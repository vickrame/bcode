///**
// * 
// */
//package com.prios.ws.services.demo;
//
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebService;
//import javax.jws.soap.SOAPBinding;
//import javax.jws.soap.SOAPBinding.ParameterStyle;
//import javax.jws.soap.SOAPBinding.Style;
//import javax.jws.soap.SOAPBinding.Use;
//import javax.xml.ws.BindingType;
//
//import com.bcode.fwk.camel.context.CamelService;
//
///**
// * @author vickrame
// *
// */
//@Stateless
////@WebService(name="ReservationImpl")
//
//
//// GLASFISH
//@WebService(serviceName="ReservationImplService", portName = "ReservationImplService")//, wsdlLocation = "WEB-INF/wsdl/ReservationImplService.wsdl")
//// LIBERTY
////@WebService(serviceName="ReservationImplService", wsdlLocation="META-INF/wsdl/ReservationImplService.wsdl")
//
////@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
//@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING)
//@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED, use=Use.LITERAL, style=Style.DOCUMENT)
////@Addressing(enabled=true, required = true)
////@RolesAllowed({"CONSULT","WRITE"})
//public class ReservationImpl implements Reservation {
//
//
//	@Inject
//	private CamelService camelService;
//
//	@WebMethod
//	public boolean estReserve(@WebParam(name="nomPersonne") String nomPersonne,  @WebParam(name="date") String date)
//			 {
//		System.out.println("param " + nomPersonne + " ; date " + date);
////		camelService.startCamel("123456789");
//		return true;
//	}
//}
