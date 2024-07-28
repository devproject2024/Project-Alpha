package com.travel.train.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.z;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.travel.train.b.aq;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class ag extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26836a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private CJRTrainLSSearchResult.Train f26837b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends CJRTrainLSSearchResult.Schedule> f26838c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public aq f26839d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26840e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26841f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26842g = true;

    /* renamed from: h  reason: collision with root package name */
    private CJRTrainLSSearchResult.Schedule f26843h;

    /* renamed from: i  reason: collision with root package name */
    private String f26844i;
    private int j;
    /* access modifiers changed from: private */
    public com.google.android.material.bottomsheet.a k;
    /* access modifiers changed from: private */
    public com.travel.train.k.a l;
    private HashMap m;

    public final View a(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f26848a;

        e(ag agVar) {
            this.f26848a = agVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                com.google.android.material.bottomsheet.a a2 = this.f26848a.k;
                FrameLayout frameLayout = a2 != null ? (FrameLayout) a2.findViewById(R.id.design_bottom_sheet) : null;
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setState(3);
                com.travel.train.k.a b2 = this.f26848a.l;
                if (b2 != null) {
                    b2.a(false);
                }
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ag a(Bundle bundle) {
            ag agVar = new ag();
            agVar.setArguments(bundle);
            return agVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments != null && arguments.containsKey("intent_extra_train_selected")) {
                this.f26837b = (CJRTrainLSSearchResult.Train) arguments.getSerializable("intent_extra_train_selected");
                CJRTrainLSSearchResult.Train train = this.f26837b;
                this.f26838c = train != null ? train.getSchedule() : null;
                this.f26840e = arguments.getBoolean("intent_extra_search_by_train");
            }
            if (!(arguments == null || !arguments.containsKey("selected_day_count") || arguments.getString("selected_day_count") == null)) {
                String string = arguments.getString("selected_day_count");
                if (string == null) {
                    k.a();
                }
                k.a((Object) string, "args?.getString(CJRTrain…IN__SELECTED_DAY_COUNT)!!");
                this.j = Integer.parseInt(string);
            }
            if (arguments != null && arguments.containsKey("intent_extra_schedule_selected")) {
                this.f26843h = (CJRTrainLSSearchResult.Schedule) arguments.getSerializable("intent_extra_schedule_selected");
            }
            if (arguments != null && arguments.containsKey("intent_extra_search_by_train_flag")) {
                this.f26842g = arguments.getBoolean("intent_extra_search_by_train_flag");
            }
            if (arguments != null && arguments.containsKey("departureDate")) {
                this.f26844i = arguments.getString("departureDate");
            }
            if (arguments != null && arguments.containsKey("from_search_by_train_result")) {
                this.f26841f = arguments.getBoolean("from_search_by_train_result");
                return;
            }
            return;
        }
        throw new RuntimeException("Arguments required");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setCanceledOnTouchOutside(this.f26842g);
            aVar.setCancelable(this.f26842g);
            aVar.setOnShowListener(new f(this));
            this.k = aVar;
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class f implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f26849a;

        f(ag agVar) {
            this.f26849a = agVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
            FrameLayout frameLayout = aVar != null ? (FrameLayout) aVar.findViewById(R.id.design_bottom_sheet) : null;
            if (frameLayout == null) {
                k.a();
            }
            BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
            if (from != null) {
                from.setBottomSheetCallback(new a(frameLayout));
            }
        }

        public static final class a extends BottomSheetBehavior.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FrameLayout f26850a;

            public final void onSlide(View view, float f2) {
                k.c(view, "p0");
            }

            a(FrameLayout frameLayout) {
                this.f26850a = frameLayout;
            }

            public final void onStateChanged(View view, int i2) {
                BottomSheetBehavior from;
                k.c(view, "p0");
                if (i2 == 1) {
                    BottomSheetBehavior from2 = BottomSheetBehavior.from(this.f26850a);
                    if (from2 != null) {
                        from2.setState(3);
                    }
                } else if (i2 == 5 && (from = BottomSheetBehavior.from(this.f26850a)) != null) {
                    from.setState(3);
                }
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(com.travel.train.R.layout.pre_t_train_boarding_point_bottom_sheet, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0071, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r14, android.os.Bundle r15) {
        /*
            r13 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r14, r0)
            super.onViewCreated(r14, r15)
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            if (r14 == 0) goto L_0x0044
            com.travel.train.k.g r15 = new com.travel.train.k.g
            com.travel.train.k.g$a r0 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r1 = com.travel.train.k.g.b.LS
            r0.<init>(r1)
            com.travel.train.a.a$a r1 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r2 = new com.travel.train.a.a.a
            java.lang.String r3 = "it"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r3 = r14
            android.content.Context r3 = (android.content.Context) r3
            r2.<init>(r3)
            com.travel.train.a.a.b r2 = (com.travel.train.a.a.b) r2
            com.travel.train.a.a r1 = r1.a(r2)
            com.travel.train.k.g$a r0 = r0.a(r1)
            r15.<init>(r0)
            androidx.lifecycle.al$b r15 = (androidx.lifecycle.al.b) r15
            androidx.lifecycle.al r14 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r14, (androidx.lifecycle.al.b) r15)
            java.lang.Class<com.travel.train.k.a> r15 = com.travel.train.k.a.class
            androidx.lifecycle.ai r14 = r14.a(r15)
            com.travel.train.k.a r14 = (com.travel.train.k.a) r14
            r13.l = r14
        L_0x0044:
            com.travel.train.k.a r14 = r13.l
            if (r14 == 0) goto L_0x005c
            androidx.lifecycle.y<java.lang.Boolean> r14 = r14.m
            androidx.lifecycle.LiveData r14 = (androidx.lifecycle.LiveData) r14
            if (r14 == 0) goto L_0x005c
            androidx.lifecycle.q r15 = r13.getViewLifecycleOwner()
            com.travel.train.fragment.ag$e r0 = new com.travel.train.fragment.ag$e
            r0.<init>(r13)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r14.observe(r15, r0)
        L_0x005c:
            boolean r14 = r13.f26840e
            r15 = 0
            if (r14 == 0) goto L_0x0085
            int r14 = com.travel.train.R.id.title_txt
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00a8
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x007e
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x007e
            int r1 = com.travel.train.R.string.destination_metro_station
            java.lang.String r0 = r0.getString(r1)
            goto L_0x007f
        L_0x007e:
            r0 = r15
        L_0x007f:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
            goto L_0x00a8
        L_0x0085:
            int r14 = com.travel.train.R.id.title_txt
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00a8
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x00a2
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x00a2
            int r1 = com.travel.train.R.string.source_metro_station
            java.lang.String r0 = r0.getString(r1)
            goto L_0x00a3
        L_0x00a2:
            r0 = r15
        L_0x00a3:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
        L_0x00a8:
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r14 = r13.f26838c
            r0 = 0
            r1 = 1
            if (r14 == 0) goto L_0x0160
            if (r14 != 0) goto L_0x00b3
            kotlin.g.b.k.a()
        L_0x00b3:
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r14 = r14.iterator()
            r2 = 0
        L_0x00ba:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x0160
            java.lang.Object r3 = r14.next()
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r3
            r3.setDefaultStationPosition(r2)
            java.lang.String r4 = r3.getDayCount()
            java.lang.String r5 = "1"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00e4
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r13.f26837b
            if (r4 == 0) goto L_0x00de
            java.lang.String r4 = r4.getRunningOn()
            goto L_0x00df
        L_0x00de:
            r4 = r15
        L_0x00df:
            r3.setRunningOnForSource(r4)
            goto L_0x015c
        L_0x00e4:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r13.f26837b
            if (r4 == 0) goto L_0x00ed
            java.lang.String r4 = r4.getRunningOn()
            goto L_0x00ee
        L_0x00ed:
            r4 = r15
        L_0x00ee:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r3.getDayCount()
            java.lang.String r7 = "item.dayCount"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            int r6 = java.lang.Integer.parseInt(r6)
            int r6 = 7 - r6
            int r6 = r6 + r1
        L_0x0103:
            r8 = 6
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            if (r6 > r8) goto L_0x012f
            if (r4 == 0) goto L_0x0124
            if (r4 == 0) goto L_0x011e
            char[] r8 = r4.toCharArray()
            java.lang.String r9 = "(this as java.lang.String).toCharArray()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            if (r8 == 0) goto L_0x0124
            char r8 = r8[r6]
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            goto L_0x0125
        L_0x011e:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r9)
            throw r14
        L_0x0124:
            r8 = r15
        L_0x0125:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r5.append(r8)
            int r6 = r6 + 1
            goto L_0x0103
        L_0x012f:
            if (r4 == 0) goto L_0x0151
            java.lang.String r6 = r3.getDayCount()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            int r6 = java.lang.Integer.parseInt(r6)
            int r6 = 7 - r6
            int r6 = r6 + r1
            if (r4 == 0) goto L_0x014b
            java.lang.String r4 = r4.substring(r0, r6)
            java.lang.String r6 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            goto L_0x0152
        L_0x014b:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r9)
            throw r14
        L_0x0151:
            r4 = r15
        L_0x0152:
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.setRunningOnForSource(r4)
        L_0x015c:
            int r2 = r2 + 1
            goto L_0x00ba
        L_0x0160:
            com.travel.train.b.aq r14 = new com.travel.train.b.aq
            androidx.fragment.app.FragmentActivity r4 = r13.getActivity()
            if (r4 != 0) goto L_0x016b
            kotlin.g.b.k.a()
        L_0x016b:
            java.lang.String r2 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r2 = com.travel.train.R.id.station_list
            android.view.View r2 = r13.a((int) r2)
            r5 = r2
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            java.lang.String r2 = "station_list"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            java.util.List<? extends com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r6 = r13.f26838c
            boolean r7 = r13.f26840e
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r8 = r13.f26843h
            java.lang.String r9 = r13.f26844i
            int r10 = r13.j
            boolean r2 = r13.f26841f
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r2)
            r3 = r14
            r12 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.f26839d = r14
            int r14 = com.travel.train.R.id.station_list
            android.view.View r14 = r13.a((int) r14)
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            if (r14 == 0) goto L_0x01b7
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r3 = r13.getActivity()
            android.content.Context r3 = (android.content.Context) r3
            r2.<init>(r3, r1, r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r14.setLayoutManager(r2)
            com.travel.train.b.aq r0 = r13.f26839d
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r14.setAdapter(r0)
        L_0x01b7:
            com.travel.train.b.aq r14 = r13.f26839d
            if (r14 == 0) goto L_0x01c4
            int r14 = r14.getItemCount()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x01c5
        L_0x01c4:
            r14 = r15
        L_0x01c5:
            if (r14 != 0) goto L_0x01ca
            kotlin.g.b.k.a()
        L_0x01ca:
            int r14 = r14.intValue()
            if (r14 <= 0) goto L_0x01f3
            int r14 = com.travel.train.R.id.station_list
            android.view.View r14 = r13.a((int) r14)
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            if (r14 == 0) goto L_0x01f3
            com.travel.train.b.aq r0 = r13.f26839d
            if (r0 == 0) goto L_0x01e6
            int r15 = r0.getItemCount()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
        L_0x01e6:
            if (r15 != 0) goto L_0x01eb
            kotlin.g.b.k.a()
        L_0x01eb:
            int r15 = r15.intValue()
            int r15 = r15 - r1
            r14.smoothScrollToPosition(r15)
        L_0x01f3:
            int r14 = com.travel.train.R.id.search_icon
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0207
            com.travel.train.fragment.ag$b r15 = new com.travel.train.fragment.ag$b
            r15.<init>(r13)
            android.view.View$OnClickListener r15 = (android.view.View.OnClickListener) r15
            r14.setOnClickListener(r15)
        L_0x0207:
            int r14 = com.travel.train.R.id.close_icon
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x021b
            com.travel.train.fragment.ag$c r15 = new com.travel.train.fragment.ag$c
            r15.<init>(r13)
            android.view.View$OnClickListener r15 = (android.view.View.OnClickListener) r15
            r14.setOnClickListener(r15)
        L_0x021b:
            int r14 = com.travel.train.R.id.search_et
            android.view.View r14 = r13.a((int) r14)
            android.widget.EditText r14 = (android.widget.EditText) r14
            if (r14 == 0) goto L_0x022f
            com.travel.train.fragment.ag$d r15 = new com.travel.train.fragment.ag$d
            r15.<init>(r13)
            android.text.TextWatcher r15 = (android.text.TextWatcher) r15
            r14.addTextChangedListener(r15)
        L_0x022f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ag.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f26845a;

        b(ag agVar) {
            this.f26845a = agVar;
        }

        public final void onClick(View view) {
            TextView textView = (TextView) this.f26845a.a(com.travel.train.R.id.title_txt);
            if (textView != null) {
                textView.setVisibility(4);
            }
            EditText editText = (EditText) this.f26845a.a(com.travel.train.R.id.search_et);
            if (editText != null) {
                editText.setVisibility(0);
            }
            ImageView imageView = (ImageView) this.f26845a.a(com.travel.train.R.id.close_icon);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = (ImageView) this.f26845a.a(com.travel.train.R.id.search_icon);
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            EditText editText2 = (EditText) this.f26845a.a(com.travel.train.R.id.search_et);
            if (editText2 != null) {
                editText2.setFocusableInTouchMode(true);
            }
            EditText editText3 = (EditText) this.f26845a.a(com.travel.train.R.id.search_et);
            if (editText3 != null) {
                editText3.requestFocus();
            }
            FragmentActivity activity = this.f26845a.getActivity();
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            if (systemService != null) {
                ((InputMethodManager) systemService).showSoftInput((EditText) this.f26845a.a(com.travel.train.R.id.search_et), 1);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f26846a;

        c(ag agVar) {
            this.f26846a = agVar;
        }

        public final void onClick(View view) {
            TextView textView = (TextView) this.f26846a.a(com.travel.train.R.id.title_txt);
            if (textView != null) {
                textView.setVisibility(0);
            }
            ImageView imageView = (ImageView) this.f26846a.a(com.travel.train.R.id.search_icon);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            EditText editText = (EditText) this.f26846a.a(com.travel.train.R.id.search_et);
            if (editText != null) {
                editText.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) this.f26846a.a(com.travel.train.R.id.close_icon);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            aq c2 = this.f26846a.f26839d;
            if (c2 != null) {
                c2.a("");
            }
            aq c3 = this.f26846a.f26839d;
            IBinder iBinder = null;
            Filter filter = c3 != null ? c3.getFilter() : null;
            if (filter == null) {
                k.a();
            }
            filter.filter("");
            FragmentActivity activity = this.f26846a.getActivity();
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                EditText editText2 = (EditText) this.f26846a.a(com.travel.train.R.id.search_et);
                if (editText2 != null) {
                    iBinder = editText2.getWindowToken();
                }
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f26847a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        d(ag agVar) {
            this.f26847a = agVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            aq c2 = this.f26847a.f26839d;
            if (c2 != null) {
                c2.a(String.valueOf(charSequence));
            }
            Filter filter = null;
            if (TextUtils.isEmpty(charSequence)) {
                aq c3 = this.f26847a.f26839d;
                if (c3 != null) {
                    filter = c3.getFilter();
                }
                if (filter == null) {
                    k.a();
                }
                filter.filter("");
                return;
            }
            aq c4 = this.f26847a.f26839d;
            if (c4 != null) {
                filter = c4.getFilter();
            }
            if (filter == null) {
                k.a();
            }
            filter.filter(String.valueOf(charSequence));
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.a((Object) a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    public final void a() {
        FragmentActivity activity = getActivity();
        IBinder iBinder = null;
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            EditText editText = (EditText) a(com.travel.train.R.id.search_et);
            if (editText != null) {
                iBinder = editText.getWindowToken();
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            o.a((Activity) getActivity());
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final int getTheme() {
        return com.travel.train.R.style.DialogStyle;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        a();
        super.onDismiss(dialogInterface);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
