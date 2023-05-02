package lpd.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

import lpd.rmi.data.Horoscopo;
import lpd.rmi.data.Info;
import lpd.rmi.data.Signo;
import lpd.rmi.data.Clima;

public class ServicioInfoImpl extends UnicastRemoteObject implements ServicioInfo {

	private static final long serialVersionUID = -5482222781702956899L;
	private ServicioHoroscopo servicioHoroscopo = null;
	private ServicioPronostico servicioClima = null;

	protected ServicioInfoImpl() throws RemoteException {
		super();
	}

	public ServicioInfoImpl(ServicioPronostico servicioClima, ServicioHoroscopo servicioHoroscopo)
			throws RemoteException {
		super();
		this.servicioHoroscopo = servicioHoroscopo;
		this.servicioClima = servicioClima;
	}

	@Override
	public Info obtenerInfo(LocalDate fecha, Signo signo) throws IllegalStateException, RemoteException {
		if (servicioClima == null || servicioHoroscopo == null)
			throw new IllegalStateException("Servicio del clima y/o horóscopo no establecidos");

		Clima weather = servicioClima.obtenerClima(fecha);
		Horoscopo horoscope = servicioHoroscopo.obtenerHoroscopo(fecha, signo);

		return new Info(weather, horoscope);
	}

}
