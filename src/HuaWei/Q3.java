package HuaWei;
//find longest continuous numeric string
public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q3 q = new Q3();
		String s = "abcd12345ed125ss123456aa789";
		System.out.println(q.findLongest(s));
	}
	
//	public String findLongest(String s){
//		String[] arr = s.split("\\D+");
//		String result = arr[0];
//		int len = arr[0].length();
//		for(int i = 1; i < arr.length; i++){
//			if(arr[i].length() > len){
//				len = arr[i].length();
//				result = arr[i];
//			}
//		}
//		return result;
//	}
	
	public String findLongest(String s){
		int start = 0, max = 0;
		for(int i = 0; i < s.length(); i++){
			int temp = 0, count = 0;
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
				temp = i;
				while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
					count++;
					i++;
				}
				if(count > max){
					max = count;
					start = temp;
				}
			}
		}
		return s.substring(start, start + max);
	}
}
