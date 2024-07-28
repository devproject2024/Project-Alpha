package com.business.merchant_payments.common.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.databinding.MpReportDownloadBottomSheetBinding;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.k;

public final class ReportDownloadBottomSheet extends CustomBottomSheetDialogFragment {
    public HashMap _$_findViewCache;
    public String currSelection = AppConstants.CUSTOM_DATE;
    public final String endDate;
    public MpReportDownloadBottomSheetBinding mBinding;
    public final IReportDownloadListener mListener;
    public final String mTitle;
    public final String startDate;

    public interface IReportDownloadListener {
        void onCustomDateClicked();

        void onDownloadClicked();

        void onRangeSelected(String str);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public ReportDownloadBottomSheet(IReportDownloadListener iReportDownloadListener, String str, String str2, String str3) {
        k.d(iReportDownloadListener, "mListener");
        k.d(str, "mTitle");
        k.d(str2, "startDate");
        k.d(str3, "endDate");
        this.mListener = iReportDownloadListener;
        this.mTitle = str;
        this.startDate = str2;
        this.endDate = str3;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        MpReportDownloadBottomSheetBinding inflate = MpReportDownloadBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        k.b(inflate, "MpReportDownloadBottomSh…flater, container, false)");
        this.mBinding = inflate;
        initUI();
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding = this.mBinding;
        if (mpReportDownloadBottomSheetBinding == null) {
            k.a("mBinding");
        }
        return mpReportDownloadBottomSheetBinding.getRoot();
    }

    private final void initUI() {
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding = this.mBinding;
        if (mpReportDownloadBottomSheetBinding == null) {
            k.a("mBinding");
        }
        TextView textView = mpReportDownloadBottomSheetBinding.viewPayment;
        k.b(textView, "mBinding.viewPayment");
        textView.setText(this.mTitle);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding2 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding2 == null) {
            k.a("mBinding");
        }
        TextView textView2 = mpReportDownloadBottomSheetBinding2.todaySummary;
        k.b(textView2, "mBinding.todaySummary");
        textView2.setText(DateUtility.getCurrentFormattedDate("dd MMM"));
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding3 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding3 == null) {
            k.a("mBinding");
        }
        TextView textView3 = mpReportDownloadBottomSheetBinding3.yesterdaySummary;
        k.b(textView3, "mBinding.yesterdaySummary");
        textView3.setText(DateUtility.getYesterdayStartDate("dd MMM"));
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding4 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding4 == null) {
            k.a("mBinding");
        }
        TextView textView4 = mpReportDownloadBottomSheetBinding4.weekSummary;
        k.b(textView4, "mBinding.weekSummary");
        textView4.setText(DateUtility.getWeek());
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding5 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding5 == null) {
            k.a("mBinding");
        }
        TextView textView5 = mpReportDownloadBottomSheetBinding5.currentSummary;
        k.b(textView5, "mBinding.currentSummary");
        textView5.setText(getSelectedDateRange());
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding6 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding6 == null) {
            k.a("mBinding");
        }
        mpReportDownloadBottomSheetBinding6.todayItem.setOnClickListener(new ReportDownloadBottomSheet$initUI$1(this));
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding7 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding7 == null) {
            k.a("mBinding");
        }
        mpReportDownloadBottomSheetBinding7.yesterdayItem.setOnClickListener(new ReportDownloadBottomSheet$initUI$2(this));
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding8 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding8 == null) {
            k.a("mBinding");
        }
        mpReportDownloadBottomSheetBinding8.weekItem.setOnClickListener(new ReportDownloadBottomSheet$initUI$3(this));
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding9 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding9 == null) {
            k.a("mBinding");
        }
        mpReportDownloadBottomSheetBinding9.currentItem.setOnClickListener(new ReportDownloadBottomSheet$initUI$4(this));
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding10 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding10 == null) {
            k.a("mBinding");
        }
        mpReportDownloadBottomSheetBinding10.customItem.setOnClickListener(new ReportDownloadBottomSheet$initUI$5(this));
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding11 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding11 == null) {
            k.a("mBinding");
        }
        mpReportDownloadBottomSheetBinding11.downloadBtn.setOnClickListener(new ReportDownloadBottomSheet$initUI$6(this));
        this.currSelection = AppConstants.CURRENT_SELECTION;
        updateSelection();
    }

    private final String getSelectedDateRange() {
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtility.getFormattedDate(this.startDate, "dd MMMM yy", "dd MMM"));
        sb.append(' ');
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        Context appContext = instance.getAppContext();
        k.b(appContext, "PaymentsConfig.getInstance().appContext");
        sb.append(appContext.getResources().getString(R.string.mp_to));
        sb.append(' ');
        sb.append(DateUtility.getFormattedDate(this.endDate, "dd MMMM yy", "dd MMM"));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final void downloadReportForCurrentSelection() {
        String str = this.currSelection;
        switch (str.hashCode()) {
            case -1778017348:
                if (str.equals(AppConstants.CUSTOM_DATE)) {
                    this.mListener.onRangeSelected(AppConstants.CUSTOM_DATE);
                    break;
                }
                break;
            case -1621979774:
                if (str.equals(AppConstants.YESTERDAY)) {
                    this.mListener.onRangeSelected(AppConstants.YESTERDAY);
                    break;
                }
                break;
            case 3645428:
                if (str.equals("week")) {
                    this.mListener.onRangeSelected("week");
                    break;
                }
                break;
            case 41248326:
                if (str.equals(AppConstants.CURRENT_SELECTION)) {
                    this.mListener.onRangeSelected(AppConstants.CURRENT_SELECTION);
                    break;
                }
                break;
            case 110534465:
                if (str.equals("today")) {
                    this.mListener.onRangeSelected("today");
                    break;
                }
                break;
        }
        this.mListener.onDownloadClicked();
    }

    /* access modifiers changed from: private */
    public final void updateSelection() {
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding = this.mBinding;
        if (mpReportDownloadBottomSheetBinding == null) {
            k.a("mBinding");
        }
        TextView textView = mpReportDownloadBottomSheetBinding.todayHeader;
        k.b(textView, "mBinding.todayHeader");
        textView.setTypeface(Typeface.DEFAULT);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding2 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding2 == null) {
            k.a("mBinding");
        }
        TextView textView2 = mpReportDownloadBottomSheetBinding2.yesterdayHeader;
        k.b(textView2, "mBinding.yesterdayHeader");
        textView2.setTypeface(Typeface.DEFAULT);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding3 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding3 == null) {
            k.a("mBinding");
        }
        TextView textView3 = mpReportDownloadBottomSheetBinding3.weekHeader;
        k.b(textView3, "mBinding.weekHeader");
        textView3.setTypeface(Typeface.DEFAULT);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding4 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding4 == null) {
            k.a("mBinding");
        }
        TextView textView4 = mpReportDownloadBottomSheetBinding4.customHeader;
        k.b(textView4, "mBinding.customHeader");
        textView4.setTypeface(Typeface.DEFAULT);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding5 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding5 == null) {
            k.a("mBinding");
        }
        TextView textView5 = mpReportDownloadBottomSheetBinding5.currentHeader;
        k.b(textView5, "mBinding.currentHeader");
        textView5.setTypeface(Typeface.DEFAULT);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding6 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding6 == null) {
            k.a("mBinding");
        }
        ImageView imageView = mpReportDownloadBottomSheetBinding6.todayTickImg;
        k.b(imageView, "mBinding.todayTickImg");
        imageView.setVisibility(8);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding7 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding7 == null) {
            k.a("mBinding");
        }
        ImageView imageView2 = mpReportDownloadBottomSheetBinding7.yesterdayTickImg;
        k.b(imageView2, "mBinding.yesterdayTickImg");
        imageView2.setVisibility(8);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding8 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding8 == null) {
            k.a("mBinding");
        }
        ImageView imageView3 = mpReportDownloadBottomSheetBinding8.weekTickImg;
        k.b(imageView3, "mBinding.weekTickImg");
        imageView3.setVisibility(8);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding9 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding9 == null) {
            k.a("mBinding");
        }
        ImageView imageView4 = mpReportDownloadBottomSheetBinding9.customTickImg;
        k.b(imageView4, "mBinding.customTickImg");
        imageView4.setVisibility(8);
        MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding10 = this.mBinding;
        if (mpReportDownloadBottomSheetBinding10 == null) {
            k.a("mBinding");
        }
        ImageView imageView5 = mpReportDownloadBottomSheetBinding10.currentTickImg;
        k.b(imageView5, "mBinding.currentTickImg");
        imageView5.setVisibility(8);
        String str = this.currSelection;
        switch (str.hashCode()) {
            case -1778017348:
                if (str.equals(AppConstants.CUSTOM_DATE)) {
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding11 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding11 == null) {
                        k.a("mBinding");
                    }
                    TextView textView6 = mpReportDownloadBottomSheetBinding11.customHeader;
                    k.b(textView6, "mBinding.customHeader");
                    textView6.setTypeface(Typeface.DEFAULT_BOLD);
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding12 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding12 == null) {
                        k.a("mBinding");
                    }
                    ImageView imageView6 = mpReportDownloadBottomSheetBinding12.customTickImg;
                    k.b(imageView6, "mBinding.customTickImg");
                    imageView6.setVisibility(0);
                    return;
                }
                return;
            case -1621979774:
                if (str.equals(AppConstants.YESTERDAY)) {
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding13 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding13 == null) {
                        k.a("mBinding");
                    }
                    TextView textView7 = mpReportDownloadBottomSheetBinding13.yesterdayHeader;
                    k.b(textView7, "mBinding.yesterdayHeader");
                    textView7.setTypeface(Typeface.DEFAULT_BOLD);
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding14 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding14 == null) {
                        k.a("mBinding");
                    }
                    ImageView imageView7 = mpReportDownloadBottomSheetBinding14.yesterdayTickImg;
                    k.b(imageView7, "mBinding.yesterdayTickImg");
                    imageView7.setVisibility(0);
                    return;
                }
                return;
            case 3645428:
                if (str.equals("week")) {
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding15 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding15 == null) {
                        k.a("mBinding");
                    }
                    TextView textView8 = mpReportDownloadBottomSheetBinding15.weekHeader;
                    k.b(textView8, "mBinding.weekHeader");
                    textView8.setTypeface(Typeface.DEFAULT_BOLD);
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding16 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding16 == null) {
                        k.a("mBinding");
                    }
                    ImageView imageView8 = mpReportDownloadBottomSheetBinding16.weekTickImg;
                    k.b(imageView8, "mBinding.weekTickImg");
                    imageView8.setVisibility(0);
                    return;
                }
                return;
            case 41248326:
                if (str.equals(AppConstants.CURRENT_SELECTION)) {
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding17 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding17 == null) {
                        k.a("mBinding");
                    }
                    TextView textView9 = mpReportDownloadBottomSheetBinding17.currentHeader;
                    k.b(textView9, "mBinding.currentHeader");
                    textView9.setTypeface(Typeface.DEFAULT_BOLD);
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding18 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding18 == null) {
                        k.a("mBinding");
                    }
                    ImageView imageView9 = mpReportDownloadBottomSheetBinding18.currentTickImg;
                    k.b(imageView9, "mBinding.currentTickImg");
                    imageView9.setVisibility(0);
                    return;
                }
                return;
            case 110534465:
                if (str.equals("today")) {
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding19 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding19 == null) {
                        k.a("mBinding");
                    }
                    TextView textView10 = mpReportDownloadBottomSheetBinding19.todayHeader;
                    k.b(textView10, "mBinding.todayHeader");
                    textView10.setTypeface(Typeface.DEFAULT_BOLD);
                    MpReportDownloadBottomSheetBinding mpReportDownloadBottomSheetBinding20 = this.mBinding;
                    if (mpReportDownloadBottomSheetBinding20 == null) {
                        k.a("mBinding");
                    }
                    ImageView imageView10 = mpReportDownloadBottomSheetBinding20.todayTickImg;
                    k.b(imageView10, "mBinding.todayTickImg");
                    imageView10.setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
