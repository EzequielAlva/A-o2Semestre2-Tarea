package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.Objects;

public class Consumo {
    private double energiaActiva;
    private double energiaReactiva;

    public Consumo(double energiaActiva, double energiaReactiva) {
        this.energiaActiva = energiaActiva;
        this.energiaReactiva = energiaReactiva;
    }

    public double getEnergiaActiva() {
        return energiaActiva;
    }

    public double getEnergiaReactiva() {
        return energiaReactiva;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(! (obj instanceof Consumo)) return false;
        Consumo consumo = (Consumo) obj;
        return consumo.getEnergiaActiva() == this.getEnergiaActiva()
                    && consumo.getEnergiaReactiva() == this.getEnergiaReactiva();
    }

    @Override
    public int hashCode() {
        return Objects.hash(energiaActiva, energiaReactiva);
    }
}
