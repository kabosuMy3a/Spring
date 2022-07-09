package kabosumy3a.eelspringbasic.order;
//Entity

public class Order {

    private Long memberId ;
    private String itemName ;
    private int itemPrice ;
    private int discountPrice ;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        if(itemPrice - discountPrice >= 0)
            return itemPrice - discountPrice ;
        return 0 ;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString(){
        return "Order{" +
                "memberID= " + memberId +
                ", itemName \'"+ itemName + '\'' +
                ", itemPrice " + itemPrice +
                ", discountPrice= " + discountPrice +
                '}';
    }

}
