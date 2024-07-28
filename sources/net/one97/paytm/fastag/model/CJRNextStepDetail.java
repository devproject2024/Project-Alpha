package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRNextStepDetail extends IJRPaytmDataModel {
    @b(a = "Subtitles")
    private ArrayList<CJRNextStepSubtitle> nextStepSubtitles;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRNextStepSubtitle> getNextStepSubtitles() {
        return this.nextStepSubtitles;
    }
}
