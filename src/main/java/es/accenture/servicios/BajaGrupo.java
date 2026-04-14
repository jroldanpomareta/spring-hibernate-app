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

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * la clase BajaGrupo.
 */
public class BajaGrupo {

    /**
     * el método main
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        BajaGrupo darDeBaja = new BajaGrupo();
        darDeBaja.metodoParaDarDeBajaUltimoGrupoAnadidoYSusComponentes();
    }

    /**
     * Metodo para dar de baja ultimo grupo anadido Y sus componentes.
     */
    public void metodoParaDarDeBajaUltimoGrupoAnadidoYSusComponentes() {

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
				 * se obtiene el último grupo insertado cogiendo el que tiene mayor Id
				 */
            	Grupo grupoAEliminar=miSession.createQuery("from Grupo order by grupoId desc",Grupo.class).setMaxResults(1).uniqueResult();

            if(grupoAEliminar!=null) {

                /**
				 * se borra el grupo y al estar en cascada elimina también los componentes
				 */
                miSession.delete(grupoAEliminar);
                /**
				 * se imprime mensaje de confirmación
				 */
                System.out.println("El último grupo que se había insertado y sus componentes han sido eliminados");
                
            }
            /**
			 * se guarda y se envía la transación con el commit
			 */
            miSession.getTransaction().commit();

        } catch (Exception miExcepcion) {
        	/**
			 * se comprueba que está la transación activa y sino se deshace todo
			 */
            if (miSession!=null&&miSession.getTransaction()!=null) {
                miSession.getTransaction().rollback();
            }

            miExcepcion.printStackTrace();

        } finally {
        	/**
        	 * se cierra la conexión si está abierta
        	 */
            if(miSession!=null) {
            	
                miSession.close();
                
            }
            
        }
        
    }
    
}