package lpd.rmi.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public final class Horoscope implements Serializable {

    private static final long serialVersionUID = -6297481296087973761L;
    private Sign sign;
    private LocalDate date;
    private String[] range;
    private String mood;

    public Horoscope(Sign sign, LocalDate date, String[] range, String mood) {
        this.sign = sign;
        this.date = date;
        this.range = range;
        this.mood = mood;
    }

    public Sign getSign() {
        return sign;
    }

    public LocalDate getDate() {
        return date;
    }

    public String[] getRange() {
        return range;
    }

    public String getMood() {
        return mood;
    }

    @Override
    public String toString() {
        return "Horoscope [sign=" + sign + ", date=" + date + ", range=" + Arrays.toString(range) + ", mood=" + mood
                + "]";
    }

}
