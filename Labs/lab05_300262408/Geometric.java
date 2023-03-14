public class Geometric extends AbstractSeries {
	private double sum = 0.0;
    private double j = 0.0;
    
    public double next() {
		sum = sum + 1.0/Math.pow(2.0, j);
		j++;
        return sum;

    }
}