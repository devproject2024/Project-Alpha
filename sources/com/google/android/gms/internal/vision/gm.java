package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class gm extends gn<FieldDescriptorType, Object> {
    gm(int i2) {
        super(i2, (byte) 0);
    }

    public final void a() {
        if (!this.f11183a) {
            for (int i2 = 0; i2 < b(); i2++) {
                Map.Entry b2 = b(i2);
                if (((eb) b2.getKey()).d()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((eb) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
