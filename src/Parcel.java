abstract class Parcel {
    final private String description;
    final private int weight;
    final private String deliveryAddress;
    final private int sendDay;

    //Для индивидуального трек номера заказа
    final private String trackNumber;
    final private int orderNumber;
    static int countOrderNumbers = 0;

    TypeParcel typeParcel;

    Parcel(String description, int weight, String deliveryAddress, int sendDay, TypeParcel typeParcel) {
        countOrderNumbers++;
        this.orderNumber = countOrderNumbers;
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.trackNumber = setTrackNumber(typeParcel, this.orderNumber);
        this.typeParcel = typeParcel;
    }

    // для  FragileParcel класса геттер
    public String getTrackNumber() {
        return trackNumber;
    }

    void packageItem() {
        System.out.println("Посылка " + this.trackNumber + " упакована.");
    }


    public String setTrackNumber(TypeParcel typeParcel, int orderNumber) {
        String prefix = switch (typeParcel) {
            case STANDARD -> "STA";
            case FRAGILE -> "FRA";
            case PERISHABLE -> "PER";
        };
        return prefix + orderNumber;

    }
    void deliver(){
        System.out.println("Посылка "+ this.trackNumber + " доставлена по адресу "+  this.deliveryAddress +".");
    }

    int calculateDeliveryCost(){
        int cost = switch (this.typeParcel) {
            case STANDARD ->  2 ;
            case FRAGILE-> 3;
            case PERISHABLE ->  4;
            default ->  999;
        };
        return cost* weight ;
    }
}
