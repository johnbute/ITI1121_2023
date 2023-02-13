public class DoorLock {
	public static void main (String args[]){
		Combination c1 = new Combination(1, 2, 3);
		DoorLock lock = new DoorLock(c1);
		Combination c2 = new Combination(3, 2, 1);
		boolean x = lock.open(c2);
		System.out.print(x);
		boolean y = lock.open(c2);
		System.out.print(y);
		boolean z = lock.open(c2);
		lock.activate(c1);
		System.out.print(z);

		System.out.println(numberOfAttempts);
		boolean w = lock.isActivated();
		System.out.println(w);
	}
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;
    private Combination combination;
    private boolean open;
    private boolean activated;
    private static int numberOfAttempts;
    public DoorLock( Combination combination ) {
		this.combination = combination;
		numberOfAttempts = 0;
		activated = true;
		open = false;
    }
    public boolean isOpen() {
        return open;
    }
    public boolean isActivated() {
        return activated;
    }
    public boolean open( Combination combination ) {
		if (activated && !open && this.combination.equals(combination)){
			numberOfAttempts = 0;
			open = true;
		}
		else {
			numberOfAttempts++;
			if (numberOfAttempts == MAX_NUMBER_OF_ATTEMPTS){
				activated = false;
				numberOfAttempts = 0;
			}
		}
		return activated && open;
	}
    public void activate( Combination c ) {
		if (c.equals(combination)){
			activated = true;
		}
    }
}