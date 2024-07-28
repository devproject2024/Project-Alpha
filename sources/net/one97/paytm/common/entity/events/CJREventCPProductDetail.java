package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventCPProductDetail implements IJRDataModel {
    @b(a = "imgurl")
    private String imageUrl;
    @b(a = "pid")
    private long pid;

    public long getPid() {
        return this.pid;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
}
