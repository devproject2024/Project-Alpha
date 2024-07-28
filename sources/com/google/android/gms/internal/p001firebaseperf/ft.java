package com.google.android.gms.internal.p001firebaseperf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.ft  reason: invalid package */
final class ft extends fq<FieldDescriptorType, Object> {
    ft(int i2) {
        super(i2, (byte) 0);
    }

    public final void a() {
        if (!this.f9637a) {
            for (int i2 = 0; i2 < b(); i2++) {
                Map.Entry b2 = b(i2);
                if (((dk) b2.getKey()).d()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((dk) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
