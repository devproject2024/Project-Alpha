package net.one97.paytm.h5.model;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class H5AppStartupParamsModel implements IJRDataModel {
    @b(a = "params")
    private String params;
    @b(a = "path")
    private String path;
    @b(a = "sparams")
    private HashMap<String, Object> sparams;

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public HashMap<String, Object> getSparams() {
        return this.sparams;
    }

    public void setSparams(HashMap<String, Object> hashMap) {
        this.sparams = hashMap;
    }

    public String toString() {
        return "H5AppStartupParamsModel{path='" + this.path + '\'' + ", params='" + this.params + '\'' + ", sparams=" + this.sparams + '}';
    }
}
