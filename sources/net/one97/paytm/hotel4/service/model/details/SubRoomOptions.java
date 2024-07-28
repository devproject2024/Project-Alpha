package net.one97.paytm.hotel4.service.model.details;

import com.google.gsonhtcfix.a.b;
import java.util.List;

public final class SubRoomOptions extends SelectableItem {
    @b(a = "paytmRoomName")
    private String paytmRoomName;
    private String size;
    @b(a = "subRooms")
    private List<SubRoomProvider> subRoomProviders;
    private List<String> view;

    public final List<String> getView() {
        return this.view;
    }

    public final void setView(List<String> list) {
        this.view = list;
    }

    public final String getSize() {
        return this.size;
    }

    public final void setSize(String str) {
        this.size = str;
    }

    public final List<SubRoomProvider> getSubRoomProviders() {
        return this.subRoomProviders;
    }

    public final void setSubRoomProviders(List<SubRoomProvider> list) {
        this.subRoomProviders = list;
    }

    public final String getPaytmRoomName() {
        return this.paytmRoomName;
    }

    public final void setPaytmRoomName(String str) {
        this.paytmRoomName = str;
    }
}
