import java.time.LocalDate;
import java.time.Period;

public class Order {
    //(объект покупатель, объект товар, количество
    private Consumer consumer;
    private Item item;
    private Integer count;

    @Override
    public String toString() {
        return "Order{" +
                "consumer=" + consumer +
                ", item=" + item +
                ", count=" + count +
                '}';
    }

    public Consumer getConsumer() {
        return consumer;
    }


    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Order(Consumer consumer, Item item, Integer count) {
        this.consumer = consumer;
        this.item = item;
        this.count = count;
    }
}
