package test.map.coroutinegogo.multiRecyclerView.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import test.map.coroutinegogo.retrofit.Api

//테스트4
class HomeViewModel(
    private val repositroy : Api
) :ViewModel(){

    private val _homeListItemLiveData = MutableLiveData<Resource<List<HomeRecyclerViewItem>>>()

    val homeListItemLiveData: LiveData<Resource<List<HomeRecyclerViewItem>>>
        get() = _homeListItemLiveData

    init {

    }
}