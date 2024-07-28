package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class UpiHelpLayoutBinding extends ViewDataBinding {
    public final Button btnProceed;
    public final Button btnProceed2;
    public final ImageView crossIcon;
    public final ImageView ivUpi;
    public final LinearLayout llWhatIsUpi;
    public final RelativeLayout rlContentView;
    public final TabLayout tabLayout;
    public final TextView tvSeeHowUpiWorks;
    public final RoboTextView tvUpiHelpTitle;
    public final ViewPager vpUpiHelp;

    protected UpiHelpLayoutBinding(Object obj, View view, int i2, Button button, Button button2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout, TabLayout tabLayout2, TextView textView, RoboTextView roboTextView, ViewPager viewPager) {
        super(obj, view, i2);
        this.btnProceed = button;
        this.btnProceed2 = button2;
        this.crossIcon = imageView;
        this.ivUpi = imageView2;
        this.llWhatIsUpi = linearLayout;
        this.rlContentView = relativeLayout;
        this.tabLayout = tabLayout2;
        this.tvSeeHowUpiWorks = textView;
        this.tvUpiHelpTitle = roboTextView;
        this.vpUpiHelp = viewPager;
    }

    public static UpiHelpLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static UpiHelpLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UpiHelpLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_help_layout, viewGroup, z, obj);
    }

    public static UpiHelpLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static UpiHelpLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UpiHelpLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_help_layout, (ViewGroup) null, false, obj);
    }

    public static UpiHelpLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static UpiHelpLayoutBinding bind(View view, Object obj) {
        return (UpiHelpLayoutBinding) bind(obj, view, R.layout.upi_help_layout);
    }
}
