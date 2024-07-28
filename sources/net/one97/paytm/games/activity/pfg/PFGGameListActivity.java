package net.one97.paytm.games.activity.pfg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.games.R;
import net.one97.paytm.games.activity.GpBaseActivity;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.model.pfg.Game;

public class PFGGameListActivity extends GpBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private final String f35565b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    private int f35566c = 1;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f35567d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f35568e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f35569f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayoutManager f35570g;

    /* renamed from: h  reason: collision with root package name */
    private List<Game> f35571h = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_game_list);
        a((Activity) this);
        String stringExtra = getIntent().getStringExtra("TITLE_NAME");
        getIntent().getStringExtra("TAG_ID");
        int intExtra = getIntent().getIntExtra("TYPE", -1);
        this.f35567d = (ImageView) findViewById(R.id.back);
        this.f35568e = (TextView) findViewById(R.id.tv_title);
        this.f35567d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PFGGameListActivity.this.a(view);
            }
        });
        this.f35568e.setText(stringExtra);
        this.f35569f = (RecyclerView) findViewById(R.id.recycler_only_game);
        this.f35570g = new LinearLayoutManager(this);
        this.f35569f.setLayoutManager(this.f35570g);
        if (intExtra == 0) {
            g.a().c().sendOpenScreenWithDeviceInfo(f.c(this, "/inbox/games/more-".concat(String.valueOf(stringExtra))), "inbox", this);
        } else if (intExtra == 1) {
            b();
            g.a().c().sendOpenScreenWithDeviceInfo(f.c(this, "/inbox/games/more-".concat(String.valueOf(stringExtra))), "inbox", this);
        } else if (intExtra == 2) {
            b();
            g.a().c().sendOpenScreenWithDeviceInfo(f.c(this, "/inbox/games/-".concat(String.valueOf(stringExtra))), "inbox", this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    private void b() {
        getIntent().getStringExtra("TITLE_NAME");
    }
}
