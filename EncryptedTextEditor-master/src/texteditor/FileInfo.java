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
 * @author Dheeraj Kumar Pant
 */
class FileInfo {
    
    private static final String ENCRYPTION_HEADER="#$*HEADER::Encryption%%%";
    private static final String ENCRYPTION_FOOTER="~!^FOOTER::Encryption@@@";
    private String no_of_characters;
    String num_of_padding_chars;
    private static final int KEY = 1100866493;
    
    String fileInfoEncryption(String str)
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        return obj1.encryption(str);
    }
    
    String fileInfoDecryption(String str)
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        return obj1.decryption(str);
    }
    
    String getHeader()
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        return obj1.encryption(ENCRYPTION_HEADER);   
        
    }
    
    String getFooter()
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        return obj1.encryption(ENCRYPTION_FOOTER);
    }
    
    boolean checkHeader(String str)
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        String s = obj1.decryption(str);
        if (s.compareTo(ENCRYPTION_HEADER) == 0)
        {
            return true;
        }
        else
            return false;
    }
    
    boolean checkFooter(String str)
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        String s = obj1.decryption(str);
        if (s.compareTo(ENCRYPTION_FOOTER) == 0)
        {
            return true;
        }
        else
            return false;
    }
    
    void setNumOfChars(int num)
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        no_of_characters = obj1.encryption(""+num);        
    }
    
    String getEquivalentHash(String str)
    {
        int length = str.length();
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        num_of_padding_chars = obj1.encryption(""+PermutationAndRotation.padding);
        
        if (length % 10 != 0)
        {
            int war = 10 - length % 10;
            while (war > 0)
            {
                war--;
                str = str + "z";
            }
        }
        
        length = str.length();
        long hash = 0, j = 0;
        String key_val = ""+KEY;
        while(j < length)
        {
            int tmp = 0;
            for ( int i = 0; i < 10; i++)
            {
                tmp = tmp + (str.charAt((int)j)^key_val.charAt(i))*31^(10 - i);
                j++;
            }
            hash = hash*100 + tmp;
        }
        
        return obj1.encryption(""+hash);
    }
    
    String getPaddingAndChars()
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        return obj1.encryption("/@P=->")+num_of_padding_chars+obj1.encryption("/@C=->")+no_of_characters+obj1.encryption("/@E=->");
    }

    String decryptFirstLayer(String str) {
        
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        str = obj1.decryption(str);
        
        return str;
    }
    
    String removeHeaderAndFooter(String str)
    {
        StringBuilder s1 = new StringBuilder(str);
        
        s1.delete(0, 24);
        s1.delete(s1.length() - 24, s1.length());
        
        return s1.toString();
    }
    
    boolean checkModified(String str)
    {
        EncryptionAndDecryption obj1 = new EncryptionAndDecryption(KEY);
        int padding_index = str.indexOf("/@P=->");
        int chars_index = str.indexOf("/@C=->");
        int deletion = str.indexOf("/@E=->");
        long hash_val = 0;
        int no_chars = 0, no_padding = 0;
        String hash = str.substring(0, padding_index);
        
        try{
            hash_val = Long.parseLong(hash);
            no_chars = Integer.parseInt(str.substring(chars_index+6, deletion));
            no_padding = Integer.parseInt(str.substring(padding_index+6, chars_index));
        }
        catch(NumberFormatException | StringIndexOutOfBoundsException e)
        {
            System.out.println("File is Modified Unable to Open");
        }
        
        str = str.substring(deletion+6, str.length());
        
        return hash_val != Long.parseLong(obj1.decryption(getEquivalentHash(str)));
    }
    
    String getTextStringEnc(String str)
    {
        int padding_index = str.indexOf("/@P=->");
        int chars_index = str.indexOf("/@C=->");
        int deletion = str.indexOf("/@E=->");
        long hash_val = 0;
        int no_chars, no_padding = 0;
        String hash = str.substring(0, padding_index);
        try{
            hash_val = Long.parseLong(hash);
            no_chars = Integer.parseInt(str.substring(chars_index+6, deletion));
            no_padding = Integer.parseInt(str.substring(padding_index+6, chars_index));
        }
        catch(NumberFormatException | StringIndexOutOfBoundsException e)
        {
            System.out.println("File is Modified Unable to Open");
        }
        str = str.substring(deletion+6, str.length());
        num_of_padding_chars =  Integer.toString(no_padding);
        return str;
    }
}
