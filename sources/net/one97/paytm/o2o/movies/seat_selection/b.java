package net.one97.paytm.o2o.movies.seat_selection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.utility.RoboTextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.reactivex.rxjava3.d.g;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.b.e;
import net.one97.paytm.o2o.movies.common.customui.b;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat;
import net.one97.paytm.o2o.movies.entity.SeatMapData;
import net.one97.paytm.o2o.movies.fragment.r;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout;
import net.one97.paytm.o2o.movies.widget.ObervableVerticalScrollView;

public final class b extends h implements net.one97.paytm.o2o.movies.d.h, r.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f75809c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    f f75810a;

    /* renamed from: b  reason: collision with root package name */
    e f75811b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.o2o.movies.common.customui.b f75812d;

    /* renamed from: e  reason: collision with root package name */
    private io.reactivex.rxjava3.b.c f75813e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f75814f;

    /* renamed from: g  reason: collision with root package name */
    private CJRSeat f75815g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f75816h;

    private View b(int i2) {
        if (this.f75816h == null) {
            this.f75816h = new HashMap();
        }
        View view = (View) this.f75816h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f75816h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.o2o.movies.seat_selection.b$b  reason: collision with other inner class name */
    static final class C1495b<T> implements g<File> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRMoviesSession f75817a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SeatMapData f75818b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f75819c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f75820d;

        C1495b(CJRMoviesSession cJRMoviesSession, SeatMapData seatMapData, FragmentActivity fragmentActivity, b bVar) {
            this.f75817a = cJRMoviesSession;
            this.f75818b = seatMapData;
            this.f75819c = fragmentActivity;
            this.f75820d = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            File file = (File) obj;
            if (file != null) {
                r b2 = this.f75820d.g();
                if (b2 != null) {
                    b2.a(file);
                    return;
                }
                return;
            }
            this.f75820d.f();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        f fVar;
        SeatMapData a2;
        CJRMoviesSession selectedMovieSession;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (fVar = this.f75810a) != null && (a2 = fVar.a()) != null && (selectedMovieSession = a2.getSelectedMovieSession()) != null) {
            e eVar = this.f75811b;
            if (eVar != null) {
                eVar.a();
            }
            this.f75811b = new e(activity, a2.getMovieTitle(), this, (ObervableVerticalScrollView) b(R.id.scroll_view_seat_container), selectedMovieSession, (InterceptTouchLinearLayout) b(R.id.movie_seat_parent_lyt), (RelativeLayout) b(R.id.id_bird_view));
            e eVar2 = this.f75811b;
            if (eVar2 != null) {
                CJRSeat cJRSeat = this.f75815g;
                if (cJRSeat == null) {
                    k.a("cjrSeat");
                }
                eVar2.a(cJRSeat);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_seated, viewGroup, false);
    }

    public final void c() {
        net.one97.paytm.o2o.movies.common.customui.b bVar = this.f75812d;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void a(ArrayList<CJRObjSeat> arrayList) {
        f fVar;
        if (arrayList != null && (fVar = this.f75810a) != null) {
            fVar.a(arrayList, arrayList.size());
        }
    }

    public final void b() {
        f fVar;
        SeatMapData a2;
        CJRMoviesSession selectedMovieSession;
        Context context = getContext();
        if (context != null && (fVar = this.f75810a) != null && (a2 = fVar.a()) != null && (selectedMovieSession = a2.getSelectedMovieSession()) != null) {
            k.a((Object) context, "context");
            String string = context.getResources().getString(R.string.movies_seats_max_limit_message, new Object[]{String.valueOf(selectedMovieSession.getMaxTickets())});
            k.a((Object) string, "context.resources.getStr…tMaxTickets().toString())");
            Toast.makeText(context, string, 0).show();
        }
    }

    public final void e() {
        SeatMapData a2;
        String seatStatus;
        String b2;
        f fVar = this.f75810a;
        if (fVar != null && (a2 = fVar.a()) != null && (seatStatus = a2.getSeatStatus()) != null && (b2 = net.one97.paytm.o2o.movies.common.a.d.b(seatStatus)) != null) {
            if (this.f75814f) {
                a(b2, "movie_tickets_seat_selection", "mutliple_showtime_clicked");
                return;
            }
            this.f75814f = true;
            a(b2, "movie_tickets_seat_selection", "seat_selection_screen_loaded");
        }
    }

    public final void a(int i2) {
        String str;
        String b2;
        Snackbar snackbar;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            CJRSeat cJRSeat = this.f75815g;
            if (cJRSeat == null) {
                k.a("cjrSeat");
            }
            Map<Integer, String> messages = cJRSeat.getMessages();
            if (messages != null && (str = messages.get(Integer.valueOf(i2))) != null && (b2 = net.one97.paytm.o2o.movies.common.a.d.b(str)) != null) {
                b.a aVar = net.one97.paytm.o2o.movies.common.customui.b.f75096g;
                k.a((Object) activity, "activity");
                this.f75812d = b.a.a(activity);
                net.one97.paytm.o2o.movies.common.customui.b bVar = this.f75812d;
                if (bVar != null) {
                    bVar.f75098b = R.layout.custom_snackbar_view_seat_layout;
                    net.one97.paytm.o2o.movies.common.customui.b a2 = bVar.a(b.c.INDEFINITE);
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) b(R.id.snack_bar);
                    k.a((Object) coordinatorLayout, "snack_bar");
                    View view = coordinatorLayout;
                    View.OnClickListener dVar = new d(activity, this, i2);
                    k.c(view, "view");
                    k.c(b2, "mText");
                    k.c(dVar, "onClickListener");
                    if (a2.f75098b != -1) {
                        int i3 = net.one97.paytm.o2o.movies.common.customui.c.f75110b[a2.f75099c.ordinal()];
                        if (i3 == 1) {
                            snackbar = Snackbar.a(view, (CharSequence) "", -2);
                            k.a((Object) snackbar, "Snackbar.make(view, \"\", …ackbar.LENGTH_INDEFINITE)");
                        } else if (i3 == 2) {
                            snackbar = Snackbar.a(view, (CharSequence) "", -1);
                            k.a((Object) snackbar, "Snackbar.make(view, \"\", Snackbar.LENGTH_SHORT)");
                        } else if (i3 == 3) {
                            snackbar = Snackbar.a(view, (CharSequence) "", 0);
                            k.a((Object) snackbar, "Snackbar.make(view, \"\", Snackbar.LENGTH_LONG)");
                        } else {
                            throw new m();
                        }
                        a2.f75101e = snackbar;
                        Snackbar snackbar2 = a2.f75101e;
                        if (snackbar2 == null) {
                            k.a("snackbar");
                        }
                        View b3 = snackbar2.b();
                        if (b3 != null) {
                            a2.f75102f = (Snackbar.SnackbarLayout) b3;
                            Snackbar.SnackbarLayout snackbarLayout = a2.f75102f;
                            if (snackbarLayout == null) {
                                k.a("snackbarView");
                            }
                            snackbarLayout.setPadding(0, 0, 0, 0);
                            Snackbar snackbar3 = a2.f75101e;
                            if (snackbar3 == null) {
                                k.a("snackbar");
                            }
                            snackbar3.b().setPadding(0, 0, 0, 0);
                            View inflate = a2.f75097a.inflate(a2.f75098b, (ViewGroup) null);
                            k.a((Object) inflate, "layoutInflater.inflate(layout, null)");
                            a2.f75100d = inflate;
                            View view2 = a2.f75100d;
                            if (view2 == null) {
                                k.a("contentView");
                            }
                            View findViewById = view2.findViewById(R.id.snackbar_text);
                            k.a((Object) findViewById, "contentView.findViewById…View>(R.id.snackbar_text)");
                            ((RoboTextView) findViewById).setText(b2);
                            View view3 = a2.f75100d;
                            if (view3 == null) {
                                k.a("contentView");
                            }
                            ((RoboTextView) view3.findViewById(R.id.tv_ok)).setOnClickListener(new b.e(a2, dVar));
                            Snackbar.SnackbarLayout snackbarLayout2 = a2.f75102f;
                            if (snackbarLayout2 == null) {
                                k.a("snackbarView");
                            }
                            View view4 = a2.f75100d;
                            if (view4 == null) {
                                k.a("contentView");
                            }
                            snackbarLayout2.addView(view4, 0);
                        } else {
                            throw new u("null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
                        }
                    } else {
                        throw new b.C1485b(a2, "layout must be setted");
                    }
                }
                net.one97.paytm.o2o.movies.common.customui.b bVar2 = this.f75812d;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f75825a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f75826b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f75827c;

        d(FragmentActivity fragmentActivity, b bVar, int i2) {
            this.f75825a = fragmentActivity;
            this.f75826b = bVar;
            this.f75827c = i2;
        }

        public final void onClick(View view) {
            net.one97.paytm.o2o.movies.common.customui.b a2 = this.f75826b.f75812d;
            if (a2 != null) {
                a2.c();
            }
        }
    }

    private final void a(String str, String str2, String str3) {
        f fVar;
        SeatMapData a2;
        CJRMoviesSession selectedMovieSession;
        FragmentActivity activity = getActivity();
        if (activity != null && (fVar = this.f75810a) != null && (a2 = fVar.a()) != null && (selectedMovieSession = a2.getSelectedMovieSession()) != null) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            String b2 = n.b(selectedMovieSession.getRealShowDateTime(), "EEE, hh:m a");
            sb.append(a2.getMovieLocalizedTitle());
            sb.append("/");
            sb.append(selectedMovieSession.getMovieCode());
            sb.append("/");
            sb.append(b2);
            sb.append("/");
            sb.append(selectedMovieSession.getCinemaName());
            sb.append("/");
            sb.append(selectedMovieSession.getCinemaID());
            arrayList.add(sb.toString());
            arrayList.add(str);
            StringBuilder sb2 = new StringBuilder(n.b(selectedMovieSession.getRealShowDateTime(), "dd MMM YYYY :"));
            List<CJRMoviesSession> sessionList = a2.getSessionList();
            int i2 = 0;
            int size = sessionList != null ? sessionList.size() : 0;
            List<CJRMoviesSession> sessionList2 = a2.getSessionList();
            if (sessionList2 != null) {
                for (Object next : sessionList2) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    sb2.append(n.b(((CJRMoviesSession) next).getRealShowDateTime(), "HH:mm"));
                    sb2.append(i2 < size + -1 ? AppConstants.COMMA : "");
                    i2 = i3;
                }
            }
            arrayList.add(sb2.toString());
            String valueOf = String.valueOf(size);
            CJRSeat cJRSeat = this.f75815g;
            if (cJRSeat == null) {
                k.a("cjrSeat");
            }
            arrayList.add(cJRSeat.getTempTransId());
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMultipleLabel(activity, str2, str3, arrayList, valueOf, "Seat Selection Screen", "movies");
        }
    }

    public final void a(String str) {
        f fVar;
        SeatMapData a2;
        try {
            FragmentActivity activity = getActivity();
            if (activity != null && (fVar = this.f75810a) != null && (a2 = fVar.a()) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/" + a2.getMovieTitle() + "/seat-selection");
                String str2 = net.one97.paytm.o2o.movies.common.b.b.f75007b;
                k.a((Object) str2, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
                String str3 = net.one97.paytm.o2o.movies.common.b.b.A;
                k.a((Object) str3, "CJRMoviesGTMConstants.GT…IE_TICKETS_SEAT_SELECTION");
                hashMap.put(str2, str3);
                String str4 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
                k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
                hashMap.put(str4, "Class Change -".concat(String.valueOf(str)));
                String str5 = net.one97.paytm.o2o.movies.common.b.b.p;
                k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
                String str6 = net.one97.paytm.o2o.movies.common.b.b.r;
                k.a((Object) str6, "CJRMoviesGTMConstants.GTM_VALUE_VERTICAL_NAME");
                hashMap.put(str5, str6);
                if (com.paytm.utility.b.r((Context) activity)) {
                    String str7 = net.one97.paytm.o2o.movies.common.b.b.q;
                    k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                    String n = com.paytm.utility.b.n((Context) activity);
                    k.a((Object) n, "CJRAppCommonUtility.getUserId(activity)");
                    hashMap.put(str7, n);
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, activity);
            }
        } catch (Exception unused) {
        }
    }

    public final void d() {
        f fVar;
        SeatMapData a2;
        CJRMoviesSession selectedMovieSession;
        try {
            FragmentActivity activity = getActivity();
            if (activity != null && (fVar = this.f75810a) != null && (a2 = fVar.a()) != null && (selectedMovieSession = a2.getSelectedMovieSession()) != null) {
                HashMap hashMap = new HashMap();
                String a3 = n.a(a2.getSelectedMovie(), selectedMovieSession);
                k.a((Object) a3, "CJRMoviesUtility\n       …SelectedMovie(), session)");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, a3);
                Map map = hashMap;
                String movieTitle = a2.getMovieTitle();
                if (movieTitle == null) {
                    movieTitle = "";
                }
                map.put("mov_curr_movie_name", movieTitle);
                String cinemaName = selectedMovieSession.getCinemaName();
                k.a((Object) cinemaName, "session.getCinemaName()");
                hashMap.put("mov_cinema_hall_name", cinemaName);
                Map map2 = hashMap;
                String selectedCity = a2.getSelectedCity();
                if (selectedCity == null) {
                    selectedCity = "";
                }
                map2.put("mov_city_name", selectedCity);
                Map map3 = hashMap;
                String n = com.paytm.utility.b.n((Context) activity);
                if (n == null) {
                    n = "";
                }
                map3.put("mov_user_id", n);
                Map map4 = hashMap;
                String selectedCategory = a2.getSelectedCategory();
                if (selectedCategory == null) {
                    selectedCategory = "";
                }
                map4.put("mov_cinema_listing_type", selectedCategory);
                String D = com.paytm.utility.b.D(com.paytm.utility.b.B(selectedMovieSession.getRealShowDateTime()));
                k.a((Object) D, "showTimeBucket");
                hashMap.put("mov_show_timing_bucket", D);
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap("movie_seat_selected", hashMap, activity);
            }
        } catch (Exception unused) {
        }
    }

    public final void onDestroyView() {
        io.reactivex.rxjava3.b.c cVar = this.f75813e;
        if (cVar != null) {
            cVar.dispose();
        }
        e eVar = this.f75811b;
        if (eVar != null) {
            eVar.a();
        }
        super.onDestroyView();
        HashMap hashMap = this.f75816h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        r4 = r4.f74918a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r13 = this;
            io.reactivex.rxjava3.b.c r0 = r13.f75813e
            if (r0 == 0) goto L_0x0007
            r0.dispose()
        L_0x0007:
            androidx.fragment.app.FragmentActivity r0 = r13.getActivity()
            if (r0 == 0) goto L_0x0109
            net.one97.paytm.o2o.movies.seat_selection.f r1 = r13.f75810a
            if (r1 == 0) goto L_0x0109
            net.one97.paytm.o2o.movies.entity.SeatMapData r1 = r1.a()
            if (r1 == 0) goto L_0x0109
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r9 = r1.getSelectedMovieSession()
            if (r9 == 0) goto L_0x0109
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_seat_parent_lyt
            android.view.View r2 = r13.b((int) r2)
            net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout r2 = (net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout) r2
            if (r2 == 0) goto L_0x0109
            java.lang.String r2 = "activity"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.o2o.movies.R.id.movie_seat_parent_lyt
            android.view.View r3 = r13.b((int) r3)
            net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout r3 = (net.one97.paytm.o2o.movies.widget.InterceptTouchLinearLayout) r3
            java.lang.String r4 = "movie_seat_parent_lyt"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r5 = r1.getSelectedMovie()
            net.one97.paytm.o2o.movies.b.e r4 = r13.f75811b
            if (r4 == 0) goto L_0x0050
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat> r4 = r4.f74918a
            if (r4 == 0) goto L_0x0050
            int r4 = r4.size()
            r7 = r4
            goto L_0x0052
        L_0x0050:
            r4 = 0
            r7 = 0
        L_0x0052:
            net.one97.paytm.o2o.movies.common.b.c r4 = net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r6 = "MoviesGTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r10 = 0
            java.lang.String r4 = "seatmap_share_custom_image_url"
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.c.a(r4, r10)
            net.one97.paytm.o2o.movies.common.b.c r8 = net.one97.paytm.o2o.movies.common.b.c.a()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            java.lang.String r6 = "seatmap_share_custom_message"
            java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.c.a(r6, r10)
            net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat r8 = r13.f75815g
            if (r8 != 0) goto L_0x007a
            java.lang.String r11 = "cjrSeat"
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x007a:
            java.util.Map r8 = r8.getSeatLegends()
            java.lang.String r11 = "context"
            kotlin.g.b.k.c(r2, r11)
            java.lang.String r12 = "seatMapView"
            kotlin.g.b.k.c(r3, r12)
            java.lang.String r12 = "movie"
            kotlin.g.b.k.c(r5, r12)
            java.lang.String r12 = "movieSession"
            kotlin.g.b.k.c(r9, r12)
            java.lang.String r12 = "movies-seat-selection"
            kotlin.g.b.k.c(r2, r11)
            java.lang.String r11 = "name"
            kotlin.g.b.k.c(r12, r11)
            net.one97.paytm.o2o.movies.storefront.a$b r11 = new net.one97.paytm.o2o.movies.storefront.a$b
            r11.<init>(r12, r2)
            io.reactivex.rxjava3.a.ab r11 = (io.reactivex.rxjava3.a.ab) r11
            io.reactivex.rxjava3.a.y r11 = io.reactivex.rxjava3.a.y.a(r11)
            java.lang.String r12 = "Single.create { emitter …rror(e)))\n        }\n    }"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            io.reactivex.rxjava3.a.x r12 = io.reactivex.rxjava3.i.a.d()
            io.reactivex.rxjava3.a.y r11 = r11.b((io.reactivex.rxjava3.a.x) r12)
            io.reactivex.rxjava3.a.x r12 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.y r11 = r11.a((io.reactivex.rxjava3.a.x) r12)
            java.lang.String r12 = "observable.subscribeOn(S…dSchedulers.mainThread())"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            net.one97.paytm.o2o.movies.utils.aa$b r12 = net.one97.paytm.o2o.movies.utils.aa.b.f75900a
            io.reactivex.rxjava3.d.h r12 = (io.reactivex.rxjava3.d.h) r12
            io.reactivex.rxjava3.a.y r11 = r11.c(r12)
            net.one97.paytm.o2o.movies.utils.aa$c r12 = net.one97.paytm.o2o.movies.utils.aa.c.f75901a
            io.reactivex.rxjava3.d.h r12 = (io.reactivex.rxjava3.d.h) r12
            io.reactivex.rxjava3.a.y r11 = r11.a(r12)
            net.one97.paytm.o2o.movies.utils.aa$d r12 = new net.one97.paytm.o2o.movies.utils.aa$d
            r12.<init>(r2, r5, r4)
            io.reactivex.rxjava3.d.h r12 = (io.reactivex.rxjava3.d.h) r12
            io.reactivex.rxjava3.a.y r2 = r11.a(r12)
            io.reactivex.rxjava3.a.x r4 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.y r11 = r2.a((io.reactivex.rxjava3.a.x) r4)
            net.one97.paytm.o2o.movies.utils.aa$e r12 = new net.one97.paytm.o2o.movies.utils.aa$e
            r2 = r12
            r4 = r6
            r6 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            io.reactivex.rxjava3.d.h r12 = (io.reactivex.rxjava3.d.h) r12
            io.reactivex.rxjava3.a.y r2 = r11.b(r12)
            if (r2 == 0) goto L_0x0107
            net.one97.paytm.o2o.movies.seat_selection.b$b r3 = new net.one97.paytm.o2o.movies.seat_selection.b$b
            r3.<init>(r9, r1, r0, r13)
            io.reactivex.rxjava3.d.g r3 = (io.reactivex.rxjava3.d.g) r3
            net.one97.paytm.o2o.movies.seat_selection.b$c r4 = new net.one97.paytm.o2o.movies.seat_selection.b$c
            r4.<init>(r9, r1, r0, r13)
            io.reactivex.rxjava3.d.g r4 = (io.reactivex.rxjava3.d.g) r4
            io.reactivex.rxjava3.b.c r10 = r2.a(r3, (io.reactivex.rxjava3.d.g<? super java.lang.Throwable>) r4)
        L_0x0107:
            r13.f75813e = r10
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.seat_selection.b.a():void");
    }

    /* access modifiers changed from: private */
    public final r g() {
        j childFragmentManager = getChildFragmentManager();
        Fragment c2 = childFragmentManager != null ? childFragmentManager.c("SeatShareDialog") : null;
        if (!(c2 instanceof r)) {
            c2 = null;
        }
        return (r) c2;
    }

    public final void f() {
        try {
            r g2 = g();
            if (g2 != null) {
                g2.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 666 && i3 == -1) {
            f();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("seat_data") : null;
        if (serializable != null) {
            this.f75815g = (CJRSeat) serializable;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat");
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (!(context instanceof f)) {
            context = null;
        }
        this.f75810a = (f) context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class c<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRMoviesSession f75821a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SeatMapData f75822b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f75823c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f75824d;

        c(CJRMoviesSession cJRMoviesSession, SeatMapData seatMapData, FragmentActivity fragmentActivity, b bVar) {
            this.f75821a = cJRMoviesSession;
            this.f75822b = seatMapData;
            this.f75823c = fragmentActivity;
            this.f75824d = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f75824d.f();
        }
    }
}
