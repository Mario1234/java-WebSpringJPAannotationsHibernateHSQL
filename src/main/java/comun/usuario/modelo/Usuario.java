package comun.usuario.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USUARIO", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID") })
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = -7031296109006058528L;
	
	private Integer id;
	private String nombre;
	private String apellido;

	public Usuario() {
	}

	public Usuario(String nom, String apel) {
		this.nombre = nom;
		this.apellido = apel;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NOMBRE", nullable = false, length = 10)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nom) {
		this.nombre = nom;
	}

	@Column(name = "APELLIDO", nullable = false, length = 20)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apel) {
		this.apellido = apel;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre
				+ ", apellido=" + apellido + "]";
	}
	
	

}