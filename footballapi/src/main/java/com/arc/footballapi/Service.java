package com.arc.footballapi;

import com.arc.footballapi.test.TestResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("lookup_all_teams.php")
    Call<TestResponse> getAllTeam(@Query("id") String id);
}
