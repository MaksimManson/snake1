/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.Random;

/**
 *
 * @author lordstorm
 */
public class Game
{
    /*
    0 - empty
    1 - snake
    2 - food
    */
    public Random r;
    public String direction = "UP";
    public int snake_size = 1;
    int x = 50;
    int y = 50;
    int xf = 20;
    int yf = 20;
    public boolean game_continue = true;
    public int[][] field;
    public int width = 1;
    public int height = 1;
    public Game(int width, int height)
    {
        r = new Random();
        field = new int[width][height];
        this.width = width;
        this.height = height;
        x = width/2;
        xf = width/3;
        yf = height/3;
        y = height/2;
        for(int i = 0; i < this.width;i++)
        {
            for(int j = 0; j < this.height; j++)
            {
                field[i][j] = 0;
            }
        }
        field[x][y] = 1;
    }
    public void update()
    {
        if(direction.equals("UP")&&game_continue)
        {
            y--;
            foodcheck();
            
        }
        if(direction.equals("DOWN")&&game_continue)
        {
            y++;
            foodcheck();
        }
        if(direction.equals("LEFT")&&game_continue)
        {
            x--;
            foodcheck();
        }
        if(direction.equals("RIGHT")&&game_continue)
        {
            x++;
            foodcheck();
        }
        
        
    }
    public void fieldm()
    {
        for(int i = 0; i < this.width;i++)
        {
            for(int j = 0; j < this.height; j++)
            {
                if(!(field[i][j] == 0))
                {
                    field[i][j]--;
                }
            }
        }
    }
    public void foodcheck()
    {
        if(x>this.width-1)
        {
            x = 0;
        }
        if(x<0)
        {
            x = width - 1;
        }
        if(y>this.width-1)
        {
            y = 0;
        }
        if(y<0)
        {
            y = width - 1;
        }
        if(field[x][y]!=0)
        {
            game_continue = false;
        }
        if((x==xf)&&(y==yf))
            {
                snake_size++;
                field[x][y] = snake_size;
                newfood();
            }
            else
            {
                fieldm();
                field[x][y] = snake_size;
            }
        
    }
    public void newfood()
    {
        int x1 = r.nextInt(this.width);
        int y1 = r.nextInt(this.width);
        while(!(field[x1][y1]==0))
        {
            x1 = r.nextInt(this.width);
            y1 = r.nextInt(this.width);
        }
        xf = x1;
        yf = y1;
    }
}

