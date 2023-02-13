import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */
	private static final String SECTIONER = "###";

	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows;

	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;

	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Car[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow; you can do so by
		// writing your own code or alternatively completing the 
		// private calculateLotDimensions(...) that I have provided
		calculateLotDimensions(strFilename);
			
		// instantiate the lotDesign and occupancy variables!
		// WRITE YOUR CODE HERE!

		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the 
		// private populateFromFile(...) that I have provided
		populateFromFile(strFilename);
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		if (canParkAt(i,j,c) == true){
			occupancy[i][j] = c;
		}
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {
		occupancy[i][j] = null;
		return occupancy[i][j];

	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {

		
		String type1;
		String lotType;
		if (i+1 > numRows || j+1> numSpotsPerRow){
			System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ") " + "cannot be parked at (" + i + "," + j + ")");
			return false;
		}
		type1 = Util.getLabelByCarType(c.getType());
		lotType = Util.getLabelByCarType(lotDesign[i][j]);
		
		
		
		if (occupancy[i][j] == null){
			if (lotDesign[i][j] == CarType.NA) {
				System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ") " + "cannot be parked at (" + i + "," + j + ")");
				return false;
			}
			else if (type1.equals("L") && lotType.equals("L")){
				return true;
			}
			else if (type1.equals("R") && (lotType.equals("L") || lotType.equals("R"))){
				return true;
			}
			else if (type1.equals("S") && !(lotType.equals("E"))){
				return true;
			}
			else if (type1.equals("E")){
				return true;
			}
			
		}
		System.out.println("Car " + Util.getLabelByCarType(c.getType()) + "(" + c.getPlateNum() + ") " + "cannot be parked at (" + i + "," + j + ")");
		return false;

	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		int totalCapacity = 0;
		for (int i = 0; i< lotDesign.length; i++){
			for (int j = 0; j<lotDesign[i].length; j++){
				if (lotDesign[i][j]!= CarType.NA){
					totalCapacity++;
				}
			}
		}
		
		return totalCapacity; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD

	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		int totalOccupancy = 0;
		for (int i = 0; i< occupancy.length; i++){
			for (int j = 0; j<occupancy[i].length; j++){
				if (occupancy[i][j]!= null){
					totalOccupancy++;
				}
			}
		}
		return totalOccupancy; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD		
	}

	private void calculateLotDimensions(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));
		int commas = 0;
		int firstLine = 0;
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if (str.equals(SECTIONER)){
				break;
			}
			if (!str.isEmpty()){
				if (firstLine == 0){
					firstLine = 1;
					for (int i = 0; i< str.length(); i++){
						if (str.charAt(i) == ','){
							commas++;
						}
					}
					numSpotsPerRow = commas + 1;
				}
				numRows++;
			}

		}
		scanner.close();
	}


	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));
		String [] line = null;
		int rowIndex;
		int spotrowIndex;
		int rowLotNb = 0;
		lotDesign = new CarType[numRows][numSpotsPerRow];
		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!
		// while loop for reading the lot design
		
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			//skip the empty lines
			if(!str.isEmpty()){
				//jump out of the loop to occupancy when the sectioner is found 
				if (str.equals(SECTIONER)){
					break;
				}
				else{
						line = str.split(SEPARATOR);
						for (int j = 0; j<line.length; j++){
							lotDesign[rowLotNb][j] = Util.getCarTypeByLabel(line[j].trim());	
						}
					rowLotNb++;
				}
			}
		}

		// while loop for reading occupancy data
		occupancy = new Car[numRows][numSpotsPerRow];
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if (!str.isEmpty()){
				line = str.split(SEPARATOR);
				rowIndex = Integer.parseInt(line[0].trim());
				spotrowIndex = Integer.parseInt(line[1].trim());
				Car carToPark= new Car(Util.getCarTypeByLabel(line[2].trim()),line[3].trim());
				if (canParkAt(rowIndex, spotrowIndex, carToPark)){
					occupancy[rowIndex][spotrowIndex] = carToPark;
				}
			}
		}
		scanner.close();
	}

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());
			
		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

		System.out.print(lot);

	}
}