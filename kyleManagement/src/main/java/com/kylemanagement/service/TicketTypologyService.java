package com.kylemanagement.service;

import com.api.model.TicketTypologyDto;
import com.kylemanagement.model.TicketTypology;
import java.util.List;

public interface TicketTypologyService {

    TicketTypology saveTicketTypology(TicketTypology ticketTypology);
    TicketTypology findByTicketTypologyId(Long id);
    List<TicketTypology> getTicketTypologies();

}
