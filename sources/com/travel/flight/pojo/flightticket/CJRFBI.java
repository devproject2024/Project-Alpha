package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.travel.flight.pojo.g;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFBI implements IJRDataModel {
    @b(a = "b")
    private List<String> banners;
    @b(a = "bim")
    private Map<String, g> bannersNew;
    @b(a = "display_info")
    private CJRDisplayInfo displayInfo;
    @b(a = "f")
    private List<CJRFilterAndBannerInfoItem> filters;
    @b(a = "p")
    private int interval;

    public int getInterval() {
        return this.interval;
    }

    public List<String> getBanners() {
        return this.banners;
    }

    public List<CJRFilterAndBannerInfoItem> getFilters() {
        return this.filters;
    }

    public void setFilters(List<CJRFilterAndBannerInfoItem> list) {
        this.filters = list;
    }

    public CJRDisplayInfo getDisplayInfo() {
        return this.displayInfo;
    }

    public Map<String, g> getBannersNew() {
        return this.bannersNew;
    }
}
