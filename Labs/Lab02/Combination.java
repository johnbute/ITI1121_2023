public class Combination {
	public static void main (String args[]){
		Combination c1, c2, c3;
		c1 = new Combination(1, 2, 3);
		c2 = new Combination(1, 2, 3);
		c3 = new Combination(3, 2, 1);


	}
	public int a, b, c;
    public Combination( int first, int second, int third ) {
		a = first;
		b = second;
		c = third;

    }

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals( Combination other ) {
		if (other == null) {
			return false;
		}	
		
       else if (this.a == other.a && this.b == other.b && this.c == other.c){
			return true;
		}
		else {
			return false;
		}
    }

    // Returns a String representation of this Combination.

    public String toString() {
		
		return this.a+":"+this.b+":"+this.c;
    }

}