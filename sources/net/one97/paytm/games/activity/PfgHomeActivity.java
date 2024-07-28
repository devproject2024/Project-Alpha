package net.one97.paytm.games.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.fragment.pfg.PFGHomeFragment;

public final class PfgHomeActivity extends GpBaseActivity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.com_gamepind_activity_weex);
        g.a().f35614a++;
        getSupportFragmentManager().a().a(R.id.com_gamepind_fragment_container, (Fragment) new PFGHomeFragment()).b();
    }

    public final void onDestroy() {
        g a2 = g.a();
        a2.f35614a--;
        super.onDestroy();
    }
}
