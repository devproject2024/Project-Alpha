package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNextStepDetail implements IJRDataModel {
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
