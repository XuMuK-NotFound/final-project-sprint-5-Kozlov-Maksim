public class StandardParcel extends Parcel{//нормис посылка
    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay,TypeParcel.STANDARD);

    }
}
