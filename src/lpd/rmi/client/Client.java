package lpd.rmi.client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Scanner;

import lpd.rmi.server.WeatherService;

public class Client {
    
    private static String host = "127.0.0.1";
    private static int port = 24001;

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
            boolean exit = false;
            String date = null;
            String sign = null;
            Scanner scanner = new Scanner(System.in);
            String name = String.format("//%s:%s/Weather", host, port);
            WeatherService weather = (WeatherService) Naming.lookup(name);
            
            do {
                System.out.println("Escribir fecha:");
                date = scanner.nextLine();
                System.out.println("Escribir signo:");
                sign = scanner.nextLine();
                
                System.out.println(weather.getWeather(LocalDate.parse(date)));
                
                System.out.println("Presionar Entrar para otra consulta / N para salir");
                switch (System.in.read()) {
                    case 'N':
                    case 'n':
                      exit = true;
                    break;
                }
                
            } while (!exit);
            
            scanner.close();
            
        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        } catch (Exception e) {
            System.err.println("Excepcion en Client:");
            e.printStackTrace();
        }
        
        System.out.println("Finalizado.");
    }

}
