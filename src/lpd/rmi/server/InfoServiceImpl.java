package lpd.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

import lpd.rmi.data.Horoscope;
import lpd.rmi.data.Info;
import lpd.rmi.data.Sign;
import lpd.rmi.data.Weather;

public class InfoServiceImpl extends UnicastRemoteObject implements InfoService {

    private static final long serialVersionUID = -5482222781702956899L;
    private HoroscopeService horoscopeService = null;
    private WeatherService weatherService = null;

    protected InfoServiceImpl() throws RemoteException {
        super();
    }

    public InfoServiceImpl(WeatherService weatherService, HoroscopeService horoscopeService) throws RemoteException {
        super();
        this.horoscopeService = horoscopeService;
        this.weatherService = weatherService;
    }

    public void setHoroscopeService(HoroscopeService horoscopeService) {
        this.horoscopeService = horoscopeService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public Info getInfo(LocalDate date, Sign sign) throws IllegalStateException, RemoteException {
        if (weatherService == null || horoscopeService == null)
            throw new IllegalStateException("Servicio del clima y/o horóscopo no establecidos");

        Weather weather = weatherService.getWeather(date);
        Horoscope horoscope = horoscopeService.getHoroscope(date, sign);

        return new Info(weather, horoscope);
    }

}
