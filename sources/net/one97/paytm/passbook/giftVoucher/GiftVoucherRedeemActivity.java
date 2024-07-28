package net.one97.paytm.passbook.giftVoucher;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.i;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.GiftVoucherDetailResponseData;
import net.one97.paytm.passbook.beans.GiftVoucherResponseData;
import net.one97.paytm.passbook.beans.SubwalletStatusResponseList;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.giftVoucher.a;
import net.one97.paytm.passbook.giftVoucher.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.q;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftVoucherRedeemActivity extends PaytmActivity implements a.C1082a, b.C1083b {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f57509a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f57510b;

    /* renamed from: c  reason: collision with root package name */
    private b f57511c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f57512d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f57513e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<SubwalletStatusResponseList> f57514f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private String f57515g;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_gift_voucher_redeem);
        this.f57515g = d.b().x();
        this.f57509a = (RecyclerView) findViewById(R.id.gvRecycleView);
        this.f57512d = (TextView) findViewById(R.id.noGvData);
        this.f57510b = (LottieAnimationView) findViewById(R.id.gift_voucher_loader);
        this.f57513e = (TextView) findViewById(R.id.gvHeadingText);
        this.f57513e.setText(String.format(getString(R.string.gv_redeem_header), new Object[]{this.f57515g}));
        this.f57511c = new b(this.f57514f, this);
        this.f57509a.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.f57509a.setItemAnimator(new g());
        this.f57509a.setAdapter(this.f57511c);
        i iVar = new i(this, 1);
        iVar.a(androidx.core.content.b.a((Context) this, R.drawable.pass_gv_divider));
        this.f57509a.addItemDecoration(iVar);
        e.a();
        String b2 = e.b();
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(this));
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ppiType", "GIFT_VOUCHER");
            jSONObject2.put("ppiStatus", "UNCLAIMED");
            jSONObject.put("request", jSONObject2);
            jSONObject.put("metadata", "Testing");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "SALES_TO_USER_CREDIT");
        } catch (JSONException unused) {
        }
        net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(b2, new i.a() {
            public final void onResponse(Object obj) {
                GiftVoucherRedeemActivity.this.a((IJRDataModel) obj);
            }
        }, new net.one97.paytm.passbook.mapping.a.g() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                GiftVoucherRedeemActivity.a(GiftVoucherRedeemActivity.this, networkCustomError);
            }
        }, new GiftVoucherResponseData(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, GiftVoucherRedeemActivity.class.getName());
        if (com.paytm.utility.b.c((Context) this)) {
            b();
            c.a(bVar);
        } else {
            a(bVar, this, new DialogInterface.OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    GiftVoucherRedeemActivity.this.a(dialogInterface);
                }
            });
        }
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GiftVoucherRedeemActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        q.a(this, "gift_voucher", "gv_redeem_back_clicked", (String) null, (String) null, "/passbook/gift-voucher-redeem", "gift_voucher");
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        c();
        if (!isFinishing()) {
            finish();
        }
    }

    private void b() {
        this.f57510b.setVisibility(0);
        net.one97.paytm.passbook.utility.a.a(this.f57510b);
    }

    private void c() {
        this.f57510b.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(this.f57510b);
    }

    private void a(net.one97.paytm.passbook.mapping.a.e eVar, Context context, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(context, eVar, onCancelListener) {
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f$2;
            private final /* synthetic */ DialogInterface.OnCancelListener f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                GiftVoucherRedeemActivity.this.a(this.f$1, this.f$2, this.f$3, dialogInterface, i2);
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, net.one97.paytm.passbook.mapping.a.e eVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        c();
        b();
        if (com.paytm.utility.b.c(context)) {
            context.getApplicationContext();
            c.a();
            c.b(eVar);
            return;
        }
        a(eVar, context, onCancelListener);
    }

    public final void a(SubwalletStatusResponseList subwalletStatusResponseList) {
        q.a(getApplicationContext(), "gift_voucher", "gv_redeembutton_clicked", (String) null, (String) null, "/passbook/gift-voucher-redeem", "gift_voucher");
        a aVar = new a();
        aVar.setCancelable(false);
        Bundle bundle = new Bundle();
        bundle.putSerializable("subwallet_data", subwalletStatusResponseList);
        aVar.setArguments(bundle);
        aVar.show(getSupportFragmentManager(), "Alert");
    }

    public final void a(String str) {
        for (int i2 = 0; i2 < this.f57514f.size(); i2++) {
            if (this.f57514f.get(i2).getTxnId().equalsIgnoreCase(str)) {
                ArrayList<SubwalletStatusResponseList> arrayList = this.f57514f;
                arrayList.remove(arrayList.get(i2));
                this.f57511c.notifyDataSetChanged();
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        b bVar;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && (bVar = this.f57511c) != null && bVar.getItemCount() == 0) {
            setResult(-1, new Intent());
            finish();
        }
    }

    public final void a() {
        b bVar = this.f57511c;
        if (bVar != null && bVar.getItemCount() == 0) {
            setResult(-1, new Intent());
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRDataModel iJRDataModel) {
        if (iJRDataModel instanceof GiftVoucherResponseData) {
            c();
            GiftVoucherResponseData giftVoucherResponseData = (GiftVoucherResponseData) iJRDataModel;
            if (!"SUCCESS".equalsIgnoreCase(giftVoucherResponseData.getStatusCode())) {
                String string = getString(R.string.failed_to_load_transaction_detail);
                if (!v.a(giftVoucherResponseData.getStatusMessage())) {
                    string = giftVoucherResponseData.getStatusMessage();
                }
                Toast.makeText(this, string, 0).show();
            } else if (giftVoucherResponseData.getResponse() == null || giftVoucherResponseData.getResponse().getSubwalletStatusResponseList() == null) {
                this.f57512d.setVisibility(0);
                this.f57512d.setText(String.format(getString(R.string.gv_no_data), new Object[]{this.f57515g}));
            } else {
                this.f57514f.addAll(giftVoucherResponseData.getResponse().getSubwalletStatusResponseList());
                this.f57511c.notifyDataSetChanged();
            }
        } else if (iJRDataModel instanceof GiftVoucherDetailResponseData) {
            GiftVoucherDetailResponseData giftVoucherDetailResponseData = (GiftVoucherDetailResponseData) iJRDataModel;
            if (!giftVoucherDetailResponseData.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                String string2 = getString(R.string.failed_to_load_transaction_detail);
                if (!v.a(giftVoucherDetailResponseData.getStatusMessage())) {
                    string2 = giftVoucherDetailResponseData.getStatusMessage();
                }
                Toast.makeText(this, string2, 0).show();
            } else if (giftVoucherDetailResponseData.getResponse() == null) {
                Toast.makeText(this, R.string.gv_no_detail_data, 0).show();
            }
        }
    }

    static /* synthetic */ void a(GiftVoucherRedeemActivity giftVoucherRedeemActivity, Throwable th) {
        if (!giftVoucherRedeemActivity.isFinishing()) {
            giftVoucherRedeemActivity.c();
            GiftVoucherRedeemActivity.class.getName();
            j.a((Activity) giftVoucherRedeemActivity, th);
        }
    }
}
