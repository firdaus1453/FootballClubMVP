package me.firdaus1453.footballclubmvp.ui.favorite;

import android.content.Context;

import java.util.ArrayList;
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

    @Override
    public void searchTeams(Context context, String searchText) {
        if (!searchText.isEmpty()){
            footballDatabase = FootballDatabase.getFootballDatabase(context);
            // Memasukkan semua data favorit ke dalam variable list
            List<TeamsItem> teamsItemList = footballDatabase.footballDao().selectFavorite();
            // Membuat penampung untuk menampung data yang sudah kita seleksi berdasarkan inutan user
            List<TeamsItem> mTeamsItemList = new ArrayList<>();

            if (teamsItemList != null){
                // Melakukan perulangan untuk mengecek data yang ada di dalam table favorit
                for (TeamsItem data: teamsItemList){
                    // Pengecekan team bedasrkan dengan permintaan user
                    String namaTeam = data.getStrTeam().toLowerCase();
                    if (namaTeam.contains(searchText.toLowerCase())){
                        // Memasukkan team yang sama dengan inputan user ke dalam wadah ke dua
                        mTeamsItemList.add(data);
                    }
                }
                // Mengirimkan wadah ke dua ke view
                view.showDataList(mTeamsItemList);
            }
        }else{
            // Apabila inputan user kosong ambil data tanpa keyword
            getDataListTeams(context);
        }
    }
}
