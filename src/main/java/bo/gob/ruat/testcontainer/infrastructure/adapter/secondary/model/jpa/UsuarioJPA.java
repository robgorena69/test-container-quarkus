package bo.gob.ruat.testcontainer.infrastructure.adapter.secondary.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "usuario", schema = "pruebas", catalog = "my_store_test")
public class UsuarioJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_usuario_sec")
	@SequenceGenerator(name = "ent_usuario_sec", schema = "pruebas", sequenceName = "ent_usuario_sec", initialValue = 1000, allocationSize = 1)
    
    @Column(name = "num_sec", nullable = false)
	private Long numSec;

    @Column(name = "carnet_identidad", nullable = true, length = 30)
    private String ci;

    @Column(name = "nombres", nullable = true, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = true, length = 50)
    private String apellidos;

    @Column(name = "edad", nullable = false, length = 50)
    private int edad;

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    
    
}
