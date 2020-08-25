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

/**
 *
 * @author Dheeraj Kumar Pant
 */
public class HelpClass {
    public static String Overview = "This is an open source application so feel free to use, distribute or modify. If you find it useful or you have suggestions ,please send your feedback.\nContact: dheerajkumarpant@outlook.com , pantd70@gmail.com";
    public static String Decrypt = "1. Click on decrypt or Open or press CTRL + D.\n2. Select Encrypted file.\n3. If file is not modified it will automatically detect that file is encrypted or not.\n4. If file is encrypted then it will ask for key that was used during encryption.\n5. Enter the key and click on decrypt.\n6. Decrypted text will appear on text area you can save it as text or encrypted file.";
    public static String why_pass = "1. Password is used to secure your text.\nThis password internally converted into 4 keys those are used to encrypt the text so that no one can read it.";
    public static String Encrypt = "1. Type your text in the text area.\n2. After complete typing press CTRL + E or goto menubar encrypt.\n3. Enter encryption password (only numbers are allowed).\n4. Maximum password length is 10.\n5. Click on encrypt button.\n6. Encryption done.\n\t Do not modify encrypted file otherwise it will not be able to recover completely.";
}   
