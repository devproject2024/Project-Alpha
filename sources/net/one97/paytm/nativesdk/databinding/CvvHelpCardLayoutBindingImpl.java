package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.cvvHelp.viewmodel.CvvHelpFragmentViewModel;

public class CvvHelpCardLayoutBindingImpl extends CvvHelpCardLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    public CvvHelpCardLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, sIncludes, sViewsWithIds));
    }

    private CvvHelpCardLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[3], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.ivCardLogo.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.tvCvvHelpTitle.setTag((Object) null);
        this.tvDesc.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.cvvHelpModel != i2) {
            return false;
        }
        setCvvHelpModel((CvvHelpFragmentViewModel) obj);
        return true;
    }

    public void setCvvHelpModel(CvvHelpFragmentViewModel cvvHelpFragmentViewModel) {
        updateRegistration(0, (h) cvvHelpFragmentViewModel);
        this.mCvvHelpModel = cvvHelpFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.cvvHelpModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeCvvHelpModel((CvvHelpFragmentViewModel) obj, i3);
        }
        if (i2 == 1) {
            return onChangeCvvHelpModelAmexCard((ObservableBoolean) obj, i3);
        }
        if (i2 == 2) {
            return onChangeCvvHelpModelDescription((i) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeCvvHelpModelTitle((i) obj, i3);
    }

    private boolean onChangeCvvHelpModel(CvvHelpFragmentViewModel cvvHelpFragmentViewModel, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeCvvHelpModelAmexCard(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeCvvHelpModelDescription(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeCvvHelpModelTitle(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00a1 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00a1 }
            monitor-exit(r18)     // Catch:{ all -> 0x00a1 }
            net.one97.paytm.nativesdk.cvvHelp.viewmodel.CvvHelpFragmentViewModel r0 = r1.mCvvHelpModel
            r6 = 0
            r7 = 31
            long r7 = r7 & r2
            r9 = 21
            r11 = 25
            r13 = 19
            r15 = 0
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0080
            long r7 = r2 & r13
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x004b
            if (r0 == 0) goto L_0x0026
            androidx.databinding.ObservableBoolean r7 = r0.amexCard
            goto L_0x0027
        L_0x0026:
            r7 = r15
        L_0x0027:
            r8 = 1
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0031
            boolean r6 = r7.get()
        L_0x0031:
            if (r16 == 0) goto L_0x003b
            if (r6 == 0) goto L_0x0038
            r7 = 64
            goto L_0x003a
        L_0x0038:
            r7 = 32
        L_0x003a:
            long r2 = r2 | r7
        L_0x003b:
            if (r6 == 0) goto L_0x0042
            android.widget.ImageView r6 = r1.ivCardLogo
            int r7 = net.one97.paytm.nativesdk.R.drawable.native_amex
            goto L_0x0046
        L_0x0042:
            android.widget.ImageView r6 = r1.ivCardLogo
            int r7 = net.one97.paytm.nativesdk.R.drawable.non_amex
        L_0x0046:
            android.graphics.drawable.Drawable r6 = getDrawableFromResource(r6, r7)
            goto L_0x004c
        L_0x004b:
            r6 = r15
        L_0x004c:
            long r7 = r2 & r9
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0065
            if (r0 == 0) goto L_0x0057
            androidx.databinding.i<java.lang.String> r7 = r0.description
            goto L_0x0058
        L_0x0057:
            r7 = r15
        L_0x0058:
            r8 = 2
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0065
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0066
        L_0x0065:
            r7 = r15
        L_0x0066:
            long r16 = r2 & r11
            int r8 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0082
            if (r0 == 0) goto L_0x0071
            androidx.databinding.i<java.lang.String> r0 = r0.title
            goto L_0x0072
        L_0x0071:
            r0 = r15
        L_0x0072:
            r8 = 3
            r1.updateRegistration((int) r8, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0082
            java.lang.Object r0 = r0.get()
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0082
        L_0x0080:
            r6 = r15
            r7 = r6
        L_0x0082:
            long r13 = r13 & r2
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x008c
            android.widget.ImageView r0 = r1.ivCardLogo
            r0.setImageDrawable(r6)
        L_0x008c:
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0096
            android.widget.TextView r0 = r1.tvCvvHelpTitle
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
        L_0x0096:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a0
            android.widget.TextView r0 = r1.tvDesc
            r0.setText(r7)
        L_0x00a0:
            return
        L_0x00a1:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x00a1 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.CvvHelpCardLayoutBindingImpl.executeBindings():void");
    }
}
