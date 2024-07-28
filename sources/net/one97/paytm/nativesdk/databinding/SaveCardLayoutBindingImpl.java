package net.one97.paytm.nativesdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.i;
import net.one97.paytm.nativesdk.BR;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.SaveDebitCreditCardModel;

public class SaveCardLayoutBindingImpl extends SaveCardLayoutBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cvv_layout, 5);
        sViewsWithIds.put(R.id.etCvv, 6);
        sViewsWithIds.put(R.id.two_mode_auth_layout, 7);
        sViewsWithIds.put(R.id.rb_saved_card_atm_pin, 8);
        sViewsWithIds.put(R.id.rb_saved_card_otp, 9);
        sViewsWithIds.put(R.id.txtAtmPinText, 10);
        sViewsWithIds.put(R.id.txtOtpText, 11);
        sViewsWithIds.put(R.id.txtamount, 12);
        sViewsWithIds.put(R.id.iv_saved_card, 13);
        sViewsWithIds.put(R.id.emi_details_layout, 14);
        sViewsWithIds.put(R.id.imgEmiCross, 15);
        sViewsWithIds.put(R.id.txt_emi_details, 16);
        sViewsWithIds.put(R.id.tv_total_amount, 17);
        sViewsWithIds.put(R.id.tv_change_plan, 18);
        sViewsWithIds.put(R.id.btnProceed, 19);
        sViewsWithIds.put(R.id.paysecurely, 20);
        sViewsWithIds.put(R.id.ltv_loading, 21);
        sViewsWithIds.put(R.id.tv_offerText, 22);
        sViewsWithIds.put(R.id.txtErrMsg, 23);
        sViewsWithIds.put(R.id.tv_promo_message, 24);
    }

    public SaveCardLayoutBindingImpl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 25, sIncludes, sViewsWithIds));
    }

    private SaveCardLayoutBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 5, objArr[19], objArr[5], objArr[14], objArr[6], objArr[15], objArr[13], objArr[21], objArr[20], objArr[1], objArr[8], objArr[9], objArr[3], objArr[2], objArr[18], objArr[4], objArr[22], objArr[24], objArr[17], objArr[7], objArr[10], objArr[16], objArr[23], objArr[11], objArr[12]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.rbCardNumber.setTag((Object) null);
        this.textViewLowSuccess.setTag((Object) null);
        this.tvBankName.setTag((Object) null);
        this.tvEmiAvailbale.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        if (BR.saveCardModel == i2) {
            setSaveCardModel((SaveDebitCreditCardModel) obj);
        } else if (BR.view != i2) {
            return false;
        } else {
            setView((View) obj);
        }
        return true;
    }

    public void setSaveCardModel(SaveDebitCreditCardModel saveDebitCreditCardModel) {
        this.mSaveCardModel = saveDebitCreditCardModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.saveCardModel);
        super.requestRebind();
    }

    public void setView(View view) {
        this.mView = view;
    }

    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return onChangeSaveCardModelCardSelected((ObservableBoolean) obj, i3);
        }
        if (i2 == 1) {
            return onChangeSaveCardModelBankName((i) obj, i3);
        }
        if (i2 == 2) {
            return onChangeSaveCardModelCardNumber((i) obj, i3);
        }
        if (i2 == 3) {
            return onChangeSaveCardModelEmiOptionAvailableVisibility((ObservableInt) obj, i3);
        }
        if (i2 != 4) {
            return false;
        }
        return onChangeSaveCardModelLowSuccess((ObservableInt) obj, i3);
    }

    private boolean onChangeSaveCardModelCardSelected(ObservableBoolean observableBoolean, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSaveCardModelBankName(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSaveCardModelCardNumber(i<String> iVar, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSaveCardModelEmiOptionAvailableVisibility(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSaveCardModelLowSuccess(ObservableInt observableInt, int i2) {
        if (i2 != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00dc }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00dc }
            monitor-exit(r24)     // Catch:{ all -> 0x00dc }
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.SaveDebitCreditCardModel r0 = r1.mSaveCardModel
            r6 = 191(0xbf, double:9.44E-322)
            long r6 = r6 & r2
            r8 = 168(0xa8, double:8.3E-322)
            r10 = 164(0xa4, double:8.1E-322)
            r14 = 162(0xa2, double:8.0E-322)
            r16 = 161(0xa1, double:7.95E-322)
            r12 = 0
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x009d
            long r6 = r2 & r16
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x0027
            androidx.databinding.ObservableBoolean r6 = r0.cardSelected
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            r1.updateRegistration((int) r12, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0032
            boolean r6 = r6.get()
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            long r18 = r2 & r14
            int r7 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x004c
            if (r0 == 0) goto L_0x003e
            androidx.databinding.i<java.lang.String> r7 = r0.bankName
            goto L_0x003f
        L_0x003e:
            r7 = 0
        L_0x003f:
            r12 = 1
            r1.updateRegistration((int) r12, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x004c
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x004d
        L_0x004c:
            r7 = 0
        L_0x004d:
            long r19 = r2 & r10
            int r12 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0067
            if (r0 == 0) goto L_0x0058
            androidx.databinding.i<java.lang.String> r12 = r0.cardNumber
            goto L_0x0059
        L_0x0058:
            r12 = 0
        L_0x0059:
            r13 = 2
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0067
            java.lang.Object r12 = r12.get()
            r13 = r12
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0068
        L_0x0067:
            r13 = 0
        L_0x0068:
            long r20 = r2 & r8
            int r12 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0081
            if (r0 == 0) goto L_0x0073
            androidx.databinding.ObservableInt r12 = r0.emiOptionAvailableVisibility
            goto L_0x0074
        L_0x0073:
            r12 = 0
        L_0x0074:
            r8 = 3
            r1.updateRegistration((int) r8, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x0081
            int r12 = r12.get()
            r8 = 176(0xb0, double:8.7E-322)
            goto L_0x0084
        L_0x0081:
            r8 = 176(0xb0, double:8.7E-322)
            r12 = 0
        L_0x0084:
            long r22 = r2 & r8
            int r8 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x009b
            if (r0 == 0) goto L_0x008f
            androidx.databinding.ObservableInt r0 = r0.lowSuccess
            goto L_0x0090
        L_0x008f:
            r0 = 0
        L_0x0090:
            r8 = 4
            r1.updateRegistration((int) r8, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x009b
            int r0 = r0.get()
            goto L_0x00a2
        L_0x009b:
            r0 = 0
            goto L_0x00a2
        L_0x009d:
            r0 = 0
            r6 = 0
            r7 = 0
            r12 = 0
            r13 = 0
        L_0x00a2:
            long r8 = r2 & r16
            int r16 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00ad
            android.widget.RadioButton r8 = r1.rbCardNumber
            androidx.databinding.a.a.a(r8, r6)
        L_0x00ad:
            long r8 = r2 & r14
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00b8
            android.widget.RadioButton r6 = r1.rbCardNumber
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r7)
        L_0x00b8:
            r6 = 176(0xb0, double:8.7E-322)
            long r6 = r6 & r2
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00c4
            android.widget.TextView r6 = r1.textViewLowSuccess
            r6.setVisibility(r0)
        L_0x00c4:
            long r6 = r2 & r10
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00cf
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvBankName
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x00cf:
            r6 = 168(0xa8, double:8.3E-322)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00db
            net.one97.paytm.nativesdk.widget.RoboTextView r0 = r1.tvEmiAvailbale
            r0.setVisibility(r12)
        L_0x00db:
            return
        L_0x00dc:
            r0 = move-exception
            monitor-exit(r24)     // Catch:{ all -> 0x00dc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.databinding.SaveCardLayoutBindingImpl.executeBindings():void");
    }
}
