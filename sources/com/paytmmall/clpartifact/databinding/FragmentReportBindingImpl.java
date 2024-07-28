package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.fragment.ReportReviewBottomSheet;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;

public class FragmentReportBindingImpl extends FragmentReportBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback22;
    private final View.OnClickListener mCallback23;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView5;

    public FragmentReportBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentReportBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, objArr[1], objArr[4], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.closeButton.setTag((Object) null);
        this.content.setTag((Object) null);
        this.header.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        this.tickIcon.setTag((Object) null);
        setRootTag(view);
        this.mCallback23 = new OnClickListener(this, 2);
        this.mCallback22 = new OnClickListener(this, 1);
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
        if (BR.fragment == i2) {
            setFragment((ReportReviewBottomSheet) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((StoreRatingViewModel) obj);
        }
        return true;
    }

    public void setFragment(ReportReviewBottomSheet reportReviewBottomSheet) {
        this.mFragment = reportReviewBottomSheet;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.fragment);
        super.requestRebind();
    }

    public void setViewModel(StoreRatingViewModel storeRatingViewModel) {
        this.mViewModel = storeRatingViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeViewModelShowReviewSuccess((ObservableInt) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeViewModelGetShowReviewSuccess((ObservableInt) obj, i3);
    }

    private boolean onChangeViewModelShowReviewSuccess(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelGetShowReviewSuccess(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x011b }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x011b }
            monitor-exit(r22)     // Catch:{ all -> 0x011b }
            com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel r0 = r1.mViewModel
            r6 = 27
            long r6 = r6 & r2
            r8 = 26
            r10 = 25
            r12 = 512(0x200, double:2.53E-321)
            r14 = 1
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x009d
            long r6 = r2 & r10
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0054
            if (r0 == 0) goto L_0x0028
            androidx.databinding.ObservableInt r6 = r0.getShowReviewSuccess()
            goto L_0x0029
        L_0x0028:
            r6 = 0
        L_0x0029:
            r1.updateRegistration((int) r15, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0033
            int r6 = r6.get()
            goto L_0x0034
        L_0x0033:
            r6 = 0
        L_0x0034:
            if (r6 != r14) goto L_0x0038
            r6 = 1
            goto L_0x0039
        L_0x0038:
            r6 = 0
        L_0x0039:
            if (r16 == 0) goto L_0x0044
            if (r6 == 0) goto L_0x0040
            r16 = 64
            goto L_0x0042
        L_0x0040:
            r16 = 32
        L_0x0042:
            long r2 = r2 | r16
        L_0x0044:
            if (r6 == 0) goto L_0x004b
            android.widget.ImageView r6 = r1.tickIcon
            int r7 = com.paytmmall.clpartifact.R.drawable.clp_ic_tick
            goto L_0x004f
        L_0x004b:
            android.widget.ImageView r6 = r1.tickIcon
            int r7 = com.paytmmall.clpartifact.R.drawable.clp_alert_icon_map
        L_0x004f:
            android.graphics.drawable.Drawable r6 = getDrawableFromResource(r6, r7)
            goto L_0x0055
        L_0x0054:
            r6 = 0
        L_0x0055:
            long r16 = r2 & r8
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x009b
            if (r0 == 0) goto L_0x0064
            androidx.databinding.ObservableInt r16 = r0.getShowReviewSuccess()
            r15 = r16
            goto L_0x0065
        L_0x0064:
            r15 = 0
        L_0x0065:
            r1.updateRegistration((int) r14, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x006f
            int r15 = r15.get()
            goto L_0x0070
        L_0x006f:
            r15 = 0
        L_0x0070:
            if (r0 == 0) goto L_0x007f
            java.lang.String r17 = r0.getHeaderText(r15)
            java.lang.String r18 = r0.getButtonText(r15)
            int r0 = r0.getHeaderImage(r15)
            goto L_0x0084
        L_0x007f:
            r0 = 0
            r17 = 0
            r18 = 0
        L_0x0084:
            if (r15 != r14) goto L_0x0089
            r19 = 1
            goto L_0x008b
        L_0x0089:
            r19 = 0
        L_0x008b:
            if (r7 == 0) goto L_0x0095
            if (r19 == 0) goto L_0x0094
            r20 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r20
            goto L_0x0095
        L_0x0094:
            long r2 = r2 | r12
        L_0x0095:
            r14 = r0
            r0 = r17
            r7 = r18
            goto L_0x00a4
        L_0x009b:
            r0 = 0
            goto L_0x009f
        L_0x009d:
            r0 = 0
            r6 = 0
        L_0x009f:
            r7 = 0
            r14 = 0
            r15 = 0
            r19 = 0
        L_0x00a4:
            long r12 = r12 & r2
            int r18 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x00ce
            r12 = 2
            if (r15 != r12) goto L_0x00af
            r16 = 1
            goto L_0x00b1
        L_0x00af:
            r16 = 0
        L_0x00b1:
            if (r18 == 0) goto L_0x00bb
            if (r16 == 0) goto L_0x00b8
            r12 = 256(0x100, double:1.265E-321)
            goto L_0x00ba
        L_0x00b8:
            r12 = 128(0x80, double:6.32E-322)
        L_0x00ba:
            long r2 = r2 | r12
        L_0x00bb:
            android.widget.TextView r12 = r1.header
            android.content.res.Resources r12 = r12.getResources()
            if (r16 == 0) goto L_0x00c6
            int r13 = com.paytmmall.clpartifact.R.string.oops
            goto L_0x00c8
        L_0x00c6:
            int r13 = com.paytmmall.clpartifact.R.string.report_review
        L_0x00c8:
            java.lang.String r12 = r12.getString(r13)
            r15 = r12
            goto L_0x00cf
        L_0x00ce:
            r15 = 0
        L_0x00cf:
            long r8 = r8 & r2
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00e4
            if (r19 == 0) goto L_0x00e5
            android.widget.TextView r8 = r1.header
            android.content.res.Resources r8 = r8.getResources()
            int r9 = com.paytmmall.clpartifact.R.string.report_review_success
            java.lang.String r8 = r8.getString(r9)
            r15 = r8
            goto L_0x00e5
        L_0x00e4:
            r15 = 0
        L_0x00e5:
            r8 = 16
            long r8 = r8 & r2
            int r13 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00fa
            android.widget.ImageView r8 = r1.closeButton
            android.view.View$OnClickListener r9 = r1.mCallback22
            r8.setOnClickListener(r9)
            android.widget.TextView r8 = r1.mboundView5
            android.view.View$OnClickListener r9 = r1.mCallback23
            r8.setOnClickListener(r9)
        L_0x00fa:
            if (r12 == 0) goto L_0x0110
            android.widget.TextView r8 = r1.content
            androidx.databinding.a.d.a((android.widget.TextView) r8, (java.lang.CharSequence) r0)
            android.widget.TextView r0 = r1.header
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
            android.widget.TextView r0 = r1.mboundView5
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
            android.widget.ImageView r0 = r1.tickIcon
            r0.setVisibility(r14)
        L_0x0110:
            long r2 = r2 & r10
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x011a
            android.widget.ImageView r0 = r1.tickIcon
            r0.setImageDrawable(r6)
        L_0x011a:
            return
        L_0x011b:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x011b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.FragmentReportBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            ReportReviewBottomSheet reportReviewBottomSheet = this.mFragment;
            if (reportReviewBottomSheet != null) {
                z = true;
            }
            if (z) {
                reportReviewBottomSheet.dismiss();
            }
        } else if (i2 == 2) {
            ReportReviewBottomSheet reportReviewBottomSheet2 = this.mFragment;
            if (reportReviewBottomSheet2 != null) {
                z = true;
            }
            if (z) {
                reportReviewBottomSheet2.onReportClick();
            }
        }
    }
}
