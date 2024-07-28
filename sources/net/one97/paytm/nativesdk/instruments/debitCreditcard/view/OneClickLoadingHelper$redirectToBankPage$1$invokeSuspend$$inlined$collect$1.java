package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.d.d;
import kotlin.x;
import kotlinx.coroutines.flow.FlowCollector;
import net.one97.paytm.nativesdk.Utils.LogUtility;

public final class OneClickLoadingHelper$redirectToBankPage$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Integer> {
    final /* synthetic */ OneClickLoadingHelper$redirectToBankPage$1 this$0;

    public OneClickLoadingHelper$redirectToBankPage$1$invokeSuspend$$inlined$collect$1(OneClickLoadingHelper$redirectToBankPage$1 oneClickLoadingHelper$redirectToBankPage$1) {
        this.this$0 = oneClickLoadingHelper$redirectToBankPage$1;
    }

    public final Object emit(Object obj, d dVar) {
        if (((Number) obj).intValue() - 10 == 0) {
            try {
                this.this$0.$suspendFunction.invoke();
            } catch (Exception e2) {
                LogUtility.printStackTrace(e2);
            }
        }
        return x.f47997a;
    }
}
