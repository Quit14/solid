import java.util.*;

public class Purchase {
    protected String title;
    protected int count;


    /* protected Purchase[] purchases = new Purchase[4];
     4 - "магическое число", т.к. набор покупок определяется другим классом.
    Вместо этого создадим hashset в классе корзины для хранения набора уникальных продуктов*/

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }


    //создаем покупку
    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }


    //метод для подсчета количества продукта
    public void addCount(int count) {
        if (this.count + count < 0) {
            throw new IllegalArgumentException("Количество продукта не должно быть меньше нуля!");
        }
        this.count += count;
    }
}

    /* Переносим метод создания набора продуктов в класс корзины.
     Метод расчета общей суммы продуктов также переносим в класс корзины
     */
