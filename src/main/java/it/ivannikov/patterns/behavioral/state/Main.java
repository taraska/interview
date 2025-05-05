package it.ivannikov.patterns.behavioral.state;

/*
Определение: Позволяет объекту менять поведение при изменении состояния.
Пример: Состояние заказа (новый, оплачен, доставлен).
* */
interface OrderState {
    void next(Order order);
}

class NewOrder implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new PaidOrder());
        System.out.println("Заказ оплачен");
    }
}

class DeliveredOrder implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Заказ доставлен");
    }
}

class PaidOrder implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new DeliveredOrder());
        System.out.println("Заказ доставлен");
    }
}

class Order {
    private OrderState state = new NewOrder();

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }
}



public class Main {
    public static void main(String[] args) {
        // Использование:
        Order order = new Order();
        order.nextState(); // Оплачен
        order.nextState(); // Доставлен
    }
}
