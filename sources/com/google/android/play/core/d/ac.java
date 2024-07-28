package com.google.android.play.core.d;

import com.alipay.mobile.h5container.api.H5Param;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class ac {

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParser f37342a;

    /* renamed from: b  reason: collision with root package name */
    private final af f37343b = new af();

    ac(XmlPullParser xmlPullParser) {
        this.f37342a = xmlPullParser;
    }

    private final String a(String str) {
        for (int i2 = 0; i2 < this.f37342a.getAttributeCount(); i2++) {
            if (this.f37342a.getAttributeName(i2).equals(str)) {
                return this.f37342a.getAttributeValue(i2);
            }
        }
        return null;
    }

    private final void b() throws IOException, XmlPullParserException {
        int i2 = 1;
        while (i2 != 0) {
            int next = this.f37342a.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final ag a() {
        String a2;
        while (this.f37342a.next() != 1) {
            try {
                if (this.f37342a.getEventType() == 2) {
                    if (this.f37342a.getName().equals("splits")) {
                        while (this.f37342a.next() != 3) {
                            if (this.f37342a.getEventType() == 2) {
                                if (!this.f37342a.getName().equals("module") || (a2 = a("name")) == null) {
                                    b();
                                } else {
                                    while (this.f37342a.next() != 3) {
                                        if (this.f37342a.getEventType() == 2) {
                                            if (this.f37342a.getName().equals("language")) {
                                                while (this.f37342a.next() != 3) {
                                                    if (this.f37342a.getEventType() == 2) {
                                                        if (this.f37342a.getName().equals(H5Param.LONG_URL_WITH_ENTRY_KEY)) {
                                                            String a3 = a("key");
                                                            String a4 = a("split");
                                                            b();
                                                            if (!(a3 == null || a4 == null)) {
                                                                af afVar = this.f37343b;
                                                                if (!afVar.f37344a.containsKey(a3)) {
                                                                    afVar.f37344a.put(a3, new HashMap());
                                                                }
                                                                afVar.f37344a.get(a3).put(a2, a4);
                                                            }
                                                        } else {
                                                            b();
                                                        }
                                                    }
                                                }
                                            } else {
                                                b();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        b();
                    }
                }
            } catch (IOException | IllegalStateException | XmlPullParserException unused) {
                return null;
            }
        }
        af afVar2 = this.f37343b;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : afVar2.f37344a.entrySet()) {
            hashMap.put((String) next.getKey(), Collections.unmodifiableMap(new HashMap((Map) next.getValue())));
        }
        return new ag(Collections.unmodifiableMap(hashMap));
    }
}
