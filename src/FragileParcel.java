public class FragileParcel   extends Parcel implements Trackable {//хрупки посыльz

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay, TypeParcel.FRAGILE);

    }

    @Override
    void packageItem(){
        System.out.println("Посылка "+ this.getTrackNumber() + " обёрнута в защитную плёнку.");
        System.out.println("Посылка "+ this.getTrackNumber() + " упакована.");

    }

    public void reportStatus(String newLocation){
        System.out.println("Хрупкая посылка"+ this.getTrackNumber() + "изменила местоположение на "+  newLocation +".");

    }
}
