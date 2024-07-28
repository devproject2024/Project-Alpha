package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;

public final class k extends i implements TextWatcher {
    EditText u;
    private String v;
    private TextView w;
    private ScrollView x;
    private HashMap y;

    public final View b(int i2) {
        if (this.y == null) {
            this.y = new HashMap();
        }
        View view = (View) this.y.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.y.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: protected */
    public final void o() {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        s();
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void s() {
        HashMap hashMap = this.y;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_metro_svp_ticket_purchase, viewGroup, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0146 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x01ba A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d0 A[Catch:{ NullPointerException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00da A[Catch:{ NullPointerException -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r14, android.os.Bundle r15) {
        /*
            r13 = this;
            java.lang.String r15 = "it"
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r14, r0)
            int r0 = net.one97.paytm.recharge.R.id.proceed_btn
            android.view.View r0 = r14.findViewById(r0)
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
            if (r0 == 0) goto L_0x0432
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.a((android.widget.TextView) r0)
            int r0 = net.one97.paytm.recharge.R.id.radio_fast_forward
            android.view.View r0 = r14.findViewById(r0)
            if (r0 == 0) goto L_0x042a
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r13.a((android.widget.CheckBox) r0)
            int r0 = net.one97.paytm.recharge.R.id.loading_threedots_view
            android.view.View r0 = r14.findViewById(r0)
            if (r0 == 0) goto L_0x0422
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r13.a((android.widget.RelativeLayout) r0)
            int r0 = net.one97.paytm.recharge.R.id.loading_threedots_lav
            android.view.View r0 = r14.findViewById(r0)
            if (r0 == 0) goto L_0x041a
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            r13.a((com.airbnb.lottie.LottieAnimationView) r0)
            int r0 = net.one97.paytm.recharge.R.id.transparent_view
            android.view.View r0 = r14.findViewById(r0)
            if (r0 == 0) goto L_0x0412
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r13.a((android.widget.FrameLayout) r0)
            int r0 = net.one97.paytm.recharge.R.id.txt_amount
            android.view.View r0 = r14.findViewById(r0)
            if (r0 == 0) goto L_0x040a
            android.widget.EditText r0 = (android.widget.EditText) r0
            r13.u = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_tips
            android.view.View r0 = r14.findViewById(r0)
            if (r0 == 0) goto L_0x0404
            android.widget.TextView r0 = (android.widget.TextView) r0
            r13.w = r0
            android.widget.EditText r0 = r13.u
            r2 = 0
            if (r0 == 0) goto L_0x006a
            r0.setTransformationMethod(r2)
        L_0x006a:
            int r0 = net.one97.paytm.recharge.R.id.scroll_view
            android.view.View r0 = r14.findViewById(r0)
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r13.x = r0
            r0 = 5
            r3 = 1
            r4 = 0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = r13.f63367b     // Catch:{ NullPointerException -> 0x00e0 }
            if (r5 == 0) goto L_0x00cd
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r5 = r5.getProduct()     // Catch:{ NullPointerException -> 0x00e0 }
            if (r5 == 0) goto L_0x00cd
            java.util.List r5 = r5.getInputFields()     // Catch:{ NullPointerException -> 0x00e0 }
            if (r5 == 0) goto L_0x00cd
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ NullPointerException -> 0x00e0 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ NullPointerException -> 0x00e0 }
            r6.<init>()     // Catch:{ NullPointerException -> 0x00e0 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ NullPointerException -> 0x00e0 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ NullPointerException -> 0x00e0 }
        L_0x0094:
            boolean r7 = r5.hasNext()     // Catch:{ NullPointerException -> 0x00e0 }
            if (r7 == 0) goto L_0x00b4
            java.lang.Object r7 = r5.next()     // Catch:{ NullPointerException -> 0x00e0 }
            r8 = r7
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r8 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r8     // Catch:{ NullPointerException -> 0x00e0 }
            java.lang.String r9 = "Amount"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r15)     // Catch:{ NullPointerException -> 0x00e0 }
            java.lang.String r8 = r8.getType()     // Catch:{ NullPointerException -> 0x00e0 }
            boolean r8 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r8, (boolean) r3)     // Catch:{ NullPointerException -> 0x00e0 }
            if (r8 == 0) goto L_0x0094
            r6.add(r7)     // Catch:{ NullPointerException -> 0x00e0 }
            goto L_0x0094
        L_0x00b4:
            java.util.List r6 = (java.util.List) r6     // Catch:{ NullPointerException -> 0x00e0 }
            java.lang.Object r5 = r6.get(r4)     // Catch:{ NullPointerException -> 0x00e0 }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r5 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r5     // Catch:{ NullPointerException -> 0x00e0 }
            if (r5 == 0) goto L_0x00cd
            java.lang.String r5 = r5.getMax()     // Catch:{ NullPointerException -> 0x00e0 }
            if (r5 == 0) goto L_0x00cd
            int r5 = r5.length()     // Catch:{ NullPointerException -> 0x00e0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ NullPointerException -> 0x00e0 }
            goto L_0x00ce
        L_0x00cd:
            r5 = r2
        L_0x00ce:
            if (r5 != 0) goto L_0x00d3
            kotlin.g.b.k.a()     // Catch:{ NullPointerException -> 0x00e0 }
        L_0x00d3:
            int r6 = r5.intValue()     // Catch:{ NullPointerException -> 0x00e0 }
            r7 = 4
            if (r6 <= r7) goto L_0x00e1
            int r0 = r5.intValue()     // Catch:{ NullPointerException -> 0x00e0 }
            int r0 = r0 + r3
            goto L_0x00e1
        L_0x00e0:
        L_0x00e1:
            android.widget.EditText r5 = r13.u
            if (r5 == 0) goto L_0x00f3
            android.text.InputFilter[] r6 = new android.text.InputFilter[r3]
            android.text.InputFilter$LengthFilter r7 = new android.text.InputFilter$LengthFilter
            r7.<init>(r0)
            android.text.InputFilter r7 = (android.text.InputFilter) r7
            r6[r4] = r7
            r5.setFilters(r6)
        L_0x00f3:
            android.os.Bundle r0 = r13.getArguments()
            if (r0 == 0) goto L_0x010e
            java.lang.String r5 = "fast_forward"
            boolean r0 = r0.getBoolean(r5, r4)
            if (r0 != r3) goto L_0x010e
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r0 = r14.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x010e
            r0.setVisibility(r4)
        L_0x010e:
            int r0 = net.one97.paytm.recharge.R.id.txt_heading
            android.view.View r0 = r14.findViewById(r0)
            if (r0 == 0) goto L_0x03fe
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = r13.f63367b
            if (r1 == 0) goto L_0x0121
            java.lang.String r1 = r1.getFilterName()
            goto L_0x0122
        L_0x0121:
            r1 = r2
        L_0x0122:
            java.lang.String r5 = "Delhi Metro"
            boolean r1 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r4)
            if (r1 == 0) goto L_0x0131
            net.one97.paytm.recharge.metro.f.c$a r1 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r1 = net.one97.paytm.recharge.metro.f.c.j
            goto L_0x018f
        L_0x0131:
            net.one97.paytm.recharge.metro.f.c$a r1 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r1 = net.one97.paytm.recharge.metro.f.c.f63584i
            if (r1 == 0) goto L_0x018e
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r1 = r1.iterator()
        L_0x0146:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x018a
            java.lang.Object r7 = r1.next()
            r8 = r7
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r8 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r8
            boolean r9 = r8.isPass()
            if (r9 == 0) goto L_0x0183
            net.one97.paytm.recharge.metro.f.c$d r9 = net.one97.paytm.recharge.metro.f.c.d.MUMBAI_METRO_SVP
            int r9 = r9.getValue()
            net.one97.paytm.recharge.metro.f.c$d$a r10 = net.one97.paytm.recharge.metro.f.c.d.Companion
            java.lang.String r10 = r8.getProductType()
            int r10 = net.one97.paytm.recharge.metro.f.c.d.a.a((java.lang.String) r10)
            if (r9 != r10) goto L_0x0183
            long r8 = r8.getProductId()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r10 = r13.f63367b
            if (r10 == 0) goto L_0x0183
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r10 = r10.getProduct()
            if (r10 == 0) goto L_0x0183
            long r10 = r10.getId()
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0183
            r8 = 1
            goto L_0x0184
        L_0x0183:
            r8 = 0
        L_0x0184:
            if (r8 == 0) goto L_0x0146
            r6.add(r7)
            goto L_0x0146
        L_0x018a:
            r1 = r6
            java.util.List r1 = (java.util.List) r1
            goto L_0x018f
        L_0x018e:
            r1 = r2
        L_0x018f:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r6 = r13.f63367b
            if (r6 == 0) goto L_0x0198
            java.lang.String r6 = r6.getFilterName()
            goto L_0x0199
        L_0x0198:
            r6 = r2
        L_0x0199:
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r4)
            if (r5 == 0) goto L_0x01a5
            net.one97.paytm.recharge.metro.f.c$a r5 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List unused = net.one97.paytm.recharge.metro.f.c.j
            goto L_0x01fe
        L_0x01a5:
            net.one97.paytm.recharge.metro.f.c$a r5 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r5 = net.one97.paytm.recharge.metro.f.c.f63584i
            if (r5 == 0) goto L_0x01fe
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x01ba:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x01fe
            java.lang.Object r7 = r5.next()
            r8 = r7
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r8 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r8
            java.util.List r9 = r8.getQrCodes()
            if (r9 == 0) goto L_0x01f7
            net.one97.paytm.recharge.metro.f.c$d r9 = net.one97.paytm.recharge.metro.f.c.d.MUMBAI_METRO_SVP
            int r9 = r9.getValue()
            net.one97.paytm.recharge.metro.f.c$d$a r10 = net.one97.paytm.recharge.metro.f.c.d.Companion
            java.lang.String r10 = r8.getProductType()
            int r10 = net.one97.paytm.recharge.metro.f.c.d.a.a((java.lang.String) r10)
            if (r9 != r10) goto L_0x01f7
            long r8 = r8.getProductId()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r10 = r13.f63367b
            if (r10 == 0) goto L_0x01f7
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r10 = r10.getProduct()
            if (r10 == 0) goto L_0x01f7
            long r10 = r10.getId()
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x01f7
            r8 = 1
            goto L_0x01f8
        L_0x01f7:
            r8 = 0
        L_0x01f8:
            if (r8 == 0) goto L_0x01ba
            r6.add(r7)
            goto L_0x01ba
        L_0x01fe:
            java.lang.String r5 = "0"
            if (r1 == 0) goto L_0x0216
            boolean r6 = r1.isEmpty()
            if (r6 != 0) goto L_0x0216
            java.lang.Object r6 = r1.get(r4)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r6
            java.lang.String r6 = r6.getBalanceAmount()
            if (r6 != 0) goto L_0x0215
            goto L_0x0216
        L_0x0215:
            r5 = r6
        L_0x0216:
            int r6 = net.one97.paytm.recharge.R.string.metro_svp_current_balance
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r7[r4] = r5
            java.lang.String r6 = r13.getString(r6, r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            r0.setVisibility(r4)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r6 = r13.f63367b     // Catch:{ Exception -> 0x0264 }
            if (r6 == 0) goto L_0x023e
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r6 = r6.getProduct()     // Catch:{ Exception -> 0x0264 }
            if (r6 == 0) goto L_0x023e
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r6 = r6.getAttributes()     // Catch:{ Exception -> 0x0264 }
            if (r6 == 0) goto L_0x023e
            java.lang.String r6 = r6.getMin_bal()     // Catch:{ Exception -> 0x0264 }
            if (r6 != 0) goto L_0x0240
        L_0x023e:
            java.lang.String r6 = "20"
        L_0x0240:
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x0264 }
            if (r1 == 0) goto L_0x026c
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0264 }
            if (r1 != 0) goto L_0x026c
            if (r5 == 0) goto L_0x026c
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0264 }
            int r1 = r1.length()     // Catch:{ Exception -> 0x0264 }
            if (r1 != 0) goto L_0x0259
            r1 = 1
            goto L_0x025a
        L_0x0259:
            r1 = 0
        L_0x025a:
            if (r1 != 0) goto L_0x026c
            int r1 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0264 }
            if (r1 >= r6) goto L_0x026c
            r1 = 1
            goto L_0x026d
        L_0x0264:
            r1 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r5 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r5.debugLogExceptions(r1)
        L_0x026c:
            r1 = 0
        L_0x026d:
            r5 = 8
            if (r1 == 0) goto L_0x0273
            r1 = 0
            goto L_0x0275
        L_0x0273:
            r1 = 8
        L_0x0275:
            r0.setVisibility(r1)
            kotlin.x r0 = kotlin.x.f47997a
            android.widget.TextView r0 = r13.w
            if (r0 != 0) goto L_0x0281
            kotlin.g.b.k.a()
        L_0x0281:
            r0.setVisibility(r4)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = r13.f63367b
            java.lang.String r6 = "amount"
            if (r1 == 0) goto L_0x02d0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r1 = r1.getProduct()
            if (r1 == 0) goto L_0x02d0
            java.util.List r1 = r1.getInputFields()
            if (r1 == 0) goto L_0x02d0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r1 = r1.iterator()
        L_0x02a3:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x02c1
            java.lang.Object r8 = r1.next()
            r9 = r8
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r9 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r15)
            java.lang.String r9 = r9.getType()
            boolean r9 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r9, (boolean) r3)
            if (r9 == 0) goto L_0x02a3
            r7.add(r8)
            goto L_0x02a3
        L_0x02c1:
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r1 = r7.get(r4)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r1 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r1
            if (r1 == 0) goto L_0x02d0
            java.lang.String r1 = r1.getMax()
            goto L_0x02d1
        L_0x02d0:
            r1 = r2
        L_0x02d1:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r7 = r13.f63367b
            if (r7 == 0) goto L_0x031b
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r7 = r7.getProduct()
            if (r7 == 0) goto L_0x031b
            java.util.List r7 = r7.getInputFields()
            if (r7 == 0) goto L_0x031b
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x02ee:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x030c
            java.lang.Object r9 = r7.next()
            r10 = r9
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r10 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r10
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r15)
            java.lang.String r10 = r10.getType()
            boolean r10 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r10, (boolean) r3)
            if (r10 == 0) goto L_0x02ee
            r8.add(r9)
            goto L_0x02ee
        L_0x030c:
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r15 = r8.get(r4)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r15 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r15
            if (r15 == 0) goto L_0x031b
            java.lang.String r15 = r15.getMin()
            goto L_0x031c
        L_0x031b:
            r15 = r2
        L_0x031c:
            int r6 = net.one97.paytm.recharge.R.string.recharge_txt_tip
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r15 = com.paytm.utility.b.x((java.lang.String) r15)
            r7[r4] = r15
            java.lang.String r15 = com.paytm.utility.b.x((java.lang.String) r1)
            r7[r3] = r15
            java.lang.String r15 = r13.getString(r6, r7)
            r13.v = r15
            java.lang.String r15 = r13.v
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r0.setText(r15)
            android.content.Context r15 = r0.getContext()
            int r6 = net.one97.paytm.recharge.R.color.color_999999
            int r15 = androidx.core.content.b.c(r15, r6)
            r0.setTextColor(r15)
            r15 = r1
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            if (r15 == 0) goto L_0x0354
            int r15 = r15.length()
            if (r15 != 0) goto L_0x0353
            goto L_0x0354
        L_0x0353:
            r3 = 0
        L_0x0354:
            if (r3 != 0) goto L_0x0362
            double r6 = java.lang.Double.parseDouble(r1)
            r8 = 0
            int r15 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r15 == 0) goto L_0x0362
            r15 = 0
            goto L_0x0364
        L_0x0362:
            r15 = 8
        L_0x0364:
            r0.setVisibility(r15)
            kotlin.x r15 = kotlin.x.f47997a
            int r15 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r15 = r14.findViewById(r15)
            if (r15 == 0) goto L_0x03f6
            androidx.recyclerview.widget.RecyclerView r15 = (androidx.recyclerview.widget.RecyclerView) r15
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = r13.f63367b
            if (r0 == 0) goto L_0x0395
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = r0.getProduct()
            if (r0 == 0) goto L_0x0395
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x0395
            java.lang.String r0 = r0.getAmountButtonList()
            if (r0 == 0) goto L_0x0395
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = ","
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.util.List r2 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.String[]) r1)
        L_0x0395:
            if (r2 == 0) goto L_0x039c
            int r0 = r2.size()
            goto L_0x039d
        L_0x039c:
            r0 = 0
        L_0x039d:
            if (r0 != 0) goto L_0x03a0
            goto L_0x03a1
        L_0x03a0:
            r5 = 0
        L_0x03a1:
            r15.setVisibility(r5)
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r1 = r15.getContext()
            r0.<init>(r1, r4, r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r15.setLayoutManager(r0)
            net.one97.paytm.recharge.metro.c.k$b r0 = new net.one97.paytm.recharge.metro.c.k$b
            r0.<init>(r15, r2, r13, r14)
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r15.setAdapter(r0)
            net.one97.paytm.recharge.metro.c.k$c r14 = new net.one97.paytm.recharge.metro.c.k$c
            r14.<init>()
            androidx.recyclerview.widget.RecyclerView$h r14 = (androidx.recyclerview.widget.RecyclerView.h) r14
            r15.addItemDecoration(r14)
            kotlin.x r14 = kotlin.x.f47997a
            android.widget.TextView r14 = r13.b()
            r14.setEnabled(r4)
            android.widget.ScrollView r14 = r13.x
            if (r14 == 0) goto L_0x03df
            net.one97.paytm.recharge.metro.c.k$d r15 = new net.one97.paytm.recharge.metro.c.k$d
            r15.<init>(r13)
            android.view.View$OnTouchListener r15 = (android.view.View.OnTouchListener) r15
            r14.setOnTouchListener(r15)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x03df:
            android.widget.CheckBox r14 = r13.e()
            net.one97.paytm.recharge.metro.c.k$e r15 = new net.one97.paytm.recharge.metro.c.k$e
            r15.<init>(r13)
            android.widget.CompoundButton$OnCheckedChangeListener r15 = (android.widget.CompoundButton.OnCheckedChangeListener) r15
            r14.setOnCheckedChangeListener(r15)
            r13.h()
            net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder r14 = r13.f63369d
            r13.b((net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder) r14)
            return
        L_0x03f6:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView"
            r14.<init>(r15)
            throw r14
        L_0x03fe:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r1)
            throw r14
        L_0x0404:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r1)
            throw r14
        L_0x040a:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type android.widget.EditText"
            r14.<init>(r15)
            throw r14
        L_0x0412:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type android.widget.FrameLayout"
            r14.<init>(r15)
            throw r14
        L_0x041a:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView"
            r14.<init>(r15)
            throw r14
        L_0x0422:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type android.widget.RelativeLayout"
            r14.<init>(r15)
            throw r14
        L_0x042a:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type android.widget.CheckBox"
            r14.<init>(r15)
            throw r14
        L_0x0432:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r1)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.k.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public static final class b extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView f63393a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f63394b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f63395c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f63396d;

        b(RecyclerView recyclerView, List list, k kVar, View view) {
            this.f63393a = recyclerView;
            this.f63394b = list;
            this.f63395c = kVar;
            this.f63396d = view;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
            a aVar = (a) vVar;
            kotlin.g.b.k.c(aVar, "holder");
            TextView textView = aVar.f63391a;
            k kVar = this.f63395c;
            int i3 = R.string.rupee;
            Object[] objArr = new Object[1];
            List list = this.f63394b;
            if (list == null) {
                kotlin.g.b.k.a();
            }
            objArr[0] = com.paytm.utility.b.x((String) list.get(i2));
            textView.setText(kVar.getString(i3, objArr));
            aVar.f63391a.setOnClickListener(new View.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f63397a;

                {
                    this.f63397a = r1;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
                    r0 = r0.getText();
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onClick(android.view.View r3) {
                    /*
                        r2 = this;
                        net.one97.paytm.recharge.metro.c.k$b r3 = r2.f63397a
                        android.view.View r3 = r3.f63396d
                        int r0 = net.one97.paytm.recharge.R.id.txt_amount
                        android.view.View r3 = r3.findViewById(r0)
                        if (r3 == 0) goto L_0x0086
                        android.widget.TextView r3 = (android.widget.TextView) r3
                        net.one97.paytm.recharge.metro.c.k$b r0 = r2.f63397a
                        java.util.List r0 = r0.f63394b
                        int r1 = r8
                        java.lang.Object r0 = r0.get(r1)
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        r3.setText(r0)
                        net.one97.paytm.recharge.metro.c.k$b r3 = r2.f63397a
                        net.one97.paytm.recharge.metro.c.k r3 = r3.f63395c
                        android.widget.EditText r3 = r3.u
                        if (r3 == 0) goto L_0x0049
                        net.one97.paytm.recharge.metro.c.k$b r0 = r2.f63397a
                        net.one97.paytm.recharge.metro.c.k r0 = r0.f63395c
                        android.widget.EditText r0 = r0.u
                        if (r0 == 0) goto L_0x003c
                        android.text.Editable r0 = r0.getText()
                        if (r0 == 0) goto L_0x003c
                        int r0 = r0.length()
                        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                        goto L_0x003d
                    L_0x003c:
                        r0 = 0
                    L_0x003d:
                        if (r0 != 0) goto L_0x0042
                        kotlin.g.b.k.a()
                    L_0x0042:
                        int r0 = r0.intValue()
                        r3.setSelection(r0)
                    L_0x0049:
                        net.one97.paytm.recharge.metro.c.k$b r3 = r2.f63397a     // Catch:{ Exception -> 0x0085 }
                        androidx.recyclerview.widget.RecyclerView r3 = r3.f63393a     // Catch:{ Exception -> 0x0085 }
                        android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0085 }
                        java.lang.String r0 = "input_method"
                        java.lang.Object r3 = r3.getSystemService(r0)     // Catch:{ Exception -> 0x0085 }
                        if (r3 == 0) goto L_0x007d
                        android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3     // Catch:{ Exception -> 0x0085 }
                        net.one97.paytm.recharge.metro.c.k$b r0 = r2.f63397a     // Catch:{ Exception -> 0x0085 }
                        androidx.recyclerview.widget.RecyclerView r0 = r0.f63393a     // Catch:{ Exception -> 0x0085 }
                        android.os.IBinder r0 = r0.getWindowToken()     // Catch:{ Exception -> 0x0085 }
                        r1 = 0
                        r3.hideSoftInputFromWindow(r0, r1)     // Catch:{ Exception -> 0x0085 }
                        net.one97.paytm.recharge.metro.c.k$b r3 = r2.f63397a     // Catch:{ Exception -> 0x0085 }
                        net.one97.paytm.recharge.metro.c.k r3 = r3.f63395c     // Catch:{ Exception -> 0x0085 }
                        net.one97.paytm.recharge.metro.c.k$b r0 = r2.f63397a     // Catch:{ Exception -> 0x0085 }
                        java.util.List r0 = r0.f63394b     // Catch:{ Exception -> 0x0085 }
                        int r1 = r8     // Catch:{ Exception -> 0x0085 }
                        java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x0085 }
                        java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0085 }
                        java.lang.String r1 = "amount_capsule_selected"
                        r3.b(r0, r1)     // Catch:{ Exception -> 0x0085 }
                        return
                    L_0x007d:
                        kotlin.u r3 = new kotlin.u     // Catch:{ Exception -> 0x0085 }
                        java.lang.String r0 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
                        r3.<init>(r0)     // Catch:{ Exception -> 0x0085 }
                        throw r3     // Catch:{ Exception -> 0x0085 }
                    L_0x0085:
                        return
                    L_0x0086:
                        kotlin.u r3 = new kotlin.u
                        java.lang.String r0 = "null cannot be cast to non-null type android.widget.TextView"
                        r3.<init>(r0)
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.k.b.AnonymousClass1.onClick(android.view.View):void");
                }
            });
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            kotlin.g.b.k.c(viewGroup, "parent");
            k kVar = this.f63395c;
            View inflate = LayoutInflater.from(this.f63393a.getContext()).inflate(R.layout.content_recharge_amount_item, viewGroup, false);
            kotlin.g.b.k.a((Object) inflate, "LayoutInflater.from(cont…ount_item, parent, false)");
            return new a(kVar, inflate);
        }

        public final int getItemCount() {
            List list = this.f63394b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    public static final class c extends RecyclerView.h {
        c() {
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            kotlin.g.b.k.c(rect, "outRect");
            kotlin.g.b.k.c(view, "view");
            kotlin.g.b.k.c(recyclerView, "parent");
            kotlin.g.b.k.c(sVar, "state");
            rect.set(0, 0, com.paytm.utility.b.c(18), 0);
        }
    }

    public static final class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f63399a;

        d(k kVar) {
            this.f63399a = kVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            kotlin.g.b.k.c(view, "v");
            kotlin.g.b.k.c(motionEvent, "m");
            k.a(this.f63399a);
            return true;
        }
    }

    static final class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f63400a;

        e(k kVar) {
            this.f63400a = kVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            String str = z ? "fast_forward_checked" : "fast_forward_unchecked";
            Context context = this.f63400a.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            CJRUtilityVariantV2 cJRUtilityVariantV2 = this.f63400a.f63366a;
            String a2 = c.a.a(cJRUtilityVariantV2 != null ? cJRUtilityVariantV2.getFilterName() : null);
            String str2 = ab.f61496a;
            kotlin.g.b.k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, a2, str, "", "store_value_pass", str2, (Object) null, (Object) null, 96);
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        b().setOnClickListener(this);
        EditText editText = this.u;
        if (editText != null) {
            editText.addTextChangedListener(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.util.List} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0036 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject l() {
        /*
            r12 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = r12.f63367b
            r2 = 0
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = r1.getFilterName()
            goto L_0x0010
        L_0x000f:
            r1 = r2
        L_0x0010:
            r3 = 0
            java.lang.String r4 = "Delhi Metro"
            boolean r1 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r3)
            r4 = 1
            if (r1 == 0) goto L_0x0021
            net.one97.paytm.recharge.metro.f.c$a r1 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r1 = net.one97.paytm.recharge.metro.f.c.j
            goto L_0x007f
        L_0x0021:
            net.one97.paytm.recharge.metro.f.c$a r1 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List r1 = net.one97.paytm.recharge.metro.f.c.f63584i
            if (r1 == 0) goto L_0x007e
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r1 = r1.iterator()
        L_0x0036:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x007a
            java.lang.Object r6 = r1.next()
            r7 = r6
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
            boolean r8 = r7.isPass()
            if (r8 == 0) goto L_0x0073
            net.one97.paytm.recharge.metro.f.c$d r8 = net.one97.paytm.recharge.metro.f.c.d.MUMBAI_METRO_SVP
            int r8 = r8.getValue()
            net.one97.paytm.recharge.metro.f.c$d$a r9 = net.one97.paytm.recharge.metro.f.c.d.Companion
            java.lang.String r9 = r7.getProductType()
            int r9 = net.one97.paytm.recharge.metro.f.c.d.a.a((java.lang.String) r9)
            if (r8 != r9) goto L_0x0073
            long r7 = r7.getProductId()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r9 = r12.f63367b
            if (r9 == 0) goto L_0x0073
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r9 = r9.getProduct()
            if (r9 == 0) goto L_0x0073
            long r9 = r9.getId()
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0073
            r7 = 1
            goto L_0x0074
        L_0x0073:
            r7 = 0
        L_0x0074:
            if (r7 == 0) goto L_0x0036
            r5.add(r6)
            goto L_0x0036
        L_0x007a:
            r1 = r5
            java.util.List r1 = (java.util.List) r1
            goto L_0x007f
        L_0x007e:
            r1 = r2
        L_0x007f:
            if (r1 == 0) goto L_0x0091
            boolean r5 = r1.isEmpty()
            if (r5 != 0) goto L_0x0091
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r1 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r1
            java.lang.String r2 = r1.getPassId()
        L_0x0091:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x009c
            int r1 = r1.length()
            if (r1 != 0) goto L_0x009d
        L_0x009c:
            r3 = 1
        L_0x009d:
            if (r3 != 0) goto L_0x00ab
            java.lang.String r1 = "passId"
            r0.put(r1, r2)
            java.lang.String r1 = "operationType"
            java.lang.String r2 = "RELOAD"
            r0.put(r1, r2)
        L_0x00ab:
            net.one97.paytm.recharge.metro.f.c$a r1 = net.one97.paytm.recharge.metro.f.c.f63576a
            int r1 = net.one97.paytm.recharge.metro.f.c.f63577b
            java.lang.String r2 = "tokenType"
            r0.put(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.k.l():org.json.JSONObject");
    }

    public final void afterTextChanged(Editable editable) {
        if (p.b(String.valueOf(editable), "0", false)) {
            EditText editText = this.u;
            if (editText != null) {
                editText.setText("");
                return;
            }
            return;
        }
        b().setEnabled(true);
        TextView textView = this.w;
        if (textView != null) {
            textView.setText(this.v);
        }
        TextView textView2 = this.w;
        if (textView2 != null) {
            Context context = textView2 != null ? textView2.getContext() : null;
            if (context == null) {
                kotlin.g.b.k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(context, R.color.color_999999));
        }
        String a2 = ba.a(String.valueOf(editable), false);
        EditText editText2 = this.u;
        if (editText2 != null) {
            editText2.removeTextChangedListener(this);
        }
        if (editable != null) {
            editable.clear();
        }
        if (editable != null) {
            editable.append(a2);
        }
        EditText editText3 = this.u;
        if (editText3 != null) {
            editText3.addTextChangedListener(this);
        }
        if (editable != null) {
            if (!(editable.length() == 0)) {
                b().setText(getString(R.string.cart_proceed_to_pay, editable.toString()));
                b().setTag(ba.e(editable.toString()));
                b().setEnabled(true);
                b(editable.toString(), "amount_entered");
                return;
            }
        }
        b().setText(getString(R.string.proceed));
        b().setTag("0");
        b().setEnabled(false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ae A[Catch:{ Exception -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e4 A[Catch:{ Exception -> 0x011f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.u
            if (r0 == 0) goto L_0x0009
            android.text.Editable r0 = r0.getText()
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = net.one97.paytm.recharge.common.utils.ba.e((java.lang.String) r0)
            java.lang.String r1 = "enteredAmount"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 == 0) goto L_0x0036
            int r0 = net.one97.paytm.recharge.R.string.error_invalid_amount
            java.lang.String r0 = r10.getString(r0)
            java.lang.String r1 = "getString(R.string.error_invalid_amount)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r10.c(r0)
            return r3
        L_0x0036:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = r10.f63367b     // Catch:{ Exception -> 0x011f }
            java.lang.String r4 = "it"
            java.lang.String r5 = "Amount"
            if (r1 == 0) goto L_0x008a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r1 = r1.getProduct()     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x008a
            java.util.List r1 = r1.getInputFields()     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x008a
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x011f }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x011f }
            r6.<init>()     // Catch:{ Exception -> 0x011f }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x011f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x011f }
        L_0x0057:
            boolean r7 = r1.hasNext()     // Catch:{ Exception -> 0x011f }
            if (r7 == 0) goto L_0x0075
            java.lang.Object r7 = r1.next()     // Catch:{ Exception -> 0x011f }
            r8 = r7
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r8 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r8     // Catch:{ Exception -> 0x011f }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)     // Catch:{ Exception -> 0x011f }
            java.lang.String r8 = r8.getType()     // Catch:{ Exception -> 0x011f }
            boolean r8 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r8, (boolean) r2)     // Catch:{ Exception -> 0x011f }
            if (r8 == 0) goto L_0x0057
            r6.add(r7)     // Catch:{ Exception -> 0x011f }
            goto L_0x0057
        L_0x0075:
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception -> 0x011f }
            java.lang.Object r1 = r6.get(r3)     // Catch:{ Exception -> 0x011f }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r1 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r1     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x008a
            java.lang.String r1 = r1.getMin()     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x008a
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x011f }
            goto L_0x008b
        L_0x008a:
            r1 = 0
        L_0x008b:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r6 = r10.f63367b     // Catch:{ Exception -> 0x011f }
            if (r6 == 0) goto L_0x00db
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r6 = r6.getProduct()     // Catch:{ Exception -> 0x011f }
            if (r6 == 0) goto L_0x00db
            java.util.List r6 = r6.getInputFields()     // Catch:{ Exception -> 0x011f }
            if (r6 == 0) goto L_0x00db
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ Exception -> 0x011f }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x011f }
            r7.<init>()     // Catch:{ Exception -> 0x011f }
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ Exception -> 0x011f }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x011f }
        L_0x00a8:
            boolean r8 = r6.hasNext()     // Catch:{ Exception -> 0x011f }
            if (r8 == 0) goto L_0x00c6
            java.lang.Object r8 = r6.next()     // Catch:{ Exception -> 0x011f }
            r9 = r8
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r9 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r9     // Catch:{ Exception -> 0x011f }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)     // Catch:{ Exception -> 0x011f }
            java.lang.String r9 = r9.getType()     // Catch:{ Exception -> 0x011f }
            boolean r9 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r9, (boolean) r2)     // Catch:{ Exception -> 0x011f }
            if (r9 == 0) goto L_0x00a8
            r7.add(r8)     // Catch:{ Exception -> 0x011f }
            goto L_0x00a8
        L_0x00c6:
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x011f }
            java.lang.Object r4 = r7.get(r3)     // Catch:{ Exception -> 0x011f }
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2 r4 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityInputFieldsV2) r4     // Catch:{ Exception -> 0x011f }
            if (r4 == 0) goto L_0x00db
            java.lang.String r4 = r4.getMax()     // Catch:{ Exception -> 0x011f }
            if (r4 == 0) goto L_0x00db
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x011f }
            goto L_0x00dc
        L_0x00db:
            r4 = 0
        L_0x00dc:
            int r5 = r0.length()     // Catch:{ Exception -> 0x011f }
            r6 = 9
            if (r5 > r6) goto L_0x0108
            int r5 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x011f }
            if (r5 <= r4) goto L_0x00eb
            goto L_0x0108
        L_0x00eb:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x011f }
            if (r0 >= r1) goto L_0x011f
            int r0 = net.one97.paytm.recharge.R.string.min_allowed_amt     // Catch:{ Exception -> 0x011f }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x011f }
            r4[r3] = r1     // Catch:{ Exception -> 0x011f }
            java.lang.String r0 = r10.getString(r0, r4)     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = "getString(R.string.min_a…mt, minAmount.toString())"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x011f }
            r10.c(r0)     // Catch:{ Exception -> 0x011f }
            return r3
        L_0x0108:
            int r0 = net.one97.paytm.recharge.R.string.max_amt_allowed_is     // Catch:{ Exception -> 0x011f }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x011f }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x011f }
            r1[r3] = r4     // Catch:{ Exception -> 0x011f }
            java.lang.String r0 = r10.getString(r0, r1)     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = "getString(R.string.max_a…is, maxAmount.toString())"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x011f }
            r10.c(r0)     // Catch:{ Exception -> 0x011f }
            return r3
        L_0x011f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.k.k():boolean");
    }

    private void c(String str) {
        kotlin.g.b.k.c(str, "str");
        TextView textView = this.w;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.w;
        if (textView2 != null) {
            Context context = textView2 != null ? textView2.getContext() : null;
            if (context == null) {
                kotlin.g.b.k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(context, R.color.error_color));
        }
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        if (!(cJRFrequentOrder instanceof CJRMetroQRFrequentOrder)) {
            cJRFrequentOrder = null;
        }
        b((CJRMetroQRFrequentOrder) cJRFrequentOrder);
    }

    private final void b(CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder) {
        Editable text;
        View view = getView();
        Integer num = null;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.txt_amount) : null;
        if (textView != null) {
            if (textView != null) {
                textView.setText(cJRMetroQRFrequentOrder != null ? cJRMetroQRFrequentOrder.getRechargeAmount() : null);
            }
            EditText editText = this.u;
            if (editText != null) {
                if (!(editText == null || (text = editText.getText()) == null)) {
                    num = Integer.valueOf(text.length());
                }
                if (num == null) {
                    kotlin.g.b.k.a();
                }
                editText.setSelection(num.intValue());
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f63391a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f63392b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k kVar, View view) {
            super(view);
            kotlin.g.b.k.c(view, "itemView");
            this.f63392b = kVar;
            View findViewById = view.findViewById(R.id.txt_amount);
            if (findViewById != null) {
                this.f63391a = (TextView) findViewById;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final void b(String str, String str2) {
        kotlin.g.b.k.c(str, "label");
        kotlin.g.b.k.c(str2, "action");
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "mumbai_metro_store_value_pass");
            hashMap.put("event_action", str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/mumbai-metro-store-value-pass");
            hashMap.put("event_label", str);
            hashMap.put("vertical_name", "recharges_utilities");
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ void a(k kVar) {
        try {
            FragmentActivity activity = kVar.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            Object systemService = activity.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                View view = kVar.getView();
                if (view == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) view, "view!!");
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception unused) {
        }
    }
}
