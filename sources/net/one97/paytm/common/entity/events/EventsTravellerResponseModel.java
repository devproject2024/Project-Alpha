package net.one97.paytm.common.entity.events;

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

public class EventsTravellerResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "flag")
    private int flag = 0;
    @b(a = "form")
    private ArrayList<ArrayList<EventsInputForm>> form;
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

    public ArrayList<ArrayList<EventsInputForm>> getForm() {
        return this.form;
    }

    public void setForm(ArrayList<ArrayList<EventsInputForm>> arrayList) {
        this.form = arrayList;
    }

    public void parseJsonString(String str) {
        JSONArray jSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("flag")) {
                this.flag = jSONObject.getInt("flag");
            }
            if (this.flag == 0) {
                this.form = null;
            } else if (this.flag == 1) {
                this.providerOid = jSONObject.getString("providerOid");
                JSONArray jSONArray2 = jSONObject.getJSONArray("form");
                this.form = new ArrayList<>();
                int i2 = 0;
                while (i2 < jSONArray2.length()) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    for (JSONArray jSONArray3 = jSONArray2.getJSONArray(i2); i3 < jSONArray3.length(); jSONArray3 = jSONArray) {
                        JSONObject jSONObject2 = jSONArray3.getJSONObject(i3);
                        JSONArray jSONArray4 = jSONArray2;
                        EventsInputForm eventsInputForm = new EventsInputForm();
                        if (jSONObject2.has("title")) {
                            jSONArray = jSONArray3;
                            eventsInputForm.setTitle(jSONObject2.getString("title"));
                        } else {
                            jSONArray = jSONArray3;
                        }
                        if (jSONObject2.has("type")) {
                            eventsInputForm.setType(jSONObject2.getString("type"));
                        }
                        if (jSONObject2.has("applied")) {
                            eventsInputForm.setApplied(jSONObject2.getString("applied"));
                        }
                        if (jSONObject2.has("id")) {
                            eventsInputForm.setId(jSONObject2.getString("id"));
                        }
                        if (jSONObject2.has("regex")) {
                            eventsInputForm.setRegex(jSONObject2.getString("regex"));
                        }
                        if (jSONObject2.has("values")) {
                            populateValuesToForm(jSONObject2.get("values"), eventsInputForm);
                        }
                        if (jSONObject2.has("seat_id")) {
                            eventsInputForm.setSeatId(jSONObject2.getString("seat_id"));
                        }
                        if (jSONObject2.has("provider_seat_id")) {
                            eventsInputForm.setProviderSeatId(jSONObject2.getString("provider_seat_id"));
                        }
                        if (jSONObject2.has("info_type")) {
                            eventsInputForm.setInfoType(jSONObject2.getString("info_type"));
                        }
                        arrayList.add(eventsInputForm);
                        i3++;
                        jSONArray2 = jSONArray4;
                    }
                    JSONArray jSONArray5 = jSONArray2;
                    this.form.add(arrayList);
                    i2++;
                    jSONArray2 = jSONArray5;
                }
            }
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
    }

    private void populateValuesToForm(Object obj, EventsInputForm eventsInputForm) throws JSONException {
        if (obj != null && eventsInputForm != null) {
            String type = eventsInputForm.getType();
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
                    eventsInputForm.setCheckBoxListValues(arrayList);
                } else if (type.equalsIgnoreCase("dropdown")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    ArrayList arrayList2 = new ArrayList();
                    while (i2 < jSONArray2.length()) {
                        arrayList2.add(jSONArray2.getString(i2));
                        i2++;
                    }
                    eventsInputForm.setDropDownListValues(arrayList2);
                } else if (type.equalsIgnoreCase("radio")) {
                    JSONArray jSONArray3 = (JSONArray) obj;
                    ArrayList arrayList3 = new ArrayList();
                    while (i2 < jSONArray3.length()) {
                        arrayList3.add(jSONArray3.getString(i2));
                        i2++;
                    }
                    eventsInputForm.setRadioListValues(arrayList3);
                }
            }
        }
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        EventsTravellerResponseModel eventsTravellerResponseModel = new EventsTravellerResponseModel();
        eventsTravellerResponseModel.parseJsonString(str);
        return eventsTravellerResponseModel;
    }
}
