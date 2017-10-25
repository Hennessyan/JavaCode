package GoldMan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Combination Sum
public class Q39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q39 q = new Q39();
		int[] nums = {2,3,6,7};
		List<List<Integer>> res = q.combinationSum(nums, 7);
		for(List<Integer> list : res){
			for(int i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return res;
		}
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		backTracking(nums, 0, target, list, res);
		return res;
	}
	private void backTracking(int[] nums, int index, int target, List<Integer> list, List<List<Integer>> res){
		if(target < 0){
			return;
		} else if(target == 0){
			res.add(new ArrayList<Integer>(list));
		} else{
			for(int i = index; i < nums.length; i++){
				list.add(nums[i]);
				backTracking(nums, i, target - nums[i], list, res);		// not i + 1 because we can reuse same elements
				list.remove(list.size() - 1);
			}
		}
	}

}
