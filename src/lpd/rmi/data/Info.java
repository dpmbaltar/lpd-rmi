package lpd.rmi.data;

import java.io.Serializable;

public final class Info implements Serializable {

    private static final long serialVersionUID = -2286013604527839998L;
    private Horoscope horoscope;
    private Weather weather;
    
    public Info(Weather weather, Horoscope horoscope) {
        this.weather = weather;
        this.horoscope = horoscope;
    }

    public Horoscope getHoroscope() {
        return horoscope;
    }

    public Weather getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "Info [weather=" + weather + ", horoscope=" + horoscope + "]";
    }
    
}
