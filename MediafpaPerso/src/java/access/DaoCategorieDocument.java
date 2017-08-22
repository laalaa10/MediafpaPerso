/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import javax.ejb.Stateless;
import model.CategorieDocument;

@Stateless
public class DaoCategorieDocument extends Dao<CategorieDocument, Integer> {
	
	public DaoCategorieDocument() {
		
	}
	
}
