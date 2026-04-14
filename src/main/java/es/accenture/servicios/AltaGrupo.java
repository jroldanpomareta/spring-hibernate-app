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

import es.accenture.entidades.Grupo;

// TODO: Auto-generated Javadoc
/**
 * La clase AltaGrupo.
 */
public class AltaGrupo {

	/**
	 * el método main
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AltaGrupo nuevoAltaGrupo=new AltaGrupo();
		
		nuevoAltaGrupo.metodoParaDarDeAltaGrupo();

	}
	
	/**
	 * Metodo para dar de alta grupo.
	 */
	public void metodoParaDarDeAltaGrupo() {
		
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
				 * se crea el grupo con los parámetros
				 */
				Grupo nuevoGrupo=new Grupo("Helloween",1978,"Hamburgo","Power metal");
		
				miSession.save(nuevoGrupo);
				
				/**
				 * se guarda y se envía la transación con el commit
				 */
				miSession.getTransaction().commit();
		
			} catch(Exception miExcepcion) {
				
				/**
				 * se comprueba que está la conexión y sino se deshace todo
				 */

				if(miSession!=null&&miSession.getTransaction()!=null) {
	        	
					miSession.getTransaction().rollback();
	            
				}

				miExcepcion.printStackTrace();
	        
			} finally {

				if(miSession!=null) {
					
					/**
		        	 * se cierra la conexión si está abierta
		        	 */
	        	
					miSession.close();
	            
				}
	        
			}
		
	}

}
