package com.paytmmall.clpartifact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.h;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.generated.callback.OnClickListener;
import com.paytmmall.clpartifact.modal.clpCommon.CJRStoreInfo;
import com.paytmmall.clpartifact.view.viewmodel.SearchViewModel;

public class ClpActivitySearchBindingImpl extends ClpActivitySearchBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback107;
    private final View.OnClickListener mCallback108;
    private final View.OnClickListener mCallback109;
    private final View.OnClickListener mCallback110;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private g queryandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.star, 15);
        sViewsWithIds.put(R.id.search_group, 16);
        sViewsWithIds.put(R.id.scrollable, 17);
    }

    public ClpActivitySearchBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 18, sIncludes, sViewsWithIds));
    }

    private ClpActivitySearchBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 5, objArr[3], objArr[2], objArr[14], objArr[5], objArr[1], objArr[11], objArr[7], objArr[10], objArr[13], objArr[6], objArr[17], objArr[12], objArr[16], objArr[8], objArr[9], objArr[15], objArr[4]);
        this.queryandroidTextAttrChanged = new g() {
            public void onChange() {
                String a2 = d.a((TextView) ClpActivitySearchBindingImpl.this.query);
                SearchViewModel searchViewModel = ClpActivitySearchBindingImpl.this.mViewModel;
                boolean z = true;
                if (searchViewModel != null) {
                    y<String> enteredText = searchViewModel.getEnteredText();
                    if (enteredText == null) {
                        z = false;
                    }
                    if (z) {
                        enteredText.setValue(a2);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.BrandLogo.setTag((Object) null);
        this.backButton.setTag((Object) null);
        this.cross.setTag((Object) null);
        this.group.setTag((Object) null);
        this.header.setTag((Object) null);
        this.homeButton.setTag((Object) null);
        this.imgSearch.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.or.setTag((Object) null);
        this.query.setTag((Object) null);
        this.rating.setTag((Object) null);
        this.searchBtn.setTag((Object) null);
        this.searchHeader.setTag((Object) null);
        this.searchSorry.setTag((Object) null);
        this.txvName.setTag((Object) null);
        setRootTag(view);
        this.mCallback108 = new OnClickListener(this, 2);
        this.mCallback109 = new OnClickListener(this, 3);
        this.mCallback110 = new OnClickListener(this, 4);
        this.mCallback107 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (BR.view == i2) {
            setView((com.paytmmall.clpartifact.modal.clpCommon.View) obj);
        } else if (BR.viewModel != i2) {
            return false;
        } else {
            setViewModel((SearchViewModel) obj);
        }
        return true;
    }

    public void setView(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        updateRegistration(2, (h) view);
        this.mView = view;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.view);
        super.requestRebind();
    }

    public void setViewModel(SearchViewModel searchViewModel) {
        this.mViewModel = searchViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeViewModelSearchButtonHandler((w) obj, i3);
        }
        if (i2 == 1) {
            return onChangeViewModelEnteredText((y) obj, i3);
        }
        if (i2 == 2) {
            return onChangeView((com.paytmmall.clpartifact.modal.clpCommon.View) obj, i3);
        }
        if (i2 == 3) {
            return onChangeViewModelShowNoSearchResult((w) obj, i3);
        }
        if (i2 != 4) {
            return false;
        }
        return onChangeViewGetStoreInfo((CJRStoreInfo) obj, i3);
    }

    private boolean onChangeViewModelSearchButtonHandler(w<Integer> wVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelEnteredText(y<String> yVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeView(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelShowNoSearchResult(w<Integer> wVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewGetStoreInfo(CJRStoreInfo cJRStoreInfo, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r35 = this;
            r1 = r35
            monitor-enter(r35)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0222 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0222 }
            monitor-exit(r35)     // Catch:{ all -> 0x0222 }
            com.paytmmall.clpartifact.modal.clpCommon.View r0 = r1.mView
            com.paytmmall.clpartifact.view.viewmodel.SearchViewModel r6 = r1.mViewModel
            r7 = 84
            long r9 = r2 & r7
            r12 = 1024(0x400, double:5.06E-321)
            r14 = 2048(0x800, double:1.0118E-320)
            r16 = 68
            r11 = 0
            int r19 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x0086
            long r9 = r2 & r16
            int r19 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x003b
            if (r0 == 0) goto L_0x002a
            com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview r9 = r0.getRatingReview()
            goto L_0x002b
        L_0x002a:
            r9 = 0
        L_0x002b:
            if (r9 != 0) goto L_0x002f
            r10 = 1
            goto L_0x0030
        L_0x002f:
            r10 = 0
        L_0x0030:
            if (r19 == 0) goto L_0x003d
            if (r10 == 0) goto L_0x0039
            r19 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r19
            goto L_0x003d
        L_0x0039:
            long r2 = r2 | r14
            goto L_0x003d
        L_0x003b:
            r9 = 0
            r10 = 0
        L_0x003d:
            if (r0 == 0) goto L_0x0046
            com.paytmmall.clpartifact.modal.clpCommon.CJRStoreInfo r19 = r0.getStoreInfo()
            r14 = r19
            goto L_0x0047
        L_0x0046:
            r14 = 0
        L_0x0047:
            r15 = 4
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x004f
            r15 = 1
            goto L_0x0050
        L_0x004f:
            r15 = 0
        L_0x0050:
            long r21 = r2 & r7
            int r23 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x005e
            if (r15 == 0) goto L_0x005a
            long r2 = r2 | r12
            goto L_0x005e
        L_0x005a:
            r21 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r21
        L_0x005e:
            if (r14 == 0) goto L_0x0065
            java.lang.String r21 = r14.getLogoUrl()
            goto L_0x0067
        L_0x0065:
            r21 = 0
        L_0x0067:
            boolean r22 = android.text.TextUtils.isEmpty(r21)
            long r23 = r2 & r7
            int r25 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x007a
            if (r22 == 0) goto L_0x0076
            r23 = 16384(0x4000, double:8.0948E-320)
            goto L_0x0078
        L_0x0076:
            r23 = 8192(0x2000, double:4.0474E-320)
        L_0x0078:
            long r2 = r2 | r23
        L_0x007a:
            if (r22 == 0) goto L_0x007f
            r22 = 8
            goto L_0x0081
        L_0x007f:
            r22 = 0
        L_0x0081:
            r28 = r22
            r22 = r21
            goto L_0x008e
        L_0x0086:
            r9 = 0
            r10 = 0
            r14 = 0
            r15 = 0
            r22 = 0
            r28 = 0
        L_0x008e:
            r23 = 107(0x6b, double:5.3E-322)
            long r23 = r2 & r23
            r29 = 104(0x68, double:5.14E-322)
            r31 = 98
            r33 = 97
            int r21 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x00fe
            long r23 = r2 & r33
            int r21 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x00be
            if (r6 == 0) goto L_0x00ab
            androidx.lifecycle.w r21 = r6.getSearchButtonHandler()
            r7 = r21
            goto L_0x00ac
        L_0x00ab:
            r7 = 0
        L_0x00ac:
            r1.updateLiveDataRegistration(r11, r7)
            if (r7 == 0) goto L_0x00b8
            java.lang.Object r7 = r7.getValue()
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x00b9
        L_0x00b8:
            r7 = 0
        L_0x00b9:
            int r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r7)
            goto L_0x00bf
        L_0x00be:
            r7 = 0
        L_0x00bf:
            long r25 = r2 & r31
            int r8 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00da
            if (r6 == 0) goto L_0x00cc
            androidx.lifecycle.y r8 = r6.getEnteredText()
            goto L_0x00cd
        L_0x00cc:
            r8 = 0
        L_0x00cd:
            r11 = 1
            r1.updateLiveDataRegistration(r11, r8)
            if (r8 == 0) goto L_0x00db
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00dc
        L_0x00da:
            r11 = 1
        L_0x00db:
            r8 = 0
        L_0x00dc:
            long r25 = r2 & r29
            int r21 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x0100
            if (r6 == 0) goto L_0x00e9
            androidx.lifecycle.w r6 = r6.getShowNoSearchResult()
            goto L_0x00ea
        L_0x00e9:
            r6 = 0
        L_0x00ea:
            r11 = 3
            r1.updateLiveDataRegistration(r11, r6)
            if (r6 == 0) goto L_0x00f8
            java.lang.Object r6 = r6.getValue()
            r11 = r6
            java.lang.Integer r11 = (java.lang.Integer) r11
            goto L_0x00f9
        L_0x00f8:
            r11 = 0
        L_0x00f9:
            int r11 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r11)
            goto L_0x0101
        L_0x00fe:
            r7 = 0
            r8 = 0
        L_0x0100:
            r11 = 0
        L_0x0101:
            r19 = 2048(0x800, double:1.0118E-320)
            long r19 = r2 & r19
            int r6 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0116
            if (r9 == 0) goto L_0x0110
            java.lang.Double r6 = r9.getAvgRating()
            goto L_0x0111
        L_0x0110:
            r6 = 0
        L_0x0111:
            if (r6 != 0) goto L_0x0117
            r19 = 1
            goto L_0x0119
        L_0x0116:
            r6 = 0
        L_0x0117:
            r19 = 0
        L_0x0119:
            long r12 = r12 & r2
            int r20 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0125
            if (r14 == 0) goto L_0x0125
            java.lang.String r12 = r14.getName()
            goto L_0x0126
        L_0x0125:
            r12 = 0
        L_0x0126:
            r13 = 84
            long r25 = r2 & r13
            int r13 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0134
            if (r15 == 0) goto L_0x0131
            goto L_0x0135
        L_0x0131:
            java.lang.String r12 = "StoreName"
            goto L_0x0135
        L_0x0134:
            r12 = 0
        L_0x0135:
            long r13 = r2 & r16
            r25 = 128(0x80, double:6.32E-322)
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x014c
            if (r10 == 0) goto L_0x0141
            r19 = 1
        L_0x0141:
            if (r15 == 0) goto L_0x014e
            if (r19 == 0) goto L_0x0149
            r13 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r13
            goto L_0x014e
        L_0x0149:
            long r2 = r2 | r25
            goto L_0x014e
        L_0x014c:
            r19 = 0
        L_0x014e:
            long r13 = r2 & r25
            int r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0166
            if (r9 == 0) goto L_0x015a
            java.lang.Double r6 = r9.getAvgRating()
        L_0x015a:
            double r9 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Double) r6)
            r13 = 0
            int r6 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0166
            r6 = 1
            goto L_0x0167
        L_0x0166:
            r6 = 0
        L_0x0167:
            long r9 = r2 & r16
            int r13 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0186
            if (r19 == 0) goto L_0x0170
            r6 = 1
        L_0x0170:
            if (r13 == 0) goto L_0x017c
            if (r6 == 0) goto L_0x0178
            r9 = 65536(0x10000, double:3.2379E-319)
            goto L_0x017b
        L_0x0178:
            r9 = 32768(0x8000, double:1.61895E-319)
        L_0x017b:
            long r2 = r2 | r9
        L_0x017c:
            if (r6 == 0) goto L_0x0181
            r18 = 8
            goto L_0x0183
        L_0x0181:
            r18 = 0
        L_0x0183:
            r6 = r18
            goto L_0x0187
        L_0x0186:
            r6 = 0
        L_0x0187:
            r9 = 84
            long r9 = r9 & r2
            int r13 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x01ab
            android.widget.ImageView r9 = r1.BrandLogo
            r10 = r28
            r9.setVisibility(r10)
            android.widget.ImageView r9 = r1.BrandLogo
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r21 = r9
            com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder.setImageUrl(r21, r22, r23, r24, r25, r26, r27)
            android.widget.TextView r9 = r1.txvName
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r12)
        L_0x01ab:
            r9 = 64
            long r9 = r9 & r2
            int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x01d6
            android.widget.ImageView r9 = r1.backButton
            android.view.View$OnClickListener r10 = r1.mCallback107
            r9.setOnClickListener(r10)
            android.widget.ImageView r9 = r1.cross
            android.view.View$OnClickListener r10 = r1.mCallback110
            r9.setOnClickListener(r10)
            android.widget.TextView r9 = r1.homeButton
            android.view.View$OnClickListener r10 = r1.mCallback108
            r9.setOnClickListener(r10)
            android.widget.EditText r9 = r1.query
            androidx.databinding.g r10 = r1.queryandroidTextAttrChanged
            r12 = 0
            androidx.databinding.a.d.a(r9, r12, r12, r10)
            android.widget.TextView r9 = r1.searchBtn
            android.view.View$OnClickListener r10 = r1.mCallback109
            r9.setOnClickListener(r10)
        L_0x01d6:
            long r9 = r2 & r16
            int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x01ec
            androidx.constraintlayout.widget.Group r9 = r1.group
            r9.setVisibility(r6)
            androidx.constraintlayout.widget.ConstraintLayout r6 = r1.header
            r9 = 0
            com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV.setBGColor(r6, r0, r9)
            android.widget.TextView r6 = r1.rating
            com.paytmmall.clpartifact.view.viewHolder.CLPStoreBannerVHWithoutRV.setRatingText(r6, r0)
        L_0x01ec:
            long r9 = r2 & r29
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x020b
            android.widget.TextView r0 = r1.homeButton
            r0.setVisibility(r11)
            android.widget.ImageView r0 = r1.imgSearch
            r0.setVisibility(r11)
            android.widget.TextView r0 = r1.or
            r0.setVisibility(r11)
            android.widget.TextView r0 = r1.searchHeader
            r0.setVisibility(r11)
            android.widget.TextView r0 = r1.searchSorry
            r0.setVisibility(r11)
        L_0x020b:
            long r9 = r2 & r31
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0216
            android.widget.EditText r0 = r1.query
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0216:
            long r2 = r2 & r33
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0221
            android.widget.TextView r0 = r1.searchBtn
            r0.setVisibility(r7)
        L_0x0221:
            return
        L_0x0222:
            r0 = move-exception
            monitor-exit(r35)     // Catch:{ all -> 0x0222 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.databinding.ClpActivitySearchBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            SearchViewModel searchViewModel = this.mViewModel;
            if (searchViewModel != null) {
                z = true;
            }
            if (z) {
                searchViewModel.handleBackPress();
            }
        } else if (i2 == 2) {
            SearchViewModel searchViewModel2 = this.mViewModel;
            if (searchViewModel2 != null) {
                z = true;
            }
            if (z) {
                searchViewModel2.handleBackPress();
            }
        } else if (i2 == 3) {
            SearchViewModel searchViewModel3 = this.mViewModel;
            if (searchViewModel3 != null) {
                z = true;
            }
            if (z && this.query != null) {
                this.query.getText();
                if (this.query.getText() != null) {
                    this.query.getText();
                    searchViewModel3.handleButtonClick(this.query.getText().toString());
                }
            }
        } else if (i2 == 4 && this.query != null) {
            this.query.setText("");
        }
    }
}
