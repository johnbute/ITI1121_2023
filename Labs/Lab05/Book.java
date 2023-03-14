public class Book {

    String author;
	String title;
	int year;

    public Book (String author, String title, int year) {
        this.author = author;
		this.title = title;
		this.year = year ;
    }

    public String getAuthor() {
		return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object other) {
		boolean result = true;
		if (other == null){
			result = false;
		}
		else if (getClass() != other.getClass()){
			result = false;
		}
		else{
			Book o = (Book) other;
			if (author == null){
				if (o.author != null){
					result = false;
				}
			}
			else if (!author.equals(o.author)){
				result = false;
			}
			else if (title == null){
				if (o.title !=null){
					result = false;
				}
			}
			else if (!title.equals(o.title)){
				result = false;
			}
			else if (year != o.year){
				result = false;
			}
		}
		return result;
    }

    public String toString() {
        return author + ":" + title + "("+ year + ")";
    }
}