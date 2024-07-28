package com.travel.common;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f23405a = new HashMap<>(0);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f23405a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f23404a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f23404a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(31);
            f23404a = sparseArray;
            sparseArray.put(0, "_all");
            f23404a.put(1, "emiViewModel");
            f23404a.put(2, "instrumentSheetViewModel");
            f23404a.put(3, "section");
            f23404a.put(4, "transcationViewModel");
            f23404a.put(5, "allNetBankingViewModel");
            f23404a.put(6, "bankMandateIfscCodeViewModel");
            f23404a.put(7, "codViewModel");
            f23404a.put(8, "view");
            f23404a.put(9, "netBankingViewModel");
            f23404a.put(10, "netbanking");
            f23404a.put(11, "saveCardModel");
            f23404a.put(12, "model");
            f23404a.put(13, "showInstrumentInfoMsg");
            f23404a.put(14, "a");
            f23404a.put(15, "otpViewholder");
            f23404a.put(16, "pincvvmodel");
            f23404a.put(17, "bank_mandate");
            f23404a.put(18, "debitCardModel");
            f23404a.put(19, "selectedInstrumentSheetViewModel");
            f23404a.put(20, "typeface");
            f23404a.put(21, "aoaWalletViewModel");
            f23404a.put(22, "bankViewModel");
            f23404a.put(23, "landingPageViewModel");
            f23404a.put(24, "walletViewModel");
            f23404a.put(25, "digitalCreditModel");
            f23404a.put(26, "cvvHelpModel");
            f23404a.put(27, "bankMandateSubDetailsViewModel");
            f23404a.put(28, "upiHelpModel");
            f23404a.put(29, "upiCollectModel");
        }
    }
}
