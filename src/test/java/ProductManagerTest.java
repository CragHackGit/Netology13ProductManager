import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)

public class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    ProductManager manager;

    Product first = new Book(1, "Lord of the Rings", 1000, "Tolkien");
    Product second = new Book(2, "Storm of Shadows", 700, "Pehov");
    Product third = new Smartphone(3, "Galaxy A50", 24000, "Samsung");
    Product fourth = new Smartphone(4, "Honor 50 Pro", 44000, "Huawei");

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }


    @Test
    void shouldSearchByBookName() {
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Storm of Shadows");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchByBookAuthor() {
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Tolkien");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchSmartphoneByTitle() {
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Honor 50 Pro");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchSmartphoneByManufacturer() {
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{third, fourth};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);

    }

}