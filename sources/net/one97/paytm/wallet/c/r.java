package net.one97.paytm.wallet.c;

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

public class r extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f70113a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager f70114b;

    /* renamed from: c  reason: collision with root package name */
    private TabLayout f70115c;

    /* renamed from: d  reason: collision with root package name */
    private Context f70116d;

    /* renamed from: e  reason: collision with root package name */
    private List<UpiHelpModel> f70117e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Button f70118f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f70119g;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f70116d = context;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnShowListener($$Lambda$r$hH4eTbBCM9KD78rdUCk5H5FDGNs.INSTANCE);
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f70113a = layoutInflater.inflate(R.layout.upi_help_layout_new, viewGroup, false);
        this.f70117e = new ArrayList();
        this.f70117e.add(new UpiHelpModel(this.f70116d.getString(R.string.upi_help_text_1), R.drawable.upi_help1));
        this.f70117e.add(new UpiHelpModel(this.f70116d.getString(R.string.upi_help_text_2), R.drawable.upi_help2));
        this.f70117e.add(new UpiHelpModel(this.f70116d.getString(R.string.upi_help_text_3), R.drawable.upi_help3));
        this.f70114b = (ViewPager) this.f70113a.findViewById(R.id.vp_upi_help);
        this.f70114b.setAdapter(new q(getChildFragmentManager(), this, this.f70117e));
        this.f70115c = (TabLayout) this.f70113a.findViewById(R.id.tab_layout);
        this.f70115c.setupWithViewPager(this.f70114b, true);
        this.f70119g = (ImageView) this.f70113a.findViewById(R.id.cross_icon);
        this.f70119g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (r.this.isAdded()) {
                    r.this.dismiss();
                }
            }
        });
        this.f70118f = (Button) this.f70113a.findViewById(R.id.btnProceed);
        this.f70118f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (r.this.isAdded()) {
                    r.this.dismiss();
                }
            }
        });
        this.f70114b.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            public final void onPageSelected(int i2) {
                if (i2 == 2) {
                    r.this.f70118f.setVisibility(0);
                } else {
                    r.this.f70118f.setVisibility(4);
                }
            }
        });
        return this.f70113a;
    }
}
