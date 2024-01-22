import java.beans.Customizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    создать статический метод “совершить покупку” со строковыми
//    параметрами, соответствующими полям объекта заказа. Метод
//    должен вернуть объект заказа
    public static boolean isInArray(Object[] a, Object b){
            for (Object elem: a){
                if (elem.equals(b)){
                    return true;
                }
            }
        return false;
    }
    public static Order makeOrder(Consumer[] consumers, Item[] items, Consumer consumer, Item item, Integer count){
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
    public static void main(String[] args) {
        Consumer[] consumers = {
                new Consumer("Fedorov", "Ilya", "Vladimirovich", "2000-12-01", "79990000000"),
                new Consumer("Titova", "Tanya", "Vladimirovna", "1995-11-11", "79009999999")};
//        consumers.add(new Consumer("Kirov", "Lesha", "Igorevich", "1987-08-18", "79119997788"));
        Item[] items = {
                new Item("Milk", 101.90),
                new Item("Sugar", 87.99),
                new Item("cucumber", 290.90),
                new Item("salt", 44.77),
                new Item("potatos", 120.88)};
        Order[] orders = new Order[5];
        Object[][] shop = {
                {consumers[0], items[0], 2},
                {consumers[1], items[1], -1},
                {consumers[0], items[0], 159},
                {consumers[0], items[4], 3},
                {consumers[1], new Item("Orange", 199.99), 3},
                {new Consumer("Egorov", "Egor", "Egorovich", "1989-12-12", "79112223344"), items[3], 1}
        };
        int countOrders = 0;
        int indShop = 0;
        while (countOrders != orders.length -1 || indShop != shop.length) {
            try {
                orders[countOrders] = makeOrder(consumers, items, (Consumer) shop[indShop][0], (Item) shop[indShop][1], (Integer) shop[indShop][2]);
                countOrders++;
                System.out.println("Сделано заказов: " + countOrders);
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                orders[countOrders] = (makeOrder(consumers, items, (Consumer) shop[indShop][0], (Item) shop[indShop][1], 1));
                countOrders++;
                System.out.println("Сделано заказов: " + countOrders);
            } catch (CustomerException e) {
                throw new RuntimeException(e);
            }
            indShop++;
        }

    }
}
