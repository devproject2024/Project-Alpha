package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f3375a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f3376b;

    /* renamed from: c  reason: collision with root package name */
    private Context f3377c;

    /* renamed from: d  reason: collision with root package name */
    private j f3378d;

    /* renamed from: e  reason: collision with root package name */
    private int f3379e;

    /* renamed from: f  reason: collision with root package name */
    private TabHost.OnTabChangeListener f3380f;

    /* renamed from: g  reason: collision with root package name */
    private a f3381g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3382h;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f3384a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f3385b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f3386c;

        /* renamed from: d  reason: collision with root package name */
        Fragment f3387d;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        String f3383a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3383a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f3383a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f3383a + "}";
        }
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        a(context, (AttributeSet) null);
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f3379e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    private void a(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f3376b = frameLayout2;
            this.f3376b.setId(this.f3379e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, j jVar) {
        a(context);
        super.setup();
        this.f3377c = context;
        this.f3378d = jVar;
        a();
    }

    @Deprecated
    public void setup(Context context, j jVar, int i2) {
        a(context);
        super.setup();
        this.f3377c = context;
        this.f3378d = jVar;
        this.f3379e = i2;
        a();
        this.f3376b.setId(i2);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    private void a() {
        if (this.f3376b == null) {
            this.f3376b = (FrameLayout) findViewById(this.f3379e);
            if (this.f3376b == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f3379e);
            }
        }
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f3380f = onTabChangeListener;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f3375a.size();
        q qVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f3375a.get(i2);
            aVar.f3387d = this.f3378d.c(aVar.f3384a);
            if (aVar.f3387d != null && !aVar.f3387d.isDetached()) {
                if (aVar.f3384a.equals(currentTabTag)) {
                    this.f3381g = aVar;
                } else {
                    if (qVar == null) {
                        qVar = this.f3378d.a();
                    }
                    qVar.d(aVar.f3387d);
                }
            }
        }
        this.f3382h = true;
        q a2 = a(currentTabTag, qVar);
        if (a2 != null) {
            a2.b();
            this.f3378d.b();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3382h = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3383a = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f3383a);
    }

    @Deprecated
    public void onTabChanged(String str) {
        q a2;
        if (this.f3382h && (a2 = a(str, (q) null)) != null) {
            a2.b();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f3380f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private q a(String str, q qVar) {
        a a2 = a(str);
        if (this.f3381g != a2) {
            if (qVar == null) {
                qVar = this.f3378d.a();
            }
            a aVar = this.f3381g;
            if (!(aVar == null || aVar.f3387d == null)) {
                qVar.d(this.f3381g.f3387d);
            }
            if (a2 != null) {
                if (a2.f3387d == null) {
                    a2.f3387d = this.f3378d.u().c(this.f3377c.getClassLoader(), a2.f3385b.getName());
                    a2.f3387d.setArguments(a2.f3386c);
                    qVar.a(this.f3379e, a2.f3387d, a2.f3384a);
                } else {
                    qVar.f(a2.f3387d);
                }
            }
            this.f3381g = a2;
        }
        return qVar;
    }

    private a a(String str) {
        int size = this.f3375a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f3375a.get(i2);
            if (aVar.f3384a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
