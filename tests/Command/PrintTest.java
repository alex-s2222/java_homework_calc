package Command;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import Exception.StackCalcException;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    @Test
    void ExecuteOK() throws StackCalcException {
        Stack<Double> stack = new Stack<Double>();
        Map<String, Double> vars = new HashMap<String, Double>();

        final double num2 = 25;
        final double num1 = 2;

        stack.push(num2);

        var contex = new Print(stack, vars);
        contex.perform();


        assertEquals(contex.stack.size(), 1);
        assertEquals(contex.stack.peek(), 25.0);

        stack.push(num1);
        contex.perform();

        assertEquals(contex.stack.size(),2);
        assertEquals(contex.stack.peek(), 2.0);

    }

}