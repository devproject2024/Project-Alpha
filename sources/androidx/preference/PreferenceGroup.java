package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.a.g;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.List;

public abstract class PreferenceGroup extends Preference {

    /* renamed from: a  reason: collision with root package name */
    final g<String, Long> f30794a;

    /* renamed from: b  reason: collision with root package name */
    List<Preference> f30795b;

    /* renamed from: c  reason: collision with root package name */
    int f30796c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f30797d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30798e;

    /* renamed from: f  reason: collision with root package name */
    private int f30799f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f30800g;

    /* renamed from: h  reason: collision with root package name */
    private a f30801h;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f30802i;

    public interface a {
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        this.f30794a = new g<>();
        this.f30797d = new Handler();
        this.f30798e = true;
        this.f30799f = 0;
        this.f30800g = false;
        this.f30796c = Integer.MAX_VALUE;
        this.f30801h = null;
        this.f30802i = new Runnable() {
            public final void run() {
                synchronized (this) {
                    PreferenceGroup.this.f30794a.clear();
                }
            }
        };
        this.f30795b = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, i2, 0);
        int i3 = R.styleable.PreferenceGroup_orderingFromXml;
        this.f30798e = androidx.core.content.b.g.a(obtainStyledAttributes, i3, i3, true);
        if (obtainStyledAttributes.hasValue(R.styleable.PreferenceGroup_initialExpandedChildrenCount)) {
            int i4 = R.styleable.PreferenceGroup_initialExpandedChildrenCount;
            a(androidx.core.content.b.g.a(obtainStyledAttributes, i4, i4));
        }
        obtainStyledAttributes.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(int i2) {
        if (i2 != Integer.MAX_VALUE && !j()) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" should have a key defined if it contains an expandable preference");
        }
        this.f30796c = i2;
    }

    public final int g() {
        return this.f30795b.size();
    }

    public final Preference b(int i2) {
        return this.f30795b.get(i2);
    }

    public final void m() {
        super.m();
        this.f30800g = true;
        int g2 = g();
        for (int i2 = 0; i2 < g2; i2++) {
            b(i2).m();
        }
    }

    public final void n() {
        super.n();
        this.f30800g = false;
        int g2 = g();
        for (int i2 = 0; i2 < g2; i2++) {
            b(i2).n();
        }
    }

    public final void a(boolean z) {
        super.a(z);
        int g2 = g();
        for (int i2 = 0; i2 < g2; i2++) {
            b(i2).b(z);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Bundle bundle) {
        super.a(bundle);
        int g2 = g();
        for (int i2 = 0; i2 < g2; i2++) {
            b(i2).a(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(Bundle bundle) {
        super.b(bundle);
        int g2 = g();
        for (int i2 = 0; i2 < g2; i2++) {
            b(i2).b(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public final Parcelable d() {
        return new SavedState(super.d(), this.f30796c);
    }

    /* access modifiers changed from: protected */
    public final void a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f30796c = savedState.f30804a;
        super.a(savedState.getSuperState());
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f30804a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f30804a = parcel.readInt();
        }

        SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f30804a = i2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f30804a);
        }
    }

    public final <T extends Preference> T c(CharSequence charSequence) {
        T c2;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else if (TextUtils.equals(this.p, charSequence)) {
            return this;
        } else {
            int g2 = g();
            for (int i2 = 0; i2 < g2; i2++) {
                T b2 = b(i2);
                if (TextUtils.equals(b2.p, charSequence)) {
                    return b2;
                }
                if ((b2 instanceof PreferenceGroup) && (c2 = ((PreferenceGroup) b2).c(charSequence)) != null) {
                    return c2;
                }
            }
            return null;
        }
    }
}
