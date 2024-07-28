package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.c;
import androidx.core.h.a.c;
import androidx.core.h.u;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    final a f1445a;

    /* renamed from: b  reason: collision with root package name */
    final View f1446b;

    /* renamed from: c  reason: collision with root package name */
    final Drawable f1447c;

    /* renamed from: d  reason: collision with root package name */
    final FrameLayout f1448d;

    /* renamed from: e  reason: collision with root package name */
    final FrameLayout f1449e;

    /* renamed from: f  reason: collision with root package name */
    final ImageView f1450f;

    /* renamed from: g  reason: collision with root package name */
    androidx.core.h.b f1451g;

    /* renamed from: h  reason: collision with root package name */
    final DataSetObserver f1452h;

    /* renamed from: i  reason: collision with root package name */
    PopupWindow.OnDismissListener f1453i;
    boolean j;
    int k;
    int l;
    private final b m;
    private final ImageView n;
    private final int o;
    private final ViewTreeObserver.OnGlobalLayoutListener p;
    private ListPopupWindow q;
    private boolean r;

    public ActivityChooserView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1452h = new DataSetObserver() {
            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f1445a.notifyDataSetChanged();
            }

            public final void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f1445a.notifyDataSetInvalidated();
            }
        };
        this.p = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (!ActivityChooserView.this.c()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().d();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().a_();
                if (ActivityChooserView.this.f1451g != null) {
                    ActivityChooserView.this.f1451g.a(true);
                }
            }
        };
        this.k = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i2, 0);
        u.a(this, context, R.styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i2);
        this.k = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
        this.m = new b();
        this.f1446b = findViewById(R.id.activity_chooser_view_content);
        this.f1447c = this.f1446b.getBackground();
        this.f1449e = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f1449e.setOnClickListener(this.m);
        this.f1449e.setOnLongClickListener(this.m);
        this.f1450f = (ImageView) this.f1449e.findViewById(R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.m);
        frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                c a2 = c.a(accessibilityNodeInfo);
                if (Build.VERSION.SDK_INT >= 19) {
                    a2.f3041a.setCanOpenPopup(true);
                }
            }
        });
        frameLayout.setOnTouchListener(new r(frameLayout) {
            public final p a() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* access modifiers changed from: protected */
            public final boolean b() {
                ActivityChooserView.this.a();
                return true;
            }

            /* access modifiers changed from: protected */
            public final boolean c() {
                ActivityChooserView.this.b();
                return true;
            }
        });
        this.f1448d = frameLayout;
        this.n = (ImageView) frameLayout.findViewById(R.id.image);
        this.n.setImageDrawable(drawable);
        this.f1445a = new a();
        this.f1445a.registerDataSetObserver(new DataSetObserver() {
            public final void onChanged() {
                super.onChanged();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (activityChooserView.f1445a.getCount() > 0) {
                    activityChooserView.f1448d.setEnabled(true);
                } else {
                    activityChooserView.f1448d.setEnabled(false);
                }
                int a2 = activityChooserView.f1445a.f1460a.a();
                int c2 = activityChooserView.f1445a.f1460a.c();
                if (a2 == 1 || (a2 > 1 && c2 > 0)) {
                    activityChooserView.f1449e.setVisibility(0);
                    ResolveInfo b2 = activityChooserView.f1445a.f1460a.b();
                    PackageManager packageManager = activityChooserView.getContext().getPackageManager();
                    activityChooserView.f1450f.setImageDrawable(b2.loadIcon(packageManager));
                    if (activityChooserView.l != 0) {
                        CharSequence loadLabel = b2.loadLabel(packageManager);
                        activityChooserView.f1449e.setContentDescription(activityChooserView.getContext().getString(activityChooserView.l, new Object[]{loadLabel}));
                    }
                } else {
                    activityChooserView.f1449e.setVisibility(8);
                }
                if (activityChooserView.f1449e.getVisibility() == 0) {
                    activityChooserView.f1446b.setBackgroundDrawable(activityChooserView.f1447c);
                } else {
                    activityChooserView.f1446b.setBackgroundDrawable((Drawable) null);
                }
            }
        });
        Resources resources = context.getResources();
        this.o = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(c cVar) {
        a aVar = this.f1445a;
        c cVar2 = ActivityChooserView.this.f1445a.f1460a;
        if (cVar2 != null && ActivityChooserView.this.isShown()) {
            cVar2.unregisterObserver(ActivityChooserView.this.f1452h);
        }
        aVar.f1460a = cVar;
        if (cVar != null && ActivityChooserView.this.isShown()) {
            cVar.registerObserver(ActivityChooserView.this.f1452h);
        }
        aVar.notifyDataSetChanged();
        if (getListPopupWindow().p.isShowing()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.n.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.n.setContentDescription(getContext().getString(i2));
    }

    public void setProvider(androidx.core.h.b bVar) {
        this.f1451g = bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (this.f1445a.f1460a != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.p);
            boolean z = this.f1449e.getVisibility() == 0;
            int a2 = this.f1445a.f1460a.a();
            if (i2 == Integer.MAX_VALUE || a2 <= i2 + (z ? 1 : 0)) {
                this.f1445a.a(false);
                this.f1445a.a(i2);
            } else {
                this.f1445a.a(true);
                this.f1445a.a(i2 - 1);
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.p.isShowing()) {
                if (this.j || !z) {
                    this.f1445a.a(true, z);
                } else {
                    this.f1445a.a(false, false);
                }
                listPopupWindow.d(Math.min(this.f1445a.a(), this.o));
                listPopupWindow.a_();
                androidx.core.h.b bVar = this.f1451g;
                if (bVar != null) {
                    bVar.a(true);
                }
                listPopupWindow.f1557e.setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
                listPopupWindow.f1557e.setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public final boolean c() {
        return getListPopupWindow().p.isShowing();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.f1445a.f1460a;
        if (cVar != null) {
            cVar.registerObserver(this.f1452h);
        }
        this.r = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f1445a.f1460a;
        if (cVar != null) {
            cVar.unregisterObserver(this.f1452h);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.p);
        }
        if (c()) {
            b();
        }
        this.r = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View view = this.f1446b;
        if (this.f1449e.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f1446b.layout(0, 0, i4 - i2, i5 - i3);
        if (!c()) {
            b();
        }
    }

    public c getDataModel() {
        return this.f1445a.f1460a;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1453i = onDismissListener;
    }

    public void setInitialActivityCount(int i2) {
        this.k = i2;
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.l = i2;
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.q == null) {
            this.q = new ListPopupWindow(getContext());
            this.q.a((ListAdapter) this.f1445a);
            ListPopupWindow listPopupWindow = this.q;
            listPopupWindow.k = this;
            listPopupWindow.i();
            ListPopupWindow listPopupWindow2 = this.q;
            b bVar = this.m;
            listPopupWindow2.l = bVar;
            listPopupWindow2.a((PopupWindow.OnDismissListener) bVar);
        }
        return this.q;
    }

    class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        b() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i2);
            if (itemViewType == 0) {
                ActivityChooserView.this.b();
                if (!ActivityChooserView.this.j) {
                    if (!ActivityChooserView.this.f1445a.f1461b) {
                        i2++;
                    }
                    Intent b2 = ActivityChooserView.this.f1445a.f1460a.b(i2);
                    if (b2 != null) {
                        b2.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(b2);
                    }
                } else if (i2 > 0) {
                    c cVar = ActivityChooserView.this.f1445a.f1460a;
                    synchronized (cVar.f1711b) {
                        cVar.d();
                        c.a aVar = cVar.f1712c.get(i2);
                        c.a aVar2 = cVar.f1712c.get(0);
                        cVar.a(new c.C0025c(new ComponentName(aVar.f1717a.activityInfo.packageName, aVar.f1717a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1718b - aVar.f1718b) + 5.0f : 1.0f));
                    }
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.a(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final void onClick(View view) {
            if (view == ActivityChooserView.this.f1449e) {
                ActivityChooserView.this.b();
                Intent b2 = ActivityChooserView.this.f1445a.f1460a.b(ActivityChooserView.this.f1445a.f1460a.a(ActivityChooserView.this.f1445a.f1460a.b()));
                if (b2 != null) {
                    b2.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(b2);
                }
            } else if (view == ActivityChooserView.this.f1448d) {
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                activityChooserView.j = false;
                activityChooserView.a(activityChooserView.k);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.f1449e) {
                if (ActivityChooserView.this.f1445a.getCount() > 0) {
                    ActivityChooserView activityChooserView = ActivityChooserView.this;
                    activityChooserView.j = true;
                    activityChooserView.a(activityChooserView.k);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public final void onDismiss() {
            if (ActivityChooserView.this.f1453i != null) {
                ActivityChooserView.this.f1453i.onDismiss();
            }
            if (ActivityChooserView.this.f1451g != null) {
                ActivityChooserView.this.f1451g.a(false);
            }
        }
    }

    class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        c f1460a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1461b;

        /* renamed from: d  reason: collision with root package name */
        private int f1463d = 4;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1464e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1465f;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        a() {
        }

        public final int getItemViewType(int i2) {
            return (!this.f1465f || i2 != getCount() - 1) ? 0 : 1;
        }

        public final int getCount() {
            int a2 = this.f1460a.a();
            if (!this.f1461b && this.f1460a.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.f1463d);
            return this.f1465f ? min + 1 : min;
        }

        public final Object getItem(int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (!this.f1461b && this.f1460a.b() != null) {
                    i2++;
                }
                return this.f1460a.a(i2);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i2);
                ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f1461b || i2 != 0 || !this.f1464e) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public final int a() {
            int i2 = this.f1463d;
            this.f1463d = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            for (int i4 = 0; i4 < count; i4++) {
                view = getView(i4, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
            }
            this.f1463d = i2;
            return i3;
        }

        public final void a(int i2) {
            if (this.f1463d != i2) {
                this.f1463d = i2;
                notifyDataSetChanged();
            }
        }

        public final void a(boolean z) {
            if (this.f1465f != z) {
                this.f1465f = z;
                notifyDataSetChanged();
            }
        }

        public final void a(boolean z, boolean z2) {
            if (this.f1461b != z || this.f1464e != z2) {
                this.f1461b = z;
                this.f1464e = z2;
                notifyDataSetChanged();
            }
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f1459a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ac a2 = ac.a(context, attributeSet, f1459a);
            setBackgroundDrawable(a2.a(0));
            a2.f1669a.recycle();
        }
    }

    public final boolean a() {
        if (getListPopupWindow().p.isShowing() || !this.r) {
            return false;
        }
        this.j = false;
        a(this.k);
        return true;
    }

    public final boolean b() {
        if (!getListPopupWindow().p.isShowing()) {
            return true;
        }
        getListPopupWindow().d();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.p);
        return true;
    }
}
