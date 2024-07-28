package com.business.merchant_payments.notificationsettings.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse;
import com.business.merchant_payments.notificationsettings.repository.NotificationsRepository;

public class AddMobileViewModel extends a {
    public final y<Boolean> apiFlag = new y<>();
    public Context appContext = PaymentsConfig.getInstance().getAppContext();
    public i<String> mInput = new i<>();
    public i<String> mInputError = new i<>();
    public i<String> mInputHint = new i<>();
    public ObservableInt mInputMaxLength = new ObservableInt();
    public ObservableInt mInputType = new ObservableInt();
    public i<String> mSubTitle = new i<>();
    public i<String> mTitle = new i<>();
    public String mType;
    public String otp = "";
    public LiveData<b<MerchantProfileResponse>> responseLiveData = ah.b(this.apiFlag, new androidx.arch.core.c.a() {
        public final Object apply(Object obj) {
            return AddMobileViewModel.this.lambda$new$0$AddMobileViewModel((Boolean) obj);
        }
    });
    public String state = "";

    public AddMobileViewModel(Application application) {
        super(application);
    }

    public /* synthetic */ LiveData lambda$new$0$AddMobileViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return callInsertUpdateDataAPI();
        }
        return new com.business.common_module.utilities.a.a();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setType(java.lang.String r6) {
        /*
            r5 = this;
            r5.mType = r6
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 1
            r4 = 2
            switch(r0) {
                case -1917971045: goto L_0x0038;
                case -1606931927: goto L_0x002d;
                case -908748295: goto L_0x0023;
                case 903349891: goto L_0x0018;
                case 1141917145: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0043
        L_0x000e:
            java.lang.String r0 = "mobile_edit_qr"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0043
            r6 = 4
            goto L_0x0044
        L_0x0018:
            java.lang.String r0 = "update_secondary_mobile"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0043
            r6 = 3
            goto L_0x0044
        L_0x0023:
            java.lang.String r0 = "additionalContact"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0043
            r6 = 2
            goto L_0x0044
        L_0x002d:
            java.lang.String r0 = "update_primary_email"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0043
            r6 = 1
            goto L_0x0044
        L_0x0038:
            java.lang.String r0 = "update_secondary_email"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0043
            r6 = 0
            goto L_0x0044
        L_0x0043:
            r6 = -1
        L_0x0044:
            if (r6 == 0) goto L_0x0085
            if (r6 == r3) goto L_0x0085
            if (r6 == r4) goto L_0x004f
            if (r6 == r2) goto L_0x004f
            if (r6 == r1) goto L_0x004f
            return
        L_0x004f:
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            android.content.Context r0 = r5.appContext
            int r1 = com.business.merchant_payments.R.string.mp_sms_notification
            java.lang.String r0 = r0.getString(r1)
            r6.set(r0)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r0 = r5.appContext
            int r1 = com.business.merchant_payments.R.string.mp_generate_qr_mobile_bottom_line
            java.lang.String r0 = r0.getString(r1)
            r6.set(r0)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r0 = r5.appContext
            int r1 = com.business.merchant_payments.R.string.mp_mobile_number_txt
            java.lang.String r0 = r0.getString(r1)
            r6.set(r0)
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r0 = 10
            r6.set(r0)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r6.<init>((int) r4)
            r5.mInputType = r6
            return
        L_0x0085:
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            android.content.Context r0 = r5.appContext
            int r1 = com.business.merchant_payments.R.string.mp_email_notification
            java.lang.String r0 = r0.getString(r1)
            r6.set(r0)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r0 = r5.appContext
            int r1 = com.business.merchant_payments.R.string.mp_email_notification_desc
            java.lang.String r0 = r0.getString(r1)
            r6.set(r0)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r0 = r5.appContext
            int r1 = com.business.merchant_payments.R.string.mp_label_email
            java.lang.String r0 = r0.getString(r1)
            r6.set(r0)
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r0 = 254(0xfe, float:3.56E-43)
            r6.set(r0)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r0 = 32
            r6.<init>((int) r0)
            r5.mInputType = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.viewmodel.AddMobileViewModel.setType(java.lang.String):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValid() {
        /*
            r9 = this;
            androidx.databinding.i<java.lang.String> r0 = r9.mInput
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = r9.mType
            int r2 = r1.hashCode()
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r2) {
                case -1917971045: goto L_0x004d;
                case -1606931927: goto L_0x0042;
                case -908748295: goto L_0x0038;
                case 903349891: goto L_0x002d;
                case 1141917145: goto L_0x0023;
                case 1955627957: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0058
        L_0x0018:
            java.lang.String r2 = "update_primary_mobile"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0058
            r1 = 2
            goto L_0x0059
        L_0x0023:
            java.lang.String r2 = "mobile_edit_qr"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0058
            r1 = 5
            goto L_0x0059
        L_0x002d:
            java.lang.String r2 = "update_secondary_mobile"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0058
            r1 = 3
            goto L_0x0059
        L_0x0038:
            java.lang.String r2 = "additionalContact"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0058
            r1 = 4
            goto L_0x0059
        L_0x0042:
            java.lang.String r2 = "update_primary_email"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0058
            r1 = 0
            goto L_0x0059
        L_0x004d:
            java.lang.String r2 = "update_secondary_email"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0058
            r1 = 1
            goto L_0x0059
        L_0x0058:
            r1 = -1
        L_0x0059:
            if (r1 == 0) goto L_0x0075
            if (r1 == r8) goto L_0x0075
            if (r1 == r7) goto L_0x0066
            if (r1 == r6) goto L_0x0066
            if (r1 == r5) goto L_0x0066
            if (r1 == r4) goto L_0x0066
            goto L_0x0084
        L_0x0066:
            boolean r0 = com.paytm.utility.p.d(r0)
            if (r0 != 0) goto L_0x0084
            android.content.Context r0 = r9.appContext
            int r1 = com.business.merchant_payments.R.string.mp_msg_sign_in_invalid_phone
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0086
        L_0x0075:
            boolean r0 = com.paytm.utility.p.c(r0)
            if (r0 != 0) goto L_0x0084
            android.content.Context r0 = r9.appContext
            int r1 = com.business.merchant_payments.R.string.mp_msg_sign_in_invalid_email
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0086
        L_0x0084:
            java.lang.String r0 = ""
        L_0x0086:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0092
            androidx.databinding.i<java.lang.String> r1 = r9.mInputError
            r1.set(r0)
            return r3
        L_0x0092:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.viewmodel.AddMobileViewModel.isValid():boolean");
    }

    public void afterInputChanged(Editable editable) {
        this.mInputError.set("");
    }

    private LiveData<b<MerchantProfileResponse>> callInsertUpdateDataAPI() {
        return NotificationsRepository.updateMerchantProfileSecondary(getBody(), this.mType);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getBody() {
        /*
            r9 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = r9.mType     // Catch:{ JSONException -> 0x00b1 }
            r2 = -1
            int r3 = r1.hashCode()     // Catch:{ JSONException -> 0x00b1 }
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            java.lang.String r8 = "additionalContact"
            switch(r3) {
                case -1917971045: goto L_0x003f;
                case -1606931927: goto L_0x0034;
                case -908748295: goto L_0x002c;
                case 903349891: goto L_0x0021;
                case 1955627957: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0049
        L_0x0016:
            java.lang.String r3 = "update_primary_mobile"
            boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x00b1 }
            if (r1 == 0) goto L_0x0049
            r2 = 2
            goto L_0x0049
        L_0x0021:
            java.lang.String r3 = "update_secondary_mobile"
            boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x00b1 }
            if (r1 == 0) goto L_0x0049
            r2 = 3
            goto L_0x0049
        L_0x002c:
            boolean r1 = r1.equals(r8)     // Catch:{ JSONException -> 0x00b1 }
            if (r1 == 0) goto L_0x0049
            r2 = 4
            goto L_0x0049
        L_0x0034:
            java.lang.String r3 = "update_primary_email"
            boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x00b1 }
            if (r1 == 0) goto L_0x0049
            r2 = 0
            goto L_0x0049
        L_0x003f:
            java.lang.String r3 = "update_secondary_email"
            boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x00b1 }
            if (r1 == 0) goto L_0x0049
            r2 = 1
        L_0x0049:
            if (r2 == 0) goto L_0x00a5
            if (r2 == r7) goto L_0x0099
            java.lang.String r1 = "state"
            java.lang.String r3 = "otp"
            if (r2 == r6) goto L_0x0083
            if (r2 == r5) goto L_0x006d
            if (r2 == r4) goto L_0x0059
            goto L_0x00b5
        L_0x0059:
            androidx.databinding.i<java.lang.String> r2 = r9.mInput     // Catch:{ JSONException -> 0x00b1 }
            java.lang.Object r2 = r2.get()     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r8, r2)     // Catch:{ JSONException -> 0x00b1 }
            java.lang.String r2 = r9.otp     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x00b1 }
            java.lang.String r2 = r9.state     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00b1 }
            goto L_0x00b5
        L_0x006d:
            java.lang.String r2 = "secondaryPhone"
            androidx.databinding.i<java.lang.String> r4 = r9.mInput     // Catch:{ JSONException -> 0x00b1 }
            java.lang.Object r4 = r4.get()     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x00b1 }
            java.lang.String r2 = r9.otp     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x00b1 }
            java.lang.String r2 = r9.state     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00b1 }
            goto L_0x00b5
        L_0x0083:
            java.lang.String r2 = "primaryMobile"
            androidx.databinding.i<java.lang.String> r4 = r9.mInput     // Catch:{ JSONException -> 0x00b1 }
            java.lang.Object r4 = r4.get()     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x00b1 }
            java.lang.String r2 = r9.otp     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x00b1 }
            java.lang.String r2 = r9.state     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00b1 }
            goto L_0x00b5
        L_0x0099:
            java.lang.String r1 = "secondaryEmail"
            androidx.databinding.i<java.lang.String> r2 = r9.mInput     // Catch:{ JSONException -> 0x00b1 }
            java.lang.Object r2 = r2.get()     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00b1 }
            goto L_0x00b5
        L_0x00a5:
            java.lang.String r1 = "primaryEmail"
            androidx.databinding.i<java.lang.String> r2 = r9.mInput     // Catch:{ JSONException -> 0x00b1 }
            java.lang.Object r2 = r2.get()     // Catch:{ JSONException -> 0x00b1 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00b5:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.viewmodel.AddMobileViewModel.getBody():java.lang.String");
    }

    public String getmInput() {
        return this.mInput.get();
    }

    public boolean isDuplicate(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(getmInput())) {
            return false;
        }
        if (AppConstants.NOTIFICATION_DETAILS.ADD_ADDITIONAL_CONTACT.equalsIgnoreCase(this.mType) || "update_secondary_mobile".equalsIgnoreCase(this.mType) || "update_primary_mobile".equalsIgnoreCase(this.mType)) {
            str2 = this.appContext.getString(R.string.mp_mobile_number_already_added);
        } else {
            str2 = "";
        }
        if ("update_secondary_email".equalsIgnoreCase(this.mType) || "update_primary_email".equalsIgnoreCase(this.mType)) {
            str2 = this.appContext.getString(R.string.mp_email_already_added);
        }
        this.mInputError.set(str2);
        return true;
    }

    public void updateOTPValues(String str, String str2) {
        this.otp = str;
        this.state = str2;
    }
}
