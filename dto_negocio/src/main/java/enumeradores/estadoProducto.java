/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumeradores;

/**
 *
 * @author Usuario
 * Enumerador para los estados de un producto
 */
public enum estadoProducto {
    BORRADOR,//Cuando se crea el producto sin publicarlo
    PUBLICADO,//Cuando se publica el producto en la pagina
    AGOTADO,//Cuando no hay stock
    PAUSADO //Este el administrador manualmente lo pone
}
