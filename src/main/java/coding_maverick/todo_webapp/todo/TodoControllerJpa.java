package coding_maverick.todo_webapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name") // Details stored across multiple requests
public class TodoControllerJpa {

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String getTodos(ModelMap model) {
        String userName = (String) model.get("name");
        List<Todo> todos = todoRepository.findByUserName(userName);
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
        todo.setUserName(userName);
        todoRepository.save(todo);
        return "redirect:list-todos"; // Redirecting to particular URL
    }
    // Command bean or Form backing object - 2 way binding (Form backing object) - directly binding it to the todo bean

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodoById(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateToDo(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        Todo todoToUpdate = todoRepository.findById(id).get();
        todoToUpdate.setDescription(todo.getDescription());
        todoToUpdate.setTargetDate(todo.getTargetDate());
        todoToUpdate.setDone(todo.isDone());
        todoRepository.save(todoToUpdate);
        return "redirect:list-todos";
    }

}
