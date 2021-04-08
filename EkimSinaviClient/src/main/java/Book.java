

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Book")
public class Book {
    private int id;
    private String title;
    private String author;
    private String year;
    private String yearOfBirth;
   


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getYear() {
        return year;
    }
    
     public String getAuthorBirth() {
        return yearOfBirth;
    }

    public void setAuthorBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setYear(String  year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String  title) {
        this.title = title;
    }

 
}
