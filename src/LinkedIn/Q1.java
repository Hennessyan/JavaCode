package LinkedIn;

import java.util.Arrays;

//Strings Homomorphism
//LintCode Q638
public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q1 q = new Q1();
		String s = "paper", t = "title";
		String s1 = "foo", t1 = "bar";
		System.out.println(q.isIsomorphic(s, t));	//return true
		System.out.println(q.isIsomorphic(s1, t1));	//return false
	}
	//注意：我们需要从左往右扫一遍,再从右往左反过来扫一遍
	//因为有这种情况: s = bar f = foo (只从左往右扫一次无法识别错误)
	public boolean isIsomorphic(String s, String t) {
        // write your code here
		int[] map = new int[256];	//ASCII的范围是0～255
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		
		for(int i = 0; i < s.length(); i++){
			if(map[sc[i]] == 0){
				map[sc[i]] = tc[i];
			} else {
				if(map[sc[i]] != tc[i]){
					return false;
				}
			}
		}
		
		//反着再来一遍
		int[] map1 = new int[256];
		for(int i = 0; i < t.length(); i++){
			if(map1[tc[i]] == 0){
				map1[tc[i]] = sc[i];
			} else {
				if(map1[tc[i]] != sc[i]){
					return false;
				}
			}
		}
		return true;
    }

}
