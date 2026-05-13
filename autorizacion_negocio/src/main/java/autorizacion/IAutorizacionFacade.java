package autorizacion;

import dto_request.UsuarioLoginDTO;
import objetosnegocio.UsuarioBO;

public interface IAutorizacionFacade {
    UsuarioBO verificarLogin(UsuarioLoginDTO usuarioLoginDTO);
}
