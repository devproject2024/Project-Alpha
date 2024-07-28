package net.one97.paytm.recharge.model.v4;

import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRRechargeAlertItemMapper {
    public final CJRRechargeAlertItem mapFrom(Help help) {
        k.c(help, "from");
        return new CJRRechargeAlertItem(help.getTitle(), (String) null, help.getDescription(), help.getDescription1(), help.getDescription2(), help.getButtonLabel(), help.getButtonUrl(), (String) null, 130, (g) null);
    }

    public final List<CJRRechargeAlertItem> mapFromLPGItem(String str, String str2) {
        k.c(str, "msg");
        List<CJRRechargeAlertItem> arrayList = new ArrayList<>();
        arrayList.add(new CJRRechargeAlertItem((String) null, str, (String) null, (String) null, (String) null, (String) null, (String) null, str2, 125, (g) null));
        return arrayList;
    }

    public final List<CJRRechargeAlertItem> mapFrom(List<Help> list) {
        List<CJRRechargeAlertItem> arrayList = new ArrayList<>();
        if (list != null) {
            for (Help mapFrom : list) {
                arrayList.add(mapFrom(mapFrom));
            }
        }
        return arrayList;
    }
}
