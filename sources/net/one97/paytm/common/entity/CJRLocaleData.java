package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRLocaleData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "ERROR")
    public String ERROR;
    @b(a = "MESSAGE")
    public String MESSAGE;
    @b(a = "STATUS")
    public String STATUS;
    @b(a = "bn-IN")
    private ArrayList<LangEntity> banglaData;
    @b(a = "en-IN")
    private ArrayList<LangEntity> englishData;
    @b(a = "gu-IN")
    private ArrayList<LangEntity> gujaratiData;
    @b(a = "hasnext")
    public boolean hasNext;
    @b(a = "hi-IN")
    private ArrayList<LangEntity> hindiData;
    @b(a = "kn-IN")
    private ArrayList<LangEntity> kannadaData;
    @b(a = "ml-IN")
    private ArrayList<LangEntity> malayalamData;
    @b(a = "mr-IN")
    private ArrayList<LangEntity> marathiData;
    @b(a = "or-IN")
    private ArrayList<LangEntity> odiaData;
    @b(a = "pa-IN")
    private ArrayList<LangEntity> punjabiData;
    @b(a = "ta-IN")
    private ArrayList<LangEntity> tamilData;
    @b(a = "te-IN")
    private ArrayList<LangEntity> teluguData;

    public ArrayList<LangEntity> getData() {
        ArrayList<LangEntity> arrayList = this.hindiData;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<LangEntity> arrayList2 = this.englishData;
        if (arrayList2 != null) {
            return arrayList2;
        }
        ArrayList<LangEntity> arrayList3 = this.gujaratiData;
        if (arrayList3 != null) {
            return arrayList3;
        }
        ArrayList<LangEntity> arrayList4 = this.marathiData;
        if (arrayList4 != null) {
            return arrayList4;
        }
        ArrayList<LangEntity> arrayList5 = this.teluguData;
        if (arrayList5 != null) {
            return arrayList5;
        }
        ArrayList<LangEntity> arrayList6 = this.banglaData;
        if (arrayList6 != null) {
            return arrayList6;
        }
        ArrayList<LangEntity> arrayList7 = this.tamilData;
        if (arrayList7 != null) {
            return arrayList7;
        }
        ArrayList<LangEntity> arrayList8 = this.kannadaData;
        if (arrayList8 != null) {
            return arrayList8;
        }
        ArrayList<LangEntity> arrayList9 = this.malayalamData;
        if (arrayList9 != null) {
            return arrayList9;
        }
        ArrayList<LangEntity> arrayList10 = this.punjabiData;
        if (arrayList10 != null) {
            return arrayList10;
        }
        ArrayList<LangEntity> arrayList11 = this.odiaData;
        if (arrayList11 != null) {
            return arrayList11;
        }
        return null;
    }
}
