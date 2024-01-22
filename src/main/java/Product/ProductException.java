package Product;

public class ProductException extends RuntimeException{
    public ProductException(){
        super();
    }
    public ProductException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Передан несуществующий товар";
    }
}
