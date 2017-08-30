package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.text.TextUtils;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.nanodegree.dario.jokeviewer.JokeViewerActivity;

public class FreeMainActivity extends MainActivity {

    private InterstitialAd mInterstitialAd;
    private String joke;

    @Override
    protected void onStart() {
        super.onStart();
        configureInterstitial();
    }

    private void configureInterstitial() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                showJoke();
            }

            @Override
            public void onAdClosed() {
                showJoke();
            }
        });
    }

    @Override
    protected void onJokeReceived(String joke) {
        this.joke = joke;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void showJoke() {
        if (!TextUtils.isEmpty(joke)) {
            Intent intent = new Intent(FreeMainActivity.this, JokeViewerActivity.class);
            intent.putExtra(JokeViewerActivity.JOKE, joke);
            startActivity(intent);
        }
    }

}
