package lpd.rmi.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public final class Horoscopo implements Serializable {

	private static final long serialVersionUID = -6297481296087973761L;
	private Signo signo;
	private LocalDate fecha;
	private String[] rango;
	private String estado;

	public Horoscopo(Signo signo, LocalDate fecha, String[] rango, String estado) {
		this.signo = signo;
		this.fecha = fecha;
		this.rango = rango;
		this.estado = estado;
	}

	public Signo getSigno() {
		return signo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String[] getRango() {
		return rango;
	}

	public String getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Horoscopo [signo=" + signo + ", fecha=" + fecha + ", rango=" + Arrays.toString(rango) + ", estado="
				+ estado + "]";
	}

}
