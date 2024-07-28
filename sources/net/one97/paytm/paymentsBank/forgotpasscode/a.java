package net.one97.paytm.paymentsBank.forgotpasscode;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.forgotpasscode.model.PrimaryKYCDocModel;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f18368c;

    /* renamed from: a  reason: collision with root package name */
    Context f18369a;

    /* renamed from: b  reason: collision with root package name */
    String f18370b;

    private a(Context context) {
        this.f18369a = context;
    }

    public static a a(Context context) {
        if (f18368c == null) {
            synchronized (a.class) {
                f18368c = new a(context);
            }
        }
        return f18368c;
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.a.q(this.f18369a));
        hashMap.put("uid", net.one97.paytm.bankCommon.mapping.a.n(this.f18369a));
        d.b();
        String a2 = d.a("kycPrimaryDocument");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(a2, (g.b) new g.b(bVar) {
            private final /* synthetic */ g.b f$1;

            {
                this.f$1 = r2;
            }

            public final void onResponse(Object obj) {
                a.this.a(this.f$1, (IJRPaytmDataModel) obj);
            }
        }, aVar, (IJRPaytmDataModel) new PrimaryKYCDocModel(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap2);
        new c();
        c.a(aVar2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(g.b bVar, IJRPaytmDataModel iJRPaytmDataModel) {
        PrimaryKYCDocModel primaryKYCDocModel = (PrimaryKYCDocModel) iJRPaytmDataModel;
        if (!(primaryKYCDocModel == null || primaryKYCDocModel.getPrimaryDocument() == null)) {
            String primaryDocument = primaryKYCDocModel.getPrimaryDocument();
            for (C0315a primaryDocument2 : C0315a.values()) {
                if (primaryDocument2.getPrimaryDocument().equalsIgnoreCase(primaryDocument)) {
                    if (primaryDocument.equalsIgnoreCase(C0315a.AADHAR.getPrimaryDocument())) {
                        this.f18370b = this.f18369a.getString(R.string.pb_enter_first_four_digit_document, new Object[]{primaryDocument});
                    } else {
                        this.f18370b = this.f18369a.getString(R.string.pb_enter_last_four_digit_document, new Object[]{primaryDocument});
                    }
                }
            }
        }
        bVar.onResponse(iJRPaytmDataModel);
    }

    /* renamed from: net.one97.paytm.paymentsBank.forgotpasscode.a$a  reason: collision with other inner class name */
    public enum C0315a {
        PASSPORT("Passport"),
        AADHAR("Aadhar"),
        DRIVING_LICENSE("DL"),
        VOTER_ID_CARD("Voter"),
        NREGA_JOB("Nrega_Job");
        
        String primaryDocument;

        private C0315a(String str) {
            this.primaryDocument = str;
        }

        public final String getPrimaryDocument() {
            return this.primaryDocument;
        }

        public final void setPrimaryDocument(String str) {
            this.primaryDocument = str;
        }
    }
}
