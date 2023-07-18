package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculatorTest
{
    Calculator calculator;
    Fibonacci fibonacci;
    @BeforeEach
    void init()
    {
        fibonacci = mock(Fibonacci.class);
        calculator = new Calculator(fibonacci);
    }


    @Test
    void sumTest()
    {
        int sum = calculator.sum(2,2);
        assertEquals(4, sum);
    }

    @Test
    void subTest()
    {
        int sub = calculator.sub(2,2);
        assertEquals(0, sub);
        assertTrue(sub > -1);
    }

    @Disabled
    @Test
    void fibiTest()
    {
        when(fibonacci.calc(2,0,1)).thenReturn(new ArrayList<>(List.of(1,2,3)));
        List<Integer> integers = calculator.fibonacci(2);
        assertEquals(3,integers.size());
    }

}
