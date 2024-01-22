package Controller;

import Consumer.Consumer;
import Order.Order;
import Product.Item;
import Product.ProductException;
import Order.AmountException;
import Consumer.CustomerException;

import java.util.List;

public class Shop {
    public static boolean isInArray(List<Consumer> a, Consumer b){
        for (Object elem: a){
            if (elem.equals(b)){
                return true;
            }
        }
        return false;
    }
    public static boolean isInArray(List<Item> a, Item b){
        for (Object elem: a){
            if (elem.equals(b)){
                return true;
            }
        }
        return false;
    }
    public static Order makeOrder(List<Consumer> consumers, List<Item> items, Consumer consumer, Item item, Integer count){
        if (!isInArray(items,item)){
            throw new ProductException("Не совершайте эту покупку!");
        }
        else if (count <0 || count > 100){
            throw new AmountException("Купите лишь 1 товар!");
        }
        else if (!isInArray(consumers, consumer)){
            throw new CustomerException("Такой пользователь не найден!");
        }

        return new Order(consumer, item, count);
    }
}
