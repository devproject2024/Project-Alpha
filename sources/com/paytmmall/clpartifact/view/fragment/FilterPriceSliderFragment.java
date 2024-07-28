package com.paytmmall.clpartifact.view.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.CustomDialog;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.paytmmall.clpartifact.databinding.FragmentFilterPriceBinding;
import com.paytmmall.clpartifact.listeners.IFilterValueListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Locale;

public class FilterPriceSliderFragment extends FilterDetailFragment implements IFilterValueListener {
    public static final String RUPEE_SYMBOL = "₹";
    public static final String TITLE = "title";
    private static boolean fired = false;
    private CJRFilterItem mFilterItem;
    private FragmentFilterPriceBinding mFragmentBinding;
    private int mInitialFrom;
    private int mInitialTo;
    private PriceRangeSeekBar<Integer> mRangeBar;
    private int mSelectedFrom;
    private int mSelectedTo;

    public static FilterDetailFragment getInstance(CJRFilterItem cJRFilterItem) {
        FilterPriceSliderFragment filterPriceSliderFragment = new FilterPriceSliderFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLPConstants.KEY_FILTER_ITEM, cJRFilterItem);
        filterPriceSliderFragment.setArguments(bundle);
        return filterPriceSliderFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mFragmentBinding = (FragmentFilterPriceBinding) f.a(layoutInflater, R.layout.fragment_filter_price, viewGroup, false);
        this.mFilterItem = getFilterItem();
        setupPriceSlider();
        return this.mFragmentBinding.getRoot();
    }

    private void setupPriceSlider() {
        this.mRangeBar = this.mFragmentBinding.seekBar;
        CJRFilterValue filterAppliedRange = this.mFilterItem.getFilterAppliedRange();
        setRange(this.mRangeBar, this.mFilterItem.getFilterValues().get(0), filterAppliedRange);
        setRupeeSymbol();
        this.mRangeBar.setOnRangeSeekBarChangeListener(new PriceRangeSeekBar.OnRangeSeekBarChangeListener() {
            public final void onRangeSeekBarValuesChanged(PriceRangeSeekBar priceRangeSeekBar, Object obj, Object obj2) {
                FilterPriceSliderFragment.this.lambda$setupPriceSlider$0$FilterPriceSliderFragment(priceRangeSeekBar, (Integer) obj, (Integer) obj2);
            }
        });
        this.mRangeBar.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return FilterPriceSliderFragment.this.lambda$setupPriceSlider$1$FilterPriceSliderFragment(view, motionEvent);
            }
        });
        addTextWatcher();
        this.mRangeBar.setNotifyWhileDragging(true);
    }

    public /* synthetic */ void lambda$setupPriceSlider$0$FilterPriceSliderFragment(PriceRangeSeekBar priceRangeSeekBar, Integer num, Integer num2) {
        this.mSelectedFrom = num.intValue();
        this.mSelectedTo = num2.intValue();
        updateEditText();
        this.mRangeBar.setSelected(true);
        this.mRangeBar.setNotifyWhileDragging(true);
    }

    public /* synthetic */ boolean lambda$setupPriceSlider$1$FilterPriceSliderFragment(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        GaHandler.getInstance().fireFilterPriceRangeChanged(String.valueOf(this.mSelectedFrom), String.valueOf(this.mSelectedTo));
        return false;
    }

    private void setRupeeSymbol() {
        Drawable symbol = getSymbol(this.mFragmentBinding.getRoot().getContext(), RUPEE_SYMBOL, this.mFragmentBinding.fromTxt.getTextSize(), this.mFragmentBinding.fromTxt.getCurrentTextColor());
        this.mFragmentBinding.fromTxt.setCompoundDrawablesWithIntrinsicBounds(symbol, (Drawable) null, (Drawable) null, (Drawable) null);
        this.mFragmentBinding.toTxt.setCompoundDrawablesWithIntrinsicBounds(symbol, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private Drawable getSymbol(Context context, String str, float f2, int i2) {
        Paint paint = new Paint(1);
        paint.setTextSize(f2);
        paint.setColor(i2);
        paint.setTextAlign(Paint.Align.LEFT);
        float f3 = -paint.ascent();
        Bitmap createBitmap = Bitmap.createBitmap((int) (paint.measureText(str) + 0.5f), (int) (paint.descent() + f3 + 0.5f), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawText(str, 0.0f, f3, paint);
        return new BitmapDrawable(context.getResources(), createBitmap);
    }

    private void addTextWatcher() {
        this.mFragmentBinding.fromTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                FilterPriceSliderFragment.this.lambda$addTextWatcher$2$FilterPriceSliderFragment(view, z);
            }
        });
        this.mFragmentBinding.toTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                FilterPriceSliderFragment.this.lambda$addTextWatcher$3$FilterPriceSliderFragment(view, z);
            }
        });
    }

    public /* synthetic */ void lambda$addTextWatcher$2$FilterPriceSliderFragment(View view, boolean z) {
        if (!z) {
            if (validEnteredValue(this.mSelectedTo, getValidValue(this.mFragmentBinding.fromTxt.getText(), this.mSelectedFrom))) {
                updateRangeSelection();
            }
        }
    }

    public /* synthetic */ void lambda$addTextWatcher$3$FilterPriceSliderFragment(View view, boolean z) {
        if (!z && validEnteredValue(getValidValue(this.mFragmentBinding.toTxt.getText(), this.mSelectedTo), this.mSelectedFrom)) {
            updateRangeSelection();
        }
    }

    private int getValidValue(Editable editable, int i2) {
        if (editable == null) {
            return i2;
        }
        String obj = editable.toString();
        if (obj.contains(RUPEE_SYMBOL)) {
            obj = obj.substring(1);
        }
        try {
            return TextUtils.isDigitsOnly(obj) ? Integer.parseInt(obj) : i2;
        } catch (Exception unused) {
            return Integer.MAX_VALUE;
        }
    }

    private void setRange(PriceRangeSeekBar<Integer> priceRangeSeekBar, CJRFilterValue cJRFilterValue, CJRFilterValue cJRFilterValue2) {
        this.mInitialFrom = cJRFilterValue.getAbsoluteMin();
        this.mInitialTo = cJRFilterValue.getAbsoluteMax();
        int i2 = this.mInitialFrom;
        this.mSelectedFrom = i2;
        this.mSelectedTo = this.mInitialTo;
        priceRangeSeekBar.setRangeValues(Integer.valueOf(i2), Integer.valueOf(this.mInitialTo));
        if (!(cJRFilterValue2 == null || cJRFilterValue2.getAbsoluteMax() == -1)) {
            int absoluteMin = cJRFilterValue2.getAbsoluteMin();
            int i3 = this.mInitialFrom;
            if (absoluteMin >= i3) {
                i3 = cJRFilterValue2.getAbsoluteMin();
            }
            this.mSelectedFrom = i3;
            int absoluteMax = cJRFilterValue2.getAbsoluteMax();
            int i4 = this.mInitialTo;
            if (absoluteMax <= i4) {
                i4 = cJRFilterValue2.getAbsoluteMax();
            }
            this.mSelectedTo = i4;
            updateRangeSelection();
        }
        updateEditText();
    }

    private void updateEditText() {
        FragmentFilterPriceBinding fragmentFilterPriceBinding = this.mFragmentBinding;
        if (fragmentFilterPriceBinding != null) {
            fragmentFilterPriceBinding.setInitialFrom(String.valueOf(this.mSelectedFrom));
            this.mFragmentBinding.setInitialTo(String.valueOf(this.mSelectedTo));
        }
    }

    private void fireGA() {
        CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents(this.mFragmentBinding.getRoot().getContext(), "product_grid", "price_range_selected", "Price", "", "grid screen", GAUtil.MARKET_PLACE);
    }

    private void updateRangeSelection() {
        PriceRangeSeekBar<Integer> priceRangeSeekBar = this.mRangeBar;
        if (priceRangeSeekBar != null) {
            priceRangeSeekBar.setSelectedMinValue(Integer.valueOf(this.mSelectedFrom));
            this.mRangeBar.setSelectedMaxValue(Integer.valueOf(this.mSelectedTo));
        }
    }

    private boolean validEnteredValue(int i2, int i3) {
        if (!isValidRange(i2, i3)) {
            showErrorPopup();
            updateEditText();
            return false;
        }
        this.mSelectedFrom = i3;
        this.mSelectedTo = i2;
        return true;
    }

    private void showErrorPopup() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            CustomDialog.showPrompt(activity, String.format(Locale.getDefault(), "Enter the price range value between %1$d and %2$d", new Object[]{Integer.valueOf(this.mInitialFrom), Integer.valueOf(this.mInitialTo)}));
        }
    }

    private boolean isValidRange(int i2, int i3) {
        return isValidValue(i3) && isValidValue(i2);
    }

    private boolean isValidValue(int i2) {
        return i2 >= this.mInitialFrom && i2 <= this.mInitialTo;
    }

    private CJRFilterItem getFilterItem() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey(CLPConstants.KEY_FILTER_ITEM)) {
            return null;
        }
        return (CJRFilterItem) arguments.get(CLPConstants.KEY_FILTER_ITEM);
    }

    public Pair<String, String> getUpdatedFilterValues() {
        if (!fired) {
            fired = true;
            fireGA();
        }
        return new Pair<>(this.mFilterItem.getFilterParam(), getFilterValue());
    }

    private String getFilterValue() {
        int validValue = getValidValue(this.mFragmentBinding.fromTxt.getText(), this.mInitialFrom);
        int validValue2 = getValidValue(this.mFragmentBinding.toTxt.getText(), this.mInitialTo);
        if (!validEnteredValue(validValue2, validValue)) {
            return CLPConstants.INVALID_FILTER_VALUE;
        }
        CJRFilterValue cJRFilterValue = this.mFilterItem.getFilterValues().get(0);
        if (validValue == cJRFilterValue.getAbsoluteMin() && validValue2 == cJRFilterValue.getAbsoluteMax()) {
            return "";
        }
        return validValue + AppConstants.COMMA + validValue2;
    }

    public void onClear(CJRFilterItem cJRFilterItem) {
        this.mFilterItem = cJRFilterItem;
        this.mSelectedFrom = this.mInitialFrom;
        this.mSelectedTo = this.mInitialTo;
        updateEditText();
        updateRangeSelection();
    }
}
