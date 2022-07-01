package newsappstarter.io.carvalho.ui

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import daniellopes.io.carvalho.util.Constants.Companion.ARTICLE_KEY
import newsappstarter.databinding.ActivityArticleBinding
import newsappstarter.io.carvalho.model.Article

class ArticleActivity : AppCompatActivity() {

    private lateinit var article: Article

    private lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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