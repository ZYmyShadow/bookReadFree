package com.bookRead.module;

import com.bookRead.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendFragmentModule {
    private RecommendFragment recommendFragment;

    public RecommendFragmentModule(RecommendFragment recommendFragment) {
        this.recommendFragment = recommendFragment;
    }

    @Provides
    RecommendFragment provideRecommendFragment() {
        return recommendFragment;
    }
}
