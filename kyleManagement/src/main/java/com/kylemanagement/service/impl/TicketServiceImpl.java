package com.kylemanagement.service.impl;

import com.api.model.TicketApi;
import com.kylemanagement.dao.TicketDao;
import com.kylemanagement.mapper.TicketMapper;
import com.kylemanagement.model.Skill;
import com.kylemanagement.model.Ticket;
import com.kylemanagement.service.SecurityContextService;
import com.kylemanagement.service.TicketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    final SecurityContextService securityContextService;
    final TicketDao ticketDao;
    final TicketMapper ticketMapper;

    @Override
    public List<TicketApi> getTickets() {
        List<Long> skills = securityContextService.getLoggedUser().getSkills()
                .stream().map(Skill::getSkillId).toList();

        List<Ticket> tickets = ticketDao.findTicketsBySkills(skills);
        return ticketDao.findTicketsBySkills(skills).stream().map(ticketMapper::toTicketApi).toList();
    }
}
