package com.business.merchant_payments.model;

public abstract class EncryptedBaseModel extends BaseModel {
    public abstract void decryptData();

    public abstract void encryptData();
}
