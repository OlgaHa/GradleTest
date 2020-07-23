package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChatFeatures {

    public String chat(Scanner scanner) throws Throwable {
        String lastAnswer = "";
        System.out.println("What's your date of birth ? (Please, input as dd-MM-yyyy)");
        String date = scanner.nextLine();

        if (checkIfDateIsValid(date)) {
            LocalDate localDate = convertStringToDate(date);

            String inputSign = getSignByDate(localDate.getDayOfMonth(), localDate.getMonthValue());

            AstroSign sign = getAstroSign(inputSign);

            int signNumber = sign.ordinal();

            System.out.println(sign.name() + "? Oh, so you must be " + sign.getDesription());
            System.out.println("Want to know your August 2020 Horoscope? Y/N?");


            String input = scanner.nextLine();

            while (isInputInvalid(input)) {
                input = scanner.nextLine();
            }

            if (input.equalsIgnoreCase("y")) {
                String horoscope = getHoroscope(sign.ordinal());
                System.out.println(horoscope);
                System.out.println("Do you want to continue and check another date? Y/N");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("n")) {
                    lastAnswer = "n";
                } else {
                    lastAnswer = "";
                }
            } else {
                lastAnswer = "n";
            }
        }
        return lastAnswer;
    }

    protected String getHoroscope(int signNumber) {
        String horoscope = "";
        try {
            horoscope = Files.readAllLines(Paths.get("astrofile.txt")).get(signNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return horoscope;
    }

    protected AstroSign getAstroSign(String inputSign) {
        return AstroSign.valueOf(inputSign);
    }

    protected boolean checkIfDateIsValid(String date) {
        try {
            LocalDate localDate = convertStringToDate(date);
            return true;
        } catch (Throwable t) {
            System.out.println("Error!  " + t.getMessage());
            return false;
        }
    }

    protected boolean isInputInvalid(String input) {
        boolean result = false;
        if (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
            System.out.println("Sorry, I understand only Y or N. Should I tell your August Horoscope?");
            result = true;
        }
        return result;
    }


    protected String getSignByDate(int day, int month) {
        String astrosign = "";
        if ((day > 21 && month == 12) || (day <= 19 && month == 1)) {
            astrosign = "Capricorn";
        }
        if ((day > 20 && month == 1) || (day <= 18 && month == 2)) {
            astrosign = "Aquarius";
        }
        if ((day > 19 && month == 2) || (day <= 20 && month == 3)) {
            astrosign = "Pisces";
        }
        if ((day > 21 && month == 3) || (day <= 20 && month == 4)) {
            astrosign = "Aries";
        }
        if ((day > 21 && month == 4) || (day <= 20 && month == 5)) {
            astrosign = "Taurus";
        }
        if ((day > 21 && month == 5) || (day <= 20 && month == 6)) {
            astrosign = "Gemini";
        }
        if ((day > 21 && month == 6) || (day <= 20 && month == 7)) {
            astrosign = "Cancer";
        }
        if ((day > 21 && month == 7) || (day <= 20 && month == 8)) {
            astrosign = "Leo";
        }
        if ((day > 21 && month == 8) || (day <= 22 && month == 9)) {
            astrosign = "Virgo";
        }
        if ((day > 23 && month == 9) || (day <= 20 && month == 10)) {
            astrosign = "Libra";
        }
        if ((day > 21 && month == 10) || (day <= 22 && month == 11)) {
            astrosign = "Scorpio";
        }
        if ((day > 23 && month == 11) || (day <= 20 && month == 12)) {
            astrosign = "Sagittarius";
        }
        return astrosign.toUpperCase();
    }

    protected LocalDate convertStringToDate(String date) {
        LocalDate localDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            localDate = LocalDate.parse(date, formatter);
        } catch (Throwable t) {
            throw new RuntimeException("Unable to create date time from: [" +
                    date + "], please enter with format [dd-MM-yyyy], " + t.getMessage());
        }
        return localDate;
    }
}
