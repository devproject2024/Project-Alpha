package easypay.entity;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PreferenceList implements Serializable {
    @c(a = "prefList")
    private List<AssistDetailsResponse> prefList = new ArrayList();

    public List<AssistDetailsResponse> getPrefList() {
        return this.prefList;
    }

    public void setPrefList(List<AssistDetailsResponse> list) {
        this.prefList = list;
    }
}
