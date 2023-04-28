package lpd.rmi.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {

    private static String host = "127.0.0.1";
    private static int port = 24000;
    private static int weatherPort = 24001;
    private static int horoscopePort = 24002;

    private static void parseArgs(String args[]) {
        if (args.length < 2) {
            System.out.println("Uso: Client IP Puerto");
            System.out.println("Ejecutando con valores por defecto:");
            System.out.println(String.format("Client %s %d", host, port));
        } else {
            host = args[0];
            port = Integer.valueOf(args[1]);
        }
    }

    public static void main(String[] args) {
        parseArgs(args);

        try {
            String weatherName = String.format("//%s:%s/Weather", host, weatherPort);
            String horoscopeName = String.format("//%s:%s/Horoscope", host, horoscopePort);
            WeatherService weatherService = (WeatherService) Naming.lookup(weatherName);
            HoroscopeService horoscopeService = (HoroscopeService) Naming.lookup(horoscopeName);
            InfoService infoService = new InfoServiceImpl(weatherService, horoscopeService);

            LocateRegistry.createRegistry(port);
            String name = String.format("rmi://%s:%s/Info", host, port);
            Naming.rebind(name, infoService);

        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        } catch (Exception e) {
            System.err.println("Excepcion en MainServer:");
            e.printStackTrace();
        }
    }

}
