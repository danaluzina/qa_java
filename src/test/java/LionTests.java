import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline;

    @Test
    public void getKittensIsCorrect() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedCount = 1;

        MatcherAssert.assertThat("Некорректное количество котят",
                lion.getKittens(),
                equalTo(expectedCount));
    }

    @Test
    public void getFoodIsCorrect() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");

        MatcherAssert.assertThat("Некорректный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood));
    }
}
