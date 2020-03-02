package com.example.android.a02212020_mb_nycschools

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.android.a02212020_mb_nycschools.viewmodel.SchoolViewModel
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private lateinit var schoolViewModel: SchoolViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        schoolViewModel = ViewModelProviders.of(this).get(SchoolViewModel::class.java)
        compositeDisposable.add(
            schoolViewModel.getSchools()
                .subscribe({schools ->
            Log.d("TAG_Q", "" + schools.schoolName)


        },{ throwable ->
            Log.d("TAG_Q", "error " + throwable.message)
        }))
    }
}
