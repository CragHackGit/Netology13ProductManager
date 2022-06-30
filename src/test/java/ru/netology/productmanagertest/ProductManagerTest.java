package ru.netology.productmanagertest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

public class ProductManagerTest {

    ProductManager manager = new ProductManager();

    Book book1 = new Book(1, "Lord of the Rings", "Tolkien");
    Book book2 = new Book(2, "Storm of Shadows", "Pehov");
    Book book3 = new Book(3, "One hero, two hero...", "Ulanov");
    Smartphone smartphone1 = new Smartphone(4, "SamsungA50", "Korea");
    Smartphone smartphone2 = new Smartphone(5, "SamsungA70", "Korea");
    Smartphone smartphone3 = new Smartphone(6, "Honor50Pro", "China");

    @Nested
    class setupTests {
        @BeforeEach
        public void setup() {
            manager.add(book1);
            manager.add(book2);
            manager.add(book3);
            manager.add(smartphone1);
            manager.add(smartphone2);
            manager.add(smartphone3);

        }

        @Test
        void shouldManagerAddProduct() {

            Product[] actual = manager.findAll();
            Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldManagerSearchBy() {

            Product[] actual = manager.searchBy("Samsung");
            ;
            Product[] expected = {smartphone1, smartphone2};

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        void shouldRepositoryDeleteById() {

            manager.deleteById(2);
            manager.deleteById(3);
            manager.deleteById(5);

            Product[] actual = manager.findAll();
            Product[] expected = {book1, smartphone1, smartphone3};

            Assertions.assertArrayEquals(expected, actual);
        }


        @Test
        void shouldRepositoryDeleteByNullId() {

            manager.deleteById(9);

            Product[] actual = manager.findAll();
            Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

            Assertions.assertArrayEquals(expected, actual);
        }
    }

    @Nested
    class standAloneTests {
        @Test
        void shouldRepositoryDeleteByIdZeroArray() {
            manager.deleteById(1);

            Product[] actual = manager.findAll();
            Product[] expected = {};

            Assertions.assertArrayEquals(expected, actual);
        }
    }
}


