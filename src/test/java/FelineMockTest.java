import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineMockTest {

    @Mock
    private Animal animal;

    private Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(animal.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(animal.getFood("Хищник"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest(){
        String actualResult = feline.getFamily();
        String expectedResult = "Кошачьи";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensTestWithoutParameters(){
        int actualResult = feline.getKittens();
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensTestWithParameters(){
        int kittens = 10;
        int actualResult = feline.getKittens(kittens);
        assertEquals(kittens, actualResult);
    }

}
