package com.example.android.a02212020_mb_nycschools.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.a02212020_mb_nycschools.model.NycHighSchoolDirectory
import com.example.android.a02212020_mb_nycschools.network.SchoolsRetrofit
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchoolViewModel(application: Application) : AndroidViewModel(application) {
    val schoolsRetrofit = SchoolsRetrofit()

    fun getSchools(): Observable<NycHighSchoolDirectory> {
        return schoolsRetrofit.getSchools()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}