package net.one97.paytm.hotel4.service.model;

import androidx.lifecycle.y;
import kotlin.g.b.k;

public final class GuestAndRoomCountDetails {
    private y<Integer> count;
    private String heading;
    private int maxCount;
    private Integer minCount;
    private boolean setSubHeadingVisible;
    private y<Boolean> showDisableMinus;
    private y<Boolean> showDisabledPlus;
    private String subHeading;
    private int tag;

    public GuestAndRoomCountDetails(int i2, String str, String str2, y<Integer> yVar, Integer num, int i3, boolean z, y<Boolean> yVar2, y<Boolean> yVar3) {
        k.c(yVar, "count");
        k.c(yVar2, "showDisabledPlus");
        k.c(yVar3, "showDisableMinus");
        this.tag = i2;
        this.heading = str;
        this.subHeading = str2;
        this.count = yVar;
        this.minCount = num;
        this.maxCount = i3;
        this.setSubHeadingVisible = z;
        this.showDisabledPlus = yVar2;
        this.showDisableMinus = yVar3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final void setTag(int i2) {
        this.tag = i2;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final void setHeading(String str) {
        this.heading = str;
    }

    public final String getSubHeading() {
        return this.subHeading;
    }

    public final void setSubHeading(String str) {
        this.subHeading = str;
    }

    public final y<Integer> getCount() {
        return this.count;
    }

    public final void setCount(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.count = yVar;
    }

    public final Integer getMinCount() {
        return this.minCount;
    }

    public final void setMinCount(Integer num) {
        this.minCount = num;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final void setMaxCount(int i2) {
        this.maxCount = i2;
    }

    public final boolean getSetSubHeadingVisible() {
        return this.setSubHeadingVisible;
    }

    public final void setSetSubHeadingVisible(boolean z) {
        this.setSubHeadingVisible = z;
    }

    public final y<Boolean> getShowDisabledPlus() {
        return this.showDisabledPlus;
    }

    public final void setShowDisabledPlus(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.showDisabledPlus = yVar;
    }

    public final y<Boolean> getShowDisableMinus() {
        return this.showDisableMinus;
    }

    public final void setShowDisableMinus(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.showDisableMinus = yVar;
    }
}
