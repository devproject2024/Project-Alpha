package com.travel.train.i;

public enum ae {
    CANCELLATION_TYPE(199, "cancellation_type"),
    HEADER_TYPE(200, "HEADER_TYPE"),
    ENTRY_TYPE(201, "ENTRY_TYPE"),
    INS_TYPE(202, "INS_TYPE");
    
    private int index;
    private String name;

    private ae(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static ae fromName(String str) {
        for (ae aeVar : values()) {
            if (aeVar.name.equalsIgnoreCase(str)) {
                return aeVar;
            }
        }
        return ENTRY_TYPE;
    }

    public static ae fromIndex(int i2) {
        for (ae aeVar : values()) {
            if (aeVar.index == i2) {
                return aeVar;
            }
        }
        return ENTRY_TYPE;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
