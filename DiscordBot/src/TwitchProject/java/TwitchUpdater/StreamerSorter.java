package TwitchUpdater;

import java.util.ArrayList;
import java.util.Collections;

public class StreamerSorter {
    public ArrayList<Streamer> sort(ArrayList<Streamer> streamers){
        ArrayList<Streamer> playingMinecraft = new ArrayList<>();
        ArrayList<Streamer> losers =  new ArrayList<>(); //people not playing minecraft
        ArrayList<Streamer> complete = new ArrayList<>(); //Complete list of streamers

        for(Streamer a : streamers){
            if(a.getGame().equalsIgnoreCase("minecraft"))
                playingMinecraft.add(a);
            else
                losers.add(a);
        }

        playingMinecraft = sortByViewers(playingMinecraft);
        losers = sortByViewers(losers);

        complete = playingMinecraft;
        complete.addAll(losers);

        return complete;

    }

    private ArrayList<Streamer> sortByViewers(ArrayList<Streamer> streamers){
        Collections.sort(streamers);
        return streamers;
    }
}
