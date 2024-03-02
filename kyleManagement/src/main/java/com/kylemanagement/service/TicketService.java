package com.kylemanagement.service;

import com.api.model.TicketDto;
import java.util.List;

public interface TicketService {
    TicketDto saveTicket(TicketDto ticket);
    List<TicketDto> getTickets();
}
