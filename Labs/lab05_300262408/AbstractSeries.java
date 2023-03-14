public abstract class AbstractSeries implements Series {

    public double[] take(int k) {
		double [] partialSum;
		partialSum = new double[k];
		for (int i = 0; i<k; i++){
			partialSum[i] = next();
		}
        // implement the method
        return partialSum;
    }

}