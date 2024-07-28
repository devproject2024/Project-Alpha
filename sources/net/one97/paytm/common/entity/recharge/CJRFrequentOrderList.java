package net.one97.paytm.common.entity.recharge;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;

public class CJRFrequentOrderList extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    public final String TAG_PAY_TYPE_POSTPAID = BaseViewModel.PaymentType.POSTPAID;
    public final String TAG_PAY_TYPE_PREPAID = "prepaid";
    public final String TAG_SERVICE_DATACARD = "DataCard";
    public final String TAG_SERVICE_DTH = "DTH";
    public final String TAG_SERVICE_ELECTRICITY = "Electricity";
    public final String TAG_SERVICE_GAS = "Gas";
    public final String TAG_SERVICE_LANDLINE = "Landline";
    public final String TAG_SERVICE_METRO = "Metro";
    public final String TAG_SERVICE_MOBILE = "mobile";
    @b(a = "orders")
    private List<CJRFrequentOrder> mOrderList = new ArrayList();

    public void clear() {
        List<CJRFrequentOrder> list = this.mOrderList;
        if (list != null) {
            list.clear();
        }
    }

    public List<CJRFrequentOrder> getOrderList() {
        return this.mOrderList;
    }

    public void setOrderList(List<CJRFrequentOrder> list) {
        this.mOrderList = list;
    }

    public ArrayList<CJRFrequentOrder> getPrepaidMobileOrdres() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null && next.getFrequentOrderProduct() != null && next.getPayType().equalsIgnoreCase("prepaid") && next.getService().equalsIgnoreCase("mobile")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getMobileOrders(String str) {
        if (TextUtils.isEmpty(str)) {
            return getMobileOrdres();
        }
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (!(next == null || next.getFrequentOrderProduct() == null)) {
                next.getPayType();
                String service = next.getService();
                if (!TextUtils.isEmpty(service) && (str.toLowerCase().equalsIgnoreCase(service.toLowerCase()) || str.toLowerCase().contains(service.toLowerCase()))) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getMobileOrdres() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null) {
                String payType = next.getPayType();
                String service = next.getService();
                if (next.getFrequentOrderProduct() != null && ((payType.equalsIgnoreCase("prepaid") || payType.equalsIgnoreCase(BaseViewModel.PaymentType.POSTPAID)) && service.equalsIgnoreCase("mobile"))) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getDatacardOrdres(String str) {
        if (TextUtils.isEmpty(str)) {
            return getDatacardOrdres();
        }
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null) {
                next.getPayType();
                String service = next.getService();
                if (!TextUtils.isEmpty(service) && (str.toLowerCase().equalsIgnoreCase(service.toLowerCase()) || str.toLowerCase().contains(service.toLowerCase()))) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getDatacardOrdres() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (!(next == null || next.getFrequentOrderProduct() == null || next.getPayType() == null || next.getService() == null)) {
                String payType = next.getPayType();
                String service = next.getService();
                if ((payType.equalsIgnoreCase("prepaid") || payType.equalsIgnoreCase(BaseViewModel.PaymentType.POSTPAID)) && service.equalsIgnoreCase("DataCard")) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPostpaidMobileOrders() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (!(next == null || next.getFrequentOrderProduct() == null || next.getPayType() == null || next.getService() == null || !next.getPayType().equalsIgnoreCase(BaseViewModel.PaymentType.POSTPAID) || !next.getService().equalsIgnoreCase("mobile"))) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getDTHOrders(String str) {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null) {
                String service = next.getService();
                if (!TextUtils.isEmpty(service) && (str.toLowerCase().equalsIgnoreCase(service.toLowerCase()) || str.toLowerCase().contains(service.toLowerCase()))) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPrepaidDTHOrdres() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (!(next == null || next.getFrequentOrderProduct() == null || next.getPayType() == null || next.getService() == null || !next.getPayType().equalsIgnoreCase("prepaid") || !next.getService().equalsIgnoreCase("DTH"))) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPostpaidDTHOrders() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (!(next == null || next.getFrequentOrderProduct() == null || next.getPayType() == null || next.getService() == null || !next.getPayType().equalsIgnoreCase(BaseViewModel.PaymentType.POSTPAID) || !next.getService().equalsIgnoreCase("DTH"))) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPrepaidDatacardOrdres() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (!(next == null || next.getFrequentOrderProduct() == null || next.getPayType() == null || next.getService() == null || !next.getPayType().equalsIgnoreCase("prepaid") || !next.getService().equalsIgnoreCase("DataCard"))) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPostpaidDatacardOrders() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (!(next == null || next.getFrequentOrderProduct() == null || next.getPayType() == null || next.getService() == null || !next.getPayType().equalsIgnoreCase(BaseViewModel.PaymentType.POSTPAID) || !next.getService().equalsIgnoreCase("DataCard"))) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPrepaidLandlineOrdres() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null && next.getFrequentOrderProduct() != null && next.getPayType().equalsIgnoreCase("prepaid") && next.getService().equalsIgnoreCase("Landline")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPostpaidLandlineOrders() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null && next.getFrequentOrderProduct() != null && next.getPayType().equalsIgnoreCase(BaseViewModel.PaymentType.POSTPAID) && next.getService().equalsIgnoreCase("Landline")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPrepaidElectricityOrdres() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null && next.getFrequentOrderProduct() != null && next.getPayType().equalsIgnoreCase("prepaid") && next.getService().equalsIgnoreCase("Electricity")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPostpaidElectricityOrders() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null && next.getFrequentOrderProduct() != null && next.getPayType().equalsIgnoreCase(BaseViewModel.PaymentType.POSTPAID) && next.getService().equalsIgnoreCase("Electricity")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPrepaidGasOrdres() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null && next.getFrequentOrderProduct() != null && next.getPayType().equalsIgnoreCase("prepaid") && next.getService().equalsIgnoreCase("Gas")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPostpaidGasOrders() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null && next.getFrequentOrderProduct() != null && next.getPayType().equalsIgnoreCase(BaseViewModel.PaymentType.POSTPAID) && next.getService().equalsIgnoreCase("Gas")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public ArrayList<CJRFrequentOrder> getPrepaidMetroCardOrders() {
        ArrayList<CJRFrequentOrder> arrayList = new ArrayList<>();
        for (CJRFrequentOrder next : this.mOrderList) {
            if (next != null && next.getFrequentOrderProduct() != null && next.getPayType().equalsIgnoreCase("prepaid") && next.getService().equalsIgnoreCase("Metro")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        try {
            CJRFrequentOrder[] cJRFrequentOrderArr = (CJRFrequentOrder[]) fVar.a(str, CJRFrequentOrder[].class);
            if (cJRFrequentOrderArr != null) {
                setOrderList(new ArrayList(Arrays.asList(cJRFrequentOrderArr)));
                return this;
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return super.parseResponse(str, fVar);
    }
}
