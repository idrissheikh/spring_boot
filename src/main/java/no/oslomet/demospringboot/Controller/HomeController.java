package no.oslomet.demospringboot.Controller;

import no.oslomet.demospringboot.model.Book;
import no.oslomet.demospringboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.net.Authenticator;
import java.util.List;

public class HomeController {

    @Autowired
    private AurthorRepository aurthorRepository;
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private OrdersRepository ordersRepository;
    private ShippingRepository shippingRepository;



}
