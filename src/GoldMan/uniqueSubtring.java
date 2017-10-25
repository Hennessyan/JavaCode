package GoldMan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class uniqueSubtring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "caaab";
		String[] res = getUniqueSubstring(s,2);
		for(String a : res){
			System.out.println(a);
		}
	}
	
	private static String[] getUniqueSubstring(String s, int k){
		if(s == null || s.length() < k){
			return new String[]{};
		}
		Map<String, Integer> map = new HashMap<>();

		for(int i = 0; i < s.length() - k + 1; i++){
	        String tmp = s.substring(i,i+k);
	        map.put(tmp,map.getOrDefault(tmp,0)+1);
		}
		List<String> list = new ArrayList<>();

		for(int i = 0; i < s.length() - k + 1; i++){
	        String tmp = s.substring(i,i+k);
	        if(map.get(tmp) == 1){
	            list.add(tmp);
	        }
		}
		Collections.sort(list);
//		for(String a : list){
//			System.out.println(a);
//		}
		return list.toArray(new String[0]);
	}
}
