package net.one97.paytm.wallet.splitbill.activity;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.c.h;
import net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse.SBBillDetailResponse;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBUserList;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;
import net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse.SBGroupDetailsDtoList;

public class SBEnterBillActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71971a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71972b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71973c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private String f71974d;

    /* renamed from: e  reason: collision with root package name */
    private SBGroupDetailsDtoList f71975e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f71976f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f71977g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f71978h = false;

    /* renamed from: i  reason: collision with root package name */
    private SBBillDetailResponse f71979i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private h p;

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        super.onCreate(bundle);
        setContentView(R.layout.sb_activity_enter_bill);
        getWindow().setSoftInputMode(20);
        String str4 = "amount_from_deeplink";
        String str5 = "your_id";
        if (getIntent() != null) {
            if (getIntent().hasExtra("list")) {
                this.f71971a = (ArrayList) getIntent().getSerializableExtra("list");
            }
            if (getIntent().hasExtra("group_name")) {
                this.f71974d = getIntent().getStringExtra("group_name");
            }
            if (getIntent().hasExtra("group_detail")) {
                this.f71975e = (SBGroupDetailsDtoList) getIntent().getSerializableExtra("group_detail");
            }
            if (getIntent().hasExtra("paid_contact_list")) {
                this.f71972b = (ArrayList) getIntent().getSerializableExtra("paid_contact_list");
            }
            if (getIntent().hasExtra("split_contact_list")) {
                this.f71973c = (ArrayList) getIntent().getSerializableExtra("split_contact_list");
            }
            if (getIntent().hasExtra("group_id")) {
                this.j = getIntent().getStringExtra("group_id");
            }
            if (getIntent().hasExtra("edit_bill")) {
                str2 = "group_id";
                this.f71977g = getIntent().getBooleanExtra("edit_bill", false);
            } else {
                str2 = "group_id";
            }
            if (getIntent().hasExtra("is_from_contact_selection")) {
                this.f71978h = getIntent().getBooleanExtra("is_from_contact_selection", false);
            }
            if (getIntent().hasExtra("bill_detail_response")) {
                this.f71979i = (SBBillDetailResponse) getIntent().getSerializableExtra("bill_detail_response");
            }
            if (getIntent().hasExtra("bill_name")) {
                this.l = getIntent().getStringExtra("bill_name");
            }
            if (getIntent().hasExtra("bill_amount")) {
                this.k = getIntent().getStringExtra("bill_amount");
            }
            if (getIntent().hasExtra("equally_switch")) {
                this.f71976f = getIntent().getBooleanExtra("equally_switch", true);
            }
            if (getIntent().hasExtra("bill_id")) {
                this.m = getIntent().getStringExtra("bill_id");
            }
            if (getIntent().hasExtra(str4)) {
                this.n = getIntent().getStringExtra(str4);
            }
            str3 = str5;
            if (getIntent().hasExtra(str3)) {
                this.o = getIntent().getStringExtra(str3);
            }
            ArrayList<SBContactDetail> arrayList = this.f71971a;
            if (arrayList == null || arrayList.size() == 0) {
                str = str4;
                this.f71971a = a(this.f71975e);
            } else if (!this.f71977g) {
                this.f71972b = a(this.f71971a);
                this.f71973c = b(this.f71971a);
                str = str4;
            } else {
                Iterator<SBContactDetail> it2 = this.f71971a.iterator();
                while (it2.hasNext()) {
                    Iterator<SBContactDetail> it3 = it2;
                    SBContactDetail next = it2.next();
                    String str6 = str4;
                    if (!a(this.f71972b, next)) {
                        this.f71972b.add(next);
                    }
                    it2 = it3;
                    str4 = str6;
                }
                str = str4;
                Iterator<SBContactDetail> it4 = this.f71971a.iterator();
                while (it4.hasNext()) {
                    SBContactDetail next2 = it4.next();
                    Iterator<SBContactDetail> it5 = it4;
                    if (!a(this.f71973c, next2)) {
                        this.f71973c.add(next2);
                    }
                    it4 = it5;
                }
            }
            ArrayList<SBContactDetail> arrayList2 = this.f71972b;
            if (arrayList2 == null || arrayList2.size() == 0) {
                this.f71972b = a(this.f71975e);
            }
            ArrayList<SBContactDetail> arrayList3 = this.f71973c;
            if (arrayList3 == null || arrayList3.size() == 0) {
                this.f71973c = a(this.f71975e);
            }
        } else {
            str = str4;
            str2 = "group_id";
            str3 = str5;
        }
        this.p = (h) getSupportFragmentManager().c(h.class.getSimpleName());
        if (this.p == null) {
            this.p = new h();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("list", this.f71971a);
        bundle2.putString("group_name", this.f71974d);
        bundle2.putSerializable("group_detail", this.f71975e);
        bundle2.putSerializable("paid_contact_list", this.f71972b);
        bundle2.putSerializable("split_contact_list", this.f71973c);
        bundle2.putBoolean("equally_switch", this.f71976f);
        bundle2.putString(str2, this.j);
        bundle2.putBoolean("edit_bill", this.f71977g);
        bundle2.putBoolean("is_from_contact_selection", this.f71978h);
        bundle2.putSerializable("bill_detail_response", this.f71979i);
        bundle2.putString("bill_amount", this.k);
        bundle2.putString("bill_name", this.l);
        bundle2.putString("bill_id", this.m);
        bundle2.putString(str3, this.o);
        bundle2.putString(str, this.n);
        this.p.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.activity_sb_enter_bill_frame, this.p, h.class.getSimpleName()).b();
    }

    private static boolean a(ArrayList<SBContactDetail> arrayList, SBContactDetail sBContactDetail) {
        Iterator<SBContactDetail> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().getMobile().equalsIgnoreCase(sBContactDetail.getMobile())) {
                return true;
            }
        }
        return false;
    }

    public void onResume() {
        super.onResume();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1 && intent != null && intent.getExtras() != null) {
            this.f71972b = (ArrayList) intent.getSerializableExtra("paid_contact_list");
            this.f71973c = (ArrayList) intent.getSerializableExtra("split_contact_list");
            this.k = intent.getStringExtra("bill_amount");
            this.f71976f = intent.getBooleanExtra("equally_switch", false);
            this.p.a(this.f71972b, this.f71973c, this.f71976f, this.k);
            h hVar = (h) getSupportFragmentManager().c(h.class.getSimpleName());
            if (hVar == null) {
                hVar = new h();
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("list", this.f71971a);
            bundle.putString("group_name", this.f71974d);
            bundle.putSerializable("group_detail", this.f71975e);
            bundle.putSerializable("paid_contact_list", this.f71972b);
            bundle.putSerializable("split_contact_list", this.f71973c);
            bundle.putBoolean("equally_switch", this.f71976f);
            bundle.putString("group_id", this.j);
            bundle.putBoolean("edit_bill", this.f71977g);
            bundle.putBoolean("is_from_contact_selection", this.f71978h);
            bundle.putSerializable("bill_detail_response", this.f71979i);
            bundle.putString("bill_amount", this.k);
            bundle.putString("bill_name", this.l);
            bundle.putString("bill_id", this.m);
            bundle.putString("your_id", this.o);
            hVar.setArguments(bundle);
            getSupportFragmentManager().a().b(R.id.activity_sb_enter_bill_frame, hVar, h.class.getSimpleName()).c();
        }
    }

    private static ArrayList<SBContactDetail> a(ArrayList<SBContactDetail> arrayList) {
        ArrayList<SBContactDetail> arrayList2 = new ArrayList<>();
        try {
            Iterator<SBContactDetail> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add((SBContactDetail) it2.next().clone());
            }
        } catch (Exception unused) {
        }
        return arrayList2;
    }

    private static ArrayList<SBContactDetail> b(ArrayList<SBContactDetail> arrayList) {
        ArrayList<SBContactDetail> arrayList2 = new ArrayList<>();
        try {
            Iterator<SBContactDetail> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add((SBContactDetail) it2.next().clone());
            }
        } catch (Exception unused) {
        }
        return arrayList2;
    }

    private static ArrayList<SBContactDetail> a(SBGroupDetailsDtoList sBGroupDetailsDtoList) {
        if (sBGroupDetailsDtoList == null) {
            return new ArrayList<>();
        }
        ArrayList<SBContactDetail> arrayList = new ArrayList<>();
        Iterator<SBUserList> it2 = sBGroupDetailsDtoList.getUserDtoList().iterator();
        while (it2.hasNext()) {
            SBUserList next = it2.next();
            if (next.getName().equalsIgnoreCase("You")) {
                arrayList.add(new SBContactDetail(next.getUserId(), next.getName(), next.getAdmin()));
            }
        }
        Iterator<SBUserList> it3 = sBGroupDetailsDtoList.getUserDtoList().iterator();
        while (it3.hasNext()) {
            SBUserList next2 = it3.next();
            if (!next2.getName().equalsIgnoreCase("You")) {
                arrayList.add(new SBContactDetail(next2.getUserId(), next2.getName(), next2.getAdmin()));
            }
        }
        return arrayList;
    }
}
