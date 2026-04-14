/**
 * Clase: Componente
 * Autor: Javi
 * Fecha: 31/03/2026
 * 
 */
package es.accenture.servicios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.accenture.entidades.Componente;
import es.accenture.entidades.Grupo;

// TODO: Auto-generated Javadoc
/**
 * la clase AltaComponentesGrupo.
 */
public class AltaComponentesGrupo {

	/**
	 * el método main
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AltaComponentesGrupo nuevoAltaDeComponente=new AltaComponentesGrupo();
		
		nuevoAltaDeComponente.metodoParaDarDeAltaUnNuevoComponente();

	}
	
	/**
	 * Metodo para dar de alta un nuevo componente.
	 */
	public void metodoParaDarDeAltaUnNuevoComponente() {
		
		Session miSession=null;
		
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
				miSession=miFactory.openSession();
		
				/**
				 * se crea la transación para meter todo junto y enviar luego con el commit
				 */
				miSession.beginTransaction();

				/**
				 * se obtiene el grupo buscado
				 */
				Grupo grupo=miSession.get(Grupo.class,11);

				Componente componente1=new Componente("Michael Kiske","Voz");
		        Componente componente2=new Componente("Andi Deris","Voz");
		        Componente componente3=new Componente("Kai Hansen","Guitarra");
		        Componente componente4=new Componente("Ingo Schwichtenberg","Bateria");

		        /**
				 * se establece la relación bidireccional entre grupo y componente
				 */
		        componente1.setGrupo(grupo);
		        componente2.setGrupo(grupo);
		        componente3.setGrupo(grupo);
		        componente4.setGrupo(grupo);
        
		        grupo.getComponentes().add(componente1);
		        grupo.getComponentes().add(componente2);
		        grupo.getComponentes().add(componente3);
		        grupo.getComponentes().add(componente4);
		
		        miSession.save(componente1);
		        miSession.save(componente2);
		        miSession.save(componente3);
		        miSession.save(componente4);
				
		        /**
		    	 * se hace el commit para mandar toda la transación junta
		    	 */
				miSession.getTransaction().commit();
				
				miSession.close();
		
				}
		catch (Exception e) {
			
			/**
			 * se comprueba que está la conexión y sino se deshace todo
			 */

	        if (miSession!=null&&miSession.getTransaction()!=null) {
	        	
	            miSession.getTransaction().rollback();
	        }

	        e.printStackTrace();
	        
	    } finally {

	        if (miSession!=null) {
	        	
	        	/**
	        	 * se cierra la conexión si está abierta
	        	 */
	            miSession.close();
	            
	        }
	        
	    }

	}

}
