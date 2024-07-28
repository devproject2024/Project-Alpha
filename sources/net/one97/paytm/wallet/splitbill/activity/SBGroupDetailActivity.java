package net.one97.paytm.wallet.splitbill.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.utils.z;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.j;
import net.one97.paytm.wallet.splitbill.c.c;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupDTO;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupInfoBaseResponse;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupSnapshot;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBUserList;
import net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse.SBGroupDetailsDtoList;
import net.one97.paytm.wallet.splitbill.model.b;

public class SBGroupDetailActivity extends PaytmActivity implements View.OnClickListener, j.a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f71980a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f71981b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ImageView f71982c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f71983d;

    /* renamed from: e  reason: collision with root package name */
    private Button f71984e;

    /* renamed from: f  reason: collision with root package name */
    private Button f71985f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f71986g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f71987h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f71988i;
    private TextView j;
    private TextView k;
    private TextView l;
    private Float m;
    private Float n;
    private z o;
    private ArrayList<String> p;
    private SBGroupDetailsDtoList q;
    private SBGroupDTO r;
    private ArrayList<SBUserList> s;
    private List<b> t;
    private List<SBGroupSnapshot> u;
    private SBGroupInfoBaseResponse v;
    private ImageView w;
    private RoboTextView x;
    private LinearLayout y;

    public final void a() {
    }

    public SBGroupDetailActivity() {
        Float valueOf = Float.valueOf(0.0f);
        this.m = valueOf;
        this.n = valueOf;
        this.p = new ArrayList<String>() {
            {
                add("#2cce86");
                add("#6c7cff");
                add("#ffa400");
                add("#b069ec");
                add("#40cdd8");
                add("#fd5c7f");
                add("#f2c110");
                add("#f36bb4");
                add("#3ab6f4");
                add("#a6b7be");
            }
        };
        this.t = new ArrayList();
        this.u = new ArrayList();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_group_detail_activity);
        this.o = new z(this);
        this.o.setCancelable(false);
        this.o.setCanceledOnTouchOutside(false);
        if (getIntent() != null) {
            this.q = (SBGroupDetailsDtoList) getIntent().getSerializableExtra("group_detail");
        }
        z zVar = this.o;
        if (zVar != null && !zVar.isShowing()) {
            this.o.show();
        }
        this.q.getGroupId();
        this.f71986g = (ImageView) findViewById(R.id.split_back_button);
        this.f71980a = (RecyclerView) findViewById(R.id.transactionrecycler);
        this.f71982c = (ImageView) findViewById(R.id.arrow_button);
        this.f71983d = (ImageView) findViewById(R.id.tint);
        this.f71987h = (TextView) findViewById(R.id.group_name);
        this.f71988i = (TextView) findViewById(R.id.group_member);
        this.j = (TextView) findViewById(R.id.total_recev);
        this.k = (TextView) findViewById(R.id.total_paid);
        this.l = (TextView) findViewById(R.id.beneficiary_circle_txt);
        this.f71985f = (Button) findViewById(R.id.tvAddNewBill);
        this.f71985f.setOnClickListener(this);
        this.f71982c.setOnClickListener(this);
        this.f71984e = (Button) findViewById(R.id.settle_up);
        this.f71984e.setOnClickListener(this);
        this.f71983d.setOnClickListener(this);
        this.f71986g.setOnClickListener(this);
        this.w = (ImageView) findViewById(R.id.split_arrow);
        this.x = (RoboTextView) findViewById(R.id.bills_for_group_name);
        RoboTextView roboTextView = this.x;
        roboTextView.setText("Bills for " + this.q.getName());
        this.w.setOnClickListener(this);
        this.y = (LinearLayout) findViewById(R.id.ll_outer_most_container);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.arrow_button) {
            net.one97.paytm.wallet.splitbill.c.b a2 = net.one97.paytm.wallet.splitbill.c.b.a();
            List<SBGroupSnapshot> list = this.u;
            SBGroupDTO sBGroupDTO = this.r;
            a2.f72108a = list;
            a2.f72111d = sBGroupDTO;
            a2.f72109b = new ArrayList();
            a2.f72110c = new ArrayList();
            a2.show(getSupportFragmentManager(), "bottom_sheet_pay_receive_list_fragment");
        } else if (id == R.id.tint) {
        } else {
            if (id == R.id.split_back_button) {
                finish();
            } else if (id == R.id.settle_up) {
                Intent intent = new Intent(this, SBBillSettlementActivity.class);
                intent.putExtra("sb_response_get_group_info", this.v);
                startActivity(intent);
            } else if (id == R.id.tvAddNewBill) {
                Intent intent2 = new Intent(this, SBEnterBillActivity.class);
                intent2.putExtra("group_name", this.q.getName());
                intent2.putExtra("group_detail", this.q);
                startActivity(intent2);
            } else if (id == R.id.split_arrow) {
                c a3 = c.a();
                a3.a(this.r.getName(), this.s, "");
                a3.show(getSupportFragmentManager(), "bottom_sheet_group_member_list_fragment");
            }
        }
    }
}
