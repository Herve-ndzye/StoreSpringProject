package com.mavicstudy.store.Repositories;

import com.mavicstudy.store.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository {
    @PersistenceContext
    private final EntityManager em;
    @Override
    public List<Product> findProductsByCriteria(String name, BigDecimal min, BigDecimal max) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        if(name!=null){
            predicates.add(cb.like(root.get("name"), "%"+name+"%"));
        }
        if(min!=null){
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), min));
        }
        if(max!=null){
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), max));
        }
        cq.select(root).where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
