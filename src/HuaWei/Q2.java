package HuaWei;

import java.util.Scanner;

//有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行,
//求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7},
//0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);  
        while(in.hasNext()){  
            int n =in.nextInt();  
            System.out.println(remainingLast(n,3)); 
        }
	}
	//http://blog.csdn.net/yuxin6866/article/details/52733915
	//当需要求f[n-1]的时候,f[n-1]的值已经求得，因此我们可以直接求得当选者的编号s’ (s’=f[n-1])
	//因此只需要转换成实际的分布，使用：s = (s'+K) mod n
	private static int remainingLast(int n,int k) {
		int last = 0;  
        for(int i = 2; i <= n; i++)  
            last = (last + k) % i;  
        return last;  
	}
}
