package com.kylemanagement.mapper;

import com.api.model.TicketDto;
import com.kylemanagement.model.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.mapstruct.*;
import org.springframework.format.annotation.DateTimeFormat;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {

    TicketDto toTicketDto(Ticket ticket);

    @InheritInverseConfiguration
    Ticket toTicket(TicketDto ticketDto);

    default Long map(TicketTypology ticketTypology) {
        return ofNullable(ticketTypology)
                .map(TicketTypology::getTicketTypologyId)
                .orElse(null);
    }
    default TicketTypology mapToTicketTypology(Long ticketTypologyId) {
        if (ticketTypologyId == null)
            return null;
        TicketTypology ticketTypology = new TicketTypology();
        ticketTypology.setTicketTypologyId(ticketTypologyId);
        return ticketTypology;
    }

    default Long map(Skill skill) {
        return ofNullable(skill)
                .map(Skill::getSkillId)
                .orElse(null);
    }
    default Skill mapToSkill(Long skillId) {
        if (skillId == null)
            return null;
        Skill skill = new Skill();
        skill.setSkillId(skillId);
        return skill;
    }

    default Long map(Customer customer) {
       return ofNullable(customer)
                .map(Customer::getCustomerId)
                .orElse(null);
    }
    default Customer mapToCustomer(Long customerId) {
        if (customerId == null)
            return null;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        return customer;
    }

}
