package net.one97.paytm.wallet.splitbill.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import net.one97.paytm.i.h;
import net.one97.paytm.p2p.theme.e;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBGroupListingActivity;
import net.one97.paytm.wallet.splitbill.activity.SBSearchContactListActivity;
import net.one97.paytm.wallet.splitbill.d.a;
import net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse.SBGroupDetailsDtoList;
import net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse.SBUserGroupsBaseResponse;

public class i extends h {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f72190a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.wallet.splitbill.a.h f72191b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f72192c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f72193d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Activity f72194e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f72195f = Boolean.FALSE;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<SBGroupDetailsDtoList> f72196g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private SBUserGroupsBaseResponse f72197h;

    /* renamed from: i  reason: collision with root package name */
    private a f72198i;
    /* access modifiers changed from: private */
    public boolean j = false;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        SBUserGroupsBaseResponse sBUserGroupsBaseResponse;
        View inflate = layoutInflater.inflate(R.layout.sb_group_list_fragment, (ViewGroup) null);
        this.f72190a = (RecyclerView) inflate.findViewById(R.id.grouprecycler);
        this.f72190a.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.f72192c = (RoboTextView) inflate.findViewById(R.id.groupViewAll);
        this.f72193d = (RelativeLayout) inflate.findViewById(R.id.layoutCreateGroup);
        if (this.f72195f.booleanValue()) {
            this.f72192c.setVisibility(8);
        }
        this.f72193d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(i.this.f72194e, SBSearchContactListActivity.class);
                intent.putExtra("show_group_widget", false);
                intent.putExtra("non_group_bill", i.this.j);
                i.this.startActivity(intent);
            }
        });
        if (getArguments() != null) {
            this.j = getArguments().getBoolean("non_group_bill");
        }
        this.f72198i = a.a((Context) this.f72194e);
        Object a2 = e.a(this.f72198i.f72229a, "user_group_data");
        if (a2 instanceof SBUserGroupsBaseResponse) {
            sBUserGroupsBaseResponse = (SBUserGroupsBaseResponse) a2;
        } else {
            sBUserGroupsBaseResponse = new SBUserGroupsBaseResponse();
        }
        this.f72197h = sBUserGroupsBaseResponse;
        this.f72196g = this.f72197h.getResponse().getGroupDetailsDtoList();
        if (this.f72195f.booleanValue()) {
            this.f72192c.setVisibility(8);
            this.f72191b = new net.one97.paytm.wallet.splitbill.a.h(this.f72196g, this.f72194e, this.j);
        } else if (this.f72196g.size() <= 3) {
            this.f72192c.setVisibility(8);
            ArrayList<SBGroupDetailsDtoList> arrayList = this.f72196g;
            this.f72191b = new net.one97.paytm.wallet.splitbill.a.h(arrayList.subList(0, arrayList.size()), this.f72194e, this.j);
        } else {
            this.f72191b = new net.one97.paytm.wallet.splitbill.a.h(this.f72196g.subList(0, 3), this.f72194e, this.j);
        }
        this.f72190a.setAdapter(this.f72191b);
        this.f72192c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(i.this.f72194e, SBGroupListingActivity.class);
                intent.putExtra("groupList", i.this.f72196g);
                intent.putExtra("non_group_bill", i.this.j);
                i.this.f72194e.startActivity(intent);
            }
        });
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f72194e = (Activity) context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
