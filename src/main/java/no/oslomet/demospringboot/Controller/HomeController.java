package no.oslomet.demospringboot.Controller;

import no.oslomet.demospringboot.model.Book;
import no.oslomet.demospringboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.net.Authenticator;
import java.util.List;

@Controller
public class HomeController {

    //depaance injection
    @Autowired
    private AurthorRepository aurthorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ShippingRepository shippingRepository;

    @GetMapping({"/", "/list"})
    public String list(Model model ){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        Book book = new Book();
        model.addAttribute("book", book);
        return "index";
    }

    @PostMapping("/saveBook")
    public String save(@ModelAttribute("book") Book book ){
        bookRepository.save(book);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model ){
        Book book  =this.bookRepository.findById(Long.parseLong(id)).get();
        List<Book> books = bookRepository.findAll();
        model.addAttribute("book", book );
        model.addAttribute("books", books );

        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id,Model model ){
        this.bookRepository.deleteById(Long.parseLong(id));
        return "redirect:/list";
    }



}
