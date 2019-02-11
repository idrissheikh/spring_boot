package no.oslomet.demospringboot.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString

public class Book {

    //Author_book
    @ManyToMany(mappedBy = "bookList", cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
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

    public Book(List<Author> authorList, Category category, String title, String releaseYear, int quantity) {
        this.authorList = authorList;
        this.category = category;
        this.title = title;
        this.releaseYear = releaseYear;
        this.quantity = quantity;
    }



}
