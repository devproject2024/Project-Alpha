package com.google.zxing.g.a;

import com.google.zxing.b.b;

enum c {
    DATA_MASK_000 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i2, int i3) {
            return (i2 & 1) == 0;
        }
    },
    DATA_MASK_010 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i2, int i3) {
            return i3 % 3 == 0;
        }
    },
    DATA_MASK_011 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    },
    DATA_MASK_100 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i2, int i3) {
            return (((i2 / 2) + (i3 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i2, int i3) {
            return (i2 * i3) % 6 == 0;
        }
    },
    DATA_MASK_110 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i2, int i3) {
            return (i2 * i3) % 6 < 3;
        }
    },
    DATA_MASK_111 {
        /* access modifiers changed from: package-private */
        public final boolean isMasked(int i2, int i3) {
            return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract boolean isMasked(int i2, int i3);

    /* access modifiers changed from: package-private */
    public final void unmaskBitMatrix(b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (isMasked(i3, i4)) {
                    bVar.c(i4, i3);
                }
            }
        }
    }
}
