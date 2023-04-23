package lpd.rmi.ejemplo.cliente;

import java.rmi.*;
import lpd.rmi.ejemplo.servidor.ServicioEco;

class ClienteEco {
    static public void main(String args[]) {
        if (args.length < 2) {
            System.err.println("Uso: ClienteEco IPServidor PuertoServidor ...");
            return;
        }

        //if (System.getSecurityManager() == null)
        //    System.setSecurityManager(new SecurityManager());

        try {

            ServicioEco srv = (ServicioEco) Naming.lookup("//" + args[0] + ":" + args[1] + "/Eco");
            System.out.println(srv.eco("Foobar"));

            // for (int i = 2; i < args.length; i++)
            //     System.out.println(srv.eco(args[i]));

        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        } catch (Exception e) {
            System.err.println("Excepcion en ClienteEco:");
            e.printStackTrace();
        }
    }
}
