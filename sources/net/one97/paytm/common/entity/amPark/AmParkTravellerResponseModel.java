package net.one97.paytm.common.entity.amPark;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AmParkTravellerResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "flag")
    private int flag = 0;
    @b(a = "form")
    private ArrayList<ArrayList<AmParkInputForm>> form;
    @b(a = "providerOid")
    private String providerOid;

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i2) {
        this.flag = i2;
    }

    public String getProviderOid() {
        return this.providerOid;
    }

    public void setProviderOid(String str) {
        this.providerOid = str;
    }

    public ArrayList<ArrayList<AmParkInputForm>> getForm() {
        return this.form;
    }

    public void setForm(ArrayList<ArrayList<AmParkInputForm>> arrayList) {
        this.form = arrayList;
    }

    public void parseJsonString(String str) {
        int i2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.flag = jSONObject.getInt("flag");
            if (this.flag == 0) {
                this.form = null;
            } else if (this.flag == 1) {
                if (jSONObject.has("providerOid")) {
                    this.providerOid = jSONObject.getString("providerOid");
                }
                JSONArray jSONArray = jSONObject.getJSONArray("form");
                this.form = new ArrayList<>();
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONArray jSONArray2 = jSONArray.getJSONArray(i3);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray3 = jSONArray;
                    int i4 = 0;
                    while (i4 < jSONArray2.length()) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                        JSONArray jSONArray4 = jSONArray2;
                        AmParkInputForm amParkInputForm = new AmParkInputForm();
                        if (jSONObject2.has("title")) {
                            i2 = i3;
                            amParkInputForm.setTitle(jSONObject2.getString("title"));
                        } else {
                            i2 = i3;
                        }
                        if (jSONObject2.has("type")) {
                            amParkInputForm.setType(jSONObject2.getString("type"));
                        }
                        if (jSONObject2.has("applied")) {
                            amParkInputForm.setApplied(jSONObject2.getString("applied"));
                        }
                        if (jSONObject2.has("id")) {
                            amParkInputForm.setId(jSONObject2.getString("id"));
                        }
                        if (jSONObject2.has("regex")) {
                            amParkInputForm.setRegex(jSONObject2.getString("regex"));
                        }
                        if (jSONObject2.has("hint")) {
                            amParkInputForm.setHint(jSONObject2.getString("hint"));
                        }
                        if (jSONObject2.has("label")) {
                            amParkInputForm.setLabel(jSONObject2.getString("label"));
                        }
                        if (jSONObject2.has("values")) {
                            populateValuesToForm(jSONObject2.get("values"), amParkInputForm);
                        }
                        if (jSONObject2.has("seat_id")) {
                            amParkInputForm.setSeatId(jSONObject2.getString("seat_id"));
                        }
                        if (jSONObject2.has("provider_seat_id")) {
                            amParkInputForm.setProviderSeatId(jSONObject2.getString("provider_seat_id"));
                        }
                        arrayList.add(amParkInputForm);
                        i4++;
                        jSONArray2 = jSONArray4;
                        i3 = i2;
                    }
                    int i5 = i3;
                    this.form.add(arrayList);
                    i3 = i5 + 1;
                    jSONArray = jSONArray3;
                }
            }
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
    }

    private void populateValuesToForm(Object obj, AmParkInputForm amParkInputForm) throws JSONException {
        if (obj != null && amParkInputForm != null) {
            String type = amParkInputForm.getType();
            if (!TextUtils.isEmpty(type)) {
                int i2 = 0;
                if (type.equalsIgnoreCase("checkbox")) {
                    JSONArray jSONArray = (JSONArray) obj;
                    ArrayList arrayList = new ArrayList();
                    while (i2 < jSONArray.length()) {
                        FormValuesData formValuesData = new FormValuesData();
                        formValuesData.setValue(jSONArray.getJSONObject(i2).getString("value"));
                        arrayList.add(formValuesData);
                        i2++;
                    }
                    amParkInputForm.setCheckBoxListValues(arrayList);
                } else if (type.equalsIgnoreCase("dropdown")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    ArrayList arrayList2 = new ArrayList();
                    while (i2 < jSONArray2.length()) {
                        arrayList2.add(jSONArray2.getString(i2));
                        i2++;
                    }
                    amParkInputForm.setDropDownListValues(arrayList2);
                } else if (type.equalsIgnoreCase("radio")) {
                    JSONArray jSONArray3 = (JSONArray) obj;
                    ArrayList arrayList3 = new ArrayList();
                    while (i2 < jSONArray3.length()) {
                        arrayList3.add(jSONArray3.getString(i2));
                        i2++;
                    }
                    amParkInputForm.setRadioListValues(arrayList3);
                }
            }
        }
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        AmParkTravellerResponseModel amParkTravellerResponseModel = new AmParkTravellerResponseModel();
        amParkTravellerResponseModel.parseJsonString(str);
        return amParkTravellerResponseModel;
    }
}
