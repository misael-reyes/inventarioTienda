/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Misael
 * 
 * Esta clase representa a la clase Producto_abstracto (patrón método de fabricación)
 */
public abstract class IteradorProd implements Iterator{
    
    protected List lista;
    
    public IteradorProd(List lista) {
        this.lista = lista;
    }
    
    @Override
    public abstract boolean hasNext();
    
    @Override 
    public abstract Object next();
    
    public abstract void ordenar();
}
