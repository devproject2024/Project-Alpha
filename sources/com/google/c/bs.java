package com.google.c;

import java.util.Collections;
import java.util.List;

public final class bs extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public bs(at atVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public bs(List<String> list) {
        super(buildDescription(list));
        this.missingFields = list;
    }

    public final List<String> getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }

    public final ad asInvalidProtocolBufferException() {
        return new ad(getMessage());
    }

    private static String buildDescription(List<String> list) {
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z = true;
        for (String next : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        return sb.toString();
    }
}
