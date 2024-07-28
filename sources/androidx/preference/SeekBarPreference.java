package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

public class SeekBarPreference extends Preference {
    private boolean B;
    private SeekBar.OnSeekBarChangeListener C;
    private View.OnKeyListener D;

    /* renamed from: a  reason: collision with root package name */
    int f30806a;

    /* renamed from: b  reason: collision with root package name */
    int f30807b;

    /* renamed from: c  reason: collision with root package name */
    boolean f30808c;

    /* renamed from: d  reason: collision with root package name */
    SeekBar f30809d;

    /* renamed from: e  reason: collision with root package name */
    boolean f30810e;

    /* renamed from: f  reason: collision with root package name */
    boolean f30811f;

    /* renamed from: g  reason: collision with root package name */
    private int f30812g;

    /* renamed from: h  reason: collision with root package name */
    private int f30813h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f30814i;

    private SeekBarPreference(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, (byte) 0);
        this.C = new SeekBar.OnSeekBarChangeListener() {
            public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (!z || (!SeekBarPreference.this.f30811f && SeekBarPreference.this.f30808c)) {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    seekBarPreference.a(i2 + seekBarPreference.f30807b);
                    return;
                }
                SeekBarPreference.this.a(seekBar);
            }

            public final void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.f30808c = true;
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.f30808c = false;
                if (seekBar.getProgress() + SeekBarPreference.this.f30807b != SeekBarPreference.this.f30806a) {
                    SeekBarPreference.this.a(seekBar);
                }
            }
        };
        this.D = new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if ((!SeekBarPreference.this.f30810e && (i2 == 21 || i2 == 22)) || i2 == 23 || i2 == 66 || SeekBarPreference.this.f30809d == null) {
                    return false;
                }
                return SeekBarPreference.this.f30809d.onKeyDown(i2, keyEvent);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, i2, 0);
        this.f30807b = obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100);
        int i4 = this.f30807b;
        i3 = i3 < i4 ? i4 : i3;
        if (i3 != this.f30812g) {
            this.f30812g = i3;
            b();
        }
        int i5 = obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0);
        if (i5 != this.f30813h) {
            this.f30813h = Math.min(this.f30812g - this.f30807b, Math.abs(i5));
            b();
        }
        this.f30810e = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.f30811f = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        obtainStyledAttributes.recycle();
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }

    public final void a(k kVar) {
        super.a(kVar);
        kVar.itemView.setOnKeyListener(this.D);
        this.f30809d = (SeekBar) kVar.a(R.id.seekbar);
        this.f30814i = (TextView) kVar.a(R.id.seekbar_value);
        if (this.B) {
            this.f30814i.setVisibility(0);
        } else {
            this.f30814i.setVisibility(8);
            this.f30814i = null;
        }
        SeekBar seekBar = this.f30809d;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(this.C);
            this.f30809d.setMax(this.f30812g - this.f30807b);
            int i2 = this.f30813h;
            if (i2 != 0) {
                this.f30809d.setKeyProgressIncrement(i2);
            } else {
                this.f30813h = this.f30809d.getKeyProgressIncrement();
            }
            this.f30809d.setProgress(this.f30806a - this.f30807b);
            a(this.f30806a);
            this.f30809d.setEnabled(i());
        }
    }

    /* access modifiers changed from: protected */
    public final Object a(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    /* access modifiers changed from: package-private */
    public final void a(SeekBar seekBar) {
        int progress = this.f30807b + seekBar.getProgress();
        if (progress != this.f30806a) {
            Integer.valueOf(progress);
            if (l()) {
                int i2 = this.f30807b;
                if (progress >= i2) {
                    i2 = progress;
                }
                int i3 = this.f30812g;
                if (i2 > i3) {
                    i2 = i3;
                }
                if (i2 != this.f30806a) {
                    this.f30806a = i2;
                    a(this.f30806a);
                    if (super.k()) {
                        int i4 = ~i2;
                        if (super.k() && super.h() == null) {
                            i4 = this.k.a().getInt(this.p, i4);
                        }
                        if (i2 == i4) {
                            return;
                        }
                        if (super.h() == null) {
                            SharedPreferences.Editor b2 = this.k.b();
                            b2.putInt(this.p, i2);
                            super.a(b2);
                            return;
                        }
                        throw new UnsupportedOperationException("Not implemented on this data store");
                    }
                    return;
                }
                return;
            }
            seekBar.setProgress(this.f30806a - this.f30807b);
            a(this.f30806a);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        TextView textView = this.f30814i;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
    }

    /* access modifiers changed from: protected */
    public final Parcelable d() {
        Parcelable d2 = super.d();
        if (this.s) {
            return d2;
        }
        SavedState savedState = new SavedState(d2);
        savedState.f30817a = this.f30806a;
        savedState.f30818b = this.f30807b;
        savedState.f30819c = this.f30812g;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public final void a(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.a(savedState.getSuperState());
        this.f30806a = savedState.f30817a;
        this.f30807b = savedState.f30818b;
        this.f30812g = savedState.f30819c;
        b();
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
        int f30817a;

        /* renamed from: b  reason: collision with root package name */
        int f30818b;

        /* renamed from: c  reason: collision with root package name */
        int f30819c;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f30817a = parcel.readInt();
            this.f30818b = parcel.readInt();
            this.f30819c = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f30817a);
            parcel.writeInt(this.f30818b);
            parcel.writeInt(this.f30819c);
        }
    }
}
