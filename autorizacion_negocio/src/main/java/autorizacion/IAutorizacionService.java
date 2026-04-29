package autorizacion;

import dtos.CredencialesDTO;
import objetosnegocio.UsuarioBO;

public interface IAutorizacionService {
    UsuarioBO verificarLogin(CredencialesDTO credencialesDTO);
}
