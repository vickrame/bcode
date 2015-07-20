///**
// * 
// */
//package com.bcode.fwk.swagger;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//
//import com.wordnik.swagger.config.ConfigFactory;
//import com.wordnik.swagger.config.ScannerFactory;
//import com.wordnik.swagger.config.SwaggerConfig;
//import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
//import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
//import com.wordnik.swagger.reader.ClassReaders;
//
///**
// * @author vickrame
// *
// */
//@WebServlet(loadOnStartup=1, name="configuration de la servlet swagger",urlPatterns={"/config"})
//public class SwaggerServlet extends HttpServlet {
//
//	
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 5428605526058216302L;
//
//	
//
//
//
//	/* (non-Javadoc)
//	 * @see javax.servlet.GenericServlet#init()
//	 */
//	@Override
//    public void init(ServletConfig servletConfig) {
//        try {
//            super.init(servletConfig);
//            SwaggerConfig swaggerConfig = new SwaggerConfig();
//            ConfigFactory.setConfig(swaggerConfig);
//            swaggerConfig.setBasePath("http://localhost:8080/bcode-camel/rest");
//            swaggerConfig.setApiVersion("1.0.0");
//            ScannerFactory.setScanner(new DefaultJaxrsScanner());
//            ClassReaders.setReader(new DefaultJaxrsApiReader());
//        } catch (ServletException e) {
//            System.out.println(e.getMessage());
//        }
//	}
// }
