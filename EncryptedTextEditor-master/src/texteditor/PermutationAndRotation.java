/*
 * Copyright (C) 2017 Dheeraj Kumar Pant
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package texteditor;

import java.io.*;

/**
 *
 * @author Dheeraj Kumar Pant
 */
public class PermutationAndRotation {
    private static final int[] PER = {3, 5, 0, 4, 9, 6, 8, 2, 7, 1};
    private static final int[] IN_PER = {2, 9, 7, 0, 3, 1, 5, 8, 6, 4};
    private static int[] ROTATION_MAT;
    public static int padding;
    
    /*public static void main(String[] args) throws Exception
    {
        PermutationAndRotation obj1 = new PermutationAndRotation("11008664");
        EncryptionAndDecryption obj2 = new EncryptionAndDecryption(110086);
        Round2Encryption r2 = new Round2Encryption("110086");
        FileOutputStream fr = new FileOutputStream("xx.txt");
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(obj1.makeTextReadyForEncryption(str));
        fr.write(r2.encryptAES(obj2.encryption(obj1.makeTextReadyForEncryption(str))).getBytes());
        fr.close();
        FileInputStream fw = new FileInputStream("xx.txt");
        byte[] cbuf = new byte[(int)new File("xx.txt").length()];
        fw.read(cbuf);
        fw.close();
        String s = new String(cbuf);
        s = r2.decryptAES(s);
        System.out.println(obj1.afterDecryptionProcess(obj2.decryption(s), padding));
    }*/
    
    public PermutationAndRotation(String key)
    {
        ROTATION_MAT = new int[10];
        setRotationMat(key);
    }
    
    String makeTextReadyForEncryption(String str)
    {
        String s = new String();
        int len = str.length();
        padding = 10 - len%10;
        for (int i = 0; i < 10 - len%10; i++)
        {
            str = str + 'z';
        }
        int j = 10;
        for (int i = 0; j <= str.length(); j+=10 )
        {
            
            s = s + applyPermutation(str.substring(i,j));
            i = j;
        }
        return s;
    }
    
    String afterDecryptionProcess(String str,int padd)
    {
        String s = new String();
        int j = 10;
        for (int i = 0; j <= str.length(); j+=10 )
        {
            
            s = s + applyInversePermutation(str.substring(i,j));
            i = j;
        }
        s = s.substring(0, s.length()- padd);
        return s;
    }
    
    private void setRotationMat(String key)
    {
        int len = key.length();
        for ( int i = 0; i < 10 - len%10; i++)
        {
            key = key + '0';
        }
        for (int i = 0; i < 10; i++)
        {
            ROTATION_MAT[i] = (PER[i]^IN_PER[i]^(int)key.charAt(i));            
        }
    }
    
    private String applyPermutation(String str)
    {
        
        str = rotateCharsLeft(str);
        String s = new String();
        for (int i = 0; i < 10; i++)
        {
            s = s + str.charAt(PER[i]);
        }
        
        return s;
    }
    
    private String applyInversePermutation(String str)
    {
        String s = new String();
        for (int i = 0; i < 10; i++)
        {
            s = s + str.charAt(IN_PER[i]);
        }
        s = rotateCharsRight(s);
        return s;
    }

    private String rotateCharsLeft(String str) 
    {
        String s = new String();
        for (int i = 0; i < 10; i++)
        {
            s = s + (char)(str.charAt(i)^ROTATION_MAT[i]);
        }
        return s;
    }

    private String rotateCharsRight(String str) 
    {
        String s = new String();
        for (int i = 0; i < 10; i++)
        {
            s = s + (char)(str.charAt(i)^ROTATION_MAT[i]);
        }
        
        return s;
    }
}
