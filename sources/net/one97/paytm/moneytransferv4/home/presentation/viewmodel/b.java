package net.one97.paytm.moneytransferv4.home.presentation.viewmodel;

import kotlin.g.b.l;
import net.one97.paytm.moneytransfer.model.ContactItemModel;

final class b extends l implements kotlin.g.a.b<ContactItemModel, Boolean> {
    public static final b INSTANCE = new b();

    b() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((ContactItemModel) obj));
    }

    public final boolean invoke(ContactItemModel contactItemModel) {
        return contactItemModel.ismIsHeading();
    }
}
