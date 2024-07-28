package net.one97.paytm.upgradeKyc.editprofile.e;

import android.net.Uri;
import android.webkit.URLUtil;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.b.e;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.CJRUserInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.CkycResponse;
import net.one97.paytm.upgradeKyc.editprofile.b.a;
import net.one97.paytm.upgradeKyc.editprofile.d.a;

public final class d implements a.d {

    /* renamed from: a  reason: collision with root package name */
    public a.e f65832a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.editprofile.d.a f65833b;

    public d(a.e eVar, net.one97.paytm.upgradeKyc.editprofile.d.a aVar) {
        k.c(eVar, "view");
        k.c(aVar, "model");
        this.f65832a = eVar;
        this.f65833b = aVar;
    }

    public final void a(IJRDataModel iJRDataModel) {
        k.c(iJRDataModel, Payload.RESPONSE);
        if (iJRDataModel instanceof CJRUserInfo) {
            try {
                CJRUserInfo cJRUserInfo = (CJRUserInfo) iJRDataModel;
                this.f65832a.c();
                if (cJRUserInfo.getStatus() == null || !k.a((Object) cJRUserInfo.getStatus(), (Object) AppConstants.TRANSACTION_STATUS_ERROR)) {
                    this.f65832a.a(cJRUserInfo);
                    return;
                }
                k.a((Object) cJRUserInfo.getStatus(), "userInfo.status");
                cJRUserInfo.getMessage();
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else if (iJRDataModel instanceof CJRUserInfoV2) {
            try {
                CJRUserInfoV2 cJRUserInfoV2 = (CJRUserInfoV2) iJRDataModel;
                this.f65832a.c();
                String status = cJRUserInfoV2.getStatus();
                if (status != null) {
                    int hashCode = status.hashCode();
                    if (hashCode != -368591510) {
                        if (hashCode == 66247144) {
                            if (status.equals(AppConstants.TRANSACTION_STATUS_ERROR)) {
                                String status2 = cJRUserInfoV2.getStatus();
                                String message = cJRUserInfoV2.getMessage();
                                a.e eVar = this.f65832a;
                                k.a((Object) status2, "title");
                                k.a((Object) message, "message");
                                eVar.a(status2, message);
                                return;
                            }
                        }
                    } else if (status.equals("FAILURE")) {
                        if (k.a((Object) cJRUserInfoV2.getMessage(), (Object) "Invalid Token")) {
                            NetworkCustomError networkCustomError = new NetworkCustomError();
                            networkCustomError.setStatusCode(401);
                            this.f65832a.b(networkCustomError);
                            return;
                        }
                        return;
                    }
                }
                e a2 = net.one97.paytm.common.b.d.a();
                net.one97.paytm.common.b.a b2 = net.one97.paytm.common.b.d.b();
                k.a((Object) b2, "HomeHelper.getAppLaunchModuleInterface()");
                a2.a(cJRUserInfoV2, b2.a());
                this.f65832a.a(cJRUserInfoV2);
            } catch (Exception e3) {
                if (b.v) {
                    q.b(e3.getMessage());
                }
            }
        } else if (iJRDataModel instanceof CkycResponse) {
            this.f65832a.c();
            if (p.a(((CkycResponse) iJRDataModel).getCode(), WebLogin.RESPONSE_CODE_SUCCESS, false)) {
                this.f65832a.a();
            } else {
                this.f65832a.d();
            }
        } else if (iJRDataModel instanceof CJRAadharPanGet) {
            CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) iJRDataModel;
            String status3 = cJRAadharPanGet.getStatus();
            if (status3 != null) {
                int hashCode2 = status3.hashCode();
                if (hashCode2 != -368591510) {
                    if (hashCode2 == 66247144 && status3.equals(AppConstants.TRANSACTION_STATUS_ERROR)) {
                        this.f65832a.a(cJRAadharPanGet);
                        return;
                    }
                } else if (status3.equals("FAILURE")) {
                    if (k.a((Object) cJRAadharPanGet.getMessage(), (Object) "Invalid Token")) {
                        NetworkCustomError networkCustomError2 = new NetworkCustomError();
                        networkCustomError2.setStatusCode(401);
                        this.f65832a.b(networkCustomError2);
                        return;
                    }
                    return;
                }
            }
            this.f65832a.a(cJRAadharPanGet);
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        this.f65832a.a(networkCustomError);
    }

    public final void b() {
        this.f65832a.b();
        net.one97.paytm.upgradeKyc.editprofile.d.a aVar = this.f65833b;
        if (aVar != null) {
            a.d dVar = this;
            k.c(dVar, "kycProfileCallback");
            String a2 = net.one97.paytm.common.b.d.b().a(PaymentsGTMConstants.USER_DETAILS);
            if (URLUtil.isValidUrl(a2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(a2);
                e a3 = net.one97.paytm.common.b.d.a();
                k.a((Object) a3, "HomeHelper.getModuleInterface()");
                sb.append(a3.B());
                sb.append(",password_status,kyc_state");
                String sb2 = sb.toString();
                Uri parse = Uri.parse(sb2);
                k.a((Object) parse, "Uri.parse(url)");
                if (parse.getHost() != null) {
                    com.paytm.network.a a4 = net.one97.paytm.common.b.d.a(aVar.f65818a, sb2, new a.b(dVar), net.one97.paytm.common.b.d.a().u(aVar.f65818a), (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRUserInfoV2(), a.c.HOME, a.b.SILENT);
                    if (!com.paytm.utility.a.m(aVar.f65818a)) {
                        return;
                    }
                    if (a4 != null) {
                        a4.a();
                        return;
                    } else {
                        com.paytm.utility.a.c();
                        return;
                    }
                }
            }
            dVar.a();
        }
    }

    public final void a() {
        this.f65832a.c();
        this.f65832a.d();
    }
}
