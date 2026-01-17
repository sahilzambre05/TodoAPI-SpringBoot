package com.example.TodoApiSpringApplication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService{

    @TimeMonitor
    public String doSomething() {
        return "Something from fake TodoService";
    }

}