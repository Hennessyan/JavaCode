package GoldMan;

public class CompressString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabbcdde";
		System.out.println(compressString(str));
	}

	public static String compressString(String str){
		if(str == null || str.length() == 0){
			return str;
		}
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == str.charAt(i - 1)){
				count++;
			} else{
				sb.append(count).append(str.charAt(i-1));
				count = 1;
			}
		}
		sb.append(count).append(str.charAt(str.length() - 1));
		return sb.toString();
	}

}
