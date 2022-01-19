package gr.pricefox.experimenting.reflection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private int pass;
    private Person mother;
    private Person father;

    public void showMessage() {
        System.out.println("Hello");
    }
}
