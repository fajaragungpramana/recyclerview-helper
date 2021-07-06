# Android Recycler View.
[![](https://jitpack.io/v/fajaragungpramana/recyclerview-helper.svg)](https://jitpack.io/#fajaragungpramana/recyclerview-helper)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
</br>
</br>

Library for android. Helping you to use recycler view.

## Installation
Add it in your root build.gradle at the end of repositories:
```gradle
allProjects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency:
```gradle
dependencies {
	implementation 'com.github.fajaragungpramana:recyclerview-helper:0.0.1'
}
```

## Usage
First step. You must add `ViewBinding` library to use this custom adapter.
```kotlin
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
```
And in the activity you can set data like this use `mDayAdapter.submitList()`. For example `MainActivity.kt`.
```kotlin
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
```

## Preview
<a href="url"><img src="https://github.com/fajaragungpramana/assets/blob/master/PagingHelper/PagingHelper.jpg" align="left" height="640" width="320" ></a>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

## License
Copyright 2021 Fajar Agung Pramana

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
