package com.kylemanagement.service;

import com.api.model.TicketTypologyDto;
import com.kylemanagement.model.TicketTypology;
import java.util.List;

public interface TicketTypologyService {

    TicketTypologyDto createTicketTypology(TicketTypologyDto ticketTypologyDto);
    TicketTypologyDto findByTicketTypologyId(Long id);
    List<TicketTypologyDto> getTicketTypologies();

}
