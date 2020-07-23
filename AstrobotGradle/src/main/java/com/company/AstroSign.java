package com.company;

public enum AstroSign {
    AQUARIUS("original and inventive"),
    PISCES("compassionate and kind"),
    ARIES ("dynamic and quick-witted"),
    TAURUS("persistent and determined"),
    GEMINI ("communicative and witty"),
    CANCER("protective and sympathetic"),
    LEO("generous and warmhearted"),
    VIRGO("intelligent and analytical"),
    LIBRA ("diplomatic and romantic "),
    SCORPIO("determined and forceful"),
    SAGITTARIUS("optimistic and freedom-loving"),
    CAPRICORN ("ambitious and disciplined");

   private String desription;

    AstroSign(String desription) {
        this.desription = desription;
    }

    public String getDesription() {
        return desription;
    }
}
