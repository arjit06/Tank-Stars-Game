//package com.mygdx.game;
//
//import com.mygdx.game.GameScreen;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//
//public class DataClass implements Serializable {
//    private ArrayList<Integer> saved_games;
//
//    public DataClass() {
//        saved_games = new ArrayList<Integer>();
//    }
//    public ArrayList<Integer> savedGames(){
//        return this.saved_games;
//    }
//    public GameScreen loadGame(int index){
//        int p=saved_games.get(index);
//        GameScreen g1;
//        ObjectInputStream in=null;
//        try{
//            in=new ObjectInputStream(new FileInputStream("Saved_Games/"+p));
//            g1=(GameScreen) (in.readObject());
//            in.close();
//        } catch (Exception e){
//            System.out.println("Could not get game");
//            return null;
//        } finally {
//            //games.remove(p);
//            saved_games.remove(index);
//        }
//
//        return g1;
//    }
//    public void saveGame(GameScreen g){
//        saved_games.add(saved_games.size()+1);
//        ObjectOutputStream out=null;
//        try{
//            out=new ObjectOutputStream(new FileOutputStream(1+".txt"));
//            out.writeObject(g);
//            out.close();
//        } catch (Exception e){
//            e.printStackTrace();
//            System.out.println("ERROR in serializing game");
//        }
//    }
//    /*public void removeGame(int index){
//        //String p=saved_games.get(index-1);
//        //games.remove(p);
//    }*/
//    public void updateGame(GameScreen g){
//        //serialize
//    }
////    public void clearData(){
////        saved_games.clear();
////        //games.clear();
////    }
////    public boolean checkNoGamesSaved(){
////        return (saved_games.size()==0);
////    }
//
//
////    public void serialize(){
////        ObjectOutputStream out=null;
////        try{
////            out=new ObjectOutputStream(new FileOutputStream("DataClass_Data/data.txt"));
////            out.writeObject(this);
////            out.close();
////        } catch (Exception e){
////            System.out.println("ERROR in serializing file");
////        }
////    }
//
//    public void setData()
//    {
//        GameScreen g1;
//        ObjectInputStream in=null;
//        for(int i=1;i<=4;i++)
//        {
//            try{
//                in=new ObjectInputStream(new FileInputStream(i+".txt"));
//                g1=(GameScreen) (in.readObject());
//                in.close();
//            } catch (Exception e){
//                return;
//            } finally {
//                this.saved_games.add(i);
//            }
//        }
//
//    }
//
//}