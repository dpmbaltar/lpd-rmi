package lpd.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import lpd.rmi.data.Weather;

public interface WeatherService extends Remote {
    Weather getWeather(LocalDate date) throws RemoteException;
}
