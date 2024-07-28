package net.one97.paytm.transport.iocl.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import net.one97.paytm.iocl.R;

public class f extends Fragment {
    public static f a() {
        return new f();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_iocl_user_requested, viewGroup, false);
        inflate.findViewById(R.id.iocl_got_it_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (f.this.getActivity() != null) {
                    f.this.getActivity().finish();
                }
            }
        });
        return inflate;
    }
}
