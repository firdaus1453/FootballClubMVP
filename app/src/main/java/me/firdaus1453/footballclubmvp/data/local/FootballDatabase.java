package me.firdaus1453.footballclubmvp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
@Database(entities = TeamsItem.class, version = 1)
public abstract class FootballDatabase extends RoomDatabase {

    public abstract FootballDao footballDao();

    private static FootballDatabase footballDatabase;

    public static FootballDatabase getFootballDatabase(Context context){
        synchronized (FootballDatabase.class){
            if (footballDatabase == null){
                footballDatabase = Room.databaseBuilder(context,
                        FootballDatabase.class,"db_football").allowMainThreadQueries().build();
            }
        }return footballDatabase;
    }

}
