package net.one97.paytm.common.entity.movies;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieLoyaltyModel implements IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "uiLabel")
    private String heading;
    @b(a = "points")
    private Double points;
    @b(a = "pointsValue")
    private Double pointsValue;
    @b(a = "preCheck")
    private boolean preCheck;
    @b(a = "tnc")
    private CJRMovieLoyaltyTerms terms;
    @b(a = "type")
    private String type;

    public String getHeading() {
        return this.heading;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isPreCheck() {
        return this.preCheck;
    }

    public CJRMovieLoyaltyTerms getTerms() {
        return this.terms;
    }

    public Double getPoints() {
        return this.points;
    }

    public Double getPointsValue() {
        return this.pointsValue;
    }

    public String getType() {
        return this.type;
    }
}
