public class PerishableParcel  extends Parcel{//бессмертны посыл
    final private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, TypeParcel.PERISHABLE);
        this.timeToLive = timeToLive;

    }
    boolean isExpired(int currentDay){
        return !((this.getSendDay() + timeToLive) >= currentDay);
    }
}
