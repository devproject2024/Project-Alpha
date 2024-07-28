package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.b.g;
import androidx.preference.Preference;

public class ListPreference extends DialogPreference {
    private String B;
    private boolean C;

    /* renamed from: g  reason: collision with root package name */
    CharSequence[] f30774g;

    /* renamed from: h  reason: collision with root package name */
    CharSequence[] f30775h;

    /* renamed from: i  reason: collision with root package name */
    String f30776i;

    public ListPreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, i2, 0);
        this.f30774g = g.d(obtainStyledAttributes, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
        this.f30775h = g.d(obtainStyledAttributes, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
        int i3 = R.styleable.ListPreference_useSimpleSummaryProvider;
        if (g.a(obtainStyledAttributes, i3, i3, false)) {
            if (a.f30778a == null) {
                a.f30778a = new a();
            }
            a((Preference.e) a.f30778a);
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i2, 0);
        this.B = g.b(obtainStyledAttributes2, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public final void a(CharSequence charSequence) {
        super.a(charSequence);
        if (charSequence == null && this.B != null) {
            this.B = null;
        } else if (charSequence != null && !charSequence.equals(this.B)) {
            this.B = charSequence.toString();
        }
    }

    public final void a(String str) {
        boolean z = !TextUtils.equals(this.f30776i, str);
        if (z || !this.C) {
            this.f30776i = str;
            this.C = true;
            c(str);
            if (z) {
                b();
            }
        }
    }

    public final CharSequence g() {
        CharSequence[] charSequenceArr;
        int o = o();
        if (o < 0 || (charSequenceArr = this.f30774g) == null) {
            return null;
        }
        return charSequenceArr[o];
    }

    public final int b(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f30775h) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.f30775h[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    private int o() {
        return b(this.f30776i);
    }

    /* access modifiers changed from: protected */
    public final Object a(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    /* access modifiers changed from: protected */
    public final Parcelable d() {
        Parcelable d2 = super.d();
        if (this.s) {
            return d2;
        }
        SavedState savedState = new SavedState(d2);
        savedState.f30777a = this.f30776i;
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
        a(savedState.f30777a);
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
        String f30777a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f30777a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f30777a);
        }
    }

    public static final class a implements Preference.e<ListPreference> {

        /* renamed from: a  reason: collision with root package name */
        static a f30778a;

        public final /* synthetic */ CharSequence a(Preference preference) {
            ListPreference listPreference = (ListPreference) preference;
            if (TextUtils.isEmpty(listPreference.g())) {
                return listPreference.j.getString(R.string.not_set);
            }
            return listPreference.g();
        }

        a() {
        }
    }

    public final CharSequence f() {
        if (this.A != null) {
            return this.A.a(this);
        }
        Object g2 = g();
        CharSequence f2 = super.f();
        String str = this.B;
        if (str == null) {
            return f2;
        }
        Object[] objArr = new Object[1];
        if (g2 == null) {
            g2 = "";
        }
        objArr[0] = g2;
        String format = String.format(str, objArr);
        return TextUtils.equals(format, f2) ? f2 : format;
    }
}
