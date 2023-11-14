package com.geektext19.restapi.controllers.Book_details;

import com.geektext19.restapi.GeekText19RestapiApplication;
import com.geektext19.restapi.controllers.Book_details.request.CreateAuthorRequest;
import com.geektext19.restapi.controllers.Book_details.request.CreateBookRequest;
import com.geektext19.restapi.entities.Author;
import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.Book_detail.AuthorRepository;
import com.geektext19.restapi.repositories.Book_detail.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;



    @ExtendWith({SpringExtension.class})
    @SpringBootTest(classes = GeekText19RestapiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class BookDetailsControllerIntegrationTest {

        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private AuthorRepository authorRepository;

        @LocalServerPort
        private int port;

        private TestRestTemplate restTemplate;
        private HttpHeaders headers;

        @BeforeEach
        public void setup() {
            restTemplate = new TestRestTemplate();
            restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
        }

        @AfterEach
        public void tearDown() {
            bookRepository.deleteAll();
            authorRepository.deleteAll();
        }


        @Test
        public void testCreateBook() {
            CreateBookRequest request = createBookRequestObject();
            HttpEntity<CreateBookRequest> entity = new HttpEntity<CreateBookRequest>(request, headers);

            ResponseEntity<Void> response = restTemplate.postForEntity(
                    createURLWithPort("/book-details"), entity, Void.class);

            Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
            // Verify that the book is created in the repository
            Book createdBook = bookRepository.findById(request.getISBN()).orElse(null);
            Assertions.assertNotNull(createdBook);
            Assertions.assertEquals(request.getBookName(), createdBook.getBookName());
        }

        @Test
        public void testGetBookDetails() {
            Book savedBook = bookRepository.save(createBookObject());

            ResponseEntity<Book> response = restTemplate.getForEntity(
                    createURLWithPort("/book-details/" + savedBook.getIsbn()), Book.class);

            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
            Assertions.assertNotNull(response.getBody());
            Assertions.assertEquals(savedBook.getIsbn(), response.getBody().getIsbn());
            Assertions.assertEquals(savedBook.getBookName(), response.getBody().getBookName());
        }

        @Test
        public void testCreateAuthor() {
            CreateAuthorRequest request = createAuthorRequestObject();
            HttpEntity<CreateAuthorRequest> entity = new HttpEntity<CreateAuthorRequest>(request, headers);

            ResponseEntity<Void> response = restTemplate.postForEntity(
                    createURLWithPort("/book-details/author"), entity, Void.class);

            Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

            Author createdAuthor = authorRepository.findById(request.getFirstName()).orElse(null);
            Assertions.assertNotNull(createdAuthor);
            Assertions.assertEquals(request.getFirstName(), createdAuthor.getFirstName());
        }

        @Test
        public void testGetBooklist() {
            Author author = new Author("Jane", "Doe", "An acclaimed author", "XYZ Publishers");
            author = authorRepository.save(author);

            Book book1 = new Book("1234567890", "test Book 1", "Description 1", 29.99, "Jane Doe", "Fiction", "XYZ Publishers", 2021, 100, 4.5);
            Book book2 = new Book("0987654321", "test Book 2", "Description 2", 39.99, "Jane Doe", "Non-Fiction", "XYZ Publishers", 2020, 150, 4.7);
            bookRepository.save(book1);
            bookRepository.save(book2);

            ResponseEntity<Book[]> response = restTemplate.getForEntity(
                    createURLWithPort("/book-details/author/" + author.getId() + "/books"), Book[].class);

            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
            Book[] books = response.getBody();
            Assertions.assertNotNull(books);
            Assertions.assertTrue(books.length >= 2);
            Assertions.assertEquals(book1.getIsbn(), books[0].getIsbn());
            Assertions.assertEquals(book2.getIsbn(), books[1].getIsbn());
        }


        private String createURLWithPort(String uri) {
            return "http://localhost:" + port + uri;
        }

        private static CreateBookRequest createBookRequestObject() {
            CreateBookRequest request = new CreateBookRequest();
            request.setISBN("1234567890");
            request.setBookName("Sample Book");
            request.setDescription("A sample book for testing");
            request.setPrice(25.99);
            request.setAuthorName("John Doe");
            request.setGenre("Fiction");
            request.setPublisher("XYZ Publishers");
            request.setYearPublished(2021);
            request.setCopiesSold(100);
            request.setRating(4.5);
            return request;
        }

        private static Book createBookObject() {
            return new Book(
                    "1234567890", "Sample Book", "Description", 29.99, "John Doe", "Fiction", "XYZ Publishers", 2021, 100, 4.5
            );
        }

        private static CreateAuthorRequest createAuthorRequestObject() {
            CreateAuthorRequest request = new CreateAuthorRequest();
            request.setFirstName("Jane");
            request.setLastName("Doe");
            request.setBiography("An acclaimed author...");
            request.setPublisher("XYZ Publishers");
            return request;
        }
    }


