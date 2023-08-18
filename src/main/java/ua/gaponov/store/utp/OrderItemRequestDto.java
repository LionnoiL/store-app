package ua.gaponov.store.utp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andriy Gaponov
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequestDto {

    private int lineNumber;
    private String productGuid;
    private String productCode;
    private String productName;
    private String productUnitName;
    private String productQty;
    private String productPrice;
    private String productSum;
    private double productQtyComplete;
}
