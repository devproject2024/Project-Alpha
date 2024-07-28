package net.one97.paytm.contacts.utils;

import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.nebula.util.H5Utils;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.contacts.activity.SearchActivityV2;
import net.one97.paytm.wallet.R;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f50261a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static final int f50262b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f50263c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f50264d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final int f50265e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f50266f = 5;

    /* renamed from: g  reason: collision with root package name */
    private static final int f50267g = 6;

    /* renamed from: h  reason: collision with root package name */
    private static final int f50268h = f50268h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f50269i = f50269i;
    private static final String j = j;
    private static final String k = k;
    private static final String l = l;
    private static final int m = 7;
    private static final String n = n;
    private static final String o = "BANK";
    private static final String p = "WALLET";
    private static final String q = "UPI";
    private static final String r = r;
    private static final String s = "mt_p2p_new_v1";

    public interface f {
        void a();
    }

    public static String q() {
        return "/mt_p2p_to_mob_no";
    }

    private e() {
    }

    public static int a() {
        return f50263c;
    }

    public static int b() {
        return f50264d;
    }

    public static int c() {
        return f50265e;
    }

    public static int d() {
        return f50266f;
    }

    public static int e() {
        return f50267g;
    }

    public static int f() {
        return f50268h;
    }

    public static String g() {
        return f50269i;
    }

    public static String h() {
        return j;
    }

    public static String i() {
        return k;
    }

    public static String j() {
        return l;
    }

    public static int k() {
        return m;
    }

    public static String l() {
        return o;
    }

    public static String m() {
        return p;
    }

    public static String n() {
        return q;
    }

    public static String o() {
        return r;
    }

    public static String p() {
        return s;
    }

    public enum b {
        PHONEBOOK(1),
        TRANSFER_BENEFICIARY(2),
        BENEFICIARY(3),
        ALL(4),
        BEN_PHONE_TYPE(5);
        
        private int type;

        protected b(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }

    public enum a {
        NONE(0),
        IN_PROCESS(1),
        COMPLETED(2);
        
        private int type;

        protected a(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }

    /* renamed from: net.one97.paytm.contacts.utils.e$e  reason: collision with other inner class name */
    public enum C0905e {
        PAY(1),
        MONEY_TRANSFER(2),
        MONEY_TRANSFER_VIEW_ALL(3),
        APP_EVOKE(4),
        CONTACT_ONLY_WITH_RESULT(6);
        
        private int type;

        protected C0905e(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }

    public enum h {
        NONE(0),
        LOCAL_DB_SYNC_DONE(1),
        TRANSFER_BEN_CALL_DONE(2),
        CONTACT_UPLOAD_CALL_DONE(3),
        CONTACT_DELETE_CALL_DONE(4),
        GET_PHONE_BOOK_CALL_DONE(5),
        ABORT(6),
        PHONEBOOK_HEALTH_DONE(7),
        BENEFICIARY_HEALTH_DONE(8),
        NEW_DB_SYNC(7);
        
        private int type;

        protected h(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }

    public enum d {
        CONTACT_PERMISSION_ALLOW(1),
        PRIVACY_ALLOW(2);
        
        private int type;

        protected d(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }

    public enum g {
        PHONEBOOK(1),
        TRANSFER_BEN(2),
        PHONE_BOOK_SERVER_SYNC(3);
        
        private int type;

        protected g(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }

    public enum c {
        SCANNER(1),
        MT(2),
        VIEWALL(3);
        
        private int type;

        protected c(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i2) {
            this.type = i2;
        }
    }

    public static String a(Context context, String str) {
        String str2;
        k.c(context, "context");
        k.c(str, "responseCode");
        if (p.a("37", str, true)) {
            String string = context.getResources().getString(R.string.upi_unable_to_verify_vpa);
            k.a((Object) string, "context.resources.getStr…upi_unable_to_verify_vpa)");
            return string;
        }
        if (p.a("XH", str, true) || p.a("J02", str, true) || p.a("U17", str, true) || p.a("0037", str, true)) {
            str2 = context.getResources().getString(R.string.upi_address_incorrect);
        } else if (p.a("INT-1470", str, true)) {
            str2 = context.getResources().getString(R.string.upi_address_incorrect);
        } else {
            str2 = context.getResources().getString(R.string.upi_unable_to_verify_vpa);
        }
        k.a((Object) str2, "if (\"XH\".equals(response…upi_unable_to_verify_vpa)");
        return str2;
    }

    public static String a(int i2) {
        if (i2 == 1) {
            return b.PHONEBOOK.name();
        }
        if (i2 != 2) {
            return i2 != 3 ? H5Utils.NETWORK_TYPE_UNKNOWN : b.BENEFICIARY.name();
        }
        return b.TRANSFER_BENEFICIARY.name();
    }

    public static String a(String str) {
        k.c(str, "number");
        String replace = new l("[^0-9]").replace((CharSequence) str, "");
        if (p.b(replace, "0", false)) {
            if (replace != null) {
                replace = replace.substring(1);
                k.a((Object) replace, "(this as java.lang.String).substring(startIndex)");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        return replace.length() == 10 ? "91".concat(String.valueOf(replace)) : replace;
    }

    public static String b(int i2) {
        if (i2 == C0905e.PAY.getType()) {
            return "pay";
        }
        if (i2 == C0905e.MONEY_TRANSFER.getType() || i2 == C0905e.MONEY_TRANSFER_VIEW_ALL.getType()) {
            return "MT";
        }
        if (i2 == C0905e.MONEY_TRANSFER_VIEW_ALL.getType()) {
        }
        return "other";
    }

    public static Intent a(Context context, int i2) {
        k.c(context, "context");
        Intent intent = new Intent(context, SearchActivityV2.class);
        if (i2 == c.MT.getType()) {
            intent.putExtra(j, C0905e.MONEY_TRANSFER_VIEW_ALL.getType());
            intent.putExtra("isViewAllRecent", true);
            intent.putExtra("syncData", true);
        } else if (i2 == c.VIEWALL.getType()) {
            intent.putExtra(j, C0905e.MONEY_TRANSFER_VIEW_ALL.getType());
            intent.putExtra("isViewAllRecent", true);
            intent.putExtra("syncData", true);
            intent.putExtra("isFromViewAll", true);
        } else if (i2 == c.SCANNER.getType()) {
            intent.putExtra(j, C0905e.PAY.getType());
            intent.putExtra("syncData", !net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(context, "contactSyncOnScannerEnabled", false));
        }
        return intent;
    }
}
