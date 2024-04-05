import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();
    }

    public void addBook (Book b) {
        // Your code here
        library.add(b);
    }

    public void sort() {
        // Your code here  
        for (int i=0; i<library.size()-1; i++)
        {
            for (int j=0; j<library.size()-i-1;j++){
                Book b1 = library.get(j);
                Book b2=library.get(j+1);
                
                
                if (b1.getAuthor().compareTo(b2.getAuthor())>0){
                    library.set(j,b2);
                    library.set(j+1,b1);
                }
                else if ( (b1.getAuthor().compareTo(b2.getAuthor())==0)){
                    if (b1.getTitle().compareTo(b2.getTitle())>0){
                        library.set(j,b2);
                        library.set(j+1,b1);}
                    else if (b1.getTitle().compareTo(b2.getTitle())==0){
                            if (b1.getYear()>b2.getYear()){
                            library.set(j,b2);
                            library.set(j+1,b1);
                        }
                    }
                    
                }
                
            }
        }
    }


    public void printLibrary() {
        // Your code here
        for (Book book:library){
            System.out.println(book);
        }
    }
}