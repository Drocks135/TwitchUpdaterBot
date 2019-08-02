package TwitchUpdater;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;



public class GetTwitchJson {
    /******************************************************************
     * @param channelID The channel id of the twitch channel you want
     *                  the information of
     * @return  A String containing the contents of a twitch stream
     *****************************************************************/
    public String requestJson(String channelID){
        URL url;
        HttpURLConnection connection = null;
        String readLine;
        String output = null;

        try{
            //create connection
            url = new URL(("https://api.twitch.tv/kraken/streams/" + channelID));

            connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("GET");

            connection.setRequestProperty("Client-ID",

                    "oynszml066roh5pc581h79wxpe6az2");

            int responseCode = connection.getResponseCode();

            //Writes the input stream into a buffered string
           if (responseCode == HttpURLConnection.HTTP_OK) {
               BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
               StringBuffer response = new StringBuffer();
               while ((readLine = in.readLine()) != null) {
                   response.append(readLine);
               }
               //convert the buffered string into a string
               output = response.toString();
               in.close();
           } else {
               System.out.println("Failed");
           }



        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return output;
    }


}

