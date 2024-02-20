package com.kylemanagement.service.impl;

import com.kylemanagement.model.Ticket;
import com.kylemanagement.model.User;
import com.kylemanagement.repository.TicketRepository;
import com.kylemanagement.service.TicketService;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    final UserDetailsService userDetailsService;
    final TicketRepository ticketRepository;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        ticket.setCreationUser((User) userDetailsService.loadUserByUsername("admin"));
        ticket.setCreationDate(Instant.now());
        ticket.setLastModifiedDate(Instant.now());
        ticket.setModifiedUser((User) userDetailsService.loadUserByUsername("admin"));
        ticketRepository.save(ticket);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }
}
