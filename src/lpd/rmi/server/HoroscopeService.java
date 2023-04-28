package lpd.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import lpd.rmi.data.Horoscope;
import lpd.rmi.data.Sign;

public interface HoroscopeService extends Remote {
    Horoscope getHoroscope(LocalDate date, Sign sign) throws RemoteException;
}
