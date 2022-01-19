package gr.pricefox.experimenting.reflection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Person {

    private String name;
    private int age;

    public void showMessage() {
        System.out.println("Hello");
    }
}
