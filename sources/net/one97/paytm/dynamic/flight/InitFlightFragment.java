package net.one97.paytm.dynamic.flight;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.paytm_finance.R;

public class InitFlightFragment extends Fragment {
    private String classpath = "com.travel.flight.flightticket.fragment.FJRFlightTicketFragment";
    private Fragment displayedFragment;

    public void onAttach(Context context) {
        super.onAttach(context);
        a.a(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.flight_init_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        switchFragment(R.id.container);
    }

    private void switchFragment(int i2) {
        q a2 = getChildFragmentManager().a();
        new Bundle().putBoolean("expanded", true);
        this.displayedFragment = getFlightFragment();
        Fragment fragment = this.displayedFragment;
        if (fragment != null) {
            a2.b(i2, fragment, "flight").b();
        }
    }

    private Fragment getFlightFragment() {
        Fragment fragment;
        IllegalAccessException e2;
        InstantiationException e3;
        ClassNotFoundException e4;
        try {
            fragment = (Fragment) Class.forName(this.classpath).newInstance();
            try {
                new StringBuilder("FlightInitFragment::getFeedFragment starting fragment ").append(fragment.getClass().getSimpleName());
            } catch (IllegalAccessException e5) {
                e2 = e5;
            } catch (InstantiationException e6) {
                e3 = e6;
                com.paytm.utility.q.b(e3.getMessage());
                return fragment;
            } catch (ClassNotFoundException e7) {
                e4 = e7;
                com.paytm.utility.q.b(e4.getMessage());
                return fragment;
            }
        } catch (IllegalAccessException e8) {
            IllegalAccessException illegalAccessException = e8;
            fragment = null;
            e2 = illegalAccessException;
            com.paytm.utility.q.b(e2.getMessage());
            return fragment;
        } catch (InstantiationException e9) {
            InstantiationException instantiationException = e9;
            fragment = null;
            e3 = instantiationException;
            com.paytm.utility.q.b(e3.getMessage());
            return fragment;
        } catch (ClassNotFoundException e10) {
            ClassNotFoundException classNotFoundException = e10;
            fragment = null;
            e4 = classNotFoundException;
            com.paytm.utility.q.b(e4.getMessage());
            return fragment;
        }
        return fragment;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        new StringBuilder("FlightInitFragment::onActivityResult displayedFragment is ").append(this.displayedFragment);
        Fragment fragment = this.displayedFragment;
        if (fragment != null) {
            fragment.onActivityResult(i2, i3, intent);
        }
    }
}
