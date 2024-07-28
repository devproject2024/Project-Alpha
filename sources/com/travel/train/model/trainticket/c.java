package com.travel.train.model.trainticket;

public final class c implements j {
    private String displayName;
    private String email;
    private int searchMatchEndIndex = -1;
    private int searchMatchStartIndex = -1;

    public final int getType() {
        return 2;
    }

    public c(String str, String str2) {
        this.displayName = str;
        this.email = str2;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getSearchMatchStartIndex() {
        return this.searchMatchStartIndex;
    }

    public final void setSearchMatchStartIndex(int i2) {
        this.searchMatchStartIndex = i2;
    }

    public final int getSearchMatchEndIndex() {
        return this.searchMatchEndIndex;
    }

    public final void setSearchMatchEndIndex(int i2) {
        this.searchMatchEndIndex = i2;
    }
}
