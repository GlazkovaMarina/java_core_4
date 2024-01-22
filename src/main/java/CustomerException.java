public class CustomerException extends RuntimeException{
    public CustomerException(){
        super();
    }
    public CustomerException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Передан несуществующий покупатель";
    }
}
