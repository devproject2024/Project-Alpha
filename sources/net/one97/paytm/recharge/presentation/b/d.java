package net.one97.paytm.recharge.presentation.b;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.utility.g;
import io.reactivex.rxjava3.a.aa;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticEditBillNameResponse;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import net.one97.paytm.upi.util.UpiConstants;

public final class d extends net.one97.paytm.i.f implements View.OnClickListener, net.one97.paytm.recharge.widgets.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64748a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static b f64749e;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f64750b;

    /* renamed from: c  reason: collision with root package name */
    private String f64751c;

    /* renamed from: d  reason: collision with root package name */
    private int f64752d = c.FROM_AUTOMATIC_SUBSCRIPTION.ordinal();

    /* renamed from: f  reason: collision with root package name */
    private HashMap f64753f;

    public interface b {
        void a(String str);
    }

    public enum c {
        FROM_AUTOMATIC_SUBSCRIPTION,
        FROM_CREDIT_CARD_REVAMP
    }

    public final View a(int i2) {
        if (this.f64753f == null) {
            this.f64753f = new HashMap();
        }
        View view = (View) this.f64753f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64753f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d a(String str, Long l, String str2, b bVar, int i2) {
            k.c(bVar, "editBillNameListener");
            d.f64749e = bVar;
            d dVar = new d();
            Bundle bundle = new Bundle();
            if (i2 == c.FROM_AUTOMATIC_SUBSCRIPTION.ordinal()) {
                bundle.putString("bill_name", str);
                if (l != null) {
                    bundle.putLong(UpiConstants.EXTRA_SUBSCRIPTION_ID, l.longValue());
                    bundle.putString("service_paytype", str2);
                }
            }
            bundle.putInt("KEY_OPEN_ORIGIN", i2);
            dVar.setArguments(bundle);
            return dVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CurvedCornerWithKeyboardBottomSheetDialogTheme);
        Bundle arguments = getArguments();
        String str = null;
        this.f64750b = arguments != null ? arguments.getString("bill_name") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("service_paytype");
        }
        this.f64751c = str;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            this.f64752d = arguments3.getInt("KEY_OPEN_ORIGIN");
        }
        if (getContext() != null) {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context = getContext();
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context, net.one97.paytm.recharge.automatic.b.a.a.X);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_edit_bill_name, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_save);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setEnabled(false);
        }
        ImageView imageView = (ImageView) a(R.id.ic_close);
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) a(R.id.btn_save);
        if (cJRProceedWidgetV82 != null) {
            cJRProceedWidgetV82.setOnClickListener(this);
        }
        if (this.f64752d == c.FROM_CREDIT_CARD_REVAMP.ordinal()) {
            TextView textView = (TextView) a(R.id.txt_heading);
            if (textView != null) {
                textView.setVisibility(8);
            }
            CJRProceedWidgetV8 cJRProceedWidgetV83 = (CJRProceedWidgetV8) a(R.id.btn_save);
            if (cJRProceedWidgetV83 != null) {
                cJRProceedWidgetV83.setProceedBtnText(getString(R.string.done));
            }
            TextView textView2 = (TextView) a(R.id.txt_sample);
            if (textView2 != null) {
                textView2.setText(getString(R.string.v4_cred_card_reavmp_add_name_desc));
            }
            EditText editText = (EditText) a(R.id.edt_bill_name);
            if (editText != null) {
                editText.setHint(getString(R.string.v4_add_card_name));
            }
            Context context = getContext();
            if (context != null) {
                EditText editText2 = (EditText) a(R.id.edt_bill_name);
                if (editText2 != null) {
                    editText2.setHintTextColor(androidx.core.content.b.c(context, R.color.color_506d85));
                }
                View a2 = a(R.id.divider);
                if (a2 != null) {
                    a2.setBackgroundColor(androidx.core.content.b.c(context, R.color.color_00aced));
                }
                TextView textView3 = (TextView) a(R.id.txt_sample);
                if (textView3 != null) {
                    textView3.setTextColor(androidx.core.content.b.c(context, R.color.black_color_1d252d));
                }
            }
        } else {
            CJRProceedWidgetV8 cJRProceedWidgetV84 = (CJRProceedWidgetV8) a(R.id.btn_save);
            if (cJRProceedWidgetV84 != null) {
                cJRProceedWidgetV84.setProceedBtnText(getString(R.string.label_save));
            }
            if (!TextUtils.isEmpty(this.f64750b)) {
                TextView textView4 = (TextView) a(R.id.txt_heading);
                if (textView4 != null) {
                    textView4.setText(getString(R.string.label_heading_edit_bill_name));
                }
                EditText editText3 = (EditText) a(R.id.edt_bill_name);
                if (editText3 != null) {
                    editText3.setHint(getString(R.string.label_heading_edit_bill_name));
                }
                EditText editText4 = (EditText) a(R.id.edt_bill_name);
                if (editText4 != null) {
                    editText4.setText(this.f64750b);
                }
                EditText editText5 = (EditText) a(R.id.edt_bill_name);
                if (editText5 != null) {
                    String str = this.f64750b;
                    Integer valueOf = str != null ? Integer.valueOf(str.length()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    editText5.setSelection(valueOf.intValue());
                }
            } else {
                TextView textView5 = (TextView) a(R.id.txt_heading);
                if (textView5 != null) {
                    textView5.setText(getString(R.string.label_heading_add_bill_name));
                }
                EditText editText6 = (EditText) a(R.id.edt_bill_name);
                if (editText6 != null) {
                    editText6.setHint(getString(R.string.label_heading_add_bill_name));
                }
            }
        }
        EditText editText7 = (EditText) a(R.id.edt_bill_name);
        if (editText7 != null) {
            editText7.addTextChangedListener(new e(this));
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64755a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        e(d dVar) {
            this.f64755a = dVar;
        }

        public final void afterTextChanged(Editable editable) {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f64755a.a(R.id.btn_save);
            if (cJRProceedWidgetV8 != null) {
                String str = null;
                boolean z = false;
                if (!TextUtils.isEmpty(editable != null ? editable.toString() : null)) {
                    if (editable != null) {
                        str = editable.toString();
                    }
                    if (str == null) {
                        k.a();
                    }
                    if (!str.equals(this.f64755a.f64750b)) {
                        z = true;
                    }
                }
                cJRProceedWidgetV8.setEnabled(z);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b2, code lost:
        if (r12 == null) goto L_0x00bd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r12) {
        /*
            r11 = this;
            java.lang.String r0 = "context!!"
            java.lang.String r1 = ""
            r2 = 0
            if (r12 == 0) goto L_0x0010
            int r12 = r12.getId()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0011
        L_0x0010:
            r12 = r2
        L_0x0011:
            int r3 = net.one97.paytm.recharge.automatic.R.id.ic_close
            if (r12 != 0) goto L_0x0016
            goto L_0x0020
        L_0x0016:
            int r4 = r12.intValue()
            if (r4 != r3) goto L_0x0020
            r11.dismiss()
            return
        L_0x0020:
            int r3 = net.one97.paytm.recharge.automatic.R.id.btn_save
            if (r12 != 0) goto L_0x0025
            return
        L_0x0025:
            int r12 = r12.intValue()
            if (r12 != r3) goto L_0x0187
            int r12 = net.one97.paytm.recharge.automatic.R.id.edt_bill_name
            android.view.View r12 = r11.a((int) r12)
            android.widget.EditText r12 = (android.widget.EditText) r12
            if (r12 == 0) goto L_0x0038
            r12.clearFocus()
        L_0x0038:
            androidx.fragment.app.FragmentActivity r12 = r11.getActivity()
            if (r12 == 0) goto L_0x0045
            java.lang.String r3 = "input_method"
            java.lang.Object r12 = r12.getSystemService(r3)
            goto L_0x0046
        L_0x0045:
            r12 = r2
        L_0x0046:
            if (r12 == 0) goto L_0x017f
            android.view.inputmethod.InputMethodManager r12 = (android.view.inputmethod.InputMethodManager) r12
            int r3 = net.one97.paytm.recharge.automatic.R.id.edt_bill_name
            android.view.View r3 = r11.a((int) r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            if (r3 == 0) goto L_0x0059
            android.os.IBinder r3 = r3.getWindowToken()
            goto L_0x005a
        L_0x0059:
            r3 = r2
        L_0x005a:
            r4 = 0
            r12.hideSoftInputFromWindow(r3, r4)
            android.content.Context r12 = r11.getContext()     // Catch:{ all -> 0x008f }
            if (r12 == 0) goto L_0x0090
            net.one97.paytm.recharge.automatic.c.a.a r12 = net.one97.paytm.recharge.automatic.c.a.a.f60256a     // Catch:{ all -> 0x008f }
            android.content.Context r3 = r11.getContext()     // Catch:{ all -> 0x008f }
            if (r3 != 0) goto L_0x006f
            kotlin.g.b.k.a()     // Catch:{ all -> 0x008f }
        L_0x006f:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ all -> 0x008f }
            net.one97.paytm.recharge.automatic.b.a.a$a r12 = net.one97.paytm.recharge.automatic.b.a.a.f60239a     // Catch:{ all -> 0x008f }
            java.lang.String r4 = net.one97.paytm.recharge.automatic.b.a.a.f60240b     // Catch:{ all -> 0x008f }
            net.one97.paytm.recharge.automatic.b.a.a$a r12 = net.one97.paytm.recharge.automatic.b.a.a.f60239a     // Catch:{ all -> 0x008f }
            java.lang.String r5 = net.one97.paytm.recharge.automatic.b.a.a.u     // Catch:{ all -> 0x008f }
            java.lang.String r6 = ""
            java.lang.String r12 = r11.f64751c     // Catch:{ all -> 0x008f }
            if (r12 != 0) goto L_0x0086
            r7 = r1
            goto L_0x0087
        L_0x0086:
            r7 = r12
        L_0x0087:
            r8 = 0
            r9 = 0
            r10 = 96
            net.one97.paytm.recharge.automatic.c.a.a.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x008f }
            goto L_0x0090
        L_0x008f:
        L_0x0090:
            int r12 = net.one97.paytm.recharge.automatic.R.id.edt_bill_name
            android.view.View r12 = r11.a((int) r12)
            android.widget.EditText r12 = (android.widget.EditText) r12
            if (r12 == 0) goto L_0x00bd
            android.text.Editable r12 = r12.getText()
            if (r12 == 0) goto L_0x00bd
            java.lang.String r12 = r12.toString()
            if (r12 == 0) goto L_0x00bd
            if (r12 == 0) goto L_0x00b5
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.CharSequence r12 = kotlin.m.p.b(r12)
            java.lang.String r12 = r12.toString()
            if (r12 != 0) goto L_0x00be
            goto L_0x00bd
        L_0x00b5:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r12.<init>(r0)
            throw r12
        L_0x00bd:
            r12 = r1
        L_0x00be:
            int r1 = r11.f64752d
            net.one97.paytm.recharge.presentation.b.d$c r3 = net.one97.paytm.recharge.presentation.b.d.c.FROM_AUTOMATIC_SUBSCRIPTION
            int r3 = r3.ordinal()
            if (r1 != r3) goto L_0x0179
            android.os.Bundle r1 = r11.getArguments()
            java.lang.String r3 = "subscription_id"
            if (r1 == 0) goto L_0x00d9
            long r4 = r1.getLong(r3)
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            goto L_0x00da
        L_0x00d9:
            r1 = r2
        L_0x00da:
            if (r1 == 0) goto L_0x0187
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0187
            android.os.Bundle r1 = r11.getArguments()
            if (r1 == 0) goto L_0x00f3
            long r1 = r1.getLong(r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r1)
        L_0x00f3:
            if (r2 != 0) goto L_0x00f8
            kotlin.g.b.k.a()
        L_0x00f8:
            long r1 = r2.longValue()
            int r3 = net.one97.paytm.recharge.automatic.R.id.btn_save
            android.view.View r3 = r11.a((int) r3)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r3 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r3
            if (r3 == 0) goto L_0x0109
            r3.a()
        L_0x0109:
            android.content.Context r3 = r11.getContext()
            if (r3 == 0) goto L_0x0171
            android.content.Context r3 = r11.getContext()
            boolean r3 = com.paytm.utility.b.c((android.content.Context) r3)
            if (r3 == 0) goto L_0x0171
            net.one97.paytm.recharge.a.a.a r3 = new net.one97.paytm.recharge.a.a.a
            r3.<init>()
            android.content.Context r3 = r11.getContext()
            if (r3 != 0) goto L_0x0127
            kotlin.g.b.k.a()
        L_0x0127:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "context"
            kotlin.g.b.k.c(r3, r1)
            java.lang.String r2 = "subscriptionId"
            kotlin.g.b.k.c(r0, r2)
            java.lang.String r4 = "nickName"
            kotlin.g.b.k.c(r12, r4)
            kotlin.g.b.k.c(r3, r1)
            kotlin.g.b.k.c(r0, r2)
            kotlin.g.b.k.c(r12, r4)
            net.one97.paytm.recharge.a.a.b$k r1 = new net.one97.paytm.recharge.a.a.b$k
            r1.<init>(r3, r0, r12)
            io.reactivex.rxjava3.a.ab r1 = (io.reactivex.rxjava3.a.ab) r1
            io.reactivex.rxjava3.a.y r0 = io.reactivex.rxjava3.a.y.a(r1)
            java.lang.String r1 = "Single.create { emitter-…\n\n            }\n        }"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            io.reactivex.rxjava3.a.x r1 = io.reactivex.rxjava3.i.a.b()
            io.reactivex.rxjava3.a.y r0 = r0.b((io.reactivex.rxjava3.a.x) r1)
            io.reactivex.rxjava3.a.x r1 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.y r0 = r0.a((io.reactivex.rxjava3.a.x) r1)
            net.one97.paytm.recharge.presentation.b.d$f r1 = new net.one97.paytm.recharge.presentation.b.d$f
            r1.<init>(r11, r12)
            io.reactivex.rxjava3.a.aa r1 = (io.reactivex.rxjava3.a.aa) r1
            r0.a(r1)
            return
        L_0x0171:
            android.content.Context r12 = r11.getContext()
            com.paytm.utility.b.c((android.content.Context) r12)
            return
        L_0x0179:
            net.one97.paytm.recharge.presentation.b.d$c r12 = net.one97.paytm.recharge.presentation.b.d.c.FROM_CREDIT_CARD_REVAMP
            r12.ordinal()
            goto L_0x0187
        L_0x017f:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            r12.<init>(r0)
            throw r12
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.b.d.onClick(android.view.View):void");
    }

    public final void a(String str, Bundle bundle) {
        CJRProceedWidgetV8 cJRProceedWidgetV8;
        if (str != null && str.hashCode() == -1657806898 && str.equals("tag.alert.finish.on.click") && (cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_save)) != null) {
            cJRProceedWidgetV8.postDelayed(new C1277d(this), 500);
        }
    }

    /* renamed from: net.one97.paytm.recharge.presentation.b.d$d  reason: collision with other inner class name */
    static final class C1277d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64754a;

        C1277d(d dVar) {
            this.f64754a = dVar;
        }

        public final void run() {
            this.f64754a.dismissAllowingStateLoss();
        }
    }

    public static final class f implements aa<CJRAutomaticEditBillNameResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64756a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f64757b;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            k.c(cVar, "d");
        }

        f(d dVar, String str) {
            this.f64756a = dVar;
            this.f64757b = str;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRAutomaticEditBillNameResponse cJRAutomaticEditBillNameResponse = (CJRAutomaticEditBillNameResponse) obj;
            k.c(cJRAutomaticEditBillNameResponse, "t");
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f64756a.a(R.id.btn_save);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.b();
            }
            if (cJRAutomaticEditBillNameResponse.getStatus() == 200 && p.a("Success", cJRAutomaticEditBillNameResponse.getMessage(), true)) {
                a aVar = d.f64748a;
                b a2 = d.f64749e;
                if (a2 != null) {
                    a2.a(this.f64757b);
                }
                this.f64756a.dismissAllowingStateLoss();
            } else if (cJRAutomaticEditBillNameResponse.getStatus() == 400) {
                d.a(this.f64756a, cJRAutomaticEditBillNameResponse.getMessage());
            }
        }

        public final void onError(Throwable th) {
            k.c(th, "e");
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f64756a.a(R.id.btn_save);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.b();
            }
            d.a(this.f64756a, th.getMessage());
        }
    }

    public static final /* synthetic */ void a(d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = dVar.getString(R.string.message_400);
        }
        g.a((g.a) new net.one97.paytm.recharge.widgets.a.a("tag.alert.finish.on.click", dVar));
        g.b(dVar.getContext(), dVar.getString(R.string.title_400), str);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64753f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
