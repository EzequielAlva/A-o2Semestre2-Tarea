package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class ReciboDeSueldo {
    private String nombre;
    private String apellido;
    private String cuil;
    private int antiguedad;
    private LocalDate fecha;
    private double sueldoTotal;

    public ReciboDeSueldo(Empleado empleado) {
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.cuil = empleado.getCuil();
        this.antiguedad = empleado.getAntiguedad();
        this.fecha = LocalDate.now();
        this.sueldoTotal = empleado.calcularMontoTotal();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCuil() {
        return cuil;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getSueldoTotal() {
        return sueldoTotal;
    }
}
