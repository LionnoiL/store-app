package ua.gaponov.store.utp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Andriy Gaponov
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUtpReturnDto {

    private String docGuid;
    private List<OrderItemUtpReturnDto> products;
}
