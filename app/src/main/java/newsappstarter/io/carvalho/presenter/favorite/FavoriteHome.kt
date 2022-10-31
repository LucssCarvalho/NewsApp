package newsappstarter.io.carvalho.presenter.favorite

import newsappstarter.io.carvalho.model.data.Article

interface FavoriteHome {
    fun showArticles(articles: List<Article>)
}