package BookPlacementWithComparable;

public class Book implements Comparable {

    String name;
    int pageCount;
    String authorName;
    String publishDate;

    public Book(String name, int page, String authorName, String publishDate) {
        this.name = name;
        this.pageCount = page;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', Page Number='" + pageCount + "', Author Name=" + authorName + "', Publish Date=" + publishDate + '}';
    }

    /*@Override
    public int compareTo(Object o) {
        Book other = (Book) o;
        return this.name.compareTo(other.name);
    }*/

    @Override
    public int compareTo(Object o) {
        Book other = (Book) o;
        return Integer.compare(this.pageCount, other.pageCount);
    }
}
