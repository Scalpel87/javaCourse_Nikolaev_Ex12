import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User("Никита", 74), new User("Стас", 84), new User("Гена", 95), new User("Turbo", 81), new User("Дюша Метелкин", 79));
        System.out.println("USB здесь. Здесь все:");
        list.forEach(System.out::println);
        System.out.println("\nПосле сортировки по возрастанию:");
        list.stream().sorted(Comparator.comparing(User::getName)).forEach(System.out::println);
        System.out.println("\nПосле сортировки по убыванию:");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("\nТолько весящие больше 80 кг:");
        list.stream().filter(User -> User.getWeight() > 80).forEach(System.out::println);
        System.out.println("\nПосле сортировки по возрастанию и только весящие больше 80 кг:");
        list.stream().sorted(Comparator.comparing(User::getName)).filter(User -> User.getWeight() > 80).forEach(System.out::println);
        System.out.println("\nПервый по алфавиту:");
        list.stream().min(Comparator.comparing(User::getName)).ifPresent(System.out::println);
        System.out.println("\nПоследний по алфавиту:");
        list.stream().max(Comparator.comparing(User::getName)).ifPresent(System.out::println);
        System.out.println("\nВсе ли звезды весят больше 70 кг?");
        System.out.println(list.stream().allMatch(User -> User.getWeight() > 70));
        System.out.println("\nЕсть ли звезда по имени Филипп?");
        System.out.println(list.stream().anyMatch(User -> User.getName().equals("Филипп")));
        System.out.println("\nНет ли звезды по имени Филипп?");
        System.out.println(list.stream().noneMatch(User -> User.getName().equals("Филипп")));
    }
}
