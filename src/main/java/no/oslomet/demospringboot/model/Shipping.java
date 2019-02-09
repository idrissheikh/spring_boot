package no.oslomet.demospringboot.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@ToString

public class Shipping {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int address;
    private int postalCode;


    //usikker har
    @OneToMany(mappedBy="shipping")
    private List<Orders>  ordersList;


}
