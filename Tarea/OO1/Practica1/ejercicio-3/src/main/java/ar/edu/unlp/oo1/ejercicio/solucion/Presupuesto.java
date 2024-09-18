package ar.edu.unlp.oo1.ejercicio.solucion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
    private LocalDate fecha;
    private String cliente;
    private List<Item> items;

    public Presupuesto(String cliente) {
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        this.items = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void agregarItem(Item item) {
        if(item != null)
            this.items.add(item);
    }

    public double calcularTotal() {
        return this.items.stream().mapToDouble(item -> item.getCostoUnitario()).sum();
    }
}
