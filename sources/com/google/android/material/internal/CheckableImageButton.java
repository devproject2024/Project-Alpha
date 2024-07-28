package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.h.a;
import androidx.core.h.a.c;
import androidx.core.h.u;
import androidx.customview.view.AbsSavedState;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f36401b = {16842912};

    /* renamed from: a  reason: collision with root package name */
    boolean f36402a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f36403c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36404d;

    public CheckableImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f36402a = true;
        this.f36404d = true;
        u.a((View) this, (a) new a() {
            public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.a(CheckableImageButton.this.f36402a);
                cVar.f3041a.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public void setChecked(boolean z) {
        if (this.f36402a && this.f36403c != z) {
            this.f36403c = z;
            refreshDrawableState();
            sendAccessibilityEvent(EmiUtil.EMI_PLAN_REQUEST_CODE);
        }
    }

    public boolean isChecked() {
        return this.f36403c;
    }

    public void toggle() {
        setChecked(!this.f36403c);
    }

    public void setPressed(boolean z) {
        if (this.f36404d) {
            super.setPressed(z);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        if (this.f36403c) {
            return mergeDrawableStates(super.onCreateDrawableState(i2 + f36401b.length), f36401b);
        }
        return super.onCreateDrawableState(i2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f36406a = this.f36403c;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        setChecked(savedState.f36406a);
    }

    public void setCheckable(boolean z) {
        if (this.f36402a != z) {
            this.f36402a = z;
            sendAccessibilityEvent(0);
        }
    }

    public void setPressable(boolean z) {
        this.f36404d = z;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f36406a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f36406a = parcel.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f36406a ? 1 : 0);
        }
    }
}
