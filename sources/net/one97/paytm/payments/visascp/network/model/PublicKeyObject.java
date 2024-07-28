package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;

public class PublicKeyObject extends BaseModel {
    @c(a = "keySize")
    private int mKeySize;
    @c(a = "keyType")
    private String mKeyType;
    @c(a = "publicKey")
    private String mPublicKey;

    public String getKeyType() {
        return this.mKeyType;
    }

    public void setKeyType(String str) {
        this.mKeyType = str;
    }

    public int getKeySize() {
        return this.mKeySize;
    }

    public void setKeySize(int i2) {
        this.mKeySize = i2;
    }

    public String getPublicKey() {
        return this.mPublicKey;
    }

    public void setPublicKey(String str) {
        this.mPublicKey = str;
    }
}
