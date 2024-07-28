package com.google.c;

import com.alipay.mobile.nebula.util.tar.TarHeader;

final class br {

    interface a {
        byte a(int i2);

        int a();
    }

    private static String a(a aVar) {
        StringBuilder sb = new StringBuilder(aVar.a());
        for (int i2 = 0; i2 < aVar.a(); i2++) {
            byte a2 = aVar.a(i2);
            if (a2 == 34) {
                sb.append("\\\"");
            } else if (a2 == 39) {
                sb.append("\\'");
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (a2 >= 32 && a2 <= 126) {
                            sb.append((char) a2);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            sb.append((char) ((a2 & 7) + TarHeader.LF_NORMAL));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String a(final j jVar) {
        return a((a) new a() {
            public final int a() {
                return jVar.size();
            }

            public final byte a(int i2) {
                return jVar.byteAt(i2);
            }
        });
    }
}
