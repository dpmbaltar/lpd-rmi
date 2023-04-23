package lpd.rmi.data;

public final class Info {

    private Horoscope horoscope;
    private Weather weather;
    
    public Info(Horoscope horoscope, Weather weather) {
        this.horoscope = horoscope;
        this.weather = weather;
    }

    public Horoscope getHoroscope() {
        return horoscope;
    }

    public Weather getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "Info [horoscope=" + horoscope + ", weather=" + weather + "]";
    }
    
}
