package net.one97.paytm.hotel4.service.model.details;

import kotlin.g.b.g;

public final class RoomTypeSelection {
    private boolean isGalleryVisible;
    private RoomOption roomOptions;
    private SubRoomOptions subRoomOptionse;
    private int viewType;

    public RoomTypeSelection(int i2, RoomOption roomOption, SubRoomOptions subRoomOptions, boolean z) {
        this.viewType = i2;
        this.roomOptions = roomOption;
        this.subRoomOptionse = subRoomOptions;
        this.isGalleryVisible = z;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public final void setViewType(int i2) {
        this.viewType = i2;
    }

    public final RoomOption getRoomOptions() {
        return this.roomOptions;
    }

    public final void setRoomOptions(RoomOption roomOption) {
        this.roomOptions = roomOption;
    }

    public final SubRoomOptions getSubRoomOptionse() {
        return this.subRoomOptionse;
    }

    public final void setSubRoomOptionse(SubRoomOptions subRoomOptions) {
        this.subRoomOptionse = subRoomOptions;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoomTypeSelection(int i2, RoomOption roomOption, SubRoomOptions subRoomOptions, boolean z, int i3, g gVar) {
        this(i2, (i3 & 2) != 0 ? null : roomOption, (i3 & 4) != 0 ? null : subRoomOptions, (i3 & 8) != 0 ? false : z);
    }

    public final boolean isGalleryVisible() {
        return this.isGalleryVisible;
    }

    public final void setGalleryVisible(boolean z) {
        this.isGalleryVisible = z;
    }
}
