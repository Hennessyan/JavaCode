package GoldMan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Combination Sum II
public class Q40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q40 q = new Q40();
		
		int[] nums = {10, 1, 2, 7, 6, 1, 5};
		
		List<List<Integer>> res = q.combinationSum2(nums, 8);
		for(List<Integer> list : res){
			for(int i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(candidates == null || candidates.length == 0){
			return res;
		}
		Arrays.sort(candidates);
		backTracking(candidates, 0, target, new ArrayList<>(), res);
		return res;
	}
	private void backTracking(int [] nums, int start, int target, List<Integer> list, List<List<Integer>> res){
		if(target < 0){
			return;
		} else if(target == 0){
			res.add(new ArrayList<>(list));
		} else {
			for(int i = start; i < nums.length; i++){
				if(i > start && nums[i] ==  nums[i - 1]){				//skip duplicates
					continue;
				}
				list.add(nums[i]);
				backTracking(nums, i + 1, target - nums[i], list, res);
				list.remove(list.size() - 1);
			}
		}
	}

}
