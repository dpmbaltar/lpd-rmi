package lpd.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import lpd.rmi.data.Horoscope;

public interface HoroscopeService extends Remote {
    Horoscope getHoroscope(LocalDate date) throws RemoteException;
}
