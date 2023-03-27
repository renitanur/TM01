import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TM01 {
    private final String USER_AGENT = "Mozilla/5.0";

    public static URL buidURL(String urlQuery) {
        URL url = null;
        try {
            url = new URL(urlQuery.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("//A");
            boolean hasilInput = scanner.hasNext();
            if (hasilInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

        public static int jumlahbarang;

        public static void main(String[] args) throws IOException {
            ConnectUri koneksiaku = new ConnectUri();
            URL myAddres = koneksiaku.buidURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM ");
            String response = koneksiaku.getResponseFromHttpUrl(myAddres);
            System.out.println(response);

            assert response != null;
            JSONArray responseJSON = new JSONArray(response);
            ArrayList<Model> Model = new ArrayList<>();
            for (int i = 0; i < responseJSON.length(); i++) {
                Model resModel = new Model();
                JSONObject myJSONObject = responseJSON.getJSONObject(i);
            }
            System.out.println("Response");
            for (int index = 0; index < Model.size(); index++) {
                int hargabarang = Integer.parseInt(Model.get(index).getHargabarang());
                if (hargabarang <= 7000) {
                    jumlahbarang++;
                    System.out.println("namabarang : " + Model.get(index).getNamabarang());
                    System.out.println("hargabarang : " + Model.get(index).getHargabarang());
                    System.out.println("harga maksimal : " + Model.get(index).getHargamaksimal());
                    System.out.println("kodebarang : " + Model.get(index).getKodebarang());
                }

            }
        }

        private static class JSONArray {
            public JSONArray(String response) {
            }

            public JSONObject getJSONObject(int i) {
                return null;
            }


            public int length() {
                return length();
            }
        }

        private static class JSONObject {
        }
    }