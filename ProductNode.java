public class ProductNode {
    private Product product;
    private ProductNode next;
    private ProductNode previous;

    public ProductNode() {
    }

    public ProductNode(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductNode getNext() {
        return next;
    }

    public void setNext(ProductNode next) {
        this.next = next;
    }

    public ProductNode getPrevious() {
        return previous;
    }

    public void setPrevious(ProductNode previous) {
        this.previous = previous;
    }
}
