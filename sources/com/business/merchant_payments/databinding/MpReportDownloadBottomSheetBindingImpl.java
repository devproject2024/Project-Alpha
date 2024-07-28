package com.business.merchant_payments.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.business.merchant_payments.R;

public class MpReportDownloadBottomSheetBindingImpl extends MpReportDownloadBottomSheetBinding {
    public static final ViewDataBinding.b sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final LinearLayout mboundView0;

    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_payment, 1);
        sViewsWithIds.put(R.id.today_item, 2);
        sViewsWithIds.put(R.id.today_header, 3);
        sViewsWithIds.put(R.id.today_summary, 4);
        sViewsWithIds.put(R.id.today_tick_img, 5);
        sViewsWithIds.put(R.id.today_divider, 6);
        sViewsWithIds.put(R.id.yesterday_item, 7);
        sViewsWithIds.put(R.id.yesterday_header, 8);
        sViewsWithIds.put(R.id.yesterday_summary, 9);
        sViewsWithIds.put(R.id.yesterday_tick_img, 10);
        sViewsWithIds.put(R.id.yesterday_divider, 11);
        sViewsWithIds.put(R.id.week_item, 12);
        sViewsWithIds.put(R.id.week_header, 13);
        sViewsWithIds.put(R.id.week_summary, 14);
        sViewsWithIds.put(R.id.week_tick_img, 15);
        sViewsWithIds.put(R.id.week_divider, 16);
        sViewsWithIds.put(R.id.current_item, 17);
        sViewsWithIds.put(R.id.current_header, 18);
        sViewsWithIds.put(R.id.current_summary, 19);
        sViewsWithIds.put(R.id.current_tick_img, 20);
        sViewsWithIds.put(R.id.current_divider, 21);
        sViewsWithIds.put(R.id.custom_item, 22);
        sViewsWithIds.put(R.id.custom_header, 23);
        sViewsWithIds.put(R.id.custom_summary, 24);
        sViewsWithIds.put(R.id.custom_tick_img, 25);
        sViewsWithIds.put(R.id.custom_divider, 26);
        sViewsWithIds.put(R.id.download_btn, 27);
    }

    public MpReportDownloadBottomSheetBindingImpl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 28, sIncludes, sViewsWithIds));
    }

    public MpReportDownloadBottomSheetBindingImpl(e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[21], objArr[18], objArr[17], objArr[19], objArr[20], objArr[26], objArr[23], objArr[22], objArr[24], objArr[25], objArr[27], objArr[6], objArr[3], objArr[2], objArr[4], objArr[5], objArr[1], objArr[16], objArr[13], objArr[12], objArr[14], objArr[15], objArr[11], objArr[8], objArr[7], objArr[9], objArr[10]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
