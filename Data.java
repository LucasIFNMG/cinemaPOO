public class Data
{
    private int month;
    private int day;
    private int year;

    // Constantes apresentam static final
    private static final int[] daysPerMonth =
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Construtor: confirma o valor adequado p/ o mês e dia dado o ano
    public Data(int day, int month, int year)
    {
        if(month <= 0 || month > 12)
            throw new IllegalArgumentException(
                "month (" + month + ") must be 1-12");
        
        if(day <= 0 ||
          (day > daysPerMonth[month] && !(month == 2 && day == 29)))
          throw new IllegalArgumentException("day (" + day +
            ") out-of-range for the specified month and year");
        
        // Verifique no ano bissexto se o mês é 2 e o dia é 29
        if(month == 2 && day == 29 && !(year % 400 == 0 ||
            (year % 4 == 0 && year % 100 != 0)))
           throw new IllegalArgumentException("day (" + day +
            ") out-of-range for the specified month and year");

        this.day = day;
        this.month = month;
        this.year = year;

        System.out.printf(
            "Date object constructor for date %s%n", this);
    }

    // retorna uma String no formato dia/mês/ano
    public String toString()
    {
        return String.format("%d/%d/%d", day, month, year);
    }

    public static void main(String[] args) {
        
    }
}