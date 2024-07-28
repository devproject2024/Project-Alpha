package androidx.preference;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.preference.DialogPreference;
import androidx.preference.i;
import androidx.recyclerview.widget.RecyclerView;

public abstract class g extends Fragment implements DialogPreference.a, i.a, i.b, i.c {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f30854a;

    /* renamed from: b  reason: collision with root package name */
    private final a f30855b = new a();

    /* renamed from: c  reason: collision with root package name */
    private i f30856c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30857d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30858e;

    /* renamed from: f  reason: collision with root package name */
    private int f30859f = R.layout.preference_list_fragment;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f30860g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f30861h = new Handler() {
        public final void handleMessage(Message message) {
            if (message.what == 1) {
                g.this.b();
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f30862i = new Runnable() {
        public final void run() {
            g.this.f30854a.focusableViewAvailable(g.this.f30854a);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = R.style.PreferenceThemeOverlay;
        }
        getActivity().getTheme().applyStyle(i2, false);
        this.f30856c = new i(getContext());
        this.f30856c.f30891g = this;
        if (getArguments() != null) {
            getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        }
    }

    /* JADX WARNING: type inference failed for: r8v16, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r8, android.view.ViewGroup r9, android.os.Bundle r10) {
        /*
            r7 = this;
            android.content.Context r10 = r7.getContext()
            int[] r0 = androidx.preference.R.styleable.PreferenceFragmentCompat
            int r1 = androidx.preference.R.attr.preferenceFragmentCompatStyle
            r2 = 0
            r3 = 0
            android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r3, r0, r1, r2)
            int r0 = androidx.preference.R.styleable.PreferenceFragmentCompat_android_layout
            int r1 = r7.f30859f
            int r0 = r10.getResourceId(r0, r1)
            r7.f30859f = r0
            int r0 = androidx.preference.R.styleable.PreferenceFragmentCompat_android_divider
            android.graphics.drawable.Drawable r0 = r10.getDrawable(r0)
            int r1 = androidx.preference.R.styleable.PreferenceFragmentCompat_android_dividerHeight
            r3 = -1
            int r1 = r10.getDimensionPixelSize(r1, r3)
            int r4 = androidx.preference.R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem
            r5 = 1
            boolean r4 = r10.getBoolean(r4, r5)
            r10.recycle()
            android.content.Context r10 = r7.getContext()
            android.view.LayoutInflater r8 = r8.cloneInContext(r10)
            int r10 = r7.f30859f
            android.view.View r9 = r8.inflate(r10, r9, r2)
            r10 = 16908351(0x102003f, float:2.3877406E-38)
            android.view.View r10 = r9.findViewById(r10)
            boolean r5 = r10 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x00cf
            android.view.ViewGroup r10 = (android.view.ViewGroup) r10
            android.content.Context r5 = r7.getContext()
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            java.lang.String r6 = "android.hardware.type.automotive"
            boolean r5 = r5.hasSystemFeature(r6)
            if (r5 == 0) goto L_0x0065
            int r5 = androidx.preference.R.id.recycler_view
            android.view.View r5 = r10.findViewById(r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 == 0) goto L_0x0065
            goto L_0x0082
        L_0x0065:
            int r5 = androidx.preference.R.layout.preference_recyclerview
            android.view.View r8 = r8.inflate(r5, r10, r2)
            r5 = r8
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            androidx.recyclerview.widget.LinearLayoutManager r8 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r6 = r7.getContext()
            r8.<init>(r6)
            r5.setLayoutManager(r8)
            androidx.preference.j r8 = new androidx.preference.j
            r8.<init>(r5)
            r5.setAccessibilityDelegateCompat(r8)
        L_0x0082:
            if (r5 == 0) goto L_0x00c7
            r7.f30854a = r5
            androidx.preference.g$a r8 = r7.f30855b
            r5.addItemDecoration(r8)
            androidx.preference.g$a r8 = r7.f30855b
            if (r0 == 0) goto L_0x0096
            int r2 = r0.getIntrinsicHeight()
            r8.f30866b = r2
            goto L_0x0098
        L_0x0096:
            r8.f30866b = r2
        L_0x0098:
            r8.f30865a = r0
            androidx.preference.g r8 = androidx.preference.g.this
            androidx.recyclerview.widget.RecyclerView r8 = r8.f30854a
            r8.invalidateItemDecorations()
            if (r1 == r3) goto L_0x00ae
            androidx.preference.g$a r8 = r7.f30855b
            r8.f30866b = r1
            androidx.preference.g r8 = androidx.preference.g.this
            androidx.recyclerview.widget.RecyclerView r8 = r8.f30854a
            r8.invalidateItemDecorations()
        L_0x00ae:
            androidx.preference.g$a r8 = r7.f30855b
            r8.f30867c = r4
            androidx.recyclerview.widget.RecyclerView r8 = r7.f30854a
            android.view.ViewParent r8 = r8.getParent()
            if (r8 != 0) goto L_0x00bf
            androidx.recyclerview.widget.RecyclerView r8 = r7.f30854a
            r10.addView(r8)
        L_0x00bf:
            android.os.Handler r8 = r7.f30861h
            java.lang.Runnable r10 = r7.f30862i
            r8.post(r10)
            return r9
        L_0x00c7:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r9 = "Could not create RecyclerView"
            r8.<init>(r9)
            throw r8
        L_0x00cf:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.g.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle("android:preferences")) == null || (preferenceScreen = this.f30856c.f30887c) == null)) {
            preferenceScreen.b(bundle2);
        }
        if (this.f30857d) {
            b();
            Runnable runnable = this.f30860g;
            if (runnable != null) {
                runnable.run();
                this.f30860g = null;
            }
        }
        this.f30858e = true;
    }

    public void onStart() {
        super.onStart();
        i iVar = this.f30856c;
        iVar.f30889e = this;
        iVar.f30890f = this;
    }

    public void onStop() {
        super.onStop();
        i iVar = this.f30856c;
        iVar.f30889e = null;
        iVar.f30890f = null;
    }

    public void onDestroyView() {
        this.f30861h.removeCallbacks(this.f30862i);
        this.f30861h.removeMessages(1);
        if (this.f30857d) {
            this.f30854a.setAdapter((RecyclerView.a) null);
            PreferenceScreen preferenceScreen = this.f30856c.f30887c;
            if (preferenceScreen != null) {
                preferenceScreen.n();
            }
        }
        this.f30854a = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = this.f30856c.f30887c;
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.a(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    private static RecyclerView.a a(PreferenceScreen preferenceScreen) {
        return new h(preferenceScreen);
    }

    class a extends RecyclerView.h {

        /* renamed from: a  reason: collision with root package name */
        Drawable f30865a;

        /* renamed from: b  reason: collision with root package name */
        int f30866b;

        /* renamed from: c  reason: collision with root package name */
        boolean f30867c = true;

        a() {
        }

        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            if (this.f30865a != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (a(childAt, recyclerView)) {
                        int y = ((int) childAt.getY()) + childAt.getHeight();
                        this.f30865a.setBounds(0, y, width, this.f30866b + y);
                        this.f30865a.draw(canvas);
                    }
                }
            }
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            if (a(view, recyclerView)) {
                rect.bottom = this.f30866b;
            }
        }

        private boolean a(View view, RecyclerView recyclerView) {
            RecyclerView.v childViewHolder = recyclerView.getChildViewHolder(view);
            if (!((childViewHolder instanceof k) && ((k) childViewHolder).f30901b)) {
                return false;
            }
            boolean z = this.f30867c;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild >= recyclerView.getChildCount() - 1) {
                return z;
            }
            RecyclerView.v childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
            return (childViewHolder2 instanceof k) && ((k) childViewHolder2).f30900a;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        PreferenceScreen preferenceScreen = this.f30856c.f30887c;
        if (preferenceScreen != null) {
            this.f30854a.setAdapter(a(preferenceScreen));
            preferenceScreen.m();
        }
    }
}
