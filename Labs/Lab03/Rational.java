public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this(numerator, 1);
    }

    public Rational(int numerator, int denominator) {
	     this.numerator = numerator;
		 this.denominator = denominator;
		 reduce();
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
	     int common = denominator * other.denominator;
		 int numerator1 = numerator * other.denominator;
		 int numerator2 = other.numerator * denominator;
		 int sum = numerator1 + numerator2;
		 return new Rational(sum, common);
    }

    public static Rational plus(Rational a, Rational b) {
    	return a.plus(b);
    }

    // Transforms this number into its reduced form

    private void reduce() {
      int x = gcd(numerator, denominator);
	  numerator = numerator/x;
	  denominator = denominator/x;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
 
	  if (a < 0 || b < 0 ){
		  if (a < 0 && b < 0){
			a = a*-1; 
			b = b*-1;  
		  }
		  if (a<0){
			a = a*-1; 
		  }
		  if (b<0){
			b = b*-1;  
		  }
	  }
	
		while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }

    public int compareTo(Rational other) {
      int numerator1 = numerator * other.denominator;
	  int numerator2 = other.numerator * denominator;
	  return numerator1 - numerator2;
    }

    public boolean equals(Rational other) {

		if (other.numerator < 0 && other.denominator < 0){
			other.numerator = Math.abs(other.numerator);
			other.denominator = Math.abs(other.denominator);
		}
		other.reduce();
		if (numerator == other.numerator && denominator == other.denominator){
			return true; 
		}
		else{
			return false;
			
		}
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    result = Integer.toString(numerator);
    	} else {
    	    result = numerator + "/" + denominator;
    	}
    	return result;
    }

}