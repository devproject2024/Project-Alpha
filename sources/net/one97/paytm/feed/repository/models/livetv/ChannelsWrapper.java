package net.one97.paytm.feed.repository.models.livetv;

import java.util.List;
import kotlin.g.b.k;

public final class ChannelsWrapper {
    private final List<Channel> channels;

    public ChannelsWrapper(List<Channel> list) {
        k.c(list, "channels");
        this.channels = list;
    }

    public final List<Channel> getChannels() {
        return this.channels;
    }
}
