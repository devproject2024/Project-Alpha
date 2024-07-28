package net.one97.paytm.bankOpen.ica.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.ica.b.i;
import net.one97.paytm.bankOpen.ica.b.l;
import net.one97.paytm.bankOpen.ica.b.m;
import net.one97.paytm.bankOpen.ica.c.a;
import net.one97.paytm.bankOpen.ica.model.ICAUpdateLeadResponse;

public final class ICAAccountOpeningActivity extends PBBaseActivity implements d {

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.bankOpen.d.a f16453b;

    static final class b<T> implements z<c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ICAAccountOpeningActivity f16455a;

        b(ICAAccountOpeningActivity iCAAccountOpeningActivity) {
            this.f16455a = iCAAccountOpeningActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            c cVar = (c) obj;
            ICAAccountOpeningActivity iCAAccountOpeningActivity = this.f16455a;
            net.one97.paytm.bankOpen.d.a aVar = iCAAccountOpeningActivity.f16453b;
            if (aVar == null) {
                k.a("lottieAnimationLoaderDialog");
            }
            if (aVar != null) {
                net.one97.paytm.bankOpen.d.a aVar2 = iCAAccountOpeningActivity.f16453b;
                if (aVar2 == null) {
                    k.a("lottieAnimationLoaderDialog");
                }
                aVar2.b();
            }
            if (cVar != null) {
                boolean z = false;
                if (cVar == null) {
                    return;
                }
                if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                    T t = cVar.f16217b;
                    if (t != null) {
                        ICAUpdateLeadResponse iCAUpdateLeadResponse = (ICAUpdateLeadResponse) t;
                        Iterator<String> it2 = iCAUpdateLeadResponse.getEntityToSolutionsMap().getINDIVIDUAL().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().equals("limited_ca")) {
                                    z = true;
                                    this.f16455a.getSupportFragmentManager().a().b(R.id.container, new m()).c();
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (!z && !TextUtils.isEmpty(iCAUpdateLeadResponse.getMessage())) {
                            ICAAccountOpeningActivity iCAAccountOpeningActivity2 = this.f16455a;
                            g.b(iCAAccountOpeningActivity2, iCAAccountOpeningActivity2.getString(R.string.error), iCAUpdateLeadResponse.getMessage(), AnonymousClass1.f16456a);
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.ICAUpdateLeadResponse");
                } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.ERROR) {
                    Throwable th = cVar.f16218c;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        f.a((Context) this.f16455a, networkCustomError, networkCustomError.getStatusCode());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            }
        }
    }

    public final void onFragmentAction(int i2, Object obj) {
        q b2;
        if (i2 == 100) {
            a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if (a.C0240a.a() != null) {
                if (obj != null) {
                    net.one97.paytm.bankOpen.ica.c.a.b((String) obj);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            getSupportFragmentManager().a().b(R.id.container, new net.one97.paytm.bankOpen.ica.b.f()).c();
        } else if (i2 == 101) {
            if (obj != null) {
                NomineeModel nomineeModel = (NomineeModel) obj;
                a.C0240a aVar2 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
                if (a.C0240a.a() != null) {
                    net.one97.paytm.bankOpen.ica.c.a.a(nomineeModel);
                }
                e();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.model.NomineeModel");
        } else if (i2 == 102) {
            a.C0240a aVar3 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if (a.C0240a.a() != null) {
                net.one97.paytm.bankOpen.ica.c.a.a((NomineeModel) null);
            }
            e();
        } else if (i2 == 105) {
            getSupportFragmentManager().a().b(R.id.container, new l()).c();
        } else if (i2 == 106) {
            net.one97.paytm.bankOpen.ica.b.c cVar = new net.one97.paytm.bankOpen.ica.b.c();
            Bundle bundle = new Bundle();
            if (obj != null) {
                bundle.putSerializable("NOMINEE_ITEM", (NomineeModel) obj);
            }
            cVar.setArguments(bundle);
            getSupportFragmentManager().a().b(R.id.container, cVar).a((String) null).c();
        } else if (i2 == 107) {
            a.C0240a aVar4 = net.one97.paytm.bankOpen.ica.c.a.f16577a;
            if (a.C0240a.a() == null) {
                k.a();
            }
            if (net.one97.paytm.bankOpen.ica.c.a.d() == null) {
                net.one97.paytm.bankOpen.ica.b.c cVar2 = new net.one97.paytm.bankOpen.ica.b.c();
                Bundle bundle2 = new Bundle();
                if (obj != null) {
                    bundle2.putSerializable("NOMINEE_ITEM", (NomineeModel) obj);
                }
                cVar2.setArguments(bundle2);
                j supportFragmentManager = getSupportFragmentManager();
                if (supportFragmentManager != null && (b2 = supportFragmentManager.a().b(R.id.container, cVar2)) != null) {
                    b2.a("bizdetail").c();
                    return;
                }
                return;
            }
            e();
        } else if (i2 == 108) {
            if (obj != null) {
                String str = (String) obj;
                if (str.equals("NOT_APPLIED") || str.equals("LEAD") || str.equals("TRACK")) {
                    a(str);
                } else if (str.equals("NOT_ALLOWED")) {
                    g.b(this, getString(R.string.error), getString(R.string.pb_ca_ica_not_allowed), new a(this));
                } else if (str.equals("ACTIVE")) {
                    finish();
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.String");
            }
        } else if (i2 == 109) {
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("edit", true);
            net.one97.paytm.bankOpen.ica.b.f fVar = new net.one97.paytm.bankOpen.ica.b.f();
            fVar.setArguments(bundle3);
            getSupportFragmentManager().a().b(R.id.container, fVar).a((String) null).c();
        } else if (i2 == 110) {
            net.one97.paytm.bankOpen.d.a aVar5 = this.f16453b;
            if (aVar5 == null) {
                k.a("lottieAnimationLoaderDialog");
            }
            if (aVar5 != null) {
                net.one97.paytm.bankOpen.d.a aVar6 = this.f16453b;
                if (aVar6 == null) {
                    k.a("lottieAnimationLoaderDialog");
                }
                aVar6.a(getString(R.string.please_wait_progress_msg));
                net.one97.paytm.bankOpen.d.a aVar7 = this.f16453b;
                if (aVar7 == null) {
                    k.a("lottieAnimationLoaderDialog");
                }
                aVar7.a();
            }
            k.a((Object) am.a((FragmentActivity) this).a(net.one97.paytm.bankOpen.ica.d.d.class), "ViewModelProviders.of(th…iewViewModel::class.java)");
            net.one97.paytm.bankOpen.ica.d.d.a().observe(this, new b(this));
        }
    }

    static final class a implements g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ICAAccountOpeningActivity f16454a;

        a(ICAAccountOpeningActivity iCAAccountOpeningActivity) {
            this.f16454a = iCAAccountOpeningActivity;
        }

        public final void onDialogDismissed() {
            this.f16454a.finish();
        }
    }

    private final void e() {
        if (!net.one97.paytm.bankCommon.h.b.a(this)) {
            getSupportFragmentManager().a().b(R.id.container, new net.one97.paytm.bankOpen.ica.b.k()).c();
            return;
        }
        getSupportFragmentManager().a().b(R.id.container, new l()).c();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_ca_acc_open_activity);
        this.f16453b = new net.one97.paytm.bankOpen.d.a(this);
        String stringExtra = getIntent().getStringExtra("icastatus");
        a.C0240a aVar = net.one97.paytm.bankOpen.ica.c.a.f16577a;
        if (a.C0240a.a() == null) {
            k.a();
        }
        net.one97.paytm.bankOpen.ica.c.a.a();
        CharSequence charSequence = stringExtra;
        if (!(charSequence == null || p.a(charSequence))) {
            a(stringExtra);
        } else {
            getSupportFragmentManager().a().b(R.id.container, new i()).c();
        }
    }

    private void a(String str) {
        Fragment fragment;
        k.c(str, "icaStatus");
        if (str.equals("LEAD")) {
            fragment = new net.one97.paytm.bankOpen.ica.b.f();
        } else if (str.equals("NOT_APPLIED")) {
            fragment = new net.one97.paytm.bankOpen.ica.b.j();
        } else {
            fragment = str.equals("TRACK") ? new m() : null;
        }
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.container;
        if (fragment != null) {
            a2.b(i2, fragment).c();
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.fragment.app.Fragment");
    }
}
