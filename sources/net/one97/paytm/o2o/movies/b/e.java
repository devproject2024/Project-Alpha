package net.one97.paytm.o2o.movies.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alipay.iap.android.webapp.sdk.api.Constants;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRGroupedSeats;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjArea;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat;
import net.one97.paytm.o2o.movies.d.h;
import net.one97.paytm.o2o.movies.d.k;
import net.one97.paytm.o2o.movies.d.l;
import net.one97.paytm.o2o.movies.d.m;
import net.one97.paytm.o2o.movies.utils.CJRSeatCustomView;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.widget.BirdRectView;
import net.one97.paytm.o2o.movies.widget.BirdView;
import net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout;
import net.one97.paytm.o2o.movies.widget.ObervableVerticalScrollView;
import net.one97.paytm.o2o.movies.widget.ObservableHorizontalScrollView;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public final class e implements View.OnClickListener, k, m {
    private int A;
    /* access modifiers changed from: private */
    public int B;
    private int C;
    /* access modifiers changed from: private */
    public long D;
    /* access modifiers changed from: private */
    public String E;
    private boolean F = true;
    private int G;
    private int H;
    private l I = new l() {
        public final void onScrollChanged(View view, int i2, int i3, int i4, int i5, boolean z) {
            e.this.a(view, i2, i3, i4, i5, z);
        }
    };
    private final int J = 30;
    private float K;
    private float L;
    private float M;
    private float N;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRObjSeat> f74918a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f74919b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f74920c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ObervableVerticalScrollView f74921d;

    /* renamed from: e  reason: collision with root package name */
    private int f74922e;

    /* renamed from: f  reason: collision with root package name */
    private int f74923f;

    /* renamed from: g  reason: collision with root package name */
    private int f74924g;

    /* renamed from: h  reason: collision with root package name */
    private int f74925h;

    /* renamed from: i  reason: collision with root package name */
    private int f74926i;
    private int j;
    /* access modifiers changed from: private */
    public h k;
    private HashMap<String, TextView> l;
    /* access modifiers changed from: private */
    public CJRMoviesSession m;
    private CJRSeatCustomView n;
    private ArrayList<ArrayList<CJRGroupedSeats>> o;
    /* access modifiers changed from: private */
    public Handler p;
    /* access modifiers changed from: private */
    public InterceptTouchLinearLayout q;
    /* access modifiers changed from: private */
    public ArrayList<ObservableHorizontalScrollView> r = new ArrayList<>();
    private int s = 20;
    private BirdView t;
    private int u;
    /* access modifiers changed from: private */
    public BirdRectView v;
    /* access modifiers changed from: private */
    public int w;
    private int x;
    /* access modifiers changed from: private */
    public int y;
    private int z;

    public e(Activity activity, String str, h hVar, ObervableVerticalScrollView obervableVerticalScrollView, CJRMoviesSession cJRMoviesSession, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        this.f74920c = activity;
        this.E = str;
        this.f74921d = obervableVerticalScrollView;
        obervableVerticalScrollView.setVerticalScrollListener(this);
        this.k = hVar;
        this.m = cJRMoviesSession;
        this.f74918a = new ArrayList<>();
        this.l = new HashMap<>();
        this.p = new Handler() {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1234) {
                    long currentTimeMillis = System.currentTimeMillis() - e.this.D;
                    if (currentTimeMillis >= 500) {
                        long unused = e.this.D = 0;
                        e.this.f74919b.animate().translationY(0.0f).setListener(new AnimatorListenerAdapter() {
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                e.this.f74919b.setVisibility(4);
                            }
                        });
                        return;
                    }
                    e.this.p.sendEmptyMessageDelayed(1234, 500 - currentTimeMillis);
                }
            }
        };
        this.q = (InterceptTouchLinearLayout) linearLayout;
        this.f74919b = relativeLayout;
        this.f74921d.setInterceptTouchListener(this);
        Resources resources = this.f74920c.getResources();
        this.f74922e = resources.getDimensionPixelSize(R.dimen.movie_seat_layout_seat_size);
        this.f74923f = resources.getDimensionPixelOffset(R.dimen.movie_seat_layout_seat_padding);
        this.f74924g = resources.getDimensionPixelOffset(R.dimen.seat_layout_seat_padding);
        this.f74925h = resources.getDimensionPixelSize(R.dimen.movie_seat_layout_row_padding_left);
        this.f74926i = resources.getDimensionPixelOffset(R.dimen.movie_seat_layout_area_description_padding);
        this.u = (int) TypedValue.applyDimension(1, 0.5f, this.f74920c.getResources().getDisplayMetrics());
        this.j = (int) TypedValue.applyDimension(1, 4.0f, this.f74920c.getResources().getDisplayMetrics());
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x0305  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            if (r1 == 0) goto L_0x0382
            net.one97.paytm.o2o.movies.common.movies.seats.CJRSeatLayout r2 = r21.getSeatLayout()
            if (r2 == 0) goto L_0x0382
            net.one97.paytm.o2o.movies.common.movies.seats.CJRSeatLayout r2 = r21.getSeatLayout()
            net.one97.paytm.o2o.movies.common.movies.seats.CJRColAreas r2 = r2.getColAreas()
            if (r2 == 0) goto L_0x0382
            net.one97.paytm.o2o.movies.common.movies.seats.CJRSeatLayout r2 = r21.getSeatLayout()
            net.one97.paytm.o2o.movies.common.movies.seats.CJRColAreas r2 = r2.getColAreas()
            java.util.ArrayList r2 = r2.getObjArea()
            if (r2 == 0) goto L_0x0382
            net.one97.paytm.o2o.movies.common.movies.seats.CJRSeatLayout r2 = r21.getSeatLayout()
            net.one97.paytm.o2o.movies.common.movies.seats.CJRColAreas r2 = r2.getColAreas()
            java.util.ArrayList r2 = r2.getObjArea()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0382
            net.one97.paytm.o2o.movies.common.movies.seats.CJRSeatLayout r2 = r21.getSeatLayout()
            net.one97.paytm.o2o.movies.common.movies.seats.CJRColAreas r2 = r2.getColAreas()
            java.util.ArrayList r2 = r2.getObjArea()
            java.util.ArrayList r3 = r21.getGroupedSeats()
            if (r3 == 0) goto L_0x0058
            java.util.ArrayList r3 = r21.getGroupedSeats()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0058
            java.util.ArrayList r3 = r21.getGroupedSeats()
            r0.o = r3
        L_0x0058:
            r3 = 0
            r4 = 0
        L_0x005a:
            int r5 = r2.size()
            r6 = 1
            if (r4 >= r5) goto L_0x00e6
            java.lang.Object r5 = r2.get(r4)
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjArea r5 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjArea) r5
            java.lang.String r7 = r5.getAreaCode()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails r7 = r0.a((java.lang.String) r7)
            if (r7 == 0) goto L_0x00e2
            if (r5 == 0) goto L_0x00e2
            java.util.ArrayList r7 = r5.getObjRow()
            if (r7 == 0) goto L_0x00e2
            java.util.ArrayList r7 = r5.getObjRow()
            int r7 = r7.size()
            if (r7 <= 0) goto L_0x00e2
            java.util.ArrayList r5 = r5.getObjRow()
            int r7 = r0.A
            int r7 = r7 + r6
            r0.A = r7
            java.util.Iterator r5 = r5.iterator()
        L_0x0090:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e2
            java.lang.Object r7 = r5.next()
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow r7 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow) r7
            if (r7 == 0) goto L_0x0090
            java.util.ArrayList r8 = r7.getObjSeat()
            if (r8 == 0) goto L_0x0090
            java.util.ArrayList r8 = r7.getObjSeat()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x0090
            int r8 = r0.B
            int r8 = r8 + r6
            r0.B = r8
            java.util.ArrayList r7 = r7.getObjSeat()
            net.one97.paytm.o2o.movies.b.-$$Lambda$e$Nw3EpPYpB4uD5rUOOuM31cFHBHU r8 = net.one97.paytm.o2o.movies.b.$$Lambda$e$Nw3EpPYpB4uD5rUOOuM31cFHBHU.INSTANCE
            java.util.Collections.sort(r7, r8)
            java.lang.Object r8 = r7.get(r3)
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat r8 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat) r8
            int r8 = r8.getGridSeatNum()
            int r9 = r0.s
            if (r8 >= r9) goto L_0x00cc
            r0.s = r8
        L_0x00cc:
            int r8 = r7.size()
            int r8 = r8 - r6
            java.lang.Object r7 = r7.get(r8)
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat r7 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat) r7
            int r7 = r7.getGridSeatNum()
            int r8 = r0.C
            if (r7 <= r8) goto L_0x0090
            r0.C = r7
            goto L_0x0090
        L_0x00e2:
            int r4 = r4 + 1
            goto L_0x005a
        L_0x00e6:
            int r4 = r0.s
            r5 = 2
            if (r4 < r5) goto L_0x00f1
            int r7 = r0.C
            int r4 = r4 - r6
            int r7 = r7 - r4
            r0.C = r7
        L_0x00f1:
            r4 = 0
        L_0x00f2:
            int r7 = r2.size()
            if (r4 >= r7) goto L_0x0341
            java.lang.Object r7 = r2.get(r4)
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjArea r7 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjArea) r7
            if (r7 == 0) goto L_0x0335
            java.util.ArrayList r8 = r7.getObjRow()
            if (r8 == 0) goto L_0x0335
            java.util.ArrayList r8 = r7.getObjRow()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x0335
            java.lang.String r8 = r7.getAreaCode()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails r8 = r0.a((java.lang.String) r8)
            if (r8 == 0) goto L_0x0335
            android.widget.TextView r9 = new android.widget.TextView
            android.app.Activity r10 = r0.f74920c
            r9.<init>(r10)
            android.app.Activity r10 = r0.f74920c
            int r11 = net.one97.paytm.o2o.movies.R.color.movie_area_description_color
            int r10 = net.one97.paytm.o2o.movies.utils.n.b((android.content.Context) r10, (int) r11)
            r9.setTextColor(r10)
            r10 = 1096810496(0x41600000, float:14.0)
            r9.setTextSize(r5, r10)
            int r10 = r0.f74925h
            int r11 = r0.f74926i
            int r12 = r0.j
            r9.setPadding(r10, r11, r11, r12)
            java.lang.String r10 = "AREA_TITLE_TAG"
            r9.setTag(r10)
            r10 = 0
            int r11 = com.paytm.utility.b.d()     // Catch:{ Exception -> 0x0156 }
            r12 = 14
            if (r11 < r12) goto L_0x0152
            java.lang.String r11 = "sans-serif-medium"
            android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r3)     // Catch:{ Exception -> 0x0156 }
            r9.setTypeface(r11)     // Catch:{ Exception -> 0x0156 }
            goto L_0x0157
        L_0x0152:
            r9.setTypeface(r10, r3)     // Catch:{ Exception -> 0x0156 }
            goto L_0x0157
        L_0x0156:
        L_0x0157:
            r11 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r8 == 0) goto L_0x0169
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r13 = r8.getMoviesPriceDetails()
            if (r13 == 0) goto L_0x0169
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r11 = r8.getMoviesPriceDetails()
            double r11 = r11.getPrice()
        L_0x0169:
            r13 = 0
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x01a7
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r14 = r8.getMoviesPriceDetails()
            java.lang.String r14 = r14.getTypeDescription()
            java.lang.String r14 = net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r14)
            r13.append(r14)
            java.lang.String r14 = " : "
            r13.append(r14)
            android.app.Activity r14 = r0.f74920c
            int r15 = net.one97.paytm.o2o.movies.R.string.rupees
            java.lang.String r14 = r14.getString(r15)
            r13.append(r14)
            java.lang.String r14 = " "
            r13.append(r14)
            java.lang.String r11 = com.paytm.utility.b.a((double) r11)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r9.setText(r11)
            goto L_0x01b2
        L_0x01a7:
            android.app.Activity r11 = r0.f74920c
            int r12 = net.one97.paytm.o2o.movies.R.string.normal
            java.lang.String r11 = r11.getString(r12)
            r9.setText(r11)
        L_0x01b2:
            android.widget.TableLayout$LayoutParams r11 = new android.widget.TableLayout$LayoutParams
            r12 = -1
            r13 = -2
            r11.<init>(r12, r13)
            r9.setLayoutParams(r11)
            r11 = 17
            r9.setGravity(r11)
            net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout r14 = r0.q
            r14.addView(r9)
            android.view.View r9 = new android.view.View
            android.app.Activity r14 = r0.f74920c
            r9.<init>(r14)
            android.widget.TableLayout$LayoutParams r14 = new android.widget.TableLayout$LayoutParams
            int r15 = r0.u
            r14.<init>(r12, r15)
            r12 = 45
            int r15 = r0.f74926i
            r14.setMargins(r12, r3, r3, r15)
            r9.setLayoutParams(r14)
            android.app.Activity r12 = r0.f74920c
            int r14 = net.one97.paytm.o2o.movies.R.color.movie_sep_color
            int r12 = net.one97.paytm.o2o.movies.utils.n.b((android.content.Context) r12, (int) r14)
            r9.setBackgroundColor(r12)
            net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout r12 = r0.q
            r12.addView(r9)
            android.app.Activity r9 = r0.f74920c
            android.view.LayoutInflater r9 = r9.getLayoutInflater()
            int r12 = net.one97.paytm.o2o.movies.R.layout.movie_seat_lyt
            android.view.View r9 = r9.inflate(r12, r10)
            int r10 = net.one97.paytm.o2o.movies.R.id.row_Id_Lyt
            android.view.View r10 = r9.findViewById(r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            int r12 = net.one97.paytm.o2o.movies.R.id.seats_lyt
            android.view.View r12 = r9.findViewById(r12)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            int r14 = net.one97.paytm.o2o.movies.R.id.seats_parent_lyt
            android.view.View r14 = r9.findViewById(r14)
            net.one97.paytm.o2o.movies.widget.ObservableHorizontalScrollView r14 = (net.one97.paytm.o2o.movies.widget.ObservableHorizontalScrollView) r14
            net.one97.paytm.o2o.movies.d.l r15 = r0.I
            r14.setScrollViewListener(r15)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r4)
            r14.setTag(r15)
            java.util.ArrayList r15 = r7.getObjRow()
            java.util.Iterator r16 = r15.iterator()
            r17 = 0
        L_0x0228:
            boolean r18 = r16.hasNext()
            if (r18 == 0) goto L_0x0327
            java.lang.Object r18 = r16.next()
            r11 = r18
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow r11 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow) r11
            android.widget.LinearLayout r5 = new android.widget.LinearLayout
            android.app.Activity r6 = r0.f74920c
            r5.<init>(r6)
            android.widget.TableLayout$LayoutParams r6 = new android.widget.TableLayout$LayoutParams
            r6.<init>(r13, r13)
            r5.setLayoutParams(r6)
            r5.setOrientation(r3)
            if (r11 == 0) goto L_0x0316
            java.util.ArrayList r6 = r11.getObjSeat()
            if (r6 == 0) goto L_0x0316
            java.util.ArrayList r6 = r11.getObjSeat()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x0316
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r3 = r7.getAreaDesc()
            r6.append(r3)
            java.lang.String r3 = r11.getPhyRowId()
            r6.append(r3)
            int r3 = r11.getGridRowId()
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto L_0x0281
            r5.setTag(r3)
        L_0x0281:
            if (r17 <= 0) goto L_0x02cd
            int r3 = r17 + -1
            java.lang.Object r3 = r15.get(r3)     // Catch:{ Exception -> 0x02cd }
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow r3 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow) r3     // Catch:{ Exception -> 0x02cd }
            int r6 = r11.getGridRowId()     // Catch:{ Exception -> 0x02cd }
            int r3 = r3.getGridRowId()     // Catch:{ Exception -> 0x02cd }
            int r6 = r6 - r3
            r3 = 1
            if (r6 <= r3) goto L_0x02cd
            int r6 = r0.B     // Catch:{ Exception -> 0x02cd }
            int r6 = r6 + r3
            r0.B = r6     // Catch:{ Exception -> 0x02cd }
            android.widget.LinearLayout r6 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x02cd }
            android.app.Activity r3 = r0.f74920c     // Catch:{ Exception -> 0x02cd }
            r6.<init>(r3)     // Catch:{ Exception -> 0x02cd }
            android.widget.TableLayout$LayoutParams r3 = new android.widget.TableLayout$LayoutParams     // Catch:{ Exception -> 0x02cd }
            int r13 = r0.f74922e     // Catch:{ Exception -> 0x02cd }
            r19 = r2
            int r2 = r0.f74922e     // Catch:{ Exception -> 0x02cb }
            r3.<init>(r13, r2)     // Catch:{ Exception -> 0x02cb }
            r6.setLayoutParams(r3)     // Catch:{ Exception -> 0x02cb }
            r12.addView(r6)     // Catch:{ Exception -> 0x02cb }
            android.widget.LinearLayout r2 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x02cb }
            android.app.Activity r3 = r0.f74920c     // Catch:{ Exception -> 0x02cb }
            r2.<init>(r3)     // Catch:{ Exception -> 0x02cb }
            android.widget.TableLayout$LayoutParams r3 = new android.widget.TableLayout$LayoutParams     // Catch:{ Exception -> 0x02cb }
            int r6 = r0.f74922e     // Catch:{ Exception -> 0x02cb }
            int r13 = r0.f74922e     // Catch:{ Exception -> 0x02cb }
            r3.<init>(r6, r13)     // Catch:{ Exception -> 0x02cb }
            r2.setLayoutParams(r3)     // Catch:{ Exception -> 0x02cb }
            r10.addView(r2)     // Catch:{ Exception -> 0x02cb }
            goto L_0x02cf
        L_0x02cb:
            goto L_0x02cf
        L_0x02cd:
            r19 = r2
        L_0x02cf:
            android.widget.TextView r2 = new android.widget.TextView
            android.app.Activity r3 = r0.f74920c
            r2.<init>(r3)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            int r6 = r0.f74922e
            r3.<init>(r6, r6)
            r2.setLayoutParams(r3)
            android.app.Activity r3 = r0.f74920c
            int r6 = net.one97.paytm.o2o.movies.R.color.movie_phy_row_id_color
            int r3 = net.one97.paytm.o2o.movies.utils.n.b((android.content.Context) r3, (int) r6)
            r2.setTextColor(r3)
            r3 = 1094713344(0x41400000, float:12.0)
            r6 = 2
            r2.setTextSize(r6, r3)
            r3 = 17
            r2.setGravity(r3)
            java.lang.String r13 = "isDescription"
            r2.setTag(r13)
            java.lang.String r13 = r11.getPhyRowId()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x030c
            java.lang.String r13 = r11.getPhyRowId()
            r2.setText(r13)
        L_0x030c:
            r10.addView(r2)
            r0.a(r11, r7, r8, r5)
            r12.addView(r5)
            goto L_0x031b
        L_0x0316:
            r19 = r2
            r3 = 17
            r6 = 2
        L_0x031b:
            int r17 = r17 + 1
            r2 = r19
            r3 = 0
            r5 = 2
            r6 = 1
            r11 = 17
            r13 = -2
            goto L_0x0228
        L_0x0327:
            r19 = r2
            r6 = 2
            net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout r2 = r0.q
            r2.addView(r9)
            java.util.ArrayList<net.one97.paytm.o2o.movies.widget.ObservableHorizontalScrollView> r2 = r0.r
            r2.add(r14)
            goto L_0x0338
        L_0x0335:
            r19 = r2
            r6 = 2
        L_0x0338:
            int r4 = r4 + 1
            r2 = r19
            r3 = 0
            r5 = 2
            r6 = 1
            goto L_0x00f2
        L_0x0341:
            net.one97.paytm.o2o.movies.d.h r2 = r0.k
            if (r2 == 0) goto L_0x035c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r0.H
            r3.append(r4)
            java.lang.String r4 = "/"
            r3.append(r4)
            int r4 = r0.G
            r3.append(r4)
            r2.e()
        L_0x035c:
            int r2 = r20.b()
            r0.b((int) r2)
            r20.b()
            net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout r2 = r0.q
            android.view.ViewTreeObserver r2 = r2.getViewTreeObserver()
            net.one97.paytm.o2o.movies.b.e$3 r3 = new net.one97.paytm.o2o.movies.b.e$3
            r3.<init>()
            r2.addOnGlobalLayoutListener(r3)
            net.one97.paytm.o2o.movies.widget.ObervableVerticalScrollView r2 = r0.f74921d
            android.view.ViewTreeObserver r2 = r2.getViewTreeObserver()
            net.one97.paytm.o2o.movies.b.e$2 r3 = new net.one97.paytm.o2o.movies.b.e$2
            r3.<init>(r1)
            r2.addOnGlobalLayoutListener(r3)
        L_0x0382:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.e.a(net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int b(CJRObjSeat cJRObjSeat, CJRObjSeat cJRObjSeat2) {
        return cJRObjSeat.getGridSeatNum() - cJRObjSeat2.getGridSeatNum();
    }

    private void b(int i2) {
        ArrayList<ObservableHorizontalScrollView> arrayList = this.r;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < this.r.size(); i3++) {
                this.r.get(i3).getChildAt(0).setPadding(0, 0, i2 - this.r.get(i3).getChildAt(0).getMeasuredWidth(), 0);
            }
        }
    }

    private int b() {
        ArrayList<ObservableHorizontalScrollView> arrayList = this.r;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            n.a(this.r.get(i3).getChildAt(0));
            if (this.r.get(i3).getChildAt(0).getMeasuredWidth() > i2) {
                i2 = this.r.get(i3).getChildAt(0).getMeasuredWidth();
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, final int i2, int i3, int i4, int i5, boolean z2) {
        ArrayList<ObservableHorizontalScrollView> arrayList = this.r;
        if (arrayList != null && arrayList.size() > 0 && z2) {
            for (final int i6 = 0; i6 < this.r.size(); i6++) {
                if (((Integer) view.getTag()).intValue() != i6) {
                    new Handler().post(new Runnable() {
                        public final void run() {
                            new StringBuilder("position is ").append(i2);
                            b.j();
                            ((ObservableHorizontalScrollView) e.this.r.get(i6)).scrollTo(i2, 0);
                        }
                    });
                }
            }
            BirdRectView birdRectView = this.v;
            if (birdRectView != null) {
                birdRectView.f76108c = (int) ((((float) i2) / ((float) this.x)) * ((float) this.z));
                int width = birdRectView.getWidth() - birdRectView.f76107b;
                if (birdRectView.f76108c < 0) {
                    birdRectView.f76108c = 0;
                } else if (birdRectView.f76108c > width) {
                    birdRectView.f76108c = width;
                }
                birdRectView.invalidate();
            }
        }
    }

    private void a(CJRObjRow cJRObjRow, CJRObjArea cJRObjArea, CJRMoviesSessionDetails cJRMoviesSessionDetails, LinearLayout linearLayout) {
        boolean z2 = cJRMoviesSessionDetails == null || cJRMoviesSessionDetails.getMoviesPriceDetails() == null || cJRMoviesSessionDetails.getMoviesPriceDetails().getPrice() < 0.0d;
        ArrayList<CJRObjSeat> objSeat = cJRObjRow.getObjSeat();
        this.G += objSeat.size();
        int i2 = this.s - 1;
        Iterator<CJRObjSeat> it2 = objSeat.iterator();
        while (it2.hasNext()) {
            CJRObjSeat next = it2.next();
            if (next != null && next.getGridSeatNum() >= 0) {
                if (!(cJRMoviesSessionDetails == null || cJRMoviesSessionDetails.getMoviesPriceDetails() == null)) {
                    next.setPrice(cJRMoviesSessionDetails.getMoviesPriceDetails().getPrice());
                    next.setTypeCode(cJRMoviesSessionDetails.getMoviesPriceDetails().getTypeCode());
                    next.setVoucherPrice(cJRMoviesSessionDetails.getMoviesPriceDetails().getVoucherPrice());
                }
                next.setGridSeatRowId(cJRObjRow.getGridRowId());
                next.setPhyRowId(cJRObjRow.getPhyRowId());
                next.setGridSeatAreaNum(cJRObjArea.getAreaNum());
                next.setAreaCode(cJRObjArea.getAreaCode());
                next.setAreaDesc(cJRObjArea.getAreaDesc());
                int gridSeatNum = next.getGridSeatNum();
                int i3 = gridSeatNum - i2;
                if (i3 > 1) {
                    for (int i4 = 0; i4 < i3 - 1; i4++) {
                        Space space = new Space(this.f74920c);
                        int i5 = this.f74922e;
                        space.setLayoutParams(new LinearLayout.LayoutParams(i5, i5));
                        linearLayout.addView(space);
                    }
                }
                CJRSeatCustomView cJRSeatCustomView = new CJRSeatCustomView(this.f74920c);
                int i6 = this.f74922e;
                cJRSeatCustomView.setLayoutParams(new LinearLayout.LayoutParams(i6, i6));
                cJRSeatCustomView.setTextColor(n.b((Context) this.f74920c, R.color.white));
                cJRSeatCustomView.setTextSize(2, 10.0f);
                cJRSeatCustomView.setGravity(17);
                int i7 = this.f74923f;
                cJRSeatCustomView.setPadding(i7, i7, i7, i7);
                cJRSeatCustomView.setBackground(this.f74920c.getResources().getDrawable(R.drawable.layout_seat_bg));
                cJRSeatCustomView.setClickable(true);
                cJRSeatCustomView.setOnClickListener(this);
                cJRSeatCustomView.setObjSeat(next);
                String str = cJRObjArea.getAreaDesc() + cJRObjRow.getGridRowId() + cJRObjRow.getPhyRowId() + next.getGridSeatNum();
                if (!TextUtils.isEmpty(str)) {
                    cJRSeatCustomView.setTag(str);
                }
                if (z2) {
                    cJRSeatCustomView.setEnabled(false);
                    next.setSeatStatus("5");
                    linearLayout.addView(cJRSeatCustomView);
                } else if (TextUtils.isEmpty(next.getSeatStatus())) {
                    cJRSeatCustomView.setEnabled(false);
                    linearLayout.addView(cJRSeatCustomView);
                } else if (next.getSeatStatus().equalsIgnoreCase("0")) {
                    cJRSeatCustomView.setEnabled(true);
                    linearLayout.addView(cJRSeatCustomView);
                    this.H++;
                } else if (next.getSeatStatus().equalsIgnoreCase(Constants.RESULT_STATUS_SUCCESS)) {
                    cJRSeatCustomView.setEnabled(true);
                    RelativeLayout relativeLayout = new RelativeLayout(this.f74920c);
                    int i8 = this.f74922e;
                    relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(i8, i8));
                    AppCompatImageView appCompatImageView = new AppCompatImageView(this.f74920c);
                    int i9 = this.f74922e;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i9 - 1, i9 - 1);
                    int i10 = this.f74923f;
                    layoutParams.setMargins(i10, i10, i10, i10);
                    appCompatImageView.setLayoutParams(layoutParams);
                    appCompatImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    appCompatImageView.setBackgroundResource(net.one97.paytm.common.assets.R.drawable.movie_seat_bg);
                    appCompatImageView.setBackgroundResource(R.drawable.ic_disabled_friendly);
                    relativeLayout.addView(cJRSeatCustomView);
                    relativeLayout.addView(appCompatImageView);
                    linearLayout.addView(relativeLayout);
                    this.H++;
                } else if (next.getSeatStatus().equalsIgnoreCase("1001")) {
                    cJRSeatCustomView.setEnabled(true);
                    RelativeLayout relativeLayout2 = new RelativeLayout(this.f74920c);
                    int i11 = this.f74922e;
                    relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(i11, i11));
                    AppCompatImageView appCompatImageView2 = new AppCompatImageView(this.f74920c);
                    int i12 = this.f74922e;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i12 - 1, i12 - 1);
                    int i13 = this.f74923f;
                    layoutParams2.setMargins(i13, i13, i13, i13);
                    appCompatImageView2.setLayoutParams(layoutParams2);
                    appCompatImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    appCompatImageView2.setBackgroundResource(net.one97.paytm.common.assets.R.drawable.movie_seat_bg);
                    appCompatImageView2.setBackgroundResource(R.drawable.ic_wheel_companion);
                    relativeLayout2.addView(cJRSeatCustomView);
                    relativeLayout2.addView(appCompatImageView2);
                    linearLayout.addView(relativeLayout2);
                    this.H++;
                } else if (next.getSeatStatus().equalsIgnoreCase("1002")) {
                    cJRSeatCustomView.setEnabled(false);
                    cJRSeatCustomView.setBackground((Drawable) null);
                    RelativeLayout relativeLayout3 = new RelativeLayout(this.f74920c);
                    int i14 = this.f74922e;
                    relativeLayout3.setLayoutParams(new RelativeLayout.LayoutParams(i14, i14));
                    AppCompatImageView appCompatImageView3 = new AppCompatImageView(this.f74920c);
                    int i15 = this.f74922e;
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i15 - 1, i15 - 1);
                    int i16 = this.f74924g;
                    layoutParams3.setMargins(i16, i16, i16, i16);
                    appCompatImageView3.setLayoutParams(layoutParams3);
                    appCompatImageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                    appCompatImageView3.setBackgroundResource(R.drawable.ic_blocked_seat);
                    relativeLayout3.addView(cJRSeatCustomView);
                    relativeLayout3.addView(appCompatImageView3);
                    linearLayout.addView(relativeLayout3);
                    this.H++;
                } else {
                    cJRSeatCustomView.setEnabled(false);
                    linearLayout.addView(cJRSeatCustomView);
                }
                i2 = gridSeatNum;
            }
        }
        View view = new View(this.f74920c);
        view.setLayoutParams(new TableRow.LayoutParams(this.f74925h, this.f74922e));
        linearLayout.addView(view);
    }

    public final void onClick(View view) {
        if (this.F) {
            a(view, false, false);
        }
    }

    private void a(View view, boolean z2, boolean z3) {
        h hVar;
        this.n = (CJRSeatCustomView) view;
        if (this.n.getTag() != null) {
            CJRObjSeat objSeat = this.n.getObjSeat();
            ArrayList<CJRObjSeat> arrayList = this.f74918a;
            int i2 = 0;
            if (arrayList != null && arrayList.size() > 0 && (!this.f74918a.get(0).getAreaCode().equalsIgnoreCase(objSeat.getAreaCode()) || !this.f74918a.get(0).getGridSeatAreaNum().equalsIgnoreCase(objSeat.getGridSeatAreaNum()))) {
                if (z2) {
                    e();
                } else {
                    a((View) this.n, objSeat);
                    return;
                }
            }
            CJRMoviesSession cJRMoviesSession = this.m;
            int maxTickets = cJRMoviesSession != null ? cJRMoviesSession.getMaxTickets() : 0;
            if (this.n.isSelected() || maxTickets <= 0 || this.f74918a.size() < maxTickets) {
                if (this.n.isSelected()) {
                    this.f74918a.remove(objSeat);
                    objSeat.setSelected(false);
                    this.l.remove(objSeat.getUniqueId());
                    this.n.setSelected(false);
                    this.n.setText("");
                    if (this.n.getObjSeat().getSeatStatus().equalsIgnoreCase("1001") || this.n.getObjSeat().getSeatStatus().equalsIgnoreCase(Constants.RESULT_STATUS_SUCCESS)) {
                        RelativeLayout relativeLayout = (RelativeLayout) this.n.getParent();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= relativeLayout.getChildCount()) {
                                break;
                            }
                            View childAt = relativeLayout.getChildAt(i3);
                            if (childAt instanceof AppCompatImageView) {
                                childAt.setVisibility(0);
                                break;
                            }
                            i3++;
                        }
                        Iterator<CJRObjSeat> it2 = this.f74918a.iterator();
                        while (it2.hasNext()) {
                            CJRObjSeat next = it2.next();
                            if (next.getSeatStatus().equalsIgnoreCase(Constants.RESULT_STATUS_SUCCESS) || next.getSeatStatus().equalsIgnoreCase("1001")) {
                                i2++;
                            }
                        }
                        if (i2 == 0 && (hVar = this.k) != null) {
                            hVar.c();
                        }
                    }
                } else {
                    this.f74918a.add(objSeat);
                    this.l.put(objSeat.getUniqueId(), this.n);
                    objSeat.setSelected(true);
                    this.n.setSelected(true);
                    h hVar2 = this.k;
                    if (hVar2 != null) {
                        hVar2.d();
                    }
                    if (this.n.getObjSeat().getSeatStatus().equalsIgnoreCase("1001") || this.n.getObjSeat().getSeatStatus().equalsIgnoreCase(Constants.RESULT_STATUS_SUCCESS)) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) this.n.getParent();
                        while (true) {
                            if (i2 >= relativeLayout2.getChildCount()) {
                                break;
                            }
                            View childAt2 = relativeLayout2.getChildAt(i2);
                            if (childAt2 instanceof AppCompatImageView) {
                                childAt2.setVisibility(8);
                                break;
                            }
                            i2++;
                        }
                        h hVar3 = this.k;
                        if (hVar3 != null) {
                            hVar3.a(Integer.parseInt(this.n.getObjSeat().getSeatStatus()));
                        }
                    }
                }
                if (!z3) {
                    a(objSeat);
                }
                c();
                this.p.post(new Runnable() {
                    public final void run() {
                        if (e.this.k != null) {
                            e.this.k.a((ArrayList<CJRObjSeat>) e.this.f74918a);
                        }
                    }
                });
                BirdView birdView = this.t;
                if (birdView != null) {
                    birdView.invalidate();
                }
                if (objSeat.getSeatStatus() != null && !objSeat.getSeatStatus().equalsIgnoreCase(Constants.RESULT_STATUS_SUCCESS)) {
                    objSeat.getSeatStatus().equalsIgnoreCase("1001");
                    return;
                }
                return;
            }
            h hVar4 = this.k;
            if (hVar4 != null) {
                hVar4.b();
            }
        }
    }

    private void a(CJRObjSeat cJRObjSeat) {
        try {
            int gridSeatNum = cJRObjSeat.getGridSeatNum();
            String gridSeatAreaNum = cJRObjSeat.getGridSeatAreaNum();
            int gridSeatRowId = cJRObjSeat.getGridSeatRowId();
            if (this.o != null) {
                Iterator<ArrayList<CJRGroupedSeats>> it2 = this.o.iterator();
                while (it2.hasNext()) {
                    ArrayList next = it2.next();
                    Iterator it3 = next.iterator();
                    while (it3.hasNext()) {
                        CJRGroupedSeats cJRGroupedSeats = (CJRGroupedSeats) it3.next();
                        String areaNum = cJRGroupedSeats.getAreaNum();
                        int gridRowId = cJRGroupedSeats.getGridRowId();
                        int gridSeatNum2 = cJRGroupedSeats.getGridSeatNum();
                        if (!TextUtils.isEmpty(areaNum) && !TextUtils.isEmpty(gridSeatAreaNum) && gridSeatAreaNum.equalsIgnoreCase(areaNum) && gridSeatRowId > 0 && gridRowId > 0 && gridSeatRowId == gridRowId && gridSeatNum > 0 && gridSeatNum2 > 0 && gridSeatNum == gridSeatNum2) {
                            a((ArrayList<CJRGroupedSeats>) next, cJRObjSeat);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a(ArrayList<CJRGroupedSeats> arrayList, CJRObjSeat cJRObjSeat) {
        LinearLayout linearLayout;
        String areaDesc = cJRObjSeat.getAreaDesc();
        String phyRowId = cJRObjSeat.getPhyRowId();
        int gridSeatRowId = cJRObjSeat.getGridSeatRowId();
        int gridSeatNum = cJRObjSeat.getGridSeatNum();
        Iterator<CJRGroupedSeats> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int gridSeatNum2 = it2.next().getGridSeatNum();
            if (gridSeatNum2 > 0) {
                String str = areaDesc + phyRowId + gridSeatRowId;
                if (!(this.q == null || TextUtils.isEmpty(str) || (linearLayout = (LinearLayout) this.q.findViewWithTag(str)) == null || gridSeatNum == gridSeatNum2)) {
                    TextView textView = (TextView) linearLayout.findViewWithTag(areaDesc + gridSeatRowId + phyRowId + gridSeatNum2);
                    if (textView != null) {
                        a((View) textView, false, true);
                    }
                }
            }
        }
    }

    private void c() {
        Collections.sort(this.f74918a, $$Lambda$e$zMh_Lhc8tjxX5p50XsgnlMAVXk.INSTANCE);
        for (int i2 = 0; i2 < this.f74918a.size(); i2++) {
            TextView textView = this.l.get(this.f74918a.get(i2).getUniqueId());
            if (textView != null) {
                textView.setText(String.valueOf(i2 + 1));
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(CJRObjSeat cJRObjSeat, CJRObjSeat cJRObjSeat2) {
        if (cJRObjSeat.getGridSeatRowId() < cJRObjSeat2.getGridSeatRowId()) {
            return -1;
        }
        if (cJRObjSeat.getGridSeatRowId() > cJRObjSeat2.getGridSeatRowId()) {
            return 1;
        }
        if (cJRObjSeat.getGridSeatNum() < cJRObjSeat2.getGridSeatNum()) {
            return -1;
        }
        if (cJRObjSeat.getGridSeatNum() > cJRObjSeat2.getGridSeatNum()) {
            return 1;
        }
        return 0;
    }

    private void a(View view, CJRObjSeat cJRObjSeat) {
        d();
        String areaDesc = cJRObjSeat.getAreaDesc();
        if (TextUtils.isEmpty(areaDesc)) {
            areaDesc = "-";
        }
        String string = this.f74920c.getString(R.string.select_seat_change_class_title, new Object[]{areaDesc});
        String string2 = this.f74920c.getString(R.string.select_seat_change_class_message, new Object[]{areaDesc, b.a(cJRObjSeat.getPrice())});
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f74920c);
        builder.setTitle(string);
        builder.setMessage(string2);
        builder.setPositiveButton(this.f74920c.getString(R.string.ok), new DialogInterface.OnClickListener(view) {
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                e.this.a(this.f$1, dialogInterface, i2);
            }
        });
        builder.setNegativeButton(this.f74920c.getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                e.this.a(dialogInterface, i2);
            }
        });
        builder.setCancelable(true);
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, DialogInterface dialogInterface, int i2) {
        h hVar = this.k;
        if (hVar != null) {
            hVar.a(CommonPayParams.Builder.YES);
        }
        a(view, true, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        h hVar = this.k;
        if (hVar != null) {
            hVar.a(CommonPayParams.Builder.NO);
        }
    }

    private void d() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/seat-selection");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.A);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Class Change Alert");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (b.r((Context) this.f74920c)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, b.n((Context) this.f74920c));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this.f74920c);
        } catch (Exception unused) {
        }
    }

    private void e() {
        for (Map.Entry next : this.l.entrySet()) {
            if (next.getValue() != null) {
                ((View) next.getValue()).setSelected(false);
                TextView textView = (TextView) next.getValue();
                textView.setText("");
                if (textView.getParent() instanceof RelativeLayout) {
                    RelativeLayout relativeLayout = (RelativeLayout) textView.getParent();
                    for (int i2 = 0; i2 < relativeLayout.getChildCount(); i2++) {
                        View childAt = relativeLayout.getChildAt(i2);
                        if (childAt instanceof AppCompatImageView) {
                            childAt.setVisibility(0);
                        }
                    }
                }
            }
        }
        this.l.clear();
        Iterator<CJRObjSeat> it2 = this.f74918a.iterator();
        while (it2.hasNext()) {
            it2.next().setSelected(false);
        }
        this.f74918a.clear();
        h hVar = this.k;
        if (hVar != null) {
            hVar.c();
        }
    }

    private CJRMoviesSessionDetails a(String str) {
        CJRMoviesSession cJRMoviesSession;
        if (TextUtils.isEmpty(str) || (cJRMoviesSession = this.m) == null || cJRMoviesSession.getMoviesSessionDetails() == null) {
            return null;
        }
        Iterator<CJRMoviesSessionDetails> it2 = this.m.getMoviesSessionDetails().iterator();
        while (it2.hasNext()) {
            CJRMoviesSessionDetails next = it2.next();
            if (next != null && next.getMoviesPriceDetails() != null && !TextUtils.isEmpty(next.getAreaCatCode()) && str.equalsIgnoreCase(next.getAreaCatCode())) {
                return next;
            }
        }
        return null;
    }

    public final void a() {
        this.f74920c = null;
        this.k = null;
        this.q.removeAllViews();
        this.f74919b.removeAllViews();
    }

    public final void a(int i2) {
        BirdRectView birdRectView = this.v;
        if (birdRectView != null) {
            birdRectView.f76109d = (int) ((((float) i2) / ((float) this.w)) * ((float) this.y));
            int height = birdRectView.getHeight() - birdRectView.f76106a;
            if (birdRectView.f76109d < 0) {
                birdRectView.f76109d = 0;
            } else if (birdRectView.f76109d > height) {
                birdRectView.f76109d = height;
            }
            birdRectView.invalidate();
        }
    }

    public final void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.K = motionEvent.getX();
            this.M = motionEvent.getY();
        } else if (action == 1) {
            a(false);
        } else if (action == 2) {
            this.L = motionEvent.getX();
            this.N = motionEvent.getY();
            if (Math.abs(this.L - this.K) > 30.0f || Math.abs(this.N - this.M) > 30.0f) {
                a(true);
            }
        } else if (action == 3) {
            a(false);
        }
    }

    private void a(boolean z2) {
        if (!z2 || this.t == null) {
            if (this.D == 0) {
                this.p.sendEmptyMessageDelayed(1234, 500);
            }
            this.D = System.currentTimeMillis();
            return;
        }
        this.f74919b.setVisibility(0);
        this.f74919b.animate().translationY(0.0f).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                e.this.f74919b.setVisibility(0);
            }
        });
    }

    static /* synthetic */ void a(e eVar, CJRSeat cJRSeat) {
        float f2;
        Activity activity;
        float f3;
        e eVar2 = eVar;
        int right = eVar2.f74921d.getRight();
        int bottom = eVar2.f74921d.getBottom();
        View findViewWithTag = eVar2.q.findViewWithTag("AREA_TITLE_TAG");
        int height = (findViewWithTag instanceof TextView ? findViewWithTag.getHeight() : 0) + eVar2.u + eVar2.f74926i;
        int i2 = eVar2.A * height;
        int i3 = eVar2.B;
        int i4 = eVar2.f74922e;
        eVar2.w = (i3 * i4) + i2;
        int i5 = eVar2.C;
        int i6 = eVar2.f74925h;
        eVar2.x = (i5 * i4) + i6;
        int i7 = (int) (((float) i5) * 12.0f);
        eVar2.z = ((int) ((12.0f / ((float) i4)) * ((float) i6))) + i7;
        int i8 = i5;
        int i9 = (int) (((double) right) * 0.5d);
        if (eVar2.z > i9) {
            eVar2.z = i9;
            int i10 = eVar2.z;
            float f4 = ((float) i10) / ((float) i8);
            i7 = i10 - ((int) ((f4 / ((float) i4)) * ((float) i6)));
            eVar2.z = i10 + ((int) ((f4 / ((float) i4)) * ((float) i6)));
            f2 = f4;
        } else {
            f2 = 12.0f;
        }
        int i11 = eVar2.f74922e;
        int i12 = eVar2.B;
        eVar2.w = (i12 * i11) + i2;
        eVar2.x = (eVar2.C * i11) + eVar2.f74925h;
        int i13 = (int) (((float) height) * (f2 / ((float) i11)));
        eVar2.y = (int) (((float) (eVar2.A * i13)) + (((float) i12) * f2));
        Activity activity2 = eVar2.f74920c;
        if (activity2 != null && !activity2.isFinishing()) {
            eVar2.t = new BirdView(eVar2.f74920c, f2, cJRSeat, i13, eVar2.s, eVar2.m);
            eVar2.t.setId(593834);
            eVar2.t.setLayoutParams(new RelativeLayout.LayoutParams(eVar2.z, eVar2.y));
            eVar2.f74919b.addView(eVar2.t);
        }
        int top = bottom - eVar2.f74919b.getTop();
        int a2 = b.a(eVar2.f74920c) - eVar2.f74925h;
        View findViewWithTag2 = eVar2.q.findViewWithTag("AREA_TITLE_TAG");
        int height2 = eVar2.A * ((findViewWithTag2 instanceof TextView ? findViewWithTag2.getHeight() : 0) + eVar2.u + eVar2.f74926i);
        int i14 = eVar2.B;
        int i15 = eVar2.f74922e;
        eVar2.w = (i14 * i15) + height2;
        eVar2.x = (eVar2.C * i15) + eVar2.f74925h;
        if ((eVar2.f74921d.getBottom() - eVar2.f74919b.getTop() < eVar2.w || b.a(eVar2.f74920c) - eVar2.f74925h < eVar2.x) && (activity = eVar2.f74920c) != null && !activity.isFinishing()) {
            int i16 = eVar2.w;
            if (i16 > top) {
                f3 = (((float) top) / ((float) i16)) * ((float) eVar2.y);
            } else {
                f3 = (float) eVar2.y;
            }
            eVar2.v = new BirdRectView(eVar2.f74920c, (int) f3, (int) ((((float) a2) / ((float) eVar2.x)) * ((float) eVar2.z)));
            eVar2.v.setLayoutParams(new RelativeLayout.LayoutParams(eVar2.z, eVar2.y));
            eVar2.f74919b.addView(eVar2.v);
        }
        Activity activity3 = eVar2.f74920c;
        if (activity3 != null) {
            View view = new View(activity3);
            view.setBackgroundColor(eVar2.f74920c.getResources().getColor(R.color.white));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, n.a(3, (Context) eVar2.f74920c));
            layoutParams.setMargins(0, n.a(2, (Context) eVar2.f74920c), 0, 0);
            layoutParams.addRule(3, 593834);
            view.setLayoutParams(layoutParams);
            eVar2.f74919b.addView(view);
        }
    }
}
