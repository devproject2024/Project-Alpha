package net.one97.paytm.feed.events.models;

import java.util.List;
import kotlin.g.b.k;

public final class FeedEventModel {
    private final List<BaseEventDTO> eventDTOList;

    public static /* synthetic */ FeedEventModel copy$default(FeedEventModel feedEventModel, List<BaseEventDTO> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = feedEventModel.eventDTOList;
        }
        return feedEventModel.copy(list);
    }

    public final List<BaseEventDTO> component1() {
        return this.eventDTOList;
    }

    public final FeedEventModel copy(List<? extends BaseEventDTO> list) {
        k.c(list, "eventDTOList");
        return new FeedEventModel(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedEventModel) && k.a((Object) this.eventDTOList, (Object) ((FeedEventModel) obj).eventDTOList);
        }
        return true;
    }

    public final int hashCode() {
        List<BaseEventDTO> list = this.eventDTOList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedEventModel(eventDTOList=" + this.eventDTOList + ")";
    }

    public FeedEventModel(List<? extends BaseEventDTO> list) {
        k.c(list, "eventDTOList");
        this.eventDTOList = list;
    }

    public final List<BaseEventDTO> getEventDTOList() {
        return this.eventDTOList;
    }
}
