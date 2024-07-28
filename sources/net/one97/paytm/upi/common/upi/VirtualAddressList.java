package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class VirtualAddressList implements UpiBaseDataModel {
    @c(a = "default-vpa")
    private String defaultVpa;
    @c(a = "va")
    private String va;

    public String getVa() {
        return this.va;
    }

    public void setVa(String str) {
        this.va = str;
    }

    public String getDefaultVpa() {
        return this.defaultVpa;
    }

    public void setDefaultVpa(String str) {
        this.defaultVpa = str;
    }
}
