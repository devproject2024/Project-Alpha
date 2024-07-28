package com.business.merchant_payments.newhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.business.common_module.a.a.a;
import com.business.common_module.a.a.b;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.view.ReportDownloadBottomSheet;
import com.business.merchant_payments.utility.MPConstants;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.Date;
import java.util.HashMap;
import kotlin.g.b.k;

public final class SelectDateBottomSheet extends CustomBottomSheetDialogFragment {
    public HashMap _$_findViewCache;
    public TextView bottosheetHeader;
    public String currSelection = AppConstants.CUSTOM_DATE;
    public TextView downloadButton;
    public String endDate;
    public String headerText;
    public AppCompatImageView imageArrow;
    public boolean isDownloadReportFlow;
    public TextView listItemThisMonth;
    public TextView listItemThisWeek;
    public TextView listItemToday;
    public TextView listItemYesterday;
    public b mCalenderUtil;
    public ReportDownloadBottomSheet.IReportDownloadListener mListener;
    public String startDate;

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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.mp_bottomsheet_select_date, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.d(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) _$_findCachedViewById(R.id.header_select_date_range);
        k.b(textView, "header_select_date_range");
        this.bottosheetHeader = textView;
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.list_item_today);
        k.b(textView2, "list_item_today");
        this.listItemToday = textView2;
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.list_item_yesterday);
        k.b(textView3, "list_item_yesterday");
        this.listItemYesterday = textView3;
        TextView textView4 = (TextView) _$_findCachedViewById(R.id.list_item_this_week);
        k.b(textView4, "list_item_this_week");
        this.listItemThisWeek = textView4;
        TextView textView5 = (TextView) _$_findCachedViewById(R.id.list_item_this_month);
        k.b(textView5, "list_item_this_month");
        this.listItemThisMonth = textView5;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.image_arrow);
        k.b(appCompatImageView, "image_arrow");
        this.imageArrow = appCompatImageView;
        TextView textView6 = (TextView) _$_findCachedViewById(R.id.download_btn);
        k.b(textView6, "download_btn");
        this.downloadButton = textView6;
        initUI();
        initOnClicks();
    }

    public final void initUI() {
        if (this.headerText != null) {
            TextView textView = this.bottosheetHeader;
            if (textView == null) {
                k.a("bottosheetHeader");
            }
            textView.setText(this.headerText);
        }
        setDownloadTextForCalendar();
        if (this.isDownloadReportFlow) {
            TextView textView2 = this.downloadButton;
            if (textView2 == null) {
                k.a("downloadButton");
            }
            textView2.setVisibility(0);
        }
        TextView textView3 = this.listItemToday;
        if (textView3 == null) {
            k.a("listItemToday");
        }
        textView3.setText(getString(R.string.mp_today_date, DateUtility.getCurrentFormattedDate("dd MMMM", DateUtility.getAppLocale())));
        TextView textView4 = this.listItemYesterday;
        if (textView4 == null) {
            k.a("listItemYesterday");
        }
        textView4.setText(getString(R.string.mp_yesterday_date, DateUtility.getYesterdayStartDate("dd MMMM", DateUtility.getAppLocale())));
        TextView textView5 = this.listItemThisWeek;
        if (textView5 == null) {
            k.a("listItemThisWeek");
        }
        textView5.setText(getString(R.string.mp_this_week_date, DateUtility.getWeek("dd MMMM")));
        TextView textView6 = this.listItemThisMonth;
        if (textView6 == null) {
            k.a("listItemThisMonth");
        }
        textView6.setText(getString(R.string.mp_this_month_date, DateUtility.getCurrentMonthName()));
    }

    private final void initOnClicks() {
        ((TextView) _$_findCachedViewById(R.id.list_item_select_range)).setOnClickListener(new SelectDateBottomSheet$initOnClicks$1(this));
        AppCompatImageView appCompatImageView = this.imageArrow;
        if (appCompatImageView == null) {
            k.a("imageArrow");
        }
        appCompatImageView.setOnClickListener(new SelectDateBottomSheet$initOnClicks$2(this));
        TextView textView = this.listItemToday;
        if (textView == null) {
            k.a("listItemToday");
        }
        textView.setOnClickListener(new SelectDateBottomSheet$initOnClicks$3(this));
        TextView textView2 = this.listItemYesterday;
        if (textView2 == null) {
            k.a("listItemYesterday");
        }
        textView2.setOnClickListener(new SelectDateBottomSheet$initOnClicks$4(this));
        TextView textView3 = this.listItemThisWeek;
        if (textView3 == null) {
            k.a("listItemThisWeek");
        }
        textView3.setOnClickListener(new SelectDateBottomSheet$initOnClicks$5(this));
        TextView textView4 = this.listItemThisMonth;
        if (textView4 == null) {
            k.a("listItemThisMonth");
        }
        textView4.setOnClickListener(new SelectDateBottomSheet$initOnClicks$6(this));
        TextView textView5 = this.downloadButton;
        if (textView5 == null) {
            k.a("downloadButton");
        }
        textView5.setOnClickListener(new SelectDateBottomSheet$initOnClicks$7(this));
    }

    /* access modifiers changed from: private */
    public final void handleOnClick(Date date, Date date2) {
        if (!this.isDownloadReportFlow) {
            b bVar = this.mCalenderUtil;
            if (bVar != null) {
                String str = this.currSelection;
                k.d(date, "mStartDate");
                k.d(date2, "mEndDate");
                k.d(str, "identifier");
                bVar.f7290f.onCustomDateSelected(b.a(date, bVar.f7287c), b.a(date2, bVar.f7287c), str);
            }
            dismissAllowingStateLoss();
            return;
        }
        b bVar2 = this.mCalenderUtil;
        if (bVar2 != null) {
            bVar2.a(this.currSelection);
        }
        String stringFromDate = DateUtility.getStringFromDate(date, "dd MMMM");
        k.b(stringFromDate, "DateUtility.getStringFro…ate, P4B_NEW_DATE_FORMAT)");
        String stringFromDate2 = DateUtility.getStringFromDate(date2, "dd MMMM");
        k.b(stringFromDate2, "DateUtility.getStringFro…ate, P4B_NEW_DATE_FORMAT)");
        setDownloadButtonText(stringFromDate, stringFromDate2);
    }

    /* access modifiers changed from: private */
    public final void downloadReportForCurrentSelection() {
        ReportDownloadBottomSheet.IReportDownloadListener iReportDownloadListener;
        ReportDownloadBottomSheet.IReportDownloadListener iReportDownloadListener2;
        ReportDownloadBottomSheet.IReportDownloadListener iReportDownloadListener3;
        ReportDownloadBottomSheet.IReportDownloadListener iReportDownloadListener4;
        ReportDownloadBottomSheet.IReportDownloadListener iReportDownloadListener5;
        String str = this.currSelection;
        switch (str.hashCode()) {
            case -1778017348:
                if (str.equals(AppConstants.CUSTOM_DATE) && (iReportDownloadListener = this.mListener) != null) {
                    iReportDownloadListener.onRangeSelected(AppConstants.CUSTOM_DATE);
                    break;
                }
            case -1621979774:
                if (str.equals(AppConstants.YESTERDAY) && (iReportDownloadListener2 = this.mListener) != null) {
                    iReportDownloadListener2.onRangeSelected(AppConstants.YESTERDAY);
                    break;
                }
            case 3645428:
                if (str.equals("week") && (iReportDownloadListener3 = this.mListener) != null) {
                    iReportDownloadListener3.onRangeSelected("week");
                    break;
                }
            case 104080000:
                if (str.equals(MPConstants.PaymentSummaryRange.MONTH) && (iReportDownloadListener4 = this.mListener) != null) {
                    iReportDownloadListener4.onRangeSelected(MPConstants.PaymentSummaryRange.MONTH);
                    break;
                }
            case 110534465:
                if (str.equals("today") && (iReportDownloadListener5 = this.mListener) != null) {
                    iReportDownloadListener5.onRangeSelected("today");
                    break;
                }
        }
        ReportDownloadBottomSheet.IReportDownloadListener iReportDownloadListener6 = this.mListener;
        if (iReportDownloadListener6 != null) {
            iReportDownloadListener6.onDownloadClicked();
        }
    }

    private final void setDownloadButtonText(String str, String str2) {
        String str3 = str + '-' + str2;
        if (!k.a((Object) str, (Object) str2)) {
            str = str3;
        }
        TextView textView = this.downloadButton;
        if (textView == null) {
            k.a("downloadButton");
        }
        textView.setText(getString(R.string.mp_download_for, str));
    }

    public final void setDownloadTextForCalendar() {
        String str = this.startDate;
        if (str != null) {
            String formattedDate = DateUtility.getFormattedDate(str, "dd MMM yy", "dd MMMM");
            String str2 = this.endDate;
            if (str2 != null) {
                String formattedDate2 = DateUtility.getFormattedDate(str2, "dd MMM yy", "dd MMMM");
                this.currSelection = AppConstants.CUSTOM_DATE;
                k.b(formattedDate, "formattedStartDate");
                k.b(formattedDate2, "formattedEndDate");
                setDownloadButtonText(formattedDate, formattedDate2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void openCalender() {
        if (!this.isDownloadReportFlow) {
            b bVar = this.mCalenderUtil;
            if (bVar != null) {
                bVar.a(a.f7279a, a.f7282d);
            }
            dismissAllowingStateLoss();
        } else {
            this.currSelection = AppConstants.CUSTOM_DATE;
            ReportDownloadBottomSheet.IReportDownloadListener iReportDownloadListener = this.mListener;
            if (iReportDownloadListener != null) {
                iReportDownloadListener.onCustomDateClicked();
            }
        }
        b bVar2 = this.mCalenderUtil;
        if (bVar2 != null) {
            bVar2.a(AppConstants.CUSTOM_DATE);
        }
    }

    public final void setCalenderUtl(b bVar) {
        this.mCalenderUtil = bVar;
    }

    public final void setDownloadListener(ReportDownloadBottomSheet.IReportDownloadListener iReportDownloadListener) {
        k.d(iReportDownloadListener, "downloadListener");
        this.mListener = iReportDownloadListener;
    }

    public final void setBottomSheetTitle(String str) {
        k.d(str, H5Logger.HEADER);
        this.headerText = str;
    }

    public final void isDownloadReportFlow(boolean z) {
        this.isDownloadReportFlow = z;
    }

    public final void setDates(String str, String str2) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        this.startDate = str;
        this.endDate = str2;
    }
}
