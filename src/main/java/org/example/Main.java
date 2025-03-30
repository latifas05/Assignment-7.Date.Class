package org.example;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try {
            Date date1 = new Date(15, 8, 2020);
            Date date2 = new Date(1, 1, 2023);
            Date date3 = new Date(29, 2, 2024);
            Date date4 = new Date(5, 5, 2019);

            // Printing dates
            System.out.print("Date 1: ");
            date1.printDate();
            System.out.print("Date 2: ");
            date2.printDate();
            System.out.print("Date 3: ");
            date3.printDate();
            System.out.print("Date 4: ");
            date4.printDate();

            System.out.println("Day of the week for Date 1: " + date1.getDayOfWeek());

            date1.updateDate(10, 10, 2021);
            System.out.print("Updated Date 1: ");
            date1.printDate();

            int diff = date1.calculateDifference(date2);
            System.out.println("Difference between Date 1 and Date 2: " + diff + " days");

            ArrayList<Date> dateList = new ArrayList<>();
            dateList.add(date1);
            dateList.add(date2);
            dateList.add(date3);
            dateList.add(date4);

            Collections.sort(dateList);

            System.out.println("Sorted Dates:");
            for (Date d : dateList) {
                d.printDate();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
