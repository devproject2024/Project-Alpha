package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;

public abstract class EncryptedBaseModel extends a {
    public abstract void decryptData();

    public abstract void encryptData();
}
