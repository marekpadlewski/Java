public class IntegerToWord {

    private static String jednosci[] = {"", "jeden ", "dwa ", "trzy ", "cztery ", "pięć ", "sześć ", "siedem ", "osiem ", "dziewięć "};
    private static String nastki[] = {"dziesięć ", "jedenaście ", "dwanaście ", "trzynaście ", "czternaście ", "piętnaście ", "szesnaście ",
                                    "siedemnaście ", "osiemnaście ", "dziewiętnaście "};
    private static String dziesiatki[] ={"", "dziesieć ", "dwadzieścia ", "trzydzieści ", "czterdzieści ", "pięćdziesiąt ", "sześćdziesiąt ",
                                    "siedemdziesiąt ", "osiemdziesiąt ", "dziewiecdziesiąt "};
    private static String setki[] = {"", "sto ", "dwiescie ", "trzysta ", "czterysta ", "pięćset ", "sześćset ", "siedemset ", "osiemset ", "dziewięćset "};
    private static String przedrostki[][] = {{"", "", "",}, {"tysiąc ", "tysiące ", "tysięcy "}, {"milion ", "miliony ", "milionów "},
                                            {"miliard ", "miliardy ", "miliardów "}};


    public static void main(String[] args){

        int number, lastDigit, row, k, n;
        boolean negative = false;
        StringBuilder word;

        for (String arg : args) {

            row = 0;
            k = 0;
            word = new StringBuilder();

            try {
                number = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                System.err.println("Input is not integer!");
                continue;
            }


            if (number == -2147483648) {
                word.insert(0, "osiem");
                number /= 10;
                k = 1;
            }

            if (number < 0) {
                negative = true;
                number = -number;
            }


            if (number == 0)
                word = new StringBuilder("zero");

            while (number > 0) {

                lastDigit = number % 10;
                number /= 10;

                if (k == 0 && (number % 100 != 0 || lastDigit != 0)) {

                    if (number % 10 != 1) {
                        if (lastDigit == 1) n = 0;
                        else if (lastDigit > 1 && lastDigit < 5) n = 1;
                        else n = 2;
                    } else
                        n = 2;


                    word.insert(0, przedrostki[row][n]);
                }

                if (k == 0 && number % 10 != 1) word.insert(0, jednosci[lastDigit]);

                if (k == 0 && number % 10 == 1) {
                    word.insert(0, nastki[lastDigit]);
                    number /= 10;
                    k += 2;
                    continue;
                }

                if (k == 1) word.insert(0, dziesiatki[lastDigit]);

                if (k == 2) {
                    word.insert(0, setki[lastDigit]);
                    k = -1;
                    row++;
                }

                k++;
            }

            if (negative) word.insert(0, "minus ");

            System.out.println(word);
        }
        }
}
