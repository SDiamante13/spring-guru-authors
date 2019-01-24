package com.diamante.springframeworkguru.config;

import com.diamante.springframeworkguru.model.Author;
import com.diamante.springframeworkguru.model.Book;
import com.diamante.springframeworkguru.model.Publisher;
import com.diamante.springframeworkguru.repository.AuthorRepository;
import com.diamante.springframeworkguru.repository.BookRepository;
import com.diamante.springframeworkguru.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableJpaRepositories(basePackageClasses = {AuthorRepository.class, BookRepository.class, PublisherRepository.class})
@Configuration
public class InitialLoadConfig {
    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        return strings -> {
            Author author1 = new Author("Antoine de", "Saint-Exupery");
            Publisher publisher1 = new Publisher("Publisher Reynal & Hitchcock", "327 Camp Lane");
            Book book1 = new Book("The Little Prince", "978-3-16-148410-0", publisher1);
            Book book2 = new Book("The Aviator", "979-3-07-138421-0", publisher1);
            Set<Book> antoineBooks = Stream.of(book1, book2)
                    .collect(Collectors.toCollection(HashSet::new));
            author1.setBooks(antoineBooks);
            book1.getAuthors().add(author1);
            book2.getAuthors().add(author1);

            authorRepository.save(author1);
            publisherRepository.save(publisher1);
            bookRepository.save(book1);
            bookRepository.save(book2);
        };
    }
}
