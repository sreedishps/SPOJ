import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

/**
 * Created by sreps on 7/17/2016.
 */
public class MovieWatcher {
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        HashSet<String> alreadyAlerted = new HashSet<>();

        while (true) {
            try {
                System.out.println("Already alerted for : ");
                for (String alerted : alreadyAlerted){
                    System.out.println(alerted);
                }

                String test = "https://in.bookmyshow.com/buytickets/kabali-bengaluru/movie-bang-ET00039091-MT/20160722";
                String result = getHTML(test);
                HashSet<String> nowShowing = parseTheatres(result);
                for (String now : nowShowing) {
                    if (alreadyAlerted.contains(now)) {
                        continue;
                    }
                    System.out.println("New theatre found " + now);

                    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sreps\\Experiments\\SPOJ\\src\\recepients"));
                    try {
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();

                        while (line != null) {
                            sendMail(line,now , alreadyAlerted);
                            line = br.readLine();
                        }
                    } finally {
                        br.close();
                    }

                    alreadyAlerted.add(now);
                }

                java.util.Date date = new java.util.Date();
                System.out.println("Sleeping for 10 min " + date);

                sleep(1000 * 60 * 10);
            } catch (Exception e) {
                System.out.println("Exception suppressed " + e.toString());
            }
        }

    }

    private static void sendMail(String email, String now, HashSet<String> alreadyAlerted) {
        String arg[] = new String[10];
        arg[0] = email;
        arg[1] = "Kabali tickets are now open in " + now;
        String opened = new String();
        opened += "\n\n\nTheatres which already opened ";
        for(String theatre : alreadyAlerted){
            opened += "\n";
            opened += theatre;
        }

        opened += "\n\n\nPlease visit https://in.bookmyshow.com/buytickets/kabali-bengaluru/movie-bang-ET00039091-MT/20160722";
        arg[2] = opened;

        SendMail.send(arg);
    }

    private static HashSet<String> parseTheatres(String temp) {
        String theatres[] = temp.split("data-name=");
        HashSet<String> nowOpen = new HashSet<>();
        for (String temp2 : theatres) {
            if (!temp2.contains("data-sub-region")) {
                continue;
            }
            String theatre = temp2.split("data-sub-region")[0];
            nowOpen.add(theatre);
        }
        return nowOpen;
    }

}
;