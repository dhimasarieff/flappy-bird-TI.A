import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pipe extends Actor
{
    public Pipe(){
        GreenfootImage image = getImage();
        image.scale(500, 900);
    }
    public void act()
    {
        setLocation(getX() -1, getY());
        if(getX() <= 1){
            setLocation(getX() + 600, Greenfoot.getRandomNumber(250)+50);
    }
}
}
