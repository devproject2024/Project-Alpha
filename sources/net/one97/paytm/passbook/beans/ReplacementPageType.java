package net.one97.paytm.passbook.beans;

import com.paytmmall.clpartifact.utils.ViewHolderFactory;

public enum ReplacementPageType {
    L1_GRID(1, "l1_grid"),
    L2_LIST(2, "l2_list"),
    L3_LIST(3, "L3_list"),
    HOME(4, ViewHolderFactory.CLASS_HOME);
    
    private int index;
    private String name;

    private ReplacementPageType(int i2, String str) {
        this.index = i2;
        this.name = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }

    public static ReplacementPageType getPageTypeFromIndex(int i2) {
        for (ReplacementPageType replacementPageType : values()) {
            if (replacementPageType.index == i2) {
                return replacementPageType;
            }
        }
        return null;
    }
}
