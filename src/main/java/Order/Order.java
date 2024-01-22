package Order;

import Consumer.Consumer;
import Product.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Order {
    private Consumer consumer;
    private Item item;
    private Integer count;
}
