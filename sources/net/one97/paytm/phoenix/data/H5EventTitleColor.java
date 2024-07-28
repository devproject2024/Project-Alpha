package net.one97.paytm.phoenix.data;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class H5EventTitleColor {
    private Integer color;
    private Boolean reset;

    public H5EventTitleColor() {
        this((Integer) null, (Boolean) null, 3, (g) null);
    }

    public static /* synthetic */ H5EventTitleColor copy$default(H5EventTitleColor h5EventTitleColor, Integer num, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = h5EventTitleColor.color;
        }
        if ((i2 & 2) != 0) {
            bool = h5EventTitleColor.reset;
        }
        return h5EventTitleColor.copy(num, bool);
    }

    public final Integer component1() {
        return this.color;
    }

    public final Boolean component2() {
        return this.reset;
    }

    public final H5EventTitleColor copy(Integer num, Boolean bool) {
        return new H5EventTitleColor(num, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H5EventTitleColor)) {
            return false;
        }
        H5EventTitleColor h5EventTitleColor = (H5EventTitleColor) obj;
        return k.a((Object) this.color, (Object) h5EventTitleColor.color) && k.a((Object) this.reset, (Object) h5EventTitleColor.reset);
    }

    public final int hashCode() {
        Integer num = this.color;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Boolean bool = this.reset;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "H5EventTitleColor(color=" + this.color + ", reset=" + this.reset + ")";
    }

    public H5EventTitleColor(Integer num, Boolean bool) {
        this.color = num;
        this.reset = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ H5EventTitleColor(Integer num, Boolean bool, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0 : num, (i2 & 2) != 0 ? Boolean.FALSE : bool);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final void setColor(Integer num) {
        this.color = num;
    }

    public final Boolean getReset() {
        return this.reset;
    }

    public final void setReset(Boolean bool) {
        this.reset = bool;
    }
}
