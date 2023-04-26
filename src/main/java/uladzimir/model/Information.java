package uladzimir.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Uladzimir Tarasavets
 * Created 25.04.2023.
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Information {
    private String name;
    private List<String> platforms = null;
    private String releaseDate;
    private String reviewSummaryResult;
    private String price;
}
