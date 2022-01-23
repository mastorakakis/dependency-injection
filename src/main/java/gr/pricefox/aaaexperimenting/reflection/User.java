package gr.pricefox.aaaexperimenting.reflection;

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
public class User implements Creature {

    private int pass;
    private Person mother;
    private Person father;

    public void showMessage() {
        System.out.println("Hello");
    }
}
