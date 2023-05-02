package lpd.rmi.data;

import java.io.Serializable;

public final class Info implements Serializable {

    private static final long serialVersionUID = -2286013604527839998L;
    private Horoscopo horoscopo;
    private Clima clima;
    
    public Info(Clima clima, Horoscopo horoscopo) {
        this.clima = clima;
        this.horoscopo = horoscopo;
    }

    public Horoscopo getHoroscopo() {
        return horoscopo;
    }

    public Clima getClima() {
        return clima;
    }

    @Override
    public String toString() {
        return "Info [clima=" + clima + ", horoscopo=" + horoscopo + "]";
    }
    
}
