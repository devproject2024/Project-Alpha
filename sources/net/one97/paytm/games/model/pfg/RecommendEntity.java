package net.one97.paytm.games.model.pfg;

import java.util.List;

public final class RecommendEntity {
    private List<Game> gameList;
    private String image = "";
    private String sectionLayout = "";
    private String sectionTitle = "";

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final String getSectionLayout() {
        return this.sectionLayout;
    }

    public final void setSectionLayout(String str) {
        this.sectionLayout = str;
    }

    public final String getSectionTitle() {
        return this.sectionTitle;
    }

    public final void setSectionTitle(String str) {
        this.sectionTitle = str;
    }

    public final List<Game> getGameList() {
        return this.gameList;
    }

    public final void setGameList(List<Game> list) {
        this.gameList = list;
    }
}
