///**
// * 
// */
//package com.bcode.fwk.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Lob;
//import javax.persistence.NamedQuery;
//
///**
// * @author vickrame
// *
// */
//@Entity
//@NamedQuery(name="DetailRecette.findAll", query="select d from detailRecette d")
//public class DetailRecette {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID_RECETTE_DETAIL", updatable = false)
//	private int idRecetteDetail;
//
//	@Lob
//	private byte[] image;
//
//	@Lob
//	@Column(name = "INGREDIENT_JSON")
//	private byte[] ingredientJson;
// }
