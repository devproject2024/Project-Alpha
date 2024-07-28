package net.one97.paytm.nativesdk.instruments.debitCreditcard.listeners;

import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiChannelInfo;

public interface SetOnEmiClickListener {
    void onClick(EmiChannelInfo emiChannelInfo, int i2, String str);
}
