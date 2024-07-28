package com.paytm.business.merchantprofile.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.i;
import androidx.lifecycle.q;
import com.paytm.business.merchantprofile.BR;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel;

public class PrActivityProfileBusinessDetailsNewBindingImpl extends PrActivityProfileBusinessDetailsNewBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final RelativeLayout mboundView0;
    public final TextView mboundView13;
    public final TextView mboundView5;
    public final TextView mboundView7;
    public final TextView mboundView8;
    public final TextView mboundView9;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(43);
        sIncludes = bVar;
        bVar.a(0, new String[]{"pr_activity_profile_business_details_shimmer"}, new int[]{20}, new int[]{R.layout.pr_activity_profile_business_details_shimmer});
        sIncludes.a(1, new String[]{"pr_profile_screen_header"}, new int[]{21}, new int[]{R.layout.pr_profile_screen_header});
        sIncludes.a(2, new String[]{"pr_profile_reactivate"}, new int[]{24}, new int[]{R.layout.pr_profile_reactivate});
        sIncludes.a(3, new String[]{"pr_view_edit_change_in_progress_new"}, new int[]{22}, new int[]{R.layout.pr_view_edit_change_in_progress_new});
        sIncludes.a(6, new String[]{"pr_view_edit_change_in_progress_new"}, new int[]{23}, new int[]{R.layout.pr_view_edit_change_in_progress_new});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 25);
        sViewsWithIds.put(R.id.scroll_view, 26);
        sViewsWithIds.put(R.id.ll_business_name_header, 27);
        sViewsWithIds.put(R.id.ll_disp_name, 28);
        sViewsWithIds.put(R.id.view_overlay_business_name, 29);
        sViewsWithIds.put(R.id.ll_business_details_header, 30);
        sViewsWithIds.put(R.id.ll_merchant_id, 31);
        sViewsWithIds.put(R.id.ll_pan, 32);
        sViewsWithIds.put(R.id.ll_gstin, 33);
        sViewsWithIds.put(R.id.view_overlay_business_details, 34);
        sViewsWithIds.put(R.id.registered_address, 35);
        sViewsWithIds.put(R.id.view_overlay_registered_address, 36);
        sViewsWithIds.put(R.id.plan_type_menu_container, 37);
        sViewsWithIds.put(R.id.plan_type, 38);
        sViewsWithIds.put(R.id.no_of_devices_under_plan_txt, 39);
        sViewsWithIds.put(R.id.usage_deposit_txt, 40);
        sViewsWithIds.put(R.id.terms_and_conditions_txt, 41);
        sViewsWithIds.put(R.id.logout_btn, 42);
    }

    public PrActivityProfileBusinessDetailsNewBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 43, sIncludes, sViewsWithIds));
    }

    public PrActivityProfileBusinessDetailsNewBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 23, objArr[12], objArr[10], objArr[14], objArr[11], objArr[4], objArr[30], objArr[27], objArr[24], objArr[28], objArr[33], objArr[31], objArr[32], objArr[42], objArr[39], objArr[16], objArr[38], objArr[37], objArr[15], objArr[35], objArr[3], objArr[2], objArr[6], objArr[1], objArr[26], objArr[20], objArr[41], objArr[25], objArr[17], objArr[18], objArr[40], objArr[19], objArr[22], objArr[23], objArr[34], objArr[29], objArr[36], objArr[21]);
        this.mDirtyFlags = -1;
        this.addAddress.setTag((Object) null);
        this.addGstIn.setTag((Object) null);
        this.edcDetails.setTag((Object) null);
        this.editAddress.setTag((Object) null);
        this.editDisplayName.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        TextView textView = objArr[13];
        this.mboundView13 = textView;
        textView.setTag((Object) null);
        TextView textView2 = objArr[5];
        this.mboundView5 = textView2;
        textView2.setTag((Object) null);
        TextView textView3 = objArr[7];
        this.mboundView7 = textView3;
        textView3.setTag((Object) null);
        TextView textView4 = objArr[8];
        this.mboundView8 = textView4;
        textView4.setTag((Object) null);
        TextView textView5 = objArr[9];
        this.mboundView9 = textView5;
        textView5.setTag((Object) null);
        this.noOfDevicesUnderPlanValue.setTag((Object) null);
        this.planTypeValue.setTag((Object) null);
        this.rl.setTag((Object) null);
        this.rlBusinessDetailsContainer.setTag((Object) null);
        this.rlContainerBusinessDetails.setTag((Object) null);
        this.rlParentContainer.setTag((Object) null);
        this.totalRentalForXDevicesTxt.setTag((Object) null);
        this.totalRentalForXDevicesValue.setTag((Object) null);
        this.usageDepositValue.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16777216;
        }
        this.shimmerContainer.invalidateAll();
        this.viewProfileHeader.invalidateAll();
        this.viewDisplayNameChange.invalidateAll();
        this.viewGstinChange.invalidateAll();
        this.llDeactivateContainer.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.viewProfileHeader.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.viewDisplayNameChange.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r6.viewGstinChange.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r6.llDeactivateContainer.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.shimmerContainer.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x003c }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            com.paytm.business.merchantprofile.databinding.PrActivityProfileBusinessDetailsShimmerBinding r0 = r6.shimmerContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            com.paytm.business.merchantprofile.databinding.PrProfileScreenHeaderBinding r0 = r6.viewProfileHeader
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding r0 = r6.viewDisplayNameChange
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding r0 = r6.viewGstinChange
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0031
            return r4
        L_0x0031:
            com.paytm.business.merchantprofile.databinding.PrProfileReactivateBinding r0 = r6.llDeactivateContainer
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x003a
            return r4
        L_0x003a:
            r0 = 0
            return r0
        L_0x003c:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrActivityProfileBusinessDetailsNewBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((ProfileBusinessDetailsViewModel) obj);
        return true;
    }

    public void setViewModel(ProfileBusinessDetailsViewModel profileBusinessDetailsViewModel) {
        this.mViewModel = profileBusinessDetailsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.shimmerContainer.setLifecycleOwner(qVar);
        this.viewProfileHeader.setLifecycleOwner(qVar);
        this.viewDisplayNameChange.setLifecycleOwner(qVar);
        this.viewGstinChange.setLifecycleOwner(qVar);
        this.llDeactivateContainer.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewModelPanNo((i) obj, i3);
            case 1:
                return onChangeViewModelIsTicketStatusFetched((ObservableBoolean) obj, i3);
            case 2:
                return onChangeViewModelIsChangeNamePermissionAvailabel((ObservableBoolean) obj, i3);
            case 3:
                return onChangeViewModelMNumberOfDevicesUnderPlan((i) obj, i3);
            case 4:
                return onChangeViewModelDisplayName((i) obj, i3);
            case 5:
                return onChangeViewModelAddress((i) obj, i3);
            case 6:
                return onChangeViewModelGstin((i) obj, i3);
            case 7:
                return onChangeViewModelMTotalRentalForKDevicesText((i) obj, i3);
            case 8:
                return onChangeViewModelMUsageDeposit((i) obj, i3);
            case 9:
                return onChangeViewModelGstinChangeVisibility((ObservableBoolean) obj, i3);
            case 10:
                return onChangeViewGstinChange((PrViewEditChangeInProgressNewBinding) obj, i3);
            case 11:
                return onChangeViewModelMRentalforDevices((i) obj, i3);
            case 12:
                return onChangeViewModelIsGstinPending((ObservableBoolean) obj, i3);
            case 13:
                return onChangeLlDeactivateContainer((PrProfileReactivateBinding) obj, i3);
            case 14:
                return onChangeViewModelIsMerchantAdmin((ObservableBoolean) obj, i3);
            case 15:
                return onChangeViewModelIsGstinExist((ObservableBoolean) obj, i3);
            case 16:
                return onChangeViewDisplayNameChange((PrViewEditChangeInProgressNewBinding) obj, i3);
            case 17:
                return onChangeViewProfileHeader((PrProfileScreenHeaderBinding) obj, i3);
            case 18:
                return onChangeShimmerContainer((PrActivityProfileBusinessDetailsShimmerBinding) obj, i3);
            case 19:
                return onChangeViewModelDisplayNameChangeVisibility((ObservableBoolean) obj, i3);
            case 20:
                return onChangeViewModelMCurrentPlanType((i) obj, i3);
            case 21:
                return onChangeViewModelMEdcDetailsVisibility((i) obj, i3);
            case 22:
                return onChangeViewModelMid((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelPanNo(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelIsTicketStatusFetched(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelIsChangeNamePermissionAvailabel(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelMNumberOfDevicesUnderPlan(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelDisplayName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelAddress(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelGstin(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelMTotalRentalForKDevicesText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelMUsageDeposit(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelGstinChangeVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewGstinChange(PrViewEditChangeInProgressNewBinding prViewEditChangeInProgressNewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelMRentalforDevices(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelIsGstinPending(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeLlDeactivateContainer(PrProfileReactivateBinding prProfileReactivateBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeViewModelIsMerchantAdmin(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeViewModelIsGstinExist(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeViewDisplayNameChange(PrViewEditChangeInProgressNewBinding prViewEditChangeInProgressNewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeViewProfileHeader(PrProfileScreenHeaderBinding prProfileScreenHeaderBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeShimmerContainer(PrActivityProfileBusinessDetailsShimmerBinding prActivityProfileBusinessDetailsShimmerBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeViewModelDisplayNameChangeVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeViewModelMCurrentPlanType(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeViewModelMEdcDetailsVisibility(i<Integer> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeViewModelMid(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x034f  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0456  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0484  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0492  */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x04a0  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x04ab  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x04d2  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x04e0  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0531  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x0545  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0153  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r53 = this;
            r1 = r53
            monitor-enter(r53)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0564 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0564 }
            monitor-exit(r53)     // Catch:{ all -> 0x0564 }
            com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel r0 = r1.mViewModel
            r6 = 33086463(0x1f8dbff, double:1.63468847E-316)
            long r6 = r6 & r2
            r10 = 25165888(0x1800040, double:1.24336007E-316)
            r12 = 25165840(0x1800010, double:1.2433577E-316)
            r14 = 25165832(0x1800008, double:1.2433573E-316)
            r16 = 25165825(0x1800001, double:1.24335696E-316)
            r18 = 25690112(0x1880000, double:1.2692602E-316)
            r20 = 25198592(0x1808000, double:1.24497586E-316)
            r22 = 25165856(0x1800020, double:1.2433585E-316)
            r26 = 25706502(0x1884006, double:1.27006995E-316)
            r28 = 25219074(0x180d002, double:1.2459878E-316)
            r9 = 8
            r30 = 0
            r8 = 0
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x02e3
            long r6 = r2 & r16
            int r32 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x004d
            if (r0 == 0) goto L_0x003f
            androidx.databinding.i<java.lang.String> r6 = r0.panNo
            goto L_0x0041
        L_0x003f:
            r6 = r30
        L_0x0041:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x004d
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x004f
        L_0x004d:
            r6 = r30
        L_0x004f:
            long r32 = r2 & r14
            int r7 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0069
            if (r0 == 0) goto L_0x005a
            androidx.databinding.i<java.lang.String> r7 = r0.mNumberOfDevicesUnderPlan
            goto L_0x005c
        L_0x005a:
            r7 = r30
        L_0x005c:
            r8 = 3
            r1.updateRegistration((int) r8, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0069
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x006b
        L_0x0069:
            r7 = r30
        L_0x006b:
            long r33 = r2 & r12
            int r8 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0085
            if (r0 == 0) goto L_0x0076
            androidx.databinding.i<java.lang.String> r8 = r0.displayName
            goto L_0x0078
        L_0x0076:
            r8 = r30
        L_0x0078:
            r14 = 4
            r1.updateRegistration((int) r14, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x0085
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0087
        L_0x0085:
            r8 = r30
        L_0x0087:
            long r14 = r2 & r22
            int r35 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x00ed
            if (r0 == 0) goto L_0x0092
            androidx.databinding.i<java.lang.String> r14 = r0.address
            goto L_0x0094
        L_0x0092:
            r14 = r30
        L_0x0094:
            r15 = 5
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00a1
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x00a3
        L_0x00a1:
            r14 = r30
        L_0x00a3:
            if (r14 == 0) goto L_0x00aa
            int r15 = r14.length()
            goto L_0x00ab
        L_0x00aa:
            r15 = 0
        L_0x00ab:
            if (r15 == 0) goto L_0x00b0
            r36 = 1
            goto L_0x00b2
        L_0x00b0:
            r36 = 0
        L_0x00b2:
            if (r15 != 0) goto L_0x00b6
            r15 = 1
            goto L_0x00b7
        L_0x00b6:
            r15 = 0
        L_0x00b7:
            if (r35 == 0) goto L_0x00c8
            if (r36 == 0) goto L_0x00c1
            r37 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            goto L_0x00c6
        L_0x00c1:
            r37 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
        L_0x00c6:
            long r2 = r2 | r37
        L_0x00c8:
            long r37 = r2 & r22
            int r35 = (r37 > r4 ? 1 : (r37 == r4 ? 0 : -1))
            if (r35 == 0) goto L_0x00dd
            if (r15 == 0) goto L_0x00d6
            r37 = 68719476736(0x1000000000, double:3.39519326554E-313)
            goto L_0x00db
        L_0x00d6:
            r37 = 34359738368(0x800000000, double:1.69759663277E-313)
        L_0x00db:
            long r2 = r2 | r37
        L_0x00dd:
            if (r36 == 0) goto L_0x00e2
            r35 = 0
            goto L_0x00e4
        L_0x00e2:
            r35 = 8
        L_0x00e4:
            if (r15 == 0) goto L_0x00e9
            r15 = r14
            r14 = 0
            goto L_0x00f2
        L_0x00e9:
            r15 = r14
            r14 = 8
            goto L_0x00f2
        L_0x00ed:
            r15 = r30
            r14 = 0
            r35 = 0
        L_0x00f2:
            long r36 = r2 & r10
            int r38 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r38 == 0) goto L_0x010c
            if (r0 == 0) goto L_0x00fd
            androidx.databinding.i<java.lang.String> r10 = r0.gstin
            goto L_0x00ff
        L_0x00fd:
            r10 = r30
        L_0x00ff:
            r11 = 6
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x010c
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x010e
        L_0x010c:
            r10 = r30
        L_0x010e:
            r24 = 25165952(0x1800080, double:1.24336323E-316)
            long r38 = r2 & r24
            int r11 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x012b
            if (r0 == 0) goto L_0x011c
            androidx.databinding.i<java.lang.String> r11 = r0.mTotalRentalForKDevicesText
            goto L_0x011e
        L_0x011c:
            r11 = r30
        L_0x011e:
            r12 = 7
            r1.updateRegistration((int) r12, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x012b
            java.lang.Object r11 = r11.get()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x012d
        L_0x012b:
            r11 = r30
        L_0x012d:
            r12 = 25166080(0x1800100, double:1.24336956E-316)
            long r12 = r12 & r2
            int r40 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r40 == 0) goto L_0x0148
            if (r0 == 0) goto L_0x013a
            androidx.databinding.i<java.lang.String> r12 = r0.mUsageDeposit
            goto L_0x013c
        L_0x013a:
            r12 = r30
        L_0x013c:
            r1.updateRegistration((int) r9, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0148
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x014a
        L_0x0148:
            r12 = r30
        L_0x014a:
            r40 = 25166336(0x1800200, double:1.2433822E-316)
            long r40 = r2 & r40
            int r13 = (r40 > r4 ? 1 : (r40 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x017d
            if (r0 == 0) goto L_0x0158
            androidx.databinding.ObservableBoolean r9 = r0.gstinChangeVisibility
            goto L_0x015a
        L_0x0158:
            r9 = r30
        L_0x015a:
            r4 = 9
            r1.updateRegistration((int) r4, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0166
            boolean r4 = r9.get()
            goto L_0x0167
        L_0x0166:
            r4 = 0
        L_0x0167:
            if (r13 == 0) goto L_0x0178
            if (r4 == 0) goto L_0x0171
            r43 = 4294967296(0x100000000, double:2.121995791E-314)
            goto L_0x0176
        L_0x0171:
            r43 = 2147483648(0x80000000, double:1.0609978955E-314)
        L_0x0176:
            long r2 = r2 | r43
        L_0x0178:
            if (r4 != 0) goto L_0x017d
            r4 = 8
            goto L_0x017e
        L_0x017d:
            r4 = 0
        L_0x017e:
            r43 = 25167872(0x1800800, double:1.2434581E-316)
            long r43 = r2 & r43
            r41 = 0
            int r5 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x019e
            if (r0 == 0) goto L_0x018e
            androidx.databinding.i<java.lang.String> r5 = r0.mRentalforDevices
            goto L_0x0190
        L_0x018e:
            r5 = r30
        L_0x0190:
            r9 = 11
            r1.updateRegistration((int) r9, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x019e
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x01a0
        L_0x019e:
            r5 = r30
        L_0x01a0:
            long r43 = r2 & r28
            r41 = 0
            int r9 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r9 == 0) goto L_0x01f6
            if (r0 == 0) goto L_0x01ad
            androidx.databinding.ObservableBoolean r9 = r0.isGstinExist
            goto L_0x01af
        L_0x01ad:
            r9 = r30
        L_0x01af:
            r13 = 15
            r1.updateRegistration((int) r13, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x01bb
            boolean r9 = r9.get()
            goto L_0x01bc
        L_0x01bb:
            r9 = 0
        L_0x01bc:
            long r43 = r2 & r20
            r41 = 0
            int r13 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x01cf
            if (r9 == 0) goto L_0x01ca
            r43 = 67108864(0x4000000, double:3.31561842E-316)
            goto L_0x01cd
        L_0x01ca:
            r43 = 33554432(0x2000000, double:1.6578092E-316)
        L_0x01cd:
            long r2 = r2 | r43
        L_0x01cf:
            long r43 = r2 & r20
            int r13 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r13 == 0) goto L_0x01db
            if (r9 == 0) goto L_0x01d8
            goto L_0x01db
        L_0x01d8:
            r13 = 8
            goto L_0x01dc
        L_0x01db:
            r13 = 0
        L_0x01dc:
            r31 = 1
            r9 = r9 ^ 1
            long r43 = r2 & r28
            int r45 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r45 == 0) goto L_0x01f8
            if (r9 == 0) goto L_0x01ee
            r43 = 17179869184(0x400000000, double:8.4879831639E-314)
            goto L_0x01f3
        L_0x01ee:
            r43 = 8589934592(0x200000000, double:4.243991582E-314)
        L_0x01f3:
            long r2 = r2 | r43
            goto L_0x01f8
        L_0x01f6:
            r9 = 0
            r13 = 0
        L_0x01f8:
            long r43 = r2 & r26
            r41 = 0
            int r45 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            r43 = r4
            if (r45 == 0) goto L_0x024f
            if (r0 == 0) goto L_0x0209
            androidx.databinding.ObservableBoolean r4 = r0.displayNameChangeVisibility
            r44 = r5
            goto L_0x020d
        L_0x0209:
            r44 = r5
            r4 = r30
        L_0x020d:
            r5 = 19
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0219
            boolean r4 = r4.get()
            goto L_0x021a
        L_0x0219:
            r4 = 0
        L_0x021a:
            long r45 = r2 & r18
            r41 = 0
            int r5 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x0231
            if (r4 == 0) goto L_0x022a
            r45 = 70368744177664(0x400000000000, double:3.4766779039175E-310)
            goto L_0x022f
        L_0x022a:
            r45 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
        L_0x022f:
            long r2 = r2 | r45
        L_0x0231:
            r5 = r4 ^ 1
            long r45 = r2 & r26
            r41 = 0
            int r47 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r47 == 0) goto L_0x0244
            if (r5 == 0) goto L_0x0240
            r45 = 1125899906842624(0x4000000000000, double:5.562684646268003E-309)
            goto L_0x0242
        L_0x0240:
            r45 = 562949953421312(0x2000000000000, double:2.781342323134002E-309)
        L_0x0242:
            long r2 = r2 | r45
        L_0x0244:
            long r45 = r2 & r18
            int r47 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r47 == 0) goto L_0x0254
            if (r4 != 0) goto L_0x0254
            r4 = 8
            goto L_0x0255
        L_0x024f:
            r44 = r5
            r41 = 0
            r5 = 0
        L_0x0254:
            r4 = 0
        L_0x0255:
            r45 = 26214400(0x1900000, double:1.29516345E-316)
            long r45 = r2 & r45
            int r47 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            r45 = r4
            if (r47 == 0) goto L_0x0279
            if (r0 == 0) goto L_0x0267
            androidx.databinding.i<java.lang.String> r4 = r0.mCurrentPlanType
            r46 = r5
            goto L_0x026b
        L_0x0267:
            r46 = r5
            r4 = r30
        L_0x026b:
            r5 = 20
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x027b
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x027d
        L_0x0279:
            r46 = r5
        L_0x027b:
            r4 = r30
        L_0x027d:
            r47 = 27262976(0x1a00000, double:1.34697E-316)
            long r47 = r2 & r47
            r41 = 0
            int r5 = (r47 > r41 ? 1 : (r47 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x02a8
            if (r0 == 0) goto L_0x028f
            androidx.databinding.i<java.lang.Integer> r5 = r0.mEdcDetailsVisibility
            r47 = r4
            goto L_0x0293
        L_0x028f:
            r47 = r4
            r5 = r30
        L_0x0293:
            r4 = 21
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02a1
            java.lang.Object r4 = r5.get()
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x02a3
        L_0x02a1:
            r4 = r30
        L_0x02a3:
            int r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r4)
            goto L_0x02ab
        L_0x02a8:
            r47 = r4
            r4 = 0
        L_0x02ab:
            r48 = 29360128(0x1c00000, double:1.45058306E-316)
            long r48 = r2 & r48
            r41 = 0
            int r5 = (r48 > r41 ? 1 : (r48 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x02d2
            if (r0 == 0) goto L_0x02bd
            androidx.databinding.i<java.lang.String> r5 = r0.mid
            r48 = r2
            goto L_0x02c1
        L_0x02bd:
            r48 = r2
            r5 = r30
        L_0x02c1:
            r2 = 22
            r1.updateRegistration((int) r2, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02d4
            java.lang.Object r2 = r5.get()
            java.lang.String r2 = (java.lang.String) r2
            r3 = r2
            r50 = r12
            goto L_0x02d8
        L_0x02d2:
            r48 = r2
        L_0x02d4:
            r50 = r12
            r3 = r30
        L_0x02d8:
            r2 = r35
            r52 = r43
            r12 = r44
            r51 = r45
            r5 = r47
            goto L_0x02fc
        L_0x02e3:
            r48 = r2
            r3 = r30
            r5 = r3
            r6 = r5
            r7 = r6
            r8 = r7
            r10 = r8
            r11 = r10
            r12 = r11
            r15 = r12
            r50 = r15
            r2 = 0
            r4 = 0
            r9 = 0
            r13 = 0
            r14 = 0
            r46 = 0
            r51 = 0
            r52 = 0
        L_0x02fc:
            r43 = 1125917086711808(0x4000400000000, double:5.56276952609964E-309)
            long r43 = r48 & r43
            r41 = 0
            int r35 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r35 == 0) goto L_0x0322
            r35 = r12
            if (r0 == 0) goto L_0x0312
            androidx.databinding.ObservableBoolean r12 = r0.isMerchantAdmin
            r43 = r11
            goto L_0x0316
        L_0x0312:
            r43 = r11
            r12 = r30
        L_0x0316:
            r11 = 14
            r1.updateRegistration((int) r11, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0326
            boolean r11 = r12.get()
            goto L_0x0327
        L_0x0322:
            r43 = r11
            r35 = r12
        L_0x0326:
            r11 = 0
        L_0x0327:
            long r44 = r48 & r28
            r41 = 0
            int r12 = (r44 > r41 ? 1 : (r44 == r41 ? 0 : -1))
            if (r12 == 0) goto L_0x0346
            if (r9 == 0) goto L_0x0333
            r9 = r11
            goto L_0x0334
        L_0x0333:
            r9 = 0
        L_0x0334:
            if (r12 == 0) goto L_0x0347
            if (r9 == 0) goto L_0x033e
            r44 = 1099511627776(0x10000000000, double:5.43230922487E-312)
            goto L_0x0343
        L_0x033e:
            r44 = 549755813888(0x8000000000, double:2.716154612436E-312)
        L_0x0343:
            long r48 = r48 | r44
            goto L_0x0347
        L_0x0346:
            r9 = 0
        L_0x0347:
            long r44 = r48 & r26
            r41 = 0
            int r12 = (r44 > r41 ? 1 : (r44 == r41 ? 0 : -1))
            if (r12 == 0) goto L_0x0364
            if (r46 != 0) goto L_0x0352
            r11 = 0
        L_0x0352:
            if (r12 == 0) goto L_0x0365
            if (r11 == 0) goto L_0x035c
            r44 = 274877906944(0x4000000000, double:1.358077306218E-312)
            goto L_0x0361
        L_0x035c:
            r44 = 137438953472(0x2000000000, double:6.7903865311E-313)
        L_0x0361:
            long r48 = r48 | r44
            goto L_0x0365
        L_0x0364:
            r11 = 0
        L_0x0365:
            r44 = 1374389534720(0x14000000000, double:6.79038653109E-312)
            long r44 = r48 & r44
            r41 = 0
            int r12 = (r44 > r41 ? 1 : (r44 == r41 ? 0 : -1))
            if (r12 == 0) goto L_0x0388
            if (r0 == 0) goto L_0x0379
            androidx.databinding.ObservableBoolean r12 = r0.isTicketStatusFetched
            r44 = r5
            goto L_0x037d
        L_0x0379:
            r44 = r5
            r12 = r30
        L_0x037d:
            r5 = 1
            r1.updateRegistration((int) r5, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x038a
            boolean r5 = r12.get()
            goto L_0x038b
        L_0x0388:
            r44 = r5
        L_0x038a:
            r5 = 0
        L_0x038b:
            long r45 = r48 & r26
            r41 = 0
            int r12 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r12 == 0) goto L_0x03a6
            if (r11 == 0) goto L_0x0397
            r11 = r5
            goto L_0x0398
        L_0x0397:
            r11 = 0
        L_0x0398:
            if (r12 == 0) goto L_0x03a7
            if (r11 == 0) goto L_0x03a0
            r45 = 268435456(0x10000000, double:1.32624737E-315)
            goto L_0x03a3
        L_0x03a0:
            r45 = 134217728(0x8000000, double:6.63123685E-316)
        L_0x03a3:
            long r48 = r48 | r45
            goto L_0x03a7
        L_0x03a6:
            r11 = 0
        L_0x03a7:
            long r45 = r48 & r28
            r41 = 0
            int r12 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r12 == 0) goto L_0x03c4
            if (r9 != 0) goto L_0x03b2
            r5 = 0
        L_0x03b2:
            if (r12 == 0) goto L_0x03c5
            if (r5 == 0) goto L_0x03bc
            r45 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
            goto L_0x03c1
        L_0x03bc:
            r45 = 8796093022208(0x80000000000, double:4.345847379897E-311)
        L_0x03c1:
            long r48 = r48 | r45
            goto L_0x03c5
        L_0x03c4:
            r5 = 0
        L_0x03c5:
            r45 = 268435456(0x10000000, double:1.32624737E-315)
            long r45 = r48 & r45
            r41 = 0
            int r9 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r9 == 0) goto L_0x03e2
            if (r0 == 0) goto L_0x03d5
            androidx.databinding.ObservableBoolean r9 = r0.isChangeNamePermissionAvailabel
            goto L_0x03d7
        L_0x03d5:
            r9 = r30
        L_0x03d7:
            r12 = 2
            r1.updateRegistration((int) r12, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x03e2
            boolean r9 = r9.get()
            goto L_0x03e3
        L_0x03e2:
            r9 = 0
        L_0x03e3:
            r45 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
            long r45 = r48 & r45
            r41 = 0
            int r12 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r12 == 0) goto L_0x0409
            if (r0 == 0) goto L_0x03f5
            androidx.databinding.ObservableBoolean r12 = r0.isGstinPending
            goto L_0x03f7
        L_0x03f5:
            r12 = r30
        L_0x03f7:
            r30 = r9
            r9 = 12
            r1.updateRegistration((int) r9, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0405
            boolean r9 = r12.get()
            goto L_0x0406
        L_0x0405:
            r9 = 0
        L_0x0406:
            r12 = 1
            r9 = r9 ^ r12
            goto L_0x040c
        L_0x0409:
            r30 = r9
            r9 = 0
        L_0x040c:
            long r45 = r48 & r26
            r41 = 0
            int r12 = (r45 > r41 ? 1 : (r45 == r41 ? 0 : -1))
            if (r12 == 0) goto L_0x042c
            if (r11 != 0) goto L_0x0418
            r30 = 0
        L_0x0418:
            if (r12 == 0) goto L_0x0427
            if (r30 == 0) goto L_0x0420
            r11 = 1073741824(0x40000000, double:5.304989477E-315)
            goto L_0x0423
        L_0x0420:
            r11 = 536870912(0x20000000, double:2.652494739E-315)
        L_0x0423:
            long r11 = r48 | r11
            r48 = r11
        L_0x0427:
            if (r30 != 0) goto L_0x042c
            r11 = 8
            goto L_0x042d
        L_0x042c:
            r11 = 0
        L_0x042d:
            long r30 = r48 & r28
            r41 = 0
            int r12 = (r30 > r41 ? 1 : (r30 == r41 ? 0 : -1))
            if (r12 == 0) goto L_0x044d
            if (r5 != 0) goto L_0x0438
            r9 = 0
        L_0x0438:
            if (r12 == 0) goto L_0x0448
            if (r9 == 0) goto L_0x043f
            r30 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
            goto L_0x0444
        L_0x043f:
            r30 = 140737488355328(0x800000000000, double:6.953355807835E-310)
        L_0x0444:
            long r30 = r48 | r30
            r48 = r30
        L_0x0448:
            if (r9 != 0) goto L_0x044d
            r5 = 8
            goto L_0x044e
        L_0x044d:
            r5 = 0
        L_0x044e:
            long r22 = r48 & r22
            r30 = 0
            int r9 = (r22 > r30 ? 1 : (r22 == r30 ? 0 : -1))
            if (r9 == 0) goto L_0x0465
            android.widget.TextView r9 = r1.addAddress
            r9.setVisibility(r14)
            android.widget.TextView r9 = r1.editAddress
            r9.setVisibility(r2)
            android.widget.TextView r2 = r1.mboundView13
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r15)
        L_0x0465:
            long r14 = r48 & r28
            int r2 = (r14 > r30 ? 1 : (r14 == r30 ? 0 : -1))
            if (r2 == 0) goto L_0x0470
            android.widget.TextView r2 = r1.addGstIn
            r2.setVisibility(r5)
        L_0x0470:
            r14 = 27262976(0x1a00000, double:1.34697E-316)
            long r14 = r48 & r14
            int r2 = (r14 > r30 ? 1 : (r14 == r30 ? 0 : -1))
            if (r2 == 0) goto L_0x047e
            android.widget.LinearLayout r2 = r1.edcDetails
            r2.setVisibility(r4)
        L_0x047e:
            long r4 = r48 & r26
            int r2 = (r4 > r30 ? 1 : (r4 == r30 ? 0 : -1))
            if (r2 == 0) goto L_0x0489
            android.widget.TextView r2 = r1.editDisplayName
            r2.setVisibility(r11)
        L_0x0489:
            r4 = 25165840(0x1800010, double:1.2433577E-316)
            long r4 = r48 & r4
            int r2 = (r4 > r30 ? 1 : (r4 == r30 ? 0 : -1))
            if (r2 == 0) goto L_0x0497
            android.widget.TextView r2 = r1.mboundView5
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r8)
        L_0x0497:
            r4 = 29360128(0x1c00000, double:1.45058306E-316)
            long r4 = r48 & r4
            int r2 = (r4 > r30 ? 1 : (r4 == r30 ? 0 : -1))
            if (r2 == 0) goto L_0x04a5
            android.widget.TextView r2 = r1.mboundView7
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r3)
        L_0x04a5:
            long r2 = r48 & r16
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x04b0
            android.widget.TextView r2 = r1.mboundView8
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r6)
        L_0x04b0:
            r2 = 25165888(0x1800040, double:1.24336007E-316)
            long r2 = r48 & r2
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x04be
            android.widget.TextView r2 = r1.mboundView9
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r10)
        L_0x04be:
            long r2 = r48 & r20
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x04c9
            android.widget.TextView r2 = r1.mboundView9
            r2.setVisibility(r13)
        L_0x04c9:
            r2 = 25165832(0x1800008, double:1.2433573E-316)
            long r2 = r48 & r2
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x04d7
            android.widget.TextView r2 = r1.noOfDevicesUnderPlanValue
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r7)
        L_0x04d7:
            r2 = 26214400(0x1900000, double:1.29516345E-316)
            long r2 = r48 & r2
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x04e7
            android.widget.TextView r2 = r1.planTypeValue
            r3 = r44
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r3)
        L_0x04e7:
            r2 = 25165952(0x1800080, double:1.24336323E-316)
            long r2 = r48 & r2
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x04f7
            android.widget.TextView r2 = r1.totalRentalForXDevicesTxt
            r11 = r43
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r11)
        L_0x04f7:
            r2 = 25167872(0x1800800, double:1.2434581E-316)
            long r2 = r48 & r2
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x0507
            android.widget.TextView r2 = r1.totalRentalForXDevicesValue
            r3 = r35
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r3)
        L_0x0507:
            r2 = 25166080(0x1800100, double:1.24336956E-316)
            long r2 = r48 & r2
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x0517
            android.widget.TextView r2 = r1.usageDepositValue
            r12 = r50
            androidx.databinding.a.d.a((android.widget.TextView) r2, (java.lang.CharSequence) r12)
        L_0x0517:
            long r2 = r48 & r18
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x0528
            com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding r2 = r1.viewDisplayNameChange
            android.view.View r2 = r2.getRoot()
            r3 = r51
            r2.setVisibility(r3)
        L_0x0528:
            r2 = 25166336(0x1800200, double:1.2433822E-316)
            long r2 = r48 & r2
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x053c
            com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding r2 = r1.viewGstinChange
            android.view.View r2 = r2.getRoot()
            r3 = r52
            r2.setVisibility(r3)
        L_0x053c:
            r2 = 25165824(0x1800000, double:1.2433569E-316)
            long r2 = r48 & r2
            int r4 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r4 == 0) goto L_0x054a
            com.paytm.business.merchantprofile.databinding.PrProfileScreenHeaderBinding r2 = r1.viewProfileHeader
            r2.setViewModel(r0)
        L_0x054a:
            com.paytm.business.merchantprofile.databinding.PrActivityProfileBusinessDetailsShimmerBinding r0 = r1.shimmerContainer
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            com.paytm.business.merchantprofile.databinding.PrProfileScreenHeaderBinding r0 = r1.viewProfileHeader
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding r0 = r1.viewDisplayNameChange
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding r0 = r1.viewGstinChange
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            com.paytm.business.merchantprofile.databinding.PrProfileReactivateBinding r0 = r1.llDeactivateContainer
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x0564:
            r0 = move-exception
            monitor-exit(r53)     // Catch:{ all -> 0x0564 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.databinding.PrActivityProfileBusinessDetailsNewBindingImpl.executeBindings():void");
    }
}
