package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.p2mNewDesign.entity.c;

public final class CJRBankAccountDetailsV2 implements IJRDataModel, c {
    public static final a Companion = new a((byte) 0);
    private static final String FEATURE_ENABLED_CONSTANT = FEATURE_ENABLED_CONSTANT;
    @b(a = "accounts")
    private List<Object> accounts;

    public final List<Object> getAccounts() {
        return this.accounts;
    }

    public final void setAccounts(List<Object> list) {
        this.accounts = list;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
