package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    // Constructor
    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date provided.");
        }
    }

    private boolean isValidDate(int d, int m, int y) {
        if (m < 1 || m > 12 || d < 1) return false;

        int[] daysInMonth = {0, 31, isLeapYear(y) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return d <= daysInMonth[m];
    }

    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    public void updateDate(int d, int m, int y) {
        if (isValidDate(d, m, y)) {
            this.day = d;
            this.month = m;
            this.year = y;
        } else {
            System.out.println("Invalid date update attempt.");
        }
    }

    public String getDayOfWeek() {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    public int calculateDifference(Date otherDate) {
        LocalDate date1 = LocalDate.of(this.year, this.month, this.day);
        LocalDate date2 = LocalDate.of(otherDate.year, otherDate.month, otherDate.day);
        return (int) ChronoUnit.DAYS.between(date1, date2);
    }

    public void printDate() {
        LocalDate date = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(date.format(formatter));
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }
}

