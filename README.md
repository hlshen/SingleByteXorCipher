# Single-Byte-Xor-Cipher
Encrypts an inputted message using singe byte xor encryption. Then decrypts the message using character frequency or keywords
as a check. The Xor encryption uses a single hexadecimal byte and XOR the byte with each byte of the ascii message.

Program Description:
    IsEnglish: Using preset values of character frequency of the english alphabet, passed in strings are
                scored. The resulting score (divided by length of the string) is then used to determine whether or not
                the string is English.
    HexConverter: Contains many functions for converting between types and bases, namely hexadecimal, base64, string, and 
                  byte array.
    SingleByteXorCipher: Contains functions to encrypt and decrypt strings using the single byte xor cipher. The decryption
                  types include frequency and keyword. The frequency decipher uses IsEnglish as its scoring class, and 
                  keyword uses a premade bank of words and checks the decrypted string for matches.
    Main: Calls for user input of a message to be encrypted, and then input for decryption method. Displays info accordingly.
    
Issues:
    Keyword decryption lacks success when typing in messages without much english syntax. The phrase "eating food" will not
    decrypt correctly due to its lack of grammar and common keywords. 
    
    Frequency decryption lacks success when another decryption contains enough english letters to raise its score. Further
    checks for grammatical or logical sense is needed.
