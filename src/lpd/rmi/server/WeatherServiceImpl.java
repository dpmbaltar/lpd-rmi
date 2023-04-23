package lpd.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import lpd.rmi.data.Weather;

public class WeatherServiceImpl extends UnicastRemoteObject implements WeatherService {

    private static final long serialVersionUID = 235386995158818076L;

    private Weather[] weatherCache = new Weather[7];
    
    private String[] conditions = {
            "Despejado",
            "Nublado",
            "Neblina",
            "Lluvia",
            "Chubascos",
            "Nieve"
            };

    protected WeatherServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Weather getWeather(LocalDate date) throws RemoteException {
        Weather weather = null;
        int day = date.compareTo(LocalDate.now());

        if (day < 0 || day >= weatherCache.length)
            return null;

        synchronized (weatherCache) {
            if (weatherCache[day] == null)
                weatherCache[day] = genWeather(day);
            weather = weatherCache[day];
        }

        return weather;
    }

    private Weather genWeather(int day) {
        LocalDate today = LocalDate.now();
        LocalDate date = today.plusDays(day);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String condition = conditions[random.nextInt(0, conditions.length)];
        double temperature = random.nextDouble(-50, 50);

        return new Weather(date, condition, temperature);
    }

}
