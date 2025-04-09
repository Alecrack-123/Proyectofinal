package co.edu.uniquindio.poo.proyectofinal;

public class CategoriaSimple implements CategoriaComponente {
    private String nombre;

    public CategoriaSimple(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("Categoría: " + nombre);
    }
}
