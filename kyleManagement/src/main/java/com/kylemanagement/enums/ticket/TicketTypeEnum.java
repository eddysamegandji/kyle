package com.kylemanagement.enums.ticket;

public enum TicketTypeEnum {

    RENTAL(1),
    SALE(2);

    private final int ticketTypeId;

    TicketTypeEnum(int ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }
}
