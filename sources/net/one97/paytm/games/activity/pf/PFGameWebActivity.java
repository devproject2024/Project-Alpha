package net.one97.paytm.games.activity.pf;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.games.R;
import net.one97.paytm.games.activity.GpBaseActivity;
import net.one97.paytm.games.fragment.pf.a;

public final class PFGameWebActivity extends GpBaseActivity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pf_game_web);
        a.c cVar = a.f35661a;
        getSupportFragmentManager().a().a(R.id.root_container, (Fragment) a.c.a(new Bundle())).b();
    }
}
