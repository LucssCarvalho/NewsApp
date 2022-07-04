package newsappstarter.io.carvalho.ui.activity

import newsappstarter.io.carvalho.repository.NewsDataSource
import SearchPresenter
import ViewHome
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import daniellopes.io.carvalho.util.Constants.Companion.ARTICLE_KEY
import daniellopes.io.carvalho.util.UtilQueryTextListener
import newsappstarter.databinding.ActivitySearchBinding
import newsappstarter.io.carvalho.ui.adapter.MainAdapter
import newsappstarter.io.carvalho.data.model.Article

class SearchActivity : AbstractActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: SearchPresenter

    private lateinit var binding: ActivitySearchBinding

    override fun getLayout(): ViewBinding {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        return binding
    }

    override fun onInject() {
        val dataSource = NewsDataSource()
        presenter = SearchPresenter(this, dataSource)
        configRecycler()
        search()
        clickAdapter()
    }

    private fun search() {
        binding.searchNews.setOnQueryTextListener(
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
        with(binding.rvSearch) {
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
        binding.rvProgressBarSearch.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        binding.rvProgressBarSearch.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}