package net.one97.paytm.moneytransferv4.a.b;

import android.content.Context;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import net.one97.paytm.contacts.entities.beans.ContactBeneficiaryBean;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.moneytransfer.utils.h;
import net.one97.paytm.moneytransfer.utils.l;

public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    final Context f54823a;

    static final class a<T> implements Response.Listener<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f54824a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f54825b;

        a(CancellableContinuation cancellableContinuation, d dVar) {
            this.f54824a = cancellableContinuation;
            this.f54825b = dVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            int i2 = 0;
            try {
                l.a aVar = l.f54175a;
                Context applicationContext = this.f54825b.f54823a.getApplicationContext();
                k.a((Object) applicationContext, "context.applicationContext");
                com.paytm.b.a.a a2 = l.a.a(applicationContext);
                k.a((Object) iJRPaytmDataModel, Payload.RESPONSE);
                byte[] bArr = iJRPaytmDataModel.getNetworkResponse().data;
                k.a((Object) bArr, "response.networkResponse.data");
                Charset defaultCharset = Charset.defaultCharset();
                k.a((Object) defaultCharset, "Charset.defaultCharset()");
                a2.a("mt_beneficiary_cache", new String(bArr, defaultCharset), false);
                a2.a("isRefreshRequired", false, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ArrayList arrayList = new ArrayList();
            if (iJRPaytmDataModel instanceof ContactBeneficiaryBean) {
                ContactBeneficiaryBean contactBeneficiaryBean = (ContactBeneficiaryBean) iJRPaytmDataModel;
                if (contactBeneficiaryBean.getResponseObject() != null) {
                    net.one97.paytm.contacts.entities.beans.Response responseObject = contactBeneficiaryBean.getResponseObject();
                    k.a((Object) responseObject, "response.responseObject");
                    if (responseObject.getContacts() != null) {
                        net.one97.paytm.contacts.entities.beans.Response responseObject2 = contactBeneficiaryBean.getResponseObject();
                        k.a((Object) responseObject2, "response.responseObject");
                        if (responseObject2.getContacts().size() > 0) {
                            net.one97.paytm.contacts.entities.beans.Response responseObject3 = contactBeneficiaryBean.getResponseObject();
                            k.a((Object) responseObject3, "response.responseObject");
                            if (responseObject3.getContacts().size() >= 4) {
                                net.one97.paytm.contacts.entities.beans.Response responseObject4 = contactBeneficiaryBean.getResponseObject();
                                k.a((Object) responseObject4, "response.responseObject");
                                Iterator<ContactsResponse> it2 = responseObject4.getContacts().iterator();
                                while (it2.hasNext()) {
                                    ContactsResponse next = it2.next();
                                    if (i2 >= 3) {
                                        break;
                                    }
                                    i2++;
                                    arrayList.add(next);
                                }
                                p.a aVar2 = p.Companion;
                                this.f54824a.resumeWith(p.m530constructorimpl(arrayList));
                                return;
                            }
                            net.one97.paytm.contacts.entities.beans.Response responseObject5 = contactBeneficiaryBean.getResponseObject();
                            k.a((Object) responseObject5, "response.responseObject");
                            ArrayList<ContactsResponse> contacts = responseObject5.getContacts();
                            p.a aVar3 = p.Companion;
                            this.f54824a.resumeWith(p.m530constructorimpl(contacts));
                            return;
                        }
                    }
                }
            }
            p.a aVar4 = p.Companion;
            this.f54824a.resumeWith(p.m530constructorimpl(arrayList));
        }
    }

    public d(Context context) {
        k.c(context, "context");
        this.f54823a = context;
    }

    static final class b implements Response.ErrorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f54826a;

        b(CancellableContinuation cancellableContinuation) {
            this.f54826a = cancellableContinuation;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            p.a aVar = p.Companion;
            this.f54826a.resumeWith(p.m530constructorimpl((Object) null));
        }
    }

    public final Object a(kotlin.d.d<? super ArrayList<ContactsResponse>> dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.d.a.b.a(dVar), 1);
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        if (com.paytm.utility.a.m(this.f54823a)) {
            h.a(this.f54823a, new a(cancellableContinuation, this), new b(cancellableContinuation));
        } else {
            p.a aVar = p.Companion;
            cancellableContinuation.resumeWith(p.m530constructorimpl((Object) null));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return result;
    }
}
