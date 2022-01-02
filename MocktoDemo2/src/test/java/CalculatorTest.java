import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    CalculatorService service= mock(CalculatorService.class);
    Calculator c=new Calculator(service);
    @Test
    public void testAdd(){
        when(service.add(2,3)).thenReturn(5);
        assertEquals(5,c.perform(2,3));
    }
}