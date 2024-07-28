package net.one97.paytm.recharge.metro.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;
import net.one97.paytm.recharge.common.e.aa;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.x;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.y;
import net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.activity.AJRMetroStationListActivity;
import net.one97.paytm.recharge.metro.activity.AJRMetroTicketPurchaseActivity;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroPassengerDataModel;
import net.one97.paytm.recharge.model.metro.CJRMetroPriceModel;
import net.one97.paytm.recharge.model.metro.CJRMetroPriceResponse;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.metro.CJRMetroStationDataModel;
import net.one97.paytm.recharge.model.metro.CJRMetroStationListResponse;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.Events;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class i extends h implements DialogInterface.OnCancelListener, View.OnClickListener, x, AJRMetroTicketPurchaseActivity.a {
    private AppCompatImageView A;
    private AppCompatImageView B;
    /* access modifiers changed from: private */
    public CompoundButton C;
    private CJRRechargePayment D;
    private final int E = 183;
    private CJRMetroStationModel F;
    private String G = "";
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.metro.e.a H;
    /* access modifiers changed from: private */
    public int I = 1;
    private boolean J;
    /* access modifiers changed from: private */
    public final int K = 105;
    /* access modifiers changed from: private */
    public String L;
    private String M;
    /* access modifiers changed from: private */
    public String N = "";
    private HashMap O;

    /* renamed from: a  reason: collision with root package name */
    CJRUtilityVariantV2 f63366a;

    /* renamed from: b  reason: collision with root package name */
    CJRUtilityVariantV2 f63367b;

    /* renamed from: c  reason: collision with root package name */
    CJRItem f63368c;

    /* renamed from: d  reason: collision with root package name */
    CJRMetroQRFrequentOrder f63369d;

    /* renamed from: e  reason: collision with root package name */
    protected net.one97.paytm.recharge.common.f.c f63370e;

    /* renamed from: f  reason: collision with root package name */
    CJRRechargeCart f63371f;

    /* renamed from: g  reason: collision with root package name */
    protected View f63372g;

    /* renamed from: h  reason: collision with root package name */
    protected TextView f63373h;

    /* renamed from: i  reason: collision with root package name */
    protected TextView f63374i;
    protected TextView j;
    protected CheckBox k;
    CJRMetroStationListResponse l;
    protected ImageView m;
    CJRMetroStationModel n;
    CJRMetroStationModel o;
    net.one97.paytm.recharge.ordersummary.f.g p;
    protected RelativeLayout q;
    protected LottieAnimationView r;
    protected FrameLayout s;
    String t;
    private CheckBox u;
    /* access modifiers changed from: private */
    public CheckBox v;
    private TextView w;
    private TextView x;
    private TextView y;
    private RelativeLayout z;

    public View b(int i2) {
        if (this.O == null) {
            this.O = new HashMap();
        }
        View view = (View) this.O.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.O.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        s();
    }

    public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
        k.c(cJPayMethodResponse, "cjPayMethodResponse");
    }

    public void onVpaReceived(VpaFetch vpaFetch) {
        k.c(vpaFetch, "vpaFetch");
    }

    public void s() {
        HashMap hashMap = this.O;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final /* synthetic */ CheckBox a(i iVar) {
        CheckBox checkBox = iVar.u;
        if (checkBox == null) {
            k.a("sjtCheckbox");
        }
        return checkBox;
    }

    public static final /* synthetic */ RelativeLayout b(i iVar) {
        RelativeLayout relativeLayout = iVar.z;
        if (relativeLayout == null) {
            k.a("passengerCountContainer");
        }
        return relativeLayout;
    }

    public static final /* synthetic */ TextView d(i iVar) {
        TextView textView = iVar.y;
        if (textView == null) {
            k.a("sjtTitle");
        }
        return textView;
    }

    public static final /* synthetic */ TextView e(i iVar) {
        TextView textView = iVar.x;
        if (textView == null) {
            k.a("rjtTitle");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final net.one97.paytm.recharge.common.f.c a() {
        net.one97.paytm.recharge.common.f.c cVar = this.f63370e;
        if (cVar == null) {
            k.a("cartRequest");
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    public final void a(TextView textView) {
        k.c(textView, "<set-?>");
        this.f63373h = textView;
    }

    /* access modifiers changed from: protected */
    public final TextView b() {
        TextView textView = this.f63373h;
        if (textView == null) {
            k.a("proceedButton");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final TextView c() {
        TextView textView = this.f63374i;
        if (textView == null) {
            k.a("tvStationFrom");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final TextView d() {
        TextView textView = this.j;
        if (textView == null) {
            k.a("tvStationTo");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final void a(CheckBox checkBox) {
        k.c(checkBox, "<set-?>");
        this.k = checkBox;
    }

    /* access modifiers changed from: protected */
    public final CheckBox e() {
        CheckBox checkBox = this.k;
        if (checkBox == null) {
            k.a("cbFastForward");
        }
        return checkBox;
    }

    /* access modifiers changed from: protected */
    public final ImageView f() {
        ImageView imageView = this.m;
        if (imageView == null) {
            k.a("stationSwap");
        }
        return imageView;
    }

    /* access modifiers changed from: protected */
    public final void a(RelativeLayout relativeLayout) {
        k.c(relativeLayout, "<set-?>");
        this.q = relativeLayout;
    }

    /* access modifiers changed from: protected */
    public final void a(LottieAnimationView lottieAnimationView) {
        k.c(lottieAnimationView, "<set-?>");
        this.r = lottieAnimationView;
    }

    /* access modifiers changed from: protected */
    public final void a(FrameLayout frameLayout) {
        k.c(frameLayout, "<set-?>");
        this.s = frameLayout;
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.recharge.ordersummary.f.g) {
            this.p = (net.one97.paytm.recharge.ordersummary.f.g) context;
        }
        if (context instanceof AJRMetroTicketPurchaseActivity) {
            this.H = (net.one97.paytm.recharge.metro.e.a) context;
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            String str2 = null;
            Serializable serializable = arguments != null ? arguments.getSerializable("metroTicketVariant") : null;
            if (!(serializable instanceof CJRUtilityVariantV2)) {
                serializable = null;
            }
            this.f63366a = (CJRUtilityVariantV2) serializable;
            Bundle arguments2 = getArguments();
            Serializable serializable2 = arguments2 != null ? arguments2.getSerializable("productVariant") : null;
            if (!(serializable2 instanceof CJRUtilityVariantV2)) {
                serializable2 = null;
            }
            this.f63367b = (CJRUtilityVariantV2) serializable2;
            Bundle arguments3 = getArguments();
            Serializable serializable3 = arguments3 != null ? arguments3.getSerializable("metro_qr_frequent_object") : null;
            if (!(serializable3 instanceof CJRMetroQRFrequentOrder)) {
                serializable3 = null;
            }
            this.f63369d = (CJRMetroQRFrequentOrder) serializable3;
            Bundle arguments4 = getArguments();
            Serializable serializable4 = arguments4 != null ? arguments4.getSerializable("extra_home_data") : null;
            if (!(serializable4 instanceof CJRItem)) {
                serializable4 = null;
            }
            this.f63368c = (CJRItem) serializable4;
            Bundle arguments5 = getArguments();
            Object obj = arguments5 != null ? arguments5.get("source") : null;
            if (obj != null) {
                this.G = (String) obj;
                Bundle arguments6 = getArguments();
                this.t = arguments6 != null ? arguments6.getString("product-type") : null;
                Bundle arguments7 = getArguments();
                if (arguments7 == null || (str = arguments7.getString("vertical_name")) == null) {
                    str = "";
                }
                this.N = str;
                o();
                try {
                    StringBuilder sb = new StringBuilder("/");
                    c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                    CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63366a;
                    sb.append(c.a.a(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null));
                    sb.append("_qr_ticket");
                    this.M = sb.toString();
                    if (this instanceof k) {
                        StringBuilder sb2 = new StringBuilder("/");
                        c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                        CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63366a;
                        if (cJRUtilityVariantV22 != null) {
                            str2 = cJRUtilityVariantV22.getFilterName();
                        }
                        sb2.append(c.a.a(str2));
                        sb2.append("_store_value_pass");
                        this.M = sb2.toString();
                    } else if (this instanceof m) {
                        StringBuilder sb3 = new StringBuilder("/");
                        c.a aVar3 = net.one97.paytm.recharge.metro.f.c.f63576a;
                        CJRUtilityVariantV2 cJRUtilityVariantV23 = this.f63366a;
                        if (cJRUtilityVariantV23 != null) {
                            str2 = cJRUtilityVariantV23.getFilterName();
                        }
                        sb3.append(c.a.a(str2));
                        sb3.append("_trip_pass");
                        this.M = sb3.toString();
                    }
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    Context context = getContext();
                    String str3 = this.M;
                    if (str3 == null) {
                        str3 = "";
                    }
                    net.one97.paytm.recharge.di.helper.b.a(context, str3);
                } catch (Throwable unused) {
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            throw new Exception("Arguments expected");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_metro_ticket_purchase_new, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.progress_bar);
        k.a((Object) findViewById, "view.findViewById(R.id.progress_bar)");
        this.f63372g = findViewById;
        View findViewById2 = view.findViewById(R.id.proceed_btn);
        if (findViewById2 != null) {
            this.f63373h = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.station_from);
            if (findViewById3 != null) {
                this.f63374i = (TextView) findViewById3;
                View findViewById4 = view.findViewById(R.id.station_to);
                if (findViewById4 != null) {
                    this.j = (TextView) findViewById4;
                    View findViewById5 = view.findViewById(R.id.radio_fast_forward);
                    if (findViewById5 != null) {
                        this.k = (CheckBox) findViewById5;
                        View findViewById6 = view.findViewById(R.id.loading_threedots_view);
                        if (findViewById6 != null) {
                            this.q = (RelativeLayout) findViewById6;
                            View findViewById7 = view.findViewById(R.id.loading_threedots_lav);
                            if (findViewById7 != null) {
                                this.r = (LottieAnimationView) findViewById7;
                                View findViewById8 = view.findViewById(R.id.transparent_view);
                                if (findViewById8 != null) {
                                    this.s = (FrameLayout) findViewById8;
                                    View findViewById9 = view.findViewById(R.id.station_swap);
                                    if (findViewById9 != null) {
                                        this.m = (ImageView) findViewById9;
                                        View findViewById10 = view.findViewById(R.id.sjt_title);
                                        if (findViewById10 != null) {
                                            this.y = (TextView) findViewById10;
                                            View findViewById11 = view.findViewById(R.id.rjt_title);
                                            if (findViewById11 != null) {
                                                this.x = (TextView) findViewById11;
                                                CheckBox checkBox = (CheckBox) view.findViewById(R.id.sjt_checked);
                                                if (checkBox != null) {
                                                    this.u = checkBox;
                                                    CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.rjt_checked);
                                                    if (checkBox2 != null) {
                                                        this.v = checkBox2;
                                                        TextView textView = this.f63373h;
                                                        if (textView == null) {
                                                            k.a("proceedButton");
                                                        }
                                                        textView.setEnabled(false);
                                                        g();
                                                        CheckBox checkBox3 = this.k;
                                                        if (checkBox3 == null) {
                                                            k.a("cbFastForward");
                                                        }
                                                        checkBox3.setOnCheckedChangeListener(new e(this));
                                                        return;
                                                    }
                                                    throw new u("null cannot be cast to non-null type android.widget.CheckBox");
                                                }
                                                throw new u("null cannot be cast to non-null type android.widget.CheckBox");
                                            }
                                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                                        }
                                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                                    }
                                    throw new u("null cannot be cast to non-null type android.widget.ImageView");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
                            }
                            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.CheckBox");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    static final class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f63379a;

        e(i iVar) {
            this.f63379a = iVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            String str;
            String str2 = z ? "fast_forward_checked" : "fast_forward_unchecked";
            i iVar = this.f63379a;
            if (iVar instanceof k) {
                str = "store_value_pass";
            } else {
                str = iVar instanceof m ? "trip_pass" : "metro_qr_ticket";
            }
            String str3 = str;
            Context context = this.f63379a.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63379a.f63366a;
            String a2 = c.a.a(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
            String str4 = ab.f61496a;
            k.a((Object) str4, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, a2, str2, "", str3, str4, (Object) null, (Object) null, 96);
        }
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.CharSequence] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r3, int r4, android.content.Intent r5) {
        /*
            r2 = this;
            int r0 = r2.E
            r1 = 0
            if (r3 != r0) goto L_0x00ab
            r3 = -1
            if (r4 != r3) goto L_0x008b
            if (r5 == 0) goto L_0x0011
            java.lang.String r3 = "metro_qr_frequent_object"
            java.io.Serializable r3 = r5.getSerializableExtra(r3)
            goto L_0x0012
        L_0x0011:
            r3 = r1
        L_0x0012:
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r3 = (net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r3
            r2.f63369d = r3
            android.view.View r3 = r2.f63372g
            if (r3 != 0) goto L_0x001f
            java.lang.String r4 = "progressBar"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x001f:
            r4 = 8
            r3.setVisibility(r4)
            android.view.View r3 = r2.getView()
            if (r3 == 0) goto L_0x0038
            int r4 = net.one97.paytm.recharge.R.id.scroll_view
            android.view.View r3 = r3.findViewById(r4)
            android.widget.ScrollView r3 = (android.widget.ScrollView) r3
            if (r3 == 0) goto L_0x0038
            r4 = 0
            r3.setVisibility(r4)
        L_0x0038:
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r3 = r2.f63369d
            if (r3 == 0) goto L_0x0040
            r2.a((net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r3)
            return
        L_0x0040:
            if (r5 == 0) goto L_0x004a
            java.lang.String r3 = "sourceMetroStation"
            java.io.Serializable r3 = r5.getSerializableExtra(r3)
            goto L_0x004b
        L_0x004a:
            r3 = r1
        L_0x004b:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r3 = (net.one97.paytm.recharge.model.metro.CJRMetroStationModel) r3
            r2.n = r3
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r3 = r2.n
            if (r3 == 0) goto L_0x008a
            r2.i()
            if (r5 == 0) goto L_0x005f
            java.lang.String r3 = "destinationMetroStation"
            java.io.Serializable r3 = r5.getSerializableExtra(r3)
            goto L_0x0060
        L_0x005f:
            r3 = r1
        L_0x0060:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r3 = (net.one97.paytm.recharge.model.metro.CJRMetroStationModel) r3
            r2.o = r3
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r3 = r2.o
            if (r3 == 0) goto L_0x008a
            r2.j()
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r3 = r2.n
            if (r3 == 0) goto L_0x0074
            java.lang.String r3 = r3.getId()
            goto L_0x0075
        L_0x0074:
            r3 = r1
        L_0x0075:
            if (r3 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r4 = r2.o
            if (r4 == 0) goto L_0x0082
            java.lang.String r1 = r4.getId()
        L_0x0082:
            if (r1 != 0) goto L_0x0087
            kotlin.g.b.k.a()
        L_0x0087:
            r2.a((java.lang.String) r3, (java.lang.String) r1)
        L_0x008a:
            return
        L_0x008b:
            android.widget.TextView r3 = r2.f63374i
            if (r3 != 0) goto L_0x0095
            java.lang.String r4 = "tvStationFrom"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0095:
            if (r3 == 0) goto L_0x009b
            java.lang.CharSequence r1 = r3.getText()
        L_0x009b:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x00aa
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x00aa
            r3.onBackPressed()
        L_0x00aa:
            return
        L_0x00ab:
            r5 = 800(0x320, float:1.121E-42)
            if (r3 != r5) goto L_0x00c3
            boolean r3 = r2.t()
            if (r3 == 0) goto L_0x0112
            int r3 = net.one97.paytm.recharge.R.id.proceed_btn
            android.view.View r3 = r2.b((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x00c2
            r3.performClick()
        L_0x00c2:
            return
        L_0x00c3:
            r5 = 103(0x67, float:1.44E-43)
            if (r3 != r5) goto L_0x00dc
            if (r4 == 0) goto L_0x00cd
            r2.o()
            return
        L_0x00cd:
            net.one97.paytm.recharge.common.utils.ay r3 = net.one97.paytm.recharge.common.utils.ay.f61523a
            net.one97.paytm.recharge.common.utils.ay.a((int) r5)
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x00db
            r3.finish()
        L_0x00db:
            return
        L_0x00dc:
            int r5 = r2.K
            if (r3 != r5) goto L_0x0112
            if (r4 == 0) goto L_0x0102
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r3 = r2.n
            if (r3 == 0) goto L_0x00eb
            java.lang.String r3 = r3.getId()
            goto L_0x00ec
        L_0x00eb:
            r3 = r1
        L_0x00ec:
            if (r3 != 0) goto L_0x00f1
            kotlin.g.b.k.a()
        L_0x00f1:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r4 = r2.o
            if (r4 == 0) goto L_0x00f9
            java.lang.String r1 = r4.getId()
        L_0x00f9:
            if (r1 != 0) goto L_0x00fe
            kotlin.g.b.k.a()
        L_0x00fe:
            r2.a((java.lang.String) r3, (java.lang.String) r1)
            return
        L_0x0102:
            net.one97.paytm.recharge.common.utils.ay r3 = net.one97.paytm.recharge.common.utils.ay.f61523a
            int r3 = r2.K
            net.one97.paytm.recharge.common.utils.ay.a((int) r3)
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x0112
            r3.finish()
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.i.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [android.view.View] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r4 = this;
            android.view.View r0 = r4.getView()
            r1 = 0
            if (r0 == 0) goto L_0x0010
            int r2 = net.one97.paytm.recharge.R.id.passenger_count
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x0067
            r4.w = r0
            android.view.View r0 = r4.getView()
            if (r0 == 0) goto L_0x0024
            int r2 = net.one97.paytm.recharge.R.id.increase_passenger_count
            android.view.View r0 = r0.findViewById(r2)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            java.lang.String r2 = "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView"
            if (r0 == 0) goto L_0x0061
            r4.A = r0
            android.view.View r0 = r4.getView()
            if (r0 == 0) goto L_0x003a
            int r3 = net.one97.paytm.recharge.R.id.decrease_passenger_count
            android.view.View r0 = r0.findViewById(r3)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            if (r0 == 0) goto L_0x005b
            r4.B = r0
            android.view.View r0 = r4.getView()
            if (r0 == 0) goto L_0x004e
            int r1 = net.one97.paytm.recharge.R.id.container_passenger_count
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
        L_0x004e:
            if (r1 == 0) goto L_0x0053
            r4.z = r1
            return
        L_0x0053:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.RelativeLayout"
            r0.<init>(r1)
            throw r0
        L_0x005b:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r2)
            throw r0
        L_0x0061:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r2)
            throw r0
        L_0x0067:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.i.g():void");
    }

    public final class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (k.a((Object) compoundButton, (Object) i.a(i.this))) {
                if (z) {
                    i.b(i.this).setLayoutParams(i.q());
                    CheckBox c2 = i.this.v;
                    if (c2 != null && c2.isChecked()) {
                        i.d(i.this).setTypeface((Typeface) null, 1);
                        i.e(i.this).setTypeface((Typeface) null, 0);
                        CheckBox c3 = i.this.v;
                        if (c3 != null) {
                            c3.toggle();
                        }
                    }
                }
                i.this.b("single_journey_selected");
            } else if (k.a((Object) compoundButton, (Object) i.this.v)) {
                if (z) {
                    i.b(i.this).setLayoutParams(i.r());
                    if (i.a(i.this).isChecked()) {
                        i.d(i.this).setTypeface((Typeface) null, 0);
                        i.e(i.this).setTypeface((Typeface) null, 1);
                        i.a(i.this).toggle();
                    }
                }
                i.this.b("return_journey_selected");
            }
            CompoundButton f2 = i.this.C;
            if (f2 != null) {
                f2.setChecked(false);
            }
            CompoundButton f3 = i.this.C;
            if (f3 != null) {
                f3.setEnabled(true);
            }
            i.this.C = compoundButton;
            CompoundButton f4 = i.this.C;
            if (f4 != null) {
                f4.setEnabled(false);
            }
            if (k.a((Object) compoundButton, (Object) i.a(i.this))) {
                i iVar = i.this;
                iVar.b(iVar.I, false);
            } else if (k.a((Object) compoundButton, (Object) i.this.v)) {
                i iVar2 = i.this;
                iVar2.b(iVar2.I, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        TextView textView = this.f63374i;
        if (textView == null) {
            k.a("tvStationFrom");
        }
        View.OnClickListener onClickListener = this;
        textView.setOnClickListener(onClickListener);
        TextView textView2 = this.j;
        if (textView2 == null) {
            k.a("tvStationTo");
        }
        textView2.setOnClickListener(onClickListener);
        ImageView imageView = this.m;
        if (imageView == null) {
            k.a("stationSwap");
        }
        imageView.setOnClickListener(onClickListener);
        AppCompatImageView appCompatImageView = this.A;
        if (appCompatImageView == null) {
            k.a("buttonCountIncrease");
        }
        appCompatImageView.setOnClickListener(onClickListener);
        AppCompatImageView appCompatImageView2 = this.B;
        if (appCompatImageView2 == null) {
            k.a("buttonCountDecrease");
        }
        appCompatImageView2.setOnClickListener(onClickListener);
        View view = getView();
        if (!(view == null || (relativeLayout2 = (RelativeLayout) view.findViewById(R.id.container_sjt)) == null)) {
            relativeLayout2.setOnClickListener(onClickListener);
        }
        View view2 = getView();
        if (!(view2 == null || (relativeLayout = (RelativeLayout) view2.findViewById(R.id.container_rjt)) == null)) {
            relativeLayout.setOnClickListener(onClickListener);
        }
        TextView textView3 = this.f63373h;
        if (textView3 == null) {
            k.a("proceedButton");
        }
        textView3.setOnClickListener(onClickListener);
        if (this.f63369d == null) {
            TextView textView4 = this.f63374i;
            if (textView4 == null) {
                k.a("tvStationFrom");
            }
            textView4.performClick();
        }
    }

    public final void i() {
        TextView textView = this.j;
        if (textView == null) {
            k.a("tvStationTo");
        }
        if (!textView.isEnabled()) {
            TextView textView2 = this.j;
            if (textView2 == null) {
                k.a("tvStationTo");
            }
            textView2.setEnabled(true);
        }
        TextView textView3 = this.f63374i;
        if (textView3 == null) {
            k.a("tvStationFrom");
        }
        CJRMetroStationModel cJRMetroStationModel = this.n;
        textView3.setText(cJRMetroStationModel != null ? cJRMetroStationModel.getName() : null);
    }

    public final void j() {
        TextView textView = this.j;
        if (textView == null) {
            k.a("tvStationTo");
        }
        CJRMetroStationModel cJRMetroStationModel = this.o;
        textView.setText(cJRMetroStationModel != null ? cJRMetroStationModel.getName() : null);
        TextView textView2 = this.f63373h;
        if (textView2 == null) {
            k.a("proceedButton");
        }
        textView2.setEnabled(true);
    }

    private void a(int i2, boolean z2) {
        CJRMetroPassengerDataModel passengers;
        TextView textView = this.w;
        if (textView == null) {
            k.a("passengerCount");
        }
        textView.setText(String.valueOf(i2));
        if (i2 > 1) {
            AppCompatImageView appCompatImageView = this.B;
            if (appCompatImageView == null) {
                k.a("buttonCountDecrease");
            }
            appCompatImageView.setImageResource(R.drawable.ic_sub_enabled);
            AppCompatImageView appCompatImageView2 = this.B;
            if (appCompatImageView2 == null) {
                k.a("buttonCountDecrease");
            }
            appCompatImageView2.setEnabled(true);
            CJRMetroStationListResponse cJRMetroStationListResponse = this.l;
            if (cJRMetroStationListResponse == null || (passengers = cJRMetroStationListResponse.getPassengers()) == null || i2 != passengers.getMaxPassengers()) {
                AppCompatImageView appCompatImageView3 = this.A;
                if (appCompatImageView3 == null) {
                    k.a("buttonCountIncrease");
                }
                appCompatImageView3.setEnabled(true);
                AppCompatImageView appCompatImageView4 = this.A;
                if (appCompatImageView4 == null) {
                    k.a("buttonCountIncrease");
                }
                appCompatImageView4.setImageResource(R.drawable.ic_add_enabled);
                return;
            }
            AppCompatImageView appCompatImageView5 = this.A;
            if (appCompatImageView5 == null) {
                k.a("buttonCountIncrease");
            }
            appCompatImageView5.setEnabled(false);
            AppCompatImageView appCompatImageView6 = this.A;
            if (appCompatImageView6 == null) {
                k.a("buttonCountIncrease");
            }
            appCompatImageView6.setImageResource(R.drawable.ic_add_disabled);
            if (z2) {
                Toast.makeText(getContext(), getString(R.string.max_passenger_limit_holder, Integer.valueOf(i2)), 0).show();
                return;
            }
            return;
        }
        AppCompatImageView appCompatImageView7 = this.A;
        if (appCompatImageView7 == null) {
            k.a("buttonCountIncrease");
        }
        appCompatImageView7.setEnabled(true);
        AppCompatImageView appCompatImageView8 = this.B;
        if (appCompatImageView8 == null) {
            k.a("buttonCountDecrease");
        }
        appCompatImageView8.setEnabled(false);
        AppCompatImageView appCompatImageView9 = this.B;
        if (appCompatImageView9 == null) {
            k.a("buttonCountDecrease");
        }
        appCompatImageView9.setImageResource(R.drawable.ic_sub_disable);
    }

    /* access modifiers changed from: protected */
    public void a(CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder) {
        this.f63369d = cJRMetroQRFrequentOrder;
        CJRMetroStationModel cJRMetroStationModel = null;
        this.n = cJRMetroQRFrequentOrder != null ? cJRMetroQRFrequentOrder.getSource() : null;
        if (cJRMetroQRFrequentOrder != null) {
            cJRMetroStationModel = cJRMetroQRFrequentOrder.getDestination();
        }
        this.o = cJRMetroStationModel;
        if (this.n != null && this.o != null) {
            i();
            j();
            CJRMetroStationModel cJRMetroStationModel2 = this.n;
            if (cJRMetroStationModel2 == null) {
                k.a();
            }
            String id = cJRMetroStationModel2.getId();
            k.a((Object) id, "mSourceStation!!.id");
            CJRMetroStationModel cJRMetroStationModel3 = this.o;
            if (cJRMetroStationModel3 == null) {
                k.a();
            }
            String id2 = cJRMetroStationModel3.getId();
            k.a((Object) id2, "mDestinationStation!!.id");
            a(id, id2);
        }
    }

    public final void a(CJRMetroPriceModel cJRMetroPriceModel) {
        String str;
        View view = getView();
        Integer num = null;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.validity_message) : null;
        if (textView != null) {
            if (cJRMetroPriceModel == null || TextUtils.isEmpty(cJRMetroPriceModel.getExpiryTime())) {
                str = "";
            } else {
                c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                String expiryTime = cJRMetroPriceModel.getExpiryTime();
                k.a((Object) expiryTime, "response.expiryTime");
                str = c.a.e(expiryTime);
                if (TextUtils.isEmpty(str)) {
                    str = cJRMetroPriceModel.getExpiryTime();
                    k.a((Object) str, "response.expiryTime");
                }
            }
            String a2 = a(str);
            if (a2 != null) {
                num = Integer.valueOf(p.a((CharSequence) a2, "Terms", 0, false, 6));
            }
            int intValue = num.intValue();
            if (intValue >= 0) {
                SpannableString spannableString = new SpannableString(a2);
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.metro_ticket_purchase_tnc_text)), intValue, a2.length(), 33);
                spannableString.setSpan(new d(this), intValue, a2.length(), 33);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setText(spannableString);
                textView.setVisibility(0);
                return;
            }
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            String string = context2.getString(R.string.v8_os_info_note);
            k.a((Object) string, "context!!.getString(R.string.v8_os_info_note)");
            String string2 = getString(R.string.trip_pass_disclaimer);
            k.a((Object) string2, "getString(R.string.trip_pass_disclaimer)");
            SpannableString spannableString2 = new SpannableString(string2);
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            spannableString2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context3, R.color.note_text_color)), 0, string.length(), 33);
            spannableString2.setSpan(new StyleSpan(1), 0, string.length(), 33);
            textView.setText(spannableString2);
            textView.setVisibility(0);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public static final class d extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f63378a;

        d(i iVar) {
            this.f63378a = iVar;
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
            r6 = (r6 = r6.getProduct()).getAttributes();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                java.lang.String r0 = "widget"
                kotlin.g.b.k.c(r6, r0)
                net.one97.paytm.recharge.metro.c.i r0 = r5.f63378a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.content.Context r0 = (android.content.Context) r0
                boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
                if (r0 != 0) goto L_0x0036
                net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a
                net.one97.paytm.recharge.metro.c.i r6 = r5.f63378a
                androidx.fragment.app.FragmentActivity r6 = r6.getActivity()
                android.content.Context r6 = (android.content.Context) r6
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.METRO_TICKET
                net.one97.paytm.recharge.metro.c.i r2 = r5.f63378a
                int r3 = net.one97.paytm.recharge.R.string.no_connection
                java.lang.String r2 = r2.getString(r3)
                net.one97.paytm.recharge.metro.c.i r3 = r5.f63378a
                int r4 = net.one97.paytm.recharge.R.string.no_internet
                java.lang.String r3 = r3.getString(r4)
                net.one97.paytm.recharge.common.utils.az.a(r6, r0, r1, r2, r3)
                return
            L_0x0036:
                net.one97.paytm.recharge.metro.c.i r0 = r5.f63378a
                android.content.Intent r1 = new android.content.Intent
                android.content.Context r6 = r6.getContext()
                java.lang.Class<net.one97.paytm.recharge.metro.activity.AJRMetroTicketTnCActivity> r2 = net.one97.paytm.recharge.metro.activity.AJRMetroTicketTnCActivity.class
                r1.<init>(r6, r2)
                net.one97.paytm.recharge.metro.c.i r6 = r5.f63378a
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r6 = r6.f63367b
                if (r6 == 0) goto L_0x005a
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r6 = r6.getProduct()
                if (r6 == 0) goto L_0x005a
                net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r6 = r6.getAttributes()
                if (r6 == 0) goto L_0x005a
                java.lang.String r6 = r6.getProductRequestType()
                goto L_0x005b
            L_0x005a:
                r6 = 0
            L_0x005b:
                java.lang.String r2 = "metro_filter"
                r1.putExtra(r2, r6)
                net.one97.paytm.recharge.metro.c.i r6 = r5.f63378a
                java.lang.String r6 = r6.t
                java.lang.String r2 = "product_type"
                r1.putExtra(r2, r6)
                r0.startActivity(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.i.d.onClick(android.view.View):void");
        }
    }

    public String a(String str) {
        k.c(str, "formatedDate");
        int i2 = R.string.metro_ticket_purchase_ticket_validity_message;
        Object[] objArr = new Object[1];
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.metro_ticket_purchase_default_validity);
            k.a((Object) str, "getString(R.string.metro…urchase_default_validity)");
        }
        objArr[0] = str;
        String string = getString(i2, objArr);
        k.a((Object) string, "getString(R.string.metro…rchase_default_validity))");
        return string;
    }

    /* JADX WARNING: type inference failed for: r3v9, types: [android.view.View] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.one97.paytm.recharge.model.metro.CJRMetroPriceResponse r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.String r1 = "response"
            r2 = r18
            kotlin.g.b.k.c(r2, r1)
            android.view.View r1 = r17.getView()
            r3 = 8
            r4 = 0
            if (r1 == 0) goto L_0x0041
            int r5 = net.one97.paytm.recharge.R.id.price_card_container
            android.view.View r1 = r1.findViewById(r5)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x0041
            int r1 = r1.getVisibility()
            if (r1 != r3) goto L_0x0041
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x0035
            int r5 = net.one97.paytm.recharge.R.id.price_card_container
            android.view.View r1 = r1.findViewById(r5)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x0035
            r1.setVisibility(r4)
        L_0x0035:
            android.widget.TextView r1 = r0.f63373h
            if (r1 != 0) goto L_0x003e
            java.lang.String r5 = "proceedButton"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x003e:
            r1.setVisibility(r4)
        L_0x0041:
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r1 = r18.getRjtFare()
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x00bc
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x0058
            int r7 = net.one97.paytm.recharge.R.id.rjt_title
            android.view.View r1 = r1.findViewById(r7)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0059
        L_0x0058:
            r1 = r6
        L_0x0059:
            boolean r7 = r1 instanceof android.widget.TextView
            if (r7 != 0) goto L_0x005e
            r1 = r6
        L_0x005e:
            if (r1 == 0) goto L_0x0071
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r7 = r18.getRjtFare()
            if (r7 == 0) goto L_0x006b
            java.lang.String r7 = r7.getLabel()
            goto L_0x006c
        L_0x006b:
            r7 = r6
        L_0x006c:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
        L_0x0071:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x0080
            int r7 = net.one97.paytm.recharge.R.id.rjt_price
            android.view.View r1 = r1.findViewById(r7)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0081
        L_0x0080:
            r1 = r6
        L_0x0081:
            boolean r7 = r1 instanceof android.widget.TextView
            if (r7 != 0) goto L_0x0086
            r1 = r6
        L_0x0086:
            if (r1 == 0) goto L_0x00af
            int r7 = net.one97.paytm.recharge.R.string.price_container_re
            java.lang.Object[] r8 = new java.lang.Object[r5]
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r9 = r18.getRjtFare()
            if (r9 == 0) goto L_0x009b
            double r9 = r9.getFare()
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            goto L_0x009c
        L_0x009b:
            r9 = r6
        L_0x009c:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r9 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r9, (boolean) r5)
            r8[r4] = r9
            java.lang.String r7 = r0.getString(r7, r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
        L_0x00af:
            android.widget.CheckBox r1 = r0.v
            if (r1 == 0) goto L_0x014d
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r7 = r18.getRjtFare()
            r1.setTag(r7)
            goto L_0x014d
        L_0x00bc:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x00cd
            int r7 = net.one97.paytm.recharge.R.id.separator
            android.view.View r1 = r1.findViewById(r7)
            if (r1 == 0) goto L_0x00cd
            net.one97.paytm.recharge.common.utils.ai.b(r1)
        L_0x00cd:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x00de
            int r7 = net.one97.paytm.recharge.R.id.sjt_title
            android.view.View r1 = r1.findViewById(r7)
            if (r1 == 0) goto L_0x00de
            net.one97.paytm.recharge.common.utils.ai.b(r1)
        L_0x00de:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x00ef
            int r7 = net.one97.paytm.recharge.R.id.sjt_checked
            android.view.View r1 = r1.findViewById(r7)
            if (r1 == 0) goto L_0x00ef
            net.one97.paytm.recharge.common.utils.ai.b(r1)
        L_0x00ef:
            android.view.View r1 = r17.getView()
            r7 = 1098907648(0x41800000, float:16.0)
            r8 = 2
            if (r1 == 0) goto L_0x0105
            int r9 = net.one97.paytm.recharge.R.id.textView41
            android.view.View r1 = r1.findViewById(r9)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0105
            r1.setTextSize(r8, r7)
        L_0x0105:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x0118
            int r9 = net.one97.paytm.recharge.R.id.sjt_price
            android.view.View r1 = r1.findViewById(r9)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0118
            r1.setTextSize(r8, r7)
        L_0x0118:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x012b
            int r7 = net.one97.paytm.recharge.R.id.textView41
            android.view.View r1 = r1.findViewById(r7)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x012b
            r1.setTypeface(r6, r5)
        L_0x012b:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x013e
            int r7 = net.one97.paytm.recharge.R.id.sjt_price
            android.view.View r1 = r1.findViewById(r7)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x013e
            r1.setTypeface(r6, r5)
        L_0x013e:
            int r1 = net.one97.paytm.recharge.R.id.container_rjt
            android.view.View r1 = r0.b((int) r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x014d
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.b(r1)
        L_0x014d:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x015c
            int r7 = net.one97.paytm.recharge.R.id.sjt_title
            android.view.View r1 = r1.findViewById(r7)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x015d
        L_0x015c:
            r1 = r6
        L_0x015d:
            boolean r7 = r1 instanceof android.widget.TextView
            if (r7 != 0) goto L_0x0162
            r1 = r6
        L_0x0162:
            java.lang.String r7 = "response.sjtFare"
            if (r1 == 0) goto L_0x0176
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r8 = r18.getSjtFare()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            java.lang.String r8 = r8.getLabel()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r1.setText(r8)
        L_0x0176:
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x0185
            int r8 = net.one97.paytm.recharge.R.id.sjt_price
            android.view.View r1 = r1.findViewById(r8)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0186
        L_0x0185:
            r1 = r6
        L_0x0186:
            boolean r8 = r1 instanceof android.widget.TextView
            if (r8 != 0) goto L_0x018b
            r1 = r6
        L_0x018b:
            if (r1 == 0) goto L_0x01af
            int r8 = net.one97.paytm.recharge.R.string.price_container_re
            java.lang.Object[] r9 = new java.lang.Object[r5]
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r10 = r18.getSjtFare()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r7)
            double r10 = r10.getFare()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r10 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r10, (boolean) r5)
            r9[r4] = r10
            java.lang.String r8 = r0.getString(r8, r9)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r1.setText(r8)
        L_0x01af:
            android.widget.CheckBox r1 = r0.u
            java.lang.String r8 = "sjtCheckbox"
            if (r1 != 0) goto L_0x01b9
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x01b9:
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r9 = r18.getSjtFare()
            r1.setTag(r9)
            android.widget.CheckBox r1 = r0.v
            if (r1 == 0) goto L_0x01ce
            net.one97.paytm.recharge.metro.c.i$a r9 = new net.one97.paytm.recharge.metro.c.i$a
            r9.<init>()
            android.widget.CompoundButton$OnCheckedChangeListener r9 = (android.widget.CompoundButton.OnCheckedChangeListener) r9
            r1.setOnCheckedChangeListener(r9)
        L_0x01ce:
            android.widget.CheckBox r1 = r0.u
            if (r1 != 0) goto L_0x01d5
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x01d5:
            net.one97.paytm.recharge.metro.c.i$a r9 = new net.one97.paytm.recharge.metro.c.i$a
            r9.<init>()
            android.widget.CompoundButton$OnCheckedChangeListener r9 = (android.widget.CompoundButton.OnCheckedChangeListener) r9
            r1.setOnCheckedChangeListener(r9)
            boolean r1 = r0.J
            if (r1 == 0) goto L_0x01f5
            android.widget.CheckBox r1 = r0.v
            if (r1 == 0) goto L_0x01ea
            r1.setChecked(r5)
        L_0x01ea:
            android.widget.CheckBox r1 = r0.u
            if (r1 != 0) goto L_0x01f1
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x01f1:
            r1.setChecked(r4)
            goto L_0x021d
        L_0x01f5:
            android.widget.CheckBox r1 = r0.v
            if (r1 == 0) goto L_0x0208
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r9 = r18.getRjtFare()
            if (r9 == 0) goto L_0x0204
            boolean r9 = r9.isSelection()
            goto L_0x0205
        L_0x0204:
            r9 = 0
        L_0x0205:
            r1.setChecked(r9)
        L_0x0208:
            android.widget.CheckBox r1 = r0.u
            if (r1 != 0) goto L_0x020f
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x020f:
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r9 = r18.getSjtFare()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            boolean r9 = r9.isSelection()
            r1.setChecked(r9)
        L_0x021d:
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r1 = r18.getSjtFare()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            double r9 = r1.getFare()
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r9 = r9 * r11
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r1 = r18.getRjtFare()
            r13 = 0
            if (r1 != 0) goto L_0x0236
            r15 = r13
            goto L_0x0243
        L_0x0236:
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r1 = r18.getRjtFare()
            java.lang.String r15 = "response.rjtFare"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)
            double r15 = r1.getFare()
        L_0x0243:
            double r9 = r9 - r15
            android.view.View r1 = r17.getView()
            if (r1 == 0) goto L_0x0253
            int r15 = net.one97.paytm.recharge.R.id.rjt_price_actual
            android.view.View r1 = r1.findViewById(r15)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0254
        L_0x0253:
            r1 = r6
        L_0x0254:
            java.lang.String r15 = "null cannot be cast to non-null type android.widget.TextView"
            if (r1 == 0) goto L_0x03e4
            android.view.View r6 = r17.getView()
            if (r6 == 0) goto L_0x0268
            int r3 = net.one97.paytm.recharge.R.id.rjt_save
            android.view.View r3 = r6.findViewById(r3)
            r6 = r3
            android.widget.TextView r6 = (android.widget.TextView) r6
            goto L_0x0269
        L_0x0268:
            r6 = 0
        L_0x0269:
            if (r6 == 0) goto L_0x03de
            int r3 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r3 <= 0) goto L_0x02bb
            int r3 = net.one97.paytm.recharge.R.string.metro_ticket_price_container
            java.lang.Object[] r13 = new java.lang.Object[r5]
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r14 = r18.getSjtFare()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
            double r14 = r14.getFare()
            double r14 = r14 * r11
            java.lang.String r11 = java.lang.String.valueOf(r14)
            java.lang.String r11 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r11, (boolean) r5)
            r13[r4] = r11
            java.lang.String r3 = r0.getString(r3, r13)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            r1.setVisibility(r4)
            int r1 = net.one97.paytm.recharge.R.string.metro_ticket_purchase_saving_placeholder_new
            java.lang.Object[] r3 = new java.lang.Object[r5]
            int r11 = net.one97.paytm.recharge.R.string.price_container_re
            java.lang.Object[] r12 = new java.lang.Object[r5]
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r9 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r9, (boolean) r5)
            r12[r4] = r9
            java.lang.String r9 = r0.getString(r11, r12)
            r3[r4] = r9
            java.lang.String r1 = r0.getString(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6.setText(r1)
            r6.setVisibility(r4)
            goto L_0x02c3
        L_0x02bb:
            r3 = 8
            r1.setVisibility(r3)
            r6.setVisibility(r3)
        L_0x02c3:
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r1 = r0.f63369d
            java.lang.String r3 = "sjtTitle"
            java.lang.String r6 = "rjtTitle"
            if (r1 == 0) goto L_0x0391
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r1 = r18.getSjtFare()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            int r1 = r1.getCode()
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r7 = r0.f63369d
            if (r7 == 0) goto L_0x031a
            int r7 = r7.getJourneyTypeCode()
            if (r1 != r7) goto L_0x031a
            android.widget.CheckBox r1 = r0.u
            if (r1 != 0) goto L_0x02e8
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x02e8:
            r1.setChecked(r5)
            android.widget.TextView r1 = r0.x
            if (r1 != 0) goto L_0x02f2
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x02f2:
            r2 = 0
            r1.setTypeface(r2, r4)
            android.widget.TextView r1 = r0.y
            if (r1 != 0) goto L_0x02fd
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x02fd:
            r1.setTypeface(r2, r5)
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r1 = r0.f63369d
            if (r1 == 0) goto L_0x030d
            int r1 = r1.getPassengers()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            goto L_0x030e
        L_0x030d:
            r6 = 0
        L_0x030e:
            if (r6 != 0) goto L_0x0313
            kotlin.g.b.k.a()
        L_0x0313:
            int r1 = r6.intValue()
            r0.I = r1
            goto L_0x0373
        L_0x031a:
            net.one97.paytm.recharge.model.metro.CJRMetroPriceModel r1 = r18.getRjtFare()
            if (r1 == 0) goto L_0x0329
            int r1 = r1.getCode()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x032a
        L_0x0329:
            r1 = 0
        L_0x032a:
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r2 = r0.f63369d
            if (r2 == 0) goto L_0x0337
            int r2 = r2.getJourneyTypeCode()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0338
        L_0x0337:
            r2 = 0
        L_0x0338:
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0373
            android.widget.CheckBox r1 = r0.v
            if (r1 == 0) goto L_0x0345
            r1.setChecked(r5)
        L_0x0345:
            android.widget.TextView r1 = r0.x
            if (r1 != 0) goto L_0x034c
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x034c:
            r2 = 0
            r1.setTypeface(r2, r5)
            android.widget.TextView r1 = r0.y
            if (r1 != 0) goto L_0x0357
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0357:
            r1.setTypeface(r2, r4)
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r1 = r0.f63369d
            if (r1 == 0) goto L_0x0367
            int r1 = r1.getPassengers()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            goto L_0x0368
        L_0x0367:
            r6 = 0
        L_0x0368:
            if (r6 != 0) goto L_0x036d
            kotlin.g.b.k.a()
        L_0x036d:
            int r1 = r6.intValue()
            r0.I = r1
        L_0x0373:
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r1 = r0.f63369d
            if (r1 == 0) goto L_0x0380
            int r1 = r1.getPassengers()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            goto L_0x0381
        L_0x0380:
            r6 = 0
        L_0x0381:
            if (r6 != 0) goto L_0x0386
            kotlin.g.b.k.a()
        L_0x0386:
            int r1 = r6.intValue()
            r0.b((int) r1, (boolean) r4)
            r1 = 0
            r0.f63369d = r1
            return
        L_0x0391:
            android.widget.CheckBox r1 = r0.u
            if (r1 != 0) goto L_0x0398
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x0398:
            boolean r1 = r1.isChecked()
            if (r1 == 0) goto L_0x03b9
            android.widget.TextView r1 = r0.x
            if (r1 != 0) goto L_0x03a5
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x03a5:
            r2 = 0
            r1.setTypeface(r2, r4)
            android.widget.TextView r1 = r0.y
            if (r1 != 0) goto L_0x03b0
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x03b0:
            r1.setTypeface(r2, r5)
            int r1 = r0.I
            r0.b((int) r1, (boolean) r4)
            return
        L_0x03b9:
            android.widget.CheckBox r1 = r0.v
            if (r1 == 0) goto L_0x03dd
            boolean r1 = r1.isChecked()
            if (r1 != r5) goto L_0x03dd
            android.widget.TextView r1 = r0.x
            if (r1 != 0) goto L_0x03ca
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x03ca:
            r2 = 0
            r1.setTypeface(r2, r5)
            android.widget.TextView r1 = r0.y
            if (r1 != 0) goto L_0x03d5
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x03d5:
            r1.setTypeface(r2, r4)
            int r1 = r0.I
            r0.b((int) r1, (boolean) r4)
        L_0x03dd:
            return
        L_0x03de:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r15)
            throw r1
        L_0x03e4:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r15)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.i.a(net.one97.paytm.recharge.model.metro.CJRMetroPriceResponse):void");
    }

    /* access modifiers changed from: private */
    public final void b(int i2, boolean z2) {
        a(i2, z2);
        CompoundButton compoundButton = this.C;
        Object tag = compoundButton != null ? compoundButton.getTag() : null;
        if (tag != null) {
            CJRMetroPriceModel cJRMetroPriceModel = (CJRMetroPriceModel) tag;
            double fare = cJRMetroPriceModel.getFare() * ((double) i2);
            if (isAdded()) {
                a(cJRMetroPriceModel);
            }
            TextView textView = this.f63373h;
            if (textView == null) {
                k.a("proceedButton");
            }
            textView.setText(getString(R.string.cart_proceed_to_pay, ba.a(String.valueOf(fare), true)));
            TextView textView2 = this.f63373h;
            if (textView2 == null) {
                k.a("proceedButton");
            }
            textView2.setTag(ba.a(String.valueOf(fare), true));
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroPriceModel");
    }

    /* access modifiers changed from: private */
    public final void a(boolean z2) {
        if (z2) {
            p();
        } else {
            u();
        }
        TextView textView = this.f63373h;
        if (textView == null) {
            k.a("proceedButton");
        }
        textView.setEnabled(z2);
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        if (this.n != null && this.o != null) {
            return true;
        }
        Toast.makeText(getContext(), R.string.error_metro_ticket_purchase_validation_failed, 0).show();
        return false;
    }

    private final boolean t() {
        Context context = getContext();
        if (!(context == null || context.getApplicationContext() == null)) {
            ax.a aVar = ax.f61521a;
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            k.a((Object) context2, "context!!");
            Context applicationContext = context2.getApplicationContext();
            k.a((Object) applicationContext, "context!!.applicationContext");
            String b2 = ax.a.a(applicationContext).b("sso_token=", "", true);
            if (!k.a((Object) b2, (Object) "")) {
                if (b2.length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        CJRMetroStationListResponse cJRMetroStationListResponse = this.l;
        Object obj = null;
        if (cJRMetroStationListResponse != null) {
            if (cJRMetroStationListResponse == null) {
                k.a();
            }
            CJRMetroStationDataModel source = cJRMetroStationListResponse.getSource();
            k.a((Object) source, "stationListResponse!!.source");
            String key = source.getKey();
            CJRMetroStationModel cJRMetroStationModel = this.n;
            jSONObject.put(key, cJRMetroStationModel != null ? cJRMetroStationModel.getId() : null);
            CJRMetroStationListResponse cJRMetroStationListResponse2 = this.l;
            if (cJRMetroStationListResponse2 == null) {
                k.a();
            }
            CJRMetroStationDataModel destination = cJRMetroStationListResponse2.getDestination();
            k.a((Object) destination, "stationListResponse!!.destination");
            String key2 = destination.getKey();
            CJRMetroStationModel cJRMetroStationModel2 = this.o;
            jSONObject.put(key2, cJRMetroStationModel2 != null ? cJRMetroStationModel2.getId() : null);
            CJRMetroStationListResponse cJRMetroStationListResponse3 = this.l;
            if (cJRMetroStationListResponse3 == null) {
                k.a();
            }
            CJRMetroPassengerDataModel passengers = cJRMetroStationListResponse3.getPassengers();
            k.a((Object) passengers, "stationListResponse!!.passengers");
            String key3 = passengers.getKey();
            TextView textView = this.w;
            if (textView == null) {
                k.a("passengerCount");
            }
            jSONObject.put(key3, Integer.parseInt(textView.getText().toString()));
            CJRMetroStationModel cJRMetroStationModel3 = this.n;
            jSONObject.put("source", cJRMetroStationModel3 != null ? cJRMetroStationModel3.getName() : null);
            CJRMetroStationModel cJRMetroStationModel4 = this.o;
            jSONObject.put("destination", cJRMetroStationModel4 != null ? cJRMetroStationModel4.getName() : null);
        }
        CompoundButton compoundButton = this.C;
        if (compoundButton != null) {
            obj = compoundButton.getTag();
        }
        if (obj != null) {
            jSONObject.put("tokenType", ((CJRMetroPriceModel) obj).getCode());
            return jSONObject;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroPriceModel");
    }

    /* access modifiers changed from: protected */
    public String m() {
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        String string = context.getString(R.string.select_origin_station);
        k.a((Object) string, "context!!.getString(R.st…ng.select_origin_station)");
        return string;
    }

    /* access modifiers changed from: protected */
    public String n() {
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        String string = context.getString(R.string.select_destination);
        k.a((Object) string, "context!!.getString(R.string.select_destination)");
        return string;
    }

    static final class f implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final f f63380a = new f();

        f() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public static final class g implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f63381a;

        g(i iVar) {
            this.f63381a = iVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            String message;
            k.c(str, "tag");
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this.f63381a.getActivity(), (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
            this.f63381a.a(true);
            net.one97.paytm.recharge.ordersummary.f.g gVar = this.f63381a.p;
            if (gVar != null) {
                gVar.o();
            }
            Context context = this.f63381a.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63381a.f63367b;
            String a2 = c.a.a(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
            String i3 = this.f63381a.L;
            String str2 = i3 == null ? "" : i3;
            String str3 = ab.f61496a;
            k.a((Object) str3, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, a2, "proceed_error", "", str2, str3, (networkCustomError == null || (message = networkCustomError.getMessage()) == null) ? "" : message, (Object) null, 64);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            String str2;
            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
            k.c(str, "tag");
            if ((iJRPaytmDataModel2 instanceof CJRRechargeCart) && this.f63381a.isAdded() && this.f63381a.getActivity() != null) {
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel2;
                this.f63381a.f63371f = cJRRechargeCart;
                az azVar = az.f61525a;
                Bundle a2 = az.a(this.f63381a.getContext(), cJRRechargeCart, true, false);
                boolean z = a2.getBoolean("extra.has.error");
                CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
                String str3 = null;
                if (!p.a("SUCCESS", cartStatus != null ? cartStatus.getResult() : null, true) || z) {
                    this.f63381a.a(true);
                    String string = a2.getString("extra.error.title");
                    String string2 = a2.getString("extra.error.msg");
                    String string3 = a2.getString("extra.show.error.info");
                    if (this.f63381a.H != null) {
                        CharSequence charSequence = string3;
                        if (!TextUtils.isEmpty(charSequence) && string3 != null && p.a(charSequence, (CharSequence) "message", false)) {
                            try {
                                JSONObject jSONObject = new JSONObject(string3);
                                net.one97.paytm.recharge.metro.e.a k = this.f63381a.H;
                                if (k == null) {
                                    k.a();
                                }
                                k.a(jSONObject);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    if (TextUtils.isEmpty(string2)) {
                        string2 = this.f63381a.getResources().getString(R.string.network_error_message);
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = this.f63381a.getResources().getString(R.string.network_error_heading);
                    }
                    Context context = this.f63381a.getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
                    c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                    CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63381a.f63367b;
                    if (cJRUtilityVariantV2 != null) {
                        str3 = cJRUtilityVariantV2.getFilterName();
                    }
                    String a3 = c.a.a(str3);
                    String i2 = this.f63381a.L;
                    if (i2 == null) {
                        i2 = "";
                    }
                    String str4 = i2;
                    String str5 = ab.f61496a;
                    k.a((Object) str5, "CJRRechargeUtilityConstant.UTILITY");
                    if (string2 == null) {
                        k.a();
                    }
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, a3, "proceed_error", "", str4, str5, string2, (Object) null, 64);
                    az azVar2 = az.f61525a;
                    az.a(this.f63381a.getContext(), ERROR_TYPE.UNDEFINED, ACTION_TYPE.METRO_TICKET, string, string2);
                    net.one97.paytm.recharge.ordersummary.f.g gVar = this.f63381a.p;
                    if (gVar != null) {
                        gVar.o();
                    }
                } else if (this.f63381a.e().isChecked()) {
                    Activity activity = this.f63381a.getActivity();
                    String j = this.f63381a.N;
                    net.one97.paytm.recharge.common.f.c a4 = this.f63381a.a();
                    CJRItem cJRItem = this.f63381a.f63368c;
                    Bundle arguments = this.f63381a.getArguments();
                    String string4 = arguments != null ? arguments.getString("input_fields") : null;
                    Bundle arguments2 = this.f63381a.getArguments();
                    String string5 = arguments2 != null ? arguments2.getString("group_field") : null;
                    CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63381a.f63366a;
                    if (cJRUtilityVariantV22 != null) {
                        str2 = cJRUtilityVariantV22.getFilterName();
                    } else {
                        str2 = null;
                    }
                    net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    net.one97.paytm.recharge.metro.f.a.a(activity, j, cJRRechargeCart, a4, cJRItem, string4, string5, str2, new a(this), this.f63381a, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.UNDEFINED, ERROR_TYPE.UNDEFINED));
                } else {
                    this.f63381a.a(true);
                    Intent intent = new Intent(this.f63381a.getContext(), AJRCouponsActivityV8.class);
                    intent.putExtra("recharge cart", iJRPaytmDataModel2);
                    intent.putExtra("gtm_category", "Recharge/Electricity");
                    CJRUtilityVariantV2 cJRUtilityVariantV23 = this.f63381a.f63366a;
                    intent.putExtra("operator_name", cJRUtilityVariantV23 != null ? cJRUtilityVariantV23.getFilterName() : null);
                    CJRUtilityVariantV2 cJRUtilityVariantV24 = this.f63381a.f63367b;
                    intent.putExtra("product_variant", cJRUtilityVariantV24 != null ? cJRUtilityVariantV24.getFilterName() : null);
                    c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                    CJRUtilityVariantV2 cJRUtilityVariantV25 = this.f63381a.f63366a;
                    if (cJRUtilityVariantV25 != null) {
                        str3 = cJRUtilityVariantV25.getFilterName();
                    }
                    intent.putExtra("recharge_utilities_service_type", c.a.a(str3));
                    intent.setFlags(536870912);
                    this.f63381a.startActivity(intent);
                    net.one97.paytm.recharge.ordersummary.f.g gVar2 = this.f63381a.p;
                    if (gVar2 != null) {
                        gVar2.o();
                    }
                }
            }
        }

        public static final class a implements ai {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f63382a;

            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                k.c(str, "tag");
            }

            a(g gVar) {
                this.f63382a = gVar;
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                String str2;
                String message;
                k.c(str, "tag");
                if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                    CJRRechargeUtilities.INSTANCE.handleError(this.f63382a.f63381a.getActivity(), networkCustomError, (String) null, (Bundle) null, false);
                }
                this.f63382a.f63381a.a(true);
                net.one97.paytm.recharge.ordersummary.f.g gVar = this.f63382a.f63381a.p;
                if (gVar != null) {
                    gVar.o();
                }
                Context context = this.f63382a.f63381a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
                c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63382a.f63381a.f63366a;
                String a2 = c.a.a(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
                String i3 = this.f63382a.f63381a.L;
                String str3 = i3 == null ? "" : i3;
                String str4 = ab.f61496a;
                k.a((Object) str4, "CJRRechargeUtilityConstant.UTILITY");
                if (networkCustomError == null || (message = networkCustomError.getMessage()) == null) {
                    str2 = "";
                } else {
                    str2 = message;
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, a2, "proceed_error", "", str3, str4, str2, (Object) null, 64);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        CJRUtilityProductV2 product;
        CJRUtilityAttributesV2 attributes;
        if (com.paytm.utility.b.c(getContext())) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            String str = null;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.GET_STATION_LIST.name());
            }
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63367b;
                flowName3.setVariantType(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
            }
            Context context = getContext();
            String str2 = this.t;
            CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63367b;
            if (!(cJRUtilityVariantV22 == null || (product = cJRUtilityVariantV22.getProduct()) == null || (attributes = product.getAttributes()) == null)) {
                str = attributes.getProductRequestType();
            }
            net.one97.paytm.recharge.metro.f.a.a("fetch_metro_station", context, str2, str, (ai) new b(this), (Object) a2);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f63376a;

        b(i iVar) {
            this.f63376a = iVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(networkCustomError);
            if (!(iJRPaytmDataModel instanceof CJRMetroStationListResponse)) {
                if (obj instanceof CJRRechargeErrorModel) {
                    az azVar = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj);
                }
                FragmentActivity activity = this.f63376a.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else if (this.f63376a.getActivity() == null || !CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                if (obj instanceof CJRRechargeErrorModel) {
                    az azVar2 = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj);
                }
                FragmentActivity activity2 = this.f63376a.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            } else {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                Activity activity3 = this.f63376a.getActivity();
                Fragment fragment = this.f63376a;
                if (networkCustomError == null) {
                    k.a();
                }
                cJRRechargeUtilities.handleError(str, activity3, fragment, networkCustomError, true, 103, obj);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel == null) {
                FragmentActivity activity = this.f63376a.getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (this.f63376a.getActivity() instanceof AJRMetroTicketPurchaseActivity) {
                FragmentActivity activity2 = this.f63376a.getActivity();
                if (activity2 == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.activity.AJRMetroTicketPurchaseActivity");
                } else if (((AJRMetroTicketPurchaseActivity) activity2).f63219a) {
                    return;
                }
            }
            i iVar = this.f63376a;
            iVar.l = (CJRMetroStationListResponse) iJRPaytmDataModel;
            i.l(iVar);
        }
    }

    public final void a(String str, String str2) {
        CJRUtilityProductV2 product;
        CJRUtilityAttributesV2 attributes;
        LinkedList<String> logs;
        LinkedList<String> logs2;
        k.c(str, "sourceStationId");
        k.c(str2, "destinationStationId");
        if (com.paytm.utility.b.c(getContext())) {
            net.one97.paytm.recharge.ordersummary.f.g gVar = this.p;
            if (gVar != null) {
                gVar.at_();
            }
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            String str3 = null;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.METRO_TICKET_PRICE.name());
            }
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                StringBuilder sb = new StringBuilder();
                CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63366a;
                sb.append(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
                sb.append("/");
                CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63367b;
                sb.append(cJRUtilityVariantV22 != null ? cJRUtilityVariantV22.getFilterName() : null);
                flowName3.setVariantType(sb.toString());
            }
            CRUFlowModel flowName4 = a2.getFlowName();
            if (!(flowName4 == null || (logs2 = flowName4.getLogs()) == null)) {
                StringBuilder sb2 = new StringBuilder("Source Station: ");
                CJRMetroStationModel cJRMetroStationModel = this.n;
                sb2.append(cJRMetroStationModel != null ? cJRMetroStationModel.getName() : null);
                sb2.append(" | ");
                CJRMetroStationModel cJRMetroStationModel2 = this.n;
                sb2.append(cJRMetroStationModel2 != null ? cJRMetroStationModel2.getId() : null);
                logs2.push(sb2.toString());
            }
            CRUFlowModel flowName5 = a2.getFlowName();
            if (!(flowName5 == null || (logs = flowName5.getLogs()) == null)) {
                StringBuilder sb3 = new StringBuilder("Destination Station: ");
                CJRMetroStationModel cJRMetroStationModel3 = this.o;
                sb3.append(cJRMetroStationModel3 != null ? cJRMetroStationModel3.getName() : null);
                sb3.append(" | ");
                CJRMetroStationModel cJRMetroStationModel4 = this.o;
                sb3.append(cJRMetroStationModel4 != null ? cJRMetroStationModel4.getId() : null);
                logs.push(sb3.toString());
            }
            Context context = getContext();
            ai cVar = new c(this);
            CJRUtilityVariantV2 cJRUtilityVariantV23 = this.f63367b;
            if (!(cJRUtilityVariantV23 == null || (product = cJRUtilityVariantV23.getProduct()) == null || (attributes = product.getAttributes()) == null)) {
                str3 = attributes.getProductRequestType();
            }
            net.one97.paytm.recharge.metro.f.a.b("fetch_metro_ticket_price", context, str, str2, cVar, str3, a2);
        }
    }

    public static final class c implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f63377a;

        c(i iVar) {
            this.f63377a = iVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            net.one97.paytm.recharge.ordersummary.f.g gVar = this.f63377a.p;
            if (gVar != null) {
                gVar.o();
            }
            this.f63377a.p();
            if (this.f63377a.getActivity() != null && CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                Activity activity = this.f63377a.getActivity();
                Fragment fragment = this.f63377a;
                if (networkCustomError == null) {
                    k.a();
                }
                cJRRechargeUtilities.handleError(str, activity, fragment, networkCustomError, true, this.f63377a.K, obj);
            } else if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel == null) {
                FragmentActivity activity = this.f63377a.getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (this.f63377a.isAdded()) {
                this.f63377a.a((CJRMetroPriceResponse) iJRPaytmDataModel);
            }
            this.f63377a.p();
            net.one97.paytm.recharge.ordersummary.f.g gVar = this.f63377a.p;
            if (gVar != null) {
                gVar.o();
            }
        }
    }

    public void onClick(View view) {
        CJRUtilityProductV2 product;
        String str;
        String str2;
        CJRUtilityProductV2 product2;
        CJRUtilityAttributesV2 attributes;
        CJRMetroStationDataModel destination;
        CJRMetroStationDataModel source;
        CJRUtilityFilterAttributesV2 attributes2;
        CJRUtilityProductV2 product3;
        CJRUtilityAttributesV2 attributes3;
        CJRMetroStationDataModel destination2;
        CJRMetroStationDataModel source2;
        CJRUtilityFilterAttributesV2 attributes4;
        CheckBox checkBox;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.container_sjt;
        if (valueOf != null && valueOf.intValue() == i2) {
            CheckBox checkBox2 = this.u;
            if (checkBox2 == null) {
                k.a("sjtCheckbox");
            }
            if (!checkBox2.isChecked()) {
                CheckBox checkBox3 = this.u;
                if (checkBox3 == null) {
                    k.a("sjtCheckbox");
                }
                checkBox3.performClick();
                return;
            }
            return;
        }
        int i3 = R.id.container_rjt;
        if (valueOf != null && valueOf.intValue() == i3) {
            CheckBox checkBox4 = this.v;
            if (checkBox4 != null && !checkBox4.isChecked() && (checkBox = this.v) != null) {
                checkBox.performClick();
                return;
            }
            return;
        }
        int i4 = R.id.station_from;
        if (valueOf == null || valueOf.intValue() != i4) {
            int i5 = R.id.station_to;
            if (valueOf == null || valueOf.intValue() != i5) {
                int i6 = R.id.increase_passenger_count;
                if (valueOf != null && valueOf.intValue() == i6) {
                    CheckBox checkBox5 = this.u;
                    if (checkBox5 == null) {
                        k.a("sjtCheckbox");
                    }
                    if (checkBox5.isChecked()) {
                        this.I++;
                        b(this.I, true);
                        return;
                    }
                    CheckBox checkBox6 = this.v;
                    if (checkBox6 != null && checkBox6.isChecked()) {
                        this.I++;
                        b(this.I, true);
                        return;
                    }
                    return;
                }
                int i7 = R.id.decrease_passenger_count;
                if (valueOf != null && valueOf.intValue() == i7) {
                    CheckBox checkBox7 = this.u;
                    if (checkBox7 == null) {
                        k.a("sjtCheckbox");
                    }
                    if (checkBox7.isChecked()) {
                        this.I--;
                        b(this.I, false);
                        return;
                    }
                    CheckBox checkBox8 = this.v;
                    if (checkBox8 != null && checkBox8.isChecked()) {
                        this.I--;
                        b(this.I, false);
                        return;
                    }
                    return;
                }
                int i8 = R.id.proceed_btn;
                if (valueOf == null || valueOf.intValue() != i8) {
                    int i9 = R.id.station_swap;
                    if (valueOf != null && valueOf.intValue() == i9) {
                        this.F = this.n;
                        this.n = this.o;
                        this.o = this.F;
                        this.F = null;
                        TextView textView = this.f63374i;
                        if (textView == null) {
                            k.a("tvStationFrom");
                        }
                        CJRMetroStationModel cJRMetroStationModel = this.n;
                        textView.setText(cJRMetroStationModel != null ? cJRMetroStationModel.getName() : null);
                        TextView textView2 = this.j;
                        if (textView2 == null) {
                            k.a("tvStationTo");
                        }
                        CJRMetroStationModel cJRMetroStationModel2 = this.o;
                        textView2.setText(cJRMetroStationModel2 != null ? cJRMetroStationModel2.getName() : null);
                        if (getContext() != null) {
                            Context context = getContext();
                            if (context == null) {
                                k.a();
                            }
                            k.a((Object) context, "context!!");
                            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
                            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
                            CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63366a;
                            String a2 = c.a.a(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
                            String str3 = ab.f61496a;
                            k.a((Object) str3, "CJRRechargeUtilityConstant.UTILITY");
                            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, a2, "interchange_clicked", "", "", str3, (Object) null, (Object) null, 96);
                        }
                    }
                } else if (k()) {
                    a(false);
                    u();
                    String str4 = this.t;
                    if (str4 != null) {
                        if (p.a(str4, "MUMBAI_METRO_SJT", false) || p.a(str4, "MUMBAI_METRO_SJT", false)) {
                            b("/mumbai-metro-qr-ticket", "mumbai_metro_qr_ticket");
                        } else if (p.a(str4, "MUMBAI_METRO_TP", false)) {
                            b("/mumbai-metro-trip-pass", "mumbai_metro_trip_pass");
                        } else if (p.a(str4, "MUMBAI_METRO_SVP", false)) {
                            b("/mumbai-metro-store-value-pass", "mumbai_metro_store_value_pass");
                        }
                    }
                    if (getContext() != null) {
                        CheckBox checkBox9 = this.v;
                        this.L = ((checkBox9 == null || checkBox9 == null || !checkBox9.isChecked()) ? "single_journey" : "return_journey") + "_" + this.I;
                        if (this instanceof m) {
                            this.L = "";
                            str = "trip_pass_proceed_clicked";
                        } else if (this instanceof k) {
                            this.L = "";
                            str = "store_value_pass_proceed_clicked";
                        } else {
                            str = "metro_qr_ticket_proceed_clicked";
                        }
                        String str5 = str;
                        Context context2 = getContext();
                        if (context2 == null) {
                            k.a();
                        }
                        k.a((Object) context2, "context!!");
                        net.one97.paytm.recharge.ordersummary.h.d dVar2 = new net.one97.paytm.recharge.ordersummary.h.d(context2);
                        c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                        CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63366a;
                        String a3 = c.a.a(cJRUtilityVariantV22 != null ? cJRUtilityVariantV22.getFilterName() : null);
                        String str6 = this.L;
                        if (str6 == null) {
                            str2 = "";
                        } else {
                            str2 = str6;
                        }
                        String str7 = ab.f61496a;
                        k.a((Object) str7, "CJRRechargeUtilityConstant.UTILITY");
                        net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, a3, str5, "", str2, str7, (Object) null, (Object) null, 96);
                    }
                    net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    ay ayVar = ay.f61523a;
                    ay.a(ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, a4);
                    if (t()) {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a5 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                        CRUFlowModel flowName = a5.getFlowName();
                        if (flowName == null) {
                            flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
                        }
                        a5.setFlowName(flowName);
                        try {
                            CJRUtilityVariantV2 cJRUtilityVariantV23 = this.f63367b;
                            jSONObject2.put(CLPConstants.PRODUCT_ID, (cJRUtilityVariantV23 == null || (product = cJRUtilityVariantV23.getProduct()) == null) ? null : Long.valueOf(product.getId()));
                            jSONObject2.put("qty", 1);
                            JSONObject jSONObject3 = new JSONObject();
                            TextView textView3 = this.f63373h;
                            if (textView3 == null) {
                                k.a("proceedButton");
                            }
                            Object tag = textView3.getTag();
                            if (tag != null) {
                                jSONObject3.put("price", ba.e((String) tag));
                                String str8 = ab.f61497b;
                                CJRItem cJRItem = this.f63368c;
                                jSONObject3.put(str8, cJRItem != null ? cJRItem.getCategoryId() : null);
                                jSONObject2.put("meta_data", l());
                                jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
                                CRUFlowModel flowName2 = a5.getFlowName();
                                if (flowName2 != null) {
                                    flowName2.setRequestBody(jSONObject3.toString());
                                }
                                jSONArray.put(jSONObject2);
                                jSONObject.put("cart_items", jSONArray);
                                HashMap hashMap = new HashMap();
                                hashMap.put("Content-Type", "application/json");
                                az azVar = az.f61525a;
                                String a6 = az.a(jSONObject);
                                y yVar = y.f61814b;
                                y.a(jSONObject);
                                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                                String b2 = com.paytm.utility.b.b(getContext(), net.one97.paytm.recharge.di.helper.c.c(a6));
                                CRUFlowModel flowName3 = a5.getFlowName();
                                if (flowName3 != null) {
                                    flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
                                }
                                CRUFlowModel flowName4 = a5.getFlowName();
                                if (flowName4 != null) {
                                    flowName4.setActionType(ACTION_TYPE.METRO_VERIFY.name());
                                }
                                CRUFlowModel flowName5 = a5.getFlowName();
                                if (flowName5 != null) {
                                    flowName5.setTag("metro_verify");
                                }
                                CRUFlowModel flowName6 = a5.getFlowName();
                                if (flowName6 != null) {
                                    StringBuilder sb = new StringBuilder();
                                    CJRUtilityVariantV2 cJRUtilityVariantV24 = this.f63366a;
                                    sb.append(cJRUtilityVariantV24 != null ? cJRUtilityVariantV24.getFilterName() : null);
                                    sb.append("/");
                                    CJRUtilityVariantV2 cJRUtilityVariantV25 = this.f63367b;
                                    sb.append(cJRUtilityVariantV25 != null ? cJRUtilityVariantV25.getFilterName() : null);
                                    flowName6.setVariantType(sb.toString());
                                }
                                this.f63370e = new net.one97.paytm.recharge.common.f.c("metro_verify", b2, (ai) new g(this), (IJRPaytmDataModel) new CJRRechargeCart(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), (Object) a5);
                                if (com.paytm.utility.b.c(getContext())) {
                                    getContext();
                                    net.one97.paytm.recharge.common.f.d.a();
                                    net.one97.paytm.recharge.common.f.c cVar2 = this.f63370e;
                                    if (cVar2 == null) {
                                        k.a("cartRequest");
                                    }
                                    net.one97.paytm.recharge.common.f.d.b(cVar2);
                                    return;
                                }
                                a(true);
                                net.one97.paytm.recharge.ordersummary.f.g gVar = this.p;
                                if (gVar != null) {
                                    gVar.o();
                                }
                                net.one97.paytm.recharge.common.f.c cVar3 = this.f63370e;
                                if (cVar3 == null) {
                                    k.a("cartRequest");
                                }
                                ba.a((net.one97.paytm.recharge.common.f.a) cVar3, getContext(), (DialogInterface.OnCancelListener) this, (aa) null);
                                return;
                            }
                            throw new u("null cannot be cast to non-null type kotlin.String");
                        } catch (Exception e2) {
                            a(true);
                            net.one97.paytm.recharge.ordersummary.f.g gVar2 = this.p;
                            if (gVar2 != null) {
                                gVar2.o();
                            }
                            q.d(e2.getMessage());
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle(getString(R.string.network_error_heading)).setMessage(getString(R.string.network_error_message));
                            builder.setCancelable(false);
                            builder.setPositiveButton(getResources().getString(R.string.ok), f.f63380a);
                            builder.show();
                        }
                    } else {
                        a(true);
                        Context context3 = getContext();
                        net.one97.paytm.recharge.di.helper.a aVar3 = net.one97.paytm.recharge.di.helper.a.f62650a;
                        Intent intent = new Intent(context3, net.one97.paytm.recharge.di.helper.a.b());
                        intent.putExtra("parent_activity", CJRRechargeBaseActivity.class.getName());
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                            k.a((Object) activity, "it");
                            cJRRechargeUtilities.signOut(activity, false, (NetworkCustomError) null);
                        }
                        intent.putExtra("sign_in_title", getResources().getString(R.string.sign_in_recharge));
                        intent.putExtra("sign_up_title", getResources().getString(R.string.sign_up_recharge));
                        intent.putExtra("set_result_required", true);
                        intent.putExtra("VERTICAL_NAME", "Recharge");
                        intent.addFlags(536870912);
                        startActivityForResult(intent, 800);
                        net.one97.paytm.recharge.ordersummary.f.g gVar3 = this.p;
                        if (gVar3 != null) {
                            gVar3.o();
                        }
                    }
                }
            } else if (!net.one97.paytm.recharge.metro.f.d.INSTANCE.validateIsAlreadyClicked(this) && this.n != null && getContext() != null) {
                CheckBox checkBox10 = this.v;
                this.J = checkBox10 != null && checkBox10.isChecked();
                Intent putExtra = new Intent(getContext(), AJRMetroStationListActivity.class).putExtra("source_station", m()).putExtra("destination_station", n());
                CJRMetroStationListResponse cJRMetroStationListResponse = this.l;
                List<CJRMetroStationModel> stations = cJRMetroStationListResponse != null ? cJRMetroStationListResponse.getStations() : null;
                if (stations != null) {
                    Intent putExtra2 = putExtra.putExtra("metroStationList", (Serializable) stations).putExtra("is_new_metro_flow", true).putExtra("sourceMetroStation", this.n);
                    CJRUtilityVariantV2 cJRUtilityVariantV26 = this.f63366a;
                    Intent putExtra3 = putExtra2.putExtra("metroTicketVariant", (cJRUtilityVariantV26 == null || (attributes2 = cJRUtilityVariantV26.getAttributes()) == null) ? null : attributes2.getProductRequestType());
                    CJRMetroStationListResponse cJRMetroStationListResponse2 = this.l;
                    Intent putExtra4 = putExtra3.putExtra("station_hint", (cJRMetroStationListResponse2 == null || (source = cJRMetroStationListResponse2.getSource()) == null) ? null : source.getLabel());
                    CJRMetroStationListResponse cJRMetroStationListResponse3 = this.l;
                    Intent putExtra5 = putExtra4.putExtra("station_hint_dest", (cJRMetroStationListResponse3 == null || (destination = cJRMetroStationListResponse3.getDestination()) == null) ? null : destination.getLabel()).putExtra("ticket_type", this.t).putExtra("product-type", this.t);
                    CJRUtilityVariantV2 cJRUtilityVariantV27 = this.f63367b;
                    startActivityForResult(putExtra5.putExtra("key_recent_product_type", (cJRUtilityVariantV27 == null || (product2 = cJRUtilityVariantV27.getProduct()) == null || (attributes = product2.getAttributes()) == null) ? null : attributes.getSelectedProductRequestType()).putExtra("source_name_for_penalty", this.n), this.E);
                    String str9 = this.t;
                    if (str9 == null) {
                        return;
                    }
                    if (p.a(str9, "MUMBAI_METRO_SJT", false) || p.a(str9, "MUMBAI_METRO_SJT", false)) {
                        a("/mumbai-metro-qr-ticket", "mumbai_metro_qr_ticket", "station_to_clicked");
                    } else if (p.a(str9, "MUMBAI_METRO_TP", false)) {
                        a("/mumbai-metro-trip-pass", "mumbai_metro_trip_pass", "station_b_clicked");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.io.Serializable");
                }
            }
        } else if (!net.one97.paytm.recharge.metro.f.d.INSTANCE.validateIsAlreadyClicked(this) && getContext() != null) {
            CheckBox checkBox11 = this.v;
            this.J = checkBox11 != null && checkBox11.isChecked();
            Intent putExtra6 = new Intent(getContext(), AJRMetroStationListActivity.class).putExtra("source_station", m()).putExtra("destination_station", n());
            CJRMetroStationListResponse cJRMetroStationListResponse4 = this.l;
            List<CJRMetroStationModel> stations2 = cJRMetroStationListResponse4 != null ? cJRMetroStationListResponse4.getStations() : null;
            if (stations2 != null) {
                Intent putExtra7 = putExtra6.putExtra("metroStationList", (Serializable) stations2).putExtra("ticket_type", this.t);
                CJRUtilityVariantV2 cJRUtilityVariantV28 = this.f63366a;
                Intent putExtra8 = putExtra7.putExtra("metroTicketVariant", (cJRUtilityVariantV28 == null || (attributes4 = cJRUtilityVariantV28.getAttributes()) == null) ? null : attributes4.getProductRequestType());
                CJRMetroStationListResponse cJRMetroStationListResponse5 = this.l;
                Intent putExtra9 = putExtra8.putExtra("station_hint", (cJRMetroStationListResponse5 == null || (source2 = cJRMetroStationListResponse5.getSource()) == null) ? null : source2.getLabel());
                CJRMetroStationListResponse cJRMetroStationListResponse6 = this.l;
                Intent putExtra10 = putExtra9.putExtra("station_hint_dest", (cJRMetroStationListResponse6 == null || (destination2 = cJRMetroStationListResponse6.getDestination()) == null) ? null : destination2.getLabel()).putExtra("product-type", this.t);
                CJRUtilityVariantV2 cJRUtilityVariantV29 = this.f63367b;
                startActivityForResult(putExtra10.putExtra("key_recent_product_type", (cJRUtilityVariantV29 == null || (product3 = cJRUtilityVariantV29.getProduct()) == null || (attributes3 = product3.getAttributes()) == null) ? null : attributes3.getSelectedProductRequestType()).putExtra("is_new_metro_flow", true), this.E);
                String str10 = this.t;
                if (str10 == null) {
                    return;
                }
                if (p.a(str10, "MUMBAI_METRO_SJT", false) || p.a(str10, "MUMBAI_METRO_SJT", false)) {
                    a("/mumbai-metro-qr-ticket", "mumbai_metro_qr_ticket", "station_from_clicked");
                } else if (p.a(str10, "MUMBAI_METRO_TP", false)) {
                    a("/mumbai-metro-trip-pass", "mumbai_metro_trip_pass", "station_a_clicked");
                }
            } else {
                throw new u("null cannot be cast to non-null type java.io.Serializable");
            }
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        net.one97.paytm.recharge.ordersummary.f.g gVar = this.p;
        if (gVar != null) {
            gVar.o();
        }
        p();
    }

    public void a(CJRFrequentOrder cJRFrequentOrder) {
        if (cJRFrequentOrder != null) {
            a((CJRMetroQRFrequentOrder) cJRFrequentOrder);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder");
    }

    /* access modifiers changed from: protected */
    public final void p() {
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout == null) {
            k.a("mProceedAnimationView");
        }
        if (a((View) relativeLayout)) {
            TextView textView = this.f63373h;
            if (textView == null) {
                k.a("proceedButton");
            }
            a(0, (View) textView);
            RelativeLayout relativeLayout2 = this.q;
            if (relativeLayout2 == null) {
                k.a("mProceedAnimationView");
            }
            a(8, (View) relativeLayout2);
            LottieAnimationView lottieAnimationView = this.r;
            if (lottieAnimationView == null) {
                k.a("mLottieAnimationView");
            }
            ba.b(lottieAnimationView);
            FrameLayout frameLayout = this.s;
            if (frameLayout == null) {
                k.a("mTransparentView");
            }
            a(8, (View) frameLayout);
        }
    }

    private void u() {
        TextView textView = this.f63373h;
        if (textView == null) {
            k.a("proceedButton");
        }
        a(8, (View) textView);
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout == null) {
            k.a("mProceedAnimationView");
        }
        a(0, (View) relativeLayout);
        LottieAnimationView lottieAnimationView = this.r;
        if (lottieAnimationView == null) {
            k.a("mLottieAnimationView");
        }
        ba.a(lottieAnimationView);
        FrameLayout frameLayout = this.s;
        if (frameLayout == null) {
            k.a("mTransparentView");
        }
        a(0, (View) frameLayout);
    }

    private static void a(int i2, View view) {
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    private static boolean a(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public final void a(CJRRechargePayment cJRRechargePayment) {
        k.c(cJRRechargePayment, "rechargePayment");
        this.D = cJRRechargePayment;
    }

    public void onRequestStart() {
        u();
    }

    public void onPaymentOptionsError() {
        String str;
        CJRUtilityProductV2 product;
        Activity activity = getActivity();
        String str2 = this.N;
        CJRRechargePayment cJRRechargePayment = this.D;
        CJRRechargeCart cJRRechargeCart = this.f63371f;
        CJRItem cJRItem = this.f63368c;
        Bundle arguments = getArguments();
        String str3 = null;
        String string = arguments != null ? arguments.getString("input_fields") : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("group_field") : null;
        CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63366a;
        net.one97.paytm.recharge.metro.f.a.a(activity, str2, cJRRechargePayment, cJRRechargeCart, cJRItem, string, string2, cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
        p();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName == null) {
            flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
        }
        a2.setFlowName(flowName);
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setErrorType(ERROR_TYPE.UI_DESCRIPTION.name());
        }
        CRUFlowModel flowName3 = a2.getFlowName();
        if (flowName3 != null) {
            flowName3.setActionType(ACTION_TYPE.CLP_PROCEED.name());
        }
        CJRUtilityVariantV2 cJRUtilityVariantV22 = this.f63367b;
        if (cJRUtilityVariantV22 == null || (product = cJRUtilityVariantV22.getProduct()) == null || (str = String.valueOf(product.getId())) == null) {
            str = "";
        }
        a2.setProductId(str);
        CRUFlowModel flowName4 = a2.getFlowName();
        if (flowName4 != null) {
            flowName4.setTag("fetchPaymentOptions");
        }
        Context context = getContext();
        if (context != null) {
            str3 = context.getString(R.string.error_message, new Object[]{"onPaymentOptionsError", i.class.getSimpleName()});
        }
        a2.setErrorMsg(str3);
        az azVar = az.f61525a;
        az.a(a2);
    }

    public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
        PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
        Activity activity = getActivity();
        String str = this.N;
        CJRRechargePayment cJRRechargePayment = this.D;
        CJRRechargeCart cJRRechargeCart = this.f63371f;
        CJRItem cJRItem = this.f63368c;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("input_fields") : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("group_field") : null;
        CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63366a;
        net.one97.paytm.recharge.metro.f.a.a(activity, str, cJRRechargePayment, cJRRechargeCart, cJRItem, string, string2, cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
        p();
    }

    private void a(String str, String str2, String str3) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        k.c(str3, "action");
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", str2);
            hashMap.put("event_action", str3);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
            hashMap.put("vertical_name", "recharges_utilities");
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        } catch (Throwable unused) {
        }
    }

    public final void b(String str) {
        k.c(str, "action");
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "mumbai_metro_qr_ticket");
            hashMap.put("event_action", str);
            Map map = hashMap;
            String str2 = this.M;
            if (str2 == null) {
                str2 = "";
            }
            map.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str2);
            hashMap.put("vertical_name", "recharges_utilities");
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        } catch (Throwable unused) {
        }
    }

    private void b(String str, String str2) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "category");
        try {
            HashMap hashMap = new HashMap();
            CheckBox checkBox = this.k;
            if (checkBox == null) {
                k.a("cbFastForward");
            }
            if (checkBox.isChecked()) {
                hashMap.put("event_label", "ff_checked");
            } else {
                hashMap.put("event_label", "ff_unchecked");
            }
            hashMap.put("event_category", str2);
            hashMap.put("event_action", Events.Action.PROCEED_CLICKED);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
            hashMap.put("vertical_name", "recharges_utilities");
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ RelativeLayout.LayoutParams q() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(1, R.id.sjt_title);
        return layoutParams;
    }

    public static final /* synthetic */ RelativeLayout.LayoutParams r() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(1, R.id.rjt_title);
        layoutParams.addRule(3, R.id.separator);
        return layoutParams;
    }

    public static final /* synthetic */ void l(i iVar) {
        CJRMetroStationListResponse cJRMetroStationListResponse;
        List<CJRMetroStationModel> stations;
        CJRMetroStationDataModel destination;
        String label;
        String str;
        CJRMetroStationDataModel source;
        String label2;
        View view;
        RelativeLayout relativeLayout;
        ScrollView scrollView;
        if (iVar.f63369d != null) {
            View view2 = iVar.f63372g;
            if (view2 == null) {
                k.a("progressBar");
            }
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = iVar.getView();
            if (!(view3 == null || (scrollView = (ScrollView) view3.findViewById(R.id.scroll_view)) == null)) {
                scrollView.setVisibility(0);
            }
        }
        Bundle arguments = iVar.getArguments();
        if (!(arguments == null || !arguments.getBoolean("fast_forward", false) || (view = iVar.getView()) == null || (relativeLayout = (RelativeLayout) view.findViewById(R.id.lyt_fast_forward)) == null)) {
            relativeLayout.setVisibility(0);
        }
        View view4 = iVar.getView();
        String str2 = null;
        TextView textView = view4 != null ? (TextView) view4.findViewById(R.id.operator) : null;
        if (!(textView instanceof TextView)) {
            textView = null;
        }
        if (textView != null) {
            CJRUtilityVariantV2 cJRUtilityVariantV2 = iVar.f63366a;
            textView.setText(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getDisplayName() : null);
        }
        View view5 = iVar.getView();
        TextInputLayout textInputLayout = view5 != null ? (TextInputLayout) view5.findViewById(R.id.station_from_hint) : null;
        if (!(textInputLayout instanceof TextInputLayout)) {
            textInputLayout = null;
        }
        if (textInputLayout != null) {
            CJRMetroStationListResponse cJRMetroStationListResponse2 = iVar.l;
            if (cJRMetroStationListResponse2 == null || (source = cJRMetroStationListResponse2.getSource()) == null || (label2 = source.getLabel()) == null) {
                str = null;
            } else if (label2 != null) {
                str = label2.toUpperCase();
                k.a((Object) str, "(this as java.lang.String).toUpperCase()");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            textInputLayout.setHint(str);
        }
        View view6 = iVar.getView();
        TextInputLayout textInputLayout2 = view6 != null ? (TextInputLayout) view6.findViewById(R.id.station_to_hint) : null;
        if (!(textInputLayout2 instanceof TextInputLayout)) {
            textInputLayout2 = null;
        }
        if (textInputLayout2 != null) {
            CJRMetroStationListResponse cJRMetroStationListResponse3 = iVar.l;
            if (!(cJRMetroStationListResponse3 == null || (destination = cJRMetroStationListResponse3.getDestination()) == null || (label = destination.getLabel()) == null)) {
                if (label != null) {
                    str2 = label.toUpperCase();
                    k.a((Object) str2, "(this as java.lang.String).toUpperCase()");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            textInputLayout2.setHint(str2);
        }
        iVar.h();
        if (!(!net.one97.paytm.recharge.common.utils.g.c(iVar.G) || (cJRMetroStationListResponse = iVar.l) == null || (stations = cJRMetroStationListResponse.getStations()) == null)) {
            for (CJRMetroStationModel cJRMetroStationModel : stations) {
                String str3 = iVar.G;
                k.a((Object) cJRMetroStationModel, "it");
                if (p.a(str3, cJRMetroStationModel.getId(), true)) {
                    TextView textView2 = iVar.j;
                    if (textView2 == null) {
                        k.a("tvStationTo");
                    }
                    textView2.setEnabled(true);
                    TextView textView3 = iVar.f63374i;
                    if (textView3 == null) {
                        k.a("tvStationFrom");
                    }
                    textView3.setText(cJRMetroStationModel.getName());
                    iVar.n = cJRMetroStationModel;
                }
            }
        }
        CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder = iVar.f63369d;
        if (cJRMetroQRFrequentOrder != null) {
            iVar.a(cJRMetroQRFrequentOrder);
        }
    }
}
