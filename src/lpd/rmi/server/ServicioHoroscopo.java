package lpd.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import lpd.rmi.data.Horoscopo;
import lpd.rmi.data.Signo;

public interface ServicioHoroscopo extends Remote {
    Horoscopo obtenerHoroscopo(LocalDate fecha, Signo signo) throws RemoteException;
}
