package me.firdaus1453.footballclubmvp.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
@Dao
public interface FootballDao {

    @Insert
    void insertItem(TeamsItem teamsItem);

    @Query("SELECT * FROM teams WHERE idTeam = :id")
    TeamsItem selectedItem(String id);

    @Delete
    void delete(TeamsItem teamsItem);
}
