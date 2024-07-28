package net.one97.paytm.hotel4.service.model.details;

import java.util.List;
import kotlin.g.b.g;

public final class HotelRoomTypeImages {
    private List<String> imageUrl;
    private String roomTypeName;

    public HotelRoomTypeImages() {
        this((String) null, (List) null, 3, (g) null);
    }

    public HotelRoomTypeImages(String str, List<String> list) {
        this.roomTypeName = str;
        this.imageUrl = list;
    }

    public final String getRoomTypeName() {
        return this.roomTypeName;
    }

    public final void setRoomTypeName(String str) {
        this.roomTypeName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotelRoomTypeImages(String str, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list);
    }

    public final List<String> getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(List<String> list) {
        this.imageUrl = list;
    }
}
