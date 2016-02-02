import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
public class IsEnglish {
	public IsEnglish(){
		
	}
	public boolean isValid(String text){
		String[] charList= text.split("");
		
		for(String characters : charList) {
			if(characters.matches("\\d")){
                return false;
			}
		}
		
		return true;
	}
	public double scoreThatString(String text){
		double score=0;
		HashMap<String,Double> charScore=new HashMap<>();
		charScore.put("a", 8.167);charScore.put("b", 1.492);
        charScore.put("c", 2.782);charScore.put("d", 4.253);
        charScore.put("e", 12.702);charScore.put("f", 2.228);
        charScore.put("g", 2.015);charScore.put("h", 6.094);
        charScore.put("i",6.966);charScore.put("j", 0.153);
        charScore.put("k",0.772);charScore.put("l", 4.025);
        charScore.put("m", 2.406);charScore.put("n", 6.749);
        charScore.put("o", 7.507);charScore.put("p",1.929 );
        charScore.put("q", 0.095);charScore.put("r", 5.987);
        charScore.put("s", 6.327);charScore.put("t", 9.056);
		charScore.put("u", 2.758);charScore.put("v", 0.978);
        charScore.put("w", 2.360);charScore.put("x", 0.150);
        charScore.put("y", 1.974);charScore.put("z", 0.074);
        charScore.put("A", 8.167);charScore.put("B", 1.492);
        charScore.put("C", 2.782);charScore.put("D", 4.253);
		charScore.put("E", 12.702);charScore.put("Z", 0.074);
        charScore.put(" ",(double) 5);charScore.put("F", 2.228);
        charScore.put("G", 2.015);charScore.put("H", 6.094);
        charScore.put("I",6.966);charScore.put("J", 0.153);
		charScore.put("K",0.772);charScore.put("L", 4.025);
        charScore.put("M", 2.406);charScore.put("N", 6.749);
        charScore.put("O", 7.507);charScore.put("P",1.929 );
        charScore.put("Q", 0.095);charScore.put("R", 5.987);
        charScore.put("S", 6.327);charScore.put("T", 9.056);
		charScore.put("U", 2.758);charScore.put("V", 0.978);
        charScore.put("W", 2.360);charScore.put("X", 0.150);
        charScore.put("Y", 1.974);
		
		String[] charList= text.split("");
		try{
		for(String characters : charList){
			score+=charScore.get(characters);
		}
		
		}
		catch(NullPointerException e){
			
		}

		return score/charList.length;
		
	}
}
