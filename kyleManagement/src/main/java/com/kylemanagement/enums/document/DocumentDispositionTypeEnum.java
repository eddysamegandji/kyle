package com.kylemanagement.enums.document;

import java.util.Arrays;

public enum DocumentDispositionTypeEnum {
	ATTACHMENT,
	INLINE,
	EXTERNAL;

	public static DocumentDispositionTypeEnum fromName(String name) {
        return Arrays.stream(values())
            .filter(e -> e.name().equalsIgnoreCase(name))
            .findAny()
            .orElse(null);
    }
}
