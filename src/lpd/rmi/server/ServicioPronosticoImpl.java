package lpd.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import lpd.rmi.data.Clima;

public class ServicioPronosticoImpl extends UnicastRemoteObject implements ServicioPronostico {

    private static final long serialVersionUID = 235386995158818076L;

    private Clima[] cacheClima = new Clima[7];
    
    private String[] conditiones = {
            "Despejado",
            "Nublado",
            "Neblina",
            "Lluvia",
            "Chubascos",
            "Nieve"
            };

    protected ServicioPronosticoImpl() throws RemoteException {
        super();
    }

    @Override
    public Clima obtenerClima(LocalDate fecha) throws RemoteException {
        Clima weather = null;
        int day = fecha.compareTo(LocalDate.now());

        if (day < 0 || day >= cacheClima.length)
            return null;

        synchronized (cacheClima) {
            if (cacheClima[day] == null)
                cacheClima[day] = generarClima(day);
            weather = cacheClima[day];
        }

        return weather;
    }

    private Clima generarClima(int day) {
        LocalDate today = LocalDate.now();
        LocalDate date = today.plusDays(day);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String condition = conditiones[random.nextInt(0, conditiones.length)];
        double temperature = random.nextDouble(-50, 50);

        return new Clima(date, condition, temperature);
    }

}
