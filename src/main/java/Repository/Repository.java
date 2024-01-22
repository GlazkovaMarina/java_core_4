package Repository;

import java.util.ArrayList;
import java.util.List;

import Consumer.Consumer;
import Product.Item;
import Order.Order;

public class Repository {
    List<Consumer> consumers;
    List<Item> items;
    List<Order> orders;
    public Repository(){
        consumers = new ArrayList<>();
        items = new ArrayList<>();
        orders = new ArrayList<>();
    }
    public List<Consumer> addConsumer(Consumer consumer){
        consumers.add(consumer);
        return consumers;
    }
    public List<Item> addItem(Item item){
        items.add(item);
        return items;
    }
    public List<Order> addOrder(Order order)
    {
        orders.add(order);
        return orders;
    }

    public List<Item> getItems(){
        return items;
    }
    public List<Consumer> getConsumers(){
        return consumers;
    }
    public Consumer getConsumerByIndex(int index){
        for (int i = 0; i < consumers.size(); i++) {
            if (index == i){
                return consumers.get(i);
            }
        }
        throw new ArrayIndexOutOfBoundsException("Такого покупателя нет");
    }
    public Item getItemByIndex(int index){
        for (int i = 0; i < items.size(); i++) {
            if (index == i){
                return items.get(i);
            }
        }
        throw new ArrayIndexOutOfBoundsException("Такого товара нет");
    }
}
