package ar.edu.unlp.info.oo1.ejercicio25;

public class ServicioConsulta extends ServicioVeterinario{
    private final double MONTO_ANTIGUEDAD = 100;

    public ServicioConsulta(Mascota mascota, Veterinario veterinario,
                            int cantidadMateriales, boolean esDomingo) {
        super(mascota,veterinario,cantidadMateriales,esDomingo);
        this.costo = calcularCosto();
    }

    @Override
    protected double calcularCosto() {
        return super.calcularCosto()
                + this.getVeterinario().calcularAntiguedad() * MONTO_ANTIGUEDAD;
    }
}
