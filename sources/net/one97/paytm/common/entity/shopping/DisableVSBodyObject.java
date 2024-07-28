package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;

public class DisableVSBodyObject {
    @b(a = "resultInfo")
    private HashMap<String, String> resultInfo = new HashMap<>();

    public HashMap<String, String> getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(HashMap<String, String> hashMap) {
        this.resultInfo = hashMap;
    }
}
