package com.alibaba.a.b.a;

import com.alibaba.a.a;
import com.alibaba.a.b.b;
import com.alibaba.a.b.c;
import com.alibaba.a.b.d;
import com.alibaba.a.b.g;
import java.lang.reflect.Type;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class ac implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final ac f6181a = new ac();

    public final int a() {
        return 12;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 8) {
            g2.d();
            return null;
        } else if (g2.a() == 12 || g2.a() == 16) {
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            while (true) {
                String a2 = g2.a(bVar.b());
                if (a2 == null) {
                    if (g2.a() == 13) {
                        g2.a(16);
                        break;
                    } else if (g2.a() == 16 && g2.a(c.AllowArbitraryCommas)) {
                    }
                }
                g2.p();
                if ("className".equals(a2)) {
                    if (g2.a() == 8) {
                        str = null;
                    } else if (g2.a() == 4) {
                        str = g2.l();
                    } else {
                        throw new com.alibaba.a.d("syntax error");
                    }
                } else if ("methodName".equals(a2)) {
                    if (g2.a() == 8) {
                        str2 = null;
                    } else if (g2.a() == 4) {
                        str2 = g2.l();
                    } else {
                        throw new com.alibaba.a.d("syntax error");
                    }
                } else if (ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME.equals(a2)) {
                    if (g2.a() == 8) {
                        str3 = null;
                    } else if (g2.a() == 4) {
                        str3 = g2.l();
                    } else {
                        throw new com.alibaba.a.d("syntax error");
                    }
                } else if ("lineNumber".equals(a2)) {
                    if (g2.a() == 8) {
                        i2 = 0;
                    } else if (g2.a() == 2) {
                        i2 = g2.n();
                    } else {
                        throw new com.alibaba.a.d("syntax error");
                    }
                } else if ("nativeMethod".equals(a2)) {
                    if (g2.a() == 8) {
                        g2.a(16);
                    } else if (g2.a() == 6) {
                        g2.a(16);
                    } else if (g2.a() == 7) {
                        g2.a(16);
                    } else {
                        throw new com.alibaba.a.d("syntax error");
                    }
                } else if (a2 != a.DEFAULT_TYPE_KEY) {
                    throw new com.alibaba.a.d("syntax error : ".concat(String.valueOf(a2)));
                } else if (g2.a() == 4) {
                    String l = g2.l();
                    if (!l.equals("java.lang.StackTraceElement")) {
                        throw new com.alibaba.a.d("syntax error : ".concat(String.valueOf(l)));
                    }
                } else if (g2.a() != 8) {
                    throw new com.alibaba.a.d("syntax error");
                }
                if (g2.a() == 13) {
                    g2.a(16);
                    break;
                }
            }
            return new StackTraceElement(str, str2, str3, i2);
        } else {
            throw new com.alibaba.a.d("syntax error: " + g.a(g2.a()));
        }
    }
}
