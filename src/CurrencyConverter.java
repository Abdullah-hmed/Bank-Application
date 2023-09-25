
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrencyConverter {
    public double Pkr(double bal){
        return bal;
    }
    public double PkrtoUsd(double bal){
        double pkrBal;
        
        double price = returnPkr("usd");
        
        pkrBal = bal/price;
        return pkrBal;
    }
    public double PkrtoPound(double bal){
        double poundBal;
        
        double price = returnPkr("gbp");
        
        poundBal = bal/price;
        return poundBal;
    }
    public double PkrtoEuro(double bal){
        double euroBal;
        
        double price = returnPkr("eur");
        
        euroBal = bal/price;
        return euroBal;
    }
    public double PkrtoYen(double bal){
        double yenBal;
        
        double price = returnPkr("jpy");
        
        yenBal = bal/price;
        return yenBal;
    }
    public double PkrtoRinggitt(double bal){
        double ringgitBal;
        
        double price = returnPkr("myr");
        
        ringgitBal = bal/price;
        return ringgitBal;
    }
    
    //Using API to get the currency rates
    public static String sendGetRequest(String currency) throws Exception {
        URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/"+currency+"/pkr.json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read the response from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } else {
            throw new Exception("API Request Failed with response code: " + responseCode);
        }
    }
    
    //extracting pkr value from API response
    public static double returnPkr(String currency){
        double price = 0;
        try {
            
            
            String response = sendGetRequest(currency);
            
            JsonObject json = JsonParser.parseString(response).getAsJsonObject();
            
            double pkr = json.get("pkr").getAsDouble();
            
            price = json.get("pkr").getAsDouble();
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(CurrencyConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
}
