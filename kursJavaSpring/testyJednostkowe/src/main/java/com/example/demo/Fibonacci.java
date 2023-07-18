package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Fibonacci {

     public List<Integer> calc(int n,int firstTerm,int secondTerm){
         ArrayList<Integer> fibonacci = new ArrayList<>();
         fibonacci.add(firstTerm);
         fibonacci.add(secondTerm);
         for (int i = 1; i <= n; ++i) {
             System.out.print(firstTerm + ", ");

             int nextTerm = firstTerm + secondTerm;
             firstTerm = secondTerm;
             secondTerm = nextTerm;
             fibonacci.add(secondTerm);
         }
         return fibonacci;
     }
}
