package co.com.accenture.model.franchise;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Franchise {

    private String id;
    private String name;

    @Override
    public String toString() {
        return "Franchise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
