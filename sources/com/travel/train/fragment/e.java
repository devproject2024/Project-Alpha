package com.travel.train.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.activity.AJRTrainLiveStatus;
import com.travel.train.b.ah;
import com.travel.train.b.aj;
import com.travel.train.fragment.af;
import com.travel.train.fragment.ag;
import com.travel.train.i.n;
import com.travel.train.i.t;
import com.travel.train.i.v;
import com.travel.train.j.m;
import com.travel.train.k.g;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class e extends am implements n, t, v {

    /* renamed from: i  reason: collision with root package name */
    public static final a f26935i = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    ah<?> f26936a;

    /* renamed from: b  reason: collision with root package name */
    ah<?> f26937b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<CJRTrainLSSearchResult.Train> f26938c;

    /* renamed from: d  reason: collision with root package name */
    List<CJRTrainRecentsItemModel> f26939d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public String f26940e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public com.travel.train.k.a f26941f;

    /* renamed from: g  reason: collision with root package name */
    boolean f26942g;

    /* renamed from: h  reason: collision with root package name */
    boolean f26943h;
    /* access modifiers changed from: private */
    public List<? extends CJRBookings> j;
    private aj k;
    /* access modifiers changed from: private */
    public final long l = 300;
    /* access modifiers changed from: private */
    public Handler m;
    /* access modifiers changed from: private */
    public Runnable n;
    private af o;
    private ag p;
    private CJRTrainLSSearchResult.Train q;
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

    static final class b<T> implements z<List<? extends CJRBookings>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f26944a;

        b(e eVar) {
            this.f26944a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f26944a.j = (List) obj;
        }
    }

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f26945a;

        c(e eVar) {
            this.f26945a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f26945a.a(R.id.lottie_in_search));
            } else {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f26945a.a(R.id.lottie_in_search));
            }
        }
    }

    static final class d<T> implements z<CJRTrainLSSearchResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f26946a;

        d(e eVar) {
            this.f26946a = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.Integer} */
        /* JADX WARNING: type inference failed for: r3v1 */
        /* JADX WARNING: type inference failed for: r3v17 */
        /* JADX WARNING: type inference failed for: r3v18 */
        /* JADX WARNING: type inference failed for: r3v19 */
        /* JADX WARNING: type inference failed for: r3v20 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x01cb  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x01f0  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x01f9  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x01fc  */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x020a  */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x022f  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x0238  */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x023b  */
        /* JADX WARNING: Removed duplicated region for block: B:150:0x0249  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x0274  */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x027e  */
        /* JADX WARNING: Removed duplicated region for block: B:173:0x0292  */
        /* JADX WARNING: Removed duplicated region for block: B:305:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r9) {
            /*
                r8 = this;
                com.travel.train.model.trainticket.CJRTrainLSSearchResult r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult) r9
                com.travel.train.fragment.e r0 = r8.f26946a
                if (r9 == 0) goto L_0x042e
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Meta r1 = r9.getMeta()
                if (r1 == 0) goto L_0x0022
                com.travel.train.k.a r1 = r0.f26941f
                if (r1 == 0) goto L_0x0022
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Meta r2 = r9.getMeta()
                java.lang.String r3 = "searchResult.meta"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                java.lang.String r2 = r2.getServer_timestamp_ist()
                androidx.lifecycle.y<java.lang.String> r1 = r1.f27615d
                r1.postValue(r2)
            L_0x0022:
                java.util.List r1 = r9.getBody()
                r2 = 0
                if (r1 == 0) goto L_0x0078
                java.util.List r9 = r9.getBody()
                if (r9 == 0) goto L_0x0078
                int r1 = r9.size()
                if (r1 <= 0) goto L_0x0078
                java.lang.Object r1 = r9.get(r2)
                java.lang.String r3 = "bodies[0]"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Body r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Body) r1
                java.util.ArrayList r1 = r1.getTrains()
                r0.f26938c = r1
                java.lang.Object r9 = r9.get(r2)
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Body r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Body) r9
                java.lang.String r9 = r9.getMessage()
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                boolean r1 = android.text.TextUtils.isEmpty(r9)
                if (r1 != 0) goto L_0x0069
                int r1 = com.travel.train.R.id.empty_results_txt
                android.view.View r1 = r0.a((int) r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                if (r1 == 0) goto L_0x0078
                r1.setText(r9)
                goto L_0x0078
            L_0x0069:
                int r9 = com.travel.train.R.id.empty_results_txt
                android.view.View r9 = r0.a((int) r9)
                android.widget.TextView r9 = (android.widget.TextView) r9
                if (r9 == 0) goto L_0x0078
                int r1 = com.travel.train.R.string.train_search_empty_error
                r9.setText(r1)
            L_0x0078:
                java.lang.String r9 = r0.f26940e
                r1 = 1
                java.lang.String r3 = "search"
                boolean r9 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r9, (boolean) r1)
                r3 = 0
                if (r9 == 0) goto L_0x014d
                int r9 = com.travel.train.R.id.search_box
                android.view.View r9 = r0.a((int) r9)
                android.widget.EditText r9 = (android.widget.EditText) r9
                if (r9 == 0) goto L_0x009c
                android.text.Editable r9 = r9.getText()
                if (r9 == 0) goto L_0x009c
                int r9 = r9.length()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            L_0x009c:
                if (r3 != 0) goto L_0x00a1
                kotlin.g.b.k.a()
            L_0x00a1:
                int r9 = r3.intValue()
                if (r9 <= 0) goto L_0x0149
                com.travel.train.k.a r9 = r0.f26941f
                r1 = 8
                if (r9 == 0) goto L_0x0114
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                java.util.List r9 = (java.util.List) r9
                boolean r9 = com.travel.train.k.a.a((java.util.List<?>) r9)
                if (r9 != 0) goto L_0x0114
                int r9 = com.travel.train.R.id.non_suggested_lyt
                android.view.View r9 = r0.a((int) r9)
                android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
                if (r9 == 0) goto L_0x00c4
                r9.setVisibility(r1)
            L_0x00c4:
                int r9 = com.travel.train.R.id.no_results_lyt
                android.view.View r9 = r0.a((int) r9)
                android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
                if (r9 == 0) goto L_0x00d1
                r9.setVisibility(r1)
            L_0x00d1:
                int r9 = com.travel.train.R.id.empty_results_txt
                android.view.View r9 = r0.a((int) r9)
                android.widget.TextView r9 = (android.widget.TextView) r9
                if (r9 == 0) goto L_0x00de
                r9.setVisibility(r1)
            L_0x00de:
                int r9 = com.travel.train.R.id.suggested_trains_lyt
                android.view.View r9 = r0.a((int) r9)
                android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
                if (r9 == 0) goto L_0x00eb
                r9.setVisibility(r2)
            L_0x00eb:
                com.travel.train.b.ah r9 = new com.travel.train.b.ah
                android.content.Context r1 = r0.getContext()
                if (r1 != 0) goto L_0x00f6
                kotlin.g.b.k.a()
            L_0x00f6:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r2 = r0.f26938c
                java.util.List r2 = (java.util.List) r2
                r3 = r0
                com.travel.train.i.v r3 = (com.travel.train.i.v) r3
                r9.<init>(r1, r2, r3)
                r0.f26936a = r9
                int r9 = com.travel.train.R.id.suggested_trains_list
                android.view.View r9 = r0.a((int) r9)
                android.widget.ListView r9 = (android.widget.ListView) r9
                if (r9 == 0) goto L_0x0113
                com.travel.train.b.ah<?> r0 = r0.f26936a
                android.widget.ListAdapter r0 = (android.widget.ListAdapter) r0
                r9.setAdapter(r0)
            L_0x0113:
                return
            L_0x0114:
                int r9 = com.travel.train.R.id.empty_results_txt
                android.view.View r9 = r0.a((int) r9)
                android.widget.TextView r9 = (android.widget.TextView) r9
                if (r9 == 0) goto L_0x0121
                r9.setVisibility(r2)
            L_0x0121:
                int r9 = com.travel.train.R.id.non_suggested_lyt
                android.view.View r9 = r0.a((int) r9)
                android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
                if (r9 == 0) goto L_0x012e
                r9.setVisibility(r1)
            L_0x012e:
                int r9 = com.travel.train.R.id.no_results_lyt
                android.view.View r9 = r0.a((int) r9)
                android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
                if (r9 == 0) goto L_0x013b
                r9.setVisibility(r1)
            L_0x013b:
                int r9 = com.travel.train.R.id.suggested_trains_lyt
                android.view.View r9 = r0.a((int) r9)
                android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
                if (r9 == 0) goto L_0x0148
                r9.setVisibility(r1)
            L_0x0148:
                return
            L_0x0149:
                r0.a()
                return
            L_0x014d:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 == 0) goto L_0x015a
                int r9 = r9.size()
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                goto L_0x015b
            L_0x015a:
                r9 = r3
            L_0x015b:
                if (r9 != 0) goto L_0x0160
                kotlin.g.b.k.a()
            L_0x0160:
                int r9 = r9.intValue()
                if (r9 <= 0) goto L_0x042e
                boolean r9 = r0.f26942g
                if (r9 != 0) goto L_0x0328
                boolean r9 = r0.f26943h
                if (r9 == 0) goto L_0x0174
                com.travel.train.b.ah<?> r9 = r0.f26937b
                if (r9 == 0) goto L_0x0174
                goto L_0x0328
            L_0x0174:
                boolean r9 = r0.f26943h
                if (r9 == 0) goto L_0x0296
                com.travel.train.b.ah<?> r9 = r0.f26937b
                if (r9 == 0) goto L_0x0296
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r9 = r0.f26939d
                if (r9 == 0) goto L_0x0189
                int r9 = r9.size()
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                goto L_0x018a
            L_0x0189:
                r9 = r3
            L_0x018a:
                if (r9 != 0) goto L_0x018f
                kotlin.g.b.k.a()
            L_0x018f:
                int r9 = r9.intValue()
                if (r9 < 0) goto L_0x01c6
                r4 = 0
            L_0x0196:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r5 = r0.f26938c
                if (r5 == 0) goto L_0x01c1
                java.lang.Object r5 = r5.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r5 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r5
                if (r5 == 0) goto L_0x01c1
                java.lang.String r5 = r5.getTrainNumber()
                if (r5 == 0) goto L_0x01c1
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r6 = r0.f26939d
                if (r6 == 0) goto L_0x01b9
                java.lang.Object r6 = r6.get(r4)
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r6 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r6
                if (r6 == 0) goto L_0x01b9
                java.lang.String r6 = r6.getTrainNumber()
                goto L_0x01ba
            L_0x01b9:
                r6 = r3
            L_0x01ba:
                boolean r5 = r5.equals(r6)
                if (r5 != r1) goto L_0x01c1
                goto L_0x01c7
            L_0x01c1:
                if (r4 == r9) goto L_0x01c6
                int r4 = r4 + 1
                goto L_0x0196
            L_0x01c6:
                r4 = 0
            L_0x01c7:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x01ce
                kotlin.g.b.k.a()
            L_0x01ce:
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                if (r9 == 0) goto L_0x0206
                java.util.List r9 = r9.getSchedule()
                if (r9 == 0) goto L_0x0206
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r9
                if (r9 == 0) goto L_0x0206
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r1 = r0.f26939d
                if (r1 == 0) goto L_0x01f9
                java.lang.Object r1 = r1.get(r4)
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r1 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r1
                if (r1 == 0) goto L_0x01f9
                int r1 = r1.getSourceSelectedPosition()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x01fa
            L_0x01f9:
                r1 = r3
            L_0x01fa:
                if (r1 != 0) goto L_0x01ff
                kotlin.g.b.k.a()
            L_0x01ff:
                int r1 = r1.intValue()
                r9.setSourceSelectedPosition(r1)
            L_0x0206:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x020d
                kotlin.g.b.k.a()
            L_0x020d:
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                if (r9 == 0) goto L_0x0245
                java.util.List r9 = r9.getSchedule()
                if (r9 == 0) goto L_0x0245
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r9
                if (r9 == 0) goto L_0x0245
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r1 = r0.f26939d
                if (r1 == 0) goto L_0x0238
                java.lang.Object r1 = r1.get(r4)
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r1 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r1
                if (r1 == 0) goto L_0x0238
                int r1 = r1.getDestSelectedPosition()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x0239
            L_0x0238:
                r1 = r3
            L_0x0239:
                if (r1 != 0) goto L_0x023e
                kotlin.g.b.k.a()
            L_0x023e:
                int r1 = r1.intValue()
                r9.setDestSelectedPosition(r1)
            L_0x0245:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x024c
                kotlin.g.b.k.a()
            L_0x024c:
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                if (r9 == 0) goto L_0x027a
                java.util.List r9 = r9.getSchedule()
                if (r9 == 0) goto L_0x027a
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r9
                if (r9 == 0) goto L_0x027a
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r1 = r0.f26939d
                if (r1 == 0) goto L_0x0272
                java.lang.Object r1 = r1.get(r4)
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r1 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r1
                if (r1 == 0) goto L_0x0272
                java.lang.String r3 = r1.getDateOfTravel()
            L_0x0272:
                if (r3 != 0) goto L_0x0277
                kotlin.g.b.k.a()
            L_0x0277:
                r9.setSelectedDeparturedate(r3)
            L_0x027a:
                com.travel.train.k.a r9 = r0.f26941f
                if (r9 == 0) goto L_0x028e
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r1 = r0.f26938c
                if (r1 != 0) goto L_0x0285
                kotlin.g.b.k.a()
            L_0x0285:
                java.lang.Object r1 = r1.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r1
                r9.a((com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r1)
            L_0x028e:
                com.travel.train.k.a r9 = r0.f26941f
                if (r9 == 0) goto L_0x0295
                r9.a()
            L_0x0295:
                return
            L_0x0296:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x029d
                kotlin.g.b.k.a()
            L_0x029d:
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                if (r9 == 0) goto L_0x02b6
                java.util.List r9 = r9.getSchedule()
                if (r9 == 0) goto L_0x02b6
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r9
                if (r9 == 0) goto L_0x02b6
                r9.setSourceSelectedPosition(r2)
            L_0x02b6:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x02bd
                kotlin.g.b.k.a()
            L_0x02bd:
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                if (r9 == 0) goto L_0x02fd
                java.util.List r9 = r9.getSchedule()
                if (r9 == 0) goto L_0x02fd
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r9
                if (r9 == 0) goto L_0x02fd
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r4 = r0.f26938c
                if (r4 != 0) goto L_0x02da
                kotlin.g.b.k.a()
            L_0x02da:
                java.lang.Object r4 = r4.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r4 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r4
                if (r4 == 0) goto L_0x02f0
                java.util.List r4 = r4.getSchedule()
                if (r4 == 0) goto L_0x02f0
                int r3 = r4.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            L_0x02f0:
                if (r3 != 0) goto L_0x02f5
                kotlin.g.b.k.a()
            L_0x02f5:
                int r3 = r3.intValue()
                int r3 = r3 - r1
                r9.setDestSelectedPosition(r3)
            L_0x02fd:
                com.travel.train.k.a r9 = r0.f26941f
                if (r9 == 0) goto L_0x0311
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r1 = r0.f26938c
                if (r1 != 0) goto L_0x0308
                kotlin.g.b.k.a()
            L_0x0308:
                java.lang.Object r1 = r1.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r1
                r9.a((com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r1)
            L_0x0311:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x0318
                kotlin.g.b.k.a()
            L_0x0318:
                java.lang.Object r9 = r9.get(r2)
                java.lang.String r1 = "mSuggestedTrains!!.get(0)"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                r0.a(r9, r2, r2)
                goto L_0x042e
            L_0x0328:
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r9 = r0.f26939d
                if (r9 == 0) goto L_0x035f
                int r4 = r9.size()
                if (r4 < 0) goto L_0x035f
                r5 = 0
            L_0x0333:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r6 = r0.f26938c
                if (r6 == 0) goto L_0x035a
                java.lang.Object r6 = r6.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r6 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r6
                if (r6 == 0) goto L_0x035a
                java.lang.String r6 = r6.getTrainNumber()
                if (r6 == 0) goto L_0x035a
                java.lang.Object r7 = r9.get(r5)
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r7 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r7
                if (r7 == 0) goto L_0x0352
                java.lang.String r7 = r7.getTrainNumber()
                goto L_0x0353
            L_0x0352:
                r7 = r3
            L_0x0353:
                boolean r6 = r6.equals(r7)
                if (r6 != r1) goto L_0x035a
                goto L_0x0360
            L_0x035a:
                if (r5 == r4) goto L_0x035f
                int r5 = r5 + 1
                goto L_0x0333
            L_0x035f:
                r5 = 0
            L_0x0360:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x0367
                kotlin.g.b.k.a()
            L_0x0367:
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                if (r9 == 0) goto L_0x039f
                java.util.List r9 = r9.getSchedule()
                if (r9 == 0) goto L_0x039f
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r9
                if (r9 == 0) goto L_0x039f
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r1 = r0.f26939d
                if (r1 == 0) goto L_0x0392
                java.lang.Object r1 = r1.get(r5)
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r1 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r1
                if (r1 == 0) goto L_0x0392
                int r1 = r1.getSourceSelectedPosition()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x0393
            L_0x0392:
                r1 = r3
            L_0x0393:
                if (r1 != 0) goto L_0x0398
                kotlin.g.b.k.a()
            L_0x0398:
                int r1 = r1.intValue()
                r9.setSourceSelectedPosition(r1)
            L_0x039f:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x03a6
                kotlin.g.b.k.a()
            L_0x03a6:
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                if (r9 == 0) goto L_0x03de
                java.util.List r9 = r9.getSchedule()
                if (r9 == 0) goto L_0x03de
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r9
                if (r9 == 0) goto L_0x03de
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r1 = r0.f26939d
                if (r1 == 0) goto L_0x03d1
                java.lang.Object r1 = r1.get(r5)
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r1 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r1
                if (r1 == 0) goto L_0x03d1
                int r1 = r1.getDestSelectedPosition()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x03d2
            L_0x03d1:
                r1 = r3
            L_0x03d2:
                if (r1 != 0) goto L_0x03d7
                kotlin.g.b.k.a()
            L_0x03d7:
                int r1 = r1.intValue()
                r9.setDestSelectedPosition(r1)
            L_0x03de:
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r9 = r0.f26938c
                if (r9 != 0) goto L_0x03e5
                kotlin.g.b.k.a()
            L_0x03e5:
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r9
                if (r9 == 0) goto L_0x0413
                java.util.List r9 = r9.getSchedule()
                if (r9 == 0) goto L_0x0413
                java.lang.Object r9 = r9.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r9 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r9
                if (r9 == 0) goto L_0x0413
                java.util.List<com.travel.train.model.trainticket.CJRTrainRecentsItemModel> r1 = r0.f26939d
                if (r1 == 0) goto L_0x040b
                java.lang.Object r1 = r1.get(r5)
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r1 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r1
                if (r1 == 0) goto L_0x040b
                java.lang.String r3 = r1.getDateOfTravel()
            L_0x040b:
                if (r3 != 0) goto L_0x0410
                kotlin.g.b.k.a()
            L_0x0410:
                r9.setSelectedDeparturedate(r3)
            L_0x0413:
                com.travel.train.k.a r9 = r0.f26941f
                if (r9 == 0) goto L_0x0427
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r1 = r0.f26938c
                if (r1 != 0) goto L_0x041e
                kotlin.g.b.k.a()
            L_0x041e:
                java.lang.Object r1 = r1.get(r2)
                com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r1
                r9.a((com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r1)
            L_0x0427:
                com.travel.train.k.a r9 = r0.f26941f
                if (r9 == 0) goto L_0x042e
                r9.a()
            L_0x042e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.e.d.onChanged(java.lang.Object):void");
        }
    }

    /* renamed from: com.travel.train.fragment.e$e  reason: collision with other inner class name */
    static final class C0488e<T> implements z<com.paytm.network.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f26947a;

        C0488e(e eVar) {
            this.f26947a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.paytm.network.a aVar = (com.paytm.network.a) obj;
            if (aVar != null) {
                this.f26947a.a(aVar);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            g.a aVar = new g.a(g.b.LS);
            a.C0484a aVar2 = com.travel.train.a.a.f25797a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.f26941f = (com.travel.train.k.a) am.a(activity, (al.b) new com.travel.train.k.g(aVar.a(aVar2.a(new com.travel.train.a.a.a(context))))).a(com.travel.train.k.a.class);
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        if (arguments.containsKey("intent_extra_from_search_by_train")) {
            this.f26942g = arguments.getBoolean("intent_extra_from_search_by_train", false);
        }
        if (arguments.containsKey("intent_extra_from_train_home")) {
            this.f26943h = arguments.getBoolean("intent_extra_from_train_home", false);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_activity_ls_search_trains, viewGroup, false);
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f26948a;

        f(e eVar) {
            this.f26948a = eVar;
        }

        public final void onClick(View view) {
            this.f26948a.b();
            FragmentActivity activity = this.f26948a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class g implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f26949a;

        g(e eVar) {
            this.f26949a = eVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 3 && i2 != 6 && (keyEvent == null || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            if (keyEvent == null || !keyEvent.isShiftPressed()) {
                this.f26949a.b();
                this.f26949a.f26940e = "search";
                com.travel.train.k.a c2 = this.f26949a.f26941f;
                if (c2 != null) {
                    HashMap<String, String> b2 = com.travel.train.j.n.b(this.f26949a.getContext());
                    k.a((Object) b2, "CJRTrainSearchResultsUtil.getHeaderParams(context)");
                    k.a((Object) textView, "v");
                    c2.a(b2, textView.getText().toString());
                }
            }
            return false;
        }
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f26950a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        h(e eVar) {
            this.f26950a = eVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (String.valueOf(charSequence).length() <= 0) {
                this.f26950a.a();
            }
        }

        public final void afterTextChanged(Editable editable) {
            if (String.valueOf(editable).length() > 0) {
                if (this.f26950a.m == null) {
                    this.f26950a.m = new Handler();
                }
                this.f26950a.n = new a(this, editable);
                Handler e2 = this.f26950a.m;
                if (e2 != null) {
                    e2.postDelayed(this.f26950a.n, this.f26950a.l);
                    return;
                }
                return;
            }
            this.f26950a.a();
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f26951a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Editable f26952b;

            a(h hVar, Editable editable) {
                this.f26951a = hVar;
                this.f26952b = editable;
            }

            public final void run() {
                this.f26951a.f26950a.f26940e = "search";
                com.travel.train.k.a c2 = this.f26951a.f26950a.f26941f;
                if (c2 != null) {
                    HashMap<String, String> b2 = com.travel.train.j.n.b(this.f26951a.f26950a.getContext());
                    k.a((Object) b2, "CJRTrainSearchResultsUtil.getHeaderParams(context)");
                    c2.a(b2, String.valueOf(this.f26952b));
                }
                this.f26951a.f26950a.e();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CJRTrainLSSearchResult.Train train, boolean z, boolean z2) {
        af afVar = this.o;
        if ((afVar == null || !afVar.isVisible()) && train != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("intent_extra_train_selected", train);
            bundle.putBoolean("intent_extra_search_by_train", z2);
            if (z) {
                this.q = train;
                ag agVar = this.p;
                if (agVar == null) {
                    ag.a aVar = ag.f26836a;
                    this.p = ag.a.a(bundle);
                } else if (agVar != null) {
                    agVar.setArguments(bundle);
                }
                ag agVar2 = this.p;
                if (agVar2 != null) {
                    j childFragmentManager = getChildFragmentManager();
                    if (childFragmentManager == null) {
                        k.a();
                    }
                    k.a((Object) childFragmentManager, "childFragmentManager!!");
                    agVar2.show(childFragmentManager, ag.class.getName());
                    return;
                }
                return;
            }
            af afVar2 = this.o;
            if (afVar2 == null) {
                af.a aVar2 = af.f26830a;
                this.o = af.a.a(bundle);
                af afVar3 = this.o;
                if (afVar3 != null) {
                    afVar3.a((n) this);
                }
            } else if (afVar2 != null) {
                afVar2.setArguments(bundle);
            }
            af afVar4 = this.o;
            if (afVar4 != null) {
                j childFragmentManager2 = getChildFragmentManager();
                if (childFragmentManager2 == null) {
                    k.a();
                }
                afVar4.show(childFragmentManager2, af.class.getName());
            }
        }
    }

    private final void c() {
        if (this.f26941f == null || com.travel.train.k.a.a((List<?>) this.j)) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.upcoming_trips_lyt);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) a(R.id.upcoming_trips_lyt);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        this.k = new aj(getContext(), this.j, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView recyclerView = (RecyclerView) a(R.id.upcoming_trips_list);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.upcoming_trips_list);
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.k);
        }
    }

    private final void d() {
        if (this.f26941f == null || com.travel.train.k.a.a((List<?>) this.f26939d)) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.recent_searches_lyt);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) a(R.id.recent_searches_lyt);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        this.f26937b = new ah<>(context, this.f26939d, this);
        ListView listView = (ListView) a(R.id.recent_searches_list);
        if (listView != null) {
            listView.setAdapter(this.f26937b);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if ((this.f26941f == null || com.travel.train.k.a.a((List<?>) this.f26939d)) && (this.f26941f == null || com.travel.train.k.a.a((List<?>) this.j))) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.non_suggested_lyt);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.suggested_trains_lyt);
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.no_results_lyt);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            ResourceUtils.loadTrainImagesFromCDN((ImageView) a(R.id.no_results_image), "search_no_results.png", false, false, n.a.V1);
            TextView textView = (TextView) a(R.id.empty_results_txt);
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        LinearLayout linearLayout3 = (LinearLayout) a(R.id.non_suggested_lyt);
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        LinearLayout linearLayout4 = (LinearLayout) a(R.id.suggested_trains_lyt);
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        TextView textView2 = (TextView) a(R.id.empty_results_txt);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        d();
        c();
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.no_results_lyt);
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    public final void a(Object obj) {
        CJRTrainLSSearchResult.Schedule schedule;
        CJRTrainLSSearchResult.Schedule schedule2;
        k.c(obj, "train");
        b();
        if (obj instanceof CJRTrainLSSearchResult.Train) {
            CJRTrainLSSearchResult.Train train = (CJRTrainLSSearchResult.Train) obj;
            List<CJRTrainLSSearchResult.Schedule> schedule3 = train.getSchedule();
            if (!(schedule3 == null || (schedule2 = schedule3.get(0)) == null)) {
                schedule2.setSourceSelectedPosition(0);
            }
            List<CJRTrainLSSearchResult.Schedule> schedule4 = train.getSchedule();
            if (!(schedule4 == null || (schedule = schedule4.get(0)) == null)) {
                List<CJRTrainLSSearchResult.Schedule> schedule5 = train.getSchedule();
                Integer valueOf = schedule5 != null ? Integer.valueOf(schedule5.size()) : null;
                if (valueOf == null) {
                    k.a();
                }
                schedule.setDestSelectedPosition(valueOf.intValue() - 1);
            }
            com.travel.train.k.a aVar = this.f26941f;
            if (aVar != null) {
                aVar.a(train);
            }
            boolean z = this.f26942g;
            if (z || this.f26943h) {
                com.travel.train.k.a aVar2 = this.f26941f;
                if (aVar2 != null) {
                    aVar2.a();
                    return;
                }
                return;
            }
            a(train, z, true);
            return;
        }
        CJRTrainRecentsItemModel cJRTrainRecentsItemModel = (CJRTrainRecentsItemModel) obj;
        this.f26940e = "recentSearch";
        com.travel.train.k.a aVar3 = this.f26941f;
        if (aVar3 != null) {
            HashMap<String, String> b2 = com.travel.train.j.n.b(getContext());
            k.a((Object) b2, "CJRTrainSearchResultsUtil.getHeaderParams(context)");
            String trainNumber = cJRTrainRecentsItemModel.getTrainNumber();
            if (trainNumber == null) {
                k.a();
            }
            aVar3.a(b2, trainNumber);
        }
    }

    public final void a(CJRTrainLSSearchResult.Schedule schedule) {
        com.travel.train.k.a aVar = this.f26941f;
        if (aVar != null) {
            aVar.f27617f.postValue(schedule);
        }
        com.travel.train.k.a aVar2 = this.f26941f;
        if (aVar2 != null) {
            aVar2.f27618g.postValue(Boolean.TRUE);
        }
    }

    public final void a(com.paytm.network.a aVar) {
        k.c(aVar, "networking");
        com.paytm.utility.h hVar = new com.paytm.utility.h(getContext());
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        hVar.setTitle(context.getResources().getString(R.string.no_connection));
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        hVar.a(context2.getResources().getString(R.string.no_internet));
        Context context3 = getContext();
        if (context3 == null) {
            k.a();
        }
        k.a((Object) context3, "context!!");
        hVar.a(-3, context3.getResources().getString(R.string.network_retry_yes), new i(this, hVar, aVar));
        hVar.show();
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f26953a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f26954b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f26955c;

        i(e eVar, com.paytm.utility.h hVar, com.paytm.network.a aVar) {
            this.f26953a = eVar;
            this.f26954b = hVar;
            this.f26955c = aVar;
        }

        public final void onClick(View view) {
            this.f26954b.cancel();
            Context context = this.f26953a.getContext();
            if (context == null) {
                k.a();
            }
            if (com.paytm.utility.b.c(context)) {
                this.f26955c.a();
            } else {
                this.f26953a.a(this.f26955c);
            }
        }
    }

    public final void b() {
        FragmentActivity activity = getActivity();
        View view = null;
        if ((activity != null ? activity.getCurrentFocus() : null) != null) {
            FragmentActivity activity2 = getActivity();
            InputMethodManager inputMethodManager = (InputMethodManager) (activity2 != null ? activity2.getSystemService("input_method") : null);
            if (inputMethodManager == null) {
                k.a();
            }
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                view = activity3.getCurrentFocus();
            }
            if (view == null) {
                k.a();
            }
            k.a((Object) view, "activity?.currentFocus!!");
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        Handler handler = this.m;
        if (handler != null && handler != null) {
            handler.removeCallbacks(this.n);
        }
    }

    public final void onDetach() {
        super.onDetach();
        e();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Window window;
        y<com.paytm.network.a> yVar;
        LiveData liveData;
        LiveData liveData2;
        LiveData liveData3;
        k.c(view, "view");
        com.travel.train.k.a aVar = this.f26941f;
        if (!(aVar == null || (liveData3 = aVar.f27613b) == null)) {
            liveData3.observe(this, new b(this));
        }
        com.travel.train.k.a aVar2 = this.f26941f;
        if (!(aVar2 == null || (liveData2 = aVar2.f27614c) == null)) {
            liveData2.observe(this, new c(this));
        }
        com.travel.train.k.a aVar3 = this.f26941f;
        if (!(aVar3 == null || (liveData = aVar3.f27612a) == null)) {
            liveData.observe(this, new d(this));
        }
        com.travel.train.k.a aVar4 = this.f26941f;
        if (!(aVar4 == null || (yVar = aVar4.l) == null)) {
            yVar.observe(this, new C0488e(this));
        }
        ((ImageView) a(R.id.close_icon)).setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        LinearLayout linearLayout = (LinearLayout) a(R.id.close_icon_lyt);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new f(this));
        }
        EditText editText = (EditText) a(R.id.search_box);
        if (editText != null) {
            editText.setOnEditorActionListener(new g(this));
        }
        EditText editText2 = (EditText) a(R.id.search_box);
        if (editText2 != null) {
            editText2.addTextChangedListener(new h(this));
        }
        m.a aVar5 = m.f27577a;
        this.f26939d = m.a.a(getContext(), this.f26942g ? "search_train_most_visited" : "train_ls_recent_searched_pref");
        if (this.f26941f != null && com.travel.train.k.a.a((List<?>) this.j)) {
            if (this.f26941f == null) {
                k.a();
            }
            if (com.travel.train.k.a.a((List<?>) this.f26939d)) {
                EditText editText3 = (EditText) a(R.id.search_box);
                if (editText3 != null) {
                    editText3.requestFocus();
                }
                FragmentActivity activity = getActivity();
                if (!(activity == null || (window = activity.getWindow()) == null)) {
                    window.setSoftInputMode(4);
                }
            }
        }
        a();
        super.onViewCreated(view, bundle);
    }

    public final void a(CJRBookings cJRBookings) {
        k.c(cJRBookings, "item");
        Intent intent = new Intent(getContext(), AJRTrainLiveStatus.class);
        intent.putExtra("intent_extra_train_selected_number", cJRBookings.getTrainNumber());
        intent.putExtra("intent_extra_train_selected_name", cJRBookings.getTrainName());
        intent.putExtra("intent_extra_bp_selected_stn_name", cJRBookings.getmBoardingStationName());
        intent.putExtra("intent_extra_bp_selected_stn_code", cJRBookings.getmBoardingStationCode());
        intent.putExtra("intent_extra_selected_ls_date", cJRBookings.getmSourceDepartureDate());
        intent.putExtra("intent_extra_ls_destination_code", cJRBookings.getmReservationUpToStationCode());
        startActivity(intent);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final e a(Bundle bundle) {
        k.c(bundle, "args");
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }
}
