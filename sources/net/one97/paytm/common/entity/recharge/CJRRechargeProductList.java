package net.one97.paytm.common.entity.recharge;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRRechargeProductList extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    private String mJsonPostpaidString;
    private String mJsonPrepaidString;
    private String mPostpaidUrlType;
    private String mPrepaidUrlType;
    Map<String, ArrayList<CJRRechargeProduct>> mProductsBasedonCategory;
    @b(a = "operators")
    private ArrayList<CJRRechargeProduct> mRechargeProduct;
    private Long mServerResponseTime;
    private String mUrlType;

    public String getName() {
        return null;
    }

    public void setUrlType(String str) {
        this.mUrlType = str;
    }

    public String getmPrepaidUrlType() {
        return this.mPrepaidUrlType;
    }

    public void setmPrepaidUrlType(String str) {
        this.mPrepaidUrlType = str;
    }

    public void setmPostpaidUrlType(String str) {
        this.mPostpaidUrlType = str;
    }

    public String getUrlType() {
        return this.mUrlType;
    }

    public Long getServerResponseTime() {
        return this.mServerResponseTime;
    }

    public void setServerResponseTime(Long l) {
        this.mServerResponseTime = l;
    }

    public ArrayList<CJRRechargeProduct> getRechargeProduct() {
        if (this.mRechargeProduct == null) {
            this.mRechargeProduct = new ArrayList<>();
        }
        return this.mRechargeProduct;
    }

    public void setRechargeProduct(ArrayList<CJRRechargeProduct> arrayList) {
        this.mRechargeProduct = arrayList;
    }

    public void filterOperatorList() {
        if (this.mRechargeProduct == null) {
            this.mRechargeProduct = new ArrayList<>();
        }
        int size = this.mRechargeProduct.size();
        this.mProductsBasedonCategory = new LinkedHashMap();
        for (int i2 = 0; i2 < size; i2++) {
            CJRRechargeProduct cJRRechargeProduct = this.mRechargeProduct.get(i2);
            String productType = cJRRechargeProduct.getProductType();
            if (!TextUtils.isEmpty(productType)) {
                String str = productType.split("-")[0];
                if (str != null) {
                    str = str.toLowerCase().trim();
                }
                ArrayList arrayList = this.mProductsBasedonCategory.get(str);
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(cJRRechargeProduct);
                    this.mProductsBasedonCategory.put(str, arrayList2);
                } else {
                    arrayList.add(cJRRechargeProduct);
                    this.mProductsBasedonCategory.put(str, arrayList);
                }
            }
        }
    }

    public void filterCircleList() {
        if (this.mRechargeProduct == null) {
            this.mRechargeProduct = new ArrayList<>();
        }
        int size = this.mRechargeProduct.size();
        for (int i2 = 0; i2 < size; i2++) {
            CJRRechargeProduct cJRRechargeProduct = this.mRechargeProduct.get(i2);
            ArrayList<CJRRechargeProduct> productList = cJRRechargeProduct.getConfiguration().getProductList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size2 = productList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                CJRRechargeProduct cJRRechargeProduct2 = productList.get(i3);
                if (cJRRechargeProduct2.getCircle() == null) {
                    cJRRechargeProduct2.setCircle(StringSet.all);
                }
                ArrayList arrayList = (ArrayList) linkedHashMap.get(cJRRechargeProduct2.getCircle());
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(cJRRechargeProduct2);
                    linkedHashMap.put(cJRRechargeProduct2.getCircle(), arrayList2);
                } else {
                    arrayList.add(cJRRechargeProduct2);
                    linkedHashMap.put(cJRRechargeProduct2.getCircle(), arrayList);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (String str : linkedHashMap.keySet()) {
                CJRCircle cJRCircle = new CJRCircle();
                cJRCircle.setName(str);
                cJRCircle.setCongigList((ArrayList) linkedHashMap.get(str));
                arrayList3.add(cJRCircle);
            }
            cJRRechargeProduct.setCircles(arrayList3);
        }
    }

    public void setJsonPostpaidString(String str) {
        this.mJsonPostpaidString = str;
    }

    public void setJsonPrepaidString(String str) {
        this.mJsonPrepaidString = str;
    }

    public String getJsonPostpaidString() {
        return this.mJsonPostpaidString;
    }

    public String getJsonPrepaidString() {
        return this.mJsonPrepaidString;
    }
}
