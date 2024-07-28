package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.h;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.CJRAadharPanDocList;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.upgradeKyc.KYCForm60;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;

public class AJRNonKYCDeeplink extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f65217a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f65218b = Boolean.FALSE;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f65219d = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f65220e = Boolean.FALSE;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f65221f = Boolean.FALSE;

    /* renamed from: g  reason: collision with root package name */
    private KYCForm60 f65222g;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.f65218b = Boolean.valueOf(getIntent().getBooleanExtra("kyc_pan_deeplink", false));
        }
        if (this.f65218b.booleanValue()) {
            setTitle(getString(R.string.update_pan_title));
        } else {
            setTitle(getString(R.string.update_aadhar_title));
        }
        if (j.b((Context) this) == 1) {
            this.f65219d = Boolean.TRUE;
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().a(0.0f);
        }
        findViewById(R.id.kyc_loader);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.non_kyc_deeplink_proceed);
        RoboTextView roboTextView2 = (RoboTextView) findViewById(R.id.non_kyc_deeplink_will_do_later);
        RoboTextView roboTextView3 = (RoboTextView) findViewById(R.id.non_kyc_deeplink_text);
        this.f65217a = (LinearLayout) findViewById(R.id.non_kyc_deeplink_ll);
        if (this.f65218b.booleanValue()) {
            roboTextView3.setText(getString(R.string.non_kyc_deeplink_pan_text));
        } else {
            roboTextView3.setText(getString(R.string.non_kyc_deeplink_adhar_text));
        }
        roboTextView.setOnClickListener(this);
        roboTextView2.setOnClickListener(this);
        a.a((LottieAnimationView) findViewById(R.id.kyc_loader));
        if (this.f65219d.booleanValue()) {
            d();
            return;
        }
        String str = null;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("min_kyc_status_v3_url");
        }
        if (URLUtil.isValidUrl(str)) {
            String e2 = b.e((Context) this, str);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", com.paytm.utility.a.q(getApplicationContext()));
            KYCStatusV2 kYCStatusV2 = new KYCStatusV2();
            a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
            com.paytm.network.b a2 = a.C1317a.a();
            a2.f42877a = this;
            a2.f42879c = a.C0715a.GET;
            a2.f42882f = hashMap;
            a2.f42885i = kYCStatusV2;
            a2.f42880d = e2;
            a2.o = AJRNonKYCDeeplink.class.getName();
            a2.n = a.b.USER_FACING;
            a2.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    AJRNonKYCDeeplink.a(AJRNonKYCDeeplink.this, iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    l.a();
                    l.a((Context) AJRNonKYCDeeplink.this, networkCustomError);
                }
            };
            com.paytm.network.a l = a2.l();
            if (b.c((Context) this)) {
                l.a();
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.non_kyc_deeplink_proceed) {
            finish();
            startActivityForResult(new Intent(this, UpgradeKycActivity.class), 312);
        } else if (view.getId() == R.id.non_kyc_deeplink_will_do_later) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, View view) {
        hVar.dismiss();
        finish();
    }

    private void d() {
        String str;
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("kycFetchProfileInfoV2");
        } else {
            str = null;
        }
        if (!URLUtil.isValidUrl(str)) {
            b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
            return;
        }
        String e2 = b.e((Context) this, str);
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.a.q(this));
        CJRAadharPanGet cJRAadharPanGet = new CJRAadharPanGet();
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a2 = a.C1317a.a();
        a2.f42877a = this;
        a2.f42879c = a.C0715a.GET;
        a2.f42882f = hashMap;
        a2.f42885i = cJRAadharPanGet;
        a2.f42880d = e2;
        a2.o = VerifyDocActivity.class.getName();
        a2.n = a.b.USER_FACING;
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                AJRNonKYCDeeplink.a(AJRNonKYCDeeplink.this, iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                l.a();
                if (!l.a((Context) AJRNonKYCDeeplink.this, networkCustomError)) {
                    a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    a.C1317a.a((Context) AJRNonKYCDeeplink.this, networkCustomError);
                }
            }
        };
        com.paytm.network.a l = a2.l();
        if (b.c((Context) this)) {
            l.a();
            return;
        }
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        a.C1317a.a((Context) this, l);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 312) {
            finish();
        }
    }

    public final int a() {
        return R.layout.activity_non_kyc_deeplink;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    static /* synthetic */ void a(AJRNonKYCDeeplink aJRNonKYCDeeplink, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof KYCStatusV2) {
            KYCStatusV2 kYCStatusV2 = (KYCStatusV2) iJRPaytmDataModel;
            j.a(aJRNonKYCDeeplink.getApplicationContext(), kYCStatusV2.getIsKycDone());
            if (kYCStatusV2.getIsKycDone() == 1) {
                aJRNonKYCDeeplink.d();
                return;
            }
            b.p();
            e.a aVar = e.f66028b;
            e.a.b().a("/kyc/not-done", "kyc", (Context) aJRNonKYCDeeplink);
            aJRNonKYCDeeplink.f65217a.setVisibility(0);
        } else if (iJRPaytmDataModel instanceof CJRAadharPanGet) {
            b.p();
            CJRAadharPanGet cJRAadharPanGet = (CJRAadharPanGet) iJRPaytmDataModel;
            try {
                if (aJRNonKYCDeeplink.findViewById(R.id.kyc_loader) != null) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) aJRNonKYCDeeplink.findViewById(R.id.kyc_loader));
                }
                if (cJRAadharPanGet != null && cJRAadharPanGet.getStatus() != null && cJRAadharPanGet.getStatus().equalsIgnoreCase(AppConstants.TRANSACTION_STATUS_ERROR)) {
                    h hVar = new h(aJRNonKYCDeeplink);
                    hVar.setTitle(aJRNonKYCDeeplink.getString(R.string.error));
                    hVar.a(cJRAadharPanGet.getMessage());
                    hVar.a(-3, aJRNonKYCDeeplink.getString(R.string.ok), new View.OnClickListener(hVar) {
                        private final /* synthetic */ h f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            AJRNonKYCDeeplink.this.a(this.f$1, view);
                        }
                    });
                    hVar.show();
                } else if (cJRAadharPanGet != null && cJRAadharPanGet.getDocuments() != null) {
                    aJRNonKYCDeeplink.f65222g = cJRAadharPanGet.getForm60Data();
                    List<CJRAadharPanDocList> documents = cJRAadharPanGet.getDocuments();
                    String str = "both";
                    for (int i2 = 0; i2 < documents.size(); i2++) {
                        if (documents.get(i2).getDocCode().equals("pan")) {
                            if (!documents.get(i2).getEditableAction().equals("EDITABLE_EXCLAMATED")) {
                                if (documents.get(i2).getEditableAction().equals("NON_EDITABLE_WAITING")) {
                                    aJRNonKYCDeeplink.f65221f = Boolean.TRUE;
                                }
                                if (documents.get(i2).getEditableAction().equals("NON_EDITABLE_TICKED")) {
                                    b.m(aJRNonKYCDeeplink, documents.get(i2).getDocValue());
                                    b.c((Context) aJRNonKYCDeeplink, Boolean.TRUE);
                                }
                                if (str.equals("both")) {
                                    str = "aadhar";
                                } else {
                                    if (!str.equals("pan")) {
                                    }
                                    str = "none";
                                }
                            }
                        }
                        if (documents.get(i2).getDocCode().equals("aadhar") && !documents.get(i2).getEditableAction().equals("EDITABLE_EXCLAMATED")) {
                            if (documents.get(i2).getEditableAction().equals("NON_EDITABLE_WAITING")) {
                                aJRNonKYCDeeplink.f65220e = Boolean.TRUE;
                            }
                            if (documents.get(i2).getEditableAction().equals("NON_EDITABLE_TICKED")) {
                                b.l(aJRNonKYCDeeplink, documents.get(i2).getDocValue());
                                b.b((Context) aJRNonKYCDeeplink, Boolean.TRUE);
                            }
                            if (str.equals("both")) {
                                str = "pan";
                            } else if (str.equals("aadhar")) {
                                str = "none";
                            }
                        }
                    }
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case -1425275947:
                            if (str.equals("aadhar")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 110749:
                            if (str.equals("pan")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 3029889:
                            if (str.equals("both")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 3387192:
                            if (str.equals("none")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 != 2) {
                                if (c2 == 3) {
                                    if (aJRNonKYCDeeplink.f65218b.booleanValue()) {
                                        Intent intent = new Intent(aJRNonKYCDeeplink, PanUpdateActivity.class);
                                        intent.putExtra("is_kyc_doc_deeplink", true);
                                        intent.putExtra("is_doc_not_uploaded", true);
                                        intent.putExtra("is_doc_verified", false);
                                        intent.putExtra("update_both_pan_adhar", false);
                                        intent.putExtra("kycform60", aJRNonKYCDeeplink.f65222g);
                                        aJRNonKYCDeeplink.startActivityForResult(intent, 312);
                                    }
                                }
                            } else if (aJRNonKYCDeeplink.f65218b.booleanValue()) {
                                Intent intent2 = new Intent(aJRNonKYCDeeplink, PanUpdateActivity.class);
                                intent2.putExtra("is_kyc_doc_deeplink", true);
                                intent2.putExtra("is_doc_not_uploaded", false);
                                intent2.putExtra("is_doc_verified", aJRNonKYCDeeplink.f65221f);
                                intent2.putExtra("update_both_pan_adhar", true);
                                intent2.putExtra("kycform60", aJRNonKYCDeeplink.f65222g);
                                aJRNonKYCDeeplink.startActivityForResult(intent2, 312);
                            }
                        } else if (aJRNonKYCDeeplink.f65218b.booleanValue()) {
                            Intent intent3 = new Intent(aJRNonKYCDeeplink, PanUpdateActivity.class);
                            intent3.putExtra("kycform60", aJRNonKYCDeeplink.f65222g);
                            intent3.putExtra("is_kyc_doc_deeplink", true);
                            intent3.putExtra("is_doc_not_uploaded", true);
                            intent3.putExtra("is_doc_verified", false);
                            intent3.putExtra("update_both_pan_adhar", true);
                            aJRNonKYCDeeplink.startActivityForResult(intent3, 312);
                        }
                    } else if (!aJRNonKYCDeeplink.f65218b.booleanValue()) {
                        boolean booleanValue = aJRNonKYCDeeplink.f65220e.booleanValue();
                    } else if (aJRNonKYCDeeplink.f65221f.booleanValue()) {
                        Intent intent4 = new Intent(aJRNonKYCDeeplink, PanUpdateActivity.class);
                        intent4.putExtra("is_kyc_doc_deeplink", true);
                        intent4.putExtra("is_doc_not_uploaded", false);
                        intent4.putExtra("is_doc_verified", aJRNonKYCDeeplink.f65221f);
                        intent4.putExtra("update_both_pan_adhar", false);
                        intent4.putExtra("kycform60", aJRNonKYCDeeplink.f65222g);
                        aJRNonKYCDeeplink.startActivityForResult(intent4, 312);
                    } else {
                        Intent intent5 = new Intent(aJRNonKYCDeeplink, PanUpdateActivity.class);
                        intent5.putExtra("is_kyc_doc_deeplink", true);
                        intent5.putExtra("is_doc_not_uploaded", false);
                        intent5.putExtra("is_doc_verified", aJRNonKYCDeeplink.f65221f);
                        intent5.putExtra("update_both_pan_adhar", false);
                        intent5.putExtra("kycform60", aJRNonKYCDeeplink.f65222g);
                        aJRNonKYCDeeplink.startActivityForResult(intent5, 312);
                    }
                    aJRNonKYCDeeplink.overridePendingTransition(0, 0);
                }
            } catch (Exception unused) {
            }
        }
    }
}
