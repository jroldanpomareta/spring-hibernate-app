/**
 * Clase: Componente
 * Autor: Javi
 * Fecha: 31/03/2026
 * 
 */
package es.accenture.servicios;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.accenture.entidades.Componente;
import es.accenture.entidades.Grupo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

// TODO: Auto-generated Javadoc
/**
 * la clase ConsultaGrupos.
 */
public class ConsultaGrupos {

	/**
	 * el método main
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsultaGrupos hacerConsulta=new ConsultaGrupos();
		
		hacerConsulta.metodoParaConsultarGrupos();

	}
	
	/**
	 * Metodo para consultar grupos.
	 */
	public void metodoParaConsultarGrupos() {
		 /**
		 * se abre con try with resources para que cierre solo
		 */		
		try
		 /**
		 * arranca Spring y carga los beans y la configuración
		 */				
		(ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml")){
			/**
			 * se obtiene el SessionFactory
			 */
		SessionFactory miFactory=context.getBean("sessionFactory",SessionFactory.class);
		/**
		 * se abre la conexión
		 */
		Session miSession=miFactory.openSession();
		/**
		 * se hace un fetch join para cargar grupos y componentes en una sola consulta
		 */
		List<Grupo>listaGrupos=miSession.createQuery("select distinct grupoRecuperado from Grupo grupoRecuperado left join fetch grupoRecuperado.componentes", Grupo.class).list();

			for(Grupo elGrupo:listaGrupos) {

			    System.out.println(elGrupo.getGrupoId()  + " - "
			    			     + elGrupo.getNombre()   + " - "
			    				 + elGrupo.getOrigen()   + " - "
			    				 + elGrupo.getCreacion() + " - "
			    				 + elGrupo.getGenero());

			    System.out.print("    Componentes: ");

			    List<Componente>componentes=elGrupo.getComponentes();

			    for(int i=0;i<componentes.size();i++) {

			        Componente elComponente=componentes.get(i);

			        System.out.print(elComponente.getNombre()+"(" +elComponente.getInstrumento()+")");

			        if(i<componentes.size()-1) {
			        	
			            System.out.print(", ");
			            
			        }
			        
			    }
			    
			    System.out.println();

			}
		
			miSession.close();
		
		}
		
		catch(Exception miExcepcion) {
			/**
			 * imprime la pila si hay error
			 */
		    miExcepcion.printStackTrace();
		    
		}
		
	}

}
