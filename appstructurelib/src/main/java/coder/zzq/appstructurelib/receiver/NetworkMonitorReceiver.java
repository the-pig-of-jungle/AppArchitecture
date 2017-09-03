package coder.zzq.appstructurelib.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import coder.zzq.appstructurelib.mvp.view.activity.SimpleBaseActivity;
import coder.zzq.appstructurelib.utils.Utils;


/**
 * Created by 朱志强 on 2017/5/10.
 */

public class NetworkMonitorReceiver extends BroadcastReceiver {


    private static Boolean sNetConnected;

    private static NetworkMonitorReceiver sReceiver;
    private static IntentFilter sIntentFilter;


    @Override
    public void onReceive(Context context, Intent intent) {
        if (sNetConnected == null){
            sNetConnected = Utils.NetworkUtils.isNetworkConnected();
            return;
        }

        if (!sNetConnected.equals(Utils.NetworkUtils.isNetworkConnected())){
            sNetConnected = !sNetConnected;
            ((SimpleBaseActivity) context).onNetworkChanged(sNetConnected);
        }
    }

    public static void registerNetworkMonitor(Context context){

        if (sReceiver == null){
            sReceiver = new NetworkMonitorReceiver();
            sIntentFilter = new IntentFilter();
            sIntentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        }

        context.registerReceiver(sReceiver,sIntentFilter);
    }

    public static void unregisterNetworkMonitor(Context context){
        context.unregisterReceiver(sReceiver);
        sNetConnected = null;
    }
}
