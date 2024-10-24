package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private String apellido;
    private String cuil;
    private String fechaNac;
    private boolean tieneHijos;
    private boolean tieneConyuge;
    private List<Contrato> contratos;

    public Empleado(String nombre, String apellido, String cuil, String fechaNac,
                    boolean tieneHijos, boolean tieneConyuge) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.fechaNac = fechaNac;
        this.tieneHijos = tieneHijos;
        this.tieneConyuge = tieneConyuge;
        contratos = new ArrayList<>();
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

    public String getFechaNac() {
        return fechaNac;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public boolean tieneHijos() {
        return tieneHijos;
    }

    public boolean tieneConyuge() {
        return tieneConyuge;
    }

    public int getAntiguedad() {
        return contratos.stream().mapToInt( contrato -> contrato.antiguedadEnMeses()).sum();
    }

    public double calcularMontoTotal() {
        Contrato contrato = obtenerContratoActivo();
        if(contrato != null) {
            double sueldoBasico = contrato.montoMensual();
            return sueldoBasico + calcularBono(sueldoBasico);
        }
        return 0;
    }

    private Contrato obtenerContratoActivo() {
        Contrato ultimoContrato = contratos.get(contratos.size() - 1);
        if (ultimoContrato.estaVigente())
            return ultimoContrato;
        return null;
    }

    private double calcularBono(double sueldoBasico) {
        double bono;
        int ant = Math.floorDiv((getAntiguedad() / 12),5);
        switch (ant) {
            case 1:
                bono = 0.3;
                break;
            case 2:
                bono = 0.5;
                break;
            case 3:
                bono = 0.7;
                break;
            case 4:
                bono = 1;
                break;
            default:
                bono = 0;
        }
        return sueldoBasico * bono;
    }

    public ReciboDeSueldo emitirReciboDeSueldo() {
        return new ReciboDeSueldo(this);
    }

    public void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
    }
}
