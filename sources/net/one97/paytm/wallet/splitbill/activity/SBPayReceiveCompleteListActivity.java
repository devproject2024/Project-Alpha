package net.one97.paytm.wallet.splitbill.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.k;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSnapShotPojo;

public class SBPayReceiveCompleteListActivity extends PaytmActivity implements k.a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f72031a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f72032b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f72033c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f72034d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f72035e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f72036f = true;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<SBUserSnapShotPojo> f72037g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<SBUserSnapShotPojo> f72038h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private k f72039i;
    private k j;
    private String k = "0";

    public final void a() {
    }

    public final void a(String str, boolean z, String str2, Double d2) {
    }

    public final void aJ_() {
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void e() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_pay_receive_complete_list);
        if (getIntent() != null) {
            if (getIntent().hasExtra("receiveList")) {
                this.f72036f = false;
                this.f72037g = (ArrayList) getIntent().getSerializableExtra("receiveList");
                this.k = getIntent().getStringExtra("totalToReceive");
            } else if (getIntent().hasExtra("payList")) {
                this.f72036f = true;
                this.f72038h = (ArrayList) getIntent().getSerializableExtra("payList");
                this.k = getIntent().getStringExtra("totalToPay");
            }
        }
        this.f72035e = (ImageView) findViewById(R.id.split_back_button);
        this.f72033c = (RoboTextView) findViewById(R.id.payReceiveHolder);
        this.f72034d = (RoboTextView) findViewById(R.id.tvTotalPayReceive);
        this.f72032b = (TextView) findViewById(R.id.header_pay_receive);
        this.f72031a = (RecyclerView) findViewById(R.id.payReceiveRecyclerView);
        this.f72031a.setLayoutManager(new LinearLayoutManager(this, 1, true));
        this.f72035e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBPayReceiveCompleteListActivity.this.finish();
            }
        });
        this.f72034d.setText(this.k);
        if (this.f72036f) {
            this.f72032b.setText("Friends whom you need to pay");
            this.f72033c.setText("TOTAL PAYABLE");
            this.f72033c.setTextColor(Color.parseColor("#fd5c5c"));
            this.f72039i = new k(this, this);
            this.f72039i.a((List<SBUserSnapShotPojo>) this.f72038h, false);
            this.f72031a.setAdapter(this.f72039i);
            this.f72031a.scrollToPosition(0);
            return;
        }
        this.f72032b.setText("Friends who owe you money");
        this.f72033c.setText("TOTAL RECEIVABLE");
        this.f72033c.setTextColor(Color.parseColor("#21c17a"));
        this.j = new k(this, this);
        this.j.a((List<SBUserSnapShotPojo>) this.f72037g, false);
        this.f72031a.setAdapter(this.j);
        this.f72031a.scrollToPosition(0);
    }
}
