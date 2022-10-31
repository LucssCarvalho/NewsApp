package newsappstarter.io.carvalho.model.data

import newsappstarter.io.carvalho.model.data.db.ArticleDataBase

class NewsRepository(private val db: ArticleDataBase) {

    fun updateInsert(article: Article) = db.getArticleDao().updateInsert(article)

    fun getAll(): List<Article> = db.getArticleDao().getAll()

    fun delete(article: Article) = db.getArticleDao().delete(article)
}