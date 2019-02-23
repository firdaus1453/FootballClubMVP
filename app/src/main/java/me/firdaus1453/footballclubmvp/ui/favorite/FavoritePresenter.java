package me.firdaus1453.footballclubmvp.ui.favorite;

import android.content.Context;

import java.util.List;

import me.firdaus1453.footballclubmvp.data.local.FootballDatabase;
import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * Created by firdaus1453 on 2/22/2019.
 */
public class FavoritePresenter implements FavoriteContract.Presenter {

    private final FavoriteContract.View view;
    private FootballDatabase footballDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams(Context context) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().selectFavorite() != null){
            List<TeamsItem> list = footballDatabase.footballDao().selectFavorite();
            view.showDataList(list);
        }else {
            view.showFailureMessage("Tidak ada data di favorite");
        }
        view.hideRefresh();
    }
}
