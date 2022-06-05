package Exercise3_1;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int copiedSold;

    public Book(String title, String author, String publisher, int copiedSold){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copiedSold = copiedSold;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public void setCopiedSold(int copiedSold){
        this.copiedSold = copiedSold;
    }


    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getPublisher(){
        return publisher;
    }

    public int getCopiedSold(){
        return copiedSold;
    }

    public static void main(String[] args) {
        Book book = new Book("today", "cham", "sky", 500);

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getPublisher());
        System.out.println(book.getCopiedSold());
    }
}

