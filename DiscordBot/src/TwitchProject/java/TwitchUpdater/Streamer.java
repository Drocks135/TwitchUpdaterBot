package TwitchUpdater;


public class Streamer implements Comparable<Streamer> {
   private String twitchName;
   private String game;
   private int viewers;

   public Streamer(String twitchName, String game, int viewers){
       this.twitchName = twitchName;
       this.game = game;
       this.viewers = viewers;
   }

   public Streamer(){

   }

   public String getTwitchName(){
       return this.twitchName;
   }

   public String getGame(){
       return this.game;
   }

   public int getViewers(){
       return this.viewers;
   }

   public void setTwitchName(String twitchName){
       this.twitchName = twitchName;
   }

   public void setGame(String game){
       this.game = game;
   }

   public void setViewers(int viewers){
       this.viewers = viewers;
   }

   @Override
   public String toString(){
       return "Streamer: " + twitchName + "\n"
               + "Game: " + game + "\n"
               + "Viewer count: " + (viewers);
   }

   @Override
   public int compareTo(Streamer other){
       return (this.getViewers() > other.getViewers() ? -1 :
               (this.getViewers() == other.getViewers() ? 0 : 1));
   }

}
