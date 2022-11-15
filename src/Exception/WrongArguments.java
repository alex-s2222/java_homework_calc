package Exception;

public class WrongArguments extends CalculatorException{
    public WrongArguments(){
    }
    public WrongArguments(String message){
        super(message);
    }
}
