package net.one97.paytm.upgradeKyc.f;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.upgradeKyc.ActionAdditionalDetails;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.common.entity.upgradeKyc.KycAddDetail;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.upgradeKyc.activity.AppointmentBookActivityV2;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.activity.KycFlowActivity;
import net.one97.paytm.upgradeKyc.activity.VerifyDocActivity;
import net.one97.paytm.upgradeKyc.activity.WalletUpgradedSuccessActivity;
import net.one97.paytm.upgradeKyc.kycV3.activity.MinKycStatusSuccessActivity;
import net.one97.paytm.upgradeKyc.utils.c;
import net.one97.paytm.upgradeKyc.utils.j;

public final class b implements Response.ErrorListener, Response.Listener<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public a f65966a;

    /* renamed from: b  reason: collision with root package name */
    public String f65967b;

    /* renamed from: c  reason: collision with root package name */
    public String f65968c;

    /* renamed from: d  reason: collision with root package name */
    public Context f65969d;

    /* renamed from: e  reason: collision with root package name */
    public String f65970e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f65971f;

    public final void onErrorResponse(VolleyError volleyError) {
    }

    public final /* bridge */ /* synthetic */ void onResponse(Object obj) {
    }

    public b(Context context, a aVar) {
        k.c(context, "context");
        k.c(aVar, "listner");
        this.f65971f = context;
        this.f65966a = aVar;
        Context applicationContext = this.f65971f.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        this.f65969d = applicationContext;
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65972a;

        public a(b bVar) {
            this.f65972a = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
            r0 = (net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData) r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r4) {
            /*
                r3 = this;
                net.one97.paytm.upgradeKyc.f.b r0 = r3.f65972a
                net.one97.paytm.upgradeKyc.f.a r0 = r0.f65966a
                if (r0 == 0) goto L_0x0009
                r0.d()
            L_0x0009:
                if (r4 == 0) goto L_0x0027
                boolean r0 = r4 instanceof net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData
                if (r0 == 0) goto L_0x0027
                r0 = r4
                net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData r0 = (net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData) r0
                java.lang.Integer r1 = r0.getStatusCode()
                if (r1 != 0) goto L_0x0019
                goto L_0x0027
            L_0x0019:
                int r1 = r1.intValue()
                r2 = 200(0xc8, float:2.8E-43)
                if (r1 != r2) goto L_0x0027
                net.one97.paytm.upgradeKyc.f.b r4 = r3.f65972a
                net.one97.paytm.upgradeKyc.f.b.a(r4, r0)
                return
            L_0x0027:
                if (r4 == 0) goto L_0x0036
                boolean r4 = r4 instanceof net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData
                if (r4 == 0) goto L_0x0036
                net.one97.paytm.upgradeKyc.f.b r4 = r3.f65972a
                net.one97.paytm.upgradeKyc.f.a r4 = r4.f65966a
                if (r4 == 0) goto L_0x0036
                r4.a()
            L_0x0036:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.f.b.a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            a aVar = this.f65972a.f65966a;
            if (aVar != null) {
                aVar.d();
            }
            a aVar2 = this.f65972a.f65966a;
            if (aVar2 != null) {
                aVar2.a(networkCustomError);
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, KycSavedUserData kycSavedUserData) {
        if (kycSavedUserData.getKYCDetail() != null && kycSavedUserData.getKYCDetail().size() > 0) {
            KYCDetail kYCDetail = kycSavedUserData.getKYCDetail().get(0);
            k.a((Object) kYCDetail, "kycsaveddata.kycDetail[0]");
            if (kYCDetail.getAction() > 0) {
                KYCDetail kYCDetail2 = kycSavedUserData.getKYCDetail().get(0);
                k.a((Object) kYCDetail2, "kycsaveddata.kycDetail[0]");
                String kycExpiryTime = kYCDetail2.getKycExpiryTime();
                if (!TextUtils.isEmpty(kycExpiryTime)) {
                    j.d(bVar.f65969d, c.a(kycExpiryTime));
                }
                KYCDetail kYCDetail3 = kycSavedUserData.getKYCDetail().get(0);
                k.a((Object) kYCDetail3, "kycsaveddata.kycDetail[0]");
                if (!TextUtils.isEmpty(kYCDetail3.getExpired())) {
                    KYCDetail kYCDetail4 = kycSavedUserData.getKYCDetail().get(0);
                    k.a((Object) kYCDetail4, "kycsaveddata.kycDetail[0]");
                    if (p.a(kYCDetail4.getExpired(), "true", true)) {
                        j.b(bVar.f65969d.getApplicationContext(), 1);
                    }
                }
                KYCDetail kYCDetail5 = kycSavedUserData.getKYCDetail().get(0);
                k.a((Object) kYCDetail5, "kycsaveddata.kycDetail[0]");
                if (kYCDetail5.getAction() != 2) {
                    KYCDetail kYCDetail6 = kycSavedUserData.getKYCDetail().get(0);
                    k.a((Object) kYCDetail6, "kycsaveddata.kycDetail[0]");
                    if (kYCDetail6.getAction() == 1) {
                        Intent intent = new Intent(bVar.f65969d, VerifyDocActivity.class);
                        a aVar = bVar.f65966a;
                        if (aVar != null) {
                            aVar.a(intent);
                        }
                        a aVar2 = bVar.f65966a;
                        if (aVar2 != null) {
                            aVar2.c();
                            return;
                        }
                        return;
                    }
                    KYCDetail kYCDetail7 = kycSavedUserData.getKYCDetail().get(0);
                    k.a((Object) kYCDetail7, "kycsaveddata.kycDetail[0]");
                    if (kYCDetail7.getAction() != 3) {
                        KYCDetail kYCDetail8 = kycSavedUserData.getKYCDetail().get(0);
                        k.a((Object) kYCDetail8, "kycsaveddata.kycDetail[0]");
                        if (kYCDetail8.getAction() == 4) {
                            Intent intent2 = new Intent(bVar.f65969d, InPersonVerification.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("kyc_additional_info", kycSavedUserData.getKYCDetail().get(0));
                            bundle.putString("vertical", bVar.f65968c);
                            bundle.putString("call_back_url", bVar.f65967b);
                            intent2.putExtras(bundle);
                            a aVar3 = bVar.f65966a;
                            if (aVar3 != null) {
                                aVar3.a(intent2);
                                return;
                            }
                            return;
                        }
                        KYCDetail kYCDetail9 = kycSavedUserData.getKYCDetail().get(0);
                        k.a((Object) kYCDetail9, "kycsaveddata.kycDetail[0]");
                        if (kYCDetail9.getAction() == 5) {
                            Intent intent3 = new Intent(bVar.f65969d, WalletUpgradedSuccessActivity.class);
                            a aVar4 = bVar.f65966a;
                            if (aVar4 != null) {
                                aVar4.a(intent3);
                            }
                            a aVar5 = bVar.f65966a;
                            if (aVar5 != null) {
                                aVar5.c();
                                return;
                            }
                            return;
                        }
                        KYCDetail kYCDetail10 = kycSavedUserData.getKYCDetail().get(0);
                        k.a((Object) kYCDetail10, "kycsaveddata.kycDetail[0]");
                        if (kYCDetail10.getAction() == 6) {
                            Intent intent4 = new Intent(bVar.f65969d, KycFlowActivity.class);
                            intent4.putExtra("kyc_flow_purpose", 4);
                            Bundle bundle2 = new Bundle();
                            bundle2.putSerializable("kyc_additional_info", kycSavedUserData.getKYCDetail().get(0));
                            intent4.putExtras(bundle2);
                            a aVar6 = bVar.f65966a;
                            if (aVar6 != null) {
                                aVar6.a(intent4);
                            }
                            a aVar7 = bVar.f65966a;
                            if (aVar7 != null) {
                                aVar7.c();
                                return;
                            }
                            return;
                        }
                        KYCDetail kYCDetail11 = kycSavedUserData.getKYCDetail().get(0);
                        k.a((Object) kYCDetail11, "kycsaveddata.kycDetail[0]");
                        if (kYCDetail11.getAction() == 7) {
                            Intent intent5 = new Intent(bVar.f65969d, KycFlowActivity.class);
                            intent5.putExtra("kyc_flow_purpose", 3);
                            Bundle bundle3 = new Bundle();
                            bundle3.putSerializable("kyc_additional_info", kycSavedUserData.getKYCDetail().get(0));
                            intent5.putExtras(bundle3);
                            a aVar8 = bVar.f65966a;
                            if (aVar8 != null) {
                                aVar8.a(intent5);
                            }
                            a aVar9 = bVar.f65966a;
                            if (aVar9 != null) {
                                aVar9.c();
                                return;
                            }
                            return;
                        }
                        KYCDetail kYCDetail12 = kycSavedUserData.getKYCDetail().get(0);
                        k.a((Object) kYCDetail12, "kycsaveddata.kycDetail[0]");
                        if (kYCDetail12.getAction() == 8) {
                            Intent intent6 = new Intent(bVar.f65969d, KycFlowActivity.class);
                            intent6.putExtra("kyc_flow_purpose", 1);
                            Bundle bundle4 = new Bundle();
                            bundle4.putSerializable("kyc_additional_info", kycSavedUserData.getKYCDetail().get(0));
                            intent6.putExtras(bundle4);
                            a aVar10 = bVar.f65966a;
                            if (aVar10 != null) {
                                aVar10.a(intent6);
                            }
                            a aVar11 = bVar.f65966a;
                            if (aVar11 != null) {
                                aVar11.c();
                                return;
                            }
                            return;
                        }
                        KYCDetail kYCDetail13 = kycSavedUserData.getKYCDetail().get(0);
                        k.a((Object) kYCDetail13, "kycsaveddata.kycDetail[0]");
                        if (kYCDetail13.getAction() == 9) {
                            Intent intent7 = new Intent(bVar.f65969d, InPersonVerification.class);
                            Bundle bundle5 = new Bundle();
                            bundle5.putSerializable("kyc_additional_info", kycSavedUserData.getKYCDetail().get(0));
                            bundle5.putString("vertical", bVar.f65968c);
                            bundle5.putString("call_back_url", bVar.f65967b);
                            intent7.putExtras(bundle5);
                            a aVar12 = bVar.f65966a;
                            if (aVar12 != null) {
                                aVar12.a(intent7);
                                return;
                            }
                            return;
                        }
                        KYCDetail kYCDetail14 = kycSavedUserData.getKYCDetail().get(0);
                        k.a((Object) kYCDetail14, "kycsaveddata.kycDetail[0]");
                        if (kYCDetail14.getAction() == 10) {
                            Intent intent8 = new Intent(bVar.f65969d, KycFlowActivity.class);
                            intent8.putExtra("kyc_flow_purpose", 10);
                            intent8.putExtras(new Bundle());
                            a aVar13 = bVar.f65966a;
                            if (aVar13 != null) {
                                aVar13.a(intent8);
                            }
                            a aVar14 = bVar.f65966a;
                            if (aVar14 != null) {
                                aVar14.c();
                                return;
                            }
                            return;
                        }
                        KYCDetail kYCDetail15 = kycSavedUserData.getKYCDetail().get(0);
                        k.a((Object) kYCDetail15, "kycsaveddata.kycDetail[0]");
                        if (kYCDetail15.getAction() == 11) {
                            Intent intent9 = new Intent(bVar.f65969d, MinKycStatusSuccessActivity.class);
                            a aVar15 = bVar.f65966a;
                            if (aVar15 != null) {
                                aVar15.a(intent9);
                            }
                            a aVar16 = bVar.f65966a;
                            if (aVar16 != null) {
                                aVar16.c();
                            }
                        }
                    }
                } else if (!TextUtils.isEmpty(bVar.f65967b)) {
                    try {
                        String decode = URLDecoder.decode(bVar.f65967b, AppConstants.UTF_8);
                        if (decode != null) {
                            a aVar17 = bVar.f65966a;
                            if (aVar17 != null) {
                                aVar17.a(decode);
                            }
                            a aVar18 = bVar.f65966a;
                            if (aVar18 != null) {
                                aVar18.c();
                            }
                        }
                    } catch (UnsupportedEncodingException unused) {
                    }
                } else {
                    KYCDetail kYCDetail16 = kycSavedUserData.getKYCDetail().get(0);
                    if (!(kYCDetail16 == null || kYCDetail16.getActionAdditionalDetails() == null)) {
                        ActionAdditionalDetails actionAdditionalDetails = kYCDetail16.getActionAdditionalDetails();
                        k.a((Object) actionAdditionalDetails, "kycDetail.actionAdditionalDetails");
                        if (actionAdditionalDetails.getClickable() && kYCDetail16.getAddDetails() != null && kYCDetail16.getAddDetails().size() > 0) {
                            KycAddDetail kycAddDetail = kYCDetail16.getAddDetails().get(0);
                            k.a((Object) kycAddDetail, "kycDetail.addDetails.get(0)");
                            Intent intent10 = new Intent(bVar.f65969d, AppointmentBookActivityV2.class);
                            intent10.putExtra("appointmentBookedaddress", kycAddDetail);
                            a aVar19 = bVar.f65966a;
                            if (aVar19 != null) {
                                aVar19.a(intent10);
                                return;
                            }
                            return;
                        }
                    }
                    Intent intent11 = new Intent(bVar.f65969d, KycFlowActivity.class);
                    intent11.putExtra("kyc_flow_purpose", 1);
                    intent11.setFlags(67108864);
                    Bundle bundle6 = new Bundle();
                    bundle6.putSerializable("kyc_additional_info", kycSavedUserData.getKYCDetail().get(0));
                    intent11.putExtras(bundle6);
                    a aVar20 = bVar.f65966a;
                    if (aVar20 != null) {
                        aVar20.a(intent11);
                    }
                    a aVar21 = bVar.f65966a;
                    if (aVar21 != null) {
                        aVar21.c();
                    }
                }
            }
        }
    }
}
