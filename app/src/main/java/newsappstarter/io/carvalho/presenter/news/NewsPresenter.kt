package newsappstarter.io.carvalho.presenter.news
import ViewHome
import newsappstarter.io.carvalho.model.data.NewsDataSource
import newsappstarter.io.carvalho.model.data.NewsResponse


class NewsPresenter(
    private val view: ViewHome.View,
    private val dataSource: NewsDataSource
) : NewsHome.Presenter {

    override fun requestAll() {
        this.view.showProgressBar()
        this.dataSource.getBreakingNews(this)
    }

    override fun onSuccess(newsResponse: NewsResponse) {
        this.view.showArticles(newsResponse.articles)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }
}