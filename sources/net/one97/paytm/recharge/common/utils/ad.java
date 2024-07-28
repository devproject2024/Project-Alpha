package net.one97.paytm.recharge.common.utils;

import java.util.Comparator;
import kotlin.g.b.k;
import net.one97.paytm.recharge.model.ContactItemModel;

public final class ad implements Comparator<ContactItemModel> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        String name;
        String str;
        ContactItemModel contactItemModel = (ContactItemModel) obj;
        ContactItemModel contactItemModel2 = (ContactItemModel) obj2;
        if (contactItemModel == null || (name = contactItemModel.getName()) == null) {
            return 0;
        }
        if (contactItemModel2 == null || (str = contactItemModel2.getName()) == null) {
            str = "";
        }
        k.d(name, "$this$compareTo");
        k.d(str, "other");
        return name.compareToIgnoreCase(str);
    }
}
