package net.one97.paytm.wallet.newdesign.nearby.a;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity;
import net.one97.paytm.wallet.newdesign.nearby.b.d;
import net.one97.paytm.wallet.newdesign.nearby.b.e;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;
import net.one97.paytm.wallet.newdesign.widget.ExpandableLinearLayout;

public final class c extends RecyclerView.a<RecyclerView.v> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    boolean f71015a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PayTMPartnerListModal.Response> f71016b;

    /* renamed from: c  reason: collision with root package name */
    private Context f71017c;

    /* renamed from: d  reason: collision with root package name */
    private Fragment f71018d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, View> f71019e = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SparseBooleanArray f71020f = new SparseBooleanArray();

    /* renamed from: g  reason: collision with root package name */
    private String f71021g;

    public c(Fragment fragment, ArrayList<PayTMPartnerListModal.Response> arrayList, Context context) {
        this.f71018d = fragment;
        this.f71016b = arrayList;
        this.f71017c = context;
        b();
    }

    public c(Fragment fragment, ArrayList<PayTMPartnerListModal.Response> arrayList, Context context, boolean z) {
        this.f71018d = fragment;
        this.f71016b = arrayList;
        this.f71017c = context;
        this.f71015a = z;
        b();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nb_item_view_divider, viewGroup, false));
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nb_item_nearby_row, viewGroup, false));
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            int r2 = r17.getItemViewType()
            r3 = 1
            if (r2 != r3) goto L_0x024a
            java.util.ArrayList<net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$Response> r2 = r0.f71016b
            java.lang.Object r2 = r2.get(r1)
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$Response r2 = (net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal.Response) r2
            r4 = r17
            net.one97.paytm.wallet.newdesign.nearby.a.c$a r4 = (net.one97.paytm.wallet.newdesign.nearby.a.c.a) r4
            if (r2 == 0) goto L_0x024a
            r5 = 0
            r4.setIsRecyclable(r5)
            net.one97.paytm.wallet.newdesign.widget.ExpandableLinearLayout r6 = r4.n
            r6.setInRecyclerView(r3)
            net.one97.paytm.wallet.newdesign.widget.ExpandableLinearLayout r6 = r4.n
            android.util.SparseBooleanArray r7 = r0.f71020f
            boolean r7 = r7.get(r1)
            r6.setExpanded(r7)
            net.one97.paytm.wallet.newdesign.widget.ExpandableLinearLayout r6 = r4.n
            net.one97.paytm.wallet.newdesign.nearby.a.c$1 r7 = new net.one97.paytm.wallet.newdesign.nearby.a.c$1
            r7.<init>(r1)
            r6.setListener(r7)
            net.one97.paytm.common.widgets.CircularImageView r6 = r4.f71024a
            int r7 = net.one97.paytm.wallet.newdesign.R.drawable.nearby
            r6.setImageResource(r7)
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r6 = r2.cashPointsDetail
            java.lang.String r6 = r6.logoUrl
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r7 = 0
            if (r6 == 0) goto L_0x0059
            com.squareup.picasso.w r6 = com.squareup.picasso.w.a()
            java.lang.String r8 = "https://assetscdn.paytm.com/images/catalog/pg/nearby.jpg"
            com.squareup.picasso.aa r6 = r6.a((java.lang.String) r8)
            net.one97.paytm.common.widgets.CircularImageView r8 = r4.f71024a
            r6.a((android.widget.ImageView) r8, (com.squareup.picasso.e) r7)
            goto L_0x006a
        L_0x0059:
            com.squareup.picasso.w r6 = com.squareup.picasso.w.a()
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r8 = r2.cashPointsDetail
            java.lang.String r8 = r8.logoUrl
            com.squareup.picasso.aa r6 = r6.a((java.lang.String) r8)
            net.one97.paytm.common.widgets.CircularImageView r8 = r4.f71024a
            r6.a((android.widget.ImageView) r8, (com.squareup.picasso.e) r7)
        L_0x006a:
            android.widget.TextView r6 = r4.f71025b
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r7 = r2.cashPointsDetail
            java.lang.String r7 = r7.displayName
            r6.setText(r7)
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r6 = r2.cashPointsDetail
            java.lang.String r6 = r6.category
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r7 = 8
            if (r6 == 0) goto L_0x0085
            android.widget.TextView r6 = r4.f71026c
            r6.setVisibility(r7)
            goto L_0x0093
        L_0x0085:
            android.widget.TextView r6 = r4.f71026c
            r6.setVisibility(r5)
            android.widget.TextView r6 = r4.f71026c
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r8 = r2.cashPointsDetail
            java.lang.String r8 = r8.category
            r6.setText(r8)
        L_0x0093:
            java.lang.String r6 = r2.offerText
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00a8
            android.widget.TextView r6 = r4.f71029f
            r6.setVisibility(r5)
            android.widget.TextView r6 = r4.f71029f
            java.lang.String r8 = r2.offerText
            r6.setText(r8)
            goto L_0x00ad
        L_0x00a8:
            android.widget.TextView r6 = r4.f71029f
            r6.setVisibility(r7)
        L_0x00ad:
            android.widget.TextView r6 = r4.f71027d
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r8 = r2.cashPointsDetail
            java.util.ArrayList<java.lang.String> r8 = r8.address
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            if (r8 == 0) goto L_0x00e8
            int r10 = r8.size()
            if (r10 <= 0) goto L_0x00e8
            int r10 = r8.size()
            r11 = 0
        L_0x00c5:
            if (r11 >= r10) goto L_0x00e8
            java.lang.Object r12 = r8.get(r11)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x00dc
            java.lang.Object r12 = r8.get(r11)
            java.lang.String r12 = (java.lang.String) r12
            r9.append(r12)
        L_0x00dc:
            int r12 = r10 + -1
            if (r11 >= r12) goto L_0x00e5
            java.lang.String r12 = " "
            r9.append(r12)
        L_0x00e5:
            int r11 = r11 + 1
            goto L_0x00c5
        L_0x00e8:
            java.lang.String r8 = r9.toString()
            r6.setText(r8)
            android.widget.TextView r6 = r4.f71028e
            java.lang.Object[] r8 = new java.lang.Object[r3]
            java.text.DecimalFormat r9 = new java.text.DecimalFormat
            java.lang.String r10 = "##.##"
            r9.<init>(r10)
            java.lang.Double r10 = r2.distanceFromLocation
            java.lang.String r9 = r9.format(r10)
            r8[r5] = r9
            java.lang.String r9 = "%s km"
            java.lang.String r8 = java.lang.String.format(r9, r8)
            r6.setText(r8)
            android.widget.TextView r6 = r4.f71030g
            boolean r8 = r2.isPreferable
            if (r8 == 0) goto L_0x0113
            r8 = 0
            goto L_0x0115
        L_0x0113:
            r8 = 8
        L_0x0115:
            r6.setVisibility(r8)
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r6 = r2.cashPointsDetail
            java.util.ArrayList<java.lang.String> r6 = r6.servicesOffered
            if (r6 == 0) goto L_0x01dd
            int r8 = r6.size()
            if (r8 <= 0) goto L_0x01dd
            r8 = 0
            r9 = 1
            r10 = 1
            r11 = 1
        L_0x0128:
            int r12 = r6.size()
            if (r8 >= r12) goto L_0x0177
            java.lang.Object r12 = r6.get(r8)
            java.lang.String r12 = (java.lang.String) r12
            int r14 = r12.hashCode()
            r15 = -905723548(0xffffffffca03c164, float:-2158681.0)
            r13 = 2
            if (r14 == r15) goto L_0x015d
            r15 = 205480262(0xc3f6146, float:1.4743377E-31)
            if (r14 == r15) goto L_0x0153
            r15 = 1508374999(0x59e7f9d7, float:8.1619277E15)
            if (r14 == r15) goto L_0x0149
            goto L_0x0167
        L_0x0149:
            java.lang.String r14 = "PAYMENT_POINT"
            boolean r12 = r12.equals(r14)
            if (r12 == 0) goto L_0x0167
            r12 = 2
            goto L_0x0168
        L_0x0153:
            java.lang.String r14 = "KYC_POINT"
            boolean r12 = r12.equals(r14)
            if (r12 == 0) goto L_0x0167
            r12 = 0
            goto L_0x0168
        L_0x015d:
            java.lang.String r14 = "CASH_POINT"
            boolean r12 = r12.equals(r14)
            if (r12 == 0) goto L_0x0167
            r12 = 1
            goto L_0x0168
        L_0x0167:
            r12 = -1
        L_0x0168:
            if (r12 == 0) goto L_0x0173
            if (r12 == r3) goto L_0x0171
            if (r12 == r13) goto L_0x016f
            goto L_0x0174
        L_0x016f:
            r9 = 0
            goto L_0x0174
        L_0x0171:
            r10 = 0
            goto L_0x0174
        L_0x0173:
            r11 = 0
        L_0x0174:
            int r8 = r8 + 1
            goto L_0x0128
        L_0x0177:
            if (r9 == 0) goto L_0x0183
            if (r10 == 0) goto L_0x0183
            if (r11 == 0) goto L_0x0183
            net.one97.paytm.wallet.newdesign.widget.ExpandableLinearLayout r6 = r4.n
            r6.setVisibility(r7)
            goto L_0x01af
        L_0x0183:
            net.one97.paytm.wallet.newdesign.widget.ExpandableLinearLayout r6 = r4.n
            r6.setVisibility(r5)
            if (r9 == 0) goto L_0x0190
            android.widget.TextView r6 = r4.f71031h
            r6.setVisibility(r7)
            goto L_0x0195
        L_0x0190:
            android.widget.TextView r6 = r4.f71031h
            r6.setVisibility(r5)
        L_0x0195:
            if (r10 == 0) goto L_0x019d
            android.widget.TextView r6 = r4.f71032i
            r6.setVisibility(r7)
            goto L_0x01a2
        L_0x019d:
            android.widget.TextView r6 = r4.f71032i
            r6.setVisibility(r5)
        L_0x01a2:
            if (r11 == 0) goto L_0x01aa
            android.widget.TextView r6 = r4.j
            r6.setVisibility(r7)
            goto L_0x01af
        L_0x01aa:
            android.widget.TextView r6 = r4.j
            r6.setVisibility(r5)
        L_0x01af:
            if (r9 != 0) goto L_0x01e7
            if (r10 != 0) goto L_0x01e7
            if (r11 != 0) goto L_0x01e7
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r8 = -2
            r9 = 1103626240(0x41c80000, float:25.0)
            android.content.Context r10 = r0.f71017c
            android.content.res.Resources r10 = r10.getResources()
            android.util.DisplayMetrics r10 = r10.getDisplayMetrics()
            float r9 = android.util.TypedValue.applyDimension(r3, r9, r10)
            int r9 = (int) r9
            r6.<init>(r8, r9)
            r8 = 3
            int r9 = net.one97.paytm.wallet.newdesign.R.id.tv_pay_with_paytm
            r6.addRule(r8, r9)
            r8 = 10
            r6.setMargins(r5, r8, r5, r5)
            android.widget.TextView r8 = r4.j
            r8.setLayoutParams(r6)
            goto L_0x01e7
        L_0x01dd:
            net.one97.paytm.wallet.newdesign.widget.ExpandableLinearLayout r6 = r4.n
            r6.setVisibility(r7)
            android.widget.TextView r6 = r4.f71030g
            r6.setVisibility(r7)
        L_0x01e7:
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r6 = r2.cashPointsDetail
            java.util.ArrayList<java.lang.String> r6 = r6.contactNo
            if (r6 == 0) goto L_0x0211
            net.one97.paytm.wallet.newdesign.nearby.datamodals.PayTMPartnerListModal$CashPointDetail r2 = r2.cashPointsDetail
            java.util.ArrayList<java.lang.String> r2 = r2.contactNo
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0211
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            r6 = 11
            int r2 = r2.get(r6)
            if (r2 < r6) goto L_0x0208
            r6 = 19
            if (r2 > r6) goto L_0x0208
            goto L_0x0209
        L_0x0208:
            r3 = 0
        L_0x0209:
            if (r3 == 0) goto L_0x0211
            android.widget.LinearLayout r2 = r4.k
            r2.setVisibility(r5)
            goto L_0x0216
        L_0x0211:
            android.widget.LinearLayout r2 = r4.k
            r2.setVisibility(r7)
        L_0x0216:
            android.widget.LinearLayout r2 = r4.k
            r2.setOnClickListener(r0)
            android.widget.LinearLayout r2 = r4.l
            r2.setOnClickListener(r0)
            android.widget.TextView r2 = r4.f71029f
            r2.setOnClickListener(r0)
            android.widget.RelativeLayout r2 = r4.m
            net.one97.paytm.wallet.newdesign.nearby.a.-$$Lambda$c$eF8cx2-FpnxVcmStIJqtlvTXyHc r3 = new net.one97.paytm.wallet.newdesign.nearby.a.-$$Lambda$c$eF8cx2-FpnxVcmStIJqtlvTXyHc
            r3.<init>()
            r2.setOnClickListener(r3)
            android.widget.LinearLayout r2 = r4.k
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
            r2.setTag(r3)
            android.widget.LinearLayout r2 = r4.l
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
            r2.setTag(r3)
            android.widget.TextView r2 = r4.f71029f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            r2.setTag(r1)
        L_0x024a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.nearby.a.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, View view) {
        ExpandableLinearLayout expandableLinearLayout = aVar.n;
        long j = (long) expandableLinearLayout.f71473a;
        TimeInterpolator timeInterpolator = expandableLinearLayout.f71474b;
        if (expandableLinearLayout.f71475c < expandableLinearLayout.getCurrentPosition()) {
            if (expandableLinearLayout.f71477e) {
                return;
            }
            if (j <= 0) {
                expandableLinearLayout.a(expandableLinearLayout.f71475c, j, timeInterpolator);
            } else {
                expandableLinearLayout.a(expandableLinearLayout.getCurrentPosition(), expandableLinearLayout.f71475c, j, timeInterpolator).start();
            }
        } else if (expandableLinearLayout.f71477e) {
        } else {
            if (j <= 0) {
                expandableLinearLayout.a(expandableLinearLayout.f71476d, j, timeInterpolator);
            } else {
                expandableLinearLayout.a(expandableLinearLayout.getCurrentPosition(), expandableLinearLayout.f71476d, j, timeInterpolator).start();
            }
        }
    }

    public final void a() {
        Fragment fragment = this.f71018d;
        if (fragment == null) {
            return;
        }
        if (fragment instanceof net.one97.paytm.wallet.newdesign.nearby.b.c) {
            this.f71021g = "Pay with Paytm";
        } else if (fragment instanceof net.one97.paytm.wallet.newdesign.nearby.b.a) {
            this.f71021g = "Add Cash";
        } else if (fragment instanceof e) {
            this.f71021g = "Upgrade Account";
        } else if (fragment instanceof d) {
            try {
                this.f71021g = ((d) fragment).f71077a;
            } catch (Exception unused) {
            }
        }
    }

    public final int getItemCount() {
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.f71016b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.f71016b;
        return (arrayList == null || arrayList.get(i2) != null) ? 1 : 0;
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_nearby_distance) {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("new_wallet_screen_type", "nearby");
                    hashMap.put("new_wallet_nearby_tab_name", this.f71021g);
                    d.a aVar = net.one97.paytm.wallet.newdesign.nearby.helper.d.f71130b;
                    d.a.b().a("new_wallet_nearby_distance_icon_clicked", (HashMap<String, Object>) hashMap, this.f71017c);
                } catch (Exception unused) {
                }
                int intValue = ((Integer) tag).intValue();
                if (this.f71016b.get(intValue).cashPointsDetail.location != null && this.f71016b.get(intValue).cashPointsDetail.location.lat != null && this.f71016b.get(intValue).cashPointsDetail.location.lon != null) {
                    net.one97.paytm.wallet.newdesign.nearby.b.a();
                    net.one97.paytm.wallet.newdesign.nearby.b.a(this.f71016b.get(intValue).cashPointsDetail.location.lat, this.f71016b.get(intValue).cashPointsDetail.location.lon, this.f71017c);
                }
            }
        } else if (id == R.id.ll_nearby_call) {
            Object tag2 = view.getTag();
            int i2 = Calendar.getInstance().get(11);
            if (!(i2 >= 9 && i2 <= 20)) {
                Fragment fragment = this.f71018d;
                if (fragment != null && fragment.getActivity() != null && !this.f71018d.getActivity().isFinishing() && (this.f71018d.getActivity() instanceof NearByMainActivity)) {
                    ((NearByMainActivity) this.f71018d.getActivity()).i();
                }
            } else if (tag2 instanceof Integer) {
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("new_wallet_screen_type", "nearby");
                    hashMap2.put("new_wallet_nearby_tab_name", this.f71021g);
                    d.a aVar2 = net.one97.paytm.wallet.newdesign.nearby.helper.d.f71130b;
                    d.a.b().a("new_wallet_nearby_call_clicked", (HashMap<String, Object>) hashMap2, this.f71017c);
                } catch (Exception unused2) {
                }
                PayTMPartnerListModal.Response response = this.f71016b.get(((Integer) tag2).intValue());
                if (response.cashPointsDetail.contactNo != null && response.cashPointsDetail.contactNo.size() > 0) {
                    this.f71017c.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(response.cashPointsDetail.contactNo.get(0))))));
                }
            }
        } else if (id == R.id.tv_deal_offer) {
            Object tag3 = view.getTag();
            if (tag3 instanceof Integer) {
                PayTMPartnerListModal.Response response2 = this.f71016b.get(((Integer) tag3).intValue());
                if (response2 instanceof PayTMPartnerListModal.Response) {
                    CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                    cJRHomePageItem.setUrl(response2.dealUrl);
                    cJRHomePageItem.setName(response2.offerText);
                    String uRLType = response2.getURLType();
                    if (response2 != null) {
                        String str = response2.dealUrl;
                        if (!TextUtils.isEmpty(str) && str.startsWith("paytmmp://")) {
                            a(uRLType);
                        } else if (Patterns.WEB_URL.matcher(str).matches() && uRLType != null && !TextUtils.isEmpty(uRLType) && str != null && URLUtil.isValidUrl(str)) {
                            if (uRLType.equalsIgnoreCase(CLPConstants.URL_TYPE_EMBED)) {
                                a(uRLType);
                            } else if ((uRLType.equalsIgnoreCase(CLPConstants.DEFAULT_GRID_VIEW_TYPE) || uRLType.equalsIgnoreCase("product")) && str != null && URLUtil.isValidUrl(str)) {
                                a(uRLType);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        this.f71020f.clear();
        for (int i2 = 0; i2 < this.f71016b.size(); i2++) {
            this.f71020f.append(i2, false);
        }
    }

    public final void a(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.f71020f.append(i3, false);
        }
    }

    public final void a(ArrayList<PayTMPartnerListModal.Response> arrayList) {
        this.f71016b = new ArrayList<>(arrayList);
        b();
        a();
        notifyDataSetChanged();
    }

    public final void c() {
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.f71016b;
        if (arrayList != null) {
            arrayList.clear();
            b();
            notifyDataSetChanged();
        }
    }

    public class b extends RecyclerView.v {
        public b(View view) {
            super(view);
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        CircularImageView f71024a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71025b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71026c;

        /* renamed from: d  reason: collision with root package name */
        TextView f71027d;

        /* renamed from: e  reason: collision with root package name */
        TextView f71028e;

        /* renamed from: f  reason: collision with root package name */
        TextView f71029f;

        /* renamed from: g  reason: collision with root package name */
        TextView f71030g;

        /* renamed from: h  reason: collision with root package name */
        TextView f71031h;

        /* renamed from: i  reason: collision with root package name */
        TextView f71032i;
        TextView j;
        LinearLayout k;
        LinearLayout l;
        RelativeLayout m;
        ExpandableLinearLayout n;

        public a(View view) {
            super(view);
            this.f71024a = (CircularImageView) view.findViewById(R.id.iv_nearby_icon);
            this.f71025b = (TextView) view.findViewById(R.id.tv_nearby_row_brand_name);
            this.f71030g = (TextView) view.findViewById(R.id.tv_recommended);
            this.f71026c = (TextView) view.findViewById(R.id.tv_nearby_row_brandcategory_type);
            this.f71027d = (TextView) view.findViewById(R.id.tv_nearby_row_brand_address);
            this.f71029f = (TextView) view.findViewById(R.id.tv_deal_offer);
            this.f71028e = (TextView) view.findViewById(R.id.tv_nearby_distance);
            this.f71031h = (TextView) view.findViewById(R.id.tv_pay_with_paytm);
            this.f71032i = (TextView) view.findViewById(R.id.tv_add_cash);
            this.j = (TextView) view.findViewById(R.id.tv_upgrade_account);
            this.k = (LinearLayout) view.findViewById(R.id.ll_nearby_call);
            this.m = (RelativeLayout) view.findViewById(R.id.rl_nearby_item);
            this.l = (LinearLayout) view.findViewById(R.id.ll_nearby_distance);
            this.n = (ExpandableLinearLayout) view.findViewById(R.id.el_nearby_services);
        }
    }

    private void a(String str) {
        Fragment fragment = this.f71018d;
        if (fragment != null && !fragment.isDetached() && !TextUtils.isEmpty(str)) {
            str.equalsIgnoreCase("nolink");
        }
    }
}
