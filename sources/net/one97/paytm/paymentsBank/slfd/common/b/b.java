package net.one97.paytm.paymentsBank.slfd.common.b;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.common.a.b;
import net.one97.paytm.paymentsBank.slfd.common.view.b;
import net.one97.paytm.paymentsBank.slfd.common.view.d;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDInterestRateListModel;
import net.one97.paytm.paymentsBank.slfd.model.a;
import net.one97.paytm.paymentsBank.utils.j;

public final class b implements g.a, g.b<IJRPaytmDataModel>, b.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f18966a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final net.one97.paytm.paymentsBank.slfd.a.a.b f18967b;

    /* renamed from: c  reason: collision with root package name */
    private final d f18968c;

    /* renamed from: d  reason: collision with root package name */
    private final b.C0329b f18969d;

    public b(net.one97.paytm.paymentsBank.slfd.a.a.b bVar, d dVar, b.C0329b bVar2) {
        k.c(bVar, "slfdRepository");
        k.c(dVar, "context");
        k.c(bVar2, "slfdtableListView");
        this.f18967b = bVar;
        this.f18968c = dVar;
        this.f18969d = bVar2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        List<FDInterestRateListModel.a> list;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof FDInterestRateListModel) {
            try {
                this.f18969d.a(false);
                b.C0329b bVar = this.f18969d;
                String effectiveDate = ((FDInterestRateListModel) iJRPaytmDataModel).getEffectiveDate();
                k.a((Object) effectiveDate, "response.effectiveDate");
                bVar.a(effectiveDate);
                List<FDInterestRateListModel.a> fdInterestRateList = ((FDInterestRateListModel) iJRPaytmDataModel).getFdInterestRateList();
                k.a((Object) fdInterestRateList, "response.fdInterestRateList");
                Iterable iterable = fdInterestRateList;
                k.d(iterable, "$this$reversed");
                if (!(iterable instanceof Collection) || ((Collection) iterable).size() > 1) {
                    list = kotlin.a.k.f(iterable);
                    k.d(list, "$this$reverse");
                    Collections.reverse(list);
                } else {
                    list = kotlin.a.k.e(iterable);
                }
                for (FDInterestRateListModel.a aVar : list) {
                    ArrayList<a> arrayList = this.f18966a;
                    k.a((Object) aVar, "item");
                    arrayList.add(new a(aVar.a(), aVar.b()));
                }
                if (this.f18966a.size() == 0) {
                    this.f18969d.a();
                    return;
                }
                ArrayList<a> arrayList2 = this.f18966a;
                FragmentActivity activity = this.f18968c.getActivity();
                String str = null;
                String string = activity != null ? activity.getString(R.string.fd_it_table_duration) : null;
                if (string == null) {
                    k.a();
                }
                FragmentActivity activity2 = this.f18968c.getActivity();
                if (activity2 != null) {
                    str = activity2.getString(R.string.fd_it_table_rate);
                }
                if (str == null) {
                    k.a();
                }
                arrayList2.add(0, new a(string, str));
                this.f18969d.b();
            } catch (Exception e2) {
                this.f18969d.a();
                e2.printStackTrace();
            }
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            this.f18969d.a(false);
            this.f18969d.a();
            f.a((Activity) this.f18968c.getActivity(), (Exception) networkCustomError, (String) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final int c() {
        return this.f18966a.size();
    }

    public final void a(b.a aVar, int i2) {
        a aVar2 = this.f18966a.get(i2);
        k.a((Object) aVar2, "itTableList.get(position)");
        a aVar3 = aVar2;
        if (aVar != null) {
            String b2 = aVar3.b();
            k.a((Object) b2, "rowValue.interest");
            k.c(b2, "amount");
            aVar.f19004b.setText(b2);
        }
        if (aVar != null) {
            String a2 = aVar3.a();
            k.a((Object) a2, "rowValue.duration");
            k.c(a2, "title");
            aVar.f19003a.setText(a2);
        }
        if (aVar != null) {
            try {
                if (i2 % 2 == 0) {
                    aVar.f19005c.setBackgroundColor(net.one97.paytm.paymentsBank.slfd.common.view.b.this.f19001a.getResources().getColor(R.color.pale_grey));
                } else {
                    aVar.f19005c.setBackgroundColor(net.one97.paytm.paymentsBank.slfd.common.view.b.this.f19001a.getResources().getColor(R.color.white));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (aVar == null) {
            return;
        }
        if (i2 == 0) {
            try {
                aVar.f19003a.setTextColor(net.one97.paytm.paymentsBank.slfd.common.view.b.this.f19001a.getResources().getColor(R.color.gray));
                aVar.f19004b.setTextColor(net.one97.paytm.paymentsBank.slfd.common.view.b.this.f19001a.getResources().getColor(R.color.gray));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else {
            aVar.f19003a.setTextColor(net.one97.paytm.paymentsBank.slfd.common.view.b.this.f19001a.getResources().getColor(R.color.color_222222));
            aVar.f19004b.setTextColor(net.one97.paytm.paymentsBank.slfd.common.view.b.this.f19001a.getResources().getColor(R.color.color_222222));
        }
    }

    public final void a() {
        if (com.paytm.utility.b.c((Context) this.f18968c.getActivity())) {
            this.f18969d.a(true);
            net.one97.paytm.paymentsBank.slfd.interestprojection.d.a a2 = net.one97.paytm.paymentsBank.slfd.interestprojection.d.a.a(this.f18968c.getActivity());
            k.a((Object) a2, "InterestProjectionManage…nstance(context.activity)");
            a2.a(j.a().equals("ICA") ? "ica" : "isa", this, this);
            return;
        }
        try {
            net.one97.paytm.paymentsBank.fragment.k a3 = net.one97.paytm.paymentsBank.fragment.k.a();
            FragmentActivity activity = this.f18968c.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "context.activity!!");
            a3.show(activity.getSupportFragmentManager().a(), "dialog");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        b.a aVar = net.one97.paytm.paymentsBank.slfd.a.a.b.f18944a;
        net.one97.paytm.paymentsBank.slfd.a.a.b.f18945d = null;
    }
}
