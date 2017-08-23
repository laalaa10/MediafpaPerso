/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
/**
 *
 * @author Ouzin-Kane
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import access.DaoCategorieDocument;
import access.DaoTypeCategorie;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.CategorieDocument;
import model.TypeCategorie;

@Named
@SessionScoped

public class ControllerCategorie implements Serializable {
    
    CategorieDocument categorieDocument;
    @Inject
    DaoCategorieDocument daoCategorieDocument;
    int selectionOneMenu;

    public ControllerCategorie() {
        categorieDocument=new CategorieDocument();
    }
    
    public void lire(){
        CategorieDocument tempC=daoCategorieDocument.findByKey2(categorieDocument.getIdCategorieDocument());
        if(tempC!=null){
            categorieDocument=tempC;
        }
        System.out.println("trouvé : "+categorieDocument);
    }
    
    public void lireSelectOne(){
        System.out.println("je lis la categorie selectionnée");
        CategorieDocument tempE=daoCategorieDocument.findByKey2(selectionOneMenu);
        System.out.println("La categorie sélectionnée est "+selectionOneMenu);
        System.out.println("categorie : "+categorieDocument.getNom());
        if(tempE!=null){
            categorieDocument=tempE;
        }
    }

    public void maj(){
        daoCategorieDocument.update(categorieDocument);
        System.out.println("Ecrire "+categorieDocument);
    }
    
    public List<CategorieDocument> renvoyerListeCategories(){
        return daoCategorieDocument.rechercherParCat();   
    }

    public CategorieDocument getCat() {
        return categorieDocument;
    }

    public void setCat(CategorieDocument cat) {
        this.categorieDocument = cat;
    }


    public DaoCategorieDocument getDaoCategorie() {
        return daoCategorieDocument;
    }

    public void setDaoCategorie(DaoCategorieDocument daoCategorie) {
        this.daoCategorieDocument = daoCategorie;
    }

    
    public int getSelectionOneMenu() {
        return selectionOneMenu;
    }

    public void setSelectionOneMenu(int selectionOneMenu) {
        this.selectionOneMenu = selectionOneMenu;
    }
public int recupSelectOneMenu(){
    return this.selectionOneMenu;
}
    
    
}
