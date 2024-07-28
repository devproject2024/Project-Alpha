package com.travel.train.helper;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.b.ap;
import com.travel.train.j.n;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;

public final class d implements com.travel.train.hintsbuilder.c {

    /* renamed from: a  reason: collision with root package name */
    ap.a f27268a;

    /* renamed from: b  reason: collision with root package name */
    CJRTrainSearchResultsTrain f27269b;

    /* renamed from: c  reason: collision with root package name */
    HashMap<String, Object> f27270c;

    /* renamed from: d  reason: collision with root package name */
    a f27271d;

    /* renamed from: e  reason: collision with root package name */
    int f27272e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27273f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f27274g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f27275h;

    /* renamed from: i  reason: collision with root package name */
    private com.paytm.b.a.a f27276i;
    private boolean j;
    private boolean k;
    private FragmentActivity l;
    private HashMap<String, String> m;

    public interface a {
        void a(RecyclerView.v vVar, String str, int i2, String str2);

        void a(boolean z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x003d, code lost:
        r2 = r2.getMAvailability();
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(androidx.fragment.app.FragmentActivity r2, com.travel.train.b.ap.a r3, com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r4, java.util.HashMap<java.lang.String, java.lang.Object> r5, com.travel.train.helper.d.a r6, int r7, java.util.HashMap<java.lang.String, java.lang.String> r8) {
        /*
            r1 = this;
            java.lang.String r0 = "mContext"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r0 = "mHolder"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = "mTraindetails"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "mClassMap"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "mClassTypeSelectListener"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "mFilteredClassMap"
            kotlin.g.b.k.c(r8, r0)
            r1.<init>()
            r1.l = r2
            r1.f27268a = r3
            r1.f27269b = r4
            r1.f27270c = r5
            r1.f27271d = r6
            r1.f27272e = r7
            r1.m = r8
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r1.f27269b
            java.util.ArrayList r2 = r2.getMAvailability()
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x005a
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r1.f27269b
            if (r2 == 0) goto L_0x004c
            java.util.ArrayList r2 = r2.getMAvailability()
            if (r2 == 0) goto L_0x004c
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x004d
        L_0x004c:
            r2 = r3
        L_0x004d:
            if (r2 != 0) goto L_0x0052
            kotlin.g.b.k.a()
        L_0x0052:
            int r2 = r2.intValue()
            if (r2 <= 0) goto L_0x005a
            r2 = 1
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            r1.f27273f = r2
            com.travel.train.j.w$a r2 = com.travel.train.j.w.f27609a
            androidx.fragment.app.FragmentActivity r2 = r1.l
            android.content.Context r2 = r2.getApplicationContext()
            java.lang.String r5 = "mContext.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            com.paytm.b.a.a r2 = com.travel.train.j.w.a.a(r2)
            r1.f27276i = r2
            com.paytm.b.a.a r2 = r1.f27276i
            if (r2 == 0) goto L_0x007f
            java.lang.String r3 = "train_show_tip_view"
            boolean r2 = r2.b((java.lang.String) r3, (boolean) r4, (boolean) r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
        L_0x007f:
            if (r3 != 0) goto L_0x0084
            kotlin.g.b.k.a()
        L_0x0084:
            boolean r2 = r3.booleanValue()
            r1.j = r2
            r1.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.helper.d.<init>(androidx.fragment.app.FragmentActivity, com.travel.train.b.ap$a, com.travel.train.model.trainticket.CJRTrainSearchResultsTrain, java.util.HashMap, com.travel.train.helper.d$a, int, java.util.HashMap):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        r0 = r0.getMAvailability();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r10 = this;
            com.travel.train.b.ap$a r0 = r10.f27268a
            android.widget.LinearLayout r0 = r0.f26273e
            r0.removeAllViews()
            int r0 = r10.b()
            if (r0 <= 0) goto L_0x00c4
            com.travel.train.b.ap$a r0 = r10.f27268a
            android.widget.LinearLayout r0 = r0.f26273e
            java.lang.String r1 = "mHolder.mClassTypeInnerLayout"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = r10.b()
            float r1 = (float) r1
            r0.setWeightSum(r1)
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r0 = r10.f27269b
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00a8
            r3 = 0
            if (r0 == 0) goto L_0x0036
            java.util.ArrayList r0 = r0.getMAvailability()
            if (r0 == 0) goto L_0x0036
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0037
        L_0x0036:
            r0 = r3
        L_0x0037:
            if (r0 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x00a8
            int r0 = r10.b()
            int r0 = r0 - r2
            if (r0 < 0) goto L_0x00a8
            r4 = 0
        L_0x004a:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r5 = r10.f27269b
            if (r5 == 0) goto L_0x0061
            java.util.ArrayList r5 = r5.getMAvailability()
            if (r5 == 0) goto L_0x0061
            java.lang.Object r5 = r5.get(r4)
            com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject r5 = (com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject) r5
            if (r5 == 0) goto L_0x0061
            com.travel.train.model.trainticket.CJRTrainSearchResultsPNRPrediction r5 = r5.getMSearchPNRPrediction()
            goto L_0x0062
        L_0x0061:
            r5 = r3
        L_0x0062:
            android.view.View r6 = r10.a((int) r4)
            android.widget.LinearLayout$LayoutParams r7 = new android.widget.LinearLayout$LayoutParams
            r8 = -2
            r7.<init>(r8, r8)
            r8 = 1065353216(0x3f800000, float:1.0)
            r7.weight = r8
            r8 = 1086324736(0x40c00000, float:6.0)
            if (r4 != 0) goto L_0x007e
            androidx.fragment.app.FragmentActivity r9 = r10.l
            android.content.Context r9 = (android.content.Context) r9
            int r9 = com.paytm.utility.b.a((float) r8, (android.content.Context) r9)
            r7.leftMargin = r9
        L_0x007e:
            if (r5 == 0) goto L_0x008d
            r5 = -1069547520(0xffffffffc0400000, float:-3.0)
            androidx.fragment.app.FragmentActivity r8 = r10.l
            android.content.Context r8 = (android.content.Context) r8
            int r5 = com.paytm.utility.b.a((float) r5, (android.content.Context) r8)
            r7.rightMargin = r5
            goto L_0x0097
        L_0x008d:
            androidx.fragment.app.FragmentActivity r5 = r10.l
            android.content.Context r5 = (android.content.Context) r5
            int r5 = com.paytm.utility.b.a((float) r8, (android.content.Context) r5)
            r7.rightMargin = r5
        L_0x0097:
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r6.setLayoutParams(r7)
            com.travel.train.b.ap$a r5 = r10.f27268a
            android.widget.LinearLayout r5 = r5.f26273e
            r5.addView(r6)
            if (r4 == r0) goto L_0x00a8
            int r4 = r4 + 1
            goto L_0x004a
        L_0x00a8:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r0 = r10.f27269b
            boolean r0 = r0.isSearchByTrainResult()
            if (r0 != 0) goto L_0x00c4
            boolean r0 = r10.j
            if (r0 != 0) goto L_0x00c4
            boolean r0 = r10.k
            if (r0 != 0) goto L_0x00c4
            r10.j = r2
            r10.c()
            com.travel.train.helper.d$a r0 = r10.f27271d
            if (r0 == 0) goto L_0x00c4
            r0.a(r1)
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.helper.d.a():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x006c, code lost:
        r11 = r11.getMAvailability();
     */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(int r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.Context r2 = (android.content.Context) r2
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            int r3 = com.travel.train.R.layout.pre_t_train_class_type_list_item
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)
            int r3 = com.travel.train.R.id.lyt_class_parent
            android.view.View r3 = r2.findViewById(r3)
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            int r5 = com.travel.train.R.id.lyt_class_sub_inner
            android.view.View r5 = r2.findViewById(r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            int r6 = com.travel.train.R.id.class_type_text
            android.view.View r6 = r2.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = com.travel.train.R.id.seat_status_text
            android.view.View r7 = r2.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = com.travel.train.R.id.price_text
            android.view.View r8 = r2.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = com.travel.train.R.id.updated_status_text
            android.view.View r9 = r2.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r10 = com.travel.train.R.id.tip_text
            android.view.View r10 = r2.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r11 = com.travel.train.R.id.prediction_progressBar
            android.view.View r11 = r2.findViewById(r11)
            android.widget.ProgressBar r11 = (android.widget.ProgressBar) r11
            r0.f27274g = r11
            int r11 = com.travel.train.R.id.prediction_progressBar_txt
            android.view.View r11 = r2.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0.f27275h = r11
            boolean r11 = r0.f27273f
            java.lang.String r12 = ")"
            java.lang.String r13 = " ("
            r4 = 0
            if (r11 == 0) goto L_0x0495
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r11 = r0.f27269b
            if (r11 == 0) goto L_0x0079
            java.util.ArrayList r11 = r11.getMAvailability()
            if (r11 == 0) goto L_0x0079
            java.lang.Object r11 = r11.get(r1)
            com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject r11 = (com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject) r11
            goto L_0x007a
        L_0x0079:
            r11 = 0
        L_0x007a:
            if (r11 != 0) goto L_0x007f
            kotlin.g.b.k.a()
        L_0x007f:
            java.lang.String r14 = "mTraindetails?.mAvailability?.get(position)!!"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r14)
            java.lang.String r14 = r11.getColour()
            java.lang.String r17 = r11.getBackgroundColour()
            boolean r18 = r11.isCreated()
            if (r18 == 0) goto L_0x00cd
            if (r7 == 0) goto L_0x0097
            r7.setVisibility(r4)
        L_0x0097:
            if (r6 == 0) goto L_0x00a0
            java.lang.String r12 = ""
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r6.setText(r12)
        L_0x00a0:
            if (r7 == 0) goto L_0x00c9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = r11.getClassType()
            r12.append(r13)
            java.lang.String r13 = " - "
            r12.append(r13)
            java.lang.String r13 = r11.getClassType()
            java.util.HashMap<java.lang.String, java.lang.Object> r15 = r0.f27270c
            java.lang.String r13 = com.travel.train.j.n.a((java.lang.String) r13, (java.util.HashMap<java.lang.String, java.lang.Object>) r15)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r7.setText(r12)
        L_0x00c9:
            r19 = r2
            goto L_0x019f
        L_0x00cd:
            java.lang.String r15 = r11.getClassType()
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x010e
            if (r6 == 0) goto L_0x00de
            r6.setVisibility(r4)
        L_0x00de:
            if (r6 == 0) goto L_0x010b
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r4 = r11.getClassType()
            r19 = r2
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f27270c
            java.lang.String r2 = com.travel.train.j.n.a((java.lang.String) r4, (java.util.HashMap<java.lang.String, java.lang.Object>) r2)
            r15.append(r2)
            r15.append(r13)
            java.lang.String r2 = r11.getClassType()
            r15.append(r2)
            r15.append(r12)
            java.lang.String r2 = r15.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
            goto L_0x0117
        L_0x010b:
            r19 = r2
            goto L_0x0117
        L_0x010e:
            r19 = r2
            if (r6 == 0) goto L_0x0117
            r2 = 8
            r6.setVisibility(r2)
        L_0x0117:
            java.lang.String r2 = r11.getStatus()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0135
            if (r7 == 0) goto L_0x0129
            r2 = 0
            r7.setVisibility(r2)
        L_0x0129:
            if (r7 == 0) goto L_0x013c
            java.lang.String r2 = r11.getStatus()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r7.setText(r2)
            goto L_0x013c
        L_0x0135:
            if (r7 == 0) goto L_0x013c
            r2 = 8
            r7.setVisibility(r2)
        L_0x013c:
            java.lang.String r2 = r11.getFare()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0173
            r2 = 0
            if (r8 == 0) goto L_0x014e
            r8.setVisibility(r2)
        L_0x014e:
            if (r8 == 0) goto L_0x017a
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]
            androidx.fragment.app.FragmentActivity r12 = r0.l
            int r13 = com.travel.train.R.string.rupee_symbol
            java.lang.String r12 = r12.getString(r13)
            r4[r2] = r12
            java.lang.String r2 = " "
            r12 = 1
            r4[r12] = r2
            r2 = 2
            java.lang.String r12 = r11.getFare()
            r4[r2] = r12
            java.lang.String r2 = com.paytm.utility.v.a((java.lang.String[]) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r8.setText(r2)
            goto L_0x017a
        L_0x0173:
            if (r8 == 0) goto L_0x017a
            r2 = 8
            r8.setVisibility(r2)
        L_0x017a:
            java.lang.String r2 = r11.getTimeOfAvailability()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0198
            if (r9 == 0) goto L_0x018c
            r2 = 0
            r9.setVisibility(r2)
        L_0x018c:
            if (r9 == 0) goto L_0x019f
            java.lang.String r2 = r11.getTimeOfAvailability()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r9.setText(r2)
            goto L_0x019f
        L_0x0198:
            if (r9 == 0) goto L_0x019f
            r2 = 8
            r9.setVisibility(r2)
        L_0x019f:
            if (r11 == 0) goto L_0x01a6
            com.travel.train.model.trainticket.CJRTrainSearchResultsPNRPrediction r4 = r11.getMSearchPNRPrediction()
            goto L_0x01a7
        L_0x01a6:
            r4 = 0
        L_0x01a7:
            if (r4 == 0) goto L_0x0291
            r2 = 1
            r0.k = r2
            android.widget.ProgressBar r2 = r0.f27274g
            r12 = 0
            if (r2 == 0) goto L_0x01b4
            r2.setVisibility(r12)
        L_0x01b4:
            android.widget.ProgressBar r2 = r0.f27274g
            if (r2 == 0) goto L_0x01bf
            int r13 = r4.getValue()
            r2.setProgress(r13)
        L_0x01bf:
            android.widget.TextView r2 = r0.f27275h
            if (r2 == 0) goto L_0x01c6
            r2.setVisibility(r12)
        L_0x01c6:
            android.widget.TextView r2 = r0.f27275h
            if (r2 == 0) goto L_0x01e8
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            int r13 = r4.getValue()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r12.append(r13)
            java.lang.String r13 = "%"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r2.setText(r12)
        L_0x01e8:
            java.lang.String r2 = r4.getColor()
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x01f7
            java.lang.String r2 = "#00baf2"
        L_0x01f7:
            int r4 = android.os.Build.VERSION.SDK_INT
            r12 = 21
            if (r4 < r12) goto L_0x0210
            android.widget.ProgressBar r4 = r0.f27274g
            if (r4 == 0) goto L_0x0210
            android.graphics.drawable.Drawable r4 = r4.getProgressDrawable()
            if (r4 == 0) goto L_0x0210
            int r2 = android.graphics.Color.parseColor(r2)
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SRC_IN
            r4.setColorFilter(r2, r12)
        L_0x0210:
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r0.f27269b
            boolean r2 = r2.isSearchByTrainResult()
            if (r2 != 0) goto L_0x02a1
            boolean r2 = r0.j
            if (r2 != 0) goto L_0x02a1
            r2 = 1
            r0.j = r2
            r20.c()
            android.widget.ProgressBar r2 = r0.f27274g
            if (r2 == 0) goto L_0x02a1
            android.view.View r2 = (android.view.View) r2
            com.travel.train.hintsbuilder.b r4 = new com.travel.train.hintsbuilder.b
            androidx.fragment.app.FragmentActivity r12 = r0.l
            android.app.Activity r12 = (android.app.Activity) r12
            r4.<init>(r12)
            com.travel.train.hintsbuilder.b r2 = r4.a((android.view.View) r2)
            java.lang.String r4 = "1/3"
            com.travel.train.hintsbuilder.b r2 = r2.a((java.lang.String) r4)
            androidx.fragment.app.FragmentActivity r4 = r0.l
            android.content.res.Resources r4 = r4.getResources()
            int r12 = com.travel.train.R.string.train_show_tip_view_desc1
            java.lang.String r4 = r4.getString(r12)
            com.travel.train.hintsbuilder.b r2 = r2.b(r4)
            com.travel.train.hintsbuilder.b r2 = r2.b()
            com.travel.train.hintsbuilder.b r2 = r2.c()
            r4 = 1
            com.travel.train.hintsbuilder.b r2 = r2.a((boolean) r4)
            androidx.fragment.app.FragmentActivity r4 = r0.l
            android.content.res.Resources r4 = r4.getResources()
            int r12 = com.travel.train.R.string.train_show_tip_view_positive_button1
            java.lang.String r4 = r4.getString(r12)
            com.travel.train.hintsbuilder.b r2 = r2.c(r4)
            androidx.fragment.app.FragmentActivity r4 = r0.l
            android.content.res.Resources r4 = r4.getResources()
            int r12 = com.travel.train.R.string.train_show_tip_view_negative_button1
            java.lang.String r4 = r4.getString(r12)
            com.travel.train.hintsbuilder.b r2 = r2.d(r4)
            r4 = r0
            com.travel.train.hintsbuilder.c r4 = (com.travel.train.hintsbuilder.c) r4
            com.travel.train.hintsbuilder.b r2 = r2.a((com.travel.train.hintsbuilder.c) r4)
            int r4 = com.travel.train.R.layout.pre_t_train_intro_srp_show_tip_layout
            com.travel.train.hintsbuilder.b r2 = r2.a((int) r4)
            com.travel.train.hintsbuilder.CJRTrainShowTipsView r2 = r2.a()
            androidx.fragment.app.FragmentActivity r4 = r0.l
            android.app.Activity r4 = (android.app.Activity) r4
            r2.a((android.app.Activity) r4)
            goto L_0x02a1
        L_0x0291:
            android.widget.ProgressBar r2 = r0.f27274g
            r4 = 8
            if (r2 == 0) goto L_0x029a
            r2.setVisibility(r4)
        L_0x029a:
            android.widget.TextView r2 = r0.f27275h
            if (r2 == 0) goto L_0x02a1
            r2.setVisibility(r4)
        L_0x02a1:
            if (r11 == 0) goto L_0x02a8
            java.lang.String r4 = r11.getClassType()
            goto L_0x02a9
        L_0x02a8:
            r4 = 0
        L_0x02a9:
            if (r4 != 0) goto L_0x02ae
            kotlin.g.b.k.a()
        L_0x02ae:
            boolean r2 = r0.a((java.lang.String) r4)
            if (r2 == 0) goto L_0x03f6
            if (r6 == 0) goto L_0x02c5
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.color.color_222222
            int r2 = r2.getColor(r4)
            r6.setTextColor(r2)
        L_0x02c5:
            r2 = r17
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x02dd
            if (r7 == 0) goto L_0x02f0
            java.lang.String r4 = r11.getTxtColour()
            int r4 = android.graphics.Color.parseColor(r4)
            r7.setTextColor(r4)
            goto L_0x02f0
        L_0x02dd:
            if (r7 == 0) goto L_0x02f0
            androidx.fragment.app.FragmentActivity r4 = r0.l
            android.content.res.Resources r4 = r4.getResources()
            int r6 = com.travel.train.j.n.b((java.lang.String) r14)
            int r4 = r4.getColor(r6)
            r7.setTextColor(r4)
        L_0x02f0:
            if (r5 == 0) goto L_0x02fc
            android.graphics.drawable.Drawable r4 = r5.getBackground()     // Catch:{ Exception -> 0x02f9 }
            r16 = r4
            goto L_0x02fe
        L_0x02f9:
            goto L_0x03a4
        L_0x02fc:
            r16 = 0
        L_0x02fe:
            if (r16 == 0) goto L_0x039c
            android.graphics.drawable.StateListDrawable r16 = (android.graphics.drawable.StateListDrawable) r16     // Catch:{ Exception -> 0x02f9 }
            android.graphics.drawable.Drawable$ConstantState r4 = r16.getConstantState()     // Catch:{ Exception -> 0x02f9 }
            if (r4 == 0) goto L_0x0394
            android.graphics.drawable.DrawableContainer$DrawableContainerState r4 = (android.graphics.drawable.DrawableContainer.DrawableContainerState) r4     // Catch:{ Exception -> 0x02f9 }
            android.graphics.drawable.Drawable[] r4 = r4.getChildren()     // Catch:{ Exception -> 0x02f9 }
            r6 = 1
            r4 = r4[r6]     // Catch:{ Exception -> 0x02f9 }
            if (r4 == 0) goto L_0x038c
            android.graphics.drawable.GradientDrawable r4 = (android.graphics.drawable.GradientDrawable) r4     // Catch:{ Exception -> 0x02f9 }
            java.lang.String r6 = r11.getBackgroundColour()     // Catch:{ Exception -> 0x02f9 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x02f9 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02f9 }
            if (r6 != 0) goto L_0x0329
            int r6 = android.graphics.Color.parseColor(r17)     // Catch:{ Exception -> 0x02f9 }
            r4.setColor(r6)     // Catch:{ Exception -> 0x02f9 }
            goto L_0x033a
        L_0x0329:
            androidx.fragment.app.FragmentActivity r6 = r0.l     // Catch:{ Exception -> 0x02f9 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x02f9 }
            int r12 = com.travel.train.j.n.c((java.lang.String) r14)     // Catch:{ Exception -> 0x02f9 }
            int r6 = r6.getColor(r12)     // Catch:{ Exception -> 0x02f9 }
            r4.setColor(r6)     // Catch:{ Exception -> 0x02f9 }
        L_0x033a:
            r6 = r14
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x02f9 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02f9 }
            if (r6 == 0) goto L_0x034d
            r6 = r17
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x02f9 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02f9 }
            if (r6 != 0) goto L_0x0355
        L_0x034d:
            java.lang.String r6 = com.travel.train.j.g.ae     // Catch:{ Exception -> 0x02f9 }
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r6)     // Catch:{ Exception -> 0x02f9 }
            if (r6 == 0) goto L_0x0366
        L_0x0355:
            androidx.fragment.app.FragmentActivity r6 = r0.l     // Catch:{ Exception -> 0x02f9 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x02f9 }
            int r12 = com.travel.train.R.color.color_d2d2d2     // Catch:{ Exception -> 0x02f9 }
            int r6 = r6.getColor(r12)     // Catch:{ Exception -> 0x02f9 }
            r12 = 1
            r4.setStroke(r12, r6)     // Catch:{ Exception -> 0x02f9 }
            goto L_0x03c7
        L_0x0366:
            r6 = r17
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x02f9 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02f9 }
            if (r6 != 0) goto L_0x0379
            int r6 = android.graphics.Color.parseColor(r17)     // Catch:{ Exception -> 0x02f9 }
            r12 = 1
            r4.setStroke(r12, r6)     // Catch:{ Exception -> 0x02f9 }
            goto L_0x03c7
        L_0x0379:
            androidx.fragment.app.FragmentActivity r6 = r0.l     // Catch:{ Exception -> 0x02f9 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x02f9 }
            int r12 = com.travel.train.j.n.c((java.lang.String) r14)     // Catch:{ Exception -> 0x02f9 }
            int r6 = r6.getColor(r12)     // Catch:{ Exception -> 0x02f9 }
            r12 = 1
            r4.setStroke(r12, r6)     // Catch:{ Exception -> 0x02f9 }
            goto L_0x03c7
        L_0x038c:
            kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x02f9 }
            java.lang.String r6 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r4.<init>(r6)     // Catch:{ Exception -> 0x02f9 }
            throw r4     // Catch:{ Exception -> 0x02f9 }
        L_0x0394:
            kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x02f9 }
            java.lang.String r6 = "null cannot be cast to non-null type android.graphics.drawable.DrawableContainer.DrawableContainerState"
            r4.<init>(r6)     // Catch:{ Exception -> 0x02f9 }
            throw r4     // Catch:{ Exception -> 0x02f9 }
        L_0x039c:
            kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x02f9 }
            java.lang.String r6 = "null cannot be cast to non-null type android.graphics.drawable.StateListDrawable"
            r4.<init>(r6)     // Catch:{ Exception -> 0x02f9 }
            throw r4     // Catch:{ Exception -> 0x02f9 }
        L_0x03a4:
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x03b4
            if (r5 == 0) goto L_0x03c7
            int r2 = android.graphics.Color.parseColor(r17)
            r5.setBackgroundColor(r2)
            goto L_0x03c7
        L_0x03b4:
            if (r5 == 0) goto L_0x03c7
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.j.n.c((java.lang.String) r14)
            int r2 = r2.getColor(r4)
            r5.setBackgroundColor(r2)
        L_0x03c7:
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r7 == 0) goto L_0x03ce
            r7.setAlpha(r2)
        L_0x03ce:
            if (r8 == 0) goto L_0x03df
            androidx.fragment.app.FragmentActivity r4 = r0.l
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.train.R.color.black
            int r4 = r4.getColor(r5)
            r8.setTextColor(r4)
        L_0x03df:
            if (r9 == 0) goto L_0x03f0
            androidx.fragment.app.FragmentActivity r4 = r0.l
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.train.R.color.color_999999
            int r4 = r4.getColor(r5)
            r9.setTextColor(r4)
        L_0x03f0:
            if (r9 == 0) goto L_0x045a
            r9.setAlpha(r2)
            goto L_0x045a
        L_0x03f6:
            if (r6 == 0) goto L_0x0407
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.color.color_666666
            int r2 = r2.getColor(r4)
            r6.setTextColor(r2)
        L_0x0407:
            if (r6 == 0) goto L_0x040f
            r2 = 1056293519(0x3ef5c28f, float:0.48)
            r6.setAlpha(r2)
        L_0x040f:
            if (r7 == 0) goto L_0x0420
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.color.color_9d9d9d
            int r2 = r2.getColor(r4)
            r7.setTextColor(r2)
        L_0x0420:
            if (r7 == 0) goto L_0x0428
            r2 = 1056293519(0x3ef5c28f, float:0.48)
            r7.setAlpha(r2)
        L_0x0428:
            if (r8 == 0) goto L_0x0439
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.color.color_909090
            int r2 = r2.getColor(r4)
            r8.setTextColor(r2)
        L_0x0439:
            if (r8 == 0) goto L_0x0441
            r2 = 1056293519(0x3ef5c28f, float:0.48)
            r8.setAlpha(r2)
        L_0x0441:
            if (r9 == 0) goto L_0x0452
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.color.color_909090
            int r2 = r2.getColor(r4)
            r9.setTextColor(r2)
        L_0x0452:
            if (r9 == 0) goto L_0x045a
            r2 = 1056293519(0x3ef5c28f, float:0.48)
            r9.setAlpha(r2)
        L_0x045a:
            if (r3 == 0) goto L_0x0466
            com.travel.train.helper.d$b r2 = new com.travel.train.helper.d$b
            r2.<init>(r0, r11, r1)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r3.setOnClickListener(r2)
        L_0x0466:
            java.lang.String r1 = r11.getTipText()
            if (r1 == 0) goto L_0x048d
            if (r11 == 0) goto L_0x047a
            java.lang.String r1 = r11.getTipText()
            if (r1 == 0) goto L_0x047a
            int r1 = r1.length()
            if (r1 == 0) goto L_0x048d
        L_0x047a:
            if (r10 == 0) goto L_0x0480
            r1 = 0
            r10.setVisibility(r1)
        L_0x0480:
            if (r10 == 0) goto L_0x0543
            java.lang.String r1 = r11.getTipText()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r10.setText(r1)
            goto L_0x0543
        L_0x048d:
            if (r10 == 0) goto L_0x0543
            r1 = 4
            r10.setVisibility(r1)
            goto L_0x0543
        L_0x0495:
            r19 = r2
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r0.f27269b
            java.util.List r2 = r2.getClasses()
            if (r2 == 0) goto L_0x04a7
            java.lang.Object r2 = r2.get(r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x04a8
        L_0x04a7:
            r4 = 0
        L_0x04a8:
            if (r4 != 0) goto L_0x04ad
            kotlin.g.b.k.a()
        L_0x04ad:
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x04df
            if (r7 == 0) goto L_0x04bc
            r2 = 0
            r7.setVisibility(r2)
        L_0x04bc:
            if (r7 == 0) goto L_0x04e6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.f27270c
            java.lang.String r5 = com.travel.train.j.n.a((java.lang.String) r4, (java.util.HashMap<java.lang.String, java.lang.Object>) r5)
            r2.append(r5)
            r2.append(r13)
            r2.append(r4)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r7.setText(r2)
            goto L_0x04e6
        L_0x04df:
            if (r7 == 0) goto L_0x04e6
            r2 = 8
            r7.setVisibility(r2)
        L_0x04e6:
            boolean r2 = r0.a((java.lang.String) r4)
            if (r2 == 0) goto L_0x04fe
            if (r7 == 0) goto L_0x0530
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.color.color_222222
            int r2 = r2.getColor(r4)
            r7.setTextColor(r2)
            goto L_0x0530
        L_0x04fe:
            if (r7 == 0) goto L_0x0506
            r2 = 1056293519(0x3ef5c28f, float:0.48)
            r7.setAlpha(r2)
        L_0x0506:
            if (r7 == 0) goto L_0x0517
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.color.color_666666
            int r2 = r2.getColor(r4)
            r7.setTextColor(r2)
        L_0x0517:
            if (r9 == 0) goto L_0x0528
            androidx.fragment.app.FragmentActivity r2 = r0.l
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.travel.train.R.color.color_909090
            int r2 = r2.getColor(r4)
            r9.setTextColor(r2)
        L_0x0528:
            if (r9 == 0) goto L_0x0530
            r2 = 1056293519(0x3ef5c28f, float:0.48)
            r9.setAlpha(r2)
        L_0x0530:
            if (r3 == 0) goto L_0x053c
            com.travel.train.helper.d$c r2 = new com.travel.train.helper.d$c
            r2.<init>(r0, r1)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r3.setOnClickListener(r2)
        L_0x053c:
            if (r10 == 0) goto L_0x0543
            r1 = 8
            r10.setVisibility(r1)
        L_0x0543:
            java.lang.String r1 = "itemView"
            r2 = r19
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.helper.d.a(int):android.view.View");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f27277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRTrainSearchResultsAvailibiltyObject f27278b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f27279c;

        b(d dVar, CJRTrainSearchResultsAvailibiltyObject cJRTrainSearchResultsAvailibiltyObject, int i2) {
            this.f27277a = dVar;
            this.f27278b = cJRTrainSearchResultsAvailibiltyObject;
            this.f27279c = i2;
        }

        public final void onClick(View view) {
            if (this.f27277a.f27271d != null) {
                this.f27277a.f27271d.a(this.f27277a.f27268a, n.a(this.f27278b.getClassType(), this.f27277a.f27270c), this.f27277a.f27272e, this.f27278b.getQuota());
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f27280a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f27281b;

        c(d dVar, int i2) {
            this.f27280a = dVar;
            this.f27281b = i2;
        }

        public final void onClick(View view) {
            if (this.f27280a.f27271d != null) {
                this.f27280a.f27271d.a(this.f27280a.f27268a, n.a(this.f27280a.f27269b.getClasses().get(this.f27281b), this.f27280a.f27270c), this.f27280a.f27272e, this.f27280a.f27269b.getClasses().get(0));
            }
        }
    }

    private final boolean a(String str) {
        HashMap<String, String> hashMap = this.m;
        if (hashMap != null && hashMap.size() == 0) {
            return true;
        }
        HashMap<String, String> hashMap2 = this.m;
        if (hashMap2 == null) {
            return false;
        }
        for (Map.Entry<String, String> key : hashMap2.entrySet()) {
            if (p.a(str, (String) key.getKey(), true)) {
                return true;
            }
        }
        return false;
    }

    private int b() {
        ArrayList<CJRTrainSearchResultsAvailibiltyObject> mAvailability;
        ArrayList<CJRTrainSearchResultsAvailibiltyObject> mAvailability2;
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f27269b;
        Integer num = null;
        if ((cJRTrainSearchResultsTrain != null ? cJRTrainSearchResultsTrain.getMAvailability() : null) != null) {
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain2 = this.f27269b;
            Integer valueOf = (cJRTrainSearchResultsTrain2 == null || (mAvailability2 = cJRTrainSearchResultsTrain2.getMAvailability()) == null) ? null : Integer.valueOf(mAvailability2.size());
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 0) {
                CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain3 = this.f27269b;
                if (!(cJRTrainSearchResultsTrain3 == null || (mAvailability = cJRTrainSearchResultsTrain3.getMAvailability()) == null)) {
                    num = Integer.valueOf(mAvailability.size());
                }
                if (num == null) {
                    k.a();
                }
                return num.intValue();
            }
        }
        List<String> classes = this.f27269b.getClasses();
        if (classes != null) {
            num = Integer.valueOf(classes.size());
        }
        if (num == null) {
            k.a();
        }
        return num.intValue();
    }

    private void c() {
        com.paytm.b.a.a aVar = this.f27276i;
        if (aVar != null) {
            aVar.a("train_show_tip_view", true, false);
        }
    }

    public final void a(View view, boolean z) {
        if (z) {
            Integer num = null;
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            ProgressBar progressBar = this.f27274g;
            if (progressBar != null) {
                num = Integer.valueOf(progressBar.getId());
            }
            if (k.a((Object) valueOf, (Object) num)) {
                a aVar = this.f27271d;
                if (aVar != null) {
                    aVar.a(true);
                    return;
                }
                return;
            }
        }
        a aVar2 = this.f27271d;
        if (aVar2 != null) {
            aVar2.a(false);
        }
    }
}
