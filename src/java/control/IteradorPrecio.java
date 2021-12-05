/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author Misael
 * 
 * Esta clase es una representación de la clase Producto_concreto
 */
public class IteradorPrecio extends IteradorProd {
    private int p = 0;
    
    public IteradorPrecio(List<Producto> p) {
        super(p);
        //ordenar();
    }

    @Override
    public boolean hasNext() {
        return p < lista.size();
    }

    @Override
    public Object next() {
        return lista.get(p++);
    }
    
    @Override
    public void ordenar() {
        //
        for(int i = 0; i < lista.size(); i ++) {
            for(int j = 0; j < lista.size()-1; j ++) {
                if(!(((Producto)lista.get(j)).getPrecio() < ((Producto)lista.get(j+1)).getPrecio())) {
                    Producto pa = (Producto)lista.get(j); //no es primero
                    //reemplazamos
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, pa);
                }
            }
        }
    }  
}
