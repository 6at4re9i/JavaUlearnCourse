import java.text.DecimalFormat;
import java.util.Random;
public class Hospital {

    /**
     * В классе Hospital прописаны все методы для работы с больницей
     * Генерация температур, подсчет средней температуры, подсчет здоровых пациентов
     * А так же настроен вывод отчета в getReport
     * Для корректной работы класса созданы две глобальные переменные
     * PatientsCount отвечает за размер массива пациентов и проверяется на корректность перед работой класса
     * Temperatures это основной рабочий массив случайных температур
     * Нам нужна глобальная переменная, в которую мы записываем этот массив, чтобы не создавать всегда новые*/

    private final int patientsCount;
    private float[]temperatures;

    public Hospital(int patientsCount){
        if (patientsCount <= 0){
            throw new IllegalArgumentException();
        }
        this.patientsCount = patientsCount;
    }
    public float[] generatePatientsTemperatures(){
        if (temperatures == null) {
            float[] temperatures = new float[patientsCount];
            Random random = new Random();
            for (int i = 0; i < temperatures.length; i++) {
                temperatures[i] = (random.nextFloat() * 8) + 32;
            }
            this.temperatures = temperatures;
        }
        return temperatures;

    }
    public int getCountHealthy(){
        if (temperatures == null){
            temperatures = generatePatientsTemperatures();
        }
        int countedHealthy = 0;
            for (float temperature : temperatures) {
                if (36.2 <= temperature && temperature <= 36.9) {
                    countedHealthy += 1;
                }
            }
        return countedHealthy;
    }
    public String getTemperaturesToString(){
        if (temperatures == null){
            temperatures = generatePatientsTemperatures();
        }
        double[] doubleTemp = new double[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            doubleTemp[i] = temperatures[i];
        }

        DecimalFormat df = new DecimalFormat("#.0");
        StringBuilder sb = new StringBuilder();
        for (float f : temperatures) {
            sb.append(df.format(f)).append(" ");
        }
        return sb.toString().trim();
    }
    public double getAverageTemp() {
        if (temperatures == null){
            temperatures = generatePatientsTemperatures();
        }
        double tempSum = 0;
        for (int i = 0; i<temperatures.length;i++){
            tempSum += temperatures[i];
        }
        return tempSum / temperatures.length;
    }
    public String getReport(){
        if (temperatures == null){
            temperatures = generatePatientsTemperatures();
        }

        double averageTemp = getAverageTemp();
        String resultString = getTemperaturesToString();
        int countedHealthy = getCountHealthy();

        String formattedAvgTemp = String.format("%.2f", averageTemp);
        return "Температуры пациентов: " + resultString + "\n" +
                "Средняя температура: " + formattedAvgTemp + "\n" +
                "Количество здоровых: " + countedHealthy;
    }
}