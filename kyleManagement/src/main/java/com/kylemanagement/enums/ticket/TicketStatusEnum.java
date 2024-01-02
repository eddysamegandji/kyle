package com.kylemanagement.enums.ticket;

public enum TicketStatusEnum {

    TODO(1),
    INPROGRESS(2),
    RESERVED(3),
    CLOSED(4),
    CANCELLED(5);

    private final int ticketStatusId;

    TicketStatusEnum(int ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }
}
