package net.one97.paytm.p2mNewDesign.j;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.a.c;
import net.one97.paytm.p2mNewDesign.models.EMIPlanResponse;
import net.one97.paytm.p2mNewDesign.models.a;
import net.one97.paytm.utils.ShimmerFrameLayout;
import net.one97.paytm.wallet.R;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends f implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f13386a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f13387b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<a> f13388c;

    /* renamed from: d  reason: collision with root package name */
    private String f13389d;

    /* renamed from: e  reason: collision with root package name */
    private String f13390e;

    /* renamed from: f  reason: collision with root package name */
    private String f13391f;

    /* renamed from: g  reason: collision with root package name */
    private String f13392g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f13393h;

    /* renamed from: i  reason: collision with root package name */
    private String f13394i;
    private TextView j;
    private ShimmerFrameLayout k;
    private String l;
    private net.one97.paytm.p2mNewDesign.f.a m;
    private boolean n = false;

    public static c a() {
        return new c();
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, net.one97.paytm.p2mNewDesign.f.a aVar, boolean z, String str6) {
        this.f13386a = context;
        this.f13389d = str;
        this.f13390e = str2;
        this.f13388c = new ArrayList<>();
        this.f13394i = str3;
        this.f13392g = str4;
        this.l = str5;
        this.m = aVar;
        this.n = z;
        this.f13391f = str6;
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        dialog.setCanceledOnTouchOutside(false);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
        try {
            Field declaredField = aVar.getClass().getDeclaredField("behavior");
            declaredField.setAccessible(true);
            final BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) declaredField.get(aVar);
            bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.a() {
                public final void onSlide(View view, float f2) {
                }

                public final void onStateChanged(View view, int i2) {
                    if (i2 == 1) {
                        bottomSheetBehavior.setState(3);
                    }
                }
            });
        } catch (NoSuchFieldException e2) {
            q.d(String.valueOf(e2));
        } catch (IllegalAccessException e3) {
            q.d(String.valueOf(e3));
        } catch (Exception e4) {
            q.d(String.valueOf(e4));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.select_emi_plan_bottom_sheet, viewGroup, false);
        this.k = (ShimmerFrameLayout) inflate.findViewById(R.id.ll_shimmer);
        this.j = (TextView) inflate.findViewById(R.id.tv_bank_name);
        if (this.n) {
            this.f13394i += " Bank";
        }
        this.j.setText(this.f13394i);
        this.f13387b = (RecyclerView) inflate.findViewById(R.id.rv_emi_plans);
        this.f13387b.setLayoutManager(new LinearLayoutManager(this.f13386a, 1, false));
        this.f13387b.setVisibility(8);
        this.f13393h = (ImageView) inflate.findViewById(R.id.iv_cancel);
        this.f13393h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.dismiss();
            }
        });
        a(true);
        if (b.c(this.f13386a)) {
            String str = this.f13389d;
            String str2 = this.f13390e;
            String str3 = this.f13391f;
            String str4 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13386a, "offlinePGFetchEMIDetail") + "?mid=" + str;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            String str5 = b.v(this.f13386a) + System.currentTimeMillis();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
                jSONObject2.put(StringSet.token, com.paytm.utility.a.q(getContext()));
                jSONObject2.put("tokenType", b.a().toUpperCase());
                jSONObject2.put("version", net.one97.paytm.wallet.communicator.b.a().getVersionName());
                jSONObject2.put("channelId", "APP");
                jSONObject2.put("requestId", str5);
                jSONObject3.put("mid", str);
                jSONObject3.put("channelCode", str2);
                jSONObject3.put("emiType", str3);
                jSONObject.put("head", jSONObject2);
                jSONObject.put("body", jSONObject3);
            } catch (JSONException unused) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            new net.one97.paytm.network.b(str4, new EMIPlanResponse(), hashMap2, hashMap, jSONObject.toString()).c().observeForever(new z() {
                public final void onChanged(Object obj) {
                    c.this.a((net.one97.paytm.network.f) obj);
                }
            });
        } else {
            Context context = this.f13386a;
            Toast.makeText(context, context.getResources().getString(R.string.no_internet_message), 1).show();
            dismiss();
        }
        return inflate;
    }

    private void a(boolean z) {
        if (z) {
            this.k.a();
            this.k.setVisibility(0);
            return;
        }
        this.k.b();
        this.k.setVisibility(8);
    }

    private double a(String str, String str2) {
        new DecimalFormat(".00", new DecimalFormatSymbols(Locale.US));
        double a2 = a(this.l);
        double doubleValue = Double.valueOf(str).doubleValue() / 1200.0d;
        double doubleValue2 = Double.valueOf(str2).doubleValue();
        double d2 = a2 * doubleValue;
        double d3 = doubleValue + 1.0d;
        double pow = (d2 * Math.pow(d3, doubleValue2)) / (Math.pow(d3, doubleValue2) - 1.0d);
        return !Double.isNaN(pow) ? pow : a2 / doubleValue2;
    }

    private double a(EMIPlanResponse.EmiChannelInfo emiChannelInfo) {
        try {
            return a(emiChannelInfo.getInterestRate(), emiChannelInfo.getOfMonths()) * Double.valueOf(emiChannelInfo.getOfMonths()).doubleValue();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public final void a(a aVar) {
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(aVar);
        this.m.a(this.n);
        dismiss();
    }

    private static double a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if (fVar.f55797b instanceof EMIPlanResponse) {
                EMIPlanResponse eMIPlanResponse = (EMIPlanResponse) fVar.f55797b;
                if (eMIPlanResponse.getBody() == null) {
                    Context context = this.f13386a;
                    Toast.makeText(context, context.getResources().getString(R.string.emi_failure_msg), 1).show();
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((a) null);
                    this.m.a(this.n);
                    dismissAllowingStateLoss();
                } else if (eMIPlanResponse.getBody().getEmiDetail() == null) {
                    this.m.a(this.f13386a.getResources().getString(R.string.no_emi_option));
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((a) null);
                    this.m.a(this.n);
                    dismissAllowingStateLoss();
                } else if (eMIPlanResponse.getBody().getResultInfo() == null || !AppConstants.FEED_SUB_TYPE.equalsIgnoreCase(eMIPlanResponse.getBody().getResultInfo().getResultStatus())) {
                    this.f13388c.clear();
                    if (eMIPlanResponse != null && eMIPlanResponse.getBody() != null) {
                        EMIPlanResponse.EmiDetail emiDetail = eMIPlanResponse.getBody().getEmiDetail();
                        if (!(emiDetail == null || emiDetail.getEmiChannelInfos() == null || emiDetail.getEmiChannelInfos().size() <= 0)) {
                            for (EMIPlanResponse.EmiChannelInfo next : emiDetail.getEmiChannelInfos()) {
                                this.f13388c.add(new a(next.getPlanId(), next.getOfMonths(), Double.valueOf(a(next.getInterestRate(), next.getOfMonths())), next.getInterestRate(), Double.valueOf(a(next)), this.l));
                            }
                        }
                        a(false);
                        this.f13387b.setAdapter(new net.one97.paytm.p2mNewDesign.a.c(this.f13386a, this, this.f13388c, this.f13392g));
                        ArrayList<a> arrayList = this.f13388c;
                        String str = this.f13392g;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= arrayList.size()) {
                                i2 = -1;
                                break;
                            } else if (arrayList.get(i2).f56918a.equalsIgnoreCase(str)) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 != -1) {
                            this.f13387b.scrollToPosition(i2);
                        }
                        this.f13387b.setVisibility(0);
                    }
                } else {
                    String resultMsg = eMIPlanResponse.getBody().getResultInfo().getResultMsg();
                    Context context2 = this.f13386a;
                    if (TextUtils.isEmpty(resultMsg)) {
                        resultMsg = this.f13386a.getResources().getString(R.string.emi_failure_msg);
                    }
                    Toast.makeText(context2, resultMsg, 1).show();
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((a) null);
                    this.m.a(this.n);
                    dismissAllowingStateLoss();
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!this.m.a("emi_api_call", bundle, fVar.f55798c.f55801c)) {
                Context context3 = this.f13386a;
                Toast.makeText(context3, context3.getResources().getString(R.string.emi_failure_msg), 1).show();
            }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((a) null);
            this.m.a(this.n);
            dismissAllowingStateLoss();
        }
    }
}
