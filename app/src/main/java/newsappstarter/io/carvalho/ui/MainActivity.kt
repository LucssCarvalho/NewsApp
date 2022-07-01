package newsappstarter.io.carvalho.ui
import NewsDataSource
import NewsPresenter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import daniellopes.io.carvalho.util.Constants.Companion.ARTICLE_KEY
import newsappstarter.R
import newsappstarter.databinding.ActivityMainBinding
import newsappstarter.io.carvalho.adapter.MainAdapter
import newsappstarter.io.carvalho.model.Article

class MainActivity : AppCompatActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: NewsPresenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSource = NewsDataSource()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter = NewsPresenter(this, dataSource)
        presenter.requestAll()
        configRecycle()
        clickAdapter()
    }

    private fun configRecycle() {
        with(binding.rvNews) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
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
        binding.rvProgressBar.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        binding.rvProgressBar.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search_menu -> {
                Intent(this, SearchActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}