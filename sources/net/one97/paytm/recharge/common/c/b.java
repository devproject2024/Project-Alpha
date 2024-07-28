package net.one97.paytm.recharge.common.c;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ALERT_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class b extends net.one97.paytm.recharge.common.fragment.d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60954a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C1180b f60955b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f60956c;

    /* renamed from: net.one97.paytm.recharge.common.c.b$b  reason: collision with other inner class name */
    public interface C1180b {
        void f();

        void g();
    }

    public final View a(int i2) {
        if (this.f60956c == null) {
            this.f60956c = new HashMap();
        }
        View view = (View) this.f60956c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f60956c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f60956c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(Bundle bundle) {
            k.c(bundle, "bundle");
            b bVar = new b();
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        boolean z = context instanceof C1180b;
        Object obj = context;
        if (!z) {
            if (getParentFragment() instanceof C1180b) {
                Object parentFragment = getParentFragment();
                obj = parentFragment;
                if (parentFragment == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.dialog.CJRConfirmAndProceedBottomSheet.OnConfirmAndProceedClickListener");
                }
            } else {
                return;
            }
        }
        this.f60955b = (C1180b) obj;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.digital_catalog_confirmation_bottom_sheet, (ViewGroup) null, false);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f60957a;

        c(b bVar) {
            this.f60957a = bVar;
        }

        public final void onClick(View view) {
            if (this.f60957a.f60955b == null) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName == null) {
                    flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
                }
                a2.setFlowName(flowName);
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.CLP_PROCEED.name());
                }
                CRUFlowModel flowName3 = a2.getFlowName();
                if (flowName3 != null) {
                    flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName4 = a2.getFlowName();
                if (flowName4 != null) {
                    flowName4.setAlertType(ALERT_TYPE.PRE_VERIFY_PROCEED.name());
                }
                k.a((Object) view, "it");
                a2.setErrorMsg(view.getContext().getString(R.string.pre_verify_proceed_listener_null, new Object[]{b.class.getSimpleName(), "onClickListener"}));
                az azVar = az.f61525a;
                az.a(a2);
            }
            C1180b a3 = this.f60957a.f60955b;
            if (a3 != null) {
                a3.g();
            }
            C1180b a4 = this.f60957a.f60955b;
            if (a4 != null) {
                a4.f();
            }
            this.f60957a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f60958a;

        d(b bVar) {
            this.f60958a = bVar;
        }

        public final void onClick(View view) {
            C1180b a2 = this.f60958a.f60955b;
            if (a2 != null) {
                a2.g();
            }
            this.f60958a.dismiss();
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        C1180b bVar = this.f60955b;
        if (bVar != null) {
            bVar.g();
        }
        super.onCancel(dialogInterface);
    }

    public final void onDetach() {
        super.onDetach();
        this.f60955b = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r2, android.os.Bundle r3) {
        /*
            r1 = this;
            java.lang.String r3 = "view"
            kotlin.g.b.k.c(r2, r3)
            android.os.Bundle r2 = r1.getArguments()
            if (r2 == 0) goto L_0x011c
            android.os.Bundle r2 = r1.getArguments()
            if (r2 != 0) goto L_0x0015
            kotlin.g.b.k.a()
        L_0x0015:
            java.lang.String r3 = "declaration_caption"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x004f
            android.os.Bundle r2 = r1.getArguments()
            if (r2 != 0) goto L_0x0026
            kotlin.g.b.k.a()
        L_0x0026:
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x004f
            int r2 = net.one97.paytm.recharge.R.id.declaration_caption
            android.view.View r2 = r1.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.os.Bundle r0 = r1.getArguments()
            if (r0 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x004f:
            android.os.Bundle r2 = r1.getArguments()
            if (r2 != 0) goto L_0x0058
            kotlin.g.b.k.a()
        L_0x0058:
            java.lang.String r3 = "declaration_text_1"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x0093
            android.os.Bundle r2 = r1.getArguments()
            if (r2 != 0) goto L_0x0069
            kotlin.g.b.k.a()
        L_0x0069:
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0093
            int r2 = net.one97.paytm.recharge.R.id.declaration_text_1
            android.view.View r2 = r1.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.os.Bundle r0 = r1.getArguments()
            if (r0 != 0) goto L_0x0089
            kotlin.g.b.k.a()
        L_0x0089:
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            goto L_0x00a5
        L_0x0093:
            int r2 = net.one97.paytm.recharge.R.id.group_1
            android.view.View r2 = r1.a((int) r2)
            androidx.constraintlayout.widget.Group r2 = (androidx.constraintlayout.widget.Group) r2
            java.lang.String r3 = "group_1"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.recharge.common.utils.ai.b(r2)
        L_0x00a5:
            android.os.Bundle r2 = r1.getArguments()
            if (r2 != 0) goto L_0x00ae
            kotlin.g.b.k.a()
        L_0x00ae:
            java.lang.String r3 = "declaration_text_2"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x00e9
            android.os.Bundle r2 = r1.getArguments()
            if (r2 != 0) goto L_0x00bf
            kotlin.g.b.k.a()
        L_0x00bf:
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00e9
            int r2 = net.one97.paytm.recharge.R.id.declaration_text_2
            android.view.View r2 = r1.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.os.Bundle r0 = r1.getArguments()
            if (r0 != 0) goto L_0x00df
            kotlin.g.b.k.a()
        L_0x00df:
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            goto L_0x00fb
        L_0x00e9:
            int r2 = net.one97.paytm.recharge.R.id.group_2
            android.view.View r2 = r1.a((int) r2)
            androidx.constraintlayout.widget.Group r2 = (androidx.constraintlayout.widget.Group) r2
            java.lang.String r3 = "group_2"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.recharge.common.utils.ai.b(r2)
        L_0x00fb:
            int r2 = net.one97.paytm.recharge.R.id.proceed_btn
            android.view.View r2 = r1.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "proceed_btn"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.os.Bundle r3 = r1.getArguments()
            if (r3 != 0) goto L_0x0111
            kotlin.g.b.k.a()
        L_0x0111:
            java.lang.String r0 = "proceed_btn_text"
            java.lang.String r3 = r3.getString(r0)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x011c:
            int r2 = net.one97.paytm.recharge.R.id.proceed_btn
            android.view.View r2 = r1.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0130
            net.one97.paytm.recharge.common.c.b$c r3 = new net.one97.paytm.recharge.common.c.b$c
            r3.<init>(r1)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setOnClickListener(r3)
        L_0x0130:
            int r2 = net.one97.paytm.recharge.R.id.ic_cross
            android.view.View r2 = r1.a((int) r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            if (r2 == 0) goto L_0x0144
            net.one97.paytm.recharge.common.c.b$d r3 = new net.one97.paytm.recharge.common.c.b$d
            r3.<init>(r1)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setOnClickListener(r3)
        L_0x0144:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.c.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
