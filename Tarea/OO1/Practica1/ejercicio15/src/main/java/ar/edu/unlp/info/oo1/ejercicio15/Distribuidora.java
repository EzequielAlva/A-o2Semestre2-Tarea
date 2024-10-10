package ar.edu.unlp.info.oo1.ejercicio15;

public class Distribuidora {
    private CuadroTarifario cuadroTarifario;

    public Distribuidora(CuadroTarifario cuadroTarifario) {
        this.cuadroTarifario = cuadroTarifario;
    }

    private boolean tieneBonificacion(Usuario usuario) {
        Consumo ultimoConsumo = this.getUltimoConsumo(usuario);
        double fpe = ultimoConsumo.getEnergiaActiva() / (
                Math.sqrt(
                        Math.pow(ultimoConsumo.getEnergiaActiva(), 2) + Math.pow(ultimoConsumo.getEnergiaReactiva(), 2)
                )
        );
        return fpe > 0.8;
    }

    private double calcularBonificacion(Usuario usuario) {
        return (tieneBonificacion(usuario)) ? 0.1 : 0;
    }

    private double calculoDeMontoFinal(Usuario usuario) {
        Consumo ultimoConsumo = this.getUltimoConsumo(usuario);
        double costoConsumo = this.cuadroTarifario.getPrecioDeKW() * ultimoConsumo.getEnergiaActiva();
        return costoConsumo - costoConsumo * calcularBonificacion(usuario);
    }

    private Consumo getUltimoConsumo(Usuario usuario) {
        return usuario.getListaConsumos().get(usuario.getListaConsumos().size() - 1);
    }

    public Factura emitirFactura(Usuario usuario) {
        double bonificacion = this.calcularBonificacion(usuario);
        double montoTotal = this.calculoDeMontoFinal(usuario);
        return new Factura(
                usuario.getNombre(),
                usuario.getDomicilio(),
                bonificacion,
                montoTotal
        );
    }
}
