package com.kylemanagement.controller;

import com.api.handler.TicketResourceApi;
import com.api.model.TicketApi;
import com.kylemanagement.service.TicketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TicketController implements TicketResourceApi {

    final TicketService ticketService;

    @Override
    public ResponseEntity<List<TicketApi>> listTickets() {
        return ok(ticketService.getTickets());
    }
}
