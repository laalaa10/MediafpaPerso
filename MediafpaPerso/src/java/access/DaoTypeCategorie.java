/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.List;
import javax.ejb.Stateless;
import model.TypeCategorie;

@Stateless
public class DaoTypeCategorie extends Dao<TypeCategorie, Integer> {
	
	public DaoTypeCategorie() {
		
	}
        public List<TypeCategorie> rechercherParCat (){
           return em.createNativeQuery("select * from type_categorie").getResultList();
   
        }
        	public TypeCategorie findByKey2(int num) {
                return (TypeCategorie) em.createNativeQuery("select * from type_categorie where id_type_categorie='"+num+"'",TypeCategorie.class).getSingleResult();                
	}

	
}
