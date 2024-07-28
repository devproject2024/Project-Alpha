package com.google.android.gms.internal.firebase_ml;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class ik extends il<FieldDescriptorType, Object> {
    ik(int i2) {
        super(i2, (byte) 0);
    }

    public final void a() {
        if (!this.f9998a) {
            for (int i2 = 0; i2 < b(); i2++) {
                Map.Entry b2 = b(i2);
                if (((gb) b2.getKey()).d()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((gb) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
