package lpd.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import lpd.rmi.data.Info;
import lpd.rmi.data.Signo;

public interface ServicioInfo extends Remote {
    Info obtenerInfo(LocalDate fecha, Signo signo) throws RemoteException;
}
