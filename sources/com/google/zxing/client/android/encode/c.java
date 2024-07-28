package com.google.zxing.client.android.encode;

import android.telephony.PhoneNumberUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;
import java.util.regex.Pattern;
import net.one97.paytm.upi.util.UpiConstants;

final class c extends a {
    c() {
    }

    public final String[] a(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2) {
        StringBuilder sb = new StringBuilder(100);
        sb.append("MECARD:");
        StringBuilder sb2 = new StringBuilder(100);
        a aVar = new a((byte) 0);
        StringBuilder sb3 = sb;
        StringBuilder sb4 = sb2;
        a aVar2 = aVar;
        a(sb3, sb4, UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, list, 1, (b) new b((byte) 0), (b) aVar2, ';');
        a(sb3, sb4, "ORG", str, aVar, ';');
        a(sb3, sb4, "ADR", list2, 1, (b) null, (b) aVar2, ';');
        a(sb3, sb4, "TEL", list3, Integer.MAX_VALUE, (b) new C0674c((byte) 0), (b) aVar2, ';');
        a(sb3, sb4, "EMAIL", list5, Integer.MAX_VALUE, (b) null, (b) aVar2, ';');
        a(sb3, sb4, "URL", list6, Integer.MAX_VALUE, (b) null, (b) aVar2, ';');
        a(sb, sb2, "NOTE", str2, aVar, ';');
        sb.append(';');
        return new String[]{sb.toString(), sb2.toString()};
    }

    static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f40205a = Pattern.compile("([\\\\:;])");

        /* renamed from: b  reason: collision with root package name */
        private static final Pattern f40206b = Pattern.compile("\\n");

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final CharSequence a(CharSequence charSequence, int i2) {
            return AppConstants.COLON + f40206b.matcher(f40205a.matcher(charSequence).replaceAll("\\\\$1")).replaceAll("");
        }
    }

    /* renamed from: com.google.zxing.client.android.encode.c$c  reason: collision with other inner class name */
    static class C0674c implements b {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f40208a = Pattern.compile("[^0-9]+");

        private C0674c() {
        }

        /* synthetic */ C0674c(byte b2) {
            this();
        }

        public final CharSequence a(CharSequence charSequence, int i2) {
            return f40208a.matcher(PhoneNumberUtils.formatNumber(charSequence.toString())).replaceAll("");
        }
    }

    static class b implements b {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f40207a = Pattern.compile(AppConstants.COMMA);

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final CharSequence a(CharSequence charSequence, int i2) {
            return f40207a.matcher(charSequence).replaceAll("");
        }
    }
}
