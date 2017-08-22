/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoTypeCategorie;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.CategorieDocument;
import model.TypeCategorie;

/**
 *
 * @author Ouzin-Kane
 */
@Named
@SessionScoped
public class NavigationController implements Serializable {
    @Inject
    private DaoTypeCategorie daoTypeCat;
    private List<TypeCategorie> typeCat;
    
    public NavigationController (){
        
    }
    /* *** Getters et Setters *** */

    public DaoTypeCategorie getDaoTypeCat() {
        return daoTypeCat;
    }

    public void setDaoTypeCat(DaoTypeCategorie daoTypeCat) {
        this.daoTypeCat = daoTypeCat;
    }

    public List<TypeCategorie> getTypeCat() {
        return typeCat;
    }

    public void setTypeCat(List<TypeCategorie> typeCat) {
        this.typeCat = typeCat;
    }


    
    public void renvoyerGoodTypeCat(String nom){
      
        this.typeCat = this.daoTypeCat.rechercherParNomCategorie(nom);
        System.out.println("la cat "+this.typeCat);
    }
    
}
