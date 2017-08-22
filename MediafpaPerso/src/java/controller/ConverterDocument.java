/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoDocument;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import model.Document;


@RequestScoped
@Named
public class ConverterDocument implements Converter {

    @Inject
    private DaoDocument daoDoc;
        
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return daoDoc.findByKey(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        return String.valueOf(((Document)value).getIdDocument());
    }


    
}
