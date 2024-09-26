package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro() {
		super();
	}
	
	@Override
	protected boolean puedeExtraer(double monto) {
		return getSaldo() >= (monto + monto * 0.02);
	}
}
