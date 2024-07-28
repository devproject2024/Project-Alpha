package com.google.android.gms.internal.clearcut;

import java.util.Map;

final class di extends dh<FieldDescriptorType, Object> {
    di(int i2) {
        super(i2, (byte) 0);
    }

    public final void a() {
        if (!this.f9286a) {
            for (int i2 = 0; i2 < b(); i2++) {
                b(i2).getKey();
            }
            for (Map.Entry key : c()) {
                key.getKey();
            }
        }
        super.a();
    }
}
