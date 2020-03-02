package com.example.android.a02212020_mb_nycschools.network

import com.example.android.a02212020_mb_nycschools.model.NycHighSchoolDirectory
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface SchoolService {
    @Headers("X-App-Token: krMoAwysZ7zWj2hCRApDpVbAE")
    @GET("resource/s3k6-pzi2.json")
        fun getSchools(): Observable<NycHighSchoolDirectory>

}