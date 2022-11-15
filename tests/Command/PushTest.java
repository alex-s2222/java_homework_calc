package Command;

import static org.junit.jupiter.api.Assertions.*;
import Exception.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class PushTest {
    @Test
    void ExecuteOK()throws NoDefinitionExcetpion{
        Stack<Double> stack = new Stack<Double>();
        Map<String, Double> vars = new HashMap<String, Double>();
        final String[] args ={ "fefef", "3.0"};

        vars.put(args[0], Double.valueOf(args[1]));

        var context = new Push(stack, vars);
        context.setPush(args[0]);
        context.perform();

        assertEquals(context.stack.size(), 1);
    }

}