package com.google.android.gms.internal.icing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class dv extends dw<FieldDescriptorType, Object> {
    dv(int i2) {
        super(i2, (byte) 0);
    }

    public final void a() {
        if (!this.f10181a) {
            for (int i2 = 0; i2 < b(); i2++) {
                Map.Entry b2 = b(i2);
                if (((bs) b2.getKey()).d()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((bs) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
