package net.one97.paytm.feed.repository.models.livetv;

import java.util.List;
import kotlin.g.b.k;

public final class ChannelCategories {
    private final List<ChannelCategory> categories;

    public static /* synthetic */ ChannelCategories copy$default(ChannelCategories channelCategories, List<ChannelCategory> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = channelCategories.categories;
        }
        return channelCategories.copy(list);
    }

    public final List<ChannelCategory> component1() {
        return this.categories;
    }

    public final ChannelCategories copy(List<ChannelCategory> list) {
        k.c(list, "categories");
        return new ChannelCategories(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ChannelCategories) && k.a((Object) this.categories, (Object) ((ChannelCategories) obj).categories);
        }
        return true;
    }

    public final int hashCode() {
        List<ChannelCategory> list = this.categories;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "ChannelCategories(categories=" + this.categories + ")";
    }

    public ChannelCategories(List<ChannelCategory> list) {
        k.c(list, "categories");
        this.categories = list;
    }

    public final List<ChannelCategory> getCategories() {
        return this.categories;
    }
}
