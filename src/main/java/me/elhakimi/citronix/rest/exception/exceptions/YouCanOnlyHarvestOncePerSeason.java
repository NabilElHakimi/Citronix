package me.elhakimi.citronix.rest.exception.exceptions;

public class YouCanOnlyHarvestOncePerSeason extends RuntimeException {
    public YouCanOnlyHarvestOncePerSeason() {
        super("You can only harvest once per season, which occurs every 3 months. Please wait until the next season before harvesting again");
    }
}
