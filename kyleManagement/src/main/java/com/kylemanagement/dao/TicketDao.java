package com.kylemanagement.dao;

import com.kylemanagement.model.Ticket;
import java.util.List;

public interface TicketDao {

    List<Ticket> findTicketsBySkills(List<Long> skills);
}
