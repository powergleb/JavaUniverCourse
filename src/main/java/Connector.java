import org.example.dao.*;
import org.example.model.*;
import org.example.service.ReadingService;
import org.example.service.UserService;
import org.example.service.console.*;
import javax.persistence.*;
import java.io.IOException;
import java.util.List;

public class Connector {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pers");

        ApartmentRepository apartmentRepository = new ApartmentRepository(entityManagerFactory);
        ColdWaterHistoryRepository coldWaterHistoryRepository = new ColdWaterHistoryRepository(entityManagerFactory);
        ColdWaterMeterRepository coldWaterMeterRepository = new ColdWaterMeterRepository(entityManagerFactory);
        HotWaterHistoryRepository hotWaterHistoryRepository = new HotWaterHistoryRepository(entityManagerFactory);
        HotWaterMeterRepository hotWaterMeterRepository = new HotWaterMeterRepository(entityManagerFactory);
        HouseRepository houseRepository = new HouseRepository(entityManagerFactory);
        LodgerRepository lodgerRepository = new LodgerRepository(entityManagerFactory);
        PaymentOrderRepository paymentOrderRepository = new PaymentOrderRepository(entityManagerFactory);
        UserRepository userRepository = new UserRepository(entityManagerFactory);

        ApartmentServiceConsole apartmentServiceConsole = new ApartmentServiceConsole(apartmentRepository);
        ColdWaterHistoryServiceConsole coldWaterHistoryServiceConsole = new ColdWaterHistoryServiceConsole(coldWaterHistoryRepository);
        ColdWaterMeterServiceConsole coldWaterMeterServiceConsole = new ColdWaterMeterServiceConsole(coldWaterMeterRepository);
        HotWaterHistoryServiceConsole hotWaterHistoryServiceConsole = new HotWaterHistoryServiceConsole(hotWaterHistoryRepository);
        HotWaterMeterServiceConsole hotWaterMeterServiceConsole = new HotWaterMeterServiceConsole(hotWaterMeterRepository);
        HouseServiceConsole houseServiceConsole = new HouseServiceConsole(houseRepository);
        LodgerServiceConsole lodgerServiceConsole = new LodgerServiceConsole(lodgerRepository);
        PaymentOrderServiceConsole paymentOrderServiceConsole = new PaymentOrderServiceConsole(paymentOrderRepository);
        UserServiceConsole userServiceConsole = new UserServiceConsole(userRepository);

        //Console part
        boolean exit = false;
        while (!exit){
            System.out.println("Main menu:");
            System.out.println("\"Write a number, with which object you want to work: \" + \"\\n\"\n" +
                    "                        + \"1. Apartment\" + \"\\n\"\n" +
                    "                        + \"2. ColdWaterHistory\" + \"\\n\"\n" +
                    "                        + \"3. ColdWaterMeter\" + \"\\n\"\n" +
                    "                        + \"4. HotWaterHistory\" + \"\\n\"\n" +
                    "                        + \"5. HotWaterMeter\" + \"\\n\"\n" +
                    "                        + \"6. House\" + \"\\n\"\n" +
                    "                        + \"7. Lodger\" + \"\\n\"\n" +
                    "                        + \"8. PaymentOrder\" + \"\\n\"\n" +
                    "                        + \"9. User\" + \"\\n\"\n" +
                    "                        + \"0. exit\" + \"\\n\"");
            int choose = ReadingService.readInt();
            switch (choose){
                case 0:
                    System.out.println("Your work have ended");
                    exit = true;
                    break;
                case 1:
                    apartmentServiceConsole.console();
                    exit = false;
                    break;
                case 2:
                    coldWaterHistoryServiceConsole.console();
                    exit = false;
                    break;
                case 3:
                    coldWaterMeterServiceConsole.console();
                    exit = false;
                    break;
                case 4:
                    hotWaterHistoryServiceConsole.console();
                    exit = false;
                    break;
                case 5:
                    hotWaterMeterServiceConsole.console();
                    exit = false;
                    break;
                case 6:
                    houseServiceConsole.console();
                    exit = false;
                    break;
                case 7:
                    lodgerServiceConsole.console();
                    exit = false;
                    break;
                case 8:
                    paymentOrderServiceConsole.console();
                    exit = false;
                    break;
                case 9:
                    userServiceConsole.console();
                    exit = false;
                    break;
                default:
                    if (!exit)
                        System.out.println("Option was incorrect. Try to choose option another time.");
                    break;
            }
        }
    }
}
