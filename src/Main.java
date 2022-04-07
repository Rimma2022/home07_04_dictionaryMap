import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * Задание 2
     * Создать программу по работе со словарем. Например,англо-испанский или французско-немецкий, или любое
     * другое направление.
     * Программа должна:
     * ■ Обеспечивать начальный ввод данных для словаря.
     * ■ Позволять отобразить слово и его переводы.
     * ■ Позволять добавить, заменить, удалить переводы слова.
     * ■ Позволять добавить, заменить, удалить слово.
     *
     */
    public static HashMap<String, List<String>> dictionary = new HashMap<>();
    //    public static Map<String, Integer> statistic = new HashMap<>();
    public static ArrayList<Sort> statistic = new ArrayList<>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int count = 0;

    private static void init() {
        ArrayList<String> hello = new ArrayList<>();
        hello.addAll(Arrays.asList("привет", "добрый день", "здравствуйте"));
        dictionary.put("hello", hello);
        statistic.add(new Sort("hello", count));

        ArrayList<String> bye = new ArrayList<>();
        bye.addAll(Arrays.asList("пока", "до встречи"));
        dictionary.put("bye", bye);
        statistic.add(new Sort("bye", count));

        ArrayList<String> family = new ArrayList<>();
        family.addAll(Arrays.asList("семья"));
        dictionary.put("family", family);
        statistic.add(new Sort("family", count));

        ArrayList<String> husband = new ArrayList<>();
        husband.addAll(Arrays.asList("муж", "супруг"));
        dictionary.put("husband", husband);
        statistic.add(new Sort("husband", count));


        ArrayList<String> wife = new ArrayList<>();
        wife.addAll(Arrays.asList("жена", "супруга"));
        dictionary.put("wife", wife);
        statistic.add(new Sort("wife", count));

        ArrayList<String> daughter = new ArrayList<>();
        daughter.addAll(Arrays.asList("дочь"));
        dictionary.put("daughter", daughter);
        statistic.add(new Sort("daughter", count));

        ArrayList<String> son = new ArrayList<>();
        son.addAll(Arrays.asList("сын"));
        dictionary.put("son", son);
        statistic.add(new Sort("son", count));

    }

    private static void Translation() throws IOException {
        System.out.println("Введите слово (англ)");
        String userWord = reader.readLine();
        if (dictionary.containsKey(userWord.toLowerCase())) {
            System.out.println(userWord + " - " + dictionary.get(userWord.toLowerCase()));
            for (int i = 0; i < statistic.size(); i++) {
                if (statistic.get(i).getUserWord().equals(userWord)) {
                    int c = statistic.get(i).getCount();
                    c++;
                    statistic.set(i, new Sort(userWord,c));
                }
            }
            System.out.println(statistic);
        } else {
            System.out.println("Проверьте введеное слово");
        }
    }

    private static void addWord() throws IOException {
        System.out.println("Введите слово (англ)");
        String userWord = reader.readLine();
        System.out.println("Введите перевод");
        String userTranslation = reader.readLine();
        ArrayList<String> userWordList = new ArrayList<>();
        userWordList.add(userTranslation);
        dictionary.put(userWord, userWordList);
        statistic.add(new Sort(userWord, count));
        System.out.println(dictionary);
    }

    private static void removeWord() throws IOException {
        System.out.println("Какое слово удалить (англ)");
        String userWord = reader.readLine();
        if (dictionary.containsKey(userWord.toLowerCase())) {
            dictionary.remove(userWord);
            System.out.println("Слово успешно удалено");
            System.out.println(dictionary);
        } else {
            System.out.println("Такого слова нет в словаре");
        }
    }

    private static void replaceWord() throws IOException {
        System.out.println("Какое слово заменить (англ)");
        String userWord = reader.readLine();
        System.out.println("На какое слово заменить");
        String userWordReplay = reader.readLine();
        if (dictionary.containsKey(userWord.toLowerCase())) {
            dictionary.put(userWordReplay, dictionary.get(userWord));
            dictionary.remove(userWord);
            System.out.println("Замена произошла успешно");
            System.out.println(dictionary);
        } else {
            System.out.println("Такого слова нет в словаре");
        }
    }
    private static void addTranslation() throws IOException {
        System.out.println("К какому слову добавить перевод (англ)");
        String userWord = reader.readLine();
        if (dictionary.containsKey(userWord.toLowerCase())) {
            System.out.println("Введите перевод");
            String userTranslation = reader.readLine();
            dictionary.get(userWord).add(userTranslation);
            System.out.println(dictionary);
        } else {
            System.out.println("Такого слова нет в словаре");
        }
    }
    private static void removeTranslation() throws IOException {
        System.out.println("К какому слову удалить перевод (англ)");
        String userWord = reader.readLine();
        if (dictionary.containsKey(userWord.toLowerCase())) {
            System.out.println(userWord + " - " + dictionary.get(userWord.toLowerCase()));
            System.out.println("Введите порядковый номер элемента для удаления");
            int userChoise = Integer.parseInt(reader.readLine());
            if(dictionary.get(userWord).size() >= userChoise) {
                dictionary.get(userWord).remove(userChoise -1);
                System.out.println("Перевод успешно удален");
                System.out.println(userWord + " - " + dictionary.get(userWord));
            } else {
                System.out.println("Неверный порядковый номер");
            }
        } else {
            System.out.println("Такого слова нет в словаре");
        }
    }
    private static void replaceTranslation() throws IOException {
        System.out.println("К какому слову заменить перевод (англ)");
        String userWord = reader.readLine();
        if (dictionary.containsKey(userWord.toLowerCase())) {
            System.out.println(userWord + " - " + dictionary.get(userWord.toLowerCase()));
            System.out.println("Введите порядковый номер элемента для замены");
            int userChoise = Integer.parseInt(reader.readLine());
            System.out.println("Введите перевод");
            String userTranslation = reader.readLine();
            if(dictionary.get(userWord).size() >= userChoise) {
                dictionary.get(userWord).remove(userChoise -1);
                dictionary.get(userWord).add(userTranslation);
                System.out.println("Перевод успешно заменен");
                System.out.println(userWord + " - " + dictionary.get(userWord));
            } else {
                System.out.println("Неверный порядковый номер");
            }

        } else {
            System.out.println("Такого слова нет в словаре");
        }
    }
    private static void showStatisticMorePop(){
        Collections.sort(statistic, new Comparator<Sort>() {
            @Override
            public int compare(Sort o1, Sort o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(statistic.get(i));
        }

    }
    private static void showStatisticLessPop(){
        Collections.sort(statistic, new Comparator<Sort>() {
            @Override
            public int compare(Sort o1, Sort o2) {
                return o1.getCount() - o2.getCount();
            }
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(statistic.get(i));
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        Integer X;
        do {
            System.out.println("0. Выход;\n1. Перевод анг -  рус;\n2. Добавить слово;\n3. Удалить слово;\n4. Заменить слово");
            System.out.println("5. Добавить перевод;\n6. Удалить перевод\n7. Заменить перевод\n8. Показать 3 самых популярных слова\n9. Показать 3 наименее популярных слова");
            String x = reader.readLine();
            X = Integer.parseInt(x);
            switch (X) {
                case 1: {
                    Translation();
                    break;
                }
                case 2: {
                    addWord();
                    break;
                }
                case 3: {
                    removeWord();
                    break;
                }
                case 4: {
                    replaceWord();
                    break;
                }
                case 5: {
                    addTranslation();
                    break;
                }
                case 6: {
                    removeTranslation();
                    break;
                }
                case 7: {
                    replaceTranslation();
                    break;
                }
                case 8: {
                    showStatisticMorePop();
                    break;
                }
                case 9: {
                    showStatisticLessPop();
                    break;
                }
            }
        } while (X != 0);
    }
}
