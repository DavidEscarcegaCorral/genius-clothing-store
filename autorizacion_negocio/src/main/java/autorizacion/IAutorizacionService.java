package autorizacion;

import dto_request.CredencialesDTO;
import objetosnegocio.UsuarioBO;

public interface IAutorizacionService {
    UsuarioBO verificarLogin(CredencialesDTO credencialesDTO);
}
