package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRServiceOptions implements IJRDataModel {
    @b(a = "actions")
    private ArrayList<CJRServiceActions> mActions;

    public ArrayList<CJRServiceActions> getActions() {
        return this.mActions;
    }
}
