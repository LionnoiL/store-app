package ua.gaponov.store.utp;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Andriy Gaponov
 */
@Data
@Builder
public class OrderRequestDto {

    private String docGuid;
    private String docNumber;
    private String docDate;
    private String docAgent;
    private String docClient;
    private String docPointName;
    private String docPointAddress;
    private String docTotalSum;
    private String docComment;
    private List<OrderItemRequestDto> products;
}
