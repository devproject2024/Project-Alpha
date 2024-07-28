package net.one97.paytm.nativesdk.instruments.netbanking.util;

import java.util.Comparator;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions;

public class NetBankingChannelComparator implements Comparator {
    public int compare(Object obj, Object obj2) {
        return ((PayChannelOptions) obj).getChannelName().compareTo(((PayChannelOptions) obj2).getChannelName());
    }
}
