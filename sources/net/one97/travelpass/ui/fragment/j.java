package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.i.h;

public class j extends h {
    public void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onResume() {
        super.onResume();
        getFragmentManager().a().a((Fragment) new TravelPassHomeFragment(), "travel-pass").b();
    }
}
