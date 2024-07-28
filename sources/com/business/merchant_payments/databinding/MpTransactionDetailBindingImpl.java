package com.business.merchant_payments.databinding;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.i;
import androidx.lifecycle.q;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.BR;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel;

public class MpTransactionDetailBindingImpl extends MpTransactionDetailBinding {
    public static final ViewDataBinding.b sIncludes;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final RelativeLayout mboundView11;
    public final RelativeLayout mboundView13;
    public final RelativeLayout mboundView17;
    public final CustomTextView mboundView8;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(44);
        sIncludes = bVar;
        bVar.a(1, new String[]{"mp_transaction_detail_sub_view"}, new int[]{26}, new int[]{R.layout.mp_transaction_detail_sub_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header_outer_most_container, 27);
        sViewsWithIds.put(R.id.iv_close, 28);
        sViewsWithIds.put(R.id.rl_amnt_status, 29);
        sViewsWithIds.put(R.id.rl_date, 30);
        sViewsWithIds.put(R.id.rl_warning, 31);
        sViewsWithIds.put(R.id.rl_print_reciept, 32);
        sViewsWithIds.put(R.id.iv_print_reciept, 33);
        sViewsWithIds.put(R.id.tv_print_reciept, 34);
        sViewsWithIds.put(R.id.rl_need_help, 35);
        sViewsWithIds.put(R.id.iv_need_help, 36);
        sViewsWithIds.put(R.id.tv_need_help, 37);
        sViewsWithIds.put(R.id.tv_settlement_detail_header, 38);
        sViewsWithIds.put(R.id.tv_settlement_date_title, 39);
        sViewsWithIds.put(R.id.utr_title, 40);
        sViewsWithIds.put(R.id.total_payment_collected_container, 41);
        sViewsWithIds.put(R.id.net_top_sep, 42);
        sViewsWithIds.put(R.id.net_total_txt, 43);
    }

    public MpTransactionDetailBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 44, sIncludes, sViewsWithIds));
    }

    public MpTransactionDetailBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 22, objArr[18], objArr[19], objArr[0], objArr[26], objArr[9], objArr[21], objArr[20], objArr[1], objArr[27], objArr[25], objArr[28], objArr[36], objArr[33], objArr[2], objArr[10], objArr[42], objArr[22], objArr[43], objArr[29], objArr[30], objArr[23], objArr[35], objArr[32], objArr[31], objArr[41], objArr[16], objArr[15], objArr[3], objArr[5], objArr[4], objArr[24], objArr[37], objArr[34], objArr[12], objArr[39], objArr[38], objArr[6], objArr[14], objArr[40], objArr[7]);
        this.mDirtyFlags = -1;
        this.commission.setTag((Object) null);
        this.commissionAmnt.setTag((Object) null);
        this.coordinatorLayout.setTag((Object) null);
        this.dotProgressBar.setTag((Object) null);
        this.gstAmntTxt.setTag((Object) null);
        this.gstTxt.setTag((Object) null);
        this.headerInnerContainer.setTag((Object) null);
        this.initiateRefundBtn.setTag((Object) null);
        this.ivStatus.setTag((Object) null);
        this.llSettlementDetailContainer.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[11];
        this.mboundView11 = relativeLayout;
        relativeLayout.setTag((Object) null);
        RelativeLayout relativeLayout2 = objArr[13];
        this.mboundView13 = relativeLayout2;
        relativeLayout2.setTag((Object) null);
        RelativeLayout relativeLayout3 = objArr[17];
        this.mboundView17 = relativeLayout3;
        relativeLayout3.setTag((Object) null);
        CustomTextView customTextView = objArr[8];
        this.mboundView8 = customTextView;
        customTextView.setTag((Object) null);
        this.netTotalAmnt.setTag((Object) null);
        this.rlIncentiveStrip.setTag((Object) null);
        this.transferedToBnkAmnt.setTag((Object) null);
        this.transferedToBnkTxt.setTag((Object) null);
        this.tvAmnt.setTag((Object) null);
        this.tvDateTime.setTag((Object) null);
        this.tvDetail.setTag((Object) null);
        this.tvIncentiveAmt.setTag((Object) null);
        this.tvSettlementDateText.setTag((Object) null);
        this.tvTxnId.setTag((Object) null);
        this.tvUtrText.setTag((Object) null);
        this.warningImage.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8388608;
        }
        this.detailsContainer.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.detailsContainer.hasPendingBindings() == false) goto L_0x0016;
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
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r0 = r6.detailsContainer
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
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpTransactionDetailBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i2, Object obj) {
        if (BR.viewModel != i2) {
            return false;
        }
        setViewModel((OnlineTxnDetailsViewModel) obj);
        return true;
    }

    public void setViewModel(OnlineTxnDetailsViewModel onlineTxnDetailsViewModel) {
        this.mViewModel = onlineTxnDetailsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    public void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.detailsContainer.setLifecycleOwner(qVar);
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return onChangeViewModelTransactionStatusImage((i) obj, i3);
            case 1:
                return onChangeViewModelIsRefund((ObservableBoolean) obj, i3);
            case 2:
                return onChangeViewModelTotalPaymentCollected((i) obj, i3);
            case 3:
                return onChangeViewModelSettlementVisibility((ObservableBoolean) obj, i3);
            case 4:
                return onChangeViewModelIsPCFTransaction((ObservableBoolean) obj, i3);
            case 5:
                return onChangeViewModelIsRefundable((ObservableBoolean) obj, i3);
            case 6:
                return onChangeViewModelIsGstPaidByUser((ObservableBoolean) obj, i3);
            case 7:
                return onChangeViewModelUtrNo((i) obj, i3);
            case 8:
                return onChangeViewModelIsCashWithdrawalIncentive((ObservableBoolean) obj, i3);
            case 9:
                return onChangeViewModelIsCommisionPaidByUser((ObservableBoolean) obj, i3);
            case 10:
                return onChangeViewModelTxnId((i) obj, i3);
            case 11:
                return onChangeViewModelDottedProgressBarVisibility((ObservableBoolean) obj, i3);
            case 12:
                return onChangeViewModelWarningVisibility((i) obj, i3);
            case 13:
                return onChangeViewModelCommision((i) obj, i3);
            case 14:
                return onChangeViewModelGST((i) obj, i3);
            case 15:
                return onChangeViewModelNetTotal((i) obj, i3);
            case 16:
                return onChangeViewModelIncentiveAmt((i) obj, i3);
            case 17:
                return onChangeViewModelDateText((i) obj, i3);
            case 18:
                return onChangeViewModelReceivedForText((i) obj, i3);
            case 19:
                return onChangeDetailsContainer((MpTransactionDetailSubViewBinding) obj, i3);
            case 20:
                return onChangeViewModelSettlementDate((i) obj, i3);
            case 21:
                return onChangeViewModelCommissionText((i) obj, i3);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelTransactionStatusImage(i<Drawable> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelIsRefund(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelTotalPaymentCollected(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelSettlementVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelIsPCFTransaction(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelIsRefundable(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelIsGstPaidByUser(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelUtrNo(i<Spannable> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelIsCashWithdrawalIncentive(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelIsCommisionPaidByUser(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelTxnId(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelDottedProgressBarVisibility(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelWarningVisibility(i<Integer> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeViewModelCommision(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeViewModelGST(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeViewModelNetTotal(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeViewModelIncentiveAmt(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeViewModelDateText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeViewModelReceivedForText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeDetailsContainer(MpTransactionDetailSubViewBinding mpTransactionDetailSubViewBinding, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeViewModelSettlementDate(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeViewModelCommissionText(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x039f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0520  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x054b  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0552 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x055b  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x056b  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0576  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x0592  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x05b1  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x05bf  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x05cd  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x05e0  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x05fc  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0611  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0621  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x0638  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0648  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0658  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0668  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x067f  */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0688  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0698  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r63 = this;
            r1 = r63
            monitor-enter(r63)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x06a5 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x06a5 }
            monitor-exit(r63)     // Catch:{ all -> 0x06a5 }
            com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel r0 = r1.mViewModel
            r6 = 16252927(0xf7ffff, double:8.030013E-317)
            long r6 = r6 & r2
            r10 = 12582920(0xc00008, double:6.2167885E-317)
            r14 = 12582916(0xc00004, double:6.2167865E-317)
            r16 = 274877906944(0x4000000000, double:1.358077306218E-312)
            r18 = 12582914(0xc00002, double:6.2167855E-317)
            r20 = 8796093022208(0x80000000000, double:4.345847379897E-311)
            r22 = 12582913(0xc00001, double:6.216785E-317)
            r24 = 12584960(0xc00800, double:6.2177964E-317)
            r26 = 12584992(0xc00820, double:6.217812E-317)
            r8 = 0
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0450
            long r6 = r2 & r22
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0049
            if (r0 == 0) goto L_0x003c
            androidx.databinding.i<android.graphics.drawable.Drawable> r6 = r0.transactionStatusImage
            goto L_0x003d
        L_0x003c:
            r6 = 0
        L_0x003d:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0049
            java.lang.Object r6 = r6.get()
            android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            long r30 = r2 & r18
            r7 = 1
            r8 = 8
            int r32 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r32 == 0) goto L_0x0076
            if (r0 == 0) goto L_0x0058
            androidx.databinding.ObservableBoolean r9 = r0.isRefund
            goto L_0x0059
        L_0x0058:
            r9 = 0
        L_0x0059:
            r1.updateRegistration((int) r7, (androidx.databinding.h) r9)
            if (r9 == 0) goto L_0x0063
            boolean r9 = r9.get()
            goto L_0x0064
        L_0x0063:
            r9 = 0
        L_0x0064:
            if (r32 == 0) goto L_0x0071
            if (r9 == 0) goto L_0x006c
            r32 = 134217728(0x8000000, double:6.63123685E-316)
            goto L_0x006f
        L_0x006c:
            r32 = 67108864(0x4000000, double:3.31561842E-316)
        L_0x006f:
            long r2 = r2 | r32
        L_0x0071:
            if (r9 == 0) goto L_0x0076
            r9 = 8
            goto L_0x0077
        L_0x0076:
            r9 = 0
        L_0x0077:
            long r32 = r2 & r14
            int r31 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r31 == 0) goto L_0x0090
            if (r0 == 0) goto L_0x0082
            androidx.databinding.i<java.lang.String> r14 = r0.totalPaymentCollected
            goto L_0x0083
        L_0x0082:
            r14 = 0
        L_0x0083:
            r15 = 2
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0090
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x0091
        L_0x0090:
            r14 = 0
        L_0x0091:
            long r34 = r2 & r10
            int r15 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00bf
            if (r0 == 0) goto L_0x009c
            androidx.databinding.ObservableBoolean r10 = r0.settlementVisibility
            goto L_0x009d
        L_0x009c:
            r10 = 0
        L_0x009d:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x00a8
            boolean r10 = r10.get()
            goto L_0x00a9
        L_0x00a8:
            r10 = 0
        L_0x00a9:
            if (r15 == 0) goto L_0x00ba
            if (r10 == 0) goto L_0x00b3
            r36 = 140737488355328(0x800000000000, double:6.953355807835E-310)
            goto L_0x00b8
        L_0x00b3:
            r36 = 70368744177664(0x400000000000, double:3.4766779039175E-310)
        L_0x00b8:
            long r2 = r2 | r36
        L_0x00ba:
            if (r10 != 0) goto L_0x00bf
            r10 = 8
            goto L_0x00c0
        L_0x00bf:
            r10 = 0
        L_0x00c0:
            r36 = 12582928(0xc00010, double:6.2167924E-317)
            long r36 = r2 & r36
            int r11 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00ed
            if (r0 == 0) goto L_0x00ce
            androidx.databinding.ObservableBoolean r15 = r0.isPCFTransaction
            goto L_0x00cf
        L_0x00ce:
            r15 = 0
        L_0x00cf:
            r7 = 4
            r1.updateRegistration((int) r7, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00da
            boolean r7 = r15.get()
            goto L_0x00db
        L_0x00da:
            r7 = 0
        L_0x00db:
            if (r11 == 0) goto L_0x00e8
            if (r7 == 0) goto L_0x00e3
            r36 = 33554432(0x2000000, double:1.6578092E-316)
            goto L_0x00e6
        L_0x00e3:
            r36 = 16777216(0x1000000, double:8.289046E-317)
        L_0x00e6:
            long r2 = r2 | r36
        L_0x00e8:
            if (r7 == 0) goto L_0x00ed
            r7 = 8
            goto L_0x00ee
        L_0x00ed:
            r7 = 0
        L_0x00ee:
            r36 = 12582976(0xc00040, double:6.216816E-317)
            long r36 = r2 & r36
            int r11 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0146
            if (r0 == 0) goto L_0x00fc
            androidx.databinding.ObservableBoolean r15 = r0.isGstPaidByUser
            goto L_0x00fd
        L_0x00fc:
            r15 = 0
        L_0x00fd:
            r12 = 6
            r1.updateRegistration((int) r12, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0108
            boolean r12 = r15.get()
            goto L_0x0109
        L_0x0108:
            r12 = 0
        L_0x0109:
            if (r11 == 0) goto L_0x011a
            if (r12 == 0) goto L_0x0113
            r38 = 137438953472(0x2000000000, double:6.7903865311E-313)
            goto L_0x0118
        L_0x0113:
            r38 = 68719476736(0x1000000000, double:3.39519326554E-313)
        L_0x0118:
            long r2 = r2 | r38
        L_0x011a:
            if (r12 == 0) goto L_0x0139
            android.widget.TextView r11 = r1.gstTxt
            android.content.res.Resources r11 = r11.getResources()
            int r12 = com.business.merchant_payments.R.string.mp_gst
            java.lang.String r11 = r11.getString(r12)
            android.widget.TextView r12 = r1.gstTxt
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.business.merchant_payments.R.string.mp_paid_by_user_text
            java.lang.String r12 = r12.getString(r13)
            java.lang.String r11 = r11.concat(r12)
            goto L_0x0147
        L_0x0139:
            android.widget.TextView r11 = r1.gstTxt
            android.content.res.Resources r11 = r11.getResources()
            int r12 = com.business.merchant_payments.R.string.mp_gst
            java.lang.String r11 = r11.getString(r12)
            goto L_0x0147
        L_0x0146:
            r11 = 0
        L_0x0147:
            r12 = 12583040(0xc00080, double:6.216848E-317)
            long r12 = r12 & r2
            int r15 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0162
            if (r0 == 0) goto L_0x0154
            androidx.databinding.i<android.text.Spannable> r12 = r0.utrNo
            goto L_0x0155
        L_0x0154:
            r12 = 0
        L_0x0155:
            r13 = 7
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0162
            java.lang.Object r12 = r12.get()
            android.text.Spannable r12 = (android.text.Spannable) r12
            goto L_0x0163
        L_0x0162:
            r12 = 0
        L_0x0163:
            r38 = 12583168(0xc00100, double:6.216911E-317)
            long r38 = r2 & r38
            int r13 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x01ba
            if (r0 == 0) goto L_0x0171
            androidx.databinding.ObservableBoolean r15 = r0.isCashWithdrawalIncentive
            goto L_0x0172
        L_0x0171:
            r15 = 0
        L_0x0172:
            r1.updateRegistration((int) r8, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x017c
            boolean r15 = r15.get()
            goto L_0x017d
        L_0x017c:
            r15 = 0
        L_0x017d:
            if (r13 == 0) goto L_0x0198
            if (r15 == 0) goto L_0x018c
            r38 = 536870912(0x20000000, double:2.652494739E-315)
            long r2 = r2 | r38
            r38 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
            goto L_0x0196
        L_0x018c:
            r38 = 268435456(0x10000000, double:1.32624737E-315)
            long r2 = r2 | r38
            r38 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
        L_0x0196:
            long r2 = r2 | r38
        L_0x0198:
            if (r15 == 0) goto L_0x019d
            r13 = 8
            goto L_0x019e
        L_0x019d:
            r13 = 0
        L_0x019e:
            if (r15 == 0) goto L_0x01ad
            android.widget.TextView r15 = r1.transferedToBnkTxt
            android.content.res.Resources r15 = r15.getResources()
            int r8 = com.business.merchant_payments.R.string.mp_incentive_amount
            java.lang.String r8 = r15.getString(r8)
            goto L_0x01bc
        L_0x01ad:
            android.widget.TextView r8 = r1.transferedToBnkTxt
            android.content.res.Resources r8 = r8.getResources()
            int r15 = com.business.merchant_payments.R.string.mp_payment_amount
            java.lang.String r8 = r8.getString(r15)
            goto L_0x01bc
        L_0x01ba:
            r8 = 0
            r13 = 0
        L_0x01bc:
            r36 = 14680576(0xe00200, double:7.2531683E-317)
            long r39 = r2 & r36
            int r15 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x01ea
            if (r0 == 0) goto L_0x01ca
            androidx.databinding.ObservableBoolean r4 = r0.isCommisionPaidByUser
            goto L_0x01cb
        L_0x01ca:
            r4 = 0
        L_0x01cb:
            r5 = 9
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01d7
            boolean r4 = r4.get()
            goto L_0x01d8
        L_0x01d7:
            r4 = 0
        L_0x01d8:
            if (r15 == 0) goto L_0x01eb
            if (r4 == 0) goto L_0x01e2
            r41 = 34359738368(0x800000000, double:1.69759663277E-313)
            goto L_0x01e7
        L_0x01e2:
            r41 = 17179869184(0x400000000, double:8.4879831639E-314)
        L_0x01e7:
            long r2 = r2 | r41
            goto L_0x01eb
        L_0x01ea:
            r4 = 0
        L_0x01eb:
            r28 = 12583936(0xc00400, double:6.2172905E-317)
            long r41 = r2 & r28
            r39 = 0
            int r5 = (r41 > r39 ? 1 : (r41 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0222
            if (r0 == 0) goto L_0x01fd
            androidx.databinding.i<java.lang.String> r15 = r0.txnId
            r41 = r4
            goto L_0x0200
        L_0x01fd:
            r41 = r4
            r15 = 0
        L_0x0200:
            r4 = 10
            r1.updateRegistration((int) r4, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x020e
            java.lang.Object r4 = r15.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x020f
        L_0x020e:
            r4 = 0
        L_0x020f:
            boolean r15 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0226
            if (r15 == 0) goto L_0x021f
            r42 = 549755813888(0x8000000000, double:2.716154612436E-312)
            long r2 = r2 | r42
            goto L_0x0226
        L_0x021f:
            long r2 = r2 | r16
            goto L_0x0226
        L_0x0222:
            r41 = r4
            r4 = 0
            r15 = 0
        L_0x0226:
            long r42 = r2 & r26
            r39 = 0
            int r5 = (r42 > r39 ? 1 : (r42 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x027f
            if (r0 == 0) goto L_0x0235
            androidx.databinding.ObservableBoolean r5 = r0.dottedProgressBarVisibility
            r42 = r4
            goto L_0x0238
        L_0x0235:
            r42 = r4
            r5 = 0
        L_0x0238:
            r4 = 11
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0244
            boolean r4 = r5.get()
            goto L_0x0245
        L_0x0244:
            r4 = 0
        L_0x0245:
            long r43 = r2 & r24
            r39 = 0
            int r5 = (r43 > r39 ? 1 : (r43 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x025c
            if (r4 == 0) goto L_0x0255
            r43 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
            goto L_0x025a
        L_0x0255:
            r43 = 1099511627776(0x10000000000, double:5.43230922487E-312)
        L_0x025a:
            long r2 = r2 | r43
        L_0x025c:
            long r43 = r2 & r24
            int r5 = (r43 > r39 ? 1 : (r43 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0267
            if (r4 != 0) goto L_0x0267
            r5 = 8
            goto L_0x0268
        L_0x0267:
            r5 = 0
        L_0x0268:
            r31 = 1
            r4 = r4 ^ 1
            long r43 = r2 & r26
            int r31 = (r43 > r39 ? 1 : (r43 == r39 ? 0 : -1))
            if (r31 == 0) goto L_0x0283
            if (r4 == 0) goto L_0x0277
            long r2 = r2 | r20
            goto L_0x0283
        L_0x0277:
            r43 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r2 = r2 | r43
            goto L_0x0283
        L_0x027f:
            r42 = r4
            r4 = 0
            r5 = 0
        L_0x0283:
            r43 = 12587008(0xc01000, double:6.218808E-317)
            long r43 = r2 & r43
            r39 = 0
            int r31 = (r43 > r39 ? 1 : (r43 == r39 ? 0 : -1))
            if (r31 == 0) goto L_0x02ae
            r31 = r4
            if (r0 == 0) goto L_0x0297
            androidx.databinding.i<java.lang.Integer> r4 = r0.warningVisibility
            r43 = r5
            goto L_0x029a
        L_0x0297:
            r43 = r5
            r4 = 0
        L_0x029a:
            r5 = 12
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x02a8
            java.lang.Object r4 = r4.get()
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x02a9
        L_0x02a8:
            r4 = 0
        L_0x02a9:
            int r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r4)
            goto L_0x02b3
        L_0x02ae:
            r31 = r4
            r43 = r5
            r4 = 0
        L_0x02b3:
            r44 = 12591104(0xc02000, double:6.220832E-317)
            long r44 = r2 & r44
            r39 = 0
            int r5 = (r44 > r39 ? 1 : (r44 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x02d6
            if (r0 == 0) goto L_0x02c5
            androidx.databinding.i<java.lang.String> r5 = r0.commision
            r44 = r4
            goto L_0x02c8
        L_0x02c5:
            r44 = r4
            r5 = 0
        L_0x02c8:
            r4 = 13
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02d8
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x02d9
        L_0x02d6:
            r44 = r4
        L_0x02d8:
            r4 = 0
        L_0x02d9:
            r45 = 12599296(0xc04000, double:6.2248793E-317)
            long r45 = r2 & r45
            r39 = 0
            int r5 = (r45 > r39 ? 1 : (r45 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x02fc
            if (r0 == 0) goto L_0x02eb
            androidx.databinding.i<java.lang.String> r5 = r0.GST
            r45 = r4
            goto L_0x02ee
        L_0x02eb:
            r45 = r4
            r5 = 0
        L_0x02ee:
            r4 = 14
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x02fe
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x02ff
        L_0x02fc:
            r45 = r4
        L_0x02fe:
            r4 = 0
        L_0x02ff:
            r46 = 12615680(0xc08000, double:6.232974E-317)
            long r46 = r2 & r46
            r39 = 0
            int r5 = (r46 > r39 ? 1 : (r46 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0322
            if (r0 == 0) goto L_0x0311
            androidx.databinding.i<java.lang.String> r5 = r0.netTotal
            r46 = r4
            goto L_0x0314
        L_0x0311:
            r46 = r4
            r5 = 0
        L_0x0314:
            r4 = 15
            r1.updateRegistration((int) r4, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0324
            java.lang.Object r4 = r5.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0325
        L_0x0322:
            r46 = r4
        L_0x0324:
            r4 = 0
        L_0x0325:
            r47 = 12648448(0xc10000, double:6.2491636E-317)
            long r47 = r2 & r47
            r39 = 0
            int r5 = (r47 > r39 ? 1 : (r47 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x0368
            r47 = r4
            if (r0 == 0) goto L_0x0339
            androidx.databinding.i<java.lang.String> r4 = r0.incentiveAmt
            r48 = r6
            goto L_0x033c
        L_0x0339:
            r48 = r6
            r4 = 0
        L_0x033c:
            r6 = 16
            r1.updateRegistration((int) r6, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x034a
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x034b
        L_0x034a:
            r4 = 0
        L_0x034b:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0360
            if (r6 == 0) goto L_0x0359
            r49 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x035e
        L_0x0359:
            r49 = 4294967296(0x100000000, double:2.121995791E-314)
        L_0x035e:
            long r2 = r2 | r49
        L_0x0360:
            r5 = r4
            if (r6 == 0) goto L_0x0366
            r4 = 8
            goto L_0x036e
        L_0x0366:
            r4 = 0
            goto L_0x036e
        L_0x0368:
            r47 = r4
            r48 = r6
            r4 = 0
            r5 = 0
        L_0x036e:
            r49 = 12713984(0xc20000, double:6.2815427E-317)
            long r49 = r2 & r49
            r39 = 0
            int r6 = (r49 > r39 ? 1 : (r49 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x0391
            if (r0 == 0) goto L_0x0380
            androidx.databinding.i<java.lang.String> r6 = r0.dateText
            r49 = r4
            goto L_0x0383
        L_0x0380:
            r49 = r4
            r6 = 0
        L_0x0383:
            r4 = 17
            r1.updateRegistration((int) r4, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0393
            java.lang.Object r4 = r6.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0394
        L_0x0391:
            r49 = r4
        L_0x0393:
            r4 = 0
        L_0x0394:
            r50 = 12582912(0xc00000, double:6.2167845E-317)
            long r50 = r2 & r50
            r39 = 0
            int r6 = (r50 > r39 ? 1 : (r50 == r39 ? 0 : -1))
            if (r6 == 0) goto L_0x03a6
            if (r0 == 0) goto L_0x03a6
            java.lang.String r6 = r0.getAmount()
            goto L_0x03a7
        L_0x03a6:
            r6 = 0
        L_0x03a7:
            r50 = 12845056(0xc40000, double:6.346301E-317)
            long r50 = r2 & r50
            int r52 = (r50 > r39 ? 1 : (r50 == r39 ? 0 : -1))
            if (r52 == 0) goto L_0x03e3
            r50 = r4
            if (r0 == 0) goto L_0x03b9
            androidx.databinding.i<java.lang.String> r4 = r0.receivedForText
            r51 = r5
            goto L_0x03bc
        L_0x03b9:
            r51 = r5
            r4 = 0
        L_0x03bc:
            r5 = 18
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x03ca
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x03cb
        L_0x03ca:
            r4 = 0
        L_0x03cb:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r52 == 0) goto L_0x03de
            if (r5 == 0) goto L_0x03d9
            r52 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x03dc
        L_0x03d9:
            r52 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x03dc:
            long r2 = r2 | r52
        L_0x03de:
            if (r5 == 0) goto L_0x03e8
            r38 = 8
            goto L_0x03ea
        L_0x03e3:
            r50 = r4
            r51 = r5
            r4 = 0
        L_0x03e8:
            r38 = 0
        L_0x03ea:
            r52 = 13631488(0xd00000, double:6.73485E-317)
            long r52 = r2 & r52
            r39 = 0
            int r5 = (r52 > r39 ? 1 : (r52 == r39 ? 0 : -1))
            if (r5 == 0) goto L_0x042d
            if (r0 == 0) goto L_0x03fc
            androidx.databinding.i<java.lang.String> r5 = r0.settlementDate
            r52 = r2
            goto L_0x03ff
        L_0x03fc:
            r52 = r2
            r5 = 0
        L_0x03ff:
            r2 = 20
            r1.updateRegistration((int) r2, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x042f
            java.lang.Object r2 = r5.get()
            java.lang.String r2 = (java.lang.String) r2
            r61 = r2
            r59 = r4
            r57 = r6
            r62 = r12
            r56 = r14
            r60 = r38
            r2 = r42
            r4 = r43
            r12 = r44
            r3 = r45
            r5 = r46
            r14 = r47
            r6 = r48
            r54 = r49
            r58 = r50
            r55 = r51
            goto L_0x0476
        L_0x042d:
            r52 = r2
        L_0x042f:
            r59 = r4
            r57 = r6
            r62 = r12
            r56 = r14
            r60 = r38
            r2 = r42
            r4 = r43
            r12 = r44
            r3 = r45
            r5 = r46
            r14 = r47
            r6 = r48
            r54 = r49
            r58 = r50
            r55 = r51
            r61 = 0
            goto L_0x0476
        L_0x0450:
            r52 = r2
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r31 = 0
            r41 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
        L_0x0476:
            long r20 = r52 & r20
            r38 = 0
            int r42 = (r20 > r38 ? 1 : (r20 == r38 ? 0 : -1))
            if (r42 == 0) goto L_0x0495
            r20 = r14
            if (r0 == 0) goto L_0x0487
            androidx.databinding.ObservableBoolean r14 = r0.isRefundable
            r21 = r12
            goto L_0x048a
        L_0x0487:
            r21 = r12
            r14 = 0
        L_0x048a:
            r12 = 5
            r1.updateRegistration((int) r12, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x0499
            boolean r12 = r14.get()
            goto L_0x049a
        L_0x0495:
            r21 = r12
            r20 = r14
        L_0x0499:
            r12 = 0
        L_0x049a:
            long r16 = r52 & r16
            r38 = 0
            int r14 = (r16 > r38 ? 1 : (r16 == r38 ? 0 : -1))
            if (r14 == 0) goto L_0x04c5
            if (r0 == 0) goto L_0x04a9
            java.lang.String r14 = r0.whiteSpace
            r16 = r12
            goto L_0x04ac
        L_0x04a9:
            r16 = r12
            r14 = 0
        L_0x04ac:
            android.widget.TextView r12 = r1.tvTxnId
            android.content.res.Resources r12 = r12.getResources()
            r17 = r8
            int r8 = com.business.merchant_payments.R.string.mp_txn_id_lower
            java.lang.String r8 = r12.getString(r8)
            java.lang.String r8 = r8.concat(r14)
            if (r8 == 0) goto L_0x04c9
            java.lang.String r2 = r8.concat(r2)
            goto L_0x04ca
        L_0x04c5:
            r17 = r8
            r16 = r12
        L_0x04c9:
            r2 = 0
        L_0x04ca:
            r42 = 51539607552(0xc00000000, double:2.54639494916E-313)
            long r42 = r52 & r42
            r38 = 0
            int r8 = (r42 > r38 ? 1 : (r42 == r38 ? 0 : -1))
            if (r8 == 0) goto L_0x0520
            if (r0 == 0) goto L_0x04dc
            androidx.databinding.i<java.lang.String> r0 = r0.commissionText
            goto L_0x04dd
        L_0x04dc:
            r0 = 0
        L_0x04dd:
            r8 = 21
            r1.updateRegistration((int) r8, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x04eb
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x04ec
        L_0x04eb:
            r0 = 0
        L_0x04ec:
            if (r0 == 0) goto L_0x04ff
            android.widget.TextView r8 = r1.commission
            android.content.res.Resources r8 = r8.getResources()
            int r12 = com.business.merchant_payments.R.string.mp_commission
            java.lang.String r8 = r8.getString(r12)
            java.lang.String r0 = r0.concat(r8)
            goto L_0x0500
        L_0x04ff:
            r0 = 0
        L_0x0500:
            r42 = 34359738368(0x800000000, double:1.69759663277E-313)
            long r42 = r52 & r42
            r38 = 0
            int r8 = (r42 > r38 ? 1 : (r42 == r38 ? 0 : -1))
            if (r8 == 0) goto L_0x0521
            if (r0 == 0) goto L_0x0521
            android.widget.TextView r8 = r1.commission
            android.content.res.Resources r8 = r8.getResources()
            int r12 = com.business.merchant_payments.R.string.mp_paid_by_user_text
            java.lang.String r8 = r8.getString(r12)
            java.lang.String r8 = r0.concat(r8)
            goto L_0x0522
        L_0x0520:
            r0 = 0
        L_0x0521:
            r8 = 0
        L_0x0522:
            r36 = 14680576(0xe00200, double:7.2531683E-317)
            long r36 = r52 & r36
            r38 = 0
            int r12 = (r36 > r38 ? 1 : (r36 == r38 ? 0 : -1))
            if (r12 == 0) goto L_0x0532
            if (r41 != 0) goto L_0x0530
            goto L_0x0533
        L_0x0530:
            r0 = r8
            goto L_0x0533
        L_0x0532:
            r0 = 0
        L_0x0533:
            r28 = 12583936(0xc00400, double:6.2172905E-317)
            long r28 = r52 & r28
            int r8 = (r28 > r38 ? 1 : (r28 == r38 ? 0 : -1))
            if (r8 == 0) goto L_0x054b
            if (r15 == 0) goto L_0x054c
            android.widget.TextView r2 = r1.tvTxnId
            android.content.res.Resources r2 = r2.getResources()
            int r14 = com.business.merchant_payments.R.string.mp_hyphen
            java.lang.String r2 = r2.getString(r14)
            goto L_0x054c
        L_0x054b:
            r2 = 0
        L_0x054c:
            long r14 = r52 & r26
            int r26 = (r14 > r38 ? 1 : (r14 == r38 ? 0 : -1))
            if (r26 == 0) goto L_0x0558
            if (r31 != 0) goto L_0x0555
            goto L_0x0558
        L_0x0555:
            r14 = r16
            goto L_0x0559
        L_0x0558:
            r14 = 0
        L_0x0559:
            if (r12 == 0) goto L_0x0560
            android.widget.TextView r12 = r1.commission
            androidx.databinding.a.d.a((android.widget.TextView) r12, (java.lang.CharSequence) r0)
        L_0x0560:
            r15 = 12591104(0xc02000, double:6.220832E-317)
            long r15 = r52 & r15
            r27 = 0
            int r0 = (r15 > r27 ? 1 : (r15 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x0570
            android.widget.TextView r0 = r1.commissionAmnt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r3)
        L_0x0570:
            long r15 = r52 & r24
            int r0 = (r15 > r27 ? 1 : (r15 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x057b
            com.business.merchant_payments.widget.DotProgressBar r0 = r1.dotProgressBar
            r0.setVisibility(r4)
        L_0x057b:
            r3 = 12599296(0xc04000, double:6.2248793E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r27 ? 1 : (r3 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x0589
            android.widget.TextView r0 = r1.gstAmntTxt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r5)
        L_0x0589:
            r3 = 12582976(0xc00040, double:6.216816E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r27 ? 1 : (r3 == r27 ? 0 : -1))
            if (r0 == 0) goto L_0x0597
            android.widget.TextView r0 = r1.gstTxt
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x0597:
            if (r26 == 0) goto L_0x059e
            android.widget.TextView r0 = r1.initiateRefundBtn
            r0.setClickable(r14)
        L_0x059e:
            long r3 = r52 & r18
            r11 = 0
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x05ab
            android.widget.TextView r0 = r1.initiateRefundBtn
            r0.setVisibility(r9)
        L_0x05ab:
            long r3 = r52 & r22
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x05b6
            android.widget.ImageView r0 = r1.ivStatus
            r0.setImageDrawable(r6)
        L_0x05b6:
            r3 = 12582920(0xc00008, double:6.2167885E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x05c4
            android.widget.LinearLayout r0 = r1.llSettlementDetailContainer
            r0.setVisibility(r10)
        L_0x05c4:
            r3 = 12582928(0xc00010, double:6.2167924E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x05d7
            android.widget.RelativeLayout r0 = r1.mboundView11
            r0.setVisibility(r7)
            android.widget.RelativeLayout r0 = r1.mboundView13
            r0.setVisibility(r7)
        L_0x05d7:
            r3 = 12583168(0xc00100, double:6.216911E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x05f1
            android.widget.RelativeLayout r0 = r1.mboundView17
            r0.setVisibility(r13)
            android.widget.TextView r0 = r1.transferedToBnkTxt
            r3 = r17
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r3)
            android.widget.TextView r0 = r1.tvDateTime
            r0.setVisibility(r13)
        L_0x05f1:
            r3 = 12587008(0xc01000, double:6.218808E-317)
            long r3 = r52 & r3
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0608
            com.business.common_module.view.widget.CustomTextView r0 = r1.mboundView8
            r3 = r21
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r1.warningImage
            r0.setVisibility(r3)
        L_0x0608:
            r3 = 12615680(0xc08000, double:6.232974E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0618
            android.widget.TextView r0 = r1.netTotalAmnt
            r3 = r20
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r3)
        L_0x0618:
            r3 = 12648448(0xc10000, double:6.2491636E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x062f
            android.widget.RelativeLayout r0 = r1.rlIncentiveStrip
            r3 = r54
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.tvIncentiveAmt
            r3 = r55
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r3)
        L_0x062f:
            r3 = 12582916(0xc00004, double:6.2167865E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x063f
            android.widget.TextView r0 = r1.transferedToBnkAmnt
            r14 = r56
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r14)
        L_0x063f:
            r3 = 12582912(0xc00000, double:6.2167845E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x064f
            android.widget.TextView r0 = r1.tvAmnt
            r3 = r57
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r3)
        L_0x064f:
            r3 = 12713984(0xc20000, double:6.2815427E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x065f
            android.widget.TextView r0 = r1.tvDateTime
            r3 = r58
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r3)
        L_0x065f:
            r3 = 12845056(0xc40000, double:6.346301E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0676
            android.widget.TextView r0 = r1.tvDetail
            r4 = r59
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            android.widget.TextView r0 = r1.tvDetail
            r3 = r60
            r0.setVisibility(r3)
        L_0x0676:
            r3 = 13631488(0xd00000, double:6.73485E-317)
            long r3 = r52 & r3
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0686
            android.widget.TextView r0 = r1.tvSettlementDateText
            r3 = r61
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r3)
        L_0x0686:
            if (r8 == 0) goto L_0x068d
            android.widget.TextView r0 = r1.tvTxnId
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r2)
        L_0x068d:
            r2 = 12583040(0xc00080, double:6.216848E-317)
            long r2 = r52 & r2
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x069f
            android.widget.TextView r0 = r1.tvUtrText
            r12 = r62
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x069f:
            com.business.merchant_payments.databinding.MpTransactionDetailSubViewBinding r0 = r1.detailsContainer
            androidx.databinding.ViewDataBinding.executeBindingsOn(r0)
            return
        L_0x06a5:
            r0 = move-exception
            monitor-exit(r63)     // Catch:{ all -> 0x06a5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.databinding.MpTransactionDetailBindingImpl.executeBindings():void");
    }
}
