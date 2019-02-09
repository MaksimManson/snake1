/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author lordstorm
 */
public class Snake extends Application {
    Game g;
    int px = 10;
    int py = 10;
    int i = 35;
    long ticker = 0;
    int snake = 0;
    
    @Override
    public void start(Stage primaryStage) 
    {
        g = new Game(30,30);
        Canvas can  = new Canvas(300, 300);
        new AnimationTimer() 
        {
            @Override
            public void handle(long now) 
            {
                ticker++;
                
                if(ticker % i == 0)
                {
                    g.update();
                    GraphicsContext gc = can.getGraphicsContext2D();
                    for(int x = 0; x < g.width; x++)
                    {
                        for(int y = 0; y < g.height; y++)
                        {
                            if(g.field[x][y]==0)
                            {
                            gc.setFill(Color.BLACK);
                            gc.fillRect(x*px, y*px, px, py);
                            }
                            else
                            {
                            gc.setFill(Color.WHITE);
                            gc.fillRect(x*px, y*px, px, py);
                            }
                        }
                    }
                    gc.setFill(Color.GREEN);
                    gc.fillRect(g.xf*px, g.yf*px, px, py);
                    primaryStage.setTitle(String.valueOf(g.snake_size));
                    snake = g.snake_size;
                    switch(snake)
                    {
                        case 5: i = 30;
                        break;
                        case 10: i = 28;
                        break;
                        case 15: i = 26;
                        break;
                        case 20: i = 24;
                        break;
                        case 25: i = 22;
                        break;
                        case 30: i = 20;
                        break;
                        case 35: i = 18;
                        break;
                        case 40: i = 16;
                        break;
                        case 45: i = 15;
                        break;
                        case 50: i = 14;
                        break;
                        case 55: i = 13;
                        break;
                        case 60: i = 12;
                        break;
                        case 65: i = 11;
                        break;
                        case 70: i = 10;
                        break;
                        case 75: i = 9;
                        break;
                        case 80: i = 8;
                        break;
                        case 85: i = 7;
                        break;
                        case 90: i = 6;
                        break;
                        case 95: i = 5;
                        break;
                        case 100: i = 4;
                        break;
                    }
                }
               
               
                
            }
        }.start();
        StackPane root = new StackPane();
        
        root.getChildren().add(can);
        
        Scene scene = new Scene(root, 300, 300);
        scene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                   if(KeyCode.A == e.getCode())
                   {
                       if(g.direction=="RIGHT")
                       {
                       }
                       else
                       {
                       g.direction = "LEFT";
                       }
                       
                       e.consume();
                       
                   }
                   if(KeyCode.W == e.getCode())
                   {
                       if(g.direction=="DOWN")
                       {
                       }
                       else
                       {
                       g.direction = "UP";
                       }
                       e.consume();
                   }
                   if(KeyCode.S == e.getCode())
                   {
                       if(g.direction=="UP")
                       {
                       }
                       else
                       {
                       g.direction = "DOWN";
                       }
                       e.consume();
                   }
                   if(KeyCode.D == e.getCode())
                   {
                       if(g.direction=="LEFT")
                       {
                       }
                       else
                       {
                       g.direction = "RIGHT";
                       }
                       e.consume();
                   }
                   e.consume();
                   
                }
            });
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
