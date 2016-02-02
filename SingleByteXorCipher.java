import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import javax.xml.bind.DatatypeConverter;

/* Class illustrates two methods to break a repeated hex. Although both 
 * utilize the same brute force method, the final check to determine which
 * string is correct uses keywords or character frequency. Also includes 
 * method for encoding a message into hexademical.
 */
public class SingleByteXorCipher {

    public SingleByteXorCipher(){

    }

    /**
     * Uses keyword to determine which string is correct
     * 
     * @param hex the encrypted hexadecimal value
     * @return the decrypted message 
     */
    public String[] BreakerKeyWord(String hex){
        HexConverter converter = new HexConverter();
        int key=0;
        String decrypt="";
        byte[] byteArray = converter.HexToByteArray(hex);

        //keywords used to check for correct string
        String keyWords[]= new String[]{"the", "be", "to", "of", "and", "a",
            "in", "is", "that", "have", "I", "it", "for", "not", "on", "with",
            "he", "as", "my", "you", "do", "at", "this", "but", "his", "by",
            "from", "they", "we", "say", "her", "she", "or", "an", "will",
            "my", "one", "all", "would", "there", "their", "what", "so",
            "up", "out", "if", "about", "who", "get", "which", "go", "me",
            "when", "make", "can", "like", "time", "no", "just",
            "him", "know", "take", "people", "into", "year", "your",
            "good", "some", "could", "them", "see", "other", "than",
            "then", "now", "look", "only", "come", "its", "over",
            "think", "also", "back", "after", "use", "two", "how",
            "our", "work", "first", "well", "way", "even", "new",
            "want", "because", "any", "these", "give", "day", "most",
            "us"};

outerloop:
        //iterates through the keys in byte value
        for (key=0X20;key<0X7A;key++){
            //checks if current decoded string contains keywords
            for (String word : keyWords){

                if(decrypt.indexOf(" "+word)>-1 || decrypt.indexOf(word +
                            " ")>-1){
                    key--;
                    break outerloop;
                            }
            }
            //
            byte[] testByteArray= byteArray;
            for(int i=0; i<byteArray.length;i++){		

                testByteArray[i]=(byte) (byteArray[i]^(byte)(key));
            }
            decrypt=converter.hexToString(
                    DatatypeConverter.printHexBinary(testByteArray));
            //decodes byteArray using certain key

        }

        String answer[]=new String[] {decrypt, Integer.toString(key)};
        return answer;
    }

    /**
     * Uses character frequency to determine which string is correct.
     *
     * @param hex the hex value to be decrypted
     * @return the decrypted string
     */
    public String[] BreakerFrequency(String hex){
        HexConverter converter = new HexConverter();
        IsEnglish scorer = new IsEnglish();
        Charset ascii = Charset.forName("US-ASCII");

        int key=0; // store answer
        String decrypt=""; // store decrypted message

        byte[] byteArray = converter.HexToByteArray(hex);
        String regx = "^[\\p{L} .'-]+$";

        outerloop:
        //iterates through the keys in byte value
        for (key=0X20;key<0x7A;key++){

            //checks if current decoded string scores with common letters
            if(decrypt.matches(regx) && scorer.isValid(decrypt) && 
                    scorer.scoreThatString(decrypt) > 1){
                key--;
                break outerloop;

            }
            byte[] testByteArray= byteArray;
            for(int i=0; i<byteArray.length;i++){

                testByteArray[i]=(byte) (byteArray[i]^(byte)(key));
            }
            decrypt=converter.hexToString(
                    DatatypeConverter.printHexBinary(testByteArray));
            //decodes byteArray using certain key

        }

        String answer[]=new String[] {decrypt, Integer.toString(key)};
        return answer;
    }


    /**
     * Converts an inputted message into a encrypted message
     * Using single byte xor encryption
     *
     * @param message the message to be encrypted
     * @param key the hex byte to xor by
     * @return the encrypted string
     */
    public String SingleByteXorMaker(int key,String message){
        HexConverter converter = new HexConverter();
        String hexedMessage=converter.StringToHex(message);
        byte[] byteArray = converter.HexToByteArray(hexedMessage);
        byte[] encryptedByteArray=byteArray;

        for (int i=0;i<byteArray.length;i++){
            encryptedByteArray[i]=(byte) (byteArray[i]^(byte)(key));
        }


        String answer=DatatypeConverter.printHexBinary(encryptedByteArray);
        return answer;

    }
}
