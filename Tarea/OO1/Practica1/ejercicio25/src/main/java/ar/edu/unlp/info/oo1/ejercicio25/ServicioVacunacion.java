package ar.edu.unlp.info.oo1.ejercicio25;

public class ServicioVacunacion extends ServicioVeterinario{
    private double costoVacuna;

    public ServicioVacunacion(Mascota mascota, Veterinario veterinario,
                              int cantidadMateriales, boolean esDomingo, double costoVacuna) {
        super(mascota, veterinario, cantidadMateriales, esDomingo);
        this.costoVacuna = costoVacuna;
        this.costo = calcularCosto();
    }

    @Override
    protected double calcularCosto() {
        return super.calcularCosto() + costoVacuna;
    }
}
