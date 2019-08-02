package TwitchUpdater;

import java.util.ArrayList;

public class JsonParser {
    /******************************************************************
     * @param jsonString containing a streamers info
     * @return A streamer object which contains a streamers view count,
     * twitch name, and there current game
     *****************************************************************/
    public Streamer parse(String jsonString){
        String twitchName = null;
        String game = null;
        int viewers = 0;

        ArrayList<String> twitchInfo = new ArrayList();

        String[] streamerInfoJson = jsonString.split(",");

        for(String s : streamerInfoJson)
            twitchInfo.add(s);

        for(String s : twitchInfo){
            if (s.toString().contains("display_name")){
                String[] tempStringArray = s.toString().split(":");
                twitchName = removeQuotations(tempStringArray[1]);
            }
            else if (s.toString().contains("game")) {
               String[] tempStringArray = s.toString().split(":");
               game = removeQuotations(tempStringArray[1]);
           } else if(s.toString().contains("viewers")){
                String[] tempStringArray = s.toString().split(":");
                viewers = Integer.parseInt(tempStringArray[1]);
           }
        }

        Streamer twitchStreamer = new Streamer(twitchName, game, viewers);

        return twitchStreamer;
    }

    private String removeQuotations(String s){
        StringBuffer str = new StringBuffer(s);
        str = str.deleteCharAt(0);
        str = str.deleteCharAt(str.length() - 1);

        return str.toString();
    }

}
