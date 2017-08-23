/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoCategorieDocument;
import access.DaoCategorieNouvelle;
import access.DaoDocument;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.CategorieDocument;
import model.CategorieNouvelle;
import model.Document;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Ouzin-Kane
 */
@Named
@SessionScoped
public class Controller implements Serializable{
      @Inject
      private DaoCategorieDocument daoCategorieDocument;
      @Inject
      private DaoDocument daoDocument;
      private List<CategorieDocument> categoriesDocument;
      private CategorieDocument catDoc;
      private Document Doc;
      private List<Document> document;
      int selectionOneMenu;
      private List<Document> DocAAfficher;
      private CategorieDocument selectedCategorie;
      private List<Document> selectedDocument;
      double result;
      


      public Controller (){
           
      }

        @PostConstruct
	public void Initialization() {
		//categoriesDocument = daoCategorieDocument.findAll();
		document = daoDocument.findAll();
		DocAAfficher = document;
	}
        
    public List<Document> getDocument() {
        return document;
    }

    /*************************************  Getters et Setters ******************************************/
    

    public void selectCategorie() {
        System.out.println("tuttutt");
        System.out.println("La categorie Selectionnée est "+ this.selectedCategorie.getNom());
//		document = daoDocument.findAll();
		
		CategorieDocument categorieDoc = selectedCategorie;
		
		if(categorieDoc != null) {
			DocAAfficher = categorieDoc.getDocumentList(); //jpa
		} else {
			DocAAfficher = document;
		}
                System.out.println("les Documents A Afficher "+DocAAfficher);
	}
    
    
    
    
    
public void test (){
    System.out.println("gnein gnein gnien");
}

    public int getSelectionOneMenu() {
        return selectionOneMenu;
    }

    public void setSelectionOneMenu(int selectionOneMenu) {
        this.selectionOneMenu = selectionOneMenu;
    }

    public DaoCategorieDocument getDaoCategorieDocument() {
        return daoCategorieDocument;
    }

    public void setDaoCategorieDocument(DaoCategorieDocument daoCategorieDocument) {
        this.daoCategorieDocument = daoCategorieDocument;
    }

    public DaoDocument getDaoDocument() {
        return daoDocument;
    }

    public void setDaoDocument(DaoDocument daoDocument) {
        this.daoDocument = daoDocument;
    }

    public List<CategorieDocument> getCategoriesDocument() {
        return categoriesDocument;
    }

    public void setCategoriesDocument(List<CategorieDocument> categoriesDocument) {
        this.categoriesDocument = categoriesDocument;
    }

    public CategorieDocument getCatDoc() {
        return catDoc;
    }

    public void setCatDoc(CategorieDocument catDoc) {
        this.catDoc = catDoc;
    }

    public Document getDoc() {
        return Doc;
    }

    public void setDoc(Document Doc) {
        this.Doc = Doc;
    }

    public List<Document> getDocAAfficher() {
        return DocAAfficher;
    }

    public void setDocAAfficher(List<Document> DocAAfficher) {
        this.DocAAfficher = DocAAfficher;
    }

    public CategorieDocument getSelectedCategorie() {
        return selectedCategorie;
    }

    public void setSelectedCategorie(CategorieDocument selectedCategorie) {
        this.selectedCategorie = selectedCategorie;
    }

    public List<Document> getSelectedDocument() {
        return selectedDocument;
    }

    public void setSelectedDocument(List<Document> selectedDocument) {
        this.selectedDocument = selectedDocument;
    }
    

    public int recupSelectOneMenuArt(){
        return this.selectionOneMenu;
    }

    /* Renvoyer la liste de tout les documents*/
    public List afficherAllDoc(){ 
       return this.daoCategorieDocument.findAll();
    }
   /*     public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
      public void AffichArtLignSelected() {
        
          try {
              FacesContext.getCurrentInstance().getExternalContext().redirect("/TopCommerceNet/faces/detailProduit.xhtml");
          } catch (IOException ex) {
              Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
          }
       
    }

}
