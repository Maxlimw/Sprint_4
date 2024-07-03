package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practicum.pom.AboutRentalPage;
import ru.practicum.pom.MainPage;
import ru.practicum.pom.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderAndRentalPageTest extends BasicTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String number;
    private final String deliveryDate;
    private final String colour;
    private final String comment;
    private MainPage mainPage;
    private OrderPage orderPage;
    private AboutRentalPage aboutRentalPage;

    public OrderAndRentalPageTest(String name, String surname, String address,
                                  String metro, String number, String deliveryDate,
                                  String colour, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.number = number;
        this.deliveryDate = deliveryDate;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Зурам", "Матовозкин", "ул. Бубенчик, 1", "Митино", "+79251231212", "03.07.2024", "black", "гоооол"},
                {"Кринжубас", "Албулаев", "опа 1123", "Технопарк", "+79251941212", "05.07.2024", "grey", "бабобой"},
                {"Алексей", "Сидоров", "улица Ленина дом 5", "Измайловская", "+79252451212", "04.04.2004", "black", "флоу"}
        };
    }


    @Test
    public void topOrderButtonTest() {
        setUpOrderAndRental();
        mainPage.clickTopOrderButton();
        assertTrue(orderPage.isOrderPageOpened());
        orderPage.fillOrderForm(name, surname, address, metro, number);
        assertTrue(orderPage.isOrderHeaderVisible());
        aboutRentalPage.fillRentalForm(deliveryDate, colour, comment);
        aboutRentalPage.clickOrderButton();
        aboutRentalPage.clickConfirmationButton();
        assertTrue(aboutRentalPage.isRentalPopUpVisible());
    }

    @Test
    public void bottomOrderButtonTest() {
        setUpOrderAndRental();
        mainPage.clickBottomOrderButton();
        assertTrue(orderPage.isOrderPageOpened());
        orderPage.fillOrderForm(name, surname, address, metro, number);
        assertTrue("Ошибка отображения",orderPage.isOrderHeaderVisible());
        aboutRentalPage.fillRentalForm(deliveryDate, colour, comment);
        aboutRentalPage.clickOrderButton();
        aboutRentalPage.clickConfirmationButton();
        assertTrue("Ошибка отображения поп-апа успешного окна", aboutRentalPage.isRentalPopUpVisible());
    }

    public void setUpOrderAndRental() {
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        aboutRentalPage = new AboutRentalPage(driver);
    }
}
