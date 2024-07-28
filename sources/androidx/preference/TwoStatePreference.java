package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

public abstract class TwoStatePreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f30828a;

    /* renamed from: b  reason: collision with root package name */
    boolean f30829b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f30830c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f30831d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30832e;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        boolean z = !this.f30828a;
        Boolean.valueOf(z);
        if (l()) {
            d(z);
        }
    }

    public final void d(boolean z) {
        boolean z2 = this.f30828a != z;
        if (z2 || !this.f30832e) {
            this.f30828a = z;
            this.f30832e = true;
            c(z);
            if (z2) {
                a(c());
                b();
            }
        }
    }

    public final boolean c() {
        return (this.f30829b ? this.f30828a : !this.f30828a) || super.c();
    }

    public final void c(CharSequence charSequence) {
        this.f30830c = charSequence;
        if (this.f30828a) {
            b();
        }
    }

    public final void d(CharSequence charSequence) {
        this.f30831d = charSequence;
        if (!this.f30828a) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(TypedArray typedArray, int i2) {
        return Boolean.valueOf(typedArray.getBoolean(i2, false));
    }

    /* access modifiers changed from: protected */
    public final void b(k kVar) {
        b(kVar.a(16908304));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0 = 1
            boolean r1 = r4.f30828a
            r2 = 0
            if (r1 == 0) goto L_0x001c
            java.lang.CharSequence r1 = r4.f30830c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x001c
            java.lang.CharSequence r0 = r4.f30830c
            r5.setText(r0)
        L_0x001a:
            r0 = 0
            goto L_0x002e
        L_0x001c:
            boolean r1 = r4.f30828a
            if (r1 != 0) goto L_0x002e
            java.lang.CharSequence r1 = r4.f30831d
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x002e
            java.lang.CharSequence r0 = r4.f30831d
            r5.setText(r0)
            goto L_0x001a
        L_0x002e:
            if (r0 == 0) goto L_0x003e
            java.lang.CharSequence r1 = r4.f()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x003e
            r5.setText(r1)
            r0 = 0
        L_0x003e:
            r1 = 8
            if (r0 != 0) goto L_0x0043
            r1 = 0
        L_0x0043:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L_0x004c
            r5.setVisibility(r1)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.b(android.view.View):void");
    }

    /* access modifiers changed from: protected */
    public final Parcelable d() {
        Parcelable d2 = super.d();
        if (this.s) {
            return d2;
        }
        SavedState savedState = new SavedState(d2);
        savedState.f30833a = this.f30828a;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public final void a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.a(savedState.getSuperState());
        d(savedState.f30833a);
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
        boolean f30833a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f30833a = parcel.readInt() != 1 ? false : true;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f30833a ? 1 : 0);
        }
    }
}
