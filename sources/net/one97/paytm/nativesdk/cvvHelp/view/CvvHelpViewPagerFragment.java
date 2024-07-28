package net.one97.paytm.nativesdk.cvvHelp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.cvvHelp.listeners.CvvHelpLIstener;
import net.one97.paytm.nativesdk.cvvHelp.model.CvvHelpModel;
import net.one97.paytm.nativesdk.cvvHelp.viewmodel.CvvHelpFragmentViewModel;
import net.one97.paytm.nativesdk.databinding.CvvHelpCardLayoutBinding;

public class CvvHelpViewPagerFragment extends h {
    private CvvHelpCardLayoutBinding binding;
    private CvvHelpModel cvvHelpModel;
    private CvvHelpLIstener lIstener;

    public static CvvHelpViewPagerFragment getInstance(CvvHelpModel cvvHelpModel2, CvvHelpLIstener cvvHelpLIstener) {
        CvvHelpViewPagerFragment cvvHelpViewPagerFragment = new CvvHelpViewPagerFragment();
        cvvHelpViewPagerFragment.cvvHelpModel = cvvHelpModel2;
        cvvHelpViewPagerFragment.lIstener = cvvHelpLIstener;
        return cvvHelpViewPagerFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (CvvHelpCardLayoutBinding) f.a(getLayoutInflater(), R.layout.cvv_help_card_layout, (ViewGroup) null, false);
        this.binding.setCvvHelpModel(new CvvHelpFragmentViewModel(this.cvvHelpModel.getTitle(), this.cvvHelpModel.getDescription(), this.cvvHelpModel.getAmexCard()));
        return this.binding.getRoot();
    }
}
