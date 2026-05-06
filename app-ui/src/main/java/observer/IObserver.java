/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author Usuario
 * Use este patron por que el metodo de cargar tabla se ejecutaba antes del que el frame fuera visible
 * entonces los productos no se mostraban
 */
public interface IObserver {
    
    public void cargar();     
    
}
