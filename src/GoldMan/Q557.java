package GoldMan;
// Reverse Words in a String III
//Same part:541 344
public class Q557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Let's take LeetCode contest";
		Q557 q = new Q557();
		System.out.println(q.reverseWords(s));
	}
	
//	public String reverseWords(String s) {
//        String[] temp = s.split(" ");
//        String res = "";
//        for(int i = 0; i < temp.length - 1; i++){
//        	res += reverse(temp[i]) + " ";
//        }
//        res += reverse(temp[temp.length-1]);
//        return res;
//    }
//	public String reverse(String s){
//		char[] c = s.toCharArray();
//		int i = 0, j = c.length - 1;
//		while(i<j){
//			char temp = c[i];
//			c[i] = c[j];
//			c[j] = temp;
//			i++;
//			j--;
//		}
//		return String.valueOf(c);
//	}
	
	public String reverseWords(String s) 
	{
	    char[] s1 = s.toCharArray();
	    int i = 0;
	    for(int j = 0; j < s1.length; j++)
	    {
	        if(s1[j] == ' ')
	        {
	            reverse(s1, i, j - 1);
	            i = j + 1;
	        }
	    }
	    reverse(s1, i, s1.length - 1);		//注意这个！！！是最后一部分的reverse
	    return new String(s1);
	}

	public void reverse(char[] s, int l, int r)
	{
		while(l < r)
		{
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			l++; r--;
		}
	}
}
