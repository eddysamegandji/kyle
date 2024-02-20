package com.kylemanagement.controller;

import com.api.handler.TicketResourceApi;
import com.api.model.TicketDto;
import com.kylemanagement.mapper.TicketMapper;
import com.kylemanagement.model.Ticket;
import com.kylemanagement.service.TicketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class TicketController implements TicketResourceApi {

    final TicketMapper ticketMapper;
    final TicketService ticketService;

    @Override
    public ResponseEntity<TicketDto> createTicket(TicketDto ticketDto) {
        Ticket ticket = ticketService.saveTicket(ticketMapper.toTicket(ticketDto));
        if (ticket != null)
            return new ResponseEntity<>(ticketMapper.toTicketDto(ticket), HttpStatus.CREATED);
        return badRequest().build();
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTickets() {
        List<TicketDto> ticketDtos = ticketService.getTickets().stream().map(ticketMapper::toTicketDto).toList();
        return ticketDtos.isEmpty() ? noContent().build() : ok(ticketDtos);
    }
}
