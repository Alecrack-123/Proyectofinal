package co.edu.uniquindio.poo.proyectofinal;

public class ReporteCSV extends ReporteDecorator{
    public ReporteCSV(Reporte decorado) {
        super(decorado);
    }

    @Override
    public void generar() {
        super.generar();
        System.out.println("Exportando a CSV...");
    }
}
