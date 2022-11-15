package Exception;

public class WrongCommand extends CalculatorException{
    public WrongCommand(){
    }
    public WrongCommand(String message){
        super(message);
    }
}
