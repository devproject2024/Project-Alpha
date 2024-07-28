package net.one97.paytm.nativesdk.upiHelp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import com.bumptech.glide.b;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.databinding.UpiHelpCardLayoutBinding;
import net.one97.paytm.nativesdk.upiHelp.pojo.UpiHelpModel;

public class UpiHelpViewPagerFragment extends h {
    private UpiHelpCardLayoutBinding binding;
    private UpiHelpModel upiHelpModel;

    public static UpiHelpViewPagerFragment getInstance(UpiHelpModel upiHelpModel2) {
        UpiHelpViewPagerFragment upiHelpViewPagerFragment = new UpiHelpViewPagerFragment();
        upiHelpViewPagerFragment.upiHelpModel = upiHelpModel2;
        return upiHelpViewPagerFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (UpiHelpCardLayoutBinding) f.a(getLayoutInflater(), R.layout.upi_help_card_layout, (ViewGroup) null, false);
        this.binding.setUpiHelpModel(this.upiHelpModel);
        this.binding.tvUpiHelpTitle.setText(this.upiHelpModel.getTitle());
        b.a((View) this.binding.ivGif).a(this.upiHelpModel.getGifUrl()).a(this.binding.ivGif);
        return this.binding.getRoot();
    }
}
