package co.edu.uniquindio.poo.proyectofinal;

import java.util.ArrayList;
import java.util.List;

public class CategoriaCompuesta implements CategoriaComponente{
    private String nombre;
    private List<CategoriaComponente> subcategorias = new ArrayList<>();

    public CategoriaCompuesta(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(CategoriaComponente c) {
        subcategorias.add(c);
    }

    public void mostrar() {
        System.out.println("Categoría compuesta: " + nombre);
        for (CategoriaComponente c : subcategorias) {
            c.mostrar();
        }
    }
}
