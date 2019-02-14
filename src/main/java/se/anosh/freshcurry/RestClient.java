 /**
  *
  * ITHS 2019 Rest client exercise
  *
  * Obtains currency exchange rates in JSON from server using
  * REST and stores them as a POJO (plain old java object)
  *
  * Uses: https://exchangeratesapi.io/
  *
  * Thanks to Madis Väin (EST) for the API :)
  *
  */

package se.anosh.freshcurry;

import se.anosh.freshcurry.domain.ExchangeRate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public class RestClient {
    
    private String url = "https://api.exchangeratesapi.io/latest";
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        RestClient client = new RestClient();
        client.run();
    }
    
    private void run() throws IOException, InterruptedException {
        
        System.out.println("Fresh Curry - REST-client for Java 11\nFOREX REST-client\n");
        menu(); // user IO
        
        URI uri = URI.create("https://api.exchangeratesapi.io/latest");
        
        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        
        HttpRequest mainRequest = HttpRequest.newBuilder()
				      .uri(uri).header("Accept", "application/json").GET().build();
        
        
            HttpResponse<String> mainResponse = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());
        
        if (mainResponse.statusCode() != 200) {
            System.out.println("Network error! Obtained code : " + mainResponse.statusCode());
            System.out.println("Exiting program");
            return; // exits program
        }
        
        String result = mainResponse.body();
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ExchangeRate valuta = gson.fromJson(result, ExchangeRate.class);
        
        System.out.println("Base: " + valuta.getBase());
        System.out.println("Date: " + valuta.getDate());
        
        Map<String,Double> map = new HashMap(valuta.getRates());
        for (String key : map.keySet()) {
            System.out.println(key + "\t" + map.get(key));
        }
        
    }
    
    private void menu() {
        
        try (Scanner sc = new Scanner(System.in)) {
            int input = 1;
            final int size = CurrencyCode.values().length; // if the enum is modified in the future
            System.out.println("List of available currencies:");
            // Prints the list
            for (CurrencyCode money : CurrencyCode.values()) {
                System.out.println(money.getCode() +  "\t" + money);
            }   do {
                System.out.print("\nPlease make your selection: ");
                input = sc.nextInt();
                
            } while (input > size || input < 1);
            /**
             * The REST-service uses € EUR as default base currency
             */
            if (input != 1) {
                url = url.concat("?base=" + CurrencyCode.get(input));
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Using default values");
        }
    }
    
    
}
