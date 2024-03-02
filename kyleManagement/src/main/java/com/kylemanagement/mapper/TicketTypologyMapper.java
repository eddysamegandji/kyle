package com.kylemanagement.mapper;

import com.api.model.TicketTypologyDto;
import com.kylemanagement.model.TicketTypology;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketTypologyMapper {

    TicketTypologyDto toTicketTypologyDto(TicketTypology ticketTypology);

    @InheritInverseConfiguration
    TicketTypology toTicketTypology(TicketTypologyDto ticketTypologyDto);
}
