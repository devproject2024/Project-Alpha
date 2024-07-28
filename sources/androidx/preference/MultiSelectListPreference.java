package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.core.content.b.g;
import androidx.preference.Preference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreference extends DialogPreference {

    /* renamed from: g  reason: collision with root package name */
    CharSequence[] f30779g;

    /* renamed from: h  reason: collision with root package name */
    CharSequence[] f30780h;

    /* renamed from: i  reason: collision with root package name */
    Set<String> f30781i;

    private MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        this.f30781i = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MultiSelectListPreference, i2, 0);
        this.f30779g = g.d(obtainStyledAttributes, R.styleable.MultiSelectListPreference_entries, R.styleable.MultiSelectListPreference_android_entries);
        this.f30780h = g.d(obtainStyledAttributes, R.styleable.MultiSelectListPreference_entryValues, R.styleable.MultiSelectListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public final void a(Set<String> set) {
        this.f30781i.clear();
        this.f30781i.addAll(set);
        if (super.k()) {
            Set<String> set2 = null;
            if (super.k() && super.h() == null) {
                set2 = this.k.a().getStringSet(this.p, (Set) null);
            }
            if (!set.equals(set2)) {
                if (super.h() == null) {
                    SharedPreferences.Editor b2 = this.k.b();
                    b2.putStringSet(this.p, set);
                    super.a(b2);
                } else {
                    throw new UnsupportedOperationException("Not implemented on this data store");
                }
            }
        }
        b();
    }

    /* access modifiers changed from: protected */
    public final Object a(TypedArray typedArray, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    /* access modifiers changed from: protected */
    public final Parcelable d() {
        Parcelable d2 = super.d();
        if (this.s) {
            return d2;
        }
        SavedState savedState = new SavedState(d2);
        savedState.f30782a = this.f30781i;
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
        a(savedState.f30782a);
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
        Set<String> f30782a;

        SavedState(Parcel parcel) {
            super(parcel);
            int readInt = parcel.readInt();
            this.f30782a = new HashSet();
            String[] strArr = new String[readInt];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f30782a, strArr);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f30782a.size());
            Set<String> set = this.f30782a;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }
    }
}
