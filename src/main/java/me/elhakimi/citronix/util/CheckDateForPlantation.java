package me.elhakimi.citronix.util;

import java.time.LocalDate;

public class CheckDateForPlantation {

    public static boolean CheckDateIfBetweenMarshAndMai(LocalDate date){
        return date.getMonthValue() >= 3 && date.getMonthValue() <= 5;

    }
}
