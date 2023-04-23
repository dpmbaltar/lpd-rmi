package lpd.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import lpd.rmi.data.Horoscope;
import lpd.rmi.data.Sign;

public class HoroscopeServiceImpl extends UnicastRemoteObject implements HoroscopeService {

    private static final long serialVersionUID = 3030900350933750920L;

    private static final String[] moods = {
            "¡Puedes enfrentarte a todo lo que obstaculiza tu realización personal! Te encuentras en una buena situación para fortalecer la confianza que tienes en quienes te rodean.",
            "¡Aleja de tu pensamiento la idea de que las barreras que encuentras en tu camino son indestructibles! Sé muy cuidadoso al manejar tu dinero.",
            "Ten presente que la vida emocional saludable se sustenta en el reconocimiento de tu esencia y del valor que le otorgas. Asegúrate de mantener una actitud sabia y positiva permanentemente.",
            "La vida te está exigiendo que pongas las cartas sobre la mesa cuanto antes y de la manera más sincera posible. ¡Decide solucionar aquellos aspectos que no te hacen feliz!",
            "¡Mantén libres y bien cimentadas tus reservas monetarias! Las tormentas están en el ambiente, pero ¡son pasajeras!",
            "Tu futuro económico se percibe estable, ya que un dinero extra llega inesperadamente. Las cuestiones laborales están favorecidas.",
            "¡Comparte tu armonía con los demás! Las cosas toman un cauce diferente e inesperado de oportunidades de progreso personal.",
            "Tu relación afectiva presenta algunos inconvenientes que pueden solucionarse con actitud de escucha y comprensión de ambas partes.",
            "Vibraciones planetarias positivas aumentan tu magnetismo. Importantes sorpresas vienen para ti en el campo financiero.",
            "Confía más en tu honestidad y buen discernimiento para defender los proyectos que vienes trabajando con ahínco y responsabilidad.",
            "El exceso de actividades laborales te absorbe de tal forma que ¡te olvidas de quienes te rodean! Pero el amor y la pasión te ofrecen sus mejores goces.",
            "Ocúpate de organizar los ingresos, de tal manera que puedas cumplir con tus responsabilidades. Evita gastos superfluos." };

    private static final String[][] ranges = {
            { "03-21", "04-19" }, { "04-20", "05-20" }, { "05-21", "06-21" }, { "06-22", "07-22" },
            { "07-23", "08-22" }, { "08-23", "09-22" }, { "09-23", "10-22" }, { "10-23", "11-22" },
            { "11-23", "12-21" }, { "12-22", "01-19" }, { "01-20", "02-18" }, { "02-19", "03-20" }
            };

    private static final Sign[] signs = Sign.values();
    
    private final Horoscope[] horoscopeCache = new Horoscope[7];

    protected HoroscopeServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Horoscope getHoroscope(LocalDate date) throws RemoteException {
        Horoscope horoscope = null;
        int day = date.compareTo(LocalDate.now());
        
        if (day < 0 || day >= horoscopeCache.length)
            return null;

        synchronized (horoscopeCache) {
            if (horoscopeCache[day] == null)
                horoscopeCache[day] = genHoroscope(day);
            horoscope = horoscopeCache[day];
        }
        
        return horoscope;
    }

    private Horoscope genHoroscope(int day) {
        LocalDate today = LocalDate.now();
        LocalDate date = today.plusDays(day);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String[] range = ranges[random.nextInt(0, ranges.length)];
        String mood = moods[random.nextInt(0, moods.length)];
        Sign sign = signs[random.nextInt(0, signs.length)];
        
        return new Horoscope(sign, date, range, mood);
    }

}
