package no.oslomet.demospringboot.model;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString

public class Book {

    //Author_book
    @ManyToMany(mappedBy = "bookList")
    private List<Author> authorList;



    //Order_book
    @ManyToMany(mappedBy = "bookList")
    private List<Orders> ordersList;




   //Book_catrgory
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category category;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String releaseYear;
    private int quantity;


}
