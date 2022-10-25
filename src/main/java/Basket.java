//Создадим отдельный класс для подсчета покупок

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Basket {
    protected Set<Purchase> purchases = new HashSet<>();

    public Basket() {
    }

    public void addPurchase(String title, int count) {
        boolean add = purchases.stream().noneMatch(purchase -> purchase.getTitle().equals(title));
        if (purchases.isEmpty() || add) {
            purchases.add(new Purchase(title, count));
            return;
        }
        for (Purchase purchase: purchases) {
            if(purchase.getTitle().equals(title)){
                purchase.addCount(count);
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        if (!purchases.isEmpty()) {
            System.out.println("КОРЗИНА:");
            for (Purchase purchase : purchases) {
                System.out.println("\t" + purchase.getTitle() + " "
                        + purchase.getCount() + " шт. в сумме "
                        + (purchase.getCount() * prices.get(purchase.title)) + " руб.");
                sum += purchase.getCount() * prices.get(purchase.title);
            }
        }
        return sum;
    }
}
