package GoldMan;
//Climbing Stairs
public class Q70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q70 q = new Q70();
		System.out.println(q.climbStairs(10));
	}

	public int climbStairs(int n) {
		int[] memo = new int[n + 1];
		return climbStairs(n, memo);
	}
	public int climbStairs(int n, int[] memo) {
		if(n < 0){
			return 0;
		} else if(n == 0){
			return 1;
		}
		if(memo[n] > 0){
			return memo[n];
		}
		memo[n] = climbStairs(n-1,memo) + climbStairs(n-2, memo);
		return memo[n];
	}
	
//	public int climbStairs(int n) {
//		int[] memo = new int[n + 1];
//		return climbStairs(n, memo);
//	}
//	public int climbStairs(int n, int[] memo) {
//		if(memo[n] == 0){
//			if(n == 1)	return 1;
//			if(n == 0)	return 1;
//			memo[n] = climbStairs(n-1,memo) + climbStairs(n-2,memo);
//		}
//		return memo[n];
//	}
}
