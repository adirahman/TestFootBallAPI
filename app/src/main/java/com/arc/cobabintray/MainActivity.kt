package com.arc.cobabintray

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arc.footballapi.BaseResponse
import com.arc.footballapi.ResponseCourier
import com.arc.footballapi.test.TestRepo

class MainActivity : AppCompatActivity(), ResponseCourier{

    lateinit var testRepo:TestRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testRepo = TestRepo(this,this)

        testRepo.callAPI()
    }

    override fun getDataResponse(response: BaseResponse<*>?, message: String?) {
        response?.let {
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        }
    }
}
