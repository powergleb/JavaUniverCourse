package org.example.service.console;

import org.example.dao.*;
import org.example.model.PaymentOrder;
import org.example.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class PaymentOrderServiceConsole {
    private PaymentOrderRepository paymentOrderRepository;
    private PaymentOrderService paymentOrderService;

    public PaymentOrderServiceConsole(PaymentOrderRepository paymentOrderRepository1){
        paymentOrderRepository = paymentOrderRepository1;
        paymentOrderService = new PaymentOrderService(paymentOrderRepository);
    }
    public void console() throws JsonProcessingException {
        boolean menucho = false;
        while (!menucho) {
            System.out.println("\"Now you work with PaymentOrder. Choose option, that you want to do: \" + \"\\n\"\n" +
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
                    PaymentOrder coldWaterMeter = new PaymentOrder();
                    int ColdWaterPayment = 0;
                    do
                    {
                        System.out.println("Write correct ColdWaterPayment");
                        ColdWaterPayment = ReadingService.readInt();
                    } while (ColdWaterPayment < 0);
                    coldWaterMeter.setColdWaterPayment(ColdWaterPayment);

                    int hotWaterPayment = 0;
                    do
                    {
                        System.out.println("Write correct hotWaterPayment");
                        hotWaterPayment = ReadingService.readInt();
                    } while (hotWaterPayment < 0);
                    coldWaterMeter.setColdWaterPayment(hotWaterPayment);

                    int AreaPayment = 0;
                    do
                    {
                        System.out.println("Write correct setCostPerOne");
                        AreaPayment = ReadingService.readInt();
                    } while (AreaPayment < 0);
                    coldWaterMeter.setAreaPayment(AreaPayment);

                    int total = AreaPayment+hotWaterPayment+ColdWaterPayment;

                    coldWaterMeter.setTotal(total);


                    paymentOrderService.create(coldWaterMeter);
                    System.out.println("You added new PaymentOrder");
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
                    PaymentOrder us1 = paymentOrderService.findById(id);
                    System.out.println("Here is found PaymentOrder");
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
                    PaymentOrder us2 = paymentOrderService.findById(id1);
                    System.out.println("Here is found PaymentOrder");
                    System.out.println(new ObjectMapper().writeValueAsString(us2));
                    int ColdWaterPayment1 = 0;
                    do
                    {
                        System.out.println("Write correct ColdWaterPayment");
                        ColdWaterPayment1 = ReadingService.readInt();
                    } while (ColdWaterPayment1 < 0);
                    us2.setColdWaterPayment(ColdWaterPayment1);

                    int hotWaterPayment1 = 0;
                    do
                    {
                        System.out.println("Write correct hotWaterPayment");
                        hotWaterPayment1 = ReadingService.readInt();
                    } while (hotWaterPayment1 < 0);
                    us2.setColdWaterPayment(hotWaterPayment1);

                    int AreaPayment1 = 0;
                    do
                    {
                        System.out.println("Write correct setCostPerOne");
                        AreaPayment1 = ReadingService.readInt();
                    } while (AreaPayment1 < 0);
                    us2.setAreaPayment(AreaPayment1);

                    int total1 = AreaPayment1+hotWaterPayment1+ColdWaterPayment1;

                    us2.setTotal(total1);



                    paymentOrderService.update(us2);
                    System.out.println("You updated PaymentOrder");
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
                    PaymentOrder us3 = paymentOrderService.findById(id2);
                    System.out.println("Here is found PaymentOrder");
                    System.out.println(new ObjectMapper().writeValueAsString(us3));
                    System.out.println("Do you really want to delete it? Press 2 if yes and 1 if no.");
                    int ans = -1;
                    do {
                        ans = ReadingService.readInt();
                        if (ans == -1)
                            System.out.println("Choose correct option");
                    } while (ans != 1 && ans != 2);
                    if (ans == 2){
                        paymentOrderService.delete(us3);
                    }
                    menucho = true;
                    break;
                case 5:
                    System.out.println("You chose the option to Get info about all.");
                    System.out.println("All PaymentOrder down:");
                    List<PaymentOrder> resultList1 = paymentOrderService.getAll();
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
