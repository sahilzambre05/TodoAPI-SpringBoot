package com.example.TodoApiSpringApplication;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private static List<Todo> todoList;


    public TodoController(){
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, false, "Todo 1", 1));
        todoList.add(new Todo(2, true, "Todo 2", 2));
    }


    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(name = "isCompleted", required = false) Boolean isCompleted){
        System.out.println("Incoming query Params :" + isCompleted);
        return ResponseEntity.ok(todoList);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable Long todoId) {
        for (Todo todo : todoList) {
            if (todo.getId()==todoId) {
                return ResponseEntity.ok(todo);
            }
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Todo not found"));
    }


}
