package androidx.legacy.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
    private final ArrayList<a> f3562a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f3563b;

    /* renamed from: c  reason: collision with root package name */
    private Context f3564c;

    /* renamed from: d  reason: collision with root package name */
    private FragmentManager f3565d;

    /* renamed from: e  reason: collision with root package name */
    private int f3566e;

    /* renamed from: f  reason: collision with root package name */
    private TabHost.OnTabChangeListener f3567f;

    /* renamed from: g  reason: collision with root package name */
    private a f3568g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3569h;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f3571a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f3572b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f3573c;

        /* renamed from: d  reason: collision with root package name */
        Fragment f3574d;
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
        String f3570a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3570a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f3570a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f3570a + "}";
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
        this.f3566e = obtainStyledAttributes.getResourceId(0, 0);
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
            this.f3563b = frameLayout2;
            this.f3563b.setId(this.f3566e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager) {
        a(context);
        super.setup();
        this.f3564c = context;
        this.f3565d = fragmentManager;
        a();
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager, int i2) {
        a(context);
        super.setup();
        this.f3564c = context;
        this.f3565d = fragmentManager;
        this.f3566e = i2;
        a();
        this.f3563b.setId(i2);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    private void a() {
        if (this.f3563b == null) {
            this.f3563b = (FrameLayout) findViewById(this.f3566e);
            if (this.f3563b == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f3566e);
            }
        }
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f3567f = onTabChangeListener;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i2 = 0; i2 < this.f3562a.size(); i2++) {
            a aVar = this.f3562a.get(i2);
            aVar.f3574d = this.f3565d.findFragmentByTag(aVar.f3571a);
            if (aVar.f3574d != null && !aVar.f3574d.isDetached()) {
                if (aVar.f3571a.equals(currentTabTag)) {
                    this.f3568g = aVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f3565d.beginTransaction();
                    }
                    fragmentTransaction.detach(aVar.f3574d);
                }
            }
        }
        this.f3569h = true;
        FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.commit();
            this.f3565d.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3569h = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3570a = getCurrentTabTag();
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
        setCurrentTabByTag(savedState.f3570a);
    }

    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction a2;
        if (this.f3569h && (a2 = a(str, (FragmentTransaction) null)) != null) {
            a2.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f3567f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        a aVar = null;
        for (int i2 = 0; i2 < this.f3562a.size(); i2++) {
            a aVar2 = this.f3562a.get(i2);
            if (aVar2.f3571a.equals(str)) {
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            if (this.f3568g != aVar) {
                if (fragmentTransaction == null) {
                    fragmentTransaction = this.f3565d.beginTransaction();
                }
                a aVar3 = this.f3568g;
                if (!(aVar3 == null || aVar3.f3574d == null)) {
                    fragmentTransaction.detach(this.f3568g.f3574d);
                }
                if (aVar != null) {
                    if (aVar.f3574d == null) {
                        aVar.f3574d = Fragment.instantiate(this.f3564c, aVar.f3572b.getName(), aVar.f3573c);
                        fragmentTransaction.add(this.f3566e, aVar.f3574d, aVar.f3571a);
                    } else {
                        fragmentTransaction.attach(aVar.f3574d);
                    }
                }
                this.f3568g = aVar;
            }
            return fragmentTransaction;
        }
        throw new IllegalStateException("No tab known for tag ".concat(String.valueOf(str)));
    }
}
