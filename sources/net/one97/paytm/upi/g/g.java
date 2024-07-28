package net.one97.paytm.upi.g;

import com.paytm.erroranalytics.c.a.b;
import com.paytm.erroranalytics.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public class g {
    public static <T> void a(T t, String str) {
        Class<g> cls = g.class;
        PaytmLogs.i(cls.getName(), "Error event on paytmErrorHandler");
        try {
            e.a();
            b.a aVar = new b.a(str);
            aVar.f42752d = t;
            e.b().a(aVar.a());
        } catch (com.paytm.erroranalytics.a.a.a unused) {
            PaytmLogs.d(cls.getName(), "Paytm error sdk not initialized");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static class b {
        @com.google.gson.a.c(a = "http")

        /* renamed from: a  reason: collision with root package name */
        private a f66973a;

        public final void a(int i2) {
            if (this.f66973a == null) {
                this.f66973a = new a((byte) 0);
            }
            this.f66973a.f66969a = i2;
        }

        public final void a(String str) {
            if (this.f66973a == null) {
                this.f66973a = new a((byte) 0);
            }
            this.f66973a.f66970b = str;
        }

        public final void b(String str) {
            if (this.f66973a == null) {
                this.f66973a = new a((byte) 0);
            }
            this.f66973a.f66971c = str;
        }

        public final void c(String str) {
            if (this.f66973a == null) {
                this.f66973a = new a((byte) 0);
            }
            this.f66973a.f66972d = str;
        }
    }

    static class a {
        @com.google.gson.a.c(a = "httpcode")

        /* renamed from: a  reason: collision with root package name */
        int f66969a;
        @com.google.gson.a.c(a = "responsetime")

        /* renamed from: b  reason: collision with root package name */
        String f66970b;
        @com.google.gson.a.c(a = "uri")

        /* renamed from: c  reason: collision with root package name */
        String f66971c;
        @com.google.gson.a.c(a = "response")

        /* renamed from: d  reason: collision with root package name */
        String f66972d;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public enum d {
        UNKNOWN(SDKConstants.UNKNOWN),
        BUS("BUS"),
        TRAIN("TRAIN"),
        FLIGHT("FLIGHT"),
        HOTELS("HOTELS"),
        INBOX("INBOX"),
        GOLD("GOLD"),
        INSURANCE("INSURANCE"),
        MOVIES("MOVIES"),
        CHANNELS("channels"),
        UPI("UPI"),
        GAMEPIND("Gamepind"),
        BANK(SDKConstants.TYPE_BANK),
        ACCEPT_MONEY("ACCEPT_MONEY"),
        ACCEPT_PAYMENT("ACCEPT_PAYMENT"),
        PASSBOOK("Passbook"),
        POST_PAYMENT("POST_PAYMENT"),
        P2P("P2P"),
        ADD_MONEY("ADD_MONEY"),
        WALLET(SDKConstants.AI_KEY_WALLET),
        MONEYTRANSFER(CommonPayParams.Builder.MONEY_TRANSFER),
        PAYMENTS("PAYMENTS"),
        GV("GV"),
        CST("CST"),
        FASTAG("Fastag"),
        PAYMENTS_LIMIT("PaymentsLimit");
        
        private final String stringValue;

        private d(String str) {
            this.stringValue = str;
        }

        public final String toString() {
            return this.stringValue;
        }
    }

    public enum c {
        NONE("None"),
        USER_FACING("true"),
        SILENT("false");
        
        private final String stringValue;

        private c(String str) {
            this.stringValue = str;
        }

        public final String toString() {
            return this.stringValue;
        }
    }
}
