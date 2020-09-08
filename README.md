# PROJECTS
This repository contains various projects that i did  as a part of course-work or my own interest.

### 1. ENCRYPT TEXT EDITOR
A fun project, with a very simple idea i.e. encrypt text. After typing, there will two options to save a file, first one is to save it in simple text format or save it so only you can read it. The latter one uses a user given password to encrypt text. Before encryption hash of text is calculated that is append to header and footer with some flags. Hash is used to verify if file was modified, and flags are to know that file is saved securely. This project was developed in Java using Netbeans IDE
#### MORE DETAILS : 
A Key is entered by user then it converted into 4 keys. These 4 keys are used in encryption. "KeyGenerator" class is used to create keys. To encrypt first all text is read character by character and xored with keys. "Encryption and Decryption" class is used. There is a round 2 to encrypt text. In round 2 AES algorithm is used. There is a predefined function in JAVA to do so. After that encrypted text is saved in a file with extension '.vc'. Headers and Footers are used to recognize an encrypted file. Encrypted text file is read only. If file is modified then it can not be decrypted.
#### NOTE:
Above project contains .jar file which should run in your machine having java installed. Further you can run the code through command prompt/terminal. The main package name is "texteditor" and main class is "TextEditor"

### 2. Classification with TRANSFER LEARNING USING KERAS
A project where i got decent accuracy in very few epochs using transfer learning. I have extended the idea of coursera guided project **Classification with Transfer Learning in Keras** to implement the same classification model using relatively less amount of data-set, using famous inception network. I have done image augmentation and drop backs to manage high accuracy with regularization effect. The link of course certificate is given below:


**Certificate** : https://www.coursera.org/account/accomplishments/certificate/L82ZX2WT8R6X
