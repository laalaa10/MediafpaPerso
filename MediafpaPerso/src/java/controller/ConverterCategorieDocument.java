/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoCategorieDocument;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.CategorieDocument;


@RequestScoped
@Named

public class ConverterCategorieDocument implements Converter {
    @Inject
    private DaoCategorieDocument daoCategorieDocument;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
        return daoCategorieDocument.findByKey2(Integer.parseInt(value));
        }catch (NumberFormatException nfe){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if(value==null){
            return null;
        }
        return String.valueOf(((CategorieDocument)value).getIdCategorieDocument()) ;
        
    }

}
