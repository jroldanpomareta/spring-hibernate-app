/**
 * Clase: Componente
 * Autor: Javi
 * Fecha: 31/03/2026
 * 
 */
package es.accenture.entidades;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * la clase Componente.
 */
@Entity
@Table(name="componentes")
public class Componente {

	/** el componente id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="componenteId")
    private int componenteId;
	
	/** el nombre. */
	@Column(name="nombre")
    private String nombre;
	
	/** el instrumento. */
	@Column(name="instrumento")
    private String instrumento;
	
	/** el grupo. */
	@ManyToOne
	@JoinColumn(name="grupoId")
	private Grupo grupo;
    
    /**
     * Constructor vacío
     */
    public Componente() {
    	
    }
    
    /**
     * constructor por parámetros
     *
     * @param nombre the nombre
     * @param instrumento the instrumento
     */
    public Componente(String nombre,String instrumento) {
    	this.nombre=nombre;
    	this.instrumento=instrumento;
    }

	/**
	 * recupera el componente id.
	 *
	 * @return the componente id
	 */
	public int getComponenteId() {
		return componenteId;
	}

	/**
	 * establece el componente id.
	 *
	 * @param componenteId the new componente id
	 */
	public void setComponenteId(int componenteId) {
		this.componenteId = componenteId;
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
	 * recupera el instrumento.
	 *
	 * @return the instrumento
	 */
	public String getInstrumento() {
		return instrumento;
	}

	/**
	 * establece el instrumento.
	 *
	 * @param instrumento the new instrumento
	 */
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	/**
	 * recupera el grupo.
	 *
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * establece el grupo.
	 *
	 * @param grupo the new grupo
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
    
}
