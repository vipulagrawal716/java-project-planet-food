
package planetfood.pojo;


public class OrderDetail {
    private String ordId;
    private String prodId;
    private Double quantity;
    private Double cost;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quatity) {
        this.quantity = quatity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
    
    
}
