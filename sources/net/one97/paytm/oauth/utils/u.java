package net.one97.paytm.oauth.utils;

import android.graphics.Color;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;

public enum u {
    WEAK("Weak", Color.parseColor("#fd5c5c")),
    AVERAGE("Average", Color.parseColor("#ffa400")),
    STRONG("Strong", Color.parseColor("#21c17a"));
    
    public static final a Companion = null;
    private static int MAXIMUM_LENGTH;
    /* access modifiers changed from: private */
    public static int REQUIRED_LENGTH;
    /* access modifiers changed from: private */
    public static boolean containsAlphabet;
    /* access modifiers changed from: private */
    public static boolean containsDigit;
    /* access modifiers changed from: private */
    public static boolean containsLower;
    /* access modifiers changed from: private */
    public static boolean containsSpecial;
    /* access modifiers changed from: private */
    public static boolean containsUpper;
    private int color;
    private String strength;

    private u(String str, int i2) {
        this.strength = str;
        this.color = i2;
    }

    public final int getColor() {
        return this.color;
    }

    public final String getStrength() {
        return this.strength;
    }

    public final void setColor(int i2) {
        this.color = i2;
    }

    public final void setStrength(String str) {
        k.c(str, "<set-?>");
        this.strength = str;
    }

    static {
        Companion = new a((byte) 0);
        REQUIRED_LENGTH = 5;
        MAXIMUM_LENGTH = 15;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static u a(String str) {
            k.c(str, "password");
            a();
            int length = str.length();
            char c2 = 0;
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 >= length) {
                    break;
                }
                char charAt = str.charAt(i2);
                if (!Character.isLetterOrDigit(charAt)) {
                    u.containsSpecial = true;
                } else if (Character.isDigit(charAt)) {
                    u.containsDigit = true;
                } else {
                    if (Character.isUpperCase(charAt)) {
                        u.containsUpper = true;
                    } else {
                        u.containsLower = true;
                    }
                    if (!u.containsUpper && !u.containsLower) {
                        z = false;
                    }
                    u.containsAlphabet = z;
                }
                i2++;
            }
            if (str.length() >= u.REQUIRED_LENGTH && !b(str) && !c(str) && !d(str)) {
                if (u.containsSpecial && u.containsDigit && u.containsLower && u.containsUpper) {
                    c2 = 2;
                } else if (!e(str) && !f(str) && !g(str) && u.containsDigit && u.containsAlphabet && !h(str)) {
                    c2 = 1;
                }
            }
            if (c2 == 0) {
                return u.WEAK;
            }
            if (c2 == 1) {
                return u.AVERAGE;
            }
            if (c2 != 2) {
                return u.WEAK;
            }
            return u.STRONG;
        }

        private static boolean b(String str) {
            int length = str.length();
            int i2 = 0;
            char c2 = 0;
            int i3 = 1;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                i3 = charAt == c2 ? i3 + 1 : 1;
                if (i3 >= 4) {
                    return true;
                }
                i2++;
                c2 = charAt;
            }
            return false;
        }

        private static boolean c(String str) {
            int length = str.length();
            int i2 = 0;
            char c2 = 0;
            int i3 = 1;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                i3 = charAt == c2 + 1 ? i3 + 1 : 1;
                if (i3 >= 4) {
                    return true;
                }
                i2++;
                c2 = charAt;
            }
            int length2 = str.length();
            int i4 = 0;
            char c3 = 0;
            int i5 = 1;
            while (i4 < length2) {
                char charAt2 = str.charAt(i4);
                i5 = charAt2 == c3 - 1 ? i5 + 1 : 1;
                if (i5 >= 4) {
                    return true;
                }
                i4++;
                c3 = charAt2;
            }
            return false;
        }

        private static boolean d(String str) {
            String[] strArr = {"password", "qwerty", "paytm"};
            int i2 = 0;
            while (i2 < 3) {
                if (str != null) {
                    String lowerCase = str.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (p.a((CharSequence) lowerCase, (CharSequence) strArr[i2], false)) {
                        return true;
                    }
                    i2++;
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                }
            }
            return false;
        }

        private static boolean e(String str) {
            return new l("\\d+(?:\\.\\d+)?").matches(str);
        }

        private static boolean f(String str) {
            return new l("^[a-zA-Z]*$").matches(str);
        }

        private static boolean g(String str) {
            return new l("[-/@#$%^&_+=()]+").matches(str);
        }

        private static boolean h(String str) {
            CharSequence charSequence = str;
            return new l("^[\\da-z]+$").matches(charSequence) || new l("^[\\dA-Z]+$").matches(charSequence);
        }

        private static void a() {
            u.containsUpper = false;
            u.containsLower = false;
            u.containsDigit = false;
            u.containsSpecial = false;
            u.containsAlphabet = false;
        }
    }
}
