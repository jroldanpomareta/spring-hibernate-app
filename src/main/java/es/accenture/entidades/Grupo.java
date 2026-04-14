/**
 * Clase: Componente
 * Autor: Javi
 * Fecha: 31/03/2026
 * 
 */
package es.accenture.entidades;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * la clase Grupo.
 */
@Entity
@Table(name="grupos")
public class Grupo {
	
	/** el grupo id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grupoId")
	private int grupoId;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="creacion")
	private int creacion;

	@Column(name="origen")
	private String origen;
	
	@Column(name="genero")
	private String genero;
	
	@OneToMany(mappedBy="grupo",cascade=CascadeType.ALL) //se pone en cascasa para que se propague
	private List<Componente>componentes;
	
	/**
	 * constructor vacío
	 */
	public Grupo() {
		
	}
	
	/**
	 * constructor por parámetros
	 */
	public Grupo(String nombre, int creacion, String origen, String genero) {
		super();
		this.nombre = nombre;
		this.creacion = creacion;
		this.origen = origen;
		this.genero = genero;
	}

	/**
	 * recupera el grupo id.
	 *
	 * @return the grupo id
	 */
	public int getGrupoId() {
		return grupoId;
	}

	/**
	 * establece el grupo id.
	 *
	 * @param grupoId the new grupo id
	 */
	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	/**
	 * recupera el nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * establece el nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * recupera la creacion.
	 *
	 * @return the creacion
	 */
	public int getCreacion() {
		return creacion;
	}

	/**
	 * establece la creacion.
	 *
	 * @param creacion the new creacion
	 */
	public void setCreacion(int creacion) {
		this.creacion = creacion;
	}

	/**
	 * recupera el origen.
	 *
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * establece el origen.
	 *
	 * @param origen the new origen
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * recupera el genero.
	 *
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * establece el genero.
	 *
	 * @param genero the new genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * recupera los componentes.
	 *
	 * @return the componentes
	 */
	public List<Componente> getComponentes() {
		return componentes;
	}

	/**
	 * establece los componentes.
	 *
	 * @param componentes the new componentes
	 */
	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	/**
	 * Agregar componente.
	 *
	 * @param componente the componente
	 */
	public void agregarComponente(Componente componente) {
		
		if(this.componentes==null) {
			
			this.componentes=new ArrayList<>();
		}
		this.componentes.add(componente);
	}
	
}
