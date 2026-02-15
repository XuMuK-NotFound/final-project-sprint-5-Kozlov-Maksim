import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class DeliveryTest {
    //Проверяют Буквально только Вычисление стоимости посылки для каждого типа посылок
    @Test
    void shouldCalculateCostForStandard() {
        // Вес 5, тариф для Standard = 2. Итого 5 * 2 = 10
        StandardParcel parcel = new StandardParcel("Книга", 5, "Москва", 1);

        Assertions.assertEquals(10, parcel.calculateDeliveryCost());
    }

    @Test
    void shouldCalculateCostForFragile() {
        // Вес 3, тариф для Fragile = 3. Итого 3 * 3 = 9
        FragileParcel parcel = new FragileParcel("Ваза", 3, "Тверь", 2);

        Assertions.assertEquals(9, parcel.calculateDeliveryCost());
    }

    @Test
    void shouldCalculateCostForPerishable() {
        // Вес 2, тариф для Perishable = 4. Итого 2 * 4 = 8
        PerishableParcel parcel = new PerishableParcel("Молоко", 2, "Уфа", 3, 5);

        Assertions.assertEquals(8, parcel.calculateDeliveryCost());
    }

    @Test
    void shouldReturnFalseIfParcelIsNotExpired() {
        PerishableParcel f1 = new PerishableParcel("Молоко", 1,
                "Тверь", 7, 7);
        int testDay = 10;

        Assertions.assertFalse(f1.isExpired(testDay));
    }

    @Test
    void shouldBeFalseOnTheLastDayOfExpiration() {
        PerishableParcel f1 = new PerishableParcel("Молоко", 1,
                "Тверь", 7, 7);
        int testDay = 14;

        Assertions.assertFalse(f1.isExpired(testDay));
    }

    @Test
    void shouldReturnTrueIfParcelIsExpired() {
        PerishableParcel f1 = new PerishableParcel("Молоко", 1,
                "Тверь", 7, 7);
        int testDay = 15;

        Assertions.assertTrue(f1.isExpired(testDay));
    }

    @Test
    void shouldAddParcelIfWeightIsUnderLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10, new ArrayList<>());
        StandardParcel p = new StandardParcel("Книга", 5, "Москва", 1);

        box.addParcel(p);

        Assertions.assertEquals(1, box.getBoxWithParcel().size());
        Assertions.assertEquals(5, box.getBoxWeight());

    }


    @Test
    void shouldNotAddParcelIfWeightExceedsLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5, new ArrayList<>()); // Лимит всего 5
        StandardParcel heavyParcel = new StandardParcel("Гантель", 10, "Омск", 1);

        box.addParcel(heavyParcel);

        // Проверяем, что в списке пусто, а вес остался 0 (или не изменился)
        Assertions.assertEquals(0, box.getBoxWithParcel().size(), "Посылка не должна была добавиться!");
        Assertions.assertNotEquals(10, box.getBoxWeight());
    }

/* опять немного перестарался
    private List<Parcel> createParcelList(int weight1, int weight2, int weight3,
                                          int weight4, int weight5, int weight6) {
        List<Parcel> allParcels = new ArrayList<>();
        allParcels.add(new StandardParcel("Книга", weight1, "Москва", 1));
        allParcels.add(new StandardParcel("Одежда", weight2, "Санкт-Петербург", 2));
        allParcels.add(new FragileParcel("Ваза", weight3, "Екатеринбург", 4));
        allParcels.add(new FragileParcel("Зеркало", weight4, "Новосибирск", 5));
        allParcels.add(new PerishableParcel("Молоко", weight5, "Тверь", 7, 5));
        allParcels.add(new PerishableParcel("Торт", weight6, "Уфа", 8, 3));
        return allParcels;
    }

    @Test
    public void shouldCalculateTotalCostForAllParcelTypes1coin() {
        List<Parcel> allParcels = createParcelList(1, 1, 1, 1, 1, 1);
        int testSum = 18;
        int resultSum = 0;

        for (Parcel parcel : allParcels) {
            resultSum = resultSum + parcel.calculateDeliveryCost();
        }

        Assertions.assertEquals(testSum, resultSum);
    }

    @Test
    public void shouldCalculateTotalCostForAllParcelTypesNormal() {
        List<Parcel> allParcels = createParcelList(2, 5, 3, 10, 1, 2);

        int testSum = 65;
        int resultSum = 0;

        for (Parcel parcel : allParcels) {
            resultSum = resultSum + parcel.calculateDeliveryCost();
        }

        Assertions.assertEquals(testSum, resultSum);
    }


    @Test
    public void shouldCalculateTotalCostForAllParcelTypesIfWasZeroWeight() {
        List<Parcel> allParcels = createParcelList(1, 1, 0, 0, 0, 0);

        int testSum = 4;
        int resultSum = 0;

        for (Parcel parcel : allParcels) {
            resultSum = resultSum + parcel.calculateDeliveryCost();
        }

        Assertions.assertEquals(testSum, resultSum);
    }



*/
}



