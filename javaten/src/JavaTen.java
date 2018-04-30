import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaTen {
    static class User {
        String firstName;
        String lastName;
        int age;

        User(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Elisabeth", "Bennett", 20),
                new User("Jane", "Bennett", 22),
                new User("Mary", "Bennett", 18),
                new User("Kitty", "Bennett", 17),
                new User("Lydia", "Bennett", 15)
        );
        final var objects = users.stream()
                .map(u ->
                        new Object() {
                            String fullName = u.firstName + " " + u.lastName;
                            boolean canDrink = u.age >= 18;
                        })
                .collect(Collectors.toUnmodifiableList());

        // do something with the users...

        System.out.println();
        for (var o : objects) {
            if (o.canDrink) {
                System.out.println("+ " + o.fullName + " is of age and can drink");
            } else {
                System.out.println("- " + o.fullName + " is not of age and cannot drink");
            }
        }
    }

    private void output(List<Object> ls) {

    }
}
