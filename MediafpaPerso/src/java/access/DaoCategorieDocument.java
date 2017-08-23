/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.List;
import javax.ejb.Stateless;
import model.CategorieDocument;

@Stateless
public class DaoCategorieDocument extends Dao<CategorieDocument, Integer> {
	
	public DaoCategorieDocument() {
		
	}
	        public List<CategorieDocument> renvoyerToutesCategories (){
           return em.createNativeQuery("select * from categorie_document",CategorieDocument.class).getResultList();
   
        }
        	public CategorieDocument findByKey2(int id) {
                return (CategorieDocument) em.createNativeQuery("select * from categorie_document where id_categorie_document='"+id+"'",CategorieDocument.class).getSingleResult();                
	}

	
}
