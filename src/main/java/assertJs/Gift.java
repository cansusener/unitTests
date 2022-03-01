package assertJs;

import lombok.*;

/*
@Getter
@Setter
@ToString
*/


//Constructor eklemek için ise AllArgsConstructor ve NoArgsConstructor annotation’larını kullanabilirsiniz.
//NoArgsConstructor sizin için default constructor eklerken,
// AllArgsConstructor ise parametre alacak bir biçimde constructor’unuzu ekleyecektir.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gift {

    public String name;
    public String surname;
    public String hello;
}
