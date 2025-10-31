import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TesteFXProperties {

    public static void main(String[] args) {
        System.out.println("Inicio do Programa");

        StringProperty nome = new SimpleStringProperty("João");

        nome.addListener(
            (obs, antigo, novo) -> System.out.println("Nome alterado de '" + 
            antigo + "' para '" + novo + "'")
        );

        nome.set("Maria");
        nome.set("Jose");
        nome.set("Alberto");

        System.out.println("Fim do Programa");
    }
    
}
