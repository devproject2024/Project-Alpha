package com.business.merchant_payments.notificationsettings.viewmodel;

import android.text.TextUtils;
import android.widget.CompoundButton;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel;
import com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider;
import com.business.merchant_payments.notificationsettings.repository.NotificationsRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class EmailAndSmsNotificationViewModel extends ai {
    public static final Companion Companion = new Companion((g) null);
    public static final int DETAIL_REMOVED = 2;
    public static final int LAUNCH_SCREEN_TO_ADD_SECONDARY_RECEIVER = 1;
    public static final int NO_INTERNET_REMOVE_RECEIVER = 6;
    public static final int NO_INTERNET_UPDATE_SETTINGS = 5;
    public static final int NO_PERMISSION_ERROR = 8;
    public static final int NO_RECEIVER = 9;
    public static final int ON_BACK_PRESS = 7;
    public static final int OPEN_LOCK_SCREEN_ACTIVITY_ADD_EMAIL = 102;
    public static final int OPEN_LOCK_SCREEN_ACTIVITY_ADD_MOBILE = 100;
    public static final int SHOW_REFUND_DEACTIVATE_DIALOG = 4;
    public static final int SHOW_TRANSACTION_DEACTIVATE_DIALOG = 3;
    public final kotlin.g EVENT$delegate = h.a(EmailAndSmsNotificationViewModel$EVENT$2.INSTANCE);
    public final kotlin.g isMerchantAdmin$delegate = h.a(EmailAndSmsNotificationViewModel$isMerchantAdmin$2.INSTANCE);
    public final kotlin.g isRefundSettingsEnabled$delegate = h.a(EmailAndSmsNotificationViewModel$isRefundSettingsEnabled$2.INSTANCE);
    public boolean isSettingsUpdated;
    public final kotlin.g isShowAddNewButton$delegate = h.a(EmailAndSmsNotificationViewModel$isShowAddNewButton$2.INSTANCE);
    public final kotlin.g isTransactionSettingsEnabled$delegate = h.a(EmailAndSmsNotificationViewModel$isTransactionSettingsEnabled$2.INSTANCE);
    public final int mMaxSecondaryEmail;
    public final kotlin.g mMaxSecondaryNumbers$delegate;
    public final kotlin.g mNotificationResId$delegate;
    public String mNotificationSettingsToUpdate;
    public final kotlin.g mNotificationType$delegate;
    public final kotlin.g mReceiverList$delegate = h.a(EmailAndSmsNotificationViewModel$mReceiverList$2.INSTANCE);
    public final kotlin.g mReceiverMsgId$delegate;
    public int positionToRemove;
    public NotificationReceiverModel receiverToRemove;
    public final kotlin.g removeSecondaryDetailFlag$delegate = h.a(EmailAndSmsNotificationViewModel$removeSecondaryDetailFlag$2.INSTANCE);
    public LiveData<b<MerchantProfileResponse>> removeSecondaryLiveData;
    public final kotlin.g updateNotificationSettingsFlag$delegate = h.a(EmailAndSmsNotificationViewModel$updateNotificationSettingsFlag$2.INSTANCE);
    public LiveData<b<NotificationOnOffDataModel>> updateNotificationSettingsLiveData;

    private final y<Boolean> getRemoveSecondaryDetailFlag() {
        return (y) this.removeSecondaryDetailFlag$delegate.getValue();
    }

    private final y<Boolean> getUpdateNotificationSettingsFlag() {
        return (y) this.updateNotificationSettingsFlag$delegate.getValue();
    }

    public final y<Integer> getEVENT() {
        return (y) this.EVENT$delegate.getValue();
    }

    public final y<Integer> getMMaxSecondaryNumbers() {
        return (y) this.mMaxSecondaryNumbers$delegate.getValue();
    }

    public final y<Integer> getMNotificationResId() {
        return (y) this.mNotificationResId$delegate.getValue();
    }

    public final y<Integer> getMNotificationType() {
        return (y) this.mNotificationType$delegate.getValue();
    }

    public final y<ArrayList<NotificationReceiverModel>> getMReceiverList() {
        return (y) this.mReceiverList$delegate.getValue();
    }

    public final y<Integer> getMReceiverMsgId() {
        return (y) this.mReceiverMsgId$delegate.getValue();
    }

    public final y<Boolean> isMerchantAdmin() {
        return (y) this.isMerchantAdmin$delegate.getValue();
    }

    public final y<Boolean> isRefundSettingsEnabled() {
        return (y) this.isRefundSettingsEnabled$delegate.getValue();
    }

    public final y<Boolean> isShowAddNewButton() {
        return (y) this.isShowAddNewButton$delegate.getValue();
    }

    public final y<Boolean> isTransactionSettingsEnabled() {
        return (y) this.isTransactionSettingsEnabled$delegate.getValue();
    }

    public final void onSettlementsCheckChange(CompoundButton compoundButton, boolean z) {
        k.d(compoundButton, "buttonView");
    }

    public EmailAndSmsNotificationViewModel() {
        LiveData<b<MerchantProfileResponse>> b2 = ah.b(getRemoveSecondaryDetailFlag(), new EmailAndSmsNotificationViewModel$removeSecondaryLiveData$1(this));
        k.b(b2, "Transformations.switchMa…create()\n        }\n\n    }");
        this.removeSecondaryLiveData = b2;
        LiveData<b<NotificationOnOffDataModel>> b3 = ah.b(getUpdateNotificationSettingsFlag(), new EmailAndSmsNotificationViewModel$updateNotificationSettingsLiveData$1(this));
        k.b(b3, "Transformations.switchMa…create()\n        }\n\n    }");
        this.updateNotificationSettingsLiveData = b3;
        this.mNotificationType$delegate = h.a(EmailAndSmsNotificationViewModel$mNotificationType$2.INSTANCE);
        this.mNotificationResId$delegate = h.a(EmailAndSmsNotificationViewModel$mNotificationResId$2.INSTANCE);
        this.mReceiverMsgId$delegate = h.a(EmailAndSmsNotificationViewModel$mReceiverMsgId$2.INSTANCE);
        this.mMaxSecondaryNumbers$delegate = h.a(EmailAndSmsNotificationViewModel$mMaxSecondaryNumbers$2.INSTANCE);
        this.mMaxSecondaryEmail = 1;
        getMMaxSecondaryNumbers().setValue(Integer.valueOf(GTMDataProviderImpl.Companion.getMInstance().getMultipleNumberCount()));
        y<Boolean> isMerchantAdmin = isMerchantAdmin();
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        isMerchantAdmin.setValue(Boolean.valueOf(instance.getMerchantDataProvider().s()));
        this.positionToRemove = -1;
    }

    public final LiveData<b<MerchantProfileResponse>> getRemoveSecondaryLiveData() {
        return this.removeSecondaryLiveData;
    }

    public final void setRemoveSecondaryLiveData(LiveData<b<MerchantProfileResponse>> liveData) {
        k.d(liveData, "<set-?>");
        this.removeSecondaryLiveData = liveData;
    }

    public final LiveData<b<NotificationOnOffDataModel>> getUpdateNotificationSettingsLiveData() {
        return this.updateNotificationSettingsLiveData;
    }

    public final void setUpdateNotificationSettingsLiveData(LiveData<b<NotificationOnOffDataModel>> liveData) {
        k.d(liveData, "<set-?>");
        this.updateNotificationSettingsLiveData = liveData;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final LiveData<b<MerchantProfileResponse>> callInsertUpdateDataAPI() {
        return NotificationsRepository.updateMerchantProfileSecondary(getBody(), getType());
    }

    private final String getBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            NotificationReceiverModel notificationReceiverModel = this.receiverToRemove;
            String str = null;
            Integer valueOf = notificationReceiverModel != null ? Integer.valueOf(notificationReceiverModel.getReceiverType()) : null;
            if (valueOf != null) {
                if (valueOf.intValue() == 1) {
                    jSONObject.put("primaryEmail", "");
                    String jSONObject2 = jSONObject.toString();
                    k.b(jSONObject2, "request.toString()");
                    return jSONObject2;
                }
            }
            if (valueOf != null && valueOf.intValue() == 4) {
                jSONObject.put("secondaryEmail", "");
                String jSONObject22 = jSONObject.toString();
                k.b(jSONObject22, "request.toString()");
                return jSONObject22;
            } else if (valueOf != null && valueOf.intValue() == 2) {
                jSONObject.put("primaryMobile", "");
                String jSONObject222 = jSONObject.toString();
                k.b(jSONObject222, "request.toString()");
                return jSONObject222;
            } else if (valueOf == null || valueOf.intValue() != 3) {
                if (valueOf != null && valueOf.intValue() == 5) {
                    NotificationReceiverModel notificationReceiverModel2 = this.receiverToRemove;
                    if (notificationReceiverModel2 != null) {
                        str = notificationReceiverModel2.getReceiverString();
                    }
                    jSONObject.put(AppConstants.NOTIFICATION_DETAILS.ADDITIONAL_CONTACT, str);
                }
                String jSONObject2222 = jSONObject.toString();
                k.b(jSONObject2222, "request.toString()");
                return jSONObject2222;
            } else {
                jSONObject.put("secondaryPhone", "");
                String jSONObject22222 = jSONObject.toString();
                k.b(jSONObject22222, "request.toString()");
                return jSONObject22222;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final String getType() {
        NotificationReceiverModel notificationReceiverModel = this.receiverToRemove;
        Integer valueOf = notificationReceiverModel != null ? Integer.valueOf(notificationReceiverModel.getReceiverType()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            return "update_primary_email";
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            return "update_secondary_mobile";
        }
        if (valueOf == null || valueOf.intValue() != 4) {
            return (valueOf == null || valueOf.intValue() != 5) ? "" : AppConstants.NOTIFICATION_DETAILS.ADDITIONAL_CONTACT;
        }
        return "update_secondary_email";
    }

    public final void initUiResId(int i2) {
        getMNotificationType().setValue(Integer.valueOf(i2));
        if (i2 == 1) {
            getMNotificationResId().setValue(Integer.valueOf(R.string.mp_email));
        } else if (i2 == 2) {
            getMNotificationResId().setValue(Integer.valueOf(R.string.mp_sms));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        r2 = r5.getTransaction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setNotificationSettings(java.util.ArrayList<com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "notificationSettings"
            kotlin.g.b.k.d(r5, r0)
            androidx.lifecycle.y r0 = r4.getMReceiverList()
            r0.setValue(r5)
            r4.setReceiverMsg()
            com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider r5 = com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider.INSTANCE
            com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel r5 = r5.getNotificationSettings()
            r4.handleAddNewButtonVisibility()
            androidx.lifecycle.y r0 = r4.getMNotificationType()
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            r1 = 0
            if (r0 == 0) goto L_0x0060
            int r2 = r0.intValue()
            r3 = 1
            if (r2 != r3) goto L_0x0060
            androidx.lifecycle.y r0 = r4.isTransactionSettingsEnabled()
            if (r5 == 0) goto L_0x003d
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r2 = r5.getTransaction()
            if (r2 == 0) goto L_0x003d
            boolean r2 = r2.getEmailAllowed()
            goto L_0x003e
        L_0x003d:
            r2 = 0
        L_0x003e:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.setValue(r2)
            androidx.lifecycle.y r0 = r4.isRefundSettingsEnabled()
            if (r5 == 0) goto L_0x0055
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r5 = r5.getRefund()
            if (r5 == 0) goto L_0x0055
            boolean r1 = r5.getEmailAllowed()
        L_0x0055:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r0.setValue(r5)
            r4.sendToggleImpressionGAEvent()
            return
        L_0x0060:
            if (r0 == 0) goto L_0x009c
            int r0 = r0.intValue()
            r2 = 2
            if (r0 != r2) goto L_0x009c
            androidx.lifecycle.y r0 = r4.isTransactionSettingsEnabled()
            if (r5 == 0) goto L_0x007a
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r2 = r5.getTransaction()
            if (r2 == 0) goto L_0x007a
            boolean r2 = r2.getSmsAllowed()
            goto L_0x007b
        L_0x007a:
            r2 = 0
        L_0x007b:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.setValue(r2)
            androidx.lifecycle.y r0 = r4.isRefundSettingsEnabled()
            if (r5 == 0) goto L_0x0092
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r5 = r5.getRefund()
            if (r5 == 0) goto L_0x0092
            boolean r1 = r5.getSmsAllowed()
        L_0x0092:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r0.setValue(r5)
            r4.sendToggleImpressionGAEvent()
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel.setNotificationSettings(java.util.ArrayList):void");
    }

    private final void setReceiverMsg() {
        ArrayList value;
        Integer value2 = getMNotificationType().getValue();
        if (value2 != null && value2.intValue() == 1) {
            ArrayList value3 = getMReceiverList().getValue();
            if (value3 == null) {
                return;
            }
            if (value3.size() > 1) {
                getMReceiverMsgId().setValue(Integer.valueOf(R.string.mp_multiple_email_receiver));
            } else {
                getMReceiverMsgId().setValue(Integer.valueOf(R.string.mp_single_email_receiver));
            }
        } else if (value2 != null && value2.intValue() == 2 && (value = getMReceiverList().getValue()) != null) {
            if (value.size() > 1) {
                getMReceiverMsgId().setValue(Integer.valueOf(R.string.mp_multiple_sms_receiver));
            } else {
                getMReceiverMsgId().setValue(Integer.valueOf(R.string.mp_single_sms_receiver));
            }
        }
    }

    private final void sendToggleImpressionGAEvent() {
        String str = "On";
        sendGAEvent("Refund State Impression", k.a((Object) isRefundSettingsEnabled().getValue(), (Object) Boolean.TRUE) ? str : "Off");
        if (!k.a((Object) isTransactionSettingsEnabled().getValue(), (Object) Boolean.TRUE)) {
            str = "Off";
        }
        sendGAEvent("Payment State Impression", str);
    }

    private final void sendToggleActionGAEvent() {
        String str = "On";
        sendGAEvent("Refund State Toggled", k.a((Object) isRefundSettingsEnabled().getValue(), (Object) Boolean.TRUE) ? str : "Off");
        if (!k.a((Object) isTransactionSettingsEnabled().getValue(), (Object) Boolean.TRUE)) {
            str = "Off";
        }
        sendGAEvent("Payment State Toggled", str);
    }

    private final void handleAddNewButtonVisibility() {
        Boolean bool;
        Integer value = getMNotificationType().getValue();
        boolean z = true;
        if (value != null && value.intValue() == 1) {
            handleAddNewButtonForEmail();
        } else if (value != null && value.intValue() == 2) {
            y<Boolean> isShowAddNewButton = isShowAddNewButton();
            ArrayList value2 = getMReceiverList().getValue();
            if (value2 != null) {
                int size = value2.size();
                Integer value3 = getMMaxSecondaryNumbers().getValue();
                k.a((Object) value3);
                if (size >= value3.intValue() + 1) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            isShowAddNewButton.setValue(bool);
        }
    }

    private final void handleAddNewButtonForEmail() {
        ArrayList value = getMReceiverList().getValue();
        if (value == null) {
            isShowAddNewButton().setValue(Boolean.FALSE);
        } else if (value.isEmpty()) {
            getEVENT().setValue(9);
        } else {
            boolean z = false;
            if (((NotificationReceiverModel) value.get(0)).getReceiverType() != 1) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                if (instance.getMerchantDataProvider().j()) {
                    isShowAddNewButton().setValue(Boolean.TRUE);
                    return;
                }
                y<Boolean> isShowAddNewButton = isShowAddNewButton();
                if (value.size() < this.mMaxSecondaryEmail) {
                    z = true;
                }
                isShowAddNewButton.setValue(Boolean.valueOf(z));
                return;
            }
            y<Boolean> isShowAddNewButton2 = isShowAddNewButton();
            if (value.size() < this.mMaxSecondaryEmail + 1) {
                z = true;
            }
            isShowAddNewButton2.setValue(Boolean.valueOf(z));
        }
    }

    public final void onTransactionCheckChange(CompoundButton compoundButton, boolean z) {
        k.d(compoundButton, "buttonView");
        if (compoundButton.isPressed()) {
            compoundButton.setPressed(false);
            if (!k.a((Object) isMerchantAdmin().getValue(), (Object) Boolean.TRUE)) {
                getEVENT().setValue(8);
                revertSwitchActions();
            } else if (z) {
                updateNotificationSettingsOnServer("transaction", z);
            } else {
                getEVENT().setValue(3);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        r9 = r6.getTransaction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateNotificationSettingsOnServer(java.lang.String r17, boolean r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "event"
            java.lang.String r3 = "refund"
            java.lang.String r4 = "transaction"
            java.lang.String r5 = "type"
            kotlin.g.b.k.d(r0, r5)
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider r6 = com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider.INSTANCE
            com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel r6 = r6.getNotificationSettings()
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            androidx.lifecycle.y r9 = r16.getMNotificationType()     // Catch:{ JSONException -> 0x0119 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ JSONException -> 0x0119 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ JSONException -> 0x0119 }
            r10 = 2141246174(0x7fa0d2de, float:NaN)
            r11 = -934813832(0xffffffffc847df78, float:-204669.88)
            java.lang.String r12 = "emailAllowed"
            java.lang.String r13 = "smsAllowed"
            if (r9 == 0) goto L_0x00a6
            int r15 = r9.intValue()     // Catch:{ JSONException -> 0x0119 }
            r14 = 1
            if (r15 != r14) goto L_0x00a6
            if (r6 == 0) goto L_0x0051
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r9 = r6.getTransaction()     // Catch:{ JSONException -> 0x0119 }
            if (r9 == 0) goto L_0x0051
            boolean r14 = r9.getSmsAllowed()     // Catch:{ JSONException -> 0x0119 }
            goto L_0x0052
        L_0x0051:
            r14 = 0
        L_0x0052:
            r7.put(r13, r14)     // Catch:{ JSONException -> 0x0119 }
            if (r6 == 0) goto L_0x0062
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r9 = r6.getRefund()     // Catch:{ JSONException -> 0x0119 }
            if (r9 == 0) goto L_0x0062
            boolean r14 = r9.getSmsAllowed()     // Catch:{ JSONException -> 0x0119 }
            goto L_0x0063
        L_0x0062:
            r14 = 0
        L_0x0063:
            r8.put(r13, r14)     // Catch:{ JSONException -> 0x0119 }
            int r9 = r17.hashCode()     // Catch:{ JSONException -> 0x0119 }
            if (r9 == r11) goto L_0x008a
            if (r9 != r10) goto L_0x010e
            boolean r0 = r0.equals(r4)     // Catch:{ JSONException -> 0x0119 }
            if (r0 == 0) goto L_0x010e
            r7.put(r12, r1)     // Catch:{ JSONException -> 0x0119 }
            if (r6 == 0) goto L_0x0084
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r0 = r6.getRefund()     // Catch:{ JSONException -> 0x0119 }
            if (r0 == 0) goto L_0x0084
            boolean r14 = r0.getEmailAllowed()     // Catch:{ JSONException -> 0x0119 }
            goto L_0x0085
        L_0x0084:
            r14 = 0
        L_0x0085:
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0119 }
            goto L_0x010e
        L_0x008a:
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0119 }
            if (r0 == 0) goto L_0x010e
            if (r6 == 0) goto L_0x009d
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r0 = r6.getTransaction()     // Catch:{ JSONException -> 0x0119 }
            if (r0 == 0) goto L_0x009d
            boolean r14 = r0.getEmailAllowed()     // Catch:{ JSONException -> 0x0119 }
            goto L_0x009e
        L_0x009d:
            r14 = 0
        L_0x009e:
            r7.put(r12, r14)     // Catch:{ JSONException -> 0x0119 }
            r8.put(r12, r1)     // Catch:{ JSONException -> 0x0119 }
            goto L_0x010e
        L_0x00a6:
            if (r9 == 0) goto L_0x010e
            int r9 = r9.intValue()     // Catch:{ JSONException -> 0x0119 }
            r14 = 2
            if (r9 != r14) goto L_0x010e
            if (r6 == 0) goto L_0x00bc
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r9 = r6.getTransaction()     // Catch:{ JSONException -> 0x0119 }
            if (r9 == 0) goto L_0x00bc
            boolean r14 = r9.getEmailAllowed()     // Catch:{ JSONException -> 0x0119 }
            goto L_0x00bd
        L_0x00bc:
            r14 = 0
        L_0x00bd:
            r7.put(r12, r14)     // Catch:{ JSONException -> 0x0119 }
            if (r6 == 0) goto L_0x00cd
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r9 = r6.getRefund()     // Catch:{ JSONException -> 0x0119 }
            if (r9 == 0) goto L_0x00cd
            boolean r14 = r9.getEmailAllowed()     // Catch:{ JSONException -> 0x0119 }
            goto L_0x00ce
        L_0x00cd:
            r14 = 0
        L_0x00ce:
            r8.put(r12, r14)     // Catch:{ JSONException -> 0x0119 }
            int r9 = r17.hashCode()     // Catch:{ JSONException -> 0x0119 }
            if (r9 == r11) goto L_0x00f4
            if (r9 != r10) goto L_0x010e
            boolean r0 = r0.equals(r4)     // Catch:{ JSONException -> 0x0119 }
            if (r0 == 0) goto L_0x010e
            r7.put(r13, r1)     // Catch:{ JSONException -> 0x0119 }
            if (r6 == 0) goto L_0x00ef
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r0 = r6.getRefund()     // Catch:{ JSONException -> 0x0119 }
            if (r0 == 0) goto L_0x00ef
            boolean r14 = r0.getSmsAllowed()     // Catch:{ JSONException -> 0x0119 }
            goto L_0x00f0
        L_0x00ef:
            r14 = 0
        L_0x00f0:
            r8.put(r13, r14)     // Catch:{ JSONException -> 0x0119 }
            goto L_0x010e
        L_0x00f4:
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0119 }
            if (r0 == 0) goto L_0x010e
            if (r6 == 0) goto L_0x0107
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r0 = r6.getTransaction()     // Catch:{ JSONException -> 0x0119 }
            if (r0 == 0) goto L_0x0107
            boolean r14 = r0.getSmsAllowed()     // Catch:{ JSONException -> 0x0119 }
            goto L_0x0108
        L_0x0107:
            r14 = 0
        L_0x0108:
            r7.put(r13, r14)     // Catch:{ JSONException -> 0x0119 }
            r8.put(r13, r1)     // Catch:{ JSONException -> 0x0119 }
        L_0x010e:
            java.lang.String r0 = "SUCCESS"
            r7.put(r2, r0)     // Catch:{ JSONException -> 0x0119 }
            java.lang.String r0 = "BOTH"
            r8.put(r2, r0)     // Catch:{ JSONException -> 0x0119 }
            goto L_0x011d
        L_0x0119:
            r0 = move-exception
            r0.printStackTrace()
        L_0x011d:
            r5.put(r4, r7)
            r5.put(r3, r8)
            java.lang.String r0 = r5.toString()
            r1 = r16
            r1.mNotificationSettingsToUpdate = r0
            r16.updateNotificationSettingsTryAgain()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel.updateNotificationSettingsOnServer(java.lang.String, boolean):void");
    }

    public final void onRefundsCheckChange(CompoundButton compoundButton, boolean z) {
        k.d(compoundButton, "buttonView");
        if (compoundButton.isPressed()) {
            compoundButton.setPressed(false);
            if (!k.a((Object) isMerchantAdmin().getValue(), (Object) Boolean.TRUE)) {
                getEVENT().setValue(8);
                revertSwitchActions();
            } else if (z) {
                updateNotificationSettingsOnServer("refund", z);
            } else {
                getEVENT().setValue(4);
            }
        }
    }

    public final void updateNotificationSettingsTryAgain() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (i.a(instance.getApplication())) {
            getUpdateNotificationSettingsFlag().setValue(Boolean.TRUE);
            return;
        }
        getEVENT().setValue(5);
        revertSwitchActions();
    }

    public final void addReceiver() {
        getEVENT().setValue(1);
        sendGAEvent("Add Button Clicked", "Addition Started");
    }

    public final void sendGAEvent(String str, String str2) {
        k.d(str, "eventAction");
        k.d(str2, "eventLabel");
        GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        singleInstance.sendEvent(instance.getAppContext(), getGAEventCategory(), str, "", str2);
    }

    public final String getGAEventCategory() {
        Integer value = getMNotificationType().getValue();
        if (value == null || value.intValue() != 2) {
            return (value == null || value.intValue() != 1) ? "" : "Email Alert Page";
        }
        return "SMS Alert Page";
    }

    public final void removeSecondaryReceiver(NotificationReceiverModel notificationReceiverModel, int i2) {
        k.d(notificationReceiverModel, "receiver");
        this.receiverToRemove = notificationReceiverModel;
        this.positionToRemove = i2;
        removeSecondaryReceiver();
        StringBuilder sb = new StringBuilder();
        sb.append(i2 + 1);
        sb.append(';');
        ArrayList value = getMReceiverList().getValue();
        sb.append(value != null ? Integer.valueOf(value.size()) : null);
        sendGAEvent("Remove Button Clicked", sb.toString());
    }

    public final void removeSecondaryReceiver() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (i.a(instance.getApplication())) {
            getRemoveSecondaryDetailFlag().setValue(Boolean.TRUE);
        } else {
            getEVENT().setValue(6);
        }
    }

    public final int getRequestCode() {
        Integer value = getMNotificationType().getValue();
        if (value == null || value.intValue() != 1) {
            return (value == null || value.intValue() != 2) ? -1 : 100;
        }
        return 102;
    }

    public final Map<String, String> getSecondaryNumbersIntentData() {
        NotificationReceiverModel notificationReceiverModel;
        NotificationReceiverModel notificationReceiverModel2;
        Object obj;
        boolean z;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList value = getMReceiverList().getValue();
        String str = null;
        if (value != null) {
            Iterator it2 = value.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((NotificationReceiverModel) obj).getReceiverType() == 3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            notificationReceiverModel = (NotificationReceiverModel) obj;
        } else {
            notificationReceiverModel = null;
        }
        if (notificationReceiverModel == null) {
            linkedHashMap.put("type", "update_secondary_mobile");
        } else {
            linkedHashMap.put("type", AppConstants.NOTIFICATION_DETAILS.ADD_ADDITIONAL_CONTACT);
        }
        linkedHashMap.put(AppConstants.MULTIPLE_NUMBERS, getSecondaryNumbers());
        if (getMReceiverList().getValue() != null) {
            ArrayList<NotificationReceiverModel> value2 = getMReceiverList().getValue();
            k.a((Object) value2);
            if (value2.size() > 0) {
                ArrayList value3 = getMReceiverList().getValue();
                if (!(value3 == null || (notificationReceiverModel2 = (NotificationReceiverModel) value3.get(0)) == null)) {
                    str = notificationReceiverModel2.getReceiverString();
                }
                if (!TextUtils.isEmpty(str)) {
                    ArrayList<NotificationReceiverModel> value4 = getMReceiverList().getValue();
                    k.a((Object) value4);
                    linkedHashMap.put(AppConstants.NOTIFICATION_DETAILS.PRIMARY_MOBILE, ((NotificationReceiverModel) value4.get(0)).getReceiverString());
                }
            }
        }
        return linkedHashMap;
    }

    private final String getSecondaryNumbers() {
        StringBuilder sb = new StringBuilder();
        if (getMReceiverList().getValue() != null) {
            ArrayList<NotificationReceiverModel> value = getMReceiverList().getValue();
            k.a((Object) value);
            if (value.size() > 1) {
                ArrayList<NotificationReceiverModel> value2 = getMReceiverList().getValue();
                k.a((Object) value2);
                int size = value2.size();
                for (int i2 = 1; i2 < size; i2++) {
                    ArrayList<NotificationReceiverModel> value3 = getMReceiverList().getValue();
                    k.a((Object) value3);
                    String receiverString = ((NotificationReceiverModel) value3.get(i2)).getReceiverString();
                    if (i2 != 0) {
                        receiverString = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA.concat(String.valueOf(receiverString));
                    }
                    sb.append(receiverString);
                }
            }
        }
        String sb2 = sb.toString();
        k.b(sb2, "con.toString()");
        return sb2;
    }

    public final String getAddedEmail() {
        NotificationReceiverModel notificationReceiverModel;
        ArrayList value = getMReceiverList().getValue();
        if (value == null || (notificationReceiverModel = (NotificationReceiverModel) value.get(0)) == null) {
            return null;
        }
        return notificationReceiverModel.getReceiverString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = (com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel) r0.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isPrimaryEmailAdded() {
        /*
            r3 = this;
            androidx.lifecycle.y r0 = r3.getMReceiverList()
            java.lang.Object r0 = r0.getValue()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r1 = 0
            if (r0 == 0) goto L_0x001d
            java.lang.Object r0 = r0.get(r1)
            com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel r0 = (com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel) r0
            if (r0 == 0) goto L_0x001d
            int r0 = r0.getReceiverType()
            r2 = 1
            if (r0 != r2) goto L_0x001d
            return r2
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel.isPrimaryEmailAdded():boolean");
    }

    public final void addReceiver(String str, int i2) {
        k.d(str, "secondaryReceiver");
        this.isSettingsUpdated = true;
        if (i2 == 1) {
            if (getMReceiverList().getValue() != null) {
                ArrayList<NotificationReceiverModel> value = getMReceiverList().getValue();
                k.a((Object) value);
                if (value.size() > 0) {
                    ArrayList<NotificationReceiverModel> value2 = getMReceiverList().getValue();
                    k.a((Object) value2);
                    value2.add(0, new NotificationReceiverModel(str, i2));
                }
            }
            getMReceiverList().setValue(kotlin.a.k.d(new NotificationReceiverModel(str, i2)));
        } else {
            ArrayList value3 = getMReceiverList().getValue();
            if (value3 != null) {
                value3.add(new NotificationReceiverModel(str, i2));
            } else {
                getMReceiverList().setValue(kotlin.a.k.d(new NotificationReceiverModel(str, i2)));
            }
        }
        setReceiverMsg();
        sendGAEvent("Add Button Clicked", "Addition Completed");
        handleAddNewButtonVisibility();
    }

    public final void updateReceiverRemovalDetails(b<MerchantProfileResponse> bVar) {
        NotificationReceiverModel notificationReceiverModel;
        ArrayList value;
        k.d(bVar, Payload.RESPONSE);
        MerchantProfileResponse merchantProfileResponse = (MerchantProfileResponse) bVar.f7358c;
        Integer num = null;
        String status = merchantProfileResponse != null ? merchantProfileResponse.getStatus() : null;
        if (status != null && status.hashCode() == -1149187101 && status.equals("SUCCESS")) {
            NotificationReceiverModel notificationReceiverModel2 = this.receiverToRemove;
            if (notificationReceiverModel2 != null) {
                num = Integer.valueOf(notificationReceiverModel2.getReceiverType());
            }
            if (((num != null && num.intValue() == 4) || ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 5))) && (notificationReceiverModel = this.receiverToRemove) != null) {
                this.isSettingsUpdated = true;
                ArrayList value2 = getMReceiverList().getValue();
                if (!(value2 == null || !value2.contains(notificationReceiverModel) || (value = getMReceiverList().getValue()) == null)) {
                    value.remove(notificationReceiverModel);
                }
                setReceiverMsg();
                getEVENT().setValue(2);
                handleAddNewButtonVisibility();
            }
        }
    }

    public final void resetReceiverInfo() {
        this.receiverToRemove = null;
        this.positionToRemove = -1;
    }

    public final int getRemovedPosition() {
        return this.positionToRemove;
    }

    public final void updateNotificationSettingsOnResponse(NotificationOnOffDataModel notificationOnOffDataModel) {
        k.d(notificationOnOffDataModel, "settingsModel");
        NotificationSettingsDataProvider.INSTANCE.setNotificationSettings(notificationOnOffDataModel);
        this.isSettingsUpdated = true;
        Integer value = getMNotificationType().getValue();
        if (value != null && value.intValue() == 1) {
            isTransactionSettingsEnabled().setValue(Boolean.valueOf(notificationOnOffDataModel.getTransaction().getEmailAllowed()));
            isRefundSettingsEnabled().setValue(Boolean.valueOf(notificationOnOffDataModel.getRefund().getEmailAllowed()));
            sendToggleActionGAEvent();
        } else if (value != null && value.intValue() == 2) {
            isTransactionSettingsEnabled().setValue(Boolean.valueOf(notificationOnOffDataModel.getTransaction().getSmsAllowed()));
            isRefundSettingsEnabled().setValue(Boolean.valueOf(notificationOnOffDataModel.getRefund().getSmsAllowed()));
            sendToggleActionGAEvent();
        }
    }

    public final boolean isNotificationSettingsUpdated() {
        return this.isSettingsUpdated;
    }

    public final ArrayList<NotificationReceiverModel> getUpdatedSettings() {
        if (getMReceiverList().getValue() != null) {
            return getMReceiverList().getValue();
        }
        return null;
    }

    public final void onBackButtonPress() {
        getEVENT().setValue(7);
    }

    public final void revertSwitchOffAction(String str) {
        k.d(str, "notificationType");
        int hashCode = str.hashCode();
        if (hashCode != -934813832) {
            if (hashCode == 2141246174 && str.equals("transaction")) {
                isTransactionSettingsEnabled().setValue(Boolean.TRUE);
            }
        } else if (str.equals("refund")) {
            isRefundSettingsEnabled().setValue(Boolean.TRUE);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r3 = r0.getTransaction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void revertSwitchActions() {
        /*
            r5 = this;
            com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider r0 = com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider.INSTANCE
            com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel r0 = r0.getNotificationSettings()
            androidx.lifecycle.y r1 = r5.getMNotificationType()
            java.lang.Object r1 = r1.getValue()
            java.lang.Integer r1 = (java.lang.Integer) r1
            r2 = 0
            if (r1 == 0) goto L_0x004b
            int r3 = r1.intValue()
            r4 = 1
            if (r3 != r4) goto L_0x004b
            androidx.lifecycle.y r1 = r5.isTransactionSettingsEnabled()
            if (r0 == 0) goto L_0x002b
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r3 = r0.getTransaction()
            if (r3 == 0) goto L_0x002b
            boolean r3 = r3.getEmailAllowed()
            goto L_0x002c
        L_0x002b:
            r3 = 0
        L_0x002c:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r1.setValue(r3)
            androidx.lifecycle.y r1 = r5.isRefundSettingsEnabled()
            if (r0 == 0) goto L_0x0043
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r0 = r0.getRefund()
            if (r0 == 0) goto L_0x0043
            boolean r2 = r0.getEmailAllowed()
        L_0x0043:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r1.setValue(r0)
            return
        L_0x004b:
            if (r1 == 0) goto L_0x0084
            int r1 = r1.intValue()
            r3 = 2
            if (r1 != r3) goto L_0x0084
            androidx.lifecycle.y r1 = r5.isTransactionSettingsEnabled()
            if (r0 == 0) goto L_0x0065
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r3 = r0.getTransaction()
            if (r3 == 0) goto L_0x0065
            boolean r3 = r3.getSmsAllowed()
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r1.setValue(r3)
            androidx.lifecycle.y r1 = r5.isRefundSettingsEnabled()
            if (r0 == 0) goto L_0x007d
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r0 = r0.getRefund()
            if (r0 == 0) goto L_0x007d
            boolean r2 = r0.getSmsAllowed()
        L_0x007d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r1.setValue(r0)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel.revertSwitchActions():void");
    }
}
