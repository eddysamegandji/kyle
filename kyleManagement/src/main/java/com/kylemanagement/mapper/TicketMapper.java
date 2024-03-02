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
    @Mapping(target = "ticketId", ignore = true)
    Ticket toTicket(TicketDto ticketDto, @MappingTarget Ticket ticket);

}
