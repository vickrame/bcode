///**
// * 
// */
//package com.bcode.fwk.swagger;
//
//import java.util.Set;
//
//import javax.ws.rs.ApplicationPath;
//import javax.ws.rs.core.Application;
//
///**
// * @author vickrame
// *
// */
//@ApplicationPath("rest")
//public class AppkicationConfig extends Application {
//
//	
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
//        resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
//        resources.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
//        resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
//        resources.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
//        addRestResourceClasses(resources);
//        return resources;
//    }
//
//    /**
//     * Do not modify addRestResourceClasses() method.
//     * It is automatically populated with
//     * all resources defined in the project.
//     * If required, comment out calling this method in getClasses().
//     */
//    private void addRestResourceClasses(Set<Class<?>> resources) {
//        resources.add(com.bcode.fwk.rest.RestAPI.class);
//    }
//}
