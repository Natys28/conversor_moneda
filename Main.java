public class Main {

    // Simulación de respuesta de la API
    public static String getExchangeRates(String apiKey) {
        return "{"
                + "\"conversion_rates\": {"
                + "\"USD\": 1.0,"
                + "\"EUR\": 0.85,"
                + "\"JPY\": 110.0"
                + "}"
                + "}";
    }

    // Función para analizar JSON y obtener la tasa de conversión
    public static double getConversionRate(String jsonResponse, String currency) {
        String key = "\"" + currency + "\":";
        int startIndex = jsonResponse.indexOf(key) + key.length();
        int endIndex = jsonResponse.indexOf(",", startIndex);

        if (endIndex == -1) { // Última clave en el JSON
            endIndex = jsonResponse.indexOf("}", startIndex);
        }

        return Double.parseDouble(jsonResponse.substring(startIndex, endIndex).trim());
    }

    public static void main(String[] args) {
        try {
            // Clave simulada (no se usa en esta versión)
            String apiKey = "SIMULADO";

            // Obtener datos simulados
            String exchangeRates = getExchangeRates(apiKey);

            // Configurar la conversión
            String fromCurrency = "USD"; // Moneda de origen
            String toCurrency = "EUR";  // Moneda de destino
            double amount = 100;        // Monto a convertir

            // Obtener las tasas
            double fromRate = getConversionRate(exchangeRates, fromCurrency);
            double toRate = getConversionRate(exchangeRates, toCurrency);

            // Realizar la conversión
            double convertedAmount = (amount / fromRate) * toRate;
            System.out.printf("%.2f %s son %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
