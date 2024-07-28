package com.business.merchant_payments.model.lastcollectedpaymentmodel;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.model.BaseModel;
import com.business.merchant_payments.model.businesswallet.ResultInfo;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineTransactionDetails extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "response")
    public OfflineTransactionDetailResponse mOfflineTransactionDetailMsg;
    @c(a = "status")
    public String mStatus;
    @c(a = "statusCode")
    public String mStatusCode;
    @c(a = "statusMessage")
    public String mStatusMessage;
    @c(a = "results")
    public ArrayList<OfflineTransDetailObject> offlineTransDetailObjectArrayList;
    @c(a = "orderList")
    public ArrayList<OfflineOrderDetails> orderList;
    public String pageNum;
    public String pageSize;
    public ResultInfo resultInfo;

    public String getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(String str) {
        this.pageSize = str;
    }

    public String getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(String str) {
        this.pageNum = str;
    }

    public ArrayList<OfflineOrderDetails> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(ArrayList<OfflineOrderDetails> arrayList) {
        this.orderList = arrayList;
    }

    public String getmStatus() {
        ResultInfo resultInfo2 = this.resultInfo;
        if (resultInfo2 == null || TextUtils.isEmpty(resultInfo2.getResultStatus())) {
            return this.mStatus;
        }
        return this.resultInfo.getResultStatus();
    }

    public String getmStatusCode() {
        ResultInfo resultInfo2 = this.resultInfo;
        if (resultInfo2 == null || TextUtils.isEmpty(resultInfo2.getResultCode())) {
            return this.mStatusCode;
        }
        return this.resultInfo.getResultCode();
    }

    public String getmStatusMessage() {
        ResultInfo resultInfo2 = this.resultInfo;
        if (resultInfo2 == null || TextUtils.isEmpty(resultInfo2.getResultMsg())) {
            return this.mStatusMessage;
        }
        return this.resultInfo.getResultMsg();
    }

    public OfflineTransactionDetailResponse getmOfflineTransactionDetailMsg() {
        String str;
        if (this.mOfflineTransactionDetailMsg == null && this.offlineTransDetailObjectArrayList != null) {
            OfflineTransactionDetailResponse offlineTransactionDetailResponse = new OfflineTransactionDetailResponse();
            this.mOfflineTransactionDetailMsg = offlineTransactionDetailResponse;
            offlineTransactionDetailResponse.setmOfflineTransDetailObj(this.offlineTransDetailObjectArrayList);
        } else if (this.mOfflineTransactionDetailMsg == null && this.orderList != null) {
            this.mOfflineTransactionDetailMsg = new OfflineTransactionDetailResponse();
            this.offlineTransDetailObjectArrayList = new ArrayList<>();
            Iterator<OfflineOrderDetails> it2 = this.orderList.iterator();
            while (it2.hasNext()) {
                OfflineOrderDetails next = it2.next();
                OfflineTransDetailObject offlineTransDetailObject = new OfflineTransDetailObject();
                parseInfo(next.getExtendInfo(), offlineTransDetailObject, next.getMerchantTransId());
                offlineTransDetailObject.setmPayerPhoneNumber(next.getOppositePhone());
                if (next.getPayMoneyAmount() == null || TextUtils.isEmpty(next.getPayMoneyAmount().getValue())) {
                    offlineTransDetailObject.setmSettlementAmmount("0");
                } else {
                    offlineTransDetailObject.setmSettlementAmmount(next.getPayMoneyAmount().getValue());
                }
                if (next.getCommission() == null || TextUtils.isEmpty(next.getCommission().getValue())) {
                    offlineTransDetailObject.setmCommissionAmmount("0");
                } else {
                    offlineTransDetailObject.setmCommissionAmmount(next.getCommission().getValue());
                }
                if (next.getCommissionTax() == null || TextUtils.isEmpty(next.getCommissionTax().getValue())) {
                    offlineTransDetailObject.setmServiceTax("0");
                } else {
                    offlineTransDetailObject.setmServiceTax(next.getCommissionTax().getValue());
                }
                offlineTransDetailObject.setUserName(next.getNickName());
                offlineTransDetailObject.setEmail(next.getOppositeEmail());
                offlineTransDetailObject.setmPosID(next.getPosId());
                String formattedDate = DateUtility.getFormattedDate(next.getOrderCreatedTime(), "yyyy-MM-dd'T'HH:mm:ssZ", "dd/MM/yyyy HH:mm:ss");
                offlineTransDetailObject.setmSettlementDate(formattedDate);
                offlineTransDetailObject.setmTransactionDate(formattedDate);
                if (!TextUtils.isEmpty(offlineTransDetailObject.getmPaymentCreatedDate())) {
                    String[] split = offlineTransDetailObject.getmPaymentCreatedDate().split(" ");
                    if (split == null || split.length <= 5) {
                        str = "";
                    } else {
                        str = split[2] + " " + split[1] + " " + split[5] + ", " + DateUtility.getFormattedDate(split[3], "HH:mm:ss", "hh:mm a");
                    }
                    offlineTransDetailObject.setmPaymentCreatedDate(str);
                }
                this.offlineTransDetailObjectArrayList.add(offlineTransDetailObject);
            }
            this.mOfflineTransactionDetailMsg.setmOfflineTransDetailObj(this.offlineTransDetailObjectArrayList);
        }
        return this.mOfflineTransactionDetailMsg;
    }

    private void parseInfo(String str, OfflineTransDetailObject offlineTransDetailObject, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ORDER_CREATE_EXTEND_INFO", "");
            String optString2 = jSONObject.optString("EXT_PASSTHROUGH", "");
            JSONObject jSONObject2 = new JSONObject(optString.replace("\\", "").replace("\"{", "{").replace("}\"", "}"));
            if (!TextUtils.isEmpty(optString2)) {
                JSONObject jSONObject3 = new JSONObject(optString2);
                offlineTransDetailObject.setmPaymentCreatedDate(jSONObject3.optString("TXN_DATE"));
                String optString3 = jSONObject3.optString("virtualPaymentAddr");
                if (!TextUtils.isEmpty(optString3)) {
                    offlineTransDetailObject.setUserVPA(optString3);
                }
                String optString4 = jSONObject3.optString("originalPaymentMode");
                if (!TextUtils.isEmpty(optString4)) {
                    offlineTransDetailObject.setOriginalPayMode(optString4);
                }
            }
            String optString5 = jSONObject2.optString("totalTxnAmount");
            String optString6 = jSONObject2.optString("mode");
            if (!TextUtils.isEmpty(optString6)) {
                offlineTransDetailObject.setOriginalPayMode(optString6);
            }
            offlineTransDetailObject.setmTransactionAmmount(optString5);
            if (!TextUtils.isEmpty(str2)) {
                offlineTransDetailObject.setmMerchantOrderID(str2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
