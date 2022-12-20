package com.mygdx.game;

public class SetPlayer
{
    private static Player player1=new Player(new FrostTank(50f,111f,80f,60f,1),1),player2= new Player(new FrostTank(565f,103f,80f,60f,2),2);


    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

}
