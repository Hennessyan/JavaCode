package GoldMan;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

//First Unique Character in a String
//Next challenge: Q6(M) Q133(M)
public class Q387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q387 q = new Q387();
		String s = "leetcode";
		String s1 = "loveleetcode";
		System.out.println(q.firstUniqChar(s));		//return 0
		System.out.println(q.firstUniqChar(s1));	//return 2
	}
	/*method1*/
//	public int firstUniqChar(String s) {
//		if(s == null || s.length() == 0)
//			return -1;
//        Map<Character, Integer> map = new HashMap<>();
//        for(char c : s.toCharArray())
//        	map.put(c, map.getOrDefault(c, 0) + 1);
//        
//        for(int i = 0; i < s.length(); i++)
//        	if(map.get(s.charAt(i)) == 1)
//        		return i;
//        return -1;
//    }
	/*method2*/
//	public int firstUniqChar(String s) {
//		int[] freq = new int[26];
//		for(int i = 0; i < s.length(); i++)
//			freq[s.charAt(i) - 'a']++;
//		for(int i = 0; i < s.length(); i++)
//			if(freq[s.charAt(i) - 'a'] == 1)
//				return i;
//		return -1;
//	}
	/*method3*/
	//TC: O(n^2)
//	public int firstUniqChar(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
//                return i;
//            }
//        }
//        return -1;
//    }
	/*method4*/
	//method4 and method5 is one pass
//	public int firstUniqChar(String s) {
//        Map<Character, Integer> map = new LinkedHashMap<>();
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (set.contains(s.charAt(i))) {
//                map.remove(s.charAt(i));
//            } else {
//                map.put(s.charAt(i), i);
//                set.add(s.charAt(i));
//            }
//        }
//        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
//    }
	/*method5*/
	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                list.remove(map.get(c));
            }
            else{
                map.put(c, i);
                list.add(i);
            }
        }
        return list.isEmpty() ? -1 : list.get(0);      
	}
}
