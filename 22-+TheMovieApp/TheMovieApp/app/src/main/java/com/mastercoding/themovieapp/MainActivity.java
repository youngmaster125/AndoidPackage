package com.mastercoding.themovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;

import com.mastercoding.themovieapp.databinding.ActivityMainBinding;
import com.mastercoding.themovieapp.model.Movie;
import com.mastercoding.themovieapp.view.MovieAdapter;
import com.mastercoding.themovieapp.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        getPopularMovies();



        swipeRefreshLayout = binding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });


    }

    private void getPopularMovies() {

        viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                movies = (ArrayList<Movie>) moviesFromLiveData;
                displayMoviesInRecyclerView();

            }
        });

    }

    private void displayMoviesInRecyclerView() {
        recyclerView = binding.recyclerview;

        movieAdapter = new MovieAdapter(this, movies);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // notify an adapter associated with a RecyclerView
        // that the underlying dataset hase changed
        movieAdapter.notifyDataSetChanged();



    }
}