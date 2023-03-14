public class Test {
	public static void display(int a){
		System.out.println( "a = " + a);
	}
	
	public static void main( String[] args){
		int a;
		a = 9;
		if (a < 10) 
			a = a + 1;
		display( a );
	}
	
}