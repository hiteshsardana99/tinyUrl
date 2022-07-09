package sardana.tinyUrl.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlData {

    @Id
    private String shortUrl;

    private String longUrl;

}
