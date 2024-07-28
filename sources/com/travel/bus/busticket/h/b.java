package com.travel.bus.busticket.h;

public enum b {
    NEAR_BY_ZERO_SEARCH(0, "nearby_search"),
    N_HOP_ZERO_SEARCH_TITLE(1, "n_hop_search_title"),
    N_HOP_ZERO_SEARCH(2, "n_hop_search"),
    IGNORE_TYPE(3, "ignore_type");
    
    private int index;
    private String name;

    private b(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static b fromIndex(int i2) {
        for (b bVar : values()) {
            if (bVar.index == i2) {
                return bVar;
            }
        }
        return IGNORE_TYPE;
    }

    public static b fromName(String str) {
        for (b bVar : values()) {
            if (bVar.name.equalsIgnoreCase(str)) {
                return bVar;
            }
        }
        return IGNORE_TYPE;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
