package net.one97.paytm.autoaddmoney.util;

import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.common.entity.IJRDataModel;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f49283a = new d();

    private d() {
    }

    public static void a(ArrayList<IJRDataModel> arrayList) {
        if (arrayList != null) {
            Iterator<IJRDataModel> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                IJRDataModel next = it2.next();
                if (next instanceof CJRAvailableInstrumentsAddMoney.Card) {
                    ((CJRAvailableInstrumentsAddMoney.Card) next).setChecked(false);
                } else if (next instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card) {
                    ((CJRAvailableInstrumentsAddMoneyCreditCard.Card) next).setChecked(false);
                } else if (next instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
                    ((CJRAvailableInstrumentsAddMoneyPPBL.Card) next).setChecked(true);
                }
            }
        }
    }
}
