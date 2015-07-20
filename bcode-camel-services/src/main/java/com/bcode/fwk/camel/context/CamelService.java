package com.bcode.fwk.camel.context;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.apache.camel.Route;
import org.apache.camel.component.cdi.CdiCamelContext;

import com.bcode.fwk.AbstractBase;
import com.bcode.fwk.camel.context.route.UneRoute;

@Singleton
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CamelService  extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6236186793728446918L;

	@Inject
    private CdiCamelContext camelCtx;
	
	@Inject
	private UneRoute maRoute;
	
	public CamelService(){
		super();
//		System.out.println("creation instance");
	}
	
	public void test(){
//		System.out.println("test");
		if(logger.isInfoEnabled()){
			logger.info("Appel a la methode test");
		}
	}
	
	@PostConstruct
	private void enregistrementRoute(){
		try {
			
			System.out.println("camelCtx.isStartingRoutes() " + camelCtx.isStartingRoutes());
			System.out.println("camelCtx.isStarted() " + camelCtx.isStarted());
			
			
            // Define Timer URI
			maRoute.setUriEndpoint("timer://simple?fixedRate=true&period=10s");
            
            


			//System.out.println(camelCtx.getRoutes().size());
			System.out.println("ajout des route " + maRoute);

            camelCtx.addRoutes(maRoute);
			System.out.println("1 " + camelCtx.getRoutes().size());
            camelCtx.start();			
			System.out.println("2 " + camelCtx.getRoutes().size());
			
		} catch (Exception e) {
			System.out.println("erreur sur l'ajout de la route");
			e.printStackTrace();
		}	
	}
	
	public void startCamel(final String idRoute){
		System.out.println("started with id "+ idRoute);
		try {
			List<Route> listRoute = camelCtx.getRoutes();
			for(Route item : listRoute){
				System.out.println(item.getId());
			}
			camelCtx.startRoute(idRoute);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				camelCtx.stopRoute(idRoute);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
	}
	
	@PreDestroy
	private void suppProcess(){
		try {
			logger.info("fin du process");
			camelCtx.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
