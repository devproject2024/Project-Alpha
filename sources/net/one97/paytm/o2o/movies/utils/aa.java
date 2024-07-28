package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.view.ViewGroup;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.h;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovies;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.storefront.model.Items;
import net.one97.paytm.o2o.movies.storefront.model.Page;
import net.one97.paytm.o2o.movies.storefront.model.StorefrontResponse;
import net.one97.paytm.o2o.movies.storefront.model.Views;
import net.one97.paytm.o2o.movies.utils.x;

public final class aa {

    public static final class e<T, R> implements h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f75905a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f75906b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRMovies f75907c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRMoviesSession f75908d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f75909e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Map f75910f;

        public e(ViewGroup viewGroup, String str, CJRMovies cJRMovies, CJRMoviesSession cJRMoviesSession, int i2, Map map) {
            this.f75905a = viewGroup;
            this.f75906b = str;
            this.f75907c = cJRMovies;
            this.f75908d = cJRMoviesSession;
            this.f75909e = i2;
            this.f75910f = map;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8 A[Catch:{ all -> 0x0270 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00dd A[Catch:{ all -> 0x0270 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x011d A[SYNTHETIC, Splitter:B:44:0x011d] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0138 A[Catch:{ all -> 0x0270 }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x017f A[Catch:{ all -> 0x0270 }] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x018f A[Catch:{ all -> 0x0270 }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.File apply(net.one97.paytm.o2o.movies.utils.ab r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0273 }
                r2.<init>()     // Catch:{ all -> 0x0273 }
                java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0273 }
                android.view.ViewGroup r3 = r0.f75905a     // Catch:{ all -> 0x0273 }
                int r3 = r3.getChildCount()     // Catch:{ all -> 0x0273 }
                r4 = 0
                r5 = 0
            L_0x0013:
                r6 = 0
                if (r5 >= r3) goto L_0x0049
                android.view.ViewGroup r7 = r0.f75905a     // Catch:{ all -> 0x0273 }
                android.view.View r7 = r7.getChildAt(r5)     // Catch:{ all -> 0x0273 }
                boolean r7 = r7 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0273 }
                if (r7 == 0) goto L_0x0046
                android.view.ViewGroup r7 = r0.f75905a     // Catch:{ all -> 0x0273 }
                android.view.View r7 = r7.getChildAt(r5)     // Catch:{ all -> 0x0273 }
                int r8 = net.one97.paytm.o2o.movies.R.id.seats_parent_lyt     // Catch:{ all -> 0x0273 }
                android.view.View r7 = r7.findViewById(r8)     // Catch:{ all -> 0x0273 }
                boolean r8 = r7 instanceof net.one97.paytm.o2o.movies.widget.ObservableHorizontalScrollView     // Catch:{ all -> 0x0273 }
                if (r8 != 0) goto L_0x0031
                goto L_0x0032
            L_0x0031:
                r6 = r7
            L_0x0032:
                net.one97.paytm.o2o.movies.widget.ObservableHorizontalScrollView r6 = (net.one97.paytm.o2o.movies.widget.ObservableHorizontalScrollView) r6     // Catch:{ all -> 0x0273 }
                if (r6 == 0) goto L_0x0046
                net.one97.paytm.o2o.movies.utils.z r7 = new net.one97.paytm.o2o.movies.utils.z     // Catch:{ all -> 0x0273 }
                int r8 = r6.getScrollX()     // Catch:{ all -> 0x0273 }
                int r6 = r6.getScrollY()     // Catch:{ all -> 0x0273 }
                r7.<init>(r8, r6)     // Catch:{ all -> 0x0273 }
                r2.add(r7)     // Catch:{ all -> 0x0273 }
            L_0x0046:
                int r5 = r5 + 1
                goto L_0x0013
            L_0x0049:
                android.view.ViewGroup r3 = r0.f75905a     // Catch:{ all -> 0x0273 }
                java.lang.String r5 = "shareImageBitmapHolder"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0273 }
                java.lang.String r5 = r0.f75906b     // Catch:{ all -> 0x0273 }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r7 = r0.f75907c     // Catch:{ all -> 0x0273 }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r0.f75908d     // Catch:{ all -> 0x0273 }
                int r9 = r0.f75909e     // Catch:{ all -> 0x0273 }
                java.util.Map r10 = r0.f75910f     // Catch:{ all -> 0x0273 }
                android.content.Context r11 = r3.getContext()     // Catch:{ all -> 0x0273 }
                int r12 = r3.getRight()     // Catch:{ all -> 0x0273 }
                int r13 = r3.getBottom()     // Catch:{ all -> 0x0273 }
                r3.measure(r4, r4)     // Catch:{ all -> 0x0273 }
                int r14 = r3.getMeasuredWidth()     // Catch:{ all -> 0x0273 }
                int r15 = r3.getMeasuredHeight()     // Catch:{ all -> 0x0273 }
                r3.layout(r4, r4, r14, r15)     // Catch:{ all -> 0x0273 }
                r14 = 600(0x258, float:8.41E-43)
                int r14 = net.one97.paytm.o2o.movies.utils.n.b((int) r14)     // Catch:{ all -> 0x0273 }
                int r15 = r3.getMeasuredWidth()     // Catch:{ all -> 0x0273 }
                if (r15 <= r14) goto L_0x0084
                int r14 = r3.getMeasuredWidth()     // Catch:{ all -> 0x0273 }
            L_0x0084:
                android.view.LayoutInflater r15 = android.view.LayoutInflater.from(r11)     // Catch:{ all -> 0x0273 }
                r16 = r2
                int r2 = net.one97.paytm.o2o.movies.R.layout.seat_share_layout     // Catch:{ all -> 0x0273 }
                android.view.View r2 = r15.inflate(r2, r6, r4)     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = "1002"
                if (r10 == 0) goto L_0x009f
                java.util.Set r15 = r10.keySet()     // Catch:{ all -> 0x0273 }
                if (r15 == 0) goto L_0x009f
                boolean r15 = r15.contains(r6)     // Catch:{ all -> 0x0273 }
                goto L_0x00a0
            L_0x009f:
                r15 = 0
            L_0x00a0:
                int r4 = net.one97.paytm.o2o.movies.R.id.img_blocked_seats     // Catch:{ all -> 0x0273 }
                android.view.View r4 = r2.findViewById(r4)     // Catch:{ all -> 0x0273 }
                java.lang.String r0 = "layout.findViewById<View>(R.id.img_blocked_seats)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0270 }
                net.one97.paytm.o2o.movies.common.a.e.a(r4, r15)     // Catch:{ all -> 0x0270 }
                int r0 = net.one97.paytm.o2o.movies.R.id.txt_blocked_seats     // Catch:{ all -> 0x0270 }
                android.view.View r0 = r2.findViewById(r0)     // Catch:{ all -> 0x0270 }
                com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0     // Catch:{ all -> 0x0270 }
                if (r0 == 0) goto L_0x00d1
                r4 = r0
                android.view.View r4 = (android.view.View) r4     // Catch:{ all -> 0x0270 }
                net.one97.paytm.o2o.movies.common.a.e.a(r4, r15)     // Catch:{ all -> 0x0270 }
                if (r10 == 0) goto L_0x00cb
                java.lang.Object r4 = r10.get(r6)     // Catch:{ all -> 0x0270 }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0270 }
                if (r4 == 0) goto L_0x00cb
            L_0x00c8:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0270 }
                goto L_0x00ce
            L_0x00cb:
                java.lang.String r4 = "Blocked"
                goto L_0x00c8
            L_0x00ce:
                r0.setText(r4)     // Catch:{ all -> 0x0270 }
            L_0x00d1:
                r0 = 1073741824(0x40000000, float:2.0)
                int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r0)     // Catch:{ all -> 0x0270 }
                int r4 = r3.getMeasuredWidth()     // Catch:{ all -> 0x0270 }
                if (r14 <= r4) goto L_0x00e1
                int r14 = r3.getMeasuredWidth()     // Catch:{ all -> 0x0270 }
            L_0x00e1:
                int r4 = r3.getMeasuredHeight()     // Catch:{ all -> 0x0270 }
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0270 }
                android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r14, r4, r6)     // Catch:{ all -> 0x0270 }
                android.graphics.Canvas r6 = new android.graphics.Canvas     // Catch:{ all -> 0x0270 }
                r6.<init>(r4)     // Catch:{ all -> 0x0270 }
                r10 = -1
                r6.drawColor(r10)     // Catch:{ all -> 0x0270 }
                r3.draw(r6)     // Catch:{ all -> 0x0270 }
                r6 = 0
                r3.layout(r6, r6, r12, r13)     // Catch:{ all -> 0x0270 }
                r3.requestLayout()     // Catch:{ all -> 0x0270 }
                int r3 = net.one97.paytm.o2o.movies.R.id.img_seatmap     // Catch:{ all -> 0x0270 }
                android.view.View r3 = r2.findViewById(r3)     // Catch:{ all -> 0x0270 }
                android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ all -> 0x0270 }
                r3.setImageBitmap(r4)     // Catch:{ all -> 0x0270 }
                int r3 = net.one97.paytm.o2o.movies.R.id.img_movie_poster     // Catch:{ all -> 0x0270 }
                android.view.View r3 = r2.findViewById(r3)     // Catch:{ all -> 0x0270 }
                android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ all -> 0x0270 }
                android.graphics.Bitmap r4 = r1.f75913a     // Catch:{ all -> 0x0270 }
                r3.setImageBitmap(r4)     // Catch:{ all -> 0x0270 }
                android.graphics.Bitmap r3 = r1.f75915c     // Catch:{ all -> 0x0270 }
                java.lang.String r4 = "layout.findViewById<Imag…ew>(R.id.layout_branding)"
                r6 = 1
                if (r3 == 0) goto L_0x0138
                int r3 = net.one97.paytm.o2o.movies.R.id.layout_branding     // Catch:{ all -> 0x0270 }
                android.view.View r3 = r2.findViewById(r3)     // Catch:{ all -> 0x0270 }
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0270 }
                r4 = 0
                net.one97.paytm.o2o.movies.common.a.e.a(r3, r4)     // Catch:{ all -> 0x0270 }
                int r3 = net.one97.paytm.o2o.movies.R.id.img_adImage     // Catch:{ all -> 0x0270 }
                android.view.View r3 = r2.findViewById(r3)     // Catch:{ all -> 0x0270 }
                android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ all -> 0x0270 }
                android.graphics.Bitmap r1 = r1.f75915c     // Catch:{ all -> 0x0270 }
                r3.setImageBitmap(r1)     // Catch:{ all -> 0x0270 }
                goto L_0x017d
            L_0x0138:
                int r3 = net.one97.paytm.o2o.movies.R.id.layout_branding     // Catch:{ all -> 0x0270 }
                android.view.View r3 = r2.findViewById(r3)     // Catch:{ all -> 0x0270 }
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0270 }
                net.one97.paytm.o2o.movies.common.a.e.a(r3, r6)     // Catch:{ all -> 0x0270 }
                int r3 = net.one97.paytm.o2o.movies.R.id.img_logo     // Catch:{ all -> 0x0270 }
                android.view.View r3 = r2.findViewById(r3)     // Catch:{ all -> 0x0270 }
                android.widget.ImageView r3 = (android.widget.ImageView) r3     // Catch:{ all -> 0x0270 }
                android.graphics.Bitmap r1 = r1.f75914b     // Catch:{ all -> 0x0270 }
                r3.setImageBitmap(r1)     // Catch:{ all -> 0x0270 }
                if (r5 == 0) goto L_0x017d
                r1 = r5
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r1 = kotlin.m.p.b(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0270 }
                int r1 = r1.length()     // Catch:{ all -> 0x0270 }
                if (r1 <= 0) goto L_0x0168
                r1 = 1
                goto L_0x0169
            L_0x0168:
                r1 = 0
            L_0x0169:
                if (r1 == 0) goto L_0x017d
                int r1 = net.one97.paytm.o2o.movies.R.id.txt_footer_text     // Catch:{ all -> 0x0270 }
                android.view.View r1 = r2.findViewById(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = "layout.findViewById<Text…ew>(R.id.txt_footer_text)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0270 }
                android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x0270 }
                r1.setText(r5)     // Catch:{ all -> 0x0270 }
            L_0x017d:
                if (r9 <= r6) goto L_0x018f
                int r1 = net.one97.paytm.o2o.movies.R.string.ss_selected_seats     // Catch:{ all -> 0x0270 }
                java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0270 }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0270 }
                r5 = 0
                r3[r5] = r4     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = r11.getString(r1, r3)     // Catch:{ all -> 0x0270 }
                goto L_0x019e
            L_0x018f:
                int r1 = net.one97.paytm.o2o.movies.R.string.ss_selected_seat     // Catch:{ all -> 0x0270 }
                java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0270 }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0270 }
                r5 = 0
                r3[r5] = r4     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = r11.getString(r1, r3)     // Catch:{ all -> 0x0270 }
            L_0x019e:
                java.lang.String r3 = "if (totalSeatSelected > … totalSeatSelected)\n    }"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0270 }
                int r3 = net.one97.paytm.o2o.movies.R.id.txt_selected_seats     // Catch:{ all -> 0x0270 }
                android.view.View r3 = r2.findViewById(r3)     // Catch:{ all -> 0x0270 }
                java.lang.String r4 = "layout.findViewById<Robo…(R.id.txt_selected_seats)"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0270 }
                com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0270 }
                r3.setText(r1)     // Catch:{ all -> 0x0270 }
                int r1 = net.one97.paytm.o2o.movies.R.id.txt_movie_title     // Catch:{ all -> 0x0270 }
                android.view.View r1 = r2.findViewById(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = "layout.findViewById<Robo…ew>(R.id.txt_movie_title)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0270 }
                com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = r7.getTitle()     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0270 }
                r1.setText(r3)     // Catch:{ all -> 0x0270 }
                int r1 = net.one97.paytm.o2o.movies.R.id.txt_cinema_name     // Catch:{ all -> 0x0270 }
                android.view.View r1 = r2.findViewById(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = "layout.findViewById<Robo…ew>(R.id.txt_cinema_name)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0270 }
                com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = r8.getCinemaName()     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0270 }
                r1.setText(r3)     // Catch:{ all -> 0x0270 }
                int r1 = net.one97.paytm.o2o.movies.R.id.txt_language     // Catch:{ all -> 0x0270 }
                android.view.View r1 = r2.findViewById(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = "layout.findViewById<Robo…tView>(R.id.txt_language)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0270 }
                com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = r7.getLanguage()     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0270 }
                r1.setText(r3)     // Catch:{ all -> 0x0270 }
                int r1 = net.one97.paytm.o2o.movies.R.id.txt_screen_format     // Catch:{ all -> 0x0270 }
                android.view.View r1 = r2.findViewById(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = "layout.findViewById<Robo…>(R.id.txt_screen_format)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0270 }
                com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = r8.getScreenFormat()     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0270 }
                r1.setText(r3)     // Catch:{ all -> 0x0270 }
                int r1 = net.one97.paytm.o2o.movies.R.id.txt_show_time     // Catch:{ all -> 0x0270 }
                android.view.View r1 = r2.findViewById(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = "layout.findViewById<Robo…View>(R.id.txt_show_time)"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0270 }
                com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = r8.getRealShowDateTime()     // Catch:{ all -> 0x0270 }
                java.lang.String r3 = net.one97.paytm.o2o.movies.utils.n.e(r3)     // Catch:{ all -> 0x0270 }
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0270 }
                r1.setText(r3)     // Catch:{ all -> 0x0270 }
                r1 = 0
                r2.measure(r0, r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r0 = "layout"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0270 }
                int r0 = r2.getMeasuredWidth()     // Catch:{ all -> 0x0270 }
                int r3 = r2.getMeasuredHeight()     // Catch:{ all -> 0x0270 }
                r2.layout(r1, r1, r0, r3)     // Catch:{ all -> 0x0270 }
                int r0 = r2.getWidth()     // Catch:{ all -> 0x0270 }
                int r1 = r2.getHeight()     // Catch:{ all -> 0x0270 }
                android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0270 }
                android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r3)     // Catch:{ all -> 0x0270 }
                android.graphics.Canvas r1 = new android.graphics.Canvas     // Catch:{ all -> 0x0270 }
                r1.<init>(r0)     // Catch:{ all -> 0x0270 }
                r2.draw(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = "context"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = "finalBitmap"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0270 }
                java.io.File r0 = net.one97.paytm.o2o.movies.utils.aa.a(r11, r0)     // Catch:{ all -> 0x0270 }
                r1 = r17
                android.view.ViewGroup r2 = r1.f75905a     // Catch:{ all -> 0x0274 }
                net.one97.paytm.o2o.movies.utils.aa$e$1 r3 = new net.one97.paytm.o2o.movies.utils.aa$e$1     // Catch:{ all -> 0x0274 }
                r4 = r16
                r3.<init>(r1, r4)     // Catch:{ all -> 0x0274 }
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x0274 }
                r2.post(r3)     // Catch:{ all -> 0x0274 }
                return r0
            L_0x0270:
                r1 = r17
                goto L_0x0274
            L_0x0273:
                r1 = r0
            L_0x0274:
                java.lang.Exception r0 = new java.lang.Exception
                r0.<init>()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.aa.e.apply(net.one97.paytm.o2o.movies.utils.ab):java.io.File");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.f.a.a(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final java.io.File a(android.content.Context r6, android.graphics.Bitmap r7) {
        /*
            r0 = 0
            java.io.File r6 = r6.getExternalFilesDir(r0)     // Catch:{ Exception -> 0x003f }
            if (r6 == 0) goto L_0x000c
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x003f }
            goto L_0x000d
        L_0x000c:
            r6 = r0
        L_0x000d:
            java.lang.String r1 = "/seat_map_screenshot.jpg"
            java.lang.String r6 = kotlin.g.b.k.a((java.lang.String) r6, (java.lang.Object) r1)     // Catch:{ Exception -> 0x003f }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x003f }
            r1.<init>(r6)     // Catch:{ Exception -> 0x003f }
            r1.createNewFile()     // Catch:{ Exception -> 0x0040 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0040 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x0040 }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ Exception -> 0x0040 }
            r2 = r6
            java.io.FileOutputStream r2 = (java.io.FileOutputStream) r2     // Catch:{ all -> 0x0038 }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0038 }
            r4 = 10
            r5 = r2
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ all -> 0x0038 }
            r7.compress(r3, r4, r5)     // Catch:{ all -> 0x0038 }
            r2.flush()     // Catch:{ all -> 0x0038 }
            kotlin.x r7 = kotlin.x.f47997a     // Catch:{ all -> 0x0038 }
            kotlin.f.a.a(r6, r0)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0040
        L_0x0038:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x003a }
        L_0x003a:
            r0 = move-exception
            kotlin.f.a.a(r6, r7)     // Catch:{ Exception -> 0x0040 }
            throw r0     // Catch:{ Exception -> 0x0040 }
        L_0x003f:
            r1 = r0
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.aa.a(android.content.Context, android.graphics.Bitmap):java.io.File");
    }

    static final class a<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f75897a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f75898b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f75899c;

        a(String str, String str2, String str3) {
            this.f75897a = str;
            this.f75898b = str2;
            this.f75899c = str3;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[Catch:{ Exception -> 0x007d }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x008d A[SYNTHETIC, Splitter:B:33:0x008d] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.one97.paytm.o2o.movies.utils.ab call() {
            /*
                r7 = this;
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
                r1 = 1
                r2 = 0
                r3 = 0
                java.lang.String r4 = r7.f75897a     // Catch:{ Exception -> 0x0039 }
                if (r4 == 0) goto L_0x0039
                java.lang.String r4 = r7.f75897a     // Catch:{ Exception -> 0x0039 }
                if (r4 == 0) goto L_0x0033
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0039 }
                java.lang.CharSequence r4 = kotlin.m.p.b(r4)     // Catch:{ Exception -> 0x0039 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0039 }
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0039 }
                int r4 = r4.length()     // Catch:{ Exception -> 0x0039 }
                if (r4 <= 0) goto L_0x0021
                r4 = 1
                goto L_0x0022
            L_0x0021:
                r4 = 0
            L_0x0022:
                if (r4 == 0) goto L_0x0039
                com.squareup.picasso.w r4 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0039 }
                java.lang.String r5 = r7.f75897a     // Catch:{ Exception -> 0x0039 }
                com.squareup.picasso.aa r4 = r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0039 }
                android.graphics.Bitmap r4 = r4.e()     // Catch:{ Exception -> 0x0039 }
                goto L_0x003a
            L_0x0033:
                kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x0039 }
                r4.<init>(r0)     // Catch:{ Exception -> 0x0039 }
                throw r4     // Catch:{ Exception -> 0x0039 }
            L_0x0039:
                r4 = r3
            L_0x003a:
                java.lang.String r5 = r7.f75898b     // Catch:{ Exception -> 0x007d }
                if (r5 == 0) goto L_0x006e
                java.lang.String r5 = r7.f75898b     // Catch:{ Exception -> 0x007d }
                if (r5 == 0) goto L_0x0068
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x007d }
                java.lang.CharSequence r5 = kotlin.m.p.b(r5)     // Catch:{ Exception -> 0x007d }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x007d }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x007d }
                int r5 = r5.length()     // Catch:{ Exception -> 0x007d }
                if (r5 <= 0) goto L_0x0056
                r5 = 1
                goto L_0x0057
            L_0x0056:
                r5 = 0
            L_0x0057:
                if (r5 == 0) goto L_0x006e
                com.squareup.picasso.w r5 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x007d }
                java.lang.String r6 = r7.f75898b     // Catch:{ Exception -> 0x007d }
                com.squareup.picasso.aa r5 = r5.a((java.lang.String) r6)     // Catch:{ Exception -> 0x007d }
                android.graphics.Bitmap r5 = r5.e()     // Catch:{ Exception -> 0x007d }
                goto L_0x008b
            L_0x0068:
                kotlin.u r5 = new kotlin.u     // Catch:{ Exception -> 0x007d }
                r5.<init>(r0)     // Catch:{ Exception -> 0x007d }
                throw r5     // Catch:{ Exception -> 0x007d }
            L_0x006e:
                com.squareup.picasso.w r5 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x007d }
                int r6 = net.one97.paytm.o2o.movies.R.drawable.movie_poster_placeholder     // Catch:{ Exception -> 0x007d }
                com.squareup.picasso.aa r5 = r5.a((int) r6)     // Catch:{ Exception -> 0x007d }
                android.graphics.Bitmap r5 = r5.e()     // Catch:{ Exception -> 0x007d }
                goto L_0x008b
            L_0x007d:
                com.squareup.picasso.w r5 = com.squareup.picasso.w.a()
                int r6 = net.one97.paytm.o2o.movies.R.drawable.movie_poster_placeholder
                com.squareup.picasso.aa r5 = r5.a((int) r6)
                android.graphics.Bitmap r5 = r5.e()
            L_0x008b:
                if (r4 != 0) goto L_0x00de
                java.lang.String r3 = r7.f75899c     // Catch:{ Exception -> 0x00d0 }
                if (r3 == 0) goto L_0x00c0
                java.lang.String r3 = r7.f75899c     // Catch:{ Exception -> 0x00d0 }
                if (r3 == 0) goto L_0x00ba
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x00d0 }
                java.lang.CharSequence r0 = kotlin.m.p.b(r3)     // Catch:{ Exception -> 0x00d0 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d0 }
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00d0 }
                int r0 = r0.length()     // Catch:{ Exception -> 0x00d0 }
                if (r0 <= 0) goto L_0x00a8
                goto L_0x00a9
            L_0x00a8:
                r1 = 0
            L_0x00a9:
                if (r1 == 0) goto L_0x00c0
                com.squareup.picasso.w r0 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x00d0 }
                java.lang.String r1 = r7.f75899c     // Catch:{ Exception -> 0x00d0 }
                com.squareup.picasso.aa r0 = r0.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00d0 }
                android.graphics.Bitmap r0 = r0.e()     // Catch:{ Exception -> 0x00d0 }
                goto L_0x00ce
            L_0x00ba:
                kotlin.u r1 = new kotlin.u     // Catch:{ Exception -> 0x00d0 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x00d0 }
                throw r1     // Catch:{ Exception -> 0x00d0 }
            L_0x00c0:
                com.squareup.picasso.w r0 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x00d0 }
                int r1 = net.one97.paytm.o2o.movies.R.drawable.paytm_logo_def     // Catch:{ Exception -> 0x00d0 }
                com.squareup.picasso.aa r0 = r0.a((int) r1)     // Catch:{ Exception -> 0x00d0 }
                android.graphics.Bitmap r0 = r0.e()     // Catch:{ Exception -> 0x00d0 }
            L_0x00ce:
                r3 = r0
                goto L_0x00de
            L_0x00d0:
                com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
                int r1 = net.one97.paytm.o2o.movies.R.drawable.paytm_logo_def
                com.squareup.picasso.aa r0 = r0.a((int) r1)
                android.graphics.Bitmap r3 = r0.e()
            L_0x00de:
                net.one97.paytm.o2o.movies.utils.ab r0 = new net.one97.paytm.o2o.movies.utils.ab
                r0.<init>(r5, r3, r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.aa.a.call():net.one97.paytm.o2o.movies.utils.ab");
        }
    }

    public static final int a(Context context) {
        k.c(context, "context");
        x.a aVar = x.f76001a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        return x.a.a(applicationContext).b("SEAT_SHARE_TUTORIAL_SHOWN_COUNT", 0, false);
    }

    public static final class b<T, R> implements h<Throwable, StorefrontResponse> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f75900a = new b();

        b() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new StorefrontResponse();
        }
    }

    public static final class d<T, R> implements h<T, ac<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f75902a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRMovies f75903b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f75904c;

        public d(Context context, CJRMovies cJRMovies, String str) {
            this.f75902a = context;
            this.f75903b = cJRMovies;
            this.f75904c = str;
        }

        public final /* synthetic */ Object apply(Object obj) {
            y a2 = y.a(new a((String) obj, this.f75903b.getImageURL(), this.f75904c)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a());
            k.a((Object) a2, "Single.fromCallable {\n  …dSchedulers.mainThread())");
            return a2;
        }
    }

    public static final class c<T, R> implements h<T, ac<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f75901a = new c();

        c() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            List<Page> page;
            List<Items> items;
            Items items2;
            StorefrontResponse storefrontResponse = (StorefrontResponse) obj;
            String str = "";
            if (!(storefrontResponse == null || (page = storefrontResponse.getPage()) == null)) {
                String str2 = str;
                for (Page views : page) {
                    List<Views> views2 = views.getViews();
                    if (views2 != null) {
                        for (Views views3 : views2) {
                            if (p.a(ViewHolderFactory.TYPE_THIN_BANNER, views3.getType(), true) && (items = views3.getItems()) != null && (items2 = (Items) kotlin.a.k.a(items, 0)) != null && (str2 = items2.getImageUrl()) == null) {
                                str2 = str;
                            }
                        }
                    }
                }
                str = str2;
            }
            y a2 = y.a(str);
            k.a((Object) a2, "Single.just(url)");
            return a2;
        }
    }
}
