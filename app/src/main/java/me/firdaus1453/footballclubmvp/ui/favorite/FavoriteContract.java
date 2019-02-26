package me.firdaus1453.footballclubmvp.ui.favorite;

import android.content.Context;

import java.util.List;

import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * Created by firdaus1453 on 2/22/2019.
 */
public interface FavoriteContract {

    interface View{
        void showDataList(List<TeamsItem> teamsItemList);
        void showFailureMessage(String msg);
        void hideRefresh();
    }

    interface Presenter{
        void getDataListTeams(Context context);
        void searchTeams(Context context, String searchText);
    }
}
