package com.springboot.springbatchprocessor.repo;

import com.springboot.springbatchprocessor.entity.BizData;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SearchNativeRepo {

    @Autowired
    EntityManager entityManager;

    CriteriaBuilder criteriaBuilder = null;
    Root<BizData> bizDataRoot = null;
    CriteriaQuery<BizData> criteriaQuery = null;

    public List<BizData> getBySearchCriteria(Map<String, String> map) {
        criteriaBuilder = entityManager.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(BizData.class);
        bizDataRoot = criteriaQuery.from(BizData.class);
        List<Predicate> predicates = buildPredicates(criteriaBuilder, map);
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        List<BizData> items = entityManager.createQuery(criteriaQuery).getResultList();
        return items;
    }

    private List<Predicate> buildPredicates(CriteriaBuilder criteriaBuilder, Map<String, String> map) {
        List<Predicate> predicates = new ArrayList<>();
        map.forEach((k, v) -> {
            if(ObjectUtils.notEqual(v, null)){
                Predicate predicate = criteriaBuilder.equal(bizDataRoot.get(k), v);
                predicates.add(predicate);
               // criteriaBuilder.and(predicate);
            }
        });
        return predicates;
    }

}
