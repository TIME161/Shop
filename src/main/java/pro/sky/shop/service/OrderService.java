package pro.sky.shop.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pro.sky.shop.exceptions.IncorrectIdException;
import pro.sky.shop.model.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope(WebApplicationContext.SCOPE_SESSION)
public class OrderService {
    List<Storage> storages = new ArrayList<>(List.of(
            new Storage(0, "Chicken"),
            new Storage(1, "Fish"),
            new Storage(2, "Goat"),
            new Storage(3, "Bear"),
            new Storage(4, "Hedgehog")));

    Map<String, Integer> basket = new HashMap<>();

    public String helloText() {
        return "Добро пожаловать в магазин, вы можете приобрести следующие наименования товара:" + storages.toString();
    }

    public String add(List<Integer> ids) {
        String answer = "Товар добавлен";
        if (ids.size() > 1) {
            answer = "Товары добавлены";
        } else if (ids.size() == 0) {
            throw new IncorrectIdException("Вы не выбрали товар");
        }
        for (Integer id : ids) {
            if (!basket.containsKey(storages.get(id).getNameOfProduct())) {
                basket.put(storages.get(id).getNameOfProduct(), 1);
            } else if (basket.containsKey(storages.get(id).getNameOfProduct())) {
                basket.replace(storages.get(id).getNameOfProduct(), basket.get(storages.get(id).getNameOfProduct()),
                        basket.get(storages.get(id).getNameOfProduct()) + 1);
            }
        }
        return answer;
    }

    public Map<String, Integer> get() {
        return basket;
    }
}