package net.one97.paytm.recharge.mobile_v3.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class a extends f implements View.OnClickListener, ai {

    /* renamed from: a  reason: collision with root package name */
    public static final C1244a f63715a = new C1244a((byte) 0);

    /* renamed from: h  reason: collision with root package name */
    private static final String f63716h;

    /* renamed from: b  reason: collision with root package name */
    private String f63717b;

    /* renamed from: c  reason: collision with root package name */
    private String f63718c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f63719d;

    /* renamed from: e  reason: collision with root package name */
    private CJRProceedWidgetV8 f63720e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f63721f;

    /* renamed from: g  reason: collision with root package name */
    private b f63722g;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f63723i;

    public interface b {
        void a(ai aiVar);

        void b(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj);

        void b(CJRRechargeCart cJRRechargeCart);
    }

    private View a(int i2) {
        if (this.f63723i == null) {
            this.f63723i = new HashMap();
        }
        View view = (View) this.f63723i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f63723i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.recharge.mobile_v3.a.a$a  reason: collision with other inner class name */
    public static final class C1244a {
        private C1244a() {
        }

        public /* synthetic */ C1244a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = d.class.getSimpleName();
        k.a((Object) simpleName, "FJRPromoTnCBottomSheetV3::class.java.simpleName");
        f63716h = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = false;
        setStyle(0, R.style.v3UpsellBottomSheetDialogTheme);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            String str = null;
            this.f63717b = arguments != null ? arguments.getString("tnc_title") : null;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("tnc_text");
            }
            this.f63718c = str;
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                z = arguments3.getBoolean("intent_is_insurance_checked", false);
            }
            this.f63719d = z;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v3_insurance_terms_condition, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0118 A[Catch:{ NullPointerException -> 0x0177 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016f A[Catch:{ NullPointerException -> 0x0177 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r10 = "view"
            kotlin.g.b.k.c(r9, r10)
            int r10 = net.one97.paytm.recharge.R.id.title
            android.view.View r10 = r8.a((int) r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            java.lang.String r0 = "title"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            java.lang.String r0 = r8.f63717b
            if (r0 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            java.lang.String r0 = ""
        L_0x001b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10.setText(r0)
            int r10 = net.one97.paytm.recharge.R.id.close_button
            android.view.View r10 = r8.a((int) r10)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r0 = r8
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r10.setOnClickListener(r0)
            int r10 = net.one97.paytm.recharge.R.id.button_container
            android.view.View r10 = r9.findViewById(r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r8.f63721f = r10
            int r10 = net.one97.paytm.recharge.R.id.i_agree_button
            android.view.View r10 = r9.findViewById(r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r10
            r8.f63720e = r10
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = r8.f63720e
            if (r10 == 0) goto L_0x004f
            int r1 = net.one97.paytm.recharge.R.string.insurance_terms_condition_agree_button
            java.lang.String r1 = r8.getString(r1)
            r10.setProceedBtnText(r1)
        L_0x004f:
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r10 = r8.f63720e
            if (r10 == 0) goto L_0x0056
            r10.setOnClickListener(r0)
        L_0x0056:
            boolean r10 = r8.f63719d
            r0 = 0
            if (r10 == 0) goto L_0x0074
            int r10 = net.one97.paytm.recharge.R.id.bottom_extra_view
            android.view.View r9 = r9.findViewById(r10)
            java.lang.String r10 = "view.findViewById<View>(R.id.bottom_extra_view)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            r10 = 8
            r9.setVisibility(r10)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r9 = r8.f63720e
            if (r9 == 0) goto L_0x007b
            r9.setVisibility(r10)
            goto L_0x007b
        L_0x0074:
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r9 = r8.f63720e
            if (r9 == 0) goto L_0x007b
            r9.setVisibility(r0)
        L_0x007b:
            java.lang.String r9 = r8.f63718c     // Catch:{ NullPointerException -> 0x0177 }
            if (r9 == 0) goto L_0x0084
            int r10 = r9.length()     // Catch:{ NullPointerException -> 0x0177 }
            goto L_0x0085
        L_0x0084:
            r10 = 0
        L_0x0085:
            java.lang.String r1 = "<br>"
            r2 = 4
            r3 = 0
            if (r10 <= r2) goto L_0x00bf
            java.lang.String r10 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r4 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            if (r9 == 0) goto L_0x00a1
            if (r9 == 0) goto L_0x009b
            java.lang.String r5 = r9.substring(r0, r2)     // Catch:{ NullPointerException -> 0x0177 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)     // Catch:{ NullPointerException -> 0x0177 }
            goto L_0x00a2
        L_0x009b:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0177 }
            r9.<init>(r10)     // Catch:{ NullPointerException -> 0x0177 }
            throw r9     // Catch:{ NullPointerException -> 0x0177 }
        L_0x00a1:
            r5 = r3
        L_0x00a2:
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r0)     // Catch:{ NullPointerException -> 0x0177 }
            if (r5 == 0) goto L_0x00bf
            if (r9 == 0) goto L_0x00be
            int r5 = r9.length()     // Catch:{ NullPointerException -> 0x0177 }
            if (r9 == 0) goto L_0x00b8
            java.lang.String r9 = r9.substring(r2, r5)     // Catch:{ NullPointerException -> 0x0177 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)     // Catch:{ NullPointerException -> 0x0177 }
            goto L_0x00bf
        L_0x00b8:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0177 }
            r9.<init>(r10)     // Catch:{ NullPointerException -> 0x0177 }
            throw r9     // Catch:{ NullPointerException -> 0x0177 }
        L_0x00be:
            r9 = r3
        L_0x00bf:
            if (r9 == 0) goto L_0x00c8
            java.lang.String r10 = "<br><br>"
            java.lang.String r9 = kotlin.m.p.a(r9, r10, r1, r0)     // Catch:{ NullPointerException -> 0x0177 }
            goto L_0x00c9
        L_0x00c8:
            r9 = r3
        L_0x00c9:
            if (r9 == 0) goto L_0x017f
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ NullPointerException -> 0x0177 }
            kotlin.m.l r10 = new kotlin.m.l     // Catch:{ NullPointerException -> 0x0177 }
            r10.<init>((java.lang.String) r1)     // Catch:{ NullPointerException -> 0x0177 }
            java.util.List r9 = r10.split(r9, r0)     // Catch:{ NullPointerException -> 0x0177 }
            boolean r10 = r9.isEmpty()     // Catch:{ NullPointerException -> 0x0177 }
            if (r10 != 0) goto L_0x010a
            int r10 = r9.size()     // Catch:{ NullPointerException -> 0x0177 }
            java.util.ListIterator r10 = r9.listIterator(r10)     // Catch:{ NullPointerException -> 0x0177 }
        L_0x00e4:
            boolean r1 = r10.hasPrevious()     // Catch:{ NullPointerException -> 0x0177 }
            if (r1 == 0) goto L_0x010a
            java.lang.Object r1 = r10.previous()     // Catch:{ NullPointerException -> 0x0177 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NullPointerException -> 0x0177 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ NullPointerException -> 0x0177 }
            int r1 = r1.length()     // Catch:{ NullPointerException -> 0x0177 }
            r2 = 1
            if (r1 != 0) goto L_0x00fb
            r1 = 1
            goto L_0x00fc
        L_0x00fb:
            r1 = 0
        L_0x00fc:
            if (r1 != 0) goto L_0x00e4
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ NullPointerException -> 0x0177 }
            int r10 = r10.nextIndex()     // Catch:{ NullPointerException -> 0x0177 }
            int r10 = r10 + r2
            java.util.List r9 = kotlin.a.k.b(r9, (int) r10)     // Catch:{ NullPointerException -> 0x0177 }
            goto L_0x010e
        L_0x010a:
            kotlin.a.w r9 = kotlin.a.w.INSTANCE     // Catch:{ NullPointerException -> 0x0177 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ NullPointerException -> 0x0177 }
        L_0x010e:
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ NullPointerException -> 0x0177 }
            java.lang.String[] r10 = new java.lang.String[r0]     // Catch:{ NullPointerException -> 0x0177 }
            java.lang.Object[] r9 = r9.toArray(r10)     // Catch:{ NullPointerException -> 0x0177 }
            if (r9 == 0) goto L_0x016f
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ NullPointerException -> 0x0177 }
            int r10 = r9.length     // Catch:{ NullPointerException -> 0x0177 }
            r1 = 0
        L_0x011c:
            if (r1 >= r10) goto L_0x017f
            r2 = r9[r1]     // Catch:{ NullPointerException -> 0x0177 }
            android.content.Context r4 = r8.getContext()     // Catch:{ NullPointerException -> 0x0177 }
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)     // Catch:{ NullPointerException -> 0x0177 }
            int r5 = net.one97.paytm.recharge.R.layout.v3_recahrge_offer_list_item_layout     // Catch:{ NullPointerException -> 0x0177 }
            android.view.View r4 = r4.inflate(r5, r3)     // Catch:{ NullPointerException -> 0x0177 }
            int r5 = net.one97.paytm.recharge.R.id.offer_details_text     // Catch:{ NullPointerException -> 0x0177 }
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ NullPointerException -> 0x0177 }
            boolean r6 = r5 instanceof com.paytm.utility.RoboTextView     // Catch:{ NullPointerException -> 0x0177 }
            if (r6 != 0) goto L_0x0139
            r5 = r3
        L_0x0139:
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5     // Catch:{ NullPointerException -> 0x0177 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ NullPointerException -> 0x0177 }
            r7 = 24
            if (r6 < r7) goto L_0x014d
            if (r5 == 0) goto L_0x0158
            android.text.Spanned r2 = android.text.Html.fromHtml(r2, r0)     // Catch:{ NullPointerException -> 0x0177 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NullPointerException -> 0x0177 }
            r5.setText(r2)     // Catch:{ NullPointerException -> 0x0177 }
            goto L_0x0158
        L_0x014d:
            if (r5 == 0) goto L_0x0158
            android.text.Spanned r2 = android.text.Html.fromHtml(r2)     // Catch:{ NullPointerException -> 0x0177 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NullPointerException -> 0x0177 }
            r5.setText(r2)     // Catch:{ NullPointerException -> 0x0177 }
        L_0x0158:
            if (r5 == 0) goto L_0x0161
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ NullPointerException -> 0x0177 }
            r5.setMovementMethod(r2)     // Catch:{ NullPointerException -> 0x0177 }
        L_0x0161:
            int r2 = net.one97.paytm.recharge.R.id.offer_txt_container     // Catch:{ NullPointerException -> 0x0177 }
            android.view.View r2 = r8.a((int) r2)     // Catch:{ NullPointerException -> 0x0177 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ NullPointerException -> 0x0177 }
            r2.addView(r4)     // Catch:{ NullPointerException -> 0x0177 }
            int r1 = r1 + 1
            goto L_0x011c
        L_0x016f:
            kotlin.u r9 = new kotlin.u     // Catch:{ NullPointerException -> 0x0177 }
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.Array<T>"
            r9.<init>(r10)     // Catch:{ NullPointerException -> 0x0177 }
            throw r9     // Catch:{ NullPointerException -> 0x0177 }
        L_0x0177:
            r9 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r10 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r10.debugLogExceptions(r9)
        L_0x017f:
            android.app.Dialog r9 = r8.getDialog()
            if (r9 == 0) goto L_0x018f
            net.one97.paytm.recharge.mobile_v3.a.a$c r10 = new net.one97.paytm.recharge.mobile_v3.a.a$c
            r10.<init>(r8)
            android.content.DialogInterface$OnShowListener r10 = (android.content.DialogInterface.OnShowListener) r10
            r9.setOnShowListener(r10)
        L_0x018f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.a.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63724a;

        c(a aVar) {
            this.f63724a = aVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
                    k.a((Object) from, "BottomSheetBehavior.from<View>(bottomSheet)");
                    from.setState(6);
                    from.setBottomSheetCallback(new BottomSheetBehavior.a(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ c f63725a;

                        {
                            this.f63725a = r1;
                        }

                        public final void onStateChanged(View view, int i2) {
                            k.c(view, "view");
                            if (i2 == 5) {
                                this.f63725a.f63724a.dismiss();
                            }
                        }

                        public final void onSlide(View view, float f2) {
                            k.c(view, "view");
                            LinearLayout a2 = this.f63725a.f63724a.f63721f;
                            if (a2 != null) {
                                a2.animate().y(((float) (view.getHeight() - a2.getHeight())) - view.getY()).setDuration(0).start();
                            }
                        }
                    });
                    LinearLayout a2 = this.f63724a.f63721f;
                    if (a2 != null) {
                        a2.animate().y((float) (from.getPeekHeight() - a2.getHeight())).setDuration(0).start();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void onClick(View view) {
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        ImageView imageView = (ImageView) a(R.id.close_button);
        k.a((Object) imageView, "close_button");
        int id = imageView.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            dismiss();
            return;
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f63720e;
        if (cJRProceedWidgetV8 != null) {
            num = Integer.valueOf(cJRProceedWidgetV8.getId());
        }
        if (k.a((Object) valueOf, (Object) num)) {
            d dVar = d.f64967a;
            d.a((CJRRechargeErrorModel) null, ACTION_TYPE.INSURANCE_I_AGREE_CLICKED);
            CJRProceedWidgetV8 cJRProceedWidgetV82 = this.f63720e;
            if (cJRProceedWidgetV82 != null) {
                cJRProceedWidgetV82.a();
            }
            b bVar = this.f63722g;
            if (bVar != null) {
                bVar.a(this);
            }
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (!(context instanceof b)) {
            if (getParentFragment() instanceof b) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    this.f63722g = (b) parentFragment;
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile_v3.dialog.FJRInsuranceTermsAndConditionsV3.IJRInsuranceTermsAndConditionsDialogListeners");
            } else if (getActivity() instanceof b) {
                context = getActivity();
                if (context == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile_v3.dialog.FJRInsuranceTermsAndConditionsV3.IJRInsuranceTermsAndConditionsDialogListeners");
                }
            } else {
                return;
            }
        }
        this.f63722g = (b) context;
    }

    public final void onDetach() {
        super.onDetach();
        this.f63722g = null;
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f63720e;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
        if (iJRPaytmDataModel instanceof CJRRechargeCart) {
            b bVar = this.f63722g;
            if (bVar != null) {
                bVar.b((CJRRechargeCart) iJRPaytmDataModel);
            }
            dismiss();
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        b bVar = this.f63722g;
        if (bVar != null) {
            bVar.b(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.f63720e;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
        dismiss();
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        jVar.a().a((Fragment) this, a.class.getName()).c();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f63723i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
