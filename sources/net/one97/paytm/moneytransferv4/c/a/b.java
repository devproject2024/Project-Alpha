package net.one97.paytm.moneytransferv4.c.a;

import android.content.Context;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransferv4.b.a.a.e;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f55358a;

    static final class a<T> implements z<S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f55359a;

        a(w wVar) {
            this.f55359a = wVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = ((ArrayList) obj).iterator();
            while (it2.hasNext()) {
                ContactDetail contactDetail = (ContactDetail) it2.next();
                k.a((Object) contactDetail, "contact");
                arrayList.add(new net.one97.paytm.moneytransferv4.b.a.a.a.e.a(contactDetail));
            }
            w wVar = this.f55359a;
            c.a aVar = c.f54031e;
            wVar.setValue(c.a.a(arrayList));
        }
    }

    public b(Context context) {
        k.c(context, "context");
        this.f55358a = context;
    }

    public final void a(w<c<ArrayList<e<RecyclerView.v>>>> wVar) {
        k.c(wVar, "contactsApiState");
        wVar.addSource(net.one97.paytm.contacts.utils.c.f50249c.a(this.f55358a, e.C0905e.MONEY_TRANSFER.getType(), e.b.PHONEBOOK.getType()), new a(wVar));
    }
}
