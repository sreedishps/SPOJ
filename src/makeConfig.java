import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sreps on 8/22/2016.
 */
public class makeConfig {
    public static void main(String[] args) {
        BufferedReader br = null;
        HashMap<String, String> hmap = new HashMap<>();

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("D:\\gitRepo\\7\\network-quality\\private\\Features\\EditorialMT\\MTv6\\PowershellConfigDeployment\\prod.BY2.xml"));
            while ((sCurrentLine = br.readLine()) != null) {
                if(sCurrentLine.contains("<Replace")){
                    String key = sCurrentLine.split("name=\"")[1].split("\"")[0];
                    String value = sCurrentLine.split("CustomValue=\"")[1].split("\"")[0];
                //    System.out.println(key+"    "+value);
                    hmap.put(key,value);
                }
            }

            hmap.put("ENVIRONMENT_NAME", "ADCAPPEDTSVCLDC2-Prod-BAY" );

            System.out.println("<!-- Config Settings for AP-Env : " + hmap.get("ENVIRONMENT_NAME") +" -->");
            // <?ap-config target="add[@key='SpamCheckStoreConnStr']/@value" value="DefaultEndpointsProtocol=https;AccountName=spamcheckstoresi;AccountKey=5+cTyzMYK9Y91sGS42wAksvf49fEtDMkKMwy2TykYIw4hu9qQP32V2ctrR3KLFdN4ZHuBWp2nAgDtmcFeeuK1Q==" when="@environment='OneBox'" ?>
            for(Map.Entry<String, String> temp : hmap.entrySet()){
                System.out.println("  <?ap-config target=\"add[@key='" + temp.getKey()+ "']/@value\" value=\"" +temp.getValue() +"\" when=\"@environment='" + hmap.get("ENVIRONMENT_NAME")+ "'\" ?>" );
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
