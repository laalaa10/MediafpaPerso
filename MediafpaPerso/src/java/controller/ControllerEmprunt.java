/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Emprunter;

/**
 *
 * @author Ouzin-Kane
 */
@Named
@SessionScoped
public class ControllerEmprunt implements Serializable {
  private Date dateEmprunt, dateRetour;  
  private Emprunter emprunter;
  @Inject
  private ControllerUser controllerUser;
  @Inject
  private Controller controller;
  
  
  
  public ControllerEmprunt(){
  this.emprunter=new Emprunter();    
  }
  
    /* *** Getters et Setters *** */

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Emprunter getEmprunter() {
        return emprunter;
    }

    public void setEmprunter(Emprunter emprunter) {
        this.emprunter = emprunter;
    }

    public ControllerUser getControllerUser() {
        return controllerUser;
    }

    public void setControllerUser(ControllerUser controllerUser) {
        this.controllerUser = controllerUser;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

  
  /* *** Methodes *** */
   
   // Creer un npuvel emprunt  
    
  public void nouvelEmprunt(){
    //  emprunter.setIdExemplaire(controller.getDoc());
      emprunter.setDateEmprunt(dateEmprunt);
      emprunter.setIdUtilisateur(controllerUser.getUser());
      emprunter.setDateRetour(dateRetour);
  }
  
}
