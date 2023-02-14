package com.lulu.teoremus.model


import android.content.Context
import android.media.MediaPlayer
import com.lulu.teoremus.enums.Escolhas

class Midia {
    private var mp = MediaPlayer()

    fun criarMidia(e: Escolhas, c: Context){
        mp = MediaPlayer.create(c, e.som)
    }

     fun conferirMP() {
        if(mp.isPlaying)
            mp.stop()
    }

     fun start(){
         conferirMP()
        mp.start()
    }
}