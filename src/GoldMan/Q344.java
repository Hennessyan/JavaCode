package GoldMan;

//Reverse String
public class Q344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello world";
		Q344 q = new Q344();
		System.out.println(q.reverseString(s));
	}

	public String reverseString(String s) {
		char[] c = s.toCharArray();
		int i = 0, j = c.length - 1;
        char temp = ' ';
        while(i < j){
        	temp = c[i];
        	c[i] = c[j];
        	c[j] = temp; 
        	i++;
        	j--;
        }
		return String.valueOf(c);
	}
	
}
