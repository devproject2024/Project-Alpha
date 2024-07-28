package net.one97.paytm.moneytransferv4;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;

public abstract class PaymentFlow implements IJRDataModel {

    public static final class PaymentCombination extends PaymentFlow {
        private final PaymentCombinationAPIResponse data;

        public static /* synthetic */ PaymentCombination copy$default(PaymentCombination paymentCombination, PaymentCombinationAPIResponse paymentCombinationAPIResponse, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                paymentCombinationAPIResponse = paymentCombination.data;
            }
            return paymentCombination.copy(paymentCombinationAPIResponse);
        }

        public final PaymentCombinationAPIResponse component1() {
            return this.data;
        }

        public final PaymentCombination copy(PaymentCombinationAPIResponse paymentCombinationAPIResponse) {
            k.c(paymentCombinationAPIResponse, "data");
            return new PaymentCombination(paymentCombinationAPIResponse);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof PaymentCombination) && k.a((Object) this.data, (Object) ((PaymentCombination) obj).data);
            }
            return true;
        }

        public final int hashCode() {
            PaymentCombinationAPIResponse paymentCombinationAPIResponse = this.data;
            if (paymentCombinationAPIResponse != null) {
                return paymentCombinationAPIResponse.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "PaymentCombination(data=" + this.data + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentCombination(PaymentCombinationAPIResponse paymentCombinationAPIResponse) {
            super((g) null);
            k.c(paymentCombinationAPIResponse, "data");
            this.data = paymentCombinationAPIResponse;
        }

        public final PaymentCombinationAPIResponse getData() {
            return this.data;
        }
    }

    private PaymentFlow() {
    }

    public /* synthetic */ PaymentFlow(g gVar) {
        this();
    }
}
