package com.travel.train.i;

public enum af {
    SMART_ICON_TYPE(201, "cancellation_type"),
    MORE_TYPE(202, "more_type"),
    IGNORE_LAYOUT(203, "ignore_layout");
    
    public static final a Companion = null;
    private final int index;
    private final String nameStr;

    private af(int i2, String str) {
        this.index = i2;
        this.nameStr = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getNameStr() {
        return this.nameStr;
    }

    static {
        Companion = new a((byte) 0);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
