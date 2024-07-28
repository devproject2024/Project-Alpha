package net.one97.paytm.games.model.pfg;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;

public final class Bean implements Serializable {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static String PCSTIME = "2019-08-27 02:10:00";
    private String amount;
    private String balance;
    private String day = "";
    private String description;
    private String id;
    private boolean isOld;
    private String product_detail;
    private String product_id;
    private String product_type;
    private String times = "";
    private String transaction_date;
    private String transaction_id;
    private String transaction_type;
    private String user_action;

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        this.balance = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getTransaction_type() {
        return this.transaction_type;
    }

    public final void setTransaction_type(String str) {
        this.transaction_type = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getTransaction_date() {
        return this.transaction_date;
    }

    public final void setTransaction_date(String str) {
        this.transaction_date = str;
    }

    public final String getTransaction_id() {
        return this.transaction_id;
    }

    public final void setTransaction_id(String str) {
        this.transaction_id = str;
    }

    public final String getUser_action() {
        return this.user_action;
    }

    public final void setUser_action(String str) {
        this.user_action = str;
    }

    public final String getProduct_id() {
        return this.product_id;
    }

    public final void setProduct_id(String str) {
        this.product_id = str;
    }

    public final String getProduct_type() {
        return this.product_type;
    }

    public final void setProduct_type(String str) {
        this.product_type = str;
    }

    public final String getProduct_detail() {
        return this.product_detail;
    }

    public final void setProduct_detail(String str) {
        this.product_detail = str;
    }

    public final void setDay(String str) {
        k.c(str, "<set-?>");
        this.day = str;
    }

    public final String getDay() {
        if (isTrimEmpty(this.transaction_date)) {
            return "";
        }
        String str = this.transaction_date;
        if (str == null) {
            k.a();
        }
        return p.a((CharSequence) str, new String[]{" "}).get(0);
    }

    public final void setTimes(String str) {
        k.c(str, "<set-?>");
        this.times = str;
    }

    public final String getTimes() {
        if (isTrimEmpty(this.transaction_date)) {
            return "";
        }
        String str = this.transaction_date;
        if (str == null) {
            k.a();
        }
        return p.a((CharSequence) str, new String[]{" "}).get(1);
    }

    public final void setOld(boolean z) {
        this.isOld = z;
    }

    public final boolean isOld() {
        if (isTrimEmpty(this.transaction_date)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(PCSTIME).compareTo(simpleDateFormat.parse(this.transaction_date)) > 0;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getPCSTIME() {
            return Bean.PCSTIME;
        }

        public final void setPCSTIME(String str) {
            k.c(str, "<set-?>");
            Bean.PCSTIME = str;
        }
    }

    public final boolean isTrimEmpty(String str) {
        if (str != null && !k.a((Object) "null", (Object) str)) {
            CharSequence charSequence = str;
            int length = charSequence.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            if (charSequence.subSequence(i2, length + 1).toString().length() == 0) {
                return true;
            }
            return false;
        }
        return true;
    }
}
