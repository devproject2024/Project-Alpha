package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.view.viewmodel.ReviewVHViewModel;

public class ClpItemReviewsBindingImpl extends ClpItemReviewsBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback104;
    private long mDirtyFlags;
    private final View mboundView6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.star, 7);
    }

    public ClpItemReviewsBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, sIncludes, sViewsWithIds));
    }

    private ClpItemReviewsBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 1, objArr[4], objArr[1], objArr[2], objArr[5], objArr[3], objArr[0], objArr[7]);
        this.mDirtyFlags = -1;
        this.date.setTag((Object) null);
        this.group.setTag((Object) null);
        this.mboundView6 = objArr[6];
        this.mboundView6.setTag((Object) null);
        this.rating.setTag((Object) null);
        this.report.setTag((Object) null);
        this.review.setTag((Object) null);
        this.root.setTag((Object) null);
        setRootTag(view);
        this.mCallback104 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((ReviewVHViewModel) obj);
        return true;
    }

    public void setViewModel(ReviewVHViewModel reviewVHViewModel) {
        updateRegistration(0, (h) reviewVHViewModel);
        this.mViewModel = reviewVHViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return onChangeViewModel((ReviewVHViewModel) obj, i3);
    }

    private boolean onChangeViewModel(ReviewVHViewModel reviewVHViewModel, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i2 == BR.rating) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i2 == BR.reviewDetail) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i2 == BR.reviewDate) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i2 != BR.name) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00e8 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00e8 }
            monitor-exit(r22)     // Catch:{ all -> 0x00e8 }
            com.paytmmall.clpartifact.view.viewmodel.ReviewVHViewModel r0 = r1.mViewModel
            r6 = 63
            long r6 = r6 & r2
            r8 = 37
            r10 = 35
            r12 = 33
            r14 = 57
            r16 = 0
            r17 = 0
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x008b
            long r6 = r2 & r12
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x003d
            if (r0 == 0) goto L_0x002c
            boolean r6 = r0.isLastItem()
            goto L_0x002d
        L_0x002c:
            r6 = 0
        L_0x002d:
            if (r18 == 0) goto L_0x0038
            if (r6 == 0) goto L_0x0034
            r18 = 128(0x80, double:6.32E-322)
            goto L_0x0036
        L_0x0034:
            r18 = 64
        L_0x0036:
            long r2 = r2 | r18
        L_0x0038:
            if (r6 == 0) goto L_0x003d
            r6 = 8
            goto L_0x003e
        L_0x003d:
            r6 = 0
        L_0x003e:
            long r18 = r2 & r14
            int r7 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005c
            if (r0 == 0) goto L_0x0052
            java.lang.String r7 = r0.getName()
            java.lang.String r18 = r0.getReviewDate()
            r12 = r7
            r7 = r18
            goto L_0x0055
        L_0x0052:
            r7 = r17
            r12 = r7
        L_0x0055:
            if (r0 == 0) goto L_0x005c
            java.lang.String r7 = r0.getDate(r7, r12)
            goto L_0x005e
        L_0x005c:
            r7 = r17
        L_0x005e:
            long r12 = r2 & r10
            int r20 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x006f
            if (r0 == 0) goto L_0x006a
            int r16 = r0.getRating()
        L_0x006a:
            java.lang.String r12 = java.lang.String.valueOf(r16)
            goto L_0x0071
        L_0x006f:
            r12 = r17
        L_0x0071:
            long r20 = r2 & r8
            int r13 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0086
            if (r0 == 0) goto L_0x007e
            com.paytmmall.clpartifact.modal.ratingreview.CJRReviewDetail r0 = r0.getReviewDetail()
            goto L_0x0080
        L_0x007e:
            r0 = r17
        L_0x0080:
            if (r0 == 0) goto L_0x0086
            java.lang.String r17 = r0.getDescription()
        L_0x0086:
            r0 = r16
            r13 = r17
            goto L_0x0091
        L_0x008b:
            r7 = r17
            r12 = r7
            r13 = r12
            r0 = 0
            r6 = 0
        L_0x0091:
            long r14 = r14 & r2
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x009b
            android.widget.TextView r14 = r1.date
            androidx.databinding.a.d.a((android.widget.TextView) r14, (java.lang.CharSequence) r7)
        L_0x009b:
            long r10 = r10 & r2
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00aa
            androidx.constraintlayout.widget.Group r7 = r1.group
            com.paytmmall.clpartifact.modal.ratingreview.TextUtils.setBackGroundColor(r7, r0)
            android.widget.TextView r0 = r1.rating
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x00aa:
            r10 = 33
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00b6
            android.view.View r0 = r1.mboundView6
            r0.setVisibility(r6)
        L_0x00b6:
            r6 = 32
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00dd
            android.widget.TextView r0 = r1.report
            android.view.View$OnClickListener r6 = r1.mCallback104
            r0.setOnClickListener(r6)
            android.widget.TextView r0 = r1.report
            android.widget.TextView r6 = r1.report
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.paytmmall.clpartifact.R.string.report
            java.lang.String r6 = r6.getString(r7)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x00dd:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e7
            android.widget.TextView r0 = r1.review
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x00e7:
            return
        L_0x00e8:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00e8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ClpItemReviewsBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        ReviewVHViewModel reviewVHViewModel = this.mViewModel;
        if (reviewVHViewModel != null) {
            reviewVHViewModel.onReportClick();
        }
    }
}
