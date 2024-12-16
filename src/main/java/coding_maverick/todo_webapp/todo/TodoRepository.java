package coding_maverick.todo_webapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> { // Todo - Entity, Integer - Primary key type
    List<Todo> findByUserName(String userName);
}
