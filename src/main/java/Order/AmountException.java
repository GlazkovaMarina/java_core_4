package Order;

public class AmountException extends RuntimeException{
    public AmountException(){
        super();
    }
    public AmountException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Передано слишком большое значение количества или отрицательное";
    }
}
