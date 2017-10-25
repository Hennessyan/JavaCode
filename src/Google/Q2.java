package Google;

import java.util.HashMap;
import java.util.Map;

//
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q2  q = new Q2();
		String[] dict = {"like", "god", "internal", "me", "internet", "interval", "intension",
				"face", "intrusion"};
		String[] ans = q.wordsAbbreviation(dict);
		for(String s : ans)
			System.out.println(s);
	}
	public String[] wordsAbbreviation(String[] dict){
		int len = dict.length;
		Map<String, Integer> map = new HashMap<>();
		String[] ans = new String[len];
		int[] prefix = new int[len];
		
		for(int i = 0; i < len; i++){
			prefix[i] = 1;
			ans[i] = getAbbr(dict[i], prefix[i]);
			if(!map.containsKey(ans[i])){
				map.put(ans[i], 0);
			}
			map.put(ans[i], map.get(ans[i]) + 1);
		}

		while(true){
			boolean unique = true;
			for(int i = 0; i < len; i++){
				if(map.get(ans[i]) > 1){
					unique = false;
					prefix[i]++;
					ans[i] = getAbbr(dict[i], prefix[i]);
					if(!map.containsKey(ans[i])){
						map.put(ans[i], 0);
					}
					map.put(ans[i], map.get(ans[i]) + 1);
				}
			}
			if(unique){
				break;
			}
		}
		return ans;
	}
	
	private String getAbbr(String s, int p){
		if(p >= s.length() - 2){
			return s;
		}
		String ans;
		ans = s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
		return ans;
	}
}
