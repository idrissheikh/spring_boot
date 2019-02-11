package no.oslomet.demospringboot;

import no.oslomet.demospringboot.model.Author;
import no.oslomet.demospringboot.model.Book;
import no.oslomet.demospringboot.model.Category;
import no.oslomet.demospringboot.repository.BookRepository;
import no.oslomet.demospringboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override

    public void run(String... args) throws Exception {
        Category category1 = new Category();
        Author author = new Author();
        author.setFristName("Henrik");
        author.setLastName("Ibsen");

        List<Author> authorList = new ArrayList<>();
        authorList.add(author);

        Author author1 = new Author();
        author1.setFristName("Knut");
        author1.setLastName("Hamsun");
        authorList.add(author1);

        category1.setName("DRAMA");

        Book book1 = new Book(authorList, category1, "Nora", "1886", 200 );
        Book book2 = new Book(authorList, category1, "Sulten", "1890", 200 );

        bookRepository.save(book1);
      //  bookRepository.save(book2);


    }
}

