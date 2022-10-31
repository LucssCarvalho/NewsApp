package newsappstarter.io.carvalho.model.data

import newsappstarter.io.carvalho.presenter.news.NewsHome
import SearchHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import newsappstarter.io.carvalho.model.remote.RetrofitInstance

class NewsDataSource() {

//    private var db: ArticleDataBase = ArticleDataBase(context)
//    private var newsRepository: NewsRepository = NewsRepository(db)

    fun getBreakingNews(callback: NewsHome.Presenter) {
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getBreakingNews("br")
            if (response.isSuccessful) {
                response.body()?.let { newsResponse ->
                    callback.onSuccess(newsResponse)
                }
                callback.onComplete()
            } else {
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }

    fun searchNew(term: String, callback: SearchHome.Presenter) {
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.searchNews(term)
            if (response.isSuccessful) {
                response.body()?.let { newsResponse ->
                    callback.onSuccess(newsResponse)
                }
                callback.onComplete()
            } else {
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }

//    fun saveArticle(article: Article) {
//        GlobalScope.launch(Dispatchers.Main) {
//            newsRepository.updateInsert(article)
//        }
//    }

//    fun getAllArticle(callback: newsappstarter.io.carvalho.presenter.favorite.FavoriteHome) {
//        var allArticle: List<Article>
//        CoroutineScope(Dispatchers.IO).launch {
//            allArticle = newsRepository.getAll()
//
//            withContext(Dispatchers.Main) {
//                callback.showArticles(allArticle)
//            }
//        }
//    }
//
//    fun deleteArticle(article: Article?) {
//        GlobalScope.launch(Dispatchers.Main) {
//            article?.let { articleSafe ->
//                newsRepository.delete(articleSafe)
//            }
//        }
//    }
}