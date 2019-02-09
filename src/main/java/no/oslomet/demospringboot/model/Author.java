package no.oslomet.demospringboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@ToString


public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fristName;
    private String lastName;
    private String rating;

    //book_Author
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Author_Book",
            joinColumns = { @JoinColumn(name = "Author_id") },
            inverseJoinColumns = { @JoinColumn(name = "Book_isbn") }
    )
    private List<Book> bookList;



    //Author_Category
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Author_Category",
            joinColumns = { @JoinColumn(name = "Author_id") },
            inverseJoinColumns = { @JoinColumn(name = "Category_id") }
    )
    private List<Category> categoryList;





}
