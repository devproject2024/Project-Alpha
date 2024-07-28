package net.one97.paytm.cst.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class OrderDetail implements IJRDataModel {
    @c(a = "UPI_RRN")
    @a
    private String UPI_RRN;
    @c(a = "UPI_taxation_id")
    @a
    private String UPI_taxation_id;
    @c(a = "UPI_taxation_type")
    @a
    private String UPI_taxation_type;
    @c(a = "amount")
    @a
    private String amount;
    @c(a = "bankId")
    @a
    private String bankId;
    @c(a = "colorCode")
    @a
    private String colorCode;
    @c(a = "desc")
    @a
    private String desc;
    @c(a = "display_id")
    @a
    private String display_text;
    @c(a = "domain")
    @a
    private String domain;
    @c(a = "entity")
    @a
    private String entity;
    @c(a = "id")
    @a
    private String id;
    @c(a = "img_url")
    @a
    private String imgUrl;
    @c(a = "is_local")
    @a
    private String is_local;
    @c(a = "itemId")
    @a
    private String itemId;
    @c(a = "status")
    @a
    private String status;
    @c(a = "taxationId")
    @a
    private String taxationId;
    @c(a = "time")
    @a
    private String time;
    @c(a = "upi_transaction")
    @a
    private String upi_transaction;
    @c(a = "user_first_name")
    @a
    private String user_first_name;
    @c(a = "user_last_name")
    @a
    private String user_last_name;
    @c(a = "verticalId")
    @a
    private String verticalId;
    @c(a = "verticalName")
    @a
    private String verticalName;
    @c(a = "walletId")
    @a
    private String walletId;

    public String getDisplay_text() {
        return this.display_text;
    }

    public void setDisplay_text(String str) {
        this.display_text = str;
    }

    public String getBankId() {
        return this.bankId;
    }

    public void setBankId(String str) {
        this.bankId = str;
    }

    public String getUser_first_name() {
        return this.user_first_name;
    }

    public void setUser_first_name(String str) {
        this.user_first_name = str;
    }

    public String getUser_last_name() {
        return this.user_last_name;
    }

    public void setUser_last_name(String str) {
        this.user_last_name = str;
    }

    public String getUpi_transaction() {
        return this.upi_transaction;
    }

    public void setUpi_transaction(String str) {
        this.upi_transaction = str;
    }

    public String getVerticalName() {
        return this.verticalName;
    }

    public void setVerticalName(String str) {
        this.verticalName = str;
    }

    public String getIs_local() {
        return this.is_local;
    }

    public void setIs_local(String str) {
        this.is_local = str;
    }

    public String getTaxationId() {
        return this.taxationId;
    }

    public void setTaxationId(String str) {
        this.taxationId = str;
    }

    public String getWalletId() {
        return this.walletId;
    }

    public void setWalletId(String str) {
        this.walletId = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getUPI_RRN() {
        return this.UPI_RRN;
    }

    public void setUPI_RRN(String str) {
        this.UPI_RRN = str;
    }

    public String getUPI_taxation_id() {
        return this.UPI_taxation_id;
    }

    public void setUPI_taxation_id(String str) {
        this.UPI_taxation_id = str;
    }

    public String getUPI_taxation_type() {
        return this.UPI_taxation_type;
    }

    public void setUPI_taxation_type(String str) {
        this.UPI_taxation_type = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(String str) {
        this.verticalId = str;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getEntity() {
        return this.entity;
    }

    public void setEntity(String str) {
        this.entity = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public void setColorCode(String str) {
        this.colorCode = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }
}
