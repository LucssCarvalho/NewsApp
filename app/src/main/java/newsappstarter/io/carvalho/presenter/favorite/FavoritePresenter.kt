package newsappstarter.io.carvalho.presenter.favorite

import newsappstarter.io.carvalho.model.data.Article
import newsappstarter.io.carvalho.model.data.NewsDataSource

class FavoritePresenter(private val dataSource: NewsDataSource) {
    fun saveArticle(article: Article) {
        this.dataSource.saveArticle(article)
    }
}