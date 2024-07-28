package net.one97.paytm.dynamic.module.cashback;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.splitcompat.a;

public class JarvisHelperInitializeFragment extends Fragment {
    public JarvisHelperInitializeFragment() {
        CashbackJarvisHelper.init();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        a.a(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return new TextView(getActivity());
    }
}
