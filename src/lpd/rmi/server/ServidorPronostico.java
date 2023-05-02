package lpd.rmi.server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class ServidorPronostico {

    private static String host = "127.0.0.1";
    private static int port = 24001;

    private static void parseArgs(String args[]) {
        if (args.length <= 2) {
            System.out.println("Uso: ServidorPronostico IP Puerto");
            System.out.println("Ejecutando con valores por defecto:");
            System.out.println(String.format("ServidorPronostico %s %d", host, port));
        } else {
            host = args[0];
            port = Integer.valueOf(args[1]);
            System.out.println(String.format("Ejecutando ServidorCentral %s %d", host, port));
        }
    }

    public static void main(String args[]) {
        parseArgs(args);

        try {
            ServicioPronostico service = new ServicioPronosticoImpl();
            LocateRegistry.createRegistry(port);
            String name = String.format("rmi://%s:%s/Pronostico", host, port);
            Naming.rebind(name, service);
        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Excepcion en ServidorPronostico:");
            e.printStackTrace();
            System.exit(1);
        }
    }

}
