public class test {
	
	public static String s = "hey";
	public static void changeString(String s) {
	s = "hi";
	}
	public static void main (String[] args) {
	String s = "hello";
	changeString(s);
	//System.out.println(s);
	}
}