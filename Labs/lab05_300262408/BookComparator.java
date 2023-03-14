import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
	public int compare(Book a, Book b){
		int result = 0;
		result = a.getAuthor().compareTo(b.getAuthor());
		if (result !=0){
			return result;
		}
		result = a.getTitle().compareTo(b.getTitle());
		if (result !=0){
			return result;
		}
		if(a.getYear() < b.getYear()){
            return -1;
        } else if (a.getYear() == b.getYear()){
            return 0;
        } else {
            return 1;
        }
		
		/*if (a.getAuthor().compareTo(b.getAuthor()) == 0){
			if (a.getTitle().compareTo(b.getTitle()) == 0){
				if (a.getYear() < b.getYear()){
					return -1;
				}
			}
		}
		
		if (a.getAuthor().compareTo(b.getAuthor()) == 0){
			if (a.getTitle().replaceAll(" ", "").compareTo(b.getTitle().replaceAll(" ","")) != 0){
				return -1;
			}
		}
		
		if (a.getAuthor().compareTo(b.getAuthor()) != 0){
			return -1;
		}
		
		return 1;
		*/
    // Implement the comparator method for books.
}
}