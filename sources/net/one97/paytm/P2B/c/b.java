package net.one97.paytm.p2b.c;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.p2b.a.c;
import net.one97.paytm.p2b.data.a.a;

public class b implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final a f56892a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c.b f56893b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f56894c;

    /* renamed from: d  reason: collision with root package name */
    private String f56895d = b.class.getSimpleName();

    public b(c.b bVar, a aVar, boolean z, String str) {
        this.f56893b = bVar;
        this.f56892a = aVar;
        this.f56894c = z;
        this.f56895d = str;
    }

    public final void a() {
        a aVar = this.f56892a;
        if (aVar != null) {
            aVar.a(this.f56895d);
        }
    }

    public final void a(String str, String str2) {
        this.f56893b.d();
        this.f56892a.a(str, str2, (a.C0169a) new a.C0169a() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                b.this.f56893b.e();
                com.paytm.utility.b.p();
                CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
                if (cJRAddBeneficiary.getError() == null) {
                    b.this.f56893b.a(cJRAddBeneficiary);
                } else if (cJRAddBeneficiary.getError().getErrorMsg() == null || !cJRAddBeneficiary.getError().getErrorCode().equalsIgnoreCase("403")) {
                    b.this.f56893b.a(cJRAddBeneficiary);
                } else {
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    networkCustomError.setAlertMessage(cJRAddBeneficiary.getError().getErrorMsg());
                    b.this.f56893b.b(networkCustomError);
                }
            }

            public final void a(NetworkCustomError networkCustomError) {
                b.this.f56893b.e();
                b.this.f56893b.b(networkCustomError);
            }
        }, this.f56895d);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z) {
        this.f56893b.d();
        this.f56892a.a(str, str2, str3, str4, z, new a.C0169a() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                b.a(b.this, iJRPaytmDataModel);
            }

            public final void a(NetworkCustomError networkCustomError) {
                b.a(b.this, networkCustomError);
            }
        }, this.f56895d);
    }

    public final void a(BeneficiaryEntity beneficiaryEntity, boolean z) {
        this.f56893b.d();
        this.f56892a.a(beneficiaryEntity, z, (a.C0169a) new a.C0169a() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                b.a(b.this, iJRPaytmDataModel);
            }

            public final void a(NetworkCustomError networkCustomError) {
                b.a(b.this, networkCustomError);
            }
        }, this.f56895d);
    }

    static /* synthetic */ void a(b bVar, IJRPaytmDataModel iJRPaytmDataModel) {
        CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
        bVar.f56893b.e();
        if (!TextUtils.isEmpty(cJRAddBeneficiary.getReferenceNumber()) && cJRAddBeneficiary.getError() == null && !TextUtils.isEmpty(cJRAddBeneficiary.getStatusCode()) && cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
            bVar.f56893b.a(cJRAddBeneficiary.getReferenceNumber());
        } else if (cJRAddBeneficiary.getError() != null) {
            if (cJRAddBeneficiary.getError().getSubError() != null) {
                bVar.f56893b.a(cJRAddBeneficiary.getError().getSubError(), cJRAddBeneficiary.getReferenceNumber());
                return;
            }
            String errorMsg = cJRAddBeneficiary.getError().getErrorMsg();
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setAlertMessage(errorMsg);
            bVar.f56893b.a(networkCustomError);
        } else if (!TextUtils.isEmpty(cJRAddBeneficiary.getMessage())) {
            String message = cJRAddBeneficiary.getMessage();
            NetworkCustomError networkCustomError2 = new NetworkCustomError();
            networkCustomError2.setAlertMessage(message);
            bVar.f56893b.a(networkCustomError2);
        } else {
            bVar.f56893b.a((NetworkCustomError) null);
        }
    }

    static /* synthetic */ void a(b bVar, NetworkCustomError networkCustomError) {
        bVar.f56893b.e();
        bVar.f56893b.a(networkCustomError);
    }
}
