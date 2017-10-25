package GoldMan;

import java.util.HashMap;
import java.util.Map;

public class kSumPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1};
		System.out.println(getKSum(nums, 2));
	}

	public static int getKSum(int[] num, int k){
		int count = 0;
		if(num == null || num.length == 0){
			return count;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < num.length; i++){
			if(map.containsKey(k - num[i])){
				count += map.get(k - num[i]);
			}
			map.put(num[i], map.getOrDefault(num[i], 0) + 1);
		}
		return count;
	}

//public static int getKSum(int[] num, int k){
//    int count = 0;
//    if(num == null || num.length == 0) return count;
//    Map<Integer, Integer> map = new HashMap<>();
//    //key is num's value, value is num's value在数组中出现的次数;只有在k-num[i]存在于map以及出现次数==1，才统计pair的个数
//    for(int i = 0; i < num.length; i++){
//        if(map.containsKey(k-num[i])){
//            map.put(k-num[i],map.get(k-num[i])+1);
//            if(map.get(k-num[i]) == 1 ){
//                count++;
//            }
//        }else map.put(num[i],0);
//    }
//   return count;
//}
//public static int getKSumII(int[] num, int k){
//    int count = 0;
//    if(num == null || num.length == 0) return count;
//    Map<Integer, Integer> map = new HashMap<>();
//    //key:nums[i], value: times of appearance
//    for(int n: num){
//        map.put(n,map.getOrDefault(n,0)+1);
//    }
//    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//        int key = entry.getKey();
//        int val = entry.getValue();
//        if(k - key == key) {
//            count+= val * (val-1); //组合的概念n个中挑2个
//        }
//        else{
//            if(map.containsKey(k - key)){
//                count += val * map.get(k - key);
//            }
//        }
//    }
//    return count/2;
//}
}
