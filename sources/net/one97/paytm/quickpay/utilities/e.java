package net.one97.paytm.quickpay.utilities;

public enum e {
    MY_PAYMENTS("my_payments", 44719),
    BUSINESS("business", 48984),
    LAYOUT_IGNORE_TYPE("ignore", -1);
    
    private int categoryId;
    private String type;

    private e(String str, int i2) {
        this.type = str;
        this.categoryId = i2;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(int i2) {
        this.categoryId = i2;
    }

    public static e fromIndex(int i2) {
        for (e eVar : values()) {
            if (eVar.categoryId == i2) {
                return eVar;
            }
        }
        return LAYOUT_IGNORE_TYPE;
    }
}
