package net.one97.paytm.recharge.automatic.b.a;

import java.util.Comparator;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;

public final class i implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((CJRPayChannelOptions) obj).getChannelName().compareTo(((CJRPayChannelOptions) obj2).getChannelName());
    }
}
