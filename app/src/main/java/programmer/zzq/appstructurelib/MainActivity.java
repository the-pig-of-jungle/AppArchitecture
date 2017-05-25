package programmer.zzq.appstructurelib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "朱志强";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            Log.d(TAG, Arrays.toString(md5.digest("我爱你".getBytes())));
            Log.d(TAG,toHexString(md5.digest("我爱你".getBytes())));
            Log.d(TAG,toHexString(md5.digest("我爱你".getBytes())).equals("4f2016c6b934d55bd7120e5d0e62cce3") + "");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public static String toHexString(byte[] bytes){
        StringBuilder sb = new StringBuilder(bytes.length);
        for (int index = 0;index < bytes.length;index++){
            if ((bytes[index] + 256) % 256 < 0x10){
                sb.append("0");
            }
            sb.append(Integer.toHexString(bytes[index] < 0 ? 256 + bytes[index] : bytes[index]));
        }
        return sb.toString();
    }

}
