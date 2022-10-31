package newsappstarter.io.carvalho.model.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import newsappstarter.io.carvalho.model.data.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = REPLACE)
     fun updateInsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAll(): List<Article>

    @Delete
     fun delete(article: Article)
}