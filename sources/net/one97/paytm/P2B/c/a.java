package net.one97.paytm.p2b.c;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.p2b.a.a;
import net.one97.paytm.p2b.d.k;
import net.one97.paytm.p2b.data.a.a;
import net.one97.paytm.p2b.data.a.b;

public class a implements a.C1057a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a.b f56885a;

    /* renamed from: b  reason: collision with root package name */
    private b f56886b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f56887c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f56888d;

    /* renamed from: e  reason: collision with root package name */
    private String f56889e = a.class.getSimpleName();

    public a(a.b bVar, b bVar2, boolean z, String str) {
        this.f56885a = bVar;
        this.f56886b = bVar2;
        this.f56888d = z;
        this.f56889e = str;
    }

    public final void a() {
        b bVar = this.f56886b;
        if (bVar != null) {
            bVar.a(this.f56889e);
        }
    }

    public final boolean a(String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str) || !z) {
            this.f56885a.e();
            return false;
        } else if (!"PYTM0123456".equalsIgnoreCase(str) || TextUtils.isEmpty(str2) || str2.trim().length() >= 12) {
            return true;
        } else {
            this.f56885a.f();
            return false;
        }
    }

    public final boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.f56885a.d();
        return false;
    }

    public final boolean e(String str) {
        return k.a(str);
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f56886b.a((a.C0169a) new a.C0169a() {
                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    a.this.f56885a.a((Object) iJRPaytmDataModel);
                }

                public final void a(NetworkCustomError networkCustomError) {
                    a.this.f56885a.a(networkCustomError);
                }
            }, str, this.f56889e);
        }
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f56885a.a();
            this.f56886b.a((a.C0169a) new a.C0169a() {
                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    CJRBankDetails cJRBankDetails = (CJRBankDetails) iJRPaytmDataModel;
                    a.this.f56885a.b();
                    if (cJRBankDetails.getResponse() != null) {
                        String str = cJRBankDetails.getResponse().getmBranchAddress();
                        if (TextUtils.isEmpty(str) || str.length() < 2) {
                            a.this.f56885a.a(cJRBankDetails.getResponse().getBranch());
                        } else {
                            a.this.f56885a.a(str);
                        }
                    } else {
                        a.this.f56885a.a((String) null);
                    }
                }

                public final void a(NetworkCustomError networkCustomError) {
                    a.this.f56885a.b();
                    a.this.f56885a.b(networkCustomError);
                }
            }, str, this.f56889e);
        }
    }

    public final boolean b() {
        return this.f56887c;
    }

    public final boolean a(String str, String str2) {
        return str.equalsIgnoreCase(str2);
    }

    public final boolean a(String str) {
        if (k.a(str)) {
            return true;
        }
        this.f56885a.c();
        return false;
    }
}
