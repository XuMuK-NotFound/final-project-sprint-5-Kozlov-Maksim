public class FragileParcel   extends Parcel implements Trackable {//хрупки посыльz

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay, TypeParcel.FRAGILE);

    }

    @Override
    void packageItem(){//+ this.trackNumber +
        System.out.println("Посылка "+ this.getDescription() + " обёрнута в защитную плёнку.");
        System.out.println("Посылка "+ this.getDescription() + " упакована.");

    }

    public void reportStatus(String newLocation){
        System.out.println("Хрупкая посылка"+ this.getDescription() + "изменила местоположение на "+  newLocation +".");

    }
}
