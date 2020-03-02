package com.example.android.a02212020_mb_nycschools.network

import com.example.android.a02212020_mb_nycschools.model.NycHighSchoolDirectory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SchoolsRetrofit {
    private var schoolService: SchoolService
    private val BASE_URL: String = "https://data.cityofnewyork.us/"

    init {
        this.schoolService = createService(getInstance())
    }

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createService(retrofit: Retrofit): SchoolService {
        return retrofit.create(SchoolService::class.java)
    }

    fun getSchools(): Observable<NycHighSchoolDirectory>{
       return schoolService.getSchools()
    }
}