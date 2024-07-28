package net.one97.paytm.nativesdk.paymethods.viewmodel;

import java.util.Comparator;
import kotlin.b.a;
import net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView;

public final class InstrumentSheetViewModel$postInstrumentsToUI$$inlined$sortedBy$1<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        return a.a(Integer.valueOf(((PaymentInstrumentView) t).getPriorityOrder()), Integer.valueOf(((PaymentInstrumentView) t2).getPriorityOrder()));
    }
}
