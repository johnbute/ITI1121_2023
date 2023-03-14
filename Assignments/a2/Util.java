/**
 * COPYRIGHT MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Mehrdad Sabetzadeh 
 */

 public class IntegerUtil {

    public static Integer[] sumRows (Integer[][] matrix) {
		private static final Integer[] resultMatrix = new Integer[matrix.length];
		private static final int sum;
        if (matrix == null) {
            return null;
        }
		
		for (int i = 0; i<matrix.length; i++){
			sum = 0;
			for(int j = 0; j<matrix[i].length; j++){
				if (matrix[i][j] == null){
					sum = sum;
				}
				else{
					sum = sum + Integer.parseInt(matrix[i][j]);
				}
			}
			resultMatrix[i] = Integer.valueOf(sum);
		}
		
		return resultMatrix;
	}
}