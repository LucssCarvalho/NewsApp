package newsappstarter.io.carvalho.ui
import NewsDataSource
import SearchPresenter
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import daniellopes.io.carvalho.util.Constants.Companion.ARTICLE_KEY
import daniellopes.io.carvalho.util.UtilQueryTextListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import newsappstarter.R
import newsappstarter.io.carvalho.adapter.MainAdapter
import newsappstarter.io.carvalho.model.Article

class SearchActivity : AbstractActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: SearchPresenter

    override fun getLayout(): Int = R.layout.activity_search

    override fun onInject() {
        val dataSource = NewsDataSource()
        presenter = SearchPresenter(this, dataSource)
        configRecycler()
        search()
        clickAdapter()
    }

    private fun search() {
        searchNews.setOnQueryTextListener(
            UtilQueryTextListener(
                this.lifecycle
            ) { newText ->
                newText?.let { query ->
                    if (query.isNotEmpty()) {
                        presenter.search(query)
                        showProgressBar()
                    }
                }
            }
        )
    }

    private fun configRecycler() {
        with(rvSearch) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@SearchActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun clickAdapter() {
        mainAdapter.setOnClickListener { article ->
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra(ARTICLE_KEY, article)
            startActivity(intent)
        }
    }

    override fun showProgressBar() {
        rvProgressBarSearch.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        rvProgressBarSearch.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}