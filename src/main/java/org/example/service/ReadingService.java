package org.example.service;

import java.util.Scanner;

public class ReadingService {

    public static int readInt(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        }
        else return -1;
    }

    public static Double readDouble(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()){
            return scanner.nextDouble();
        }
        else return null;
    }

    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()){
            return scanner.nextLine();
        }
        else return null;
    }

}
