package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.b.g;
import androidx.preference.Preference;

public class EditTextPreference extends DialogPreference {

    /* renamed from: g  reason: collision with root package name */
    String f30770g;

    /* renamed from: h  reason: collision with root package name */
    a f30771h;

    public interface a {
    }

    private EditTextPreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextPreference, i2, 0);
        int i3 = R.styleable.EditTextPreference_useSimpleSummaryProvider;
        if (g.a(obtainStyledAttributes, i3, i3, false)) {
            if (b.f30773a == null) {
                b.f30773a = new b();
            }
            a((Preference.e) b.f30773a);
        }
        obtainStyledAttributes.recycle();
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.editTextPreferenceStyle, 16842898));
    }

    public final void a(String str) {
        boolean c2 = c();
        this.f30770g = str;
        c(str);
        boolean c3 = c();
        if (c3 != c2) {
            a(c3);
        }
        b();
    }

    /* access modifiers changed from: protected */
    public final Object a(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    public final boolean c() {
        return TextUtils.isEmpty(this.f30770g) || super.c();
    }

    /* access modifiers changed from: protected */
    public final Parcelable d() {
        Parcelable d2 = super.d();
        if (this.s) {
            return d2;
        }
        SavedState savedState = new SavedState(d2);
        savedState.f30772a = this.f30770g;
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
        a(savedState.f30772a);
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
        String f30772a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f30772a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f30772a);
        }
    }

    public static final class b implements Preference.e<EditTextPreference> {

        /* renamed from: a  reason: collision with root package name */
        static b f30773a;

        public final /* synthetic */ CharSequence a(Preference preference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            return TextUtils.isEmpty(editTextPreference.f30770g) ? editTextPreference.j.getString(R.string.not_set) : editTextPreference.f30770g;
        }

        b() {
        }
    }
}
