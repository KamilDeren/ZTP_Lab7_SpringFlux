package pl.kamilderen.ztplab7.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;

@Data
@Table("orders")
public class Order {
    @Id
    private Long id;
    private List<Long> bookIds;
    private String userId;
}
