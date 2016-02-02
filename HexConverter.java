
import java.math.BigInteger;
import java.lang.*;
import javax.xml.bind.DatatypeConverter;

/*
 * HexConverter converts other numeric types to hex and vice versa.
 * Bytes, base 64, string.
 */
public class HexConverter {
	

	//constructor
	public HexConverter(){
	
	}
	
    /**
     * Changes hexadecimal to base 64
     *
     * @param hex the hexadecimal value to convert
     * @return the base64 value
     */
	public String HexToBase64(String hex){
		
		byte[] byteArray=DatatypeConverter.parseHexBinary(hex);
		String base64String=DatatypeConverter.printBase64Binary(byteArray);
		
		return base64String;
	}

    /**
     * Converts strings (in ascii) to hexadecimal
     * 
     * @param message the string to convert
     * @return the hexadecimal string
     */
	public String StringToHex(String message){
		try {	      
			 return String.format("%x", new BigInteger(
                message.getBytes("US-ASCII")));
		    }
		    catch(Exception e) {
		       System.out.print(e.toString());
		       return message;
		    }
		  }

    /**
     * Another way to converter string to hexadecimal
     *
     * @param message the string to convert
     * @return the hexadecimal string of the message
     */
	public String StringToHex2(String message){

		    return String.format("%x", new BigInteger(message.getBytes()));    
	}

    /**
     * Converts hexadecimal values to a byte array
     * Used for bitwise operation
     *
     * @param hex the hexadecimal value to change
     * @return the byte array
     */
	public byte[] HexToByteArray(String hex){
		
		byte[] byteArray=DatatypeConverter.parseHexBinary(hex);	
		return byteArray;
		
	}

    /**
     * Converts hexadecimal values to string values
     *
     * @param hexa the hexadecimal value to change
     * @return the string 
     */
	public String hexToString(String hexa){
		  StringBuilder sb = new StringBuilder();
		  StringBuilder temp = new StringBuilder();
	 
		  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
		  for( int i=0; i<hexa.length()-1; i+=2 ){
	 
		      //grab the hex in pairs
		      String output = hexa.substring(i, (i + 2));
		      //convert hex to decimal
		      int decimal = Integer.parseInt(output, 16);
		      //convert the decimal to character
		      sb.append((char)decimal);
		      
		      temp.append(decimal);
		  }
	 
		  return sb.toString();
	}
	
}
