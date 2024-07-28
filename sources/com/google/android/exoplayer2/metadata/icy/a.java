package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a implements com.google.android.exoplayer2.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f32678a = Pattern.compile("(.+?)='(.*?)';", 32);

    public final Metadata a(c cVar) {
        ByteBuffer byteBuffer = cVar.f31311c;
        Matcher matcher = f32678a.matcher(ae.a(byteBuffer.array(), 0, byteBuffer.limit()));
        String str = null;
        String str2 = null;
        for (int i2 = 0; matcher.find(i2); i2 = matcher.end()) {
            String d2 = ae.d(matcher.group(1));
            String group = matcher.group(2);
            char c2 = 65535;
            int hashCode = d2.hashCode();
            if (hashCode != -315603473) {
                if (hashCode == 1646559960 && d2.equals("streamtitle")) {
                    c2 = 0;
                }
            } else if (d2.equals("streamurl")) {
                c2 = 1;
            }
            if (c2 == 0) {
                str = group;
            } else if (c2 != 1) {
                "Unrecognized ICY tag: ".concat(String.valueOf(str));
                l.c();
            } else {
                str2 = group;
            }
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new Metadata(new IcyInfo(str, str2));
    }
}
