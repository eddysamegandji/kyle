package com.kylemanagement.service.impl;

import com.api.model.TicketTypologyDto;
import com.kylemanagement.mapper.TicketTypologyMapper;
import com.kylemanagement.repository.TicketTypologyRepository;
import com.kylemanagement.service.TicketTypologyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketTypologyServiceImpl implements TicketTypologyService {

    final TicketTypologyRepository ticketTypologyRepository;
    final TicketTypologyMapper ticketTypologyMapper;


    @Override
    public TicketTypologyDto createTicketTypology(TicketTypologyDto ticketTypologyDto) {
        return null;
    }

    @Override
    public TicketTypologyDto findByTicketTypologyId(Long id) {
        return null;
    }

    @Override
    public List<TicketTypologyDto> getTicketTypologies() {
        return ticketTypologyRepository.findAll()
                .stream()
                .map(ticketTypologyMapper::toTicketTypologyDto)
                .toList();
    }
}
