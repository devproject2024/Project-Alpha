package net.one97.paytm.nativesdk.instruments;

import java.util.ArrayList;

public interface InstrumentsSelectionManager {
    int getTotalInstrumentsSelected();

    void registerCallback(InstrumentCallback instrumentCallback);

    void resetInstruments(ArrayList<PaytmBaseView> arrayList);
}
