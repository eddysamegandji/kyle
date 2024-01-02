package com.kylemanagement.mapper;

import com.api.model.TicketApi;
import com.kylemanagement.model.Ticket;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TicketMapper {

    @Mapping(target = "id", source = "ticketId")
    @Mapping(target = "creationDate", expression = "java(map(ticket.getCreationDate()))")
    @Mapping(target = "ticketType", source = "ticketType")
    TicketApi toTicketApi(Ticket ticket);

    default Date map(Instant value){
        return value != null ? Date.from(value) : null;
    }
}
