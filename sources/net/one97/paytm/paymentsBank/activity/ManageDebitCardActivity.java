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
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankCommon.model.IDCResponse;
import net.one97.paytm.bankCommon.model.PBCardDetailModel;
import net.one97.paytm.bankCommon.model.PBHelpVideoModel;
import net.one97.paytm.bankCommon.model.PBHelpVideoResponse;
import net.one97.paytm.bankCommon.utils.c;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.customView.BankDebitCardView;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.fragment.m;
import net.one97.paytm.paymentsBank.pdc.a.p;
import net.one97.paytm.paymentsBank.pdc.activity.PDCLowBalancelActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCOrderDetailActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCSelectAtmActivity;
import net.one97.paytm.paymentsBank.pdc.response.PDCPrevalidateResponse;
import net.one97.paytm.paymentsBank.pdc.response.PDCPriceResponse;
import net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.paymentsBank.widget.FacilitiesView;
import net.one97.paytm.paymentsBank.widget.SwitchPlus;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class ManageDebitCardActivity extends PBBaseToolbarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, d, g.a, g.b<IJRPaytmDataModel>, BankDebitCardView.a {
    private View A;
    private PBHelpVideoModel B;
    private IDCResponse C;
    private View D;
    private TextView E;
    private TextView F;
    private TextView G;
    private View H;
    private View I;
    private boolean J;
    private View K;
    private boolean L;

    /* renamed from: b  reason: collision with root package name */
    String f17388b = null;

    /* renamed from: c  reason: collision with root package name */
    String f17389c = null;

    /* renamed from: d  reason: collision with root package name */
    String f17390d = null;

    /* renamed from: f  reason: collision with root package name */
    private final int f17391f = 234;

    /* renamed from: g  reason: collision with root package name */
    private final int f17392g = 123;

    /* renamed from: h  reason: collision with root package name */
    private CustProductList f17393h;

    /* renamed from: i  reason: collision with root package name */
    private BankDebitCardView f17394i;
    private PBCardDetailModel j;
    private ViewGroup k;
    private SwitchPlus l;
    private ViewGroup m;
    private ViewGroup n;
    private ViewGroup o;
    private ViewGroup p;
    private View q;
    private View r;
    private FacilitiesView s;
    private View t;
    private View u;
    private String v;
    private String w;
    private LottieAnimationView x;
    private String y;
    private ViewGroup z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
    }

    public final void a(String str) {
    }

    public final void g() {
    }

    public final int e() {
        return R.layout.activity_manage_debit_atm;
    }

    public final int f() {
        return R.layout.toolbar_manage_debit_card_activity;
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        if (!o.b()) {
            getIntent().getBooleanExtra("showasdialog", false);
            getSupportActionBar().b(false);
            findViewById(R.id.toolbar_close).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ManageDebitCardActivity.this.c(view);
                }
            });
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.help_videos_layout);
            if (viewGroup != null) {
                viewGroup.setOnClickListener($$Lambda$ManageDebitCardActivity$Gl5OMXZ8pnyNsW9DSaf2vwzHGVA.INSTANCE);
            }
            net.one97.paytm.bankCommon.utils.d.b();
            ((TextView) findViewById(R.id.toolbarTitle)).setText(R.string.pdc_manage_your_card);
            if (getIntent() != null) {
                this.f17393h = (CustProductList) getIntent().getSerializableExtra("CUST_PRODUCT");
                this.j = (PBCardDetailModel) getIntent().getSerializableExtra("CARD_DETAILS");
                this.y = getIntent().getStringExtra("goToScreen");
            }
            this.k = (ViewGroup) findViewById(R.id.blockBtnLayout);
            this.l = (SwitchPlus) findViewById(R.id.switch_toggle);
            this.E = (TextView) findViewById(R.id.switchTitle);
            this.F = (TextView) findViewById(R.id.switchSubtitle);
            this.H = findViewById(R.id.permanently_block_layout);
            this.G = (TextView) findViewById(R.id.permanently_block_tv);
            this.G.setOnClickListener(this);
            this.l.setOnOffColor(androidx.core.content.b.c(this, R.color.red), androidx.core.content.b.c(this, R.color.green));
            this.I = findViewById(R.id.atm_states_layout);
            this.m = (ViewGroup) findViewById(R.id.atm_state_1);
            this.n = (ViewGroup) findViewById(R.id.atm_state_2);
            this.o = (ViewGroup) findViewById(R.id.atm_state_3);
            this.p = (ViewGroup) findViewById(R.id.atm_state_4);
            this.x = (LottieAnimationView) findViewById(R.id.wallet_loader);
            this.D = findViewById(R.id.loaderView);
            this.r = findViewById(R.id.request_atm_btn);
            this.q = findViewById(R.id.request_again_atm_btn);
            this.s = (FacilitiesView) findViewById(R.id.atm_order_status_btn);
            this.t = findViewById(R.id.activate_atm_layout);
            this.u = findViewById(R.id.change_atm_pin);
            View findViewById = findViewById(R.id.about_db_card);
            this.z = (ViewGroup) findViewById(R.id.pdc_about_layout);
            this.K = findViewById(R.id.cst_issue_lyt);
            this.A = findViewById(R.id.videosLayout);
            this.A.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            findViewById.setOnClickListener(this);
            ((FacilitiesView) findViewById).setTitle(getString(R.string.pb_pdc_view_benefits_and_offer));
            ((FacilitiesView) this.u).setTitle(getString(R.string.change_atm_card_pin));
            this.s.setTitle(getString(R.string.atm_card_order_status));
            ((FacilitiesView) this.t).setTitle(getString(R.string.activate_atm_card));
            ((FacilitiesView) this.t).setSubTitle(getString(R.string.activate_your_atm_card_once));
            a(getIntent());
            if (this.B == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", getClass().getSimpleName());
                a.c cVar = a.c.PAYMENTSBANK;
                a.b bVar = a.b.USER_FACING;
                net.one97.paytm.bankCommon.mapping.g.a();
                String a2 = net.one97.paytm.bankCommon.utils.d.a("ppb_help_videos");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("User-Token", com.paytm.utility.a.q(this));
                net.one97.paytm.bankCommon.g.a aVar = new net.one97.paytm.bankCommon.g.a(a2, (g.b) this, (g.a) this, (IJRPaytmDataModel) new PBHelpVideoResponse(), (Map<String, String>) hashMap2, cVar, bVar, (HashMap<String, String>) hashMap, 0);
                if (b.c((Context) this)) {
                    new c();
                    c.a(aVar);
                } else {
                    b(aVar);
                }
            }
            if (this.f17393h != null) {
                i();
            } else {
                p();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        onBackPressed();
    }

    private void i() {
        CustProductList custProductList = this.f17393h;
        if (custProductList != null) {
            if (!TextUtils.isEmpty(custProductList.getVdcStatus()) && this.f17393h.getVdcStatus().equalsIgnoreCase("ISSUED")) {
                this.f17394i = new BankDebitCardView(this);
                this.f17394i.setBankCardListener(this);
                this.f17394i.setForgotPasswordCallback(new BankDebitCardView.b() {
                    public final void onClickForgotPassword() {
                        ManageDebitCardActivity.this.r();
                    }
                });
                net.one97.paytm.paymentsBank.customView.c cVar = net.one97.paytm.paymentsBank.customView.c.MASKED_CARD;
                if (!TextUtils.isEmpty(this.f17393h.getVdcCardStatus())) {
                    if (H5ThreadType.NORMAL.equalsIgnoreCase(this.f17393h.getVdcCardStatus())) {
                        if (this.j != null) {
                            cVar = net.one97.paytm.paymentsBank.customView.c.FULL_CARD;
                        } else {
                            cVar = net.one97.paytm.paymentsBank.customView.c.MASKED_CARD;
                        }
                    } else if ("RESTRICTED_BLOCK".equalsIgnoreCase(this.f17393h.getVdcCardStatus())) {
                        cVar = net.one97.paytm.paymentsBank.customView.c.RESTRICTED_BLOCK;
                    } else {
                        cVar = net.one97.paytm.paymentsBank.customView.c.BLOCK_CARD;
                    }
                }
                this.f17394i.setDebitCardState(cVar);
                this.l.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                this.f17394i.setDebitCardState(cVar);
                this.f17394i.a(this.f17393h);
                this.f17394i.setCardDetails(this.j);
                ((FrameLayout) findViewById(R.id.activity_manage_debit_atm_card_lyt)).removeAllViews();
                ((FrameLayout) findViewById(R.id.activity_manage_debit_atm_card_lyt)).addView(this.f17394i);
                if (H5ThreadType.NORMAL.equalsIgnoreCase(this.f17393h.getVdcCardStatus())) {
                    this.l.setChecked(true);
                    this.E.setText(getString(R.string.pb_vdc_unblocked_title_msg));
                    this.F.setText("");
                } else {
                    this.l.setChecked(false);
                    this.E.setText(getString(R.string.pb_vdc_blocked_title_msg));
                    this.F.setText("");
                }
                this.k.setVisibility(0);
                this.l.setOnCheckedChangeListener(this);
                if (this.f17393h.getIsaAccountStatus() == null || "CLOSED".equalsIgnoreCase(this.f17393h.getIsaAccountStatus()) || net.one97.paytm.passbook.beans.CustProductList.ISA_DEBIT_FREEZED.equalsIgnoreCase(this.f17393h.getIsaAccountStatus()) || net.one97.paytm.passbook.beans.CustProductList.ISA_TOTAL_FREEZED.equalsIgnoreCase(this.f17393h.getIsaAccountStatus())) {
                    a(false, false, false);
                } else {
                    q();
                }
            }
        } else if (this.f17394i != null) {
            ((FrameLayout) findViewById(R.id.activity_manage_debit_atm_card_lyt)).removeAllViews();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r() {
        if (net.one97.paytm.bankCommon.mapping.a.c((Context) this)) {
            ForgotPasscodeChallengesActivity.a((Context) this);
        } else {
            d();
        }
    }

    private void j() {
        this.H.setVisibility(0);
        if ("block_card".equalsIgnoreCase(this.y)) {
            this.y = null;
            this.H.setVisibility(0);
            this.G.setVisibility(0);
            m mVar = new m();
            mVar.f18528a = this;
            mVar.show(getSupportFragmentManager(), "bottomSheetDialogFragmentConfirm");
        }
    }

    private void k() {
        IDCResponse iDCResponse = this.C;
        if (iDCResponse == null || iDCResponse.getPdcDetails() == null || TextUtils.isEmpty(this.C.getPdcDetails().getStatus())) {
            a(false, false, false);
            this.H.setVisibility(8);
            return;
        }
        this.v = this.C.getPdcDetails().getStatus();
        this.w = this.C.getPdcDetails().getCardStatus();
        this.J = this.C.getPdcDetails().isMarketPlace();
        if ("NOT_APPLIED".equalsIgnoreCase(this.v) || "LEAD".equalsIgnoreCase(this.v)) {
            a(true, false, false);
        } else {
            if ("PENDING".equalsIgnoreCase(this.v) || "IN_PROGRESS".equalsIgnoreCase(this.v) || "INITIATED".equalsIgnoreCase(this.v) || "FAILED".equalsIgnoreCase(this.v)) {
                if (!TextUtils.isEmpty(this.C.getPdcDetails().getOrderId())) {
                    this.t.setVisibility(8);
                    a(false, true, false);
                    String orderId = this.C.getPdcDetails().getOrderId();
                    net.one97.paytm.bankCommon.mapping.g.a();
                    if (b.s(net.one97.paytm.bankCommon.utils.d.a("pdcTrackOrder"))) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("screen_name", getClass().getSimpleName());
                        f a2 = net.one97.paytm.paymentsBank.pdc.a.a(this, orderId, this.J, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
                        if (b.c((Context) this)) {
                            new c();
                            c.a(a2);
                        } else {
                            b(a2);
                        }
                    } else {
                        finish();
                    }
                } else {
                    a(false, false, false);
                }
            } else if ("ISSUED".equalsIgnoreCase(this.v) && "INACTIVE".equals(this.w)) {
                this.t.setVisibility(0);
                a(false, true, false);
                this.s.setSubTitle("");
            } else if ("ACTIVE".equals(this.w)) {
                a(false, false, true);
            } else {
                a(false, false, false);
            }
        }
        a(this.f17393h.getVdcCardStatus(), this.v, this.w);
    }

    private void a(String str, String str2, String str3) {
        if ("ISSUED".equalsIgnoreCase(str2)) {
            if (H5ThreadType.NORMAL.equalsIgnoreCase(str)) {
                this.E.setText(getString(R.string.pb_vdc_unblocked_title_msg));
                if ("ACTIVE".equals(str3)) {
                    this.F.setText(getString(R.string.pb_vdc_unblocked_card_active_msg));
                } else {
                    this.F.setText(getString(R.string.pb_block_db_switch_pdc_inactive_subtitle));
                }
                this.H.setVisibility(8);
                return;
            }
            this.E.setText(getString(R.string.pb_vdc_blocked_title_msg));
            if ("ACTIVE".equals(str3)) {
                this.F.setText(getString(R.string.pb_vdc_blocked_msg));
            } else {
                this.F.setText("");
                this.H.setVisibility(8);
            }
            j();
        } else if (H5ThreadType.NORMAL.equalsIgnoreCase(str)) {
            this.E.setText(getString(R.string.pb_vdc_unblocked_title_msg));
            this.F.setText(getString(R.string.pb_vdc_only_card_active_msg));
            this.H.setVisibility(8);
        } else if ("TEMP_BLOCK".equalsIgnoreCase(str)) {
            this.E.setText(getString(R.string.pb_vdc_blocked_title_msg));
            this.F.setText(getString(R.string.pb_vdc_only_unblock_ur_card_msg));
            j();
        } else {
            this.E.setText(getString(R.string.pb_vdc_blocked_title_msg));
            this.F.setText("");
            this.H.setVisibility(8);
        }
    }

    private void l() {
        this.r.setEnabled(false);
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f b2 = net.one97.paytm.paymentsBank.pdc.a.b(this, this, this, "", a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            getApplicationContext();
            new c();
            c.a(b2);
            return;
        }
        this.r.setEnabled(true);
    }

    private void a(boolean z2, boolean z3, boolean z4) {
        if (!isFinishing()) {
            this.m.setVisibility(z2 ? 0 : 8);
            this.n.setVisibility(z3 ? 0 : 8);
            this.o.setVisibility(z4 ? 0 : 8);
            this.p.setVisibility(z4 ? 0 : 8);
            if (z3) {
                this.s.findViewById(R.id.right_arrow_img).setVisibility(0);
                this.s.setClickable(true);
            }
            if (!TextUtils.isEmpty(n.a(this.f17393h.getVdcCardType()))) {
                if (z2 || z3 || z4) {
                    findViewById(R.id.lineAboveBenefitsAbout).setVisibility(0);
                } else {
                    findViewById(R.id.lineAboveBenefitsAbout).setVisibility(8);
                }
                this.z.setVisibility(0);
            } else {
                this.z.setVisibility(8);
            }
            if (z2 && "request_atm".equals(this.y)) {
                this.y = null;
                if ("RESTRICTED_BLOCK".equals(this.f17393h.getVdcCardStatus()) || "TEMP_BLOCK".equals(this.f17393h.getVdcCardStatus())) {
                    b.a((Context) this, getString(R.string.unblock_your_card_to_request_atm));
                    return;
                }
                this.r.performClick();
            } else if (z3) {
                String stringExtra = getIntent().getStringExtra("order_id");
                if ("track_atm_order".equals(this.y)) {
                    b(stringExtra);
                } else if ("retry_request_atm".equalsIgnoreCase(this.y)) {
                    b(stringExtra);
                }
            } else if (net.one97.paytm.paymentsBank.d.a.FORGOT_ATM_PIN.getFeatureType().equalsIgnoreCase(this.y)) {
                if ("RESTRICTED_BLOCK".equals(this.f17393h.getVdcCardStatus()) || "TEMP_BLOCK".equals(this.f17393h.getVdcCardStatus())) {
                    b.a((Context) this, getString(R.string.pb_unblock_your_card_first));
                    return;
                }
                Intent intent = new Intent(this, PDCPasscodePinActivity.class);
                if (this.C.getPdcDetails() != null) {
                    intent.putExtra("cardNumberAlias", this.C.getPdcDetails().getCardAliasNumber());
                } else {
                    intent.putExtra("cardNumberAlias", this.C.getIdcDetails().getCardAlias());
                }
                intent.putExtra("ENTER_HEADER", "atmPinForgot");
                startActivity(intent);
            } else if (z4 && "change_atm_pin".equalsIgnoreCase(this.y)) {
                this.u.performClick();
            }
            net.one97.paytm.bankCommon.utils.d.b();
            this.K.setVisibility(0);
            this.K.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ManageDebitCardActivity.this.a(view);
                }
            });
        }
    }

    public void onClick(View view) {
        String str;
        if (!b.c((Context) this)) {
            b.a((Context) this, getString(R.string.pb_check_your_network));
            return;
        }
        this.L = false;
        int id = view.getId();
        if (id == R.id.request_atm_btn) {
            if ("RESTRICTED_BLOCK".equals(this.f17393h.getVdcCardStatus())) {
                b.a((Context) this, getString(R.string.unblock_your_card_to_request_atm));
            } else if (c.C0228c.RUPAY.stringValue.startsWith(this.f17393h.getVdcCardType())) {
                l();
            } else {
                net.one97.paytm.paymentsBank.fragment.c cVar = new net.one97.paytm.paymentsBank.fragment.c();
                Bundle bundle = new Bundle();
                String vdcCardType = this.f17393h.getVdcCardType();
                if (!c.C0228c.VISA_PLATINUM.stringValue.startsWith(vdcCardType) && !c.C0228c.VISA_CLASSIC.stringValue.startsWith(vdcCardType)) {
                    if (c.C0228c.MASTER_PLATINUM.stringValue.startsWith(vdcCardType)) {
                        str = getString(R.string.pb_card_name_master);
                    } else if (c.C0228c.MASTER_CLASSIC.stringValue.startsWith(vdcCardType)) {
                        str = getString(R.string.pb_card_name_master);
                    }
                    bundle.putString("cardType", str);
                    cVar.setArguments(bundle);
                    cVar.f18488a = this;
                    cVar.show(getSupportFragmentManager(), "BlockNonRupayVDCBottomSheet");
                }
                str = getString(R.string.pb_card_name_visa);
                bundle.putString("cardType", str);
                cVar.setArguments(bundle);
                cVar.f18488a = this;
                cVar.show(getSupportFragmentManager(), "BlockNonRupayVDCBottomSheet");
            }
        } else if (id == R.id.videosLayout) {
            if (!b.c((Context) this)) {
                b.a((Context) this, getString(R.string.pb_check_your_network));
            } else if (this.B != null) {
                o.a().openYoutubePlayerFragment(this, this.B.getUrl());
            }
        } else if (id == R.id.atm_order_status_btn) {
            IDCResponse iDCResponse = this.C;
            if (iDCResponse != null && iDCResponse.getPdcDetails() != null && this.C.getPdcDetails().getOrderId() != null) {
                b(this.C.getPdcDetails().getOrderId());
            }
        } else if (id == R.id.activate_atm_layout) {
            if ("TEMP_BLOCK".equals(this.f17393h.getVdcCardStatus())) {
                b.a((Context) this, getString(R.string.unblock_your_card_to_request_atm));
            } else if (net.one97.paytm.bankCommon.h.b.u(this)) {
                o.a().openPaySendActivityForActivatingPDC(this);
            } else {
                net.one97.paytm.paymentsBank.pdc.a.a.a((d) this).show(getSupportFragmentManager(), "activateAtmCardPopUp");
            }
        } else if (id == R.id.change_atm_pin) {
            if ("TEMP_BLOCK".equals(this.f17393h.getVdcCardStatus())) {
                b.a((Context) this, getString(R.string.unblock_your_card_to_request_atm));
                return;
            }
            Intent intent = new Intent(this, PDCPasscodePinActivity.class);
            if (this.C.getPdcDetails() != null) {
                intent.putExtra("cardNumberAlias", this.C.getPdcDetails().getCardAliasNumber());
            } else {
                intent.putExtra("cardNumberAlias", this.C.getIdcDetails().getCardAlias());
            }
            intent.putExtra("ENTER_HEADER", "atmPinReset");
            startActivity(intent);
        } else if (id == R.id.about_db_card) {
            o.a().openWebViewActivity(this, n.a(this.f17393h.getVdcCardType()), getString(R.string.pb_pdc_benefits_and_offer));
        } else if (id == R.id.permanently_block_tv) {
            m mVar = new m();
            Bundle bundle2 = new Bundle();
            bundle2.putString("block_card_flow", "block_pdc_only");
            mVar.setArguments(bundle2);
            mVar.f18528a = this;
            mVar.show(getSupportFragmentManager(), "bottomSheetDialogFragmentConfirm");
        } else if (id != R.id.request_again_atm_btn) {
        } else {
            if ("RESTRICTED_BLOCK".equals(this.f17393h.getVdcCardStatus())) {
                b.a((Context) this, getString(R.string.unblock_your_card_to_request_atm));
                return;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("block_card_flow", "block_with_req_again_pdc");
            m mVar2 = new m();
            mVar2.setArguments(bundle3);
            mVar2.f18528a = this;
            mVar2.show(getSupportFragmentManager(), "bottomSheetDialogFragmentConfirm");
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.y = null;
            return;
        }
        Intent intent = new Intent(this, PDCOrderDetailActivity.class);
        intent.putExtra("pdc_is_delivery_status_checking", true);
        intent.putExtra("order_id", str);
        intent.putExtra("item_id", "");
        intent.putExtra("isMarketplaceorder", this.J);
        intent.putExtra("CUST_PRODUCT", this.f17393h);
        intent.putExtra("goToScreen", this.y);
        startActivityForResult(intent, 120);
        this.y = null;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 234 && i3 == -1) {
            Intent intent2 = new Intent(this, ReIssueDebitCardActivity.class);
            intent2.putExtra("block_with_req_again_pdc", this.L);
            startActivity(intent2);
            finish();
        } else if (i2 == 123) {
            p();
        } else if (i2 == 120 && i3 == -1) {
            o();
        } else if (i2 == 7 && i3 == -1 && intent != null && intent.hasExtra("forgot_passcode_access")) {
            Intent intent3 = new Intent(this, AJRForgotPasscode.class);
            intent3.putExtra("forgot_passcode_access", intent.getStringExtra("forgot_passcode_access"));
            startActivityForResult(intent3, 9856);
        }
    }

    public final void a(net.one97.paytm.paymentsBank.customView.c cVar) {
        if (cVar == net.one97.paytm.paymentsBank.customView.c.MASKED_CARD) {
            this.k.setVisibility(0);
            Toast.makeText(this, getString(R.string.card_unblocked), 0).show();
        } else if (cVar == net.one97.paytm.paymentsBank.customView.c.BLOCK_CARD) {
            this.I.setVisibility(0);
            m();
            this.k.setVisibility(0);
        }
        p();
    }

    private void m() {
        if (!TextUtils.isEmpty(n.a(this.f17393h.getVdcCardType()))) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
    }

    public final void h() {
        this.I.setVisibility(0);
        m();
        this.k.setVisibility(0);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            c();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (!b.c((Context) this)) {
            b.a((Context) this, getString(R.string.pb_check_your_network));
            new Handler().postDelayed(new Runnable(z2) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ManageDebitCardActivity.this.e(this.f$1);
                }
            }, 100);
        } else if (!z2) {
            this.f17394i.d();
            this.k.setVisibility(8);
            this.I.setVisibility(8);
            this.z.setVisibility(8);
            new Handler().postDelayed(new Runnable(z2) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ManageDebitCardActivity.this.d(this.f$1);
                }
            }, 100);
        } else {
            BankDebitCardView bankDebitCardView = this.f17394i;
            if (bankDebitCardView.f18207d != null && bankDebitCardView.f18207d == net.one97.paytm.paymentsBank.customView.c.RESTRICTED_BLOCK) {
                Toast.makeText(bankDebitCardView.f18204a, R.string.error_card_restricted, 0).show();
            } else if (!net.one97.paytm.bankCommon.h.b.a(bankDebitCardView.f18204a)) {
                bankDebitCardView.a();
            } else {
                bankDebitCardView.f18206c = 1;
                bankDebitCardView.setPasscodeTitle(bankDebitCardView.f18204a.getString(R.string.enter_passcode_to_unblock_card));
                bankDebitCardView.b();
                bankDebitCardView.setPasscodeStatus(true);
                bankDebitCardView.f18205b.requestFocus();
                bankDebitCardView.a(true);
            }
            new Handler().postDelayed(new Runnable(z2) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ManageDebitCardActivity.this.c(this.f$1);
                }
            }, 100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void e(boolean z2) {
        this.l.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (z2) {
            if (!H5ThreadType.NORMAL.equalsIgnoreCase(this.f17393h.getVdcCardStatus())) {
                this.l.setChecked(false);
            }
        } else if (!z2 && H5ThreadType.NORMAL.equalsIgnoreCase(this.f17393h.getVdcCardStatus())) {
            this.l.setChecked(true);
        }
        this.l.setOnCheckedChangeListener(this);
    }

    public void onBackPressed() {
        try {
            if (this.f17394i.e()) {
                BankDebitCardView bankDebitCardView = this.f17394i;
                bankDebitCardView.a(false);
                bankDebitCardView.b();
                bankDebitCardView.setPasscodeStatus(false);
                bankDebitCardView.b(false);
                this.I.setVisibility(0);
                m();
                this.k.setVisibility(0);
                return;
            }
            super.onBackPressed();
        } catch (Exception unused) {
            super.onBackPressed();
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        ah_();
        if (iJRPaytmDataModel instanceof CustProductStatus) {
            CustProductStatus custProductStatus = (CustProductStatus) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(custProductStatus.getProduct()) && "PDC".equalsIgnoreCase(custProductStatus.getProduct())) {
                if (!"Y".equals(custProductStatus.getVDC()) || !"Y".equals(custProductStatus.getISA())) {
                    b.b((Context) this, getString(R.string.error), getString(R.string.pb_pdc_error_prerequisite));
                    return;
                }
                this.r.setEnabled(true);
                Intent intent = new Intent(this, PDCSelectAtmActivity.class);
                intent.putExtra("CUST_PRODUCT", this.f17393h);
                startActivityForResult(intent, 123);
            }
        } else if (iJRPaytmDataModel instanceof CustProductList) {
            this.f17393h = (CustProductList) iJRPaytmDataModel;
            if (TextUtils.isEmpty(this.f17393h.getErrorMessage()) && !isFinishing()) {
                i();
            }
        } else if (iJRPaytmDataModel instanceof IDCResponse) {
            this.C = (IDCResponse) iJRPaytmDataModel;
            if (!isFinishing()) {
                b(false);
                net.one97.paytm.bankCommon.utils.d.b();
                IDCResponse iDCResponse = this.C;
                if (iDCResponse == null) {
                    return;
                }
                if (iDCResponse.getIdcDetails() == null) {
                    k();
                } else if (!TextUtils.isEmpty(this.C.getIdcDetails().getStatus())) {
                    String status = this.C.getIdcDetails().getStatus();
                    this.J = this.C.getIdcDetails().isMarketPlace();
                    if ("INITIATED".equalsIgnoreCase(status) || "PENDING".equalsIgnoreCase(status) || "FAILED".equalsIgnoreCase(status) || "IN_PROGRESS".equalsIgnoreCase(status) || "IN_PROGRESS".equalsIgnoreCase(status)) {
                        a(false, false, false);
                        this.H.setVisibility(8);
                    } else if ("ISSUED".equalsIgnoreCase(status)) {
                        str = this.C.getIdcDetails().getCardStatus();
                        if (str.equalsIgnoreCase("ACTIVE")) {
                            a(false, false, true);
                        } else if ("INACTIVE".equalsIgnoreCase(str)) {
                            this.s.setVisibility(8);
                            this.t.setVisibility(0);
                            a(false, true, false);
                            this.F.setText(getString(R.string.pb_block_db_switch_pdc_inactive_subtitle));
                            j();
                        } else {
                            this.H.setVisibility(8);
                        }
                        a(this.f17393h.getVdcCardStatus(), status, str);
                    } else if ("NOT_APPLIED".equalsIgnoreCase(status) || "LEAD".equalsIgnoreCase(status)) {
                        k();
                    }
                    str = "";
                    a(this.f17393h.getVdcCardStatus(), status, str);
                }
            }
        } else if (iJRPaytmDataModel instanceof PBHelpVideoResponse) {
            PBHelpVideoResponse pBHelpVideoResponse = (PBHelpVideoResponse) iJRPaytmDataModel;
            if (pBHelpVideoResponse != null && pBHelpVideoResponse.getVideo() != null) {
                for (int i2 = 0; i2 < pBHelpVideoResponse.getVideo().size(); i2++) {
                    PBHelpVideoModel pBHelpVideoModel = pBHelpVideoResponse.getVideo().get(i2);
                    if (Constants.EASYPAY_PAYTYPE_DEBIT_CARD.equalsIgnoreCase(pBHelpVideoModel.getTag())) {
                        this.B = pBHelpVideoModel;
                        this.A.setVisibility(0);
                        return;
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof PDCPrevalidateResponse) {
            PDCPrevalidateResponse pDCPrevalidateResponse = (PDCPrevalidateResponse) iJRPaytmDataModel;
            this.r.setEnabled(true);
            if (pDCPrevalidateResponse.getResponseCode() == 200) {
                Intent intent2 = new Intent(this, PDCSelectAtmActivity.class);
                intent2.putExtra("CUST_PRODUCT", this.f17393h);
                intent2.putExtra("pdc_product_id", this.f17388b);
                intent2.putExtra("pdc_title", this.f17390d);
                intent2.putExtra("pdc_price", this.f17389c);
                startActivityForResult(intent2, 123);
            } else if (pDCPrevalidateResponse.getResponseCode() == 444) {
                n();
            } else {
                b.b((Context) this, getString(R.string.error), pDCPrevalidateResponse.getResponseMessage());
            }
        } else if (iJRPaytmDataModel instanceof PDCPriceResponse) {
            this.r.setEnabled(true);
            PDCPriceResponse pDCPriceResponse = (PDCPriceResponse) iJRPaytmDataModel;
            if (pDCPriceResponse.getResponseCode().intValue() == 200) {
                ArrayList arrayList = new ArrayList(pDCPriceResponse.getPayload());
                if (arrayList.size() > 0) {
                    this.f17388b = ((PDCPriceResponse.Payload) arrayList.get(0)).getProductId();
                    this.f17390d = ((PDCPriceResponse.Payload) arrayList.get(0)).getName();
                    this.f17389c = ((PDCPriceResponse.Payload) arrayList.get(0)).getPrice();
                    String str2 = this.f17388b;
                    HashMap hashMap = new HashMap();
                    hashMap.put("screen_name", getClass().getSimpleName());
                    f a2 = net.one97.paytm.paymentsBank.pdc.a.a(this, this, this, str2, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
                    if (b.c((Context) this)) {
                        a(this, getString(R.string.pb_please_wait));
                        getApplicationContext();
                        new net.one97.paytm.bankCommon.g.c();
                        net.one97.paytm.bankCommon.g.c.a(a2);
                    }
                }
            } else if (pDCPriceResponse.getResponseCode().intValue() == 444) {
                n();
            } else {
                b.b((Context) this, getString(R.string.error), pDCPriceResponse.getResponseMessage());
            }
        } else if (iJRPaytmDataModel instanceof PDCTrackOrderResponse) {
            PDCTrackOrderResponse pDCTrackOrderResponse = (PDCTrackOrderResponse) iJRPaytmDataModel;
            if (pDCTrackOrderResponse.getPayload() != null && !TextUtils.isEmpty(pDCTrackOrderResponse.getPayload().getCurrentStatus())) {
                this.s.setSubTitle(pDCTrackOrderResponse.getPayload().getCurrentStatus());
                String currentStatus = pDCTrackOrderResponse.getPayload().getCurrentStatus();
                String deliveredAt = pDCTrackOrderResponse.getPayload().getDeliveredAt();
                if (!"Successful".equalsIgnoreCase(currentStatus) && TextUtils.isEmpty(deliveredAt)) {
                    return;
                }
                if ("INACTIVE".equals(this.w)) {
                    this.H.setVisibility(0);
                } else {
                    this.H.setVisibility(8);
                }
            }
        }
    }

    private void n() {
        Intent intent = new Intent(this, PDCLowBalancelActivity.class);
        intent.putExtra("account_no_extra", this.f17393h.getIsaAccNum());
        intent.putExtra("extra_ifsc", this.f17393h.getIsaIfsc());
        intent.putExtra("pdc_product_id", this.f17388b);
        startActivity(intent);
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 == 100) {
            this.r.performClick();
        } else if (i2 == 103) {
            this.t.performClick();
        } else if (i2 == 105) {
            o();
        } else if (i2 == 107) {
            b.ai(this);
        } else if (i2 == 108) {
            l();
        } else if (i2 == 121) {
            this.L = true;
            o();
        }
    }

    private void o() {
        Intent intent = new Intent(this, PDCPasscodePinActivity.class);
        intent.putExtra("ENTER_HEADER", "verifyPasscodeAndBlockPDC");
        intent.putExtra("cardAlias", this.f17393h.getVdcCardAlias());
        startActivityForResult(intent, 234);
    }

    private void p() {
        if (b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) this, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
            getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(a2);
        }
    }

    private void b(boolean z2) {
        try {
            if (this.x != null) {
                net.one97.paytm.common.widgets.a.b(this.x);
                if (z2) {
                    this.D.setVisibility(0);
                    net.one97.paytm.common.widgets.a.a(this.x);
                    return;
                }
                this.D.setVisibility(8);
                net.one97.paytm.common.widgets.a.b(this.x);
            }
        } catch (Exception unused) {
        }
    }

    private void a(Intent intent) {
        int intExtra = intent.getIntExtra("fromATMPinChangePage", 0);
        if (intExtra == 101) {
            net.one97.paytm.paymentsBank.pdc.a.b.a((d) this).show(getSupportFragmentManager(), "activationSuccessPopUp");
        } else if (intExtra == 102) {
            p.a((d) this).show(getSupportFragmentManager(), "resetATMSuccessPopUp");
        } else if (intExtra == 301) {
            this.r.performClick();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
        p();
    }

    private void q() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f d2 = net.one97.paytm.paymentsBank.b.a.d(this, this.f17393h.getVdcCardAlias(), this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (b.c((Context) this)) {
            b(true);
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(d2);
            return;
        }
        b(d2);
    }

    public void onDestroy() {
        ah_();
        super.onDestroy();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b(false);
        this.r.setEnabled(true);
        a(false, false, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Bundle bundle = new Bundle();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        IDCResponse iDCResponse = this.C;
        if (iDCResponse == null || iDCResponse.getPdcDetails() == null) {
            sb.append("NULL");
            sb2.append("NULL");
        } else {
            if (this.C.getPdcDetails().getStatus() != null) {
                sb.append(this.C.getPdcDetails().getStatus());
            } else {
                sb.append("NULL");
            }
            if (this.C.getPdcDetails().getCardStatus() != null) {
                sb2.append(this.C.getPdcDetails().getCardStatus());
            } else {
                sb2.append("NULL");
            }
            bundle.putString("ismarketPlace", this.C.getPdcDetails().isMarketPlace() ? "cart" : "bfs");
            bundle.putString("orderid", this.C.getPdcDetails().getOrderId());
        }
        sb.append("_");
        sb2.append("_");
        IDCResponse iDCResponse2 = this.C;
        if (iDCResponse2 == null || iDCResponse2.getIdcDetails() == null) {
            sb.append("NULL");
            sb2.append("NULL");
        } else {
            if (this.C.getIdcDetails().getStatus() != null) {
                sb.append(this.C.getIdcDetails().getStatus());
            } else {
                sb.append("NULL");
            }
            if (this.C.getIdcDetails().getCardStatus() != null) {
                sb2.append(this.C.getIdcDetails().getCardStatus());
            } else {
                sb2.append("NULL");
            }
        }
        bundle.putString("status", sb.toString());
        bundle.putString("cardstatus", sb2.toString());
        bundle.putString("category_cst", "PDC");
        o.a().openCstWithBundle(this, bundle);
    }
}
