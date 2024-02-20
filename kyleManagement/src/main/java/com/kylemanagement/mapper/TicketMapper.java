package com.kylemanagement.mapper;

import com.api.model.TicketDto;
import com.kylemanagement.model.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.mapstruct.*;
import org.springframework.format.annotation.DateTimeFormat;

import static java.util.Optional.ofNullable;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    TicketDto toTicketDto(Ticket ticket);

    @InheritInverseConfiguration
    Ticket toTicket(TicketDto ticketDto);

    default Long map(TicketTypology ticketTypology) {
        return ticketTypology.getTicketTypologyId();
    }
    default TicketTypology mapToTicketTypology(Long ticketTypologyId) {
        TicketTypology ticketTypology = new TicketTypology();
        ticketTypology.setTicketTypologyId(ticketTypologyId);
        return ticketTypology;
    }

    default Long map(Skill skill) {
        return skill.getSkillId();
    }
    default Skill mapToSkill(Long skillId) {
        Skill skill = new Skill();
        skill.setSkillId(skillId);
        return skill;
    }

    default Long map(Customer customer) {
        return customer.getCustomerId();
    }
    default Customer mapToCustomer(Long customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        return customer;
    }

}
