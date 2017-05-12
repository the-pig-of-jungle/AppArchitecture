package programmer.zzq.appstructure.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.orhanobut.logger.Logger;

import programmer.zzq.appstructure.mvp.view.activity.SimpleBaseActivity;
import programmer.zzq.appstructure.utils.Utils;


/**
 * Created by 朱志强 on 2017/5/10.
 */

public class NetworkMonitorReceiver extends BroadcastReceiver {

    public static NetworkMonitorReceiver sReceiver;
    public static IntentFilter sIntentFilter;

    @Override
    public void onReceive(Context context, Intent intent) {
        Logger.d("收到广播");
        ((SimpleBaseActivity) context).receiveNetworkChangeBroadcast(Utils.NetworkUtils.isNetworkConnected());
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
    }
}
