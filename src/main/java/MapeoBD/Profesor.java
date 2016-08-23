
package MapeoBD;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rae
 */
@Entity
@Table(name="Profesor")
public class Profesor {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idProfesor")
    private long id_profesor;
    
    @Column(name = "nombreProfesor")
    private String nombre_profesor;
    
    @Column(name = "tipoProfesor")
    private String tipo_profesor;

    @OneToMany(mappedBy="profesor_grupo")
    private List<Grupo> grupos;

    public long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getTipo_profesor() {
        return tipo_profesor;
    }

    public void setTipo_profesor(String tipo_profesor) {
        this.tipo_profesor = tipo_profesor;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    
    
}
