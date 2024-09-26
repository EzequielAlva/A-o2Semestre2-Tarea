package ar.edu.unlp.info.oo1.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private String nombre;
    private List<Inversion> inversiones;

    public Inversor() {
        this.inversiones = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarInversion(Inversion inversion) {
        this.inversiones.add(inversion);
    }

    public void quitarInversion(Inversion inversion) {
        if(!this.inversiones.isEmpty())
            this.inversiones.remove(inversion);
    }

    public double valorActual() {
        return this.inversiones.stream()
                .mapToDouble(i -> i.valorActual())
                .sum();
    }
}
