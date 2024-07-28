package net.one97.paytm.upi.common.upi;

import com.android.volley.Request;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.MoneyTransferRecentListAdapter;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.BeneficiaryEntity;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.d;
import net.one97.paytm.upi.util.ClickEvent;

public interface MoneyTransferContract {

    public enum ErrorMessage {
        SOMETHING_WENT_WRONG,
        PLEASE_ADD_BANK,
        CANNOT_TRANSFER_TO_SAME_ACC,
        NO_SIM
    }

    public interface MoneyTransferRecentListRowView {
        void setAccountNumberOrVpa(String str);

        void setAmount(String str);

        void setBankName(String str);

        void setBeneficiaryName(String str);

        void setDate(String str, String str2);

        void setListRowClick(int i2);

        void setListRowLongClick(int i2);

        void setLogoBankName(String str);

        void setRowIcon(String str);

        void setSelectedState(boolean z);
    }

    public interface Presenter extends c {
        void addBeneficiary(String str, String str2, String str3, String str4);

        void bankAccountSelected(AccountProviderBody.AccountProvider accountProvider);

        void callUserInfoV2();

        void collectRequestApiForVpa(String str, String str2, String str3, String str4, String str5, String str6, String str7, UpiProfileDefaultBank upiProfileDefaultBank, String str8);

        void commonApiForAadhar(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, String str9);

        void commonApiForAccountNumber(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, UpiProfileDefaultBank upiProfileDefaultBank, String str10);

        void commonApiForVpa(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, UpiProfileDefaultBank upiProfileDefaultBank, String str11, boolean z);

        void getAccBalance(String str);

        int getNotificationCount();

        int getRepositoriesRowsCount();

        void getUpiAccBalance(UpiProfileDefaultBank upiProfileDefaultBank);

        void getUpiListKeys(boolean z);

        void getUpiProfile();

        void getUpiToken();

        void getVpaList();

        void hitWalletCommisionApi(String str, String str2, String str3);

        void onBindRepositoryRowViewAtPosition(int i2, MoneyTransferRecentListAdapter.BeneficiaryViewHolder beneficiaryViewHolder);

        void onCommissionApiResponse(UpiBaseDataModel upiBaseDataModel);

        void onRecentRowClick(int i2);

        void onRecentRowLongClick(int i2);

        void onUserInfoV2response();

        void onVerifyIfsc(String str);

        void onVerifyVpa(String str, String str2, ProgressType progressType, boolean z);

        void selectAll();

        void sendParametersToCommonLib(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<BankAccountDetails.BankAccountCredentials> list, String str12);

        void unSelectAll();

        void updateListAfterDeletion();
    }

    public enum ProgressType {
        VERIFY_VPA,
        PROCESS_PAYMENT
    }

    public interface View extends d<Presenter> {
        void addUPIBeneficiary(BaseUpiResponse baseUpiResponse);

        void callCommonPayApi(String str);

        void clearVpaList(List<UpiProfileDefaultBank> list);

        void doProceedForPayemnt(boolean z);

        boolean doShowPPBForUPI();

        boolean doShowWalletOption();

        void finishActivity();

        boolean getCollectRequestOrPushFlag();

        boolean getUnivP2PFlag();

        void handleUIbasedOnUpiEnabled(boolean z);

        void inflateDropDownRecords(ArrayList<UpiBaseDataModel> arrayList);

        void initialiseIMPSVariables(Double d2, Double d3);

        boolean isFromDeeplink();

        boolean isFromOfflinePg();

        boolean isFromPPBAddMoney();

        void isIfscVerified(boolean z, String str);

        void isPPBLinkedtoUpi(boolean z);

        boolean isShowBankAccount();

        boolean isUpiPushFlow();

        void isVpaVerified(boolean z, String str);

        void loadBeneficiaryFragment();

        void loadContactsFragment();

        void moneySentViaImps(UpiBaseDataModel upiBaseDataModel);

        void moneySentViaUpi(BaseUpiResponse baseUpiResponse, String str);

        void onBeneficiaryListFetched(ArrayList<BeneficiaryEntity> arrayList, int i2);

        void onRecentItemClick(UpiDBTransactionModel upiDBTransactionModel);

        void onRecentItemLongClick(int i2);

        void onRecentSelectForDeletion(ClickEvent clickEvent);

        void onTokenFetched(String str);

        void onUpiAccountsFetched(List<BankAccountDetails.BankAccount> list);

        void onVpaFetched(List<UpiProfileDefaultBank> list, List<UpiProfileDefaultBank> list2, ArrayList<String> arrayList);

        void populateIfscCode(String str, String str2);

        void populatePayerName(String str);

        void proceedToPay();

        void setCriteriaForPPBImps(boolean z);

        void setP2BFee(double d2, double d3, double d4, double d5);

        void showAdpaterLoader(boolean z);

        void showAmountAndPaymentLayout();

        void showBottomSheetForP2B();

        void showError(UpiCustomVolleyError upiCustomVolleyError);

        void showErrorDialog(String str);

        void showInsufficientBalDialog(String str, boolean z);

        void showNetworkdialog(Request request);

        void showNewWalletLoader(boolean z, boolean z2);

        void showNoRecentsLayout();

        void showProgressBar(boolean z, ProgressType progressType);

        void showSelectAll(boolean z);

        void showTokenFetchError(ErrorMessage errorMessage);

        void showWalletDialogLoader(boolean z, boolean z2);

        void startBankAdditionScreen(AccountProviderBody.AccountProvider accountProvider, String str);

        void startDeviceRegistration(boolean z);

        void updateBankAccBalance(String str);

        void updateBankAccNumber(String str);

        void updateUpiBankAccBalance(String str, String str2);

        void updateWalletBalance(double d2);
    }
}
