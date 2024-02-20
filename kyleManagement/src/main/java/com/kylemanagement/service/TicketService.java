package com.kylemanagement.service;

import com.kylemanagement.model.Ticket;
import java.util.List;

public interface TicketService {
    Ticket saveTicket(Ticket ticket);
    List<Ticket> getTickets();
}
