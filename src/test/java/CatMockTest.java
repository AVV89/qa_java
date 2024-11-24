import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class CatMockTest {
    Cat cat;

    @Mock
    Feline FelineMock;

    @Before
    public void initCat(){
        MockitoAnnotations.initMocks(this);
        cat = new Cat(FelineMock);
    }

    @Test
    public void getSoundTest() {
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(FelineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);

    }


}

