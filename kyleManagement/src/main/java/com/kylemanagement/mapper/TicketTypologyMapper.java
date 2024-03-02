package com.kylemanagement.mapper;

import com.api.model.TicketTypologyDto;
import com.kylemanagement.model.TicketTypology;
import org.mapstruct.*;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketTypologyMapper {

    TicketTypologyDto toTicketTypologyDto(TicketTypology ticketTypology);

    @InheritInverseConfiguration
    @Mapping(target = "ticketTypologyId", ignore = true)
    TicketTypology toTicketTypology(TicketTypologyDto ticketTypologyDto, @MappingTarget TicketTypology ticketTypology);
}
