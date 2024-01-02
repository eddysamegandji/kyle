package com.kylemanagement.dao.Impl;

import com.kylemanagement.dao.TicketDao;
import com.kylemanagement.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TicketDaoImpl implements TicketDao {

    private final EntityManager entityManager;

    @Override
    public List<Ticket> findTicketsBySkills(List<Long> skills) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
        Root<Ticket> root = cq.from(Ticket.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add((root.get("skill").get("id").in(skills)));
        return entityManager.createQuery(cq).getResultList();
    }
}
