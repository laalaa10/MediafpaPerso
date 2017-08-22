/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoAdresse;
import access.DaoUtilisateur;
import java.io.Serializable;
import java.sql.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import model.Adresse;
import model.Utilisateur;
import javax.inject.Named;

/**
 *
 * @author Ouzin-Kane
 */
@Named
@SessionScoped

public class ControllerUser implements Serializable{
 private String nom,prenom,mail,telephone,numeroRue,voie,cp,ville;
 private boolean formation;
 private Utilisateur user; 
 private Date dateDeNaiss;
 private Adresse adress;
 
 @Inject
 DaoAdresse daoAdresse;
 @Inject
 DaoUtilisateur daoUtilisateur;
 
 public ControllerUser(){
   this.user = new Utilisateur();   
 }
 /* *** Getters et Setters *** */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public boolean isFormation() {
        return formation;
    }

    public void setFormation(boolean formation) {
        this.formation = formation;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Date getDateDeNaiss() {
        return dateDeNaiss;
    }

    public void setDateDeNaiss(Date dateDeNaiss) {
        this.dateDeNaiss = dateDeNaiss;
    }

    public Adresse getAdress() {
        return adress;
    }

    public void setAdress(Adresse adress) {
        this.adress = adress;
    }

    public DaoAdresse getDaoAdresse() {
        return daoAdresse;
    }

    public void setDaoAdresse(DaoAdresse daoAdresse) {
        this.daoAdresse = daoAdresse;
    }

    public DaoUtilisateur getDaoUtilisateur() {
        return daoUtilisateur;
    }

    public void setDaoUtilisateur(DaoUtilisateur daoUtilisateur) {
        this.daoUtilisateur = daoUtilisateur;
    }
    
    
 /* *** Methodes *** */
 public void newAdress(){
this.adress=new Adresse();
this.adress.setCp(this.getCp());
this.adress.setNumero(this.getNumeroRue());
this.adress.setVoie(this.getVoie());
this.adress.setVille(this.getVille());
this.daoAdresse.write(this.getAdress());
 }   
 
public void newUser (){
 this.newAdress();
 this.user.setIdAdresse(adress);
 this.user.setDateNaissance(dateDeNaiss);
 this.user.setNom(nom);
 this.user.setPrenom(prenom);
 this.setMail(mail);
 this.user.setTelephone(telephone);
 this.daoUtilisateur.write(user);
 
}
 
}
