/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoTypeCategorie;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.TypeCategorie;


@RequestScoped
@Named

public class ConverterTypeCategorie implements Converter {
    @Inject
    private DaoTypeCategorie daotypeC;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
        return daotypeC.findByKey2(Integer.parseInt(value));
        }catch (NumberFormatException nfe){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if(value==null){
            return null;
        }
     //   return String.valueOf(((Categorie)value).getIdCat());
        return String.valueOf(((TypeCategorie)value).getIdTypeCategorie()) ;
        
    }

}
