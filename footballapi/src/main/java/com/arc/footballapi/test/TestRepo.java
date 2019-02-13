package com.arc.footballapi.test;

import android.content.Context;
import com.arc.footballapi.BaseRepo;
import com.arc.footballapi.Client;
import com.arc.footballapi.ResponseCourier;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestRepo extends BaseRepo {
    public TestRepo(Context context, ResponseCourier courier) {
        super(context, courier);
    }

    public void callAPI(){
        try{
            Call<TestResponse> call = Client.getInstance().getService().getAllTeam("4328");
            call.enqueue(new Callback<TestResponse>() {
                @Override
                public void onResponse(Call<TestResponse> call, Response<TestResponse> response) {
                    if(response.body() != null){
                        courier.getDataResponse(response.body(),"sukses");
                    }else{
                        courier.getDataResponse(null,"failed");
                    }
                }

                @Override
                public void onFailure(Call<TestResponse> call, Throwable t) {
                    courier.getDataResponse(null,"failed");
                }
            });
        }catch (Exception e){
            courier.getDataResponse(null,e.getMessage());
        }
    }
}
