package bo.gob.ruat.testcontainer.infraestructue.adapter.secondary.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bo.gob.ruat.testcontainer.application.port.secondary.IUsuarioRepository;
import bo.gob.ruat.testcontainer.domain.entity.UsuarioEntity;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UsuarioRepositoryTest {

    @Inject
    IUsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Registra un usuario")
    @Transactional
    public void registraUsuario(){
        Random rand = new Random();
            
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setPrimerNombre("juan" + rand.nextInt(5));
        usuarioEntity.setSegundoNombre("carlos"+ rand.nextInt(8));
        usuarioEntity.setApellidoPaterno("gorena"+rand.nextInt(8));
        usuarioEntity.setApellidoMaterno("fernadnez"+rand.nextInt(4));
        usuarioEntity.setCi(Integer.toString(rand.nextInt(6000)));
        usuarioEntity.setEdad(rand.nextInt(99)+1);
        usuarioRepository.creaUsuario(usuarioEntity);
        assertNotNull(usuarioEntity);
    }

    @Test
    @DisplayName("Verifica los datos de un usuario")
    @Transactional
    public void obtieneUsuario(){
        String ciValido = "3641";
        UsuarioEntity usuarioEntity = usuarioRepository.buscaUsuarioByCi(ciValido);
        assertNotNull(usuarioEntity);
        assertEquals(usuarioEntity.getPrimerNombre(), "juan0");
        assertTrue(usuarioEntity.getEdad()>18, "La persona es mayor de edad");

    }

    
}
