package net.one97.paytm.paymentsBank.slfd.nominee.b;

import android.text.TextUtils;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeListModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.nominee.a.a;
import net.one97.paytm.paymentsBank.slfd.nominee.view.a;

public final class a implements g.a, g.b<IJRPaytmDataModel>, a.C0337a {

    /* renamed from: a  reason: collision with root package name */
    private final a.b f19229a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19230b;

    /* renamed from: c  reason: collision with root package name */
    private final b f19231c;

    /* renamed from: d  reason: collision with root package name */
    private final SlfdNomineeListModel f19232d;

    private a(a.b bVar, int i2, b bVar2, SlfdNomineeListModel slfdNomineeListModel) {
        k.c(bVar, "slfdNomineeView");
        k.c(bVar2, "slfdRepository");
        k.c(slfdNomineeListModel, "slfdNomineeList");
        this.f19229a = bVar;
        this.f19230b = i2;
        this.f19231c = bVar2;
        this.f19232d = slfdNomineeListModel;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        this.f19229a.a(false);
        if (iJRPaytmDataModel instanceof SlfdNomineeListModel) {
            ArrayList<SlfdNomineeModel> nomineeList = this.f19232d.getNomineeList();
            if (nomineeList == null) {
                k.a();
            }
            nomineeList.clear();
            this.f19229a.a();
            ArrayList<SlfdNomineeModel> nomineeList2 = this.f19232d.getNomineeList();
            if (nomineeList2 == null) {
                k.a();
            }
            ArrayList<SlfdNomineeModel> nomineeList3 = ((SlfdNomineeListModel) iJRPaytmDataModel).getNomineeList();
            if (nomineeList3 == null) {
                k.a();
            }
            nomineeList2.addAll(nomineeList3);
            this.f19229a.a();
        }
    }

    public /* synthetic */ a(a.b bVar, int i2, b bVar2) {
        this(bVar, i2, bVar2, new SlfdNomineeListModel());
    }

    public final void a() {
        this.f19229a.a(true);
        this.f19231c.c(this, this);
    }

    public final void b() {
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }

    public final int c() {
        if (this.f19232d.getNomineeList() == null) {
            return 0;
        }
        ArrayList<SlfdNomineeModel> nomineeList = this.f19232d.getNomineeList();
        if (nomineeList == null) {
            k.a();
        }
        return nomineeList.size();
    }

    public final void a(int i2) {
        a.b bVar = this.f19229a;
        ArrayList<SlfdNomineeModel> nomineeList = this.f19232d.getNomineeList();
        if (nomineeList == null) {
            k.a();
        }
        SlfdNomineeModel slfdNomineeModel = nomineeList.get(i2);
        k.a((Object) slfdNomineeModel, "slfdNomineeList.nomineeL…t!!.get(selectedPosition)");
        bVar.a(slfdNomineeModel, i2);
    }

    public final void a(a.C0338a aVar, int i2) {
        String str;
        ArrayList<SlfdNomineeModel> nomineeList = this.f19232d.getNomineeList();
        if (nomineeList == null) {
            k.a();
        }
        SlfdNomineeModel slfdNomineeModel = nomineeList.get(i2);
        k.a((Object) slfdNomineeModel, "slfdNomineeList.nomineeList!!.get(position)");
        SlfdNomineeModel slfdNomineeModel2 = slfdNomineeModel;
        if (aVar != null) {
            String name = slfdNomineeModel2.getName();
            if (name == null) {
                name = "";
            }
            k.c(name, "name");
            aVar.f19244b.setText(name);
            String relationship = slfdNomineeModel2.getRelationship();
            if (relationship == null) {
                relationship = "";
            }
            k.c(relationship, "relationship");
            aVar.f19245c.setText(relationship);
            if (!TextUtils.isEmpty(slfdNomineeModel2.getHouseNo())) {
                str = "" + slfdNomineeModel2.getHouseNo();
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(slfdNomineeModel2.getStreetName())) {
                str = str + ", " + slfdNomineeModel2.getStreetName();
            }
            if (!TextUtils.isEmpty(slfdNomineeModel2.getAreaName())) {
                str = str + ", " + slfdNomineeModel2.getAreaName();
            }
            if (!TextUtils.isEmpty(slfdNomineeModel2.getCity())) {
                str = str + StringUtility.NEW_LINE + slfdNomineeModel2.getCity();
            }
            if (!TextUtils.isEmpty(slfdNomineeModel2.getState())) {
                str = str + ", " + slfdNomineeModel2.getState();
            }
            if (!TextUtils.isEmpty(slfdNomineeModel2.getPincode())) {
                str = str + " - " + slfdNomineeModel2.getPincode();
            }
            k.c(str, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            aVar.f19246d.setText(str);
            k.c("", "contactNo");
            if (!TextUtils.isEmpty(r2)) {
                aVar.f19247e.setText(r2);
                aVar.f19247e.setVisibility(0);
            } else {
                aVar.f19247e.setVisibility(8);
            }
            aVar.itemView.setOnClickListener(new a.C0338a.C0339a(aVar, i2));
            aVar.f19243a.setOnClickListener(new a.C0338a.b(aVar, i2));
            aVar.a(slfdNomineeModel2.isSelected());
            int i3 = this.f19230b;
            if (i3 != -1 && i2 == i3) {
                aVar.a(true);
            }
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        String str2;
        this.f19229a.a(false);
        a.b bVar = this.f19229a;
        if (networkCustomError == null || (str = networkCustomError.getAlertTitle()) == null) {
            str = "Error";
        }
        if (networkCustomError == null || (str2 = networkCustomError.getAlertMessage()) == null) {
            str2 = "Some error occurred";
        }
        bVar.a(str, str2);
    }
}
