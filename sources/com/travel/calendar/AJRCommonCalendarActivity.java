package com.travel.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.tabs.TabLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.travel.CJRActionBarBaseActivity;
import com.travel.R;
import com.travel.calendar.g;
import com.travel.cdn.ResourceUtils;
import com.travel.model.CalendarHolidayList;
import com.travel.utils.m;
import com.travel.utils.n;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.widgets.CJRSmoothScrollViewPager;
import org.json.JSONObject;

public final class AJRCommonCalendarActivity extends CJRActionBarBaseActivity implements f {

    /* renamed from: a  reason: collision with root package name */
    private Date f22968a;

    /* renamed from: b  reason: collision with root package name */
    private String f22969b;

    /* renamed from: c  reason: collision with root package name */
    private Calendar f22970c;

    /* renamed from: d  reason: collision with root package name */
    private Calendar f22971d;

    /* renamed from: e  reason: collision with root package name */
    private g f22972e;

    /* renamed from: f  reason: collision with root package name */
    private Locale f22973f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f22974g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private b f22975h;

    /* renamed from: i  reason: collision with root package name */
    private final String f22976i = "E MMM dd HH:mm:ss Z yyyy";
    private final String j = "dd MMM yy";
    private String k = "";
    private com.travel.c.c l;
    /* access modifiers changed from: private */
    public int m = -1;
    private boolean n;
    private String o;
    private String p;
    private final g q = new g(this);
    private HashMap r;

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22977a = new a();

        a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f22978a = new b();

        b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e<T> implements z<Date> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCommonCalendarActivity f22981a;

        e(AJRCommonCalendarActivity aJRCommonCalendarActivity) {
            this.f22981a = aJRCommonCalendarActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (((Date) obj) != null) {
                AJRCommonCalendarActivity.a(this.f22981a).b();
                com.travel.utils.f fVar = com.travel.utils.f.ONE_WAY;
            }
        }
    }

    public static final /* synthetic */ g a(AJRCommonCalendarActivity aJRCommonCalendarActivity) {
        g gVar = aJRCommonCalendarActivity.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        return gVar;
    }

    public final void onCreate(Bundle bundle) {
        m mVar;
        super.onCreate(bundle);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        ViewDataBinding a2 = androidx.databinding.f.a(getLayoutInflater(), R.layout.activity_common_calendar, (ViewGroup) null, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…on_calendar, null, false)");
        this.l = (com.travel.c.c) a2;
        com.travel.c.c cVar = this.l;
        if (cVar == null) {
            k.a("binding");
        }
        frameLayout.addView(cVar.getRoot());
        if (getIntent() != null) {
            if (getIntent().hasExtra("is_from_order_modification")) {
                this.n = getIntent().getBooleanExtra("is_from_order_modification", false);
            }
            if (getIntent().hasExtra("intent_extra_start_date_range")) {
                this.o = getIntent().getStringExtra("intent_extra_start_date_range");
            }
            if (getIntent().hasExtra("intent_extra_end_date_range")) {
                this.p = getIntent().getStringExtra("intent_extra_end_date_range");
            }
        }
        e();
        this.s.f();
        ai a3 = am.a((FragmentActivity) this).a(g.class);
        k.a((Object) a3, "ViewModelProviders.of(th…darViewModel::class.java]");
        this.f22972e = (g) a3;
        this.f22973f = new Locale(n.a());
        Locale locale = this.f22973f;
        if (locale == null) {
            k.a("appLocale");
        }
        Calendar instance = Calendar.getInstance(locale);
        k.a((Object) instance, "Calendar.getInstance(appLocale)");
        this.f22970c = instance;
        Locale locale2 = this.f22973f;
        if (locale2 == null) {
            k.a("appLocale");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMMM", locale2);
        Calendar calendar = this.f22970c;
        if (calendar == null) {
            k.a("calendarTodayDate");
        }
        String format = simpleDateFormat.format(calendar.getTime());
        k.a((Object) format, "originalFormat.format(calendarTodayDate.time)");
        this.f22969b = format;
        Calendar calendar2 = this.f22970c;
        if (calendar2 == null) {
            k.a("calendarTodayDate");
        }
        Date time = calendar2.getTime();
        k.a((Object) time, "calendarTodayDate.time");
        this.f22968a = time;
        Calendar instance2 = Calendar.getInstance();
        instance2.add(5, 1);
        k.a((Object) instance2, "Calendar.getInstance().a…{ add(Calendar.DATE, 1) }");
        this.f22971d = instance2;
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        Locale locale3 = this.f22973f;
        if (locale3 == null) {
            k.a("appLocale");
        }
        k.c(intent, "i");
        k.c(locale3, "appLocale");
        if (intent.hasExtra("MAX_INTERVAL_BETWEEN_START_END")) {
            gVar.y = intent.getIntExtra("MAX_INTERVAL_BETWEEN_START_END", -1);
        }
        if (intent.hasExtra("INTENT_SHOW_LOADER")) {
            gVar.x = intent.getBooleanExtra("INTENT_SHOW_LOADER", false);
        }
        if (intent.hasExtra("INTENT_EXTRA_SELECTED_DATE_TIME")) {
            gVar.w = intent.getLongExtra("INTENT_EXTRA_SELECTED_DATE_TIME", 0);
        }
        if (intent.hasExtra("INTENT_EXTRA_UPDATED_DEPART_DATE")) {
            gVar.u = intent.getStringExtra("INTENT_EXTRA_UPDATED_DEPART_DATE");
        } else if (intent.hasExtra("INTENT_EXTRA_RESETED_DEPART_DATE")) {
            gVar.u = intent.getStringExtra("INTENT_EXTRA_RESETED_DEPART_DATE");
        } else if (intent.hasExtra("BOOK_DATE")) {
            gVar.u = intent.getStringExtra("BOOK_DATE");
        }
        try {
            Date parse = new SimpleDateFormat("yyyy MM dd", locale3).parse(gVar.u);
            k.a((Object) parse, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            gVar.b(parse);
        } catch (ParseException e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
            gVar.f23017e.setValue(null);
        }
        if (gVar.w == 0 && gVar.u != null && !TextUtils.isEmpty(gVar.u)) {
            try {
                Date parse2 = new SimpleDateFormat("yyyy MM dd", locale3).parse(gVar.u);
                k.a((Object) parse2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
                gVar.b(parse2);
                gVar.a((Date) null);
                gVar.w = parse2.getTime();
            } catch (ParseException e3) {
                if (com.paytm.utility.b.v) {
                    q.c(e3.getMessage());
                }
                gVar.f23017e.setValue(null);
            }
        }
        if (intent.hasExtra("END_DATE")) {
            gVar.v = intent.getStringExtra("END_DATE");
        } else if (intent.hasExtra("INTENT_EXTRA_UPDATED_RETURN_DATE")) {
            gVar.v = intent.getStringExtra("INTENT_EXTRA_UPDATED_RETURN_DATE");
        }
        CharSequence charSequence = gVar.v;
        if (!(charSequence == null || p.a(charSequence))) {
            try {
                gVar.a(new SimpleDateFormat("yyyy MM dd", locale3).parse(gVar.v));
            } catch (ParseException e4) {
                if (com.paytm.utility.b.v) {
                    q.c(e4.getMessage());
                }
                gVar.f23017e.setValue(null);
            }
        }
        if (intent.hasExtra("TODAYS_DATE")) {
            String stringExtra = intent.getStringExtra("TODAYS_DATE");
            k.a((Object) stringExtra, "i.getStringExtra(it)");
            gVar.r = stringExtra;
        }
        if (intent.hasExtra("INTENT_EXTRA_FARE_CALENDAR")) {
            try {
                HashMap hashMap = (HashMap) intent.getSerializableExtra("INTENT_EXTRA_FARE_CALENDAR");
                if (hashMap != null) {
                    gVar.p.clear();
                    gVar.p.putAll(hashMap);
                }
            } catch (Exception e5) {
                if (com.paytm.utility.b.v) {
                    q.c(e5.getMessage());
                }
            }
        }
        if (intent.hasExtra("HOLIDAY_LIST")) {
            Serializable serializableExtra = intent.getSerializableExtra("HOLIDAY_LIST");
            if (serializableExtra != null) {
                gVar.a((CalendarHolidayList) serializableExtra);
            } else {
                throw new u("null cannot be cast to non-null type com.travel.model.CalendarHolidayList");
            }
        }
        if (intent.hasExtra(AppConstants.EXTRA_FIRST_TITLE)) {
            gVar.m = intent.getStringExtra(AppConstants.EXTRA_FIRST_TITLE);
        }
        if (intent.hasExtra("CITY_NAME")) {
            gVar.n = intent.getStringExtra("CITY_NAME");
        }
        gVar.k = intent.getBooleanExtra("FLIGHT_FARE_API_CALLED", false);
        if (intent.hasExtra("INTENT_HIDE_BOTTOM_LAYOUT")) {
            gVar.j = intent.getBooleanExtra("INTENT_HIDE_BOTTOM_LAYOUT", false);
        }
        if (intent.hasExtra("INTENT_SELECT_SINGLE_DATE")) {
            gVar.f23021i = intent.getBooleanExtra("INTENT_SELECT_SINGLE_DATE", false);
        }
        if (intent.hasExtra("INTENT_MAX_ADVANCE_BOOKING_ALLOWED_IN_DAYS")) {
            gVar.f23020h = intent.getIntExtra("INTENT_MAX_ADVANCE_BOOKING_ALLOWED_IN_DAYS", -1);
        }
        if (intent.hasExtra("INTENT_FROM_WHICH_VERICAL")) {
            Serializable serializableExtra2 = intent.getSerializableExtra("INTENT_FROM_WHICH_VERICAL");
            if (serializableExtra2 != null) {
                gVar.f23018f = (com.travel.common.a.c) serializableExtra2;
            } else {
                throw new u("null cannot be cast to non-null type com.travel.common.listener.VerticalType");
            }
        }
        if (intent.hasExtra("Intent_Extra_Calendar_Type")) {
            Serializable serializableExtra3 = intent.getSerializableExtra("Intent_Extra_Calendar_Type");
            if (serializableExtra3 != null) {
                gVar.f23019g = (com.travel.utils.f) serializableExtra3;
            } else {
                throw new u("null cannot be cast to non-null type com.travel.utils.CalendarType");
            }
        }
        if (intent.hasExtra("HOLIDAY_URL")) {
            gVar.z = intent.getStringExtra("HOLIDAY_URL");
        }
        if (intent.hasExtra("intent_extra_fare_disclaimer")) {
            gVar.q = intent.getStringExtra("intent_extra_fare_disclaimer");
        }
        if (intent.hasExtra("intent extra tab type for two way calendar")) {
            Serializable serializableExtra4 = intent.getSerializableExtra("intent extra tab type for two way calendar");
            if (serializableExtra4 != null) {
                mVar = (m) serializableExtra4;
            } else {
                throw new u("null cannot be cast to non-null type com.travel.utils.TabTypeForTwoWayCalendar");
            }
        } else {
            mVar = m.DEPART;
        }
        gVar.A = mVar;
        if (intent.hasExtra("intent_extra_need_to_show_fare")) {
            gVar.o = intent.getBooleanExtra("intent_extra_need_to_show_fare", false);
        }
        if (intent.hasExtra("intent_extra_running_on_for_train")) {
            gVar.B = intent.getStringExtra("intent_extra_running_on_for_train");
        }
        g gVar2 = this.f22972e;
        if (gVar2 == null) {
            k.a("viewModel");
        }
        CharSequence charSequence2 = gVar2.z;
        if (!(charSequence2 == null || p.a(charSequence2))) {
            gVar2.z = com.paytm.utility.b.s(gVar2.getApplication(), gVar2.z);
            try {
                if (com.paytm.utility.b.c((Context) gVar2.getApplication())) {
                    new com.paytm.network.b().a((Context) gVar2.getApplication()).a(a.b.SILENT).c(AJRCommonCalendarActivity.class.getSimpleName()).a(a.c.FLIGHT).a(a.C0715a.GET).a(gVar2.z).a((IJRPaytmDataModel) new CalendarHolidayList()).a((com.paytm.network.listener.b) new g.a(gVar2)).a((JSONObject) null).l().a();
                }
            } catch (Exception e6) {
                q.c(e6.getMessage());
            }
        }
        com.travel.c.c cVar2 = this.l;
        if (cVar2 == null) {
            k.a("binding");
        }
        cVar2.f22871i.setImageResource(R.drawable.travel_res_common_close);
        com.travel.c.c cVar3 = this.l;
        if (cVar3 == null) {
            k.a("binding");
        }
        cVar3.f22871i.setOnClickListener(new c(this));
        g gVar3 = this.f22972e;
        if (gVar3 == null) {
            k.a("viewModel");
        }
        if (gVar3.b() == com.travel.utils.f.ONE_WAY) {
            com.travel.c.c cVar4 = this.l;
            if (cVar4 == null) {
                k.a("binding");
            }
            ImageView imageView = cVar4.j;
            k.a((Object) imageView, "binding.ivTabArrow");
            imageView.setVisibility(8);
            com.travel.c.c cVar5 = this.l;
            if (cVar5 == null) {
                k.a("binding");
            }
            View view = cVar5.f22870h;
            k.a((Object) view, "binding.departureTab");
            view.setVisibility(8);
            com.travel.c.c cVar6 = this.l;
            if (cVar6 == null) {
                k.a("binding");
            }
            View view2 = cVar6.n;
            k.a((Object) view2, "binding.returnTab");
            view2.setVisibility(8);
            g gVar4 = this.f22972e;
            if (gVar4 == null) {
                k.a("viewModel");
            }
            if (gVar4.a() != com.travel.common.a.c.FLIGHT) {
                com.travel.c.c cVar7 = this.l;
                if (cVar7 == null) {
                    k.a("binding");
                }
                ConstraintLayout constraintLayout = cVar7.s;
                k.a((Object) constraintLayout, "binding.tabLayoutContainer");
                constraintLayout.setVisibility(8);
            }
            g gVar5 = this.f22972e;
            if (gVar5 == null) {
                k.a("viewModel");
            }
            if (!gVar5.f23021i) {
                com.travel.c.c cVar8 = this.l;
                if (cVar8 == null) {
                    k.a("binding");
                }
                LinearLayout linearLayout = cVar8.f22863a;
                k.a((Object) linearLayout, "binding.calendarBottomLayout");
                linearLayout.setVisibility(0);
                g();
                com.travel.c.c cVar9 = this.l;
                if (cVar9 == null) {
                    k.a("binding");
                }
                cVar9.o.setOnClickListener(new d(this));
            } else {
                g gVar6 = this.f22972e;
                if (gVar6 == null) {
                    k.a("viewModel");
                }
                if (gVar6.a() != com.travel.common.a.c.FLIGHT) {
                    com.travel.c.c cVar10 = this.l;
                    if (cVar10 == null) {
                        k.a("binding");
                    }
                    RoboTextView roboTextView = cVar10.p;
                    k.a((Object) roboTextView, "binding.selectedDate");
                    roboTextView.setVisibility(0);
                    com.travel.c.c cVar11 = this.l;
                    if (cVar11 == null) {
                        k.a("binding");
                    }
                    View view3 = cVar11.q;
                    k.a((Object) view3, "binding.sepView");
                    view3.setVisibility(0);
                    g gVar7 = this.f22972e;
                    if (gVar7 == null) {
                        k.a("viewModel");
                    }
                    Date date = gVar7.t;
                    if (date != null) {
                        a(date);
                    }
                }
            }
        } else {
            com.travel.c.c cVar12 = this.l;
            if (cVar12 == null) {
                k.a("binding");
            }
            ImageView imageView2 = cVar12.j;
            k.a((Object) imageView2, "binding.ivTabArrow");
            imageView2.setVisibility(0);
        }
        g gVar8 = this.f22972e;
        if (gVar8 == null) {
            k.a("viewModel");
        }
        String str = gVar8.m;
        if (str != null) {
            com.travel.c.c cVar13 = this.l;
            if (cVar13 == null) {
                k.a("binding");
            }
            RoboTextView roboTextView2 = cVar13.u;
            k.a((Object) roboTextView2, "binding.tvTitle");
            roboTextView2.setVisibility(0);
            com.travel.c.c cVar14 = this.l;
            if (cVar14 == null) {
                k.a("binding");
            }
            RoboTextView roboTextView3 = cVar14.u;
            k.a((Object) roboTextView3, "binding.tvTitle");
            roboTextView3.setText(str);
        }
        g gVar9 = this.f22972e;
        if (gVar9 == null) {
            k.a("viewModel");
        }
        String str2 = gVar9.n;
        if (str2 != null) {
            com.travel.c.c cVar15 = this.l;
            if (cVar15 == null) {
                k.a("binding");
            }
            RoboTextView roboTextView4 = cVar15.f22866d;
            k.a((Object) roboTextView4, "binding.cityName");
            roboTextView4.setVisibility(0);
            com.travel.c.c cVar16 = this.l;
            if (cVar16 == null) {
                k.a("binding");
            }
            RoboTextView roboTextView5 = cVar16.f22866d;
            k.a((Object) roboTextView5, "binding.cityName");
            roboTextView5.setText(str2);
        }
        b();
        com.travel.c.c cVar17 = this.l;
        if (cVar17 == null) {
            k.a("binding");
        }
        TabLayout tabLayout = cVar17.f22867e;
        k.a((Object) tabLayout, "binding.commonCalendarTabLayout");
        tabLayout.setTabGravity(0);
        com.travel.c.c cVar18 = this.l;
        if (cVar18 == null) {
            k.a("binding");
        }
        cVar18.f22867e.setSelectedTabIndicatorColor(androidx.core.content.b.c(this, R.color.white));
        com.travel.c.c cVar19 = this.l;
        if (cVar19 == null) {
            k.a("binding");
        }
        cVar19.f22867e.setSelectedTabIndicatorHeight(0);
        com.travel.c.c cVar20 = this.l;
        if (cVar20 == null) {
            k.a("binding");
        }
        cVar20.f22867e.setSelectedTabIndicator((Drawable) null);
        com.travel.c.c cVar21 = this.l;
        if (cVar21 == null) {
            k.a("binding");
        }
        TabLayout tabLayout2 = cVar21.f22867e;
        k.a((Object) tabLayout2, "binding.commonCalendarTabLayout");
        tabLayout2.setTabMode(1);
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        List<String> list = this.f22974g;
        g gVar10 = this.f22972e;
        if (gVar10 == null) {
            k.a("viewModel");
        }
        this.f22975h = new b(supportFragmentManager, list, gVar10.l, this.n, this.o, this.p);
        com.travel.c.c cVar22 = this.l;
        if (cVar22 == null) {
            k.a("binding");
        }
        CJRSmoothScrollViewPager cJRSmoothScrollViewPager = cVar22.f22868f;
        k.a((Object) cJRSmoothScrollViewPager, "binding.commonCalendarViewPage");
        b bVar = this.f22975h;
        if (bVar == null) {
            k.a("mCalendarFragmentAdapter");
        }
        cJRSmoothScrollViewPager.setAdapter(bVar);
        com.travel.c.c cVar23 = this.l;
        if (cVar23 == null) {
            k.a("binding");
        }
        cVar23.f22868f.addOnPageChangeListener(this.q);
        com.travel.c.c cVar24 = this.l;
        if (cVar24 == null) {
            k.a("binding");
        }
        TabLayout tabLayout3 = cVar24.f22867e;
        com.travel.c.c cVar25 = this.l;
        if (cVar25 == null) {
            k.a("binding");
        }
        tabLayout3.setupWithViewPager(cVar25.f22868f);
        f();
        a(0);
        g gVar11 = this.f22972e;
        if (gVar11 == null) {
            k.a("viewModel");
        }
        if (gVar11.b() == com.travel.utils.f.TWO_WAY) {
            g gVar12 = this.f22972e;
            if (gVar12 == null) {
                k.a("viewModel");
            }
            m mVar2 = gVar12.A;
            if (mVar2 == null) {
                k.a("tabTypeToOpenInitially");
            }
            int i2 = a.f22984a[mVar2.ordinal()];
            if (i2 == 1) {
                com.travel.c.c cVar26 = this.l;
                if (cVar26 == null) {
                    k.a("binding");
                }
                CJRSmoothScrollViewPager cJRSmoothScrollViewPager2 = cVar26.f22868f;
                k.a((Object) cJRSmoothScrollViewPager2, "binding.commonCalendarViewPage");
                cJRSmoothScrollViewPager2.setCurrentItem(0);
            } else if (i2 == 2) {
                com.travel.c.c cVar27 = this.l;
                if (cVar27 == null) {
                    k.a("binding");
                }
                CJRSmoothScrollViewPager cJRSmoothScrollViewPager3 = cVar27.f22868f;
                k.a((Object) cJRSmoothScrollViewPager3, "binding.commonCalendarViewPage");
                cJRSmoothScrollViewPager3.setCurrentItem(1);
            }
        }
        g gVar13 = this.f22972e;
        if (gVar13 == null) {
            k.a("viewModel");
        }
        androidx.lifecycle.q qVar = this;
        gVar13.f23014b.observe(qVar, new e(this));
        g gVar14 = this.f22972e;
        if (gVar14 == null) {
            k.a("viewModel");
        }
        gVar14.f23017e.observe(qVar, new f(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCommonCalendarActivity f22979a;

        c(AJRCommonCalendarActivity aJRCommonCalendarActivity) {
            this.f22979a = aJRCommonCalendarActivity;
        }

        public final void onClick(View view) {
            this.f22979a.finish();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCommonCalendarActivity f22980a;

        d(AJRCommonCalendarActivity aJRCommonCalendarActivity) {
            this.f22980a = aJRCommonCalendarActivity;
        }

        public final void onClick(View view) {
            if (AJRCommonCalendarActivity.a(this.f22980a).t != null && AJRCommonCalendarActivity.a(this.f22980a).s != null) {
                if (this.f22980a.m == -1) {
                    AJRCommonCalendarActivity aJRCommonCalendarActivity = this.f22980a;
                    Date date = AJRCommonCalendarActivity.a(aJRCommonCalendarActivity).t;
                    if (date == null) {
                        k.a();
                    }
                    Date date2 = AJRCommonCalendarActivity.a(this.f22980a).s;
                    if (date2 == null) {
                        k.a();
                    }
                    aJRCommonCalendarActivity.m = (int) aJRCommonCalendarActivity.a(date, date2);
                }
                AJRCommonCalendarActivity aJRCommonCalendarActivity2 = this.f22980a;
                Date date3 = AJRCommonCalendarActivity.a(aJRCommonCalendarActivity2).t;
                if (date3 == null) {
                    k.a();
                }
                String a2 = aJRCommonCalendarActivity2.b(date3);
                AJRCommonCalendarActivity aJRCommonCalendarActivity3 = this.f22980a;
                Date date4 = AJRCommonCalendarActivity.a(aJRCommonCalendarActivity3).t;
                if (date4 == null) {
                    k.a();
                }
                String b2 = aJRCommonCalendarActivity3.c(date4);
                long j = AJRCommonCalendarActivity.a(this.f22980a).w;
                AJRCommonCalendarActivity aJRCommonCalendarActivity4 = this.f22980a;
                Date date5 = AJRCommonCalendarActivity.a(aJRCommonCalendarActivity4).s;
                if (date5 == null) {
                    k.a();
                }
                String a3 = aJRCommonCalendarActivity4.b(date5);
                AJRCommonCalendarActivity aJRCommonCalendarActivity5 = this.f22980a;
                Date date6 = AJRCommonCalendarActivity.a(aJRCommonCalendarActivity5).s;
                if (date6 == null) {
                    k.a();
                }
                aJRCommonCalendarActivity2.a(a2, b2, "", j, a3, aJRCommonCalendarActivity5.c(date6));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        int i2 = a.f22985b[gVar.b().ordinal()];
        char c2 = 2;
        boolean z = true;
        if (i2 == 1) {
            c2 = 1;
        } else if (i2 != 2) {
            throw new kotlin.m();
        }
        if (c2 == 1) {
            g gVar2 = this.f22972e;
            if (gVar2 == null) {
                k.a("viewModel");
            }
            CharSequence charSequence = gVar2.u;
            if (charSequence != null && !p.a(charSequence)) {
                z = false;
            }
            if (!z) {
                List<String> list = this.f22974g;
                Activity activity = this;
                g gVar3 = this.f22972e;
                if (gVar3 == null) {
                    k.a("viewModel");
                }
                String a2 = com.travel.utils.g.a(activity, gVar3.u, "yyyy MM dd", "dd MMMM EEEE");
                k.a((Object) a2, "CalenderUtils.formatDate…_HOME_SCREEN_DATE_FORMAT)");
                list.add(a2);
                return;
            }
            List<String> list2 = this.f22974g;
            String string = getString(R.string.depart);
            k.a((Object) string, "getString(R.string.depart)");
            list2.add(string);
            return;
        }
        g gVar4 = this.f22972e;
        if (gVar4 == null) {
            k.a("viewModel");
        }
        CharSequence charSequence2 = gVar4.u;
        if (!(charSequence2 == null || p.a(charSequence2))) {
            List<String> list3 = this.f22974g;
            Activity activity2 = this;
            g gVar5 = this.f22972e;
            if (gVar5 == null) {
                k.a("viewModel");
            }
            String a3 = com.travel.utils.g.a(activity2, gVar5.u, "yyyy MM dd", "dd MMMM EEEE");
            k.a((Object) a3, "CalenderUtils.formatDate…_HOME_SCREEN_DATE_FORMAT)");
            list3.add(a3);
        } else {
            List<String> list4 = this.f22974g;
            String string2 = getString(R.string.depart);
            k.a((Object) string2, "getString(R.string.depart)");
            list4.add(string2);
        }
        g gVar6 = this.f22972e;
        if (gVar6 == null) {
            k.a("viewModel");
        }
        CharSequence charSequence3 = gVar6.v;
        if (charSequence3 != null && !p.a(charSequence3)) {
            z = false;
        }
        if (!z) {
            List<String> list5 = this.f22974g;
            Activity activity3 = this;
            g gVar7 = this.f22972e;
            if (gVar7 == null) {
                k.a("viewModel");
            }
            String a4 = com.travel.utils.g.a(activity3, gVar7.v, "yyyy MM dd", "dd MMMM EEEE");
            k.a((Object) a4, "CalenderUtils.formatDate…_HOME_SCREEN_DATE_FORMAT)");
            list5.add(a4);
            return;
        }
        List<String> list6 = this.f22974g;
        String string3 = getString(R.string.return_);
        k.a((Object) string3, "getString(R.string.return_)");
        list6.add(string3);
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.b() == com.travel.utils.f.TWO_WAY) {
            View findViewById = findViewById(R.id.departure_tab);
            View findViewById2 = findViewById(R.id.return_tab);
            if (i2 == 0) {
                k.a((Object) findViewById, "deptTabView");
                findViewById.setVisibility(0);
                k.a((Object) findViewById2, "returnTabView");
                findViewById2.setVisibility(8);
                return;
            }
            k.a((Object) findViewById, "deptTabView");
            findViewById.setVisibility(8);
            k.a((Object) findViewById2, "returnTabView");
            findViewById2.setVisibility(0);
        }
    }

    private final void f() {
        View view;
        com.travel.c.c cVar = this.l;
        if (cVar == null) {
            k.a("binding");
        }
        int tabCount = cVar.f22867e.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            com.travel.c.c cVar2 = this.l;
            if (cVar2 == null) {
                k.a("binding");
            }
            TabLayout.f a2 = cVar2.f22867e.a(i2);
            if (a2 != null) {
                if (i2 == 0) {
                    view = b(i2);
                    if (view == null) {
                        k.a();
                    }
                    view.setSelected(true);
                } else {
                    view = b(i2);
                    if (view == null) {
                        k.a();
                    }
                    view.setSelected(false);
                }
                a2.a(view);
            }
        }
    }

    private final View b(int i2) {
        int i3 = i2;
        View inflate = LayoutInflater.from(this).inflate(R.layout.pre_td_calendar_tab_view, (ViewGroup) null);
        k.a((Object) inflate, "LayoutInflater.from(this…_calendar_tab_view, null)");
        View findViewById = inflate.findViewById(R.id.tab_item_title);
        k.a((Object) findViewById, "Tabview.findViewById(R.id.tab_item_title)");
        TextView textView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.selected_date);
        k.a((Object) findViewById2, "Tabview.findViewById(R.id.selected_date)");
        TextView textView2 = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.flight_imageView);
        k.a((Object) findViewById3, "Tabview.findViewById(R.id.flight_imageView)");
        ImageView imageView = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.departure_lyt);
        k.a((Object) findViewById4, "Tabview.findViewById(R.id.departure_lyt)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.departure_date_textview);
        k.a((Object) findViewById5, "Tabview.findViewById(R.id.departure_date_textview)");
        TextView textView3 = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.departure_month_textview);
        k.a((Object) findViewById6, "Tabview.findViewById(R.i…departure_month_textview)");
        TextView textView4 = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.departure_week_textview);
        k.a((Object) findViewById7, "Tabview.findViewById(R.id.departure_week_textview)");
        TextView textView5 = (TextView) findViewById7;
        String str = this.f22974g.get(i3);
        if (i3 == 0) {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "onward_revamp.png", false, false, n.a.V1);
            textView.setText(getString(R.string.depart));
            if (p.a(str, getString(R.string.depart), true)) {
                textView2.setText(getString(R.string.select_return_date));
                textView2.setVisibility(0);
                relativeLayout.setVisibility(8);
            } else {
                textView2.setVisibility(8);
                relativeLayout.setVisibility(0);
                CharSequence charSequence = str;
                if (!(charSequence == null || p.a(charSequence))) {
                    List<String> a2 = p.a(charSequence, new String[]{" "});
                    textView3.setText(a2.get(0));
                    textView4.setText(a2.get(1));
                    textView5.setText(a2.get(2));
                }
            }
        } else {
            ResourceUtils.loadFlightImagesFromCDN(imageView, "return_revamp.png", false, false, n.a.V1);
            textView.setText(getString(R.string.return_));
            if (p.a(str, getResources().getString(R.string.return_), true)) {
                textView2.setText(getString(R.string.select_return_date));
                textView2.setVisibility(0);
                relativeLayout.setVisibility(8);
            } else {
                textView2.setVisibility(8);
                relativeLayout.setVisibility(0);
                CharSequence charSequence2 = str;
                if (!(charSequence2 == null || p.a(charSequence2))) {
                    List<String> a3 = p.a(charSequence2, new String[]{" "});
                    textView3.setText(a3.get(0));
                    textView4.setText(a3.get(1));
                    textView5.setText(a3.get(2));
                }
            }
        }
        return inflate;
    }

    private final void a(Date date) {
        com.travel.c.c cVar = this.l;
        if (cVar == null) {
            k.a("binding");
        }
        RoboTextView roboTextView = cVar.p;
        k.a((Object) roboTextView, "binding.selectedDate");
        if (com.travel.utils.j.a(roboTextView)) {
            String a2 = com.travel.utils.g.a(this, date.toString(), this.f22976i, "EEE, dd MMMM");
            com.travel.c.c cVar2 = this.l;
            if (cVar2 == null) {
                k.a("binding");
            }
            RoboTextView roboTextView2 = cVar2.p;
            k.a((Object) roboTextView2, "binding.selectedDate");
            roboTextView2.setText(a2);
        }
    }

    public static final class g implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCommonCalendarActivity f22983a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        g(AJRCommonCalendarActivity aJRCommonCalendarActivity) {
            this.f22983a = aJRCommonCalendarActivity;
        }

        public final void onPageSelected(int i2) {
            this.f22983a.b();
            AJRCommonCalendarActivity.d(this.f22983a);
            this.f22983a.a(i2);
        }
    }

    /* access modifiers changed from: private */
    public final long a(Date date, Date date2) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (this.f22973f == null) {
            k.a("appLocale");
        }
        return com.travel.utils.g.a(date, date2, timeUnit);
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2, String str3, long j2, String str4, String str5) {
        Intent intent = new Intent();
        intent.putExtra("intent_extra_selected_depart_date", str);
        intent.putExtra("intent_extra_selected_train_display_date_depart", str2);
        intent.putExtra("intent_extra_selected_date_time", j2);
        intent.putExtra("date_value", str3);
        if (str4 != null) {
            intent.putExtra("intent_extra_selected_return_date", str4);
        }
        if (str5 != null) {
            intent.putExtra("intent_extra_selected_train_display_date_return", str5);
        }
        int i2 = this.m;
        if (i2 != -1) {
            intent.putExtra("DAYS_SELECTED", i2);
        }
        setResult(-1, intent);
        finish();
    }

    public final void a(Date date, List<? extends Date> list) {
        long j2;
        Date date2 = date;
        List<? extends Date> list2 = list;
        k.c(date2, "checkInDate");
        k.c(list2, "selectedDates");
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.b() == com.travel.utils.f.ONE_WAY) {
            g gVar2 = this.f22972e;
            if (gVar2 == null) {
                k.a("viewModel");
            }
            if (gVar2.f23021i) {
                Date date3 = this.f22968a;
                if (date3 == null) {
                    k.a("dateToday");
                }
                TimeUnit timeUnit = TimeUnit.DAYS;
                if (this.f22973f == null) {
                    k.a("appLocale");
                }
                long a2 = com.travel.utils.g.a(date3, date2, timeUnit);
                g gVar3 = this.f22972e;
                if (gVar3 == null) {
                    k.a("viewModel");
                }
                String str = "";
                if (gVar3.a() == com.travel.common.a.c.BUS) {
                    g gVar4 = this.f22972e;
                    if (gVar4 == null) {
                        k.a("viewModel");
                    }
                    if (gVar4.f23020h != -1) {
                        g gVar5 = this.f22972e;
                        if (gVar5 == null) {
                            k.a("viewModel");
                        }
                        if (a2 >= ((long) gVar5.f23020h)) {
                            String b2 = com.travel.utils.g.b(com.travel.utils.g.a(date));
                            String b3 = com.travel.utils.g.b(date);
                            aa aaVar = aa.f47921a;
                            String string = getString(R.string.bus_msg_booking_after_sixty_days);
                            k.a((Object) string, "getString(R.string.bus_m…booking_after_sixty_days)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{b2, b3}, 2));
                            k.a((Object) format, "java.lang.String.format(format, *args)");
                            com.paytm.utility.b.b((Context) this, getString(R.string.bus_title_booking_after_sixty_days), format);
                            g gVar6 = this.f22972e;
                            if (gVar6 == null) {
                                k.a("viewModel");
                            }
                            g gVar7 = this.f22972e;
                            if (gVar7 == null) {
                                k.a("viewModel");
                            }
                            Date date4 = gVar7.t;
                            if (date4 == null && (date4 = this.f22968a) == null) {
                                k.a("dateToday");
                            }
                            gVar6.b(date4);
                            return;
                        }
                    }
                } else {
                    g gVar8 = this.f22972e;
                    if (gVar8 == null) {
                        k.a("viewModel");
                    }
                    if (gVar8.a() == com.travel.common.a.c.FLIGHT) {
                        Activity activity = this;
                        g gVar9 = this.f22972e;
                        if (gVar9 == null) {
                            k.a("viewModel");
                        }
                        if (!com.travel.utils.g.a(activity, gVar9.t)) {
                            return;
                        }
                    } else {
                        g gVar10 = this.f22972e;
                        if (gVar10 == null) {
                            k.a("viewModel");
                        }
                        if (gVar10.a() == com.travel.common.a.c.TRAIN) {
                            g gVar11 = this.f22972e;
                            if (gVar11 == null) {
                                k.a("viewModel");
                            }
                            if (gVar11.f23020h != -1) {
                                g gVar12 = this.f22972e;
                                if (gVar12 == null) {
                                    k.a("viewModel");
                                }
                                if (a2 >= ((long) gVar12.f23020h)) {
                                    String string2 = getResources().getString(R.string.train_msg_proper_date);
                                    k.a((Object) string2, "resources.getString(R.st…ng.train_msg_proper_date)");
                                    com.paytm.utility.b.b((Context) this, str, string2);
                                    return;
                                }
                            }
                        }
                    }
                }
                g gVar13 = this.f22972e;
                if (gVar13 == null) {
                    k.a("viewModel");
                }
                g gVar14 = this.f22972e;
                if (gVar14 == null) {
                    k.a("viewModel");
                }
                Date date5 = gVar14.t;
                if (date5 != null) {
                    j2 = date5.getTime();
                } else {
                    j2 = 0;
                }
                gVar13.w = j2;
                String b4 = b(date);
                String c2 = c(date);
                String str2 = this.j;
                Locale locale = this.f22973f;
                if (locale == null) {
                    k.a("appLocale");
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, locale);
                Calendar calendar = this.f22970c;
                if (calendar == null) {
                    k.a("calendarTodayDate");
                }
                if (p.a(b4, simpleDateFormat.format(calendar.getTime()), true)) {
                    str = "today";
                } else {
                    String str3 = this.j;
                    Locale locale2 = this.f22973f;
                    if (locale2 == null) {
                        k.a("appLocale");
                    }
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str3, locale2);
                    Calendar calendar2 = this.f22971d;
                    if (calendar2 == null) {
                        k.a("calendarTomorrowDate");
                    }
                    if (p.a(b4, simpleDateFormat2.format(calendar2.getTime()), true)) {
                        str = "tomorrow";
                    }
                }
                this.k = str;
                a(date);
                a(b4, c2, this.k, date.getTime(), (String) null, (String) null);
                return;
            }
            this.m = list.size() - 1;
            if (list.size() == 1) {
                g gVar15 = this.f22972e;
                if (gVar15 == null) {
                    k.a("viewModel");
                }
                gVar15.b((Date) list2.get(0));
                g gVar16 = this.f22972e;
                if (gVar16 == null) {
                    k.a("viewModel");
                }
                gVar16.a((Date) null);
                com.travel.c.c cVar = this.l;
                if (cVar == null) {
                    k.a("binding");
                }
                cVar.o.setBackgroundResource(R.color.gray);
                com.travel.c.c cVar2 = this.l;
                if (cVar2 == null) {
                    k.a("binding");
                }
                Button button = cVar2.o;
                k.a((Object) button, "binding.selectDateButton");
                button.setEnabled(false);
            } else {
                g gVar17 = this.f22972e;
                if (gVar17 == null) {
                    k.a("viewModel");
                }
                if (gVar17.y != -1) {
                    int size = list.size();
                    g gVar18 = this.f22972e;
                    if (gVar18 == null) {
                        k.a("viewModel");
                    }
                    if (size > gVar18.y) {
                        g gVar19 = this.f22972e;
                        if (gVar19 == null) {
                            k.a("viewModel");
                        }
                        gVar19.b((Date) list2.get(0));
                        g gVar20 = this.f22972e;
                        if (gVar20 == null) {
                            k.a("viewModel");
                        }
                        gVar20.a((Date) null);
                        c.a aVar = new c.a(this);
                        aVar.a(R.string.date_error);
                        aVar.a(R.string.ok, (DialogInterface.OnClickListener) a.f22977a);
                        Resources resources = getResources();
                        int i2 = R.string.date_error_message;
                        Object[] objArr = new Object[1];
                        g gVar21 = this.f22972e;
                        if (gVar21 == null) {
                            k.a("viewModel");
                        }
                        objArr[0] = Integer.valueOf(gVar21.y);
                        aVar.b((CharSequence) resources.getString(i2, objArr));
                        aVar.b();
                    }
                }
                com.travel.c.c cVar3 = this.l;
                if (cVar3 == null) {
                    k.a("binding");
                }
                cVar3.o.setBackgroundResource(R.color.blue);
                com.travel.c.c cVar4 = this.l;
                if (cVar4 == null) {
                    k.a("binding");
                }
                Button button2 = cVar4.o;
                k.a((Object) button2, "binding.selectDateButton");
                button2.setEnabled(true);
                g gVar22 = this.f22972e;
                if (gVar22 == null) {
                    k.a("viewModel");
                }
                gVar22.b((Date) list2.get(0));
                g gVar23 = this.f22972e;
                if (gVar23 == null) {
                    k.a("viewModel");
                }
                gVar23.a((Date) kotlin.a.k.f(list));
            }
            g();
            return;
        }
        g gVar24 = this.f22972e;
        if (gVar24 == null) {
            k.a("viewModel");
        }
        if (gVar24.b() == com.travel.utils.f.TWO_WAY) {
            g gVar25 = this.f22972e;
            if (gVar25 == null) {
                k.a("viewModel");
            }
            gVar25.a((Date) null);
            g gVar26 = this.f22972e;
            if (gVar26 == null) {
                k.a("viewModel");
            }
            gVar26.b(date2);
            com.travel.c.c cVar5 = this.l;
            if (cVar5 == null) {
                k.a("binding");
            }
            CJRSmoothScrollViewPager cJRSmoothScrollViewPager = cVar5.f22868f;
            k.a((Object) cJRSmoothScrollViewPager, "binding.commonCalendarViewPage");
            cJRSmoothScrollViewPager.setCurrentItem(1);
        }
    }

    public final void b(Date date, List<? extends Date> list) {
        long j2;
        k.c(date, "checkOutDate");
        k.c(list, "selectedDates");
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.t == null) {
            g gVar2 = this.f22972e;
            if (gVar2 == null) {
                k.a("viewModel");
            }
            gVar2.a((Date) null);
            com.travel.c.c cVar = this.l;
            if (cVar == null) {
                k.a("binding");
            }
            CJRSmoothScrollViewPager cJRSmoothScrollViewPager = cVar.f22868f;
            k.a((Object) cJRSmoothScrollViewPager, "binding.commonCalendarViewPage");
            cJRSmoothScrollViewPager.setCurrentItem(0);
            return;
        }
        g gVar3 = this.f22972e;
        if (gVar3 == null) {
            k.a("viewModel");
        }
        if (gVar3.t == null) {
            g gVar4 = this.f22972e;
            if (gVar4 == null) {
                k.a("viewModel");
            }
            gVar4.a((Date) null);
            com.travel.c.c cVar2 = this.l;
            if (cVar2 == null) {
                k.a("binding");
            }
            CJRSmoothScrollViewPager cJRSmoothScrollViewPager2 = cVar2.f22868f;
            k.a((Object) cJRSmoothScrollViewPager2, "binding.commonCalendarViewPage");
            cJRSmoothScrollViewPager2.setCurrentItem(0);
            return;
        }
        g gVar5 = this.f22972e;
        if (gVar5 == null) {
            k.a("viewModel");
        }
        if (date.before(gVar5.t)) {
            g gVar6 = this.f22972e;
            if (gVar6 == null) {
                k.a("viewModel");
            }
            g gVar7 = this.f22972e;
            if (gVar7 == null) {
                k.a("viewModel");
            }
            gVar6.a(gVar7.s);
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.return_date_before_depart_date));
            return;
        }
        g gVar8 = this.f22972e;
        if (gVar8 == null) {
            k.a("viewModel");
        }
        if (gVar8.y != -1) {
            g gVar9 = this.f22972e;
            if (gVar9 == null) {
                k.a("viewModel");
            }
            Date date2 = gVar9.t;
            if (date2 == null) {
                k.a();
            }
            long a2 = a(date2, date);
            g gVar10 = this.f22972e;
            if (gVar10 == null) {
                k.a("viewModel");
            }
            if (a2 > ((long) gVar10.y)) {
                g gVar11 = this.f22972e;
                if (gVar11 == null) {
                    k.a("viewModel");
                }
                g gVar12 = this.f22972e;
                if (gVar12 == null) {
                    k.a("viewModel");
                }
                gVar11.a(gVar12.s);
                c.a aVar = new c.a(this);
                aVar.a(R.string.date_error);
                aVar.a(R.string.ok_text, (DialogInterface.OnClickListener) b.f22978a);
                Resources resources = getResources();
                int i2 = R.string.date_error_message;
                Object[] objArr = new Object[1];
                g gVar13 = this.f22972e;
                if (gVar13 == null) {
                    k.a("viewModel");
                }
                objArr[0] = Integer.valueOf(gVar13.y);
                aVar.b((CharSequence) resources.getString(i2, objArr));
                aVar.b();
                return;
            }
        }
        g gVar14 = this.f22972e;
        if (gVar14 == null) {
            k.a("viewModel");
        }
        gVar14.a(date);
        g gVar15 = this.f22972e;
        if (gVar15 == null) {
            k.a("viewModel");
        }
        g gVar16 = this.f22972e;
        if (gVar16 == null) {
            k.a("viewModel");
        }
        Date date3 = gVar16.t;
        if (date3 != null) {
            j2 = date3.getTime();
        } else {
            j2 = 0;
        }
        gVar15.w = j2;
        b(1);
        g gVar17 = this.f22972e;
        if (gVar17 == null) {
            k.a("viewModel");
        }
        Date date4 = gVar17.t;
        if (date4 == null) {
            k.a();
        }
        String b2 = b(date4);
        g gVar18 = this.f22972e;
        if (gVar18 == null) {
            k.a("viewModel");
        }
        Date date5 = gVar18.t;
        if (date5 == null) {
            k.a();
        }
        String c2 = c(date5);
        g gVar19 = this.f22972e;
        if (gVar19 == null) {
            k.a("viewModel");
        }
        long j3 = gVar19.w;
        g gVar20 = this.f22972e;
        if (gVar20 == null) {
            k.a("viewModel");
        }
        Date date6 = gVar20.s;
        if (date6 == null) {
            k.a();
        }
        String b3 = b(date6);
        g gVar21 = this.f22972e;
        if (gVar21 == null) {
            k.a("viewModel");
        }
        Date date7 = gVar21.s;
        if (date7 == null) {
            k.a();
        }
        a(b2, c2, "", j3, b3, c(date7));
    }

    /* access modifiers changed from: private */
    public final String b(Date date) {
        if (p.a(com.paytm.utility.n.a(), "hi", true) || p.a(com.paytm.utility.n.a(), "ta", true) || p.a(com.paytm.utility.n.a(), "te", true) || p.a(com.paytm.utility.n.a(), "kn", true) || p.a(com.paytm.utility.n.a(), "pa", true) || p.a(com.paytm.utility.n.a(), "mr", true) || p.a(com.paytm.utility.n.a(), "gu", true) || p.a(com.paytm.utility.n.a(), "bn", true) || p.a(com.paytm.utility.n.a(), "or", true) || p.a(com.paytm.utility.n.a(), "ml", true)) {
            String a2 = com.paytm.utility.b.a(date, "dd MMM yy");
            k.a((Object) a2, "CJRAppCommonUtility.conv…Y_BUS_TICKET_DATE_FORMAT)");
            return a2;
        }
        String a3 = com.travel.utils.g.a(this, date.toString(), this.f22976i, "dd MMM yy");
        k.a((Object) a3, "CalenderUtils.formatDate…Y_BUS_TICKET_DATE_FORMAT)");
        return a3;
    }

    /* access modifiers changed from: private */
    public final String c(Date date) {
        if (p.a(com.paytm.utility.n.a(), "hi", true) || p.a(com.paytm.utility.n.a(), "ta", true) || p.a(com.paytm.utility.n.a(), "te", true) || p.a(com.paytm.utility.n.a(), "kn", true) || p.a(com.paytm.utility.n.a(), "pa", true) || p.a(com.paytm.utility.n.a(), "mr", true) || p.a(com.paytm.utility.n.a(), "gu", true) || p.a(com.paytm.utility.n.a(), "bn", true) || p.a(com.paytm.utility.n.a(), "or", true) || p.a(com.paytm.utility.n.a(), "ml", true)) {
            String a2 = com.paytm.utility.b.a(date, "dd MMMM, EEE");
            k.a((Object) a2, "CJRAppCommonUtility.conv…REEN_DISPLAY_DATE_FORMAT)");
            return a2;
        }
        String a3 = com.travel.utils.g.a(this, date.toString(), this.f22976i, "dd MMMM, EEE");
        k.a((Object) a3, "CalenderUtils.formatDate…REEN_DISPLAY_DATE_FORMAT)");
        return a3;
    }

    private final void g() {
        i();
        h();
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.t != null) {
            g gVar2 = this.f22972e;
            if (gVar2 == null) {
                k.a("viewModel");
            }
            if (gVar2.s != null) {
                com.travel.c.c cVar = this.l;
                if (cVar == null) {
                    k.a("binding");
                }
                cVar.o.setBackgroundResource(R.color.blue);
                com.travel.c.c cVar2 = this.l;
                if (cVar2 == null) {
                    k.a("binding");
                }
                Button button = cVar2.o;
                k.a((Object) button, "binding.selectDateButton");
                button.setEnabled(true);
            }
        }
    }

    private final void h() {
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        Date date = gVar.t;
        if (date != null) {
            try {
                String format = new SimpleDateFormat("dd MMM, EEE").format(date);
                k.a((Object) format, "dateString");
                if (p.b(format, "0", false)) {
                    format = p.a(format, "0", "", false);
                }
                com.travel.c.c cVar = this.l;
                if (cVar == null) {
                    k.a("binding");
                }
                TextView textView = cVar.f22864b;
                k.a((Object) textView, "binding.checkinDateTv");
                textView.setText(format);
            } catch (Exception unused) {
            }
        }
    }

    private final void i() {
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        if (gVar.s == null) {
            com.travel.c.c cVar = this.l;
            if (cVar == null) {
                k.a("binding");
            }
            cVar.f22865c.setText(R.string.select_date);
            com.travel.c.c cVar2 = this.l;
            if (cVar2 == null) {
                k.a("binding");
            }
            LinearLayout linearLayout = cVar2.f22869g;
            k.a((Object) linearLayout, "binding.daysCountLayout");
            linearLayout.setVisibility(8);
            return;
        }
        j();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM, EEE");
        g gVar2 = this.f22972e;
        if (gVar2 == null) {
            k.a("viewModel");
        }
        Date date = gVar2.s;
        if (date == null) {
            k.a();
        }
        String format = simpleDateFormat.format(date);
        k.a((Object) format, "dateString");
        if (p.b(format, "0", false)) {
            format = p.a(format, "0", "", false);
        }
        com.travel.c.c cVar3 = this.l;
        if (cVar3 == null) {
            k.a("binding");
        }
        TextView textView = cVar3.f22865c;
        k.a((Object) textView, "binding.checkoutDateTv");
        textView.setText(format);
    }

    private final void j() {
        g gVar = this.f22972e;
        if (gVar == null) {
            k.a("viewModel");
        }
        Date date = gVar.t;
        g gVar2 = this.f22972e;
        if (gVar2 == null) {
            k.a("viewModel");
        }
        Date date2 = gVar2.s;
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (this.f22973f == null) {
            k.a("appLocale");
        }
        long a2 = com.travel.utils.g.a(date, date2, timeUnit);
        com.travel.c.c cVar = this.l;
        if (cVar == null) {
            k.a("binding");
        }
        LinearLayout linearLayout = cVar.f22869g;
        k.a((Object) linearLayout, "binding.daysCountLayout");
        linearLayout.setVisibility(0);
        com.travel.c.c cVar2 = this.l;
        if (cVar2 == null) {
            k.a("binding");
        }
        TextView textView = cVar2.l;
        k.a((Object) textView, "binding.nightCount");
        textView.setText(String.valueOf(a2));
        if (a2 == 1) {
            com.travel.c.c cVar3 = this.l;
            if (cVar3 == null) {
                k.a("binding");
            }
            TextView textView2 = cVar3.m;
            k.a((Object) textView2, "binding.nightText");
            textView2.setText("Night");
            return;
        }
        com.travel.c.c cVar4 = this.l;
        if (cVar4 == null) {
            k.a("binding");
        }
        TextView textView3 = cVar4.m;
        k.a((Object) textView3, "binding.nightText");
        textView3.setText("Nights");
    }

    private final String a(Date date, String str) {
        Locale locale = this.f22973f;
        if (locale == null) {
            k.a("appLocale");
        }
        String format = new SimpleDateFormat(str, locale).format(date);
        k.a((Object) format, "dateFormat.format(date)");
        return format;
    }

    static final class f<T> implements z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCommonCalendarActivity f22982a;

        f(AJRCommonCalendarActivity aJRCommonCalendarActivity) {
            this.f22982a = aJRCommonCalendarActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.paytm.utility.b.a((Activity) this.f22982a, AJRCommonCalendarActivity.class.getName());
        }
    }

    public static final /* synthetic */ void d(AJRCommonCalendarActivity aJRCommonCalendarActivity) {
        int i2;
        AJRCommonCalendarActivity aJRCommonCalendarActivity2 = aJRCommonCalendarActivity;
        com.travel.c.c cVar = aJRCommonCalendarActivity2.l;
        String str = "binding";
        if (cVar == null) {
            k.a(str);
        }
        int tabCount = cVar.f22867e.getTabCount();
        int i3 = 0;
        while (i3 < tabCount) {
            com.travel.c.c cVar2 = aJRCommonCalendarActivity2.l;
            if (cVar2 == null) {
                k.a(str);
            }
            TabLayout.f a2 = cVar2.f22867e.a(i3);
            if (a2 == null) {
                k.a();
            }
            View a3 = a2.a();
            if (a3 == null) {
                k.a();
            }
            TextView textView = (TextView) a3.findViewById(R.id.tab_item_title);
            TextView textView2 = (TextView) a3.findViewById(R.id.selected_date);
            ImageView imageView = (ImageView) a3.findViewById(R.id.flight_imageView);
            RelativeLayout relativeLayout = (RelativeLayout) a3.findViewById(R.id.departure_lyt);
            TextView textView3 = (TextView) a3.findViewById(R.id.departure_date_textview);
            TextView textView4 = (TextView) a3.findViewById(R.id.departure_month_textview);
            int i4 = tabCount;
            String str2 = str;
            String str3 = "null cannot be cast to non-null type kotlin.Array<T>";
            TextView textView5 = (TextView) a3.findViewById(R.id.departure_week_textview);
            if (i3 == 0) {
                i2 = i3;
                g gVar = aJRCommonCalendarActivity2.f22972e;
                if (gVar == null) {
                    k.a("viewModel");
                }
                if (gVar.t != null) {
                    g gVar2 = aJRCommonCalendarActivity2.f22972e;
                    if (gVar2 == null) {
                        k.a("viewModel");
                    }
                    Date date = gVar2.t;
                    if (date == null) {
                        k.a();
                    }
                    String a4 = aJRCommonCalendarActivity2.a(date, "dd MMMM EEEE");
                    String str4 = "txtWeek";
                    TextView textView6 = textView4;
                    ResourceUtils.loadFlightImagesFromCDN(imageView, "onward_revamp.png", false, false, n.a.V1);
                    k.a((Object) textView, "txtTabTitle");
                    textView.setText(aJRCommonCalendarActivity2.getString(R.string.depart));
                    k.a((Object) textView2, "txtTabDisc");
                    textView2.setVisibility(8);
                    k.a((Object) relativeLayout, "tabDateLyt");
                    relativeLayout.setVisibility(0);
                    if (a4 != null) {
                        Object[] array = new l(" ").split(a4, 0).toArray(new String[0]);
                        if (array != null) {
                            String[] strArr = (String[]) array;
                            k.a((Object) textView3, "txtDate");
                            textView3.setText(strArr[0]);
                            TextView textView7 = textView6;
                            k.a((Object) textView7, "txtMonth");
                            textView7.setText(strArr[1]);
                            TextView textView8 = textView5;
                            k.a((Object) textView8, str4);
                            textView8.setText(strArr[2]);
                        } else {
                            throw new u(str3);
                        }
                    }
                }
            } else {
                i2 = i3;
                String str5 = str3;
                String str6 = "txtWeek";
                TextView textView9 = textView4;
                ResourceUtils.loadFlightImagesFromCDN(imageView, "return_revamp.png", false, false, n.a.V1);
                k.a((Object) textView, "txtTabTitle");
                textView.setText(aJRCommonCalendarActivity2.getString(R.string.return_));
                g gVar3 = aJRCommonCalendarActivity2.f22972e;
                if (gVar3 == null) {
                    k.a("viewModel");
                }
                if (gVar3.s != null) {
                    g gVar4 = aJRCommonCalendarActivity2.f22972e;
                    if (gVar4 == null) {
                        k.a("viewModel");
                    }
                    Date date2 = gVar4.s;
                    if (date2 == null) {
                        k.a();
                    }
                    String a5 = aJRCommonCalendarActivity2.a(date2, "dd MMMM EEEE");
                    k.a((Object) textView2, "txtTabDisc");
                    textView2.setVisibility(8);
                    k.a((Object) relativeLayout, "tabDateLyt");
                    relativeLayout.setVisibility(0);
                    if (a5 != null) {
                        Object[] array2 = new l(" ").split(a5, 0).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            k.a((Object) textView3, "txtDate");
                            textView3.setText(strArr2[0]);
                            TextView textView10 = textView9;
                            k.a((Object) textView10, "txtMonth");
                            textView10.setText(strArr2[1]);
                            TextView textView11 = textView5;
                            k.a((Object) textView11, str6);
                            textView11.setText(strArr2[2]);
                        } else {
                            throw new u(str5);
                        }
                    }
                } else {
                    k.a((Object) textView2, "txtTabDisc");
                    textView2.setText(aJRCommonCalendarActivity2.getString(R.string.select_return_date));
                    textView2.setVisibility(0);
                    k.a((Object) relativeLayout, "tabDateLyt");
                    relativeLayout.setVisibility(8);
                    i3 = i2 + 1;
                    tabCount = i4;
                    str = str2;
                }
            }
            i3 = i2 + 1;
            tabCount = i4;
            str = str2;
        }
    }
}
