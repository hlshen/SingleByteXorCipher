import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;
import java.util.Scanner;

/*
 * The main runs some tests using IsEnglish, HexConverter, and 
 * SingleByteXorCipher objects
 */
public class Main {
    public static void main(String args[]){

        // construct objects
        Scanner input = new Scanner(System.in);
        HexConverter converter = new HexConverter();
        SingleByteXorCipher singleCoder=new SingleByteXorCipher();
        IsEnglish scorer = new IsEnglish();

        
        //user input
        System.out.println("Please enter a string to encrypt\n");
        String message = input.nextLine();

        //encrypt using key 0x50
        String encrypted = singleCoder.SingleByteXorMaker(0x50, message);

        //display message and encryption
        System.out.printf("Message: %s, Score= %s \n", message, 
                scorer.scoreThatString(message));
        System.out.printf("Encrypted: %s\n", encrypted);

        //user chooses decrypt method
        System.out.println("Please enter decrypt method" +
                ":1 for Frequency, 0 for Keyword?");
        int method = input.nextInt();

        //Frequency
        if(method == 1){
            System.out.println("Using frequency of English letters to " +
                    "determine the correct decrypted message");
            String[] ans = singleCoder.BreakerFrequency(encrypted);
            System.out.printf("Decoded String: %s \n Key: %s \n",
                ans[0], ans[1]);
        }

        //Keywords
        else{
            System.out.println("Using common keywords in English to " +
                    "determine the correct decrypted message");
            String[] ans = singleCoder.BreakerKeyWord(encrypted);
            System.out.printf("Decoded String: %s \n Key: %s \n",
                                       ans[0], ans[1]);
        }

    }
}

