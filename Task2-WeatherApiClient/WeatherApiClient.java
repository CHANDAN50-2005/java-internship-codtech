import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherApiClient {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=12.97&longitude=77.59&current_weather=true";

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
                );
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON
                JSONObject json = new JSONObject(response.toString());
                JSONObject current = json.getJSONObject("current_weather");

                System.out.println("📍 Location: Bangalore");
                System.out.println("🌡 Temperature: " + current.getDouble("temperature") + "°C");
                System.out.println("💨 Wind Speed: " + current.getDouble("windspeed") + " km/h");
                System.out.println("🕒 Time: " + current.getString("time"));

            } else {
                System.out.println("❌ Error: HTTP code " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
