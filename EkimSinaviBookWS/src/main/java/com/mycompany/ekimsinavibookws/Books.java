package com.mycompany.ekimsinavibookws;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("books")
@Produces("text/xml")
public class Books {
    private Map<Integer, Book> books = new HashMap<>();

    Books() {
        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("Book1");
        book1.setAuthor("Nick Jonas");
        book1.setYear("1997");
        
        Book book2 = new Book();
        book2.setId(2);
        book2.setTitle("Book2");
        book2.setAuthor("Joe Jonas");
        book2.setYear("1998");
        
        Book book3 = new Book();
        book3.setId(3);
        book3.setTitle("Book3");
        book2.setAuthor("Kevin Jonas");
        book2.setYear("1999");
     
        Book book4 = new Book();
        book2.setId(4);
        book2.setTitle("Book4");
        book2.setAuthor("Abidik Jonas");
        book2.setYear("2000");
        
        Book book5 = new Book();
        book2.setId(5);
        book2.setTitle("Book5");
        book2.setAuthor("Abidik Jonas");
        book2.setYear("2000");
        
        Book book6 = new Book();
        book6.setId(6);
        book6.setTitle("Book6");
        book6.setAuthor("Gubidik Jonas");
        book6.setYear("2000");
        
        Book book7 = new Book();
        book7.setId(7);
        book7.setTitle("Book7");
        book7.setAuthor("Airport Jonas");
        book7.setYear("2001");
        
        Book book8 = new Book();
        book8.setId(8);
        book8.setTitle("Book8");
        book8.setAuthor("Flight Jonas");
        book8.setYear("2002");
        
        Book book9 = new Book();
        book9.setId(9);
        book9.setTitle("Book9");
        book9.setAuthor("plane Jonas");
        book9.setYear("2003");
        
        Book book10 = new Book();
        book10.setId(10);
        book10.setTitle("Book10");
        book10.setAuthor("elma Jonas");
        book10.setYear("2010");

        this.books.put(1, book1);
        this.books.put(2, book2);
        this.books.put(3, book3);
        this.books.put(4, book4);
        this.books.put(5, book5);
        this.books.put(6, book6);
        this.books.put(7, book7);
        this.books.put(8, book8);
        this.books.put(9, book9);
        this.books.put(10, book10);

    }

    @GET
    @Path("{bookId}")
    public Book getCourse(@PathParam("bookId") int bookId) {
        return findById(bookId);
    }

 

    private Book findById(int id) {
        for (Map.Entry<Integer, Book> book : books.entrySet()) {
            if (book.getKey() == id) {
                return book.getValue();
            }
        }
        return null;
    }
}

