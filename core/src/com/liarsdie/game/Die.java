package com.liarsdie.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Die {

    int numPips;
    Texture diePicture;

    public Die(){


    }

    public void setNumPips(int pips){
        numPips = pips;
    }

    public void setDiePicture(){
        diePicture = new Texture(Gdx.files.internal("die-" + numPips + " (1).png"));
    }

    public void roll(){
        int count = MathUtils.random(1,6);
        setNumPips(count);
        setDiePicture();
    }
}
