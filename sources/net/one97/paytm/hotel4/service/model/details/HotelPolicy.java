package net.one97.paytm.hotel4.service.model.details;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;

public final class HotelPolicy extends IJRPaytmDataModel {
    private String checkInTime;
    private String checkOutTime;
    private List<String> other;

    public HotelPolicy() {
        this((String) null, (String) null, (List) null, 7, (g) null);
    }

    public final String getCheckInTime() {
        return this.checkInTime;
    }

    public final void setCheckInTime(String str) {
        this.checkInTime = str;
    }

    public final String getCheckOutTime() {
        return this.checkOutTime;
    }

    public final void setCheckOutTime(String str) {
        this.checkOutTime = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotelPolicy(String str, String str2, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : list);
    }

    public final List<String> getOther() {
        return this.other;
    }

    public final void setOther(List<String> list) {
        this.other = list;
    }

    public HotelPolicy(String str, String str2, List<String> list) {
        this.checkInTime = str;
        this.checkOutTime = str2;
        this.other = list;
    }
}
