package Command;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import Exception.*;


class SqrtTest {
    @Test
    void ExecuteOK() throws StackCalcException {
        Stack<Double> stack = new Stack<Double>();
        Map<String, Double> vars = new HashMap<String, Double>();

        final double num2 = 25;


        stack.push(num2);

        var contex = new Sqrt(stack,vars);
        contex.perform();

        assertEquals(contex.stack.size(),1);
        assertEquals(contex.stack.peek(),Math.sqrt(num2));
    }

}