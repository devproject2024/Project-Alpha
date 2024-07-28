package com.travel.train.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainViewRoute;
import com.travel.train.fragment.ag;
import com.travel.train.fragment.ah;
import com.travel.train.fragment.j;
import com.travel.train.fragment.q;
import com.travel.train.j.m;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.searchResult.CJRSearchByTrainDetails;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.trainticket.CJRTrainHolidayList;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class h extends am implements com.travel.train.hintsbuilder.c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26988a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private com.travel.train.k.b f26989b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRSearchByTrainNumberModel f26990c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJRSearchByTrainNumberModel f26991d;

    /* renamed from: e  reason: collision with root package name */
    private CJRSearchByTrainDetails f26992e;

    /* renamed from: f  reason: collision with root package name */
    private ac f26993f;

    /* renamed from: g  reason: collision with root package name */
    private q f26994g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CJRTrainSearchInput f26995h;

    /* renamed from: i  reason: collision with root package name */
    private com.travel.train.k.a f26996i;
    /* access modifiers changed from: private */
    public CJRTrainLSSearchResult.Train j;
    /* access modifiers changed from: private */
    public CJRTrainLSSearchResult.Schedule k;
    /* access modifiers changed from: private */
    public String l;
    private CJRTrainHolidayList m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public boolean o;
    private com.paytm.b.a.a p;
    private final int q = 100;
    private HashMap r;

    public final View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class g<T> implements z<CJRSearchByTrainNumberModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27002a;

        g(h hVar) {
            this.f27002a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f27002a.f26990c = (CJRSearchByTrainNumberModel) obj;
            h.b(this.f27002a);
            this.f27002a.a();
            this.f27002a.a(false);
            m.a aVar = com.travel.train.j.m.f27577a;
            m.a.a(this.f27002a.f26990c, this.f27002a.l, this.f27002a.k, this.f27002a.f26995h, this.f27002a.getContext());
        }
    }

    /* renamed from: com.travel.train.fragment.h$h  reason: collision with other inner class name */
    static final class C0490h<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27003a;

        C0490h(h hVar) {
            this.f27003a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            h hVar = this.f27003a;
            kotlin.g.b.k.a((Object) bool, "it");
            hVar.o = bool.booleanValue();
            h.j(this.f27003a);
        }
    }

    static final class i<T> implements z<Pair<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27004a;

        i(h hVar) {
            this.f27004a = hVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                android.util.Pair r4 = (android.util.Pair) r4
                com.travel.train.fragment.h r0 = r3.f27004a
                r1 = 0
                if (r4 == 0) goto L_0x000c
                java.lang.Object r2 = r4.first
                java.lang.String r2 = (java.lang.String) r2
                goto L_0x000d
            L_0x000c:
                r2 = r1
            L_0x000d:
                if (r4 == 0) goto L_0x0014
                java.lang.Object r4 = r4.second
                r1 = r4
                java.lang.String r1 = (java.lang.String) r1
            L_0x0014:
                r0.showErrorDialog(r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.i.onChanged(java.lang.Object):void");
        }
    }

    static final class j<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27005a;

        j(h hVar) {
            this.f27005a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (str != null) {
                h.b(this.f27005a, str);
                h.g(this.f27005a);
            }
        }
    }

    static final class k<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27006a;

        k(h hVar) {
            this.f27006a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f27006a.a(R.id.lottie_in_search);
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                }
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f27006a.a(R.id.lottie_in_search));
                return;
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f27006a.a(R.id.lottie_in_search);
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setVisibility(4);
            }
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f27006a.a(R.id.lottie_in_search));
        }
    }

    static final class l<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27007a;

        l(h hVar) {
            this.f27007a = hVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00c5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Integer r5 = (java.lang.Integer) r5
                com.travel.train.fragment.h r0 = r4.f27007a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r0.k
                if (r0 == 0) goto L_0x0016
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
                int r5 = r5.intValue()
                r0.setSourceSelectedPosition(r5)
            L_0x0016:
                com.travel.train.fragment.h r5 = r4.f27007a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r5.j
                r1 = 0
                if (r0 == 0) goto L_0x004d
                java.util.List r0 = r0.getSchedule()
                if (r0 == 0) goto L_0x004d
                com.travel.train.fragment.h r2 = r4.f27007a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r2.k
                if (r2 == 0) goto L_0x0036
                int r2 = r2.getSourceSelectedPosition()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0037
            L_0x0036:
                r2 = r1
            L_0x0037:
                if (r2 != 0) goto L_0x003c
                kotlin.g.b.k.a()
            L_0x003c:
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
                if (r0 == 0) goto L_0x004d
                java.lang.String r0 = r0.getStationCode()
                goto L_0x004e
            L_0x004d:
                r0 = r1
            L_0x004e:
                com.travel.train.fragment.h r2 = r4.f27007a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r2 = r2.j
                if (r2 == 0) goto L_0x0084
                java.util.List r2 = r2.getSchedule()
                if (r2 == 0) goto L_0x0084
                com.travel.train.fragment.h r3 = r4.f27007a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = r3.k
                if (r3 == 0) goto L_0x006d
                int r3 = r3.getSourceSelectedPosition()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                goto L_0x006e
            L_0x006d:
                r3 = r1
            L_0x006e:
                if (r3 != 0) goto L_0x0073
                kotlin.g.b.k.a()
            L_0x0073:
                int r3 = r3.intValue()
                java.lang.Object r2 = r2.get(r3)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r2
                if (r2 == 0) goto L_0x0084
                java.lang.String r2 = r2.getStationName()
                goto L_0x0085
            L_0x0084:
                r2 = r1
            L_0x0085:
                r5.a((java.lang.String) r0, (java.lang.String) r2)
                com.travel.train.fragment.h r5 = r4.f27007a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = r5.k
                if (r5 == 0) goto L_0x0099
                int r5 = r5.getDestSelectedPosition()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                goto L_0x009a
            L_0x0099:
                r5 = r1
            L_0x009a:
                if (r5 != 0) goto L_0x009f
                kotlin.g.b.k.a()
            L_0x009f:
                int r5 = r5.intValue()
                com.travel.train.fragment.h r0 = r4.f27007a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r0.k
                if (r0 == 0) goto L_0x00b3
                int r0 = r0.getSourceSelectedPosition()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            L_0x00b3:
                if (r1 != 0) goto L_0x00b8
                kotlin.g.b.k.a()
            L_0x00b8:
                int r0 = r1.intValue()
                if (r5 > r0) goto L_0x00c5
                com.travel.train.fragment.h r5 = r4.f27007a
                r0 = 1
                com.travel.train.fragment.h.b((com.travel.train.fragment.h) r5, (boolean) r0)
                return
            L_0x00c5:
                com.travel.train.fragment.h r5 = r4.f27007a
                java.lang.String r0 = r5.l
                com.travel.train.fragment.h.c((com.travel.train.fragment.h) r5, (java.lang.String) r0)
                com.travel.train.fragment.h r5 = r4.f27007a
                android.content.Context r5 = r5.getContext()
                java.lang.String r0 = "train_homepage"
                java.lang.String r1 = "Train number"
                java.lang.String r2 = "station_changed"
                java.lang.String r3 = "/trains"
                com.travel.train.j.o.a(r0, r1, r2, r3, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.l.onChanged(java.lang.Object):void");
        }
    }

    static final class m<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27008a;

        m(h hVar) {
            this.f27008a = hVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Integer r5 = (java.lang.Integer) r5
                com.travel.train.fragment.h r0 = r4.f27008a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r0.k
                if (r0 == 0) goto L_0x0016
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
                int r5 = r5.intValue()
                r0.setDestSelectedPosition(r5)
            L_0x0016:
                com.travel.train.fragment.h r5 = r4.f27008a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r5.j
                r1 = 0
                if (r0 == 0) goto L_0x004d
                java.util.List r0 = r0.getSchedule()
                if (r0 == 0) goto L_0x004d
                com.travel.train.fragment.h r2 = r4.f27008a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r2.k
                if (r2 == 0) goto L_0x0036
                int r2 = r2.getDestSelectedPosition()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0037
            L_0x0036:
                r2 = r1
            L_0x0037:
                if (r2 != 0) goto L_0x003c
                kotlin.g.b.k.a()
            L_0x003c:
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
                if (r0 == 0) goto L_0x004d
                java.lang.String r0 = r0.getStationCode()
                goto L_0x004e
            L_0x004d:
                r0 = r1
            L_0x004e:
                com.travel.train.fragment.h r2 = r4.f27008a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r2 = r2.j
                if (r2 == 0) goto L_0x0083
                java.util.List r2 = r2.getSchedule()
                if (r2 == 0) goto L_0x0083
                com.travel.train.fragment.h r3 = r4.f27008a
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r3 = r3.k
                if (r3 == 0) goto L_0x006d
                int r3 = r3.getDestSelectedPosition()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                goto L_0x006e
            L_0x006d:
                r3 = r1
            L_0x006e:
                if (r3 != 0) goto L_0x0073
                kotlin.g.b.k.a()
            L_0x0073:
                int r3 = r3.intValue()
                java.lang.Object r2 = r2.get(r3)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r2
                if (r2 == 0) goto L_0x0083
                java.lang.String r1 = r2.getStationName()
            L_0x0083:
                r5.b((java.lang.String) r0, (java.lang.String) r1)
                com.travel.train.fragment.h r5 = r4.f27008a
                java.lang.String r0 = r5.l
                com.travel.train.fragment.h.c((com.travel.train.fragment.h) r5, (java.lang.String) r0)
                com.travel.train.fragment.h r5 = r4.f27008a
                android.content.Context r5 = r5.getContext()
                java.lang.String r0 = "train_homepage"
                java.lang.String r1 = "Train number"
                java.lang.String r2 = "station_changed"
                java.lang.String r3 = "/trains"
                com.travel.train.j.o.a(r0, r1, r2, r3, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.m.onChanged(java.lang.Object):void");
        }
    }

    static final class n<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27009a;

        n(h hVar) {
            this.f27009a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (str != null) {
                this.f27009a.l = str;
            }
        }
    }

    static final class o<T> implements z<CJRSearchByTrainNumberModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27010a;

        o(h hVar) {
            this.f27010a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f27010a.f26991d = (CJRSearchByTrainNumberModel) obj;
            if (this.f27010a.n == null) {
                this.f27010a.a(true);
            } else {
                h.j(this.f27010a);
            }
        }
    }

    static final class p<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27011a;

        p(h hVar) {
            this.f27011a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            this.f27011a.n = str;
            if (str == null) {
                h.j(this.f27011a);
                return;
            }
            h hVar = this.f27011a;
            h.e(hVar, hVar.n);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_search_by_train_result_layout, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:207:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0418  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0447  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0459  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0476  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0488  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r7, r0)
            super.onViewCreated(r7, r8)
            android.os.Bundle r7 = r6.getArguments()
            r8 = 0
            if (r7 == 0) goto L_0x0017
            java.lang.String r0 = "search_by_train_result"
            java.lang.Object r7 = r7.get(r0)
            goto L_0x0018
        L_0x0017:
            r7 = r8
        L_0x0018:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r7 = (com.travel.train.model.searchResult.CJRSearchByTrainNumberModel) r7
            r6.f26990c = r7
            android.os.Bundle r7 = r6.getArguments()
            if (r7 == 0) goto L_0x0029
            java.lang.String r0 = "intent_extra_train_search_input"
            java.io.Serializable r7 = r7.getSerializable(r0)
            goto L_0x002a
        L_0x0029:
            r7 = r8
        L_0x002a:
            com.travel.train.model.CJRTrainSearchInput r7 = (com.travel.train.model.CJRTrainSearchInput) r7
            r6.f26995h = r7
            com.travel.train.model.CJRTrainSearchInput r7 = r6.f26995h
            if (r7 == 0) goto L_0x0037
            java.lang.String r7 = r7.getmDate()
            goto L_0x0038
        L_0x0037:
            r7 = r8
        L_0x0038:
            r6.l = r7
            android.os.Bundle r7 = r6.getArguments()
            if (r7 == 0) goto L_0x0047
            java.lang.String r0 = "intent_extra_train_selected"
            java.io.Serializable r7 = r7.getSerializable(r0)
            goto L_0x0048
        L_0x0047:
            r7 = r8
        L_0x0048:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r7 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r7
            r6.j = r7
            android.os.Bundle r7 = r6.getArguments()
            if (r7 == 0) goto L_0x0059
            java.lang.String r0 = "intent_extra_schedule_selected"
            java.io.Serializable r7 = r7.getSerializable(r0)
            goto L_0x005a
        L_0x0059:
            r7 = r8
        L_0x005a:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r7 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r7
            r6.k = r7
            android.os.Bundle r7 = r6.getArguments()
            if (r7 != 0) goto L_0x0067
            kotlin.g.b.k.a()
        L_0x0067:
            java.lang.String r0 = "extra_intent_holiday_list"
            boolean r7 = r7.containsKey(r0)
            if (r7 == 0) goto L_0x0080
            android.os.Bundle r7 = r6.getArguments()
            if (r7 != 0) goto L_0x0078
            kotlin.g.b.k.a()
        L_0x0078:
            java.lang.Object r7 = r7.get(r0)
            com.travel.train.model.trainticket.CJRTrainHolidayList r7 = (com.travel.train.model.trainticket.CJRTrainHolidayList) r7
            r6.m = r7
        L_0x0080:
            androidx.fragment.app.FragmentActivity r7 = r6.getActivity()
            if (r7 == 0) goto L_0x00fe
            com.travel.train.k.g r0 = new com.travel.train.k.g
            com.travel.train.k.g$a r1 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r2 = com.travel.train.k.g.b.SEARCHBYTRAIN
            r1.<init>(r2)
            com.travel.train.a.a$a r2 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r3 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r4 = r6.getActivity()
            if (r4 != 0) goto L_0x009c
            kotlin.g.b.k.a()
        L_0x009c:
            java.lang.String r5 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.content.Context r4 = (android.content.Context) r4
            r3.<init>(r4)
            com.travel.train.a.a.b r3 = (com.travel.train.a.a.b) r3
            com.travel.train.a.a r2 = r2.a(r3)
            com.travel.train.k.g$a r1 = r1.a(r2)
            r0.<init>(r1)
            androidx.lifecycle.al$b r0 = (androidx.lifecycle.al.b) r0
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r7, (androidx.lifecycle.al.b) r0)
            java.lang.Class<com.travel.train.k.b> r1 = com.travel.train.k.b.class
            androidx.lifecycle.ai r0 = r0.a(r1)
            com.travel.train.k.b r0 = (com.travel.train.k.b) r0
            r6.f26989b = r0
            com.travel.train.k.g r0 = new com.travel.train.k.g
            com.travel.train.k.g$a r1 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r2 = com.travel.train.k.g.b.LS
            r1.<init>(r2)
            com.travel.train.a.a$a r2 = com.travel.train.a.a.f25797a
            com.travel.train.a.a.a r3 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r4 = r6.getActivity()
            if (r4 != 0) goto L_0x00d9
            kotlin.g.b.k.a()
        L_0x00d9:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.content.Context r4 = (android.content.Context) r4
            r3.<init>(r4)
            com.travel.train.a.a.b r3 = (com.travel.train.a.a.b) r3
            com.travel.train.a.a r2 = r2.a(r3)
            com.travel.train.k.g$a r1 = r1.a(r2)
            r0.<init>(r1)
            androidx.lifecycle.al$b r0 = (androidx.lifecycle.al.b) r0
            androidx.lifecycle.al r7 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r7, (androidx.lifecycle.al.b) r0)
            java.lang.Class<com.travel.train.k.a> r0 = com.travel.train.k.a.class
            androidx.lifecycle.ai r7 = r7.a(r0)
            com.travel.train.k.a r7 = (com.travel.train.k.a) r7
            r6.f26996i = r7
        L_0x00fe:
            com.travel.train.k.b r7 = r6.f26989b
            if (r7 == 0) goto L_0x0115
            androidx.lifecycle.y<com.travel.train.model.searchResult.CJRSearchByTrainNumberModel> r7 = r7.f27621a
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x0115
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$g r1 = new com.travel.train.fragment.h$g
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x0115:
            com.travel.train.k.b r7 = r6.f26989b
            if (r7 == 0) goto L_0x012a
            com.travel.train.l.c r7 = r7.f27626f
            if (r7 == 0) goto L_0x012a
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$i r1 = new com.travel.train.fragment.h$i
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x012a:
            com.travel.train.k.b r7 = r6.f26989b
            if (r7 == 0) goto L_0x0141
            androidx.lifecycle.y<java.lang.String> r7 = r7.f27625e
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x0141
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$j r1 = new com.travel.train.fragment.h$j
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x0141:
            com.travel.train.k.a r7 = r6.f26996i
            if (r7 == 0) goto L_0x0158
            androidx.lifecycle.y<java.lang.Boolean> r7 = r7.f27614c
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x0158
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$k r1 = new com.travel.train.fragment.h$k
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x0158:
            com.travel.train.k.a r7 = r6.f26996i
            if (r7 == 0) goto L_0x016f
            androidx.lifecycle.y<java.lang.Integer> r7 = r7.j
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x016f
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$l r1 = new com.travel.train.fragment.h$l
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x016f:
            com.travel.train.k.a r7 = r6.f26996i
            if (r7 == 0) goto L_0x0186
            androidx.lifecycle.y<java.lang.Integer> r7 = r7.k
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x0186
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$m r1 = new com.travel.train.fragment.h$m
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x0186:
            com.travel.train.k.a r7 = r6.f26996i
            if (r7 == 0) goto L_0x019d
            androidx.lifecycle.y<java.lang.String> r7 = r7.f27620i
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x019d
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$n r1 = new com.travel.train.fragment.h$n
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x019d:
            com.travel.train.k.b r7 = r6.f26989b
            if (r7 == 0) goto L_0x01b4
            androidx.lifecycle.y<com.travel.train.model.searchResult.CJRSearchByTrainNumberModel> r7 = r7.f27623c
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x01b4
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$o r1 = new com.travel.train.fragment.h$o
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x01b4:
            com.travel.train.k.b r7 = r6.f26989b
            if (r7 == 0) goto L_0x01cb
            androidx.lifecycle.y<java.lang.String> r7 = r7.f27628h
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x01cb
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$p r1 = new com.travel.train.fragment.h$p
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x01cb:
            com.travel.train.k.b r7 = r6.f26989b
            if (r7 == 0) goto L_0x01e2
            androidx.lifecycle.y<java.lang.Boolean> r7 = r7.f27629i
            androidx.lifecycle.LiveData r7 = (androidx.lifecycle.LiveData) r7
            if (r7 == 0) goto L_0x01e2
            r0 = r6
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            com.travel.train.fragment.h$h r1 = new com.travel.train.fragment.h$h
            r1.<init>(r6)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r7.observe(r0, r1)
        L_0x01e2:
            android.content.Context r7 = r6.getContext()
            if (r7 == 0) goto L_0x01f5
            android.content.Context r7 = r7.getApplicationContext()
            if (r7 == 0) goto L_0x01f5
            com.travel.train.j.w$a r0 = com.travel.train.j.w.f27609a
            com.paytm.b.a.a r7 = com.travel.train.j.w.a.a(r7)
            goto L_0x01f6
        L_0x01f5:
            r7 = r8
        L_0x01f6:
            r6.p = r7
            int r7 = com.travel.train.R.id.search_by_station
            android.view.View r7 = r6.a((int) r7)
            if (r7 == 0) goto L_0x020e
            int r0 = com.travel.train.R.id.sep_route
            android.view.View r7 = r7.findViewById(r0)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x020e
            r0 = 4
            r7.setVisibility(r0)
        L_0x020e:
            int r7 = com.travel.train.R.id.search_by_station
            android.view.View r7 = r6.a((int) r7)
            r0 = 8
            if (r7 == 0) goto L_0x022d
            int r1 = com.travel.train.R.id.source_lyt
            android.view.View r7 = r7.findViewById(r1)
            if (r7 == 0) goto L_0x022d
            int r1 = com.travel.train.R.id.input_unselected
            android.view.View r7 = r7.findViewById(r1)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            if (r7 == 0) goto L_0x022d
            r7.setVisibility(r0)
        L_0x022d:
            int r7 = com.travel.train.R.id.search_by_station
            android.view.View r7 = r6.a((int) r7)
            r1 = 0
            if (r7 == 0) goto L_0x024b
            int r2 = com.travel.train.R.id.source_lyt
            android.view.View r7 = r7.findViewById(r2)
            if (r7 == 0) goto L_0x024b
            int r2 = com.travel.train.R.id.input_city_code
            android.view.View r7 = r7.findViewById(r2)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x024b
            r7.setVisibility(r1)
        L_0x024b:
            int r7 = com.travel.train.R.id.search_by_station
            android.view.View r7 = r6.a((int) r7)
            if (r7 == 0) goto L_0x0268
            int r2 = com.travel.train.R.id.destination_lyt
            android.view.View r7 = r7.findViewById(r2)
            if (r7 == 0) goto L_0x0268
            int r2 = com.travel.train.R.id.input_unselected
            android.view.View r7 = r7.findViewById(r2)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            if (r7 == 0) goto L_0x0268
            r7.setVisibility(r0)
        L_0x0268:
            int r7 = com.travel.train.R.id.search_by_station
            android.view.View r7 = r6.a((int) r7)
            if (r7 == 0) goto L_0x0285
            int r0 = com.travel.train.R.id.destination_lyt
            android.view.View r7 = r7.findViewById(r0)
            if (r7 == 0) goto L_0x0285
            int r0 = com.travel.train.R.id.input_city_code
            android.view.View r7 = r7.findViewById(r0)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0285
            r7.setVisibility(r1)
        L_0x0285:
            int r7 = com.travel.train.R.id.action_toolbar
            android.view.View r7 = r6.a((int) r7)
            if (r7 == 0) goto L_0x02a1
            int r0 = com.travel.train.R.id.train_toolbar_back_arrow
            android.view.View r7 = r7.findViewById(r0)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x02a1
            com.travel.train.fragment.h$b r0 = new com.travel.train.fragment.h$b
            r0.<init>(r6)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
        L_0x02a1:
            int r7 = com.travel.train.R.id.route_icon
            android.view.View r7 = r6.a((int) r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x02b5
            com.travel.train.fragment.h$c r0 = new com.travel.train.fragment.h$c
            r0.<init>(r6)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
        L_0x02b5:
            int r7 = com.travel.train.R.id.search_by_station
            android.view.View r7 = r6.a((int) r7)
            if (r7 == 0) goto L_0x02cf
            int r0 = com.travel.train.R.id.source_lyt
            android.view.View r7 = r7.findViewById(r0)
            if (r7 == 0) goto L_0x02cf
            com.travel.train.fragment.h$d r0 = new com.travel.train.fragment.h$d
            r0.<init>(r6)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
        L_0x02cf:
            int r7 = com.travel.train.R.id.search_by_station
            android.view.View r7 = r6.a((int) r7)
            if (r7 == 0) goto L_0x02e9
            int r0 = com.travel.train.R.id.destination_lyt
            android.view.View r7 = r7.findViewById(r0)
            if (r7 == 0) goto L_0x02e9
            com.travel.train.fragment.h$e r0 = new com.travel.train.fragment.h$e
            r0.<init>(r6)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
        L_0x02e9:
            int r7 = com.travel.train.R.id.see_calendar_view
            android.view.View r7 = r6.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x02fd
            com.travel.train.fragment.h$f r0 = new com.travel.train.fragment.h$f
            r0.<init>(r6)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
        L_0x02fd:
            com.paytm.b.a.a r7 = r6.p
            java.lang.String r0 = "train_show_tip_view_for_sbt_srp"
            if (r7 == 0) goto L_0x030d
            boolean r7 = r7.b((java.lang.String) r0, (boolean) r1, (boolean) r1)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x030e
        L_0x030d:
            r7 = r8
        L_0x030e:
            if (r7 != 0) goto L_0x0313
            kotlin.g.b.k.a()
        L_0x0313:
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x03cc
            int r7 = com.travel.train.R.id.search_by_station
            android.view.View r7 = r6.a((int) r7)
            if (r7 == 0) goto L_0x032a
            int r2 = com.travel.train.R.id.src_tip_lyt
            android.view.View r7 = r7.findViewById(r2)
            android.widget.TextView r7 = (android.widget.TextView) r7
            goto L_0x032b
        L_0x032a:
            r7 = r8
        L_0x032b:
            android.view.View r7 = (android.view.View) r7
            com.travel.train.hintsbuilder.a r2 = new com.travel.train.hintsbuilder.a
            androidx.fragment.app.FragmentActivity r3 = r6.getActivity()
            android.app.Activity r3 = (android.app.Activity) r3
            r2.<init>(r3)
            com.travel.train.hintsbuilder.a r7 = r2.a((android.view.View) r7)
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()
            if (r2 == 0) goto L_0x034f
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x034f
            int r3 = com.travel.train.R.string.train_show_tip_title_1_of_3
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0350
        L_0x034f:
            r2 = r8
        L_0x0350:
            com.travel.train.hintsbuilder.a r7 = r7.a((java.lang.String) r2)
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()
            if (r2 == 0) goto L_0x0367
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x0367
            int r3 = com.travel.train.R.string.train_show_tip_view_chng_src_desc
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0368
        L_0x0367:
            r2 = r8
        L_0x0368:
            com.travel.train.hintsbuilder.a r7 = r7.b((java.lang.String) r2)
            int r2 = r6.q
            com.travel.train.hintsbuilder.a r7 = r7.a((int) r2)
            com.travel.train.hintsbuilder.a r7 = r7.b()
            com.travel.train.hintsbuilder.a r7 = r7.c()
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()
            if (r2 == 0) goto L_0x038d
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x038d
            int r3 = com.travel.train.R.string.train_show_tip_view_positive_button1
            java.lang.String r2 = r2.getString(r3)
            goto L_0x038e
        L_0x038d:
            r2 = r8
        L_0x038e:
            com.travel.train.hintsbuilder.a r7 = r7.c(r2)
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()
            if (r2 == 0) goto L_0x03a5
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x03a5
            int r3 = com.travel.train.R.string.train_show_tip_view_negative_button1
            java.lang.String r2 = r2.getString(r3)
            goto L_0x03a6
        L_0x03a5:
            r2 = r8
        L_0x03a6:
            com.travel.train.hintsbuilder.a r7 = r7.d(r2)
            r2 = r6
            com.travel.train.hintsbuilder.c r2 = (com.travel.train.hintsbuilder.c) r2
            com.travel.train.hintsbuilder.a r7 = r7.a((com.travel.train.hintsbuilder.c) r2)
            int r2 = com.travel.train.R.layout.pre_t_train_show_square_tip_view
            com.travel.train.hintsbuilder.a r7 = r7.b((int) r2)
            com.travel.train.hintsbuilder.CJRTrainShowSquareTipsView r7 = r7.a()
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()
            android.app.Activity r2 = (android.app.Activity) r2
            r7.a((android.app.Activity) r2)
            com.paytm.b.a.a r7 = r6.p
            if (r7 == 0) goto L_0x03cc
            r2 = 1
            r7.a((java.lang.String) r0, (boolean) r2, (boolean) r1)
        L_0x03cc:
            r6.a()
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r7 = r6.j
            if (r7 == 0) goto L_0x03fd
            java.util.List r7 = r7.getSchedule()
            if (r7 == 0) goto L_0x03fd
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r6.k
            if (r0 == 0) goto L_0x03e6
            int r0 = r0.getSourceSelectedPosition()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x03e7
        L_0x03e6:
            r0 = r8
        L_0x03e7:
            if (r0 != 0) goto L_0x03ec
            kotlin.g.b.k.a()
        L_0x03ec:
            int r0 = r0.intValue()
            java.lang.Object r7 = r7.get(r0)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r7 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r7
            if (r7 == 0) goto L_0x03fd
            java.lang.String r7 = r7.getStationCode()
            goto L_0x03fe
        L_0x03fd:
            r7 = r8
        L_0x03fe:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r6.j
            if (r0 == 0) goto L_0x042c
            java.util.List r0 = r0.getSchedule()
            if (r0 == 0) goto L_0x042c
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r6.k
            if (r2 == 0) goto L_0x0415
            int r2 = r2.getSourceSelectedPosition()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0416
        L_0x0415:
            r2 = r8
        L_0x0416:
            if (r2 != 0) goto L_0x041b
            kotlin.g.b.k.a()
        L_0x041b:
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.get(r2)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
            if (r0 == 0) goto L_0x042c
            java.lang.String r0 = r0.getStationName()
            goto L_0x042d
        L_0x042c:
            r0 = r8
        L_0x042d:
            r6.a((java.lang.String) r7, (java.lang.String) r0)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r7 = r6.j
            if (r7 == 0) goto L_0x045e
            java.util.List r7 = r7.getSchedule()
            if (r7 == 0) goto L_0x045e
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = r6.k
            if (r0 == 0) goto L_0x0447
            int r0 = r0.getDestSelectedPosition()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0448
        L_0x0447:
            r0 = r8
        L_0x0448:
            if (r0 != 0) goto L_0x044d
            kotlin.g.b.k.a()
        L_0x044d:
            int r0 = r0.intValue()
            java.lang.Object r7 = r7.get(r0)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r7 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r7
            if (r7 == 0) goto L_0x045e
            java.lang.String r7 = r7.getStationCode()
            goto L_0x045f
        L_0x045e:
            r7 = r8
        L_0x045f:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r0 = r6.j
            if (r0 == 0) goto L_0x048c
            java.util.List r0 = r0.getSchedule()
            if (r0 == 0) goto L_0x048c
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r2 = r6.k
            if (r2 == 0) goto L_0x0476
            int r2 = r2.getDestSelectedPosition()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0477
        L_0x0476:
            r2 = r8
        L_0x0477:
            if (r2 != 0) goto L_0x047c
            kotlin.g.b.k.a()
        L_0x047c:
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.get(r2)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
            if (r0 == 0) goto L_0x048c
            java.lang.String r8 = r0.getStationName()
        L_0x048c:
            r6.b((java.lang.String) r7, (java.lang.String) r8)
            r6.a((boolean) r1)
            android.content.Context r7 = r6.getContext()
            java.lang.String r8 = "train_search_results"
            java.lang.String r0 = "Train number"
            java.lang.String r1 = "train_screen_loaded"
            java.lang.String r2 = "/trains"
            com.travel.train.j.o.a(r8, r0, r1, r2, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f26997a;

        b(h hVar) {
            this.f26997a = hVar;
        }

        public final void onClick(View view) {
            h.k(this.f26997a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f26998a;

        c(h hVar) {
            this.f26998a = hVar;
        }

        public final void onClick(View view) {
            h.l(this.f26998a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f26999a;

        d(h hVar) {
            this.f26999a = hVar;
        }

        public final void onClick(View view) {
            h.b(this.f26999a, false);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27000a;

        e(h hVar) {
            this.f27000a = hVar;
        }

        public final void onClick(View view) {
            h.b(this.f27000a, true);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f27001a;

        f(h hVar) {
            this.f27001a = hVar;
        }

        public final void onClick(View view) {
            h.e(this.f27001a, (String) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r7 = this;
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r0 = r7.f26990c
            r1 = 0
            if (r0 == 0) goto L_0x0010
            com.travel.train.model.searchResult.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0010
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r0 = r0.getTrainDetails()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            r7.f26992e = r0
            int r0 = com.travel.train.R.id.action_toolbar
            android.view.View r0 = r7.a((int) r0)
            if (r0 == 0) goto L_0x003e
            int r2 = com.travel.train.R.id.train_toolbar_title
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x003e
            android.content.Context r2 = r7.getContext()
            if (r2 == 0) goto L_0x0038
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x0038
            int r3 = com.travel.train.R.string.train_book_tickets_text
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0039
        L_0x0038:
            r2 = r1
        L_0x0039:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x003e:
            int r0 = com.travel.train.R.id.train_name_number_txt
            android.view.View r0 = r7.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0090
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r7.f26992e
            if (r3 == 0) goto L_0x0056
            java.lang.String r3 = r3.getTrainNumber()
            goto L_0x0057
        L_0x0056:
            r3 = r1
        L_0x0057:
            r2.append(r3)
            java.lang.String r3 = ": "
            r2.append(r3)
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r7.f26992e
            if (r3 == 0) goto L_0x0068
            java.lang.String r3 = r3.getTrainFullName()
            goto L_0x0069
        L_0x0068:
            r3 = r1
        L_0x0069:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x007a
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r7.f26992e
            if (r3 == 0) goto L_0x0083
            java.lang.String r3 = r3.getTrainFullName()
            goto L_0x0084
        L_0x007a:
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r7.f26992e
            if (r3 == 0) goto L_0x0083
            java.lang.String r3 = r3.getTrainName()
            goto L_0x0084
        L_0x0083:
            r3 = r1
        L_0x0084:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0090:
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r0 = r7.f26992e
            if (r0 == 0) goto L_0x009f
            com.travel.train.model.searchResult.FromStation r0 = r0.getFromStation()
            if (r0 == 0) goto L_0x009f
            java.lang.String r0 = r0.getDepartureDate()
            goto L_0x00a0
        L_0x009f:
            r0 = r1
        L_0x00a0:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = "dd MMM"
            java.lang.String r4 = "yyyyMMdd"
            java.lang.String r5 = ", "
            if (r2 != 0) goto L_0x00d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r2 = r7.f26992e
            if (r2 == 0) goto L_0x00c4
            com.travel.train.model.searchResult.FromStation r2 = r2.getFromStation()
            if (r2 == 0) goto L_0x00c4
            java.lang.String r2 = r2.getDepartureDate()
            goto L_0x00c5
        L_0x00c4:
            r2 = r1
        L_0x00c5:
            java.lang.String r2 = com.travel.train.j.i.b((java.lang.String) r2, (java.lang.String) r4, (java.lang.String) r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
        L_0x00d0:
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r2 = r7.f26992e
            if (r2 == 0) goto L_0x00df
            com.travel.train.model.searchResult.ToStation r2 = r2.getToStation()
            if (r2 == 0) goto L_0x00df
            java.lang.String r2 = r2.getArrivalDate()
            goto L_0x00e0
        L_0x00df:
            r2 = r1
        L_0x00e0:
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0109
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r5)
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r5 = r7.f26992e
            if (r5 == 0) goto L_0x00fd
            com.travel.train.model.searchResult.ToStation r5 = r5.getToStation()
            if (r5 == 0) goto L_0x00fd
            java.lang.String r5 = r5.getArrivalDate()
            goto L_0x00fe
        L_0x00fd:
            r5 = r1
        L_0x00fe:
            java.lang.String r3 = com.travel.train.j.i.b((java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
        L_0x0109:
            int r3 = com.travel.train.R.id.duration_layout
            android.view.View r3 = r7.a((int) r3)
            if (r3 == 0) goto L_0x0134
            int r4 = com.travel.train.R.id.departure_time
            android.view.View r3 = r3.findViewById(r4)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            if (r3 == 0) goto L_0x0134
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r4 = r7.f26992e
            if (r4 == 0) goto L_0x012a
            com.travel.train.model.searchResult.FromStation r4 = r4.getFromStation()
            if (r4 == 0) goto L_0x012a
            java.lang.String r4 = r4.getDepartureTime()
            goto L_0x012b
        L_0x012a:
            r4 = r1
        L_0x012b:
            java.lang.String r0 = kotlin.g.b.k.a((java.lang.String) r4, (java.lang.Object) r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
        L_0x0134:
            int r0 = com.travel.train.R.id.duration_layout
            android.view.View r0 = r7.a((int) r0)
            if (r0 == 0) goto L_0x015b
            int r3 = com.travel.train.R.id.source_name
            android.view.View r0 = r0.findViewById(r3)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x015b
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r7.f26992e
            if (r3 == 0) goto L_0x0155
            com.travel.train.model.searchResult.FromStation r3 = r3.getFromStation()
            if (r3 == 0) goto L_0x0155
            java.lang.String r3 = r3.getStationName()
            goto L_0x0156
        L_0x0155:
            r3 = r1
        L_0x0156:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x015b:
            int r0 = com.travel.train.R.id.duration_layout
            android.view.View r0 = r7.a((int) r0)
            if (r0 == 0) goto L_0x0186
            int r3 = com.travel.train.R.id.arriaval_time
            android.view.View r0 = r0.findViewById(r3)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x0186
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r7.f26992e
            if (r3 == 0) goto L_0x017c
            com.travel.train.model.searchResult.ToStation r3 = r3.getToStation()
            if (r3 == 0) goto L_0x017c
            java.lang.String r3 = r3.getArrivalTime()
            goto L_0x017d
        L_0x017c:
            r3 = r1
        L_0x017d:
            java.lang.String r2 = kotlin.g.b.k.a((java.lang.String) r3, (java.lang.Object) r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0186:
            int r0 = com.travel.train.R.id.duration_layout
            android.view.View r0 = r7.a((int) r0)
            if (r0 == 0) goto L_0x01ad
            int r2 = com.travel.train.R.id.destination_name
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x01ad
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r2 = r7.f26992e
            if (r2 == 0) goto L_0x01a7
            com.travel.train.model.searchResult.ToStation r2 = r2.getToStation()
            if (r2 == 0) goto L_0x01a7
            java.lang.String r2 = r2.getStationName()
            goto L_0x01a8
        L_0x01a7:
            r2 = r1
        L_0x01a8:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x01ad:
            int r0 = com.travel.train.R.id.duration_layout
            android.view.View r0 = r7.a((int) r0)
            if (r0 == 0) goto L_0x01ce
            int r2 = com.travel.train.R.id.total_hours
            android.view.View r0 = r0.findViewById(r2)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x01ce
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r2 = r7.f26992e
            if (r2 == 0) goto L_0x01c8
            java.lang.String r2 = r2.getDuration()
            goto L_0x01c9
        L_0x01c8:
            r2 = r1
        L_0x01c9:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x01ce:
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r0 = r7.f26992e
            if (r0 == 0) goto L_0x01ec
            java.lang.String r0 = r0.getRunningOn()
            if (r0 == 0) goto L_0x01ec
            if (r0 == 0) goto L_0x01e4
            char[] r0 = r0.toCharArray()
            java.lang.String r2 = "(this as java.lang.String).toCharArray()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            goto L_0x01ed
        L_0x01e4:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L_0x01ec:
            r0 = r1
        L_0x01ed:
            if (r0 != 0) goto L_0x01f0
            return
        L_0x01f0:
            int r2 = r0.length
            if (r2 <= 0) goto L_0x022a
            r3 = 1
        L_0x01f4:
            int r4 = com.travel.train.R.id.running_on
            android.view.View r4 = r7.a((int) r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0225
            int r5 = r3 + -1
            android.view.View r4 = r4.getChildAt(r5)
            if (r4 == 0) goto L_0x0225
            if (r0 == 0) goto L_0x020f
            char r5 = r0[r5]
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            goto L_0x0210
        L_0x020f:
            r5 = r1
        L_0x0210:
            char r5 = r5.charValue()
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            r6 = 89
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            boolean r5 = r5.equals(r6)
            r4.setSelected(r5)
        L_0x0225:
            if (r3 == r2) goto L_0x022a
            int r3 = r3 + 1
            goto L_0x01f4
        L_0x022a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.a():void");
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2) {
        View findViewById;
        TextView textView;
        View findViewById2;
        TextView textView2;
        View a2 = a(R.id.search_by_station);
        if (!(a2 == null || (findViewById2 = a2.findViewById(R.id.source_lyt)) == null || (textView2 = (TextView) findViewById2.findViewById(R.id.input_city_code)) == null)) {
            textView2.setText(str);
        }
        View a3 = a(R.id.search_by_station);
        if (a3 != null && (findViewById = a3.findViewById(R.id.source_lyt)) != null && (textView = (TextView) findViewById.findViewById(R.id.input_full_name)) != null) {
            textView.setText(str2);
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str, String str2) {
        View findViewById;
        TextView textView;
        View findViewById2;
        TextView textView2;
        View a2 = a(R.id.search_by_station);
        if (!(a2 == null || (findViewById2 = a2.findViewById(R.id.destination_lyt)) == null || (textView2 = (TextView) findViewById2.findViewById(R.id.input_city_code)) == null)) {
            textView2.setText(str);
        }
        View a3 = a(R.id.search_by_station);
        if (a3 != null && (findViewById = a3.findViewById(R.id.destination_lyt)) != null && (textView = (TextView) findViewById.findViewById(R.id.input_full_name)) != null) {
            textView.setText(str2);
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        if (!z) {
            ac acVar = this.f26993f;
            if (acVar != null) {
                if (acVar == null) {
                    kotlin.g.b.k.a();
                }
                if (acVar.isAdded()) {
                    Bundle b2 = b();
                    ac acVar2 = this.f26993f;
                    if (acVar2 == null) {
                        kotlin.g.b.k.a();
                    }
                    acVar2.b(b2);
                    return;
                }
            }
            this.f26993f = ac.a(b());
            androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
            if (childFragmentManager == null) {
                kotlin.g.b.k.a();
            }
            q a2 = childFragmentManager.a();
            kotlin.g.b.k.a((Object) a2, "childFragmentManager!!.beginTransaction()");
            int i2 = R.id.view_frame_train_search;
            ac acVar3 = this.f26993f;
            if (acVar3 == null) {
                kotlin.g.b.k.a();
            }
            a2.b(i2, acVar3);
            a2.c();
            return;
        }
        ac acVar4 = this.f26993f;
        if (acVar4 != null) {
            if (acVar4 == null) {
                kotlin.g.b.k.a();
            }
            if (acVar4.isAdded()) {
                Bundle c2 = c();
                q.a aVar = q.f27125a;
                this.f26994g = q.a.a(c2);
                androidx.fragment.app.j childFragmentManager2 = getChildFragmentManager();
                if (childFragmentManager2 == null) {
                    kotlin.g.b.k.a();
                }
                androidx.fragment.app.q a3 = childFragmentManager2.a();
                kotlin.g.b.k.a((Object) a3, "childFragmentManager!!.beginTransaction()");
                int i3 = R.id.view_frame_train_search;
                q qVar = this.f26994g;
                if (qVar == null) {
                    kotlin.g.b.k.a();
                }
                a3.b(i3, qVar);
                a3.c();
            }
        }
    }

    private final Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("search_by_train_result", this.f26990c);
        bundle.putSerializable("intent_extra_train_search_input", this.f26995h);
        return bundle;
    }

    private final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("search_by_train_result", this.f26991d);
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r1 = r1.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onBackPressed() {
        /*
            r3 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = r3.j
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r2 = "intent_extra_train_selected"
            r0.putExtra(r2, r1)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r1 = r3.k
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r2 = "intent_extra_schedule_selected"
            r0.putExtra(r2, r1)
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r3.f26990c
            if (r1 == 0) goto L_0x0026
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x0026
            java.lang.String r1 = r1.getSearchedDate()
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            java.lang.String r2 = "departureDate"
            r0.putExtra(r2, r1)
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            if (r1 == 0) goto L_0x0037
            r2 = 123(0x7b, float:1.72E-43)
            r1.setResult(r2, r0)
        L_0x0037:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.onBackPressed():boolean");
    }

    public final void a(View view, boolean z) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        Resources resources6;
        Resources resources7;
        String str = null;
        if (z) {
            View a2 = a(R.id.search_by_station);
            if (kotlin.g.b.k.a((Object) view, (Object) a2 != null ? (TextView) a2.findViewById(R.id.src_tip_lyt) : null)) {
                View a3 = a(R.id.search_by_station);
                com.travel.train.hintsbuilder.a a4 = new com.travel.train.hintsbuilder.a(getActivity()).a((View) a3 != null ? (TextView) a3.findViewById(R.id.dst_tip_lyt) : null);
                FragmentActivity activity = getActivity();
                com.travel.train.hintsbuilder.a a5 = a4.a((activity == null || (resources7 = activity.getResources()) == null) ? null : resources7.getString(R.string.train_show_tip_title_2_of_3));
                FragmentActivity activity2 = getActivity();
                com.travel.train.hintsbuilder.a c2 = a5.b((activity2 == null || (resources6 = activity2.getResources()) == null) ? null : resources6.getString(R.string.train_show_tip_view_chng_dest_desc)).a(this.q).b().c();
                FragmentActivity activity3 = getActivity();
                com.travel.train.hintsbuilder.a c3 = c2.c((activity3 == null || (resources5 = activity3.getResources()) == null) ? null : resources5.getString(R.string.train_show_tip_view_positive_button1));
                FragmentActivity activity4 = getActivity();
                if (!(activity4 == null || (resources4 = activity4.getResources()) == null)) {
                    str = resources4.getString(R.string.train_show_tip_view_negative_button1);
                }
                c3.d(str).a((com.travel.train.hintsbuilder.c) this).b(R.layout.pre_t_train_show_square_tip_view).a().a((Activity) getActivity());
                return;
            }
        }
        if (z) {
            View a6 = a(R.id.search_by_station);
            if (kotlin.g.b.k.a((Object) view, (Object) a6 != null ? (TextView) a6.findViewById(R.id.dst_tip_lyt) : null)) {
                com.travel.train.hintsbuilder.a a7 = new com.travel.train.hintsbuilder.a(getActivity()).a((View) (TextView) a(R.id.see_120_days_tip));
                FragmentActivity activity5 = getActivity();
                com.travel.train.hintsbuilder.a a8 = a7.a((activity5 == null || (resources3 = activity5.getResources()) == null) ? null : resources3.getString(R.string.train_show_tip_title_3_of_3));
                FragmentActivity activity6 = getActivity();
                com.travel.train.hintsbuilder.a c4 = a8.b((activity6 == null || (resources2 = activity6.getResources()) == null) ? null : resources2.getString(R.string.train_show_tip_view_120_days)).a(this.q).b().c();
                FragmentActivity activity7 = getActivity();
                if (!(activity7 == null || (resources = activity7.getResources()) == null)) {
                    str = resources.getString(R.string.train_show_tip_view_positive_button2);
                }
                c4.c(str).a((com.travel.train.hintsbuilder.c) this).b(R.layout.pre_t_train_show_square_tip_view).a().a((Activity) getActivity());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r1 = (r1 = (android.widget.TextView) (r1 = r1.findViewById(com.travel.train.R.id.source_lyt)).findViewById(com.travel.train.R.id.input_city_code)).getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(com.travel.train.fragment.h r4) {
        /*
            com.travel.train.model.CJRTrainSearchInput r0 = new com.travel.train.model.CJRTrainSearchInput
            r0.<init>()
            r4.f26995h = r0
            com.travel.train.model.CJRTrainSearchInput r0 = r4.f26995h
            if (r0 != 0) goto L_0x000e
            kotlin.g.b.k.a()
        L_0x000e:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.f26990c
            r2 = 0
            if (r1 == 0) goto L_0x002b
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x002b
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x002b
            com.travel.train.model.searchResult.FromStation r1 = r1.getFromStation()
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = r1.getStationCode()
            if (r1 != 0) goto L_0x0051
        L_0x002b:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x0050
            int r3 = com.travel.train.R.id.source_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x0050
            int r3 = com.travel.train.R.id.input_city_code
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0050
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = r1.toString()
            goto L_0x0051
        L_0x0050:
            r1 = r2
        L_0x0051:
            r0.setmSourceCityCode(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.f26995h
            if (r0 != 0) goto L_0x005b
            kotlin.g.b.k.a()
        L_0x005b:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.f26990c
            if (r1 == 0) goto L_0x0077
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x0077
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x0077
            com.travel.train.model.searchResult.FromStation r1 = r1.getFromStation()
            if (r1 == 0) goto L_0x0077
            java.lang.String r1 = r1.getStationName()
            if (r1 != 0) goto L_0x009d
        L_0x0077:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x009c
            int r3 = com.travel.train.R.id.source_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x009c
            int r3 = com.travel.train.R.id.input_full_name
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x009c
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x009c
            java.lang.String r1 = r1.toString()
            goto L_0x009d
        L_0x009c:
            r1 = r2
        L_0x009d:
            r0.setmSourceCityName(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.f26995h
            if (r0 != 0) goto L_0x00a7
            kotlin.g.b.k.a()
        L_0x00a7:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.f26990c
            if (r1 == 0) goto L_0x00c3
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x00c3
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x00c3
            com.travel.train.model.searchResult.FromStation r1 = r1.getFromStation()
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = r1.getStationName()
            if (r1 != 0) goto L_0x00e9
        L_0x00c3:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x00e8
            int r3 = com.travel.train.R.id.source_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x00e8
            int r3 = com.travel.train.R.id.input_full_name
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x00e8
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x00e8
            java.lang.String r1 = r1.toString()
            goto L_0x00e9
        L_0x00e8:
            r1 = r2
        L_0x00e9:
            r0.setSourceAirPortName(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.f26995h
            if (r0 != 0) goto L_0x00f3
            kotlin.g.b.k.a()
        L_0x00f3:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.f26990c
            if (r1 == 0) goto L_0x010f
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x010f
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x010f
            com.travel.train.model.searchResult.ToStation r1 = r1.getToStation()
            if (r1 == 0) goto L_0x010f
            java.lang.String r1 = r1.getStationCode()
            if (r1 != 0) goto L_0x0135
        L_0x010f:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x0134
            int r3 = com.travel.train.R.id.destination_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x0134
            int r3 = com.travel.train.R.id.input_city_code
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0134
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x0134
            java.lang.String r1 = r1.toString()
            goto L_0x0135
        L_0x0134:
            r1 = r2
        L_0x0135:
            r0.setmDestCityCode(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.f26995h
            if (r0 != 0) goto L_0x013f
            kotlin.g.b.k.a()
        L_0x013f:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.f26990c
            if (r1 == 0) goto L_0x015b
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x015b
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x015b
            com.travel.train.model.searchResult.ToStation r1 = r1.getToStation()
            if (r1 == 0) goto L_0x015b
            java.lang.String r1 = r1.getStationName()
            if (r1 != 0) goto L_0x0181
        L_0x015b:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x0180
            int r3 = com.travel.train.R.id.destination_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x0180
            int r3 = com.travel.train.R.id.input_full_name
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0180
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x0180
            java.lang.String r1 = r1.toString()
            goto L_0x0181
        L_0x0180:
            r1 = r2
        L_0x0181:
            r0.setmDestCityName(r1)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.f26995h
            if (r0 != 0) goto L_0x018b
            kotlin.g.b.k.a()
        L_0x018b:
            com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r1 = r4.f26990c
            if (r1 == 0) goto L_0x01aa
            com.travel.train.model.searchResult.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x01aa
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r1 = r1.getTrainDetails()
            if (r1 == 0) goto L_0x01aa
            com.travel.train.model.searchResult.ToStation r1 = r1.getToStation()
            if (r1 == 0) goto L_0x01aa
            java.lang.String r1 = r1.getStationName()
            if (r1 != 0) goto L_0x01a8
            goto L_0x01aa
        L_0x01a8:
            r2 = r1
            goto L_0x01ce
        L_0x01aa:
            int r1 = com.travel.train.R.id.search_by_station
            android.view.View r1 = r4.a((int) r1)
            if (r1 == 0) goto L_0x01ce
            int r3 = com.travel.train.R.id.destination_lyt
            android.view.View r1 = r1.findViewById(r3)
            if (r1 == 0) goto L_0x01ce
            int r3 = com.travel.train.R.id.input_full_name
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x01ce
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x01ce
            java.lang.String r2 = r1.toString()
        L_0x01ce:
            r0.setDestAirportName(r2)
            com.travel.train.model.CJRTrainSearchInput r0 = r4.f26995h
            if (r0 != 0) goto L_0x01d8
            kotlin.g.b.k.a()
        L_0x01d8:
            java.lang.String r4 = r4.l
            r0.setmDate(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.b(com.travel.train.fragment.h):void");
    }

    public static final /* synthetic */ void b(h hVar, String str) {
        boolean c2 = com.paytm.utility.b.c(str, "dd MMM yy");
        hVar.getActivity();
        String d2 = com.paytm.utility.b.d(str, "dd MMM yy", "EEE");
        kotlin.g.b.k.a((Object) d2, "CJRAppCommonUtility.form…ts.TRAIN_EEE_DATE_FORMAT)");
        hVar.getActivity();
        kotlin.g.b.k.a((Object) com.paytm.utility.b.d(str, "dd MMM yy", "dd MMMM EEEE"), "CJRAppCommonUtility.form…DD_MMMM_EEEE_DATE_FORMAT)");
        if (c2) {
            str = v.a(str, AppConstants.COMMA, " ", d2);
        }
        hVar.l = str;
    }

    public static final /* synthetic */ void g(h hVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("intent_extra_train_selected", hVar.j);
        bundle.putSerializable("intent_extra_schedule_selected", hVar.k);
        bundle.putSerializable("intent_extra_train_search_input", hVar.f26995h);
        bundle.putString("calendar_class", hVar.n);
        bundle.putString("intent_extra_date", hVar.l);
        ah.a aVar = ah.f26851f;
        ah ahVar = new ah();
        ahVar.setArguments(bundle);
        androidx.fragment.app.j childFragmentManager = hVar.getChildFragmentManager();
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
        ahVar.show(childFragmentManager, ah.class.getSimpleName());
    }

    public static final /* synthetic */ void b(h hVar, boolean z) {
        String str;
        List<CJRTrainLSSearchResult.Schedule> schedule;
        Bundle bundle = new Bundle();
        bundle.putSerializable("intent_extra_train_selected", hVar.j);
        bundle.putSerializable("intent_extra_schedule_selected", hVar.k);
        bundle.putBoolean("intent_extra_search_by_train", z);
        boolean z2 = true;
        bundle.putBoolean("from_search_by_train_result", true);
        bundle.putString("departureDate", hVar.l);
        Integer num = null;
        if (hVar.k != null) {
            CJRTrainLSSearchResult.Train train = hVar.j;
            if (!(train == null || (schedule = train.getSchedule()) == null)) {
                CJRTrainLSSearchResult.Schedule schedule2 = hVar.k;
                Integer valueOf = schedule2 != null ? Integer.valueOf(schedule2.getSourceSelectedPosition()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                CJRTrainLSSearchResult.Schedule schedule3 = schedule.get(valueOf.intValue());
                if (schedule3 != null) {
                    str = schedule3.getDayCount();
                    bundle.putString("selected_day_count", str);
                }
            }
            str = null;
            bundle.putString("selected_day_count", str);
        }
        if (z) {
            CJRTrainLSSearchResult.Schedule schedule4 = hVar.k;
            Integer valueOf2 = schedule4 != null ? Integer.valueOf(schedule4.getDestSelectedPosition()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            int intValue = valueOf2.intValue();
            CJRTrainLSSearchResult.Schedule schedule5 = hVar.k;
            if (schedule5 != null) {
                num = Integer.valueOf(schedule5.getSourceSelectedPosition());
            }
            if (num == null) {
                kotlin.g.b.k.a();
            }
            if (intValue < num.intValue()) {
                z2 = false;
            }
            bundle.putBoolean("intent_extra_search_by_train_flag", z2);
        }
        ag.a aVar = ag.f26836a;
        ag a2 = ag.a.a(bundle);
        androidx.fragment.app.j childFragmentManager = hVar.getChildFragmentManager();
        if (childFragmentManager == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager!!");
        a2.show(childFragmentManager, ag.class.getName());
        com.travel.train.j.o.a("train_homepage", "Train number", "station_change_selected", "/trains", hVar.getContext());
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void c(com.travel.train.fragment.h r6, java.lang.String r7) {
        /*
            com.travel.train.k.b r0 = r6.f26989b
            if (r0 == 0) goto L_0x0087
            android.content.Context r1 = r6.getContext()
            java.util.HashMap r1 = com.travel.train.j.n.b((android.content.Context) r1)
            java.lang.String r2 = "CJRTrainSearchResultsUtil.getHeaderParams(context)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r2 = r6.f26992e
            r3 = 0
            if (r2 == 0) goto L_0x001b
            java.lang.String r2 = r2.getTrainNumber()
            goto L_0x001c
        L_0x001b:
            r2 = r3
        L_0x001c:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r6.j
            if (r4 == 0) goto L_0x004a
            java.util.List r4 = r4.getSchedule()
            if (r4 == 0) goto L_0x004a
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = r6.k
            if (r5 == 0) goto L_0x0033
            int r5 = r5.getSourceSelectedPosition()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0034
        L_0x0033:
            r5 = r3
        L_0x0034:
            if (r5 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            int r5 = r5.intValue()
            java.lang.Object r4 = r4.get(r5)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
            if (r4 == 0) goto L_0x004a
            java.lang.String r4 = r4.getStationCode()
            goto L_0x004b
        L_0x004a:
            r4 = r3
        L_0x004b:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r5 = r6.j
            if (r5 == 0) goto L_0x0079
            java.util.List r5 = r5.getSchedule()
            if (r5 == 0) goto L_0x0079
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r6 = r6.k
            if (r6 == 0) goto L_0x0062
            int r6 = r6.getDestSelectedPosition()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0063
        L_0x0062:
            r6 = r3
        L_0x0063:
            if (r6 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            int r6 = r6.intValue()
            java.lang.Object r6 = r5.get(r6)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r6 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r6
            if (r6 == 0) goto L_0x0079
            java.lang.String r6 = r6.getStationCode()
            goto L_0x007a
        L_0x0079:
            r6 = r3
        L_0x007a:
            java.util.HashMap r6 = com.travel.train.j.n.a((java.lang.String) r2, (java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r3)
            java.lang.String r7 = "CJRTrainSearchResultsUti…tionCode, mDepDate, null)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r7 = 0
            r0.a(r1, r6, r7)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.c(com.travel.train.fragment.h, java.lang.String):void");
    }

    public static final /* synthetic */ void j(h hVar) {
        TextView textView = (TextView) hVar.a(R.id.see_calendar_view);
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) hVar.a(R.id.see_120_days_tip);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        FrameLayout frameLayout = (FrameLayout) hVar.a(R.id.fragment_container);
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        Bundle bundle = new Bundle();
        Date a2 = com.travel.train.j.i.a((Activity) hVar.getActivity(), hVar.l, new Locale(com.paytm.utility.n.a()));
        androidx.fragment.app.q qVar = null;
        Long valueOf = a2 != null ? Long.valueOf(a2.getTime()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        bundle.putLong(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, valueOf.longValue());
        bundle.putString("selected_date", hVar.l);
        bundle.putSerializable("extra_intent_holiday_list", hVar.m);
        CJRSearchByTrainDetails cJRSearchByTrainDetails = hVar.f26992e;
        bundle.putString("running_on", cJRSearchByTrainDetails != null ? cJRSearchByTrainDetails.getRunningOn() : null);
        CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel = hVar.f26991d;
        bundle.putSerializable("calendar_data_list", cJRSearchByTrainNumberModel != null ? cJRSearchByTrainNumberModel.getBody() : null);
        bundle.putBoolean("for_120_days", true);
        bundle.putString("calendar_class", hVar.n);
        bundle.putBoolean("is_available_only", hVar.o);
        j.a aVar = j.f27027a;
        j jVar = new j();
        jVar.setArguments(bundle);
        androidx.fragment.app.j childFragmentManager = hVar.getChildFragmentManager();
        if (childFragmentManager != null) {
            qVar = childFragmentManager.a();
        }
        if (qVar != null) {
            qVar.a(R.id.fragment_container, jVar, j.class.getSimpleName());
        }
        if (qVar != null) {
            qVar.c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void e(com.travel.train.fragment.h r6, java.lang.String r7) {
        /*
            com.travel.train.k.b r0 = r6.f26989b
            if (r0 == 0) goto L_0x009e
            android.content.Context r1 = r6.getContext()
            java.util.HashMap r1 = com.travel.train.j.n.b((android.content.Context) r1)
            java.lang.String r2 = "CJRTrainSearchResultsUtil.getHeaderParams(context)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            com.travel.train.model.searchResult.CJRSearchByTrainDetails r2 = r6.f26992e
            r3 = 0
            if (r2 == 0) goto L_0x001b
            java.lang.String r2 = r2.getTrainNumber()
            goto L_0x001c
        L_0x001b:
            r2 = r3
        L_0x001c:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = r6.j
            if (r4 == 0) goto L_0x004a
            java.util.List r4 = r4.getSchedule()
            if (r4 == 0) goto L_0x004a
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r5 = r6.k
            if (r5 == 0) goto L_0x0033
            int r5 = r5.getSourceSelectedPosition()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0034
        L_0x0033:
            r5 = r3
        L_0x0034:
            if (r5 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            int r5 = r5.intValue()
            java.lang.Object r4 = r4.get(r5)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r4
            if (r4 == 0) goto L_0x004a
            java.lang.String r4 = r4.getStationCode()
            goto L_0x004b
        L_0x004a:
            r4 = r3
        L_0x004b:
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r5 = r6.j
            if (r5 == 0) goto L_0x0079
            java.util.List r5 = r5.getSchedule()
            if (r5 == 0) goto L_0x0079
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r6 = r6.k
            if (r6 == 0) goto L_0x0062
            int r6 = r6.getDestSelectedPosition()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0063
        L_0x0062:
            r6 = r3
        L_0x0063:
            if (r6 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            int r6 = r6.intValue()
            java.lang.Object r6 = r5.get(r6)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r6 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r6
            if (r6 == 0) goto L_0x0079
            java.lang.String r6 = r6.getStationCode()
            goto L_0x007a
        L_0x0079:
            r6 = r3
        L_0x007a:
            java.util.HashMap r6 = com.travel.train.j.n.a((java.lang.String) r2, (java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r3, (java.lang.String) r7)
            java.lang.String r7 = "CJRTrainSearchResultsUti… null, selectedClassType)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = "headers"
            kotlin.g.b.k.c(r1, r7)
            java.lang.String r7 = "urlParams"
            kotlin.g.b.k.c(r6, r7)
            androidx.lifecycle.y<java.lang.Boolean> r7 = r0.f27624d
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r7.postValue(r2)
            com.travel.train.a.a r7 = r0.j
            if (r7 == 0) goto L_0x009e
            com.paytm.network.listener.b r0 = (com.paytm.network.listener.b) r0
            r7.c(r0, r0, r1, r6)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.h.e(com.travel.train.fragment.h, java.lang.String):void");
    }

    public static final /* synthetic */ void k(h hVar) {
        FragmentActivity activity = hVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public static final /* synthetic */ void l(h hVar) {
        ac acVar = hVar.f26993f;
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = null;
        if (acVar != null) {
            if (acVar == null) {
                kotlin.g.b.k.a();
            }
            if (acVar.isAdded()) {
                ac acVar2 = hVar.f26993f;
                if (acVar2 != null) {
                    acVar2.a((CJRTrainSearchResultsTrain) null);
                    return;
                }
                return;
            }
        }
        q qVar = hVar.f26994g;
        if (qVar != null) {
            if (qVar == null) {
                kotlin.g.b.k.a();
            }
            if (qVar.isAdded()) {
                hVar.getActivity();
                CJRTrainSearchResults a2 = com.travel.train.helper.b.a(hVar.f26991d);
                if (a2.getBody() != null) {
                    CJRTrainSearchResultsBody body = a2.getBody();
                    if (body == null) {
                        kotlin.g.b.k.a();
                    }
                    if (body.getTrains().size() > 0) {
                        CJRTrainSearchResultsBody body2 = a2.getBody();
                        if (body2 == null) {
                            kotlin.g.b.k.a();
                        }
                        List<CJRTrainSearchResultsTrain> trains = body2.getTrains();
                        if (trains == null) {
                            kotlin.g.b.k.a();
                        }
                        cJRTrainSearchResultsTrain = trains.get(0);
                    }
                }
                Intent intent = new Intent(hVar.getActivity(), AJRTrainViewRoute.class);
                intent.putExtra("extra_home_data", cJRTrainSearchResultsTrain);
                intent.putExtra("extra_selected_train_detail", hVar.f26995h);
                hVar.startActivity(intent);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final h a(Bundle bundle) {
        h hVar = new h();
        hVar.setArguments(bundle);
        return hVar;
    }
}
