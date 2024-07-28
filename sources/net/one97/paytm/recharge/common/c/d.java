package net.one97.paytm.recharge.common.c;

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
    public static final a f60981a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f60982d;

    /* renamed from: b  reason: collision with root package name */
    private String f60983b;

    /* renamed from: c  reason: collision with root package name */
    private String f60984c;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f60985e;

    private View a(int i2) {
        if (this.f60985e == null) {
            this.f60985e = new HashMap();
        }
        View view = (View) this.f60985e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f60985e.put(Integer.valueOf(i2), findViewById);
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
        k.a((Object) simpleName, "CJRPromoTnCBottomSheetDi…V8::class.java.simpleName");
        f60982d = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            this.f60983b = arguments.getString("tnc_title");
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            this.f60984c = arguments2.getString("tnc_text");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_offers_terms_condition, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d8 A[Catch:{ NullPointerException -> 0x0165 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012f A[Catch:{ NullPointerException -> 0x0165 }] */
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
            java.lang.String r10 = r8.f60983b
            if (r10 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            java.lang.String r10 = ""
        L_0x001b:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
            int r9 = net.one97.paytm.recharge.R.id.close_button
            android.view.View r9 = r8.a(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r10 = r8
            android.view.View$OnClickListener r10 = (android.view.View.OnClickListener) r10
            r9.setOnClickListener(r10)
            java.lang.String r9 = r8.f60984c     // Catch:{ NullPointerException -> 0x0165 }
            r10 = 0
            if (r9 == 0) goto L_0x0038
            int r0 = r9.length()     // Catch:{ NullPointerException -> 0x0165 }
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            r1 = 4
            java.lang.String r2 = "<br>"
            r3 = 0
            if (r0 <= r1) goto L_0x0073
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r4 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            if (r9 == 0) goto L_0x0055
            if (r9 == 0) goto L_0x004f
            java.lang.String r5 = r9.substring(r10, r1)     // Catch:{ NullPointerException -> 0x0165 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)     // Catch:{ NullPointerException -> 0x0165 }
            goto L_0x0056
        L_0x004f:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0165 }
            r9.<init>(r0)     // Catch:{ NullPointerException -> 0x0165 }
            throw r9     // Catch:{ NullPointerException -> 0x0165 }
        L_0x0055:
            r5 = r3
        L_0x0056:
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r10)     // Catch:{ NullPointerException -> 0x0165 }
            if (r5 == 0) goto L_0x0073
            if (r9 == 0) goto L_0x0072
            int r5 = r9.length()     // Catch:{ NullPointerException -> 0x0165 }
            if (r9 == 0) goto L_0x006c
            java.lang.String r9 = r9.substring(r1, r5)     // Catch:{ NullPointerException -> 0x0165 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)     // Catch:{ NullPointerException -> 0x0165 }
            goto L_0x0073
        L_0x006c:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0165 }
            r9.<init>(r0)     // Catch:{ NullPointerException -> 0x0165 }
            throw r9     // Catch:{ NullPointerException -> 0x0165 }
        L_0x0072:
            r9 = r3
        L_0x0073:
            if (r9 == 0) goto L_0x007c
            java.lang.String r0 = "<br><br>"
            java.lang.String r9 = kotlin.m.p.a(r9, r0, r2, r10)     // Catch:{ NullPointerException -> 0x0165 }
            goto L_0x007d
        L_0x007c:
            r9 = r3
        L_0x007d:
            if (r9 == 0) goto L_0x0137
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ NullPointerException -> 0x0165 }
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ NullPointerException -> 0x0165 }
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r1, (boolean) r10)     // Catch:{ NullPointerException -> 0x0165 }
            r1 = 1
            if (r0 != r1) goto L_0x0137
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ NullPointerException -> 0x0165 }
            kotlin.m.l r0 = new kotlin.m.l     // Catch:{ NullPointerException -> 0x0165 }
            r0.<init>((java.lang.String) r2)     // Catch:{ NullPointerException -> 0x0165 }
            java.util.List r9 = r0.split(r9, r10)     // Catch:{ NullPointerException -> 0x0165 }
            boolean r0 = r9.isEmpty()     // Catch:{ NullPointerException -> 0x0165 }
            if (r0 != 0) goto L_0x00ca
            int r0 = r9.size()     // Catch:{ NullPointerException -> 0x0165 }
            java.util.ListIterator r0 = r9.listIterator(r0)     // Catch:{ NullPointerException -> 0x0165 }
        L_0x00a5:
            boolean r2 = r0.hasPrevious()     // Catch:{ NullPointerException -> 0x0165 }
            if (r2 == 0) goto L_0x00ca
            java.lang.Object r2 = r0.previous()     // Catch:{ NullPointerException -> 0x0165 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NullPointerException -> 0x0165 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NullPointerException -> 0x0165 }
            int r2 = r2.length()     // Catch:{ NullPointerException -> 0x0165 }
            if (r2 != 0) goto L_0x00bb
            r2 = 1
            goto L_0x00bc
        L_0x00bb:
            r2 = 0
        L_0x00bc:
            if (r2 != 0) goto L_0x00a5
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ NullPointerException -> 0x0165 }
            int r0 = r0.nextIndex()     // Catch:{ NullPointerException -> 0x0165 }
            int r0 = r0 + r1
            java.util.List r9 = kotlin.a.k.b(r9, (int) r0)     // Catch:{ NullPointerException -> 0x0165 }
            goto L_0x00ce
        L_0x00ca:
            kotlin.a.w r9 = kotlin.a.w.INSTANCE     // Catch:{ NullPointerException -> 0x0165 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ NullPointerException -> 0x0165 }
        L_0x00ce:
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ NullPointerException -> 0x0165 }
            java.lang.String[] r0 = new java.lang.String[r10]     // Catch:{ NullPointerException -> 0x0165 }
            java.lang.Object[] r9 = r9.toArray(r0)     // Catch:{ NullPointerException -> 0x0165 }
            if (r9 == 0) goto L_0x012f
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ NullPointerException -> 0x0165 }
            int r0 = r9.length     // Catch:{ NullPointerException -> 0x0165 }
            r1 = 0
        L_0x00dc:
            if (r1 >= r0) goto L_0x016d
            r2 = r9[r1]     // Catch:{ NullPointerException -> 0x0165 }
            android.content.Context r4 = r8.getContext()     // Catch:{ NullPointerException -> 0x0165 }
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)     // Catch:{ NullPointerException -> 0x0165 }
            int r5 = net.one97.paytm.recharge.R.layout.recharge_offer_list_item_layout     // Catch:{ NullPointerException -> 0x0165 }
            android.view.View r4 = r4.inflate(r5, r3)     // Catch:{ NullPointerException -> 0x0165 }
            int r5 = net.one97.paytm.recharge.R.id.offer_details_text     // Catch:{ NullPointerException -> 0x0165 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ NullPointerException -> 0x0165 }
            boolean r6 = r5 instanceof com.paytm.utility.RoboTextView     // Catch:{ NullPointerException -> 0x0165 }
            if (r6 != 0) goto L_0x00f9
            r5 = r3
        L_0x00f9:
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5     // Catch:{ NullPointerException -> 0x0165 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ NullPointerException -> 0x0165 }
            r7 = 24
            if (r6 < r7) goto L_0x010d
            if (r5 == 0) goto L_0x0118
            android.text.Spanned r2 = android.text.Html.fromHtml(r2, r10)     // Catch:{ NullPointerException -> 0x0165 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NullPointerException -> 0x0165 }
            r5.setText(r2)     // Catch:{ NullPointerException -> 0x0165 }
            goto L_0x0118
        L_0x010d:
            if (r5 == 0) goto L_0x0118
            android.text.Spanned r2 = android.text.Html.fromHtml(r2)     // Catch:{ NullPointerException -> 0x0165 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NullPointerException -> 0x0165 }
            r5.setText(r2)     // Catch:{ NullPointerException -> 0x0165 }
        L_0x0118:
            if (r5 == 0) goto L_0x0121
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ NullPointerException -> 0x0165 }
            r5.setMovementMethod(r2)     // Catch:{ NullPointerException -> 0x0165 }
        L_0x0121:
            int r2 = net.one97.paytm.recharge.R.id.offer_txt_container     // Catch:{ NullPointerException -> 0x0165 }
            android.view.View r2 = r8.a(r2)     // Catch:{ NullPointerException -> 0x0165 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ NullPointerException -> 0x0165 }
            r2.addView(r4)     // Catch:{ NullPointerException -> 0x0165 }
            int r1 = r1 + 1
            goto L_0x00dc
        L_0x012f:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0165 }
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.Array<T>"
            r9.<init>(r10)     // Catch:{ NullPointerException -> 0x0165 }
            throw r9     // Catch:{ NullPointerException -> 0x0165 }
        L_0x0137:
            android.content.Context r10 = r8.getContext()     // Catch:{ NullPointerException -> 0x0165 }
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r10)     // Catch:{ NullPointerException -> 0x0165 }
            int r0 = net.one97.paytm.recharge.R.layout.recharge_offer_list_item_layout     // Catch:{ NullPointerException -> 0x0165 }
            android.view.View r10 = r10.inflate(r0, r3)     // Catch:{ NullPointerException -> 0x0165 }
            int r0 = net.one97.paytm.recharge.R.id.offer_details_text     // Catch:{ NullPointerException -> 0x0165 }
            android.view.View r0 = r10.findViewById(r0)     // Catch:{ NullPointerException -> 0x0165 }
            boolean r1 = r0 instanceof com.paytm.utility.RoboTextView     // Catch:{ NullPointerException -> 0x0165 }
            if (r1 != 0) goto L_0x0150
            r0 = r3
        L_0x0150:
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0     // Catch:{ NullPointerException -> 0x0165 }
            if (r0 == 0) goto L_0x0159
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ NullPointerException -> 0x0165 }
            r0.setText(r9)     // Catch:{ NullPointerException -> 0x0165 }
        L_0x0159:
            int r9 = net.one97.paytm.recharge.R.id.offer_txt_container     // Catch:{ NullPointerException -> 0x0165 }
            android.view.View r9 = r8.a(r9)     // Catch:{ NullPointerException -> 0x0165 }
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9     // Catch:{ NullPointerException -> 0x0165 }
            r9.addView(r10)     // Catch:{ NullPointerException -> 0x0165 }
            return
        L_0x0165:
            r9 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r10 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r10.debugLogExceptions(r9)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.c.d.onViewCreated(android.view.View, android.os.Bundle):void");
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
        HashMap hashMap = this.f60985e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
