package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStatusDetails implements IJRDataModel {
    @b(a = "actions")
    private ArrayList<CJRAction> mActions = new ArrayList<>();
    @b(a = "status_text")
    private String mStatusText;

    public String getmStatusText() {
        return this.mStatusText;
    }

    public ArrayList<CJRAction> getmActions() {
        return this.mActions;
    }

    public void setmActions(ArrayList<CJRAction> arrayList) {
        this.mActions = arrayList;
    }

    public void setmStatusText(String str) {
        this.mStatusText = str;
    }
}
