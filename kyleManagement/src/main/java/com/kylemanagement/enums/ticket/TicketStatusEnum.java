package com.kylemanagement.enums.ticket;

public enum TicketStatusEnum {

    TODO(1),
    INPROGRESS(2),
    RESERVED(3),
    TOBEVALIDATED (4),
    COMPLETED (5),
    CLOSED(6),
    CANCELLED(7);

    private final int ticketStatusId;

    TicketStatusEnum(int ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }
}
