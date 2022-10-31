package newsappstarter.io.carvalho.ui.activity

import android.webkit.WebViewClient
import androidx.viewbinding.ViewBinding
import newsappstarter.databinding.ActivityArticleBinding
import newsappstarter.io.carvalho.model.data.Article
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
