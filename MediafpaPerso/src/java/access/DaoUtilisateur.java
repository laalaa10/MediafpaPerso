/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import javax.ejb.Stateless;
import model.Utilisateur;

@Stateless
public class DaoUtilisateur extends Dao<Utilisateur, Integer> {
	
	public DaoUtilisateur() {
		
	}
	
}
