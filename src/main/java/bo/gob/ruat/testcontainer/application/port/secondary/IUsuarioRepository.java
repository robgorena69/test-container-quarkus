package bo.gob.ruat.testcontainer.application.port.secondary;

import bo.gob.ruat.testcontainer.domain.entity.UsuarioEntity;

public interface IUsuarioRepository {
    
    void creaUsuario(UsuarioEntity usuario);

    UsuarioEntity buscaUsuarioByCi(String ci);

}
