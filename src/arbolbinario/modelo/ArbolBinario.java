/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario.modelo;

import arbolbinario.modelo.excepciones.ArbolBinarioException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carloaiza
 */
public class ArbolBinario {

    private Nodo raiz;

    //public void adicionarNodo()
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void isLleno() throws ArbolBinarioException {
        if (raiz == null) {
            throw new ArbolBinarioException("El árbol está vacío");
        }
    }

    public void adicionarNodo(int dato, Nodo ubicacion) throws ArbolBinarioException {
        if (raiz == null) {
            raiz = new Nodo(dato);

        } else {
            if (dato < ubicacion.getDato()) {
                if (ubicacion.getIzquierda() == null) {
                    ubicacion.setIzquierda(new Nodo(dato));
                } else {
                    adicionarNodo(dato, ubicacion.getIzquierda());
                }
            } else if (dato > ubicacion.getDato()) {
                if (ubicacion.getDerecha() == null) {
                    ubicacion.setDerecha(new Nodo(dato));
                } else {
                    adicionarNodo(dato, ubicacion.getDerecha());
                }
            } else {
                throw new ArbolBinarioException("No se puede repetir");
            }
        }
    }
    
     
    public ArrayList inOrden() throws ArbolBinarioException{
        isLleno();
        ArrayList l=new ArrayList();
        inOrden(raiz,l);
        return l;
    }

    private void inOrden(Nodo reco,ArrayList l) {
        if (reco != null) {
            inOrden(reco.getIzquierda(),l);
            l.add(reco.getDato() + " ");
            inOrden(reco.getDerecha(),l);
        }
    }
    

    /**
     * Método que retorna un arreglo de enteros con los datos de recorrer el árbol en preorden
     * @return Arraylist
     * @throws ArbolBinarioException 
     */
    
    //imprimir lista de números en preorden
    public ArrayList preOrden() throws ArbolBinarioException{
        ArrayList l=new ArrayList();
        if (raiz != null) 
        {
            preOrden(raiz, l);
        }
        return l;
    } 
    
    /**
     * Método recursivo que recorre el árbol en preorden
     * @param temp Ayudante que toma referencia en un nodo
     * @param listado acumulador para registrar el dato del nodo visitado
     */
    
    private void preOrden(Nodo temp, ArrayList listado)
    {
        //Condición que garantiza que el método finalice
        if(temp!=null)
        {
            listado.add(temp.getDato());
            preOrden(temp.getIzquierda(), listado);
            preOrden(temp.getDerecha(), listado);
        }
    }
    
    /**
     * Método recursivo que recorre el árbol en preorden
     * @param temp Ayudante que toma referencia en un nodo
     * @param listado acumulador para registrar el dato del nodo visitado
     */
    private void postOrden(Nodo temp, ArrayList listado) {
        if (temp != null) {
            postOrden(temp.getIzquierda(),listado);
            postOrden(temp.getDerecha(),listado);
            listado.add(temp.getDato() + " ");
        }
    }
    
    //imprimir post orden
    public ArrayList postOrden() throws ArbolBinarioException {
        ArrayList l=new ArrayList();
        if(raiz !=null)
        {
            postOrden(raiz,l);
        }
        return l;
    }
    
   
    public void llenarArbol(String datos) throws ArbolBinarioException
    {
        String[] arrayDatos= datos.split(",");
        for(String cadena: arrayDatos)
        {
            adicionarNodo(Integer.parseInt(cadena), raiz);
        }
        
    }

}
