package net.one97.paytm.common.entity.movies.search;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public final class CJRMovieSummaryCatalogV2Items extends CJRHomePageItem {
    @b(a = "end_time")
    private Object endTime;
    @b(a = "item_id")
    private Integer itemId;
    @b(a = "start_time")
    private Object startTime;

    public final Integer getItemId() {
        return this.itemId;
    }

    public final void setItemId(Integer num) {
        this.itemId = num;
    }

    public final Object getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(Object obj) {
        this.startTime = obj;
    }

    public CJRMovieSummaryCatalogV2Items(Integer num, Object obj, Object obj2) {
        this.itemId = num;
        this.startTime = obj;
        this.endTime = obj2;
    }

    public final Object getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(Object obj) {
        this.endTime = obj;
    }
}
