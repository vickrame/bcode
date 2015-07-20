///**
// * 
// */
//package com.prios.ws.services.demo;
//
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebService;
//import javax.jws.soap.SOAPBinding;
//import javax.jws.soap.SOAPBinding.ParameterStyle;
//import javax.jws.soap.SOAPBinding.Style;
//import javax.jws.soap.SOAPBinding.Use;
//import javax.xml.ws.BindingType;
//import javax.xml.ws.soap.MTOM;
//
///**
// * @author vickrame
// *
// */
//@MTOM
//@WebService
//@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING)
//@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED, style=Style.DOCUMENT, use=Use.LITERAL)
//public interface Reservation {
//
//	@WebMethod
//	public boolean estReserve(@WebParam(name= "nom") String nomPersonne,  @WebParam(name="date") String date) ;
//	
//}
