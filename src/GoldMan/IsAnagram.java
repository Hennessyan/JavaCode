package GoldMan;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("asd","sad"));
	}
	
	public static boolean isAnagram(String s, String t){
		if(s == null || t == null){
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for(char c : t.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for(char c : s.toCharArray()){
			if(map.containsKey(c)){
				if(map.get(c) - 1 < 0){
					return false;
				}
				map.put(c, map.get(c) - 1);
			} else{
				return false;
			}
		}
		for(Character key : map.keySet()){
			if(map.get(key) != 0){
				return false;
			}
		}
		return true;
		
	}

}
