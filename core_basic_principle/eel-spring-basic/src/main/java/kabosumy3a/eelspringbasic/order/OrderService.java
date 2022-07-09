package kabosumy3a.eelspringbasic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
