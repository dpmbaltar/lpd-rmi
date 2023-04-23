// Implementación del servicio
package lpd.rmi.ejemplo.servidor;

import java.rmi.*;
import java.rmi.server.*;

class ServicioEcoImpl extends UnicastRemoteObject implements ServicioEco {
    
    private static final long serialVersionUID = -8022087511051344400L;

    ServicioEcoImpl() throws RemoteException {
    }

    public String eco(String s) throws RemoteException {
        return s.toUpperCase();
    }
    
}
