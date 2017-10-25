package WangYi;

import java.util.Arrays;

//http://blog.csdn.net/lezg_bkbj/article/details/51132908
//比较重量

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q1 q = new Q1();
		int[][] records = new int[][]{{1,2},{2,4},{1,3},{4,3}};
		System.out.println(q.cmp(2, 3, records, 4));
	}
	
	public int cmp(int g1, int g2, int[][] records, int n) {
		int N = getMaxWeight(records, n) + 1;
		int[][] map = new int[N][N];
		initMap(map, records, n);
		boolean[] isVisited = new boolean[N];
		if(dfs(map, g1, g2, isVisited)){
			return 1;
		} 
		Arrays.fill(isVisited, false);
		if(dfs(map, g2, g1, isVisited)){
			return -1;
		}
		return 0;
	}
	private boolean dfs(int[][] map, int g1, int g2, boolean[] isVisited){
		isVisited[g1] = true;
		if(map[g1][g2] == 1){
			return true;
		}
		
		for(int i = 0; i < map.length; i++){
			if(map[g1][i] == 1 && !isVisited[i]){
				isVisited[i] = true;
				if(dfs(map, i, g2, isVisited)){
					return true;
				}
			}
		}
		return false;
	}
	private int getMaxWeight(int[][] records, int n) {
		int max = 0;
		for(int i = 0; i < n; i++){
			int a = records[i][0];
			int b = records[i][1];
			max = Math.max(max, a);
			max = Math.max(max, b);
		}
		return max;
	}
	private void initMap(int[][] map, int[][] records, int n){
		for (int i = 0; i < n; i++) {
            map[records[i][0]][records[i][1]] = 1;
        }
	}

}
