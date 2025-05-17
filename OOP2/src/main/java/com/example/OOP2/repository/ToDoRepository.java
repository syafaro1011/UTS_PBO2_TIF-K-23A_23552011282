package com.example.OOP2.repository;

import com.example.OOP2.model.ToDo;
import com.example.OOP2.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByUser(User user);
}
