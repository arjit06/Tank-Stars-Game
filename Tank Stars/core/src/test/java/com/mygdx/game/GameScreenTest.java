package com.mygdx.game;

import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class GameScreenTest {
    @Test
    public void testSimple()  {
        assertEquals(1,1);
    }

    @Test
    public void firstcond()
    {
        //GameScreen g=new GameScreen(new MyGdxGame(),new MainScreen(new MyGdxGame()));
        assertEquals(0,GameScreen.calcIndex(55.5f)) ;
    }

    @Test
    public void second()
    {
        //GameScreen g=new GameScreen(new MyGdxGame(),new MainScreen(new MyGdxGame()));
        assertEquals(1,GameScreen.calcIndex(155.5f)) ;
    }

    @Test
    public void third()
    {
        //GameScreen g=new GameScreen(new MyGdxGame(),new MainScreen(new MyGdxGame()));
        assertEquals(2,GameScreen.calcIndex(355.5f)) ;
    }

    @Test
    public void fourth()
    {
        //GameScreen g=new GameScreen(new MyGdxGame(),new MainScreen(new MyGdxGame()));
        assertEquals(3,GameScreen.calcIndex(455.5f)) ;
    }

    @Test
    public void fifth()
    {
        //GameScreen g=new GameScreen(new MyGdxGame(),new MainScreen(new MyGdxGame()));
        assertEquals(4,GameScreen.calcIndex(555.5f)) ;
    }

    @Test
    public void sizth()
    {
        //GameScreen g=new GameScreen(new MyGdxGame(),new MainScreen(new MyGdxGame()));
        assertEquals(5,GameScreen.calcIndex(655.5f)) ;
    }

    @Test
    public void seventh()   //intentionally left incorrect
    {
        //GameScreen g=new GameScreen(new MyGdxGame(),new MainScreen(new MyGdxGame()));

        assertEquals(6,GameScreen.calcIndex(655.5f)) ;
    }

    @Test
    public void eitght()
    {
        //GameScreen g=new GameScreen(new MyGdxGame(),new MainScreen(new MyGdxGame()));
        assertEquals(7,GameScreen.calcIndex(755.5f)) ;
    }

    @Test
    public void allinone()
    {
        //ListIterator iter=GameScreen.getEquation().listIterator();
        //MyGdxGame game=new MyGdxGame();
        //GameScreen g=new GameScreen(game,new MainScreen(game));
        Ground g=new Ground();
        /*Collection c=g.getEquation();
        Iterator iter = c.iterator();

        //int i=0;
        while(iter.hasNext())
        {
            //assertEquals(0.67f,iter.next());
            //Collection d= (Collection) c.iterator();
            Collection d=g.getEquation().get(i);
            Iterator iter2= d.iterator();
            assertEquals(0.67f,iter2.next());
            assertEquals(0.67f,iter2.next());
        }

        for(int i=0;i<2;i++)
        {

        }*/
        Collection d=g.getEquation().get(0);
        Iterator iter2= d.iterator();
        while (iter2.hasNext())
        {
            assertEquals(0.67f,iter2.next());
            assertEquals(80.0f,iter2.next());
        }

//        Collection d1=g.getEquation().get(0);
//        Iterator iter2= d.iterator();
//        while (iter2.hasNext())
//        {
//            assertEquals(0.67f,iter2.next());
//            assertEquals(80.0f,iter2.next());
//        }

        d=g.getEquation().get(1);
        iter2= d.iterator();
        while (iter2.hasNext())
        {
            assertEquals(0.23f,iter2.next());
            assertEquals(127.69f,iter2.next());
        }

//        d=g.getEquation().get(2);
//        iter2= d.iterator();
//        while (iter2.hasNext())
//        {
//            assertEquals(0.23f,iter2.next());
//            assertEquals(127.69f,iter2.next());
//        }

        d=g.getEquation().get(2);
        iter2= d.iterator();
        while (iter2.hasNext())
        {
            assertEquals(-0.97872340425531914893617f,iter2.next());
            assertEquals(506.31f,iter2.next());
        }

        d=g.getEquation().get(3);
        iter2= d.iterator();
        while (iter2.hasNext())
        {
            assertEquals(-0.48484848484848484848484f,iter2.next());
            assertEquals(328.01f,iter2.next());
        }

        d=g.getEquation().get(4);
        iter2= d.iterator();
        while (iter2.hasNext())
        {
            assertEquals(-0.02604166666666666666666f,iter2.next());
            assertEquals(116.96f,iter2.next());
        }

        d=g.getEquation().get(5);
        iter2= d.iterator();
        while (iter2.hasNext())
        {
            assertEquals(0.64f,iter2.next());
            assertEquals(-317.28f,iter2.next());
        }

        d=g.getEquation().get(6);
        iter2= d.iterator();
        while (iter2.hasNext())
        {
            assertEquals(-0.64f,iter2.next());
            assertEquals(583.32f,iter2.next());
        }

        d=g.getEquation().get(7);
        iter2= d.iterator();
        while (iter2.hasNext())
        {
            assertEquals(0.0f,iter2.next());
            assertEquals(105.0f,iter2.next());
        }

//        d=g.getEquation().get(9);
//        iter2= d.iterator();
//        while (iter2.hasNext())
//        {
//            assertEquals(0.67f,iter2.next());
//            assertEquals(80.0f,iter2.next());
//        }


//        Collection d3=g.getEquation().get(0);
//        Iterator iter2= d.iterator();
//        while (iter2.hasNext())
//        {
//            assertEquals(0.67f,iter2.next());
//            assertEquals(80.0f,iter2.next());
//        }
//
//        Collection d=g.getEquation().get(0);
//        Iterator iter2= d.iterator();
//        while (iter2.hasNext())
//        {
//            assertEquals(0.67f,iter2.next());
//            assertEquals(80.0f,iter2.next());
//        }
//
//        Collection d=g.getEquation().get(0);
//        Iterator iter2= d.iterator();
//        while (iter2.hasNext())
//        {
//            assertEquals(0.67f,iter2.next());
//            assertEquals(80.0f,iter2.next());
//        }
//
//        Collection d=g.getEquation().get(0);
//        Iterator iter2= d.iterator();
//        while (iter2.hasNext())
//        {
//            assertEquals(0.67f,iter2.next());
//            assertEquals(80.0f,iter2.next());
//        }

    }

}