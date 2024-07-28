package net.one97.paytm.contacts.sync;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.contacts.entities.beans.ContactBeneficiaryBean;
import net.one97.paytm.contacts.entities.beans.Response;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.utils.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    x.e f50160a;

    /* renamed from: b  reason: collision with root package name */
    int f50161b;

    /* renamed from: c  reason: collision with root package name */
    private Context f50162c;

    /* renamed from: d  reason: collision with root package name */
    private int f50163d;

    /* renamed from: e  reason: collision with root package name */
    private int f50164e = 20;

    /* renamed from: net.one97.paytm.contacts.sync.b$b  reason: collision with other inner class name */
    static final class C0900b<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f50170a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f50171b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f50172c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f50173d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f50174e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f50175f;

        C0900b(b bVar, Context context, int i2, int i3, int i4, long j) {
            this.f50170a = bVar;
            this.f50171b = context;
            this.f50172c = i2;
            this.f50173d = i3;
            this.f50174e = i4;
            this.f50175f = j;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            f fVar = (f) obj;
            if (fVar.f55796a == h.SUCCESS) {
                if (fVar.f55797b instanceof ContactBeneficiaryBean) {
                    final x.e eVar = new x.e();
                    eVar.element = (ContactBeneficiaryBean) fVar.f55797b;
                    if (((ContactBeneficiaryBean) eVar.element) != null && ((ContactBeneficiaryBean) eVar.element).isSuccess()) {
                        Response responseObject = ((ContactBeneficiaryBean) eVar.element).getResponseObject();
                        k.a((Object) responseObject, "contactBeneficiaryBean.responseObject");
                        Collection contacts = responseObject.getContacts();
                        if (!(contacts == null || contacts.isEmpty())) {
                            Response responseObject2 = ((ContactBeneficiaryBean) eVar.element).getResponseObject();
                            k.a((Object) responseObject2, "contactBeneficiaryBean.responseObject");
                            if (responseObject2.getTotalCount() > 0) {
                                net.one97.paytm.contacts.utils.a aVar = net.one97.paytm.contacts.utils.a.f50219b;
                                net.one97.paytm.contacts.utils.a.a(this.f50171b, (ContactBeneficiaryBean) eVar.element, (e.f) new e.f(this) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ C0900b f50176a;

                                    {
                                        this.f50176a = r1;
                                    }

                                    public final void a() {
                                        int i2 = this.f50176a.f50172c + this.f50176a.f50173d;
                                        Response responseObject = ((ContactBeneficiaryBean) eVar.element).getResponseObject();
                                        k.a((Object) responseObject, "contactBeneficiaryBean.responseObject");
                                        if (i2 <= responseObject.getTotalCount()) {
                                            b.a(this.f50176a.f50170a, this.f50176a.f50171b, this.f50176a.f50174e, this.f50176a.f50172c, this.f50176a.f50172c + this.f50176a.f50173d, this.f50176a.f50175f);
                                        } else if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f50176a.f50171b, "isContactSyncEnableV2", true)) {
                                            if (this.f50176a.f50174e == e.b.TRANSFER_BENEFICIARY.getType()) {
                                                this.f50176a.f50170a.f50160a.b(e.h.TRANSFER_BEN_CALL_DONE, this.f50176a.f50171b, this.f50176a.f50170a.f50161b);
                                            } else if (this.f50176a.f50174e == e.b.PHONEBOOK.getType()) {
                                                this.f50176a.f50170a.f50160a.b(e.h.GET_PHONE_BOOK_CALL_DONE, this.f50176a.f50171b, this.f50176a.f50170a.f50161b);
                                            }
                                        } else if (this.f50176a.f50174e == e.b.TRANSFER_BENEFICIARY.getType()) {
                                            this.f50176a.f50170a.f50160a.b(e.h.ABORT, this.f50176a.f50171b, this.f50176a.f50170a.f50161b);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                    }
                    if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f50171b, "isContactSyncEnableV2", true)) {
                        if (this.f50174e == e.b.TRANSFER_BENEFICIARY.getType()) {
                            this.f50170a.f50160a.b(e.h.TRANSFER_BEN_CALL_DONE, this.f50171b, this.f50170a.f50161b);
                        } else if (this.f50174e == e.b.PHONEBOOK.getType()) {
                            this.f50170a.f50160a.b(e.h.GET_PHONE_BOOK_CALL_DONE, this.f50171b, this.f50170a.f50161b);
                        }
                    } else if (this.f50174e == e.b.TRANSFER_BENEFICIARY.getType()) {
                        this.f50170a.f50160a.b(e.h.ABORT, this.f50171b, this.f50170a.f50161b);
                    }
                }
            } else if (fVar.f55796a != h.ERROR) {
            } else {
                if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f50171b, "isContactSyncEnableV2", true)) {
                    if (this.f50174e == e.b.TRANSFER_BENEFICIARY.getType()) {
                        this.f50170a.f50160a.b(e.h.TRANSFER_BEN_CALL_DONE, this.f50171b, this.f50170a.f50161b);
                    } else if (this.f50174e == e.b.PHONEBOOK.getType()) {
                        this.f50170a.f50160a.b(e.h.GET_PHONE_BOOK_CALL_DONE, this.f50171b, this.f50170a.f50161b);
                    }
                } else if (this.f50174e == e.b.TRANSFER_BENEFICIARY.getType()) {
                    this.f50170a.f50160a.b(e.h.ABORT, this.f50171b, this.f50170a.f50161b);
                }
            }
        }
    }

    public b(Context context, x.e eVar, int i2, int i3) {
        k.c(context, "context");
        k.c(eVar, "listener");
        this.f50160a = eVar;
        this.f50162c = context;
        this.f50163d = i2;
        this.f50161b = i3;
    }

    public final void a() {
        if (com.paytm.utility.b.r(this.f50162c)) {
            Context context = this.f50162c;
            int i2 = this.f50163d;
            int i3 = this.f50164e;
            net.one97.paytm.contacts.utils.a aVar = net.one97.paytm.contacts.utils.a.f50219b;
            net.one97.paytm.contacts.utils.a.a(context, i2, (x.b) new a(this, context, i2, i3));
            return;
        }
        this.f50160a.b(e.h.ABORT, this.f50162c, this.f50161b);
    }

    public static final class a implements x.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f50165a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f50166b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f50167c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f50168d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f50169e = 0;

        /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, net.one97.paytm.contacts.sync.b] */
        /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, int] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        a(android.content.Context r1, int r2, int r3, int r4) {
            /*
                r0 = this;
                r0.f50165a = r1
                r0.f50166b = r2
                r0.f50167c = r3
                r0.f50168d = r4
                r1 = 0
                r0.f50169e = r1
                r0.<init>()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.sync.b.a.<init>(net.one97.paytm.contacts.sync.b, android.content.Context, int, int):void");
        }

        public final void a(long j) {
            b.a(this.f50165a, this.f50166b, this.f50167c, this.f50168d, this.f50169e, j);
        }
    }

    public static final /* synthetic */ void a(b bVar, Context context, int i2, int i3, int i4, long j) {
        String str;
        b bVar2 = bVar;
        Context context2 = context;
        int i5 = i2;
        if (!com.paytm.utility.b.r(bVar2.f50162c) || !com.paytm.utility.b.c(context)) {
            bVar2.f50160a.b(e.h.ABORT, context, bVar2.f50161b);
            return;
        }
        if (i5 == e.b.TRANSFER_BENEFICIARY.getType()) {
            str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "beneficiariesSearchUrl_V2");
            k.a((Object) str, "WalletCommManager.getWal…neficiariesSearchUrl_V2\")");
        } else {
            str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "contactsSearchUrl_V2");
            k.a((Object) str, "WalletCommManager.getWal…, \"contactsSearchUrl_V2\")");
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            if (i5 == e.b.TRANSFER_BENEFICIARY.getType()) {
                bVar2.f50160a.b(e.h.TRANSFER_BEN_CALL_DONE, context, bVar2.f50161b);
            } else if (i5 == e.b.PHONEBOOK.getType()) {
                bVar2.f50160a.b(e.h.GET_PHONE_BOOK_CALL_DONE, context, bVar2.f50161b);
            }
        } else if (i5 != e.b.PHONEBOOK.getType() || Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a(context, "android.permission.READ_CONTACTS") == 0) {
            a aVar = a.f50159a;
            LiveData<f> a2 = a.a(context, str2, i4, i3, i2, j);
            if (a2 != null) {
                a2.observeForever(new C0900b(bVar, context, i3, i4, i2, j));
            }
        } else if (i5 == e.b.TRANSFER_BENEFICIARY.getType()) {
            bVar2.f50160a.b(e.h.TRANSFER_BEN_CALL_DONE, context, bVar2.f50161b);
        } else if (i5 == e.b.PHONEBOOK.getType()) {
            bVar2.f50160a.b(e.h.GET_PHONE_BOOK_CALL_DONE, context, bVar2.f50161b);
        }
    }
}
