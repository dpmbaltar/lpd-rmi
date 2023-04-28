package lpd.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import lpd.rmi.data.Info;
import lpd.rmi.data.Sign;

public interface InfoService extends Remote {
    Info getInfo(LocalDate date, Sign sign) throws RemoteException;
}
