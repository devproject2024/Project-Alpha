package net.one97.paytm.recharge.mobile_v3.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;

public final class d extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f63744a = new a((byte) 0);

    /* renamed from: e  reason: collision with root package name */
    private static final String f63745e;

    /* renamed from: b  reason: collision with root package name */
    private String f63746b;

    /* renamed from: c  reason: collision with root package name */
    private String f63747c;

    /* renamed from: d  reason: collision with root package name */
    private String f63748d;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f63749f;

    private View a(int i2) {
        if (this.f63749f == null) {
            this.f63749f = new HashMap();
        }
        View view = (View) this.f63749f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f63749f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = d.class.getSimpleName();
        k.a((Object) simpleName, "FJRPromoTnCBottomSheetV3::class.java.simpleName");
        f63745e = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            this.f63746b = arguments.getString("tnc_title");
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            this.f63747c = arguments2.getString("tnc_text");
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                k.a();
            }
            this.f63748d = arguments3.getString("coupon_code_extra");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v3_offers_terms_condition, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e7 A[Catch:{ NullPointerException -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013e A[Catch:{ NullPointerException -> 0x0146 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r10 = "view"
            kotlin.g.b.k.c(r9, r10)
            int r9 = net.one97.paytm.recharge.R.id.title
            android.view.View r9 = r8.a(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r10 = "title"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            java.lang.String r10 = r8.f63746b
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x001b
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            goto L_0x001e
        L_0x001b:
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
        L_0x001e:
            r9.setText(r10)
            int r9 = net.one97.paytm.recharge.R.id.close_button
            android.view.View r9 = r8.a(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r10 = r8
            android.view.View$OnClickListener r10 = (android.view.View.OnClickListener) r10
            r9.setOnClickListener(r10)
            int r9 = net.one97.paytm.recharge.R.id.code_text
            android.view.View r9 = r8.a(r9)
            com.paytm.utility.RoboTextView r9 = (com.paytm.utility.RoboTextView) r9
            java.lang.String r10 = "code_text"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            java.lang.String r10 = r8.f63748d
            if (r10 == 0) goto L_0x0043
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            goto L_0x0046
        L_0x0043:
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
        L_0x0046:
            r9.setText(r10)
            java.lang.String r9 = r8.f63747c     // Catch:{ NullPointerException -> 0x0146 }
            r10 = 0
            if (r9 == 0) goto L_0x0053
            int r0 = r9.length()     // Catch:{ NullPointerException -> 0x0146 }
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            java.lang.String r1 = "<br>"
            r2 = 4
            r3 = 0
            if (r0 <= r2) goto L_0x008e
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r4 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            if (r9 == 0) goto L_0x0070
            if (r9 == 0) goto L_0x006a
            java.lang.String r5 = r9.substring(r10, r2)     // Catch:{ NullPointerException -> 0x0146 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)     // Catch:{ NullPointerException -> 0x0146 }
            goto L_0x0071
        L_0x006a:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0146 }
            r9.<init>(r0)     // Catch:{ NullPointerException -> 0x0146 }
            throw r9     // Catch:{ NullPointerException -> 0x0146 }
        L_0x0070:
            r5 = r3
        L_0x0071:
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r10)     // Catch:{ NullPointerException -> 0x0146 }
            if (r5 == 0) goto L_0x008e
            if (r9 == 0) goto L_0x008d
            int r5 = r9.length()     // Catch:{ NullPointerException -> 0x0146 }
            if (r9 == 0) goto L_0x0087
            java.lang.String r9 = r9.substring(r2, r5)     // Catch:{ NullPointerException -> 0x0146 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)     // Catch:{ NullPointerException -> 0x0146 }
            goto L_0x008e
        L_0x0087:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0146 }
            r9.<init>(r0)     // Catch:{ NullPointerException -> 0x0146 }
            throw r9     // Catch:{ NullPointerException -> 0x0146 }
        L_0x008d:
            r9 = r3
        L_0x008e:
            if (r9 == 0) goto L_0x0097
            java.lang.String r0 = "<br><br>"
            java.lang.String r9 = kotlin.m.p.a(r9, r0, r1, r10)     // Catch:{ NullPointerException -> 0x0146 }
            goto L_0x0098
        L_0x0097:
            r9 = r3
        L_0x0098:
            if (r9 == 0) goto L_0x014e
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ NullPointerException -> 0x0146 }
            kotlin.m.l r0 = new kotlin.m.l     // Catch:{ NullPointerException -> 0x0146 }
            r0.<init>((java.lang.String) r1)     // Catch:{ NullPointerException -> 0x0146 }
            java.util.List r9 = r0.split(r9, r10)     // Catch:{ NullPointerException -> 0x0146 }
            boolean r0 = r9.isEmpty()     // Catch:{ NullPointerException -> 0x0146 }
            if (r0 != 0) goto L_0x00d9
            int r0 = r9.size()     // Catch:{ NullPointerException -> 0x0146 }
            java.util.ListIterator r0 = r9.listIterator(r0)     // Catch:{ NullPointerException -> 0x0146 }
        L_0x00b3:
            boolean r1 = r0.hasPrevious()     // Catch:{ NullPointerException -> 0x0146 }
            if (r1 == 0) goto L_0x00d9
            java.lang.Object r1 = r0.previous()     // Catch:{ NullPointerException -> 0x0146 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NullPointerException -> 0x0146 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ NullPointerException -> 0x0146 }
            int r1 = r1.length()     // Catch:{ NullPointerException -> 0x0146 }
            r2 = 1
            if (r1 != 0) goto L_0x00ca
            r1 = 1
            goto L_0x00cb
        L_0x00ca:
            r1 = 0
        L_0x00cb:
            if (r1 != 0) goto L_0x00b3
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ NullPointerException -> 0x0146 }
            int r0 = r0.nextIndex()     // Catch:{ NullPointerException -> 0x0146 }
            int r0 = r0 + r2
            java.util.List r9 = kotlin.a.k.b(r9, (int) r0)     // Catch:{ NullPointerException -> 0x0146 }
            goto L_0x00dd
        L_0x00d9:
            kotlin.a.w r9 = kotlin.a.w.INSTANCE     // Catch:{ NullPointerException -> 0x0146 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ NullPointerException -> 0x0146 }
        L_0x00dd:
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ NullPointerException -> 0x0146 }
            java.lang.String[] r0 = new java.lang.String[r10]     // Catch:{ NullPointerException -> 0x0146 }
            java.lang.Object[] r9 = r9.toArray(r0)     // Catch:{ NullPointerException -> 0x0146 }
            if (r9 == 0) goto L_0x013e
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ NullPointerException -> 0x0146 }
            int r0 = r9.length     // Catch:{ NullPointerException -> 0x0146 }
            r1 = 0
        L_0x00eb:
            if (r1 >= r0) goto L_0x014e
            r2 = r9[r1]     // Catch:{ NullPointerException -> 0x0146 }
            android.content.Context r4 = r8.getContext()     // Catch:{ NullPointerException -> 0x0146 }
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)     // Catch:{ NullPointerException -> 0x0146 }
            int r5 = net.one97.paytm.recharge.R.layout.v3_recahrge_offer_list_item_layout     // Catch:{ NullPointerException -> 0x0146 }
            android.view.View r4 = r4.inflate(r5, r3)     // Catch:{ NullPointerException -> 0x0146 }
            int r5 = net.one97.paytm.recharge.R.id.offer_details_text     // Catch:{ NullPointerException -> 0x0146 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ NullPointerException -> 0x0146 }
            boolean r6 = r5 instanceof com.paytm.utility.RoboTextView     // Catch:{ NullPointerException -> 0x0146 }
            if (r6 != 0) goto L_0x0108
            r5 = r3
        L_0x0108:
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5     // Catch:{ NullPointerException -> 0x0146 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ NullPointerException -> 0x0146 }
            r7 = 24
            if (r6 < r7) goto L_0x011c
            if (r5 == 0) goto L_0x0127
            android.text.Spanned r2 = android.text.Html.fromHtml(r2, r10)     // Catch:{ NullPointerException -> 0x0146 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NullPointerException -> 0x0146 }
            r5.setText(r2)     // Catch:{ NullPointerException -> 0x0146 }
            goto L_0x0127
        L_0x011c:
            if (r5 == 0) goto L_0x0127
            android.text.Spanned r2 = android.text.Html.fromHtml(r2)     // Catch:{ NullPointerException -> 0x0146 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NullPointerException -> 0x0146 }
            r5.setText(r2)     // Catch:{ NullPointerException -> 0x0146 }
        L_0x0127:
            if (r5 == 0) goto L_0x0130
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ NullPointerException -> 0x0146 }
            r5.setMovementMethod(r2)     // Catch:{ NullPointerException -> 0x0146 }
        L_0x0130:
            int r2 = net.one97.paytm.recharge.R.id.offer_txt_container     // Catch:{ NullPointerException -> 0x0146 }
            android.view.View r2 = r8.a(r2)     // Catch:{ NullPointerException -> 0x0146 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ NullPointerException -> 0x0146 }
            r2.addView(r4)     // Catch:{ NullPointerException -> 0x0146 }
            int r1 = r1 + 1
            goto L_0x00eb
        L_0x013e:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0146 }
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.Array<T>"
            r9.<init>(r10)     // Catch:{ NullPointerException -> 0x0146 }
            throw r9     // Catch:{ NullPointerException -> 0x0146 }
        L_0x0146:
            r9 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r10 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r10.debugLogExceptions(r9)
        L_0x014e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.a.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        ImageView imageView = (ImageView) a(R.id.close_button);
        k.a((Object) imageView, "close_button");
        int id = imageView.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f63749f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
