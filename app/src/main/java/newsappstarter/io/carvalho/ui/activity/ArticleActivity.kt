package newsappstarter.io.carvalho.ui.activity

import android.webkit.WebViewClient
import androidx.viewbinding.ViewBinding
import newsappstarter.io.carvalho.util.Constants.Companion.ARTICLE_KEY
import newsappstarter.databinding.ActivityArticleBinding
import newsappstarter.io.carvalho.data.model.Article

class ArticleActivity : AbstractActivity() {

    private lateinit var article: Article

    private lateinit var binding: ActivityArticleBinding

    override fun getLayout(): ViewBinding {
        binding = ActivityArticleBinding.inflate(layoutInflater)
        return binding
    }

    override fun onInject() {
        getArticle()
        binding.webView.apply {
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
