package net.one97.paytm.games.model;

import com.google.gson.a.c;
import java.util.ArrayList;

public class GpTasksListResponse extends GpCommonBaseResponse {
    @c(a = "tasks")
    private ArrayList<GpTask> tasks;

    public ArrayList<GpTask> getTasks() {
        return this.tasks;
    }

    public static class GpTask {
        @c(a = "attributes")
        private String attributes;
        @c(a = "claims")
        private ArrayList<Claim> claims;
        @c(a = "eventId")
        private String eventId;
        private int pointsFromClaimBean;
        @c(a = "ruleId")
        private String ruleId;

        public String getRuleId() {
            return this.ruleId;
        }

        public String getEventId() {
            return this.eventId;
        }

        public String getAttributes() {
            return this.attributes;
        }

        public ArrayList<Claim> getClaims() {
            return this.claims;
        }

        public void setPointsFromClaimBean(int i2) {
            this.pointsFromClaimBean = i2;
        }

        public int getPointsFromClaimBean() {
            return this.pointsFromClaimBean;
        }

        public String toString() {
            return "GpTask{ruleId='" + this.ruleId + '\'' + ", eventId='" + this.eventId + '\'' + ", attributes='" + this.attributes + '\'' + ", claims=" + this.claims + ", pointsFromClaimBean=" + this.pointsFromClaimBean + '}';
        }

        public static class Claim {
            @c(a = "claimId")
            private String claimId;
            @c(a = "claimStatus")
            private String claimStatus;
            @c(a = "counter")
            private int counter;
            @c(a = "points")
            private int points;

            public int getCounter() {
                return this.counter;
            }

            public String getClaimStatus() {
                return this.claimStatus;
            }

            public String getClaimId() {
                return this.claimId;
            }

            public int getPoints() {
                return this.points;
            }

            public String toString() {
                return "Claim{counter=" + this.counter + ", claimStatus='" + this.claimStatus + '\'' + ", claimId='" + this.claimId + '\'' + ", points=" + this.points + '}';
            }
        }
    }

    public String toString() {
        return "GpTasksListResponse{tasks=" + this.tasks + ", code=" + this.code + ", message='" + this.message + '\'' + ", status='" + this.status + '\'' + "} " + super.toString();
    }
}
