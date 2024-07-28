package com.travel.sale;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.travel.R;
import com.travel.sale.data.model.CampaignDetailsResponse;
import kotlin.u;

public final class CalendarView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    CampaignDetailsResponse f25670a;

    /* renamed from: b  reason: collision with root package name */
    public CardView f25671b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f25672c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25673d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25674e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25675f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f25676g;

    /* renamed from: h  reason: collision with root package name */
    public CheckBox f25677h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f25678i;
    public TextView j;
    final int k;
    final int l;
    int m;
    a n;
    boolean o;
    private RelativeLayout p;
    private int q;
    private int r;
    private boolean s;

    public interface a {
        void a();

        boolean b();

        boolean c();

        void d();
    }

    public CalendarView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (kotlin.g.b.g) null);
    }

    public CalendarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (kotlin.g.b.g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CalendarView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.g.b.g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CalendarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.k.c(context, "context");
        this.l = 1;
        this.m = this.k;
        this.s = true;
        RelativeLayout.inflate(context, R.layout.custom_calendar_view, this);
        View findViewById = findViewById(R.id.calendar_info_container);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.calendar_info_container)");
        this.p = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.registered_calender_view);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.registered_calender_view)");
        this.f25671b = (CardView) findViewById2;
        View findViewById3 = findViewById(R.id.custom_checkbox);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.custom_checkbox)");
        this.f25672c = (RelativeLayout) findViewById3;
        RelativeLayout relativeLayout = this.f25672c;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("customCheckbox");
        }
        relativeLayout.measure(0, 0);
        RelativeLayout relativeLayout2 = this.f25672c;
        if (relativeLayout2 == null) {
            kotlin.g.b.k.a("customCheckbox");
        }
        if (relativeLayout2 == null) {
            kotlin.g.b.k.a();
        }
        this.q = relativeLayout2.getMeasuredHeight();
        RelativeLayout relativeLayout3 = this.f25672c;
        if (relativeLayout3 == null) {
            kotlin.g.b.k.a("customCheckbox");
        }
        relativeLayout3.measure(0, 0);
        RelativeLayout relativeLayout4 = this.f25672c;
        if (relativeLayout4 == null) {
            kotlin.g.b.k.a("customCheckbox");
        }
        if (relativeLayout4 == null) {
            kotlin.g.b.k.a();
        }
        this.r = relativeLayout4.getMeasuredWidth();
        View findViewById4 = findViewById(R.id.atc_button_title);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById(R.id.atc_button_title)");
        this.f25673d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.calendar_title);
        kotlin.g.b.k.a((Object) findViewById5, "findViewById(R.id.calendar_title)");
        this.f25674e = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.calendar_description);
        kotlin.g.b.k.a((Object) findViewById6, "findViewById(R.id.calendar_description)");
        this.f25675f = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.success_tick);
        kotlin.g.b.k.a((Object) findViewById7, "findViewById(R.id.success_tick)");
        this.f25676g = (ImageView) findViewById7;
        RelativeLayout relativeLayout5 = this.f25672c;
        if (relativeLayout5 == null) {
            kotlin.g.b.k.a("customCheckbox");
        }
        if (relativeLayout5 != null) {
            relativeLayout5.setOnClickListener(new c(this));
        }
        View findViewById8 = findViewById(R.id.checkbox);
        kotlin.g.b.k.a((Object) findViewById8, "findViewById(R.id.checkbox)");
        this.f25677h = (CheckBox) findViewById8;
        View findViewById9 = findViewById(R.id.add_calender_container);
        kotlin.g.b.k.a((Object) findViewById9, "findViewById(R.id.add_calender_container)");
        this.f25678i = (LinearLayout) findViewById9;
        View findViewById10 = findViewById(R.id.calendar_hint_text);
        kotlin.g.b.k.a((Object) findViewById10, "findViewById(R.id.calendar_hint_text)");
        this.j = (TextView) findViewById10;
        CheckBox checkBox = this.f25677h;
        if (checkBox == null) {
            kotlin.g.b.k.a("checkbox");
        }
        if (checkBox != null) {
            checkBox.setClickable(false);
        }
        CheckBox checkBox2 = this.f25677h;
        if (checkBox2 == null) {
            kotlin.g.b.k.a("checkbox");
        }
        if (checkBox2 != null) {
            checkBox2.setFocusable(false);
        }
        LinearLayout linearLayout = this.f25678i;
        if (linearLayout == null) {
            kotlin.g.b.k.a("addCalenderContainer");
        }
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b(this));
        }
    }

    public final CampaignDetailsResponse getCampaignDetails() {
        return this.f25670a;
    }

    public final void setCampaignDetails(CampaignDetailsResponse campaignDetailsResponse) {
        this.f25670a = campaignDetailsResponse;
    }

    public final CardView getRegisteredCalenderView() {
        CardView cardView = this.f25671b;
        if (cardView == null) {
            kotlin.g.b.k.a("registeredCalenderView");
        }
        return cardView;
    }

    public final void setRegisteredCalenderView(CardView cardView) {
        kotlin.g.b.k.c(cardView, "<set-?>");
        this.f25671b = cardView;
    }

    public final RelativeLayout getCustomCheckbox() {
        RelativeLayout relativeLayout = this.f25672c;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("customCheckbox");
        }
        return relativeLayout;
    }

    public final void setCustomCheckbox(RelativeLayout relativeLayout) {
        kotlin.g.b.k.c(relativeLayout, "<set-?>");
        this.f25672c = relativeLayout;
    }

    public final TextView getAtcButtonTitle() {
        TextView textView = this.f25673d;
        if (textView == null) {
            kotlin.g.b.k.a("atcButtonTitle");
        }
        return textView;
    }

    public final void setAtcButtonTitle(TextView textView) {
        kotlin.g.b.k.c(textView, "<set-?>");
        this.f25673d = textView;
    }

    public final TextView getCalendarTitileTv() {
        TextView textView = this.f25674e;
        if (textView == null) {
            kotlin.g.b.k.a("calendarTitileTv");
        }
        return textView;
    }

    public final void setCalendarTitileTv(TextView textView) {
        kotlin.g.b.k.c(textView, "<set-?>");
        this.f25674e = textView;
    }

    public final TextView getCalendarDescription() {
        TextView textView = this.f25675f;
        if (textView == null) {
            kotlin.g.b.k.a("calendarDescription");
        }
        return textView;
    }

    public final void setCalendarDescription(TextView textView) {
        kotlin.g.b.k.c(textView, "<set-?>");
        this.f25675f = textView;
    }

    public final ImageView getSuccessTick() {
        ImageView imageView = this.f25676g;
        if (imageView == null) {
            kotlin.g.b.k.a("successTick");
        }
        return imageView;
    }

    public final void setSuccessTick(ImageView imageView) {
        kotlin.g.b.k.c(imageView, "<set-?>");
        this.f25676g = imageView;
    }

    public final CheckBox getCheckbox() {
        CheckBox checkBox = this.f25677h;
        if (checkBox == null) {
            kotlin.g.b.k.a("checkbox");
        }
        return checkBox;
    }

    public final void setCheckbox(CheckBox checkBox) {
        kotlin.g.b.k.c(checkBox, "<set-?>");
        this.f25677h = checkBox;
    }

    public final LinearLayout getAddCalenderContainer() {
        LinearLayout linearLayout = this.f25678i;
        if (linearLayout == null) {
            kotlin.g.b.k.a("addCalenderContainer");
        }
        return linearLayout;
    }

    public final void setAddCalenderContainer(LinearLayout linearLayout) {
        kotlin.g.b.k.c(linearLayout, "<set-?>");
        this.f25678i = linearLayout;
    }

    public final TextView getCalendarHintText() {
        TextView textView = this.j;
        if (textView == null) {
            kotlin.g.b.k.a("calendarHintText");
        }
        return textView;
    }

    public final void setCalendarHintText(TextView textView) {
        kotlin.g.b.k.c(textView, "<set-?>");
        this.j = textView;
    }

    public final RelativeLayout getCalendarInfoContainer() {
        return this.p;
    }

    public final void setCalendarInfoContainer(RelativeLayout relativeLayout) {
        kotlin.g.b.k.c(relativeLayout, "<set-?>");
        this.p = relativeLayout;
    }

    public final int getCALENDAR_VIEW_TYPE_BASIC() {
        return this.k;
    }

    public final int getCALENDAR_VIEW_TYPE_CUSTOM() {
        return this.l;
    }

    public final int getCalendarType() {
        return this.m;
    }

    public final void setCalendarType(int i2) {
        this.m = i2;
    }

    public final a getCalendarViewActionListener() {
        return this.n;
    }

    public final void setCalendarViewActionListener(a aVar) {
        this.n = aVar;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25679a;

        b(CalendarView calendarView) {
            this.f25679a = calendarView;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r3 = r3.getBody();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r3) {
            /*
                r2 = this;
                com.travel.sale.CalendarView r3 = r2.f25679a
                com.travel.sale.data.model.CampaignDetailsResponse r3 = r3.getCampaignDetails()
                r0 = 0
                if (r3 == 0) goto L_0x0018
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r3.getBody()
                if (r3 == 0) goto L_0x0018
                boolean r3 = r3.isInterested()
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                goto L_0x0019
            L_0x0018:
                r3 = r0
            L_0x0019:
                if (r3 != 0) goto L_0x001e
                kotlin.g.b.k.a()
            L_0x001e:
                boolean r3 = r3.booleanValue()
                if (r3 == 0) goto L_0x0047
                com.travel.sale.CalendarView r3 = r2.f25679a
                com.travel.sale.data.model.CampaignDetailsResponse r3 = r3.getCampaignDetails()
                if (r3 == 0) goto L_0x003b
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r3 = r3.getBody()
                if (r3 == 0) goto L_0x003b
                boolean r3 = r3.isAddedToCalendar()
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                goto L_0x003c
            L_0x003b:
                r3 = r0
            L_0x003c:
                if (r3 != 0) goto L_0x0041
                kotlin.g.b.k.a()
            L_0x0041:
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L_0x0082
            L_0x0047:
                com.travel.sale.CalendarView r3 = r2.f25679a
                com.travel.sale.data.model.CampaignDetailsResponse r1 = r3.f25670a
                if (r1 == 0) goto L_0x005b
                com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
                if (r1 == 0) goto L_0x005b
                boolean r0 = r1.isInterested()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            L_0x005b:
                if (r0 != 0) goto L_0x0060
                kotlin.g.b.k.a()
            L_0x0060:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x0075
                com.travel.sale.CalendarView$a r0 = r3.n
                if (r0 == 0) goto L_0x0082
                r3.setBasicCalendarCheckedState()
                com.travel.sale.CalendarView$a r3 = r3.n
                if (r3 == 0) goto L_0x0074
                r3.a()
            L_0x0074:
                return
            L_0x0075:
                boolean r0 = r3.c()
                if (r0 == 0) goto L_0x007f
                r3.setBasicCalendarUncheckedState()
                return
            L_0x007f:
                r3.setBasicCalendarCheckedState()
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.b.onClick(android.view.View):void");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25680a;

        c(CalendarView calendarView) {
            this.f25680a = calendarView;
        }

        public final void onClick(View view) {
            a calendarViewActionListener = this.f25680a.getCalendarViewActionListener();
            Boolean bool = null;
            Boolean valueOf = calendarViewActionListener != null ? Boolean.valueOf(calendarViewActionListener.c()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.booleanValue()) {
                this.f25680a.b();
                return;
            }
            a calendarViewActionListener2 = this.f25680a.getCalendarViewActionListener();
            if (calendarViewActionListener2 != null) {
                bool = Boolean.valueOf(calendarViewActionListener2.b());
            }
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (!bool.booleanValue()) {
                this.f25680a.b();
                return;
            }
            a calendarViewActionListener3 = this.f25680a.getCalendarViewActionListener();
            if (calendarViewActionListener3 != null) {
                calendarViewActionListener3.d();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setupCalendarVisibilityState() {
        /*
            r1 = this;
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r1.f25670a
            if (r0 == 0) goto L_0x0013
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.isDisplayAddToCalendar()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x0019
            kotlin.g.b.k.a()
        L_0x0019:
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0025
            r0 = 8
            r1.setCalendarVisibility(r0)
            return
        L_0x0025:
            r0 = 0
            r1.setCalendarVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.setupCalendarVisibilityState():void");
    }

    public final void setTypeDepedentVibility() {
        if (this.m == this.k) {
            setBasicCalendarVisibility(0);
            setCustomCalendarVisibility(8);
            return;
        }
        setBasicCalendarVisibility(8);
        setCustomCalendarVisibility(0);
    }

    public static /* synthetic */ void setCalendarViewType$default(CalendarView calendarView, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = Integer.valueOf(calendarView.k);
        }
        calendarView.setCalendarViewType(num);
    }

    public final void setCalendarViewType(Integer num) {
        if (num == null) {
            kotlin.g.b.k.a();
        }
        this.m = num.intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setCalendarType() {
        /*
            r2 = this;
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r2.f25670a
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isDisplayAddToCalendar()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 != 0) goto L_0x001a
            kotlin.g.b.k.a()
        L_0x001a:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0065
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r2.f25670a
            if (r0 == 0) goto L_0x0033
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0033
            boolean r0 = r0.isInterested()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            if (r0 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0061
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r2.f25670a
            if (r0 == 0) goto L_0x0051
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0051
            boolean r0 = r0.isAddedToCalendar()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
        L_0x0051:
            if (r1 != 0) goto L_0x0056
            kotlin.g.b.k.a()
        L_0x0056:
            boolean r0 = r1.booleanValue()
            if (r0 != 0) goto L_0x0061
            int r0 = r2.l
            r2.m = r0
            return
        L_0x0061:
            int r0 = r2.k
            r2.m = r0
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.setCalendarType():void");
    }

    public final void a() {
        CampaignDetailsResponse.CampaignDetails body;
        CampaignDetailsResponse.CampaignDetails body2;
        Boolean bool = null;
        if (this.m == this.k) {
            CampaignDetailsResponse campaignDetailsResponse = this.f25670a;
            if (!(campaignDetailsResponse == null || (body2 = campaignDetailsResponse.getBody()) == null)) {
                bool = Boolean.valueOf(body2.isAddedToCalendar());
            }
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                setBasicCalendarCheckedState();
            } else {
                setBasicCalendarUncheckedState();
            }
        } else {
            CampaignDetailsResponse campaignDetailsResponse2 = this.f25670a;
            if (!(campaignDetailsResponse2 == null || (body = campaignDetailsResponse2.getBody()) == null)) {
                bool = Boolean.valueOf(body.isAddedToCalendar());
            }
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (bool.booleanValue()) {
                setCustomCalendarCheckedState();
            } else {
                setCustomCalendarUnCheckedState();
            }
        }
    }

    public final void setCalendarVisibility(int i2) {
        setVisibility(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r1 = this;
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r1.f25670a
            if (r0 == 0) goto L_0x0013
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.isInterested()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x0019
            kotlin.g.b.k.a()
        L_0x0019:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002e
            com.travel.sale.CalendarView$a r0 = r1.n
            if (r0 == 0) goto L_0x003b
            r1.setCustomCalendarCheckedState()
            com.travel.sale.CalendarView$a r0 = r1.n
            if (r0 == 0) goto L_0x002d
            r0.a()
        L_0x002d:
            return
        L_0x002e:
            boolean r0 = r1.c()
            if (r0 == 0) goto L_0x0038
            r1.setCustomCalendarUnCheckedState()
            return
        L_0x0038:
            r1.setCustomCalendarCheckedState()
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.b():void");
    }

    public final void setBasicCalendarVisibility(int i2) {
        LinearLayout linearLayout = this.f25678i;
        if (linearLayout == null) {
            kotlin.g.b.k.a("addCalenderContainer");
        }
        linearLayout.setVisibility(i2);
    }

    public final void setCustomCalendarVisibility(int i2) {
        CardView cardView = this.f25671b;
        if (cardView == null) {
            kotlin.g.b.k.a("registeredCalenderView");
        }
        cardView.setVisibility(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r2 = r2.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setBasicCalendarCheckedState() {
        /*
            r3 = this;
            android.widget.CheckBox r0 = r3.f25677h
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "checkbox"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            r1 = 1
            r0.setChecked(r1)
            android.widget.TextView r0 = r3.j
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "calendarHintText"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0016:
            if (r0 == 0) goto L_0x002d
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r3.f25670a
            if (r2 == 0) goto L_0x0027
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = r2.getAddToCalendarText()
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x002d:
            r3.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.setBasicCalendarCheckedState():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r2 = r2.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setBasicCalendarUncheckedState() {
        /*
            r3 = this;
            android.widget.CheckBox r0 = r3.f25677h
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "checkbox"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            r1 = 0
            r0.setChecked(r1)
            android.widget.TextView r0 = r3.j
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "calendarHintText"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0016:
            if (r0 == 0) goto L_0x002d
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r3.f25670a
            if (r2 == 0) goto L_0x0027
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = r2.getAddToCalendarText()
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x002d:
            r3.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.setBasicCalendarUncheckedState():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r1 = r1.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setCustomCalendarCheckedState() {
        /*
            r3 = this;
            android.widget.TextView r0 = r3.f25674e
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "calendarTitileTv"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            com.travel.sale.data.model.CampaignDetailsResponse r1 = r3.f25670a
            r2 = 0
            if (r1 == 0) goto L_0x0019
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = r1.getAddedToCalendarText()
            goto L_0x001a
        L_0x0019:
            r1 = r2
        L_0x001a:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r3.f25675f
            if (r0 != 0) goto L_0x0028
            java.lang.String r1 = "calendarDescription"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0028:
            com.travel.sale.data.model.CampaignDetailsResponse r1 = r3.f25670a
            if (r1 == 0) goto L_0x0036
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
            if (r1 == 0) goto L_0x0036
            java.lang.String r2 = r1.getCalendarButtonText()
        L_0x0036:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            r0 = 1
            r3.a(r0)
            r3.d()
            r3.o = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.setCustomCalendarCheckedState():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r1 = r1.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setCustomCalendarUnCheckedState() {
        /*
            r3 = this;
            android.widget.TextView r0 = r3.f25674e
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "calendarTitileTv"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            com.travel.sale.data.model.CampaignDetailsResponse r1 = r3.f25670a
            r2 = 0
            if (r1 == 0) goto L_0x0019
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = r1.getCalendarButtonHeader()
            goto L_0x001a
        L_0x0019:
            r1 = r2
        L_0x001a:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r3.f25675f
            if (r0 != 0) goto L_0x0028
            java.lang.String r1 = "calendarDescription"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0028:
            com.travel.sale.data.model.CampaignDetailsResponse r1 = r3.f25670a
            if (r1 == 0) goto L_0x0036
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r1 = r1.getBody()
            if (r1 == 0) goto L_0x0036
            java.lang.String r2 = r1.getGetReminderText()
        L_0x0036:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            r0 = 0
            r3.a(r0)
            boolean r1 = r3.s
            if (r1 == 0) goto L_0x0046
            r3.s = r0
            return
        L_0x0046:
            r3.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.setCustomCalendarUnCheckedState():void");
    }

    public final void a(boolean z) {
        CampaignDetailsResponse.CampaignDetails body;
        CampaignDetailsResponse campaignDetailsResponse = this.f25670a;
        if (campaignDetailsResponse != null && (body = campaignDetailsResponse.getBody()) != null) {
            body.setAddedToCalendar(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
            r1 = this;
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r1.f25670a
            if (r0 == 0) goto L_0x0013
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.isAddedToCalendar()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x0019
            kotlin.g.b.k.a()
        L_0x0019:
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.c():boolean");
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        int[] iArr = new int[2];
        RelativeLayout relativeLayout = this.f25672c;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("customCheckbox");
        }
        if (relativeLayout == null) {
            kotlin.g.b.k.a();
        }
        iArr[0] = relativeLayout.getHeight();
        iArr[1] = (int) getResources().getDimension(R.dimen.dimen_25dp);
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        ofInt.addUpdateListener(new d(this));
        int[] iArr2 = new int[2];
        RelativeLayout relativeLayout2 = this.f25672c;
        if (relativeLayout2 == null) {
            kotlin.g.b.k.a("customCheckbox");
        }
        if (relativeLayout2 == null) {
            kotlin.g.b.k.a();
        }
        iArr2[0] = relativeLayout2.getWidth();
        iArr2[1] = (int) getResources().getDimension(R.dimen.dimen_25dp);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(iArr2);
        ofInt2.addUpdateListener(new e(this));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new f(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.addUpdateListener(new g(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playTogether(new Animator[]{ofInt, ofInt2, ofFloat2, ofFloat});
        animatorSet.addListener(new h(this));
        animatorSet.start();
    }

    static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25681a;

        d(CalendarView calendarView) {
            this.f25681a = calendarView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                RelativeLayout customCheckbox = this.f25681a.getCustomCheckbox();
                if (customCheckbox == null) {
                    kotlin.g.b.k.a();
                }
                ViewGroup.LayoutParams layoutParams = customCheckbox.getLayoutParams();
                kotlin.g.b.k.a((Object) layoutParams, "customCheckbox!!.getLayoutParams()");
                layoutParams.height = intValue;
                RelativeLayout customCheckbox2 = this.f25681a.getCustomCheckbox();
                if (customCheckbox2 == null) {
                    kotlin.g.b.k.a();
                }
                customCheckbox2.setLayoutParams(layoutParams);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25682a;

        e(CalendarView calendarView) {
            this.f25682a = calendarView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                RelativeLayout customCheckbox = this.f25682a.getCustomCheckbox();
                if (customCheckbox == null) {
                    kotlin.g.b.k.a();
                }
                ViewGroup.LayoutParams layoutParams = customCheckbox.getLayoutParams();
                kotlin.g.b.k.a((Object) layoutParams, "customCheckbox!!.getLayoutParams()");
                layoutParams.width = intValue;
                RelativeLayout customCheckbox2 = this.f25682a.getCustomCheckbox();
                if (customCheckbox2 == null) {
                    kotlin.g.b.k.a();
                }
                customCheckbox2.setLayoutParams(layoutParams);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25683a;

        f(CalendarView calendarView) {
            this.f25683a = calendarView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextView atcButtonTitle = this.f25683a.getAtcButtonTitle();
            if (atcButtonTitle == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                atcButtonTitle.setAlpha(((Float) animatedValue).floatValue());
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25684a;

        g(CalendarView calendarView) {
            this.f25684a = calendarView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ImageView successTick = this.f25684a.getSuccessTick();
            if (successTick == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                successTick.setAlpha(((Float) animatedValue).floatValue());
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25685a;

        h(CalendarView calendarView) {
            this.f25685a = calendarView;
        }

        public final void onAnimationEnd(Animator animator) {
            kotlin.g.b.k.c(animator, "animation");
            this.f25685a.a(true);
            RelativeLayout customCheckbox = this.f25685a.getCustomCheckbox();
            if (customCheckbox != null) {
                customCheckbox.setBackgroundResource(R.drawable.travel_oval_green_button);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{(int) getResources().getDimension(R.dimen.dimen_25dp), this.q});
        ofInt.addUpdateListener(new i(this));
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{(int) getResources().getDimension(R.dimen.dimen_25dp), this.r});
        ofInt2.addUpdateListener(new j(this));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new k(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat2.addUpdateListener(new l(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playTogether(new Animator[]{ofInt, ofInt2, ofFloat2, ofFloat});
        animatorSet.addListener(new m(this));
        animatorSet.start();
    }

    static final class i implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25686a;

        i(CalendarView calendarView) {
            this.f25686a = calendarView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                RelativeLayout customCheckbox = this.f25686a.getCustomCheckbox();
                if (customCheckbox == null) {
                    kotlin.g.b.k.a();
                }
                ViewGroup.LayoutParams layoutParams = customCheckbox.getLayoutParams();
                kotlin.g.b.k.a((Object) layoutParams, "customCheckbox!!.getLayoutParams()");
                layoutParams.height = intValue;
                RelativeLayout customCheckbox2 = this.f25686a.getCustomCheckbox();
                if (customCheckbox2 == null) {
                    kotlin.g.b.k.a();
                }
                customCheckbox2.setLayoutParams(layoutParams);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static final class j implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25687a;

        j(CalendarView calendarView) {
            this.f25687a = calendarView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                RelativeLayout customCheckbox = this.f25687a.getCustomCheckbox();
                if (customCheckbox == null) {
                    kotlin.g.b.k.a();
                }
                ViewGroup.LayoutParams layoutParams = customCheckbox.getLayoutParams();
                kotlin.g.b.k.a((Object) layoutParams, "customCheckbox!!.getLayoutParams()");
                layoutParams.width = intValue;
                RelativeLayout customCheckbox2 = this.f25687a.getCustomCheckbox();
                if (customCheckbox2 == null) {
                    kotlin.g.b.k.a();
                }
                customCheckbox2.setLayoutParams(layoutParams);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static final class k implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25688a;

        k(CalendarView calendarView) {
            this.f25688a = calendarView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextView atcButtonTitle = this.f25688a.getAtcButtonTitle();
            if (atcButtonTitle == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                atcButtonTitle.setAlpha(((Float) animatedValue).floatValue());
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static final class l implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25689a;

        l(CalendarView calendarView) {
            this.f25689a = calendarView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ImageView successTick = this.f25689a.getSuccessTick();
            if (successTick == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                successTick.setAlpha(((Float) animatedValue).floatValue());
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class m extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CalendarView f25690a;

        m(CalendarView calendarView) {
            this.f25690a = calendarView;
        }

        public final void onAnimationEnd(Animator animator) {
            kotlin.g.b.k.c(animator, "animation");
            this.f25690a.a(false);
            RelativeLayout customCheckbox = this.f25690a.getCustomCheckbox();
            if (customCheckbox != null) {
                customCheckbox.setBackgroundResource(R.drawable.travel_oval_button);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r3 = this;
            boolean r0 = r3.o
            if (r0 == 0) goto L_0x0051
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r3.f25670a
            r1 = 0
            if (r0 == 0) goto L_0x0018
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.isInterested()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            if (r0 != 0) goto L_0x001e
            kotlin.g.b.k.a()
        L_0x001e:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0051
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r3.f25670a
            if (r0 == 0) goto L_0x004e
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x004e
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r3.f25670a
            if (r2 == 0) goto L_0x0040
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x0040
            boolean r1 = r2.isAddedToCalendar()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x0040:
            if (r1 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            boolean r1 = r1.booleanValue()
            r1 = r1 ^ 1
            r0.setAddedToCalendar(r1)
        L_0x004e:
            r3.a()
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.CalendarView.f():void");
    }

    public final void g() {
        CampaignDetailsResponse.CampaignDetails body;
        CampaignDetailsResponse campaignDetailsResponse = this.f25670a;
        if (!(campaignDetailsResponse == null || (body = campaignDetailsResponse.getBody()) == null)) {
            body.setAddedToCalendar(false);
        }
        setCalendarType();
        if (this.m == this.k) {
            setBasicCalendarUncheckedState();
        } else {
            setCustomCalendarUnCheckedState();
        }
    }
}
