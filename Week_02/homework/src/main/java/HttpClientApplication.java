public class HttpClientApplication {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        try {
            client.doGetTestOne();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
