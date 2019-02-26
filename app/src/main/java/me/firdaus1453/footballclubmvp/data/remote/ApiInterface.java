package me.firdaus1453.footballclubmvp.data.remote;

import me.firdaus1453.footballclubmvp.model.TeamsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public interface ApiInterface {

    @GET("search_all_teams.php")
    Call<TeamsResponse> getAllTeams(@Query("s") String s, @Query("c") String c);

    // Endpoint untuk melakukan search berdasarkan nama team
    @GET("searchteams.php")
    Call<TeamsResponse> getSearchTeams(@Query("t") String t);
}
