package com.travel.train.i;

public enum ac {
    MOST_POPULAR(200, "most_popular"),
    NEAR_BY(201, "nearby_stations"),
    SEARCH_STATION(202, "search_station");
    
    private int index;
    private String name;

    private ac(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public static ac fromName(String str) {
        for (ac acVar : values()) {
            if (acVar.name.equalsIgnoreCase(str)) {
                return acVar;
            }
        }
        return MOST_POPULAR;
    }

    public static ac fromIndex(int i2) {
        for (ac acVar : values()) {
            if (acVar.index == i2) {
                return acVar;
            }
        }
        return MOST_POPULAR;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }
}
