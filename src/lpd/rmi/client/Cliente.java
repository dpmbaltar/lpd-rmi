package lpd.rmi.client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Scanner;

import lpd.rmi.data.Signo;
import lpd.rmi.data.Info;
import lpd.rmi.server.ServicioInfo;

public class Cliente {

    private static String host = "127.0.0.1";
    private static int port = 24000;

    private static void parseArgs(String args[]) {
        if (args.length < 2) {
            System.out.println("Uso: Cliente IP Puerto");
            System.out.println("Ejecutando con valores por defecto:");
            System.out.println(String.format("Cliente %s %d", host, port));
        } else {
            host = args[0];
            port = Integer.valueOf(args[1]);
        }
    }

    public static void main(String[] args) {
        parseArgs(args);

        try {
            boolean exit = false;
            String dateInput = null;
            String signInput = null;
            Scanner scanner = new Scanner(System.in);
            String name = String.format("//%s:%s/Info", host, port);
            ServicioInfo infoService = (ServicioInfo) Naming.lookup(name);

            do {
                System.out.println("Escribir fecha:");
                dateInput = scanner.nextLine();
                System.out.println("Escribir signo:");
                signInput = scanner.nextLine();

                LocalDate date = LocalDate.parse(dateInput);
                Signo sign = Signo.valueOf(signInput.toUpperCase());

                if (date == null)
                    System.out.println("Fecha incorrecta");
                if (sign == null)
                    System.out.println("Signo desconocido");

                Info info = infoService.obtenerInfo(date, sign);
                System.out.println("Respuesta:");
                System.out.println(info.getClima());
                System.out.println(info.getHoroscopo());

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
            System.err.println("Excepcion en Cliente:");
            e.printStackTrace();
        }

        System.out.println("Finalizado.");
    }

}
