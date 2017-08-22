/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoCategorieNouvelle;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.CategorieNouvelle;
import model.Nouvelle;

/**
 *
 * @author Ouzin-Kane
 */

@Named
@SessionScoped
public class ControllerNouvelle implements Serializable {
   private String titre,contenu,nomCatNouvelle;
   private Date dateDeRedaction;
   private Nouvelle nouvelle;
   private CategorieNouvelle categorieNouvelle;
   private int idNouvelleCategorie;
@Inject
Controller controller;
@Inject
ControllerUser controllerUser;
@Inject
private DaoCategorieNouvelle daoCategorieNouvelle;

   public ControllerNouvelle(){
     this.nouvelle = new Nouvelle();  
   }
   
   
   /* *** Getters et Setters *** */

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getNomCatNouvelle() {
        return nomCatNouvelle;
    }

    public void setNomCatNouvelle(String nomCatNouvelle) {
        this.nomCatNouvelle = nomCatNouvelle;
    }

    public Date getDateDeRedaction() {
        return dateDeRedaction;
    }

    public void setDateDeRedaction(Date dateDeRedaction) {
        this.dateDeRedaction = dateDeRedaction;
    }

    public Nouvelle getNouvelle() {
        return nouvelle;
    }

    public void setNouvelle(Nouvelle nouvelle) {
        this.nouvelle = nouvelle;
    }

    public CategorieNouvelle getCategorieNouvelle() {
        return categorieNouvelle;
    }

    public void setCategorieNouvelle(CategorieNouvelle categorieNouvelle) {
        this.categorieNouvelle = categorieNouvelle;
    }

    public int getIdNouvelleCategorie() {
        return idNouvelleCategorie;
    }

    public void setIdNouvelleCategorie(int idNouvelleCategorie) {
        this.idNouvelleCategorie = idNouvelleCategorie;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public ControllerUser getControllerUser() {
        return controllerUser;
    }

    public void setControllerUser(ControllerUser controllerUser) {
        this.controllerUser = controllerUser;
    }

    public DaoCategorieNouvelle getDaoCategorieNouvelle() {
        return daoCategorieNouvelle;
    }

    public void setDaoCategorieNouvelle(DaoCategorieNouvelle daoCategorieNouvelle) {
        this.daoCategorieNouvelle = daoCategorieNouvelle;
    }
   

   /* **** Methodes **** */
    public void renvoyerCategorieNouvelle(){
       categorieNouvelle = daoCategorieNouvelle.findByKey(idNouvelleCategorie);
       System.out.println("La catnouvelle est : "+this.categorieNouvelle);  
    }

   public void creerNouvelle(){
       
    nouvelle.setTitre(titre);
    nouvelle.setContenu(contenu);
    nouvelle.setDate(dateDeRedaction);
    nouvelle.setIdCategorieNouvelle(categorieNouvelle);
    nouvelle.setIdAuteur(controllerUser.getUser());
   }
}
