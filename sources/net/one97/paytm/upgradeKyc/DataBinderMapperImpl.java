package net.one97.paytm.upgradeKyc;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.upgradeKyc.b.f;
import net.one97.paytm.upgradeKyc.b.h;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_BOTTOMSHEETVIDEOKYCCHECKLIST = 1;
    private static final int LAYOUT_FRAGMENTAGENTSTATUS = 2;
    private static final int LAYOUT_FRAGMENTAOTPEXITCONSENT = 3;
    private static final int LAYOUT_FRAGMENTEARLYAPPOINTMENTVIDEOKYC = 4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(4);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.bottomsheet_video_kyc_checklist, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_agent_status, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_aotp_exit_consent, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_early_appointment_video_kyc, 4);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    if ("layout/fragment_early_appointment_video_kyc_0".equals(tag)) {
                        return new h(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_early_appointment_video_kyc is invalid. Received: ".concat(String.valueOf(tag)));
                } else if ("layout/fragment_aotp_exit_consent_0".equals(tag)) {
                    return new f(eVar, view);
                } else {
                    throw new IllegalArgumentException("The tag for fragment_aotp_exit_consent is invalid. Received: ".concat(String.valueOf(tag)));
                }
            } else if ("layout/fragment_agent_status_0".equals(tag)) {
                return new net.one97.paytm.upgradeKyc.b.d(eVar, view);
            } else {
                throw new IllegalArgumentException("The tag for fragment_agent_status is invalid. Received: ".concat(String.valueOf(tag)));
            }
        } else if ("layout/bottomsheet_video_kyc_checklist_0".equals(tag)) {
            return new net.one97.paytm.upgradeKyc.b.b(eVar, view);
        } else {
            throw new IllegalArgumentException("The tag for bottomsheet_video_kyc_checklist is invalid. Received: ".concat(String.valueOf(tag)));
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f65184a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f65183a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f65183a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(3);
            f65183a = sparseArray;
            sparseArray.put(0, "_all");
            f65183a.put(1, "viewModel");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f65184a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(4);
            f65184a = hashMap;
            hashMap.put("layout/bottomsheet_video_kyc_checklist_0", Integer.valueOf(R.layout.bottomsheet_video_kyc_checklist));
            f65184a.put("layout/fragment_agent_status_0", Integer.valueOf(R.layout.fragment_agent_status));
            f65184a.put("layout/fragment_aotp_exit_consent_0", Integer.valueOf(R.layout.fragment_aotp_exit_consent));
            f65184a.put("layout/fragment_early_appointment_video_kyc_0", Integer.valueOf(R.layout.fragment_early_appointment_video_kyc));
        }
    }
}
