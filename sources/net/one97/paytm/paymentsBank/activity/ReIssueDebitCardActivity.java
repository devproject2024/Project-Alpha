package net.one97.paytm.paymentsBank.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.g;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankCommon.model.IDCResponse;
import net.one97.paytm.bankCommon.model.PBCardDetailModel;
import net.one97.paytm.bankCommon.model.PBHelpVideoModel;
import net.one97.paytm.bankCommon.model.PBHelpVideoResponse;
import net.one97.paytm.common.widgets.CustomSwitch;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.customView.BankDebitCardView;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.pdc.a.n;
import net.one97.paytm.paymentsBank.pdc.activity.PDCLowBalancelActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCSelectAtmActivity;
import net.one97.paytm.paymentsBank.pdc.response.PDCPrevalidateResponse;
import net.one97.paytm.paymentsBank.pdc.response.PDCPriceResponse;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.paymentsBank.widget.FacilitiesView;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class ReIssueDebitCardActivity extends PBBaseToolbarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, d, g.a, g.b<IJRPaytmDataModel>, BankDebitCardView.a {

    /* renamed from: b  reason: collision with root package name */
    String f17402b = null;

    /* renamed from: c  reason: collision with root package name */
    String f17403c = null;

    /* renamed from: d  reason: collision with root package name */
    String f17404d = null;

    /* renamed from: f  reason: collision with root package name */
    private final int f17405f = 123;

    /* renamed from: g  reason: collision with root package name */
    private CustProductList f17406g;

    /* renamed from: h  reason: collision with root package name */
    private BankDebitCardView f17407h;

    /* renamed from: i  reason: collision with root package name */
    private PBCardDetailModel f17408i;
    private ViewGroup j;
    private CustomSwitch k;
    private ViewGroup l;
    private View m;
    private String n;
    private LottieAnimationView o;
    private String p;
    private ViewGroup q;
    private View r;
    private PBHelpVideoModel s;
    private IDCResponse t;
    private View u;
    private View v;
    private LottieAnimationView w;
    private View x;
    private boolean y;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
    }

    public final void a(String str) {
    }

    public final void g() {
    }

    public final void h() {
    }

    public final int e() {
        return R.layout.activity_reissue_debit_atm;
    }

    public final int f() {
        if (this.y) {
            return -1;
        }
        return R.layout.item_toolbar_center_icon;
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        if (getIntent() != null) {
            this.f17406g = (CustProductList) getIntent().getSerializableExtra("CUST_PRODUCT");
            this.f17408i = (PBCardDetailModel) getIntent().getSerializableExtra("CARD_DETAILS");
            this.p = getIntent().getStringExtra("goToScreen");
            this.y = getIntent().getBooleanExtra("block_with_req_again_pdc", false);
        }
        super.onCreate(bundle);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.help_videos_layout);
        if (viewGroup != null) {
            viewGroup.setOnClickListener($$Lambda$ReIssueDebitCardActivity$LhH3uAd2_yOMIRW6F7EEnPWL_OI.INSTANCE);
        }
        if (this.y) {
            findViewById(R.id.scrollView).setVisibility(8);
            c(true);
        } else {
            a.a(this.w);
            findViewById(R.id.scrollView).setVisibility(0);
            c(false);
        }
        this.x = findViewById(R.id.normalLayout);
        this.v = findViewById(R.id.pageLoadingLayout);
        this.w = (LottieAnimationView) findViewById(R.id.pageLoader);
        this.l = (ViewGroup) findViewById(R.id.atm_state_1);
        this.o = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.u = findViewById(R.id.loaderView);
        this.m = findViewById(R.id.request_atm_btn);
        View findViewById = findViewById(R.id.about_db_card);
        this.q = (ViewGroup) findViewById(R.id.pdc_about_layout);
        View findViewById2 = findViewById(R.id.requestCardKnowMoreButton);
        this.r = findViewById(R.id.videosLayout);
        this.r.setOnClickListener(this);
        this.m.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        ((FacilitiesView) findViewById).setTitle(getString(R.string.pb_pdc_view_benefits_and_offer));
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                ReIssueDebitCardActivity.this.k();
            }
        }, 5000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        if (net.one97.paytm.bankCommon.mapping.a.c((Context) this)) {
            ForgotPasscodeChallengesActivity.a((Context) this);
        } else {
            d();
        }
    }

    private void a(boolean z) {
        this.l.setVisibility(z ? 0 : 8);
        net.one97.paytm.bankCommon.mapping.g.a();
        if (!TextUtils.isEmpty(net.one97.paytm.bankCommon.utils.d.a("aboutCardBenefits"))) {
            if (!z) {
                findViewById(R.id.lineAboveBenefitsAbout).setVisibility(8);
            } else {
                findViewById(R.id.lineAboveBenefitsAbout).setVisibility(0);
            }
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
        if (z && "request_atm".equals(this.p)) {
            this.p = null;
            if ("RESTRICTED_BLOCK".equals(this.f17406g.getVdcCardStatus()) || "TEMP_BLOCK".equals(this.f17406g.getVdcCardStatus())) {
                b.a((Context) this, getString(R.string.unblock_your_card_to_request_atm));
                return;
            }
            Intent intent = new Intent(this, PDCSelectAtmActivity.class);
            intent.putExtra("CUST_PRODUCT", this.f17406g);
            startActivity(intent);
        }
    }

    public void onClick(View view) {
        if (!b.c((Context) this)) {
            b.a((Context) this, getString(R.string.pb_check_your_network));
            return;
        }
        int id = view.getId();
        if (id == R.id.request_atm_btn) {
            c.a(this, "bank_saving_account", "request_card_clicked", "", "", "/bank/savings-account/debit-card", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            if ("RESTRICTED_BLOCK".equals(this.f17406g.getVdcCardStatus()) || "TEMP_BLOCK".equals(this.f17406g.getVdcCardStatus())) {
                b.a((Context) this, getString(R.string.unblock_your_card_to_request_atm));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f b2 = net.one97.paytm.paymentsBank.pdc.a.b(this, this, this, "", a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            if (b.c((Context) this)) {
                a(this, getString(R.string.pb_please_wait));
                getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(b2);
            }
        } else if (id == R.id.videosLayout) {
            if (!b.c((Context) this)) {
                b.a((Context) this, getString(R.string.pb_check_your_network));
                return;
            }
            PBHelpVideoModel pBHelpVideoModel = this.s;
            if (pBHelpVideoModel != null) {
                c.a(this, "user_learning", "click on help video", pBHelpVideoModel.getTitle(), "", "/bank/help_videos", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                o.a().openYoutubePlayerFragment(this, this.s.getUrl());
            }
        } else if (id == R.id.requestCardKnowMoreButton) {
            n.a((d) this).show(getSupportFragmentManager(), "requestAtmPopUp");
        } else if (id == R.id.about_db_card) {
            net.one97.paytm.bankCommon.mapping.g.a();
            o.a().openWebViewActivity(this, net.one97.paytm.bankCommon.utils.d.a("aboutCardBenefits"), getString(R.string.pb_pdc_benefits_and_offer));
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 234 && i3 == -1) {
            Toast.makeText(this, getString(R.string.card_blocked), 0).show();
            this.j.setVisibility(8);
            setResult(-1);
            finish();
        } else if (i2 == 7 && i3 == -1) {
            if (intent != null && intent.hasExtra("forgot_passcode_access")) {
                Intent intent2 = new Intent(this, AJRForgotPasscode.class);
                intent2.putExtra("forgot_passcode_access", intent.getStringExtra("forgot_passcode_access"));
                startActivityForResult(intent2, 9856);
            }
        } else if (i2 == 123) {
            finish();
        }
    }

    public final void a(net.one97.paytm.paymentsBank.customView.c cVar) {
        if (cVar == net.one97.paytm.paymentsBank.customView.c.MASKED_CARD) {
            this.j.setVisibility(0);
            Toast.makeText(this, getString(R.string.card_unblocked), 0).show();
        } else if (cVar == net.one97.paytm.paymentsBank.customView.c.BLOCK_CARD) {
            this.j.setVisibility(8);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            c();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!b.c((Context) this) && z) {
            this.k.setChecked(false);
            b.a((Context) this, getString(R.string.pb_check_your_network));
        } else if (z) {
            this.f17407h.d();
            this.k.toggle();
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof CustProductStatus) {
            CustProductStatus custProductStatus = (CustProductStatus) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(custProductStatus.getProduct()) && "PDC".equalsIgnoreCase(custProductStatus.getProduct())) {
                if (!"Y".equals(custProductStatus.getVDC()) || !"Y".equals(custProductStatus.getISA())) {
                    b.b((Context) this, getString(R.string.error), getString(R.string.pb_pdc_error_prerequisite));
                    return;
                }
                Intent intent = new Intent(this, PDCSelectAtmActivity.class);
                intent.putExtra("CUST_PRODUCT", this.f17406g);
                startActivityForResult(intent, 123);
            }
        } else if (iJRPaytmDataModel instanceof CustProductList) {
            this.f17406g = (CustProductList) iJRPaytmDataModel;
            String vdcStatus = this.f17406g.getVdcStatus();
            net.one97.paytm.common.widgets.a.b(this.w);
            if (this.y) {
                c(false);
            }
            if (TextUtils.isEmpty(this.f17406g.getErrorMessage())) {
                if (!isFinishing()) {
                    if ("ISSUED".equalsIgnoreCase(vdcStatus)) {
                        if (this.y) {
                            this.m.performClick();
                        } else {
                            this.x.setVisibility(0);
                            CustProductList custProductList = this.f17406g;
                            if (custProductList != null) {
                                if (!TextUtils.isEmpty(custProductList.getVdcStatus()) && this.f17406g.getVdcStatus().equalsIgnoreCase("ISSUED")) {
                                    this.f17407h = new BankDebitCardView(this);
                                    this.f17407h.setBankCardListener(this);
                                    this.f17407h.setForgotPasswordCallback(new BankDebitCardView.b() {
                                        public final void onClickForgotPassword() {
                                            ReIssueDebitCardActivity.this.j();
                                        }
                                    });
                                    net.one97.paytm.paymentsBank.customView.c cVar = net.one97.paytm.paymentsBank.customView.c.MASKED_CARD;
                                    if (!TextUtils.isEmpty(this.f17406g.getVdcCardStatus())) {
                                        if (H5ThreadType.NORMAL.equalsIgnoreCase(this.f17406g.getVdcCardStatus())) {
                                            if (this.f17408i != null) {
                                                cVar = net.one97.paytm.paymentsBank.customView.c.FULL_CARD;
                                            } else {
                                                cVar = net.one97.paytm.paymentsBank.customView.c.MASKED_CARD;
                                            }
                                        } else if ("RESTRICTED_BLOCK".equalsIgnoreCase(this.f17406g.getVdcCardStatus())) {
                                            cVar = net.one97.paytm.paymentsBank.customView.c.RESTRICTED_BLOCK;
                                        } else {
                                            cVar = net.one97.paytm.paymentsBank.customView.c.BLOCK_CARD;
                                        }
                                    }
                                    this.f17407h.setDebitCardState(cVar);
                                    this.f17407h.a(this.f17406g);
                                    this.f17407h.setCardDetails(this.f17408i);
                                    ((FrameLayout) findViewById(R.id.activity_manage_debit_atm_card_lyt)).addView(this.f17407h);
                                    if (this.f17406g.getIsaAccountStatus() == null || "CLOSED".equalsIgnoreCase(this.f17406g.getIsaAccountStatus()) || net.one97.paytm.passbook.beans.CustProductList.ISA_DEBIT_FREEZED.equalsIgnoreCase(this.f17406g.getIsaAccountStatus()) || net.one97.paytm.passbook.beans.CustProductList.ISA_TOTAL_FREEZED.equalsIgnoreCase(this.f17406g.getIsaAccountStatus())) {
                                        a(false);
                                    } else {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("screen_name", getClass().getSimpleName());
                                        f d2 = net.one97.paytm.paymentsBank.b.a.d(this, this.f17406g.getVdcCardAlias(), this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
                                        if (b.c((Context) this)) {
                                            b(true);
                                            new net.one97.paytm.bankCommon.g.c();
                                            net.one97.paytm.bankCommon.g.c.a(d2);
                                        } else {
                                            b(d2);
                                        }
                                    }
                                }
                            } else if (this.f17407h != null) {
                                ((FrameLayout) findViewById(R.id.activity_manage_debit_atm_card_lyt)).removeAllViews();
                            }
                        }
                    } else if (this.y) {
                        com.paytm.utility.g.b(this, getString(R.string.pb_pdc_reissue_pending_title), getString(R.string.pb_pdc_reissue_pending_msg), new g.c() {
                            public final void onDialogDismissed() {
                                ReIssueDebitCardActivity.this.finish();
                            }
                        });
                    } else {
                        findViewById(R.id.vdcPendingTv).setVisibility(0);
                        ((TextView) findViewById(R.id.tv_card_reissue_msg)).setText(R.string.pb_pdc_pending_vdc_state);
                        this.x.setVisibility(8);
                    }
                    this.v.setVisibility(8);
                }
            } else if (this.y) {
                com.paytm.utility.g.b(this, getString(R.string.error), this.f17406g.getErrorMessage(), new g.c() {
                    public final void onDialogDismissed() {
                        ReIssueDebitCardActivity.this.finish();
                    }
                });
            } else {
                b.b((Context) this, getString(R.string.error), this.f17406g.getErrorMessage());
            }
        } else if (iJRPaytmDataModel instanceof IDCResponse) {
            this.t = (IDCResponse) iJRPaytmDataModel;
            if (!isFinishing()) {
                b(false);
                net.one97.paytm.bankCommon.mapping.g.a();
                IDCResponse iDCResponse = this.t;
                if (iDCResponse != null) {
                    if (iDCResponse.getIdcDetails() != null) {
                        if (!TextUtils.isEmpty(this.t.getIdcDetails().getStatus())) {
                            String status = this.t.getIdcDetails().getStatus();
                            if ("INITIATED".equalsIgnoreCase(status) || "PENDING".equalsIgnoreCase(status) || "FAILED".equalsIgnoreCase(status) || "IN_PROGRESS".equalsIgnoreCase(status) || "IN_PROGRESS".equalsIgnoreCase(status)) {
                                a(false);
                                return;
                            } else if (!"NOT_APPLIED".equalsIgnoreCase(status) && !"LEAD".equalsIgnoreCase(status)) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    IDCResponse iDCResponse2 = this.t;
                    if (iDCResponse2 == null || iDCResponse2.getPdcDetails() == null || TextUtils.isEmpty(this.t.getPdcDetails().getStatus())) {
                        a(false);
                        return;
                    }
                    this.n = this.t.getPdcDetails().getStatus();
                    this.t.getPdcDetails().getCardStatus();
                    if ("NOT_APPLIED".equalsIgnoreCase(this.n) || "LEAD".equalsIgnoreCase(this.n)) {
                        a(true);
                    } else {
                        a(false);
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof PBHelpVideoResponse) {
            PBHelpVideoResponse pBHelpVideoResponse = (PBHelpVideoResponse) iJRPaytmDataModel;
            if (pBHelpVideoResponse != null && pBHelpVideoResponse.getVideo() != null) {
                for (int i2 = 0; i2 < pBHelpVideoResponse.getVideo().size(); i2++) {
                    PBHelpVideoModel pBHelpVideoModel = pBHelpVideoResponse.getVideo().get(i2);
                    if (Constants.EASYPAY_PAYTYPE_DEBIT_CARD.equalsIgnoreCase(pBHelpVideoModel.getTag())) {
                        this.s = pBHelpVideoModel;
                        this.r.setVisibility(0);
                        return;
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof PDCPrevalidateResponse) {
            PDCPrevalidateResponse pDCPrevalidateResponse = (PDCPrevalidateResponse) iJRPaytmDataModel;
            if (this.y) {
                c(false);
            }
            if (pDCPrevalidateResponse.getResponseCode() == 200) {
                Intent intent2 = new Intent(this, PDCSelectAtmActivity.class);
                intent2.putExtra("CUST_PRODUCT", this.f17406g);
                intent2.putExtra("pdc_product_id", this.f17402b);
                intent2.putExtra("pdc_title", this.f17404d);
                intent2.putExtra("pdc_price", this.f17403c);
                startActivityForResult(intent2, 123);
            } else if (pDCPrevalidateResponse.getResponseCode() == 444) {
                Intent intent3 = new Intent(this, PDCLowBalancelActivity.class);
                intent3.putExtra("account_no_extra", this.f17406g.getIsaAccNum());
                intent3.putExtra("extra_ifsc", this.f17406g.getIsaIfsc());
                intent3.putExtra("pdc_product_id", this.f17402b);
                startActivity(intent3);
                if (this.y) {
                    finish();
                }
            } else {
                b.b((Context) this, getString(R.string.error), pDCPrevalidateResponse.getResponseMessage());
            }
        } else if (iJRPaytmDataModel instanceof PDCPriceResponse) {
            PDCPriceResponse pDCPriceResponse = (PDCPriceResponse) iJRPaytmDataModel;
            if (pDCPriceResponse.getResponseCode().intValue() == 200) {
                ArrayList arrayList = new ArrayList(pDCPriceResponse.getPayload());
                if (arrayList.size() > 0) {
                    this.f17402b = ((PDCPriceResponse.Payload) arrayList.get(0)).getProductId();
                    this.f17404d = ((PDCPriceResponse.Payload) arrayList.get(0)).getName();
                    this.f17403c = ((PDCPriceResponse.Payload) arrayList.get(0)).getPrice();
                    String str = this.f17402b;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("screen_name", getClass().getSimpleName());
                    f a2 = net.one97.paytm.paymentsBank.pdc.a.a(this, this, this, str, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
                    if (b.c((Context) this)) {
                        a(this, getString(R.string.pb_please_wait));
                        getApplicationContext();
                        new net.one97.paytm.bankCommon.g.c();
                        net.one97.paytm.bankCommon.g.c.a(a2);
                    }
                } else if (this.y) {
                    com.paytm.utility.g.b(this, getString(R.string.error), getString(R.string.pb_something_wrong_try_again), new g.c() {
                        public final void onDialogDismissed() {
                            ReIssueDebitCardActivity.this.finish();
                        }
                    });
                } else {
                    b.b((Context) this, getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
                }
            } else if (this.y) {
                com.paytm.utility.g.b(this, getString(R.string.error), pDCPriceResponse.getResponseMessage(), new g.c() {
                    public final void onDialogDismissed() {
                        ReIssueDebitCardActivity.this.finish();
                    }
                });
            } else {
                b.b((Context) this, getString(R.string.error), pDCPriceResponse.getResponseMessage());
            }
        }
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 == 100) {
            this.m.performClick();
        } else if (i2 == 107) {
            b.ai(this);
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b(false);
        a(false);
        if (this.y) {
            c(false);
        }
        j.a((Context) this, networkCustomError, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void k() {
        if (b.c((Context) this)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) this, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(a2);
        }
    }

    private void b(boolean z) {
        try {
            if (this.o != null) {
                net.one97.paytm.common.widgets.a.b(this.o);
                if (z) {
                    this.u.setVisibility(0);
                    net.one97.paytm.common.widgets.a.a(this.o);
                    return;
                }
                this.u.setVisibility(8);
                net.one97.paytm.common.widgets.a.b(this.o);
            }
        } catch (Exception unused) {
        }
    }

    private void c(boolean z) {
        try {
            net.one97.paytm.common.widgets.a.b(this.o);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.topLoading);
            if (z) {
                lottieAnimationView.setVisibility(0);
                net.one97.paytm.common.widgets.a.a(lottieAnimationView);
                return;
            }
            lottieAnimationView.setVisibility(8);
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        } catch (Exception unused) {
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
