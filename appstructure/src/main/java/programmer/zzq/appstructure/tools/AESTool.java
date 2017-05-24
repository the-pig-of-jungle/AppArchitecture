package programmer.zzq.appstructure.tools;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by 朱志强 on 2017/5/19.
 */

public class AESTool {

    private static String sAlgorithm = "AES/ECB/PKCS5Padding";
    private static KeyGenerator sKeyGenerator;


    public static void  init(String encryptMode,String paddingMode){
        sAlgorithm = "AES/" + encryptMode + "/" + paddingMode;
    }

    private AESTool(){

    }





    public static byte[] createRandomKey(){

        if (sKeyGenerator == null){
            try {
                sKeyGenerator = KeyGenerator.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return sKeyGenerator.generateKey().getEncoded();
    }



    public static String encrypt(byte[] content,byte[] key){

        byte[] encryptedData = null;
        SecretKeySpec secretKeySpec = new SecretKeySpec(key,"AES");

        try {

            Cipher cipher = Cipher.getInstance(sAlgorithm);
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
            encryptedData = cipher.doFinal(content);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        String s = Base64.encodeToString(encryptedData,Base64.DEFAULT);

        return s;
    }





    public static byte[] decrypt(String encryptedData,byte[] key){
        byte[] decryptedData = null;
        SecretKeySpec secretKeySpec = new SecretKeySpec(key,"AES");
        try {
            Cipher cipher = Cipher.getInstance(sAlgorithm);
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            decryptedData = cipher.doFinal(Base64.decode(encryptedData,Base64.DEFAULT));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return decryptedData;
    }



    public static String decryptToString(String encryptData,byte[] key){
        return new String(decrypt(encryptData,key));
    }


}
