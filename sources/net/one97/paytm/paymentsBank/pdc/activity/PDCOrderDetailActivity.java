package net.one97.paytm.paymentsBank.pdc.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.q;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.PBBaseToolbarActivity;
import net.one97.paytm.paymentsBank.fragment.m;
import net.one97.paytm.paymentsBank.pdc.a;
import net.one97.paytm.paymentsBank.pdc.a.e;
import net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class PDCOrderDetailActivity extends PBBaseToolbarActivity implements d {

    /* renamed from: b  reason: collision with root package name */
    private boolean f18671b;

    /* renamed from: c  reason: collision with root package name */
    private String f18672c;

    /* renamed from: d  reason: collision with root package name */
    private d f18673d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18674f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f18675g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18676h;

    /* renamed from: i  reason: collision with root package name */
    private String f18677i;

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(int i2, Object obj) {
    }

    public final int e() {
        return R.layout.pdc_order_detail;
    }

    public final int f() {
        return R.layout.toolbar_pdc_status;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18675g = (TextView) findViewById(R.id.pdc_title);
        this.f18674f = (TextView) findViewById(R.id.pdc_arriving_by);
        c.a("/bank/savings-account/debit-card/status", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) this);
        this.f18671b = getIntent().getBooleanExtra("pdc_is_delivery_status_checking", true);
        CustProductList custProductList = (CustProductList) getIntent().getSerializableExtra("CUST_PRODUCT");
        this.f18676h = getIntent().getBooleanExtra("isMarketplaceorder", false);
        this.f18672c = getIntent().getStringExtra("order_id");
        if (getIntent().hasExtra("goToScreen")) {
            this.f18677i = getIntent().getStringExtra("goToScreen");
        }
        o.a().initBottomBar(findViewById(R.id.parent_layout_bottom), this, $$Lambda$PDCOrderDetailActivity$4rbonixhXlfAykNNy_MHHSZocbI.INSTANCE);
        this.f18673d = this;
        if (custProductList != null) {
            ((TextView) findViewById(R.id.tv_card_number)).setText(custProductList.getVdcMaskedCardNum().replace("-", "     "));
        }
        o.a().getNameFromKyc(this, new d() {
            public final void onFragmentAction(int i2, Object obj) {
                PDCOrderDetailActivity.this.a(i2, obj);
            }
        });
        String str = this.f18672c;
        g.a();
        if (b.s(net.one97.paytm.bankCommon.utils.d.a("pdcTrackOrder"))) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f a2 = a.a(this, str, this.f18676h, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            if (b.c((Context) this)) {
                a(this, getString(R.string.pb_please_wait));
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a2);
            } else {
                b(a2);
            }
        } else {
            finish();
        }
        c.a(this, "bank_saving_account", "atm_card_order_status_screen_loaded", "", "", "/bank/savings-account/debit-card/status", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        ((TextView) findViewById(R.id.tv_card_holder_name)).setText((String) obj);
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        PDCTrackOrderResponse pDCTrackOrderResponse;
        super.onResponse(iJRPaytmDataModel);
        ah_();
        if (!isFinishing() && (iJRPaytmDataModel instanceof PDCTrackOrderResponse) && (pDCTrackOrderResponse = (PDCTrackOrderResponse) iJRPaytmDataModel) != null) {
            ((TextView) findViewById(R.id.pdc_toolbar_heading)).setText(R.string.pb_pdc_your_atm_card);
            ((TextView) findViewById(R.id.pdc_toolbar_subheading)).setText(String.format(getResources().getString(R.string.pdc_order_no), new Object[]{this.f18672c}));
            if (this.f18671b) {
                findViewById(R.id.paytm_strip).setVisibility(8);
                findViewById(R.id.bottom_bar).setVisibility(8);
            }
            q a2 = getSupportFragmentManager().a();
            a2.b(R.id.fragment_container, net.one97.paytm.paymentsBank.pdc.a.f.a(), net.one97.paytm.paymentsBank.pdc.a.f.class.getName());
            a2.c();
            findViewById(R.id.fragment_layout).setVisibility(0);
            findViewById(R.id.pdc_paytm_trust_layout).setVisibility(8);
            if (pDCTrackOrderResponse.getResponseCode().intValue() == 200) {
                d dVar = this.f18673d;
                View findViewById = findViewById(R.id.pdc_status_layout);
                if (!(pDCTrackOrderResponse.getPayload() == null || pDCTrackOrderResponse.getPayload().getStatusFlow() == null || pDCTrackOrderResponse.getPayload().getStatusFlow().size() <= 0)) {
                    try {
                        if (!TextUtils.isEmpty(pDCTrackOrderResponse.getPayload().getExpectedDateOfDelivery())) {
                            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(pDCTrackOrderResponse.getPayload().getExpectedDateOfDelivery());
                            this.f18675g.setText(new SimpleDateFormat("EEE, d MMMM").format(parse));
                            this.f18674f.setVisibility(0);
                            this.f18675g.setVisibility(0);
                        } else {
                            this.f18674f.setVisibility(8);
                            this.f18675g.setVisibility(8);
                        }
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                    }
                    if (findViewById instanceof LinearLayout) {
                        if ("Y".equalsIgnoreCase(pDCTrackOrderResponse.getPayload().getReIssue())) {
                            List<PDCTrackOrderResponse.StatusFlow> statusFlow = pDCTrackOrderResponse.getPayload().getStatusFlow();
                            if (statusFlow.size() > 0) {
                                PDCTrackOrderResponse.StatusFlow statusFlow2 = statusFlow.get(statusFlow.size() - 1);
                                PDCTrackOrderResponse.Action action = new PDCTrackOrderResponse.Action();
                                action.setType("cancelpdcandreqagain");
                                action.setLabel(getString(R.string.pb_pdc_action_cancel_and_req));
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(action);
                                if (statusFlow2.getActions() != null) {
                                    statusFlow2.setActions(arrayList);
                                } else {
                                    statusFlow2.setStatusDetailTxt(getString(R.string.pb_pdc_status_text_order_cancelled));
                                    statusFlow2.setActions(arrayList);
                                }
                                if (!TextUtils.isEmpty(pDCTrackOrderResponse.getPayload().getCancellationReason())) {
                                    statusFlow2.setStatusDetailTxt(pDCTrackOrderResponse.getPayload().getCancellationReason());
                                } else {
                                    statusFlow2.setStatusDetailTxt(getString(R.string.pb_pdc_status_text_order_cancelled));
                                }
                            }
                        }
                        LinearLayout linearLayout = (LinearLayout) findViewById;
                        View a3 = new net.one97.paytm.paymentsBank.pdc.view.c(this, pDCTrackOrderResponse, dVar).a();
                        if (a3 != null) {
                            a3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                            linearLayout.setVisibility(0);
                            linearLayout.removeAllViews();
                            linearLayout.addView(a3);
                            String str = this.f18677i;
                            if (str != null && "retry_request_atm".equalsIgnoreCase(str)) {
                                onFragmentAction(107, (Object) null);
                            }
                        } else {
                            findViewById.setVisibility(8);
                        }
                    } else {
                        findViewById.setVisibility(8);
                    }
                }
                if (pDCTrackOrderResponse.getPayload() != null && pDCTrackOrderResponse.getPayload().getUserDetail() != null && pDCTrackOrderResponse.getPayload().getUserDetail().getUserAddress() != null) {
                    q a4 = getSupportFragmentManager().a();
                    PDCTrackOrderResponse.UserAddress userAddress = pDCTrackOrderResponse.getPayload().getUserDetail().getUserAddress();
                    e eVar = new e();
                    Bundle bundle = new Bundle();
                    bundle.putString("extra_address", userAddress.getAddress1() + " " + userAddress.getAddress2() + ", " + userAddress.getCity() + ", " + userAddress.getState() + "-" + userAddress.getPin());
                    bundle.putString("extra_mobile", userAddress.getMobile());
                    bundle.putString("extra_name", userAddress.getName());
                    eVar.setArguments(bundle);
                    a4.b(R.id.address_container, eVar, e.class.getName());
                    a4.c();
                    findViewById(R.id.address_layout).setVisibility(0);
                    return;
                }
                return;
            }
            b.b((Context) this, getString(R.string.error), pDCTrackOrderResponse.getResponseMessage());
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
    }

    public void onFragmentAction(int i2, Object obj) {
        if (i2 == 105) {
            setResult(-1);
            finish();
        } else if (i2 == 107) {
            m mVar = new m();
            mVar.f18528a = this;
            mVar.show(getSupportFragmentManager(), "bottomSheetDialogFragmentConfirm");
        }
    }
}
