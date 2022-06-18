package daniellopes.io.newsappstarter.presenter.search

import daniellopes.io.newsappstarter.presenter.news.NewsPresenter

interface SearchHome {

    interface Presenter {
        fun search(term: String)

        fun onSuccess(newsResponse: NewsPresenter)

        fun onError(message: String)

        fun onComplete()
    }
}