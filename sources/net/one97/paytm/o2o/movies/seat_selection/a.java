package net.one97.paytm.o2o.movies.seat_selection;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRAreas;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat;
import net.one97.paytm.o2o.movies.entity.SeatMapData;
import net.one97.paytm.o2o.movies.utils.n;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final C1494a f75793a = new C1494a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private f f75794b;

    /* renamed from: c  reason: collision with root package name */
    private b f75795c = new b();

    /* renamed from: d  reason: collision with root package name */
    private CJRSeat f75796d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f75797e;

    private View a(int i2) {
        if (this.f75797e == null) {
            this.f75797e = new HashMap();
        }
        View view = (View) this.f75797e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f75797e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("seat_data") : null;
        if (serializable != null) {
            this.f75796d = (CJRSeat) serializable;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CharSequence charSequence;
        String b2;
        ArrayList<CJRAreas> areas;
        CJRMoviesSessionDetails cJRMoviesSessionDetails;
        String str;
        CJRMoviesPriceDetails moviesPriceDetails;
        Resources resources;
        SeatMapData a2;
        CJRMoviesSession selectedMovieSession;
        ArrayList<CJRMoviesSessionDetails> moviesSessionDetails;
        Object obj;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((LinearLayout) a(R.id.lyt_select_circle)).setOnClickListener(new d(this));
        CJRSeat cJRSeat = this.f75796d;
        if (cJRSeat == null) {
            k.a("cjrSeat");
        }
        Context context = getContext();
        if (context != null) {
            this.f75795c.f75800c.clear();
            if (!(cJRSeat == null || (areas = cJRSeat.getAreas()) == null)) {
                for (CJRAreas cJRAreas : areas) {
                    k.a((Object) cJRAreas, "objArea");
                    if (cJRAreas.getAvailable() > 0) {
                        f fVar = this.f75794b;
                        if (fVar == null || (a2 = fVar.a()) == null || (selectedMovieSession = a2.getSelectedMovieSession()) == null || (moviesSessionDetails = selectedMovieSession.getMoviesSessionDetails()) == null) {
                            cJRMoviesSessionDetails = null;
                        } else {
                            Iterator it2 = moviesSessionDetails.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it2.next();
                                CJRMoviesSessionDetails cJRMoviesSessionDetails2 = (CJRMoviesSessionDetails) obj;
                                k.a((Object) cJRMoviesSessionDetails2, "detail");
                                boolean z = true;
                                if (cJRMoviesSessionDetails2.getMoviesPriceDetails() == null || TextUtils.isEmpty(cJRMoviesSessionDetails2.getAreaCatCode()) || !p.a(cJRMoviesSessionDetails2.mAreaCatCode, cJRAreas.getAreaCode(), true)) {
                                    z = false;
                                    continue;
                                }
                                if (z) {
                                    break;
                                }
                            }
                            cJRMoviesSessionDetails = (CJRMoviesSessionDetails) obj;
                        }
                        Context context2 = getContext();
                        if (context2 == null || (resources = context2.getResources()) == null || (str = resources.getString(R.string.normal)) == null) {
                            str = "";
                        }
                        k.a((Object) str, "context?.resources?.getS…ng(R.string.normal) ?: \"\"");
                        if (!(cJRMoviesSessionDetails == null || (moviesPriceDetails = cJRMoviesSessionDetails.getMoviesPriceDetails()) == null)) {
                            double price = moviesPriceDetails.getPrice();
                            if (price >= 0.0d) {
                                StringBuilder sb = new StringBuilder();
                                CJRMoviesPriceDetails moviesPriceDetails2 = cJRMoviesSessionDetails.getMoviesPriceDetails();
                                k.a((Object) moviesPriceDetails2, "sessionDetails.moviesPriceDetails");
                                sb.append(n.b(moviesPriceDetails2.getTypeDescription()));
                                sb.append(" ( ");
                                sb.append(getString(R.string.rupees));
                                sb.append(" ");
                                sb.append(price);
                                sb.append(")");
                                str = sb.toString();
                            }
                        }
                        CJRObjSeat cJRObjSeat = new CJRObjSeat();
                        cJRObjSeat.setAreaCirclename(str);
                        if (!(cJRMoviesSessionDetails == null || cJRMoviesSessionDetails.getMoviesPriceDetails() == null)) {
                            CJRMoviesPriceDetails moviesPriceDetails3 = cJRMoviesSessionDetails.getMoviesPriceDetails();
                            k.a((Object) moviesPriceDetails3, "sessionDetails.moviesPriceDetails");
                            cJRObjSeat.setPrice(moviesPriceDetails3.getPrice());
                            CJRMoviesPriceDetails moviesPriceDetails4 = cJRMoviesSessionDetails.getMoviesPriceDetails();
                            k.a((Object) moviesPriceDetails4, "sessionDetails.moviesPriceDetails");
                            cJRObjSeat.setTypeCode(moviesPriceDetails4.getTypeCode());
                            CJRMoviesPriceDetails moviesPriceDetails5 = cJRMoviesSessionDetails.getMoviesPriceDetails();
                            k.a((Object) moviesPriceDetails5, "sessionDetails.moviesPriceDetails");
                            cJRObjSeat.setVoucherPrice(moviesPriceDetails5.getVoucherPrice());
                        }
                        cJRObjSeat.setAreaCode(cJRAreas.getAreaCode());
                        cJRObjSeat.setAreaDesc(cJRAreas.getAreaDesc());
                        cJRObjSeat.setAreaAvailableCount(cJRAreas.getAvailable());
                        this.f75795c.f75800c.add(cJRObjSeat);
                    }
                }
            }
            LayoutInflater from = LayoutInflater.from(context);
            int i2 = 0;
            for (Object next : this.f75795c.f75800c) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.k.a();
                }
                View inflate = from.inflate(R.layout.lyt_movie_circle, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.txt_movie_circle);
                k.a((Object) findViewById, "circleView.findViewById<…w>(R.id.txt_movie_circle)");
                ((TextView) findViewById).setText(((CJRObjSeat) next).getAreaCircleName());
                inflate.setOnClickListener(new c(i2, from, this, cJRSeat));
                ((LinearLayout) a(R.id.layout_movie_circle)).addView(inflate);
                i2 = i3;
            }
            this.f75795c.a(0);
            TextView textView = (TextView) a(R.id.txt_select_circle);
            k.a((Object) textView, "txt_select_circle");
            String c2 = this.f75795c.c();
            if (c2 == null || (b2 = net.one97.paytm.o2o.movies.common.a.d.b(c2)) == null) {
                k.a((Object) context, "context");
                charSequence = context.getResources().getText(R.string.select_your_circle);
            } else {
                charSequence = b2;
            }
            textView.setText(charSequence);
            b();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f75806a;

        d(a aVar) {
            this.f75806a = aVar;
        }

        public final void onClick(View view) {
            this.f75806a.a();
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator rotation;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator rotation2;
        Context context = getContext();
        if (context != null) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.layout_movie_circle);
            if (linearLayout == null || !net.one97.paytm.o2o.movies.common.a.e.a(linearLayout)) {
                LinearLayout linearLayout2 = (LinearLayout) a(R.id.layout_movie_circle);
                k.a((Object) linearLayout2, "layout_movie_circle");
                net.one97.paytm.o2o.movies.common.a.e.a(linearLayout2, true);
                TextView textView = (TextView) a(R.id.txt_select_circle);
                if (textView != null) {
                    k.a((Object) context, "context");
                    textView.setText(context.getResources().getText(R.string.select_your_circle));
                }
                ImageView imageView = (ImageView) a(R.id.img_toggle_select_circle);
                if (!(imageView == null || (animate = imageView.animate()) == null || (duration = animate.setDuration(50)) == null || (rotation = duration.rotation(180.0f)) == null)) {
                    rotation.start();
                }
                View a2 = a(R.id.circle_extra_view);
                if (a2 != null) {
                    net.one97.paytm.o2o.movies.common.a.e.a(a2, false);
                    return;
                }
                return;
            }
            String c2 = this.f75795c.c();
            TextView textView2 = (TextView) a(R.id.txt_select_circle);
            if (textView2 != null) {
                textView2.setText(c2);
            }
            LinearLayout linearLayout3 = (LinearLayout) a(R.id.layout_movie_circle);
            k.a((Object) linearLayout3, "layout_movie_circle");
            net.one97.paytm.o2o.movies.common.a.e.a(linearLayout3, false);
            ImageView imageView2 = (ImageView) a(R.id.img_toggle_select_circle);
            if (!(imageView2 == null || (animate2 = imageView2.animate()) == null || (duration2 = animate2.setDuration(50)) == null || (rotation2 = duration2.rotation(0.0f)) == null)) {
                rotation2.start();
            }
            View a3 = a(R.id.circle_extra_view);
            if (a3 != null) {
                net.one97.paytm.o2o.movies.common.a.e.a(a3, true);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f75802a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LayoutInflater f75803b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f75804c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRSeat f75805d;

        c(int i2, LayoutInflater layoutInflater, a aVar, CJRSeat cJRSeat) {
            this.f75802a = i2;
            this.f75803b = layoutInflater;
            this.f75804c = aVar;
            this.f75805d = cJRSeat;
        }

        public final void onClick(View view) {
            a.a(this.f75804c, this.f75802a);
            this.f75804c.b();
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        f fVar;
        SeatMapData a2;
        CJRMoviesSession selectedMovieSession;
        Context context = getContext();
        if (context != null && (fVar = this.f75794b) != null && (a2 = fVar.a()) != null && (selectedMovieSession = a2.getSelectedMovieSession()) != null) {
            int b2 = n.b(34);
            int b3 = n.b(7);
            int b4 = n.b(16);
            int maxTickets = selectedMovieSession.getMaxTickets();
            int a3 = this.f75795c.a();
            if (maxTickets >= a3) {
                maxTickets = a3;
            }
            LinearLayout linearLayout = (LinearLayout) a(R.id.lyt_seats);
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            e eVar = new e(context, this);
            if (maxTickets > 0) {
                if (maxTickets > 0) {
                    int i2 = 1;
                    while (true) {
                        TextView textView = new TextView(context);
                        textView.setLayoutParams(new TableRow.LayoutParams(b2, b2));
                        textView.setTextColor(n.b(context, net.one97.paytm.common.assets.R.color.color_33b5e5));
                        textView.setTextSize(1, 13.0f);
                        textView.setGravity(17);
                        textView.setPadding(b3, b3, b3, b3);
                        textView.setBackgroundResource(R.drawable.just_tickets_movie_seat_bg);
                        textView.setText(String.valueOf(i2));
                        textView.setEnabled(true);
                        textView.setClickable(true);
                        textView.setTag(Integer.valueOf(i2));
                        textView.setOnClickListener(eVar);
                        LinearLayout linearLayout2 = (LinearLayout) a(R.id.lyt_seats);
                        if (linearLayout2 != null) {
                            linearLayout2.addView(textView);
                        }
                        if (i2 == maxTickets) {
                            break;
                        }
                        i2++;
                    }
                }
                View view = new View(context);
                view.setLayoutParams(new TableRow.LayoutParams(b4, b2));
                LinearLayout linearLayout3 = (LinearLayout) a(R.id.lyt_seats);
                if (linearLayout3 != null) {
                    linearLayout3.addView(view);
                }
            }
            if (this.f75795c.f75799b > maxTickets || maxTickets <= 0) {
                this.f75795c.f75799b = -1;
                d();
                return;
            }
            LinearLayout linearLayout4 = (LinearLayout) a(R.id.lyt_seats);
            View childAt = linearLayout4 != null ? linearLayout4.getChildAt(this.f75795c.f75799b - 1) : null;
            if (!(childAt instanceof TextView)) {
                childAt = null;
            }
            TextView textView2 = (TextView) childAt;
            if (textView2 != null) {
                textView2.setSelected(true);
                textView2.setTextColor(n.b(context, R.color.white));
            }
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f75807a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f75808b;

        e(Context context, a aVar) {
            this.f75807a = context;
            this.f75808b = aVar;
        }

        public final void onClick(View view) {
            k.c(view, "v");
            if (!(view instanceof TextView)) {
                view = null;
            }
            TextView textView = (TextView) view;
            if (textView != null) {
                a.a(this.f75808b, textView);
            }
        }
    }

    private final void c() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(R.string.not_enough_seats);
            builder.setPositiveButton(getString(R.string.ok), (DialogInterface.OnClickListener) null);
            builder.setCancelable(true);
            builder.show();
        }
    }

    private final void d() {
        f fVar;
        SeatMapData a2;
        CJRMoviesSession selectedMovieSession;
        FragmentActivity activity = getActivity();
        if (!(activity == null || this.f75795c.f75799b <= 0 || (fVar = this.f75794b) == null || (a2 = fVar.a()) == null || (selectedMovieSession = a2.getSelectedMovieSession()) == null)) {
            if (selectedMovieSession.isTokenFeeOnly()) {
                ((TextView) a(R.id.txt_just_tickets_desc)).setText(R.string.booking_justtickets_seat_desc);
                ((TextView) a(R.id.txt_just_tickets_desc)).setTextColor(n.b((Context) activity, R.color.just_tickets_con_fee_desc));
            } else {
                ((TextView) a(R.id.txt_just_tickets_desc)).setText(R.string.open_seat_desc);
                ((TextView) a(R.id.txt_just_tickets_desc)).setTextColor(n.b((Context) activity, R.color.just_tickets_open_seat_desc));
            }
        }
        CJRObjSeat d2 = this.f75795c.d();
        if (d2 != null) {
            ArrayList d3 = kotlin.a.k.d(d2);
            f fVar2 = this.f75794b;
            if (fVar2 != null) {
                fVar2.a(d3, this.f75795c.f75799b);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_non_seated, viewGroup, false);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (!(context instanceof f)) {
            context = null;
        }
        this.f75794b = (f) context;
    }

    /* renamed from: net.one97.paytm.o2o.movies.seat_selection.a$a  reason: collision with other inner class name */
    public static final class C1494a {
        private C1494a() {
        }

        public /* synthetic */ C1494a(byte b2) {
            this();
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f75798a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f75799b = -1;

        /* renamed from: c  reason: collision with root package name */
        List<CJRObjSeat> f75800c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private int f75801d = -1;

        public final void a(int i2) {
            this.f75801d = this.f75798a;
            this.f75798a = i2;
        }

        public final int a() {
            CJRObjSeat cJRObjSeat = (CJRObjSeat) kotlin.a.k.a(this.f75800c, this.f75798a);
            if (cJRObjSeat != null) {
                return cJRObjSeat.getAreaAvailableCount();
            }
            return 0;
        }

        public final boolean b() {
            return this.f75799b <= a();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
            r0 = r0.getAreaCircleName();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String c() {
            /*
                r2 = this;
                java.util.List<net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat> r0 = r2.f75800c
                int r1 = r2.f75798a
                java.lang.Object r0 = kotlin.a.k.a(r0, (int) r1)
                net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat r0 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat) r0
                if (r0 == 0) goto L_0x0012
                java.lang.String r0 = r0.getAreaCircleName()
                if (r0 != 0) goto L_0x0014
            L_0x0012:
                java.lang.String r0 = ""
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.seat_selection.a.b.c():java.lang.String");
        }

        public final CJRObjSeat d() {
            return (CJRObjSeat) kotlin.a.k.a(this.f75800c, this.f75798a);
        }
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        if (aVar.f75795c.f75798a != i2) {
            aVar.f75795c.a(i2);
            if (!aVar.f75795c.b()) {
                aVar.f75795c.f75799b = -1;
                aVar.c();
            }
        }
        aVar.a();
        aVar.d();
    }

    public static final /* synthetic */ void a(a aVar, TextView textView) {
        int i2 = -1;
        if (textView.isSelected()) {
            textView.setSelected(false);
            textView.setTextColor(n.b(aVar.getContext(), net.one97.paytm.common.assets.R.color.color_33b5e5));
            aVar.f75795c.f75799b = -1;
        } else {
            b bVar = aVar.f75795c;
            Object tag = textView.getTag();
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            bVar.f75799b = num != null ? num.intValue() : 0;
            Object tag2 = textView.getTag();
            if (!(tag2 instanceof Integer)) {
                tag2 = null;
            }
            Integer num2 = (Integer) tag2;
            if (num2 != null) {
                i2 = num2.intValue();
            }
            LinearLayout linearLayout = (LinearLayout) aVar.a(R.id.lyt_seats);
            int childCount = linearLayout != null ? linearLayout.getChildCount() : 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                LinearLayout linearLayout2 = (LinearLayout) aVar.a(R.id.lyt_seats);
                View childAt = linearLayout2 != null ? linearLayout2.getChildAt(i3) : null;
                if (!(childAt instanceof TextView)) {
                    childAt = null;
                }
                TextView textView2 = (TextView) childAt;
                if (textView2 != null) {
                    if (i3 == i2 - 1) {
                        textView2.setSelected(true);
                        textView2.setTextColor(n.b(aVar.getContext(), R.color.white));
                    } else {
                        textView2.setSelected(false);
                        textView2.setTextColor(n.b(aVar.getContext(), net.one97.paytm.common.assets.R.color.color_33b5e5));
                    }
                }
            }
            if (!aVar.f75795c.b()) {
                aVar.c();
                return;
            }
        }
        aVar.d();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f75797e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
