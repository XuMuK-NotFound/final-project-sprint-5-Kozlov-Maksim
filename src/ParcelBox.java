
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private int maxWeight;
    private int boxWeight;
    List<T> boxWithParcel;

    //int countMax = 0; хотел сделать счетчик что бы он не предупреждал 1000 раз будь 1000 посылок
    // но не стал времени нет.
    public ParcelBox(int maxWeight, List<T> boxWithParcel) {
        this.maxWeight = maxWeight;
        this.boxWithParcel = boxWithParcel;
    }

    void addParcel(T parcelInBox) {
        if (parcelInBox == null) return;

        if (this.boxWeight + parcelInBox.getWeight() > this.maxWeight) {
            System.out.println("Превышен лимит веса! Посылка " +
                    parcelInBox.getDescription() + " не поместилась.");
            return;
        }

        this.boxWeight += parcelInBox.getWeight();
        this.boxWithParcel.add(parcelInBox);
    }


    void getAllParcels() {
        int i = 0;
        for (T parcelFromBox : this.boxWithParcel) {
            i++;
            System.out.println(i + ". " + parcelFromBox.getDescription());
        }
    }

    public int getBoxWeight() {
        return boxWeight;
    }

    public List<T> getBoxWithParcel() {
        return boxWithParcel;
    }

    void fillBox(List<Parcel> allParcels, TypeParcel type) {
        for (Parcel parcel : allParcels) {// ОДНИМ ЗАЙЕМ ДВУХ ВЫСТРЕЛОВ
            int i = 1;
            if (parcel.getTypeParcel() != type) {
                continue;
            }
            addParcel((T) parcel);
        }

    }
}
