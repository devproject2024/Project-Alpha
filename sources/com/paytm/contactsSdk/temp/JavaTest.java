package com.paytm.contactsSdk.temp;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class JavaTest {
    /* access modifiers changed from: package-private */
    public void test() {
        new String[]{"1", "2"};
        StringBuilder sb = new StringBuilder(4);
        for (int i2 = 0; i2 < 2; i2++) {
            if (i2 > 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append("?");
        }
    }

    public static void main(String[] strArr) {
        new JavaTest().test();
    }
}
