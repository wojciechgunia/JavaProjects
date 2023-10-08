package com.example.order.entity.notify;

import com.example.order.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
    private String orderId;
    private String extOrderId;
    private String orderCreateDate;
    private String notifyUrl;
    private String customerIp;
    private String merchantPostId;
    private String description;
    private String totalAmount;
    private Buyer buyer;
    private PayMethod payMethod;
    private List<Product> products;
    private Status status;

}
