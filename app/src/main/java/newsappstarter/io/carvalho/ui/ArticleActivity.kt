package newsappstarter.io.carvalho.ui

import android.webkit.WebViewClient
import daniellopes.io.carvalho.util.Constants.Companion.ARTICLE_KEY
import kotlinx.android.synthetic.main.activity_article.*
import newsappstarter.R
import newsappstarter.io.carvalho.model.Article

class ArticleActivity : AbstractActivity() {

    private lateinit var article: Article

    override fun getLayout(): Int = R.layout.activity_article

    override fun onInject() {
        getArticle()
        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { url ->
                loadUrl(url)
            }
        }

    }

    private fun getArticle() {
        intent.extras?.let { articleSend ->
            article = articleSend.get(ARTICLE_KEY) as Article
        }
    }
}