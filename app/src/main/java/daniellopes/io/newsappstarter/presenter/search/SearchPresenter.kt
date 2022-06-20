package daniellopes.io.newsappstarter.presenter.search

import daniellopes.io.newsappstarter.model.NewsResponse
import daniellopes.io.newsappstarter.model.data.NewsDataSource
import daniellopes.io.newsappstarter.presenter.news.ViewHome

class SearchPresenter(
    val view: ViewHome.View,
    private val dataSource: NewsDataSource
) : SearchHome.Presenter {
    override fun search(term: String) {
    }

    override fun onSuccess(newsResponse: NewsResponse) {
    }

    override fun onError(message: String) {
    }

    override fun onComplete() {
    }
}