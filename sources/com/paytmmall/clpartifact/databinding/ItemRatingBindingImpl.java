package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RatingBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.lifecycle.q;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.generated.callback.OnRatingBarChangeListener;
import com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel;

public class ItemRatingBindingImpl extends ItemRatingBinding implements OnClickListener.Listener, OnRatingBarChangeListener.Listener {
    private static final ViewDataBinding.b sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback28;
    private final View.OnClickListener mCallback29;
    private final View.OnClickListener mCallback30;
    private final RatingBar.OnRatingBarChangeListener mCallback31;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final Group mboundView5;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(16);
        sIncludes = bVar;
        bVar.a(0, new String[]{"layout_no_rating_reviews_available"}, new int[]{11}, new int[]{R.layout.layout_no_rating_reviews_available});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header, 12);
        sViewsWithIds.put(R.id.view1, 13);
        sViewsWithIds.put(R.id.view2, 14);
        sViewsWithIds.put(R.id.divider, 15);
    }

    public ItemRatingBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 16, sIncludes, sViewsWithIds));
    }

    private ItemRatingBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[8], objArr[15], objArr[6], objArr[12], objArr[11], objArr[1], objArr[2], objArr[4], objArr[10], objArr[9], objArr[7], objArr[13], objArr[14], objArr[3]);
        this.mDirtyFlags = -1;
        this.avgRatingBar.setTag((Object) null);
        this.group.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView5 = objArr[5];
        this.mboundView5.setTag((Object) null);
        this.rateButton.setTag((Object) null);
        this.rateString.setTag((Object) null);
        this.ratingBar.setTag((Object) null);
        this.ratingChartRv.setTag((Object) null);
        this.ratingCount.setTag((Object) null);
        this.storeRating.setTag((Object) null);
        this.writeReview.setTag((Object) null);
        setRootTag(view);
        this.mCallback30 = new OnClickListener(this, 3);
        this.mCallback28 = new OnClickListener(this, 1);
        this.mCallback31 = new OnRatingBarChangeListener(this, 4);
        this.mCallback29 = new OnClickListener(this, 2);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.noRatingReviewLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.noRatingReviewLayout.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.paytmmall.clpartifact.databinding.LayoutNoRatingReviewsAvailableBinding r0 = r6.noRatingReviewLayout
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRatingBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((RatingVHViewModel) obj);
        return true;
    }

    public void setViewModel(RatingVHViewModel ratingVHViewModel) {
        updateRegistration(3, (h) ratingVHViewModel);
        this.mViewModel = ratingVHViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.noRatingReviewLayout.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeNoRatingReviewLayout((LayoutNoRatingReviewsAvailableBinding) obj, i3);
        }
        if (i2 == 1) {
            return onChangeViewModelRatingValue((ObservableDouble) obj, i3);
        }
        if (i2 == 2) {
            return onChangeViewModelShowRatingBar((ObservableInt) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return onChangeViewModel((RatingVHViewModel) obj, i3);
    }

    private boolean onChangeNoRatingReviewLayout(LayoutNoRatingReviewsAvailableBinding layoutNoRatingReviewsAvailableBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelRatingValue(ObservableDouble observableDouble, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelShowRatingBar(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModel(RatingVHViewModel ratingVHViewModel, int i2) {
        if (i2 == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i2 != BR.showRatingBar) {
            return false;
        } else {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x011d }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x011d }
            monitor-exit(r24)     // Catch:{ all -> 0x011d }
            r0 = 0
            com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel r8 = r1.mViewModel
            r9 = 30
            long r9 = r9 & r2
            r11 = 26
            r13 = 28
            r15 = 24
            r17 = 0
            r18 = 0
            int r19 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x00a0
            long r9 = r2 & r15
            int r19 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0058
            if (r8 == 0) goto L_0x0037
            java.lang.Integer r0 = r8.getTotalRatings()
            java.lang.Double r9 = r8.getAvgRating()
            androidx.recyclerview.widget.RecyclerView$a r10 = r8.getRatingAdapter()
            int r19 = r8.getRatingChartVisivility()
            goto L_0x003d
        L_0x0037:
            r0 = r18
            r9 = r0
            r10 = r9
            r19 = 0
        L_0x003d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = " Ratings"
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            double r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Double) r9)
            java.lang.String r9 = java.lang.String.valueOf(r6)
            float r6 = (float) r6
            goto L_0x005f
        L_0x0058:
            r0 = r18
            r9 = r0
            r10 = r9
            r6 = 0
            r19 = 0
        L_0x005f:
            long r22 = r2 & r11
            int r7 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x007b
            if (r8 == 0) goto L_0x006c
            androidx.databinding.ObservableDouble r7 = r8.getRatingValue()
            goto L_0x006e
        L_0x006c:
            r7 = r18
        L_0x006e:
            r11 = 1
            r1.updateRegistration((int) r11, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x007b
            double r11 = r7.get()
            r20 = r11
            goto L_0x007d
        L_0x007b:
            r20 = 0
        L_0x007d:
            long r11 = r2 & r13
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x009b
            if (r8 == 0) goto L_0x0089
            androidx.databinding.ObservableInt r18 = r8.getShowRatingBar()
        L_0x0089:
            r7 = r18
            r8 = 2
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x009b
            int r17 = r7.get()
            r7 = r0
            r0 = r17
            r8 = r19
            goto L_0x00a9
        L_0x009b:
            r7 = r0
            r8 = r19
            r0 = 0
            goto L_0x00a9
        L_0x00a0:
            r7 = r18
            r9 = r7
            r10 = r9
            r0 = 0
            r6 = 0
            r8 = 0
            r20 = 0
        L_0x00a9:
            long r11 = r2 & r15
            int r15 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00d0
            android.widget.RatingBar r11 = r1.avgRatingBar
            float r12 = r11.getRating()
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x00bc
            r11.setRating(r6)
        L_0x00bc:
            androidx.constraintlayout.widget.Group r6 = r1.mboundView5
            r6.setVisibility(r8)
            androidx.recyclerview.widget.RecyclerView r6 = r1.ratingChartRv
            com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel.bindRecyclerViewAdapter((androidx.recyclerview.widget.RecyclerView) r6, (androidx.recyclerview.widget.RecyclerView.a<?>) r10)
            android.widget.TextView r6 = r1.ratingCount
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r7)
            android.widget.TextView r6 = r1.storeRating
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r9)
        L_0x00d0:
            long r6 = r2 & r13
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00db
            androidx.constraintlayout.widget.Group r6 = r1.group
            r6.setVisibility(r0)
        L_0x00db:
            r6 = 16
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00fe
            android.widget.TextView r0 = r1.rateButton
            android.view.View$OnClickListener r6 = r1.mCallback28
            r0.setOnClickListener(r6)
            android.widget.TextView r0 = r1.rateString
            android.view.View$OnClickListener r6 = r1.mCallback29
            r0.setOnClickListener(r6)
            android.widget.RatingBar r0 = r1.ratingBar
            android.widget.RatingBar$OnRatingBarChangeListener r6 = r1.mCallback31
            r0.setOnRatingBarChangeListener(r6)
            android.widget.TextView r0 = r1.writeReview
            android.view.View$OnClickListener r6 = r1.mCallback30
            r0.setOnClickListener(r6)
        L_0x00fe:
            r6 = 26
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0117
            android.widget.TextView r0 = r1.rateString
            java.lang.Double r2 = java.lang.Double.valueOf(r20)
            com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel.setRatingReviewText(r0, r2)
            android.widget.RatingBar r0 = r1.ratingBar
            java.lang.Double r2 = java.lang.Double.valueOf(r20)
            com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel.setRating(r0, r2)
        L_0x0117:
            com.paytmmall.clpartifact.databinding.LayoutNoRatingReviewsAvailableBinding r0 = r1.noRatingReviewLayout
            executeBindingsOn(r0)
            return
        L_0x011d:
            r0 = move-exception
            monitor-exit(r24)     // Catch:{ all -> 0x011d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ItemRatingBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            RatingVHViewModel ratingVHViewModel = this.mViewModel;
            if (ratingVHViewModel != null) {
                z = true;
            }
            if (z) {
                ratingVHViewModel.toggleRatingBar(this.group);
            }
        } else if (i2 == 2) {
            RatingVHViewModel ratingVHViewModel2 = this.mViewModel;
            if (ratingVHViewModel2 != null) {
                z = true;
            }
            if (z) {
                ratingVHViewModel2.writeAReview();
            }
        } else if (i2 == 3) {
            RatingVHViewModel ratingVHViewModel3 = this.mViewModel;
            if (ratingVHViewModel3 != null) {
                z = true;
            }
            if (z) {
                ratingVHViewModel3.writeAReview();
            }
        }
    }

    public final void _internalCallbackOnRatingChanged(int i2, RatingBar ratingBar, float f2, boolean z) {
        RatingVHViewModel ratingVHViewModel = this.mViewModel;
        if (ratingVHViewModel != null) {
            ratingVHViewModel.onRatingBarClick(ratingBar, f2, z);
        }
    }
}
