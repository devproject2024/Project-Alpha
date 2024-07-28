package androidx.core.f;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final d f2916a = e.f2951c;

    /* renamed from: b  reason: collision with root package name */
    static final a f2917b = new a(false, 2, f2916a);

    /* renamed from: c  reason: collision with root package name */
    static final a f2918c = new a(true, 2, f2916a);

    /* renamed from: d  reason: collision with root package name */
    private static final String f2919d = Character.toString(8206);

    /* renamed from: e  reason: collision with root package name */
    private static final String f2920e = Character.toString(8207);

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2921f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2922g;

    /* renamed from: h  reason: collision with root package name */
    private final d f2923h;

    /* renamed from: androidx.core.f.a$a  reason: collision with other inner class name */
    public static final class C0042a {

        /* renamed from: a  reason: collision with root package name */
        boolean f2924a = a.a(Locale.getDefault());

        /* renamed from: b  reason: collision with root package name */
        int f2925b = 2;

        /* renamed from: c  reason: collision with root package name */
        d f2926c = a.f2916a;
    }

    public static a a() {
        C0042a aVar = new C0042a();
        if (aVar.f2925b != 2 || aVar.f2926c != f2916a) {
            return new a(aVar.f2924a, aVar.f2925b, aVar.f2926c);
        }
        if (aVar.f2924a) {
            return f2918c;
        }
        return f2917b;
    }

    private a(boolean z, int i2, d dVar) {
        this.f2921f = z;
        this.f2922g = i2;
        this.f2923h = dVar;
    }

    private CharSequence a(CharSequence charSequence, d dVar) {
        d dVar2;
        d dVar3;
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = "";
        if ((this.f2922g & 2) != 0) {
            if (a2) {
                dVar3 = e.f2950b;
            } else {
                dVar3 = e.f2949a;
            }
            boolean a3 = dVar3.a(charSequence, charSequence.length());
            if (!this.f2921f && (a3 || c(charSequence) == 1)) {
                str = f2919d;
            } else if (!this.f2921f || (a3 && c(charSequence) != -1)) {
                str = str2;
            } else {
                str = f2920e;
            }
            spannableStringBuilder.append(str);
        }
        if (a2 != this.f2921f) {
            spannableStringBuilder.append(a2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (a2) {
            dVar2 = e.f2950b;
        } else {
            dVar2 = e.f2949a;
        }
        boolean a4 = dVar2.a(charSequence, charSequence.length());
        if (!this.f2921f && (a4 || b(charSequence) == 1)) {
            str2 = f2919d;
        } else if (this.f2921f && (!a4 || b(charSequence) == -1)) {
            str2 = f2920e;
        }
        spannableStringBuilder.append(str2);
        return spannableStringBuilder;
    }

    public final String a(String str) {
        d dVar = this.f2923h;
        if (str == null) {
            return null;
        }
        return a(str, dVar).toString();
    }

    public final CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.f2923h);
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence).b();
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence).a();
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f2927a = new byte[1792];

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f2928b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f2929c = false;

        /* renamed from: d  reason: collision with root package name */
        private final int f2930d;

        /* renamed from: e  reason: collision with root package name */
        private int f2931e;

        /* renamed from: f  reason: collision with root package name */
        private char f2932f;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f2927a[i2] = Character.getDirectionality(i2);
            }
        }

        b(CharSequence charSequence) {
            this.f2928b = charSequence;
            this.f2930d = charSequence.length();
        }

        /* access modifiers changed from: package-private */
        public final int a() {
            this.f2931e = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f2931e < this.f2930d && i2 == 0) {
                byte c2 = c();
                if (c2 != 0) {
                    if (c2 == 1 || c2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (c2 != 9) {
                        switch (c2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                continue;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                continue;
                            case 18:
                                i4--;
                                i3 = 0;
                                continue;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f2931e > 0) {
                switch (d()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r2 = r2 - 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int b() {
            /*
                r7 = this;
                int r0 = r7.f2930d
                r7.f2931e = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r7.f2931e
                if (r3 <= 0) goto L_0x003b
                byte r3 = r7.d()
                r4 = -1
                if (r3 == 0) goto L_0x0034
                r5 = 1
                if (r3 == r5) goto L_0x002e
                r6 = 2
                if (r3 == r6) goto L_0x002e
                r6 = 9
                if (r3 == r6) goto L_0x0007
                switch(r3) {
                    case 14: goto L_0x0028;
                    case 15: goto L_0x0028;
                    case 16: goto L_0x0025;
                    case 17: goto L_0x0025;
                    case 18: goto L_0x0022;
                    default: goto L_0x001f;
                }
            L_0x001f:
                if (r1 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0022:
                int r2 = r2 + 1
                goto L_0x0007
            L_0x0025:
                if (r1 != r2) goto L_0x002b
                return r5
            L_0x0028:
                if (r1 != r2) goto L_0x002b
                return r4
            L_0x002b:
                int r2 = r2 + -1
                goto L_0x0007
            L_0x002e:
                if (r2 != 0) goto L_0x0031
                return r5
            L_0x0031:
                if (r1 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0034:
                if (r2 != 0) goto L_0x0037
                return r4
            L_0x0037:
                if (r1 != 0) goto L_0x0007
            L_0x0039:
                r1 = r2
                goto L_0x0007
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.f.a.b.b():int");
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f2927a[c2] : Character.getDirectionality(c2);
        }

        private byte c() {
            this.f2932f = this.f2928b.charAt(this.f2931e);
            if (Character.isHighSurrogate(this.f2932f)) {
                int codePointAt = Character.codePointAt(this.f2928b, this.f2931e);
                this.f2931e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f2931e++;
            byte a2 = a(this.f2932f);
            if (!this.f2929c) {
                return a2;
            }
            char c2 = this.f2932f;
            if (c2 == '<') {
                return e();
            }
            return c2 == '&' ? g() : a2;
        }

        private byte d() {
            this.f2932f = this.f2928b.charAt(this.f2931e - 1);
            if (Character.isLowSurrogate(this.f2932f)) {
                int codePointBefore = Character.codePointBefore(this.f2928b, this.f2931e);
                this.f2931e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f2931e--;
            byte a2 = a(this.f2932f);
            if (!this.f2929c) {
                return a2;
            }
            char c2 = this.f2932f;
            if (c2 == '>') {
                return f();
            }
            return c2 == ';' ? h() : a2;
        }

        private byte e() {
            char charAt;
            int i2 = this.f2931e;
            while (true) {
                int i3 = this.f2931e;
                if (i3 < this.f2930d) {
                    CharSequence charSequence = this.f2928b;
                    this.f2931e = i3 + 1;
                    this.f2932f = charSequence.charAt(i3);
                    char c2 = this.f2932f;
                    if (c2 == '>') {
                        return 12;
                    }
                    if (c2 == '\"' || c2 == '\'') {
                        char c3 = this.f2932f;
                        do {
                            int i4 = this.f2931e;
                            if (i4 >= this.f2930d) {
                                break;
                            }
                            CharSequence charSequence2 = this.f2928b;
                            this.f2931e = i4 + 1;
                            charAt = charSequence2.charAt(i4);
                            this.f2932f = charAt;
                        } while (charAt != c3);
                    }
                } else {
                    this.f2931e = i2;
                    this.f2932f = '<';
                    return 13;
                }
            }
        }

        private byte f() {
            char charAt;
            int i2 = this.f2931e;
            while (true) {
                int i3 = this.f2931e;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2928b;
                int i4 = i3 - 1;
                this.f2931e = i4;
                this.f2932f = charSequence.charAt(i4);
                char c2 = this.f2932f;
                if (c2 != '<') {
                    if (c2 == '>') {
                        break;
                    } else if (c2 == '\"' || c2 == '\'') {
                        char c3 = this.f2932f;
                        do {
                            int i5 = this.f2931e;
                            if (i5 <= 0) {
                                break;
                            }
                            CharSequence charSequence2 = this.f2928b;
                            int i6 = i5 - 1;
                            this.f2931e = i6;
                            charAt = charSequence2.charAt(i6);
                            this.f2932f = charAt;
                        } while (charAt != c3);
                    }
                } else {
                    return 12;
                }
            }
            this.f2931e = i2;
            this.f2932f = '>';
            return 13;
        }

        private byte g() {
            char charAt;
            do {
                int i2 = this.f2931e;
                if (i2 >= this.f2930d) {
                    return 12;
                }
                CharSequence charSequence = this.f2928b;
                this.f2931e = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.f2932f = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte h() {
            char c2;
            int i2 = this.f2931e;
            do {
                int i3 = this.f2931e;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2928b;
                int i4 = i3 - 1;
                this.f2931e = i4;
                this.f2932f = charSequence.charAt(i4);
                c2 = this.f2932f;
                if (c2 == '&') {
                    return 12;
                }
            } while (c2 != ';');
            this.f2931e = i2;
            this.f2932f = ';';
            return 13;
        }
    }
}
