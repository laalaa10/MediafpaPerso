/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.jodah.typetools.TypeResolver;


public class Dao<T, K extends Serializable> {
	
	protected Class<T> persistentClass;
	protected Class<K> idClass;
	
	@PersistenceContext(unitName="MediafpaPU")
	protected EntityManager em;
	
	public Dao() {
		Class<?>[] typeArguments = TypeResolver.resolveRawArguments(Dao.class, getClass());
		this.persistentClass = (Class<T>)typeArguments[0];
		this.idClass = (Class<K>) typeArguments[1];
	}
	
	public T findByKey(K key) {
		return (T)em.find(persistentClass, key);
	}
	
	public void write(T object) {
		try {
			em.persist(object);
		} catch(javax.ejb.EJBException e) {
			System.out.println("EJBException : " + e.getLocalizedMessage());
		}
	}
	
	public void update(T object) {
		try {
			em.merge(object);
		} catch(javax.ejb.EJBException e) {
			System.out.println("EJBException : " + e.getLocalizedMessage());
		}
	}
	
	public void refresh(T object) {
		try {
			em.refresh(object);
		} catch(javax.ejb.EJBException e) {
			System.out.println("EJBException : " + e.getLocalizedMessage());
		}
	}
	
	public void remove(T object) {
		try {
			T newObject = em.merge(object);
			em.remove(newObject);
		} catch(javax.ejb.EJBException e) {
			System.out.println("EJBException : " + e.getLocalizedMessage());
		}
	}
	
	public List<T> findAll() {
		return em.createNativeQuery("select * from " + persistentClass.getSimpleName().toLowerCase(), persistentClass).getResultList();
	}
	    public List<T> rechercherParNom(String nom){
            return em.createNativeQuery("select * from " + persistentClass.getSimpleName().toLowerCase()+" where titre like \"%"+nom+"%\"", persistentClass).getResultList();
        }
	    public List<T> rechercherParNomCategorie(String nom){
            return em.createNativeQuery("select * from " + persistentClass.getSimpleName().toLowerCase()+" where nom = "+nom, persistentClass).getResultList();
        }
        
}
