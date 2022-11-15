package Command;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import Command.Command;
import Exception.StackCalcException;


import static org.junit.jupiter.api.Assertions.*;

class CommandTest {
    protected Stack<Double> stack = new Stack<Double>();
    protected Map<String, Double> vars = new HashMap<String, Double>();

    @Test
    void SumOK() throws StackCalcException {
        final double num1 = 1.2;
        final double num2 = 3.0;

        var context = new Sum(stack,vars);
        context.stack.push(num1);
        context.stack.push(num2);
        context.perform();

        assertEquals(context.stack.size(), 1);
        assertEquals(context.stack.peek(), num1 + num2);
    }
    @Test
    void MinusOK() throws StackCalcException{
        final double num1 = 1.2;
        final double num2 = 3.0;

        var context = new Minus(stack,vars);
        context.stack.push(num2);
        context.stack.push(num1);
        context.perform();


        assertEquals(context.stack.size(), 1);
        assertEquals(context.stack.peek(), num1 - num2);
    }
    @Test
    void MultiplyOk() throws StackCalcException {
        final double num1 = 1.2;
        final double num2 = 3.0;

        var context = new Mul(stack,vars);
        context.stack.push(num2);
        context.stack.push(num1);
        context.perform();

        assertEquals(context.stack.size(), 1);
        assertEquals(context.stack.peek(), num1 * num2);
    }
    @Test
    void DivOK() throws StackCalcException {
        final double num1 = 1.2;
        final double num2 = 3.0;

        var context = new Div(stack,vars);
        context.stack.push(num2);
        context.stack.push(num1);
        context.perform();

        assertEquals(context.stack.size(), 1);
        assertEquals(context.stack.peek(), num1 / num2);
    }
}