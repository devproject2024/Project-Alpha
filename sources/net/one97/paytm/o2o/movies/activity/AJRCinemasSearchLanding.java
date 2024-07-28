package net.one97.paytm.o2o.movies.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.g;
import net.one97.paytm.o2o.movies.common.b.b;
import net.one97.paytm.o2o.movies.entity.CJRAmenity;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.utils.i;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRCinemasSearchLanding extends AppBaseActivity implements TextWatcher, View.OnClickListener, g.c {
    private static final String o = AJRCinemasSearchLanding.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private Toolbar f73928a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f73929b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f73930c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f73931d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f73932e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f73933f;

    /* renamed from: g  reason: collision with root package name */
    private g f73934g;

    /* renamed from: h  reason: collision with root package name */
    private Animation f73935h;

    /* renamed from: i  reason: collision with root package name */
    private String f73936i;
    private String j;
    private String k = "";
    private String l = "";
    private List<CJRCinemas> m = new ArrayList();
    private List<CJRAmenity> n = new ArrayList();

    private static double a(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00e1 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e5 A[Catch:{ Exception -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0246 A[Catch:{ Exception -> 0x0258 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r19) {
        /*
            r18 = this;
            r7 = r18
            super.onCreate(r19)
            int r0 = net.one97.paytm.o2o.movies.R.layout.activity_cinemas_search_landing
            r7.setContentView((int) r0)
            int r0 = net.one97.paytm.o2o.movies.R.id.toolbar
            android.view.View r0 = r7.findViewById(r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r7.f73928a = r0
            int r0 = net.one97.paytm.o2o.movies.R.id.top_title
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r7.f73929b = r0
            int r0 = net.one97.paytm.o2o.movies.R.id.search_edit_txt
            android.view.View r0 = r7.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r7.f73930c = r0
            int r0 = net.one97.paytm.o2o.movies.R.id.err_lyt
            android.view.View r0 = r7.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r7.f73931d = r0
            int r0 = net.one97.paytm.o2o.movies.R.id.error_text_quote
            android.view.View r0 = r7.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r7.f73932e = r0
            int r0 = net.one97.paytm.o2o.movies.R.id.recycler_view_cinema
            android.view.View r0 = r7.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r7.f73933f = r0
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            r0.<init>(r7)
            androidx.recyclerview.widget.RecyclerView r1 = r7.f73933f
            r1.setLayoutManager(r0)
            android.widget.EditText r0 = r7.f73930c
            r0.addTextChangedListener(r7)
            android.widget.EditText r0 = r7.f73930c
            net.one97.paytm.o2o.movies.activity.-$$Lambda$AJRCinemasSearchLanding$tPugLqC-xwptvojSn0UuNvR362o r1 = net.one97.paytm.o2o.movies.activity.$$Lambda$AJRCinemasSearchLanding$tPugLqCxwptvojSn0UuNvR362o.INSTANCE
            r0.setOnEditorActionListener(r1)
            androidx.recyclerview.widget.RecyclerView r0 = r7.f73933f
            net.one97.paytm.o2o.movies.activity.-$$Lambda$AJRCinemasSearchLanding$-T-02ylMxeSHkeh3gVLt80C0J2M r1 = net.one97.paytm.o2o.movies.activity.$$Lambda$AJRCinemasSearchLanding$T02ylMxeSHkeh3gVLt80C0J2M.INSTANCE
            r0.setOnTouchListener(r1)
            android.content.Intent r0 = r18.getIntent()
            if (r0 == 0) goto L_0x00a1
            java.lang.String r1 = "intent_city_name"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x0077
            java.lang.String r1 = r0.getStringExtra(r1)
            r7.f73936i = r1
        L_0x0077:
            java.lang.String r1 = "cinema_list"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x0085
            java.util.ArrayList r1 = r0.getParcelableArrayListExtra(r1)
            r7.m = r1
        L_0x0085:
            java.lang.String r1 = "AMENITIES_list"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x0093
            java.util.ArrayList r1 = r0.getParcelableArrayListExtra(r1)
            r7.n = r1
        L_0x0093:
            java.lang.String r1 = "intent_virtual_city_name"
            boolean r2 = r0.hasExtra(r1)
            if (r2 == 0) goto L_0x00a1
            java.lang.String r0 = r0.getStringExtra(r1)
            r7.j = r0
        L_0x00a1:
            r0 = 21
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00b0 }
            if (r1 >= r0) goto L_0x00b0
            android.view.Window r1 = r18.getWindow()     // Catch:{ Exception -> 0x00b0 }
            r2 = 32
            r1.setSoftInputMode(r2)     // Catch:{ Exception -> 0x00b0 }
        L_0x00b0:
            androidx.appcompat.widget.Toolbar r1 = r7.f73928a
            r7.setSupportActionBar(r1)
            androidx.appcompat.app.ActionBar r1 = r18.getSupportActionBar()
            r2 = 1
            r1.b((boolean) r2)
            androidx.appcompat.app.ActionBar r1 = r18.getSupportActionBar()
            r3 = 0
            r1.c((boolean) r3)
            int r1 = net.one97.paytm.common.widgets.R.drawable.back_arrow     // Catch:{ Exception -> 0x00e1 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r7, (int) r1)     // Catch:{ Exception -> 0x00e1 }
            android.graphics.drawable.Drawable r4 = r1.mutate()     // Catch:{ Exception -> 0x00e1 }
            int r5 = net.one97.paytm.common.assets.R.color.color_000000     // Catch:{ Exception -> 0x00e1 }
            int r5 = androidx.core.content.b.c(r7, r5)     // Catch:{ Exception -> 0x00e1 }
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_ATOP     // Catch:{ Exception -> 0x00e1 }
            r4.setColorFilter(r5, r6)     // Catch:{ Exception -> 0x00e1 }
            androidx.appcompat.app.ActionBar r4 = r18.getSupportActionBar()     // Catch:{ Exception -> 0x00e1 }
            r4.b((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x00e1 }
        L_0x00e1:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00f1 }
            if (r1 < r0) goto L_0x00f2
            android.widget.TextView r0 = r7.f73929b     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r1 = "sans-serif-medium"
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r3)     // Catch:{ Exception -> 0x00f1 }
            r0.setTypeface(r1)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f2
        L_0x00f1:
        L_0x00f2:
            java.lang.String r0 = r7.f73936i
            java.lang.String r1 = r7.j
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00fe
            java.lang.String r0 = r7.j
        L_0x00fe:
            android.widget.TextView r1 = r7.f73929b
            int r4 = net.one97.paytm.o2o.movies.R.string.cinema_search_header
            java.lang.String r4 = r7.getString(r4)
            java.lang.String r5 = " "
            java.lang.String r4 = r4.concat(r5)
            java.lang.String r0 = r4.concat(r0)
            r1.setText(r0)
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRCinemas> r0 = r7.m
            if (r0 == 0) goto L_0x0207
            net.one97.paytm.o2o.movies.utils.i r0 = net.one97.paytm.o2o.movies.utils.i.a()
            android.location.Location r0 = r0.f75931a
            if (r0 == 0) goto L_0x01e7
            double r4 = r0.getLatitude()
            java.lang.String r1 = java.lang.String.valueOf(r4)
            double r4 = r0.getLongitude()
            java.lang.String r0 = java.lang.String.valueOf(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x01e7
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x01e7
            double r4 = java.lang.Double.parseDouble(r1)
            double r0 = java.lang.Double.parseDouble(r0)
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRCinemas> r6 = r7.m
            java.util.Iterator r6 = r6.iterator()
            r8 = 0
        L_0x014a:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x01da
            java.lang.Object r9 = r6.next()
            net.one97.paytm.o2o.movies.entity.CJRCinemas r9 = (net.one97.paytm.o2o.movies.entity.CJRCinemas) r9
            if (r9 == 0) goto L_0x014a
            java.lang.Double r10 = r9.getLatitude()
            if (r10 == 0) goto L_0x014a
            java.lang.Double r10 = r9.getLongitude()
            if (r10 == 0) goto L_0x014a
            java.lang.Double r10 = r9.getLatitude()
            double r10 = r10.doubleValue()
            java.lang.Double r12 = r9.getLongitude()
            double r12 = r12.doubleValue()
            double r12 = r0 - r12
            double r14 = a((double) r4)
            double r14 = java.lang.Math.sin(r14)
            double r16 = a((double) r10)
            double r16 = java.lang.Math.sin(r16)
            double r14 = r14 * r16
            double r16 = a((double) r4)
            double r16 = java.lang.Math.cos(r16)
            double r10 = a((double) r10)
            double r10 = java.lang.Math.cos(r10)
            double r16 = r16 * r10
            double r10 = a((double) r12)
            double r10 = java.lang.Math.cos(r10)
            double r16 = r16 * r10
            double r14 = r14 + r16
            double r10 = java.lang.Math.acos(r14)
            r12 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r10 = r10 * r12
            r12 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r10 = r10 / r12
            r12 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r10 = r10 * r12
            r12 = 4607864714143564038(0x3ff26c8b43958106, double:1.1515)
            double r10 = r10 * r12
            r12 = 4609926660211357856(0x3ff9bfdf7e8038a0, double:1.609344)
            double r10 = r10 * r12
            r9.setDistance(r10)
            java.lang.Integer r9 = r9.is_preferred_cinema()
            int r9 = r9.intValue()
            if (r9 != r2) goto L_0x014a
            int r8 = r8 + 1
            goto L_0x014a
        L_0x01da:
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRCinemas> r0 = r7.m
            int r1 = r0.size()
            java.util.List r0 = r0.subList(r8, r1)
            java.util.Collections.sort(r0)
        L_0x01e7:
            androidx.recyclerview.widget.RecyclerView r0 = r7.f73933f
            r0.setVisibility(r3)
            net.one97.paytm.o2o.movies.adapter.g r8 = new net.one97.paytm.o2o.movies.adapter.g
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRCinemas> r2 = r7.m
            com.paytm.utility.RoboTextView r3 = r7.f73932e
            android.widget.LinearLayout r4 = r7.f73931d
            java.lang.String r5 = r7.f73936i
            r0 = r8
            r1 = r18
            r6 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.f73934g = r8
            androidx.recyclerview.widget.RecyclerView r0 = r7.f73933f
            net.one97.paytm.o2o.movies.adapter.g r1 = r7.f73934g
            r0.setAdapter(r1)
        L_0x0207:
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.S
            net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r0, (android.content.Context) r7)
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0258 }
            r0.<init>()     // Catch:{ Exception -> 0x0258 }
            java.lang.String r1 = "screenName"
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.S     // Catch:{ Exception -> 0x0258 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0258 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x0258 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.y     // Catch:{ Exception -> 0x0258 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0258 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x0258 }
            java.lang.String r2 = "Screen Loaded"
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0258 }
            java.lang.String r1 = r7.f73936i     // Catch:{ Exception -> 0x0258 }
            if (r1 == 0) goto L_0x0239
            java.lang.String r1 = r7.f73936i     // Catch:{ Exception -> 0x0258 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0258 }
            if (r1 != 0) goto L_0x0239
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75013h     // Catch:{ Exception -> 0x0258 }
            java.lang.String r2 = r7.f73936i     // Catch:{ Exception -> 0x0258 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0258 }
        L_0x0239:
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x0258 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x0258 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0258 }
            boolean r1 = com.paytm.utility.b.r((android.content.Context) r18)     // Catch:{ Exception -> 0x0258 }
            if (r1 == 0) goto L_0x024f
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x0258 }
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r18)     // Catch:{ Exception -> 0x0258 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0258 }
        L_0x024f:
            net.one97.paytm.o2o.movies.common.c.b r1 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0258 }
            net.one97.paytm.o2o.movies.common.c.c r1 = r1.f75033b     // Catch:{ Exception -> 0x0258 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x0258 }
            r1.sendCustomEventWithMap(r2, r0, r7)     // Catch:{ Exception -> 0x0258 }
        L_0x0258:
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b
            java.lang.String r1 = o
            java.lang.String r2 = ""
            r0.dropBreadCrumb(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRCinemasSearchLanding.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 != 6) {
            return false;
        }
        n.b((View) textView);
        return false;
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        g gVar = this.f73934g;
        if (gVar != null) {
            gVar.getFilter().filter(charSequence);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.search_icon_img) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, b.S);
                hashMap.put(b.f75007b, b.y);
                hashMap.put(b.f75008c, "Search Tab Clicked");
                hashMap.put(b.p, b.r);
                if (com.paytm.utility.b.r((Context) this)) {
                    hashMap.put(b.q, com.paytm.utility.b.n((Context) this));
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(b.f75006a, hashMap, this);
            } catch (Exception unused) {
            }
            this.f73935h = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
            this.f73930c.requestFocus();
            ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.f73930c, 1);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(17432576, net.one97.paytm.common.assets.R.anim.slide_out_right);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(17432576, net.one97.paytm.common.assets.R.anim.slide_out_right);
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public final void a(CJRCinemas cJRCinemas) {
        String str = this.f73936i;
        if (cJRCinemas.isCurrentCityCinema().intValue() == 0 && !TextUtils.isEmpty(this.j)) {
            str = this.j;
        }
        i.a().f75936f = cJRCinemas;
        Intent intent = new Intent(this, AJRCinemaDetailsActivity.class);
        intent.putExtra("movie_ticket_city_selected", str);
        intent.putExtra("movie_ticket_selected_item_type", "cinema");
        StringBuilder sb = new StringBuilder();
        sb.append(cJRCinemas.getPaytmCinemaId());
        intent.putExtra("movie_ticket_selected_item_value", sb.toString());
        startActivity(intent);
        overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
    }
}
