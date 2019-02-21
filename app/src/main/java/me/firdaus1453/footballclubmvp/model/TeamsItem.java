package me.firdaus1453.footballclubmvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public class TeamsItem {

    @SerializedName("idTeams")
    private String idTeam;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }
}
