package net.one97.paytm.upi.util;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class SimUtils {
    private static final String AIRTEL = "airtel";
    private static final String BSNL = "bsnl";
    public static final Companion Companion = new Companion((g) null);
    private static final String DELIMITER = " ";
    private static final String IDEA = "idea";
    private static final String JIO = "jio";
    private static final String MTNL = "mtnl";
    private static final String OPERATOR_MAPPING_GTM_KEY = "operator_icons_mapping";
    private static final String RCOM = "rcom";
    private static final String VODAFONE = "vodafone";
    /* access modifiers changed from: private */
    public static final Set<String> operatorSet = ak.a(AIRTEL, VODAFONE, JIO, RCOM, MTNL, BSNL, IDEA);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r0 = r0.c();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final net.one97.paytm.upi.util.SimUtils.TelcoOperatorModel getGTMOperatorMapping() {
            /*
                r4 = this;
                net.one97.paytm.upi.i r0 = net.one97.paytm.upi.i.a()
                r1 = 0
                if (r0 == 0) goto L_0x0016
                net.one97.paytm.upi.h r0 = r0.c()
                if (r0 == 0) goto L_0x0016
                java.lang.String r2 = "operator_icons_mapping"
                java.lang.String r3 = ""
                java.lang.String r0 = r0.b((java.lang.String) r2, (java.lang.String) r3)
                goto L_0x0017
            L_0x0016:
                r0 = r1
            L_0x0017:
                r2 = r0
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x002e }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x002e }
                if (r2 != 0) goto L_0x0032
                com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x002e }
                r2.<init>()     // Catch:{ Exception -> 0x002e }
                java.lang.Class<net.one97.paytm.upi.util.SimUtils$TelcoOperatorModel> r3 = net.one97.paytm.upi.util.SimUtils.TelcoOperatorModel.class
                java.lang.Object r0 = r2.a((java.lang.String) r0, r3)     // Catch:{ Exception -> 0x002e }
                net.one97.paytm.upi.util.SimUtils$TelcoOperatorModel r0 = (net.one97.paytm.upi.util.SimUtils.TelcoOperatorModel) r0     // Catch:{ Exception -> 0x002e }
                return r0
            L_0x002e:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.util.SimUtils.Companion.getGTMOperatorMapping():net.one97.paytm.upi.util.SimUtils$TelcoOperatorModel");
        }

        public final String getURLFromMap(String str, HashMap<String, String> hashMap) {
            k.c(str, "carrierName");
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence) && hashMap != null) {
                for (String next : p.a(charSequence, new String[]{" "})) {
                    if (next != null) {
                        String lowerCase = next.toLowerCase();
                        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (SimUtils.operatorSet.contains(lowerCase)) {
                            String str2 = hashMap.get(lowerCase);
                            if (str2 == null) {
                                return "";
                            }
                            return str2;
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            return "";
        }
    }

    public static final class TelcoOperatorModel {
        @b(a = "upi_telco_icons")
        private HashMap<String, String> telcoIconsMap;

        public final HashMap<String, String> getTelcoIconsMap() {
            return this.telcoIconsMap;
        }

        public final void setTelcoIconsMap(HashMap<String, String> hashMap) {
            this.telcoIconsMap = hashMap;
        }
    }
}
