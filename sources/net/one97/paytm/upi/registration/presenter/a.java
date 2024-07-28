package net.one97.paytm.upi.registration.presenter;

import android.text.TextUtils;
import androidx.core.g.f;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.registration.a.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;

public final class a implements a.C1387a, a.C1389a {

    /* renamed from: a  reason: collision with root package name */
    a.b f68593a;

    /* renamed from: b  reason: collision with root package name */
    b f68594b;

    /* renamed from: c  reason: collision with root package name */
    List<UpiBaseDataModel> f68595c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    String f68596d;

    /* renamed from: e  reason: collision with root package name */
    private List<AccountProviderBody.AccountProvider> f68597e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final String f68598f = "AccountProviderPresenter";

    /* renamed from: g  reason: collision with root package name */
    private boolean f68599g = true;

    public a(b bVar, a.b bVar2) {
        this.f68594b = (b) f.a(bVar, "accountProviderRepo cannot be null");
        this.f68593a = (a.b) f.a(bVar2, "accountProvider cannot be null!");
        this.f68596d = this.f68593a.getClass().getSimpleName();
        this.f68593a.a(this);
    }

    public a(b bVar, a.b bVar2, byte b2) {
        this.f68594b = (b) f.a(bVar, "accountProviderRepo cannot be null");
        this.f68593a = (a.b) f.a(bVar2, "accountProvider cannot be null!");
        this.f68593a.a(this);
        this.f68599g = false;
    }

    public final void e() {
        if (this.f68599g) {
            a();
        }
    }

    public final void a() {
        if (this.f68593a.c()) {
            this.f68593a.a();
            b();
        }
    }

    public final void a(String str) {
        List<UpiBaseDataModel> list = this.f68595c;
        if (list != null && list.size() != 0) {
            if (TextUtils.isEmpty(str)) {
                this.f68593a.a(this.f68595c);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (UpiBaseDataModel next : this.f68595c) {
                if ((next instanceof AccountProviderBody.AccountProvider) && ((AccountProviderBody.AccountProvider) next).getAccountProvider().toLowerCase().contains(str)) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                this.f68593a.a((List<UpiBaseDataModel>) arrayList);
            } else {
                this.f68593a.b();
            }
        }
    }

    public final void a(List<UpiBaseDataModel> list) {
        this.f68595c = list;
        this.f68593a.a(list);
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        a.b bVar = this.f68593a;
        if (bVar != null) {
            if (upiBaseDataModel instanceof AccountProviderBody.AccountProviderDetails) {
                AccountProviderBody.AccountProviderDetails accountProviderDetails = (AccountProviderBody.AccountProviderDetails) upiBaseDataModel;
                if (accountProviderDetails != null) {
                    final List<AccountProviderBody.AccountProvider> providers = accountProviderDetails.getProviders();
                    List<AccountProviderBody.AccountProvider> topProviders = accountProviderDetails.getTopProviders();
                    if (providers != null && providers.size() > 0) {
                        List<UpiBaseDataModel> list = this.f68595c;
                        if (list == null || list.size() == 0) {
                            b(accountProviderDetails.getProviders());
                            c(accountProviderDetails.getProviders());
                        } else {
                            y.a(new Callable<List<AccountProviderBody.AccountProvider>>() {
                                public final /* synthetic */ Object call() throws Exception {
                                    Map<String, AccountProviderBody.AccountProvider> l = a.this.f68594b.l();
                                    ArrayList arrayList = new ArrayList();
                                    for (AccountProviderBody.AccountProvider accountProvider : providers) {
                                        if (!l.containsKey(accountProvider.getIfsc())) {
                                            arrayList.add(accountProvider);
                                        }
                                    }
                                    a.this.c(arrayList);
                                    return arrayList;
                                }
                            }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new aa<List<AccountProviderBody.AccountProvider>>() {
                                public final void onError(Throwable th) {
                                }

                                public final void onSubscribe(c cVar) {
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    List list = (List) obj;
                                    if (a.a(a.this) && list != null && list.size() > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.addAll(list);
                                        a.this.f68593a.c(arrayList);
                                    }
                                }
                            });
                        }
                    }
                    if (topProviders != null && topProviders.size() > 0) {
                        this.f68597e.clear();
                        this.f68597e.addAll(topProviders);
                        this.f68593a.b(this.f68597e);
                        return;
                    }
                    return;
                }
                bVar.b();
                return;
            }
            bVar.a((UpiCustomVolleyError) null);
        }
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        a.b bVar = this.f68593a;
        if (bVar != null) {
            bVar.a(upiCustomVolleyError);
        }
    }

    public final void f() {
        this.f68593a = null;
        this.f68594b.c("AccountProviderPresenter");
    }

    private void b() {
        y.a(new Callable<List<AccountProviderBody.AccountProvider>>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public List<AccountProviderBody.AccountProvider> call() {
                try {
                    return a.this.f68594b.k();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new aa<List<AccountProviderBody.AccountProvider>>() {
            public final void onSubscribe(c cVar) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (list != null && list.size() > 0) {
                    a.this.b(list);
                }
                b bVar = a.this.f68594b;
                a aVar = a.this;
                bVar.a((a.C1389a) aVar, "AccountProviderPresenter", aVar.f68596d);
            }

            public final void onError(Throwable th) {
                th.printStackTrace();
                if (a.a(a.this)) {
                    a.this.f68593a.a((UpiCustomVolleyError) null);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void b(final List<AccountProviderBody.AccountProvider> list) {
        y.a(new Callable<List<UpiBaseDataModel>>() {
            public final /* synthetic */ Object call() throws Exception {
                a.this.f68595c.clear();
                for (AccountProviderBody.AccountProvider add : list) {
                    a.this.f68595c.add(add);
                }
                return a.this.f68595c;
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new aa<List<UpiBaseDataModel>>() {
            public final void onSubscribe(c cVar) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (!a.a(a.this)) {
                    return;
                }
                if (list != null || list.size() > 0) {
                    a.this.f68593a.a((List<UpiBaseDataModel>) list);
                }
            }

            public final void onError(Throwable th) {
                th.printStackTrace();
                if (a.a(a.this)) {
                    a.this.f68593a.a((UpiCustomVolleyError) null);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void c(final List<AccountProviderBody.AccountProvider> list) {
        y.a(new Callable<Object>() {
            public final Object call() {
                a.this.f68594b.a((List<AccountProviderBody.AccountProvider>) list);
                return list;
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new aa<Object>() {
            public final void onError(Throwable th) {
            }

            public final void onSubscribe(c cVar) {
            }

            public final void onSuccess(Object obj) {
            }
        });
    }

    public final void a(int i2) {
        this.f68593a.a(this.f68597e.get(i2));
    }

    static /* synthetic */ boolean a(a aVar) {
        return aVar.f68593a != null;
    }
}
