package co.edu.uniquindio.poo.proyectofinal;

public abstract class ReporteDecorator implements Reporte {
    protected Reporte decorado;

    public ReporteDecorator(Reporte decorado) {
        this.decorado = decorado;
    }

    public void generar() {
        decorado.generar();
    }

}