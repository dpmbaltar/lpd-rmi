package lpd.rmi.data;

import java.io.Serializable;
import java.time.LocalDate;

public final class Clima implements Serializable {

	private static final long serialVersionUID = -2598374210122976147L;
	private LocalDate fecha;
	private String condicion;
	private double temperatura;

	public Clima(LocalDate fecha, String condicion, double temperatura) {
		this.fecha = fecha;
		this.condicion = condicion;
		this.temperatura = temperatura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getCondicion() {
		return condicion;
	}

	public double getTemperatura() {
		return temperatura;
	}

	@Override
	public String toString() {
		return "Clima [fecha=" + fecha + ", condicion=" + condicion + ", temperatura=" + temperatura + "]";
	}

}
