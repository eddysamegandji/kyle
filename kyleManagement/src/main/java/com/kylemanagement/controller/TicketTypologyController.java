package com.kylemanagement.controller;

import com.api.handler.TypologyResourceApi;
import com.api.model.TicketTypologyDto;
import com.kylemanagement.service.TicketTypologyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class TicketTypologyController implements TypologyResourceApi {

    final TicketTypologyService ticketTypologyService;

    @Override
    public ResponseEntity<TicketTypologyDto> createTypology(TicketTypologyDto ticketTypologyDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<TicketTypologyDto>> getTypologies() {
        List<TicketTypologyDto> ticketTypologyDtos = ticketTypologyService.getTicketTypologies();
        return ticketTypologyDtos.isEmpty() ? noContent().build() : ok(ticketTypologyDtos);
    }
}
