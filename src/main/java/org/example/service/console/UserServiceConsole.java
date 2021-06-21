package org.example.service.console;

import org.example.Password;
import org.example.dao.*;
import org.example.model.User;
import org.example.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class UserServiceConsole {
    private UserRepository userRepository;
    private UserService userService;

    public UserServiceConsole(UserRepository userRepository1){
        userRepository = userRepository1;
        userService = new UserService(userRepository);
    }

    public void console() throws Exception {
        boolean menucho = false;
        while (!menucho) {
            System.out.println("\"Now you work with User. Choose option, that you want to do: \" + \"\\n\"\n" +
                    "                        + \"1. Create\" + \"\\n\"\n" +
                    "                        + \"2. Find by Id\" + \"\\n\"\n" +
                    "                        + \"3. Update\" + \"\\n\"\n" +
                    "                        + \"4. Delete\" + \"\\n\"\n" +
                    "                        + \"5. Get info about all\" + \"\\n\"\n" +
                    "                        + \"6. Check pass by Id\" + \"\\n\"\n" +
                    "                        + \"0. Go to Main Menu\" + \"\\n\"");

            int after = ReadingService.readInt();
            switch (after) {
                case 0:
                    System.out.println("Okay, now you will return to main menu");
                    menucho = true;
                    break;
                case 1:
                    System.out.println("You chose the option to Create");
                    User user = new User();
                    String login = null;
                    do
                    {
                        System.out.println("Write correct login");
                        login = ReadingService.readString();
                    } while (login == null);
                    user.setLogin(login);

                    String pass = null;
                    do
                    {
                        System.out.println("Write correct password");
                        pass = ReadingService.readString();
                    } while (pass == null);
                    user.setPass(pass);

                    String phone = null;
                    do
                    {
                        System.out.println("Write correct phonenumber");
                        phone = ReadingService.readString();
                    } while (phone == null);
                    user.setPhone(phone);

                    userService.create(user);
                    System.out.println("You added new user");
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
                    User us1 = userService.findById(id);
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
                    User us2 = userService.findById(id1);
                    System.out.println("Here is found user");
                    System.out.println(new ObjectMapper().writeValueAsString(us2));


                    String login1 = null;
                    do
                    {
                        System.out.println("Write correct login");
                        login1 = ReadingService.readString();
                    } while (login1 == null);
                    us2.setLogin(login1);

                    String pass1 = null;
                    do
                    {
                        System.out.println("Write correct password");
                        pass1 = ReadingService.readString();
                    } while (pass1 == null);
                    us2.setPass(pass1);

                    String phone1 = null;
                    do
                    {
                        System.out.println("Write correct phonenumber");
                        phone1 = ReadingService.readString();
                    } while (phone1 == null);
                    us2.setPhone(phone1);


                    userService.update(us2);
                    System.out.println("You updated user");
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
                    User us3 = userService.findById(id2);
                    System.out.println("Here is found user");
                    System.out.println(new ObjectMapper().writeValueAsString(us3));
                    System.out.println("Do you really want to delete it? Press 2 if yes and 1 if no.");
                    int ans = -1;
                    do {
                        ans = ReadingService.readInt();
                        if (ans == -1)
                            System.out.println("Choose correct option");
                    } while (ans != 1 && ans != 2);
                    if (ans == 2){
                        userService.delete(us3);
                    }
                    menucho = true;
                    break;
                case 5:
                    System.out.println("You chose the option to Get info about all.");
                    System.out.println("All user down:");
                    List<User> resultList1 = userService.getAll();
                    for (Object object: resultList1
                    ) {
                        System.out.println(new ObjectMapper().writeValueAsString(object));
                    }
                    menucho = true;
                    break;
                case 6:
                    System.out.println("You chose the option to Check pass By Id");
                    int id3 = 0;
                    do
                    {
                        System.out.println("Write correct id");
                        id3 = ReadingService.readInt();
                    } while (id3 < 0);
                    User us4 = userService.findById(id3);
                    System.out.println("Here is found user");
                    System.out.println(new ObjectMapper().writeValueAsString(us4));
                    String pass2 = null;
                    do
                    {
                        System.out.println("Write check password");
                        pass2 = ReadingService.readString();
                    } while (pass2 == null);
                    if(us4 != null) {
                        if (Password.check(pass2, us4.getPass()))
                            System.out.println("Passwords are equal");
                        else
                            System.out.println("Wrong password");
                    }
                    else
                        System.out.println("No such user");
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
