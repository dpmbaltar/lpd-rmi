package lpd.rmi.client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Scanner;

import lpd.rmi.data.Sign;
import lpd.rmi.data.Info;
import lpd.rmi.server.InfoService;

public class Client {

    private static String host = "127.0.0.1";
    private static int port = 24000;

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
            String dateInput = null;
            String signInput = null;
            Scanner scanner = new Scanner(System.in);
            String name = String.format("//%s:%s/Info", host, port);
            InfoService infoService = (InfoService) Naming.lookup(name);

            do {
                System.out.println("Escribir fecha:");
                dateInput = scanner.nextLine();
                System.out.println("Escribir signo:");
                signInput = scanner.nextLine();

                LocalDate date = LocalDate.parse(dateInput);
                Sign sign = Sign.valueOf(signInput.toUpperCase());

                if (date == null)
                    System.out.println("Fecha incorrecta");
                if (sign == null)
                    System.out.println("Signo desconocido");

                Info info = infoService.getInfo(date, sign);
                System.out.println(info);

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
