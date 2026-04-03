package com.example.pokemonclicker;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.content.Context;

    public class BackgroundMusic {
        private MediaPlayer mediaPlayer;

        public void start(Context context, int musicResId, boolean loop){
            stop();
            mediaPlayer = MediaPlayer.create(context, musicResId);
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(loop);
                mediaPlayer.start();
            }
        }

        public void pause() {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        }

        public void resume() {
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        }

        public void stop() {
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }

        public boolean isPlaying() {
            return mediaPlayer != null && mediaPlayer.isPlaying();
        }
    }


