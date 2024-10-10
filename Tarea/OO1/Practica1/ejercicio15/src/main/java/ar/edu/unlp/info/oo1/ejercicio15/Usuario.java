package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String domicilio;
    private List<Consumo> listaConsumos;

    public Usuario(String nombre, String domicilio) {
        this.listaConsumos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public List<Consumo> getListaConsumos() {
        return listaConsumos;
    }

    public void agregarConsumo(Consumo consumo) {
        this.listaConsumos.add(consumo);
    }

    public void quitarConsumo(Consumo consumo) {
        if(this.listaConsumos.size() > 0 && this.listaConsumos.contains(consumo))
        this.listaConsumos.remove(consumo);
    }
}