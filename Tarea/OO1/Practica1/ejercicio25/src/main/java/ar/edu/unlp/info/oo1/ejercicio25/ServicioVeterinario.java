package ar.edu.unlp.info.oo1.ejercicio25;

public abstract class ServicioVeterinario extends Servicio{
    private Veterinario veterinario;
    private int cantidadMateriales;
    private boolean esDomingo;
    private final double MONTO_MATERIAL = 300;
    private final double MONTO_DOMINGO = 200;

    public ServicioVeterinario(Mascota mascota, Veterinario veterinario,
                            int cantidadMateriales, boolean esDomingo) {
        super(mascota);
        this.veterinario = veterinario;
        this.cantidadMateriales = cantidadMateriales;
        this.esDomingo = esDomingo;
    }

    public Veterinario getVeterinario() {
        return this.veterinario;
    }

    @Override
    protected double calcularCosto() {
        double montoDomingo = (esDomingo) ? MONTO_DOMINGO : 0;
        return this.getVeterinario().getHonorarios()
                + this.cantidadMateriales * MONTO_MATERIAL
                + montoDomingo;
    }
}
