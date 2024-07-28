package net.one97.paytm.nativesdk.paymethods.viewmodel;

import java.util.Comparator;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.PaymentModes;

final class InstrumentSheetViewModel$sortPaymentMethods$1<T> implements Comparator<PaymentModes> {
    public static final InstrumentSheetViewModel$sortPaymentMethods$1 INSTANCE = new InstrumentSheetViewModel$sortPaymentMethods$1();

    InstrumentSheetViewModel$sortPaymentMethods$1() {
    }

    public final int compare(PaymentModes paymentModes, PaymentModes paymentModes2) {
        k.a((Object) paymentModes, "o1");
        int sortingWeight = paymentModes.getSortingWeight();
        k.a((Object) paymentModes2, "o2");
        if (sortingWeight > paymentModes2.getSortingWeight()) {
            return 1;
        }
        return paymentModes.getSortingWeight() == paymentModes2.getSortingWeight() ? 0 : -1;
    }
}
