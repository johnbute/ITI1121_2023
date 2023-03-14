public class Arithmetic extends AbstractSeries {

    private double sum = 0.0;
	private double j = 1.0;
    public double next() {
		sum = sum +j;
		j++;
		return sum;
        // implement the method
        
    }
}