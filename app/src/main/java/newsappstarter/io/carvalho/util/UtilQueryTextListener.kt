package newsappstarter.io.carvalho.util

import android.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UtilQueryTextListener(
    lifecycle: Lifecycle,
    private val utilQueryTextListener: (String?) -> Unit
) : SearchView.OnQueryTextListener, LifecycleObserver {

    private val coroutineScope = lifecycle.coroutineScope
    private var searchJob: Job? = null

    override fun onQueryTextSubmit(newText: String?): Boolean {
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            newText?.let {
                delay(Constants.SEARCH_NEWS_DELAY)
                utilQueryTextListener(newText)
            }
        }
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
//        searchJob?.cancel()
//        searchJob = coroutineScope.launch {
//            newText?.let {
//                delay(Constants.SEARCH_NEWS_DELAY)
//                utilQueryTextListener(newText)
//            }
//        }
        return false
    }
}