package com.travel.flight.flightticket.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.activity.FlightWebViewActivity;
import com.travel.flight.flightticket.a.o;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem;
import com.travel.utils.q;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.u;

public final class g extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24981a = new a((byte) 0);
    /* access modifiers changed from: private */
    public static String n = "FlightTravelInsuranceFragment";

    /* renamed from: b  reason: collision with root package name */
    private ConstraintLayout f24982b;

    /* renamed from: c  reason: collision with root package name */
    private ConstraintLayout f24983c;

    /* renamed from: d  reason: collision with root package name */
    private EditText f24984d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24985e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CJRInsuranceItem f24986f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f24987g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f24988h;

    /* renamed from: i  reason: collision with root package name */
    private o f24989i;
    /* access modifiers changed from: private */
    public com.travel.flight.flightticket.f.l j;
    private com.travel.flight.flightticket.e.j k = com.travel.flight.flightticket.e.j.MAIN;
    /* access modifiers changed from: private */
    public boolean l;
    private ScrollView m;
    private HashMap o;

    public static final /* synthetic */ TextView c(g gVar) {
        TextView textView = gVar.f24985e;
        if (textView == null) {
            kotlin.g.b.k.a("mDaysYesBtn");
        }
        return textView;
    }

    public static final /* synthetic */ TextView d(g gVar) {
        TextView textView = gVar.f24988h;
        if (textView == null) {
            kotlin.g.b.k.a("mErrorTxt");
        }
        return textView;
    }

    public static final /* synthetic */ EditText j(g gVar) {
        EditText editText = gVar.f24984d;
        if (editText == null) {
            kotlin.g.b.k.a("mDaysBox");
        }
        return editText;
    }

    public static final /* synthetic */ ConstraintLayout k(g gVar) {
        ConstraintLayout constraintLayout = gVar.f24982b;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("mInsuranceLyt");
        }
        return constraintLayout;
    }

    public static final /* synthetic */ ScrollView l(g gVar) {
        ScrollView scrollView = gVar.m;
        if (scrollView == null) {
            kotlin.g.b.k.a("mMainScrollView");
        }
        return scrollView;
    }

    public static final /* synthetic */ ConstraintLayout m(g gVar) {
        ConstraintLayout constraintLayout = gVar.f24983c;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("mDaysLyt");
        }
        return constraintLayout;
    }

    static final class d implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24993a;

        d(g gVar) {
            this.f24993a = gVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            g.a(dialogInterface);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(new d(this));
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        q.c(context);
        super.onAttach(context);
    }

    public final void onCreate(Bundle bundle) {
        setStyle(0, R.style.AdjustResizeBottomSheetStyle);
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.activity_flight_travel_insurance, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.j = (com.travel.flight.flightticket.f.l) activity;
            return;
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightticket.listener.IJRTravelInsuranceListener");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0536  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0265  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r11, android.os.Bundle r12) {
        /*
            r10 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r11, r0)
            super.onViewCreated(r11, r12)
            android.os.Bundle r12 = r10.getArguments()
            r0 = 0
            if (r12 == 0) goto L_0x006a
            android.os.Bundle r12 = r10.getArguments()
            if (r12 != 0) goto L_0x0019
            kotlin.g.b.k.a()
        L_0x0019:
            java.lang.String r1 = "intent_extra_flight_travel_insurance"
            boolean r12 = r12.containsKey(r1)
            if (r12 == 0) goto L_0x0032
            android.os.Bundle r12 = r10.getArguments()
            if (r12 != 0) goto L_0x002a
            kotlin.g.b.k.a()
        L_0x002a:
            java.io.Serializable r12 = r12.getSerializable(r1)
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = (com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem) r12
            r10.f24986f = r12
        L_0x0032:
            android.os.Bundle r12 = r10.getArguments()
            if (r12 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            java.lang.String r1 = "intent_extra_flight_travel_insurance_view_type"
            boolean r12 = r12.containsKey(r1)
            if (r12 == 0) goto L_0x006a
            android.os.Bundle r12 = r10.getArguments()
            if (r12 != 0) goto L_0x004c
            kotlin.g.b.k.a()
        L_0x004c:
            int r12 = r12.getInt(r1)
            com.travel.flight.flightticket.e.j$a r1 = com.travel.flight.flightticket.e.j.Companion
            com.travel.flight.flightticket.e.j[] r1 = com.travel.flight.flightticket.e.j.values()
            int r2 = r1.length
            r3 = 0
        L_0x0058:
            if (r3 >= r2) goto L_0x0066
            r4 = r1[r3]
            int r5 = r4.getInputValue()
            if (r5 != r12) goto L_0x0063
            goto L_0x0068
        L_0x0063:
            int r3 = r3 + 1
            goto L_0x0058
        L_0x0066:
            com.travel.flight.flightticket.e.j r4 = com.travel.flight.flightticket.e.j.MAIN
        L_0x0068:
            r10.k = r4
        L_0x006a:
            int r12 = com.travel.flight.R.id.main_scroll_view
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r1 = "view.findViewById(R.id.main_scroll_view)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            android.widget.ScrollView r12 = (android.widget.ScrollView) r12
            r10.m = r12
            int r12 = com.travel.flight.R.id.insurance_opt_lyt
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r1 = "view.findViewById(R.id.insurance_opt_lyt)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r10.f24982b = r12
            int r12 = com.travel.flight.R.id.days_lyt
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r1 = "view.findViewById(R.id.days_lyt)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r10.f24983c = r12
            int r12 = com.travel.flight.R.id.day_box
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r1 = "view.findViewById(R.id.day_box)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            android.widget.EditText r12 = (android.widget.EditText) r12
            r10.f24984d = r12
            int r12 = com.travel.flight.R.id.insurance_lyt_recyler_view
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r1 = "view.findViewById(R.id.insurance_lyt_recyler_view)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            r10.f24987g = r12
            int r12 = com.travel.flight.R.id.error_txt
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r1 = "view.findViewById(R.id.error_txt)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r10.f24988h = r12
            int r12 = com.travel.flight.R.id.days_lyt_yes_btn
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r1 = "view.findViewById(R.id.days_lyt_yes_btn)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r10.f24985e = r12
            com.travel.flight.flightticket.e.j r12 = r10.k
            com.travel.flight.flightticket.e.j r1 = com.travel.flight.flightticket.e.j.DAYS
            boolean r12 = r12.equals(r1)
            r1 = 0
            if (r12 == 0) goto L_0x0118
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x00f2
            boolean r12 = r12.isOne_way_international()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            goto L_0x00f3
        L_0x00f2:
            r12 = r1
        L_0x00f3:
            if (r12 != 0) goto L_0x00f8
            kotlin.g.b.k.a()
        L_0x00f8:
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0118
            androidx.constraintlayout.widget.ConstraintLayout r12 = r10.f24983c
            if (r12 != 0) goto L_0x0107
            java.lang.String r2 = "mDaysLyt"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0107:
            r12.setVisibility(r0)
            androidx.constraintlayout.widget.ConstraintLayout r12 = r10.f24982b
            if (r12 != 0) goto L_0x0113
            java.lang.String r2 = "mInsuranceLyt"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0113:
            r2 = 8
            r12.setVisibility(r2)
        L_0x0118:
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x058a
            int r12 = com.travel.flight.R.id.insurance_lyt_title_1
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r2 = "view.findViewById<TextVi…id.insurance_lyt_title_1)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r2 = r10.f24986f
            if (r2 == 0) goto L_0x0133
            java.lang.String r2 = r2.getTitle()
            goto L_0x0134
        L_0x0133:
            r2 = r1
        L_0x0134:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            int r12 = com.travel.flight.R.id.insurance_lyt_title_2
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r2 = "view.findViewById<TextVi…id.insurance_lyt_title_2)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r2 = r10.f24986f
            if (r2 == 0) goto L_0x0150
            java.lang.String r2 = r2.getHeader()
            goto L_0x0151
        L_0x0150:
            r2 = r1
        L_0x0151:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            int r12 = com.travel.flight.R.id.insurance_lyt_title_3
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r2 = "view.findViewById<TextVi…id.insurance_lyt_title_3)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r2 = r10.f24986f
            if (r2 == 0) goto L_0x016d
            java.lang.String r2 = r2.getSub_text()
            goto L_0x016e
        L_0x016d:
            r2 = r1
        L_0x016e:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x017c
            java.util.ArrayList r12 = r12.getPriceDetails()
            goto L_0x017d
        L_0x017c:
            r12 = r1
        L_0x017d:
            java.lang.String r2 = "resources.getString(R.st…rance_yes_secure_my_trip)"
            java.lang.String r3 = "java.lang.String.format(format, *args)"
            r4 = 1
            if (r12 == 0) goto L_0x022e
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x018d
            java.util.ArrayList r12 = r12.getPriceDetails()
            goto L_0x018e
        L_0x018d:
            r12 = r1
        L_0x018e:
            if (r12 != 0) goto L_0x0193
            kotlin.g.b.k.a()
        L_0x0193:
            int r12 = r12.size()
            if (r12 <= 0) goto L_0x022e
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x01a6
            boolean r12 = r12.isOne_way_international()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            goto L_0x01a7
        L_0x01a6:
            r12 = r1
        L_0x01a7:
            if (r12 != 0) goto L_0x01ac
            kotlin.g.b.k.a()
        L_0x01ac:
            boolean r12 = r12.booleanValue()
            java.lang.String r5 = "mInsuranceItem?.priceDetails!!.get(0)"
            if (r12 == 0) goto L_0x01f1
            kotlin.g.b.aa r12 = kotlin.g.b.aa.f47921a
            android.content.res.Resources r12 = r10.getResources()
            int r6 = com.travel.flight.R.string.flight_insurance_yes_secure_per_passenger_per_day
            java.lang.String r12 = r12.getString(r6)
            java.lang.String r6 = "resources.getString(R.st…re_per_passenger_per_day)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r7 = r10.f24986f
            if (r7 == 0) goto L_0x01d0
            java.util.ArrayList r7 = r7.getPriceDetails()
            goto L_0x01d1
        L_0x01d0:
            r7 = r1
        L_0x01d1:
            if (r7 != 0) goto L_0x01d6
            kotlin.g.b.k.a()
        L_0x01d6:
            java.lang.Object r7 = r7.get(r0)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail r7 = (com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail) r7
            java.lang.String r5 = r7.getPremiumPerPassenger()
            r6[r0] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r12 = java.lang.String.format(r12, r5)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            goto L_0x023b
        L_0x01f1:
            kotlin.g.b.aa r12 = kotlin.g.b.aa.f47921a
            android.content.res.Resources r12 = r10.getResources()
            int r6 = com.travel.flight.R.string.flight_insurance_yes_secure_per_passenger
            java.lang.String r12 = r12.getString(r6)
            java.lang.String r6 = "resources.getString(R.st…yes_secure_per_passenger)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r7 = r10.f24986f
            if (r7 == 0) goto L_0x020d
            java.util.ArrayList r7 = r7.getPriceDetails()
            goto L_0x020e
        L_0x020d:
            r7 = r1
        L_0x020e:
            if (r7 != 0) goto L_0x0213
            kotlin.g.b.k.a()
        L_0x0213:
            java.lang.Object r7 = r7.get(r0)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail r7 = (com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail) r7
            java.lang.String r5 = r7.getPremiumPerPassenger()
            r6[r0] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r12 = java.lang.String.format(r12, r5)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            goto L_0x023b
        L_0x022e:
            android.content.res.Resources r12 = r10.getResources()
            int r5 = com.travel.flight.R.string.flight_insurance_yes_secure_my_trip
            java.lang.String r12 = r12.getString(r5)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
        L_0x023b:
            int r5 = com.travel.flight.R.id.insuarnce_lyt_yes__btn
            android.view.View r5 = r11.findViewById(r5)
            java.lang.String r6 = "view.findViewById<TextVi…d.insuarnce_lyt_yes__btn)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r5.setText(r12)
            int r12 = com.travel.flight.R.id.insuarnce_lyt_no__btn
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r5 = "view.findViewById<TextVi…id.insuarnce_lyt_no__btn)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r5 = r10.f24986f
            if (r5 == 0) goto L_0x0265
            java.lang.String r5 = r5.getOptOutText()
            goto L_0x0266
        L_0x0265:
            r5 = r1
        L_0x0266:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r12.setText(r5)
            int r12 = com.travel.flight.R.id.days_lyt_no_btn
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r5 = "view.findViewById<TextView>(R.id.days_lyt_no_btn)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r5 = r10.f24986f
            if (r5 == 0) goto L_0x0282
            java.lang.String r5 = r5.getOptOutText()
            goto L_0x0283
        L_0x0282:
            r5 = r1
        L_0x0283:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r12.setText(r5)
            com.travel.flight.flightticket.fragment.g$l r12 = new com.travel.flight.flightticket.fragment.g$l
            r12.<init>(r10)
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r5 = r10.f24986f
            if (r5 == 0) goto L_0x0296
            java.lang.String r5 = r5.getTnc_text()
            goto L_0x0297
        L_0x0296:
            r5 = r1
        L_0x0297:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x02a4
            int r5 = r5.length()
            if (r5 != 0) goto L_0x02a2
            goto L_0x02a4
        L_0x02a2:
            r5 = 0
            goto L_0x02a5
        L_0x02a4:
            r5 = 1
        L_0x02a5:
            if (r5 != 0) goto L_0x0301
            int r5 = com.travel.flight.R.id.insurance_lyt_tnc
            android.view.View r5 = r11.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.text.SpannableString r6 = new android.text.SpannableString
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r7 = r10.f24986f
            if (r7 == 0) goto L_0x02ba
            java.lang.String r7 = r7.getTnc_text()
            goto L_0x02bb
        L_0x02ba:
            r7 = r1
        L_0x02bb:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.<init>(r7)
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r7 = r10.f24986f
            if (r7 == 0) goto L_0x02c9
            java.lang.String r7 = r7.getTnc_text()
            goto L_0x02ca
        L_0x02c9:
            r7 = r1
        L_0x02ca:
            if (r7 != 0) goto L_0x02cf
            kotlin.g.b.k.a()
        L_0x02cf:
            int r7 = r7.length()
            int r7 = r7 + -3
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r8 = r10.f24986f
            if (r8 == 0) goto L_0x02de
            java.lang.String r8 = r8.getTnc_text()
            goto L_0x02df
        L_0x02de:
            r8 = r1
        L_0x02df:
            if (r8 != 0) goto L_0x02e4
            kotlin.g.b.k.a()
        L_0x02e4:
            int r8 = r8.length()
            r9 = 33
            r6.setSpan(r12, r7, r8, r9)
            java.lang.String r12 = "insuranceTextView"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            r5.setClickable(r4)
            android.text.method.MovementMethod r12 = android.text.method.LinkMovementMethod.getInstance()
            r5.setMovementMethod(r12)
        L_0x0301:
            int r12 = com.travel.flight.R.id.insurance_lyt_soldby
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r5 = "view.findViewById<TextVi….id.insurance_lyt_soldby)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.aa r5 = kotlin.g.b.aa.f47921a
            android.content.res.Resources r5 = r10.getResources()
            int r6 = com.travel.flight.R.string.flight_insurance_sold_by
            java.lang.String r5 = r5.getString(r6)
            java.lang.String r6 = "resources.getString(R.st…flight_insurance_sold_by)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r7 = r10.f24986f
            if (r7 == 0) goto L_0x032b
            java.lang.String r7 = r7.getInsuranceProvider()
            goto L_0x032c
        L_0x032b:
            r7 = r1
        L_0x032c:
            r6[r0] = r7
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r4)
            java.lang.String r5 = java.lang.String.format(r5, r6)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r12.setText(r5)
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x034b
            boolean r12 = r12.isOne_way_international()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            goto L_0x034c
        L_0x034b:
            r12 = r1
        L_0x034c:
            if (r12 != 0) goto L_0x0351
            kotlin.g.b.k.a()
        L_0x0351:
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x052a
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x0360
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r12 = r12.getUserInputInfo()
            goto L_0x0361
        L_0x0360:
            r12 = r1
        L_0x0361:
            if (r12 == 0) goto L_0x052a
            android.widget.EditText r12 = r10.f24984d
            java.lang.String r5 = "mDaysBox"
            if (r12 != 0) goto L_0x036c
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x036c:
            com.travel.flight.flightticket.fragment.g$e r6 = new com.travel.flight.flightticket.fragment.g$e
            r6.<init>(r10)
            android.widget.TextView$OnEditorActionListener r6 = (android.widget.TextView.OnEditorActionListener) r6
            r12.setOnEditorActionListener(r6)
            android.widget.EditText r12 = r10.f24984d
            if (r12 != 0) goto L_0x037d
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x037d:
            com.travel.flight.flightticket.fragment.g$f r6 = new com.travel.flight.flightticket.fragment.g$f
            r6.<init>(r10)
            android.text.TextWatcher r6 = (android.text.TextWatcher) r6
            r12.addTextChangedListener(r6)
            int r12 = com.travel.flight.R.id.day_box_lyt
            android.view.View r12 = r11.findViewById(r12)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            com.travel.flight.flightticket.fragment.g$g r6 = new com.travel.flight.flightticket.fragment.g$g
            r6.<init>(r10)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r12.setOnClickListener(r6)
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x03a8
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r12 = r12.getUserInputInfo()
            if (r12 == 0) goto L_0x03a8
            java.lang.String r12 = r12.getDefault_insured_days()
            goto L_0x03a9
        L_0x03a8:
            r12 = r1
        L_0x03a9:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x03b6
            boolean r12 = kotlin.m.p.a(r12)
            if (r12 == 0) goto L_0x03b4
            goto L_0x03b6
        L_0x03b4:
            r12 = 0
            goto L_0x03b7
        L_0x03b6:
            r12 = 1
        L_0x03b7:
            if (r12 != 0) goto L_0x047c
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x03cc
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r12 = r12.getUserInputInfo()
            if (r12 == 0) goto L_0x03cc
            int r12 = r12.getSelectedDays()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x03cd
        L_0x03cc:
            r12 = r1
        L_0x03cd:
            if (r12 != 0) goto L_0x03d2
            kotlin.g.b.k.a()
        L_0x03d2:
            int r12 = r12.intValue()
            java.lang.String r2 = "resources.getString(R.st…_yes_secure_my_trip_days)"
            if (r12 <= 0) goto L_0x0431
            android.widget.EditText r12 = r10.f24984d
            if (r12 != 0) goto L_0x03e1
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x03e1:
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r5 = r10.f24986f
            if (r5 == 0) goto L_0x03f4
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r5 = r5.getUserInputInfo()
            if (r5 == 0) goto L_0x03f4
            int r5 = r5.getSelectedDays()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x03f5
        L_0x03f4:
            r5 = r1
        L_0x03f5:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r12.setText(r5)
            kotlin.g.b.aa r12 = kotlin.g.b.aa.f47921a
            android.content.res.Resources r12 = r10.getResources()
            int r5 = com.travel.flight.R.string.flight_insurance_yes_secure_my_trip_days
            java.lang.String r12 = r12.getString(r5)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            java.lang.Object[] r2 = new java.lang.Object[r4]
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r5 = r10.f24986f
            if (r5 == 0) goto L_0x0422
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r5 = r5.getUserInputInfo()
            if (r5 == 0) goto L_0x0422
            int r5 = r5.getSelectedDays()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0423
        L_0x0422:
            r5 = r1
        L_0x0423:
            r2[r0] = r5
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            java.lang.String r12 = java.lang.String.format(r12, r2)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            goto L_0x0489
        L_0x0431:
            android.widget.EditText r12 = r10.f24984d
            if (r12 != 0) goto L_0x0438
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0438:
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r5 = r10.f24986f
            if (r5 == 0) goto L_0x0447
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r5 = r5.getUserInputInfo()
            if (r5 == 0) goto L_0x0447
            java.lang.String r5 = r5.getDefault_insured_days()
            goto L_0x0448
        L_0x0447:
            r5 = r1
        L_0x0448:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r12.setText(r5)
            kotlin.g.b.aa r12 = kotlin.g.b.aa.f47921a
            android.content.res.Resources r12 = r10.getResources()
            int r5 = com.travel.flight.R.string.flight_insurance_yes_secure_my_trip_days
            java.lang.String r12 = r12.getString(r5)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            java.lang.Object[] r2 = new java.lang.Object[r4]
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r5 = r10.f24986f
            if (r5 == 0) goto L_0x046d
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r5 = r5.getUserInputInfo()
            if (r5 == 0) goto L_0x046d
            java.lang.String r5 = r5.getDefault_insured_days()
            goto L_0x046e
        L_0x046d:
            r5 = r1
        L_0x046e:
            r2[r0] = r5
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            java.lang.String r12 = java.lang.String.format(r12, r2)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            goto L_0x0489
        L_0x047c:
            android.content.res.Resources r12 = r10.getResources()
            int r5 = com.travel.flight.R.string.flight_insurance_yes_secure_my_trip
            java.lang.String r12 = r12.getString(r5)
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
        L_0x0489:
            int r2 = com.travel.flight.R.id.days_lyt_yes_btn
            android.view.View r2 = r11.findViewById(r2)
            java.lang.String r5 = "view.findViewById<TextView>(R.id.days_lyt_yes_btn)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r2.setText(r12)
            int r12 = com.travel.flight.R.id.days_lyt_title_1
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r2 = "view.findViewById<TextView>(R.id.days_lyt_title_1)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r2 = r10.f24986f
            if (r2 == 0) goto L_0x04b9
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r2 = r2.getUserInputInfo()
            if (r2 == 0) goto L_0x04b9
            java.lang.String r2 = r2.getHeader()
            goto L_0x04ba
        L_0x04b9:
            r2 = r1
        L_0x04ba:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            int r12 = com.travel.flight.R.id.days_lyt_title_2
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r2 = "view.findViewById<TextView>(R.id.days_lyt_title_2)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r2 = r10.f24986f
            if (r2 == 0) goto L_0x04dc
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r2 = r2.getUserInputInfo()
            if (r2 == 0) goto L_0x04dc
            java.lang.String r2 = r2.getTitle()
            goto L_0x04dd
        L_0x04dc:
            r2 = r1
        L_0x04dd:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            int r12 = com.travel.flight.R.id.days_detail_txt
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r2 = "view.findViewById<TextView>(R.id.days_detail_txt)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            android.content.res.Resources r2 = r10.getResources()
            int r5 = com.travel.flight.R.string.flight_insurance_per_day_per_traveler
            java.lang.String r2 = r2.getString(r5)
            java.lang.String r5 = "resources.getString(R.st…nce_per_day_per_traveler)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.lang.Object[] r5 = new java.lang.Object[r4]
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r6 = r10.f24986f
            if (r6 == 0) goto L_0x0517
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r6 = r6.getUserInputInfo()
            if (r6 == 0) goto L_0x0517
            double r6 = r6.getPremium_per_day()
            int r6 = (int) r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0518
        L_0x0517:
            r6 = r1
        L_0x0518:
            r5[r0] = r6
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r5, r4)
            java.lang.String r0 = java.lang.String.format(r2, r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
        L_0x052a:
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x0533
            java.util.ArrayList r12 = r12.getBenefits()
            goto L_0x0534
        L_0x0533:
            r12 = r1
        L_0x0534:
            if (r12 == 0) goto L_0x058a
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r12 = r10.f24986f
            if (r12 == 0) goto L_0x053f
            java.util.ArrayList r12 = r12.getBenefits()
            goto L_0x0540
        L_0x053f:
            r12 = r1
        L_0x0540:
            if (r12 != 0) goto L_0x0545
            kotlin.g.b.k.a()
        L_0x0545:
            int r12 = r12.size()
            if (r12 <= 0) goto L_0x058a
            com.travel.flight.flightticket.a.o r12 = new com.travel.flight.flightticket.a.o
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r0 = r10.f24986f
            if (r0 == 0) goto L_0x0555
            java.util.ArrayList r1 = r0.getBenefits()
        L_0x0555:
            if (r1 != 0) goto L_0x055a
            kotlin.g.b.k.a()
        L_0x055a:
            java.util.List r1 = (java.util.List) r1
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            if (r0 != 0) goto L_0x0565
            kotlin.g.b.k.a()
        L_0x0565:
            java.lang.String r2 = "this.activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r2 = "this.activity!!.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r12.<init>(r1, r0)
            r10.f24989i = r12
            androidx.recyclerview.widget.RecyclerView r12 = r10.f24987g
            if (r12 != 0) goto L_0x0583
            java.lang.String r0 = "mBenefitsRecyler"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0583:
            com.travel.flight.flightticket.a.o r0 = r10.f24989i
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r12.setAdapter(r0)
        L_0x058a:
            int r12 = com.travel.flight.R.id.insuarnce_lyt_yes__btn
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.flightticket.fragment.g$h r0 = new com.travel.flight.flightticket.fragment.g$h
            r0.<init>(r10)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r12.setOnClickListener(r0)
            android.widget.TextView r12 = r10.f24985e
            if (r12 != 0) goto L_0x05a5
            java.lang.String r0 = "mDaysYesBtn"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x05a5:
            com.travel.flight.flightticket.fragment.g$i r0 = new com.travel.flight.flightticket.fragment.g$i
            r0.<init>(r10)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r12.setOnClickListener(r0)
            int r12 = com.travel.flight.R.id.insuarnce_lyt_no__btn
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            com.travel.flight.flightticket.fragment.g$j r0 = new com.travel.flight.flightticket.fragment.g$j
            r0.<init>(r10)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r12.setOnClickListener(r0)
            int r12 = com.travel.flight.R.id.days_lyt_no_btn
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            com.travel.flight.flightticket.fragment.g$k r12 = new com.travel.flight.flightticket.fragment.g$k
            r12.<init>(r10)
            android.view.View$OnClickListener r12 = (android.view.View.OnClickListener) r12
            r11.setOnClickListener(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.fragment.g.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public static final class l extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f25001a;

        l(g gVar) {
            this.f25001a = gVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "view");
            CJRInsuranceItem a2 = this.f25001a.f24986f;
            String str = null;
            CharSequence tnc = a2 != null ? a2.getTnc() : null;
            if (!(tnc == null || tnc.length() == 0)) {
                g gVar = this.f25001a;
                CJRInsuranceItem a3 = gVar.f24986f;
                if (a3 != null) {
                    str = a3.getTnc();
                }
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.c(str, "url");
                Intent intent = new Intent(gVar.getActivity(), FlightWebViewActivity.class);
                intent.putExtra("url", str);
                gVar.startActivity(intent);
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            textPaint.setColor(Color.parseColor("#00baf2"));
            textPaint.setUnderlineText(true);
        }
    }

    static final class e implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24994a;

        e(g gVar) {
            this.f24994a = gVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            g.b(this.f24994a);
            return true;
        }
    }

    public static final class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24995a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        f(g gVar) {
            this.f24995a = gVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TextView c2 = g.c(this.f24995a);
            aa aaVar = aa.f47921a;
            String string = this.f24995a.getResources().getString(R.string.flight_insurance_yes_secure_my_trip_days);
            kotlin.g.b.k.a((Object) string, "resources.getString(R.st…_yes_secure_my_trip_days)");
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(charSequence)}, 1));
            kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
            c2.setText(format);
            g.d(this.f24995a).setVisibility(8);
        }
    }

    /* renamed from: com.travel.flight.flightticket.fragment.g$g  reason: collision with other inner class name */
    static final class C0471g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24996a;

        C0471g(g gVar) {
            this.f24996a = gVar;
        }

        public final void onClick(View view) {
            g.e(this.f24996a);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24997a;

        h(g gVar) {
            this.f24997a = gVar;
        }

        public final void onClick(View view) {
            g.f(this.f24997a);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24998a;

        i(g gVar) {
            this.f24998a = gVar;
        }

        public final void onClick(View view) {
            g.b(this.f24998a);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24999a;

        j(g gVar) {
            this.f24999a = gVar;
        }

        public final void onClick(View view) {
            this.f24999a.l = true;
            com.travel.flight.flightticket.f.l h2 = this.f24999a.j;
            if (h2 != null) {
                h2.j();
            }
            this.f24999a.b();
            this.f24999a.dismiss();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f25000a;

        k(g gVar) {
            this.f25000a = gVar;
        }

        public final void onClick(View view) {
            this.f25000a.l = true;
            com.travel.flight.flightticket.f.l h2 = this.f25000a.j;
            if (h2 != null) {
                h2.j();
            }
            this.f25000a.b();
            this.f25000a.dismiss();
        }
    }

    private final String a(int i2, int i3) {
        aa aaVar = aa.f47921a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        String string = activity.getResources().getString(R.string.flight_insurance_days_error_message);
        kotlin.g.b.k.a((Object) string, "activity!!.resources.get…rance_days_error_message)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}, 2));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f25002a;

        m(g gVar) {
            this.f25002a = gVar;
        }

        public final void run() {
            if (this.f25002a.getActivity() != null && this.f25002a.isAdded()) {
                g.j(this.f25002a).setSelection(g.j(this.f25002a).getText().length());
                g.j(this.f25002a).requestFocus();
                FragmentActivity activity = this.f25002a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                Object systemService = activity.getSystemService("input_method");
                if (systemService != null) {
                    ((InputMethodManager) systemService).toggleSoftInput(2, 1);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24990a;

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        b(g gVar) {
            this.f24990a = gVar;
        }

        public final void onAnimationEnd(Animator animator) {
            g.k(this.f24990a).setVisibility(8);
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f24991a;

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        c(g gVar) {
            this.f24991a = gVar;
        }

        public final void onAnimationEnd(Animator animator) {
            g.l(this.f24991a).post(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f24992a;

                {
                    this.f24992a = r1;
                }

                public final void run() {
                    g.l(this.f24992a.f24991a).fullScroll(130);
                }
            });
            g.e(this.f24991a);
        }

        public final void onAnimationStart(Animator animator) {
            g.m(this.f24991a).setVisibility(0);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g a(com.travel.flight.flightticket.f.l lVar) {
            kotlin.g.b.k.c(lVar, "listener");
            return new g();
        }
    }

    public final void onPause() {
        super.onPause();
        b();
    }

    /* access modifiers changed from: private */
    public final void b() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        Object systemService = activity.getSystemService("input_method");
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            EditText editText = this.f24984d;
            if (editText == null) {
                kotlin.g.b.k.a("mDaysBox");
            }
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        com.travel.flight.flightticket.f.l lVar;
        kotlin.g.b.k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (!this.l && (lVar = this.j) != null) {
            lVar.j();
        }
        b();
    }

    public final void onResume() {
        FragmentActivity activity = getActivity();
        q.c(activity != null ? activity.getApplicationContext() : null);
        super.onResume();
    }

    public static final /* synthetic */ void a(DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (findViewById != null) {
                kotlin.g.b.k.a((Object) findViewById, "bottomSheetDialog.findVi…                ?: return");
                findViewById.setBackgroundColor(0);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(com.travel.flight.flightticket.fragment.g r7) {
        /*
            android.widget.TextView r0 = r7.f24988h
            java.lang.String r1 = "mErrorTxt"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            r2 = 8
            r0.setVisibility(r2)
            android.widget.EditText r0 = r7.f24984d
            if (r0 != 0) goto L_0x0017
            java.lang.String r2 = "mDaysBox"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0017:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x00fd
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r0 = r0.toString()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r2 = r7.f24986f
            r3 = 0
            if (r2 == 0) goto L_0x0074
            r4 = 0
            if (r2 == 0) goto L_0x0038
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r2 = r2.getUserInputInfo()
            goto L_0x0039
        L_0x0038:
            r2 = r4
        L_0x0039:
            if (r2 == 0) goto L_0x0074
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r2 = r7.f24986f
            if (r2 == 0) goto L_0x004e
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r2 = r2.getUserInputInfo()
            if (r2 == 0) goto L_0x004e
            int r2 = r2.getMin_days()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x004f
        L_0x004e:
            r2 = r4
        L_0x004f:
            if (r2 != 0) goto L_0x0054
            kotlin.g.b.k.a()
        L_0x0054:
            int r2 = r2.intValue()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r5 = r7.f24986f
            if (r5 == 0) goto L_0x006a
            com.travel.flight.pojo.flightticket.insurance.CJRTravelInsuranceUserInputInfo r5 = r5.getUserInputInfo()
            if (r5 == 0) goto L_0x006a
            int r4 = r5.getMax_days()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x006a:
            if (r4 != 0) goto L_0x006f
            kotlin.g.b.k.a()
        L_0x006f:
            int r4 = r4.intValue()
            goto L_0x0076
        L_0x0074:
            r2 = 0
            r4 = 0
        L_0x0076:
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 1
            if (r5 == 0) goto L_0x0085
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r5 = 0
            goto L_0x0086
        L_0x0085:
            r5 = 1
        L_0x0086:
            if (r5 != 0) goto L_0x00e2
            int r5 = java.lang.Integer.parseInt(r0)
            if (r5 <= 0) goto L_0x00c7
            if (r2 <= r5) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            if (r4 < r5) goto L_0x0095
            r5 = 1
            goto L_0x0096
        L_0x0095:
            r5 = 0
        L_0x0096:
            if (r5 == 0) goto L_0x00ac
            r7.l = r6
            com.travel.flight.flightticket.f.l r1 = r7.j
            if (r1 == 0) goto L_0x00a5
            int r0 = java.lang.Integer.parseInt(r0)
            r1.a(r0)
        L_0x00a5:
            r7.b()
            r7.dismiss()
            return
        L_0x00ac:
            android.widget.TextView r0 = r7.f24988h
            if (r0 != 0) goto L_0x00b3
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00b3:
            r0.setVisibility(r3)
            android.widget.TextView r0 = r7.f24988h
            if (r0 != 0) goto L_0x00bd
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00bd:
            java.lang.String r7 = r7.a(r2, r4)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            return
        L_0x00c7:
            android.widget.TextView r0 = r7.f24988h
            if (r0 != 0) goto L_0x00ce
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00ce:
            r0.setVisibility(r3)
            android.widget.TextView r0 = r7.f24988h
            if (r0 != 0) goto L_0x00d8
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00d8:
            java.lang.String r7 = r7.a(r2, r4)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            return
        L_0x00e2:
            android.widget.TextView r0 = r7.f24988h
            if (r0 != 0) goto L_0x00e9
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00e9:
            r0.setVisibility(r3)
            android.widget.TextView r0 = r7.f24988h
            if (r0 != 0) goto L_0x00f3
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00f3:
            java.lang.String r7 = r7.a(r2, r4)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            return
        L_0x00fd:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.fragment.g.b(com.travel.flight.flightticket.fragment.g):void");
    }

    public static final /* synthetic */ void e(g gVar) {
        ConstraintLayout constraintLayout = gVar.f24983c;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("mDaysLyt");
        }
        if (!constraintLayout.isFocused()) {
            new Handler().postDelayed(new m(gVar), 200);
        }
    }

    public static final /* synthetic */ void f(g gVar) {
        CJRInsuranceItem cJRInsuranceItem = gVar.f24986f;
        Boolean valueOf = cJRInsuranceItem != null ? Boolean.valueOf(cJRInsuranceItem.isOne_way_international()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        if (valueOf.booleanValue()) {
            ConstraintLayout constraintLayout = gVar.f24983c;
            if (constraintLayout == null) {
                kotlin.g.b.k.a("mDaysLyt");
            }
            constraintLayout.setVisibility(0);
            Animator loadAnimator = AnimatorInflater.loadAnimator(gVar.getActivity(), R.animator.rotate_go_away);
            loadAnimator.addListener(new b(gVar));
            ConstraintLayout constraintLayout2 = gVar.f24982b;
            if (constraintLayout2 == null) {
                kotlin.g.b.k.a("mInsuranceLyt");
            }
            loadAnimator.setTarget(constraintLayout2);
            loadAnimator.start();
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(gVar.getActivity(), R.animator.rotate_come_back);
            loadAnimator2.addListener(new c(gVar));
            ConstraintLayout constraintLayout3 = gVar.f24983c;
            if (constraintLayout3 == null) {
                kotlin.g.b.k.a("mDaysLyt");
            }
            loadAnimator2.setTarget(constraintLayout3);
            loadAnimator2.start();
            return;
        }
        gVar.l = true;
        com.travel.flight.flightticket.f.l lVar = gVar.j;
        if (lVar != null) {
            lVar.i();
        }
        gVar.b();
        gVar.dismiss();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
