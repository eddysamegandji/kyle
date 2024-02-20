package com.kylemanagement.enums.ticket;

public enum TicketStatusEnum {

    TODO (1),
    RESERVED (2),
    INPROGRESS (3),
    PENDING (4),
    TOBEVALIDATED (5),
    COMPLETED (6),
    CANCELED (7),
    START (8);

    private final int id;

    TicketStatusEnum(int id) {
        this.id = id;
    }
}
