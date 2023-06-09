/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.rajohnson.tpcustomerrajohnson.ejb;

/**
 *
 * @author LENOVO
 */
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import mg.itu.rajohnson.tpcustomerrajohnson.entities.Discount;

@Stateless
public class DiscountManager {

    @PersistenceContext
    private EntityManager em;

    public List<Discount> getAllDiscounts() {
//        Query query = em.createNamedQuery("Discount.findAll");
        Query query = em.createNamedQuery("Discount.findAllByRateAsc");
        return query.getResultList();
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

    public void persist(Discount discount) {
        em.persist(discount);
    }
}
