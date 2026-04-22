/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumeradores;

/**
 *
 * @author Usuario
 * Enumerador para ver el estado del pedido una vez pagado
 */
public enum estadoPedido {
    PENDIENTE_PAGO, // Cuando lo selecciona pero no lo ha pagado
    PAGADO, //Cuando hace el pago
    EN_PREPARACION, //Cuando se esta armando el pedido
    ENVIADO, //Cuando el pedido fue enviado
    ENTREGADO, //Cuando le llego al usuario
    CANCELADO //Cuando la tienda cancela la entrega
}
