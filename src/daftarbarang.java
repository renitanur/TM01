import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class daftarbarang {
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
            resModel.setI_code(myJSONObject.getString("i_code"));
            resModel.setG_code(myJSONObject.getString("G_code"));
            resModel.setI_barcode(myJSONObject.getString("i_barcode"));
            resModel.setI_brands (myJSONObject.getString("i_brands"));
            resModel.setI_cogs(myJSONObject.getString("i_cogs"));
            resModel.setI_color(myJSONObject.getString("i_color"));
            resModel.setI_kdsell(myJSONObject.getString("i_kdsell"));
            resModel.setI_qty(myJSONObject.getString("i_qty"));
            resModel.setI_qtymin(myJSONObject.getString("i_qtymin"));
            resModel.setI_supp(myJSONObject.getString("i_supp"));
            resModel.setI_sell(myJSONObject.getString("i_sell"));
            resModel.setI_name(myJSONObject.getString("i_name"));
            resModel.setI_unit(myJSONObject.getString("i_unit"));
            resModel.setI_size(myJSONObject.getString("i_size"));
            resModel.setI_article(myJSONObject.getString("i_article"));
            resModel.setI_status(myJSONObject.getString("i_status"));
            resModel.setId(myJSONObject.getString("id"));
            Model.add(resModel);
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
        public Object getString(String i_code) {
            return null;
        }
    }
}
