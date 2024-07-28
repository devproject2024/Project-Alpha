package net.one97.paytm.nativesdk.cvvHelp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.view.fragment.CustomBottomSheetDialogFragment;
import net.one97.paytm.nativesdk.cvvHelp.listeners.CvvHelpLIstener;
import net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard;
import net.one97.paytm.nativesdk.databinding.CvvHelpLayoutBinding;

public class CvvHelpBottomSheet extends CustomBottomSheetDialogFragment implements CvvHelpLIstener {
    private CvvHelpLayoutBinding binding;
    private CvvHelpCard cvvHelpCard;

    public static CvvHelpBottomSheet getInstance(CvvHelpCard cvvHelpCard2) {
        CvvHelpBottomSheet cvvHelpBottomSheet = new CvvHelpBottomSheet();
        cvvHelpBottomSheet.cvvHelpCard = cvvHelpCard2;
        return cvvHelpBottomSheet;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (CvvHelpLayoutBinding) f.a(layoutInflater, R.layout.cvv_help_layout, viewGroup, false);
        this.binding.btnProceed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CvvHelpBottomSheet.this.closeBottomSheet();
            }
        });
        return this.binding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.binding.vpCvvHelp.setAdapter(new CvvHelpAdapter(getChildFragmentManager(), this.cvvHelpCard, this, getContext()));
        this.binding.tabLayout.setupWithViewPager(this.binding.vpCvvHelp, true);
    }

    public void closeBottomSheet() {
        dismissAllowingStateLoss();
    }
}
