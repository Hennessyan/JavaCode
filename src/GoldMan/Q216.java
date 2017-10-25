package GoldMan;
import java.util.ArrayList;
import java.util.List;


//Combination Sum III
public class Q216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q216 q = new Q216();
		List<List<Integer>> res = q.combinationSum3(3, 9);	//if k = 3, n = 9, return [[1,2,6], [1,3,5], [2,3,4]]
		for(List<Integer> list : res){						//if k = 3, n = 7, return [[1,2,4]]
			for(int i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		backTracking(res, new ArrayList<>(), k, n, 1);
		return res;
	}
	
	private void backTracking(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start){
		if(tempList.size() > k || remain < 0){
			return;
		} else if(tempList.size() == k && remain == 0){
			list.add(new ArrayList<>(tempList));
		} else {
			for(int i = start; i <= 9; i++){
				tempList.add(i);
				backTracking(list, tempList, k, remain - i, i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
