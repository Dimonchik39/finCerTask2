import org.example.task2.MathService;
import org.example.task2.NotFoundAnswerException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MathServiceTest {
    @Test
    void testPositiveAnswer() throws NotFoundAnswerException {
        MathService mathService = new MathService();
        assertEquals("Answer{first=-6.0, second=48.0}",mathService.getAnswer(-3,21,24).toString());
    }
    @Test
    void testDiscriminantPositive() {
        MathService mathService = new MathService();
        assertEquals(729,mathService.getD(-3,21,24));
    }
    @Test
    void testDiscriminantZero()  {
        MathService mathService = new MathService();
        assertEquals(0,mathService.getD(3,0,0));
    }
    @Test
    void testDiscriminantNegative(){
        MathService mathService = new MathService();
        assertEquals(-144, mathService.getD(3,0,12));
    }

    @ParameterizedTest
    @CsvSource({"2,2,2","24,8,10","8,12,16"})
    void testParameterizedNegative(int a,int b, int c)  {
        MathService mathService = new MathService();
        assertThrows(NotFoundAnswerException.class, () -> {
            mathService.getAnswer(a,b,c);
        }, "Корни не найдены");
    }
}
