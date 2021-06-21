package org.example.service.console;

import org.example.dao.*;
import org.example.model.House;
import org.example.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class HouseServiceConsole {
    private HouseRepository houseRepository;
    private HouseService houseService;

    public HouseServiceConsole(HouseRepository houseRepository1){
        houseRepository = houseRepository1;
        houseService = new HouseService(houseRepository);
    }

    public void console() throws JsonProcessingException {
        boolean menucho = false;
        while (!menucho) {
            System.out.println("\"Now you work with House. Choose option, that you want to do: \" + \"\\n\"\n" +
                    "                        + \"1. Create\" + \"\\n\"\n" +
                    "                        + \"2. Find by Id\" + \"\\n\"\n" +
                    "                        + \"3. Update\" + \"\\n\"\n" +
                    "                        + \"4. Delete\" + \"\\n\"\n" +
                    "                        + \"5. Get info about all\" + \"\\n\"\n" +
                    "                        + \"0. Go to Main Menu\" + \"\\n\"");

            int after = ReadingService.readInt();
            switch (after) {
                case 0:
                    System.out.println("Okay, now you will return to main menu");
                    menucho = true;
                    break;
                case 1:
                    System.out.println("You chose the option to Create");
                    House coldWaterMeter = new House();
                    String street = null;
                    do
                    {
                        System.out.println("Write correct street");
                        street = ReadingService.readString();
                    } while (street == null);
                    coldWaterMeter.setStreet(street);



                    houseService.create(coldWaterMeter);
                    System.out.println("You added new House");
                    menucho = true;
                    break;
                case 2:
                    System.out.println("You chose the option to Find By Id");
                    int id = 0;
                    do
                    {
                        System.out.println("Write correct id");
                        id = ReadingService.readInt();
                    } while (id < 0);
                    House us1 = houseService.findById(id);
                    System.out.println("Here is found House");
                    System.out.println(new ObjectMapper().writeValueAsString(us1));
                    menucho = true;
                    break;
                case 3:
                    System.out.println("You chose the option to Update");

                    int id1 = 0;
                    do
                    {
                        System.out.println("Write correct id");
                        id1 = ReadingService.readInt();
                    } while (id1 < 0);
                    House us2 = houseService.findById(id1);
                    System.out.println("Here is found House");
                    System.out.println(new ObjectMapper().writeValueAsString(us2));
                    String street1 = null;
                    do
                    {
                        System.out.println("Write correct street");
                        street1 = ReadingService.readString();
                    } while (street1 == null);
                    us2.setStreet(street1);



                    houseService.update(us2);
                    System.out.println("You updated House");
                    System.out.println(new ObjectMapper().writeValueAsString(us2));
                    menucho = true;
                    break;
                case 4:
                    System.out.println("You chose the option to Delete");
                    int id2 = 0;
                    do
                    {
                        System.out.println("Write correct id");
                        id2 = ReadingService.readInt();
                    } while (id2 < 0);
                    House us3 = houseService.findById(id2);
                    System.out.println("Here is found House");
                    System.out.println(new ObjectMapper().writeValueAsString(us3));
                    System.out.println("Do you really want to delete it? Press 2 if yes and 1 if no.");
                    int ans = -1;
                    do {
                        ans = ReadingService.readInt();
                        if (ans == -1)
                            System.out.println("Choose correct option");
                    } while (ans != 1 && ans != 2);
                    if (ans == 2){
                        houseService.delete(us3);
                    }
                    menucho = true;
                    break;
                case 5:
                    System.out.println("You chose the option to Get info about all.");
                    System.out.println("All House down:");
                    List<House> resultList1 = houseService.getAll();
                    for (Object object: resultList1
                    ) {
                        System.out.println(new ObjectMapper().writeValueAsString(object));
                    }
                    menucho = true;
                    break;
                default:
                    if (!menucho)
                        System.out.println("Option was incorrect. Try to choose option another time.");
                    break;
            }
        }
    }
}
