package net.one97.paytm.common.entity.recharge.v2;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRProductAttributes implements IJRDataModel {
    private String board;
    @b(a = "challan_type")
    private String challanType;
    private String disclaimer;
    private String district;
    @b(a = "fee_type")
    private String feeType;
    @b(a = "input_field-config_key-1")
    private String mInputFieldConfig;
    @b(a = "input_field-regex-1")
    private String mInputFieldRegex1;
    @b(a = "input_field-sample_bill-1")
    private String mInputFieldSampleBill1;
    @b(a = "input_field-title-1")
    private String mInputFieldTitle1;
    @b(a = "sub_district")
    private String mSubDistrict;
    @b(a = "sub_division")
    private String mSubDivision;
    private String max_amount;
    private String min_amount;
    private String operator;
    @b(a = "operator_display_label")
    private String operatorDisplayLabel;
    @b(a = "operator_label")
    private String operator_label;
    @b(a = "otp_flow")
    private int otp_flow;
    @b(a = "paytype_display_label")
    private String payTypeDisplayLabel;
    private String paytype;
    @b(a = "paytype_label")
    private String paytypeLabel;
    private String prefetch;
    private String service;
    @b(a = "service_display_label")
    private String serviceDisplayLabel;
    private String service_label;
    private String state;

    public String getmSubDivision() {
        return this.mSubDivision;
    }

    public void setmSubDivision(String str) {
        this.mSubDivision = str;
    }

    public String getmSubDistrict() {
        return this.mSubDistrict;
    }

    public void setmSubDistrict(String str) {
        this.mSubDistrict = str;
    }

    public String getPaytypeLabel() {
        return this.paytypeLabel;
    }

    public String getPaytTypeDisplayLabel() {
        if (!TextUtils.isEmpty(this.payTypeDisplayLabel)) {
            return this.payTypeDisplayLabel;
        }
        return this.paytypeLabel;
    }

    public void setPaytypeLabel(String str) {
        this.paytypeLabel = str;
    }

    public void setPayTypeDisplayLabel(String str) {
        this.payTypeDisplayLabel = str;
    }

    public String getPrefetch() {
        return this.prefetch;
    }

    public void setPrefetch(String str) {
        this.prefetch = str;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public void setDisclaimer(String str) {
        this.disclaimer = str;
    }

    public String getOperator_label() {
        return this.operator_label;
    }

    public String getOperatorDisplayLabel() {
        if (!TextUtils.isEmpty(this.operatorDisplayLabel)) {
            return this.operatorDisplayLabel;
        }
        return this.operator_label;
    }

    public void setOperator_label(String str) {
        this.operator_label = str;
    }

    public void setOperatorDisplayLabel(String str) {
        this.operatorDisplayLabel = str;
    }

    public String getMin_amount() {
        return this.min_amount;
    }

    public void setMin_amount(String str) {
        this.min_amount = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getService_label() {
        return this.service_label;
    }

    public String getServiceDisplayLabel() {
        if (!TextUtils.isEmpty(this.serviceDisplayLabel)) {
            return this.serviceDisplayLabel;
        }
        return this.service_label;
    }

    public void setService_label(String str) {
        this.service_label = str;
    }

    public String getBoard() {
        return this.board;
    }

    public void setBoard(String str) {
        this.board = str;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public String getmInputFieldRegex1() {
        return this.mInputFieldRegex1;
    }

    public void setmInputFieldRegex1(String str) {
        this.mInputFieldRegex1 = str;
    }

    public String getPaytype() {
        return this.paytype;
    }

    public void setPaytype(String str) {
        this.paytype = str;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String str) {
        this.service = str;
    }

    public String getmInputFieldConfig() {
        return this.mInputFieldConfig;
    }

    public void setmInputFieldConfig(String str) {
        this.mInputFieldConfig = str;
    }

    public String getmInputFieldTitle1() {
        return this.mInputFieldTitle1;
    }

    public void setmInputFieldTitle1(String str) {
        this.mInputFieldTitle1 = str;
    }

    public String getmInputFieldSampleBill1() {
        return this.mInputFieldSampleBill1;
    }

    public void setmInputFieldSampleBill1(String str) {
        this.mInputFieldSampleBill1 = str;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public String getMax_amount() {
        return this.max_amount;
    }

    public void setMax_amount(String str) {
        this.max_amount = str;
    }

    public boolean getOtp_flow() {
        return this.otp_flow == 1;
    }

    public void setOtp_flow(int i2) {
        this.otp_flow = i2;
    }

    public String getFeeType() {
        return this.feeType;
    }

    public void setFeeType(String str) {
        this.feeType = str;
    }

    public String getChallanType() {
        return this.challanType;
    }

    public void setChallanType(String str) {
        this.challanType = str;
    }
}
