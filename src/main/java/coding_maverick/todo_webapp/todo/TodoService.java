package coding_maverick.todo_webapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;
    static {
        todos.add(new Todo(++todoCount,"siyo","Learn SpringBoot", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCount,"siyo","Learn AWS",LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todoCount,"batman","Learn Azure",LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findTodoByUserName(String userName){
        // String cannot be compared with == , it will be compared with equals
        return todos.stream().filter(todo -> todo.getUserName().equalsIgnoreCase(userName)).toList();
    }

    public void addTodo(String userName, String description, LocalDate targetDate, Boolean done) {
        Todo todo = new Todo(++todoCount,userName,description,targetDate,done);
        todos.add(todo);
    }

    public void deleteTodo(int id){
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findTodoById(int id) {
        Todo todo = todos.stream().filter(todo1 ->  todo1.getId() == id ).findFirst().get();
        return todo;
    }

    public void updateTodoItem(int id, String description, LocalDate targetDate, Boolean done) {
        Todo todo = findTodoById(id);
        todo.setDescription(description);
        todo.setTargetDate(targetDate);
        todo.setDone(done);
    }

}
