package net.one97.paytm.o2o.movies.seat_selection;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.VolleyError;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.card.MaterialCardView;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AppBaseActivity;
import net.one97.paytm.o2o.movies.adapter.v;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget;
import net.one97.paytm.o2o.movies.entity.SeatMapData;
import net.one97.paytm.o2o.movies.fragment.r;
import net.one97.paytm.o2o.movies.order_review.AJROrderReview;
import net.one97.paytm.o2o.movies.seat_selection.a;
import net.one97.paytm.o2o.movies.seat_selection.b;
import net.one97.paytm.o2o.movies.utils.aa;
import net.one97.paytm.o2o.movies.utils.x;
import net.one97.paytm.o2o.movies.widget.ViewTooltip;
import net.one97.paytm.utils.CJRDottedProgressBar;

public final class SeatSelectionActivity extends AppBaseActivity implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f75763a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private g f75764b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public SeatMapData f75765c;

    /* renamed from: d  reason: collision with root package name */
    private v f75766d;

    /* renamed from: e  reason: collision with root package name */
    private CJRSeat f75767e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<CJRObjSeat> f75768f;

    /* renamed from: g  reason: collision with root package name */
    private int f75769g;

    /* renamed from: h  reason: collision with root package name */
    private String f75770h;

    /* renamed from: i  reason: collision with root package name */
    private MenuItem f75771i;
    private ViewTooltip j;
    private boolean k = true;
    private ObjectAnimator l;
    private HashMap m;

    public static final void a(Context context, SeatMapData seatMapData) {
        a.a(context, seatMapData);
    }

    public final View a(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<net.one97.paytm.o2o.movies.common.h<CJRSeat, Throwable>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75773a;

        c(SeatSelectionActivity seatSelectionActivity) {
            this.f75773a = seatSelectionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.o2o.movies.common.h hVar = (net.one97.paytm.o2o.movies.common.h) obj;
            if (!hVar.f75125a) {
                if (!hVar.f75126b || hVar.f75127c == null) {
                    SeatSelectionActivity seatSelectionActivity = this.f75773a;
                    E e2 = hVar.f75128d;
                    if (!(e2 instanceof net.one97.paytm.o2o.movies.common.f)) {
                        e2 = null;
                    }
                    SeatSelectionActivity.a(seatSelectionActivity, (net.one97.paytm.o2o.movies.common.f) e2);
                } else {
                    SeatSelectionActivity.a(this.f75773a, (CJRSeat) hVar.f75127c);
                }
            }
            SeatSelectionActivity.a(this.f75773a, hVar.f75125a);
        }
    }

    public SeatSelectionActivity() {
        SeatMapData seatMapData = r1;
        SeatMapData seatMapData2 = new SeatMapData((CJRMoviesSession) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, false, (CJRMovieWidget) null, 0, (String) null, 262143, (kotlin.g.b.g) null);
        this.f75765c = seatMapData;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(32:10|(1:14)|15|(1:19)|20|(1:24)|25|(1:29)|30|(1:32)|33|(1:35)|36|(1:38)|39|(5:40|41|(1:45)|46|(1:48))|50|(2:54|(1:56))|57|(2:59|(1:61))(2:62|(1:66))|67|(1:69)|70|(8:74|(1:76)(1:77)|78|(1:80)|81|(1:83)|84|(1:86))|87|(1:89)|90|91|(1:93)|94|95|(10:97|(1:99)|100|(1:102)|103|(1:105)|106|(1:108)|109|113)(1:115)) */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x031b */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0323 A[Catch:{ Exception -> 0x049e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            java.lang.String r0 = "/"
            super.onCreate(r11)
            int r11 = net.one97.paytm.o2o.movies.R.layout.activity_movie_seat_selection
            r10.setContentView((int) r11)
            android.content.Intent r11 = r10.getIntent()
            r1 = 0
            if (r11 == 0) goto L_0x001a
            java.lang.String r2 = "seatmap_data"
            android.os.Parcelable r11 = r11.getParcelableExtra(r2)
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = (net.one97.paytm.o2o.movies.entity.SeatMapData) r11
            goto L_0x001b
        L_0x001a:
            r11 = r1
        L_0x001b:
            boolean r2 = r11 instanceof net.one97.paytm.o2o.movies.entity.SeatMapData
            if (r2 != 0) goto L_0x0020
            r11 = r1
        L_0x0020:
            if (r11 == 0) goto L_0x049f
            boolean r2 = r11.preconditionCheck()
            r3 = 1
            if (r2 != r3) goto L_0x049f
            r10.f75765c = r11
            r11 = r10
            androidx.fragment.app.FragmentActivity r11 = (androidx.fragment.app.FragmentActivity) r11
            androidx.lifecycle.al r11 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r11)
            java.lang.Class<net.one97.paytm.o2o.movies.seat_selection.g> r2 = net.one97.paytm.o2o.movies.seat_selection.g.class
            androidx.lifecycle.ai r11 = r11.a(r2)
            net.one97.paytm.o2o.movies.seat_selection.g r11 = (net.one97.paytm.o2o.movies.seat_selection.g) r11
            r10.f75764b = r11
            net.one97.paytm.o2o.movies.seat_selection.g r11 = r10.f75764b
            if (r11 == 0) goto L_0x0057
            kotlin.g r11 = r11.f75839a
            java.lang.Object r11 = r11.getValue()
            androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
            if (r11 == 0) goto L_0x0057
            r2 = r10
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$c r4 = new net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$c
            r4.<init>(r10)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r11.observe(r2, r4)
        L_0x0057:
            net.one97.paytm.o2o.movies.seat_selection.g r11 = r10.f75764b
            if (r11 == 0) goto L_0x006c
            androidx.lifecycle.y<android.content.Intent> r11 = r11.f75840b
            if (r11 == 0) goto L_0x006c
            r2 = r10
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$d r4 = new net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$d
            r4.<init>(r10)
            androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
            r11.observe(r2, r4)
        L_0x006c:
            int r11 = com.paytm.utility.b.d()
            r2 = 21
            r4 = 0
            if (r11 >= r2) goto L_0x0080
            int r11 = net.one97.paytm.o2o.movies.R.id.view_container_movie_info_separator
            android.view.View r11 = r10.a((int) r11)
            if (r11 == 0) goto L_0x0080
            r11.setVisibility(r4)
        L_0x0080:
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r2) goto L_0x0096
            android.view.Window r11 = r10.getWindow()
            if (r11 == 0) goto L_0x0096
            r2 = r10
            android.content.Context r2 = (android.content.Context) r2
            int r5 = net.one97.paytm.o2o.movies.R.color.black
            int r2 = androidx.core.content.b.c(r2, r5)
            r11.setNavigationBarColor(r2)
        L_0x0096:
            int r11 = net.one97.paytm.o2o.movies.R.id.network_retry_btn
            android.view.View r11 = r10.a((int) r11)
            android.widget.Button r11 = (android.widget.Button) r11
            if (r11 == 0) goto L_0x00aa
            net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$e r2 = new net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$e
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r11.setOnClickListener(r2)
        L_0x00aa:
            int r11 = net.one97.paytm.o2o.movies.R.id.proceed_to_pay_rel_lyt
            android.view.View r11 = r10.a((int) r11)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$f r2 = new net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$f
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r11.setOnClickListener(r2)
            int r11 = net.one97.paytm.o2o.movies.R.id.toolbar
            android.view.View r11 = r10.a((int) r11)
            androidx.appcompat.widget.Toolbar r11 = (androidx.appcompat.widget.Toolbar) r11
            r10.setSupportActionBar(r11)
            androidx.appcompat.app.ActionBar r11 = r10.getSupportActionBar()
            if (r11 == 0) goto L_0x00d0
            r11.b((boolean) r3)
        L_0x00d0:
            androidx.appcompat.app.ActionBar r11 = r10.getSupportActionBar()
            if (r11 == 0) goto L_0x00d9
            r11.c((boolean) r4)
        L_0x00d9:
            r11 = r10
            android.content.Context r11 = (android.content.Context) r11     // Catch:{ Exception -> 0x0102 }
            int r2 = net.one97.paytm.common.widgets.R.drawable.back_arrow     // Catch:{ Exception -> 0x0102 }
            android.graphics.drawable.Drawable r11 = androidx.core.content.b.a((android.content.Context) r11, (int) r2)     // Catch:{ Exception -> 0x0102 }
            if (r11 == 0) goto L_0x00f8
            android.graphics.drawable.Drawable r2 = r11.mutate()     // Catch:{ Exception -> 0x0102 }
            if (r2 == 0) goto L_0x00f8
            r5 = r10
            android.content.Context r5 = (android.content.Context) r5     // Catch:{ Exception -> 0x0102 }
            int r6 = net.one97.paytm.common.assets.R.color.color_000000     // Catch:{ Exception -> 0x0102 }
            int r5 = androidx.core.content.b.c(r5, r6)     // Catch:{ Exception -> 0x0102 }
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_ATOP     // Catch:{ Exception -> 0x0102 }
            r2.setColorFilter(r5, r6)     // Catch:{ Exception -> 0x0102 }
        L_0x00f8:
            androidx.appcompat.app.ActionBar r2 = r10.getSupportActionBar()     // Catch:{ Exception -> 0x0102 }
            if (r2 == 0) goto L_0x0103
            r2.b((android.graphics.drawable.Drawable) r11)     // Catch:{ Exception -> 0x0102 }
            goto L_0x0103
        L_0x0102:
        L_0x0103:
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = r10.f75765c
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r11 = r11.getSelectedMovieSession()
            if (r11 == 0) goto L_0x0124
            java.lang.String r11 = r11.getRealShowDateTime()
            if (r11 == 0) goto L_0x0124
            java.lang.String r11 = net.one97.paytm.o2o.movies.utils.n.f(r11)
            int r2 = net.one97.paytm.o2o.movies.R.id.txt_date_info
            android.view.View r2 = r10.a((int) r2)
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2
            if (r2 == 0) goto L_0x0124
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r2.setText(r11)
        L_0x0124:
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = r10.f75765c
            java.lang.String r11 = r11.getMovieLocalizedTitle()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0148
            int r11 = net.one97.paytm.o2o.movies.R.id.txt_toolbar_title
            android.view.View r11 = r10.a((int) r11)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            if (r11 == 0) goto L_0x016b
            net.one97.paytm.o2o.movies.entity.SeatMapData r2 = r10.f75765c
            java.lang.String r2 = r2.getMovieLocalizedTitle()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r11.setText(r2)
            goto L_0x016b
        L_0x0148:
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = r10.f75765c
            java.lang.String r11 = r11.getMovieTitle()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x016b
            int r11 = net.one97.paytm.o2o.movies.R.id.txt_toolbar_title
            android.view.View r11 = r10.a((int) r11)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            if (r11 == 0) goto L_0x016b
            net.one97.paytm.o2o.movies.entity.SeatMapData r2 = r10.f75765c
            java.lang.String r2 = r2.getMovieTitle()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r11.setText(r2)
        L_0x016b:
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = r10.f75765c
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r11 = r11.getSelectedMovieSession()
            if (r11 == 0) goto L_0x018c
            int r2 = net.one97.paytm.o2o.movies.R.id.txt_cinema_info
            android.view.View r2 = r10.a((int) r2)
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2
            java.lang.String r5 = "txt_cinema_info"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            net.one97.paytm.o2o.movies.utils.h r5 = net.one97.paytm.o2o.movies.utils.h.f75928a
            java.lang.String r11 = net.one97.paytm.o2o.movies.utils.h.a((net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r11)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r2.setText(r11)
        L_0x018c:
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = r10.f75765c
            java.util.List r11 = r11.getSessionList()
            if (r11 == 0) goto L_0x01ec
            net.one97.paytm.o2o.movies.entity.SeatMapData r2 = r10.f75765c
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r2 = r2.getSelectedMovieSession()
            if (r2 == 0) goto L_0x01ec
            int r5 = net.one97.paytm.o2o.movies.R.id.rv_session_time_slots
            android.view.View r5 = r10.a((int) r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 == 0) goto L_0x01ab
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = r5.getLayoutManager()
            goto L_0x01ac
        L_0x01ab:
            r5 = r1
        L_0x01ac:
            net.one97.paytm.o2o.movies.adapter.as r6 = new net.one97.paytm.o2o.movies.adapter.as
            r7 = r10
            android.content.Context r7 = (android.content.Context) r7
            r6.<init>(r7)
            androidx.recyclerview.widget.RecyclerView$r r6 = (androidx.recyclerview.widget.RecyclerView.r) r6
            int r2 = r11.indexOf(r2)
            java.lang.Object r8 = kotlin.a.k.a(r11, (int) r2)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r8
            if (r8 == 0) goto L_0x01c5
            r8.setCurrentSession(r3)
        L_0x01c5:
            net.one97.paytm.o2o.movies.adapter.v r8 = new net.one97.paytm.o2o.movies.adapter.v
            net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$h r9 = new net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity$h
            r9.<init>(r6, r5, r11, r10)
            net.one97.paytm.o2o.movies.adapter.v$a r9 = (net.one97.paytm.o2o.movies.adapter.v.a) r9
            r8.<init>(r11, r7, r3, r9)
            r10.f75766d = r8
            int r11 = net.one97.paytm.o2o.movies.R.id.rv_session_time_slots
            android.view.View r11 = r10.a((int) r11)
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            if (r11 == 0) goto L_0x01e4
            net.one97.paytm.o2o.movies.adapter.v r3 = r10.f75766d
            androidx.recyclerview.widget.RecyclerView$a r3 = (androidx.recyclerview.widget.RecyclerView.a) r3
            r11.setAdapter(r3)
        L_0x01e4:
            r6.setTargetPosition(r2)
            if (r5 == 0) goto L_0x01ec
            r5.startSmoothScroll(r6)
        L_0x01ec:
            net.one97.paytm.o2o.movies.common.c.b r11 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r11 = r11.f75033b
            r2 = r10
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r3 = "/movies/seat-selection"
            java.lang.String r5 = "movies"
            r11.sendOpenScreenWithDeviceInfo(r3, r5, r2)
            r10.b()
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = r10.f75765c
            java.lang.String r11 = r11.getMovieImageUrl()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x021c
            com.squareup.picasso.w r11 = com.squareup.picasso.w.a()
            net.one97.paytm.o2o.movies.entity.SeatMapData r2 = r10.f75765c
            java.lang.String r2 = r2.getMovieImageUrl()
            com.squareup.picasso.aa r11 = r11.a((java.lang.String) r2)
            r11.a((com.squareup.picasso.e) r1)
        L_0x021c:
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = r10.f75765c     // Catch:{ Exception -> 0x031b }
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r11 = r11.getSelectedMovieSession()     // Catch:{ Exception -> 0x031b }
            if (r11 == 0) goto L_0x031b
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x031b }
            r1.<init>()     // Catch:{ Exception -> 0x031b }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = "Asia/Calcutta"
            java.util.TimeZone r2 = java.util.TimeZone.getTimeZone(r2)     // Catch:{ Exception -> 0x031b }
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "city_name"
            net.one97.paytm.o2o.movies.entity.SeatMapData r5 = r10.f75765c     // Catch:{ Exception -> 0x031b }
            java.lang.String r5 = r5.getSelectedCity()     // Catch:{ Exception -> 0x031b }
            r1.put(r3, r5)     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = "calendar"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x031b }
            java.util.Date r3 = r11.getRealDateTime()     // Catch:{ Exception -> 0x031b }
            r2.setTime(r3)     // Catch:{ Exception -> 0x031b }
            r3 = 5
            int r3 = r2.get(r3)     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x031b }
            r5 = 7
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = r2.getDisplayName(r5, r4, r6)     // Catch:{ Exception -> 0x031b }
            java.lang.String r5 = "day_date"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r6.<init>()     // Catch:{ Exception -> 0x031b }
            r6.append(r2)     // Catch:{ Exception -> 0x031b }
            r2 = 32
            r6.append(r2)     // Catch:{ Exception -> 0x031b }
            r6.append(r3)     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x031b }
            r1.put(r5, r2)     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = "theatre_name"
            java.lang.String r3 = r11.getCinemaName()     // Catch:{ Exception -> 0x031b }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = "show_time"
            java.lang.String r3 = r11.getRealShowDateTime()     // Catch:{ Exception -> 0x031b }
            java.lang.String r3 = net.one97.paytm.o2o.movies.utils.n.c((java.lang.String) r3)     // Catch:{ Exception -> 0x031b }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x031b }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x031b }
            r2.<init>()     // Catch:{ Exception -> 0x031b }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x031b }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x031b }
            r3.<init>()     // Catch:{ Exception -> 0x031b }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x031b }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x031b }
            r5.<init>()     // Catch:{ Exception -> 0x031b }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = "list"
            java.lang.String r7 = "Movie Listing"
            r5.put(r6, r7)     // Catch:{ Exception -> 0x031b }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x031b }
            r6.<init>()     // Catch:{ Exception -> 0x031b }
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception -> 0x031b }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x031b }
            r7.<init>()     // Catch:{ Exception -> 0x031b }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = "name"
            java.lang.String r9 = r11.getCinemaName()     // Catch:{ Exception -> 0x031b }
            r7.put(r8, r9)     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = "id"
            java.lang.String r9 = r11.getCinemaID()     // Catch:{ Exception -> 0x031b }
            r7.put(r8, r9)     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = "price"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x031b }
            r7.put(r8, r4)     // Catch:{ Exception -> 0x031b }
            java.lang.String r4 = "brand"
            net.one97.paytm.o2o.movies.entity.SeatMapData r8 = r10.f75765c     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = r8.getSelectedCity()     // Catch:{ Exception -> 0x031b }
            r7.put(r4, r8)     // Catch:{ Exception -> 0x031b }
            java.lang.String r4 = "variant"
            java.lang.String r11 = r11.getScreenFormat()     // Catch:{ Exception -> 0x031b }
            r7.put(r4, r11)     // Catch:{ Exception -> 0x031b }
            r6.add(r7)     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = "products"
            r5.put(r11, r6)     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = "actionField"
            r3.put(r11, r5)     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = "detail"
            r2.put(r11, r3)     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = "currencyCode"
            java.lang.String r3 = "INR"
            r2.put(r11, r3)     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = "ecommerce"
            r1.put(r11, r2)     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = "vertical_name"
            java.lang.String r2 = "Entertainment - Movies"
            r1.put(r11, r2)     // Catch:{ Exception -> 0x031b }
            net.one97.paytm.o2o.movies.common.c.b r11 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x031b }
            net.one97.paytm.o2o.movies.common.c.c r11 = r11.f75033b     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = "openScreen"
            r3 = r10
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ Exception -> 0x031b }
            r11.sendEnhancedEcommerceEvent(r2, r1, r3)     // Catch:{ Exception -> 0x031b }
        L_0x031b:
            net.one97.paytm.o2o.movies.entity.SeatMapData r11 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r11 = r11.getSelectedMovieSession()     // Catch:{ Exception -> 0x049e }
            if (r11 == 0) goto L_0x049e
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x049e }
            r1.<init>()     // Catch:{ Exception -> 0x049e }
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = "screenName"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049e }
            java.lang.String r5 = "/movies/"
            r4.<init>(r5)     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.entity.SeatMapData r5 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            java.lang.String r5 = r5.getMovieTitle()     // Catch:{ Exception -> 0x049e }
            r4.append(r5)     // Catch:{ Exception -> 0x049e }
            java.lang.String r5 = "/seat-selection"
            r4.append(r5)     // Catch:{ Exception -> 0x049e }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x049e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x049e }
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x049e }
            java.lang.String r4 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x049e }
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.A     // Catch:{ Exception -> 0x049e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x049e }
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x049e }
            java.lang.String r4 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x049e }
            java.lang.String r4 = "Screen Loaded"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x049e }
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x049e }
            java.lang.String r4 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x049e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049e }
            r4.<init>()     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.entity.SeatMapData r5 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            java.lang.String r5 = r5.getMovieTitle()     // Catch:{ Exception -> 0x049e }
            r4.append(r5)     // Catch:{ Exception -> 0x049e }
            r4.append(r0)     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.entity.SeatMapData r5 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            java.lang.String r5 = r5.getMovieCode()     // Catch:{ Exception -> 0x049e }
            r4.append(r5)     // Catch:{ Exception -> 0x049e }
            r4.append(r0)     // Catch:{ Exception -> 0x049e }
            java.lang.String r5 = r11.getRealShowDateTime()     // Catch:{ Exception -> 0x049e }
            java.lang.String r6 = "session.getRealShowDateTime()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x049e }
            java.lang.String r5 = a((java.lang.String) r5)     // Catch:{ Exception -> 0x049e }
            r4.append(r5)     // Catch:{ Exception -> 0x049e }
            r4.append(r0)     // Catch:{ Exception -> 0x049e }
            java.lang.String r5 = r11.getCinemaName()     // Catch:{ Exception -> 0x049e }
            r4.append(r5)     // Catch:{ Exception -> 0x049e }
            r4.append(r0)     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = r11.getCinemaID()     // Catch:{ Exception -> 0x049e }
            r4.append(r0)     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x049e }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.entity.SeatMapData r0 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = r0.getSeatStatus()     // Catch:{ Exception -> 0x049e }
            if (r0 == 0) goto L_0x03d4
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75010e     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_2"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.entity.SeatMapData r3 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = r3.getSeatStatus()     // Catch:{ Exception -> 0x049e }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x049e }
        L_0x03d4:
            r0 = r10
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.d.b((android.content.Context) r0)     // Catch:{ Exception -> 0x049e }
            boolean r2 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotBlank(r0)     // Catch:{ Exception -> 0x049e }
            if (r2 == 0) goto L_0x03ee
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75013h     // Catch:{ Exception -> 0x049e }
            java.lang.String r4 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_5"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x049e }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x049e }
        L_0x03ee:
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75014i     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_6"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.entity.SeatMapData r3 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = r3.getMovieTitle()     // Catch:{ Exception -> 0x049e }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x049e }
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.j     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_7"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.entity.SeatMapData r3 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = r3.getMovieCode()     // Catch:{ Exception -> 0x049e }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x049e }
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.k     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_8"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = r11.getCinemaName()     // Catch:{ Exception -> 0x049e }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x049e }
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.l     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_9"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = r11.getCinemaID()     // Catch:{ Exception -> 0x049e }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = r11.getpKey()     // Catch:{ Exception -> 0x049e }
            boolean r0 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotBlank(r0)     // Catch:{ Exception -> 0x049e }
            if (r0 == 0) goto L_0x0451
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.m     // Catch:{ Exception -> 0x049e }
            java.lang.String r3 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_10"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x049e }
            java.lang.String r11 = r11.getpKey()     // Catch:{ Exception -> 0x049e }
            r0.put(r2, r11)     // Catch:{ Exception -> 0x049e }
        L_0x0451:
            r11 = r1
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.n     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_11"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.entity.SeatMapData r2 = r10.f75765c     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = r2.getMovieLanguage()     // Catch:{ Exception -> 0x049e }
            r11.put(r0, r2)     // Catch:{ Exception -> 0x049e }
            r11 = r1
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x049e }
            r11.put(r0, r2)     // Catch:{ Exception -> 0x049e }
            r11 = r10
            android.content.Context r11 = (android.content.Context) r11     // Catch:{ Exception -> 0x049e }
            boolean r11 = com.paytm.utility.b.r((android.content.Context) r11)     // Catch:{ Exception -> 0x049e }
            if (r11 == 0) goto L_0x0490
            r11 = r1
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = "CJRMoviesGTMConstants.GTM_KEY_USER_ID"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x049e }
            r2 = r10
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x049e }
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r2)     // Catch:{ Exception -> 0x049e }
            r11.put(r0, r2)     // Catch:{ Exception -> 0x049e }
        L_0x0490:
            net.one97.paytm.o2o.movies.common.c.b r11 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x049e }
            net.one97.paytm.o2o.movies.common.c.c r11 = r11.f75033b     // Catch:{ Exception -> 0x049e }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x049e }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x049e }
            r2 = r10
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x049e }
            r11.sendCustomEventWithMap(r0, r1, r2)     // Catch:{ Exception -> 0x049e }
        L_0x049e:
            return
        L_0x049f:
            r10.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public final void b() {
        this.f75768f = null;
        this.f75769g = 0;
        LinearLayout linearLayout = (LinearLayout) a(R.id.lyt_container_movie_info);
        kotlin.g.b.k.a((Object) linearLayout, "lyt_container_movie_info");
        if (net.one97.paytm.o2o.movies.common.a.e.a(linearLayout)) {
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.lyt_container_movie_info);
            kotlin.g.b.k.a((Object) linearLayout2, "lyt_container_movie_info");
            net.one97.paytm.o2o.movies.common.a.e.a(linearLayout2, false);
            ObjectAnimator a2 = a((View) (LinearLayout) a(R.id.lyt_container_movie_info), (AnimatorListenerAdapter) null);
            if (a2 != null) {
                a2.start();
            }
        }
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt);
        kotlin.g.b.k.a((Object) relativeLayout, "proceed_to_pay_rel_lyt");
        if (net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout)) {
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt);
            kotlin.g.b.k.a((Object) relativeLayout2, "proceed_to_pay_rel_lyt");
            net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout2, false);
            ObjectAnimator a3 = a((View) (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt), (AnimatorListenerAdapter) null);
            if (a3 != null) {
                a3.start();
            }
        }
        ViewTooltip viewTooltip = this.j;
        if (viewTooltip != null) {
            viewTooltip.f76168c.a();
        }
        b(false);
        e();
        g gVar = this.f75764b;
        if (gVar != null) {
            gVar.a(this.f75765c.getSelectedMovieSession());
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75775a;

        e(SeatSelectionActivity seatSelectionActivity) {
            this.f75775a = seatSelectionActivity;
        }

        public final void onClick(View view) {
            this.f75775a.b();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75776a;

        f(SeatSelectionActivity seatSelectionActivity) {
            this.f75776a = seatSelectionActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.o2o.movies.common.a.e.b((RelativeLayout) this.f75776a.a(R.id.proceed_to_pay_rel_lyt));
            SeatSelectionActivity.c(this.f75776a);
            if (!TextUtils.isEmpty(this.f75776a.f75765c.getCinemaMovieInfoString())) {
                SeatSelectionActivity.e(this.f75776a);
            } else {
                SeatSelectionActivity.f(this.f75776a);
            }
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75777a;

        g(SeatSelectionActivity seatSelectionActivity) {
            this.f75777a = seatSelectionActivity;
        }

        public final void run() {
            RelativeLayout relativeLayout = (RelativeLayout) this.f75777a.a(R.id.proceed_to_pay_rel_lyt);
            if (relativeLayout != null) {
                relativeLayout.setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        ArrayList<CJRObjSeat> arrayList;
        Context context = this;
        if (!com.paytm.utility.b.c(context)) {
            a(true);
        } else if (com.paytm.utility.b.r(context)) {
            CJRSeat cJRSeat = this.f75767e;
            if (cJRSeat != null && (arrayList = this.f75768f) != null) {
                net.one97.paytm.o2o.movies.utils.g.a().d();
                int i2 = this.f75769g;
                kotlin.g.b.k.c(cJRSeat, "cjrSeat");
                kotlin.g.b.k.c(arrayList, "selectedSeats");
                String str = "checkout";
                Intent intent = new Intent(context, AJROrderReview.class);
                Bundle bundle = new Bundle();
                Object obj = "quantity";
                intent.putExtra("seatmap_data", this.f75765c);
                bundle.putString("temptransid", cJRSeat.getTempTransId());
                CJRMoviesSession selectedMovieSession = this.f75765c.getSelectedMovieSession();
                bundle.putString("cinemaid", selectedMovieSession != null ? selectedMovieSession.getCinemaID() : null);
                bundle.putParcelable("moviesession", this.f75765c.getSelectedMovieSession());
                bundle.putParcelable("selectedmovie", this.f75765c.getSelectedMovie());
                bundle.putString("seatselectionsource", this.f75765c.getSelectedCategory());
                bundle.putString("citysearched", this.f75765c.getSelectedCity());
                bundle.putParcelableArrayList("selectedseats", arrayList);
                bundle.putInt("curentselectedseat", i2);
                bundle.putString("productid", cJRSeat.getProductId());
                bundle.putString("intent_extra_time_slot", this.f75765c.getTimeSlot());
                bundle.putBoolean("movie_pass_present", this.f75765c.isMoviePassPresent());
                bundle.putParcelable("intent_extra_movie_offer_data", this.f75765c.getMovieOfferData());
                bundle.putString("intent_movie_title_localized", this.f75765c.getMovieLocalizedTitle());
                bundle.putString("intent_movie_language_localized", this.f75765c.getMovieLocalizedLanguage());
                intent.putExtra("bundle", bundle);
                startActivity(intent);
                try {
                    CJRMoviesSession selectedMovieSession2 = this.f75765c.getSelectedMovieSession();
                    if (selectedMovieSession2 != null) {
                        Map hashMap = new HashMap();
                        hashMap.put("city_name", this.f75765c.getSelectedCity());
                        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
                        kotlin.g.b.k.a((Object) instance, "calendar");
                        instance.setTime(selectedMovieSession2.getRealDateTime());
                        String valueOf = String.valueOf(instance.get(5));
                        String displayName = instance.getDisplayName(7, 0, Locale.getDefault());
                        hashMap.put("day_date", displayName + ' ' + valueOf);
                        hashMap.put("theatre_name", selectedMovieSession2.getCinemaName());
                        hashMap.put("show_time", net.one97.paytm.o2o.movies.utils.n.c(selectedMovieSession2.getRealShowDateTime()));
                        Map hashMap2 = new HashMap();
                        Map hashMap3 = new HashMap();
                        List arrayList2 = new ArrayList();
                        Map hashMap4 = new HashMap();
                        hashMap4.put("name", this.f75765c.getMovieTitle());
                        hashMap4.put("id", this.f75765c.getMovieCode());
                        Map map = hashMap;
                        hashMap4.put("price", 0);
                        hashMap4.put("category", selectedMovieSession2.getCinemaName());
                        hashMap4.put(CLPConstants.BRAND_PARAMS, this.f75765c.getSelectedCity());
                        hashMap4.put("variant", selectedMovieSession2.getScreenFormat());
                        hashMap4.put(CLPConstants.ARGUMENT_KEY_POSITION, 1);
                        Object obj2 = obj;
                        hashMap4.put(obj2, 1);
                        arrayList2.add(hashMap4);
                        Map hashMap5 = new HashMap();
                        hashMap5.put("name", selectedMovieSession2.getCinemaName());
                        hashMap5.put("id", selectedMovieSession2.getCinemaID());
                        hashMap5.put("price", 0);
                        hashMap5.put("category", this.f75765c.getMovieTitle());
                        hashMap5.put(CLPConstants.BRAND_PARAMS, this.f75765c.getSelectedCity());
                        hashMap5.put("variant", selectedMovieSession2.getScreenFormat());
                        hashMap5.put(CLPConstants.ARGUMENT_KEY_POSITION, 1);
                        hashMap5.put(obj2, Integer.valueOf(this.f75769g));
                        arrayList2.add(hashMap5);
                        hashMap3.put("products", arrayList2);
                        Map hashMap6 = new HashMap();
                        hashMap6.put("step", 1);
                        hashMap6.put("option", "Order Review");
                        hashMap3.put("actionField", hashMap6);
                        String str2 = str;
                        hashMap2.put(str2, hashMap3);
                        Map map2 = map;
                        map2.put("ecommerce", hashMap2);
                        map2.put("vertical_name", "Entertainment - Movies");
                        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendEnhancedEcommerceEvent(str2, map2, this);
                    }
                } catch (Exception unused) {
                }
                finish();
            }
        } else {
            this.f75770h = "task_type_proceed_to_pay";
            try {
                HashMap hashMap7 = new HashMap();
                hashMap7.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/" + this.f75765c.getMovieTitle() + "/seat-selection");
                String str3 = net.one97.paytm.o2o.movies.common.b.b.f75007b;
                kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
                String str4 = net.one97.paytm.o2o.movies.common.b.b.A;
                kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GT…IE_TICKETS_SEAT_SELECTION");
                hashMap7.put(str3, str4);
                String str5 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
                kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
                hashMap7.put(str5, "Login Prompt Shown");
                String str6 = net.one97.paytm.o2o.movies.common.b.b.p;
                kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
                String str7 = net.one97.paytm.o2o.movies.common.b.b.r;
                kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_VALUE_VERTICAL_NAME");
                hashMap7.put(str6, str7);
                if (com.paytm.utility.b.r((Context) this)) {
                    String str8 = net.one97.paytm.o2o.movies.common.b.b.q;
                    kotlin.g.b.k.a((Object) str8, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                    String n2 = com.paytm.utility.b.n((Context) this);
                    kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                    hashMap7.put(str8, n2);
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap7, this);
            } catch (Exception unused2) {
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.signOut(this, false, (VolleyError) null);
            net.one97.paytm.o2o.movies.common.c.c cVar = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b;
            kotlin.g.b.k.a((Object) cVar, "MoviesController.getMovieEventListener()");
            startActivityForResult(new Intent(context, cVar.getPaytmActivityMap().get("authActivity")), 1);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f75787a;

        m(AlertDialog alertDialog) {
            this.f75787a = alertDialog;
        }

        public final void onClick(View view) {
            AlertDialog alertDialog = this.f75787a;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75788a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AlertDialog f75789b;

        n(SeatSelectionActivity seatSelectionActivity, AlertDialog alertDialog) {
            this.f75788a = seatSelectionActivity;
            this.f75789b = alertDialog;
        }

        public final void onClick(View view) {
            AlertDialog alertDialog = this.f75789b;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.f75788a.c();
        }
    }

    public static final class h implements v.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.r f75778a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.LayoutManager f75779b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f75780c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75781d;

        public final void b(View view, CJRMoviesSession cJRMoviesSession, ArrayList<CJRMoviesSession> arrayList, int i2) {
            kotlin.g.b.k.c(view, "view");
            kotlin.g.b.k.c(cJRMoviesSession, "session");
            kotlin.g.b.k.c(arrayList, "sessionList");
        }

        h(RecyclerView.r rVar, RecyclerView.LayoutManager layoutManager, List list, SeatSelectionActivity seatSelectionActivity) {
            this.f75778a = rVar;
            this.f75779b = layoutManager;
            this.f75780c = list;
            this.f75781d = seatSelectionActivity;
        }

        public final void a(View view, CJRMoviesSession cJRMoviesSession, ArrayList<CJRMoviesSession> arrayList, int i2) {
            kotlin.g.b.k.c(view, "view");
            kotlin.g.b.k.c(cJRMoviesSession, "session");
            kotlin.g.b.k.c(arrayList, "sessionList");
            this.f75781d.f75765c.setSelectedMovieSession(cJRMoviesSession);
            this.f75781d.f75765c.setMovieSessionPosition(i2);
            this.f75778a.setTargetPosition(i2);
            RecyclerView.LayoutManager layoutManager = this.f75779b;
            if (layoutManager != null) {
                layoutManager.startSmoothScroll(this.f75778a);
            }
            this.f75781d.b();
        }
    }

    private final void a(String str, String str2) {
        View a2 = a(R.id.seat_api_fail_layout);
        if (a2 != null) {
            a2.setVisibility(0);
        }
        Button button = (Button) a(R.id.seat_error_cta_btn);
        if (button != null) {
            button.setVisibility(8);
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.seat_error_title_tv);
            if (roboTextView != null) {
                roboTextView.setText(charSequence);
            }
        } else {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.seat_error_title_tv);
            if (roboTextView2 != null) {
                roboTextView2.setText(getString(R.string.movie_seat_api_error_title));
            }
        }
        CharSequence charSequence2 = str2;
        if (!TextUtils.isEmpty(charSequence2)) {
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.seat_error_desc_tv);
            if (roboTextView3 != null) {
                roboTextView3.setText(charSequence2);
                return;
            }
            return;
        }
        RoboTextView roboTextView4 = (RoboTextView) a(R.id.seat_error_desc_tv);
        if (roboTextView4 != null) {
            roboTextView4.setText(getResources().getString(R.string.movie_seat_api_error_desc));
        }
    }

    private final void a(boolean z) {
        View a2 = a(R.id.no_network_layout);
        kotlin.g.b.k.a((Object) a2, "no_network_layout");
        net.one97.paytm.o2o.movies.common.a.e.a(a2, z);
    }

    public static final class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75782a;

        i(SeatSelectionActivity seatSelectionActivity) {
            this.f75782a = seatSelectionActivity;
        }

        public final void onAnimationEnd(Animator animator) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f75782a.a(R.id.proceed_to_pay_rel_lyt);
            kotlin.g.b.k.a((Object) relativeLayout, "proceed_to_pay_rel_lyt");
            net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout, true);
            ObjectAnimator a2 = SeatSelectionActivity.b((View) (RelativeLayout) this.f75782a.a(R.id.proceed_to_pay_rel_lyt));
            if (a2 != null) {
                a2.start();
            }
        }
    }

    private final void d() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.l;
        if (!(objectAnimator2 == null || !objectAnimator2.isRunning() || (objectAnimator = this.l) == null)) {
            objectAnimator.cancel();
        }
        LinearLayout linearLayout = (LinearLayout) a(R.id.lyt_container_movie_info);
        kotlin.g.b.k.a((Object) linearLayout, "lyt_container_movie_info");
        if (!net.one97.paytm.o2o.movies.common.a.e.a(linearLayout)) {
            if (this.f75765c.isFreeSeating()) {
                LinearLayout linearLayout2 = (LinearLayout) a(R.id.lyt_container_movie_info);
                kotlin.g.b.k.a((Object) linearLayout2, "lyt_container_movie_info");
                net.one97.paytm.o2o.movies.common.a.e.a(linearLayout2, false);
                RelativeLayout relativeLayout = (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt);
                kotlin.g.b.k.a((Object) relativeLayout, "proceed_to_pay_rel_lyt");
                net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout, false);
                this.l = a((View) (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt), (AnimatorListenerAdapter) null);
                ObjectAnimator objectAnimator3 = this.l;
                if (objectAnimator3 != null) {
                    objectAnimator3.start();
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt);
            kotlin.g.b.k.a((Object) relativeLayout2, "proceed_to_pay_rel_lyt");
            if (net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout2)) {
                this.l = a((View) (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt), (AnimatorListenerAdapter) new j(this));
                ObjectAnimator objectAnimator4 = this.l;
                if (objectAnimator4 != null) {
                    objectAnimator4.start();
                    return;
                }
                return;
            }
            LinearLayout linearLayout3 = (LinearLayout) a(R.id.lyt_container_movie_info);
            kotlin.g.b.k.a((Object) linearLayout3, "lyt_container_movie_info");
            net.one97.paytm.o2o.movies.common.a.e.a(linearLayout3, true);
            this.l = b((View) (LinearLayout) a(R.id.lyt_container_movie_info));
            ObjectAnimator objectAnimator5 = this.l;
            if (objectAnimator5 != null) {
                objectAnimator5.start();
            }
        }
    }

    public static final class j extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75783a;

        j(SeatSelectionActivity seatSelectionActivity) {
            this.f75783a = seatSelectionActivity;
        }

        public final void onAnimationEnd(Animator animator) {
            LinearLayout linearLayout = (LinearLayout) this.f75783a.a(R.id.lyt_container_movie_info);
            kotlin.g.b.k.a((Object) linearLayout, "lyt_container_movie_info");
            net.one97.paytm.o2o.movies.common.a.e.a(linearLayout, true);
            ObjectAnimator a2 = SeatSelectionActivity.b((View) (LinearLayout) this.f75783a.a(R.id.lyt_container_movie_info));
            if (a2 != null) {
                a2.start();
            }
        }
    }

    private static ObjectAnimator a(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, -((float) view.getWidth())});
        kotlin.g.b.k.a((Object) ofFloat, "animator");
        ofFloat.setDuration(350);
        ofFloat.addListener(new p(view, animatorListenerAdapter));
        return ofFloat;
    }

    public static final class p extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f75791a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AnimatorListenerAdapter f75792b;

        p(View view, AnimatorListenerAdapter animatorListenerAdapter) {
            this.f75791a = view;
            this.f75792b = animatorListenerAdapter;
        }

        public final void onAnimationEnd(Animator animator) {
            View view = this.f75791a;
            if (view != null) {
                net.one97.paytm.o2o.movies.common.a.e.a(view, false);
            }
            View view2 = this.f75791a;
            if (view2 != null) {
                view2.setTranslationX(0.0f);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.f75792b;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            View view = this.f75791a;
            if (view != null) {
                net.one97.paytm.o2o.movies.common.a.e.a(view, false);
            }
            View view2 = this.f75791a;
            if (view2 != null) {
                view2.setTranslationX(0.0f);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.f75792b;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(animator);
            }
        }
    }

    /* access modifiers changed from: private */
    public static ObjectAnimator b(View view) {
        int i2;
        if (view == null) {
            return null;
        }
        if (view.getHeight() > 0) {
            i2 = view.getHeight();
        } else {
            net.one97.paytm.o2o.movies.utils.n.a(view);
            i2 = view.getMeasuredHeight();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) i2, 0.0f});
        kotlin.g.b.k.a((Object) ofFloat, "animator");
        ofFloat.setDuration(350);
        return ofFloat;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75772a;

        b(SeatSelectionActivity seatSelectionActivity) {
            this.f75772a = seatSelectionActivity;
        }

        public final void onClick(View view) {
            MaterialCardView materialCardView = (MaterialCardView) this.f75772a.a(R.id.layout_init_message);
            kotlin.g.b.k.a((Object) materialCardView, "layout_init_message");
            net.one97.paytm.o2o.movies.common.a.e.a(materialCardView, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r0 = r1.a().a(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e() {
        /*
            r2 = this;
            androidx.fragment.app.j r0 = r2.getSupportFragmentManager()
            if (r0 == 0) goto L_0x002b
            int r1 = net.one97.paytm.o2o.movies.R.id.seat_selection_container
            androidx.fragment.app.Fragment r0 = r0.c((int) r1)
            if (r0 == 0) goto L_0x002b
            androidx.fragment.app.j r1 = r2.getSupportFragmentManager()
            if (r1 == 0) goto L_0x0027
            androidx.fragment.app.q r1 = r1.a()
            androidx.fragment.app.q r0 = r1.a((androidx.fragment.app.Fragment) r0)
            if (r0 == 0) goto L_0x0027
            int r0 = r0.b()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            r0.intValue()
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity.e():void");
    }

    private final void b(boolean z) {
        if (this.f75765c.isFreeSeating()) {
            MenuItem menuItem = this.f75771i;
            if (menuItem != null) {
                menuItem.setVisible(false);
            }
        } else {
            MenuItem menuItem2 = this.f75771i;
            if (menuItem2 != null) {
                menuItem2.setVisible(true);
            }
        }
        MenuItem menuItem3 = this.f75771i;
        if (menuItem3 != null) {
            menuItem3.setEnabled(z);
        }
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movie_seat_selection_menu, menu);
        this.f75771i = menu != null ? menu.findItem(R.id.btn_seat_share) : null;
        if (this.f75771i != null) {
            if (this.f75765c.isFreeSeating()) {
                MenuItem menuItem = this.f75771i;
                if (menuItem != null) {
                    menuItem.setVisible(false);
                }
            } else {
                b(false);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        SeatMapData a2;
        CJRMoviesSession selectedMovieSession;
        ArrayList<CJRObjSeat> arrayList;
        kotlin.g.b.k.c(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.btn_seat_share) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            int i2 = 0;
            if (!com.paytm.utility.b.c((Context) this)) {
                MenuItem menuItem2 = this.f75771i;
                if (menuItem2 != null) {
                    menuItem2.setEnabled(false);
                }
                a(true);
            } else {
                ViewTooltip viewTooltip = this.j;
                if (viewTooltip != null) {
                    viewTooltip.f76168c.a();
                }
                androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
                Fragment c2 = supportFragmentManager != null ? supportFragmentManager.c("FJRSeated") : null;
                if (!(c2 instanceof b)) {
                    c2 = null;
                }
                b bVar = (b) c2;
                if (bVar != null) {
                    bVar.f();
                    f fVar = bVar.f75810a;
                    if (!(fVar == null || (a2 = fVar.a()) == null || (selectedMovieSession = a2.getSelectedMovieSession()) == null)) {
                        net.one97.paytm.o2o.movies.b.e eVar = bVar.f75811b;
                        if (!(eVar == null || (arrayList = eVar.f74918a) == null)) {
                            i2 = arrayList.size();
                        }
                        r.a(i2, a2.getMovieTitle(), net.one97.paytm.o2o.movies.utils.n.e(selectedMovieSession.getRealShowDateTime()), selectedMovieSession.getCinemaName()).show(bVar.getChildFragmentManager(), "SeatShareDialog");
                    }
                }
            }
            return true;
        }
    }

    static final class o implements ViewTooltip.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75790a;

        o(SeatSelectionActivity seatSelectionActivity) {
            this.f75790a = seatSelectionActivity;
        }

        public final void a() {
            Context context = this.f75790a;
            kotlin.g.b.k.c(context, "context");
            x.a aVar = x.f76001a;
            Context applicationContext = context.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
            x.a.a(applicationContext).a("SEAT_SHARE_TUTORIAL_SHOWN_COUNT", aa.a(this.f75790a) + 1, false);
        }
    }

    public final void onStart() {
        CJRDottedProgressBar cJRDottedProgressBar;
        super.onStart();
        LinearLayout linearLayout = (LinearLayout) a(R.id.lyt_progress_bar);
        if (linearLayout != null && linearLayout.getVisibility() == 0 && (cJRDottedProgressBar = (CJRDottedProgressBar) a(R.id.dottedProgressBar)) != null) {
            cJRDottedProgressBar.a();
        }
    }

    public final void onStop() {
        super.onStop();
        CJRDottedProgressBar cJRDottedProgressBar = (CJRDottedProgressBar) a(R.id.dottedProgressBar);
        if (cJRDottedProgressBar != null) {
            cJRDottedProgressBar.b();
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        net.one97.paytm.o2o.movies.common.e.a(this);
        overridePendingTransition(17432576, net.one97.paytm.common.assets.R.anim.slide_out_right);
    }

    public final SeatMapData a() {
        return this.f75765c;
    }

    public final void a(ArrayList<CJRObjSeat> arrayList, int i2) {
        Context context;
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator;
        this.f75768f = arrayList;
        this.f75769g = i2;
        if (i2 > 0) {
            ObjectAnimator objectAnimator2 = this.l;
            if (!(objectAnimator2 == null || !objectAnimator2.isRunning() || (objectAnimator = this.l) == null)) {
                objectAnimator.cancel();
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt);
            kotlin.g.b.k.a((Object) relativeLayout, "proceed_to_pay_rel_lyt");
            if (!net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout)) {
                if (this.f75765c.isFreeSeating()) {
                    LinearLayout linearLayout = (LinearLayout) a(R.id.lyt_container_movie_info);
                    kotlin.g.b.k.a((Object) linearLayout, "lyt_container_movie_info");
                    net.one97.paytm.o2o.movies.common.a.e.a(linearLayout, false);
                    RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt);
                    kotlin.g.b.k.a((Object) relativeLayout2, "proceed_to_pay_rel_lyt");
                    net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout2, true);
                    this.l = b((View) (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt));
                    ObjectAnimator objectAnimator3 = this.l;
                    if (objectAnimator3 != null) {
                        objectAnimator3.start();
                    }
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) a(R.id.lyt_container_movie_info);
                    kotlin.g.b.k.a((Object) linearLayout2, "lyt_container_movie_info");
                    if (net.one97.paytm.o2o.movies.common.a.e.a(linearLayout2)) {
                        this.l = a((View) (LinearLayout) a(R.id.lyt_container_movie_info), (AnimatorListenerAdapter) new i(this));
                        ObjectAnimator objectAnimator4 = this.l;
                        if (objectAnimator4 != null) {
                            objectAnimator4.start();
                        }
                    } else {
                        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt);
                        kotlin.g.b.k.a((Object) relativeLayout3, "proceed_to_pay_rel_lyt");
                        net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout3, true);
                        this.l = b((View) (RelativeLayout) a(R.id.proceed_to_pay_rel_lyt));
                        ObjectAnimator objectAnimator5 = this.l;
                        if (objectAnimator5 != null) {
                            objectAnimator5.start();
                        }
                    }
                }
            }
            RoboTextView roboTextView = (RoboTextView) a(R.id.txt_proceed_to_pay);
            kotlin.g.b.k.a((Object) roboTextView, "txt_proceed_to_pay");
            StringBuilder sb = new StringBuilder("Book ");
            sb.append(i2);
            sb.append(' ');
            sb.append(i2 > 1 ? "Tickets" : "Ticket");
            roboTextView.setText(sb.toString());
        } else {
            d();
        }
        if (this.k && this.f75769g == 2 && !this.f75765c.isFreeSeating() && this.f75771i != null && aa.a(this) < 3) {
            View inflate = getLayoutInflater().inflate(R.layout.seat_share_tooltip, (ViewGroup) null);
            this.k = false;
            ViewTooltip viewTooltip = new ViewTooltip(new ViewTooltip.e(this), findViewById(R.id.btn_seat_share));
            viewTooltip.f76168c.setAutoHide(false);
            viewTooltip.f76168c.setDuration(1000);
            viewTooltip.f76168c.setCorner(30);
            viewTooltip.f76168c.setColor(getResources().getColor(R.color.zambezi));
            Paint paint = new Paint(1);
            paint.setColor(0);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(0.0f);
            viewTooltip.f76168c.setBorderPaint(paint);
            viewTooltip.f76168c.setCustomView(inflate);
            viewTooltip.f76168c.setArrowWidth(20);
            viewTooltip.f76168c.setArrowHeight(20);
            viewTooltip.f76168c.setDistanceWithView(0);
            viewTooltip.f76168c.setPosition(ViewTooltip.f.BOTTOM);
            viewTooltip.f76168c.setWithShadow(false);
            viewTooltip.f76168c.setListenerDisplay(new o(this));
            viewTooltip.f76168c.setClickToHide(true);
            this.j = viewTooltip;
            ViewTooltip viewTooltip2 = this.j;
            if (viewTooltip2 != null && (context = viewTooltip2.f76168c.getContext()) != null && (context instanceof Activity)) {
                if (viewTooltip2.f76166a != null) {
                    viewGroup = (ViewGroup) viewTooltip2.f76166a;
                } else {
                    viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
                }
                viewTooltip2.f76167b.postDelayed(new Runnable(viewGroup) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ ViewGroup f76169a;

                    {
                        this.f76169a = r2;
                    }

                    public final void run() {
                        final Rect rect = new Rect();
                        ViewTooltip.this.f76167b.getGlobalVisibleRect(rect);
                        Rect rect2 = new Rect();
                        Point point = new Point();
                        this.f76169a.getGlobalVisibleRect(rect2, point);
                        int[] iArr = new int[2];
                        ViewTooltip.this.f76167b.getLocationOnScreen(iArr);
                        rect.left = iArr[0];
                        rect.top -= point.y;
                        rect.bottom -= point.y;
                        rect.left -= point.x;
                        rect.right -= point.x;
                        this.f76169a.addView(ViewTooltip.this.f76168c, -2, -2);
                        ViewTooltip.this.f76168c.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                            public final boolean onPreDraw() {
                                ViewTooltip.this.f76168c.setup(rect, AnonymousClass1.this.f76169a.getWidth());
                                ViewTooltip.this.f76168c.getViewTreeObserver().removeOnPreDrawListener(this);
                                return false;
                            }
                        });
                    }
                }, 100);
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        androidx.fragment.app.j supportFragmentManager;
        Fragment c2;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            if (com.paytm.utility.b.r((Context) this) && kotlin.m.p.a("task_type_proceed_to_pay", this.f75770h, true)) {
                this.f75770h = null;
                c();
            }
        } else if (i2 == 666 && i3 == -1 && (supportFragmentManager = getSupportFragmentManager()) != null && (c2 = supportFragmentManager.c("FJRSeated")) != null) {
            c2.onActivityResult(i2, i3, intent);
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat("E, HH:mm a").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(str));
        } catch (ParseException unused) {
            return "";
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75784a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Dialog f75785b;

        k(SeatSelectionActivity seatSelectionActivity, Dialog dialog) {
            this.f75784a = seatSelectionActivity;
            this.f75785b = dialog;
        }

        public final void onClick(View view) {
            this.f75785b.dismiss();
            this.f75784a.c();
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Dialog f75786a;

        l(Dialog dialog) {
            this.f75786a = dialog;
        }

        public final void onClick(View view) {
            this.f75786a.dismiss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, SeatMapData seatMapData) {
            kotlin.g.b.k.c(context, "context");
            Intent intent = new Intent(context, SeatSelectionActivity.class);
            intent.putExtra("seatmap_data", seatMapData);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
            }
        }
    }

    static final class d<T> implements z<Intent> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SeatSelectionActivity f75774a;

        d(SeatSelectionActivity seatSelectionActivity) {
            this.f75774a = seatSelectionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.o2o.movies.common.e.a((Activity) this.f75774a, (kotlin.g.a.a<kotlin.x>) new kotlin.g.a.a<kotlin.x>(this) {
                final /* synthetic */ d this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    androidx.fragment.app.j supportFragmentManager = this.this$0.f75774a.getSupportFragmentManager();
                    Fragment c2 = supportFragmentManager != null ? supportFragmentManager.c("FJRSeated") : null;
                    if (!(c2 instanceof b)) {
                        c2 = null;
                    }
                    b bVar = (b) c2;
                    if (bVar != null) {
                        bVar.f();
                    }
                    SeatSelectionActivity.a(this.this$0.f75774a);
                }
            });
        }
    }

    public static final /* synthetic */ void a(SeatSelectionActivity seatSelectionActivity, CJRSeat cJRSeat) {
        Context context = seatSelectionActivity;
        net.one97.paytm.o2o.movies.common.e.a(context);
        Intent intent = new Intent("action.order.session.expire");
        Object systemService = context.getSystemService("alarm");
        String str = null;
        if (!(systemService instanceof AlarmManager)) {
            systemService = null;
        }
        AlarmManager alarmManager = (AlarmManager) systemService;
        if (alarmManager != null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 868, intent, 134217728);
            long currentTimeMillis = System.currentTimeMillis() + 600000;
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(0, currentTimeMillis, broadcast);
            } else if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, currentTimeMillis, broadcast);
            } else {
                alarmManager.set(0, currentTimeMillis, broadcast);
            }
        }
        seatSelectionActivity.f75767e = cJRSeat;
        ArrayList<CJRSeat.MessageObject> sessionMessages = cJRSeat.getSessionMessages();
        if ((sessionMessages != null ? sessionMessages.size() : 0) > 0) {
            SeatMapData seatMapData = seatSelectionActivity.f75765c;
            StringBuilder sb = new StringBuilder();
            sb.append(seatSelectionActivity.getString(R.string.important));
            sb.append(10);
            ArrayList<CJRSeat.MessageObject> sessionMessages2 = cJRSeat.getSessionMessages();
            if (sessionMessages2 != null) {
                Iterable iterable = sessionMessages2;
                Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
                int i2 = 0;
                for (Object next : iterable) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    arrayList.add(i3 + ". " + ((CJRSeat.MessageObject) next).f75211b);
                    i2 = i3;
                }
                str = kotlin.a.k.a((Iterable) (List) arrayList, (CharSequence) StringUtility.NEW_LINE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
            }
            sb.append(str);
            seatMapData.setCinemaMovieInfoString(sb.toString());
        }
        if (seatSelectionActivity.f75765c.isFreeSeating()) {
            a.C1494a aVar = a.f75793a;
            kotlin.g.b.k.c(cJRSeat, "cjrSeat");
            a aVar2 = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("seat_data", cJRSeat);
            aVar2.setArguments(bundle);
            androidx.fragment.app.j supportFragmentManager = seatSelectionActivity.getSupportFragmentManager();
            if (supportFragmentManager != null) {
                supportFragmentManager.a().b(R.id.seat_selection_container, aVar2, "FJRNonSeated").b();
            }
        } else {
            b.a aVar3 = b.f75809c;
            kotlin.g.b.k.c(cJRSeat, "cjrSeat");
            b bVar = new b();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("seat_data", cJRSeat);
            bVar.setArguments(bundle2);
            androidx.fragment.app.j supportFragmentManager2 = seatSelectionActivity.getSupportFragmentManager();
            if (supportFragmentManager2 != null) {
                supportFragmentManager2.a().b(R.id.seat_selection_container, bVar, "FJRSeated").b();
            }
            seatSelectionActivity.d();
            seatSelectionActivity.b(true);
        }
        ArrayList<String> initMessages = cJRSeat.getInitMessages();
        if ((initMessages != null ? initMessages.size() : 0) > 0) {
            RoboTextView roboTextView = (RoboTextView) seatSelectionActivity.a(R.id.txt_init_message);
            kotlin.g.b.k.a((Object) roboTextView, "txt_init_message");
            ArrayList<String> initMessages2 = cJRSeat.getInitMessages();
            kotlin.g.b.k.a((Object) initMessages2, "seatData.initMessages");
            roboTextView.setText(kotlin.a.k.a((Iterable) initMessages2, (CharSequence) StringUtility.NEW_LINE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62));
            ((AppCompatImageView) seatSelectionActivity.a(R.id.close_init_message)).setOnClickListener(new b(seatSelectionActivity));
            MaterialCardView materialCardView = (MaterialCardView) seatSelectionActivity.a(R.id.layout_init_message);
            kotlin.g.b.k.a((Object) materialCardView, "layout_init_message");
            net.one97.paytm.o2o.movies.common.a.e.a(materialCardView, true);
            return;
        }
        MaterialCardView materialCardView2 = (MaterialCardView) seatSelectionActivity.a(R.id.layout_init_message);
        kotlin.g.b.k.a((Object) materialCardView2, "layout_init_message");
        net.one97.paytm.o2o.movies.common.a.e.a(materialCardView2, false);
    }

    public static final /* synthetic */ void a(SeatSelectionActivity seatSelectionActivity, net.one97.paytm.o2o.movies.common.f fVar) {
        seatSelectionActivity.b(false);
        if (fVar != null) {
            NetworkCustomError error = fVar.getError();
            String str = null;
            if ((error != null ? error.getErrorType() : null) != NetworkCustomError.ErrorType.NoConnectionError) {
                NetworkCustomError error2 = fVar.getError();
                if ((error2 != null ? error2.getErrorType() : null) != NetworkCustomError.ErrorType.NetworkError) {
                    int errorCode = fVar.getErrorCode();
                    if (errorCode == 503) {
                        String string = seatSelectionActivity.getResources().getString(R.string.title_503);
                        kotlin.g.b.k.a((Object) string, "resources.getString(R.string.title_503)");
                        String string2 = seatSelectionActivity.getResources().getString(R.string.message_503);
                        kotlin.g.b.k.a((Object) string2, "resources.getString(R.string.message_503)");
                        seatSelectionActivity.a(string, string2);
                        return;
                    } else if (errorCode == 412 && fVar.getError() != null) {
                        String alertTitle = fVar.getError().getAlertTitle();
                        kotlin.g.b.k.a((Object) alertTitle, "error.error.getAlertTitle()");
                        String alertMessage = fVar.getError().getAlertMessage();
                        kotlin.g.b.k.a((Object) alertMessage, "error.error.getAlertMessage()");
                        seatSelectionActivity.a(alertTitle, alertMessage);
                        return;
                    } else if (errorCode == 410 || errorCode == 401) {
                        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.handleError(seatSelectionActivity, fVar.getError(), (String) null, (Bundle) null, false);
                        NetworkCustomError error3 = fVar.getError();
                        if (error3 != null) {
                            String alertTitle2 = error3.getAlertTitle();
                            kotlin.g.b.k.a((Object) alertTitle2, "getAlertTitle()");
                            String alertMessage2 = error3.getAlertMessage();
                            kotlin.g.b.k.a((Object) alertMessage2, "getAlertMessage()");
                            seatSelectionActivity.a(alertTitle2, alertMessage2);
                            return;
                        }
                        return;
                    } else if (fVar.getError() != null) {
                        Context context = seatSelectionActivity;
                        CJRError error4 = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getError(context, fVar.getError());
                        if (error4 != null && !TextUtils.isEmpty(error4.getTitle()) && !TextUtils.isEmpty(error4.getMessage())) {
                            String title = error4.getTitle();
                            kotlin.g.b.k.a((Object) title, "cjrError.getTitle()");
                            String message = error4.getMessage();
                            kotlin.g.b.k.a((Object) message, "cjrError.getMessage()");
                            seatSelectionActivity.a(title, message);
                            return;
                        } else if (kotlin.m.p.a("parsing_error", fVar.getError().getMessage(), true)) {
                            CJRError dataDisplayError = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getDataDisplayError(context, fVar.getError().getUrl());
                            if (dataDisplayError != null && !TextUtils.isEmpty(dataDisplayError.getTitle()) && !TextUtils.isEmpty(dataDisplayError.getMessage())) {
                                String title2 = dataDisplayError.getTitle();
                                kotlin.g.b.k.a((Object) title2, "cjrError.getTitle()");
                                String message2 = dataDisplayError.getMessage();
                                kotlin.g.b.k.a((Object) message2, "cjrError.getMessage()");
                                seatSelectionActivity.a(title2, message2);
                                return;
                            }
                            return;
                        } else {
                            String string3 = seatSelectionActivity.getResources().getString(R.string.network_error_heading);
                            kotlin.g.b.k.a((Object) string3, "resources.getString(R.st…ng.network_error_heading)");
                            StringBuilder sb = new StringBuilder();
                            sb.append(seatSelectionActivity.getResources().getString(R.string.network_error_message));
                            sb.append(" ");
                            NetworkCustomError error5 = fVar.getError();
                            if (error5 != null) {
                                str = error5.getUrl();
                            }
                            sb.append(str);
                            seatSelectionActivity.a(string3, sb.toString());
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            seatSelectionActivity.a(true);
        }
        String string4 = seatSelectionActivity.getResources().getString(R.string.network_error_heading);
        kotlin.g.b.k.a((Object) string4, "resources.getString(R.st…ng.network_error_heading)");
        String string5 = seatSelectionActivity.getResources().getString(R.string.network_error_message);
        kotlin.g.b.k.a((Object) string5, "resources.getString(R.st…ng.network_error_message)");
        seatSelectionActivity.a(string4, string5);
    }

    public static final /* synthetic */ void a(SeatSelectionActivity seatSelectionActivity, boolean z) {
        if (z) {
            View a2 = seatSelectionActivity.a(R.id.seat_api_fail_layout);
            kotlin.g.b.k.a((Object) a2, "seat_api_fail_layout");
            net.one97.paytm.o2o.movies.common.a.e.a(a2, false);
            seatSelectionActivity.a(false);
        }
        if (z) {
            LinearLayout linearLayout = (LinearLayout) seatSelectionActivity.a(R.id.lyt_progress_bar);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            CJRDottedProgressBar cJRDottedProgressBar = (CJRDottedProgressBar) seatSelectionActivity.a(R.id.dottedProgressBar);
            if (cJRDottedProgressBar != null) {
                cJRDottedProgressBar.a();
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) seatSelectionActivity.a(R.id.lyt_progress_bar);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        CJRDottedProgressBar cJRDottedProgressBar2 = (CJRDottedProgressBar) seatSelectionActivity.a(R.id.dottedProgressBar);
        if (cJRDottedProgressBar2 != null) {
            cJRDottedProgressBar2.b();
        }
    }

    public static final /* synthetic */ void a(SeatSelectionActivity seatSelectionActivity) {
        Intent intent = new Intent(seatSelectionActivity, SeatSelectionActivity.class);
        intent.putExtra("seatmap_data", seatSelectionActivity.f75765c);
        seatSelectionActivity.startActivity(intent);
        seatSelectionActivity.finish();
    }

    public static final /* synthetic */ void c(SeatSelectionActivity seatSelectionActivity) {
        try {
            CJRMoviesSession selectedMovieSession = seatSelectionActivity.f75765c.getSelectedMovieSession();
            if (selectedMovieSession != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/" + seatSelectionActivity.f75765c.getMovieTitle() + "/seat-selection");
                String str = net.one97.paytm.o2o.movies.common.b.b.f75007b;
                kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
                String str2 = net.one97.paytm.o2o.movies.common.b.b.A;
                kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants.GT…IE_TICKETS_SEAT_SELECTION");
                hashMap.put(str, str2);
                String str3 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
                kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
                hashMap.put(str3, "Book Tickets Clicked");
                String b2 = net.one97.paytm.o2o.movies.common.d.b((Context) seatSelectionActivity);
                boolean z = false;
                if (b2 != null) {
                    if (!(b2.length() == 0)) {
                        String str4 = net.one97.paytm.o2o.movies.common.b.b.f75013h;
                        kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_5");
                        hashMap.put(str4, b2);
                    }
                }
                String movieTitle = seatSelectionActivity.f75765c.getMovieTitle();
                if (movieTitle != null) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75014i, movieTitle);
                }
                String movieCode = seatSelectionActivity.f75765c.getMovieCode();
                if (movieCode != null) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.j, movieCode);
                }
                String cinemaName = selectedMovieSession.getCinemaName();
                if (cinemaName != null) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.k, cinemaName);
                }
                String cinemaID = selectedMovieSession.getCinemaID();
                if (cinemaID != null) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.l, cinemaID);
                }
                String str5 = selectedMovieSession.getpKey();
                if (str5 != null) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.m, str5);
                }
                String movieLanguage = seatSelectionActivity.f75765c.getMovieLanguage();
                if (movieLanguage != null) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.n, movieLanguage);
                }
                ArrayList<CJRObjSeat> arrayList = seatSelectionActivity.f75768f;
                if (arrayList != null) {
                    if (arrayList.size() == 1) {
                        String str6 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
                        kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.valueOf(seatSelectionActivity.f75769g));
                        sb.append("|");
                        sb.append(seatSelectionActivity.f75765c.getMovieTitle());
                        sb.append("|");
                        sb.append(seatSelectionActivity.f75765c.getMovieCode());
                        sb.append("|");
                        sb.append(selectedMovieSession.getCinemaName());
                        sb.append("|");
                        sb.append(selectedMovieSession.getCinemaID());
                        sb.append("|");
                        sb.append(((CJRObjSeat) kotlin.a.k.d(arrayList)).getAreaDesc());
                        sb.append("|");
                        String realShowDateTime = selectedMovieSession.getRealShowDateTime();
                        kotlin.g.b.k.a((Object) realShowDateTime, "session.realShowDateTime");
                        sb.append(a(realShowDateTime));
                        hashMap.put(str6, sb.toString());
                    } else if (arrayList.size() > 1) {
                        String areaDesc = ((CJRObjSeat) kotlin.a.k.d(arrayList)).getAreaDesc();
                        kotlin.g.b.k.a((Object) areaDesc, "seats.first().getAreaDesc()");
                        Iterator<CJRObjSeat> it2 = arrayList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = true;
                                break;
                            }
                            CJRObjSeat next = it2.next();
                            kotlin.g.b.k.a((Object) next, "selectedSeat");
                            if (!kotlin.m.p.a(next.getAreaDesc(), areaDesc, true)) {
                                break;
                            }
                        }
                        if (!z || TextUtils.isEmpty(areaDesc)) {
                            String str7 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
                            kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(String.valueOf(seatSelectionActivity.f75769g));
                            sb2.append("|");
                            sb2.append(seatSelectionActivity.f75765c.getMovieTitle());
                            sb2.append("|");
                            sb2.append(seatSelectionActivity.f75765c.getMovieCode());
                            sb2.append("|");
                            sb2.append(selectedMovieSession.getCinemaName());
                            sb2.append("|");
                            sb2.append(selectedMovieSession.getCinemaID());
                            sb2.append("|");
                            String realShowDateTime2 = selectedMovieSession.getRealShowDateTime();
                            kotlin.g.b.k.a((Object) realShowDateTime2, "session.getRealShowDateTime()");
                            sb2.append(a(realShowDateTime2));
                            hashMap.put(str7, sb2.toString());
                        } else {
                            String str8 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
                            kotlin.g.b.k.a((Object) str8, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(String.valueOf(seatSelectionActivity.f75769g));
                            sb3.append("|");
                            sb3.append(seatSelectionActivity.f75765c.getMovieTitle());
                            sb3.append("|");
                            sb3.append(seatSelectionActivity.f75765c.getMovieCode());
                            sb3.append("|");
                            sb3.append(selectedMovieSession.getCinemaName());
                            sb3.append("|");
                            sb3.append(selectedMovieSession.getCinemaID());
                            sb3.append("|");
                            sb3.append(areaDesc);
                            sb3.append("|");
                            String realShowDateTime3 = selectedMovieSession.getRealShowDateTime();
                            kotlin.g.b.k.a((Object) realShowDateTime3, "session.realShowDateTime");
                            sb3.append(a(realShowDateTime3));
                            hashMap.put(str8, sb3.toString());
                        }
                    }
                }
                String str9 = net.one97.paytm.o2o.movies.common.b.b.p;
                kotlin.g.b.k.a((Object) str9, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
                String str10 = net.one97.paytm.o2o.movies.common.b.b.r;
                kotlin.g.b.k.a((Object) str10, "CJRMoviesGTMConstants.GTM_VALUE_VERTICAL_NAME");
                hashMap.put(str9, str10);
                if (com.paytm.utility.b.r((Context) seatSelectionActivity)) {
                    String str11 = net.one97.paytm.o2o.movies.common.b.b.q;
                    kotlin.g.b.k.a((Object) str11, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                    String n2 = com.paytm.utility.b.n((Context) seatSelectionActivity);
                    kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                    hashMap.put(str11, n2);
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, seatSelectionActivity);
            }
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void e(SeatSelectionActivity seatSelectionActivity) {
        Dialog dialog = new Dialog(seatSelectionActivity);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        dialog.setContentView(R.layout.custom_alertdialog);
        dialog.setCancelable(false);
        TextView textView = (TextView) dialog.findViewById(R.id.txt_dia);
        ((TextView) dialog.findViewById(R.id.okBtn)).setOnClickListener(new k(seatSelectionActivity, dialog));
        ((TextView) dialog.findViewById(R.id.cancelBtn)).setOnClickListener(new l(dialog));
        kotlin.g.b.k.a((Object) textView, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        textView.setText(seatSelectionActivity.f75765c.getCinemaMovieInfoString());
        dialog.show();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = seatSelectionActivity.getWindowManager();
        kotlin.g.b.k.a((Object) windowManager, "windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window2 = dialog.getWindow();
        layoutParams.copyFrom(window2 != null ? window2.getAttributes() : null);
        layoutParams.width = (int) (((float) i2) * 0.8f);
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            window3.setAttributes(layoutParams);
        }
    }

    public static final /* synthetic */ void f(SeatSelectionActivity seatSelectionActivity) {
        Object obj;
        Object obj2;
        Object obj3;
        CJRObjSeat cJRObjSeat;
        ArrayList<CJRMoviesSessionDetails> moviesSessionDetails;
        CJRMoviesSessionDetails cJRMoviesSessionDetails;
        CJRMoviesPriceDetails cJRMoviesPriceDetails;
        String mmFoodMandatoryMessage;
        String b2;
        SeatSelectionActivity seatSelectionActivity2 = seatSelectionActivity;
        ViewTooltip viewTooltip = seatSelectionActivity2.j;
        if (viewTooltip != null) {
            viewTooltip.f76168c.a();
        }
        RelativeLayout relativeLayout = (RelativeLayout) seatSelectionActivity2.a(R.id.proceed_to_pay_rel_lyt);
        kotlin.g.b.k.a((Object) relativeLayout, "proceed_to_pay_rel_lyt");
        relativeLayout.setEnabled(false);
        RelativeLayout relativeLayout2 = (RelativeLayout) seatSelectionActivity2.a(R.id.proceed_to_pay_rel_lyt);
        if (relativeLayout2 != null) {
            relativeLayout2.postDelayed(new g(seatSelectionActivity2), 3000);
        }
        if (seatSelectionActivity2.f75765c.isFoodMandatory() == 1) {
            ArrayList<CJRObjSeat> arrayList = seatSelectionActivity2.f75768f;
            if (arrayList == null || (cJRObjSeat = (CJRObjSeat) kotlin.a.k.e(arrayList)) == null) {
                obj2 = "quantity";
                obj = CLPConstants.ARGUMENT_KEY_POSITION;
                obj3 = "variant";
            } else {
                ArrayList<CJRObjSeat> arrayList2 = seatSelectionActivity2.f75768f;
                int size = arrayList2 != null ? arrayList2.size() : 0;
                AlertDialog create = new AlertDialog.Builder(seatSelectionActivity2).create();
                LayoutInflater layoutInflater = seatSelectionActivity.getLayoutInflater();
                kotlin.g.b.k.a((Object) layoutInflater, "this.layoutInflater");
                View inflate = layoutInflater.inflate(R.layout.lyt_food_coupons, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.food_coupon_title);
                kotlin.g.b.k.a((Object) findViewById, "dialogView.findViewById(R.id.food_coupon_title)");
                RoboTextView roboTextView = (RoboTextView) findViewById;
                View findViewById2 = inflate.findViewById(R.id.description_text);
                kotlin.g.b.k.a((Object) findViewById2, "dialogView.findViewById(R.id.description_text)");
                RoboTextView roboTextView2 = (RoboTextView) findViewById2;
                TextView textView = (TextView) inflate.findViewById(R.id.food_coupon_cancel);
                obj2 = "quantity";
                TextView textView2 = (TextView) inflate.findViewById(R.id.food_coupon_confirm);
                obj = CLPConstants.ARGUMENT_KEY_POSITION;
                CJRMoviesSession selectedMovieSession = seatSelectionActivity2.f75765c.getSelectedMovieSession();
                if (!(selectedMovieSession == null || (mmFoodMandatoryMessage = selectedMovieSession.getMmFoodMandatoryMessage()) == null || (b2 = net.one97.paytm.o2o.movies.common.a.d.b(mmFoodMandatoryMessage)) == null)) {
                    roboTextView2.setText(b2);
                }
                CJRMoviesSession selectedMovieSession2 = seatSelectionActivity2.f75765c.getSelectedMovieSession();
                double d2 = 0.0d;
                if (selectedMovieSession2 == null || (moviesSessionDetails = selectedMovieSession2.getMoviesSessionDetails()) == null || (cJRMoviesSessionDetails = (CJRMoviesSessionDetails) kotlin.a.k.e(moviesSessionDetails)) == null || (cJRMoviesPriceDetails = cJRMoviesSessionDetails.mMoviesPriceDetails) == null || cJRMoviesPriceDetails.getVoucherPrice() != 0.0d) {
                    CJRMoviesSession selectedMovieSession3 = seatSelectionActivity2.f75765c.getSelectedMovieSession();
                    if ((selectedMovieSession3 == null || !selectedMovieSession3.isTokenFeeOnly()) && cJRObjSeat != null && size > 0) {
                        obj3 = "variant";
                        d2 = (cJRObjSeat.getPrice() + cJRObjSeat.getVoucherPrice()) * ((double) size);
                    } else {
                        obj3 = "variant";
                    }
                    roboTextView.setText("Mandatory Food coupon worth Rs. ".concat(String.valueOf(d2)));
                } else {
                    obj3 = "variant";
                }
                textView.setOnClickListener(new m(create));
                textView2.setOnClickListener(new n(seatSelectionActivity2, create));
                if (create == null) {
                    kotlin.g.b.k.a();
                }
                create.setView(inflate);
                create.setCancelable(true);
                create.setCanceledOnTouchOutside(true);
                create.show();
            }
        } else {
            obj2 = "quantity";
            obj = CLPConstants.ARGUMENT_KEY_POSITION;
            obj3 = "variant";
            seatSelectionActivity.c();
        }
        try {
            CJRMoviesSession selectedMovieSession4 = seatSelectionActivity2.f75765c.getSelectedMovieSession();
            if (selectedMovieSession4 != null) {
                Map hashMap = new HashMap();
                hashMap.put("city_name", seatSelectionActivity2.f75765c.getSelectedCity());
                Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
                kotlin.g.b.k.a((Object) instance, "calendar");
                instance.setTime(selectedMovieSession4.getRealDateTime());
                String valueOf = String.valueOf(instance.get(5));
                String displayName = instance.getDisplayName(7, 0, Locale.getDefault());
                hashMap.put("day_date", displayName + ' ' + valueOf);
                hashMap.put("theatre_name", selectedMovieSession4.getCinemaName());
                hashMap.put("show_time", net.one97.paytm.o2o.movies.utils.n.c(selectedMovieSession4.getRealShowDateTime()));
                Map hashMap2 = new HashMap();
                Map hashMap3 = new HashMap();
                List arrayList3 = new ArrayList();
                Map hashMap4 = new HashMap();
                hashMap4.put("name", seatSelectionActivity2.f75765c.getMovieTitle());
                hashMap4.put("id", seatSelectionActivity2.f75765c.getMovieCode());
                hashMap4.put("price", 0);
                hashMap4.put("category", selectedMovieSession4.getCinemaName());
                hashMap4.put(CLPConstants.BRAND_PARAMS, seatSelectionActivity2.f75765c.getSelectedCity());
                Object obj4 = obj3;
                hashMap4.put(obj4, selectedMovieSession4.getScreenFormat());
                Object obj5 = obj;
                hashMap4.put(obj5, 1);
                Object obj6 = obj2;
                hashMap4.put(obj6, 1);
                arrayList3.add(hashMap4);
                Map hashMap5 = new HashMap();
                hashMap5.put("name", selectedMovieSession4.getCinemaName());
                hashMap5.put("id", selectedMovieSession4.getCinemaID());
                hashMap5.put("price", 0);
                hashMap5.put("category", selectedMovieSession4.getCinemaName());
                hashMap5.put(CLPConstants.BRAND_PARAMS, seatSelectionActivity2.f75765c.getSelectedCity());
                hashMap5.put(obj4, selectedMovieSession4.getScreenFormat());
                hashMap5.put(obj5, 1);
                hashMap5.put(obj6, Integer.valueOf(seatSelectionActivity2.f75769g));
                arrayList3.add(hashMap5);
                hashMap3.put("products", arrayList3);
                hashMap2.put("add", hashMap3);
                hashMap2.put("currencyCode", "INR");
                hashMap.put("ecommerce", hashMap2);
                hashMap.put("vertical_name", "Entertainment - Movies");
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendEnhancedEcommerceEvent("addToCart", hashMap, seatSelectionActivity2);
            }
        } catch (Exception unused) {
        }
    }
}
