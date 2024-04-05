import java.util.Objects;

public class Book {

    // Your variables declaration here
    private String author;
    private String title;
    private int year;

    public Book (String author, String title, int year) {
        // Your code here
        this.author=author;
        this.title=title;
        this.year=year;
    }

    public String getAuthor() {
        // Your code here
        return author;
    }

    public String getTitle() {
        // Your code here
        return title;
    }

    public int getYear() {
        // Your code here
        return year;
    }

    public boolean equals(Object other) {
        // Your code here
        if (this==other){
            return true;
        }
        if(other==null||getClass()!=other.getClass()){
            return false;
        }

        Book book = (Book)other; 
        
        if (title!=null&&book.title!= null && author!=null&&book.author!=null )
        {
            boolean titleYearEquals= year==book.year && Objects.equals(title,book.title);
            boolean titleAuthorEquals = Objects.equals(title,book.title) && Objects.equals(author, book.author);;
            return titleYearEquals && titleAuthorEquals;
        }
        else if (author==null && book.author==null && title!=null && book.title!=null){
            boolean authorNullTitleEquals= year==book.year && Objects.equals(title,book.title);
            return authorNullTitleEquals;
        }
        else if (author!=null && book.author!=null && title==null && book.title==null){
            boolean authorTitleNullEquals= year==book.year && Objects.equals(title,book.title);
            return authorTitleNullEquals;
        }
        else
        {
            return false;
        }
        
    }
    public String toString() {
        // Your code here
        return "Book{" + "author='" + author + '\'' + ", title='" + title + '\'' + ", year=" + year + '}';
    }
}