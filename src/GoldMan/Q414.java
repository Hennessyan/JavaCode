package GoldMan;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//Third Maximum Number
//Same part: Q41(H)
//Next challenge: Q215(M)
public class Q414 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q414 q = new Q414();
		int[] nums = {2, 2, 3, 1, 5, 4};
		System.out.println(q.thirdMax(nums));	//return 1
	}
	/*method1*/
	//TC & SC: O(nlgn)
//	public int thirdMax(int[] nums) {
//        Arrays.sort(nums);
//        int count = 1;
//        for(int i = nums.length - 1; i >= 0; i--){
//        	if(count == 3)
//        		return nums[i];
//        	if(i >= 1){
//        		if(nums[i] == nums[i-1])
//        			continue;
//        		else
//        			count++;
//        	}
//        }
//        return nums[nums.length - 1];
//    }
	/*method2*/
//	public int thirdMax(int[] nums) {
//		PriorityQueue<Integer> queue = new PriorityQueue<>();
//		Set<Integer> set = new HashSet<>();
//		
//		for(int n : nums){
//			if(set.add(n)){
//				queue.offer(n);
//				if(queue.size() > 3)
//					queue.poll();
//			}
//		}
//		if(queue.size() == 2)
//			queue.poll();
//		return queue.peek();
//		
//	}
	/*method3*/
	//TC : O(n)
	//SC : O(1)
//	public int thirdMax(int[] nums) {
//		Integer max1 = null, max2 = null, max3 = null;
//		for(Integer n : nums){		//注意这里是Integer
//			if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
//			if(max1 == null || n > max1){
//				max3 = max2;
//				max2 = max1;
//				max1 = n;
//			} else if(max2 == null || n > max2){
//				max3 = max2;
//				max2 = n;
//			} else if(max3 == null || n > max3){
//				max3 = n;
//			}
//		}
//		return max3 == null ? max1 : max3;
//	}
	/*method4*/
	public int thirdMax(int[] nums) {
        int max, mid, small, count;
        max = mid = small = Integer.MIN_VALUE;
        count = 0;  //Count how many top elements have been found.

        for( int x: nums) {
            //Skip loop if max or mid elements are duplicate. The purpose is for avoiding right shift.
            if( x == max || x == mid ) {
                continue;
            }
            if (x > max) {
                //right shift
                small = mid;
                mid = max;
                max = x;
                count++;
            } else if( x > mid) {
                //right shift
                small = mid;
                mid = x;
                count++;
            } else if ( x >= small) { //if small duplicated, that's find, there's no shift and need to increase count.
                small = x;
                count++;
            }
        }

        //"count" is used for checking whether found top 3 maximum elements.
        if( count >= 3) { 
            return small;
        } else {
            return max;
        }
    }
}
