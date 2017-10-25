package HuaWei;

import java.util.Arrays;

//华为面试题(8分钟写出代码)
//有两个数组a,b, 大小都是n, 数组元素的值任意,无序. 
//要求:通过交换a,b中的元素,使数组a的和与数组b的和之间的差最小

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q1 q = new Q1();
		int[] a = {2,5,4,3,1,0};
        int[] b = {7,9,8,10,6,11};
        q.exchange(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
	}
	
	//newDiff=diff-2*singlediff
//	private void exchange(int[] a, int[] b){
//		int diff = 0;
//		for(int i = 0; i < a.length; i++)
//			diff += a[i] - b[i];
//		
//		for(int i = 0; i < a.length; i++){
//			for(int j = 0; j < a.length; j++){
//				int singleDiff = a[i] - b[j];
//				if(Math.abs(diff) > Math.abs(diff - 2*singleDiff)){
//					int temp = a[i];
//					a[i] = b[j];
//					b[j] = temp;
//					diff = diff - 2*singleDiff;
//				}				
//			}
//		}
//	}
	/*http://blog.csdn.net/qq_15720911/article/details/77860012*/
	//判断是否需要交换的条件可以直接用上方法的Math.abs来比较新旧diff的大小,
	//也可以通过给a,b两个值取不同大小,不同正负的所有情况比较,得到结论：
	//（a/b)(a-b) > 0 => a(a-b) > 0 
	// a/b 或者 b/a都可以,只是为了说明符号相同.
	private void exchange(int[] a,int[] b){
        int n = a.length;
        int diff = 0;
        for(int i = 0;i < n;i++){
            diff += a[i] - b[i];//计算两组数的差
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int tp = a[i] - b[j];//计算两组数中单个元素的差值
                int t = tp - diff;//单个元素差值和数组的差值比较
                if(t*tp < 0){    //以此条件判断是否需要交换
                    int ex = a[i];
                    a[i] = b[j];
                    b[j] = ex;
                    diff -= 2*tp;//计算数据交换后两个数组的差值
                }
            }
        }
	}
}
