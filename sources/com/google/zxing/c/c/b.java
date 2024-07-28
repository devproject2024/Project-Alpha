package com.google.zxing.c.c;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

final class b implements g {
    b() {
    }

    public final void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!hVar.b()) {
                break;
            }
            sb.append(hVar.a());
            hVar.f39979f++;
            if (j.a(hVar.f39974a, hVar.f39979f, 5) != 5) {
                hVar.f39980g = 0;
                break;
            }
        }
        int length = sb.length() - 1;
        int length2 = hVar.f39978e.length() + length + 1;
        hVar.a(length2);
        boolean z = hVar.f39981h.f39989b - length2 > 0;
        if (hVar.b() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length3 = sb.length();
        for (int i2 = 0; i2 < length3; i2++) {
            int charAt = sb.charAt(i2) + (((hVar.f39978e.length() + 1) * 149) % PriceRangeSeekBar.INVALID_POINTER_ID) + 1;
            if (charAt > 255) {
                charAt -= 256;
            }
            hVar.a((char) charAt);
        }
    }
}
