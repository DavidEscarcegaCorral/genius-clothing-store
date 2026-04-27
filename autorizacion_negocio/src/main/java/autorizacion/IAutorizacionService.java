package autorizacion;

import dtos.CredencialesDTO;

public interface IAutorizacionService {
    boolean verificarLogin(CredencialesDTO credencialesDTO);
}
