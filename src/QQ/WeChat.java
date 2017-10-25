package QQ;
//微信红包
public class WeChat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeChat q = new WeChat();
		int[] nums = {1,2,3,2,2};
		int[] nums1 = {1,2,3,4,5};
		System.out.println(q.find(nums, 5));	//return 2
		System.out.println(q.find(nums1, 5));	//return 0
	}

	public int find(int[] nums, int k){
		int count = 1, result = nums[0];
		for(int i = 1; i < nums.length; i++){
			if(nums[i] != result){
				count--;
			}else{
				count++;
			}
			if(count == 0){
				result = nums[i];
				count = 1;
			}
		}
//		System.out.println(result + " " + count);
		if(isResult(nums, result, k)){
			return result;
		}
		return 0;
	}
	private boolean isResult(int[] nums, int result,int k){
		int count = 0;
		for(int num : nums){
			if(result == num){
				count++;
			}
		}
		return count > k / 2;
	}
}
