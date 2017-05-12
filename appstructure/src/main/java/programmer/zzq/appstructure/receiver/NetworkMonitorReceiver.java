package programmer.zzq.appstructure.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import programmer.zzq.appstructure.mvp.contract.BaseContract;
import programmer.zzq.appstructure.utils.Utils;


/**
 * Created by 朱志强 on 2017/5/10.
 */

public class NetworkMonitorReceiver extends BroadcastReceiver {

    public static NetworkMonitorReceiver sReceiver;
    public static IntentFilter sIntentFilter;
    @Override
    public void onReceive(Context context, Intent intent) {
        ((BaseContract.IBaseMvpView) context).onNetworkChanged(Utils.NetworkUtils.isNetworkConnected());
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
