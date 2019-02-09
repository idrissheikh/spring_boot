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

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;



    //Book_Order
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Order_Book",
            joinColumns = { @JoinColumn(name = "Orders_id") },
            inverseJoinColumns = { @JoinColumn(name = "Book_isbn") }
    )
    private List<Book> bookList;


    //bok_Orders
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Shipping_id")
    private Shipping shipping;







}
