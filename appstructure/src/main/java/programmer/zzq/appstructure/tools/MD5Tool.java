package programmer.zzq.appstructure.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import programmer.zzq.appstructure.utils.Utils;

/**
 * Created by 朱志强 on 2017/5/25.
 */

public class MD5Tool {

    public static final int RESULT_16 = 16;
    public static final int RESULT_32 = 32;

    private static MessageDigest sMD5;

    public static String encrypt(byte[] content,boolean uppercase,int resultNum){

        if (sMD5 == null){
            try {
                sMD5 = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        byte[] resultBytes = sMD5.digest(content);
        String resultStr = Utils.CastUtil.toHexString(resultBytes,uppercase);
        return resultNum == RESULT_16 ? resultStr.substring(8,24) : resultStr;
    }
    
    
    public static void shutdown(){
        sMD5 = null;
    }

    public static String encrypt(byte[] content){
        return encrypt(content,false,32);
    }
}
