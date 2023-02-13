import java.util.Scanner;

public class Q6{
	public static void main(String[] args){
		double[] grades = new double[10];
		double averageCalculated, medianCalculated;
		int studentsPassed, studentsFailed;

		
		System.out.print("Please enter the grades of the 10 students: \n");
		Scanner scanDouble = new Scanner(System.in);
		for (int i = 0; i<10; i++){
			double inputedGrade = scanDouble.nextDouble();
			grades[i]= inputedGrade;
		}
		
		averageCalculated = calculateAverage(grades);
		medianCalculated = calculateMedian(grades);
		studentsPassed = calculateNumberPassed(grades);
		studentsFailed = calculateNumberFailed(grades);
		
		System.out.print("The average of the grades is: " + averageCalculated + "\n");
		System.out.print("The median of the grades is: " + medianCalculated + "\n");
		System.out.print("The number of students who passed is: " + studentsPassed + "\n");
		System.out.print("The number of students who failed is: " + studentsFailed + "\n");
		
		

	}

	public static double calculateAverage(double[] notes){
		double result;
		double sum = 0.0;
		
		for (int i = 0; i < notes.length; i++){
			sum += notes[i];
		}
		result = (double)sum/notes.length;
		return result;
	}

	public static double calculateMedian(double[] notes){
		double medianResult = 0;
		int i, j, argMin;
		double tmp;
		
		for (i = 0; i< notes.length -1; i++){
			argMin = i;
			for (j = i+1; j<notes.length; j++){
				if (notes[j]<notes[argMin]){
					argMin = j;
				}
			}
			tmp = notes[argMin];
			notes[argMin] = notes[i];
			notes[i] = tmp;
		}
		
		if (notes.length % 2 == 0){
			medianResult = (notes[(notes.length/2)-1] + notes[notes.length/2])/2;
		}
		else{
			medianResult = (notes[notes.length/2]);
		}
		return medianResult;
		
	}

	public static int calculateNumberFailed(double[] notes){
		double passingGrade = 50.0;
		int studentsFailed = 0;
		
		for (int i = 0; i< notes.length; i++){
			if (notes[i]<passingGrade){
				studentsFailed ++;
			}
		}
		return studentsFailed;
	}

	public static int calculateNumberPassed(double[] notes){
		double passingGrade = 50.0;
		int studentsPassed = 0;
		
		for (int i = 0; i< notes.length; i++){
			if (notes[i]>=passingGrade){
				studentsPassed ++;
			}
		}
		return studentsPassed;
	}

}
