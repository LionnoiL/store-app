package ua.gaponov.store.utp;

import lombok.Builder;
import lombok.Data;

/**
 * @author Andriy Gaponov
 */
@Data
@Builder
public class OrderItemRequestDto {

    private int lineNumber;
    private String productGuid;
    private String productCode;
    private String productName;
    private String productUnitName;
    private String productQty;
    private String productPrice;
    private String productSum;
    private String productQtyComplete;
}
