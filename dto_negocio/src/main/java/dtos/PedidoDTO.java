/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import enumeradores.EstadoPedido;
import enumeradores.MetodoPago;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PedidoDTO {
    
    private Integer idPedido;
    private UsuarioDTO usuario;
    //Un pedido tendra una lista de DetallePedido con el producto y el precio y subtotal
    //Por ejemplo si compras 2 tenis de diferente marca en el pedido se debe de mostrar los detalles de cada compra
    private List<DetallePedidoDTO> detalles;
    private Date fecha;
    private Double total;
    private MetodoPago pago;
    private EstadoPedido estado;

    public PedidoDTO(Integer idPedido, UsuarioDTO usuario, List<DetallePedidoDTO> detalles, Date fecha, Double total, MetodoPago pago, EstadoPedido estado) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.detalles = detalles;
        this.fecha = fecha;
        this.total = total;
        this.pago = pago;
        this.estado = estado;
    }

    public PedidoDTO(UsuarioDTO usuario, List<DetallePedidoDTO> detalles, Date fecha, Double total, MetodoPago pago, EstadoPedido estado) {
        this.usuario = usuario;
        this.detalles = detalles;
        this.fecha = fecha;
        this.total = total;
        this.pago = pago;
        this.estado = estado;
    }

    public PedidoDTO() {
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public List<DetallePedidoDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoDTO> detalles) {
        this.detalles = detalles;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
       Double total = 0.0;
       //Recorremos la lista de detalle pedido
       for(DetallePedidoDTO d : detalles){
           //Sumamos por ca
           total= total + d.getSubtotal();
       }
       return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public MetodoPago getPago() {
        return pago;
    }

    public void setPago(MetodoPago pago) {
        this.pago = pago;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    
    
}
