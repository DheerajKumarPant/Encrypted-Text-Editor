/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 *
 * @author Dheeraj Kumar Pant
 */
public class Round2Encryption {
    private static final String ALGORITHM = "AES";
    private static byte[] key;
    
    public Round2Encryption(String password)
    {
        key = getKey(password);
    }

    private byte[] getKey(String password) 
    {
        int len = password.length();
        for (int i = len; i < 16; i++)
        {
            password+= 's';
        }
        
        return password.getBytes();
    }
    
    private static Key generateKey() throws Exception
    {
        Key key2 = new SecretKeySpec(key, ALGORITHM);
        return key2;
    }
    
    public String encryptAES(String str) throws Exception
    {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc_data = cipher.doFinal(str.getBytes());
		Base64.Encoder base64Encoder = Base64.getEncoder().withoutPadding();
        String encrypted_text = base64Encoder.encodeToString(enc_data);
        return encrypted_text;
    }
    
    public String decryptAES(String str) throws Exception
    {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded_text = Base64.getDecoder().decode(str);
        byte[] final_text = cipher.doFinal(decoded_text);
        String decrypted_text = new String(final_text);
        return decrypted_text;
    }
}
