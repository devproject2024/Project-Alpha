package net.one97.paytm.autoaddmoney.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.autoaddmoney.a.b;
import net.one97.paytm.autoaddmoney.c;
import net.one97.paytm.autoaddmoney.c.a;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.autoaddmoney.views.b;
import net.one97.paytm.autoaddmoney.views.g;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;

public final class d extends net.one97.paytm.i.f implements View.OnClickListener, b.a {
    private net.one97.paytm.autoaddmoney.a.b A;
    /* access modifiers changed from: private */
    public int B = -1;
    /* access modifiers changed from: private */
    public boolean C;
    private boolean D;
    /* access modifiers changed from: private */
    public ArrayList<TncData> E;
    private net.one97.paytm.autoaddmoney.c.a F;
    /* access modifiers changed from: private */
    public int G;
    /* access modifiers changed from: private */
    public int H;
    /* access modifiers changed from: private */
    public int I;
    /* access modifiers changed from: private */
    public String J;
    /* access modifiers changed from: private */
    public String K;
    /* access modifiers changed from: private */
    public String L;
    /* access modifiers changed from: private */
    public String M;
    /* access modifiers changed from: private */
    public boolean N;
    /* access modifiers changed from: private */
    public boolean O;
    private boolean P;
    /* access modifiers changed from: private */
    public boolean Q;
    private final b R = new b(this);
    private final a S = new a(this);
    private HashMap T;

    /* renamed from: a  reason: collision with root package name */
    final int f49351a = 1021;

    /* renamed from: b  reason: collision with root package name */
    private NestedScrollView f49352b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f49353c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f49354d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f49355e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f49356f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f49357g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ImageView f49358h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ImageView f49359i;
    /* access modifiers changed from: private */
    public TextView j;
    private TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    private TextView n;
    /* access modifiers changed from: private */
    public LinearLayout o;
    /* access modifiers changed from: private */
    public LinearLayout p;
    /* access modifiers changed from: private */
    public final int q = IuserActions.HIDE_KEYBOARD;
    /* access modifiers changed from: private */
    public ArrayList<IJRDataModel> r;
    private IJRDataModel s;
    private CustomWalletLoaderDialog t;
    private net.one97.paytm.addmoney.a.g u;
    private View v;
    private ImageView w;
    private RecyclerView x;
    private TextView y;
    private RelativeLayout z;

    static final class aa<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends CJRRechargePayment>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49361a;

        aa(d dVar) {
            this.f49361a = dVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: net.one97.paytm.common.entity.IJRDataModel} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: net.one97.paytm.common.entity.IJRDataModel} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00e4  */
        /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r9) {
            /*
                r8 = this;
                net.one97.paytm.autoaddmoney.a r9 = (net.one97.paytm.autoaddmoney.a) r9
                r0 = 0
                if (r9 == 0) goto L_0x000d
                java.lang.Object r9 = r9.a()
                net.one97.paytm.common.entity.recharge.CJRRechargePayment r9 = (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r9
                r5 = r9
                goto L_0x000e
            L_0x000d:
                r5 = r0
            L_0x000e:
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49361a
                java.util.ArrayList r9 = r9.r
                if (r9 == 0) goto L_0x0023
                net.one97.paytm.autoaddmoney.views.d r1 = r8.f49361a
                int r1 = r1.B
                java.lang.Object r9 = r9.get(r1)
                net.one97.paytm.common.entity.IJRDataModel r9 = (net.one97.paytm.common.entity.IJRDataModel) r9
                goto L_0x0024
            L_0x0023:
                r9 = r0
            L_0x0024:
                boolean r9 = r9 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card
                java.lang.String r1 = "|"
                java.lang.String r2 = "||"
                java.lang.String r3 = ""
                if (r9 == 0) goto L_0x0079
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49361a
                java.util.ArrayList r9 = r9.r
                if (r9 == 0) goto L_0x0045
                net.one97.paytm.autoaddmoney.views.d r0 = r8.f49361a
                int r0 = r0.B
                java.lang.Object r9 = r9.get(r0)
                r0 = r9
                net.one97.paytm.common.entity.IJRDataModel r0 = (net.one97.paytm.common.entity.IJRDataModel) r0
            L_0x0045:
                if (r0 == 0) goto L_0x0071
                net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard$Card r0 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card) r0
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = r0.getSavedCardId()
                r9.append(r0)
                r9.append(r2)
                net.one97.paytm.autoaddmoney.views.d r0 = r8.f49361a
                net.one97.paytm.autoaddmoney.a.b r0 = net.one97.paytm.autoaddmoney.views.d.m(r0)
                java.lang.String r0 = r0.a()
                r9.append(r0)
                r9.append(r1)
                java.lang.String r9 = r9.toString()
                java.lang.String r0 = "CREDIT_CARD"
            L_0x006e:
                r4 = r9
                r7 = r0
                goto L_0x00dc
            L_0x0071:
                kotlin.u r9 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card"
                r9.<init>(r0)
                throw r9
            L_0x0079:
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49361a
                java.util.ArrayList r9 = r9.r
                if (r9 == 0) goto L_0x008e
                net.one97.paytm.autoaddmoney.views.d r4 = r8.f49361a
                int r4 = r4.B
                java.lang.Object r9 = r9.get(r4)
                net.one97.paytm.common.entity.IJRDataModel r9 = (net.one97.paytm.common.entity.IJRDataModel) r9
                goto L_0x008f
            L_0x008e:
                r9 = r0
            L_0x008f:
                boolean r9 = r9 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card
                if (r9 == 0) goto L_0x00da
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49361a
                java.util.ArrayList r9 = r9.r
                if (r9 == 0) goto L_0x00a8
                net.one97.paytm.autoaddmoney.views.d r0 = r8.f49361a
                int r0 = r0.B
                java.lang.Object r9 = r9.get(r0)
                r0 = r9
                net.one97.paytm.common.entity.IJRDataModel r0 = (net.one97.paytm.common.entity.IJRDataModel) r0
            L_0x00a8:
                if (r0 == 0) goto L_0x00d2
                net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney$Card r0 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card) r0
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = r0.getSavedCardId()
                r9.append(r0)
                r9.append(r2)
                net.one97.paytm.autoaddmoney.views.d r0 = r8.f49361a
                net.one97.paytm.autoaddmoney.a.b r0 = net.one97.paytm.autoaddmoney.views.d.m(r0)
                java.lang.String r0 = r0.a()
                r9.append(r0)
                r9.append(r1)
                java.lang.String r9 = r9.toString()
                java.lang.String r0 = "DEBIT_CARD"
                goto L_0x006e
            L_0x00d2:
                kotlin.u r9 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card"
                r9.<init>(r0)
                throw r9
            L_0x00da:
                r4 = r3
                r7 = r4
            L_0x00dc:
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49361a
                boolean r9 = r9.b()
                if (r9 == 0) goto L_0x00f0
                net.one97.paytm.autoaddmoney.views.d r1 = r8.f49361a
                int r2 = r1.q
                r6 = 0
                java.lang.String r3 = "otp"
                r1.a(r2, r3, r4, r5, r6, r7)
            L_0x00f0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.views.d.aa.onChanged(java.lang.Object):void");
        }
    }

    static final class ad<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49364a;

        ad(d dVar) {
            this.f49364a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            d dVar = this.f49364a;
            net.one97.paytm.autoaddmoney.b.d dVar2 = aVar != null ? (net.one97.paytm.autoaddmoney.b.d) aVar.a() : null;
            if (dVar2 == null) {
                kotlin.g.b.k.a();
            }
            dVar.a(dVar2);
        }
    }

    static final class h<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends CJRRechargePayment>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49374a;

        h(d dVar) {
            this.f49374a = dVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x011f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r9) {
            /*
                r8 = this;
                net.one97.paytm.autoaddmoney.a r9 = (net.one97.paytm.autoaddmoney.a) r9
                r0 = 0
                if (r9 == 0) goto L_0x000d
                java.lang.Object r9 = r9.a()
                net.one97.paytm.common.entity.recharge.CJRRechargePayment r9 = (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r9
                r5 = r9
                goto L_0x000e
            L_0x000d:
                r5 = r0
            L_0x000e:
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49374a
                java.lang.String r7 = r9.L
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49374a
                android.widget.EditText r1 = r9.f49355e
                if (r1 == 0) goto L_0x0021
                android.text.Editable r1 = r1.getText()
                goto L_0x0022
            L_0x0021:
                r1 = r0
            L_0x0022:
                java.lang.String r1 = java.lang.String.valueOf(r1)
                r2 = 0
                java.lang.String r3 = " "
                java.lang.String r4 = ""
                java.lang.String r1 = kotlin.m.p.a(r1, r3, r4, r2)
                r9.M = r1
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49374a
                android.widget.EditText r9 = r9.f49356f
                if (r9 == 0) goto L_0x003f
                android.text.Editable r9 = r9.getText()
                goto L_0x0040
            L_0x003f:
                r9 = r0
            L_0x0040:
                java.lang.String r9 = java.lang.String.valueOf(r9)
                net.one97.paytm.autoaddmoney.views.d r1 = r8.f49374a
                android.widget.EditText r1 = r1.f49357g
                if (r1 == 0) goto L_0x0051
                android.text.Editable r1 = r1.getText()
                goto L_0x0052
            L_0x0051:
                r1 = r0
            L_0x0052:
                java.lang.String.valueOf(r1)
                net.one97.paytm.autoaddmoney.views.d r1 = r8.f49374a
                android.widget.EditText r1 = r1.f49357g
                if (r1 == 0) goto L_0x0061
                android.text.Editable r0 = r1.getText()
            L_0x0061:
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                kotlin.m.l r1 = new kotlin.m.l
                java.lang.String r3 = "/"
                r1.<init>((java.lang.String) r3)
                java.util.List r0 = r1.split(r0, r2)
                boolean r1 = r0.isEmpty()
                r3 = 1
                if (r1 != 0) goto L_0x00a6
                int r1 = r0.size()
                java.util.ListIterator r1 = r0.listIterator(r1)
            L_0x0081:
                boolean r4 = r1.hasPrevious()
                if (r4 == 0) goto L_0x00a6
                java.lang.Object r4 = r1.previous()
                java.lang.String r4 = (java.lang.String) r4
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                int r4 = r4.length()
                if (r4 != 0) goto L_0x0097
                r4 = 1
                goto L_0x0098
            L_0x0097:
                r4 = 0
            L_0x0098:
                if (r4 != 0) goto L_0x0081
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                int r1 = r1.nextIndex()
                int r1 = r1 + r3
                java.util.List r0 = kotlin.a.k.b(r0, (int) r1)
                goto L_0x00aa
            L_0x00a6:
                kotlin.a.w r0 = kotlin.a.w.INSTANCE
                java.util.List r0 = (java.util.List) r0
            L_0x00aa:
                java.util.Collection r0 = (java.util.Collection) r0
                java.lang.String[] r1 = new java.lang.String[r2]
                java.lang.Object[] r0 = r0.toArray(r1)
                if (r0 == 0) goto L_0x011f
                java.lang.String[] r0 = (java.lang.String[]) r0
                net.one97.paytm.autoaddmoney.views.d r1 = r8.f49374a
                java.lang.String r1 = r1.J
                java.lang.String r4 = "MAESTRO"
                boolean r1 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r3)
                java.lang.String r4 = "|"
                if (r1 != 0) goto L_0x00f3
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r4)
                net.one97.paytm.autoaddmoney.views.d r6 = r8.f49374a
                java.lang.String r6 = r6.M
                r1.append(r6)
                r1.append(r4)
                r1.append(r9)
                r1.append(r4)
                r9 = r0[r2]
                r1.append(r9)
                net.one97.paytm.autoaddmoney.util.f r9 = net.one97.paytm.autoaddmoney.util.f.f49285a
                r9 = r0[r3]
                java.lang.String r9 = net.one97.paytm.autoaddmoney.util.f.a(r9)
                r1.append(r9)
                java.lang.String r9 = r1.toString()
                goto L_0x010b
            L_0x00f3:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>(r4)
                net.one97.paytm.autoaddmoney.views.d r0 = r8.f49374a
                java.lang.String r0 = r0.M
                r9.append(r0)
                java.lang.String r0 = "||"
                r9.append(r0)
                java.lang.String r9 = r9.toString()
            L_0x010b:
                r4 = r9
                net.one97.paytm.autoaddmoney.views.d r9 = r8.f49374a
                boolean r9 = r9.b()
                if (r9 == 0) goto L_0x011e
                net.one97.paytm.autoaddmoney.views.d r1 = r8.f49374a
                int r2 = r1.f49351a
                r6 = 1
                java.lang.String r3 = "otp"
                r1.a(r2, r3, r4, r5, r6, r7)
            L_0x011e:
                return
            L_0x011f:
                kotlin.u r9 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
                r9.<init>(r0)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.views.d.h.onChanged(java.lang.Object):void");
        }
    }

    static final class i<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49375a;

        i(d dVar) {
            this.f49375a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            Boolean bool = aVar != null ? (Boolean) aVar.a() : null;
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                this.f49375a.B = -1;
                try {
                    d.q(this.f49375a).setVisibility(0);
                    net.one97.paytm.autoaddmoney.a.b m = d.m(this.f49375a);
                    int unused = this.f49375a.B;
                    m.a(m.f49122d);
                    m.notifyItemChanged(m.f49122d);
                    m.f49122d = -1;
                    m.f49119a = null;
                    m.f49120b = null;
                    AddMoneyUtils.a(this.f49375a.f49355e, (Activity) this.f49375a.getActivity());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                d.r(this.f49375a).setImageResource(R.drawable.ic_radio_active_addmoney_addmoney);
                return;
            }
            d.q(this.f49375a).setVisibility(8);
            d.r(this.f49375a).setImageResource(R.drawable.ic_radio_inactive_addmoney);
        }
    }

    static final class j<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.f>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49376a;

        j(d dVar) {
            this.f49376a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            Bundle bundle = null;
            net.one97.paytm.autoaddmoney.b.f fVar = aVar != null ? (net.one97.paytm.autoaddmoney.b.f) aVar.a() : null;
            if (this.f49376a.b()) {
                net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
                FragmentActivity activity = this.f49376a.getActivity();
                if (activity != null) {
                    Activity activity2 = activity;
                    String canonicalName = AmAutomaticActivity.class.getCanonicalName();
                    if (fVar != null) {
                        bundle = fVar.f49164b;
                    }
                    a2.a(activity2, canonicalName, bundle);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    static final class k<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49377a;

        k(d dVar) {
            this.f49377a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                aVar.a();
            }
            com.paytm.utility.b.c((Activity) this.f49377a.getActivity());
            if (this.f49377a.Q) {
                d.s(this.f49377a);
            } else {
                this.f49377a.dismiss();
            }
        }
    }

    static final class l<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends com.paytm.network.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49378a;

        l(d dVar) {
            this.f49378a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            d dVar = this.f49378a;
            com.paytm.network.a aVar2 = aVar != null ? (com.paytm.network.a) aVar.a() : null;
            if (aVar2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(aVar2, "request");
            if (dVar.b()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dVar.getActivity());
                builder.setTitle(dVar.getResources().getString(R.string.no_connection));
                builder.setMessage(dVar.getResources().getString(R.string.no_internet));
                builder.setPositiveButton(dVar.getResources().getString(R.string.network_retry_yes), new e(dVar, aVar2));
                builder.show();
            }
        }
    }

    static final class m<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49379a;

        m(d dVar) {
            this.f49379a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            AddMoneyUtils.a(this.f49379a.getActivity(), aVar != null ? (NetworkCustomError) aVar.a() : null, (String) null, Boolean.FALSE);
        }
    }

    static final class n<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49380a;

        n(d dVar) {
            this.f49380a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (this.f49380a.b()) {
                com.paytm.utility.b.b(this.f49380a.getActivity(), this.f49380a.getString(R.string.error), aVar != null ? (String) aVar.a() : null);
            }
        }
    }

    static final class o<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends ArrayList<TncData>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49381a;

        o(d dVar) {
            this.f49381a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            d dVar = this.f49381a;
            ArrayList arrayList = aVar != null ? (ArrayList) aVar.a() : null;
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            dVar.E = arrayList;
        }
    }

    static final class q<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends kotlin.x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49383a;

        q(d dVar) {
            this.f49383a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                aVar.a();
            }
            net.one97.paytm.autoaddmoney.c.a o = d.o(this.f49383a);
            ArrayList j = this.f49383a.r;
            o.a(j != null ? (IJRDataModel) j.get(this.f49383a.B) : null, this.f49383a.f49353c, this.f49383a.f49354d, this.f49383a.N);
        }
    }

    static final class r<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends IJRDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49384a;

        r(d dVar) {
            this.f49384a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            d.o(this.f49384a).a(aVar != null ? (IJRDataModel) aVar.a() : null, this.f49384a.f49353c, this.f49384a.f49354d, this.f49384a.N);
        }
    }

    static final class s<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49385a;

        s(d dVar) {
            this.f49385a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            HasLowSuccess hasLowSuccess;
            String str;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            String str2 = null;
            net.one97.paytm.autoaddmoney.b.a aVar2 = aVar != null ? (net.one97.paytm.autoaddmoney.b.a) aVar.a() : null;
            if (aVar2 != null) {
                hasLowSuccess = aVar2.f49148a;
            } else {
                hasLowSuccess = null;
            }
            if (hasLowSuccess != null) {
                d.a(this.f49385a, aVar2.f49148a);
            }
            d dVar = this.f49385a;
            if (aVar2 != null) {
                str = aVar2.f49149b;
            } else {
                str = null;
            }
            dVar.L = str;
            d dVar2 = this.f49385a;
            if (aVar2 != null) {
                str2 = aVar2.f49150c;
            }
            dVar2.J = str2;
            d.i(this.f49385a);
        }
    }

    static final class t<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends kotlin.x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49386a;

        t(d dVar) {
            this.f49386a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                aVar.a();
            }
            com.paytm.utility.b.b(this.f49386a.getContext(), "Error", this.f49386a.getString(R.string.alreadyadded_card));
        }
    }

    static final class u<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends kotlin.x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49387a;

        u(d dVar) {
            this.f49387a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                aVar.a();
            }
            IJRDataModel w = d.w(this.f49387a);
            d dVar = this.f49387a;
            d.a(dVar, "FAILED", w, dVar.getString(R.string.transaction_failed_rs1), true);
        }
    }

    static final class v<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends kotlin.x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49388a;

        v(d dVar) {
            this.f49388a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                aVar.a();
            }
            net.one97.paytm.autoaddmoney.c.a o = d.o(this.f49388a);
            ArrayList j = this.f49388a.r;
            o.a(j != null ? (IJRDataModel) j.get(this.f49388a.B) : null, this.f49388a.f49353c, this.f49388a.f49354d, this.f49388a.N);
        }
    }

    static final class w<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49389a;

        w(d dVar) {
            this.f49389a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            String str = null;
            NetworkCustomError a2 = d.b(aVar != null ? (NetworkCustomError) aVar.a() : null);
            if (this.f49389a.b()) {
                if (!TextUtils.isEmpty(a2 != null ? a2.getAlertMessage() : null)) {
                    net.one97.paytm.autoaddmoney.a.b m = d.m(this.f49389a);
                    if (a2 != null) {
                        str = a2.getAlertMessage();
                    }
                    if (m.f49121c != null && str != null) {
                        TextView textView = m.f49121c;
                        if (textView != null) {
                            textView.setText(str);
                        }
                        TextView textView2 = m.f49121c;
                        if (textView2 == null) {
                            kotlin.g.b.k.a();
                        }
                        textView2.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            AddMoneyUtils.a(this.f49389a.getActivity(), a2, AmAutomaticActivity.class.getCanonicalName(), Boolean.FALSE);
        }
    }

    static final class x<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.g>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49390a;

        x(d dVar) {
            this.f49390a = dVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
            if ((r1 != null ? r1.getStatus() : null).equals("SUCCESS") == false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
            if (kotlin.m.p.a(r1 != null ? r1.getStatusMessage() : null, "SUCCESS", true) != false) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0062, code lost:
            if (net.one97.paytm.autoaddmoney.views.d.x(r9.f49390a) == false) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
            r10 = net.one97.paytm.autoaddmoney.views.d.y(r9.f49390a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
            if (r10 == null) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x006c, code lost:
            r0 = new net.one97.paytm.autoaddmoney.b.c(net.one97.paytm.autoaddmoney.views.d.t(r9.f49390a), net.one97.paytm.autoaddmoney.views.d.u(r9.f49390a), r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x007f, code lost:
            if (r0.f49156a == null) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0081, code lost:
            r10.f49324a = r0.f49156a;
            r10.a();
            r10.a("SUCCESS", "", r0.f49156a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
            r10 = r9.f49390a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0092, code lost:
            if (r1 == null) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0094, code lost:
            r0 = r1.getStatusMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
            net.one97.paytm.autoaddmoney.views.d.a(r10, "SUCCESS", r7, r0, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x009b, code lost:
            r9.f49390a.dismiss();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r10) {
            /*
                r9 = this;
                net.one97.paytm.autoaddmoney.a r10 = (net.one97.paytm.autoaddmoney.a) r10
                r0 = 0
                if (r10 == 0) goto L_0x000c
                java.lang.Object r10 = r10.a()
                net.one97.paytm.autoaddmoney.b.g r10 = (net.one97.paytm.autoaddmoney.b.g) r10
                goto L_0x000d
            L_0x000c:
                r10 = r0
            L_0x000d:
                if (r10 == 0) goto L_0x0012
                net.one97.paytm.addmoney.common.model.CJRSubscribeAutoAdd r1 = r10.f49166a
                goto L_0x0013
            L_0x0012:
                r1 = r0
            L_0x0013:
                if (r10 == 0) goto L_0x0019
                net.one97.paytm.common.entity.IJRDataModel r10 = r10.f49167b
                r7 = r10
                goto L_0x001a
            L_0x0019:
                r7 = r0
            L_0x001a:
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                boolean r10 = r10.Q
                if (r10 == 0) goto L_0x0028
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                r10.dismiss()
                return
            L_0x0028:
                if (r1 == 0) goto L_0x002f
                java.lang.String r10 = r1.getStatus()
                goto L_0x0030
            L_0x002f:
                r10 = r0
            L_0x0030:
                r2 = 0
                java.lang.String r3 = "SUCCESS"
                if (r10 == 0) goto L_0x0043
                if (r1 == 0) goto L_0x003c
                java.lang.String r10 = r1.getStatus()
                goto L_0x003d
            L_0x003c:
                r10 = r0
            L_0x003d:
                boolean r10 = r10.equals(r3)
                if (r10 != 0) goto L_0x005c
            L_0x0043:
                if (r1 == 0) goto L_0x004a
                java.lang.String r10 = r1.getStatusMessage()
                goto L_0x004b
            L_0x004a:
                r10 = r0
            L_0x004b:
                if (r10 == 0) goto L_0x00a1
                if (r1 == 0) goto L_0x0054
                java.lang.String r10 = r1.getStatusMessage()
                goto L_0x0055
            L_0x0054:
                r10 = r0
            L_0x0055:
                r4 = 1
                boolean r10 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r3, (boolean) r4)
                if (r10 == 0) goto L_0x00a1
            L_0x005c:
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                boolean r10 = r10.O
                if (r10 == 0) goto L_0x0090
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                net.one97.paytm.autoaddmoney.views.b r10 = net.one97.paytm.autoaddmoney.views.d.y(r10)
                if (r10 == 0) goto L_0x009b
                net.one97.paytm.autoaddmoney.b.c r0 = new net.one97.paytm.autoaddmoney.b.c
                net.one97.paytm.autoaddmoney.views.d r1 = r9.f49390a
                java.lang.String r1 = r1.f49353c
                net.one97.paytm.autoaddmoney.views.d r2 = r9.f49390a
                java.lang.String r2 = r2.f49354d
                r0.<init>(r1, r2, r7)
                net.one97.paytm.common.entity.IJRDataModel r1 = r0.f49156a
                if (r1 == 0) goto L_0x009b
                net.one97.paytm.common.entity.IJRDataModel r1 = r0.f49156a
                r10.f49324a = r1
                r10.a()
                net.one97.paytm.common.entity.IJRDataModel r0 = r0.f49156a
                java.lang.String r1 = ""
                r10.a(r3, r1, r0)
                goto L_0x009b
            L_0x0090:
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                if (r1 == 0) goto L_0x0098
                java.lang.String r0 = r1.getStatusMessage()
            L_0x0098:
                net.one97.paytm.autoaddmoney.views.d.a(r10, r3, r7, r0, r2)
            L_0x009b:
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                r10.dismiss()
                return
            L_0x00a1:
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                boolean r10 = r10.O
                if (r10 == 0) goto L_0x00e1
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                net.one97.paytm.autoaddmoney.views.b r10 = net.one97.paytm.autoaddmoney.views.d.y(r10)
                if (r10 == 0) goto L_0x00e0
                net.one97.paytm.autoaddmoney.b.b r8 = new net.one97.paytm.autoaddmoney.b.b
                if (r1 == 0) goto L_0x00bb
                java.lang.String r2 = r1.getStatus()
                r3 = r2
                goto L_0x00bc
            L_0x00bb:
                r3 = r0
            L_0x00bc:
                if (r1 == 0) goto L_0x00c2
                java.lang.String r0 = r1.getStatusMessage()
            L_0x00c2:
                r4 = r0
                net.one97.paytm.autoaddmoney.views.d r0 = r9.f49390a
                java.lang.String r5 = r0.f49353c
                net.one97.paytm.autoaddmoney.views.d r0 = r9.f49390a
                java.lang.String r6 = r0.f49354d
                r2 = r8
                r2.<init>(r3, r4, r5, r6, r7)
                net.one97.paytm.common.entity.IJRDataModel r0 = r8.f49153c
                if (r0 == 0) goto L_0x00e0
                java.lang.String r0 = r8.f49151a
                java.lang.String r1 = r8.f49152b
                net.one97.paytm.common.entity.IJRDataModel r2 = r8.f49153c
                r10.a(r0, r1, r2)
            L_0x00e0:
                return
            L_0x00e1:
                net.one97.paytm.autoaddmoney.views.d r10 = r9.f49390a
                net.one97.paytm.common.entity.IJRDataModel r10 = net.one97.paytm.autoaddmoney.views.d.w(r10)
                net.one97.paytm.autoaddmoney.views.d r3 = r9.f49390a
                if (r1 == 0) goto L_0x00ef
                java.lang.String r0 = r1.getStatusMessage()
            L_0x00ef:
                java.lang.String r1 = "FAILED"
                net.one97.paytm.autoaddmoney.views.d.a(r3, r1, r10, r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.views.d.x.onChanged(java.lang.Object):void");
        }
    }

    static final class y<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49391a;

        y(d dVar) {
            this.f49391a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            this.f49391a.a(aVar != null ? (String) aVar.a() : null);
        }
    }

    static final class z<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends ArrayList<IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49392a;

        z(d dVar) {
            this.f49392a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            ArrayList<IJRDataModel> arrayList = aVar != null ? (ArrayList) aVar.a() : null;
            if (this.f49392a.getParentFragment() != null && (this.f49392a.getParentFragment() instanceof b)) {
                Fragment parentFragment = this.f49392a.getParentFragment();
                if (parentFragment != null) {
                    b bVar = (b) parentFragment;
                    if (arrayList != null) {
                        bVar.f49325b = arrayList;
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.views.AmAutomaticEditFragment");
                }
            }
            if (this.f49392a.getParentFragment() != null && (this.f49392a.getParentFragment() instanceof g)) {
                Fragment parentFragment2 = this.f49392a.getParentFragment();
                if (parentFragment2 != null) {
                    g gVar = (g) parentFragment2;
                    if (arrayList != null) {
                        gVar.f49416a = arrayList;
                        return;
                    }
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.views.AmSetupFragment");
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.autoaddmoney.a.b m(d dVar) {
        net.one97.paytm.autoaddmoney.a.b bVar = dVar.A;
        if (bVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        return bVar;
    }

    public static final /* synthetic */ net.one97.paytm.autoaddmoney.c.a o(d dVar) {
        net.one97.paytm.autoaddmoney.c.a aVar = dVar.F;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ View q(d dVar) {
        View view = dVar.v;
        if (view == null) {
            kotlin.g.b.k.a("mAddCardParent");
        }
        return view;
    }

    public static final /* synthetic */ ImageView r(d dVar) {
        ImageView imageView = dVar.w;
        if (imageView == null) {
            kotlin.g.b.k.a("mImgSelectNewCard");
        }
        return imageView;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.p2bAppBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        Fragment fragment = this;
        c.a aVar = net.one97.paytm.autoaddmoney.c.f49170a;
        FragmentActivity activity = getActivity();
        ai a2 = am.a(fragment, (al.b) c.a.a(activity != null ? activity.getApplication() : null)).a(net.one97.paytm.autoaddmoney.c.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(\n …ardViewModel::class.java)");
        this.F = (net.one97.paytm.autoaddmoney.c.a) a2;
        net.one97.paytm.addmoney.a.g a3 = net.one97.paytm.addmoney.a.g.a(layoutInflater, viewGroup);
        kotlin.g.b.k.a((Object) a3, "AmLayoutSelectPayoptions…flater, container, false)");
        this.u = a3;
        net.one97.paytm.autoaddmoney.c.a aVar2 = this.F;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        androidx.lifecycle.q qVar = this;
        aVar2.l.removeObservers(qVar);
        net.one97.paytm.autoaddmoney.c.a aVar3 = this.F;
        if (aVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar3.l.observe(qVar, new h(this));
        net.one97.paytm.autoaddmoney.c.a aVar4 = this.F;
        if (aVar4 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar4.m.observe(qVar, new s(this));
        net.one97.paytm.autoaddmoney.c.a aVar5 = this.F;
        if (aVar5 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar5.n.observe(qVar, new y(this));
        net.one97.paytm.autoaddmoney.c.a aVar6 = this.F;
        if (aVar6 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar6.t.observe(qVar, new z(this));
        net.one97.paytm.autoaddmoney.c.a aVar7 = this.F;
        if (aVar7 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar7.k.observe(qVar, new aa(this));
        net.one97.paytm.autoaddmoney.c.a aVar8 = this.F;
        if (aVar8 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar8.j.observe(qVar, new ab(this));
        net.one97.paytm.autoaddmoney.c.a aVar9 = this.F;
        if (aVar9 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar9.f49181i.observe(qVar, new ac(this));
        net.one97.paytm.autoaddmoney.c.a aVar10 = this.F;
        if (aVar10 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar10.f49173a.observe(qVar, new ad(this));
        net.one97.paytm.autoaddmoney.c.a aVar11 = this.F;
        if (aVar11 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar11.f49177e.observe(qVar, new ae(this));
        net.one97.paytm.autoaddmoney.c.a aVar12 = this.F;
        if (aVar12 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar12.f49176d.observe(qVar, new i(this));
        net.one97.paytm.autoaddmoney.c.a aVar13 = this.F;
        if (aVar13 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar13.f49175c.observe(qVar, new j(this));
        net.one97.paytm.autoaddmoney.c.a aVar14 = this.F;
        if (aVar14 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar14.f49178f.observe(qVar, new k(this));
        net.one97.paytm.autoaddmoney.c.a aVar15 = this.F;
        if (aVar15 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar15.f49174b.observe(qVar, new l(this));
        net.one97.paytm.autoaddmoney.c.a aVar16 = this.F;
        if (aVar16 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar16.x.observe(qVar, new m(this));
        net.one97.paytm.autoaddmoney.c.a aVar17 = this.F;
        if (aVar17 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar17.f49179g.observe(qVar, new n(this));
        net.one97.paytm.autoaddmoney.c.a aVar18 = this.F;
        if (aVar18 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar18.f49180h.observe(qVar, new o(this));
        net.one97.paytm.autoaddmoney.c.a aVar19 = this.F;
        if (aVar19 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar19.s.observe(qVar, new p(this));
        net.one97.paytm.autoaddmoney.c.a aVar20 = this.F;
        if (aVar20 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar20.q.observe(qVar, new q(this));
        net.one97.paytm.autoaddmoney.c.a aVar21 = this.F;
        if (aVar21 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar21.o.observe(qVar, new r(this));
        net.one97.paytm.autoaddmoney.c.a aVar22 = this.F;
        if (aVar22 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar22.p.observe(qVar, new t(this));
        net.one97.paytm.autoaddmoney.c.a aVar23 = this.F;
        if (aVar23 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar23.r.observe(qVar, new u(this));
        net.one97.paytm.autoaddmoney.c.a aVar24 = this.F;
        if (aVar24 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar24.v.observe(qVar, new v(this));
        net.one97.paytm.autoaddmoney.c.a aVar25 = this.F;
        if (aVar25 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar25.w.observe(qVar, new w(this));
        net.one97.paytm.autoaddmoney.c.a aVar26 = this.F;
        if (aVar26 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar26.u.observe(qVar, new x(this));
        net.one97.paytm.addmoney.a.g gVar = this.u;
        if (gVar == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        return gVar.getRoot();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        kotlin.g.b.k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        com.paytm.utility.b.c((Activity) getActivity());
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new c(this));
            aVar.setCanceledOnTouchOutside(!this.Q);
            aVar.setCancelable(!this.Q);
            return aVar;
        }
        throw new kotlin.u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49367a;

        c(d dVar) {
            this.f49367a = dVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    FrameLayout frameLayout = (FrameLayout) findViewById;
                    if (frameLayout != null) {
                        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                        kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                        from.setState(3);
                        from.setPeekHeight(500);
                        from.setHideable(!this.f49367a.Q);
                        from.setSkipCollapsed(true);
                        return;
                    }
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new kotlin.u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        Fragment parentFragment = getParentFragment();
        com.paytm.utility.b.c((Activity) parentFragment != null ? parentFragment.getActivity() : null);
        HashMap hashMap = this.T;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v119, resolved type: java.util.List} */
    /* JADX WARNING: type inference failed for: r8v85, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.os.Bundle r8) {
        /*
            r7 = this;
            java.lang.String r0 = "null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel>"
            super.onActivityCreated(r8)
            android.os.Bundle r8 = r7.getArguments()
            r1 = 1
            r2 = 0
            if (r8 == 0) goto L_0x01e9
            android.os.Bundle r8 = r7.getArguments()
            if (r8 != 0) goto L_0x0016
            kotlin.g.b.k.a()
        L_0x0016:
            java.lang.String r3 = "SAVED_CARDS"
            boolean r8 = r8.containsKey(r3)
            if (r8 == 0) goto L_0x01e9
            android.os.Bundle r8 = r7.getArguments()     // Catch:{ Exception -> 0x0070 }
            if (r8 == 0) goto L_0x0029
            java.io.Serializable r8 = r8.getSerializable(r3)     // Catch:{ Exception -> 0x0070 }
            goto L_0x002a
        L_0x0029:
            r8 = r2
        L_0x002a:
            if (r8 == 0) goto L_0x0045
            android.os.Bundle r8 = r7.getArguments()     // Catch:{ Exception -> 0x0070 }
            if (r8 == 0) goto L_0x0037
            java.io.Serializable r8 = r8.getSerializable(r3)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0038
        L_0x0037:
            r8 = r2
        L_0x0038:
            if (r8 == 0) goto L_0x003f
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ Exception -> 0x0070 }
            r7.r = r8     // Catch:{ Exception -> 0x0070 }
            goto L_0x0045
        L_0x003f:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x0070 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x0070 }
            throw r8     // Catch:{ Exception -> 0x0070 }
        L_0x0045:
            android.os.Bundle r8 = r7.getArguments()     // Catch:{ Exception -> 0x0070 }
            java.lang.String r3 = "SAVED_CARD"
            if (r8 == 0) goto L_0x0052
            java.io.Serializable r8 = r8.getSerializable(r3)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0053
        L_0x0052:
            r8 = r2
        L_0x0053:
            if (r8 == 0) goto L_0x0074
            android.os.Bundle r8 = r7.getArguments()     // Catch:{ Exception -> 0x0070 }
            if (r8 == 0) goto L_0x0060
            java.io.Serializable r8 = r8.getSerializable(r3)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0061
        L_0x0060:
            r8 = r2
        L_0x0061:
            if (r8 == 0) goto L_0x0068
            net.one97.paytm.common.entity.IJRDataModel r8 = (net.one97.paytm.common.entity.IJRDataModel) r8     // Catch:{ Exception -> 0x0070 }
            r7.s = r8     // Catch:{ Exception -> 0x0070 }
            goto L_0x0074
        L_0x0068:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x0070 }
            java.lang.String r3 = "null cannot be cast to non-null type net.one97.paytm.common.entity.IJRDataModel"
            r8.<init>(r3)     // Catch:{ Exception -> 0x0070 }
            throw r8     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0074:
            android.os.Bundle r8 = r7.getArguments()
            java.lang.String r3 = "EDIT_MODE"
            if (r8 == 0) goto L_0x0085
            boolean r8 = r8.containsKey(r3)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x0086
        L_0x0085:
            r8 = r2
        L_0x0086:
            if (r8 != 0) goto L_0x008b
            kotlin.g.b.k.a()
        L_0x008b:
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00bf
            android.os.Bundle r8 = r7.getArguments()
            if (r8 == 0) goto L_0x00a0
            boolean r8 = r8.getBoolean(r3)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x00a1
        L_0x00a0:
            r8 = r2
        L_0x00a1:
            if (r8 != 0) goto L_0x00a6
            kotlin.g.b.k.a()
        L_0x00a6:
            boolean r8 = r8.booleanValue()
            r7.N = r8
            boolean r8 = r7.N
            if (r8 == 0) goto L_0x00bf
            android.widget.TextView r8 = r7.n
            if (r8 == 0) goto L_0x00bf
            int r3 = net.one97.paytm.addmoney.R.string.proceed
            java.lang.String r3 = r7.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r8.setText(r3)
        L_0x00bf:
            android.os.Bundle r8 = r7.getArguments()
            java.lang.String r3 = "PAYMENT_MODE_CHANGE"
            if (r8 == 0) goto L_0x00d0
            boolean r8 = r8.containsKey(r3)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x00d1
        L_0x00d0:
            r8 = r2
        L_0x00d1:
            if (r8 != 0) goto L_0x00d6
            kotlin.g.b.k.a()
        L_0x00d6:
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00f7
            android.os.Bundle r8 = r7.getArguments()
            if (r8 == 0) goto L_0x00eb
            boolean r8 = r8.getBoolean(r3)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x00ec
        L_0x00eb:
            r8 = r2
        L_0x00ec:
            if (r8 != 0) goto L_0x00f1
            kotlin.g.b.k.a()
        L_0x00f1:
            boolean r8 = r8.booleanValue()
            r7.O = r8
        L_0x00f7:
            android.os.Bundle r8 = r7.getArguments()
            java.lang.String r3 = "IS_DEACTIVATED"
            if (r8 == 0) goto L_0x0108
            boolean r8 = r8.containsKey(r3)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x0109
        L_0x0108:
            r8 = r2
        L_0x0109:
            if (r8 != 0) goto L_0x010e
            kotlin.g.b.k.a()
        L_0x010e:
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x012f
            android.os.Bundle r8 = r7.getArguments()
            if (r8 == 0) goto L_0x0123
            boolean r8 = r8.getBoolean(r3)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x0124
        L_0x0123:
            r8 = r2
        L_0x0124:
            if (r8 != 0) goto L_0x0129
            kotlin.g.b.k.a()
        L_0x0129:
            boolean r8 = r8.booleanValue()
            r7.P = r8
        L_0x012f:
            android.view.View r8 = r7.getView()
            if (r8 == 0) goto L_0x013e
            int r3 = net.one97.paytm.addmoney.R.id.recycler_view_cards
            android.view.View r8 = r8.findViewById(r3)
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            goto L_0x013f
        L_0x013e:
            r8 = r2
        L_0x013f:
            if (r8 != 0) goto L_0x0144
            kotlin.g.b.k.a()
        L_0x0144:
            r7.x = r8
            androidx.recyclerview.widget.RecyclerView r8 = r7.x
            if (r8 != 0) goto L_0x014f
            java.lang.String r3 = "cardRlView"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x014f:
            if (r8 == 0) goto L_0x015f
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r7.getContext()
            r3.<init>(r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r8.setLayoutManager(r3)
        L_0x015f:
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r8 = r7.r
            if (r8 == 0) goto L_0x01e9
            net.one97.paytm.helper.a$a r8 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r8 = r8.a()
            java.lang.String r3 = "isCCAllowedForAutoAm"
            boolean r8 = r8.g((java.lang.String) r3)
            if (r8 != 0) goto L_0x01aa
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r8 = r7.r
            if (r8 == 0) goto L_0x019c
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r8 = r8.iterator()
        L_0x0182:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0198
            java.lang.Object r4 = r8.next()
            r5 = r4
            net.one97.paytm.common.entity.IJRDataModel r5 = (net.one97.paytm.common.entity.IJRDataModel) r5
            boolean r5 = r5 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card
            r5 = r5 ^ r1
            if (r5 == 0) goto L_0x0182
            r3.add(r4)
            goto L_0x0182
        L_0x0198:
            r8 = r3
            java.util.List r8 = (java.util.List) r8
            goto L_0x019d
        L_0x019c:
            r8 = r2
        L_0x019d:
            if (r8 == 0) goto L_0x01a4
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            r7.r = r8
            goto L_0x01aa
        L_0x01a4:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r0)
            throw r8
        L_0x01aa:
            net.one97.paytm.autoaddmoney.a.b r8 = new net.one97.paytm.autoaddmoney.a.b
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 == 0) goto L_0x01e1
            android.app.Activity r0 = (android.app.Activity) r0
            r3 = r7
            net.one97.paytm.autoaddmoney.a.b$a r3 = (net.one97.paytm.autoaddmoney.a.b.a) r3
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r4 = r7.r
            if (r4 != 0) goto L_0x01be
            kotlin.g.b.k.a()
        L_0x01be:
            java.util.List r4 = (java.util.List) r4
            boolean r5 = r7.N
            r8.<init>(r0, r3, r4, r5)
            r7.A = r8
            androidx.recyclerview.widget.RecyclerView r8 = r7.x
            if (r8 != 0) goto L_0x01d0
            java.lang.String r0 = "cardRlView"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01d0:
            if (r8 == 0) goto L_0x01e9
            net.one97.paytm.autoaddmoney.a.b r0 = r7.A
            if (r0 != 0) goto L_0x01db
            java.lang.String r3 = "adapter"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01db:
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r8.setAdapter(r0)
            goto L_0x01e9
        L_0x01e1:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.app.Activity"
            r8.<init>(r0)
            throw r8
        L_0x01e9:
            android.os.Bundle r8 = r7.getArguments()
            if (r8 != 0) goto L_0x01f2
            kotlin.g.b.k.a()
        L_0x01f2:
            java.lang.String r0 = "min_amount"
            boolean r8 = r8.containsKey(r0)
            if (r8 == 0) goto L_0x0209
            android.os.Bundle r8 = r7.getArguments()
            if (r8 != 0) goto L_0x0203
            kotlin.g.b.k.a()
        L_0x0203:
            java.lang.String r8 = r8.getString(r0)
            r7.f49353c = r8
        L_0x0209:
            android.os.Bundle r8 = r7.getArguments()
            if (r8 != 0) goto L_0x0212
            kotlin.g.b.k.a()
        L_0x0212:
            java.lang.String r0 = "auto_amount"
            boolean r8 = r8.containsKey(r0)
            if (r8 == 0) goto L_0x0229
            android.os.Bundle r8 = r7.getArguments()
            if (r8 != 0) goto L_0x0223
            kotlin.g.b.k.a()
        L_0x0223:
            java.lang.String r8 = r8.getString(r0)
            r7.f49354d = r8
        L_0x0229:
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0232
            kotlin.g.b.k.a()
        L_0x0232:
            int r0 = net.one97.paytm.addmoney.R.id.new_add_card_ly
            android.view.View r8 = r8.findViewById(r0)
            java.lang.String r0 = "view!!.findViewById<View>(R.id.new_add_card_ly)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            r7.v = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0249
            kotlin.g.b.k.a()
        L_0x0249:
            int r0 = net.one97.paytm.addmoney.R.id.main_content
            android.view.View r8 = r8.findViewById(r0)
            java.lang.String r0 = "view!!.findViewById(R.id.main_content)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            r7.z = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0262
            kotlin.g.b.k.a()
        L_0x0262:
            int r0 = net.one97.paytm.addmoney.R.id.tv_acivate_am
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.k = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0275
            kotlin.g.b.k.a()
        L_0x0275:
            int r0 = net.one97.paytm.addmoney.R.id.nested_scrollView
            android.view.View r8 = r8.findViewById(r0)
            androidx.core.widget.NestedScrollView r8 = (androidx.core.widget.NestedScrollView) r8
            r7.f49352b = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0288
            kotlin.g.b.k.a()
        L_0x0288:
            int r0 = net.one97.paytm.addmoney.R.id.editText
            android.view.View r8 = r8.findViewById(r0)
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.EditText"
            if (r8 == 0) goto L_0x04ce
            android.widget.EditText r8 = (android.widget.EditText) r8
            r7.f49355e = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x029f
            kotlin.g.b.k.a()
        L_0x029f:
            int r3 = net.one97.paytm.addmoney.R.id.iv_clear
            android.view.View r8 = r8.findViewById(r3)
            java.lang.String r3 = "null cannot be cast to non-null type android.widget.ImageView"
            if (r8 == 0) goto L_0x04c8
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.f49358h = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x02b6
            kotlin.g.b.k.a()
        L_0x02b6:
            int r4 = net.one97.paytm.addmoney.R.id.tv_low_success
            android.view.View r8 = r8.findViewById(r4)
            java.lang.String r4 = "null cannot be cast to non-null type android.widget.TextView"
            if (r8 == 0) goto L_0x04c2
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.j = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x02cd
            kotlin.g.b.k.a()
        L_0x02cd:
            int r5 = net.one97.paytm.addmoney.R.id.ll_new_card_cvv
            android.view.View r8 = r8.findViewById(r5)
            java.lang.String r5 = "null cannot be cast to non-null type android.widget.LinearLayout"
            if (r8 == 0) goto L_0x04bc
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r7.o = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x02e4
            kotlin.g.b.k.a()
        L_0x02e4:
            int r6 = net.one97.paytm.addmoney.R.id.ll_expiry
            android.view.View r8 = r8.findViewById(r6)
            if (r8 == 0) goto L_0x04b6
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r7.p = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x02f9
            kotlin.g.b.k.a()
        L_0x02f9:
            int r5 = net.one97.paytm.addmoney.R.id.et_new_card_cvv
            android.view.View r8 = r8.findViewById(r5)
            if (r8 == 0) goto L_0x04b0
            android.widget.EditText r8 = (android.widget.EditText) r8
            r7.f49356f = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x030e
            kotlin.g.b.k.a()
        L_0x030e:
            int r5 = net.one97.paytm.addmoney.R.id.iv_card_logo
            android.view.View r8 = r8.findViewById(r5)
            if (r8 == 0) goto L_0x04aa
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.f49359i = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0323
            kotlin.g.b.k.a()
        L_0x0323:
            int r5 = net.one97.paytm.addmoney.R.id.tv_enter_card_number
            android.view.View r8 = r8.findViewById(r5)
            if (r8 == 0) goto L_0x04a4
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.l = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0338
            kotlin.g.b.k.a()
        L_0x0338:
            int r5 = net.one97.paytm.addmoney.R.id.et_expiry_validity
            android.view.View r8 = r8.findViewById(r5)
            if (r8 == 0) goto L_0x049e
            android.widget.EditText r8 = (android.widget.EditText) r8
            r7.f49357g = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x034d
            kotlin.g.b.k.a()
        L_0x034d:
            int r0 = net.one97.paytm.addmoney.R.id.tv_expiry_validity
            android.view.View r8 = r8.findViewById(r0)
            if (r8 == 0) goto L_0x0498
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.m = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0362
            kotlin.g.b.k.a()
        L_0x0362:
            int r0 = net.one97.paytm.addmoney.R.id.radio_button
            android.view.View r8 = r8.findViewById(r0)
            if (r8 == 0) goto L_0x0492
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.w = r8
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0377
            kotlin.g.b.k.a()
        L_0x0377:
            int r0 = net.one97.paytm.addmoney.R.id.tv_safegaurd
            android.view.View r8 = r8.findViewById(r0)
            if (r8 == 0) goto L_0x048c
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.y = r8
            net.one97.paytm.helper.a$a r8 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r8 = r8.a()
            java.lang.String r0 = "aam_activation_text"
            java.lang.String r8 = r8.f((java.lang.String) r0)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r3 = 0
            if (r0 != 0) goto L_0x03b0
            android.widget.TextView r0 = r7.y
            if (r0 != 0) goto L_0x03a1
            java.lang.String r4 = "mSafeGuardText"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x03a1:
            r0.setText(r8)
            android.widget.TextView r8 = r7.y
            if (r8 != 0) goto L_0x03ad
            java.lang.String r0 = "mSafeGuardText"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x03ad:
            r8.setVisibility(r3)
        L_0x03b0:
            android.view.View r8 = r7.getView()
            if (r8 == 0) goto L_0x03bf
            int r0 = net.one97.paytm.addmoney.R.id.tv_acivate_am
            android.view.View r8 = r8.findViewById(r0)
            r2 = r8
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x03bf:
            r7.n = r2
            android.widget.TextView r8 = r7.n
            if (r8 == 0) goto L_0x03cb
            r0 = r7
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
        L_0x03cb:
            android.widget.EditText r8 = r7.f49355e
            if (r8 == 0) goto L_0x03df
            android.text.InputFilter[] r0 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r2 = new android.text.InputFilter$LengthFilter
            r4 = 19
            r2.<init>(r4)
            android.text.InputFilter r2 = (android.text.InputFilter) r2
            r0[r3] = r2
            r8.setFilters(r0)
        L_0x03df:
            android.widget.EditText r8 = r7.f49357g
            if (r8 == 0) goto L_0x03f2
            android.text.InputFilter[] r0 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r2 = new android.text.InputFilter$LengthFilter
            r4 = 5
            r2.<init>(r4)
            android.text.InputFilter r2 = (android.text.InputFilter) r2
            r0[r3] = r2
            r8.setFilters(r0)
        L_0x03f2:
            android.widget.EditText r8 = r7.f49356f
            if (r8 == 0) goto L_0x0405
            android.text.InputFilter[] r0 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r1 = new android.text.InputFilter$LengthFilter
            r2 = 3
            r1.<init>(r2)
            android.text.InputFilter r1 = (android.text.InputFilter) r1
            r0[r3] = r1
            r8.setFilters(r0)
        L_0x0405:
            android.widget.EditText r8 = r7.f49355e
            if (r8 == 0) goto L_0x0410
            net.one97.paytm.autoaddmoney.views.d$b r0 = r7.R
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r8.addTextChangedListener(r0)
        L_0x0410:
            android.widget.EditText r8 = r7.f49357g
            if (r8 == 0) goto L_0x041b
            net.one97.paytm.autoaddmoney.views.d$a r0 = r7.S
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r8.addTextChangedListener(r0)
        L_0x041b:
            android.widget.EditText r8 = r7.f49356f
            if (r8 == 0) goto L_0x0429
            net.one97.paytm.autoaddmoney.views.d$d r0 = new net.one97.paytm.autoaddmoney.views.d$d
            r0.<init>(r7)
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r8.addTextChangedListener(r0)
        L_0x0429:
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0432
            kotlin.g.b.k.a()
        L_0x0432:
            int r0 = net.one97.paytm.addmoney.R.id.tv_cvv_help
            android.view.View r8 = r8.findViewById(r0)
            r0 = r7
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r8.setOnClickListener(r0)
            android.view.View r8 = r7.getView()
            if (r8 != 0) goto L_0x0447
            kotlin.g.b.k.a()
        L_0x0447:
            int r1 = net.one97.paytm.addmoney.R.id.et_expiry_validity
            android.view.View r8 = r8.findViewById(r1)
            r8.setOnClickListener(r0)
            android.widget.ImageView r8 = r7.f49358h
            if (r8 == 0) goto L_0x0457
            r8.setOnClickListener(r0)
        L_0x0457:
            net.one97.paytm.addmoney.a.g r8 = r7.u
            if (r8 != 0) goto L_0x0461
            java.lang.String r0 = "viewDataBinding"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0461:
            net.one97.paytm.autoaddmoney.c.a r0 = r7.F
            if (r0 != 0) goto L_0x046b
            java.lang.String r1 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x046b:
            r8.a(r0)
            net.one97.paytm.addmoney.a.g r8 = r7.u
            if (r8 != 0) goto L_0x0478
            java.lang.String r0 = "viewDataBinding"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0478:
            r0 = r7
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            r8.setLifecycleOwner(r0)
            net.one97.paytm.autoaddmoney.c.a r8 = r7.F
            if (r8 != 0) goto L_0x0488
            java.lang.String r0 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0488:
            r8.c()
            return
        L_0x048c:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r4)
            throw r8
        L_0x0492:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r3)
            throw r8
        L_0x0498:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r4)
            throw r8
        L_0x049e:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r0)
            throw r8
        L_0x04a4:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r4)
            throw r8
        L_0x04aa:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r3)
            throw r8
        L_0x04b0:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r0)
            throw r8
        L_0x04b6:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r5)
            throw r8
        L_0x04bc:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r5)
            throw r8
        L_0x04c2:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r4)
            throw r8
        L_0x04c8:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r3)
            throw r8
        L_0x04ce:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.views.d.onActivityCreated(android.os.Bundle):void");
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f49371a;

        f(com.paytm.utility.h hVar) {
            this.f49371a = hVar;
        }

        public final void onClick(View view) {
            this.f49371a.cancel();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49372a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f49373b;

        g(d dVar, com.paytm.utility.h hVar) {
            this.f49372a = dVar;
            this.f49373b = hVar;
        }

        public final void onClick(View view) {
            com.paytm.utility.b.c((Activity) this.f49372a.getActivity());
            b y = d.y(this.f49372a);
            if (y != null) {
                y.f49326c = false;
            }
            this.f49373b.cancel();
            this.f49372a.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        dismiss();
        if (getParentFragment() != null && (getParentFragment() instanceof b)) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                b bVar = (b) parentFragment;
                View inflate = LayoutInflater.from(bVar.getContext()).inflate(R.layout.am_layout_dialog_custom_error, (ViewGroup) null);
                AlertDialog.Builder builder = new AlertDialog.Builder(bVar.getContext());
                builder.setView(inflate);
                AlertDialog create = builder.create();
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence)) {
                    View findViewById = inflate.findViewById(R.id.errorTxt);
                    kotlin.g.b.k.a((Object) findViewById, "dialogView.findViewById<TextView>(R.id.errorTxt)");
                    ((TextView) findViewById).setText(charSequence);
                }
                ((TextView) inflate.findViewById(R.id.ok_got_it_tv)).setOnClickListener(new b.C0876b(bVar, create));
                create.show();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.views.AmAutomaticEditFragment");
        } else if (getParentFragment() != null && (getParentFragment() instanceof g)) {
            Fragment parentFragment2 = getParentFragment();
            if (parentFragment2 != null) {
                g gVar = (g) parentFragment2;
                View inflate2 = LayoutInflater.from(gVar.getContext()).inflate(R.layout.am_layout_dialog_custom_error, (ViewGroup) null);
                AlertDialog.Builder builder2 = new AlertDialog.Builder(gVar.getContext());
                builder2.setView(inflate2);
                AlertDialog create2 = builder2.create();
                CharSequence charSequence2 = str;
                if (!TextUtils.isEmpty(charSequence2)) {
                    View findViewById2 = inflate2.findViewById(R.id.errorTxt);
                    kotlin.g.b.k.a((Object) findViewById2, "dialogView.findViewById<TextView>(R.id.errorTxt)");
                    ((TextView) findViewById2).setText(charSequence2);
                }
                ((TextView) inflate2.findViewById(R.id.ok_got_it_tv)).setOnClickListener(new g.d(gVar, create2));
                create2.show();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.views.AmSetupFragment");
        }
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49369a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f49370b;

        e(d dVar, com.paytm.network.a aVar) {
            this.f49369a = dVar;
            this.f49370b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f49369a.getActivity())) {
                d.o(this.f49369a).b();
                this.f49370b.a();
            }
        }
    }

    public final void a(int i2) {
        this.B = i2;
        this.D = false;
        if (this.C || this.E == null) {
            ArrayList<IJRDataModel> arrayList = this.r;
            if ((arrayList != null ? arrayList.get(this.B) : null) instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
                net.one97.paytm.autoaddmoney.a.b bVar = this.A;
                if (bVar == null) {
                    kotlin.g.b.k.a("adapter");
                }
                if (bVar != null) {
                    net.one97.paytm.autoaddmoney.a.b bVar2 = this.A;
                    if (bVar2 == null) {
                        kotlin.g.b.k.a("adapter");
                    }
                    if (!TextUtils.isEmpty(bVar2.b())) {
                        net.one97.paytm.autoaddmoney.c.a aVar = this.F;
                        if (aVar == null) {
                            kotlin.g.b.k.a("viewModel");
                        }
                        Context context = getContext();
                        if (context == null) {
                            kotlin.g.b.k.a();
                        }
                        net.one97.paytm.addmoney.addmoneysource.c.c.b b2 = net.one97.paytm.addmoney.j.b(context, getParentFragment());
                        net.one97.paytm.autoaddmoney.a.b bVar3 = this.A;
                        if (bVar3 == null) {
                            kotlin.g.b.k.a("adapter");
                        }
                        aVar.a(b2, bVar3.b(), AmAutomaticActivity.class.getName());
                        a("Payment_Proceed_clicked", SDKConstants.AI_KEY_PPBL);
                        return;
                    }
                }
                a(new net.one97.paytm.autoaddmoney.b.d("", false));
                return;
            }
            net.one97.paytm.autoaddmoney.a.b bVar4 = this.A;
            if (bVar4 == null) {
                kotlin.g.b.k.a("adapter");
            }
            if (bVar4 != null) {
                net.one97.paytm.autoaddmoney.a.b bVar5 = this.A;
                if (bVar5 == null) {
                    kotlin.g.b.k.a("adapter");
                }
                if (!TextUtils.isEmpty(bVar5.a())) {
                    net.one97.paytm.autoaddmoney.c.a aVar2 = this.F;
                    if (aVar2 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    aVar2.a(getClass().getName(), false);
                    return;
                }
            }
            a(new net.one97.paytm.autoaddmoney.b.d("", false));
            return;
        }
        net.one97.paytm.autoaddmoney.c.a aVar3 = this.F;
        if (aVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        ArrayList<TncData> arrayList2 = this.E;
        if (arrayList2 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.c(arrayList2, "tncDataList");
        if (!aVar3.d()) {
            return;
        }
        if (arrayList2.size() == 0) {
            aVar3.c();
            return;
        }
        aVar3.b();
        aVar3.y.a(arrayList2, (a.g) new a.f(aVar3));
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        b bVar;
        kotlin.g.b.k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Fragment parentFragment = getParentFragment();
        com.paytm.utility.b.c((Activity) parentFragment != null ? parentFragment.getActivity() : null);
        if (getParentFragment() != null && (getParentFragment() instanceof b) && (bVar = (b) getParentFragment()) != null) {
            bVar.f49326c = false;
            com.paytm.utility.b.c((Activity) bVar.getActivity());
        }
    }

    public final void onHiddenChanged(boolean z2) {
        super.onHiddenChanged(z2);
        if (isHidden()) {
            Fragment parentFragment = getParentFragment();
            com.paytm.utility.b.c((Activity) parentFragment != null ? parentFragment.getActivity() : null);
        }
    }

    /* access modifiers changed from: private */
    public final void a(net.one97.paytm.autoaddmoney.b.d dVar) {
        CustomWalletLoaderDialog customWalletLoaderDialog;
        try {
            if (b()) {
                if (this.t == null) {
                    this.t = new CustomWalletLoaderDialog(getActivity());
                }
                if (dVar.f49160b) {
                    if (this.t != null) {
                        CustomWalletLoaderDialog customWalletLoaderDialog2 = this.t;
                        if (customWalletLoaderDialog2 != null) {
                            customWalletLoaderDialog2.setTitle(dVar.f49159a);
                        }
                        CustomWalletLoaderDialog customWalletLoaderDialog3 = this.t;
                        if (customWalletLoaderDialog3 != null) {
                            customWalletLoaderDialog3.showLoader();
                        }
                    }
                } else if (this.t != null && (customWalletLoaderDialog = this.t) != null) {
                    customWalletLoaderDialog.dismissLoader();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        if (getActivity() == null) {
            return false;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        return !activity.isFinishing();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            String str = null;
            if (i2 == this.q) {
                String stringExtra = intent != null ? intent.getStringExtra("order_id") : null;
                Boolean valueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra(AppConstants.IS_CANCEL, false)) : null;
                if (kotlin.m.p.a("true", intent != null ? intent.getStringExtra("retry_allowed") : null, true)) {
                    if (intent != null) {
                        str = intent.getStringExtra("error_message");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getResources().getString(R.string.auto_card_not_auto_debit);
                    }
                    a(new net.one97.paytm.autoaddmoney.b.d("", false));
                    a(str);
                    return;
                }
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (!valueOf.booleanValue()) {
                    net.one97.paytm.autoaddmoney.c.a aVar = this.F;
                    if (aVar == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    aVar.b(stringExtra, false);
                    return;
                }
                a(new net.one97.paytm.autoaddmoney.b.d("", false));
            } else if (i2 == this.f49351a) {
                String stringExtra2 = intent != null ? intent.getStringExtra("order_id") : null;
                Boolean valueOf2 = intent != null ? Boolean.valueOf(intent.getBooleanExtra(AppConstants.IS_CANCEL, false)) : null;
                if (kotlin.m.p.a("true", intent != null ? intent.getStringExtra("retry_allowed") : null, true)) {
                    if (intent != null) {
                        str = intent.getStringExtra("error_message");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getResources().getString(R.string.auto_card_not_auto_debit);
                    }
                    a(new net.one97.paytm.autoaddmoney.b.d("", false));
                    a(str);
                    return;
                }
                if (valueOf2 == null) {
                    kotlin.g.b.k.a();
                }
                if (!valueOf2.booleanValue()) {
                    net.one97.paytm.autoaddmoney.c.a aVar2 = this.F;
                    if (aVar2 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    aVar2.b(stringExtra2, true);
                    return;
                }
                a(new net.one97.paytm.autoaddmoney.b.d("", false));
            } else {
                a(getResources().getString(R.string.auto_card_not_auto_debit));
            }
        } else {
            a(new net.one97.paytm.autoaddmoney.b.d("", false));
            a(getResources().getString(R.string.auto_card_not_auto_debit));
        }
    }

    public final void a() {
        View view = this.v;
        if (view == null) {
            kotlin.g.b.k.a("mAddCardParent");
        }
        view.setVisibility(8);
        ImageView imageView = this.w;
        if (imageView == null) {
            kotlin.g.b.k.a("mImgSelectNewCard");
        }
        imageView.setImageResource(R.drawable.ic_radio_inactive_addmoney);
    }

    /* renamed from: net.one97.paytm.autoaddmoney.views.d$d  reason: collision with other inner class name */
    public static final class C0878d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49368a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        C0878d(d dVar) {
            this.f49368a = dVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            if (charSequence.length() == this.f49368a.H) {
                d dVar = this.f49368a;
                d.a(dVar, (View) dVar.f49356f);
            }
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49366a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        b(d dVar) {
            this.f49366a = dVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            if (!TextUtils.isEmpty(charSequence)) {
                ImageView A = this.f49366a.f49358h;
                if (A != null) {
                    A.setVisibility(0);
                }
            } else {
                ImageView A2 = this.f49366a.f49358h;
                if (A2 != null) {
                    A2.setVisibility(8);
                }
            }
            if (charSequence.length() <= 6) {
                this.f49366a.J = "";
                LinearLayout C = this.f49366a.o;
                if (C != null) {
                    C.setAlpha(1.0f);
                }
                LinearLayout D = this.f49366a.p;
                if (D != null) {
                    D.setAlpha(1.0f);
                }
                ImageView E = this.f49366a.f49359i;
                if (E != null) {
                    E.setImageDrawable((Drawable) null);
                }
                TextView F = this.f49366a.j;
                if (F != null) {
                    F.setVisibility(8);
                }
            } else if (this.f49366a.I < 7) {
                d.e(this.f49366a, kotlin.m.p.a(charSequence.toString(), " ", "", false));
            }
            this.f49366a.I = charSequence.length();
        }

        public final void afterTextChanged(Editable editable) {
            EditText f2;
            EditText d2;
            kotlin.g.b.k.c(editable, "s");
            this.f49366a.K = kotlin.m.p.a(editable.toString(), " ", "", false);
            Editable editable2 = null;
            if (this.f49366a.G > 0) {
                String G = this.f49366a.K;
                Integer valueOf = G != null ? Integer.valueOf(G.length()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (valueOf.intValue() > this.f49366a.G - (this.f49366a.G / 5) && kotlin.m.p.a(editable.toString(), " ", "", false).length() >= 6) {
                    editable.delete(this.f49366a.G - (this.f49366a.G / 5), editable.length());
                }
            }
            int i2 = 0;
            while (i2 < editable.length()) {
                if (' ' == editable.charAt(i2)) {
                    int i3 = i2 + 1;
                    if (i3 % 5 != 0 || i3 == editable.length()) {
                        editable.delete(i2, i3);
                    }
                }
                i2++;
            }
            for (int i4 = 4; i4 < editable.length(); i4 += 5) {
                if (kotlin.m.p.a((CharSequence) "0123456789", editable.charAt(i4), 0, false, 6) >= 0) {
                    editable.insert(i4, " ");
                }
            }
            EditText d3 = this.f49366a.f49355e;
            Integer valueOf2 = d3 != null ? Integer.valueOf(d3.getSelectionStart()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            boolean z = true;
            if (valueOf2.intValue() > 0) {
                EditText d4 = this.f49366a.f49355e;
                Integer valueOf3 = d4 != null ? Integer.valueOf(d4.getSelectionStart()) : null;
                if (valueOf3 == null) {
                    kotlin.g.b.k.a();
                }
                if (editable.charAt(valueOf3.intValue() - 1) == ' ' && (d2 = this.f49366a.f49355e) != null) {
                    EditText d5 = this.f49366a.f49355e;
                    Integer valueOf4 = d5 != null ? Integer.valueOf(d5.getSelectionStart()) : null;
                    if (valueOf4 == null) {
                        kotlin.g.b.k.a();
                    }
                    d2.setSelection(valueOf4.intValue() - 1);
                }
            }
            if (editable.toString().length() != this.f49366a.G || TextUtils.isEmpty(this.f49366a.K)) {
                if (editable.toString().length() != 0) {
                    z = false;
                }
                if (z) {
                    EditText e2 = this.f49366a.f49356f;
                    Editable text = e2 != null ? e2.getText() : null;
                    if (text == null) {
                        kotlin.g.b.k.a();
                    }
                    text.clear();
                    EditText f3 = this.f49366a.f49357g;
                    if (f3 != null) {
                        editable2 = f3.getText();
                    }
                    if (editable2 == null) {
                        kotlin.g.b.k.a();
                    }
                    editable2.clear();
                    EditText d6 = this.f49366a.f49355e;
                    if (d6 != null) {
                        Context context = this.f49366a.getContext();
                        if (context == null) {
                            kotlin.g.b.k.a();
                        }
                        d6.setBackground(androidx.core.content.b.a(context, R.drawable.white_background_with_border_addmoney));
                    }
                    TextView I = this.f49366a.l;
                    if (I != null) {
                        Context context2 = this.f49366a.getContext();
                        if (context2 == null) {
                            kotlin.g.b.k.a();
                        }
                        I.setText(context2.getString(R.string.enter_card_number));
                    }
                    TextView I2 = this.f49366a.l;
                    if (I2 != null) {
                        Context context3 = this.f49366a.getContext();
                        if (context3 == null) {
                            kotlin.g.b.k.a();
                        }
                        I2.setTextColor(androidx.core.content.b.c(context3, R.color.color_444444));
                    }
                } else if (!kotlin.m.p.a(this.f49366a.L, SDKConstants.CREDIT, false)) {
                    TextView I3 = this.f49366a.l;
                    if (I3 != null) {
                        I3.setText(this.f49366a.getResources().getString(R.string.enter_card_number));
                    }
                    TextView I4 = this.f49366a.l;
                    if (I4 != null) {
                        Context context4 = this.f49366a.getContext();
                        if (context4 == null) {
                            kotlin.g.b.k.a();
                        }
                        I4.setTextColor(androidx.core.content.b.c(context4, R.color.color_444444));
                    }
                    EditText d7 = this.f49366a.f49355e;
                    if (d7 != null) {
                        d7.setBackground(this.f49366a.getResources().getDrawable(R.drawable.white_background_with_border_addmoney));
                    }
                }
            } else if (!kotlin.m.p.a(SDKConstants.MAESTRO, this.f49366a.J, true) && (f2 = this.f49366a.f49357g) != null) {
                f2.requestFocus();
            }
        }
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49360a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        a(d dVar) {
            this.f49360a = dVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            EditText e2;
            kotlin.g.b.k.c(charSequence, "s");
            TextView J = this.f49360a.m;
            if (J != null) {
                J.setText(this.f49360a.getResources().getString(R.string.expiry_validity_date));
            }
            TextView J2 = this.f49360a.m;
            if (J2 != null) {
                Context context = this.f49360a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                J2.setTextColor(androidx.core.content.b.c(context, R.color.color_444444));
            }
            EditText f2 = this.f49360a.f49357g;
            if (f2 != null) {
                f2.setBackground(this.f49360a.getResources().getDrawable(R.drawable.white_background_with_border_addmoney));
            }
            StringBuilder sb = new StringBuilder(charSequence);
            if (sb.length() > 0 && sb.length() == 3 && '/' == sb.charAt(sb.length() - 1)) {
                sb.delete(sb.length() - 1, sb.length());
            }
            if (sb.length() > 0 && sb.length() == 3 && Character.isDigit(sb.charAt(sb.length() - 1))) {
                sb.insert(sb.length() - 1, "/");
            }
            EditText f3 = this.f49360a.f49357g;
            if (f3 != null) {
                f3.removeTextChangedListener(this);
            }
            EditText f4 = this.f49360a.f49357g;
            if (f4 != null) {
                f4.setText(sb);
            }
            EditText f5 = this.f49360a.f49357g;
            if (f5 != null) {
                f5.setSelection(sb.length());
            }
            EditText f6 = this.f49360a.f49357g;
            if (f6 != null) {
                f6.addTextChangedListener(this);
            }
            if (sb.length() == 5) {
                LinearLayout C = this.f49360a.o;
                if (C == null) {
                    kotlin.g.b.k.a();
                }
                if (C.isEnabled() && (e2 = this.f49360a.f49356f) != null) {
                    e2.requestFocus();
                }
            }
        }
    }

    public final void a(int i2, String str, String str2, CJRRechargePayment cJRRechargePayment, boolean z2, String str3) {
        String str4;
        kotlin.g.b.k.c(str, "_authMode");
        kotlin.g.b.k.c(str2, "_cardInfo");
        String str5 = SDKConstants.DEBIT;
        if (kotlin.m.p.a(str5, str3, true)) {
            str4 = Constants.EASYPAY_PAYTYPE_DEBIT_CARD;
        } else {
            str5 = SDKConstants.CREDIT;
            str4 = Constants.EASYPAY_PAYTYPE_CREDIT_CARD;
        }
        String str6 = str5;
        String str7 = z2 ? "1" : "0";
        String str8 = null;
        HashMap<String, String> a2 = AddMoneyUtils.a(str, cJRRechargePayment != null ? cJRRechargePayment.getmTxnToken() : null, cJRRechargePayment != null ? cJRRechargePayment.getMID() : null, cJRRechargePayment != null ? cJRRechargePayment.getOrderId() : null, str6, str2, str7);
        net.one97.paytm.helper.c a3 = net.one97.paytm.helper.a.f50546a.a();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        Intent f2 = a3.f((Activity) activity);
        if (cJRRechargePayment != null) {
            cJRRechargePayment.setmPGParams(a2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(net.one97.paytm.helper.a.f50546a.a().f("processTxnAddMoneyURL"));
        sb.append("?mid=");
        sb.append(cJRRechargePayment != null ? cJRRechargePayment.getMID() : null);
        sb.append("&orderId=");
        if (cJRRechargePayment != null) {
            str8 = cJRRechargePayment.getmOrderId();
        }
        sb.append(str8);
        String sb2 = sb.toString();
        if (cJRRechargePayment != null) {
            cJRRechargePayment.setmPGUrlToHit(sb2);
        }
        f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        f2.putExtra("auto_add_money", true);
        startActivityForResult(f2, i2);
        a("Payment_Proceed_clicked", str4);
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2) {
        Bundle arguments = getArguments();
        String str3 = (arguments == null || !arguments.getBoolean("EDIT_MODE", false)) ? "Create" : "Update";
        net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        Context context = activity;
        String[] strArr = new String[3];
        strArr[0] = str3;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            kotlin.g.b.k.a();
        }
        String string = arguments2.getString("source", "");
        kotlin.g.b.k.a((Object) string, "arguments!!.getString(UtilsConstants.SOURCE, \"\")");
        strArr[1] = string;
        strArr[2] = str2;
        a2.a(context, "Auto Add Money", str, (ArrayList<String>) kotlin.a.k.d(strArr), "", "", "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02d5, code lost:
        if (kotlin.g.b.k.a(java.lang.Integer.valueOf(r8[0]).intValue(), r1.get(2)) <= 0) goto L_0x02d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x030b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x000c
            int r8 = r8.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x000d
        L_0x000c:
            r8 = r0
        L_0x000d:
            int r1 = net.one97.paytm.addmoney.R.id.iv_clear
            if (r8 != 0) goto L_0x0012
            goto L_0x004e
        L_0x0012:
            int r2 = r8.intValue()
            if (r2 != r1) goto L_0x004e
            android.widget.EditText r8 = r7.f49355e
            if (r8 == 0) goto L_0x0021
            android.text.Editable r8 = r8.getText()
            goto L_0x0022
        L_0x0021:
            r8 = r0
        L_0x0022:
            if (r8 != 0) goto L_0x0027
            kotlin.g.b.k.a()
        L_0x0027:
            r8.clear()
            android.widget.EditText r8 = r7.f49356f
            if (r8 == 0) goto L_0x0033
            android.text.Editable r8 = r8.getText()
            goto L_0x0034
        L_0x0033:
            r8 = r0
        L_0x0034:
            if (r8 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            r8.clear()
            android.widget.EditText r8 = r7.f49357g
            if (r8 == 0) goto L_0x0044
            android.text.Editable r0 = r8.getText()
        L_0x0044:
            if (r0 != 0) goto L_0x0049
            kotlin.g.b.k.a()
        L_0x0049:
            r0.clear()
            goto L_0x03ad
        L_0x004e:
            int r1 = net.one97.paytm.addmoney.R.id.tv_cvv_help
            java.lang.String r2 = "Amex"
            r3 = 1
            if (r8 != 0) goto L_0x0056
            goto L_0x009e
        L_0x0056:
            int r4 = r8.intValue()
            if (r4 != r1) goto L_0x009e
            java.lang.String r8 = r7.J
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x0072
            net.one97.paytm.wallet.c.d$b r8 = net.one97.paytm.wallet.c.d.b.ALL
            net.one97.paytm.wallet.c.d r8 = net.one97.paytm.wallet.c.d.a((net.one97.paytm.wallet.c.d.b) r8)
            java.lang.String r1 = "CvvHelpBottomSheetFragme…AddMoney.CvvHelpCard.ALL)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            goto L_0x0091
        L_0x0072:
            java.lang.String r8 = r7.J
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r2, (boolean) r3)
            if (r8 != 0) goto L_0x0086
            net.one97.paytm.wallet.c.d$b r8 = net.one97.paytm.wallet.c.d.b.NON_AMEX
            net.one97.paytm.wallet.c.d r8 = net.one97.paytm.wallet.c.d.a((net.one97.paytm.wallet.c.d.b) r8)
            java.lang.String r1 = "CvvHelpBottomSheetFragme…ney.CvvHelpCard.NON_AMEX)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            goto L_0x0091
        L_0x0086:
            net.one97.paytm.wallet.c.d$b r8 = net.one97.paytm.wallet.c.d.b.AMEX
            net.one97.paytm.wallet.c.d r8 = net.one97.paytm.wallet.c.d.a((net.one97.paytm.wallet.c.d.b) r8)
            java.lang.String r1 = "CvvHelpBottomSheetFragme…ddMoney.CvvHelpCard.AMEX)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
        L_0x0091:
            androidx.fragment.app.j r1 = r7.getFragmentManager()
            if (r1 != 0) goto L_0x009a
            kotlin.g.b.k.a()
        L_0x009a:
            r8.show((androidx.fragment.app.j) r1, (java.lang.String) r0)
            return
        L_0x009e:
            int r1 = net.one97.paytm.addmoney.R.id.et_expiry_validity
            if (r8 != 0) goto L_0x00a3
            goto L_0x00c0
        L_0x00a3:
            int r4 = r8.intValue()
            if (r4 != r1) goto L_0x00c0
            android.widget.EditText r8 = r7.f49357g
            if (r8 == 0) goto L_0x00bf
            if (r8 == 0) goto L_0x00b3
            android.text.Editable r0 = r8.getText()
        L_0x00b3:
            if (r0 != 0) goto L_0x00b8
            kotlin.g.b.k.a()
        L_0x00b8:
            int r0 = r0.length()
            r8.setSelection(r0)
        L_0x00bf:
            return
        L_0x00c0:
            int r1 = net.one97.paytm.addmoney.R.id.tv_acivate_am
            if (r8 != 0) goto L_0x00c5
            return
        L_0x00c5:
            int r8 = r8.intValue()
            if (r8 != r1) goto L_0x0436
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            android.app.Activity r8 = (android.app.Activity) r8
            com.paytm.utility.b.c((android.app.Activity) r8)
            android.widget.EditText r8 = r7.f49355e
            if (r8 == 0) goto L_0x00dd
            android.text.Editable r8 = r8.getText()
            goto L_0x00de
        L_0x00dd:
            r8 = r0
        L_0x00de:
            if (r8 != 0) goto L_0x00e3
            kotlin.g.b.k.a()
        L_0x00e3:
            int r8 = r8.length()
            android.widget.EditText r1 = r7.f49355e
            if (r1 == 0) goto L_0x00f0
            android.text.Editable r1 = r1.getText()
            goto L_0x00f1
        L_0x00f0:
            r1 = r0
        L_0x00f1:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03f2
            r1 = 17
            if (r8 < r1) goto L_0x03f2
            r4 = 23
            if (r8 <= r4) goto L_0x0103
            goto L_0x03f2
        L_0x0103:
            java.lang.String r5 = r7.L
            java.lang.String r6 = "CREDIT_CARD"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r3)
            if (r5 == 0) goto L_0x014a
            net.one97.paytm.helper.a$a r5 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r5 = r5.a()
            java.lang.String r6 = "isCCAllowedForAutoAm"
            boolean r5 = r5.g((java.lang.String) r6)
            if (r5 != 0) goto L_0x014a
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x0131
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0128
            kotlin.g.b.k.a()
        L_0x0128:
            int r1 = net.one97.paytm.addmoney.R.color.color_fd5c5c
            int r0 = androidx.core.content.b.c(r0, r1)
            r8.setTextColor(r0)
        L_0x0131:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x0149
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x013e
            kotlin.g.b.k.a()
        L_0x013e:
            int r1 = net.one97.paytm.addmoney.R.string.credit_card_not_support_error
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x0149:
            return
        L_0x014a:
            java.lang.String r5 = r7.J
            if (r5 == 0) goto L_0x03ad
            java.lang.String r6 = "Diners"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r3)
            if (r5 == 0) goto L_0x0158
            if (r8 != r1) goto L_0x0368
        L_0x0158:
            java.lang.String r1 = r7.J
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 == 0) goto L_0x0164
            r1 = 18
            if (r8 != r1) goto L_0x0368
        L_0x0164:
            java.lang.String r1 = r7.J
            java.lang.String r2 = "DISCOVER"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 != 0) goto L_0x018c
            java.lang.String r1 = r7.J
            java.lang.String r2 = "VISA"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 != 0) goto L_0x018c
            java.lang.String r1 = r7.J
            java.lang.String r2 = "Master"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 != 0) goto L_0x018c
            java.lang.String r1 = r7.J
            java.lang.String r2 = "RUPAY"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 == 0) goto L_0x0190
        L_0x018c:
            r1 = 19
            if (r8 != r1) goto L_0x0368
        L_0x0190:
            java.lang.String r1 = r7.J
            java.lang.String r2 = "MAESTRO"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)
            if (r1 == 0) goto L_0x019e
            if (r8 == r4) goto L_0x019e
            goto L_0x0368
        L_0x019e:
            android.widget.EditText r8 = r7.f49355e
            if (r8 == 0) goto L_0x01b4
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L_0x01ab
            kotlin.g.b.k.a()
        L_0x01ab:
            int r4 = net.one97.paytm.addmoney.R.drawable.white_background_with_border_addmoney
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r4)
            r8.setBackground(r1)
        L_0x01b4:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x01cc
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L_0x01c1
            kotlin.g.b.k.a()
        L_0x01c1:
            int r4 = net.one97.paytm.addmoney.R.string.enter_card_number
            java.lang.String r1 = r1.getString(r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x01cc:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x01e2
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L_0x01d9
            kotlin.g.b.k.a()
        L_0x01d9:
            int r4 = net.one97.paytm.addmoney.R.color.color_444444
            int r1 = androidx.core.content.b.c(r1, r4)
            r8.setTextColor(r1)
        L_0x01e2:
            java.lang.String r8 = r7.J
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r2, (boolean) r3)
            if (r8 != 0) goto L_0x0358
            android.widget.EditText r8 = r7.f49357g
            if (r8 == 0) goto L_0x01f3
            android.text.Editable r8 = r8.getText()
            goto L_0x01f4
        L_0x01f3:
            r8 = r0
        L_0x01f4:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0313
            android.widget.EditText r8 = r7.f49357g
            if (r8 == 0) goto L_0x0209
            android.text.Editable r8 = r8.getText()
            goto L_0x020a
        L_0x0209:
            r8 = r0
        L_0x020a:
            if (r8 != 0) goto L_0x020f
            kotlin.g.b.k.a()
        L_0x020f:
            int r8 = r8.length()
            r1 = 5
            if (r8 < r1) goto L_0x0313
            net.one97.paytm.autoaddmoney.util.f r8 = net.one97.paytm.autoaddmoney.util.f.f49285a
            android.widget.EditText r8 = r7.f49357g
            if (r8 == 0) goto L_0x0221
            android.text.Editable r8 = r8.getText()
            goto L_0x0222
        L_0x0221:
            r8 = r0
        L_0x0222:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r1 = "value"
            kotlin.g.b.k.c(r8, r1)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            kotlin.m.l r1 = new kotlin.m.l
            java.lang.String r2 = "/"
            r1.<init>((java.lang.String) r2)
            r2 = 0
            java.util.List r8 = r1.split(r8, r2)
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L_0x026d
            int r1 = r8.size()
            java.util.ListIterator r1 = r8.listIterator(r1)
        L_0x0248:
            boolean r4 = r1.hasPrevious()
            if (r4 == 0) goto L_0x026d
            java.lang.Object r4 = r1.previous()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x025e
            r4 = 1
            goto L_0x025f
        L_0x025e:
            r4 = 0
        L_0x025f:
            if (r4 != 0) goto L_0x0248
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            int r1 = r1.nextIndex()
            int r1 = r1 + r3
            java.util.List r8 = kotlin.a.k.b(r8, (int) r1)
            goto L_0x0271
        L_0x026d:
            kotlin.a.w r8 = kotlin.a.w.INSTANCE
            java.util.List r8 = (java.util.List) r8
        L_0x0271:
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.String[] r1 = new java.lang.String[r2]
            java.lang.Object[] r8 = r8.toArray(r1)
            if (r8 == 0) goto L_0x030b
            java.lang.String[] r8 = (java.lang.String[]) r8
            r1 = r8[r3]
            java.lang.String r1 = net.one97.paytm.autoaddmoney.util.f.a(r1)
            r8[r3] = r1
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            r4 = r8[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r4 = r4.intValue()
            r5 = 12
            int r4 = kotlin.g.b.k.a((int) r4, (int) r5)
            if (r4 > 0) goto L_0x02d9
            r4 = r8[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r4 = r4.intValue()
            int r5 = r1.get(r3)
            int r4 = kotlin.g.b.k.a((int) r4, (int) r5)
            if (r4 > 0) goto L_0x02d7
            r4 = r8[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r5 = r1.get(r3)
            if (r4 != 0) goto L_0x02bc
            goto L_0x02d9
        L_0x02bc:
            int r4 = r4.intValue()
            if (r4 != r5) goto L_0x02d9
            r8 = r8[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r8 = r8.intValue()
            r4 = 2
            int r1 = r1.get(r4)
            int r8 = kotlin.g.b.k.a((int) r8, (int) r1)
            if (r8 <= 0) goto L_0x02d9
        L_0x02d7:
            r8 = 1
            goto L_0x02da
        L_0x02d9:
            r8 = 0
        L_0x02da:
            if (r8 != 0) goto L_0x02dd
            goto L_0x0313
        L_0x02dd:
            android.widget.EditText r8 = r7.f49356f
            if (r8 == 0) goto L_0x02e5
            android.text.Editable r0 = r8.getText()
        L_0x02e5:
            if (r0 != 0) goto L_0x02ea
            kotlin.g.b.k.a()
        L_0x02ea:
            int r8 = r0.length()
            int r0 = r7.H
            if (r8 >= r0) goto L_0x0358
            int r8 = net.one97.paytm.addmoney.R.string.enter_valid_cvv
            java.lang.String r8 = r7.getString(r8)
            java.lang.String r0 = "getString(R.string.enter_valid_cvv)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            android.content.Context r0 = r7.getContext()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            android.widget.Toast r8 = android.widget.Toast.makeText(r0, r8, r2)
            r8.show()
            return
        L_0x030b:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r8.<init>(r0)
            throw r8
        L_0x0313:
            android.widget.TextView r8 = r7.m
            if (r8 == 0) goto L_0x032b
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0320
            kotlin.g.b.k.a()
        L_0x0320:
            int r1 = net.one97.paytm.addmoney.R.string.invalid_expiry_date
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x032b:
            android.widget.TextView r8 = r7.m
            if (r8 == 0) goto L_0x0341
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0338
            kotlin.g.b.k.a()
        L_0x0338:
            int r1 = net.one97.paytm.addmoney.R.color.color_fd5c5c
            int r0 = androidx.core.content.b.c(r0, r1)
            r8.setTextColor(r0)
        L_0x0341:
            android.widget.EditText r8 = r7.f49357g
            if (r8 == 0) goto L_0x0357
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x034e
            kotlin.g.b.k.a()
        L_0x034e:
            int r1 = net.one97.paytm.addmoney.R.drawable.red_background_with_border_addmoney
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r1)
            r8.setBackground(r0)
        L_0x0357:
            return
        L_0x0358:
            net.one97.paytm.autoaddmoney.c.a r8 = r7.F
            if (r8 != 0) goto L_0x0362
            java.lang.String r0 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0362:
            java.lang.String r0 = "AutoAddmoneyNewCard"
            r8.a(r0, r3)
            return
        L_0x0368:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x0380
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0375
            kotlin.g.b.k.a()
        L_0x0375:
            int r1 = net.one97.paytm.addmoney.R.string.enter_valid_card_number
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x0380:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x0396
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x038d
            kotlin.g.b.k.a()
        L_0x038d:
            int r1 = net.one97.paytm.addmoney.R.color.color_fd5c5c
            int r0 = androidx.core.content.b.c(r0, r1)
            r8.setTextColor(r0)
        L_0x0396:
            android.widget.EditText r8 = r7.f49355e
            if (r8 == 0) goto L_0x03ac
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x03a3
            kotlin.g.b.k.a()
        L_0x03a3:
            int r1 = net.one97.paytm.addmoney.R.drawable.red_background_with_border_addmoney
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r1)
            r8.setBackground(r0)
        L_0x03ac:
            return
        L_0x03ad:
            android.widget.EditText r8 = r7.f49355e
            if (r8 == 0) goto L_0x03c3
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x03ba
            kotlin.g.b.k.a()
        L_0x03ba:
            int r1 = net.one97.paytm.addmoney.R.drawable.white_background_with_border_addmoney
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r1)
            r8.setBackground(r0)
        L_0x03c3:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x03db
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x03d0
            kotlin.g.b.k.a()
        L_0x03d0:
            int r1 = net.one97.paytm.addmoney.R.string.enter_card_number
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x03db:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x0436
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x03e8
            kotlin.g.b.k.a()
        L_0x03e8:
            int r1 = net.one97.paytm.addmoney.R.color.color_444444
            int r0 = androidx.core.content.b.c(r0, r1)
            r8.setTextColor(r0)
            return
        L_0x03f2:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x040a
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x03ff
            kotlin.g.b.k.a()
        L_0x03ff:
            int r1 = net.one97.paytm.addmoney.R.string.enter_valid_card_number
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x040a:
            android.widget.TextView r8 = r7.l
            if (r8 == 0) goto L_0x0420
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x0417
            kotlin.g.b.k.a()
        L_0x0417:
            int r1 = net.one97.paytm.addmoney.R.color.color_fd5c5c
            int r0 = androidx.core.content.b.c(r0, r1)
            r8.setTextColor(r0)
        L_0x0420:
            android.widget.EditText r8 = r7.f49355e
            if (r8 == 0) goto L_0x0436
            android.content.Context r0 = r7.getContext()
            if (r0 != 0) goto L_0x042d
            kotlin.g.b.k.a()
        L_0x042d:
            int r1 = net.one97.paytm.addmoney.R.drawable.red_background_with_border_addmoney
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r1)
            r8.setBackground(r0)
        L_0x0436:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.views.d.onClick(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static NetworkCustomError b(NetworkCustomError networkCustomError) {
        NetworkResponse networkResponse;
        if (networkCustomError != null) {
            try {
                networkResponse = networkCustomError.networkResponse;
            } catch (com.google.gson.p e2) {
                e2.printStackTrace();
            }
        } else {
            networkResponse = null;
        }
        if (networkResponse != null) {
            byte[] bArr = (networkCustomError != null ? networkCustomError.networkResponse : null).data;
            kotlin.g.b.k.a((Object) bArr, "volleyError?.networkResponse.data");
            String str = new String(bArr, kotlin.m.d.f47971a);
            new com.google.gson.q();
            com.google.gson.l a2 = com.google.gson.q.a(str);
            if (a2 != null) {
                com.google.gson.o oVar = (com.google.gson.o) a2;
                networkCustomError.setmAlertTitle("Error");
                if (oVar.b("error_description") != null) {
                    com.google.gson.l b2 = oVar.b("error_description");
                    kotlin.g.b.k.a((Object) b2, "obj.get(\"error_description\")");
                    networkCustomError.setAlertMessage(b2.c());
                }
                return networkCustomError;
            }
            throw new kotlin.u("null cannot be cast to non-null type com.google.gson.JsonObject");
        }
        return null;
    }

    static final class ab<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends kotlin.x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49362a;

        ab(d dVar) {
            this.f49362a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList j = this.f49362a.r;
            if ((j != null ? (IJRDataModel) j.get(this.f49362a.B) : null) instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
                if (d.m(this.f49362a) == null || TextUtils.isEmpty(d.m(this.f49362a).b())) {
                    this.f49362a.a(new net.one97.paytm.autoaddmoney.b.d("", false));
                    return;
                }
                net.one97.paytm.autoaddmoney.c.a o = d.o(this.f49362a);
                Context context = this.f49362a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                o.a(net.one97.paytm.addmoney.j.b(context, this.f49362a.getParentFragment()), d.m(this.f49362a).b(), AmAutomaticActivity.class.getName());
                this.f49362a.a("Payment_Proceed_clicked", SDKConstants.AI_KEY_PPBL);
            } else if (d.m(this.f49362a) == null || TextUtils.isEmpty(d.m(this.f49362a).a())) {
                this.f49362a.a(new net.one97.paytm.autoaddmoney.b.d("", false));
            } else {
                d.o(this.f49362a).a(this.f49362a.getClass().getName(), false);
            }
        }
    }

    static final class ac<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends kotlin.x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49363a;

        ac(d dVar) {
            this.f49363a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList j = this.f49363a.r;
            if ((j != null ? (IJRDataModel) j.get(this.f49363a.B) : null) instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
                if (d.m(this.f49363a) == null || TextUtils.isEmpty(d.m(this.f49363a).b())) {
                    this.f49363a.a(new net.one97.paytm.autoaddmoney.b.d("", false));
                    return;
                }
                net.one97.paytm.autoaddmoney.c.a o = d.o(this.f49363a);
                Context context = this.f49363a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                o.a(net.one97.paytm.addmoney.j.b(context, this.f49363a.getParentFragment()), d.m(this.f49363a).b(), AmAutomaticActivity.class.getName());
                this.f49363a.a("Payment_Proceed_clicked", SDKConstants.AI_KEY_PPBL);
            } else if (d.m(this.f49363a) == null || TextUtils.isEmpty(d.m(this.f49363a).a())) {
                this.f49363a.a(new net.one97.paytm.autoaddmoney.b.d("", false));
            } else {
                this.f49363a.C = true;
                d.o(this.f49363a).a(this.f49363a.getClass().getName(), false);
            }
        }
    }

    static final class ae<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49365a;

        ae(d dVar) {
            this.f49365a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            d dVar = this.f49365a;
            dVar.startActivity(new Intent(dVar.getActivity(), AmSupportedCardActivity.class));
        }
    }

    static final class p<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends kotlin.x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f49382a;

        p(d dVar) {
            this.f49382a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.c.a o = d.o(this.f49382a);
            ArrayList j = this.f49382a.r;
            ArrayList arrayList = new ArrayList();
            if (j != null) {
                Iterator it2 = j.iterator();
                while (it2.hasNext()) {
                    IJRDataModel iJRDataModel = (IJRDataModel) it2.next();
                    if (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card) {
                        arrayList.add(((CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel).getSavedCardId());
                    } else if (iJRDataModel instanceof CJRAvailableInstrumentsAddMoney.Card) {
                        arrayList.add(((CJRAvailableInstrumentsAddMoney.Card) iJRDataModel).getSavedCardId());
                    }
                }
            }
            o.y.f49241a.a(false, (a.h) new a.e(o, arrayList));
        }
    }

    public static final /* synthetic */ void a(d dVar, HasLowSuccess hasLowSuccess) {
        if (hasLowSuccess.getStatus()) {
            TextView textView = dVar.j;
            if (textView == null) {
                kotlin.g.b.k.a();
            }
            textView.setVisibility(0);
            TextView textView2 = dVar.j;
            if (textView2 == null) {
                kotlin.g.b.k.a();
            }
            textView2.setText(hasLowSuccess.getMsg());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:165:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void i(net.one97.paytm.autoaddmoney.views.d r7) {
        /*
            java.lang.String r0 = r7.L
            r1 = 1
            java.lang.String r2 = "CREDIT_CARD"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 == 0) goto L_0x0047
            net.one97.paytm.helper.a$a r0 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r0 = r0.a()
            java.lang.String r2 = "isCCAllowedForAutoAm"
            boolean r0 = r0.g((java.lang.String) r2)
            if (r0 != 0) goto L_0x0047
            android.widget.TextView r0 = r7.l
            if (r0 == 0) goto L_0x002f
            android.content.Context r2 = r7.getContext()
            if (r2 != 0) goto L_0x0026
            kotlin.g.b.k.a()
        L_0x0026:
            int r3 = net.one97.paytm.addmoney.R.color.color_fd5c5c
            int r2 = androidx.core.content.b.c(r2, r3)
            r0.setTextColor(r2)
        L_0x002f:
            android.widget.TextView r0 = r7.l
            if (r0 == 0) goto L_0x0047
            android.content.Context r2 = r7.getContext()
            if (r2 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            int r3 = net.one97.paytm.addmoney.R.string.credit_card_not_support_error
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0047:
            java.lang.String r0 = r7.J
            java.lang.String r2 = "MAESTRO"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            r3 = 0
            if (r0 == 0) goto L_0x0080
            android.widget.LinearLayout r0 = r7.o
            r4 = 1053609165(0x3ecccccd, float:0.4)
            if (r0 == 0) goto L_0x005c
            r0.setAlpha(r4)
        L_0x005c:
            android.widget.LinearLayout r0 = r7.o
            if (r0 == 0) goto L_0x0063
            r0.setEnabled(r3)
        L_0x0063:
            android.widget.EditText r0 = r7.f49356f
            if (r0 == 0) goto L_0x006a
            r0.setEnabled(r3)
        L_0x006a:
            android.widget.LinearLayout r0 = r7.p
            if (r0 == 0) goto L_0x0071
            r0.setAlpha(r4)
        L_0x0071:
            android.widget.LinearLayout r0 = r7.p
            if (r0 == 0) goto L_0x0078
            r0.setEnabled(r3)
        L_0x0078:
            android.widget.EditText r0 = r7.f49357g
            if (r0 == 0) goto L_0x00ac
            r0.setEnabled(r3)
            goto L_0x00ac
        L_0x0080:
            android.widget.LinearLayout r0 = r7.o
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0089
            r0.setAlpha(r4)
        L_0x0089:
            android.widget.LinearLayout r0 = r7.o
            if (r0 == 0) goto L_0x0090
            r0.setEnabled(r1)
        L_0x0090:
            android.widget.EditText r0 = r7.f49356f
            if (r0 == 0) goto L_0x0097
            r0.setEnabled(r1)
        L_0x0097:
            android.widget.LinearLayout r0 = r7.p
            if (r0 == 0) goto L_0x009e
            r0.setAlpha(r4)
        L_0x009e:
            android.widget.LinearLayout r0 = r7.p
            if (r0 == 0) goto L_0x00a5
            r0.setEnabled(r1)
        L_0x00a5:
            android.widget.EditText r0 = r7.f49357g
            if (r0 == 0) goto L_0x00ac
            r0.setEnabled(r1)
        L_0x00ac:
            java.lang.String r0 = r7.J
            java.lang.String r4 = "VISA"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
            r4 = 3
            r5 = 19
            if (r0 == 0) goto L_0x00f7
            android.widget.ImageView r0 = r7.f49359i
            if (r0 == 0) goto L_0x00cf
            android.content.Context r2 = r7.getContext()
            if (r2 != 0) goto L_0x00c6
            kotlin.g.b.k.a()
        L_0x00c6:
            int r6 = net.one97.paytm.addmoney.R.drawable.visa_logo_addmoney
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r6)
            r0.setImageDrawable(r2)
        L_0x00cf:
            android.widget.EditText r0 = r7.f49356f
            if (r0 == 0) goto L_0x00e1
            android.text.InputFilter[] r2 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r4)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r2[r3] = r6
            r0.setFilters(r2)
        L_0x00e1:
            android.widget.EditText r0 = r7.f49355e
            if (r0 == 0) goto L_0x00f3
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r2 = new android.text.InputFilter$LengthFilter
            r2.<init>(r5)
            android.text.InputFilter r2 = (android.text.InputFilter) r2
            r1[r3] = r2
            r0.setFilters(r1)
        L_0x00f3:
            r7.G = r5
            goto L_0x02b3
        L_0x00f7:
            java.lang.String r0 = r7.J
            java.lang.String r6 = "Master"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r6, (boolean) r1)
            if (r0 == 0) goto L_0x013f
            android.widget.EditText r0 = r7.f49356f
            if (r0 == 0) goto L_0x0113
            android.text.InputFilter[] r2 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r4)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r2[r3] = r6
            r0.setFilters(r2)
        L_0x0113:
            android.widget.EditText r0 = r7.f49355e
            if (r0 == 0) goto L_0x0125
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r2 = new android.text.InputFilter$LengthFilter
            r2.<init>(r5)
            android.text.InputFilter r2 = (android.text.InputFilter) r2
            r1[r3] = r2
            r0.setFilters(r1)
        L_0x0125:
            android.widget.ImageView r0 = r7.f49359i
            if (r0 == 0) goto L_0x013b
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L_0x0132
            kotlin.g.b.k.a()
        L_0x0132:
            int r2 = net.one97.paytm.addmoney.R.drawable.ic_mastercard_logo_addmoney
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setImageDrawable(r1)
        L_0x013b:
            r7.G = r5
            goto L_0x02b3
        L_0x013f:
            java.lang.String r0 = r7.J
            java.lang.String r6 = "Diners"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r6, (boolean) r1)
            if (r0 == 0) goto L_0x0189
            android.widget.ImageView r0 = r7.f49359i
            if (r0 == 0) goto L_0x015f
            android.content.Context r2 = r7.getContext()
            if (r2 != 0) goto L_0x0156
            kotlin.g.b.k.a()
        L_0x0156:
            int r5 = net.one97.paytm.addmoney.R.drawable.diners_addmoney
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r5)
            r0.setImageDrawable(r2)
        L_0x015f:
            android.widget.EditText r0 = r7.f49356f
            if (r0 == 0) goto L_0x0171
            android.text.InputFilter[] r2 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
            r5.<init>(r4)
            android.text.InputFilter r5 = (android.text.InputFilter) r5
            r2[r3] = r5
            r0.setFilters(r2)
        L_0x0171:
            android.widget.EditText r0 = r7.f49355e
            r2 = 17
            if (r0 == 0) goto L_0x0185
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
            r5.<init>(r2)
            android.text.InputFilter r5 = (android.text.InputFilter) r5
            r1[r3] = r5
            r0.setFilters(r1)
        L_0x0185:
            r7.G = r2
            goto L_0x02b3
        L_0x0189:
            java.lang.String r0 = r7.J
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            r2 = 23
            if (r0 == 0) goto L_0x01c6
            android.widget.LinearLayout r0 = r7.o
            if (r0 == 0) goto L_0x019a
            r0.setEnabled(r3)
        L_0x019a:
            android.widget.EditText r0 = r7.f49355e
            if (r0 == 0) goto L_0x01ac
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r4 = new android.text.InputFilter$LengthFilter
            r4.<init>(r2)
            android.text.InputFilter r4 = (android.text.InputFilter) r4
            r1[r3] = r4
            r0.setFilters(r1)
        L_0x01ac:
            android.widget.ImageView r0 = r7.f49359i
            if (r0 == 0) goto L_0x01c2
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L_0x01b9
            kotlin.g.b.k.a()
        L_0x01b9:
            int r4 = net.one97.paytm.addmoney.R.drawable.maestro_icon_addmoney
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r4)
            r0.setImageDrawable(r1)
        L_0x01c2:
            r7.G = r2
            goto L_0x02b5
        L_0x01c6:
            java.lang.String r0 = r7.J
            java.lang.String r6 = "Amex"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r6, (boolean) r1)
            if (r0 == 0) goto L_0x0211
            android.widget.EditText r0 = r7.f49355e
            if (r0 == 0) goto L_0x01e2
            android.text.InputFilter[] r4 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
            r5.<init>(r2)
            android.text.InputFilter r5 = (android.text.InputFilter) r5
            r4[r3] = r5
            r0.setFilters(r4)
        L_0x01e2:
            android.widget.EditText r0 = r7.f49356f
            r4 = 4
            if (r0 == 0) goto L_0x01f5
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
            r5.<init>(r4)
            android.text.InputFilter r5 = (android.text.InputFilter) r5
            r1[r3] = r5
            r0.setFilters(r1)
        L_0x01f5:
            android.widget.ImageView r0 = r7.f49359i
            if (r0 == 0) goto L_0x020b
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L_0x0202
            kotlin.g.b.k.a()
        L_0x0202:
            int r5 = net.one97.paytm.addmoney.R.drawable.amex_addmoney
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r5)
            r0.setImageDrawable(r1)
        L_0x020b:
            r7.G = r2
            r7.H = r4
            goto L_0x02b5
        L_0x0211:
            java.lang.String r0 = r7.J
            java.lang.String r6 = "JCB"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r6, (boolean) r1)
            if (r0 == 0) goto L_0x0258
            android.widget.EditText r0 = r7.f49356f
            if (r0 == 0) goto L_0x022d
            android.text.InputFilter[] r2 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r4)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r2[r3] = r6
            r0.setFilters(r2)
        L_0x022d:
            android.widget.EditText r0 = r7.f49355e
            if (r0 == 0) goto L_0x023f
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r2 = new android.text.InputFilter$LengthFilter
            r2.<init>(r5)
            android.text.InputFilter r2 = (android.text.InputFilter) r2
            r1[r3] = r2
            r0.setFilters(r1)
        L_0x023f:
            android.widget.ImageView r0 = r7.f49359i
            if (r0 == 0) goto L_0x0255
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L_0x024c
            kotlin.g.b.k.a()
        L_0x024c:
            int r2 = net.one97.paytm.addmoney.R.drawable.jcb_addmoney
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setImageDrawable(r1)
        L_0x0255:
            r7.G = r5
            goto L_0x02b3
        L_0x0258:
            java.lang.String r0 = r7.J
            java.lang.String r6 = "RUPAY"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r6, (boolean) r1)
            if (r0 == 0) goto L_0x029f
            android.widget.EditText r0 = r7.f49356f
            if (r0 == 0) goto L_0x0274
            android.text.InputFilter[] r2 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r4)
            android.text.InputFilter r6 = (android.text.InputFilter) r6
            r2[r3] = r6
            r0.setFilters(r2)
        L_0x0274:
            android.widget.EditText r0 = r7.f49355e
            if (r0 == 0) goto L_0x0286
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r2 = new android.text.InputFilter$LengthFilter
            r2.<init>(r5)
            android.text.InputFilter r2 = (android.text.InputFilter) r2
            r1[r3] = r2
            r0.setFilters(r1)
        L_0x0286:
            android.widget.ImageView r0 = r7.f49359i
            if (r0 == 0) goto L_0x029c
            android.content.Context r1 = r7.getContext()
            if (r1 != 0) goto L_0x0293
            kotlin.g.b.k.a()
        L_0x0293:
            int r2 = net.one97.paytm.addmoney.R.drawable.rupay_addmoney
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setImageDrawable(r1)
        L_0x029c:
            r7.G = r5
            goto L_0x02b3
        L_0x029f:
            r7.G = r2
            android.widget.EditText r0 = r7.f49355e
            if (r0 == 0) goto L_0x02b3
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
            r5.<init>(r2)
            android.text.InputFilter r5 = (android.text.InputFilter) r5
            r1[r3] = r5
            r0.setFilters(r1)
        L_0x02b3:
            r7.H = r4
        L_0x02b5:
            android.widget.ImageView r7 = r7.f49359i
            if (r7 == 0) goto L_0x02bc
            r7.setVisibility(r3)
        L_0x02bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.autoaddmoney.views.d.i(net.one97.paytm.autoaddmoney.views.d):void");
    }

    public static final /* synthetic */ void s(d dVar) {
        if (AddMoneyUtils.a((Fragment) dVar)) {
            com.paytm.utility.h hVar = new com.paytm.utility.h(dVar.getActivity());
            hVar.a(dVar.getResources().getString(R.string.edit_standing_instructions));
            hVar.a(-1, dVar.getResources().getString(R.string.yes), new f(hVar));
            hVar.a(-2, dVar.getResources().getString(R.string.no), new g(dVar, hVar));
            hVar.show();
        }
    }

    public static final /* synthetic */ IJRDataModel w(d dVar) {
        int i2 = dVar.B;
        IJRDataModel iJRDataModel = null;
        if (i2 >= 0) {
            ArrayList<IJRDataModel> arrayList = dVar.r;
            if ((arrayList != null ? arrayList.get(i2) : null) instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card) {
                ArrayList<IJRDataModel> arrayList2 = dVar.r;
                if (arrayList2 != null) {
                    iJRDataModel = arrayList2.get(dVar.B);
                }
                if (iJRDataModel != null) {
                    return (CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card");
            }
            ArrayList<IJRDataModel> arrayList3 = dVar.r;
            if ((arrayList3 != null ? arrayList3.get(dVar.B) : null) instanceof CJRAvailableInstrumentsAddMoney.Card) {
                ArrayList<IJRDataModel> arrayList4 = dVar.r;
                if (arrayList4 != null) {
                    iJRDataModel = arrayList4.get(dVar.B);
                }
                if (iJRDataModel != null) {
                    return (CJRAvailableInstrumentsAddMoney.Card) iJRDataModel;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card");
            }
            ArrayList<IJRDataModel> arrayList5 = dVar.r;
            if ((arrayList5 != null ? arrayList5.get(dVar.B) : null) instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
                ArrayList<IJRDataModel> arrayList6 = dVar.r;
                if (arrayList6 != null) {
                    iJRDataModel = arrayList6.get(dVar.B);
                }
                if (iJRDataModel != null) {
                    return (CJRAvailableInstrumentsAddMoneyPPBL.Card) iJRDataModel;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL.Card");
            }
        }
        return null;
    }

    public static final /* synthetic */ void a(d dVar, String str, IJRDataModel iJRDataModel, String str2, boolean z2) {
        Intent intent = new Intent(dVar.getActivity(), AmAutomaticResultActivity.class);
        intent.putExtra("min_amount", dVar.f49353c);
        intent.putExtra("auto_amount", dVar.f49354d);
        intent.putExtra("SAVED_CARD", iJRDataModel);
        intent.putExtra(SDKConstants.STATUS, str);
        intent.putExtra("STATUS_MESSAGE", str2);
        if ("FAILED".equals(str)) {
            intent.putExtra("isTransactionOrSubscriptionFailed", z2);
            Fragment parentFragment = dVar.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startActivityForResult(intent, 2091);
            }
            dVar.a("Post_creation_page_loaded", "Failure");
            return;
        }
        dVar.a("Post_creation_page_loaded", "Successful");
        dVar.startActivity(intent);
        FragmentActivity activity = dVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final /* synthetic */ b y(d dVar) {
        androidx.fragment.app.j supportFragmentManager;
        if (dVar.getActivity() != null) {
            FragmentActivity activity = dVar.getActivity();
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (!valueOf.booleanValue()) {
                FragmentActivity activity2 = dVar.getActivity();
                Fragment c2 = (activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null) ? null : supportFragmentManager.c(R.id.framelayout);
                if (c2 != null && (c2 instanceof b)) {
                    b bVar = (b) c2;
                    if (bVar.isResumed()) {
                        return bVar;
                    }
                }
            }
        }
        return null;
    }

    public static final /* synthetic */ void a(d dVar, View view) {
        if (dVar.b()) {
            FragmentActivity activity = dVar.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (view != null) {
                if (inputMethodManager == null) {
                    kotlin.g.b.k.a();
                }
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public static final /* synthetic */ void e(d dVar, String str) {
        net.one97.paytm.autoaddmoney.c.a aVar = dVar.F;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        kotlin.g.b.k.c(str, "cardString");
        aVar.y.a(str, (a.e) new a.c(aVar));
    }
}
