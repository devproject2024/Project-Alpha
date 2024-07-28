package net.one97.paytm.recharge.model.v4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRGroupDisplay;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse;

public abstract class CJRInstruct {
    private CJRInstruct() {
    }

    public /* synthetic */ CJRInstruct(g gVar) {
        this();
    }

    public static final class startOperatorListActivity extends CJRInstruct {
        private final String listType;
        private final String title;

        public startOperatorListActivity(String str, String str2) {
            super((g) null);
            this.title = str;
            this.listType = str2;
        }

        public final String getListType() {
            return this.listType;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    public static final class startLocationActivity extends CJRInstruct {
        private final String groupName;
        private final String listType;
        private final String searchHintView;
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public startLocationActivity(String str, String str2, String str3, String str4) {
            super((g) null);
            k.c(str4, "groupName");
            this.title = str;
            this.listType = str2;
            this.searchHintView = str3;
            this.groupName = str4;
        }

        public final String getGroupName() {
            return this.groupName;
        }

        public final String getListType() {
            return this.listType;
        }

        public final String getSearchHintView() {
            return this.searchHintView;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    public static final class removeBbpsLogo extends CJRInstruct {
        private final String groupName;

        public removeBbpsLogo(String str) {
            super((g) null);
            this.groupName = str;
        }

        public final String getGroupName() {
            return this.groupName;
        }
    }

    public static final class addBBPSLogo extends CJRInstruct {
        private final String bbpsLogoUrl;

        public addBBPSLogo(String str) {
            super((g) null);
            this.bbpsLogoUrl = str;
        }

        public final String getBbpsLogoUrl() {
            return this.bbpsLogoUrl;
        }
    }

    public static final class getLocalLocation extends CJRInstruct {
        private final int groupLevel;
        private final String groupName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public getLocalLocation(int i2, String str) {
            super((g) null);
            k.c(str, "groupName");
            this.groupLevel = i2;
            this.groupName = str;
        }

        public final int getGroupLevel() {
            return this.groupLevel;
        }

        public final String getGroupName() {
            return this.groupName;
        }
    }

    public static final class setText extends CJRInstruct {
        private final int groupLevel;
        private final String groupName;
        private final String text;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public setText(int i2, String str, String str2) {
            super((g) null);
            k.c(str, "groupName");
            k.c(str2, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            this.groupLevel = i2;
            this.groupName = str;
            this.text = str2;
        }

        public final int getGroupLevel() {
            return this.groupLevel;
        }

        public final String getGroupName() {
            return this.groupName;
        }

        public final String getText() {
            return this.text;
        }
    }

    public static final class removeExtraFilteredGroup extends CJRInstruct {
        private final int groupLevel;
        private final String groupName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public removeExtraFilteredGroup(int i2, String str) {
            super((g) null);
            k.c(str, "groupName");
            this.groupLevel = i2;
            this.groupName = str;
        }

        public final int getGroupLevel() {
            return this.groupLevel;
        }

        public final String getGroupName() {
            return this.groupName;
        }
    }

    public static final class removeAllInputFields extends CJRInstruct {
        public removeAllInputFields() {
            super((g) null);
        }
    }

    public static final class resetUI extends CJRInstruct {
        public resetUI() {
            super((g) null);
        }
    }

    public static final class clearProduct extends CJRInstruct {
        public clearProduct() {
            super((g) null);
        }
    }

    public static final class updateSelectedItem extends CJRInstruct {
        private final int groupLevel;
        private final String groupName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public updateSelectedItem(int i2, String str) {
            super((g) null);
            k.c(str, "groupName");
            this.groupLevel = i2;
            this.groupName = str;
        }

        public final int getGroupLevel() {
            return this.groupLevel;
        }

        public final String getGroupName() {
            return this.groupName;
        }
    }

    public static final class showAlertDialog extends CJRInstruct {
        private final ErrorAction action;
        private final String actionButtonLabel;
        private final Boolean errorInfoDialog;
        private final Object hawkEyeEvent;
        private final String message;
        private final String title;

        public final String getActionButtonLabel() {
            return this.actionButtonLabel;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTitle() {
            return this.title;
        }

        public showAlertDialog(String str, String str2, String str3, ErrorAction errorAction, Boolean bool, Object obj) {
            super((g) null);
            this.title = str;
            this.message = str2;
            this.actionButtonLabel = str3;
            this.action = errorAction;
            this.errorInfoDialog = bool;
            this.hawkEyeEvent = obj;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ showAlertDialog(String str, String str2, String str3, ErrorAction errorAction, Boolean bool, Object obj, int i2, g gVar) {
            this(str, str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : errorAction, (i2 & 16) != 0 ? null : bool, obj);
        }

        public final ErrorAction getAction() {
            return this.action;
        }

        public final Boolean getErrorInfoDialog() {
            return this.errorInfoDialog;
        }

        public final Object getHawkEyeEvent() {
            return this.hawkEyeEvent;
        }
    }

    public static final class showNotMandatoryFields extends CJRInstruct {
        private final CJRRechargeCart cjrRechargeCart;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public showNotMandatoryFields(CJRRechargeCart cJRRechargeCart) {
            super((g) null);
            k.c(cJRRechargeCart, "cjrRechargeCart");
            this.cjrRechargeCart = cJRRechargeCart;
        }

        public final CJRRechargeCart getCjrRechargeCart() {
            return this.cjrRechargeCart;
        }
    }

    public static final class openAutomaticAddNewBill extends CJRInstruct {
        private final CJRRechargeCart cjrRechargeCart;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public openAutomaticAddNewBill(CJRRechargeCart cJRRechargeCart) {
            super((g) null);
            k.c(cJRRechargeCart, "cjrRechargeCart");
            this.cjrRechargeCart = cJRRechargeCart;
        }

        public final CJRRechargeCart getCjrRechargeCart() {
            return this.cjrRechargeCart;
        }
    }

    public static final class openPostOrderSummaryActivity extends CJRInstruct {
        private final Object hawkEyeEvent;
        private final CJRRechargeCart rechargeCart;
        private final CJRRechargePayment rechargePayment;

        public openPostOrderSummaryActivity(CJRRechargePayment cJRRechargePayment, CJRRechargeCart cJRRechargeCart, Object obj) {
            super((g) null);
            this.rechargePayment = cJRRechargePayment;
            this.rechargeCart = cJRRechargeCart;
            this.hawkEyeEvent = obj;
        }

        public final Object getHawkEyeEvent() {
            return this.hawkEyeEvent;
        }

        public final CJRRechargeCart getRechargeCart() {
            return this.rechargeCart;
        }

        public final CJRRechargePayment getRechargePayment() {
            return this.rechargePayment;
        }
    }

    public static final class openRechargePaymentActivity extends CJRInstruct {
        private final String categoryName;
        private final Object hawkEyeEvent;
        private final CJRRechargeCart rechargeCart;
        private final CJRRechargePayment rechargePayment;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public openRechargePaymentActivity(String str, CJRRechargeCart cJRRechargeCart, CJRRechargePayment cJRRechargePayment, Object obj) {
            super((g) null);
            k.c(str, "categoryName");
            this.categoryName = str;
            this.rechargeCart = cJRRechargeCart;
            this.rechargePayment = cJRRechargePayment;
            this.hawkEyeEvent = obj;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ openRechargePaymentActivity(String str, CJRRechargeCart cJRRechargeCart, CJRRechargePayment cJRRechargePayment, Object obj, int i2, g gVar) {
            this(str, (i2 & 2) != 0 ? null : cJRRechargeCart, (i2 & 4) != 0 ? null : cJRRechargePayment, obj);
        }

        public final String getCategoryName() {
            return this.categoryName;
        }

        public final Object getHawkEyeEvent() {
            return this.hawkEyeEvent;
        }

        public final CJRRechargeCart getRechargeCart() {
            return this.rechargeCart;
        }

        public final CJRRechargePayment getRechargePayment() {
            return this.rechargePayment;
        }
    }

    public static final class openCouponsActivity extends CJRInstruct {
        private final String categoryName;
        private final Boolean dealsFastForward;
        private final String dealsMessage;
        private final String groupFieldValues;
        private final String protectionUrl;
        private final CJRRechargeCart rechargeCart;

        public final String getCategoryName() {
            return this.categoryName;
        }

        public final Boolean getDealsFastForward() {
            return this.dealsFastForward;
        }

        public final String getProtectionUrl() {
            return this.protectionUrl;
        }

        public final CJRRechargeCart getRechargeCart() {
            return this.rechargeCart;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public openCouponsActivity(String str, CJRRechargeCart cJRRechargeCart, String str2, Boolean bool, String str3, String str4) {
            super((g) null);
            k.c(str, "categoryName");
            this.categoryName = str;
            this.rechargeCart = cJRRechargeCart;
            this.protectionUrl = str2;
            this.dealsFastForward = bool;
            this.groupFieldValues = str3;
            this.dealsMessage = str4;
        }

        public final String getDealsMessage() {
            return this.dealsMessage;
        }

        public final String getGroupFieldValues() {
            return this.groupFieldValues;
        }
    }

    public static final class openUpdateAppVersionScreen extends CJRInstruct {
        private final String appMinVersion;

        public openUpdateAppVersionScreen(String str) {
            super((g) null);
            this.appMinVersion = str;
        }

        public final String getAppMinVersion() {
            return this.appMinVersion;
        }
    }

    public static final class saveRechargeCart extends CJRInstruct {
        private final CJRRechargeCart rechargeCart;

        public saveRechargeCart(CJRRechargeCart cJRRechargeCart) {
            super((g) null);
            this.rechargeCart = cJRRechargeCart;
        }

        public final CJRRechargeCart getRechargeCart() {
            return this.rechargeCart;
        }
    }

    public static final class saveRechargePayment extends CJRInstruct {
        private final CJRRechargePayment rechargePayment;

        public saveRechargePayment(CJRRechargePayment cJRRechargePayment) {
            super((g) null);
            this.rechargePayment = cJRRechargePayment;
        }

        public final CJRRechargePayment getRechargePayment() {
            return this.rechargePayment;
        }
    }

    public static final class openSetupAutomaticSelectDurationActivity extends CJRInstruct {
        private final FragmentActivity activity;
        private final Bundle extras;
        private final Fragment fragment;
        private final CJRFrequentOrder recent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public openSetupAutomaticSelectDurationActivity(Fragment fragment2, FragmentActivity fragmentActivity, CJRFrequentOrder cJRFrequentOrder, Bundle bundle) {
            super((g) null);
            k.c(cJRFrequentOrder, "recent");
            this.fragment = fragment2;
            this.activity = fragmentActivity;
            this.recent = cJRFrequentOrder;
            this.extras = bundle;
        }

        public final FragmentActivity getActivity() {
            return this.activity;
        }

        public final Bundle getExtras() {
            return this.extras;
        }

        public final Fragment getFragment() {
            return this.fragment;
        }

        public final CJRFrequentOrder getRecent() {
            return this.recent;
        }
    }

    public static final class openManageAutomaticActivity extends CJRInstruct {
        private final FragmentActivity activity;
        private final Bundle extras;
        private final Fragment fragment;
        private final CJRFrequentOrder recent;
        private final CJRAutomaticSubscriptionItemModel subscriptionModel;

        public final FragmentActivity getActivity() {
            return this.activity;
        }

        public final Fragment getFragment() {
            return this.fragment;
        }

        public final CJRFrequentOrder getRecent() {
            return this.recent;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public openManageAutomaticActivity(Fragment fragment2, FragmentActivity fragmentActivity, CJRFrequentOrder cJRFrequentOrder, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, Bundle bundle) {
            super((g) null);
            k.c(cJRFrequentOrder, "recent");
            k.c(cJRAutomaticSubscriptionItemModel, "subscriptionModel");
            this.fragment = fragment2;
            this.activity = fragmentActivity;
            this.recent = cJRFrequentOrder;
            this.subscriptionModel = cJRAutomaticSubscriptionItemModel;
            this.extras = bundle;
        }

        public final Bundle getExtras() {
            return this.extras;
        }

        public final CJRAutomaticSubscriptionItemModel getSubscriptionModel() {
            return this.subscriptionModel;
        }
    }

    public static final class updateCreateBillResponse extends CJRInstruct {
        private final CJRSetUserConsentApiResponse setUserConsentResponse;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public updateCreateBillResponse(CJRSetUserConsentApiResponse cJRSetUserConsentApiResponse) {
            super((g) null);
            k.c(cJRSetUserConsentApiResponse, "setUserConsentResponse");
            this.setUserConsentResponse = cJRSetUserConsentApiResponse;
        }

        public final CJRSetUserConsentApiResponse getSetUserConsentResponse() {
            return this.setUserConsentResponse;
        }
    }

    public static final class updateGetBillResponse extends CJRInstruct {
        private final CJRGetUserConsentApiResponse getUserConsentResponse;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public updateGetBillResponse(CJRGetUserConsentApiResponse cJRGetUserConsentApiResponse) {
            super((g) null);
            k.c(cJRGetUserConsentApiResponse, "getUserConsentResponse");
            this.getUserConsentResponse = cJRGetUserConsentApiResponse;
        }

        public final CJRGetUserConsentApiResponse getGetUserConsentResponse() {
            return this.getUserConsentResponse;
        }
    }

    public static final class updateUnsubscribeBillResponse extends CJRInstruct {
        private final UnsubscribeApiResponse unsubscribeResponse;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public updateUnsubscribeBillResponse(UnsubscribeApiResponse unsubscribeApiResponse) {
            super((g) null);
            k.c(unsubscribeApiResponse, "unsubscribeResponse");
            this.unsubscribeResponse = unsubscribeApiResponse;
        }

        public final UnsubscribeApiResponse getUnsubscribeResponse() {
            return this.unsubscribeResponse;
        }
    }

    public static final class resetRadioButton extends CJRInstruct {
        public resetRadioButton() {
            super((g) null);
        }
    }

    public static final class updateProductResponseOnDTH extends CJRInstruct {
        public updateProductResponseOnDTH() {
            super((g) null);
        }
    }

    public static final class onRecentClickCheckRcChange extends CJRInstruct {
        public onRecentClickCheckRcChange() {
            super((g) null);
        }
    }

    public static final class checkAndHandlePreFillForm extends CJRInstruct {
        public checkAndHandlePreFillForm() {
            super((g) null);
        }
    }

    public static final class openSubscriberBottomSheet extends CJRInstruct {
        private final CJRGroupDisplay cjrGroupDisplay;
        private final CJRRechargeCart rechargeCart;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public openSubscriberBottomSheet(CJRRechargeCart cJRRechargeCart, CJRGroupDisplay cJRGroupDisplay) {
            super((g) null);
            k.c(cJRGroupDisplay, "cjrGroupDisplay");
            this.rechargeCart = cJRRechargeCart;
            this.cjrGroupDisplay = cJRGroupDisplay;
        }

        public final CJRGroupDisplay getCjrGroupDisplay() {
            return this.cjrGroupDisplay;
        }

        public final CJRRechargeCart getRechargeCart() {
            return this.rechargeCart;
        }
    }

    public static final class setIsBillConsentSetSuccessfully extends CJRInstruct {
        private final boolean isBillConsentSetSuccessfully;

        public setIsBillConsentSetSuccessfully(boolean z) {
            super((g) null);
            this.isBillConsentSetSuccessfully = z;
        }

        public final boolean isBillConsentSetSuccessfully() {
            return this.isBillConsentSetSuccessfully;
        }
    }

    public static final class showMyBill extends CJRInstruct {
        private final CJRMyBillData myBillData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public showMyBill(CJRMyBillData cJRMyBillData) {
            super((g) null);
            k.c(cJRMyBillData, "myBillData");
            this.myBillData = cJRMyBillData;
        }

        public final CJRMyBillData getMyBillData() {
            return this.myBillData;
        }
    }

    public static final class updateAmountField extends CJRInstruct {
        private final String amount;
        private final CJRRechargeCart cjrRechargeCart;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public updateAmountField(String str, CJRRechargeCart cJRRechargeCart) {
            super((g) null);
            k.c(str, "amount");
            k.c(cJRRechargeCart, "cjrRechargeCart");
            this.amount = str;
            this.cjrRechargeCart = cJRRechargeCart;
        }

        public final String getAmount() {
            return this.amount;
        }

        public final CJRRechargeCart getCjrRechargeCart() {
            return this.cjrRechargeCart;
        }
    }

    public static final class errorInFetchAmountField extends CJRInstruct {
        public errorInFetchAmountField() {
            super((g) null);
        }
    }

    public static final class onContainsError extends CJRInstruct {
        private final Object hawkEyeModel;
        private final String message;
        private final String tag;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public onContainsError(String str, String str2, Object obj) {
            super((g) null);
            k.c(str2, "tag");
            this.message = str;
            this.tag = str2;
            this.hawkEyeModel = obj;
        }

        public final Object getHawkEyeModel() {
            return this.hawkEyeModel;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTag() {
            return this.tag;
        }
    }

    public static final class sendProductNotSelectedHawkEyeEvent extends CJRInstruct {
        private final String bankCode;

        public sendProductNotSelectedHawkEyeEvent(String str) {
            super((g) null);
            this.bankCode = str;
        }

        public final String getBankCode() {
            return this.bankCode;
        }
    }

    public static final class sendBillFetchSuccessfullEvent extends CJRInstruct {
        private final String label;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public sendBillFetchSuccessfullEvent(String str) {
            super((g) null);
            k.c(str, "label");
            this.label = str;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    public static final class sendBillFetchFailEvent extends CJRInstruct {
        private final String label;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public sendBillFetchFailEvent(String str) {
            super((g) null);
            k.c(str, "label");
            this.label = str;
        }

        public final String getLabel() {
            return this.label;
        }
    }
}
