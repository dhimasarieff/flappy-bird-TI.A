import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FlappyBird extends Actor
{
    private double g = 1;
    private int y = 200;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacross = false;
    private boolean hasaddscore = false;
    public FlappyBird(){
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }
    public void act()
    {
        // Jika tekan spasi, koordinat y akan berkurang dan terbang ke atas
        if(spacePressed()){
            g=-2;
        }
        g +=0.1;
        y += g;
        setLocation(getX(), (int)(y));
        if(isTouchpipe()){
            isalive = false;
        }
        if(isTouchpipe()){
            isalive = false;
        }
        if(!isalive){
            getWorld().addObject(new GameOver(), 300, 200);
            getWorld().removeObject(this);
        }
        if(!hasaddscore && isacross && isalive){
            Greenfoot.playSound("score.mp3");
            Score.add(1);
        }
        hasaddscore = isacross;
    }
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("Space")){
            if(!haspressed){
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            haspressed = true;
        }else{
            haspressed = false;
        }
        return pressed;
    }
    public boolean isTouchpipe(){
        isacross = false;
        for(Pipe pipe : getWorld().getObjects(Pipe.class)){
            if(Math.abs(pipe.getX() - getX()) < 69){
            if(Math.abs(pipe.getY() + 30 - getY()) > 37){
                Greenfoot.playSound("peng.mp3");
                isalive = false;
            }
            isacross = true;
        }
    }
    return !isalive;
}
}
