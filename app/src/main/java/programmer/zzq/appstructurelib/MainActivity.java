package programmer.zzq.appstructurelib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import programmer.zzq.appstructure.tools.MD5Tool;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "朱志强";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, MD5Tool.encrypt("我爱你".getBytes(), false, 16).equals("b934d55bd7120e5d") + "");

        Log.d(TAG, MD5Tool.encrypt("我爱你".getBytes(), true, 16).equals("B934D55BD7120E5D") + "");
        Log.d(TAG, MD5Tool.encrypt("我爱你".getBytes(), false, 32).equals("4f2016c6b934d55bd7120e5d0e62cce3") + "");
        Log.d(TAG, MD5Tool.encrypt("我爱你".getBytes(), true, 32).equals("4F2016C6B934D55BD7120E5D0E62CCE3") + "");
        Log.d(TAG, MD5Tool.encrypt("我爱你".getBytes()).equals("4f2016c6b934d55bd7120e5d0e62cce3") + "");
        MD5Tool.shutdown();
    }


}
