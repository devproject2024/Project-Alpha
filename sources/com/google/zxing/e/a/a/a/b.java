package com.google.zxing.e.a.a.a;

import com.google.zxing.b.a;
import com.paytm.business.merchantprofile.common.utility.AppConstants;

final class b extends f {
    /* access modifiers changed from: protected */
    public final int a(int i2) {
        return i2 < 10000 ? i2 : i2 - AppConstants.START_OTP_FLOW;
    }

    b(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public final void a(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
