/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	size = 0;
		messages = new Post[MAX_SIZE];
    }

    public void add(Post message) {
		if (size == MAX_SIZE){
			return;
		}	
		messages[size++] = message;

    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
		NewsFeed PhotoFeed = new NewsFeed();
		for (int i = 0; i< size(); i++){
			if (messages[i].getClass().getName().equals("PhotoPost")){
				PhotoFeed.add(messages[i]);
			}
  	}
	return PhotoFeed;
}

  	public NewsFeed plus(NewsFeed other){
		NewsFeed combinedfeed = new NewsFeed();
		
		for (int i = 0; i<size(); i++){
			combinedfeed.add(messages[i]);
		}
		
		for (int j = 0; j<other.size(); j++){
			combinedfeed.add(other.messages[j]);
		}
		combinedfeed.sort();
		return combinedfeed;
  	  // Your code here
  	}

}
