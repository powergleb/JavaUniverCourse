package org.example.service.console;

import org.example.dao.ApartmentRepository;
import org.example.model.Apartment;
import org.example.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ApartmentServiceConsole {
    private ApartmentRepository apartmentRepository;
    private ApartmentService apartmentService;

    public ApartmentServiceConsole(ApartmentRepository apartmentRepository1){
        apartmentRepository = apartmentRepository1;
        apartmentService = new ApartmentService(apartmentRepository);
    }

    public void console() throws JsonProcessingException {
        boolean menucho = false;
        while (!menucho) {
            System.out.println("\"Now you work with Apartment. Choose option, that you want to do: \" + \"\\n\"\n" +
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
                    Apartment apartment = new Apartment();
                    int area = 0;

                    do
                    {
                        System.out.println("Write correct area");
                        area = ReadingService.readInt();
                    } while (area < 0);
                    apartment.setArea(area);
                    int credit = 0;
                    do
                    {
                        System.out.println("Write correct credit");
                        credit = ReadingService.readInt();
                    } while (credit < 0);
                    apartment.setCredit(credit);
                    apartmentService.create(apartment);

                    System.out.println("You added new Apartment");
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
                    Apartment us1 = apartmentService.findById(id);
                    System.out.println("Here is found stock");
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
                    Apartment us2 = apartmentService.findById(id1);
                    System.out.println("Here is found Apartment");
                    System.out.println(new ObjectMapper().writeValueAsString(us2));
                    int credit1 = 0;
                    do
                    {
                        System.out.println("Write correct credit");
                        credit1 = ReadingService.readInt();
                    } while (credit1 < 0);
                    us2.setCredit(credit1);
                    int area1 = 0;
                    do
                    {
                        System.out.println("Write correct area");
                        area1 = ReadingService.readInt();
                    } while (area1 < 0);
                    us2.setArea(area1);
                    apartmentService.update(us2);
                    System.out.println("You updated Apartment");
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
                    Apartment us3 = apartmentService.findById(id2);
                    System.out.println("Here is found apartment");
                    System.out.println(new ObjectMapper().writeValueAsString(us3));
                    System.out.println("Do you really want to delete it? Press 2 if yes and 1 if no.");
                    int ans = -1;
                    do {
                        ans = ReadingService.readInt();
                        if (ans == -1)
                            System.out.println("Choose correct option");
                    } while (ans != 1 && ans != 2);
                    if (ans == 2){
                        apartmentService.delete(us3);
                    }
                    menucho = true;
                    break;
                case 5:
                    System.out.println("You chose the option to Get info about all.");
                    System.out.println("All ColdWaterHistory down:");
                    List<Apartment> resultList1 = apartmentService.getAll();
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



