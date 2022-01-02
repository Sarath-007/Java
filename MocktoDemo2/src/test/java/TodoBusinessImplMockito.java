import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockito {
    @Test
public void UsingMockito(){
        TodoService todoservice=mock(TodoService.class);
        List<String> allTodos= Arrays.asList("Spring","Spring and summer","Winter");
        when(todoservice.retrieveTodos("Dummy")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoservice);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, todos.size());


}
}
