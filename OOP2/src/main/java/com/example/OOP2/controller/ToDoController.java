package com.example.OOP2.controller;

import com.example.OOP2.model.ToDo;
import com.example.OOP2.model.User;
import com.example.OOP2.service.ToDoService;
import com.example.OOP2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private UserService userService;

    // 🔹 Daftar semua tugas user + detail
    @GetMapping("/todos")
    public String home(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username).orElseThrow();
        model.addAttribute("todos", toDoService.getTodosByUser(user));
        model.addAttribute("username", username);
        return "index"; // tampilkan daftar tugas dan detailnya
    }

    // 🔹 Form tambah tugas
    @GetMapping("/todos/create")
    public String showCreateForm(Model model) {
        model.addAttribute("todo", new ToDo());
        return "create"; // form tambah
    }

    // 🔹 Simpan tugas baru
    @PostMapping("/todos/create")
    public String addTodo(@ModelAttribute ToDo todo, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username).orElseThrow();
        todo.setUser(user);
        toDoService.saveTodo(todo);
        return "redirect:/todos";
    }

    // 🔹 Form edit tugas berdasarkan id
    @GetMapping("/todos/edit/{id}")
    public String showEditForm(@PathVariable Long id, Principal principal, Model model) {
        String username = principal.getName();
        Optional<ToDo> todoOpt = toDoService.getTodoById(id);
        if (todoOpt.isPresent() && todoOpt.get().getUser().getUsername().equals(username)) {
            model.addAttribute("todo", todoOpt.get());
            return "edit";
        }
        return "redirect:/todos"; // jika tidak valid
    }

    // 🔹 Simpan update tugas
    @PostMapping("/todos/edit/{id}")
    public String editTodo(@PathVariable Long id, @ModelAttribute ToDo updatedTodo, Principal principal) {
        String username = principal.getName();
        Optional<ToDo> todoOpt = toDoService.getTodoById(id);
        if (todoOpt.isPresent() && todoOpt.get().getUser().getUsername().equals(username)) {
            ToDo todo = todoOpt.get();
            todo.setTask(updatedTodo.getTask());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompleted(updatedTodo.isCompleted());
            toDoService.saveTodo(todo);
        }
        return "redirect:/todos";
    }

    // 🔹 Hapus tugas
    @PostMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable Long id, Principal principal) {
        Optional<ToDo> todoOpt = toDoService.getTodoById(id);
        String username = principal.getName();

        todoOpt.ifPresent(todo -> {
            if (todo.getUser().getUsername().equals(username)) {
                toDoService.deleteTodo(id);
            }
        });
        return "redirect:/todos";
    }

    // 🔹 Toggle selesai / belum
    @PostMapping("/todos/update-status/{id}")
    public String updateTodo(@PathVariable Long id, Principal principal) {
        Optional<ToDo> todoOpt = toDoService.getTodoById(id);
        String username = principal.getName();

        todoOpt.ifPresent(todo -> {
            if (todo.getUser().getUsername().equals(username)) {
                todo.setCompleted(!todo.isCompleted());
                toDoService.saveTodo(todo);
            }
        });
        return "redirect:/todos";
    }
}
