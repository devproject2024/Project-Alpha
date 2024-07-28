package net.one97.paytm.wallet.splitbill.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.google.gson.g;
import com.paytm.utility.a;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.i;
import net.one97.paytm.wallet.splitbill.activity.SBEnterBillActivity;
import net.one97.paytm.wallet.splitbill.b.d;
import net.one97.paytm.wallet.splitbill.b.e;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.e.c;
import net.one97.paytm.wallet.splitbill.model.AddBillAPI.SBContact;
import net.one97.paytm.wallet.splitbill.model.AddBillAPI.SBCreateGroupAPIRequest;
import net.one97.paytm.wallet.splitbill.model.CreateGroupAPIResponse.SBCreateGroupBaseResponse;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public class f extends h implements Response.Listener<IJRDataModel>, d, e {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f72146a;

    /* renamed from: b  reason: collision with root package name */
    private i f72147b;

    /* renamed from: c  reason: collision with root package name */
    private Button f72148c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<SBContactDetail> f72149d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<SBContactDetail> f72150e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Activity f72151f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f72152g;

    /* renamed from: h  reason: collision with root package name */
    private int f72153h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f72154i;
    private String j;
    private View k;
    private c l;
    private RelativeLayout m;

    public final void a(ArrayList<SBContactDetail> arrayList) {
    }

    public final void b(ArrayList<SBContactDetail> arrayList) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (iJRDataModel instanceof SBCreateGroupBaseResponse) {
            SBCreateGroupBaseResponse sBCreateGroupBaseResponse = (SBCreateGroupBaseResponse) iJRDataModel;
            if (sBCreateGroupBaseResponse.getStatus().equalsIgnoreCase("FAILURE")) {
                String b2 = b.b(sBCreateGroupBaseResponse.getCode());
                this.l.a(b2, sBCreateGroupBaseResponse.getMessage(), false);
                this.k.findViewById(R.id.title).setVisibility(TextUtils.isEmpty(b2) ? 8 : 0);
                this.k.findViewById(R.id.status_ticker_view).setVisibility(0);
                this.k.findViewById(R.id.split_back_button).setVisibility(8);
                return;
            }
            Intent intent = new Intent(this.f72151f, SBEnterBillActivity.class);
            intent.putExtra("list", this.f72149d);
            intent.putExtra("group_name", this.f72152g.getText().toString());
            intent.putExtra("group_id", sBCreateGroupBaseResponse.getResponse().getGroupId());
            this.f72151f.startActivity(intent);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f72151f = (Activity) context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sb_fragment_create_group, (ViewGroup) null);
        if (getArguments() != null) {
            this.f72149d = (ArrayList) getArguments().getSerializable("list");
        }
        this.k = inflate;
        this.m = (RelativeLayout) inflate.findViewById(R.id.activity_container);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.m.getLayoutParams());
        layoutParams.height = -1;
        this.m.setLayoutParams(layoutParams);
        this.f72154i = (TextView) inflate.findViewById(R.id.group_names);
        this.f72146a = (RecyclerView) inflate.findViewById(R.id.recycleview);
        this.f72146a.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.f72152g = (EditText) inflate.findViewById(R.id.et_name);
        this.f72152g.requestFocus();
        this.l = new c(this.f72151f, this);
        ((LinearLayout) inflate.findViewById(R.id.status_ticker_view)).addView(this.l.a(false));
        ((LinearLayout) inflate.findViewById(R.id.status_ticker_view)).setVisibility(8);
        this.f72148c = (Button) inflate.findViewById(R.id.creategroup);
        ((ImageView) inflate.findViewById(R.id.split_back_button)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.f72151f.finish();
            }
        });
        this.f72148c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (TextUtils.isEmpty(f.this.f72152g.getText().toString())) {
                    Toast.makeText(f.this.f72151f, "group name cannot be empty", 0).show();
                } else {
                    f.c(f.this);
                }
            }
        });
        ArrayList<SBContactDetail> arrayList = this.f72149d;
        if (arrayList != null && arrayList.size() > 0) {
            this.f72153h = this.f72149d.size();
        }
        this.j = this.f72151f.getResources().getString(R.string.between_you_and_others) + this.f72153h + this.f72151f.getResources().getString(R.string.sb_others);
        this.f72154i.setText(this.j);
        SBContactDetail sBContactDetail = new SBContactDetail();
        sBContactDetail.setmName(this.f72151f.getResources().getString(R.string.you));
        sBContactDetail.setMobile(com.paytm.utility.b.l((Context) getActivity()));
        sBContactDetail.setSelected(true);
        sBContactDetail.setAdmin(true);
        this.f72149d.add(0, sBContactDetail);
        this.f72147b = new i(getActivity(), this, false);
        i iVar = this.f72147b;
        iVar.f71830b = this.f72149d;
        this.f72146a.setAdapter(iVar);
        return inflate;
    }

    public final void a(SBContactDetail sBContactDetail) {
        this.f72153h = this.f72149d.size();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f72151f.getResources().getString(R.string.between_you_and_others));
        sb.append(this.f72153h - 1);
        sb.append(this.f72151f.getResources().getString(R.string.sb_others));
        this.j = sb.toString();
        this.f72154i.setText(this.j);
    }

    public final void b() {
        this.k.findViewById(R.id.status_ticker_view).setVisibility(8);
        this.k.findViewById(R.id.split_back_button).setVisibility(0);
    }

    static /* synthetic */ void c(f fVar) {
        String stringFromGTM = !TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(fVar.f72151f, "getCreateGroupUrl")) ? net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(fVar.f72151f, "getCreateGroupUrl") : "https://prms.paytmbank.com/prms/ext/v1/group";
        SBCreateGroupAPIRequest sBCreateGroupAPIRequest = new SBCreateGroupAPIRequest();
        sBCreateGroupAPIRequest.setClient(UpiConstants.B2C_ANDROID);
        if (!TextUtils.isEmpty(fVar.f72152g.getText().toString())) {
            sBCreateGroupAPIRequest.setName(fVar.f72152g.getText().toString());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SBContactDetail> it2 = fVar.f72149d.iterator();
        while (it2.hasNext()) {
            SBContactDetail next = it2.next();
            arrayList.add(new SBContact(next.getMobile(), next.getmAmount(), next.getUserId(), next.getmName()));
        }
        sBCreateGroupAPIRequest.setUserList(arrayList);
        g gVar = new g();
        gVar.f39467e = false;
        gVar.a().b(sBCreateGroupAPIRequest);
        if (!TextUtils.isEmpty(stringFromGTM)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("user-token", a.q(fVar.f72151f));
                hashMap.put("Content-Type", "application/json");
                hashMap.put("client-id", UpiConstants.B2C_ANDROID);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }
}
