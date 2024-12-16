package coding_maverick.todo_webapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


//@Controller - Spring ignore this class
@SessionAttributes("name") // Details stored across multiple requests
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String getTodos(ModelMap model) {
        String userName = (String) model.get("name");
        List<Todo> todos = todoService.findTodoByUserName(userName);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String setNewTodo(ModelMap model) {
        String userName = (String) model.get("name");
        Todo todo = new Todo(0, userName, "", LocalDate.now(), false); // We are setting our default values, when we are creating new bean
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String getNewTodos(ModelMap model, @Valid Todo todo, BindingResult result) { // Command Bean or Form Backing Object
        if (result.hasErrors()) {
            return "todo";
        }
        String userName = (String) model.get("name");
        todoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos"; // Redirecting to particular URL
    }
    // Command bean or Form backing object - 2 way binding (Form backing object) - directly binding it to the todo bean

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodoById(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findTodoById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateToDo(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todoService.updateTodoItem(id,todo.getDescription(), todo.getTargetDate(),todo.isDone());
        return "redirect:list-todos";
    }

}
