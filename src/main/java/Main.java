import Consumer.Consumer;
import Controller.Shop;
import Order.Order;
import Product.Item;
import Product.ProductException;
import Order.AmountException;
import Consumer.CustomerException;
import Repository.Repository;

import  Consumer.Sex;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void Congratulate(List<Consumer> consumers){
        LocalDateTime currentDateTime = LocalDateTime.now();
        String str = String.valueOf(currentDateTime.getMonthValue()) + '-' + String.valueOf(currentDateTime.getDayOfMonth()) ;
        for(Consumer consumer: consumers){
            if (str.equals(Holiday.NY.getTitle())){
                System.out.println("Счастливого Нового года, " + consumer.getLastName() + ' ' + consumer.getFirstName() + ' ' + consumer.getFathersName() + '!');
            } else if (str.equals(Holiday.MARCH_8.getTitle()) && consumer.getSex() == Sex.FEMALE) {
                System.out.println("С 8 марта, уважаемая " + consumer.getLastName() + ' ' + consumer.getFirstName() + ' ' + consumer.getFathersName() + '!');
            } else if (str.equals(Holiday.FEBRUARY_23.getTitle()) && consumer.getSex() == Sex.MALE) {
                System.out.println("С 23 февраля, уважаемый " + consumer.getLastName() + ' ' + consumer.getFirstName() + ' ' + consumer.getFathersName() + '!');
            }
        }
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        repository.addConsumer(new Consumer("Fedorov", "Ilya", "Vladimirovich", Sex.MALE, "2000-12-01", "79990000000"));
        repository.addConsumer(new Consumer("Titova", "Tanya", "Vladimirovna", Sex.FEMALE, "1995-11-11", "79009999999"));
        repository.addItem(new Item("Milk", 101.90));
        repository.addItem(new Item("Sugar", 87.99));
        repository.addItem(new Item("cucumber", 290.90));
        repository.addItem(new Item("salt", 44.77));
        repository.addItem(new Item("potatos", 120.88));

        Object[][] shop = {
                {repository.getConsumerByIndex(0), repository.getItemByIndex(0), 2},
                {repository.getConsumerByIndex(1), repository.getItemByIndex(1), -1},
                {repository.getConsumerByIndex(0), repository.getItemByIndex(0), 159},
                {repository.getConsumerByIndex(0), repository.getItemByIndex(4), 3},
                {repository.getConsumerByIndex(1), new Item("Orange", 199.99), 3},
                {new Consumer("Egorov", "Egor", "Egorovich", Sex.MALE, "1989-12-12", "79112223344"), repository.getItemByIndex(3), 1}
        };

        int countOrders = 0;
        int indShop = 0;
        while (indShop != shop.length) {
            try {
                repository.addOrder(Shop.makeOrder(repository.getConsumers(), repository.getItems(), (Consumer) shop[indShop][0], (Item) shop[indShop][1], (Integer) shop[indShop][2]));
                countOrders++;
                System.out.println("Сделано заказов: " + countOrders);
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                repository.addOrder(Shop.makeOrder(repository.getConsumers(), repository.getItems(), (Consumer) shop[indShop][0], (Item) shop[indShop][1], 1));
                countOrders++;
                System.out.println("Сделано заказов: " + countOrders);
            } catch (CustomerException e) {
                throw new RuntimeException(e);
            }
            indShop++;
        }
        Congratulate(repository.getConsumers());
    }
}
