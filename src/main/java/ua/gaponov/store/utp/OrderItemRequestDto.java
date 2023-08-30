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
    private double productQty;
    private double productPrice;
    private double productSum;
    private double productQtyComplete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemRequestDto that = (OrderItemRequestDto) o;

        return productGuid.equals(that.productGuid);
    }

    @Override
    public int hashCode() {
        return productGuid.hashCode();
    }
}
