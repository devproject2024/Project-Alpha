package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.g.d;
import androidx.core.h.a.c;
import androidx.core.h.u;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public final class f<S> extends l<S> {

    /* renamed from: a  reason: collision with root package name */
    static final Object f36201a = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: b  reason: collision with root package name */
    static final Object f36202b = "NAVIGATION_PREV_TAG";

    /* renamed from: c  reason: collision with root package name */
    static final Object f36203c = "NAVIGATION_NEXT_TAG";

    /* renamed from: d  reason: collision with root package name */
    static final Object f36204d = "SELECTOR_TOGGLE_TAG";
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public DateSelector<S> f36205e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public CalendarConstraints f36206f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public Month f36207g;

    /* renamed from: h  reason: collision with root package name */
    a f36208h;
    /* access modifiers changed from: package-private */

    /* renamed from: i  reason: collision with root package name */
    public b f36209i;
    private int k;
    /* access modifiers changed from: private */
    public RecyclerView l;
    /* access modifiers changed from: private */
    public RecyclerView m;
    private View n;
    /* access modifiers changed from: private */
    public View o;

    enum a {
        DAY,
        YEAR
    }

    interface b {
        void a(long j);
    }

    static <T> f<T> a(DateSelector<T> dateSelector, int i2, CalendarConstraints calendarConstraints) {
        f<T> fVar = new f<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.f36139c);
        fVar.setArguments(bundle);
        return fVar;
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.k);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f36205e);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f36206f);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f36207g);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.k = bundle.getInt("THEME_RES_ID_KEY");
        this.f36205e = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f36206f = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f36207g = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.k);
        this.f36209i = new b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.f36206f.f36137a;
        if (g.a((Context) contextThemeWrapper)) {
            i3 = R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        u.a((View) gridView, (androidx.core.h.a) new androidx.core.h.a() {
            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.a((Object) null);
            }
        });
        gridView.setAdapter(new e());
        gridView.setNumColumns(month.f36158e);
        gridView.setEnabled(false);
        this.m = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.m.setLayoutManager(new m(getContext(), i2) {
            public final void calculateExtraLayoutSpace(RecyclerView.s sVar, int[] iArr) {
                if (i2 == 0) {
                    iArr[0] = f.this.m.getWidth();
                    iArr[1] = f.this.m.getWidth();
                    return;
                }
                iArr[0] = f.this.m.getHeight();
                iArr[1] = f.this.m.getHeight();
            }
        });
        this.m.setTag(f36201a);
        final j jVar = new j(contextThemeWrapper, this.f36205e, this.f36206f, new b() {
            public final void a(long j) {
                if (f.this.f36206f.f36140d.a(j)) {
                    f.this.f36205e.a(j);
                    Iterator it2 = f.this.j.iterator();
                    while (it2.hasNext()) {
                        ((k) it2.next()).a(f.this.f36205e.a());
                    }
                    f.this.m.getAdapter().notifyDataSetChanged();
                    if (f.this.l != null) {
                        f.this.l.getAdapter().notifyDataSetChanged();
                    }
                }
            }
        });
        this.m.setAdapter(jVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        this.l = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        RecyclerView recyclerView = this.l;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.l.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.l.setAdapter(new p(this));
            this.l.addItemDecoration(new RecyclerView.h() {

                /* renamed from: b  reason: collision with root package name */
                private final Calendar f36219b = o.b();

                /* renamed from: c  reason: collision with root package name */
                private final Calendar f36220c = o.b();

                public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
                    int i2;
                    if ((recyclerView.getAdapter() instanceof p) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                        p pVar = (p) recyclerView.getAdapter();
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                        for (d next : f.this.f36205e.d()) {
                            if (!(next.f2964a == null || next.f2965b == null)) {
                                this.f36219b.setTimeInMillis(((Long) next.f2964a).longValue());
                                this.f36220c.setTimeInMillis(((Long) next.f2965b).longValue());
                                int a2 = pVar.a(this.f36219b.get(1));
                                int a3 = pVar.a(this.f36220c.get(1));
                                View findViewByPosition = gridLayoutManager.findViewByPosition(a2);
                                View findViewByPosition2 = gridLayoutManager.findViewByPosition(a3);
                                int spanCount = a2 / gridLayoutManager.getSpanCount();
                                int spanCount2 = a3 / gridLayoutManager.getSpanCount();
                                int i3 = spanCount;
                                while (i3 <= spanCount2) {
                                    View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i3);
                                    if (findViewByPosition3 != null) {
                                        int top = findViewByPosition3.getTop() + f.this.f36209i.f36187d.f36178a.top;
                                        int bottom = findViewByPosition3.getBottom() - f.this.f36209i.f36187d.f36178a.bottom;
                                        int left = i3 == spanCount ? findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2) : 0;
                                        if (i3 == spanCount2) {
                                            i2 = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                        } else {
                                            i2 = recyclerView.getWidth();
                                        }
                                        canvas.drawRect((float) left, (float) top, (float) i2, (float) bottom, f.this.f36209i.f36191h);
                                    }
                                    i3++;
                                }
                            }
                        }
                    }
                }
            });
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            final MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.month_navigation_fragment_toggle);
            materialButton.setTag(f36204d);
            u.a((View) materialButton, (androidx.core.h.a) new androidx.core.h.a() {
                public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                    String str;
                    super.onInitializeAccessibilityNodeInfo(view, cVar);
                    if (f.this.o.getVisibility() == 0) {
                        str = f.this.getString(R.string.mtrl_picker_toggle_to_year_selection);
                    } else {
                        str = f.this.getString(R.string.mtrl_picker_toggle_to_day_selection);
                    }
                    cVar.f((CharSequence) str);
                }
            });
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.month_navigation_previous);
            materialButton2.setTag(f36202b);
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R.id.month_navigation_next);
            materialButton3.setTag(f36203c);
            this.n = inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
            this.o = inflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            a(a.DAY);
            materialButton.setText(this.f36207g.f36155b);
            this.m.addOnScrollListener(new RecyclerView.l() {
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    int i4;
                    if (i2 < 0) {
                        i4 = f.this.a().findFirstVisibleItemPosition();
                    } else {
                        i4 = f.this.a().findLastVisibleItemPosition();
                    }
                    Month unused = f.this.f36207g = jVar.a(i4);
                    materialButton.setText(jVar.a(i4).f36155b);
                }

                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    if (i2 == 0) {
                        CharSequence text = materialButton.getText();
                        if (Build.VERSION.SDK_INT >= 16) {
                            recyclerView.announceForAccessibility(text);
                        } else {
                            recyclerView.sendAccessibilityEvent(EmiUtil.EMI_PLAN_REQUEST_CODE);
                        }
                    }
                }
            });
            materialButton.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    f fVar = f.this;
                    if (fVar.f36208h == a.YEAR) {
                        fVar.a(a.DAY);
                    } else if (fVar.f36208h == a.DAY) {
                        fVar.a(a.YEAR);
                    }
                }
            });
            materialButton3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int findFirstVisibleItemPosition = f.this.a().findFirstVisibleItemPosition() + 1;
                    if (findFirstVisibleItemPosition < f.this.m.getAdapter().getItemCount()) {
                        f.this.a(jVar.a(findFirstVisibleItemPosition));
                    }
                }
            });
            materialButton2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int findLastVisibleItemPosition = f.this.a().findLastVisibleItemPosition() - 1;
                    if (findLastVisibleItemPosition >= 0) {
                        f.this.a(jVar.a(findLastVisibleItemPosition));
                    }
                }
            });
        }
        if (!g.a((Context) contextThemeWrapper)) {
            new q().attachToRecyclerView(this.m);
        }
        this.m.scrollToPosition(jVar.a(this.f36207g));
        return inflate;
    }

    /* access modifiers changed from: package-private */
    public final void a(Month month) {
        j jVar = (j) this.m.getAdapter();
        final int a2 = jVar.a(month);
        int a3 = a2 - jVar.a(this.f36207g);
        boolean z = true;
        boolean z2 = Math.abs(a3) > 3;
        if (a3 <= 0) {
            z = false;
        }
        this.f36207g = month;
        if (z2 && z) {
            this.m.scrollToPosition(a2 - 3);
        } else if (z2) {
            this.m.scrollToPosition(a2 + 3);
        }
        this.m.post(new Runnable() {
            public final void run() {
                f.this.m.smoothScrollToPosition(a2);
            }
        });
    }

    static int a(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.f36208h = aVar;
        if (aVar == a.YEAR) {
            this.l.getLayoutManager().scrollToPosition(((p) this.l.getAdapter()).a(this.f36207g.f36157d));
            this.n.setVisibility(0);
            this.o.setVisibility(8);
        } else if (aVar == a.DAY) {
            this.n.setVisibility(8);
            this.o.setVisibility(0);
            a(this.f36207g);
        }
    }

    /* access modifiers changed from: package-private */
    public final LinearLayoutManager a() {
        return (LinearLayoutManager) this.m.getLayoutManager();
    }
}
