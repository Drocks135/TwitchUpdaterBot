package TwitchUpdater;

/*import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;*/


import java.util.ArrayList;

/*public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "Token Placeholder";
        builder.setToken(token);
        builder.addEventListeners(new Main());
        builder.build();
    }

    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println("We recieved a message form " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );

        if(event.getMessage().getContentRaw().equals("!ping")){
            event.getChannel().sendMessage("Pong!").queue();
        }
    }*/
public class Main {
    public static void main(String[] args) {
        String output;
        GetTwitchJson post = new GetTwitchJson();
        JsonParser buildStreamer = new JsonParser();
        StreamerSorter sort = new StreamerSorter();
        int streamerID[] = new int[5];
        streamerID[0] = 124604785;
        streamerID[1] = 20786541;
        streamerID[2] = 156567621;
        streamerID[3] = 29994704;
        streamerID[4] = 32776386;
        ArrayList<Streamer> streamers = new ArrayList<>();

        for(int i = 0; i < streamerID.length; i++){
            output = post.requestJson(Integer.toString(streamerID[i]));
            streamers.add(buildStreamer.parse(output));
        }

        streamers = sort.sort(streamers);
        for(Streamer a : streamers){
            System.out.println(a);
            System.out.println("");
        }
    }


}