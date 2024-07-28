package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class DefaultDebit implements BaseDataModel {
    @c(a = "accRefNumber")
    @a
    private String accRefNumber;
    @c(a = "account")
    @a
    private String account;
    @c(a = "accountType")
    @a
    private String accountType;
    @c(a = "aeba")
    @a
    private String aeba;
    @c(a = "bank")
    @a
    private String bank;
    @c(a = "credsAllowed")
    @a
    private List<CredsAllowed_> credsAllowed = null;
    @c(a = "ifsc")
    @a
    private String ifsc;
    @c(a = "invalidVpa")
    @a
    private Boolean invalidVpa;
    @c(a = "mbeba")
    @a
    private String mbeba;
    @c(a = "name")
    @a
    private String name;

    public String getBank() {
        return this.bank;
    }

    public void setBank(String str) {
        this.bank = str;
    }

    public String getIfsc() {
        return this.ifsc;
    }

    public void setIfsc(String str) {
        this.ifsc = str;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String getAccRefNumber() {
        return this.accRefNumber;
    }

    public void setAccRefNumber(String str) {
        this.accRefNumber = str;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public List<CredsAllowed_> getCredsAllowed() {
        return this.credsAllowed;
    }

    public void setCredsAllowed(List<CredsAllowed_> list) {
        this.credsAllowed = list;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMbeba() {
        return this.mbeba;
    }

    public void setMbeba(String str) {
        this.mbeba = str;
    }

    public String getAeba() {
        return this.aeba;
    }

    public void setAeba(String str) {
        this.aeba = str;
    }

    public Boolean getInvalidVpa() {
        return this.invalidVpa;
    }

    public void setInvalidVpa(Boolean bool) {
        this.invalidVpa = bool;
    }
}
