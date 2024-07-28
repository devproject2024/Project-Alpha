package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import net.one97.paytm.nativesdk.R;

public abstract class CvvHelpLayoutBinding extends ViewDataBinding {
    public final Button btnProceed;
    public final TabLayout tabLayout;
    public final ViewPager vpCvvHelp;

    protected CvvHelpLayoutBinding(Object obj, View view, int i2, Button button, TabLayout tabLayout2, ViewPager viewPager) {
        super(obj, view, i2);
        this.btnProceed = button;
        this.tabLayout = tabLayout2;
        this.vpCvvHelp = viewPager;
    }

    public static CvvHelpLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static CvvHelpLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CvvHelpLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cvv_help_layout, viewGroup, z, obj);
    }

    public static CvvHelpLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static CvvHelpLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CvvHelpLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cvv_help_layout, (ViewGroup) null, false, obj);
    }

    public static CvvHelpLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static CvvHelpLayoutBinding bind(View view, Object obj) {
        return (CvvHelpLayoutBinding) bind(obj, view, R.layout.cvv_help_layout);
    }
}
