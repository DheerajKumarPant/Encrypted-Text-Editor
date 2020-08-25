package texteditor;
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

/**
 *
 * version 1.0 17 Jan 2017 @author Dheeraj Kumar Pant.
 * This class is used to encrypt and decrypt the given text.
 * 
 */
public class EncryptionAndDecryption {
    
    private final long key;
    private long[] key_set;
   
    
    public EncryptionAndDecryption(long key)
    {
        
        this.key=key;
        generatekeys();        
    }

    

    private void generatekeys() {
        KeyGenerator obj1=new KeyGenerator(key); 
        key_set=obj1.getKeySet();
    }
    
    public String encryption(String str)
    {
        if(key==0)
        {
            return "#$*Error:::Key is not valid";
        }
        
        str=encryptText(str);
        
        return str;        
    }
    
    public String decryption(String str)
    {
        str = decryptText(str);
        
        return str;
    }

    private String encryptText(String str) 
    {
                String encrypted=new String();
                byte[] ecn=str.getBytes();
                int i=0,j=0;
                while(i<ecn.length)
                {
                    ecn[i]=(byte)((long)ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j++;
                while(i<ecn.length)
                {
                    ecn[i]=(byte)((long)ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j++;
                while(i<ecn.length)
                {
                    ecn[i]=(byte)((long)ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j++;
                while(i<ecn.length)
                {
                    ecn[i]=(byte)((long)ecn[i]^key_set[j]);
                    i++;
                }
                str = new String(ecn);                
                encrypted=encrypted+str;
                return encrypted;
    }
    
    String encryption(String str, int type) 
    {
                String encrypted=new String();
                char[] ecn=str.toCharArray();
                int i=0,j=0;
                while(i<ecn.length)
                {
                    ecn[i]=(char)(ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j++;
                while(i<ecn.length)
                {
                    ecn[i]=(char)((long)ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j++;
                while(i<ecn.length)
                {
                    ecn[i]=(char)((long)ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j++;
                while(i<ecn.length)
                {
                    ecn[i]=(char)((long)ecn[i]^key_set[j]);
                    i++;
                }
                str = new String(ecn);                
                encrypted=encrypted+str;
                return encrypted;
    }

    private String decryptText(String str) 
    {
        
        
        byte[] ecn=str.getBytes();
                int i=0,j=3;
                while(i<ecn.length)
                {
                    ecn[i]=(byte)((long)ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j--;
                while(i<ecn.length)
                {
                    ecn[i]=(byte)((long)ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j--;
                while(i<ecn.length)
                {
                    ecn[i]=(byte)((long)ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j--;
                while(i<ecn.length)
                {
                    ecn[i]=(byte)((long)ecn[i]^key_set[j]);
                    i++;
                }
                return new String(ecn);
    }
    
    String decryption(String str, int type) 
    {
        
        
        char[] ecn=str.toCharArray();
                int i=0,j=3;
                while(i<ecn.length)
                {
                    ecn[i]=(char)(ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j--;
                while(i<ecn.length)
                {
                    ecn[i]=(char)(ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j--;
                while(i<ecn.length)
                {
                    ecn[i]=(char)(ecn[i]^key_set[j]);
                    i++;
                }
                i=0;
                j--;
                while(i<ecn.length)
                {
                    ecn[i]=(char)(ecn[i]^key_set[j]);
                    i++;
                }
                return new String(ecn);
    }
    
}
