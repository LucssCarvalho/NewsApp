package newsappstarter.io.carvalho.ui

import android.webkit.WebViewClient
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import newsappstarter.R
import newsappstarter.databinding.ActivityArticleBinding
import newsappstarter.io.carvalho.model.data.Article
import newsappstarter.io.carvalho.model.data.NewsDataSource
import newsappstarter.io.carvalho.util.Constants.Companion.ARTICLE_KEY

class ArticleActivity : AbstractActivity() {

    private lateinit var article: Article

    private lateinit var binding: ActivityArticleBinding

    override fun getLayout(): ViewBinding {
        binding = ActivityArticleBinding.inflate(layoutInflater)
        return binding
    }

    override fun onInject() {
        getArticle()
        val dataSource = NewsDataSource(this)
        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { url ->
                loadUrl(url)
            }
        }
        binding.fab.setOnClickListener {
            dataSource.saveArticle(article)
            Snackbar.make(
                it,
                R.string.article_saved_successful,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    private fun getArticle() {
        intent.extras?.let { articleSend ->
            article = articleSend.get(ARTICLE_KEY) as Article
        }
    }
}
