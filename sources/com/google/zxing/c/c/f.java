package com.google.zxing.c.c;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

final class f implements g {
    f() {
    }

    public final void a(h hVar) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        while (true) {
            z = true;
            if (!hVar.b()) {
                break;
            }
            char a2 = hVar.a();
            if (a2 >= ' ' && a2 <= '?') {
                sb.append(a2);
            } else if (a2 < '@' || a2 > '^') {
                j.c(a2);
            } else {
                sb.append((char) (a2 - '@'));
            }
            hVar.f39979f++;
            if (sb.length() >= 4) {
                hVar.a(a((CharSequence) sb));
                sb.delete(0, 4);
                if (j.a(hVar.f39974a, hVar.f39979f, 4) != 4) {
                    hVar.f39980g = 0;
                    break;
                }
            }
        }
        sb.append(31);
        try {
            int length = sb.length();
            if (length != 0) {
                if (length == 1) {
                    hVar.d();
                    int length2 = hVar.f39981h.f39989b - hVar.f39978e.length();
                    int c2 = hVar.c();
                    if (c2 > length2) {
                        hVar.a(hVar.f39978e.length() + 1);
                        length2 = hVar.f39981h.f39989b - hVar.f39978e.length();
                    }
                    if (c2 <= length2 && length2 <= 2) {
                        hVar.f39980g = 0;
                        return;
                    }
                }
                if (length <= 4) {
                    int i2 = length - 1;
                    String a3 = a((CharSequence) sb);
                    if (!(!hVar.b()) || i2 > 2) {
                        z = false;
                    }
                    if (i2 <= 2) {
                        hVar.a(hVar.f39978e.length() + i2);
                        if (hVar.f39981h.f39989b - hVar.f39978e.length() >= 3) {
                            hVar.a(hVar.f39978e.length() + a3.length());
                            z = false;
                        }
                    }
                    if (z) {
                        hVar.f39981h = null;
                        hVar.f39979f -= i2;
                    } else {
                        hVar.a(a3);
                    }
                    hVar.f39980g = 0;
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            hVar.f39980g = 0;
        }
    }

    private static String a(CharSequence charSequence) {
        char c2 = 0;
        int length = charSequence.length() - 0;
        if (length != 0) {
            char charAt = charSequence.charAt(0);
            char charAt2 = length >= 2 ? charSequence.charAt(1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(2) : 0;
            if (length >= 4) {
                c2 = charSequence.charAt(3);
            }
            int i2 = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c2;
            char c3 = (char) ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
            char c4 = (char) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID));
            if (length >= 2) {
                sb.append(c3);
            }
            if (length >= 3) {
                sb.append(c4);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
