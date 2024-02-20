package com.kylemanagement.enums.ticket;

import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableMap;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public enum TicketPriorityEnum {
    VERYLOW(1),
    LOW(2),
    MEDIUM(3),
    HIGH(4),
    VERYHIGH(5);

    private static final Map<Integer, TicketPriorityEnum> mapById =
        unmodifiableMap(stream(values()).collect(toMap(TicketPriorityEnum::getId, identity())));

    private static final Map<String, TicketPriorityEnum> mapByCode =
        unmodifiableMap(stream(values()).collect(toMap(TicketPriorityEnum::getPriorityCode, identity())));

    private final int priorityId;

    TicketPriorityEnum(int priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityName() {
        return "PRIORITY." + this.name();
    }

    public String getPriorityCode() {
        return name();
    }

    public int getId() {
        return this.priorityId;
    }

    public static TicketPriorityEnum fromId(Integer id) {
        return Optional.of(mapById.get(id)).orElseThrow(IllegalArgumentException::new);
    }

    public static TicketPriorityEnum getEnum(String code) {
        return Optional.of(mapByCode.get(code)).orElseThrow(IllegalArgumentException::new);
    }
}
