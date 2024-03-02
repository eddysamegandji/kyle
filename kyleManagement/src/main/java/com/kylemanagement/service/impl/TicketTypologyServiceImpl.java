package com.kylemanagement.service.impl;

import com.kylemanagement.model.TicketTypology;
import com.kylemanagement.repository.TicketRepository;
import com.kylemanagement.repository.TicketTypologyRepository;
import com.kylemanagement.service.TicketService;
import com.kylemanagement.service.TicketTypologyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketTypologyServiceImpl implements TicketTypologyService {

    final TicketTypologyRepository ticketTypologyRepository;

    @Override
    public TicketTypology saveTicketTypology(TicketTypology ticketTypology) {
        return null;
    }

    @Override
    public TicketTypology findByTicketTypologyId(Long id) {
        return null;
    }

    @Override
    public List<TicketTypology> getTicketTypologies() {
        return ticketTypologyRepository.findAll();
    }
}
