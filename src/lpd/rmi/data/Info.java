package lpd.rmi.data;

import java.io.Serializable;

public final class Info implements Serializable {

    private static final long serialVersionUID = -2286013604527839998L;
    private Horoscopo horoscope;
    private Clima weather;
    
    public Info(Clima weather, Horoscopo horoscope) {
        this.weather = weather;
        this.horoscope = horoscope;
    }

    public Horoscopo getHoroscope() {
        return horoscope;
    }

    public Clima getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "Info [weather=" + weather + ", horoscope=" + horoscope + "]";
    }
    
}
