package net.one97.paytm.nativesdk.cvvHelp.view;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.cvvHelp.model.CvvHelpModel;
import net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard;

class CvvHelpAdapter extends m {
    private CvvHelpBottomSheet _cvvHelpBottomSheet;
    private Context context;
    private CvvHelpCard cvvHelpCard;

    CvvHelpAdapter(j jVar, CvvHelpCard cvvHelpCard2, CvvHelpBottomSheet cvvHelpBottomSheet, Context context2) {
        super(jVar);
        this.cvvHelpCard = cvvHelpCard2;
        this.context = context2;
        this._cvvHelpBottomSheet = cvvHelpBottomSheet;
    }

    public Fragment getItem(int i2) {
        if (this.cvvHelpCard != CvvHelpCard.ALL) {
            int i3 = AnonymousClass1.$SwitchMap$net$one97$paytm$nativesdk$cvvHelp$utils$CvvHelpCard[this.cvvHelpCard.ordinal()];
            if (i3 == 1) {
                return CvvHelpViewPagerFragment.getInstance(new CvvHelpModel(this.context.getResources().getString(R.string.native_what_is_cvv), this.context.getResources().getString(R.string.native_three_digit), Boolean.FALSE), this._cvvHelpBottomSheet);
            }
            if (i3 != 2) {
                return null;
            }
            return CvvHelpViewPagerFragment.getInstance(new CvvHelpModel(this.context.getResources().getString(R.string.native_what_is_cvv), this.context.getResources().getString(R.string.native_four_digit), Boolean.TRUE), this._cvvHelpBottomSheet);
        } else if (i2 == 0) {
            return CvvHelpViewPagerFragment.getInstance(new CvvHelpModel(this.context.getResources().getString(R.string.native_what_is_cvv), this.context.getResources().getString(R.string.native_three_digit), Boolean.FALSE), this._cvvHelpBottomSheet);
        } else {
            if (i2 != 1) {
                return null;
            }
            return CvvHelpViewPagerFragment.getInstance(new CvvHelpModel(this.context.getResources().getString(R.string.native_what_is_cvv), this.context.getResources().getString(R.string.native_four_digit), Boolean.TRUE), this._cvvHelpBottomSheet);
        }
    }

    /* renamed from: net.one97.paytm.nativesdk.cvvHelp.view.CvvHelpAdapter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$one97$paytm$nativesdk$cvvHelp$utils$CvvHelpCard = new int[CvvHelpCard.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard[] r0 = net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$one97$paytm$nativesdk$cvvHelp$utils$CvvHelpCard = r0
                int[] r0 = $SwitchMap$net$one97$paytm$nativesdk$cvvHelp$utils$CvvHelpCard     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard r1 = net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard.NON_AMEX     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$net$one97$paytm$nativesdk$cvvHelp$utils$CvvHelpCard     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard r1 = net.one97.paytm.nativesdk.cvvHelp.utils.CvvHelpCard.AMEX     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.cvvHelp.view.CvvHelpAdapter.AnonymousClass1.<clinit>():void");
        }
    }

    public int getCount() {
        return this.cvvHelpCard == CvvHelpCard.ALL ? 2 : 1;
    }
}
