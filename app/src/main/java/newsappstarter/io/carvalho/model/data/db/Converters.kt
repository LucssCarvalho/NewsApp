package newsappstarter.io.carvalho.model.data.db

import androidx.room.TypeConverter
import newsappstarter.io.carvalho.model.data.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}
