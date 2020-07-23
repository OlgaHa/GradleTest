package com.company;

import com.company.AstroSign;
import com.company.ChatFeatures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ChatFeaturesTest should")
class ChatFeaturesTest {
    private ChatFeatures ch = new ChatFeatures();


    @Test
    void returnTrueIfDateIsValid() {
        String date = "10-10-2000";
        boolean result = ch.checkIfDateIsValid(date);
        assertTrue(result);
    }

    @Test
    void returnFalseIfDateIsInvalid() {
        String date = "10-15-2000";
        boolean result = ch.checkIfDateIsValid(date);
        assertFalse(result);
    }


    @Test
    void convertStringToAstroSignEnum() {
        String sigh = "leo";
        AstroSign as = ch.getAstroSign(sigh.toUpperCase());
        assertEquals(sigh.toUpperCase(), as.name());
    }

    @Test
    void getHoroscopeFromDate() {
        String sigh = "capricorn";
        AstroSign as = ch.getAstroSign(sigh.toUpperCase());
        int number = as.ordinal();
        String horoscope = ch.getHoroscope(number);
        assertEquals(horoscope, "CAPRICORN. Expect frustration during the first few days of " +
                "August 2020 - probably be due to other people (workmen, trades people, et cetera) " +
                "letting you down.   Don't attempt to force issues until after the 6th, " +
                "after which you can make as much of a fuss as you like, so that you get satisfactory " +
                "results and feel smug that you've put the erring ones strictly in their place! " +
                "From then enjoy the rest of the month.");

        sigh = "aries";
        as = ch.getAstroSign(sigh.toUpperCase());
        number = as.ordinal();

        horoscope = ch.getHoroscope(number);
        assertEquals(horoscope, "ARIES. Don't go bang your head against a brick wall on the 1st - it'll hurt more " +
                "than the frustration prompting you to take such extreme action! Everything's going to get seriously better, " +
                "as the Solar System is working well for you as far as sheer fun and risk-taking is concerned " +
                "(or did you prang your car or back a loser on the 1st ?). " +
                "After the 7th the stars will make you chatty and communicative, but beware of being too provocative!");
    }

    @Test
    void getSignByDate() {
        int day = 10;
        int month = 10;
        String result = ch.getSignByDate(day, month);
        assertEquals(result, "LIBRA");
    }

    @Test
    void checkIfInputIsInvalid() {
        String input = "f";
        assertTrue(ch.isInputInvalid(input));
    }

}