import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameterized {

    private String sex;
    private boolean hasMane;
    private boolean expectException;

    public LionTestParameterized(String sex, boolean hasMane, boolean expectException) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.expectException = expectException;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][] {
                {"Самец", true, false}, // Самец имеет гриву
                {"Самка", false, false}, // Самка не имеет гривы
                {"Неизвестный пол", false, true}, // Некорректный пол, ожидаем исключение
                {null, false, true} // Нулевой пол, ожидаем исключение
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline feline = new Feline();
        if (expectException) {
            try {
                new Lion(sex, feline);
                throw new AssertionError("Expected exception was not thrown");
            } catch (Exception e) {
                assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            }
        } else {
            Lion lion = new Lion(sex, feline);
            assertEquals(hasMane, lion.doesHaveMane());
        }
    }
}



