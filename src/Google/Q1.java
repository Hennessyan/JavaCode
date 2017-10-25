package Google;
//Check Word Abbreviation
public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q1 q = new Q1();
		String s = "internationalization";
		String abbr = "i12iz4n";
		System.out.println(q.validWordAbbreviation(s, abbr));	//return true
	}
	
	public boolean validWordAbbreviation(String s, String abbr){
		int i = 0, j = 0;
		char[] sc = s.toCharArray();
		char[] t = abbr.toCharArray();
		
		while(i < sc.length && j < t.length){
			if(Character.isDigit(t[j])){
				if(t[j] == '0'){
					return false;
				}
				int val = 0;
				while(j < t.length && Character.isDigit(t[j])){
					val = val * 10 + t[j] - '0';
					j++;
				}
				i += val;
			} else{
				if(sc[i++] != t[j++]){
					return false;
				}
			}
		}
		return i == sc.length && j == t.length;
	}
}
