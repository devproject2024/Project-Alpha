package net.one97.paytm.common.entity.shopping;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;

public class CJRDthPlanInfo implements Serializable {
    @c(a = "services")
    private List<CJRService> services;
    @c(a = "type")
    private String type;

    public List<CJRService> getServices() {
        return this.services;
    }

    public void setServices(List<CJRService> list) {
        this.services = list;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
