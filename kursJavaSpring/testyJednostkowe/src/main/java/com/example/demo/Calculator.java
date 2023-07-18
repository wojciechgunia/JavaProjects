package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Calculator {
    private final Fibonacci fibonacci;

    public int sum(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }

    public int multi(int a, int b){
        return a*b;
    }

    public int divi(int a, int b){
        return a/b;
    }

    public List<Integer> fibonacci(int n){
       return fibonacci.calc(n,0,1);
    }

    public int meanAvg(int n){
       List<Integer> list = fibonacci.calc(n,0,1);
       int avg = list.stream().mapToInt(value -> value).sum();
       return avg/list.size();
    }
}
