package net.one97.paytm.wallet.utility;

import java.util.ArrayList;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public interface j {

    /* renamed from: a  reason: collision with root package name */
    public static final Double f72322a = Double.valueOf(100000.0d);

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<Integer> f72323b = new ArrayList<Integer>() {
        {
            add(401);
            add(410);
            add(403);
        }
    };

    public enum a {
        ACTIVE,
        DEBIT_FREEZED,
        CREDIT_FREEZED,
        TOTAL_FREEZED,
        CLOSED
    }

    public enum c {
        NO_UPI(1),
        UPI_CREATED_NO_BANK_LINK(2),
        UPI_WITH_BANK_LINK(3),
        MERCHANT_UPI_NOT_AVAILABLE(4);
        
        int value;

        private c(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public enum b {
        NONE(SDKConstants.NATIVE_SDK_NONE),
        ADD_PAY("ADD&PAY"),
        HYBRID(SDKConstants.HYBRID);
        
        String paymentFlow;

        private b(String str) {
            this.paymentFlow = str;
        }

        public final String getValue() {
            return this.paymentFlow;
        }
    }
}
