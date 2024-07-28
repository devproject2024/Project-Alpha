package net.one97.paytm.nativesdk.upiHelp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import androidx.fragment.app.q;
import androidx.viewpager.widget.ViewPager;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.view.fragment.CustomBottomSheetDialogFragment;
import net.one97.paytm.nativesdk.databinding.UpiHelpLayoutBinding;
import net.one97.paytm.nativesdk.upiHelp.pojo.UpiHelpModel;

public class UpiHelpBottomSheet extends CustomBottomSheetDialogFragment {
    /* access modifiers changed from: private */
    public UpiHelpLayoutBinding binding;

    public static UpiHelpBottomSheet getInstance() {
        return new UpiHelpBottomSheet();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (UpiHelpLayoutBinding) f.a(layoutInflater, R.layout.upi_help_layout, viewGroup, false);
        this.binding.btnProceed.setVisibility(4);
        this.binding.vpUpiHelp.setAdapter(new UpiHelpAdapter(getContext(), getChildFragmentManager()));
        this.binding.vpUpiHelp.setPageMargin(10);
        this.binding.tabLayout.setupWithViewPager(this.binding.vpUpiHelp, true);
        this.binding.btnProceed.setVisibility(0);
        this.binding.vpUpiHelp.addOnPageChangeListener(new ViewPager.e() {
            public void onPageScrollStateChanged(int i2) {
            }

            public void onPageScrolled(int i2, float f2, int i3) {
            }

            public void onPageSelected(int i2) {
                if (i2 == 3) {
                    UpiHelpBottomSheet.this.binding.btnProceed.setVisibility(0);
                } else {
                    UpiHelpBottomSheet.this.binding.btnProceed.setVisibility(4);
                }
            }
        });
        this.binding.btnProceed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiHelpBottomSheet.this.dismissAllowingStateLoss();
            }
        });
        this.binding.btnProceed2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiHelpBottomSheet.this.dismissAllowingStateLoss();
            }
        });
        this.binding.crossIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiHelpBottomSheet.this.dismissAllowingStateLoss();
            }
        });
        this.binding.tvSeeHowUpiWorks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiHelpBottomSheet.this.binding.llWhatIsUpi.setVisibility(8);
                UpiHelpBottomSheet.this.binding.rlContentView.setVisibility(0);
                UpiHelpBottomSheet.this.binding.btnProceed.setVisibility(4);
            }
        });
        return this.binding.getRoot();
    }

    public static class UpiHelpAdapter extends m {
        Context context;

        public int getCount() {
            return 4;
        }

        UpiHelpAdapter(Context context2, j jVar) {
            super(jVar);
            this.context = context2;
        }

        public Fragment getItem(int i2) {
            if (i2 == 0) {
                return UpiHelpViewPagerFragment.getInstance(new UpiHelpModel(this.context.getString(R.string.native_upi_help_title_1), "https://d210mgjwpcjie0.cloudfront.net/6bb1101b-64d0-4569-af04-4606167585b1.gif"));
            }
            if (i2 == 1) {
                return UpiHelpViewPagerFragment.getInstance(new UpiHelpModel(this.context.getString(R.string.native_upi_help_title_2), "https://d210mgjwpcjie0.cloudfront.net/9bd1f5b0-199d-414e-87b8-f03156712ce8.gif"));
            }
            if (i2 == 2) {
                return UpiHelpViewPagerFragment.getInstance(new UpiHelpModel(this.context.getString(R.string.native_upi_help_title_3), "https://d210mgjwpcjie0.cloudfront.net/51f4da2d-5f9d-4415-af56-0c7d8d5d7035.gif"));
            }
            return UpiHelpViewPagerFragment.getInstance(new UpiHelpModel(this.context.getString(R.string.native_upi_help_title_4), "https://d210mgjwpcjie0.cloudfront.net/0d98751e-0d7b-4917-9e60-79c86d936989.gif"));
        }
    }

    public int show(q qVar, String str) {
        qVar.a((Fragment) this, str);
        return qVar.c();
    }
}
