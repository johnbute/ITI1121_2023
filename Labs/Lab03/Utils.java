/**
* this class represents a utility
*<p>
*Note: Utils is the base class that allows to manipulate an array of strings
* by using its method findAndReplace.
*
*
*
*@author John Bute
*/

public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     */

    public static String[] findAndReplace( String[] in, String[] what, String[] with ) {

        String[] out = null; // The new array to be returned
	    boolean valid = true; // True if the pre-conditions are satistified
		int i;
      	// Testing pre-conditions
		/**
		*Block of conditions which returns null whether one of the following
		*preconditions of the method FindAndReplace are violated
		*/
      	if ( in == null || what == null || with == null ) {
      	    valid = false; // the formal parameters of findAndReplace cannot be null
      	} else {
			if (what.length != with.length){
				valid = false; // @param what and @param with must be of same length
			}
			else {
				for (i =0; i<in.length; i++){
					if (in[i]== null){
						valid = false; // @param in must not contain any elements that are null
					}
				}
				for (i =0; i<what.length; i++){
					if (what[i]== null){
						valid = false; // @param what must not contain any elements that are null
					}
				for (i =0; i<with.length; i++){
					if (with[i]== null){
						valid = false; //@ param with must not contain any elements that are null
					}
				}
				}
			}
      	}

      	if ( valid ) {
      	    out = new String[ in.length ]; // instantiating the out variable which will be returned
      	    for (i=0; i<in.length; i++ ) {
				for (int j = 0; j<what.length; j++){
					if (in[i].equals(what[j])){
						out[i] = with[j]; // replacing the string that appears in @param in and @param what with @param with
						j = what.length;
					}
					else{
						out[i] = in[i]; //populating out with @param in, since nothing is needed to be replaced
					}
				}
			}
			}
		return out;
		}
}
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

