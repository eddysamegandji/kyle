package com.kylemanagement.repository;

import com.kylemanagement.model.TicketTypology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypologyRepository extends JpaRepository<TicketTypology, Long> {
}
