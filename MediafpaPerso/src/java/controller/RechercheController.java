/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoDocument;
import access.DaoTypeCategorie;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Document;
import model.TypeCategorie;

@Named
@SessionScoped
public class RechercheController implements Serializable {
 private String nomAchercher;
 @Inject
 DaoDocument daoDocument;
 @Inject
 DaoTypeCategorie daotypeCategorie;
private List<Document> docfound;
private Document docSeleted;
private TypeCategorie typeCategorie;

	public RechercheController() {
		
	}

    public String getNomAchercher() {
        return nomAchercher;
    }

    public void setNomAchercher(String nomAchercher) {
        this.nomAchercher = nomAchercher;
    }

    public DaoDocument getDaoDocument() {
        return daoDocument;
    }

    public void setDaoDocument(DaoDocument daoDocument) {
        this.daoDocument = daoDocument;
    }

    public List<Document> getDocfound() {
        return docfound;
    }

    public void setDocfound(List<Document> docfound) {
        this.docfound = docfound;
    }

    public Document getDocSeleted() {
        return docSeleted;
    }

    public void setDocSeleted(Document docSeleted) {
        this.docSeleted = docSeleted;
    }

    public DaoTypeCategorie getDaotypeCategorie() {
        return daotypeCategorie;
    }

    public void setDaotypeCategorie(DaoTypeCategorie daotypeCategorie) {
        this.daotypeCategorie = daotypeCategorie;
    }

    public TypeCategorie getTypeCategorie() {
        return typeCategorie;
    }

    public void setTypeCategorie(TypeCategorie typeCategorie) {
        this.typeCategorie = typeCategorie;
    }
    

    public void rechercheDansCatalogue (String nom){
    this.docfound = this.daoDocument.rechercherParNom(nom);  
    }
    
    public void rechercheDansType (int id){
    typeCategorie = daotypeCategorie.findByKey(id);
    }
    
}
