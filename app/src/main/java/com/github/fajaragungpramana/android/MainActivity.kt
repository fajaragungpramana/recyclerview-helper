package com.github.fajaragungpramana.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.fajaragungpramana.android.databinding.ActivityMainBinding
import com.github.fajaragungpramana.android.databinding.AdapterDayBinding
import com.github.fajaragungpramana.recyclerviewhelper.RecyclerViewHelperAdapterImpl

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private val mMainViewModel by lazy { MainViewModel() }

    private val mDayAdapter by lazy {
        RecyclerViewHelperAdapterImpl(
            Day.DIFF_UTIL,
            onCreateViewBinding = { inflater, parent, _ ->
                AdapterDayBinding.inflate(inflater, parent, false)
            },
            onBinding = { binding, entity, position ->
                (binding as AdapterDayBinding).apply {
                    tvDay.text = entity?.name
                }
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.rvDay.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mDayAdapter
        }

        mDayAdapter.submitList(mMainViewModel.listDay)

    }

}