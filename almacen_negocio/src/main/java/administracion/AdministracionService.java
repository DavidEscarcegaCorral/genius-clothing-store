/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import dominio.ProductoEntidad;
import dtos.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import repository.ProductoRepository;

/**
 *
 * @author Usuario
 */
public class AdministracionService implements IAdministracionService{
    
    private ProductoRepository repository;

    //Cuandos se crea un AdministracionService se crea un ProductoRepository
    public AdministracionService() {
        this.repository = new ProductoRepository();
    }

    @Override
    public List<ProductoDTO> obtenerProductos() {
        List<ProductoEntidad> productos = repository.obtenerProductos();
        
        List<ProductoDTO> dto = new ArrayList<>();
        for(ProductoEntidad e : productos){
            dto.add(new ProductoDTO(
            e.getId().toString(),
                    e.getNombre(),
                    e.getDescrpcionProducto(),
                    e.getPrecio(),
                    e.getRutaImagen(),
                    e.getStock(),
                    e.getEstado()
            ));         
        }
        return dto;
       
    }

   
    
    
}
