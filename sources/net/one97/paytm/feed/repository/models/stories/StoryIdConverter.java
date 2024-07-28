package net.one97.paytm.feed.repository.models.stories;

import com.google.gson.f;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.polls.Options;

public final class StoryIdConverter {
    public final String listToJson(List<String> list) {
        String b2 = new f().b(list);
        k.a((Object) b2, "Gson().toJson(value)");
        return b2;
    }

    public final List<String> jsonToList(String str) {
        k.c(str, "value");
        Object a2 = new f().a(str, String[].class);
        if (a2 != null) {
            return kotlin.a.f.b((String[]) a2);
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
    }

    public final String fromOptionsList(List<Options> list) {
        if (list == null) {
            return null;
        }
        return new f().a((Object) list, new StoryIdConverter$fromOptionsList$type$1().getType());
    }

    public final List<Options> toOptionsList(String str) {
        if (str == null) {
            return null;
        }
        return (List) new f().a(str, new StoryIdConverter$toOptionsList$type$1().getType());
    }
}
