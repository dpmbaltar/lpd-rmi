// interface que contiene los métodos del servicio
package lpd.rmi.ejemplo.servidor;

import java.rmi.*;

public interface ServicioEco extends Remote {
    String eco(String s) throws RemoteException;
}
