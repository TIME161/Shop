package pro.sky.shop.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pro.sky.shop.exceptions.IncorrectIdException;
import pro.sky.shop.service.OrderService;

import java.util.List;
import java.util.Map;

@RestController
@Scope(WebApplicationContext.SCOPE_SESSION)
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService = new OrderService();

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IncorrectIdException.class)
    public String handleException(IncorrectIdException e) {
        return String.format("%s", e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String handleException(IndexOutOfBoundsException e) {
        return String.format("%s", "Товар не найден");
    }

    @RequestMapping("")
    public String hello() {
        return orderService.helloText();
    }
    @RequestMapping("/add")
    public String add(@RequestParam("id") List<Integer> ids) {
        return orderService.add(ids);
    }

    @RequestMapping("/get")
    public Map<String, Integer> get() {
        return orderService.get();
    }
}