package net.one97.paytm.p2mNewDesign.d;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.offline_pg.UpiHelpModel;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;

public class j extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f51188a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager f51189b;

    /* renamed from: c  reason: collision with root package name */
    private TabLayout f51190c;

    /* renamed from: d  reason: collision with root package name */
    private Context f51191d;

    /* renamed from: e  reason: collision with root package name */
    private List<UpiHelpModel> f51192e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Button f51193f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f51194g;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f51191d = context;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener($$Lambda$j$okAKDhNO2oCjhYXLNB6hvNmU8.INSTANCE);
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f51188a = layoutInflater.inflate(R.layout.upi_help_layout_new, viewGroup, false);
        this.f51192e = new ArrayList();
        this.f51192e.add(new UpiHelpModel(this.f51191d.getString(R.string.upi_help_text_1), R.drawable.upi_help1));
        this.f51192e.add(new UpiHelpModel(this.f51191d.getString(R.string.upi_help_text_2), R.drawable.upi_help2));
        this.f51192e.add(new UpiHelpModel(this.f51191d.getString(R.string.upi_help_text_3), R.drawable.upi_help3));
        this.f51189b = (ViewPager) this.f51188a.findViewById(R.id.vp_upi_help);
        this.f51189b.setAdapter(new i(getChildFragmentManager(), this, this.f51192e));
        this.f51190c = (TabLayout) this.f51188a.findViewById(R.id.tab_layout);
        this.f51190c.setupWithViewPager(this.f51189b, true);
        this.f51194g = (ImageView) this.f51188a.findViewById(R.id.cross_icon);
        this.f51194g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (j.this.isAdded()) {
                    j.this.dismiss();
                }
            }
        });
        this.f51193f = (Button) this.f51188a.findViewById(R.id.btnProceed);
        this.f51193f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (j.this.isAdded()) {
                    j.this.dismiss();
                }
            }
        });
        this.f51189b.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            public final void onPageSelected(int i2) {
                if (i2 == 2) {
                    j.this.f51193f.setVisibility(0);
                } else {
                    j.this.f51193f.setVisibility(4);
                }
            }
        });
        return this.f51188a;
    }
}
