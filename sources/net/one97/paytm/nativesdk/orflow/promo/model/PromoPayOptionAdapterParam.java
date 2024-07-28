package net.one97.paytm.nativesdk.orflow.promo.model;

import java.util.ArrayList;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public class PromoPayOptionAdapterParam {
    private int VIEWTYPE;
    private String cardNumber;
    private int cardSizeShouldBe;
    private BaseDataModel data;
    private CJRFetchBalanceResponse fetchBalanceResponse;
    private String inputError;
    private boolean isSelected;
    private String mode;
    private ArrayList<PromoPayOptionAdapterParam> nbTopBankList;
    private NetworkCallState networkCallState = NetworkCallState.Default;
    private String nonPromoErrorMessage;
    private String promoErrorMessage;
    private int sortingOrder;
    private TransactionType transactionType;
    private String upiAddress;

    public enum NetworkCallState {
        Default,
        Processing,
        Success,
        Failed
    }

    public enum TransactionType {
        UserInput,
        NonUserInput
    }

    public PromoPayOptionAdapterParam(int i2, BaseDataModel baseDataModel) {
        this.data = baseDataModel;
        this.VIEWTYPE = i2;
    }

    public int getSortingOrder() {
        return this.sortingOrder;
    }

    public void setSortingOrder(int i2) {
        this.sortingOrder = i2;
    }

    public NetworkCallState getNetworkCallState() {
        return this.networkCallState;
    }

    public void setNetworkCallState(NetworkCallState networkCallState2) {
        this.networkCallState = networkCallState2;
    }

    public ArrayList<PromoPayOptionAdapterParam> getNbTopBankList() {
        return this.nbTopBankList;
    }

    public void setNbTopBankList(ArrayList<PromoPayOptionAdapterParam> arrayList) {
        this.nbTopBankList = arrayList;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(TransactionType transactionType2) {
        this.transactionType = transactionType2;
    }

    public CJRFetchBalanceResponse getFetchBalanceResponse() {
        return this.fetchBalanceResponse;
    }

    public void setFetchBalanceResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        this.fetchBalanceResponse = cJRFetchBalanceResponse;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public String getInputError() {
        return this.inputError;
    }

    public void setInputError(String str) {
        this.inputError = str;
    }

    public String getUpiAddress() {
        return this.upiAddress;
    }

    public void setUpiAddress(String str) {
        this.upiAddress = str;
    }

    public int getCardSizeShouldBe() {
        return this.cardSizeShouldBe;
    }

    public void setCardSizeShouldBe(int i2) {
        this.cardSizeShouldBe = i2;
    }

    public String getPromoErrorMessage() {
        return this.promoErrorMessage;
    }

    public void setPromoErrorMessage(String str) {
        this.promoErrorMessage = str;
    }

    public String getNonPromoErrorMessage() {
        return this.nonPromoErrorMessage;
    }

    public void setNonPromoErrorMessage(String str) {
        this.nonPromoErrorMessage = str;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public int getVIEWTYPE() {
        return this.VIEWTYPE;
    }

    public void setVIEWTYPE(int i2) {
        this.VIEWTYPE = i2;
    }

    public BaseDataModel getData() {
        return this.data;
    }

    public void setData(BaseDataModel baseDataModel) {
        this.data = baseDataModel;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
