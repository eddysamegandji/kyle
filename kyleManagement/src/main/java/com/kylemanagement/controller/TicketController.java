package com.kylemanagement.controller;

import com.api.handler.TicketResourceApi;
import com.api.model.TicketDto;
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
    final TicketService ticketService;

    @Override
    public ResponseEntity<TicketDto> createTicket(TicketDto ticketDto) {
        TicketDto createdTicket = ticketService.saveTicket(ticketDto);
        return createdTicket == null ? badRequest().build() : new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TicketDto> editTicket(Long id, TicketDto ticketDto) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTickets() {
        List<TicketDto> ticketDtos = ticketService.getTickets();
        return ticketDtos.isEmpty() ? noContent().build() : ok(ticketDtos);
    }
}
