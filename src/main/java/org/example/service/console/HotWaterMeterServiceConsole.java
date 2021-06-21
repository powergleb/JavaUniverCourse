package org.example.service.console;

import org.example.dao.*;
import org.example.model.HotWaterMeter;
import org.example.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class HotWaterMeterServiceConsole {
    private HotWaterMeterRepository hotWaterMeterRepository;
    private HotWaterMeterService hotWaterMeterService;

    public HotWaterMeterServiceConsole(HotWaterMeterRepository hotWaterMeterRepository1){
        hotWaterMeterRepository = hotWaterMeterRepository1;
        hotWaterMeterService = new HotWaterMeterService(hotWaterMeterRepository);
    }

    public void console() throws JsonProcessingException {
        boolean menucho = false;
        while (!menucho) {
            System.out.println("\"Now you work with HotWaterMeter. Choose option, that you want to do: \" + \"\\n\"\n" +
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
                    HotWaterMeter coldWaterMeter = new HotWaterMeter();
                    int value = 0;
                    do
                    {
                        System.out.println("Write correct value");
                        value = ReadingService.readInt();
                    } while (value < 0);
                    coldWaterMeter.setValue(value);

                    int setCostPerOne = 0;
                    do
                    {
                        System.out.println("Write correct setCostPerOne");
                        setCostPerOne = ReadingService.readInt();
                    } while (setCostPerOne < 0);
                    coldWaterMeter.setCostPerOne(setCostPerOne);

                    int LastCheckDate = 0;
                    do
                    {
                        System.out.println("Write correct LastCheckDate");
                        LastCheckDate = ReadingService.readInt();
                    } while (LastCheckDate < 0);
                    coldWaterMeter.setLastCheckDate(LastCheckDate);


                    hotWaterMeterService.create(coldWaterMeter);
                    System.out.println("You added new HotWaterMeter");
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
                    HotWaterMeter us1 = hotWaterMeterService.findById(id);
                    System.out.println("Here is found ColdWaterMeter");
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
                    HotWaterMeter us2 = hotWaterMeterService.findById(id1);
                    System.out.println("Here is found HotWaterMeter");
                    System.out.println(new ObjectMapper().writeValueAsString(us2));
                    int value1 = 0;
                    do
                    {
                        System.out.println("Write correct value");
                        value1 = ReadingService.readInt();
                    } while (value1 < 0);
                    us2.setValue(value1);

                    int setCostPerOne1 = 0;
                    do
                    {
                        System.out.println("Write correct setCostPerOne");
                        setCostPerOne1 = ReadingService.readInt();
                    } while (setCostPerOne1 < 0);
                    us2.setCostPerOne(setCostPerOne1);

                    int LastCheckDate1 = 0;
                    do
                    {
                        System.out.println("Write correct LastCheckDate");
                        LastCheckDate1 = ReadingService.readInt();
                    } while (LastCheckDate1 < 0);
                    us2.setLastCheckDate(LastCheckDate1);



                    hotWaterMeterService.update(us2);
                    System.out.println("You updated HotWaterMeter");
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
                    HotWaterMeter us3 = hotWaterMeterService.findById(id2);
                    System.out.println("Here is found HotWaterMeter");
                    System.out.println(new ObjectMapper().writeValueAsString(us3));
                    System.out.println("Do you really want to delete it? Press 2 if yes and 1 if no.");
                    int ans = -1;
                    do {
                        ans = ReadingService.readInt();
                        if (ans == -1)
                            System.out.println("Choose correct option");
                    } while (ans != 1 && ans != 2);
                    if (ans == 2){
                        hotWaterMeterService.delete(us3);
                    }
                    menucho = true;
                    break;
                case 5:
                    System.out.println("You chose the option to Get info about all.");
                    System.out.println("All HotWaterMeter down:");
                    List<HotWaterMeter> resultList1 = hotWaterMeterService.getAll();
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
