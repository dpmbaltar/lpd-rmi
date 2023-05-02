package lpd.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import lpd.rmi.data.Clima;

public interface ServicioPronostico extends Remote {
    Clima obtenerClima(LocalDate fecha) throws RemoteException;
}
