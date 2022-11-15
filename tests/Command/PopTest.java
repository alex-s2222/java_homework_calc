package Command;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import Exception.*;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {
    protected Stack<Double> stack = new Stack<Double>();
    protected Map<String, Double> vars = new HashMap<String, Double>();

    final double num1 = 4.2;
    final double num2 = 8.8;

    @Test
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    void ExecuteOK() throws StackCalcException {
        var context = new Pop(stack, vars);

        context.stack.push(num1);
        context.perform();
        assertEquals(context.stack.size(), 0);
    }
}