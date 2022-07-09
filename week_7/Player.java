public class Player {
    protected String playlist;

    Player(){

    }

    Player(String playlist){
        this.playlist = playlist;
    }

    public void start(){
        System.out.println("Start");
    }
    
    public void pause(){
        System.out.println("Pause");
    }
    
    public void stop(){
        System.out.println("Stop");
    }

    public static void main(String[] args) {
        MusicPlayer mp = new MusicPlayer();
        mp.start();
        mp.pause();
        mp.stop();    
        System.out.println(mp.playlist);
        MusicPlayer mp2 = new MusicPlayer("Your playlist");
    }
}


class MusicPlayer extends Player{
    MusicPlayer(){
        super("");
    }

    MusicPlayer(String playlist){
        super(playlist);
    }

    public void start(){
        System.out.println("Playing advertisement now.........");
    }
}