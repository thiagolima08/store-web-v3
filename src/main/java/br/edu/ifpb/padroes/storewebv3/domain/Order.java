package br.edu.ifpb.padroes.storewebv3.domain;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Order {

    private Long id;

    private String strapaKey;

    private Date created;

    private boolean processed = false;

    private List<OrderItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrapaKey() {
        return strapaKey;
    }

    public void setStrapaKey(String strapaKey) {
        this.strapaKey = strapaKey;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
