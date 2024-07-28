package com.google.android.exoplayer2.e.h;

import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f31638a = Pattern.compile("^NOTE(( |\t).*)?$");

    public static boolean b(r rVar) {
        String r = rVar.r();
        return r != null && r.startsWith("WEBVTT");
    }

    public static long a(String str) throws NumberFormatException {
        String[] b2 = ae.b(str, "\\.");
        long j = 0;
        for (String parseLong : ae.a(b2[0], AppConstants.COLON)) {
            j = (j * 60) + Long.parseLong(parseLong);
        }
        long j2 = j * 1000;
        if (b2.length == 2) {
            j2 += Long.parseLong(b2[1]);
        }
        return j2 * 1000;
    }

    public static float b(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static Matcher c(r rVar) {
        String r;
        while (true) {
            String r2 = rVar.r();
            if (r2 == null) {
                return null;
            }
            if (f31638a.matcher(r2).matches()) {
                do {
                    r = rVar.r();
                    if (r == null) {
                        break;
                    }
                } while (r.isEmpty());
            } else {
                Matcher matcher = f.f31623a.matcher(r2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static void a(r rVar) throws v {
        int i2 = rVar.f32567b;
        if (!b(rVar)) {
            rVar.c(i2);
            throw new v("Expected WEBVTT. Got " + rVar.r());
        }
    }
}
