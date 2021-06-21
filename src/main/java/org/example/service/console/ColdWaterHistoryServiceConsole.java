package org.example.service.console;

import org.example.dao.*;
import org.example.model.ColdWaterHistory;
import org.example.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ColdWaterHistoryServiceConsole {
    private ColdWaterHistoryRepository coldWaterHistoryRepository;
    private ColdWaterHistoryService coldWaterHistoryService;

    public ColdWaterHistoryServiceConsole(ColdWaterHistoryRepository coldWaterHistoryRepository1){
        coldWaterHistoryRepository = coldWaterHistoryRepository1;
        coldWaterHistoryService = new ColdWaterHistoryService(coldWaterHistoryRepository);
    }
    public void console() throws JsonProcessingException {
        boolean menucho = false;
        while (!menucho) {
            System.out.println("\"Now you work with ColdWaterHistory. Choose option, that you want to do: \" + \"\\n\"\n" +
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
                    ColdWaterHistory coldWaterHistory = new ColdWaterHistory();
                    int lastMonthDate = 0;
                    do
                    {
                        System.out.println("Write correct lastMonthDate");
                        lastMonthDate = ReadingService.readInt();
                    } while (lastMonthDate < 0);
                    coldWaterHistory.setLastMonthDate(lastMonthDate);

                    int NewMonthDate = 0;
                    do
                    {
                        System.out.println("Write correct NewMonthDate");
                        NewMonthDate = ReadingService.readInt();
                    } while (NewMonthDate < 0);
                    coldWaterHistory.setNewMonthDate(NewMonthDate);

                    int LastMonthValue = 0;
                    do
                    {
                        System.out.println("Write correct LastMonthValue");
                        LastMonthValue = ReadingService.readInt();
                    } while (LastMonthValue < 0);
                    coldWaterHistory.setLastMonthValue(LastMonthValue);

                    int NewMonthValue = 0;
                    do
                    {
                        System.out.println("Write correct NewMonthValue");
                        NewMonthValue = ReadingService.readInt();
                    } while (NewMonthValue < 0);
                    coldWaterHistory.setNewMonthValue(NewMonthValue);


                    coldWaterHistoryService.create(coldWaterHistory);
                    System.out.println("You added new coldWaterHistory");
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
                    ColdWaterHistory us1 = coldWaterHistoryService.findById(id);
                    System.out.println("Here is found coldWaterHistory");
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
                    ColdWaterHistory us2 = coldWaterHistoryService.findById(id1);
                    System.out.println("Here is found ColdWaterHistory");
                    System.out.println(new ObjectMapper().writeValueAsString(us2));
                    int lastMonthDate1 = 0;
                    do
                    {
                        System.out.println("Write correct lastMonthDate");
                        lastMonthDate = ReadingService.readInt();
                    } while (lastMonthDate < 0);
                    us2.setLastMonthDate(lastMonthDate);

                    int NewMonthDate1 = 0;
                    do
                    {
                        System.out.println("Write correct NewMonthDate");
                        NewMonthDate = ReadingService.readInt();
                    } while (NewMonthDate < 0);
                    us2.setNewMonthDate(NewMonthDate);

                    int LastMonthValue1 = 0;
                    do
                    {
                        System.out.println("Write correct LastMonthValue");
                        LastMonthValue1 = ReadingService.readInt();
                    } while (LastMonthValue1 < 0);
                    us2.setLastMonthValue(LastMonthValue1);

                    int NewMonthValue1 = 0;
                    do
                    {
                        System.out.println("Write correct NewMonthValue");
                        NewMonthValue1 = ReadingService.readInt();
                    } while (NewMonthValue1 < 0);
                    us2.setNewMonthValue(NewMonthValue1);


                    coldWaterHistoryService.update(us2);
                    System.out.println("You updated ColdWaterHistory");
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
                    ColdWaterHistory us3 = coldWaterHistoryService.findById(id2);
                    System.out.println("Here is found ColdWaterHistory");
                    System.out.println(new ObjectMapper().writeValueAsString(us3));
                    System.out.println("Do you really want to delete it? Press 2 if yes and 1 if no.");
                    int ans = -1;
                    do {
                        ans = ReadingService.readInt();
                        if (ans == -1)
                            System.out.println("Choose correct option");
                    } while (ans != 1 && ans != 2);
                    if (ans == 2){
                        coldWaterHistoryService.delete(us3);
                    }
                    menucho = true;
                    break;
                case 5:
                    System.out.println("You chose the option to Get info about all.");
                    System.out.println("All ColdWaterHistory down:");
                    List<ColdWaterHistory> resultList1 = coldWaterHistoryService.getAll();
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
