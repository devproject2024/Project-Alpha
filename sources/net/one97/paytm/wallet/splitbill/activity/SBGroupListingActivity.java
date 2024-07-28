package net.one97.paytm.wallet.splitbill.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.h;
import net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse.SBGroupDetailsDtoList;

public class SBGroupListingActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f71989a;

    /* renamed from: b  reason: collision with root package name */
    private h f71990b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f71991c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f71992d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<SBGroupDetailsDtoList> f71993e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f71994f = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_group_listing_activity);
        if (getIntent() != null) {
            if (getIntent().hasExtra("groupList")) {
                this.f71993e = (ArrayList) getIntent().getSerializableExtra("groupList");
            }
            if (getIntent().hasExtra("non_group_bill")) {
                this.f71994f = getIntent().getBooleanExtra("non_group_bill", false);
            }
        }
        this.f71989a = (RecyclerView) findViewById(R.id.grouprecycler);
        this.f71989a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f71992d = (ImageView) findViewById(R.id.split_back_button);
        this.f71991c = (RelativeLayout) findViewById(R.id.layoutCreateGroup);
        this.f71991c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBGroupListingActivity.this.startActivity(new Intent(SBGroupListingActivity.this, SBSearchContactListActivity.class));
            }
        });
        this.f71992d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBGroupListingActivity.this.finish();
            }
        });
        ArrayList<SBGroupDetailsDtoList> arrayList = this.f71993e;
        if (arrayList != null && arrayList.size() >= 0) {
            this.f71990b = new h(this.f71993e, this, this.f71994f);
            this.f71989a.setAdapter(this.f71990b);
            this.f71989a.scrollToPosition(0);
        }
    }
}
